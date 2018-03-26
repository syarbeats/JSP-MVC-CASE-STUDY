<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	<LINK REL=STYLESHEET HREF="./css/JSP-Styles.css" TYPE="text/css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
	<div class="container">
    <div class="row" style="margin-top: 100px">
        <div class="col-md-4 offset-4">
            <div class="card">
                <div class="card-header text-sm-center">Edit Article Data</div>
                <div class="card-body">
                    <form action="editArticle" type="POST">
                        <div class="row">
                            <div class="col-md-4"><label class="form-group">Article ID</label></div>
                            <div class="col-md-4"><input class="form-group" id="id" placeholder="Article Id"></div>
                        </div>
                        <div class="row">
                            <div class="col-md-4"><label class="form-group">Title</label></div>
                            <div class="col-md-4"><input class="form-group" id="title" placeholder="Title"></div>
                        </div>
                        <div class="row">
                            <div class="col-md-4"><label class="form-group">Category</label></div>
                            <div class="col-md-4"><input class="form-group" id="category" placeholder="Category"></div>
                        </div>
                        <div class="row">
                            <div class="col-md-4 offset-4"><button type="button" class="btn btn-primary" onclick="location.href='http://localhost:8080';">Save Article</button></div>
                            <div class="col-md-4" style="margin-left: 0px"><button type="button" class="btn btn-info" onclick="location.href='http://localhost:8080';">Cancel</button></div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>