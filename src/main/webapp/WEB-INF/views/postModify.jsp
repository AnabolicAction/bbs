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

    <h4 style="float: right;">${modify.user.id} 님이 로그인 되었습니다.</h4>
    <title>게시글 수정</title>
</head>
<body>
<h3>게시글 수정</h3>
<div style="padding: 30px">
    <form:form commandName="post" action="/post/modify/${modify.bno}" method="PUT">
        <div class="form-group">
            <label>제목 : </label>
            <input type="text" name="title" value="${modify.title}" class="form-control">
        </div>

        <div class="form-group">
            <label>작성자 : </label>
            <span>${modify.user.id} (${modify.user.gender})</span>
        </div>

        <div class="form-group">
            <label>작성날짜 : </label>
            <span>${modify.upDate}</span>
        </div>

        <div class="form-group">
            <label>조회수</label>
            <span>${modify.hit}</span>
        </div>

        <div class="form-group">
            <label>내용 : </label>
            <textarea name="post" class="form-control" rows="5">${modify.post}</textarea>
        </div>
        <button type="submit" class="bun btn-default">수정</button>
    </form:form>
</div>

</body>
</html>
