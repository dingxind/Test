package com.lunz.cpfw.web.entities;

import lombok.Data;

import java.util.Date;
@Data
public class tb_product_vehicletype {
    private String id;

    private Boolean isdisable;

    private String name;

    private String code;

    private Date createdat;

    private String createdbyid;

    private Date updatedat;

    private String updatedbyid;

    private Boolean deleted;

    private Date deletedat;

    private String deletedbyid;

    private String jsonstring;

}