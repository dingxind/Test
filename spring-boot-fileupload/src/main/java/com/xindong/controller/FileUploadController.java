package com.xindong.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class FileUploadController {

    @RequestMapping("/fileUploadController")
    public Map<String,Object> fileUpload(MultipartFile multipartFile) throws IOException {
        System.out.println(multipartFile.getOriginalFilename());
        multipartFile.transferTo(new File("e:/"+multipartFile.getOriginalFilename()));
        HashMap<String, Object> map = new HashMap<>();
        map.put("msg","ok");
        return map;

    }

}
