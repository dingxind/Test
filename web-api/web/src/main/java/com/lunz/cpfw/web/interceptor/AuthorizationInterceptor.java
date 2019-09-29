package com.lunz.cpfw.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.alibaba.fastjson.JSON;
import com.lunz.cpfw.common.utils.SpringContextUtils;
import com.lunz.cpfw.core.annotation.Annoymous;
import com.lunz.cpfw.core.annotation.Login;
import com.lunz.cpfw.core.entity.CurrentUserDTO;
import com.lunz.cpfw.core.service.JwtService;
import com.lunz.cpfw.core.service.WebApiResult;
import com.lunz.cpfw.core.utils.ServletUtils;

@Component
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {
    @Value("${environment.open-authorization}")
    private boolean openAuthorization;

    public Logger logger = LoggerFactory.getLogger(getClass());

    // @Value("${env.env-value}")
    // private String envValue;

    @Autowired
    private MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        Boolean canSkip = false;
        CurrentUserDTO currentUserDTO = null;
        try {
            if (handler instanceof HandlerMethod) {

                if (((HandlerMethod) handler).hasMethodAnnotation(Login.class)) {
                    canSkip = true;
                } else {
                    if (((HandlerMethod) handler).hasMethodAnnotation(Annoymous.class)) {
                        canSkip = true;
                    }
                }
            }

            String authorization = request.getHeader("Authorization");
            String token = StringUtils.substringAfter(authorization, "Bearer ");
            if (StringUtils.isNotBlank(token)) {
                currentUserDTO = JwtService.getClaimsFromToken(token);

                // 设置userInfo到request里，后续根据userInfo，获取用户信息
                request.setAttribute(ServletUtils.UserInfoKey, JSON.toJSONString(currentUserDTO));
            }
            String envStr = SpringContextUtils.getActiveProfile();
            // logger.info("envStr:" + envStr);
            if (!openAuthorization || StringUtils.equals(ServletUtils.EnvValueStr, envStr)) {
                canSkip = true;
                return canSkip;
            } else {
                if (currentUserDTO == null) {
                    ServletUtils.GenerateCommonResponseHeader(request, response);
                    HttpOutputMessage httpOutputMessage = new ServletServerHttpResponse(response);

                    mappingJackson2HttpMessageConverter.write(WebApiResult.error(401, "Token为空或Token已过期"),
                            MediaType.APPLICATION_JSON_UTF8, httpOutputMessage);
                    return canSkip;
                }
            }
            canSkip = true;
        } catch (Exception e) {
            String errorMessage = "tokenException:" + e;
            logger.error(errorMessage);
            HttpOutputMessage httpOutputMessage = new ServletServerHttpResponse(response);

            mappingJackson2HttpMessageConverter.write(WebApiResult.error(500, errorMessage),
                    MediaType.APPLICATION_JSON_UTF8, httpOutputMessage);
        }
        return canSkip;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        ServletUtils.GenerateCommonResponseHeader(request, response);
    }

}