package com.lunz.cpfw.web.model;

public class RegionRateSearchModel {

    private String provincecode;

    public String getProvincecode() {
        return provincecode;
    }

    public void setProvincecode(String provincecode) {
        this.provincecode = provincecode == null ? null : provincecode.trim();
    }
}