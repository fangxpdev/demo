package com.beidou.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author beidou
 * @since 17/12/23
 */
@Controller
public class IndexController {

    @RequestMapping(value = "/index")
    @ResponseBody
    public String getIndex() {
        return "hello spring mvc!!!";
    }

}
