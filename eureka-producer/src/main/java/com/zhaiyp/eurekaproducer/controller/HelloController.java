package com.zhaiyp.eurekaproducer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: Administrator
 * @Date: 2019/2/23 14:20
 * @Description:
 */
@RestController
public class HelloController {

    @RequestMapping(value = "/hello")
    String HelloTest(@RequestParam String name){
        System.out.println("This first producer!");
        return "Welcome "+name + ",This first producer!";
    }
    @RequestMapping(value = "/hello2")
    String HelloTest2(@RequestParam String name){
        System.out.println("HelloTest2,This first producer!");
        return "Welcome "+name + ",This first producer!HelloTest2!";
    }
}
