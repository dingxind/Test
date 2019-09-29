package com.lunz.cpfw.core.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletUtils {
    public static final String HeaderKey = "Authorization, Content-Type, X-Requested-With, token, ClientId";
    public static final String ClientIdKey = "ClientId";
    public static final String UserInfoKey = "UserInfo";
    public static final String EnvValueStr = "dev";

    public static void GenerateCommonResponseHeader(HttpServletRequest request, HttpServletResponse response) {
        // response.reset();
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Headers", HeaderKey);
        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, OPTIONS, POST, PUT, DELETE");
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Max-Age", "3600");
    }
}