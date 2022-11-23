package com.sunglowsys.service.impl;

import com.sunglowsys.service.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class FileServiveImpl implements FileService {

    @Override
    public String uploadImage(String path, MultipartFile file) throws IOException {

        // FileName
        String name = file.getOriginalFilename();

        //fullpath
        String filePath = path +File.separator+name;

        //crate image
        File file1 = new  File(path);
        if (!file1.exists()){
            file1.mkdir();
        }

        // filecopy
        Files.copy(file.getInputStream(), Paths.get(filePath));
        return name;

    }
}
