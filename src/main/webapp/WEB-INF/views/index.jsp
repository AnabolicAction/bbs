<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<h3><a href="/index">Home</a></h3>

<html>
<head>
    <title>게시글 목록</title>

</head>
<body>


<h3>게시글 목록</h3>
<button class="btn btn-primary" style="float: right;"
        onclick="location.href='/post'">작성</button>
<table class="table">
    <tr>
        <th>No</th>
        <th>제목</th>
        <th>작성자</th>
        <th>작성날짜</th>
        <th>조회수</th>
    </tr>
    <%--${list}--%>
    <c:forEach var="post" items="${list}">
        <tr>
            <td>${post.bno}</td>
            <td><a href="/post/${post.bno}">${post.title}</a></td>
            <td>${post.user.id}</td>
            <td><fmt:formatDate value="${post.regDate}" pattern="yyyy/MM/dd" /></td>
            <td>${post.hit}</td>
        </tr>
    </c:forEach>


</table>

</body>

</html>
