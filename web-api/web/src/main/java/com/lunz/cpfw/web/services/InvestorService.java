package com.lunz.cpfw.web.services;

import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

import com.lunz.cpfw.core.service.WebApiResult;

import com.lunz.cpfw.web.entities.tb_product_investorinfo;
import com.lunz.cpfw.web.entities.tb_product_investormortgage;
import com.lunz.cpfw.web.entities.tb_product_mortgageregion;
import com.lunz.cpfw.web.entities.tb_product_investorannex;

import com.lunz.cpfw.web.interfaces.IInvestorService;

import com.lunz.cpfw.web.mappers.CommonMapper;

import com.lunz.cpfw.web.model.InvestorModel;
import com.lunz.cpfw.web.model.InvestorMortgageModel;
import com.lunz.cpfw.web.utils.ReflectionUtil;
import com.lunz.cpfw.web.utils.ListUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.toolkit.StringUtils;

import org.springframework.transaction.annotation.Transactional;

import com.lunz.cpfw.core.interaction.PagingOptions;

@Service
public class InvestorService implements IInvestorService {
    @Value("${environment.open-authorization}")
    private boolean openAuthorization;

    @Autowired
    CommonMapper commonMapper;

    @Autowired
    InvestorInfoService investorInfoService;

    @Autowired
    InvestorMortgageService mortgageService;

    @Autowired
    MortgageRegionService regionService;

    @Autowired
    InvestorAnnexService annexService;

    @Autowired
    LogService logService;

    @Autowired
    CommonService commonService;

    /**
     * 获取资方管理列表
     */
    @Async
    @Override
    public Future<WebApiResult> getInvestorListAsync(PagingOptions pagingOptions) {
        AsyncResult<WebApiResult> result = null;
        try {
            result = new AsyncResult<WebApiResult>(investorInfoService.queryInvestorList(pagingOptions));
        } catch (Exception ex) {
            result = new AsyncResult<WebApiResult>(WebApiResult.error(ex));
        }
        return result;
    }

