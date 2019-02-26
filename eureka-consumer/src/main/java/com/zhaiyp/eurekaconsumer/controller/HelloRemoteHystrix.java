package com.zhaiyp.eurekaconsumer.controller;

import org.springframework.stereotype.Component;

/**
 * @Auther: Administrator
 * @Date: 2019/2/26 13:40
 * @Description:
 */
@Component
public class HelloRemoteHystrix implements HelloRemote {
    @Override
    public String hello(String name) {
        return "Hello " + name + ",message send failed!";
    }
    @Override
    public String hello2(String name) {
        return "Hello2 " + name + ",message send failed!";
    }
}
