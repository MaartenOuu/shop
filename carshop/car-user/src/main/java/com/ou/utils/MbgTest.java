package com.ou.utils;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class MbgTest {
    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");

        //1. 全局配置
        GlobalConfig config = new GlobalConfig();
        //是否支持AR模式
        config.setActiveRecord(true)
                .setAuthor("Owq") //作者
                .setOutputDir(projectPath+"/src/main/java")  //生成路径
                .setFileOverride(true)//是否文件覆盖，如果多次
                .setServiceName("%sService") //设置生成的service接口名首字母是否为I
                .setIdType(IdType.AUTO) //主键策略
                .setServiceName("%sService")//设置生成的service接口的名字的首字母是否为I
                .setSwagger2(true)
                .setBaseResultMap(true)
                .setBaseColumnList(true)
                ;
        //2. 数据源配置
        DataSourceConfig dsConfig = new DataSourceConfig();
        dsConfig.setDbType(DbType.MYSQL)
                .setUrl("jdbc:mysql://localhost:3306/car_user")
                .setDriverName("com.mysql.jdbc.Driver")
                .setUsername("root")
                .setPassword("123456");
        //3.策略配置
        StrategyConfig stConfig = new StrategyConfig();
        stConfig.setCapitalMode(true) // 全局大写命名
                .setNaming(NamingStrategy.underline_to_camel) // 数据库表映射到实体的命名策略
                .setInclude("user"); //生成的表
        //4.包名策略
        PackageConfig pkConfig = new PackageConfig();
        pkConfig.setParent("com.ou")//父包名
                .setController("controller")
                .setEntity("entity")
                .setService("service")
                .setMapper("dao")
                .setXml("mapper");
        //5.整合配置
        AutoGenerator ag = new AutoGenerator().setGlobalConfig(config)
                .setDataSource(dsConfig)
                .setStrategy(stConfig)
                .setPackageInfo(pkConfig);
        ag.execute();
    }
}
