package com.example.springboot_netty.netty;

import com.example.springboot_netty.config.Config;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Netty服务器
 *
 * @author 一只小ikun
 * @date 2023/03/24
 */
@Slf4j
@Component
public class NettyServer {

    public void start(){
        EventLoopGroup boss = new NioEventLoopGroup();
        EventLoopGroup worker = new NioEventLoopGroup();
        try{
            ServerBootstrap sb = new ServerBootstrap();
            sb.group(boss, worker)
              .channel(NioServerSocketChannel.class)
              .handler(new LoggingHandler(LogLevel.DEBUG))
              .option(ChannelOption.ALLOCATOR, ByteBufAllocator.DEFAULT)
              .childHandler(new ServerInitializer());
            Channel channel = sb.bind("0.0.0.0", Config.serverPort).sync().channel();
            log.info("Netty server started on port {}", Config.serverPort);
            channel.closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            boss.shutdownGracefully();
            worker.shutdownGracefully();
        }
    }
}
