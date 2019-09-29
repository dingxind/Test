package com.lunz.cpfw.core.interaction;

import java.io.Serializable;

public class PagingFilter implements Serializable {

    private static final long serialVersionUID = 1L;

    private String field;
    private String op;
    private String term;

    public void setField(String field) {
        this.field = field;
    }

    public String getField() {
        return this.field;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public String getOp() {
        return this.op;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getTerm() {
        return this.term;
    }
}