package com.it.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author wangchao
 * @date 2019/09/12 15:00
 */
@Controller
public class UploadController {


    @RequestMapping("uploadPre")
    public String uploadPre() {
        return "uploadPre";
    }

    @RequestMapping("uploadPres")
    public String uploadPres() {
        return "uploadPres";
    }

    /**
     * 默认最大10M
     */
    @ResponseBody
    @PostMapping("upload")
    public String upload(String name, @RequestParam("file") MultipartFile multipartFile){
        if(multipartFile != null){
            System.out.println("name:"+ name);
            System.out.println("filename:" + multipartFile.getOriginalFilename());
            System.out.println("content-type:" + multipartFile.getContentType());
            System.out.println("file size:" + multipartFile.getSize());
        }
        return "success";
    }


}
