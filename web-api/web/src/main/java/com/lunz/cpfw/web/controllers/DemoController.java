package com.lunz.cpfw.web.controllers;

import java.util.concurrent.Future;

import com.lunz.cpfw.web.entities.helloworld;
import com.lunz.cpfw.web.model.DemoSearchModel;
import com.lunz.cpfw.web.services.HelloWorldService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.lunz.cpfw.core.interaction.PagingOptions;
import com.lunz.cpfw.core.service.WebApiResult;

@RestController
@Api(tags = "Demo")
public class DemoController extends BaseV1Controller {
	@Value("${env.env-value}")
	String envValue;
	
    @Autowired
    HelloWorldService helloworldService;

    @GetMapping("/demo/demo1/{name}")
    @ApiOperation("测试Demo1")
    public helloworld demo(@PathVariable String name) throws Exception {
        Future<helloworld> item = helloworldService.getHelloWorld1Async(name);
        return item.get();
    }

    @ApiOperation("测试Demo2")
    @GetMapping("/demo/demo2/{name}")
    public WebApiResult demo2(@PathVariable String name) {
        return helloworldService.getHelloWorld2(name);
    }

    @ApiOperation("分页 get demo")
    @GetMapping("/demo/getpaging")
    public WebApiResult demo3(@RequestParam(value = "pageSize") int pageSize,
            @RequestParam(value = "pageIndex") int pageIndex) throws Exception {
        PagingOptions pagingOptions = new PagingOptions();
        pagingOptions.setPageIndex(pageIndex);
        pagingOptions.setPageSize(pageSize);
        Future<WebApiResult> result = helloworldService.queryPagingResult(pagingOptions);
        return result.get();
    }

    @ApiOperation("分页 post demo")
    @PostMapping("/demo/postpaging")
    public WebApiResult demo4(@RequestBody PagingOptions pagingOptions) throws Exception {
        Future<WebApiResult> result = helloworldService.queryPagingResult(pagingOptions);
        return result.get();
    }

    @ApiOperation("复杂查询+分页 post demo")
    @PostMapping("/demo/postsearchpaging")
    public WebApiResult demo5(@RequestBody DemoSearchModel searchModel, @RequestParam(value = "pageSize") int pageSize,
            @RequestParam(value = "pageIndex") int pageIndex) throws Exception {
                ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
RequestContextHolder.setRequestAttributes(sra, true);
        PagingOptions pagingOptions = new PagingOptions();
        pagingOptions.setPageIndex(pageIndex);
        pagingOptions.setPageSize(pageSize);
        // 只做demo，未真正实现查询
        String returnStr = String.format("PageSize:%s, PageIndex:%s, SearchModel:%s", pageSize,pageIndex,searchModel.toString());
        return WebApiResult.ok(returnStr);
    }
    
    @ApiOperation("环境test")
    @GetMapping("/demo/demo6")
    public String  demo6() {
		return envValue;
	}
}
