<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../../_header.jsp"/>
    <section id="admin-product-list">
    
    <script type="text/javascript">
		$(document).ready(function() {
			$("#cbx_chkAll").click(function() {
				if($("#cbx_chkAll").is(":checked")) $("input[name=chk]").prop("checked", true);
				else $("input[name=chk]").prop("checked", false);
			});
			
			$("input[name=chk]").click(function() {
				var total = $("input[name=chk]").length;
				var checked = $("input[name=chk]:checked").length;
				
				if(total != checked) $("#cbx_chkAll").prop("checked", false);
				else $("#cbx_chkAll").prop("checked", true); 
			});
		});
	</script>
                <nav>
                    <h3>문의하기 목록</h3>
                    <p>
                        HOME > 고객센터 > <strong>문의하기</strong>
                    </p>
                </nav>
                <!-- 상품목록 컨텐츠 시작 -->                                
                <section>
                    <div>
                        <select name="search" class="w-btn-outline w-btn-indigo-outline">
                            <option value="search1" >1차 선택</option>
                            <option value="search1">상품코드</option>
                            <option value="search1">제조사</option>
                            <option value="search1">판매자</option>                                    
                        </select>
                        
                    </div>
                    <div>
                        <select name="search" class="w-btn-outline w-btn-indigo-outline">
                            <option value="search1">2차 선택</option>
                            <option value="search1">상품코드</option>
                            <option value="search1">제조사</option>
                            <option value="search1">판매자</option>                                    
                        </select>
                    </div>
                    <table>
                        <tr>
                            <th><input type="checkbox" id="cbx_chkAll"/></th>
                            <th>번호</th>
                            <th>1차유형</th>
                            <th>2차유형</th>
                            <th>제목</th>
                            <th>작성자</th>
                            <th>작성일</th>
                            <th>상태</th>
                        </tr>

                        <tr>
                            <td><input type="checkbox" name="chk"/></td>
                            <td>10</td>
                            <td>회원</td>
                            <td>가입</td>
                            <td>개인회원과 법인회원에 차이가 있나요?</td>
                            <td>10</td>
                            <td>00.00.00</td>
                            <td>
                                <a href="#">검토중</a>
                            </td>
                        </tr>
                         <tr>
                            <td><input type="checkbox" name="chk"/></td>
                            <td>10</td>
                            <td>회원</td>
                            <td>가입</td>
                            <td>본인인증 시 이미 가입되어 있는 정보라고 나옵니다.</td>
                            <td>120</td>
                            <td>00.00.00</td>
                            <td>
                               <a href="#">검토중</a>
                            </td>
                        </tr>
                         <tr>
                            <td><input type="checkbox" name="chk"/></td>
                            <td>10</td>
                            <td>회원</td>
                            <td>가입</td>
                            <td>개인회원과 법인회원에 차이가 있나요?</td>
                            <td>120</td>
                            <td>00.00.00</td>
                            <td>
                                <a href="#">답변완료</a>
                            </td>
                             </tr>
                         <tr>
                            <td><input type="checkbox" name="chk"/></td>
                            <td>10</td>
                            <td>회원</td>
                            <td>가입</td>
                            <td>개인회원과 법인회원에 차이가 있나요?</td>
                            <td>120</td>
                            <td>00.00.00</td>
                            <td>
                               <a href="#">답변완료</a>
                            </td>
                             </tr>
                         <tr>
                            <td><input type="checkbox" name="chk"/></td>
                            <td>10</td>
                            <td>회원</td>
                            <td>가입</td>
                            <td>개인회원과 법인회원에 차이가 있나요?</td>
                            <td>120</td>
                            <td>00.00.00</td>
                            <td>
                               <a href="#">답변완료</a>
                            </td>
                             </tr>
                         <tr>
                            <td><input type="checkbox" name="chk"/></td>
                            <td>10</td>
                            <td>회원</td>
                            <td>가입</td>
                            <td>개인회원과 법인회원에 차이가 있나요?</td>
                            <td>120</td>
                            <td>00.00.00</td>
                            <td>
                                <a href="#">답변완료</a>
                            </td>
                             </tr>
                         <tr>
                            <td><input type="checkbox" name="chk"/></td>
                            <td>10</td>
                            <td>회원</td>
                            <td>가입</td>
                            <td>개인회원과 법인회원에 차이가 있나요?</td>
                            <td>120</td>
                            <td>00.00.00</td>
                            <td>
                               <a href="#">답변완료</a>
                            </td>
                             </tr>
                         <tr>
                            <td><input type="checkbox" name="chk"/></td>
                            <td>10</td>
                            <td>회원</td>
                            <td>가입</td>
                            <td>개인회원과 법인회원에 차이가 있나요?</td>
                            <td>120</td>
                            <td>00.00.00</td>
                            <td>
                                <a href="#">답변완료</a>
                            </td>
                             </tr>
                         <tr>
                            <td><input type="checkbox" name="chk"/></td>
                            <td>10</td>
                            <td>회원</td>
                            <td>가입</td>
                            <td>개인회원과 법인회원에 차이가 있나요?</td>
                            <td>120</td>
                            <td>00.00.00</td>
                            <td>
                               <a href="#">답변완료</a>
                            </td>
                             </tr>
                         <tr>
                            <td><input type="checkbox" name="chk"/></td>
                            <td>10</td>
                            <td>회원</td>
                            <td>가입</td>
                            <td>개인회원과 법인회원에 차이가 있나요?</td>
                            <td>120</td>
                            <td>00.00.00</td>
                            <td>
                                <a href="#">답변완료</a>
                            </td>
                        </tr>
                        
                    </table>

                    <div class="btn1ro">
                    	<a href="./list.do" class="w-btn w-btn-indigo">선택삭제</a>
					</div>

                    <div class="paging">
                        <span class="prev">
                            <a href="#"><&nbsp;이전</a>
                        </span>
                        <span class="num">
                            <a href="#" class="w-btn-outline w-btn-blue-outline">1</a>
                            <a href="#" class="w-btn-outline w-btn-blue-outline">2</a>
                            <a href="#" class="w-btn-outline w-btn-blue-outline">3</a>
                            <a href="#" class="w-btn-outline w-btn-blue-outline">4</a>
                            <a href="#" class="w-btn-outline w-btn-blue-outline">5</a>
                            <a href="#" class="w-btn-outline w-btn-blue-outline">6</a>
                            <a href="#" class="w-btn-outline w-btn-blue-outline">7</a>
                        </span>
                        <span class="next">
                            <a href="#">다음&nbsp;></a>
                        </span>
                        </div>

                </section>              
    </div>
</section>
<jsp:include page="../../_footer.jsp"/>