package com.example.demo.controller.websocket;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebSocketContorller {


    @RequestMapping(value = "/websocket_test",method = RequestMethod.GET)
    public String websocketTest( ){
        return "websocket_demo";
    }


}
