package com.lunz.cpfw.web.interfaces;

import java.util.concurrent.Future;

import com.lunz.cpfw.web.entities.helloworld;

import com.baomidou.mybatisplus.service.IService;
import com.lunz.cpfw.core.interaction.PagingOptions;
import com.lunz.cpfw.core.service.WebApiResult;

public interface IHelloWorldService extends IService<helloworld> {
    Future<helloworld> getHelloWorld1Async(String name);
    WebApiResult getHelloWorld2(String name);
    Future<WebApiResult> queryPagingResult(PagingOptions pagingOptions);
}