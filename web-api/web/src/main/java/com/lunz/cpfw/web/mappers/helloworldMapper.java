package com.lunz.cpfw.web.mappers;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.lunz.cpfw.web.entities.helloworld;

public interface helloworldMapper extends BaseMapper<helloworld> {
    helloworld queryByName(String number);
}