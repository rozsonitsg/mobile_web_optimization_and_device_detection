package com.epam.training.smdm.war.spring.oddr.device;

import java.io.Serializable;

import org.springframework.mobile.device.Device;

@SuppressWarnings("serial")
public class ODDRDevice implements Device, Serializable {
    private String id;
    private String vendor;
    private String model;
    private Integer displayWidth;
    private Integer displayHeight;
    private String version;
    private String[] inputDevices;
    private Boolean cookieSupport;
    private String[] imageFormatSupport;
    private String[] inputModeSupport;
    private String[] stylesheetSupport;
    private String[] markupSupport;
    private String[] scriptSupport;
    private String mobileBrowser;
    private String deviceOs;
    private Integer nokiaSeries;
    private String mobileBrowserVersion;
    private Boolean tabletDevice;
    private Integer nokiaEdition;
    private String deviceOsVersion;
    private Boolean wirelessDevice;
    private String marketingName;
    private Boolean xhtmlFormatAsAttribute;
    private Boolean xhtmlFormatAsCssProperty;
    private Boolean ajaxSupportGetElementById;
    private Boolean ajaxSupportEventListener;
    private Boolean ajaxManipulateDom;
    private Boolean ajaxSupportJavascript;
    private Boolean ajaxSupportInnerHtml;
    private Boolean ajaxManipulateCss;
    private Boolean ajaxSupportEvents;
    private Boolean dualOrientation;
    private Boolean imageInlining;
    private String from;

    @Override
    public boolean isNormal() {
        return (wirelessDevice == null || !wirelessDevice) && (tabletDevice == null || !tabletDevice);
    }

    @Override
    public boolean isMobile() {
        return (wirelessDevice != null && wirelessDevice) && (tabletDevice == null || !tabletDevice);
    }

