package com.boot.mvc20220916nk.web.controller.api;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ResponseBodyController {

    // Logger

    Logger logger = LoggerFactory.getLogger(getClass());

    @ResponseBody
    @GetMapping("/api/text")
    public String textGetReq(@RequestParam("value") String value, @RequestParam int num) {
        return "파라미터 값: " + value + "," + num;
    }

    @ResponseBody
    @GetMapping("/api/text")
    public String textPostReq(@RequestParam String name, int age) {

        return "name" + "age";
    }

    @ResponseBody
    @GetMapping("/api/text")
    public String textPutReq(@RequestParam String name, int age) {

        return "name" + "age";
    }

    @ResponseBody
    @GetMapping("/api/text")
    public String textDeleteReq(@RequestParam String name, int age) {

        return "name" + "age";
    }


}
