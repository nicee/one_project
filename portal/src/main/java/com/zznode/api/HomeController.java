package com.zznode.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author rookie
 * @project one_project
 * @time 2018/10/22.15:34
 */
@RestController
public class HomeController {

    @GetMapping("/home")
    public String hello() {
        return new String("Hello");
    }

}
