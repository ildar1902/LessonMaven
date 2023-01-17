package com.ildar.recipesapp.services;

import java.io.File;

public interface FileService {

    void saveToFile(String path, String json);

    String readFromFile(String path);

    File getDataFile(String filePath);

    void cleanFile(String path);
}
