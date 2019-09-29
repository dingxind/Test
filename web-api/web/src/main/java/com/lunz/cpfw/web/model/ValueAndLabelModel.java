package com.lunz.cpfw.web.model;

public class ValueAndLabelModel {
    private String value;

    private String label;

    public String getValue() {
        return value;
    }

    public void setId(String value) {
        this.value = value == null ? null : value.trim();
    }

    public String getLabel() {
        return label;
    }

    public void setName(String label) {
        this.label = label == null ? null : label.trim();
    }
}