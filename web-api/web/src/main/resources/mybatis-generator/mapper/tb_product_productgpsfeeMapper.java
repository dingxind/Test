package mybatis-generator.mapper;

import mybatis-generator.entity.tb_product_productgpsfee;

public interface tb_product_productgpsfeeMapper {
    int deleteByPrimaryKey(String id);

    int insert(tb_product_productgpsfee record);

    int insertSelective(tb_product_productgpsfee record);

    tb_product_productgpsfee selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(tb_product_productgpsfee record);

    int updateByPrimaryKey(tb_product_productgpsfee record);
}