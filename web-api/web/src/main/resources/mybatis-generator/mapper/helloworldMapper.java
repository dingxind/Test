package mybatis-generator.mapper;

import mybatis-generator.entity.helloworld;

public interface helloworldMapper {
    int insert(helloworld record);

    int insertSelective(helloworld record);
}