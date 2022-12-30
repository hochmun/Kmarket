<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>케이마켓::대한민국 1등 온라인 쇼핑몰</title>
    <link rel="shortcut icon" type="image/x-icon" href="./img/favicon.ico" />
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css"/>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css"/>
    <link rel="stylesheet" href="./css/main.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
    <script src="https://kit.fontawesome.com/20962f3e4b.js" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
    <script>
    	let slidingOk = true;
    
        $(()=>{
        	var $slider = $('.slider > ul').bxSlider({
        		easing: "linear",
        		// 슬라이드 전환 직적 실행
        		onSlideBefore: function($slideElement, oldIndex, currentIndex) {
        			if(slidingOk == true) {
        				slidingOk = false;
        				return true;
        			} else {
        				return false;
        			}
        			
        		},
        		// 슬라이더 전환 후 실행
        		onSlideAfter: function($slideElement, oldIndex, currentIndex) {
        			slidingOk = true;
        		}
        	});
        });

        $(function(){
            const best = $("aside > .best");

            $(window).scroll(function(){
                var t = $(this).scrollTop();

                if (t > 620) {
                    best.css({
                        position: "fixed",
                        top: "0"
                    });
                } else {
                    best.css({ position: "static" });
                }
            });
        });
        
        function goTop(){
        	$('html').scrollTop(0);
        }
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
                    	<c:when test="${ sessUser.type ne 1 }">
                    		<a href="${pageContext.request.contextPath}/admin/index.do">관리자</a>
                    		<a href="${pageContext.request.contextPath}/member/logout.do">로그아웃</a>
                    		<a href="#">마이페이지</a>
                    		<a href="${pageContext.request.contextPath}/product/cart.do">
		                        <i class="fa fa-shopping-cart" aria-hidden="true"></i>
		                        &nbsp;장바구니
		                    </a>
                    	</c:when>
                    	<c:otherwise>
                    		<a href="${pageContext.request.contextPath}/member/logout.do">로그아웃</a>
                    		<a href="#">마이페이지</a>
		                    		<a href="${pageContext.request.contextPath}/product/cart.do">
		                        <i class="fa fa-shopping-cart" aria-hidden="true"></i>
		                        &nbsp;장바구니
		                    </a>
                    	</c:otherwise>
                    </c:choose>
                </div>
            </div>
            <div class="logo">
                <div>
                    <a href="${pageContext.request.contextPath}/index.do">
                        <img src="./img/header_logo.png" alt="로고">
                    </a>
                    <form action="#">
                        <input type="text" name="search">
                        <button>
                            <i class="fa fa-search" aria-hidden="true"></i>
                        </button>
                    </form>
                </div>
            </div>
            <div class="menu">
                <div>
                    <ul>
                        <li><a href="#hit">히트상품</a></li>
                        <li><a href="#recommend">추천상품</a></li>
                        <li><a href="#new">최신상품</a></li>
                        <li><a href="#discount">할인상품</a></li>
                    </ul>
                    <ul>
                        <li><a href="${pageContext.request.contextPath}/cs/notice/list.do">공지사항</a></li>
                        <li><a href="${pageContext.request.contextPath}/cs/faq/list.do">자주묻는질문</a></li>
                        <li><a href="${pageContext.request.contextPath}/cs/qna/list.do?cate1=10">문의하기</a></li>
                        <li><a href="${pageContext.request.contextPath}/cs/index.do">고객센터</a></li>
                    </ul>
                </div>
            </div>
        </header>