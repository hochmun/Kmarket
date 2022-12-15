<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="./_header.jsp"/>
<main>
    <!-- 카테고리/베스트 상품 영역 -->
    <aside>
        <!-- 카테고리 -->
        <ul class="category">
            <li>
                <i class="fa fa-bars" aria-hidden="true"></i>
                카테고리
            </li>
            
            <c:forEach var="cate1" items="${ vos1 }">
            	<li>
	                <a href="${pageContext.request.contextPath}/product/list.do?cate1=+${ cate1.cate1 }">
	                	<c:if test="${ cate1.cate1 eq 10 }"><i class="fas fa-shopping-bag"></i></c:if>
	                	<c:if test="${ cate1.cate1 eq 11 }"><i class="fas fa-tshirt"></i></c:if>
	                	<c:if test="${ cate1.cate1 eq 12 }"><i class="fas fa-baby-carriage"></i></c:if>
	                	<c:if test="${ cate1.cate1 eq 13 }"><i class="fas fa-utensils"></i></c:if>
	                	<c:if test="${ cate1.cate1 eq 14 }"><i class="fas fa-home"></i></c:if>
	                	<c:if test="${ cate1.cate1 eq 15 }"><i class="fas fa-tv"></i></c:if>
	                	<c:if test="${ cate1.cate1 eq 16 }"><i class="fas fa-running"></i></c:if>
	                	<c:if test="${ cate1.cate1 eq 17 }"><i class="fas fa-car"></i></c:if>
	                	<c:if test="${ cate1.cate1 eq 18 }"><i class="fas fa-book"></i></c:if>
	                    ${ cate1.c1Name }
	                    <i class="fas fa-angle-right"></i>
	                </a>
	                <ol>
	                	<c:forEach var="cate2" items="${ vos2 }">
	                		<c:if test="${ cate2.cate1 eq cate1.cate1 }">
	                			<li><a href="${pageContext.request.contextPath}/product/list.do?cate1=${ cate1.cate1 }&cate2=${ cate2.cate2 }">${ cate2.c2Name }</a></li>
	                		</c:if>
	                	</c:forEach>
	                </ol>
	            </li>
            </c:forEach>
            
        </ul>
        <!-- 베스트상품 배너 -->
        <article class="best">
            <h1><i class="fas fa-crown"></i>베스트상품</h1>
            <ol>
                <li>
                    <a href="#">
                        <div class="thumb">
                            <i>1</i>
                            <img src="http://via.placeholder.com/230" alt="item1">
                        </div>
                        <h2>상품명</h2>
                        <div class="org_price">
                            <del>30,000</del>
                            <span>10%</span>
                        </div>
                        <div class="dis_price">
                            <ins>27,000</ins>
                        </div>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <div class="thumb">
                            <i>2</i>
                            <img src="http://via.placeholder.com/50" alt="item1">
                        </div>
                        <h2>상품명</h2>
                        <div class="org_price">
                            <del>30,000</del>
                            <span>10%</span>
                        </div>
                        <div class="dis_price">
                            <ins>27,000</ins>
                        </div>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <div class="thumb">
                            <i>3</i>
                            <img src="http://via.placeholder.com/50" alt="item1">
                        </div>
                        <h2>상품명</h2>
                        <div class="org_price">
                            <del>30,000</del>
                            <span>10%</span>
                        </div>
                        <div class="dis_price">
                            <ins>27,000</ins>
                        </div>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <div class="thumb">
                            <i>4</i>
                            <img src="http://via.placeholder.com/50" alt="item1">
                        </div>
                        <h2>상품명</h2>
                        <div class="org_price">
                            <del>30,000</del>
                            <span>10%</span>
                        </div>
                        <div class="dis_price">
                            <ins>27,000</ins>
                        </div>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <div class="thumb">
                            <i>5</i>
                            <img src="http://via.placeholder.com/50" alt="item1">
                        </div>
                        <h2>상품명</h2>
                        <div class="org_price">
                            <del>30,000</del>
                            <span>10%</span>
                        </div>
                        <div class="dis_price">
                            <ins>27,000</ins>
                        </div>
                    </a>
                </li>
            </ol>
        </article>
    </aside>
    <section>
        <!-- 슬라이더 영역 -->
        <section class="slider">
            <ul>
                <li>
                    <a href="#">
                        <img src="https://via.placeholder.com/985x447" alt="item1">
                    </a>
                </li>
                <li>
                    <a href="#">
                        <img src="https://via.placeholder.com/985x447" alt="item2">
                    </a>
                </li>
                <li>
                    <a href="#">
                        <img src="https://via.placeholder.com/985x447" alt="item3">
                    </a>
                </li>
                <li>
                    <a href="#">
                        <img src="https://via.placeholder.com/985x447" alt="item4">
                    </a>
                </li>
                <li>
                    <a href="#">
                        <img src="https://via.placeholder.com/985x447" alt="item5">
                    </a>
                </li>
            </ul>
        </section>
        <!-- 히트상품 영역 -->
        <section class="hit">
            <h3><span>히트상품</span></h3>
            <article>
                <a href="#">
                    <div class="thumb">
                        <img src="https://via.placeholder.com/230x230" alt="t1">
                    </div>
                    <h2>상품명</h2>
                    <p>간단한 상품 설명</p>
                    <div class="org_price">
                        <del>30,000</del>
                        <span>10%</span>
                    </div>
                    <div class="dis_price">
                        <ins>27,000</ins>
                        <span class="free">무료배송</span>
                    </div>
                </a>
            </article>
            <article>
                <a href="#">
                    <div class="thumb">
                        <img src="https://via.placeholder.com/230x230" alt="t1">
                    </div>
                    <h2>상품명</h2>
                    <p>간단한 상품 설명</p>
                    <div class="org_price">
                        <del>30,000</del>
                        <span>10%</span>
                    </div>
                    <div class="dis_price">
                        <ins>27,000</ins>
                        <span class="free">무료배송</span>
                    </div>
                </a>
            </article>
            <article>
                <a href="#">
                    <div class="thumb">
                        <img src="https://via.placeholder.com/230x230" alt="t1">
                    </div>
                    <h2>상품명</h2>
                    <p>간단한 상품 설명</p>
                    <div class="org_price">
                        <del>30,000</del>
                        <span>10%</span>
                    </div>
                    <div class="dis_price">
                        <ins>27,000</ins>
                        <span class="free">무료배송</span>
                    </div>
                </a>
            </article>
            <article>
                <a href="#">
                    <div class="thumb">
                        <img src="https://via.placeholder.com/230x230" alt="t1">
                    </div>
                    <h2>상품명</h2>
                    <p>간단한 상품 설명</p>
                    <div class="org_price">
                        <del>30,000</del>
                        <span>10%</span>
                    </div>
                    <div class="dis_price">
                        <ins>27,000</ins>
                        <span class="free">무료배송</span>
                    </div>
                </a>
            </article>
            <article>
                <a href="#">
                    <div class="thumb">
                        <img src="https://via.placeholder.com/230x230" alt="t1">
                    </div>
                    <h2>상품명</h2>
                    <p>간단한 상품 설명</p>
                    <div class="org_price">
                        <del>30,000</del>
                        <span>10%</span>
                    </div>
                    <div class="dis_price">
                        <ins>27,000</ins>
                        <span class="free">무료배송</span>
                    </div>
                </a>
            </article>
            <article>
                <a href="#">
                    <div class="thumb">
                        <img src="https://via.placeholder.com/230x230" alt="t1">
                    </div>
                    <h2>상품명</h2>
                    <p>간단한 상품 설명</p>
                    <div class="org_price">
                        <del>30,000</del>
                        <span>10%</span>
                    </div>
                    <div class="dis_price">
                        <ins>27,000</ins>
                        <span class="free">무료배송</span>
                    </div>
                </a>
            </article>
            <article>
                <a href="#">
                    <div class="thumb">
                        <img src="https://via.placeholder.com/230x230" alt="t1">
                    </div>
                    <h2>상품명</h2>
                    <p>간단한 상품 설명</p>
                    <div class="org_price">
                        <del>30,000</del>
                        <span>10%</span>
                    </div>
                    <div class="dis_price">
                        <ins>27,000</ins>
                        <span class="free">무료배송</span>
                    </div>
                </a>
            </article>
            <article>
                <a href="#">
                    <div class="thumb">
                        <img src="https://via.placeholder.com/230x230" alt="t1">
                    </div>
                    <h2>상품명</h2>
                    <p>간단한 상품 설명</p>
                    <div class="org_price">
                        <del>30,000</del>
                        <span>10%</span>
                    </div>
                    <div class="dis_price">
                        <ins>27,000</ins>
                        <span class="free">무료배송</span>
                    </div>
                </a>
            </article>
        </section>
        <!-- 추천상품 영역 -->
        <section class="recommend">
            <h3><span>추천상품</span></h3>
            <article>
                <a href="#">
                    <div class="thumb">
                        <img src="https://via.placeholder.com/230x230" alt="t1">
                    </div>
                    <h2>상품명</h2>
                    <p>간단한 상품 설명</p>
                    <div class="org_price">
                        <del>30,000</del>
                        <span>10%</span>
                    </div>
                    <div class="dis_price">
                        <ins>27,000</ins>
                        <span>배송비 2500</span>
                    </div>
                </a>
            </article>
            <article>
                <a href="#">
                    <div class="thumb">
                        <img src="https://via.placeholder.com/230x230" alt="t1">
                    </div>
                    <h2>상품명</h2>
                    <p>간단한 상품 설명</p>
                    <div class="org_price">
                        <del>30,000</del>
                        <span>10%</span>
                    </div>
                    <div class="dis_price">
                        <ins>27,000</ins>
                        <span>배송비 2500</span>
                    </div>
                </a>
            </article>
            <article>
                <a href="#">
                    <div class="thumb">
                        <img src="https://via.placeholder.com/230x230" alt="t1">
                    </div>
                    <h2>상품명</h2>
                    <p>간단한 상품 설명</p>
                    <div class="org_price">
                        <del>30,000</del>
                        <span>10%</span>
                    </div>
                    <div class="dis_price">
                        <ins>27,000</ins>
                        <span>배송비 2500</span>
                    </div>
                </a>
            </article>
            <article>
                <a href="#">
                    <div class="thumb">
                        <img src="https://via.placeholder.com/230x230" alt="t1">
                    </div>
                    <h2>상품명</h2>
                    <p>간단한 상품 설명</p>
                    <div class="org_price">
                        <del>30,000</del>
                        <span>10%</span>
                    </div>
                    <div class="dis_price">
                        <ins>27,000</ins>
                        <span>배송비 2500</span>
                    </div>
                </a>
            </article>
            <article>
                <a href="#">
                    <div class="thumb">
                        <img src="https://via.placeholder.com/230x230" alt="t1">
                    </div>
                    <h2>상품명</h2>
                    <p>간단한 상품 설명</p>
                    <div class="org_price">
                        <del>30,000</del>
                        <span>10%</span>
                    </div>
                    <div class="dis_price">
                        <ins>27,000</ins>
                        <span>배송비 2500</span>
                    </div>
                </a>
            </article>
            <article>
                <a href="#">
                    <div class="thumb">
                        <img src="https://via.placeholder.com/230x230" alt="t1">
                    </div>
                    <h2>상품명</h2>
                    <p>간단한 상품 설명</p>
                    <div class="org_price">
                        <del>30,000</del>
                        <span>10%</span>
                    </div>
                    <div class="dis_price">
                        <ins>27,000</ins>
                        <span>배송비 2500</span>
                    </div>
                </a>
            </article>
            <article>
                <a href="#">
                    <div class="thumb">
                        <img src="https://via.placeholder.com/230x230" alt="t1">
                    </div>
                    <h2>상품명</h2>
                    <p>간단한 상품 설명</p>
                    <div class="org_price">
                        <del>30,000</del>
                        <span>10%</span>
                    </div>
                    <div class="dis_price">
                        <ins>27,000</ins>
                        <span>배송비 2500</span>
                    </div>
                </a>
            </article>
            <article>
                <a href="#">
                    <div class="thumb">
                        <img src="https://via.placeholder.com/230x230" alt="t1">
                    </div>
                    <h2>상품명</h2>
                    <p>간단한 상품 설명</p>
                    <div class="org_price">
                        <del>30,000</del>
                        <span>10%</span>
                    </div>
                    <div class="dis_price">
                        <ins>27,000</ins>
                        <span>배송비 2500</span>
                    </div>
                </a>
            </article>
        </section>
        <!-- 최신상품 영역 -->
        <section class="new">
            <h3><span>최신상품</span></h3>
            <article>
                <a href="#">
                    <div class="thumb">
                        <img src="https://via.placeholder.com/230x230" alt="t1">
                    </div>
                    <h2>상품명</h2>
                    <p>간단한 상품 설명</p>
                    <div class="org_price">
                        <del>30,000</del>
                        <span>10%</span>
                    </div>
                    <div class="dis_price">
                        <ins>27,000</ins>
                        <span class="free">무료배송</span>
                    </div>
                </a>
            </article>
            <article>
                <a href="#">
                    <div class="thumb">
                        <img src="https://via.placeholder.com/230x230" alt="t1">
                    </div>
                    <h2>상품명</h2>
                    <p>간단한 상품 설명</p>
                    <div class="org_price">
                        <del>30,000</del>
                        <span>10%</span>
                    </div>
                    <div class="dis_price">
                        <ins>27,000</ins>
                        <span class="free">무료배송</span>
                    </div>
                </a>
            </article>
            <article>
                <a href="#">
                    <div class="thumb">
                        <img src="https://via.placeholder.com/230x230" alt="t1">
                    </div>
                    <h2>상품명</h2>
                    <p>간단한 상품 설명</p>
                    <div class="org_price">
                        <del>30,000</del>
                        <span>10%</span>
                    </div>
                    <div class="dis_price">
                        <ins>27,000</ins>
                        <span class="free">무료배송</span>
                    </div>
                </a>
            </article>
            <article>
                <a href="#">
                    <div class="thumb">
                        <img src="https://via.placeholder.com/230x230" alt="t1">
                    </div>
                    <h2>상품명</h2>
                    <p>간단한 상품 설명</p>
                    <div class="org_price">
                        <del>30,000</del>
                        <span>10%</span>
                    </div>
                    <div class="dis_price">
                        <ins>27,000</ins>
                        <span class="free">무료배송</span>
                    </div>
                </a>
            </article>
            <article>
                <a href="#">
                    <div class="thumb">
                        <img src="https://via.placeholder.com/230x230" alt="t1">
                    </div>
                    <h2>상품명</h2>
                    <p>간단한 상품 설명</p>
                    <div class="org_price">
                        <del>30,000</del>
                        <span>10%</span>
                    </div>
                    <div class="dis_price">
                        <ins>27,000</ins>
                        <span class="free">무료배송</span>
                    </div>
                </a>
            </article>
            <article>
                <a href="#">
                    <div class="thumb">
                        <img src="https://via.placeholder.com/230x230" alt="t1">
                    </div>
                    <h2>상품명</h2>
                    <p>간단한 상품 설명</p>
                    <div class="org_price">
                        <del>30,000</del>
                        <span>10%</span>
                    </div>
                    <div class="dis_price">
                        <ins>27,000</ins>
                        <span class="free">무료배송</span>
                    </div>
                </a>
            </article>
            <article>
                <a href="#">
                    <div class="thumb">
                        <img src="https://via.placeholder.com/230x230" alt="t1">
                    </div>
                    <h2>상품명</h2>
                    <p>간단한 상품 설명</p>
                    <div class="org_price">
                        <del>30,000</del>
                        <span>10%</span>
                    </div>
                    <div class="dis_price">
                        <ins>27,000</ins>
                        <span class="free">무료배송</span>
                    </div>
                </a>
            </article>
            <article>
                <a href="#">
                    <div class="thumb">
                        <img src="https://via.placeholder.com/230x230" alt="t1">
                    </div>
                    <h2>상품명</h2>
                    <p>간단한 상품 설명</p>
                    <div class="org_price">
                        <del>30,000</del>
                        <span>10%</span>
                    </div>
                    <div class="dis_price">
                        <ins>27,000</ins>
                        <span class="free">무료배송</span>
                    </div>
                </a>
            </article>
        </section>
        <!-- 할인상품 영역 -->
        <section class="discount">
            <h3><span>할인상품</span></h3>
            <article>
                <a href="#">
                    <div class="thumb">
                        <img src="https://via.placeholder.com/230x230" alt="t1">
                    </div>
                    <h2>상품명</h2>
                    <p>간단한 상품 설명</p>
                    <div class="org_price">
                        <del>30,000</del>
                        <span>10%</span>
                    </div>
                    <div class="dis_price">
                        <ins>27,000</ins>
                        <span class="free">무료배송</span>
                    </div>
                </a>
            </article>
            <article>
                <a href="#">
                    <div class="thumb">
                        <img src="https://via.placeholder.com/230x230" alt="t1">
                    </div>
                    <h2>상품명</h2>
                    <p>간단한 상품 설명</p>
                    <div class="org_price">
                        <del>30,000</del>
                        <span>10%</span>
                    </div>
                    <div class="dis_price">
                        <ins>27,000</ins>
                        <span class="free">무료배송</span>
                    </div>
                </a>
            </article>
            <article>
                <a href="#">
                    <div class="thumb">
                        <img src="https://via.placeholder.com/230x230" alt="t1">
                    </div>
                    <h2>상품명</h2>
                    <p>간단한 상품 설명</p>
                    <div class="org_price">
                        <del>30,000</del>
                        <span>10%</span>
                    </div>
                    <div class="dis_price">
                        <ins>27,000</ins>
                        <span class="free">무료배송</span>
                    </div>
                </a>
            </article>
            <article>
                <a href="#">
                    <div class="thumb">
                        <img src="https://via.placeholder.com/230x230" alt="t1">
                    </div>
                    <h2>상품명</h2>
                    <p>간단한 상품 설명</p>
                    <div class="org_price">
                        <del>30,000</del>
                        <span>10%</span>
                    </div>
                    <div class="dis_price">
                        <ins>27,000</ins>
                        <span class="free">무료배송</span>
                    </div>
                </a>
            </article>
            <article>
                <a href="#">
                    <div class="thumb">
                        <img src="https://via.placeholder.com/230x230" alt="t1">
                    </div>
                    <h2>상품명</h2>
                    <p>간단한 상품 설명</p>
                    <div class="org_price">
                        <del>30,000</del>
                        <span>10%</span>
                    </div>
                    <div class="dis_price">
                        <ins>27,000</ins>
                        <span class="free">무료배송</span>
                    </div>
                </a>
            </article>
            <article>
                <a href="#">
                    <div class="thumb">
                        <img src="https://via.placeholder.com/230x230" alt="t1">
                    </div>
                    <h2>상품명</h2>
                    <p>간단한 상품 설명</p>
                    <div class="org_price">
                        <del>30,000</del>
                        <span>10%</span>
                    </div>
                    <div class="dis_price">
                        <ins>27,000</ins>
                        <span class="free">무료배송</span>
                    </div>
                </a>
            </article>
            <article>
                <a href="#">
                    <div class="thumb">
                        <img src="https://via.placeholder.com/230x230" alt="t1">
                    </div>
                    <h2>상품명</h2>
                    <p>간단한 상품 설명</p>
                    <div class="org_price">
                        <del>30,000</del>
                        <span>10%</span>
                    </div>
                    <div class="dis_price">
                        <ins>27,000</ins>
                        <span class="free">무료배송</span>
                    </div>
                </a>
            </article>
            <article>
                <a href="#">
                    <div class="thumb">
                        <img src="https://via.placeholder.com/230x230" alt="t1">
                    </div>
                    <h2>상품명</h2>
                    <p>간단한 상품 설명</p>
                    <div class="org_price">
                        <del>30,000</del>
                        <span>10%</span>
                    </div>
                    <div class="dis_price">
                        <ins>27,000</ins>
                        <span class="free">무료배송</span>
                    </div>
                </a>
            </article>
        </section>
    </section>
</main>
<jsp:include page="./_footer.jsp"/>      