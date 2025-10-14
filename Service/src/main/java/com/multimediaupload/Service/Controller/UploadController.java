package com.multimediaupload.Service.Controller;


import com.multimediaupload.Service.ApiResponseBody.ResponseBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/upload")
public class UploadController {

    @PostMapping("/image")
    public ResponseEntity<ResponseBody> uploadImage(@RequestBody MultipartFile file){
        return null;
    }


    @PostMapping("/video")
    public ResponseEntity<ResponseBody> uploadVideo(@RequestBody MultipartFile file){
        return null;
    }


    @PostMapping("/file")
    public ResponseEntity<ResponseBody> uploadFile(@RequestBody MultipartFile file){
        return null;
    }

}
