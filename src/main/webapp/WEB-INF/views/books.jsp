<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<link href="${ pageContext.request.contextPath }/resources/css/bootstrap.min.css" rel="stylesheet">
<meta charset="UTF-8">
<title>Welcome to BookMarket</title>
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
			<h1 class="display-3">도서 목록</h1>
		</div>
	</div>

	<div class="container">
		<div class="row" align="center">
			<c:forEach items="${ bookList }" var="book">
				<div class="col -md-4">
					<h3>${ book.name }</h3>
					<p><img src=${ pageContext.request.contextPath }/resources/img/${ book.imgPath } /></p>
					<p>저자 : ${ book.author } 
						<br> 출판 : ${ book.publisher }
						<br> 분류 : ${ book.category } | 발매일 : ${ book.releaseDate }
					<p align=left>${fn:substring(book.description,0 , 60)}...
					<p> ${ book.unitPrice } 원 | 재고 : ${ book.unitsInStock } 권
					<p> ${ book.condition }
					
					<p><a href="<c:url value="/books/book?id=${ book.bookId }"/>" class="btn btn-secondary" role="buton">상세 보기 &raquo;</a>
				</div>
			</c:forEach>
		</div>
	</div>

	<footer class="container">
		<hr>
		<p>&copy; Book</p>
	</footer>

</body>
</html>