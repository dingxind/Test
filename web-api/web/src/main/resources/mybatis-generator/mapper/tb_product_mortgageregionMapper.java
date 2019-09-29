package mybatis-generator.mapper;

import mybatis-generator.entity.tb_product_mortgageregion;

public interface tb_product_mortgageregionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(tb_product_mortgageregion record);

    int insertSelective(tb_product_mortgageregion record);

    tb_product_mortgageregion selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(tb_product_mortgageregion record);

    int updateByPrimaryKey(tb_product_mortgageregion record);
}