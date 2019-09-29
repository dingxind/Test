package com.lunz.cpfw.web.services;

import com.lunz.cpfw.core.service.ServiceBase;
import com.lunz.cpfw.web.entities.tb_product_mortgageregion;

import com.lunz.cpfw.web.interfaces.IMortgageRegionService;

import com.lunz.cpfw.web.mappers.tb_product_mortgageregionMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MortgageRegionService extends ServiceBase<tb_product_mortgageregionMapper, tb_product_mortgageregion>
        implements IMortgageRegionService {
    @Autowired
    tb_product_mortgageregionMapper regionMapper;

    @Override
    public int insertMortgageRegion(tb_product_mortgageregion model) {
        return regionMapper.insertMortgageRegion(model);
    }
}