package com.ildar.recipesapp.services;

public interface FileService {

    void saveToFile(String path, String json);

    String readFromFile(String path);

    void cleanFile(String path);
}
