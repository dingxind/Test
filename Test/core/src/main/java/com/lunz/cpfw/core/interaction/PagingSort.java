package com.lunz.cpfw.core.interaction;

import java.io.Serializable;

public class PagingSort implements Serializable {

    private static final long serialVersionUID = 1L;

    private String field;
    private String sort;
    private String sortOrder;

    public void setField(String field) {
        this.field = field;
    }

    public String getField() {
        return this.field;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getSort() {
        return this.sort;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getSortOrder() {
        return this.sortOrder;
    }
}