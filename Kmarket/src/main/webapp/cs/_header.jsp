<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>케이마켓 고객센터</title>
    <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/img/favicon.ico"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/cs/css/cs.css">
</head>
<body>
    <div id="wrapper">
        <header>
            <div class="top">
                <div>
                    <p>
                    <a href="${pageContext.request.contextPath}/index.do">홈으로</a>
                    <c:choose>
               			<c:when test="${ sessUser.uid eq null }">
                    		<a href="${pageContext.request.contextPath}/member/login.do">로그인</a>
                    		<a href="${pageContext.request.contextPath}/member/join.do">회원가입</a>
                    	</c:when>
                        <c:when test="${ sessUser.type ne 1 }">
                    		<a href="${pageContext.request.contextPath}/admin/index.do">관리자</a>
                    		<a href="${pageContext.request.contextPath}/member/logout.do">로그아웃</a>
                    		<a href="#">마이페이지</a>
                    	</c:when>
                    	<c:otherwise>
                    		<a href="${pageContext.request.contextPath}/member/logout.do">로그아웃</a>
                    		<a href="#">마이페이지</a>
                    	</c:otherwise>
                    </c:choose>
                        <a href="${pageContext.request.contextPath}/product/cart.do"><i class="fa fa-shopping-cart" aria-hidden="true"></i
                        >&nbsp;장바구니</a>
                    </p>
                </div>
            </div>
            <div class="logo">
                <div>
                    <a href="${pageContext.request.contextPath}/cs/index.do"><img src="${pageContext.request.contextPath}/cs/img/logo.png" alt="로고">고객센터</a>
                </div>
            </div>
        </header>