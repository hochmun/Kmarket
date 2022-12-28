<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="./_header.jsp"/>
<script>
	$(()=>{
		// 동의하기 클릭시
		$('.agree').click(()=>{
			// agree 1~3 체크 확인
			if($('input[name=agree1]').is(':checked') &&
				$('input[name=agree2]').is(':checked') &&
				$('input[name=agree3]').is(':checked')) {
				
				// agree4 체크 값 받아오기
				const agree4 = $('input[name=agree4]').is(':checked');
				
				// url에서 type 값 받아오기
				const url = new URL(window.location.href);
				const urlParams = url.searchParams;
				const type = urlParams.get('type');
				
				// 타입 값에 따라 페이지 이동 및 agree4 동의 결과 전송
				if(type == 1) {
					location.href = '/Kmarket/member/register.do?agree4='+agree4;
				} else if (type == 2) {
					location.href = '/Kmarket/member/registerSeller.do?agree4='+agree4;
				}
				
			} else {
				alert('필수 약관 동의에 체크를 하셔야 합니다.');
				return false;
			}
		});
	});
</script>
<main id="member">
    <div class="signup">
        <nav>
            <h1>약관동의</h1>
        </nav>
        <section>
        	<c:choose>
        		<c:when test="${ param.type eq 1 }">
        			<h3><span class="essential">(필수)</span>케이마켓 이용약관</h3>
            		<textarea class="terms" readonly>${ vo.terms }</textarea>
            		<label><input type="checkbox" name="agree1"/>동의합니다.</label>
        		</c:when>
            	<c:when test="${ param.type eq 2 }">
            		<h3><span class="essential">(필수)</span>케이마켓 판매자 이용약관</h3>
            		<textarea class="tax" readonly>${ vo.tax }</textarea>
            		<label><input type="checkbox" name="agree1"/>동의합니다.</label>
            	</c:when>
			</c:choose>
            <h3><span class="essential">(필수)</span>전자금융거래 이용약관</h3>
            <textarea class="financial" readonly>${ vo.finance }</textarea>
            <label><input type="checkbox" name="agree2"/>동의합니다.</label>

            <h3><span class="essential">(필수)</span>개인정보 수집동의</h3>
            <textarea class="privacy" readonly>${ vo.privacy }</textarea>
            <label><input type="checkbox" name="agree3"/>동의합니다.</label>
        </section>

        <section>
            <h3><span class="optional">(선택)</span>위치정보 이용약관</h3>
            <textarea class="location" readonly>${ vo.location }</textarea>
            <label><input type="checkbox" name="agree4"/>동의합니다.</label>
        </section>

        <div>
            <input type="button" class="agree" value="동의하기">
        </div>
    </div>
</main>
<jsp:include page="./_footer.jsp"/>        