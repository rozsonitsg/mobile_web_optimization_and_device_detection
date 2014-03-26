package com.epam.training.smdm.war.spring.oddr.resolver;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.openddr.simpleapi.oddr.model.ODDRHTTPEvidence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.w3c.ddr.simple.Evidence;
import org.w3c.ddr.simple.PropertyRef;
import org.w3c.ddr.simple.PropertyValue;
import org.w3c.ddr.simple.PropertyValues;
import org.w3c.ddr.simple.exception.InitializationException;
import org.w3c.ddr.simple.exception.NameException;
import org.w3c.ddr.simple.exception.ValueException;

import com.epam.training.smdm.war.spring.oddr.device.ODDRDevice;
import com.epam.training.smdm.war.spring.oddr.factory.IdentificationServiceFactory;

@Service("oddrUserAgentResolver")
public class ODDRUserAgentResolver {
    private static final String USER_AGENT = "User-Agent";

    private org.w3c.ddr.simple.Service identificationService;

    @Autowired
    private IdentificationServiceFactory identificationServiceFactory;

    @Resource(name = "oddrDevicePropertyMappings")
    private Map<String, String> propertyMappings;

    private Map<PropertyRef, String> propertyRefMappings;

    @PostConstruct
    public void postConstruct() throws InitializationException, NameException, IOException {
        identificationService = createIdentificationService();
        propertyRefMappings = createPropertyRefMappings(identificationService, propertyMappings);
    }

    public Device resolve(String userAgent) {
        Assert.notNull(userAgent);

        ODDRDevice device = new ODDRDevice();

        PropertyRef[] propertyRefs = propertyRefMappings.keySet().toArray(new PropertyRef[]{});
        Evidence evidence = new ODDRHTTPEvidence();
        evidence.put(USER_AGENT, userAgent);

        try {
            PropertyValues propertyValues = identificationService.getPropertyValues(evidence, propertyRefs);
    
            for (Map.Entry<PropertyRef, String> propertyMapping : propertyRefMappings.entrySet()) {
                PropertyValue propertyValue = propertyValues.getValue(propertyMapping.getKey());
                if(propertyValue.exists()) {
                    try {
                        Class<?> propertyType = PropertyUtils.getPropertyType(device, propertyMapping.getValue());
                        if(propertyType.isAssignableFrom(Boolean.class)) {
                            BeanUtils.setProperty(device, propertyMapping.getValue(), propertyValue.getBoolean());
                        } else if(propertyType.isAssignableFrom(Double.class)) {
                            BeanUtils.setProperty(device, propertyMapping.getValue(), propertyValue.getDouble());
                        } else if(propertyType.isAssignableFrom(String[].class)) {
                            BeanUtils.setProperty(device, propertyMapping.getValue(), propertyValue.getEnumeration());
                        } else if(propertyType.isAssignableFrom(Float.class)) {
                            BeanUtils.setProperty(device, propertyMapping.getValue(), propertyValue.getFloat());
                        } else if(propertyType.isAssignableFrom(Integer.class)) {
                            BeanUtils.setProperty(device, propertyMapping.getValue(), propertyValue.getInteger());
                        } else if(propertyType.isAssignableFrom(Long.class)) {
                            BeanUtils.setProperty(device, propertyMapping.getValue(), propertyValue.getLong());
                        } else if(propertyType.isAssignableFrom(String.class)) {
                            BeanUtils.setProperty(device, propertyMapping.getValue(), propertyValue.getString());
                        }
                    } catch (IllegalAccessException ex) {
                        throw new IllegalStateException(ex);
                    } catch (InvocationTargetException ex) {
                        throw new IllegalStateException(ex);
                    } catch (ValueException ex) {
                        throw new IllegalStateException(ex);
                    } catch (NoSuchMethodException ex) {
                        throw new IllegalStateException(ex);
                    }
                }
            }
        } catch (NameException ex) {
            throw new IllegalStateException(ex);
        }

        return device;
    }


    private Map<PropertyRef, String> createPropertyRefMappings(org.w3c.ddr.simple.Service identificationService, Map<String, String> propertyMappings) throws NameException {
        Assert.notNull(identificationService);
        Assert.notNull(propertyMappings);
        Map<PropertyRef, String> propertyRefMappings = new LinkedHashMap<PropertyRef, String>();
        for (Map.Entry<String, String> propertyMapping : propertyMappings.entrySet()) {
            propertyRefMappings.put(identificationService.newPropertyRef(propertyMapping.getKey()), propertyMapping.getValue());
        }
        return propertyRefMappings;
    }

    private org.w3c.ddr.simple.Service createIdentificationService() throws IOException, InitializationException, NameException {
        return identificationServiceFactory.createIdentificationService();
    }

    public void setPropertyMappings(Map<String, String> propertyMappings) {
        this.propertyMappings = propertyMappings;
    }
}
