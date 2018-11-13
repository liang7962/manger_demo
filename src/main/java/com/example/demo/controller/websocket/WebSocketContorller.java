package com.example.demo.controller.websocket;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebSocketContorller {

    /**
     * @author: jinliang
     * @create: 2018/11/13 14:24
     * @desc: 进入消息推送页面
     * @param
     **/
    @RequestMapping(value = "/websocket_test",method = RequestMethod.GET)
    public String websocketTest( ){
        return "view/webSocket/runoob_websocket";
    }


}
