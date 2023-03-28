package com.example.springboot_netty.netty.handler;

import com.example.springboot_netty.utils.StringUtils;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class extendChannelInboundHandlerAdapter extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        log.info("原始数据: {}", msg);


        //获取到 16 进制字符串
        String message = StringUtils.stringToHexString((String) msg);
        log.info("16进制: {}", message);

        //调用方法从 16进制 字符串转为String消息
        String result = StringUtils.hexStringToString(message);
        log.info("16进制还原字符串: {}", result);

        log.info("====================================================================================");




//        //使用ByteBuf获取到 16 进制字符串
//        String message = StringUtils.byteBufToHexString((ByteBuf) msg);
//        log.info("16进制数据: {}", message);
//
//        //调用方法从 16进制 字符串转为String消息
//        String result = StringUtils.hexStringToString(message);
//        log.info("string: {}", result);

       super.channelRead(ctx, msg);
    }
}
