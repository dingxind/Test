package mybatis-generator.mapper;

import mybatis-generator.entity.tb_product_investorinfo;

public interface tb_product_investorinfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(tb_product_investorinfo record);

    int insertSelective(tb_product_investorinfo record);

    tb_product_investorinfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(tb_product_investorinfo record);

    int updateByPrimaryKey(tb_product_investorinfo record);
}