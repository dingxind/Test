package mybatis-generator.mapper;

import mybatis-generator.entity.tb_product_vehiclekind;

public interface tb_product_vehiclekindMapper {
    int deleteByPrimaryKey(String id);

    int insert(tb_product_vehiclekind record);

    int insertSelective(tb_product_vehiclekind record);

    tb_product_vehiclekind selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(tb_product_vehiclekind record);

    int updateByPrimaryKey(tb_product_vehiclekind record);
}