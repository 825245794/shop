package com.shop.shop

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Controller
@EnableAutoConfiguration
class HiController {
    @RequestMapping("/login")
    String login(){
        return 'login'
    }
}
