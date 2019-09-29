package com.lunz.cpfw.web.services;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.toolkit.StringUtils;
import com.lunz.cpfw.core.service.ServiceBase;
import com.lunz.cpfw.core.service.WebApiResult;
import com.lunz.cpfw.web.entities.sys_product_operatinglog;

import com.lunz.cpfw.web.interfaces.ILogService;

import com.lunz.cpfw.web.mappers.sys_product_operatinglogMapper;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;
import java.util.Date;

@Service
public class LogService extends ServiceBase<sys_product_operatinglogMapper, sys_product_operatinglog>
        implements ILogService {

    @Value("${environment.open-authorization}")
    private boolean openAuthorization;

    /**
     * 添加日志
     */
    @Async
    @Override
    public Future<WebApiResult> addLogAsync(String dataid, String tableName, Short type, String remark,
            Short businessType) {
        AsyncResult<WebApiResult> result = null;
        try {
            String userId = getUserId();
            String userName = getUserName();
            if (StringUtils.isEmpty(userId) && openAuthorization) {
                super.logger.debug("dartaid：" + dataid + "记录日志时当前人为空");
            }

            sys_product_operatinglog log = new sys_product_operatinglog();
            log.setDataid(dataid);
            log.setTablename(tableName);
            log.setType(type);
            log.setRemark(remark);
            log.setBusinesstype(businessType);
            log.setOperateid(userId);
            log.setOperator(userName);
            log.setCreatedat(new Date());
            log.setCreatedbyid(userId);
            log.setUpdatedat(new Date());
            log.setUpdatedbyid(userId);
            log.setDeleted(false);
            log.setJsonstring(JSON.toJSONString(log));
            boolean isSuccess = super.insert(log);
            result = new AsyncResult<WebApiResult>(WebApiResult.ok(isSuccess));
        } catch (Exception ex) {
            result = new AsyncResult<WebApiResult>(WebApiResult.error(ex));
        }
        return result;
    }

    /**
     * 根据DataId获取日志
     */
    @Async
    @Override
    public Future<WebApiResult> getLogsByDataIdAsync(String id) {
        AsyncResult<WebApiResult> result = null;
        try {
            EntityWrapper<sys_product_operatinglog> wrapper = new EntityWrapper<>();
            wrapper.eq("dataid", id);
            wrapper.orderBy("createdat", false);
            result = new AsyncResult<WebApiResult>(WebApiResult.ok(selectList(wrapper)));
        } catch (Exception ex) {
            result = new AsyncResult<WebApiResult>(WebApiResult.error(ex));
        }
        return result;
    }

    /**
     * 根据BusinessType获取模块日志
     */
    @Async
    @Override
    public Future<WebApiResult> getLogsByBusinessTypeAsync(Short type) {
        AsyncResult<WebApiResult> result = null;
        try {
            EntityWrapper<sys_product_operatinglog> wrapper = new EntityWrapper<>();
            wrapper.eq("businesstype", type);
            wrapper.orderBy("createdat", false);
            result = new AsyncResult<WebApiResult>(WebApiResult.ok(selectList(wrapper)));
        } catch (Exception ex) {
            result = new AsyncResult<WebApiResult>(WebApiResult.error(ex));
        }
        return result;
    }
}