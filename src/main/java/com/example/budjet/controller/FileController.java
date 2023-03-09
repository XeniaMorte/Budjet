package com.example.budjet.controller;

import com.example.budjet.service.FileService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.*;

@RestController
@RequestMapping("/files")

public class FileController {
    @Value("${settings.ing.file.path}")
    private String ingPath;
    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping(value = "/export")
    public ResponseEntity<InputStreamResource> dowloadDataFile() throws FileNotFoundException {
        File file = fileService.getDataFile(ingPath);
        if (file.exists()) {
            InputStreamResource inputStreamResource = new InputStreamResource(new FileInputStream(file));
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .contentLength(file.length())
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=\"TransactionsLog.json\"")
                    .body(inputStreamResource);

        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "/import",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> apploadDataFile(@RequestParam MultipartFile multipartFile) {
        fileService.cleanDataFile(ingPath);
        File datafile = fileService.getDataFile(ingPath);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(datafile);
            IOUtils.copy(multipartFile.getInputStream(), fileOutputStream);
            return ResponseEntity.ok().build();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();


    }
}

