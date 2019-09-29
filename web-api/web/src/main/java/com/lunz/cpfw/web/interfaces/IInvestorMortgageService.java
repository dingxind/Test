package com.lunz.cpfw.web.interfaces;

import com.lunz.cpfw.web.entities.tb_product_investormortgage;
import com.baomidou.mybatisplus.service.IService;

public interface IInvestorMortgageService extends IService<tb_product_investormortgage> {
    int insertInvestorMortgage(tb_product_investormortgage investor);
}