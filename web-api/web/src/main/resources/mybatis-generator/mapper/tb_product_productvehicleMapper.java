package mybatis-generator.mapper;

import mybatis-generator.entity.tb_product_productvehicle;

public interface tb_product_productvehicleMapper {
    int deleteByPrimaryKey(String id);

    int insert(tb_product_productvehicle record);

    int insertSelective(tb_product_productvehicle record);

    tb_product_productvehicle selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(tb_product_productvehicle record);

    int updateByPrimaryKey(tb_product_productvehicle record);
}