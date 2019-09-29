package mybatis-generator.mapper;

import mybatis-generator.entity.tb_product_productregion;

public interface tb_product_productregionMapper {
    int deleteByPrimaryKey(String id);

    int insert(tb_product_productregion record);

    int insertSelective(tb_product_productregion record);

    tb_product_productregion selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(tb_product_productregion record);

    int updateByPrimaryKey(tb_product_productregion record);
}