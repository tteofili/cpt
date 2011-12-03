<?xml version="1.0" encoding="UTF-8" ?>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="./css/primary.css" />
<meta http-equiv="Refresh" content="10;url=indexAdmin.jsp" />  
<title>Cybion - Operazione confermata</title>
</head>
<body>
<div id="header"><jsp:include page="header.jsp"></jsp:include></div>
<div id="title">
<h3>Operazione confermata</h3>
</div>


<div><h6> Redirect automatico in 10 secondi oppure <a class="generic" href="indexAdmin.jsp"> Torna alla home </a></h6></div>  
<h4><c:out value="${message}" escapeXml="false"/></h4>
</body>

<div id="footer"><h6>Cybion - monitoraggio dati</h6></div>
</html>