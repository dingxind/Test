package mybatis-generator.entity;

import java.math.BigDecimal;
import java.util.Date;

public class tb_product_productinfo {
    private String id;

    private String uniqueid;

    private String clientid;

    private Boolean isdisable;

    private String name;

    private Short leasedirection;

    private Short repaymentmode;

    private String investorid;

    private Short limitinterestrate;

    private BigDecimal standardinterestrate;

    private Short limitfinancing;

    private BigDecimal financingamounts;

    private BigDecimal financingamounte;

    private String vehiclekindid;

    private Short businessscope;

    private Short regionrate;

    private BigDecimal regionfloat;

    private Short isdiscount;

    private BigDecimal overallfloatrate;

    private Date effectivedate;

    private Date invaliddate;

    private Short ishandlingfee;

    private Short handlingfeeway;

    private BigDecimal yearbaserate;

    private Short isfloat;

    private Short securitydeposit;

    private Short securitydepositprocess;

    private Short downpayment;

    private Short finalpayment;

    private Short purchasetax;

    private Short insurance;

    private Short gps;

    private Short violationdeposit;

    private Short renewalmoney;

    private Short otherhandlingfee;

    private Short monthlyfee;

    private Boolean isused;

    private Short iscurrent;

    private Integer version;

    private Date createdat;

    private String createdbyid;

    private Date updatedat;

    private String updatedbyid;

    private Boolean deleted;

    private Date deletedat;

    private String deletedbyid;

    private String jsonstring;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUniqueid() {
        return uniqueid;
    }

    public void setUniqueid(String uniqueid) {
        this.uniqueid = uniqueid == null ? null : uniqueid.trim();
    }

    public String getClientid() {
        return clientid;
    }

    public void setClientid(String clientid) {
        this.clientid = clientid == null ? null : clientid.trim();
    }

    public Boolean getIsdisable() {
        return isdisable;
    }

