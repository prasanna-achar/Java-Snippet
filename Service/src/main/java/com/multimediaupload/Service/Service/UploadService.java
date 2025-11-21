package com.multimediaupload.Service.Service;


import com.multimediaupload.Service.ApiResponseBody.APIResponseBody;
import com.multimediaupload.Service.ApiResponseBody.ApiSuccessResponse;
import com.multimediaupload.Service.Consumers.VideoProcessingConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class UploadService {

    @Autowired
    VideoProcessingConsumer videoProcessingConsumer;

    private static final String UPLOAD_DIR = "uploads";

    public APIResponseBody uploadVideo(MultipartFile file) throws IOException {
        File dir = new File(UPLOAD_DIR +"/videos");

        if(!dir.exists()) dir.mkdirs();

        String originalFileName = file.getOriginalFilename();
        String extension = "";

        if (originalFileName != null && originalFileName.contains(".")) {
            extension = originalFileName.substring(originalFileName.lastIndexOf("."));
        }

        // Use only current timestamp as filename
        String fileName = System.currentTimeMillis() + extension;
        Path filePath = Paths.get(dir.getAbsolutePath(),fileName);
        Files.write(filePath, file.getBytes());
        new Thread(() -> {
            try {
                videoProcessingConsumer.transcodeVideo(filePath.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        return new ApiSuccessResponse<>("", null);
    }
}
