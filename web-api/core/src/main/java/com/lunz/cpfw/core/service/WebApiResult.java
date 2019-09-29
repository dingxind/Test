/**
 * Copyright 2018 人人开源 http://www.renren.io
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.lunz.cpfw.core.service;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回数据
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年10月27日 下午9:59:27
 */
public class WebApiResult extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    public WebApiResult() {
        put("code", 200);
        put("message", "success");
        put("success", true);
    }

    public static WebApiResult error() {
        return error(500, "未知异常，请联系管理员");
    }

    public static WebApiResult error(String msg) {
        return error(500, msg);
    }

    public static WebApiResult error(Exception ex) {
        return error(500, ex);
    }

    public static WebApiResult error(int code, String msg) {
        WebApiResult r = new WebApiResult();
        r.put("code", code);
        r.put("message", msg);
        r.put("success", false);
        return r;
    }

    public static WebApiResult error(int code, Exception ex) {
        String exceptionMessageFormat = "Message: %s, StackTrace: %s, Suppressed: %s, Cause: %s, Class: %s %s";

        String msg = String.format(exceptionMessageFormat, ex.getMessage(), ex.getStackTrace(), ex.getSuppressed(),
                ex.getCause(), ex.getClass(), System.getProperty("line.separator"));

        return error(code, msg);
    }

    public static WebApiResult ok(Object data) {
        WebApiResult r = new WebApiResult();
        r.put("data", data);
        return r;
    }

    public static WebApiResult ok(Map<String, Object> map) {
        WebApiResult r = new WebApiResult();
        r.putAll(map);
        return r;
    }

    public static WebApiResult ok() {
        return new WebApiResult();
    }

    @Override
    public WebApiResult put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    public static WebApiResult toMap(String key, Object value) {
        WebApiResult r = new WebApiResult();
        r.clear();
        r.put(key, value);
        return r;

    }
}
