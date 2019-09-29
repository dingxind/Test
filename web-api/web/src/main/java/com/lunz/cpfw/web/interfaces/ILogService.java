package com.lunz.cpfw.web.interfaces;

import com.lunz.cpfw.core.service.WebApiResult;
import com.lunz.cpfw.web.entities.sys_product_operatinglog;

import java.util.concurrent.Future;

import com.baomidou.mybatisplus.service.IService;

public interface ILogService extends IService<sys_product_operatinglog> {
    Future<WebApiResult> addLogAsync(String dataid, String tableName, Short type, String remark, Short businessType);

    Future<WebApiResult> getLogsByDataIdAsync(String id);

    Future<WebApiResult> getLogsByBusinessTypeAsync(Short type);
}