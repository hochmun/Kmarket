<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../../_header.jsp"/>
<script src="../js/faqList.js"></script>
	<section id="admin-product-list">
		<nav>
			<h3>자주묻는질문 목록</h3>
			<p>
				HOME > 고객센터 > <strong>자주묻는질문</strong>
			</p>
		</nav>
		<!-- 상품목록 컨텐츠 시작 -->                                
		<section>
	      
			<div>
				<select name="cate1" class="w-btn-outline w-btn-indigo-outline">
					<option value="">1차 선택</option>
	                  
					<c:forEach var="vo2" items="${ vos2 }">
						<option value="${ vo2.cate1 }">${ vo2.cate1Name }</option>
					</c:forEach>
	                  
				</select>
	              
			</div>
			<div>
				<select name="cate2" class="w-btn-outline w-btn-indigo-outline">
					<option value="">2차 선택</option>
				</select>
			</div>
	          
	          
			<table id="listTable">
				<tr>
					<th><input type="checkbox" id="cbx_chkAll"/></th>
					<th>번호</th>
					<th>1차유형</th>
					<th>2차유형</th>
					<th>제목</th>
					<th>조회</th>
					<th>날짜</th>
					<th>관리</th>
				</tr>
	              
				<c:forEach var="vo" items="${ vos }">
	              	
					<tr>
						<td><input type="checkbox" name="상품코드"/></td>
						<td>${ vo.faqNo }</td>
						<td>${ vo.cate1Name }</td>
						<td>${ vo.cate2Name }</td>
						<td><a href="${pageContext.request.contextPath}/admin/cs/faq/view.do?faqNo=${ vo.faqNo }">${ vo.faqTitle }</a></td>
						<td>${ vo.faqHit }</td>
						<td>${ vo.faqRdate }</td>
						<td>
							<a href="./delete.do?faqNo=${ vo.faqNo }" onclick="deleteNotice()">[삭제]</a>
							<a href="./modify.do?faqNo=${ vo.faqNo }">[수정]</a>
						</td>
					</tr>
	              	
				</c:forEach>
	                   
			</table>
	
			<div class="btn2ro">
				<a href="#" class="w-btn w-btn-indigo deleteAll">선택삭제</a>  
				<a href="./write.do" class="w-btn w-btn-green">작성하기</a> 
			</div>
	
		</section>
	</section>
</main>
<jsp:include page="../../_footer.jsp"/>