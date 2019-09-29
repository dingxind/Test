package com.lunz.cpfw.web.utils;

import com.lunz.cpfw.core.interaction.PagingFilter;

/**
 * 创建一个过滤条件
 * 
 * @param field 属性名
 * @param op    匹配方式
 * @param term  匹配的值
 */
public class PagingFilterUtil {
    public static PagingFilter createOne(String field, String op, String term) {
        PagingFilter filter = new PagingFilter();
        filter.setField(field);
        filter.setOp(op);
        filter.setTerm(term);

        return filter;
    }
}