    /**
     * 新建/编辑资方
     * 
     */
    @Async
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Future<WebApiResult> addInvestorAsync(InvestorModel model) throws Exception {
        AsyncResult<WebApiResult> result = null;
        String uniqueid = null;
        Short type = 0;
        String remark = "";
        // String operating = null;
        // String otherExplain = null;
        try {
            String userId = investorInfoService.getUserId();
            if (StringUtils.isEmpty(userId) && openAuthorization) {
                return new AsyncResult<WebApiResult>(WebApiResult.error("登录用户信息获取失败，操作失败！"));
            }

            if (model != null) {
                tb_product_investorinfo newInvestorInfo = model.getInvestorinfo();
                List<InvestorMortgageModel> mortgageList = model.getInvestorMortgageList();
                List<tb_product_investorannex> newAnnexList = model.getInvestorAnnexList();

                String oldId = newInvestorInfo.getId();
                String newId = commonMapper.GeneratorKey("PPIN");

                tb_product_investorinfo investorInfo = investorInfoService.selectById(oldId);

                if (investorInfo == null) {
                    Map<String, Object> map = ReflectionUtil.getKeyAndValue(newInvestorInfo, null);
                    if (map != null && map.size() > 0) {
                        remark = commonService.getAddRemark(map, "新建资方");
                    }

                    newInvestorInfo.setIsdisable(false);
                    uniqueid = commonMapper.GeneratorKey("PUIN");
                    type = 1;
                } else {
                    // 判断资方基本信息是否有修改
                    Map<String, List<Object>> map = ReflectionUtil.compareFields(investorInfo, newInvestorInfo, null);
                    if (map != null && map.size() > 0) {
                        remark = commonService.getEditRemark(map, "修改资方基本信息");
                    }

                    // 判断附件资料是否有修改
                    EntityWrapper<tb_product_investorannex> annexWrapper = new EntityWrapper<>();
                    annexWrapper.eq("investorid", newInvestorInfo.getId());
                    annexWrapper.setSqlSelect(new String[] { "url" });
                    List<tb_product_investorannex> annexList = annexService.selectList(annexWrapper);

                    List<String> list1 = annexList.stream().map(p -> p.getUrl()).collect(Collectors.toList());
                    List<String> list2 = newAnnexList.stream().map(p -> p.getUrl()).collect(Collectors.toList());
                    boolean annexCommon = ListUtil.isCommon(list1, list2);
                    if ((map == null || map.size() == 0) && annexCommon) {
                        return new AsyncResult<WebApiResult>(WebApiResult.ok("无任何修改，此处不进行操作"));
                    } else if (!annexCommon) {
                        remark = remark + "修改附件资料";
                    }

                    investorInfo.setIscurrent(false);
                    investorInfo.setUpdatedat(new Date());
                    investorInfo.setUpdatedbyid(userId);
                    investorInfo.setJsonstring(null);
                    investorInfo.setJsonstring(JSON.toJSONString(investorInfo));
                    investorInfoService.updateById(investorInfo);

                    newInvestorInfo.setIsdisable(investorInfo.getIsdisable());

                    uniqueid = investorInfo.getUniqueid();
                    type = 2;

                    // 资方编辑后，正在使用该资方的产品受影响
                    // productService.updateProductByInvestor(oldId, newId);
                }

                String clientId = investorInfoService.getClientId();
                newInvestorInfo.setId(newId);
                newInvestorInfo.setUniqueid(uniqueid);
                newInvestorInfo.setClientid(clientId);
                newInvestorInfo.setCreatedat(new Date());
                newInvestorInfo.setCreatedbyid(userId);
                newInvestorInfo.setUpdatedat(new Date());
                newInvestorInfo.setUpdatedbyid(userId);
                newInvestorInfo.setDeleted(false);
                newInvestorInfo.setIscurrent(true);
                newInvestorInfo.setVersion(1);
                newInvestorInfo.setJsonstring(JSON.toJSONString(newInvestorInfo));
                investorInfoService.insert(newInvestorInfo);// 资方基本信息

                // 抵押信息
                if (mortgageList != null) {
                    for (InvestorMortgageModel mortgageInfo : mortgageList) {
                        tb_product_investormortgage mortgage = mortgageInfo.getInvestormortgage();
                        List<tb_product_mortgageregion> regionList = mortgageInfo.getMortgageRegionList();

                        String mortgageid = commonMapper.GeneratorKey("PPMT");
                        mortgage.setId(mortgageid);
                        mortgage.setInvestorid(newId);
                        mortgage.setCreatedat(new Date());
                        mortgage.setCreatedbyid(userId);
                        mortgage.setUpdatedat(new Date());
                        mortgage.setUpdatedbyid(userId);
                        mortgage.setDeleted(false);
                        mortgage.setJsonstring(JSON.toJSONString(mortgage));
                        mortgageService.insert(mortgage);

                        // 抵押省份信息
                        if (regionList != null) {
                            for (tb_product_mortgageregion region : regionList) {
                                region.setId(null);
                                region.setInvestorid(newId);
                                region.setMortgageid(mortgageid);
                                region.setCreatedat(new Date());
                                region.setCreatedbyid(userId);
                                region.setUpdatedat(new Date());
                                region.setUpdatedbyid(userId);
                                region.setDeleted(false);
                                region.setJsonstring(JSON.toJSONString(region));
                                regionService.insert(region);
                            }
                        }
                    }
                }
                // 附件信息
                if (newAnnexList != null) {
                    for (tb_product_investorannex annex : newAnnexList) {
                        annex.setId(null);
                        annex.setInvestorid(newId);
                        annex.setCreatedat(new Date());
                        annex.setCreatedbyid(userId);
                        annex.setUpdatedat(new Date());
                        annex.setUpdatedbyid(userId);
                        annex.setDeleted(false);
                        annex.setJsonstring(JSON.toJSONString(annex));
                        annexService.insert(annex);
                    }
                }

                // 记录日志
                logService.addLogAsync(uniqueid, "tb_product_investorinfo", type, remark, (short) 1);

                result = new AsyncResult<WebApiResult>(WebApiResult.ok("成功"));
            }
        } catch (Exception ex) {
            result = new AsyncResult<WebApiResult>(WebApiResult.error(ex));
            throw ex;
        }
        return result;
    }

