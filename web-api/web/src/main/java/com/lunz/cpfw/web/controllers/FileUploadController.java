package com.lunz.cpfw.web.controllers;

import java.util.concurrent.Future;

import javax.servlet.http.HttpServletRequest;

import com.lunz.cpfw.core.service.WebApiResult;
import com.lunz.cpfw.web.interfaces.IFileUploadService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "FileUpload")
public class FileUploadController extends BaseV1Controller {

    @Autowired
    IFileUploadService fileUploadOssService;

    @PostMapping("FileUpload/FileUploadOss")
    @ResponseBody
    @ApiOperation("上传阿里云oss")
    public WebApiResult upload(HttpServletRequest request) throws Exception {
        Future<WebApiResult> result = fileUploadOssService.fileUploadOss(request);
        return result.get();
    }
}