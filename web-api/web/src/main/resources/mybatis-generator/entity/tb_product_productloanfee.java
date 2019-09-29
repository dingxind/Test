package mybatis-generator.entity;

import java.math.BigDecimal;
import java.util.Date;

public class tb_product_productloanfee {
    private String id;

    private String productid;

    private Short type;

    private Short isinterval;

    private BigDecimal startvalue;

    private BigDecimal endvalue;

    private BigDecimal floatinginterestrates;

    private BigDecimal floatingrates;

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

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public Short getIsinterval() {
        return isinterval;
    }

    public void setIsinterval(Short isinterval) {
        this.isinterval = isinterval;
    }

    public BigDecimal getStartvalue() {
        return startvalue;
    }

    public void setStartvalue(BigDecimal startvalue) {
        this.startvalue = startvalue;
    }

    public BigDecimal getEndvalue() {
        return endvalue;
    }

    public void setEndvalue(BigDecimal endvalue) {
        this.endvalue = endvalue;
    }

    public BigDecimal getFloatinginterestrates() {
        return floatinginterestrates;
    }

    public void setFloatinginterestrates(BigDecimal floatinginterestrates) {
        this.floatinginterestrates = floatinginterestrates;
    }

    public BigDecimal getFloatingrates() {
        return floatingrates;
    }

    public void setFloatingrates(BigDecimal floatingrates) {
        this.floatingrates = floatingrates;
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