package com.lunz.cpfw.web.model;

import java.util.List;

import javax.validation.Valid;

import com.lunz.cpfw.web.entities.tb_product_investorannex;
import com.lunz.cpfw.web.entities.tb_product_investorinfo;

public class InvestorModel {

    @Valid
    private tb_product_investorinfo investorinfo;

    private List<InvestorMortgageModel> investormortgagelist;

    private List<tb_product_investorannex> investorannexlist;

    public tb_product_investorinfo getInvestorinfo() {
        return investorinfo;
    }

    public void setInvestorinfo(tb_product_investorinfo investorinfo) {
        this.investorinfo = investorinfo;
    }

    public List<InvestorMortgageModel> getInvestorMortgageList() {
        return investormortgagelist;
    }

    public void setInvestorMortgageList(List<InvestorMortgageModel> investormortgagelist) {
        this.investormortgagelist = investormortgagelist;
    }

    public List<tb_product_investorannex> getInvestorAnnexList() {
        return investorannexlist;
    }

    public void setInvestorAnnexList(List<tb_product_investorannex> investorannexlist) {
        this.investorannexlist = investorannexlist;
    }
}