package com.zhaiyp.eurekaproducer.controller;

import com.sun.media.jfxmedia.logging.Logger;
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
        System.out.println("This second producer!");
        return "Welcome "+name + ",This second producer!";
    }
}
