<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="plate" value="quizcollector"/>
<!DOCTYPE html>
<html lang="zh-cn">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>欢迎来到Utunan</title>
    <link rel="stylesheet" href="/css/common.css">
    <link rel="stylesheet" href="/css/user/quizcollector.css">
    <link rel="stylesheet" href="/css/user/usercommon.css">
    <link rel="shortcut icon" href="/images/common/favicon.ico" type="image/x-icon">
</head>

<body>
<%@include file="../common/header.jsp" %>
<%@include file="common/usercard.jsp" %>
<div class="container" style="margin-top: 30px;">
    <div class="wrapper background">
        <%@include file="common/userfunction.jsp" %>
        <div class="content">
            <div class="title"><span>问答收藏</span></div>
            <nav class="postlist">
                <c:forEach items="${Quizzes }" var="Q">
                    <li>
                        <div class="posttop">

                        <span>
                            <img src="/images/user/qzc.svg"/>
                            <a href="">${Q.quizTitle }</a>
                        </span>
                        </span>
                            <span class="delete"><a href="/user/quizcollector/${Q.quizId}"><img
                                    src="/images/user/qzcdelete.svg"/></a></span>
                        </div>
                    </li>
                </c:forEach>

            </nav>
            <%@include file="common/page.jsp" %>
        </div>
    </div>
</div>
<%@include file="../common/footer.jsp" %>
</body>
<script src="/js/user/usercommon.js"></script>
<script src="/js/common/common.js"></script>
</html>