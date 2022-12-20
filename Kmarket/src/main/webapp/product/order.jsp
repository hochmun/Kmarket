<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="./_header.jsp"/>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="./js/order.js"></script>
<script>
	const havingPoint = "${ mvo.point }"; // 유저가 현재 소지중인 포인트
	let productCartNoArray = [];
</script>
<c:set var="productCount" value="0"></c:set> <!-- 상품 갯수 -->
<c:set var="productPrice" value="0"></c:set> <!-- 상품 총 가격 -->
<c:set var="productDisprice" value="0"></c:set> <!-- 상품 총 할인 가격 -->
<c:set var="productDelivery" value="0"></c:set> <!-- 상품 총 배달 비 -->
<c:set var="productPoint" value="0"></c:set> <!-- 상품 총 포인트 -->
<c:set var="productTotal" value="0"></c:set> <!-- 상품 총 가격 -->
<!-- 주문 페이지 시작 -->
<section class="order">
    <!-- 제목, 페이지 네비게이션 -->
    <nav>
        <h1>주문결제</h1>
        <p>
            HOME > 장바구니 > <strong>주문결제</strong>
        </p>
    </nav>

    <form action="#">
        <!-- 주문 상품 목록 -->
        <table>
        
	         <tr>
	             <th>상품명</th>
	             <th>총수량</th>
	             <th>판매가</th>
	             <th>할인</th>
	             <th>포인트</th>
	             <th>배송비</th>
	             <th>소계</th>
	         </tr>
	         
	         <tr class="empty">
	             <td colspan="7">장바구니에 상품이 없습니다.</td>
	         </tr>
	         
	         <c:forEach var="pcvo" items="${ pcvos }">
	         	<script>
	         		productCartNoArray.push("${ pcvo.cartNo }");
	         	</script>
	         	<c:set var="productCount" value="${ productCount + 1 }"></c:set>
	         	<c:set var="productPrice" value="${ productPrice + ( pcvo.price * pcvo.count ) }"></c:set>
	         	<c:set var="productDisprice" value="${ productDisprice + ( ( ( pcvo.price * pcvo.count ) + pcvo.delivery ) - pcvo.total ) }"></c:set>
	         	<c:set var="productDelivery" value="${ productDelivery + pcvo.delivery }"></c:set>
	         	<c:set var="productPoint" value="${ productPoint + pcvo.point }"></c:set>
	         	<c:set var="productTotal" value="${ productTotal + pcvo.total }"></c:set>
	             	<tr>
						<td>
							<article>
								<a href="${pageContext.request.contextPath}/product/view.do?prodNo=${ pcvo.prodNo }"><img src="/thumb/${ pcvo.prodCate1 }/${ pcvo.prodCate2 }/${ pcvo.thumb1 }" alt="상품이미지"></a>
								<div>
									<h2><a href="${pageContext.request.contextPath}/product/view.do?prodNo=${ pcvo.prodNo }">${ pcvo.prodName }</a></h2>
									<p>${ pcvo.descript }</p>
						        </div>
						    </article>
						</td>
						<td>${ pcvo.count }</td>
						<td><fmt:formatNumber value="${ pcvo.price }" pattern="#,###"/></td>
						<td>${ pcvo.discount }%</td>
						<td><fmt:formatNumber value="${ pcvo.point }" pattern="#,###"/></td>
						
						<c:choose>
							<c:when test="${ pcvo.delivery gt 0 }">
								<td><fmt:formatNumber value="${ pcvo.delivery }" pattern="#,###"/></td>
							</c:when>
							<c:otherwise>
								<td>무료배송</td>
							</c:otherwise>
						</c:choose>
	                  
						<td><fmt:formatNumber value="${ pcvo.total }" pattern="#,###"/></td>
					</tr>
			</c:forEach>
         
        </table>

			<script>
				const productTotal2 = "${ productTotal }"; // 전체 결제 금액
				const savePoint = "${ productPoint }"; // 전체 결제 후 누적 포인트
			</script>

	        <!-- 최종 결제 정보 -->
	        <div class="final">
	            <h2>최종결제 정보</h2>
	            <table>
	                <tr>
	                    <td>총</td>
	                    <td id="totallyCount">${ productCount } 건</td>
	                </tr>
	                <tr>
	                    <td>상품금액</td>
	                    <td id="totallyPrice"><fmt:formatNumber value="${ productPrice }" pattern="#,###"/></td>
	                </tr>
	                <tr>
	                    <td>할인금액</td>
	                    <td id="totallyDisprice"><fmt:formatNumber value="${ productDisprice }" pattern="#,###"/></td>
	                </tr>
	                <tr>
	                    <td>배송비</td>
	                    <td id="totallyDelivery"><fmt:formatNumber value="${ productDelivery }" pattern="#,###"/></td>
	                </tr>
	                <tr>
	                    <td>포인트 할인</td>
	                    <td id="totallyPoint">0</td>
	                </tr>
	                <tr>
	                    <td>전체주문금액</td>
	                    <td id="totallyTotal"><fmt:formatNumber value="${ productTotal }" pattern="#,###"/></td>
	                </tr>
	            </table>
	            <input type="button" name="" value="결제하기" onclick="orderComplete()">
	        </div>

	        <!-- 배송정보 -->
	        <article class="delivery">
	            <h1>배송정보</h1>
	            <table>
	                <tr>
	                    <td>주문자</td>
	                    <td><input type="text" name="orderer"/></td>
	                </tr>
	                <tr>
	                    <td>휴대폰</td>
	                    <td><input type="text" name="hp" onchange="isHpCheck(this.value)"/>
	                        <span>- 포함 입력</span>&nbsp;&nbsp;<span class="msgHp"></span>
	                    </td>
	                </tr>
	                <tr>
	                    <td>우편번호</td>
	                    <td>
	                        <input type="text" name="zip" id="zip" readonly="readonly"/>
	                        <input type="button" value="검색" onclick="zipcode()"/>
	                    </td>
	                </tr>
	                <tr>
	                    <td>기본주소</td>
	                    <td>
	                        <input type="text" name="addr1" id="addr1" readonly="readonly"/>
	                    </td>
	                </tr>
	                <tr>
	                    <td>상세주소</td>
	                    <td>
	                        <input type="text" name="addr2" id="addr2"/>
	                    </td>
	                </tr>
	            </table>
	        </article>

	        <!-- 할인정보 -->
	        <article class="discount">
	            <h1>할인정보</h1>
	            
	            <div>
	                <p>현재 포인트 : <span><fmt:formatNumber value="${ mvo.point }" pattern="#,###"/></span>점</p>
	                
	                <c:choose>
	                	<c:when test="${ mvo.point gt 4999 }">
	                		<label>
			                    <input type="text" name="point"/>점
			                    <input type="button" value="적용" onclick="usedPoint()"></input>
			                </label>
	                	</c:when>
	                </c:choose>
	                
	                <span>포인트 5,000점 이상이면 현금처럼 사용 가능합니다.</span>
	            </div>
	        </article>

        	<!-- 결제방법 -->
	        <article class="payment">
	            <h1>결제방법</h1>
	            <div>
	                <span>신용카드</span>
	                <p>
	                    <label><input type="radio" name="payment" value="1"/>신용카드 결제</label>
	                    <label><input type="radio" name="payment" value="2"/>체크카드 결제</label>
	                </p>
	            </div>
	            <div>
	                <span>계좌이체</span>
	                <p>
	                    <label><input type="radio" name="payment" value="3"/>실시간 계좌이체</label>
	                    <label><input type="radio" name="payment" value="4"/>무통장 입금</label>
	                </p>
	            </div>
	            <div>
	                <span>기타</span>
	                <p>
	                    <label><input type="radio" name="payment" value="5"/>휴대폰결제</label>
	                    <label>
	                        <input type="radio" name="payment" value="6"/>카카오페이
	                        <img src="../img/ico_kakaopay.gif" alt="카카오페이"/>
	                    </label>
					</p>
				</div>
			</article>

			<!-- 경고 -->
			<article class="alert">
				<ul>
					<li><span>케이마켓의 모든 판매자는 안전거래를 위해 구매금액, 결제수단에 상관없이 모든거래에 대하여 케이마켓 유한책임회사의 구매안전서비스(에스크로)를 제공하고 있습니다.</span></li>
					<li><span>케이마켓 유한책임회사의 전자금융거래법에 의해 결제대금예치업 등록번호는 02-006-00008 입니다.</span></li>
					<li><span>등록여부는 금융감독원 홈페이지(www.fss.or.kr)의 업무자료>인허가업무안내>전자금융업등록현황에서 확인하실수 있습니다.</span></li>
				</ul>
			</article>

		</form>

	</section>
	<!-- 주문 페이지 끝 -->
</main>
<jsp:include page="./_footer.jsp"/>