<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
index!!!


<a href="/index">index</a>
<a href="/post">post</a>
<a href="/login">login</a>
<html>
<head>
<title> 게시글 목록</title>


</head>
<body>
<h3>게시글 목록 </h3>
<button class="btn btn-primary" style="float: right;" onclick="location.href='/post'">작성</button>
<table class="table">
    <tr>
        <th>No</th>
        <th>제목</th>
        <th>작성자</th>
        <th>작성날짜</th>
        <th>조회수</th>
    </tr>
    ${list}
<%--<c:forEach var="post" items="list">--%>
    <%--<tr>--%>
        <%--<td>${post.bno}</td>--%>
        <%--&lt;%&ndash;<td><a href="/index/${post.bno}">${post.title}</a> ddd</td>&ndash;%&gt;--%>
        <%--&lt;%&ndash;<td>${post.memberId}</td>&ndash;%&gt;--%>
        <%--&lt;%&ndash;<td><fmt:formatDate value="${post.reg_date}" pattern="MM/dd"/></td>&ndash;%&gt;--%>
        <%--&lt;%&ndash;<td>${post.hit}</td>&ndash;%&gt;--%>
    <%--</tr>--%>
<%--</c:forEach>--%>
</table>

</body>

</html>
