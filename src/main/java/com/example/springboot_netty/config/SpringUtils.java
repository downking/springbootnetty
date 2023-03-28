package com.example.springboot_netty.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * spring工具类
 *
 * @author 一只小ikun
 * @date 2023/03/24
 * 实现 ApplicationContextAware 接口，让当前类的方法可以获取到spring容器中的bean
 */
@Component
public class SpringUtils implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        //重写方法，把applicationContext对象提取出来
        SpringUtils.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext(){
        return applicationContext;
    }

    /*
        通过name获取bean
     */
    public static Object getBeanByName(String name){
        return getApplicationContext().getBean(name);
    }

    /*
        通过class获取bean(通过类型)
     */
    public static Object getBeanByClass(Class<?> clazz){
        return getApplicationContext().getBean(clazz);
    }
}
