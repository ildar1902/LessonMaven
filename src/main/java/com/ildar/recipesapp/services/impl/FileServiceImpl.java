package com.ildar.recipesapp.services.impl;

import com.ildar.recipesapp.services.FileService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service

public class FileServiceImpl implements FileService {

    @Override
    public void saveToFile(String path, String json) {
        try {
            cleanFile(path);
            Files.writeString(Path.of(path), json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String readFromFile(String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void cleanFile(String filePath) {
        try {
            Path path = Path.of(filePath);
            Files.deleteIfExists(path);
            Files.createFile(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
