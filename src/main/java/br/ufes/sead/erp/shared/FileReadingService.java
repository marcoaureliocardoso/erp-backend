package br.ufes.sead.erp.shared;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

@Service
public class FileReadingService {

    private final ResourceLoader resourceLoader;

    public FileReadingService(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public String readFileAsString(String filePath) {
        try {
            Resource resource = resourceLoader.getResource("classpath:" + filePath);

            return new String(resource.getInputStream().readAllBytes());
        } catch (Exception e) {
            return "Error reading file: " + e.getMessage();
        }
    }
}
