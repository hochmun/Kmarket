<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="./_header.jsp"/>
<script src="./js/product.js"></script>
 <main id="product">
            <aside>
                <ul class="category">
                    <li><i class="fa fa-bars" aria-hidden="true"></i>카테고리</li>
                    <li>
                        <a href="#"><i class="fas fa-tshirt"></i>패션·의류·뷰티</a>
                        <ol>
                            <li><a href="#">남성의류</a></li>
                            <li><a href="#">여성의류</a></li>
                            <li><a href="#">잡화</a></li>
                            <li><a href="#">뷰티</a></li>
                        </ol>
                    </li>
                    <li>
                        <a href="#"><i class="fas fa-laptop"></i>가전·디지털</a>
                        <ol>
                            <li><a href="#">노트북</a></li>
                            <li><a href="#">가전</a></li>
                            <li><a href="#">휴대폰</a></li>
                            <li><a href="#">기타</a></li>
                        </ol>
                    </li>
                    <li>
                        <a href="#"><i class="fas fa-utensils"></i>식품·생필품</a>
                        <ol>
                            <li><a href="#">신선식품</a></li>
                            <li><a href="#">가공식품</a></li>
                            <li><a href="#">건강식품</a></li>
                            <li><a href="#">생필품</a></li>
                        </ol>
                    </li>
                    <li>
                        <a href="#"><i class="fas fa-home"></i>홈·문구·취미</a>
                        <ol>
                            <li><a href="#">가구/DIY</a></li>
                            <li><a href="#">침구·커튼</a></li>
                            <li><a href="#">잡화</a></li>
                            <li><a href="#">뷰티</a></li>
                        </ol>
                    </li>
                </ul>
            </aside>

            <section class="list">
                <!-- 제목, 페이지 네비게이션 -->
                <nav>
                    <h1>상품목록</h1>
                    <p>HOME > <span>${vo.c1Name}</span> > <strong>${vo.c2Name}</strong></p>
                </nav>

                <!-- 정렬 메뉴 -->
                <ul class="sort">
                    <li><a href="#" id="sold" prodcate1="${vo.cate1}" prodcate2="${vo.cate2}">판매많은순</a></li>
                    <li><a href="#" id="low" prodcate1="${vo.cate1}" prodcate2="${vo.cate2}">낮은가격순</a></li>
                    <li><a href="#" id="high" prodcate1="${vo.cate1}" prodcate2="${vo.cate2}">높은가격순</a></li>
                    <li><a href="#" id="hstar" prodcate1="${vo.cate1}" prodcate2="${vo.cate2}">평점높은순</a></li>
                    <li><a href="#" id="review" prodcate1="${vo.cate1}" prodcate2="${vo.cate2}">후기많은순</a></li>
                    <li><a href="#" id="latest" prodcate1="${vo.cate1}" prodcate2="${vo.cate2}">최근등록순</a></li>
                </ul>
                <!-- 상품목록 -->      
                <table border="0" class="productList">
                <c:forEach var="product" items="${pvos}">
	                <tr>
	                    <td><a href="/Kmarket/product/view.do?pg=${pg}&cate1=${vo.cate1}&cate2=${vo.cate2}&prodNo=${pvos.prodNo}" class="thumb"><img src="https://via.placeholder.com/120x120" alt="상품이미지"></a></td>
	                    <td>
	                        <h3 class="name">${pvos.prodName}</h3>
	                        <a href="#" class="desc">${pvos.descript}</a>
	                    </td>
	                    <td>
	                        <ul>
	                        <c:choose>
	                        <c:when test="${pvos.discount gt 0}">
	                            <li><ins class="dis-price">${disprice}</ins></li>
	                            <li>
	                                <del class="org-price">${pvos.price}</del>
	                                <span class="discount">${pvos.discount}%</span>
	                            </li>
                            </c:when>
                            <c:otherwise>
                            	<li>
	                                <del class="dis-price">${pvos.price}</del>
	                            </li>
                            </c:otherwise>
                            </c:choose>
                            <c:choose>
                            <c:when test="${pvos.delivery eq 0}">
	                            <li><span class="free-delivery">무료배송</span></li>
	                            </c:when>
	                            <c:otherwise>
	                            <li><span>${pvos.delivery}</span></li>
	                            </c:otherwise>
	                            </c:choose>
	                        </ul>
	                    </td>
	                    <td>
	                        <h4 class="seller"><i class="fas fa-home"></i>&nbsp;${pvos.seller}</h4>
	                        <h5 class="badge power">판매자등급</h5>
	                        <c:choose>
	                        <c:when test="${pvos.score eq 1}">
	                        <h6 class="rating star1">상품평</h6>
	                        </c:when>
	                        <c:when test="${pvos.score eq 2}">
	                        <h6 class="rating star2">상품평</h6>
	                        </c:when>
	                        <c:when test="${pvos.score eq 3}">
	                        <h6 class="rating star3">상품평</h6>
	                        </c:when>
	                        <c:when test="${pvos.score eq 4}">
	                        <h6 class="rating star4">상품평</h6>
	                        </c:when>
	                        <c:when test="${pvos.score eq 5}">
	                        <h6 class="rating star5">상품평</h6>
	                        </c:when>
	                        <c:when test="${pvos.score eq 6}">
	                        <h6 class="rating star6">상품평</h6>
	                        </c:when>
	                        <c:when test="${pvos.score eq 7}">
	                        <h6 class="rating star7">상품평</h6>
	                        </c:when>
	                        <c:when test="${pvos.score eq 8}">
	                        <h6 class="rating star8">상품평</h6>
	                        </c:when>
	                        <c:when test="${pvos.score eq 9}">
	                        <h6 class="rating star9">상품평</h6>
	                        </c:when>
	                        <c:otherwise>
	                        <h6 class="rating star10">상품평</h6>
	                        </c:otherwise>
	                        </c:choose>
	                    </td>
	                </tr>
	                </c:forEach>
