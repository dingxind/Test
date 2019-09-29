package com.lunz.cpfw.web.model;

import java.math.BigDecimal;

public class RegionRateModel {
    private String id;

    private String uniqueid;

    private String provincename;

    private String provincecode;

    private BigDecimal floatinginterestrates;

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
}