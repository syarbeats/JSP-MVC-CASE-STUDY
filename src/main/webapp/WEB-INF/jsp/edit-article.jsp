<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<LINK REL=STYLESHEET HREF="./css/JSP-Styles.css" TYPE="text/css">
<link rel="stylesheet" href="./css/bootstrap.min.css">
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
				</nav>
			</div>

		</div>

		<div class="row" style="margin-top: 100px">
			<div class="col-md-4 offset-4">
				<div class="card">
					<div class="card-header text-sm-center">Edit Article Data</div>
					<div class="card-body">
						<form
							action="http://localhost:8080/mvc-jdbc-case-study/saveArticle"
							method="POST">
							<div class="row">
								<div class="col-md-4">
									<label class="form-group">Article ID</label>
								</div>
								<div class="col-md-4">
									<input class="form-group" id="id" name="articleId"
										value="${article.articleId}">
								</div>
							</div>
							<div class="row">
								<div class="col-md-4">
									<label class="form-group">Title</label>
								</div>
								<div class="col-md-4">
									<input class="form-group" id="title" name="title"
										value="${article.title}">
								</div>
							</div>
							<div class="row">
								<div class="col-md-4">
									<label class="form-group">Category</label>
								</div>
								<div class="col-md-4">
									<input class="form-group" id="category" name="category"
										value="${article.category}">
								</div>
							</div>
							<div class="row">
								<div class="col-md-4 offset-4">
									<input type="submit" class="btn btn-primary"
										value="Save Article" />
								</div>
								<div class="col-md-4" style="margin-left: 0px">
									<input type="reset" class="btn btn-info" value="Cancel" />
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<div class="row" style="margin-top: 100px">
			<div class="col-md-4 offset-3">
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