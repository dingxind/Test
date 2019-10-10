/**
 * Copyright (C), 2015-2019,
 * FileName: CodeGenerator
 * Author:   Administrator
 * Date:     2019/10/9 0009 8:40
 * Description: 代码生成器
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.example.demo;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.lunz.cpfw.DemoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class CodeGenerator {
    @Test
    public void genCode() {

        AutoGenerator mpg = new AutoGenerator();

        //全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("dxd");
        gc.setOpen(false);//是否打开资源管理器
        gc.setFileOverride(false); // 生成的文件是否覆盖
        gc.setServiceName("%sService"); // 生成Service接口方法的名称
        gc.setIdType(IdType.ID_WORKER_STR); // id策略
        gc.setDateType(DateType.ONLY_DATE);
        gc.setSwagger2(true); //实体属性 Swagger2 注解
        mpg.setGlobalConfig(gc);


        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://rm-bp1oydriw2vi7fc68qo.mysql.rds.aliyuncs.com/fin_productcenter?useSSL=false&allowMultiQueries=true&useUnicode=true&characterEncoding=utf8");
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("user_fin");
        dsc.setPassword("Lunz2017");
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);


        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName("cpfw");
        pc.setParent("com.lunz");
        pc.setController("controller");
        pc.setEntity("entity");
        pc.setMapper("mapper");
        pc.setService("service");
        mpg.setPackageInfo(pc);


        // 策略配置
        StrategyConfig strategy = new StrategyConfig();

        strategy.setInclude("tb_product"+"_\\w*");//表名
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setTablePrefix(pc.getModuleName() + "_");

        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);

        strategy.setLogicDeleteFieldName("deleted");
        strategy.setEntityBooleanColumnRemoveIsPrefix(true);
        TableFill createdAt = new TableFill("createdAt", FieldFill.INSERT);
        TableFill updatedAt = new TableFill("updatedAt", FieldFill.INSERT_UPDATE);
        ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(createdAt);
        tableFills.add(updatedAt);
        strategy.setTableFillList(tableFills);
        strategy.setVersionFieldName("version");
        strategy.setRestControllerStyle(true);
        // 公共父类
//        strategy.setSuperControllerClass("com.lunz.cpfw.web.controllers.BaseV1Controller.java");
        mpg.setStrategy(strategy);

        mpg.execute();

    }


}
