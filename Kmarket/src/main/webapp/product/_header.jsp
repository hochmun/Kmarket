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
    <script>
 // 각 탭 클릭시 데이터 받기
 	$.get('/Kmarket/getLatests.do',(data)=>{
			for(let latest of data) {
				let url = "/Kmarket/product/list.do?pg=&cate1=11&cate2="+latest.no;
				$('#tabs-1 > .txt').append("<li><a href='"+url+"'>"+latest.title+"</a></li>");
			}
		});
 
	$(document).one('click', '#tabs-1-click', function(){
		$.get('/Kmarket/getLatests.do?cate=qna',(data)=>{
			for(let latest of data) {
				let url = "/Kmarket/view.do?cate=5&tit=1&pg=1&no="+latest.no;
				$('#tabs-2 > .txt').append("<li><a href='"+url+"'>"+latest.title+"</a></li>");
			}
		});
	});
	$(document).one('click', '#tabs-2-click', function(){
		$.get('/Kmarket/getLatests.do?cate=faq',(data)=>{
			for(let latest of data) {
				let url = "/Kmarket/view.do?cate=5&tit=2&pg=1&no="+latest.no;
				$('#tabs-3 > .txt').append("<li><a href='"+url+"'>"+latest.title+"</a></li>");
			}
		});
	});
	$(document).one('click', '#tabs-2-click', function(){
		$.get('/Kmarket/getLatests.do?cate=faq',(data)=>{
			for(let latest of data) {
				let url = "/Kmarket/view.do?cate=5&tit=3&pg=1&no="+latest.no;
				$('#tabs-4 > .txt').append("<li><a href='"+url+"'>"+latest.title+"</a></li>");
			}
		});
	});
	$(document).one('click', '#tabs-2-click', function(){
		$.get('/Kmarket/getLatests.do?cate=faq',(data)=>{
			for(let latest of data) {
				let url = "/Kmarket/view.do?cate=5&tit=4&pg=1&no="+latest.no;
				$('#tabs-5 > .txt').append("<li><a href='"+url+"'>"+latest.title+"</a></li>");
			}
		});
	});
	
    </script>
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
                    	<c:otherwise>
                    		<a href="${pageContext.request.contextPath}/member/logout.do">로그아웃</a>
                    		<a href="#">마이페이지</a>
                    	</c:otherwise>
                    </c:choose>
                    <a href="#"><i class="fa fa-shopping-cart" aria-hidden="true"></i>&nbsp;장바구니</a>
                </div>
            </div>
            <div class="logo">
                <div>
                    <a href="#"><img src="../img/header_logo.png" alt="로고"/></a>
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
                        <li><a href="#">고객센터</a></li>
                        <li><a href="#">FAQ</a></li>
                    </ul>
                </div>
            </div>
        </header>
		<main id="product">
            <aside>
                <ul class="category">
                    <li><i class="fa fa-bars" aria-hidden="true"></i>카테고리</li>
                    <li>
                        <a href="#"><i class="fas fa-tshirt"></i>패션·의류·뷰티</a>
                        <ol>
                            <li><a href="/Kmarket/product/list.do?cate1=11&cate2=11&pg=${pg}">남성의류</a></li>
                            <li><a href="/Kmarket/product/list.do?cate1=11&cate2=10&pg=${pg}">여성의류</a></li>
                            <li><a href="/Kmarket/product/list.do?cate1=11&cate2=14&pg=${pg}">잡화</a></li>
                            <li><a href="/Kmarket/product/list.do?cate1=10&cate2=16&pg=${pg}">뷰티</a></li>
                        </ol>
                    </li>
                    <li>
                        <a href="#"><i class="fas fa-laptop"></i>가전·디지털</a>
                        <ol>
                            <li><a href="/Kmarket/product/list.do?cate1=15&cate2=10&pg=${pg}">노트북</a></li>
                            <li><a href="/Kmarket/product/list.do?cate1=15&cate2=16&pg=${pg}">가전</a></li>
                            <li><a href="/Kmarket/product/list.do?cate1=15&cate2=13&pg=${pg}">휴대폰</a></li>
                            <li><a href="/Kmarket/product/list.do?cate1=15&cate2=15&pg=${pg}">기타</a></li>
                        </ol>
                    </li>
                    <li>
                        <a href="#"><i class="fas fa-utensils"></i>식품·생필품</a>
                        <ol>
                            <li><a href="/Kmarket/product/list.do?cate1=13&cate2=10&pg=${pg}">신선식품</a></li>
                            <li><a href="/Kmarket/product/list.do?cate1=13&cate2=11&pg=${pg}">가공식품</a></li>
                            <li><a href="/Kmarket/product/list.do?cate1=13&cate2=12&pg=${pg}">건강식품</a></li>
                            <li><a href="/Kmarket/product/list.do?cate1=13&cate2=14&pg=${pg}">생필품</a></li>
                        </ol>
                    </li>
                    <li>
                        <a href="#"><i class="fas fa-home"></i>홈·문구·취미</a>
                        <ol>
                            <li><a href="/Kmarket/product/list.do?cate1=14&cate2=10&pg=${pg}">가구/DIY</a></li>
                            <li><a href="/Kmarket/product/list.do?cate1=14&cate2=11&pg=${pg}">침구·커튼</a></li>
                            <li><a href="/Kmarket/product/list.do?cate1=14&cate2=13&pg=${pg}">생활용품</a></li>
                            <li><a href="/Kmarket/product/list.do?cate1=14&cate2=15&pg=${pg}">사무용품</a></li>
                        </ol>
                    </li>
                </ul>
            </aside>