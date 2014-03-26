package com.epam.training.smdm.war.spring.oddr.resolver;

import javax.servlet.http.HttpServletRequest;

import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.DeviceResolver;

public class ODDRDeviceResolver implements DeviceResolver {
    private static final String USER_AGENT = "User-Agent";

    private ODDRUserAgentResolver userAgentResolver;

    @Override
    public Device resolveDevice(HttpServletRequest request) {
        return userAgentResolver.resolve(request.getHeader(USER_AGENT));
    }

    public void setUserAgentResolver(ODDRUserAgentResolver userAgentResolver) {
        this.userAgentResolver = userAgentResolver;
    }

}
