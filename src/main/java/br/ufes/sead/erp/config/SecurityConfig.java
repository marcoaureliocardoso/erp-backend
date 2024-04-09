package br.ufes.sead.erp.config;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CorsConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        Customizer<CorsConfigurer<HttpSecurity>> customizer = cors -> cors
                .configurationSource(corsConfigurationSource());

        http.cors(customizer)
                .csrf(csrf -> csrf.disable())
                .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(req -> {
                    req.requestMatchers(HttpMethod.GET, "/api/v1/financial/fest/*").hasAnyRole("fest-user", "admin");
                    req.requestMatchers(HttpMethod.POST, "/api/v1/financial/fest/*").hasAnyRole("fest-user", "admin");
                    req.requestMatchers(HttpMethod.PUT, "/api/v1/financial/fest/*").hasAnyRole("fest-user", "admin");
                    req.requestMatchers(HttpMethod.DELETE, "/api/v1/financial/fest/*").hasRole("admin");
                    req.anyRequest().authenticated();
                })
                // .httpBasic(Customizer.withDefaults());
                .oauth2ResourceServer(oauth2Configurer -> oauth2Configurer
                        .jwt(jwtConfigurer -> jwtConfigurer.jwtAuthenticationConverter(jwt -> {
                            // Extract 'resource_access' claim safely
                            Map<String, Object> resourceAccessMap = jwt.getClaim("resource_access");
                            // System.out.println("##### resourceAccessMap: #####\n" + resourceAccessMap);

                            // Extract roles specifically for 'erp-sead'
                            Collection<String> erpRoles = Optional.ofNullable(resourceAccessMap)
                                    .map(ra -> (Map<String, Collection<String>>) ra.get("erp-sead"))
                                    .map(rf -> rf.get("roles"))
                                    .orElse(Collections.emptyList());
                            // System.out.println("##### erpRoles: #####\n" + erpRoles);

                            // Convert 'erp-sead' roles into Spring Security GrantedAuthorities
                            Collection<GrantedAuthority> grantedAuthorities = erpRoles.stream()
                                    .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
                                    .collect(Collectors.toList());
                            // System.out.println("##### grantedAuthorities: #####\n" + grantedAuthorities);

                            // Return the authentication token with granted authorities based only on
                            // 'erp-sead' roles
                            return new JwtAuthenticationToken(jwt, grantedAuthorities);
                        })));

        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(
                Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT"));
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Cache-Control", "Content-Type"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
