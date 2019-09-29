package com.lunz.cpfw.web.entities;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class tb_product_mortgageregion {
    private Integer id;

    private String investorid;

    private String mortgageid;

    private String provincename;

    private String provincecode;

    private Date createdat;

    private String createdbyid;
 
    private Date updatedat;

    private String updatedbyid;

    private Boolean deleted;

    private Date deletedat;

    private String deletedbyid;

    @JSONField(serialize = false)
    private String jsonstring;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInvestorid() {
        return investorid;
    }

    public void setInvestorid(String investorid) {
        this.investorid = investorid == null ? null : investorid.trim();
    }

    public String getMortgageid() {
        return mortgageid;
    }

    public void setMortgageid(String mortgageid) {
        this.mortgageid = mortgageid == null ? null : mortgageid.trim();
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