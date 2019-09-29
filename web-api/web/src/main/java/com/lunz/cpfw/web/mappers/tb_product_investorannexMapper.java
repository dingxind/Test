package com.lunz.cpfw.web.mappers;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.lunz.cpfw.web.entities.tb_product_investorannex;

public interface tb_product_investorannexMapper extends BaseMapper<tb_product_investorannex> {
    int insertInvestorAnnex(tb_product_investorannex model);
}