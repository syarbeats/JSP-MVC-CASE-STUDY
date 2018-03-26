<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	<LINK REL=STYLESHEET HREF="./css/JSP-Styles.css" TYPE="text/css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<br>
	<div class="row" style="margin-top: 30px">
    	<div class="col-md-6 offset-5">
        	<nav class="navbar navbar-light bd-faded">
            	<h2><label class="alert-primary text-sm-center">CUSTOMER LIST</label></h2>
            </nav>
        </div>

    </div>
	<table BORDER=5 ALIGN="CENTER">
	<tr>
		<th CLASS="TITLE">ID</th>
		<th CLASS="TITLE">TITLE</th>
		<th CLASS="TITLE">CATEGORY</th>
	</tr>
	
	<c:forEach items="${articles}" var="article">
	<tr>
	    <td>${article.articleId}</td>
	    <td>${article.title}</td>
	    <td>${article.category}</td>
	</tr>
	</c:forEach>
	
	</table>
</body>
</html>