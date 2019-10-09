package com.lunz.cpfw.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.lunz.cpfw.common.utils.SpringContextUtils;
import com.lunz.cpfw.core.service.WebApiResult;
import com.lunz.cpfw.core.utils.ServletUtils;
import com.lunz.cpfw.web.mappers.CommonMapper;

@Component
public class ClientIdInterceptor extends HandlerInterceptorAdapter {
//    @Value("${environment.open-authorization}")
//    private boolean openAuthorization;

    @Autowired
    private MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter;
    @Autowired
    private CommonMapper commonMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        Boolean canSkip = false;

        String envStr = SpringContextUtils.getActiveProfile();

        if (canSkip || StringUtils.equals(ServletUtils.EnvValueStr, envStr)) {
            return true;
        }

        String clientId = request.getHeader(ServletUtils.ClientIdKey);
        canSkip = StringUtils.isNotBlank(clientId);

        if (canSkip) {
            int clientCount = commonMapper.HasClient(clientId);
            canSkip = clientCount > 0;
        }

        if (!canSkip) {
            ServletUtils.GenerateCommonResponseHeader(request, response);
            HttpOutputMessage httpOutputMessage = new ServletServerHttpResponse(response);

            mappingJackson2HttpMessageConverter.write(WebApiResult.error(401, "Header中ClientId缺失或ClientId不存在"),
                    MediaType.APPLICATION_JSON_UTF8, httpOutputMessage);

            return canSkip;
        }

        request.setAttribute(ServletUtils.ClientIdKey, clientId);

        return canSkip;
    }
}

// @Override
// public void afterCompletion(HttpServletRequest request, HttpServletResponse
// response, Object handler, Exception ex)
// throws Exception {
// ServletUtils.GenerateCommonResponseHeader(request, response);
// }