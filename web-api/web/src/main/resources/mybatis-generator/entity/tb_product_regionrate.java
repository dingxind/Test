package mybatis-generator.entity;

import java.math.BigDecimal;
import java.util.Date;

public class tb_product_regionrate {
    private String id;

    private String uniqueid;

    private String clientid;

    private String provincename;

    private String provincecode;

    private BigDecimal floatinginterestrates;

    private Boolean isused;

    private Boolean iscurrent;

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

    public String getProvincename() {
        return provincename;
    }

    public void setProvincename(String provincename) {
        this.provincename = provincename == null ? null : provincename.trim();
    }

    public String getProvincecode() {
        return provincecode;
    }

    public void setProvincecode(String provincecode) {
        this.provincecode = provincecode == null ? null : provincecode.trim();
    }

    public BigDecimal getFloatinginterestrates() {
        return floatinginterestrates;
    }

    public void setFloatinginterestrates(BigDecimal floatinginterestrates) {
        this.floatinginterestrates = floatinginterestrates;
    }

    public Boolean getIsused() {
        return isused;
    }

    public void setIsused(Boolean isused) {
        this.isused = isused;
    }

    public Boolean getIscurrent() {
        return iscurrent;
    }

    public void setIscurrent(Boolean iscurrent) {
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