<!-- 	                <tr>
	                    <td><a href="#" class="thumb"><img src="https://via.placeholder.com/120x120" alt="상품이미지"></a></td>
	                    <td>
	                        <h3 class="name">상품명</h3>
	                        <a href="#" class="desc">상품설명</a>
	                    </td>
	                    <td>
	                        <ul>
	                            <li><ins class="dis-price">27,000</ins></li>
	                            <li>
	                                <del class="org-price">30,000</del>
	                                <span class="discount">10%</span>
	                            </li>
	                            <li><span class="free-delivery">무료배송</span></li>
	                        </ul>
	                    </td>
	                    <td>
	                        <h4 class="seller"><i class="fas fa-home"></i>&nbsp;판매자명</h4>
	                        <h5 class="badge power">판매자등급</h5>
	                        <h6 class="rating star2">상품평</h6>
	                    </td>
	                </tr>
	                <tr>
	                    <td><a href="#" class="thumb"><img src="https://via.placeholder.com/120x120" alt="상품이미지"></a></td>
	                    <td>
	                        <h3 class="name">상품명</h3>
	                        <a href="#" class="desc">상품설명</a>
	                    </td>
	                    <td>
	                        <ul>
	                            <li><ins class="dis-price">27,000</ins></li>
	                            <li>
	                                <del class="org-price">30,000</del>
	                                <span class="discount">10%</span>
	                            </li>
	                            <li><span class="free-delivery">무료배송</span></li>
	                        </ul>
	                    </td>
	                    <td>
	                        <h4 class="seller"><i class="fas fa-home"></i>&nbsp;판매자명</h4>
	                        <h5 class="badge power">판매자등급</h5>
	                        <h6 class="rating star3">상품평</h6>
	                    </td>
	                </tr>
	                <tr>
	                    <td><a href="#" class="thumb"><img src="https://via.placeholder.com/120x120" alt="상품이미지"></a></td>
	                    <td>
	                        <h3 class="name">상품명</h3>
	                        <a href="#" class="desc">상품설명</a>
	                    </td>
	                    <td>
	                        <ul>
	                            <li><ins class="dis-price">27,000</ins></li>
	                            <li>
	                                <del class="org-price">30,000</del>
	                                <span class="discount">10%</span>
	                            </li>
	                            <li><span class="free-delivery">무료배송</span></li>
	                        </ul>
	                    </td>
	                    <td>
	                        <h4 class="seller"><i class="fas fa-home"></i>&nbsp;판매자명</h4>
	                        <h5 class="badge power">판매자등급</h5>
	                        <h6 class="rating star4">상품평</h6>
	                    </td>
	                </tr>
	                <tr>
	                    <td><a href="#" class="thumb"><img src="https://via.placeholder.com/120x120" alt="상품이미지"></a></td>
	                    <td>
	                        <h3 class="name">상품명</h3>
	                        <a href="#" class="desc">상품설명</a>
	                    </td>
	                    <td>
	                        <ul>
	                            <li><ins class="dis-price">27,000</ins></li>
	                            <li>
	                                <del class="org-price">30,000</del>
	                                <span class="discount">10%</span>
	                            </li>
	                            <li><span>배송비 2500</span></li>
	                        </ul>
	                    </td>
	                    <td>
	                        <h4 class="seller"><i class="fas fa-home"></i>&nbsp;판매자명</h4>
	                        <h5 class="badge power">판매자등급</h5>
	                        <h6 class="rating star5">상품평</h6>
	                    </td>
	                </tr>-->
                </table>

                <!-- 상품목록 페이지번호 -->
                <div class="paging">
                <c:if test="${pageGroupStart gt 1}">
                    <span class="prev">
                        <a href="/Kmarket/product/list.do?pg=${pageGroupStart - 1}"><&nbsp;이전</a>
                    </span>
                    </c:if>
                    <span class="num">
                    <c:forEach var="i" begin="${pageGroupStart}" end="${pageGroupEnd}">
                        <a href="/Kmarket/product/list.do?pg=${i}" class="${currentPage eq i?'on':'off'}">${i}</a>
                    </c:forEach>
                    </span>
                    <c:if test="${pageGroupEnd lt lastPageNum}">
                    <span class="next">
                        <a href="/Kmarket/product/list.do?pg=${pageGroupEnd + 1}">다음&nbsp;></a>
                    </span>
                    </c:if>
                </div>

            </section>
        </main>
    
<jsp:include page="./_footer.jsp"/>