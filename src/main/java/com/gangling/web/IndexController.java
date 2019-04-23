package com.gangling.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * created by liufeng
 * 2018/8/21
 */
@Controller
public class IndexController {
    private static final Logger logger=LoggerFactory.getLogger(IndexController.class);

    @RequestMapping("/index")
    public String indexJsp()  {
        logger.error("index error-log test");
        logger.info("index info-log test");
        return "index";
    }

    @RequestMapping("/json")
    @ResponseBody
    public String json(){
        int a=0;
        int b=1/a;
        return "qqq";
    }

    @RequestMapping("/error")
    @ResponseBody
    public String error(){
        int a=0;
        int b=1/a;
        return "qqq";
    }
}
