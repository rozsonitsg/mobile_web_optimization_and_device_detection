<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
<title>Mobile</title>
</head>
<body>
<spring:url var="desktop" value="?site_preference=normal" />
<spring:url var="mobile" value="?site_preference=mobile" />

<p>Welcome to mobile site</p>
<p>Site: <a href="${desktop}">Normal</a> | <a href="${mobile}">Mobile</a></p>

<%@ include file="/WEB-INF/jsp/common/preview/preview.jspf"%>

</body>
</html>