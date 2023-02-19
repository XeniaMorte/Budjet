package com.example.budjet.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

@Service
public class FileService<T> {
    public T readFromFile(String path, TypeReference<T> type) throws IOException {
        System.out.print(">>>>>>>>>>>");
        File file = new File(path);
        System.out.println(file.getAbsolutePath());
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(file, type);

    }

    public void saveFile(T payload, String path) {
        try {

            ObjectMapper objectMapper = new ObjectMapper();
            String stringOfRec = objectMapper.writeValueAsString(payload);
            Files.writeString(Path.of(path), stringOfRec, StandardOpenOption.CREATE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public File getDataFile(String path) {
        return new File(path);
    }

    public boolean cleanDataFile(String path) {
        try {
            Path filePath = Path.of(path);
            Files.deleteIfExists(filePath);
            Files.createFile(filePath);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    public Path createTempleFile(String path) {
        try {
            return Files.createTempFile(path,"tempFile");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}


