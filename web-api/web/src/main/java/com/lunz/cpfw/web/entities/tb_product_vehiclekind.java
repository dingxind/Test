package com.lunz.cpfw.web.entities;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.baomidou.mybatisplus.enums.FieldFill;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
@Data
public class tb_product_vehiclekind {

    private String id;

    private String uniqueid;

    private String clientid;

    private Boolean isdisable;

    private String name;

    private String type;

    private BigDecimal positiverentbaseinterestrate;

    private BigDecimal leasebackbaseinterestrate;

    private Boolean isused;

    private Boolean iscurrent;

    private Integer version;

    @TableField(fill = FieldFill.INSERT)
    private Date createdat;

    private String createdbyid;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updatedat;

    private String updatedbyid;

    @TableLogic
    private Boolean deleted;

    private Date deletedat;

    private String deletedbyid;

    private String jsonstring;

//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id == null ? null : id.trim();
//    }
//
//    public String getUniqueid() {
//        return uniqueid;
//    }
//
//    public void setUniqueid(String uniqueid) {
//        this.uniqueid = uniqueid == null ? null : uniqueid.trim();
//    }
//
//    public String getClientid() {
//        return clientid;
//    }
//
//    public void setClientid(String clientid) {
//        this.clientid = clientid == null ? null : clientid.trim();
//    }
//
//    public Boolean getIsdisable() {
//        return isdisable;
//    }
//
//    public void setIsdisable(Boolean isdisable) {
//        this.isdisable = isdisable;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name == null ? null : name.trim();
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type == null ? null : type.trim();
//    }
//
//    public BigDecimal getPositiverentbaseinterestrate() {
//        return positiverentbaseinterestrate;
//    }
//
//    public void setPositiverentbaseinterestrate(BigDecimal positiverentbaseinterestrate) {
//        this.positiverentbaseinterestrate = positiverentbaseinterestrate;
//    }
//
//    public BigDecimal getLeasebackbaseinterestrate() {
//        return leasebackbaseinterestrate;
//    }
//
//    public void setLeasebackbaseinterestrate(BigDecimal leasebackbaseinterestrate) {
//        this.leasebackbaseinterestrate = leasebackbaseinterestrate;
//    }
//
//    public Boolean getIsused() {
//        return isused;
//    }
//
//    public void setIsused(Boolean isused) {
//        this.isused = isused;
//    }
//
//    public Boolean getIscurrent() {
//        return iscurrent;
//    }
//
//    public void setIscurrent(Boolean iscurrent) {
//        this.iscurrent = iscurrent;
//    }
//
//    public Integer getVersion() {
//        return version;
//    }
//
//    public void setVersion(Integer version) {
//        this.version = version;
//    }
//
//    public Date getCreatedat() {
//        return createdat;
//    }
//
//    public void setCreatedat(Date createdat) {
//        this.createdat = createdat;
//    }
//
//    public String getCreatedbyid() {
//        return createdbyid;
//    }
//
//    public void setCreatedbyid(String createdbyid) {
//        this.createdbyid = createdbyid == null ? null : createdbyid.trim();
//    }
//
//    public Date getUpdatedat() {
//        return updatedat;
//    }
//
//    public void setUpdatedat(Date updatedat) {
//        this.updatedat = updatedat;
//    }
//
//    public String getUpdatedbyid() {
//        return updatedbyid;
//    }
//
//    public void setUpdatedbyid(String updatedbyid) {
//        this.updatedbyid = updatedbyid == null ? null : updatedbyid.trim();
//    }
//
//    public Boolean getDeleted() {
//        return deleted;
//    }
//
//    public void setDeleted(Boolean deleted) {
//        this.deleted = deleted;
//    }
//
//    public Date getDeletedat() {
//        return deletedat;
//    }
//
//    public void setDeletedat(Date deletedat) {
//        this.deletedat = deletedat;
//    }
//
//    public String getDeletedbyid() {
//        return deletedbyid;
//    }
//
//    public void setDeletedbyid(String deletedbyid) {
//        this.deletedbyid = deletedbyid == null ? null : deletedbyid.trim();
//    }
//
//    public String getJsonstring() {
//        return jsonstring;
//    }
//
//    public void setJsonstring(String jsonstring) {
//        this.jsonstring = jsonstring == null ? null : jsonstring.trim();
//    }

}