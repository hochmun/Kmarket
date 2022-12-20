<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../../_header.jsp"/>
    <section id="admin-product-list">
    <script type="text/javascript">
		$(document).ready(function() {
			$("#cbx_chkAll").click(function() {
				if($("#cbx_chkAll").is(":checked")) $("input[name=상품코드]").prop("checked", true);
				else $("input[name=상품코드]").prop("checked", false);
			});
			
			$("input[name=상품코드]").click(function() {
				var total = $("input[name=상품코드]").length;
				var checked = $("input[name=상품코드]:checked").length;
				
				if(total != checked) $("#cbx_chkAll").prop("checked", false);
				else $("#cbx_chkAll").prop("checked", true); 
			});
		});
	</script>
                <nav>
                    <h3>자주묻는질문 목록</h3>
                    <p>
                        HOME > 고객센터 > <strong>자주묻는질문</strong>
                    </p>
                </nav>
                <!-- 상품목록 컨텐츠 시작 -->                                
                <section>
                    <div>
                        <select name="search" class="w-btn-outline w-btn-indigo-outline">
                            <option value="search1">1차 선택</option>
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
                            <th>조회</th>
                            <th>날짜</th>
                            <th>관리</th>
                        </tr>

                        <tr>
                            <td><input type="checkbox" name="상품코드"/></td>
                            <td>10</td>
                            <td>회원</td>
                            <td>가입</td>
                            <td>개인회원과 법인회원에 차이가 있나요?</td>
                            <td>10</td>
                            <td>00.00.00</td>
                            <td>
                                <a href="#">[삭제]</a>
                                <a href="./modify.do">[수정]</a>
                            </td>
                        </tr>
                         <tr>
                            <td><input type="checkbox" name="상품코드"/></td>
                            <td>10</td>
                            <td>회원</td>
                            <td>가입</td>
                            <td>본인인증 시 이미 가입되어 있는 정보라고 나옵니다.</td>
                            <td>120</td>
                            <td>00.00.00</td>
                            <td>
                                <a href="#">[삭제]</a>
                                <a href="./modify.do">[수정]</a>
                            </td>
                        </tr>
                         <tr>
                            <td><input type="checkbox" name="상품코드"/></td>
                            <td>10</td>
                            <td>회원</td>
                            <td>가입</td>
                            <td>개인회원과 법인회원에 차이가 있나요?</td>
                            <td>120</td>
                            <td>00.00.00</td>
                            <td>
                                <a href="#">[삭제]</a>
                                <a href="./modify.do">[수정]</a>
                            </td>
                             </tr>
                         <tr>
                            <td><input type="checkbox" name="상품코드"/></td>
                            <td>10</td>
                            <td>회원</td>
                            <td>가입</td>
                            <td>개인회원과 법인회원에 차이가 있나요?</td>
                            <td>120</td>
                            <td>00.00.00</td>
                            <td>
                                <a href="#">[삭제]</a>
                                <a href="./modify.do">[수정]</a>
                            </td>
                             </tr>
                         <tr>
                            <td><input type="checkbox" name="상품코드"/></td>
                            <td>10</td>
                            <td>회원</td>
                            <td>가입</td>
                            <td>개인회원과 법인회원에 차이가 있나요?</td>
                            <td>120</td>
                            <td>00.00.00</td>
                            <td>
                                <a href="#">[삭제]</a>
                                <a href="./modify.do">[수정]</a>
                            </td>
                             </tr>
                         <tr>
                            <td><input type="checkbox" name="상품코드"/></td>
                            <td>10</td>
                            <td>회원</td>
                            <td>가입</td>
                            <td>개인회원과 법인회원에 차이가 있나요?</td>
                            <td>120</td>
                            <td>00.00.00</td>
                            <td>
                                <a href="#">[삭제]</a>
                                <a href="./modify.do">[수정]</a>
                            </td>
                             </tr>
                         <tr>
                            <td><input type="checkbox" name="상품코드"/></td>
                            <td>10</td>
                            <td>회원</td>
                            <td>가입</td>
                            <td>개인회원과 법인회원에 차이가 있나요?</td>
                            <td>120</td>
                            <td>00.00.00</td>
                            <td>
                                <a href="#">[삭제]</a>
                                <a href="./modify.do">[수정]</a>
                            </td>
                             </tr>
                         <tr>
                            <td><input type="checkbox" name="상품코드"/></td>
                            <td>10</td>
                            <td>회원</td>
                            <td>가입</td>
                            <td>개인회원과 법인회원에 차이가 있나요?</td>
                            <td>120</td>
                            <td>00.00.00</td>
                            <td>
                                <a href="#">[삭제]</a>
                                <a href="./modify.do">[수정]</a>
                            </td>
                             </tr>
                         <tr>
                            <td><input type="checkbox" name="상품코드"/></td>
                            <td>10</td>
                            <td>회원</td>
                            <td>가입</td>
                            <td>개인회원과 법인회원에 차이가 있나요?</td>
                            <td>120</td>
                            <td>00.00.00</td>
                            <td>
                                <a href="#">[삭제]</a>
                                <a href="./modify.do">[수정]</a>
                            </td>
                             </tr>
                         <tr>
                            <td><input type="checkbox" name="상품코드"/></td>
                            <td>10</td>
                            <td>회원</td>
                            <td>가입</td>
                            <td>개인회원과 법인회원에 차이가 있나요?</td>
                            <td>120</td>
                            <td>00.00.00</td>
                            <td>
                                <a href="#">[삭제]</a>
                                <a href="./modify.do">[수정]</a>
                            </td>
                        </tr>
                        
                    </table>

                    
                    <a href="./list.do" class="w-btn w-btn-indigo">선택삭제</a>  
                    <a href="./list.do" class="w-btn w-btn-gra3 w-btn-gra-anim">수정하기</a>              


                    <div class="paging">
                        <span class="prev">
                            <a href="#"><&nbsp;이전</a>
                        </span>
                        <span class="num">
                            <a class="w-btn-outline w-btn-green-outline" href="#" class="on">1</a>
                            <a class="w-btn-outline w-btn-green-outline" href="#">2</a>
                            <a class="w-btn-outline w-btn-green-outline" href="#">3</a>
                            <a class="w-btn-outline w-btn-green-outline" href="#">4</a>
                            <a class="w-btn-outline w-btn-green-outline" href="#">5</a>
                            <a class="w-btn-outline w-btn-green-outline" href="#">6</a>
                            <a class="w-btn-outline w-btn-green-outline" href="#">7</a>
                        </span>
                        <span class="next">
                            <a href="#">다음&nbsp;></a>
                        </span>
                        </div>

                </section>              
    </div>
</section>
<jsp:include page="../../_footer.jsp"/>