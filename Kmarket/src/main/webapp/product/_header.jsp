<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>케이마켓::대한민국 1등 온라인 쇼핑몰</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
    <script src="https://kit.fontawesome.com/20962f3e4b.js" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
    <link rel="stylesheet" href="../css/main.css"/>
    <link rel="stylesheet" href="./css/product.css"/>
    <script src="./js/_header.js"></script>
</head>
<body>
    <div id="wrapper">
        <header>
            <div class="top">
                <div>
                    <c:choose>
                		<c:when test="${ sessUser.uid eq null }">
                    		<a href="${pageContext.request.contextPath}/member/login.do">로그인</a>
                    		<a href="${pageContext.request.contextPath}/member/join.do">회원가입</a>
                    	</c:when>
                    	<c:when test="${ sessUser.type eq 2 || sessUser.type eq 5 }">
                    		<a href="${pageContext.request.contextPath}/admin/index.do">관리자</a>
                    		<a href="${pageContext.request.contextPath}/member/logout.do">로그아웃</a>
                    		<a href="#">마이페이지</a>
                    	</c:when>
                    	<c:otherwise>
                    		<a href="${pageContext.request.contextPath}/member/logout.do">로그아웃</a>
                    		<a href="#">마이페이지</a>
                    	</c:otherwise>
                    </c:choose>
                    <a href="${pageContext.request.contextPath}/product/cart.do"><i class="fa fa-shopping-cart" aria-hidden="true"></i>&nbsp;장바구니</a>
                </div>
            </div>
            <div class="logo">
                <div>
                    <a href="${pageContext.request.contextPath}/index.do"><img src="../img/header_logo.png" alt="로고"/></a>
                    <form action="#">
                        <input type="text" name="search"/>
                        <button><i class="fa fa-search"></i></button>
                    </form>
                </div>

            </div>
            <div class="menu">
                <div>
                    <ul>
                        <li><a href="#">히트상품</a></li>
                        <li><a href="#">추천상품</a></li>
                        <li><a href="#">최신상품</a></li>
                        <li><a href="#">인기상품</a></li>
                        <li><a href="#">할인상품</a></li>
                    </ul>
                    <ul>
                        <li><a href="#">쿠폰존</a></li>
                        <li><a href="#">사용후기</a></li>
                        <li><a href="#">개인결제</a></li>
                        <li><a href="${pageContext.request.contextPath}/cs/index.do">고객센터</a></li>
                        <li><a href="${pageContext.request.contextPath}/cs/faq/list.do">FAQ</a></li>
                    </ul>
                </div>
            </div>
        </header>
		<main id="product">
            <aside>
                <ul class="category">
                    <li><i class="fa fa-bars" aria-hidden="true"></i>카테고리</li>
                </ul>
            </aside>