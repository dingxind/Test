package com.lunz.cpfw.web.mappers;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.lunz.cpfw.web.entities.tb_product_investorinfo;

import com.lunz.cpfw.web.model.ValueAndLabelModel;

public interface tb_product_investorinfoMapper extends BaseMapper<tb_product_investorinfo> {
    List<ValueAndLabelModel> selectIdAndNameList();
}