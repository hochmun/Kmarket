<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../../_header.jsp"/>
    <section id="admin-product-list">
                <nav>
                    <h3>공지사항 목록</h3>
                    <p>
                        HOME > 고객센터 > <strong>공지사항</strong>
                    </p>
                </nav>
                <!-- 상품목록 컨텐츠 시작 -->                                
                <section>
                    <div>
                        <select name="search">
                            <option value="search1">유형 선택</option>
                            <option value="search1">상품코드</option>
                            <option value="search1">제조사</option>
                            <option value="search1">판매자</option>                                    
                        </select>
                        
                    </div>
                    <table>
                        <tr>
                            <th><input type="checkbox" name="all"/></th>
                            <th>번호</th>
                            <th>유형</th>
                            <th>제목</th>
                            <th>조회</th>
                            <th>날짜</th>
                            <th>관리</th>
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
                                <a href="#">[수정]</a>
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
                                <a href="#">[수정]</a>
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
                                <a href="#">[수정]</a>
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
                                <a href="#">[수정]</a>
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
                                <a href="#">[수정]</a>
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
                                <a href="#">[수정]</a>
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
                                <a href="#">[수정]</a>
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
                                <a href="#">[수정]</a>
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
                                <a href="#">[수정]</a>
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
                                <a href="#">[수정]</a>
                            </td>
                        </tr>
                        
                    </table>

                    
                    <input type="button" value="선택삭제" />                          
                    <input type="button" value="작성하기" />                          


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
                            <a href="#">다음&nbsp;></a>
                        </span>
                        </div>

                </section>              
    </div>
</section>
<jsp:include page="../../_footer.jsp"/>