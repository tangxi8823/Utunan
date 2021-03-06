<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="plate" value="message/read"/>
<!DOCTYPE html>
<html lang="zh-cn">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>已读消息</title>
    <link rel="stylesheet" href="/css/common.css">
    <link rel="stylesheet" href="/css/user/message.css">
    <link rel="stylesheet" href="/css/user/usercommon.css">
    <link rel="shortcut icon" href="/images/common/favicon.ico" type="image/x-icon">
</head>

<body>
<%@include file="../common/header.jsp" %>
<%@include file="common/usercard.jsp"%>
<div class="container" style="margin-top: 30px;">
    <div class="wrapper background">
        <%@include file="common/userfunction.jsp"%>
        <div class="content" id="content">
            <div class="title">
                <span>消息通知</span>
            </div>
            <div class="infotype">
                <span><a href="/user/message/noread">未读消息</a></span>
                <span id="infoactive"><a href="/user/message/read">已读消息</a></span>
            </div>
            <nav id="message">
                <c:forEach items="${Messages}" var="message">
                    <c:choose>
                        <c:when test="${message.messageType==\"1\"}">
                            <li>
                                <span class="system"> 系统消息 : </span>
                                <span id="message${message.messageId}"><a _href="/user/message/systeminfo/${message.messageId}">${message.messageTitle}</a></span>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li>
                                <span class="newreply"> 问答回复 : </span>
                                <span id="message${message.messageId}">您的问答 : ${message.messageContent} 有了新的回复 </span>
                            </li>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
                <script>
                    alla=$('#message a')
                    alla.click(function(){
                        url=$(this).attr('_href')
                        var tempwindow=window.open('_blank'); // 先打开页面
                        tempwindow.location=url; // 后更改页面地址
                    })
                </script>
            </nav>
            <%@ include file="common/page.jsp"%>
        </div>
    </div>
</div>
<%@include file="../common/footer.jsp"%>
</body>
<script src="/js/user/usercommon.js"></script>
<script src="/js/common/common.js"></script>
</html>