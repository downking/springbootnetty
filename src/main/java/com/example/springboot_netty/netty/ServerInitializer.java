package com.example.springboot_netty.netty;

import com.example.springboot_netty.netty.handler.extendChannelInboundHandlerAdapter;
import com.example.springboot_netty.utils.StringUtils;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.*;
import io.netty.handler.codec.string.StringDecoder;
import lombok.extern.slf4j.Slf4j;


/**
 * 服务器初始化
 *
 * @author 一只小ikun
 * @date 2023/03/23
 */
@Slf4j
public class ServerInitializer extends ChannelInitializer {
    @Override
    protected void initChannel(Channel ch) throws Exception {
//        ChannelPipeline pipeline = ch.pipeline();
//        pipeline.addLast(new LoggingHandler());
        ch.pipeline().addLast("decoder", new StringDecoder());

        ch.pipeline().addLast(new extendChannelInboundHandlerAdapter());
    }
}
