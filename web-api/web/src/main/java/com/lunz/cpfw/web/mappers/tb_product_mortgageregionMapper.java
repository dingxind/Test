package com.lunz.cpfw.web.mappers;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.lunz.cpfw.web.entities.tb_product_mortgageregion;

public interface tb_product_mortgageregionMapper extends BaseMapper<tb_product_mortgageregion> {
    int insertMortgageRegion(tb_product_mortgageregion model);
}