package mybatis-generator.mapper;

import mybatis-generator.entity.tb_product_productinfo;

public interface tb_product_productinfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(tb_product_productinfo record);

    int insertSelective(tb_product_productinfo record);

    tb_product_productinfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(tb_product_productinfo record);

    int updateByPrimaryKey(tb_product_productinfo record);
}