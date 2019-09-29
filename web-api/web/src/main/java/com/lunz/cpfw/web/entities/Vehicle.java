package com.lunz.cpfw.web.entities;

import java.math.BigDecimal;
import java.util.List;

public class Vehicle {

    private String id;

    private String name;

    private List<String> list;

    private BigDecimal positiverentbaseinterestrate;

    private BigDecimal leasebackbaseinterestrate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public BigDecimal getPositiverentbaseinterestrate() {
        return positiverentbaseinterestrate;
    }

    public void setPositiverentbaseinterestrate(BigDecimal positiverentbaseinterestrate) {
        this.positiverentbaseinterestrate = positiverentbaseinterestrate;
    }

    public BigDecimal getLeasebackbaseinterestrate() {
        return leasebackbaseinterestrate;
    }

    public void setLeasebackbaseinterestrate(BigDecimal leasebackbaseinterestrate) {
        this.leasebackbaseinterestrate = leasebackbaseinterestrate;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", list=" + list +
                ", positiverentbaseinterestrate=" + positiverentbaseinterestrate +
                ", leasebackbaseinterestrate=" + leasebackbaseinterestrate +
                '}';
    }
}
