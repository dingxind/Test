package com.lunz.cpfw.web.services;

import com.lunz.cpfw.core.service.ServiceBase;

import com.lunz.cpfw.web.entities.tb_product_investorannex;
import com.lunz.cpfw.web.interfaces.IInvestorAnnexService;
import com.lunz.cpfw.web.mappers.tb_product_investorannexMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvestorAnnexService extends ServiceBase<tb_product_investorannexMapper, tb_product_investorannex> implements IInvestorAnnexService {
    @Autowired
    tb_product_investorannexMapper annexMapper;

    @Override
	public int insertInvestorAnnex(tb_product_investorannex model) {
		return annexMapper.insertInvestorAnnex(model);
	}
}