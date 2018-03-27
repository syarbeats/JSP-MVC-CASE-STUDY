<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Article</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="row" style="margin-top: 30px">
			<div class="col-md-6 offset-4">
				<nav class="navbar navbar-light bd-faded">
				<h2>
					<label class="alert-primary text-sm-center">JSP MVC JDBC
						CASE STUDY</label>
				</h2>
				<a href=""></a> </nav>
			</div>
		</div>

		<div class="row" style="margin-top: 10px">
			<div class="col-md-6 offset-3">
				<form action="http://localhost:8080/mvc-jdbc-case-study/searchArticleById" method="post">
					<div class="input-group">
						<span class="input-group-btn"> <input
							class="btn btn-secondary" type="submit" value="Search Article" />
						</span> <input type="text" name="articleId" class="form-control"
							placeholder="Insert Article Id.">
					</div>
				</form>
			</div>
		</div>

		<div class="row" style="margin-top: 30px">
			<div class="col-md-12">
				<table BORDER=1 ALIGN="CENTER" class="table">
					<thead class="thead-dark">
					<tr>
						<th CLASS="TITLE">ID</th>
						<th CLASS="TITLE">TITLE</th>
						<th CLASS="TITLE">CATEGORY</th>
						<th CLASS="TITLE"></th>
					</tr>
					</thead>
					<tbody>
					<tr>
						<td>${article.articleId}</td>
						<td>${article.title}</td>
						<td>${article.category}</td>
						<td><a class="btn btn-info"
							href="http://localhost:8080/mvc-jdbc-case-study/editArticle?articleId=${article.articleId}&title=${article.title}&category=${article.category}">Edit</a>
							<a class="btn btn-danger"
							href="http://localhost:8080/mvc-jdbc-case-study/deleteArticle?articleId=${article.articleId}">Delete</a></td>
					</tr>
					</tbody>
				</table>
			</div>
		</div>

		<div class="row" style="margin-top: 100px">
			<div class="col-md-6 offset-3">
				<div class="btn-toolbar justify-content-between" role="toolbar"
					aria-label="Toolbar with button groups">
					<div class="btn-group" role="group" aria-label="First group">
						<button type="button" class="btn btn-secondary"
							onclick="location.href='http://localhost:8080/mvc-jdbc-case-study/displayArticles';">Show
							All Article</button>
						<button type="button" class="btn btn-info"
							onclick="location.href='http://localhost:8080/mvc-jdbc-case-study/edit-article.jsp';">Update
							Article</button>
						<button type="button" class="btn btn-danger"
							onclick="location.href='http://localhost:8080/mvc-jdbc-case-study/search';">Delete
							Article</button>
						<button type="button" class="btn btn-dark"
							onclick="location.href='http://localhost:8080/mvc-jdbc-case-study/addArticle';">Insert
							Article</button>
						<button type="button" class="btn btn-primary"
							onclick="location.href='http://localhost:8080/mvc-jdbc-case-study/search';">Search
							Article By Id</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>