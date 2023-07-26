<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<link href="${ pageContext.request.contextPath }/resources/css/bootstrap.min.css" rel="stylesheet">
	<meta charset="UTF-8">
	<title>Book</title>
</head>
	<body>
		<nav class="navbar navbar-expand navbar-dark bg-dark">
			<div class="container">
				<div class="navbar-header">
					<a class="navbar-brand" href="./home">Home</a> <a
						class="navbar-brand" href="./all">도서 목록</a> <a class="navbar-brand"
						href="./home">쇼핑몰</a>
				</div>
			</div>
		</nav>
	
		<div class="jumbotron">
			<div class="container">
				<h1 class="display-3">도서 정보</h1>
			</div>
		</div>
		<div class="container">
			<div class="row">
				<div class="co -md-12">
					<h3>${ book.name }</h3>
					<p>${ book.description }
					<p><b>도서코드 : </b><span class="badge badge-info">${ book.bookId }</span>
					<p><b>저   자 : </b>${ book.author }
					<p><b>출 판 사 : </b>${ book.publisher }
					<p><b>분   류 : </b>${ book.category }
					<p><b>출판날짜 : </b>${ book.releaseDate }
					<p><b>재   고 : </b>${ book.unitsInStock }
					<h4>${ book.unitPrice }원</h4>
					<br />
					<p><a href="#" class="btn btn-primary">도서주문 &raquo;</a>
					<a href="<c:url value="/books"/>"class="btn btn-secondary">도서 목록 &raquo;</a>
				</div>
			</div>
		</div>
	</body>
</html>