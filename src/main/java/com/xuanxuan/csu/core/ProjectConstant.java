package com.xuanxuan.csu.core;

/**
 * @author PualrDwade
 * @blog :http://120.79.206.32/
 * @Discript 项目常量配置
 */
public final class ProjectConstant {
    public static final String BASE_PACKAGE = "com.xuanxuan.csu";//生成代码所在的基础包名
    public static final String MODEL_PACKAGE = BASE_PACKAGE + ".entrys";//生成的Model所在包
    public static final String MAPPER_PACKAGE = BASE_PACKAGE + ".persistence";//生成的Mapper所在包
    public static final String SERVICE_PACKAGE = BASE_PACKAGE + ".service";//生成的Service所在包
    public static final String SERVICE_IMPL_PACKAGE = SERVICE_PACKAGE + ".impl";//生成的ServiceImpl所在包
    public static final String CONTROLLER_PACKAGE = BASE_PACKAGE + ".controller";//生成的Controller所在包
    public static final String MAPPER_INTERFACE_REFERENCE = BASE_PACKAGE + ".core.Mapper";//Mapper插件基础接口的完全限定名
}
