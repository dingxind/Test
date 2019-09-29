package mybatis-generator.mapper;

import mybatis-generator.entity.tb_product_investorannex;

public interface tb_product_investorannexMapper {
    int deleteByPrimaryKey(Long id);

    int insert(tb_product_investorannex record);

    int insertSelective(tb_product_investorannex record);

    tb_product_investorannex selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(tb_product_investorannex record);

    int updateByPrimaryKey(tb_product_investorannex record);
}