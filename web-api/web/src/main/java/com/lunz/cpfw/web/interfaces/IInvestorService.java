package com.lunz.cpfw.web.interfaces;

import java.util.concurrent.Future;

import com.lunz.cpfw.core.service.WebApiResult;
import com.lunz.cpfw.web.model.InvestorModel;

import com.lunz.cpfw.core.interaction.PagingOptions;

public interface IInvestorService {
    Future<WebApiResult> addInvestorAsync(InvestorModel model) throws Exception;

    Future<WebApiResult> getInvestorInfoAsync(String id);

    Future<WebApiResult> openInvestorAsync(String id);

    Future<WebApiResult> stopInvestorAsync(String id);

    Future<WebApiResult> getInvestorListAsync(PagingOptions pagingOptions);
}