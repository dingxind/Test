package com.lunz.cpfw.web.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import io.lettuce.core.dynamic.annotation.Param;

@Mapper
public interface CommonMapper {
    String GeneratorKey(String idName);

    @Select("select count(*) from tb_product_client a where exists (select * from tb_product_client b where a.Id = b.Id and b.Id = #{clientId})")
    int HasClient(@Param("clientId") String clientId);
}