package com.lunz.cpfw.web.services;

import com.lunz.cpfw.core.service.ServiceBase;
import com.lunz.cpfw.web.entities.tb_product_investormortgage;

import com.lunz.cpfw.web.interfaces.IInvestorMortgageService;

import com.lunz.cpfw.web.mappers.tb_product_investormortgageMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvestorMortgageService extends ServiceBase<tb_product_investormortgageMapper, tb_product_investormortgage> implements IInvestorMortgageService {
    @Autowired
    tb_product_investormortgageMapper mortgageMapper;

    @Override
	public int insertInvestorMortgage(tb_product_investormortgage model) {
		return mortgageMapper.insertInvestorMortgage(model);
	}
}