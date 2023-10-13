package com.lou.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@Controller
public class UploadController {
    @Value("${upload.path}")
    private String FILE_UPLOAD_PATH;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) return "Upload Failed";

        // get name and suffix
        String fileName = file.getOriginalFilename();
        assert fileName != null;
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        // normal generate file name method: date + random + suffix
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
        Random r = new Random();
        String newFileName = sdf.format(new Date()) + r.nextInt(100) + suffixName;
        System.out.println(newFileName);
        try {
            // store file
            byte[] bytes = file.getBytes();
            // get path
            Path path = Paths.get(FILE_UPLOAD_PATH + newFileName);
            System.out.println(path);
            // write back
            Files.write(path, bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Upload successful, file address: /files/" + newFileName;
    }
}
