package com.shop.shop

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@EnableAutoConfiguration
class HiController {
    @RequestMapping("hi")
    String index(){
        return 'I am Groovy！！！'
    }
}
