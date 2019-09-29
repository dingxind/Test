package com.lunz.cpfw.web.mappers;

import com.lunz.cpfw.web.entities.tb_product_investormortgage;
import com.baomidou.mybatisplus.mapper.BaseMapper;

public interface tb_product_investormortgageMapper extends BaseMapper<tb_product_investormortgage> {
    int insertInvestorMortgage(tb_product_investormortgage model);
}