    public void setIsdisable(Boolean isdisable) {
        this.isdisable = isdisable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Short getLeasedirection() {
        return leasedirection;
    }

    public void setLeasedirection(Short leasedirection) {
        this.leasedirection = leasedirection;
    }

    public Short getRepaymentmode() {
        return repaymentmode;
    }

    public void setRepaymentmode(Short repaymentmode) {
        this.repaymentmode = repaymentmode;
    }

    public String getInvestorid() {
        return investorid;
    }

    public void setInvestorid(String investorid) {
        this.investorid = investorid == null ? null : investorid.trim();
    }

    public Short getLimitinterestrate() {
        return limitinterestrate;
    }

    public void setLimitinterestrate(Short limitinterestrate) {
        this.limitinterestrate = limitinterestrate;
    }

    public BigDecimal getStandardinterestrate() {
        return standardinterestrate;
    }

    public void setStandardinterestrate(BigDecimal standardinterestrate) {
        this.standardinterestrate = standardinterestrate;
    }

    public Short getLimitfinancing() {
        return limitfinancing;
    }

    public void setLimitfinancing(Short limitfinancing) {
        this.limitfinancing = limitfinancing;
    }

    public BigDecimal getFinancingamounts() {
        return financingamounts;
    }

    public void setFinancingamounts(BigDecimal financingamounts) {
        this.financingamounts = financingamounts;
    }

    public BigDecimal getFinancingamounte() {
        return financingamounte;
    }

    public void setFinancingamounte(BigDecimal financingamounte) {
        this.financingamounte = financingamounte;
    }

    public String getVehiclekindid() {
        return vehiclekindid;
    }

    public void setVehiclekindid(String vehiclekindid) {
        this.vehiclekindid = vehiclekindid == null ? null : vehiclekindid.trim();
    }

    public Short getBusinessscope() {
        return businessscope;
    }

    public void setBusinessscope(Short businessscope) {
        this.businessscope = businessscope;
    }

    public Short getRegionrate() {
        return regionrate;
    }

    public void setRegionrate(Short regionrate) {
        this.regionrate = regionrate;
    }

    public BigDecimal getRegionfloat() {
        return regionfloat;
    }

    public void setRegionfloat(BigDecimal regionfloat) {
        this.regionfloat = regionfloat;
    }

    public Short getIsdiscount() {
        return isdiscount;
    }

    public void setIsdiscount(Short isdiscount) {
        this.isdiscount = isdiscount;
    }

    public BigDecimal getOverallfloatrate() {
        return overallfloatrate;
    }

    public void setOverallfloatrate(BigDecimal overallfloatrate) {
        this.overallfloatrate = overallfloatrate;
    }

    public Date getEffectivedate() {
        return effectivedate;
    }

    public void setEffectivedate(Date effectivedate) {
        this.effectivedate = effectivedate;
    }

    public Date getInvaliddate() {
        return invaliddate;
    }

    public void setInvaliddate(Date invaliddate) {
        this.invaliddate = invaliddate;
    }

    public Short getIshandlingfee() {
        return ishandlingfee;
    }

    public void setIshandlingfee(Short ishandlingfee) {
        this.ishandlingfee = ishandlingfee;
    }

    public Short getHandlingfeeway() {
        return handlingfeeway;
    }

    public void setHandlingfeeway(Short handlingfeeway) {
        this.handlingfeeway = handlingfeeway;
    }

    public BigDecimal getYearbaserate() {
        return yearbaserate;
    }

    public void setYearbaserate(BigDecimal yearbaserate) {
        this.yearbaserate = yearbaserate;
    }

    public Short getIsfloat() {
        return isfloat;
    }

    public void setIsfloat(Short isfloat) {
        this.isfloat = isfloat;
    }

    public Short getSecuritydeposit() {
        return securitydeposit;
    }

    public void setSecuritydeposit(Short securitydeposit) {
        this.securitydeposit = securitydeposit;
    }

    public Short getSecuritydepositprocess() {
        return securitydepositprocess;
    }

    public void setSecuritydepositprocess(Short securitydepositprocess) {
        this.securitydepositprocess = securitydepositprocess;
    }

    public Short getDownpayment() {
        return downpayment;
    }

    public void setDownpayment(Short downpayment) {
        this.downpayment = downpayment;
    }

    public Short getFinalpayment() {
        return finalpayment;
    }

    public void setFinalpayment(Short finalpayment) {
        this.finalpayment = finalpayment;
    }

    public Short getPurchasetax() {
        return purchasetax;
    }

    public void setPurchasetax(Short purchasetax) {
        this.purchasetax = purchasetax;
    }

    public Short getInsurance() {
        return insurance;
    }

    public void setInsurance(Short insurance) {
        this.insurance = insurance;
    }

    public Short getGps() {
        return gps;
    }

    public void setGps(Short gps) {
        this.gps = gps;
    }

    public Short getViolationdeposit() {
        return violationdeposit;
    }

    public void setViolationdeposit(Short violationdeposit) {
        this.violationdeposit = violationdeposit;
    }

    public Short getRenewalmoney() {
        return renewalmoney;
    }

    public void setRenewalmoney(Short renewalmoney) {
        this.renewalmoney = renewalmoney;
    }

    public Short getOtherhandlingfee() {
        return otherhandlingfee;
    }

    public void setOtherhandlingfee(Short otherhandlingfee) {
        this.otherhandlingfee = otherhandlingfee;
    }

    public Short getMonthlyfee() {
        return monthlyfee;
    }

    public void setMonthlyfee(Short monthlyfee) {
        this.monthlyfee = monthlyfee;
    }

    public Boolean getIsused() {
        return isused;
    }

    public void setIsused(Boolean isused) {
        this.isused = isused;
    }

    public Short getIscurrent() {
        return iscurrent;
    }

    public void setIscurrent(Short iscurrent) {
        this.iscurrent = iscurrent;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Date getCreatedat() {
        return createdat;
    }

    public void setCreatedat(Date createdat) {
        this.createdat = createdat;
    }

    public String getCreatedbyid() {
        return createdbyid;
    }

    public void setCreatedbyid(String createdbyid) {
        this.createdbyid = createdbyid == null ? null : createdbyid.trim();
    }

    public Date getUpdatedat() {
        return updatedat;
    }

    public void setUpdatedat(Date updatedat) {
        this.updatedat = updatedat;
    }

    public String getUpdatedbyid() {
        return updatedbyid;
    }

    public void setUpdatedbyid(String updatedbyid) {
        this.updatedbyid = updatedbyid == null ? null : updatedbyid.trim();
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Date getDeletedat() {
        return deletedat;
    }

    public void setDeletedat(Date deletedat) {
        this.deletedat = deletedat;
    }

    public String getDeletedbyid() {
        return deletedbyid;
    }

    public void setDeletedbyid(String deletedbyid) {
        this.deletedbyid = deletedbyid == null ? null : deletedbyid.trim();
    }

    public String getJsonstring() {
        return jsonstring;
    }

    public void setJsonstring(String jsonstring) {
        this.jsonstring = jsonstring == null ? null : jsonstring.trim();
    }
}