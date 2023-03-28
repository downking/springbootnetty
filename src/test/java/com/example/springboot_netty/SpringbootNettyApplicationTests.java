package com.example.springboot_netty;

import com.example.springboot_netty.config.Config;
import com.example.springboot_netty.utils.StringUtils;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

@SpringBootTest
@RunWith(SpringRunner.class)
class SpringbootNettyApplicationTests {
    @Value("${netty.server.port}")
    public String serverPort;

    @Test
    void contextLoads() {
        System.out.println(serverPort);
        System.out.println(Config.serverPort);
    }

    /*
        测试Server是否能正确接收消息
     */
    @Test
    public void socket(){
        try {
            Socket socket = new Socket("z28800z238.goho.co", 44399);
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("你好,世界".getBytes());
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /*
        测试StringUtil中的方法
     */
    @Test
    public void testStringUtil(){
        for (int i = 0; i < 10; i++) {
            String str = "你好,世界" + i;
            System.out.println("原始数据: " + str);

            String hexString = StringUtils.stringToHexString(str);
            System.out.println("16进制数据: " + hexString);

            String result = StringUtils.hexStringToString(hexString);
            System.out.println("转换后的数据: " + result);

            System.out.println("============================================");
        }
    }

}























