package com.epam.training.smdm.war.desktop.index.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/index.html")
public class DesktopHomepageController {
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView get(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("desktop/homepage/index");
    }
}
