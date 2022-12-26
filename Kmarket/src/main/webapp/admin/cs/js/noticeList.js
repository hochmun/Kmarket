$(()=>{
	// 전체 클릭
	$("#cbx_chkAll").click(function() {
		if($("#cbx_chkAll").is(":checked")) $("input[name=상품코드]").prop("checked", true);
		else $("input[name=상품코드]").prop("checked", false);
	});
	
	// 개별 클릭
	$("input[name=상품코드]").click(function() {
		var total = $("input[name=상품코드]").length;
		var checked = $("input[name=상품코드]:checked").length;
		
		if(total != checked) $("#cbx_chkAll").prop("checked", false);
		else $("#cbx_chkAll").prop("checked", true); 
	});
	
	// 선택 삭제 버튼 클릭시
	$('.deleteAll').click((e)=>{
		e.preventDefault();
		
		const deleteOk = confirm('삭제 하시겠습니까?');
		if(deleteOk == false) return false;
		
		// 선택한 게시물을 받아옴
		const trs = $('input[name=상품코드]:checked').parent().parent();
		
		// 게시물 번호를 받을 문자열
		let arrayNoticeNo = "";
		
		// 배열에 게시물 번호를 담음
		for(tr of trs) {
			td = tr.children[1].innerText;
			arrayNoticeNo += td
					   += ", ";
		}
		
		// 값이 없을 경우 리턴
		if(arrayNoticeNo == "") {
			alert('삭제 할 게시물을 선택 하십시오.');
			return false;
		}
		
		// ajax 전송
		$.ajax({
			url: '/Kmarket/admin/cs/notice/delete.do',
			type: 'get',
			data: {'n':arrayNoticeNo, 't':2},
			dataType: 'json',
			success: (data)=>{
				if(data.result > 0) {
					alert('게시물 삭제에 성공 했습니다.');
					trs.remove();
				} else {
					alert('게시물 삭제에 실패 하였습니다.');
				}
			}
		});
	});
	
	// 타입 선택시 동적 처리
	$('select[name=type]').change(function(){
		const t = $(this).val();
		$.ajax({
			url:'/Kmarket/admin/cs/notice/list.do',
			type: 'POST',
			data: {"t":t},
			dataType: 'json',
			success: (data)=>{
				const table = document.querySelector('table');
				const div = document.getElementsByClassName('paging')[0];
				
				// 기본 내용 제거
				$('.VOStableList tr:gt(0)').remove();
				$('.paging').children().remove();
				
				// 내용
				for(vo of data.vos) {
					// 행 추가
					const tr = table.insertRow();
					
					// 셀 추가
					const td1 = tr.insertCell(0);
					const input = document.createElement('input');
					input.setAttribute('type', 'checkbox');
					input.setAttribute('name', '상품코드');
					td1.appendChild(input);

					const td2 = tr.insertCell(1);
					td2.textContent = vo.noticeNo;
					
					const td3 = tr.insertCell(2);
					if(vo.noticeCate == 10) td3.textContent = '고객서비스';
					if(vo.noticeCate == 11) td3.textContent = '안전거래';
					if(vo.noticeCate == 12) td3.textContent = '위해상품';
					if(vo.noticeCate == 13) td3.textContent = '이벤트상품';
					
					const td4 = tr.insertCell(3);
					const a3 = document.createElement('a');
					a3.setAttribute('href', './view.do?p=1&t='+t+'&n='+vo.noticeNo);
					a3.textContent = vo.noticeTitle;
					td4.appendChild(a3);
					
					const td5 = tr.insertCell(4);
					td5.textContent = vo.noticeHit;
					
					const td6 = tr.insertCell(5);
					td6.textContent = vo.noticeRdate;
					
					const td7 = tr.insertCell(6);
					const a1 = document.createElement('a');
					const a2 = document.createElement('a');
					a1.setAttribute('href', './delete.do?n='+vo.noticeNo);
					a1.setAttribute('id', 'deleteSingle');
					a2.setAttribute('href', './modify.do?p=1&t='+t+'&n='+vo.noticeNo);
					a1.textContent = '[삭제]';
					a2.textContent = '[수정]';
					td7.appendChild(a1);
					td7.appendChild(a2);
				}
				
				// 페이징 추가
				if(data.pageGroupStart > 1) {
					const span1 = document.createElement('span');
					span1.setAttribute('class', 'prev');
					const a10 = document.createElement('a');
					a10.setAttribute('href', '/Kmarket/admin/cs/notice/list.do?p='+(data.pageGroupStart-1)+'&t='+t);
					a10.textContent = ' 이전';
					span1.appendChild(a10);
					div.appendChild(span1);
				}
				
				const span2 = document.createElement('span');
				span2.setAttribute('class', 'num');
				for(let i = data.pageGroupStart; i <= data.pageGroupEnd; i++) {
					const a11 = document.createElement('a');
					a11.setAttribute('href', '/Kmarket/admin/cs/notice/list.do?p='+i+'&t='+t);
					if(data.currentPage == i) a11.setAttribute('class', 'on');
					a11.textContent = i;
					span2.appendChild(a11);
				}
				div.appendChild(span2);
				
				if(data.pageGroupEnd < data.lastPageNum) {
					const span3 = document.createElement('span');
					span3.setAttribute('class', 'next');
					const a12 = document.createElement('a');
					a12.setAttribute('href', '/Kmarket/admin/cs/notice/list/do?p='+(data.pageGroupEnd+1)+'&t='+t);
					a12.textContent = '다음 ';
					span3.appendChild(a12);
					div.appendChild(span3);
				}
				
			}
		});
	});
});

function deleteNotice() {
	const deleteOk = confirm('삭제 하시겠습니까?');
	if(deleteOk == false) return false;
}