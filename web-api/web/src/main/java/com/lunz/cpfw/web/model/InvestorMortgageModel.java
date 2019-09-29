package com.lunz.cpfw.web.model;

import java.util.List;

import com.lunz.cpfw.web.entities.tb_product_investormortgage;
import com.lunz.cpfw.web.entities.tb_product_mortgageregion;;

public class InvestorMortgageModel {

    private tb_product_investormortgage investormortgage;

    private List<tb_product_mortgageregion> mortgageregionlist;

    /**
     * @return the investormortgage
     */
    public tb_product_investormortgage getInvestormortgage() {
        return investormortgage;
    }

    /**
     * @param investormortgage the investormortgage to set
     */
    public void setInvestormortgage(tb_product_investormortgage investormortgage) {
        this.investormortgage = investormortgage;
    }

    public List<tb_product_mortgageregion> getMortgageRegionList() {
        return mortgageregionlist;
    }

    public void setMortgageRegionList(List<tb_product_mortgageregion> mortgageregionlist) {
        this.mortgageregionlist = mortgageregionlist;
    }
}