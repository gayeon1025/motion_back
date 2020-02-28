package com.cnu.motion.common.file;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/files")
public class FileManagementController {

    @Value("${file.upload.path}")
    String uploadPath;

    @PostMapping
    public List<String> upload(@RequestParam("file") MultipartFile[] files) {
        log.debug("Start upload {} file(s)", files.length);
        List<String> uploadedFiles = new ArrayList<>();

        for(MultipartFile file : files) {
            File newFile = new File(uploadPath + UUID.randomUUID().toString());
            try {
                FileUtils.copyInputStreamToFile(file.getInputStream(), newFile);
            } catch (IOException e) {
                log.error("Error while copying.", e);
                e.printStackTrace();
            }
            uploadedFiles.add(newFile.getAbsolutePath());
            log.debug("Success to upload {}", newFile.getName());
        }

        log.debug("Uploading is complete");
        return uploadedFiles;
    }

}
