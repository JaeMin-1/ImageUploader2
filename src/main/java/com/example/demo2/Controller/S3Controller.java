package com.example.demo2.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class S3Controller {
    private final S3Uploader s3Uploader;

    @GetMapping("/")
    public String index() {
        return "result";
    }

    @PostMapping("/upload")
    @ResponseBody
    public List<String> upload(@RequestParam("data") MultipartFile[] multipartFiles) throws IOException {
        return s3Uploader.upload(multipartFiles, "image");
    }
}
