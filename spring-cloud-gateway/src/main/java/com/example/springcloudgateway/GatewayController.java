package com.example.springcloudgateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fallback")
public class GatewayController {
    @GetMapping("/wordCounterFallback")
    public String getDefaultFallback(){
        return "Couldn't reach wordCounter service";
    }
}
