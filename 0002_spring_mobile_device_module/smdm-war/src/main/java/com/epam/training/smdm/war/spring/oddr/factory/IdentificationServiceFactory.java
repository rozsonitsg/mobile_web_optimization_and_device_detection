package com.epam.training.smdm.war.spring.oddr.factory;

import java.io.IOException;
import java.util.Properties;

import org.openddr.simpleapi.oddr.ODDRService;
import org.w3c.ddr.simple.ServiceFactory;
import org.w3c.ddr.simple.exception.InitializationException;
import org.w3c.ddr.simple.exception.NameException;

public class IdentificationServiceFactory {
    private static final String ORG_OPENDDR_SIMPLEAPI_ODDR_ODDR_SERVICE = "org.openddr.simpleapi.oddr.ODDRService";

    private String configurationLocation;

    public org.w3c.ddr.simple.Service createIdentificationService() throws IOException, InitializationException, NameException {
        Properties initializationProperties = new Properties();
        initializationProperties.load(getClass().getResourceAsStream(configurationLocation));
        return ServiceFactory.newService(ORG_OPENDDR_SIMPLEAPI_ODDR_ODDR_SERVICE, initializationProperties.getProperty(ODDRService.ODDR_VOCABULARY_IRI), initializationProperties);
    }

    public void setConfigurationLocation(String configurationLocation) {
        this.configurationLocation = configurationLocation;
    }
}
