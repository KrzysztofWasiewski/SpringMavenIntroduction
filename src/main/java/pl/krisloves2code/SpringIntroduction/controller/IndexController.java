package pl.krisloves2code.SpringIntroduction.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/index")
public class IndexController {


    @GetMapping
    public ModelAndView page() {
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }
}