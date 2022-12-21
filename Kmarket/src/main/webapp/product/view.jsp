<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="./_header.jsp"/>
<script src="./js/view.js"></script>
<script>
	const sessUserUid = "${ sessUser.uid }"; // 유저 uid 정보 입력
	const prodNo = "${ vo.prodNo }"; // 상품 번호
	const prodCate1 = "${ vo.prodCate1 }";
	const prodCate2 = "${ vo.prodCate2 }";
	const thumb1 = "${ vo.thumb1 }";
	const prodName = "${ vo.prodName}";
	const descript = "${ vo.descript }";
	const price = "${ vo.price }" // 상품 가격
	const discount = "${ vo.discount }"; // 할인율
	const point = "${ vo.point }"; // 포인트
	const delivery = "${ vo.delivery }"; // 배송비
</script>
    
    <!-- 상품 상세페이지 시작-->
    <section class="view">
    
        <!-- 제목, 페이지 네비게이션 -->
        <nav>
            <h1>상품보기</h1>
            <p>
              HOME &gt; <span>${ cate1 }</span> &gt; <strong>${ cate2 }</strong>
          </p>
        </nav>

        <!-- 상품 전체 정보 내용 -->
        <article class="info">
            <div class="image">
                <img src="/thumb/${ vo.prodCate1 }/${ vo.prodCate2 }/${ vo.thumb3 }" alt="상품이미지"/>
            </div>
            <div class="summary">
                <nav>
                	<!-- 판매자 -->
                    <h1>${ vo.seller }</h1>
                    <h2>상품번호&nbsp;:&nbsp;<span>${ vo.prodNo }</span></h2>
                </nav>
                <nav>
                	<!-- 상품 이름, 상세 설명 -->
                    <h3>${ vo.prodName }</h3>
                    <p>${ vo.descript }</p>
                    <h5 class="rating star4"><a href="#">상품평보기</a></h5>
                </nav>
                <nav>
                
                	<!-- 할인율 있을경우와 없을 경우 -->
                
                	<c:choose>
                		<c:when test="${ vo.discount gt 0 }">
                			<div class="org_price">
                          		<del><fmt:formatNumber value="${ vo.price }" pattern="#,###"/></del>
                          		<span>${ vo.discount }%</span>
                      		</div>
                      		<div class="dis_price">
                          		<ins><fmt:formatNumber value="${ disprice }" pattern="#,###"/></ins>
                      		</div>
                		</c:when>
                		<c:otherwise>
                			<div class="dis_price">
                          		<ins><fmt:formatNumber value="${ vo.price }" pattern="#,###"/></ins>
                      		</div>
                		</c:otherwise>
                	</c:choose>
                	
                </nav>
                
                <nav>
                
                	<!-- 배송비 있을 경우 배송비 출력, 없을 경우 무료배송 출력 -->
                	
                 <c:choose>
                 	<c:when test="${ vo.delivery gt 0 }">
                 		<span class="delivery">배송비 <fmt:formatNumber value="${ vo.delivery }" pattern="#,###"/>원</span>
                 	</c:when>
                 	<c:otherwise>
                 		<span class="delivery">무료배송</span>
                 	</c:otherwise>
                 </c:choose>
                 
                 <!-- 배송 날짜 -->
                    <span class="arrival" id="arrival" onload="arrivalDate()"></span>
                 
                    <span class="desc">본 상품은 국내배송만 가능합니다.</span>
                </nav>
                <nav>
                    <span class="card cardfree"><i>아이콘</i>무이자할부</span>&nbsp;&nbsp;
                    <span class="card cardadd"><i>아이콘</i>카드추가혜택</span>
                </nav>
                
                <!-- 원산지 -->
                
                <nav>
                    <span class="origin">${ vo.origin }</span>
                </nav>
                
                
                <img src="../img/vip_plcc_banner.png" alt="100원만 결제해도 1만원 적립!" class="banner"/>
                
                <!-- 주문 갯수, 총 상품 금액 -->
                
                <div class="count">
                    <button class="decrease" id="decrease" onclick="count('minus')">-</button>
                    <input type="text" name="num" id="num" value="1" readonly/>
                    <button class="increase" id="increase" onclick="count('plus')">+</button>
                </div>

                <div class="total">
                
                	<c:choose>
                		<c:when test="${ vo.discount gt 0 }">
                			<span id="totalprice"><fmt:formatNumber value="${ disprice + vo.delivery }" pattern="#,###"/></span>
                		</c:when>
                		<c:otherwise>
                			<span id="totalprice"><fmt:formatNumber value="${ vo.price + vo.delivery }" pattern="#,###"/></span>
                		</c:otherwise>
                	</c:choose>
                	
                    <em>총 상품금액</em>
                    
                </div>
                
                <!-- 주문하기 -->
                
                <div class="button">
                    <input type="button" class="cart" value="장바구니" onclick="orderProduct('cart')"/>
                    <input type="button" class="order" value="구매하기" onclick="orderProduct('order')"/>
                </div>
                
            </div>
            
        </article>

        <!-- 상품 정보 내용 -->
        <article class="detail">
            <nav>
                <h1>상품정보</h1>
            </nav>
            <!-- 상품상세페이지 이미지 -->
            <img src="/thumb/${ vo.prodCate1 }/${ vo.prodCate2 }/${ vo.detail }" alt="상세페이지">
        </article>

        <!-- 상품 정보 제공 고시 내용 -->
        <article class="notice">
            <nav>
                <h1>상품 정보 제공 고시</h1>
                <p>[전자상거래에 관한 상품정보 제공에 관한 고시] 항목에 의거 등록된 정보입니다.</p>
            </nav>
            <table>
                <tr>
                    <td>상품번호</td>
                    <td>${ vo.prodNo }</td>
                </tr>
                <tr>
                    <td>상품상태</td>
                    <td>${ vo.status }</td>
                </tr>
                <tr>
                    <td>부가세 면세여부</td>
                    <td>${ vo.duty }</td>
                </tr>
                <tr>
                    <td>영수증발행</td>
                    <td>${ vo.receipt }</td>
                </tr>
                <tr>
                    <td>사업자구분</td>
                    <td>${ vo.bizType }</td>
                </tr>
                <tr>
                    <td>브랜드</td>
                    <td>${ vo.company }</td>
                </tr>
                <tr>
                    <td>원산지</td>
                    <td>${ vo.origin }</td>
                </tr>
            </table>
            <table>
                <tr>
                    <td>제품소개</td>
                    <td>${ vo.descript }</td>
                </tr>
                <tr>
                    <td>색상</td>
                    <td>상세정보 직접입력</td>
                </tr>
                <tr>
                    <td>치수</td>
                    <td>상세정보 직접입력</td>
                </tr>
                <tr>
                    <td>제조자/수입국</td>
                    <td>${ vo.company }/${ vo.origin }</td>
                </tr>
                <tr>
                    <td>제조국</td>
                    <td>${ vo.origin }</td>
                </tr>
                <tr>
                    <td>취급시 주의사항</td>
                    <td>상세정보 직접입력</td>
                </tr>
                <tr>
                    <td>제조연월</td>
                    <td>상세정보 직접입력</td>
                </tr>
                <tr>
                    <td>품질보증기준</td>
                    <td>상세정보 직접입력</td>
                </tr>
                <tr>
                	<!-- seller로 데이터베이스에서 판매자계정 검색? 후 담당자 번호 입력 -->
                    <td>A/S 책임자와 전화번호</td>
                    <td>상세정보 직접입력</td>
                </tr>
                <tr>
                    <td>주문후 예상 배송기간</td>
                    <td>약 3일</td>
                </tr>
                <tr>
                    <td colspan="2">구매, 교환, 반품, 배송, 설치 등과 관련하여 추가비용, 제한조건 등의 특이사항이 있는 경우</td>
                </tr>
            </table>
            <p class="notice">
                소비자가 전자상거래등에서 소비자 보호에 관한 법률 제 17조 제1항 또는 제3항에 따라 청약철회를 하고
                동법 제 18조 제1항 에 따라 청약철회한 물품을 판매자에게 반환하였음에도 불구 하고 결제 대금의
                환급이 3영업일을 넘게 지연된 경우, 소비자 는 전자상거래등에서 소비자보호에 관한 법률 제18조
                제2항 및 동법 시행령 제21조 2에 따라 지연일수에 대하여 전상법 시행령으로 정하는 이율을 곱하여
                산정한 지연이자(“지연배상금”)를 신청할 수 있습니다. 아울러, 교환∙반품∙보증 및 결제대금의
                환급신청은 [나의쇼핑정보]에서 하실 수 있으며, 자세한 문의는 개별 판매자에게 연락하여 주시기 바랍니다.
            </p>
        </article>

        <!-- 상품 리뷰 내용 -->
        
        <article class="review">
            <nav>
                <h1>상품리뷰</h1>
            </nav>
            <ul>
                <li>
                    <div>
                        <h5 class="rating star4">상품평</h5>
                        <span>seo****** 2018-07-10</span>
                    </div>
                    <h3>상품명1/BLUE/L</h3>
                    <p>
                        가격대비 정말 괜찮은 옷이라 생각되네요 핏은 음...제가 입기엔 어깨선이 맞고 루즈핏이라 하기도 좀 힘드네요.
                        아주 약간 루즈한정도...?그래도 이만한 옷은 없다고 봅니다 깨끗하고 포장도 괜찮고 다음에도 여기서 판매하는
                        제품들을 구매하고 싶네요 정말 만족하고 후기 남깁니다 많이 파시길 바래요 ~ ~ ~ 
                    </p>
                </li>
                <li>
                    <div>
                        <h5 class="rating star4">상품평</h5>
                        <span>seo****** 2018-07-10</span>
                    </div>
                    <h3>상품명1/BLUE/L</h3>
                    <p>
                        가격대비 정말 괜찮은 옷이라 생각되네요 핏은 음...제가 입기엔 어깨선이 맞고 루즈핏이라 하기도 좀 힘드네요.
                        아주 약간 루즈한정도...?그래도 이만한 옷은 없다고 봅니다 깨끗하고 포장도 괜찮고 다음에도 여기서 판매하는
                        제품들을 구매하고 싶네요 정말 만족하고 후기 남깁니다 많이 파시길 바래요 ~ ~ ~ 
                    </p>
                </li>
                <li>
                    <div>
                        <h5 class="rating star4">상품평</h5>
                        <span>seo****** 2018-07-10</span>
                    </div>
                    <h3>상품명1/BLUE/L</h3>
                    <p>
                        가격대비 정말 괜찮은 옷이라 생각되네요 핏은 음...제가 입기엔 어깨선이 맞고 루즈핏이라 하기도 좀 힘드네요.
                        아주 약간 루즈한정도...?그래도 이만한 옷은 없다고 봅니다 깨끗하고 포장도 괜찮고 다음에도 여기서 판매하는
                        제품들을 구매하고 싶네요 정말 만족하고 후기 남깁니다 많이 파시길 바래요 ~ ~ ~ 
                    </p>
                </li>
                <li>
                    <div>
                        <h5 class="rating star4">상품평</h5>
                        <span>seo****** 2018-07-10</span>
                    </div>
                    <h3>상품명1/BLUE/L</h3>
                    <p>
                        가격대비 정말 괜찮은 옷이라 생각되네요 핏은 음...제가 입기엔 어깨선이 맞고 루즈핏이라 하기도 좀 힘드네요.
                        아주 약간 루즈한정도...?그래도 이만한 옷은 없다고 봅니다 깨끗하고 포장도 괜찮고 다음에도 여기서 판매하는
                        제품들을 구매하고 싶네요 정말 만족하고 후기 남깁니다 많이 파시길 바래요 ~ ~ ~ 
                    </p>
                </li>
                <li>
                    <div>
                        <h5 class="rating star4">상품평</h5>
                        <span>seo****** 2018-07-10</span>
                    </div>
                    <h3>상품명1/BLUE/L</h3>
                    <p>
                        가격대비 정말 괜찮은 옷이라 생각되네요 핏은 음...제가 입기엔 어깨선이 맞고 루즈핏이라 하기도 좀 힘드네요.
                        아주 약간 루즈한정도...?그래도 이만한 옷은 없다고 봅니다 깨끗하고 포장도 괜찮고 다음에도 여기서 판매하는
                        제품들을 구매하고 싶네요 정말 만족하고 후기 남깁니다 많이 파시길 바래요 ~ ~ ~ 
                    </p>
                </li>
            </ul>
            
            <!-- 페이징 처리 -->
            
            <div class="paging">
                <span class="prev">
                    <a href="#">&nbsp;이전</a>
                </span>
                <span class="num">
                    <a href="#" class="on">1</a>
                    <a href="#">2</a>
                    <a href="#">3</a>
                    <a href="#">4</a>
                    <a href="#">5</a>
                    <a href="#">6</a>
                    <a href="#">7</a>
                </span>
                <span class="next">
                    <a href="#">다음&nbsp;</a>
                </span>
            </div>
            
            
        </article>

    </section>
    <!-- 상품 상세페이지 끝 -->
</main>

<jsp:include page="./_footer.jsp"/>
