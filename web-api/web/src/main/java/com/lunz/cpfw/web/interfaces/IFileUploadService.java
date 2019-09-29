package com.lunz.cpfw.web.interfaces;

import java.util.concurrent.Future;

import javax.servlet.http.HttpServletRequest;

import com.lunz.cpfw.core.service.WebApiResult;

public interface IFileUploadService {
    Future<WebApiResult> fileUploadOss(HttpServletRequest request);
}