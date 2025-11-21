package com.multimediaupload.Service.Controllers;


import com.multimediaupload.Service.ApiResponseBody.APIResponseBody;
import com.multimediaupload.Service.Service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    UploadService uploadService;

    @PostMapping("/video")
    public ResponseEntity<APIResponseBody> uploadVideo(@RequestParam("file")MultipartFile file){
        try{
            APIResponseBody responseBody = uploadService.uploadVideo(file);
            return new ResponseEntity<>(responseBody, responseBody.getHttpStatus());
        } catch (Exception e) {
            throw new RuntimeException(e);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

}
