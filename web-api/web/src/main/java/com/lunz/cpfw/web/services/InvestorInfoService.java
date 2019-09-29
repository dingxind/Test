package com.lunz.cpfw.web.services;

import com.lunz.cpfw.core.service.ServiceBase;
import com.lunz.cpfw.core.service.WebApiResult;
import com.lunz.cpfw.web.entities.tb_product_investorinfo;

import com.lunz.cpfw.web.interfaces.IInvestorInfoService;

import com.lunz.cpfw.web.mappers.tb_product_investorinfoMapper;
import com.lunz.cpfw.web.utils.PagingFilterUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.toolkit.StringUtils;
import com.lunz.cpfw.core.interaction.PagingFilter;
import com.lunz.cpfw.core.interaction.PagingOptions;
import com.lunz.cpfw.core.interaction.PagingSort;
import com.lunz.cpfw.core.interaction.Query;

@Service
public class InvestorInfoService extends ServiceBase<tb_product_investorinfoMapper, tb_product_investorinfo>
        implements IInvestorInfoService {
    @Value("${environment.open-authorization}")
    private boolean openAuthorization;

    @Autowired
    tb_product_investorinfoMapper investorMapper;

    @Autowired
    LogService logService;

    @Override
    public WebApiResult queryInvestorList(PagingOptions pagingOptions) {
        List<PagingFilter> filters = pagingOptions.getFilters();
        if (pagingOptions.getFilters() == null || pagingOptions.getFilters().size() == 0) {
            filters.add(PagingFilterUtil.createOne("isdisable", "eq", "0"));
        }
        filters.add(PagingFilterUtil.createOne("deleted", "eq", "0"));
        filters.add(PagingFilterUtil.createOne("iscurrent", "eq", "1"));
        pagingOptions.setFilters(filters);

        List<PagingSort> sorts = new ArrayList<>();
        PagingSort sort = new PagingSort();
        sort.setField("createdat");
        sort.setSort("desc");
        sorts.add(sort);
        pagingOptions.setSorts(sorts);

        Query<tb_product_investorinfo> query = new Query<tb_product_investorinfo>(investorMapper, pagingOptions);

        return query.buildResult();
    }

    /**
     * 启用/停用资方
     */
    @Override
    public WebApiResult openOrStopInvestor(String id, boolean isdisable) {
        WebApiResult result = new WebApiResult();
        String message = null;
        try {
            String userId = getUserId();
            if (StringUtils.isEmpty(userId) && openAuthorization) {
                return WebApiResult.error("登录用户信息获取失败，操作失败！");
            }

            if (isdisable) {
                message = "停用资方";
            } else {
                message = "启用资方";
            }
            EntityWrapper<tb_product_investorinfo> wrapper = new EntityWrapper<>();
            wrapper.eq("id", id);
            tb_product_investorinfo investorInfo = super.selectOne(wrapper);
            investorInfo.setIsdisable(isdisable);
            investorInfo.setUpdatedat(new Date());
            investorInfo.setUpdatedbyid(userId);
            investorInfo.setJsonstring(null);
            investorInfo.setJsonstring(JSON.toJSONString(investorInfo));
            super.update(investorInfo, wrapper);

            // 记录日志
            logService.addLogAsync(investorInfo.getUniqueid(), "tb_product_investorinfo", (short) 2, message,
                    (short) 1);

            result = WebApiResult.ok("成功");
        } catch (Exception ex) {
            result = WebApiResult.error(ex);
            throw ex;
        }

        return result;
    }

    /**
     * 获取资方列表（用于产品管理明细）
     */
    @Override
    public WebApiResult getInestorNameList() {
        WebApiResult result = new WebApiResult();
        try {
            result = WebApiResult.ok(investorMapper.selectIdAndNameList());
        } catch (Exception ex) {
            result = WebApiResult.error(ex);
        }

        return result;
    }

    /**
     * 判断该资方是否已停用
     */
    @Override
    public boolean isStop(String id) {
        boolean result = false;
        try {
            tb_product_investorinfo info = super.selectById(id);
            if (info != null) {
                result = info.getIsdisable();
            }
        } catch (Exception ex) {
            throw ex;
        }

        return result;
    }

    /**
     * 更改资方“是否使用”字段（暂时无用）
     */
    @Override
    public WebApiResult changeIsUsed(String id, boolean isUsed) {
        WebApiResult result = new WebApiResult();
        try {
            String userId = getUserId();

            tb_product_investorinfo info = selectById(id);
            info.setIsused(isUsed);
            info.setUpdatedat(new Date());
            info.setUpdatedbyid(userId);
            info.setJsonstring(null);
            info.setJsonstring(JSON.toJSONString(info));
            boolean isSuccess = updateById(info);

            result = WebApiResult.ok(isSuccess);
        } catch (Exception ex) {
            result = WebApiResult.error(ex);
            throw ex;
        }

        return result;
    }

    /**
     * 根据资方Id获取资方姓名
     */
    public String getInvestorNameById(String id) {
        String name = null;
        try {
            tb_product_investorinfo info = selectById(id);
            if (info != null) {
                name = info.getName();
            }
        } catch (Exception ex) {
            throw ex;
        }

        return name;
    }

}