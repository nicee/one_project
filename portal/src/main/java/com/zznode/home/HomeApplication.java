package com.zznode.home;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author jianli.xiao
 * @project one_project
 * @time 2018/10/22.15:32
 */
@SpringBootApplication
@ComponentScan("com.zznode.api")
public class HomeApplication {

    public static void main(String[] args) {
        SpringApplication.run(HomeApplication.class, args);
    }

}
