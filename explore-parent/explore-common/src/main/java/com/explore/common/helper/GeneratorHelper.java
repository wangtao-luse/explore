package com.explore.common.helper;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.ConstVal;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class GeneratorHelper {
private static final String MODULE_MEMBER_SERVICE="explore-member-service";
private static final String MODULE_MEMBER_SERVICE_PACKAGEPREFIX="member";	
	public static void main(String[] args) {
		String moduleName = GeneratorHelper.MODULE_MEMBER_SERVICE;
		String moudelPrefix = GeneratorHelper.MODULE_MEMBER_SERVICE_PACKAGEPREFIX;
		String author ="wwangtaoc11@gamil.com";
		String[] tablePrefix =  new String [] {"t_m"};
		String[] tableNames = new String[] {
				"t_m_member","T_M_OAUTH","t_m_right_detail","t_m_role_right","t_m_group_role","t_m_member_group",
				"T_M_GROUP","T_M_PERSON","T_M_BUSINESS"
				};
		         tableNames = new String[] {"t_m_member_Oauth_view"};
		         tableNames = new String[] {"T_M_GROUP","T_M_ROLE"};
		boolean view = false;//是否为视图
		generatorCode(tablePrefix, tableNames, moduleName, moudelPrefix, author,view);
	}
private static void generatorCode(String[] tablePrefix,String[]tableNames,String mouduleName,String moudelPrefix,String author,boolean view ) {
	
	Properties properties = setProperties(mouduleName,moudelPrefix,view);
	properties.setProperty("author", author);
	AutoGenerator mpg = new AutoGenerator();
	 mpg.setGlobalConfig(globalConfig(properties));
	 mpg.setDataSource(dataSourceConfig(properties));
	 mpg.setPackageInfo(packageConfig(properties));
	 mpg.setStrategy(strategyConfig(tablePrefix, tableNames, properties));
	 
	 mpg.execute();
}
private static Properties setProperties(String module,String packageprefix,boolean view) {
	Properties properties = new Properties();	
	//全局配置
	
	properties.setProperty("activeRecord", "0");//是否支持AR模式  (1:表示支持;默认不支持;0:表示不支持)
	properties.setProperty("author", "wwangtaoc11@gmail.com");//作者
	properties.setProperty("fileOverride","1" );//是否覆盖已有文件(1:表示覆盖;默认不覆盖;0:表示不覆盖)
	properties.setProperty("baseColumnList","1" );//开启 baseColumnList(1:表示开启;默认不开启;0:表示不开启)
	properties.setProperty("baseResultMap","1" );//开启 BaseResultMap(1:表示开启;默认不开启;0:表示不开启)
	properties.setProperty("swagger2","1" );//开启 swagger2 模式(1:表示开启;默认不开启;0:表示不开启)
	properties.setProperty("idType","auto" );//指定生成的主键的ID类：auto:数据库ID自增
	properties.setProperty("outputDir", "d://mybataiplus.com");
	//数据源配置
	properties.setProperty("url","jdbc:mysql://1.116.226.147:3306/member?serverTimezone=UTC&useSSL=false" );//驱动连接的URL
	properties.setProperty("driverName","com.mysql.cj.jdbc.Driver" );//驱动名称
	properties.setProperty("username","root" );//驱动名称
	properties.setProperty("password","mysql@958958" );//驱动名称
	properties.setProperty("dbType","mysql" );//数据库类型 
	
	//包配置
	String absolutePath = System.getProperty("user.dir");
	String base = new File(absolutePath).getParent();
	String mod = module.substring(0, module.lastIndexOf("-"));//explore-member-service-->explore-member
	String modPrefix = module.substring(0, module.indexOf("-"));//explore-member-service-->explore
	
	// /explore-model/src/main/java/com/explore/model/member
	String entity_path = base+File.separator+modPrefix+"-model/src/main/java/com/"+modPrefix+"/model/"+packageprefix+(view==true?"/vo":"");
	// /explore-member-persist/src/main/java/com.explore.member
	String mapper_path = base+File.separator+mod+"-persist/src/main/java/com/"+modPrefix+"/"+packageprefix+"/persist";
	// /explore-member-persist/src/main/resources/mapping
	String xml_path = base+File.separator+mod+"-persist/src/main/resources/mapping";
	// /explore-member-service/src/main/java/com/explore/member/service
	String SERVICE_IMPL_PATH = base+File.separator+mod+"-service/src/main/java/com/"+modPrefix+"/"+packageprefix+"/service";
	
	properties.setProperty("parent","com."+modPrefix );//父包名
	properties.setProperty("mapper",packageprefix+".persist" );//Mapper包名
	properties.setProperty("entity","model."+packageprefix+(view==true?".vo":"") );//实体类包名
	properties.setProperty("serviceImpl",packageprefix+".service" );
	properties.setProperty("service","");
	properties.setProperty("xml","mapping");
	
	properties.setProperty("entity_path", entity_path);
	properties.setProperty("mapper_path",mapper_path );
	properties.setProperty("xml_path",xml_path);
	properties.setProperty("SERVICE_PATH","" );
	properties.setProperty("SERVICE_IMPL_PATH",SERVICE_IMPL_PATH );
	properties.setProperty("pathInfo","1" );//1:表示之间生成文件到项目;0:表示将文件生成到指定目录
	//策略配置
	properties.setProperty("naming","underline_to_camel" );//表名生成策略
	properties.setProperty("columnNaming","underline_to_camel" );//数据库列映射到实体类的命名策略
	return properties;
	
}

private static StrategyConfig  strategyConfig (String[] tablePrefix,String[] tableNames,Properties poreties) {
	StrategyConfig strategy = new StrategyConfig();	  
       strategy.setTablePrefix(tablePrefix);// 此处可以修改为您的表前缀
       strategy.setInclude(tableNames); // 需要生成的表
       if ("underline_to_camel".equals(poreties.getProperty("naming", "no_change"))) {
    	   strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略  
       }
       if ("underline_to_camel".equals(poreties.getProperty("columnNaming", "no_change"))) {
    	   strategy.setColumnNaming(NamingStrategy.underline_to_camel);//数据库列映射到实体类的命名策略
       }
      
	return strategy;
	
}
private static PackageConfig packageConfig(Properties properties) {
	PackageConfig pc = new PackageConfig();
	pc.setParent(properties.getProperty("parent"));    
    pc.setMapper(properties.getProperty("mapper"));
    pc.setXml(properties.getProperty("xml"));
    pc.setServiceImpl(properties.getProperty("serviceImpl"));
    pc.setEntity(properties.getProperty("entity"));
    pc.setService(properties.getProperty("service",""));
    if("1".equals(properties.getProperty("pathInfo"))) {
    	 //设置自定义输出目录（分布式项目使用）
        Map<String, String> pathInfo = new HashMap<>();  
    	pathInfo.put(ConstVal.ENTITY_PATH, properties.getProperty("entity_path"));
    	pathInfo.put(ConstVal.MAPPER_PATH, properties.getProperty("mapper_path"));
    	pathInfo.put(ConstVal.XML_PATH, properties.getProperty("xml_path"));
    	pathInfo.put(ConstVal.SERVICE_PATH, properties.getProperty("SERVICE_PATH"));
        pathInfo.put(ConstVal.SERVICE_IMPL_PATH, properties.getProperty("SERVICE_IMPL_PATH"));
        pc.setPathInfo(pathInfo);
    }
   
	return pc;
	
}
private static DataSourceConfig dataSourceConfig(Properties properties) {
	DataSourceConfig dsc = new DataSourceConfig();
    dsc.setUrl(properties.getProperty("url"));
    dsc.setDriverName(properties.getProperty("driverName"));
    dsc.setUsername(properties.getProperty("username"));
    dsc.setPassword(properties.getProperty("password"));
    if("mysql".equals(properties.getOrDefault("dbType", "mysql"))) {
    	dsc.setDbType(DbType.MYSQL);	
    }

	return dsc;
}
private static GlobalConfig globalConfig(Properties properties) {
	 //1. 全局配置
    GlobalConfig config = new GlobalConfig();
    // 是否支持AR模式    
    if("1".equals(properties.getProperty("activeRecord", "0"))) {
    	config.setActiveRecord(true);
    } 
    // 文件覆盖
    if("1".equals(properties.getProperty("fileOverride", "0"))){
    	 config.setFileOverride(true);
    }  
    //开启 baseColumnList
    if("1".equals(properties.getProperty("baseColumnList", "0"))){
    	config.setBaseColumnList(true);
    }  
   //生成基本的resultMap
    if("1".equals(properties.getProperty("baseResultMap", "0"))){
    	config.setBaseResultMap(true);
    } 
    //开启 swagger2 模式
    if("1".equals(properties.getProperty("swagger2", "0"))){
    	config.setSwagger2(true);
    }  
    if("auto".equals(properties.getProperty("idType", "auto"))){
    	config.setIdType(IdType.AUTO);
    }  
    if("0".equals(properties.getProperty("pathInfo"))) {
    	 config.setOutputDir(properties.getProperty("outputDir"));
    }  
    // 作者
    config .setAuthor(properties.getProperty("author")); 
    //自定义文件命名，注意 %s 会自动填充表实体属性！
    config.setMapperName("%sMapper");
    config.setXmlName("%sMapper");
    config.setServiceName("%sService");
    config.setServiceImplName("%sService");
    config.setControllerName("%sController");
   
      
return config;
       

}



}
