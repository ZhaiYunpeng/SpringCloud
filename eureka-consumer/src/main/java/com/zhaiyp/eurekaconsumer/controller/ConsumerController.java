package com.zhaiyp.eurekaconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: Administrator
 * @Date: 2019/2/25 17:33
 * @Description:
 */
@RestController
public class ConsumerController {
    @Autowired
    private HelloRemote helloRemote;

    @RequestMapping(value = "/hello/{name}")
    private String index(@PathVariable("name")String name){
        return helloRemote.hello(name);
    }
    @RequestMapping(value = "/hello2/{name}")
    private String index2(@PathVariable("name")String name){
        return helloRemote.hello2(name);
    }

}
