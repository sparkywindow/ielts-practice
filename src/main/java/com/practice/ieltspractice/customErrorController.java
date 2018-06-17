package com.practice.ieltspractice;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;

public class customErrorController implements ErrorController {
    @Override
    public String getErrorPath() {
        return "error-test";
    }

    @GetMapping("/error")
    public String error(){
        return "error-test";
    }
}
