<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<link href="${ pageContext.request.contextPath }/resources/css/bootstrap.min.css" rel="stylesheet">
<meta charset="UTF-8">
<title>Add Book Page</title>
</head>
<body>
	<nav class="navbar navbar-expand navbar-dark bg-dark">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="./home">Home</a> <a
					class="navbar-brand" href="./home">게시판</a> <a class="navbar-brand"
					href="./home">쇼핑몰</a>
			</div>
		</div>
	</nav>

	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">도서 등록</h1>
		</div>
	</div>

	<div class="container">
		<form:form modelAttribute="NewBook" class="form-horizontal" method="post">
			<fieldset>
			<legend>${ addTitle }</legend>
			<div class="form-group row">
				<label class="col-sm-2 control-label">도서 코드</label>
				<div class="col -sm-3">
					<form:input path="bookId" class="form-control" />
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2 control-label">도서 제목</label>
				<div class="col -sm-3">
					<form:input path="name" class="form-control" />
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2 control-label">도서 가격</label>
				<div class="col -sm-3">
					<form:input path="unitPrice" class="form-control" />
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2 control-label">도서 저자</label>
				<div class="col -sm-3">
					<form:input path="author" class="form-control" />
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2 control-label">상세 설명</label>
				<div class="col -sm-3">
					<form:textarea path="description" cols="50" rows="2" class="form-control"></form:textarea>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2 control-label">도서 출판</label>
				<div class="col -sm-3">
					<form:input path="publisher" class="form-control" />
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2 control-label">도서 분류</label>
				<div class="col -sm-3">
					<form:input path="category" class="form-control" />
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2 control-label">재고 현황</label>
				<div class="col -sm-3">
					<form:input path="unitsInStock" class="form-control" />
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2 control-label">출판 년월</label>
				<div class="col -sm-3">
					<form:input path="releaseDate" class="form-control" />
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2 control-label">도서 상태</label>
				<div class="col -sm-3">
					<form:radiobutton path="condition" value="new" /> new
					<form:radiobutton path="condition" value="old" /> old
					<form:radiobutton path="condition" value="e-Book" /> e-Book
				</div>
			</div>
			<div class="form-group row">
				<div class="col -sm-offset-2 col -sm-10">
					<input type="submit" class="btn btn-primary" value="등록" />
				</div>
			</div>
			</fieldset>
		</form:form>
	</div>

	<footer class="container">
		<hr>
		<p>&copy; BookMarket</p>
	</footer>
</body>
</html>