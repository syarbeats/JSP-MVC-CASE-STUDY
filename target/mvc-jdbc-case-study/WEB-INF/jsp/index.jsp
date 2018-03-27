<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    
</head>
<body>

        <div class="container">
            <div class="row" style="margin-top: 30px">
                <div class="col-md-6 offset-4">
                    <nav class="navbar navbar-light bd-faded">
                        <h2><label class="alert-primary text-sm-center">JSP MVC JDBC CASE STUDY</label></h2>
                    </nav>
                </div>

            </div>
            <div class="row" style="margin-top: 100px">
                <div class="col-md-4 offset-3">
                    <div class="btn-toolbar justify-content-between" role="toolbar" aria-label="Toolbar with button groups">
                        <div class="btn-group" role="group" aria-label="First group">
                            <button type="button" class="btn btn-secondary" onclick="location.href='http://localhost:8080/mvc-jdbc-case-study/displayArticles';">Show All Article</button>
                            <button type="button" class="btn btn-info" onclick="location.href='http://localhost:8080/mvc-jdbc-case-study/edit-article.jsp';">Update Article</button>
                            <button type="button" class="btn btn-danger" onclick="location.href='http://localhost:8080/mvc-jdbc-case-study/deleteArticle';">Delete Article</button>
                            <button type="button" class="btn btn-dark" onclick="location.href='http://localhost:8080/mvc-jdbc-case-study/addArticle';">Insert Article</button>
                            <button type="button" class="btn btn-primary" onclick="location.href='http://localhost:8080/mvc-jdbc-case-study/searchArticleById';">Search Article By Id</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
</body>
</html>