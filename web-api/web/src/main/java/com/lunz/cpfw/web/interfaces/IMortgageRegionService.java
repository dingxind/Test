package com.lunz.cpfw.web.interfaces;

import com.lunz.cpfw.web.entities.tb_product_mortgageregion;
import com.baomidou.mybatisplus.service.IService;

public interface IMortgageRegionService extends IService<tb_product_mortgageregion> {
    int insertMortgageRegion(tb_product_mortgageregion investor);
}