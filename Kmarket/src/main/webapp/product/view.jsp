<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="./_header.jsp"/>
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
                            <li><a href="#">노트북/PC</a></li>
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
                            <li><a href="#">생활용품</a></li>
                            <li><a href="#">사무용품</a></li>
                        </ol>
                    </li>
                </ul>
            </aside>

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
                        <img src="/home/kmarket/thumb/${ vo.prodCate1 }/${ vo.prodCate2 }/${ vo.thumb3 }" alt="상품이미지"/>
                    </div>
                    <div class="summary">
                        <nav>
                            <h1>${ vo.seller }</h1>
                            <h2>상품번호&nbsp;:&nbsp;<span>${ vo.prodNo }</span></h2>
                        </nav>
                        <nav>
                            <h3>${ vo.prodName }</h3>
                            <p>${ vo.descript }</p>
                            <h5 class="rating star4"><a href="#">상품평보기</a></h5>
                        </nav>
                        <nav>
                        	<c:choose>
                        		<c:when test="${ vo.discount gt 0 }">
                        			<div class="org_price">
		                                <del>${ vo.price }</del>
		                                <span>${ vo.discount }%</span>
		                            </div>
		                            <div class="dis_price">
		                                <ins>${ disprice }</ins>
		                            </div>
                        		</c:when>
                        		<c:otherwise>
                        			<div class="dis_price">
		                                <ins>${ vo.price }</ins>
		                            </div>
                        		</c:otherwise>
                        	</c:choose>
                        	
                        
                            
                        </nav>
                        <nav>
	                        <c:choose>
	                        	<c:when test="${ vo.delivery gt 0 }">
	                        		<span class="delivery">배송비 ${ vo.delivery }원</span>
	                        	</c:when>
	                        	<c:otherwise>
	                        		<span class="delivery">무료배송</span>
	                        	</c:otherwise>
	                        </c:choose>
                            <span class="arrival" id="arrival"></span>
                            <script>
                            	// 배송 도착일자 3일후 설정
	                        	var now = new Date();
	                        	const after = new Date(now.setDate(now.getDate()+3));
	                        	const arrival = after.toLocaleDateString('ko', {
	                        		weekday: 'short',
	                        		month: 'short',
	                        		day: 'numeric'
	                        	});
	                        	document.getElementById("arrival").innerText=arrival+" 도착예정";
	                        </script>
                            <span class="desc">본 상품은 국내배송만 가능합니다.</span>
                        </nav>
                        <nav>
                            <span class="card cardfree"><i>아이콘</i>무이자할부</span>&nbsp;&nbsp;
                            <span class="card cardadd"><i>아이콘</i>카드추가혜택</span>
                        </nav>
                        <nav>
                            <span class="origin">${ vo.origin }</span>
                        </nav>
                        <img src="../img/vip_plcc_banner.png" alt="100원만 결제해도 1만원 적립!" class="banner"/>
                        <div class="count">
                            <button class="decrease" id="decrease" >-</button>
                            <input type="text" name="num" value="1" readonly/>
                            <button class="increase" id="increase">+</button>
                        </div>

                        <div class="total">
                            <span>35,000</span>
                            <em>총 상품금액</em>
                        </div>
                        
                        <!-- 주문 갯수 스크립트 -->
                        <script>
                        	function(type) {
                        		// 변화하는 값
                        		const num = document.getElementsByName("num");
                        		
                        		// 현재 표시된 값
                        		let number = num.innerText;
                        		
                        		// 더하기 빼기
                        		if(type === 'plus') {
                        			number = parseInt(number)+1;
                        		} else if(type === 'minus' && parseInt(number) > 1) {
                        			number = parseInt(number)-1;
                        		}
                        		
                        		// 결과 출력
                        		num.innerText = number;
                        	}
                        </script>
                        
                        <div class="button">
                            <input type="button" class="cart" value="장바구니"/>
                            <input type="button" class="order" value="구매하기"/>
                        </div>
                    </div>
                </article>

                <!-- 상품 정보 내용 -->
                <article class="detail">
                    <nav>
                        <h1>상품정보</h1>
                    </nav>
                    <!-- 상품상세페이지 이미지 -->
                    <img src="/home/kmarket/thumb/${ vo.prodCate1 }/${ vo.prodCate2 }/${ vo.detail }" alt="상세페이지">
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
                    <div class="paging">
                        <span class="prev">
                            <a href="#"><&nbsp;이전</a>
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