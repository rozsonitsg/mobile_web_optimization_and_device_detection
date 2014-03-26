package com.epam.training.smdm.war.mobile.index.controller;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.site.SitePreference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.epam.training.smdm.war.desktop.index.controller.DesktopHomepageController;

@Controller
@RequestMapping("/mobile/index.html")
public class MobileHomepageController {
    private static final Logger LOGGER = Logger.getLogger(DesktopHomepageController.class.getCanonicalName());

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView get(Device device, SitePreference sitePreference, HttpServletRequest request, HttpServletResponse response) {
        LOGGER.info(String.format("Device: %s", device));
        LOGGER.info(String.format("Site preference: %s", sitePreference));
        return new ModelAndView("mobile/homepage/index");
    }
}
