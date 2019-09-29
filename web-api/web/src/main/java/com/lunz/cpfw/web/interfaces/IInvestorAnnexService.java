package com.lunz.cpfw.web.interfaces;

import com.lunz.cpfw.web.entities.tb_product_investorannex;
import com.baomidou.mybatisplus.service.IService;

public interface IInvestorAnnexService extends IService<tb_product_investorannex> {
    int insertInvestorAnnex(tb_product_investorannex annex);
}