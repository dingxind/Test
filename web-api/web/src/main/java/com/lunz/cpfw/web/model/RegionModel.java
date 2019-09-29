package com.lunz.cpfw.web.model;

public class RegionModel {
    private String regionid;

    private String label;

    private String value;

    public String getRegionid() {
        return regionid;
    }

    public void setRegionid(String regionid) {
        this.regionid = regionid == null ? null : regionid.trim();
    }

    public String getLabel() {
        return label;
    }

    public void setLable(String label) {
        this.label = label == null ? null : label.trim();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }
}