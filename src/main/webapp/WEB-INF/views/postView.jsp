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

    <div class="form-group">
        <input type="button" value="수정" onclick='location.href="/post/modify/${post.bno}"'>
        <form:form action="/post/${post.bno}" method="DELETE">
            <input type="submit" value="삭제">
        </form:form>
    </div>
</div>

<div class="container">
    <form class="comment_form" action="/comment/${bno}/insert" method="get" style="width: 500px">
        <br><br>
        <div>
            <div>
                <span><strong>Comments</strong></span><span id="cno"></span>
            </div>
            <div>
                <table class="table">
                    <tr>
                        <td>
                            <textarea name="content" id="content" cols="30" rows="3" style="width: 500px"
                                      placeholder="댓글을 입력하세요"></textarea>
                            <br>
                            <div>
                                <input id="comment_submit" class="btn pull-right btn-success" type="submit" value="작성"/>
                            </div>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="hidden" name="bno" value="${post.bno}">
    </form>
</div>

<%@include file="commentS.jsp" %>

<script type="text/javascript">
    // 작성을 할 것인지 확인하도록 eventListener등록
    $('#comment_submit').on('click', function(e) {

        e.preventDefault(); // 이벤트 동작을 멈춘다.. 그리고 밑에 새로운 동작을 할 수 있다.

        commentInsert();

    });

    function commentInsert() {
        $.ajax({
            url: $('.comment_form').attr('action')
            ,type: "GET"
            ,data: {content: $('#content').val()
                ,authenticity_token: $('#csrf-token').attr('content')
            }
            ,success: function() {
                $('#content').val('')
                getCommentList();
                alert('success')
            }
            ,error: function() {
                alert('fail')
            }
        });
    };
    // $('input[type="submit"]').on('click', function (e) {
    //     var response = confirm("리스트 리로드");
    //     $.ajax({
    //         url: "/comment/list/"+$('.comment_form > input[name="bno"]').val()   //$('.comment_form').attr('action')
    //         , type: "GET"
    //         , data: {
    //             content: $('input[name="content"]').val()
    //             , authenticity_token: $('[name="csrf-token"]').attr('content')
    //         }
    //         , dataType: 'json'
    //         , contentType: "application/x-www-form-urlencoded; charset=UTF-8"
    //         , success: function () {
    //             getCommentList();
    //             // $('.comment_form > input[name="content"]').val('')
    //             alert('success')
    //         }
    //         , error: function () {
    //             alert('fail')
    //         }
    //     });
    // });

    // 작성을 할 것인지 확인하도록 eventListener등록
    // $('input[type="submit"]').on('click', function(e) {
    //     //var response = confirm("작성 하시겠습니까?");
    //     alert('작성하시겠습니까?');
    //     if (!response) {
    //         e.preventDefault(); // 이벤트 동작을 멈춘다.. 그리고 밑에 새로운 동작을 할 수 있다.
    //         // e.stopImmediatePropagation(); // elemente의 다른 모든 이벤트 중지
    //         // return false; 도 가능하지만.. return 이기 때문에 다른 작업은 못 한다.
    //     }
    // });
    // // 글자수를 확인하는 함수
    // function checkContentLen(e) {
    //     alert('글자수체크');
    //     var content = $('input[name="content"]').val();
    //     if (content.length < 1) {
    //         alert('1글자 이상 작성해 주세요');
    //         e.stopImmediatePropagation();
    //         return false;
    //     }
    // };
    // 글자수를 확인하도록 eventListener등록
    //$('input[type="submit"]').on('click', checkContentLen());

    // 매우 중요
    // ajax를 submit의 eventListener로 등록하는 작업이 글자 수를 체크하는 스크립트 아래에 작성 되어야
    // 정상적으로 글자수를 체크한다!
    // 만약 순서를 다르게 하고 싶다면 ajax를 함수로 만들어서 글자수 체크 후 실행되도록 작성해야 한다!


    // $('.delete_comment').on('click', function(e) {
    //     // 이동하지 못하도록..?
    //     e.preventDefault();
    //     $.ajax({
    //         url: this.href // event를 넘겨주는 객체에 this로 접근할 수 있다
    //         ,type: "DELETE"
    //         ,data: {authenticity_token: $('[name="csrf-token"]').attr('content')}
    //         ,dataType: "json"
    //         ,success: function() {
    //             alert("Complete to delete")
    //         }
    //         ,error: function() {
    //             alert("Fail to delete")
    //         }
    //     });
    // });
</script>
</body>
</html>