<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ include file="mainHeader.jsp" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Re:dogs 投稿</title>
<link rel="icon" type="image/x-icon" href="img/favicon.JPG">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/submissionDetail.css">
</head>
<body>
	<h1>Re:dogs</h1>
	<h2>投稿</h2>
		<div class="submission">
			<form action="Submission" method="post">
				<c:forEach var="item" items="${submissionData}" varStatus="sts">
					<div>
				        <span class="title"><c:out value="${item.title}" /></span>
				        <span class="createDate">投稿日&nbsp;<c:out value="${item.createDate}" /></span>
				    </div>
				    <div>
				    	<c:out value="${item.article}" />
				    </div>
				    <div>
				    	<img src="data:image/png;base64,${item.fileData64}" />
				    </div>
				    <br>
				    <br>
				</c:forEach>

			</form>
		</div>
</body>
</html>