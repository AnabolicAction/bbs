<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
index!!!

<h3><a href="/index">Home</a></h3>
<html>
<head>
    <title>게시글 목록</title>

    <h4 style="float: right;">${post.user.id} 님이 로그인 되었습니다.</h4>
    <title>게시글 상세보기</title>
</head>
<body>
<h3>게시글 상세보기</h3>
<div style="padding: 30px">
    <div class="form-group">
        <label>제목 : </label> <span>${post.title}</span>
    </div>

    <div class="form-group">
        <label>작성자 : </label> <span>${post.user.id} (${post.user.gender})</span>
    </div>

    <div class="form-group">
        <label>작성날짜 : </label> <span>${post.regDate}</span>
    </div>

    <div class="form-group">
        <label>조회수</label> <span>${post.hit}</span>
    </div>

    <div class="form-group">
        <label>내용 : </label>
        <span>${post.post}</span>
    </div>

    <div class="form-group" style="float: right;">
        <input type="button" value="수정" onclick='location.href="/post/modify/${post.bno}"'>
        <form:form action="/post/${post.bno}" method="DELETE">
            <input type="submit" value="삭제">
        </form:form>
    </div>
</div>

<%@include file="commentS.jsp" %>
</body>
</html>
