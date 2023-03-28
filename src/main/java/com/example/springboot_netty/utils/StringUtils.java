package com.example.springboot_netty.utils;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;

public class StringUtils {
    /*
        16进制字符串直接转换成为汉字
     */
    public static String hexStringToString(String hexStr) {
        String str = "0123456789ABCDEF";
        char[] hexs = hexStr.toCharArray();
        byte[] bytes = new byte[hexStr.length() / 2]; //1个byte数值 -> 两个16进制字符
        int n;
        for (int i = 0; i < bytes.length; i++) {
            n = str.indexOf(hexs[2 * i]) * 16;
            n += str.indexOf(hexs[2 * i + 1]);
            bytes[i] = (byte) (n & 0xff);
        }
        return new String(bytes);
    }

    /*
        字符串转为16进制字符串
     */
    public static String stringToHexString(String msg) {
        // 解决16进制编解码问题
        String message = "";
        byte[] bytebuf=((String) msg).getBytes();
        // 此解码为解决 16进制在超过79的情况乱码问题
        for(int i = 0, len = bytebuf.length; i < len; i ++) {
            String hex =  Integer.toHexString(bytebuf[i] & 0xff).toUpperCase();
            message += hex.length()  == 1 ? "0" + hex : hex;
        }
        return message;
    }

    /*
        ByteBuf对象转为 16 进制字符串
     */

    
    public static String byteBufToHexString(ByteBuf buf){
        byte[] bytes = ByteBufUtil.getBytes(buf);
        String msg = new String(bytes, 0, bytes.length);
        return stringToHexString(msg);
    }
}
