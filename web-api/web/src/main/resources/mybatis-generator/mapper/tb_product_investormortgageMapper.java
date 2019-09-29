package mybatis-generator.mapper;

import mybatis-generator.entity.tb_product_investormortgage;

public interface tb_product_investormortgageMapper {
    int deleteByPrimaryKey(String id);

    int insert(tb_product_investormortgage record);

    int insertSelective(tb_product_investormortgage record);

    tb_product_investormortgage selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(tb_product_investormortgage record);

    int updateByPrimaryKey(tb_product_investormortgage record);
}