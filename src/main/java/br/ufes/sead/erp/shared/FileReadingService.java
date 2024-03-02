package br.ufes.sead.erp.shared;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

@Service
public class FileReadingService {

    @Autowired
    ResourceLoader resourceLoader;

    public String readFileAsString(String filePath) {
        try {
            Resource resource = resourceLoader.getResource("classpath:" + filePath);

            return new String(resource.getInputStream().readAllBytes());
        } catch (Exception e) {
            return "Error reading file: " + e.getMessage();
        }
    }
}
