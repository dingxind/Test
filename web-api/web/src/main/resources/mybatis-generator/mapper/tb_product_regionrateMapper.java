package mybatis-generator.mapper;

import mybatis-generator.entity.tb_product_regionrate;

public interface tb_product_regionrateMapper {
    int deleteByPrimaryKey(String id);

    int insert(tb_product_regionrate record);

    int insertSelective(tb_product_regionrate record);

    tb_product_regionrate selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(tb_product_regionrate record);

    int updateByPrimaryKey(tb_product_regionrate record);
}