package ru.efanov.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WidgedController {
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public String testController() {
        return "TEST";
    }
}
