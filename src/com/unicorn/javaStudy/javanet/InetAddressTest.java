package com.unicorn.javaStudy.javanet;

import org.junit.jupiter.api.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * <p>
 *     IP地址在java中可以使用InetAddress对象来表示
 *     IPv4 : 由4个字节组成， 分为公网地址（万维网）和私有地址（局域网）， 私有地址范围192.168.0.0 - 192.168.255.255
 *              127.0.0.1或localhost代表本机
 *     IPv6 : 由16个字节组成，共128位， 写成8个（组）无符号整数，每个整数使用四个十六进制位表示，组之间使用冒号:分隔
 *
 *     端口号 ： 0 - 65535， 0-1023 已分配给其他互联网应用
 * </p>
 * Created on 2021/3/6.
 *
 * @author Unicorn
 */

public class InetAddressTest {

    // InetAddress静态方法
    @Test
    public void test1(){
        try {
            // 直接写ip地址
            InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
            System.out.println(inetAddress);

            InetAddress inetAddress1 = InetAddress.getByName("localhost");
            System.out.println(inetAddress1);

            // 直接写域名, 会发给DNS服务器解析出IP地址
            InetAddress inetAddress2 = InetAddress.getByName("www.baidu.com");
            System.out.println(inetAddress2);

            // 获取本机IP地址
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println(localHost);


        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    // InetAddress实例方法
    @Test
    public void test2(){
        try {

            InetAddress inetAddress2 = InetAddress.getByName("www.baidu.com");
            System.out.println(inetAddress2);   // www.baidu.com/183.232.231.174
            // getHostAddress
            System.out.println(inetAddress2.getHostAddress());  // 183.232.231.174
            // getHostName
            System.out.println(inetAddress2.getHostName());     // www.baidu.com


        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
