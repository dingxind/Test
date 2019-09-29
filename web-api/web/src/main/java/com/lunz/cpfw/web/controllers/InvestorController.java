package com.lunz.cpfw.web.controllers;

import java.util.concurrent.Future;

import com.lunz.cpfw.web.services.InvestorService;
import com.lunz.cpfw.web.model.InvestorModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.lunz.cpfw.core.interaction.PagingOptions;
import com.lunz.cpfw.core.service.WebApiResult;

@RestController
@Api(tags = "Investor")
public class InvestorController extends BaseV1Controller {
    @Autowired
    InvestorService investorService;

    @PostMapping("Investor/getList")
    @ApiOperation("获取资方管理列表")
    public WebApiResult getList(@RequestBody PagingOptions pagingOptions) throws Exception {
        Future<WebApiResult> result = investorService.getInvestorListAsync(pagingOptions);
        return result.get();
    }

    @PostMapping("Investor/addOrEdit")
    @ApiOperation("新建/编辑资方")
    public WebApiResult addOrEdit(@Validated @RequestBody InvestorModel model, BindingResult bindingResult)
            throws Exception {
        if (bindingResult.hasErrors()) {
            String error = bindingResult.getFieldError().getDefaultMessage();
            return WebApiResult.error(error);
        }
        Future<WebApiResult> result = investorService.addInvestorAsync(model);
        return result.get();
    }

    @GetMapping("Investor/getInfo")
    @ApiOperation("获取资方信息")
    public WebApiResult getInfo(@RequestParam String id, String name) throws Exception {
        Future<WebApiResult> result = investorService.getInvestorInfoAsync(id);
        return result.get();
    }

    @GetMapping("Investor/open/{id}")
    @ApiOperation("启用资方")
    public WebApiResult open(@PathVariable String id) throws Exception {
        Future<WebApiResult> result = investorService.openInvestorAsync(id);
        return result.get();
    }

    @GetMapping("Investor/stop/{id}")
    @ApiOperation("停用资方")
    public WebApiResult stop(@PathVariable String id) throws Exception {
        Future<WebApiResult> result = investorService.stopInvestorAsync(id);
        return result.get();
    }
}