package mybatis-generator.mapper;

import mybatis-generator.entity.tb_product_allannex;

public interface tb_product_allannexMapper {
    int deleteByPrimaryKey(Long id);

    int insert(tb_product_allannex record);

    int insertSelective(tb_product_allannex record);

    tb_product_allannex selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(tb_product_allannex record);

    int updateByPrimaryKey(tb_product_allannex record);
}