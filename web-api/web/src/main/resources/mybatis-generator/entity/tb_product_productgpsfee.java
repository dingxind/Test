package mybatis-generator.entity;

import java.math.BigDecimal;
import java.util.Date;

public class tb_product_productgpsfee {
    private String id;

    private String productid;

    private Short isleaseperiod;

    private Integer startvalue;

    private Integer endvalue;

    private Short calculationrules;

    private Short rulename;

    private BigDecimal rulevalue;

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

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid == null ? null : productid.trim();
    }

    public Short getIsleaseperiod() {
        return isleaseperiod;
    }

    public void setIsleaseperiod(Short isleaseperiod) {
        this.isleaseperiod = isleaseperiod;
    }

    public Integer getStartvalue() {
        return startvalue;
    }

    public void setStartvalue(Integer startvalue) {
        this.startvalue = startvalue;
    }

    public Integer getEndvalue() {
        return endvalue;
    }

    public void setEndvalue(Integer endvalue) {
        this.endvalue = endvalue;
    }

    public Short getCalculationrules() {
        return calculationrules;
    }

    public void setCalculationrules(Short calculationrules) {
        this.calculationrules = calculationrules;
    }

    public Short getRulename() {
        return rulename;
    }

    public void setRulename(Short rulename) {
        this.rulename = rulename;
    }

    public BigDecimal getRulevalue() {
        return rulevalue;
    }

    public void setRulevalue(BigDecimal rulevalue) {
        this.rulevalue = rulevalue;
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