package mybatis-generator.mapper;

import mybatis-generator.entity.sys_product_operatinglog;

public interface sys_product_operatinglogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(sys_product_operatinglog record);

    int insertSelective(sys_product_operatinglog record);

    sys_product_operatinglog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(sys_product_operatinglog record);

    int updateByPrimaryKeyWithBLOBs(sys_product_operatinglog record);

    int updateByPrimaryKey(sys_product_operatinglog record);
}