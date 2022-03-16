package com.dlu.cdmanage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

@SpringBootApplication
@Controller
public class CdManageApplication {

    public static void main(String[] args) {
        SpringApplication.run(CdManageApplication.class, args);
    }

}
