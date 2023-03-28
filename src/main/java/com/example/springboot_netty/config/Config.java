package com.example.springboot_netty.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 配置
 *
 * @author 一只小ikun
 * @date 2023/03/24
 */
@Component
public class Config {

    public static int serverPort;

    @Value("${netty.server.port}")
    public void setServerPort(int port) {
        serverPort = port;
    }

}
