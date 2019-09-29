package mybatis-generator.mapper;

import mybatis-generator.entity.tb_product_productloanfee;

public interface tb_product_productloanfeeMapper {
    int deleteByPrimaryKey(String id);

    int insert(tb_product_productloanfee record);

    int insertSelective(tb_product_productloanfee record);

    tb_product_productloanfee selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(tb_product_productloanfee record);

    int updateByPrimaryKey(tb_product_productloanfee record);
}