package com.lunz.cpfw.web.controllers;

import java.util.concurrent.Future;

import com.lunz.cpfw.web.services.LogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.lunz.cpfw.core.service.WebApiResult;

@RestController
@Api(tags = "Log")
public class LogController extends BaseV1Controller {
    @Autowired
    LogService logService;

    @GetMapping("Log/getLogs/{id}")
    @ApiOperation("获取日志")
    public WebApiResult getLogs(@PathVariable String id) throws Exception {
        Future<WebApiResult> result = logService.getLogsByDataIdAsync(id);
        return result.get();
    }

    @GetMapping("Log/getModuleLogs/{type}")
    @ApiOperation("获取模块日志")
    public WebApiResult getModuleLogs(@PathVariable Short type) throws Exception {
        Future<WebApiResult> result = logService.getLogsByBusinessTypeAsync(type);
        return result.get();
    }
}