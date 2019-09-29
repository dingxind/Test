package com.lunz.cpfw.core.service;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import com.lunz.cpfw.core.entity.CurrentUserDTO;
import com.lunz.cpfw.core.utils.ServletUtils;

public class ServiceBase<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> implements IServiceBase<T> {
    public Logger logger = LoggerFactory.getLogger(getClass());

    private CurrentUserDTO currentUser;

    public CurrentUserDTO getCurrentUser() {
        Object userInfoAttr = getRequest().getAttribute(ServletUtils.UserInfoKey);

        if (userInfoAttr != null) {
            String currentUserJsonStr = userInfoAttr.toString();
            if (StringUtils.isNotBlank(currentUserJsonStr)) {
                currentUser = JSON.parseObject(currentUserJsonStr, CurrentUserDTO.class);
            }
        }

        return currentUser;
    }

    public void setCurrentUser(CurrentUserDTO currentUser) {
        this.currentUser = currentUser;
    }

    private String clientId;

    public String getClientId() {
        clientId = getRequest().getHeader(ServletUtils.ClientIdKey);
        return clientId;
    }

    public HttpServletRequest getRequest() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();
        return request;
    }

    private String userId;

    public String getUserId() {
        if (this.currentUser == null) {
            getCurrentUser();
        }
        if (this.currentUser != null) {
            this.userId = this.currentUser.getId();
        }
        return userId;
    }

    private String userName;

    public String getUserName() {
        if (this.currentUser == null) {
            getCurrentUser();
        }
        if (this.currentUser != null) {
            this.userName = this.currentUser.getName();
        }
        return userName;
    }
}