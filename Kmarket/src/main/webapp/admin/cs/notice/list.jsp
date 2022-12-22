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
                    <h3>공지사항 목록</h3>
                    <p>
                        HOME > 고객센터 > <strong>공지사항</strong>
                    </p>
                </nav>
                <!-- 상품목록 컨텐츠 시작 -->                                
                <section>
                    <div>
                        <select name="search" class="w-btn-outline w-btn-indigo-outline" >
                            <option value="search1">유형 선택</option>
                            <option value="search1">상품코드</option>
                            <option value="search1">제조사</option>
                            <option value="search1">판매자</option>                                    
                        </select>
                        
                    </div>
                    <table>
                        <tr>
                            <th style="width: 5%;"><input type="checkbox" id="cbx_chkAll"/></th>
                            <th style="width: 5%;">번호</th>
                            <th style="width: 11%;">유형</th>
                            <th style="width: auto;">제목</th>
                            <th style="width: 5%;">조회</th>
                            <th style="width: 9%;">날짜</th>
                            <th style="width: 5%;">관리</th>
                        </tr>

                        <tr>
                            <td><input type="checkbox" name="상품코드"/></td>
                            <td>100</td>
                            <td>고객서비스</td>
                            <td>[안내] 해외결제 사칭 문자 주의</td>
                            <td>120</td>
                            <td>00.00.00</td>
                            <td>
                                <a href="#">[삭제]</a>
                                <a href="./modify.do">[수정]</a>
                            </td>
                        </tr>
                        
                        <tr>
                            <td><input type="checkbox" name="상품코드"/></td>
                            <td>99</td>
                            <td>이벤트 당첨</td>
                            <td>[발표] G.Live X SK스토아(하남쭈꾸미)이벤트 당첨자</td>
                            <td>120</td>
                            <td>00.00.00</td>
                            <td>
                                <a href="#">[삭제]</a>
                                <a href="./modify.do">[수정]</a>
                            </td>
                        </tr>
                        <tr>
                            <td><input type="checkbox" name="상품코드"/></td>
                            <td>98</td>
                            <td>안전거래</td>
                            <td>[안내] 로젠택배 반품/교환 수거지시 지연 안내</td>
                            <td>120</td>
                            <td>00.00.00</td>
                            <td>
                                <a href="#">[삭제]</a>
                                <a href="./modify.do">[수정]</a>
                            </td>
                        </tr>
                        <tr>
                            <td><input type="checkbox" name="상품코드"/></td>
                            <td>97</td>
                            <td>위해상품</td>
                            <td>[위해상품정보] 무주꾸지뽕 지도점검 회수사유적발</td>
                            <td>120</td>
                            <td>00.00.00</td>
                            <td>
                                <a href="#">[삭제]</a>
                                <a href="./modify.do">[수정]</a>
                            </td>
                        </tr>
                        <tr>
                            <td><input type="checkbox" name="상품코드"/></td>
                            <td>96</td>
                            <td>고객서비스</td>
                            <td>[안내] 씨티은행 시스템 점검에 따른 계좌, 체크카드...</td>
                            <td>120</td>
                            <td>00.00.00</td>
                            <td>
                                <a href="#">[삭제]</a>
                                <a href="./modify.do">[수정]</a>
                            </td>
                        </tr>
                        <tr>
                            <td><input type="checkbox" name="상품코드"/></td>
                            <td>95</td>
                            <td>고객서비스</td>
                            <td>[안내] 구매회원 이용약관 개정</td>
                            <td>120</td>
                            <td>00.00.00</td>
                            <td>
                                <a href="#">[삭제]</a>
                                <a href="./modify.do">[수정]</a>
                            </td>
                        </tr>
                        <tr>
                            <td><input type="checkbox" name="상품코드"/></td>
                            <td>94</td>
                            <td>고객서비스</td>
                            <td>[안내] 해외결제 사칭 문자 주의</td>
                            <td>120</td>
                            <td>00.00.00</td>
                            <td>
                                <a href="#">[삭제]</a>
                                <a href="./modify.do">[수정]</a>
                            </td>
                        </tr>
                        <tr>
                            <td><input type="checkbox" name="상품코드"/></td>
                            <td>93</td>
                            <td>고객서비스</td>
                            <td>[안내] 해외결제 사칭 문자 주의</td>
                            <td>120</td>
                            <td>00.00.00</td>
                            <td>
                                <a href="#">[삭제]</a>
                                <a href="./modify.do">[수정]</a>
                            </td>
                        </tr>
                        <tr>
                            <td><input type="checkbox" name="상품코드"/></td>
                            <td>92</td>
                            <td>고객서비스</td>
                            <td>[안내] 해외결제 사칭 문자 주의</td>
                            <td>120</td>
                            <td>00.00.00</td>
                            <td>
                                <a href="#">[삭제]</a>
                                <a href="./modify.do">[수정]</a>
                            </td>
                        </tr>
                        <tr>
                            <td><input type="checkbox" name="상품코드"/></td>
                            <td>91</td>
                            <td>고객서비스</td>
                            <td>[안내] 해외결제 사칭 문자 주의</td>
                            <td>120</td>
                            <td>00.00.00</td>
                            <td>
                                <a href="#">[삭제]</a>
                                <a href="./modify.do">[수정]</a>
                            </td>
                        </tr>
                        
                    </table>

					<div class="btn2ro">
                     <a href="#" class="w-btn w-btn-indigo">선택삭제</a>
                     <a href="./write.do" class="w-btn w-btn-green">작성하기</a>                     
					</div>

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