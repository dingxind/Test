package com.lunz.cpfw.web.interfaces;

import com.lunz.cpfw.core.service.WebApiResult;
import com.baomidou.mybatisplus.service.IService;

import com.lunz.cpfw.web.entities.tb_product_investorinfo;

import com.lunz.cpfw.core.interaction.PagingOptions;

public interface IInvestorInfoService extends IService<tb_product_investorinfo> {
    WebApiResult queryInvestorList(PagingOptions pagingOptions);

    WebApiResult openOrStopInvestor(String id, boolean isdisable);

    WebApiResult getInestorNameList();

    boolean isStop(String id);

    WebApiResult changeIsUsed(String id, boolean isUsed);
}