    @Override
    public boolean isTablet() {
        return (wirelessDevice != null && wirelessDevice) && (tabletDevice != null || tabletDevice);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getDisplayWidth() {
        return displayWidth;
    }

    public void setDisplayWidth(Integer displayWidth) {
        this.displayWidth = displayWidth;
    }

    public Integer getDisplayHeight() {
        return displayHeight;
    }

    public void setDisplayHeight(Integer displayHeight) {
        this.displayHeight = displayHeight;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String[] getInputDevices() {
        return inputDevices;
    }

    public void setInputDevices(String[] inputDevices) {
        this.inputDevices = inputDevices;
    }

    public Boolean getCookieSupport() {
        return cookieSupport;
    }

    public void setCookieSupport(Boolean cookieSupport) {
        this.cookieSupport = cookieSupport;
    }

    public String[] getImageFormatSupport() {
        return imageFormatSupport;
    }

    public void setImageFormatSupport(String[] imageFormatSupport) {
        this.imageFormatSupport = imageFormatSupport;
    }

    public String[] getInputModeSupport() {
        return inputModeSupport;
    }

    public void setInputModeSupport(String[] inputModeSupport) {
        this.inputModeSupport = inputModeSupport;
    }

    public String[] getStylesheetSupport() {
        return stylesheetSupport;
    }

    public void setStylesheetSupport(String[] stylesheetSupport) {
        this.stylesheetSupport = stylesheetSupport;
    }

    public String[] getMarkupSupport() {
        return markupSupport;
    }

    public void setMarkupSupport(String[] markupSupport) {
        this.markupSupport = markupSupport;
    }

    public String[] getScriptSupport() {
        return scriptSupport;
    }

    public void setScriptSupport(String[] scriptSupport) {
        this.scriptSupport = scriptSupport;
    }

    public String getMobileBrowser() {
        return mobileBrowser;
    }

    public void setMobileBrowser(String mobileBrowser) {
        this.mobileBrowser = mobileBrowser;
    }

    public String getDeviceOs() {
        return deviceOs;
    }

    public void setDeviceOs(String deviceOs) {
        this.deviceOs = deviceOs;
    }

    public Integer getNokiaSeries() {
        return nokiaSeries;
    }

    public void setNokiaSeries(Integer nokiaSeries) {
        this.nokiaSeries = nokiaSeries;
    }

    public String getMobileBrowserVersion() {
        return mobileBrowserVersion;
    }

    public void setMobileBrowserVersion(String mobileBrowserVersion) {
        this.mobileBrowserVersion = mobileBrowserVersion;
    }

    public Boolean getTabletDevice() {
        return tabletDevice;
    }

    public void setTabletDevice(Boolean tabletDevice) {
        this.tabletDevice = tabletDevice;
    }

    public Integer getNokiaEdition() {
        return nokiaEdition;
    }

    public void setNokiaEdition(Integer nokiaEdition) {
        this.nokiaEdition = nokiaEdition;
    }

    public String getDeviceOsVersion() {
        return deviceOsVersion;
    }

    public void setDeviceOsVersion(String deviceOsVersion) {
        this.deviceOsVersion = deviceOsVersion;
    }

    public Boolean getWirelessDevice() {
        return wirelessDevice;
    }

    public void setWirelessDevice(Boolean wirelessDevice) {
        this.wirelessDevice = wirelessDevice;
    }

    public String getMarketingName() {
        return marketingName;
    }

    public void setMarketingName(String marketingName) {
        this.marketingName = marketingName;
    }

    public Boolean getXhtmlFormatAsAttribute() {
        return xhtmlFormatAsAttribute;
    }

    public void setXhtmlFormatAsAttribute(Boolean xhtmlFormatAsAttribute) {
        this.xhtmlFormatAsAttribute = xhtmlFormatAsAttribute;
    }

    public Boolean getXhtmlFormatAsCssProperty() {
        return xhtmlFormatAsCssProperty;
    }

    public void setXhtmlFormatAsCssProperty(Boolean xhtmlFormatAsCssProperty) {
        this.xhtmlFormatAsCssProperty = xhtmlFormatAsCssProperty;
    }

    public Boolean getAjaxSupportGetElementById() {
        return ajaxSupportGetElementById;
    }

    public void setAjaxSupportGetElementById(Boolean ajaxSupportGetElementById) {
        this.ajaxSupportGetElementById = ajaxSupportGetElementById;
    }

    public Boolean getAjaxSupportEventListener() {
        return ajaxSupportEventListener;
    }

    public void setAjaxSupportEventListener(Boolean ajaxSupportEventListener) {
        this.ajaxSupportEventListener = ajaxSupportEventListener;
    }

    public Boolean getAjaxManipulateDom() {
        return ajaxManipulateDom;
    }

    public void setAjaxManipulateDom(Boolean ajaxManipulateDom) {
        this.ajaxManipulateDom = ajaxManipulateDom;
    }

    public Boolean getAjaxSupportJavascript() {
        return ajaxSupportJavascript;
    }

    public void setAjaxSupportJavascript(Boolean ajaxSupportJavascript) {
        this.ajaxSupportJavascript = ajaxSupportJavascript;
    }

    public Boolean getAjaxSupportInnerHtml() {
        return ajaxSupportInnerHtml;
    }

    public void setAjaxSupportInnerHtml(Boolean ajaxSupportInnerHtml) {
        this.ajaxSupportInnerHtml = ajaxSupportInnerHtml;
    }

    public Boolean getAjaxManipulateCss() {
        return ajaxManipulateCss;
    }

    public void setAjaxManipulateCss(Boolean ajaxManipulateCss) {
        this.ajaxManipulateCss = ajaxManipulateCss;
    }

    public Boolean getAjaxSupportEvents() {
        return ajaxSupportEvents;
    }

    public void setAjaxSupportEvents(Boolean ajaxSupportEvents) {
        this.ajaxSupportEvents = ajaxSupportEvents;
    }

    public Boolean getDualOrientation() {
        return dualOrientation;
    }

    public void setDualOrientation(Boolean dualOrientation) {
        this.dualOrientation = dualOrientation;
    }

    public Boolean getImageInlining() {
        return imageInlining;
    }

    public void setImageInlining(Boolean imageInlining) {
        this.imageInlining = imageInlining;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }
}
