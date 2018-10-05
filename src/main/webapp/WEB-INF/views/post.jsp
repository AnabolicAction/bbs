<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
index!!!


<h3><a href="/index">Home</a></h3>
<html>
<head>
    <title> 게시글 작성</title>
</head>

<body>
<h3>게시글 작성 </h3>
<div style="padding: 30px;">
    <form action="/writePost" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        <div class="form-group">
            <label>제목</label>
            <input type="text" name="title" class="form-control">
        </div>
        <div class="form-group">
            <label>내용</label>
            <textarea name="post" class="form-control" rows="5"></textarea>
        </div>
        <input type="submit" class="btn btn-default" value="작성"/>
    </form>
</div>
</body>
</html>