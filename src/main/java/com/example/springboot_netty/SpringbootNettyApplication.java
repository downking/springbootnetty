package com.example.springboot_netty;

import com.example.springboot_netty.netty.NettyServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/*
    springboot 启动程序
 */
@SpringBootApplication
public class SpringbootNettyApplication /* extends WebMvcConfigurationSupport */{

    public static void main(String[] args) {
        /*
            以web方式启动,会启动两个端口,可以继承WebMvcConfigurationSupport类实现web的一些管控
         */
        ApplicationContext ctx = SpringApplication.run(SpringbootNettyApplication.class, args);

        /*
            以非web方式启动,只会启动一个端口,还可以使用springboot中的一些功能
            不可以继承 WebMvcConfigurationSupport 类,因为这种启动方式就不是一个web程序
         */
//        ApplicationContext ctx = new SpringApplicationBuilder(SpringbootNettyApplication.class)
//                .web(WebApplicationType.NONE).run(args);

        //获取NettyServer对象
        NettyServer nettyServer = ctx.getBean(NettyServer.class);
        nettyServer.start();
    }
}
