package com.example.budjet.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

@Service
public class FileService<T> {
    public List<T> readFromFile(String path) throws IOException {
        File file = new File(path);
        ObjectMapper objectMapper = new ObjectMapper();
        List<T> resoult = objectMapper.readValue(file, List.class);
        return resoult;
    }

    public void saveFile(List<T> payload, String path) {
        try {

            ObjectMapper objectMapper = new ObjectMapper();
            String stringOfRec = objectMapper.writeValueAsString(payload);
            Files.writeString(Path.of(path), stringOfRec, StandardOpenOption.CREATE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