    /**
     * 获取资方详情
     */
    @Async
    @Override
    public Future<WebApiResult> getInvestorInfoAsync(String id) {
        AsyncResult<WebApiResult> result = null;
        try {
            InvestorModel investorModel = new InvestorModel();
            InvestorMortgageModel mortgageModel = new InvestorMortgageModel();
            List<InvestorMortgageModel> mortgageInfoList = new ArrayList<>();

            // 资方基本信息
            EntityWrapper<tb_product_investorinfo> infoWrapper = new EntityWrapper<>();
            infoWrapper.eq("id", id);
            investorModel.setInvestorinfo(investorInfoService.selectOne(infoWrapper));

            // 附件信息
            EntityWrapper<tb_product_investorannex> annexWrapper = new EntityWrapper<>();
            annexWrapper.eq("investorid", id);
            annexWrapper.orderBy("createdat", false);
            investorModel.setInvestorAnnexList(annexService.selectList(annexWrapper));

            // 抵押信息
            EntityWrapper<tb_product_investormortgage> mortgageWrapper = new EntityWrapper<>();
            mortgageWrapper.eq("investorid", id);
            mortgageWrapper.orderBy("createdat", false);
            List<tb_product_investormortgage> mortgageList = mortgageService.selectList(mortgageWrapper);

            if (mortgageList != null) {
                for (tb_product_investormortgage mortgage : mortgageList) {
                    String mortgageid = mortgage.getId();
                    mortgageModel.setInvestormortgage(mortgage);

                    // 抵押省份信息
                    EntityWrapper<tb_product_mortgageregion> regionWrapper = new EntityWrapper<>();
                    regionWrapper.eq("investorid", id);
                    regionWrapper.eq("mortgageid", mortgageid);
                    regionWrapper.orderBy("createdat", false);
                    mortgageModel.setMortgageRegionList(regionService.selectList(regionWrapper));
                    mortgageInfoList.add(mortgageModel);
                }
            }

            investorModel.setInvestorMortgageList(mortgageInfoList);

            result = new AsyncResult<WebApiResult>(WebApiResult.ok(investorModel));
        } catch (Exception ex) {
            result = new AsyncResult<WebApiResult>(WebApiResult.error(ex));
        }
        return result;
    }

    /**
     * 启用资方
     */
    @Async
    @Override
    public Future<WebApiResult> openInvestorAsync(String id) {
        AsyncResult<WebApiResult> result = null;
        try {
            result = new AsyncResult<WebApiResult>(investorInfoService.openOrStopInvestor(id, false));
        } catch (Exception ex) {
            result = new AsyncResult<WebApiResult>(WebApiResult.error(ex));
        }
        return result;
    }

    /**
     * 停用资方
     */
    @Async
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Future<WebApiResult> stopInvestorAsync(String id) {
        AsyncResult<WebApiResult> result = null;
        try {
            // 停用资方
            investorInfoService.openOrStopInvestor(id, true);
            // 停用相关产品
            // productInfoService.stopProductByInvestorId(id);

            result = new AsyncResult<WebApiResult>(WebApiResult.ok("成功"));
        } catch (Exception ex) {
            result = new AsyncResult<WebApiResult>(WebApiResult.error(ex));
        }
        return result;
    }

    // public WebApiResult GetInestorNameList() {
    // WebApiResult result = new WebApiResult();
    // try {
    // EntityWrapper<tb_product_investorinfo> wrapper = new EntityWrapper<>();
    // wrapper.eq("deleted", "0");
    // wrapper.eq("iscurrent", "1");
    // String[] array = new String[] { "id", "name" };
    // wrapper.setSqlSelect(array);

    // List<IdAndNameModel> list = new ArrayList<>();
    // investorInfoService.selectList(wrapper).forEach(x -> {
    // IdAndNameModel model = new IdAndNameModel();
    // model.setId(x.getId());
    // model.setName(x.getName());
    // list.add(model);
    // });

    // result = WebApiResult.ok(list);
    // } catch (Exception ex) {
    // result = WebApiResult.error(ex);
    // }

    // return result;
    // }

}