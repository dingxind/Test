package mybatis-generator.mapper;

import mybatis-generator.entity.tb_product_vehicletype;

public interface tb_product_vehicletypeMapper {
    int deleteByPrimaryKey(String id);

    int insert(tb_product_vehicletype record);

    int insertSelective(tb_product_vehicletype record);

    tb_product_vehicletype selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(tb_product_vehicletype record);

    int updateByPrimaryKey(tb_product_vehicletype record);
}