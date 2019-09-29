package mybatis-generator.mapper;

import mybatis-generator.entity.tb_product_productotherfee;

public interface tb_product_productotherfeeMapper {
    int deleteByPrimaryKey(String id);

    int insert(tb_product_productotherfee record);

    int insertSelective(tb_product_productotherfee record);

    tb_product_productotherfee selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(tb_product_productotherfee record);

    int updateByPrimaryKey(tb_product_productotherfee record);
}