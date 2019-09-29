package com.lunz.cpfw.web.model;

import java.math.BigDecimal;
import java.util.Date;

public class InvestorListModel {
    private String id;

    private String clientid;

    private Boolean isdisable;

    private String name;

    private String contact;

    private Long contactnumber;

    private BigDecimal baseinterestrate;

    private Date createdat;

    private Boolean deleted;

    public String getId() {
        return id;
    }

    public BigDecimal getBaseinterestrate() {
        return baseinterestrate;
    }

    public void setBaseinterestrate(BigDecimal baseinterestrate) {
        this.baseinterestrate = baseinterestrate;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

    public Long getContactnumber() {
        return contactnumber;
    }

    public void setContactnumber(Long contactnumber) {
        this.contactnumber = contactnumber;
    }

    public Date getCreatedat() {
        return createdat;
    }

    public void setCreatedat(Date createdat) {
        this.createdat = createdat;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}