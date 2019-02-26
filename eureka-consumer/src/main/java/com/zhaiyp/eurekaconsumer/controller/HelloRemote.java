package com.zhaiyp.eurekaconsumer.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Auther: Administrator
 * @Date: 2019/2/25 17:31
 * @Description:
 */
@FeignClient(name = "eureka-producer", fallback = HelloRemoteHystrix.class)
public interface HelloRemote {

    @RequestMapping(value = "/hello")
    String hello(@RequestParam(value = "name") String name);

    @RequestMapping(value = "/hello2")
    String hello2(@RequestParam(value = "name") String name);
}
