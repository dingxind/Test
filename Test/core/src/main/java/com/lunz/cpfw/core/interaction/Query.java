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

package com.lunz.cpfw.core.interaction;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.lunz.cpfw.core.service.WebApiResult;

import com.lunz.cpfw.common.utils.StringUtil;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 查询参数
 *
 * @author Mark sunlightcs@gmail.com
 * @since 2.0.0 2017-03-14
 */
public class Query<T> extends LinkedHashMap<String, Object> {
    private static final long serialVersionUID = 1L;
    /**
     * mybatis-plus分页参数
     */
    private Page<T> page;
    /**
     * 当前页码
     */
    private int currPage = 1;
    /**
     * 每页条数
     */
    private int limit = 10;

    private EntityWrapper<T> entityWrapper;

    private BaseMapper<T> baseMapper;

    public Query(Map<String, Object> params) {
        this.putAll(params);

        // 分页参数
        if (params.get("pageindex") != null) {
            currPage = Integer.parseInt(String.valueOf(params.get("pageindex")));
        }
        if (params.get("pagesize") != null) {
            limit = Integer.parseInt(String.valueOf(params.get("pagesize")));
        }

        this.put("offset", (currPage - 1) * limit);
        this.put("page", currPage);
        this.put("limit", limit);

        // 防止SQL注入（因为sidx、order是通过拼接SQL实现排序的，会有SQL注入风险）
        // String sidx = SQLFilter.sqlInject((String)params.get("sidx"));
        // String order = SQLFilter.sqlInject((String)params.get("order"));
        // this.put("sidx", sidx);
        // this.put("order", order);

        // mybatis-plus分页
        this.page = new Page<>(currPage, limit);

        // 排序
        // if(StringUtils.isNotBlank(sidx) && StringUtils.isNotBlank(order)){
        // this.page.setOrderByField(sidx);
        // this.page.setAsc("ASC".equalsIgnoreCase(order));
        // }

    }

    public Query(BaseMapper<T> baseMapper, PagingOptions pagingOptions) {

        this.baseMapper = baseMapper;
        // 分页参数
        this.page = new Page<>(pagingOptions.getPageIndex(), pagingOptions.getPageSize());

        // Build Query
        this.entityWrapper = new EntityWrapper<T>();

        // Build Filter
        List<PagingFilter> filters = pagingOptions.getFilters();
        if (filters != null && !filters.isEmpty()) {
            for (PagingFilter filter : pagingOptions.getFilters()) {

                if (StringUtil.isEmpty(filter.getField()) || StringUtil.isEmpty(filter.getOp())) {
                    continue;
                }

                String strOp = filter.getOp().trim();
                switch (strOp) {
                case "eq":
                    this.entityWrapper.eq(filter.getField(), filter.getTerm());
                    break;
                case "ne":
                    this.entityWrapper.ne(filter.getField(), filter.getTerm());
                    break;
                case "lt":
                    this.entityWrapper.lt(filter.getField(), filter.getTerm());
                    break;
                case "le":
                    this.entityWrapper.le(filter.getField(), filter.getTerm());
                    break;
                case "gt":
                    this.entityWrapper.gt(filter.getField(), filter.getTerm());
                    break;
                case "ge":
                    this.entityWrapper.ge(filter.getField(), filter.getTerm());
                    break;
                case "cn":
                    this.entityWrapper.like(filter.getField(), filter.getTerm());
                    break;
                case "nu":
                    this.entityWrapper.isNull(filter.getField());
                    break;
                case "nn":
                    this.entityWrapper.isNotNull(filter.getField());
                    break;
                }

            }
        }

        // Build Order
        List<PagingSort> sorts = pagingOptions.getSorts();
        if (sorts != null && !sorts.isEmpty()) {
            for (PagingSort sort : pagingOptions.getSorts()) {

                if (StringUtil.isEmpty(sort.getField()) || StringUtil.isEmpty(sort.getSort())) {
                    continue;
                }

                String strOp = sort.getSort().trim();
                switch (strOp) {
                case "asc":
                    this.entityWrapper.orderBy(sort.getField());
                    break;
                case "desc":
                    this.entityWrapper.orderBy(sort.getField(), false);
                    break;
                }

            }
        }
    }

    public Page<T> getPage() {
        return page;
    }

    public int getCurrPage() {
        return currPage;
    }

    public int getLimit() {
        return limit;
    }

    public EntityWrapper<T> getQueryWrapper() {
        return this.entityWrapper;
    }

    public WebApiResult buildResult() {
        try {
            page.setRecords(this.baseMapper.selectPage(page, entityWrapper));
            PageUtils pageUtil = new PageUtils(page);
            return WebApiResult.ok(pageUtil.getList()).put("count", pageUtil.getTotalCount());

        } catch (Exception ex) {
            return WebApiResult.error(ex);
        }
    }
}
