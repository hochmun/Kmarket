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
	
	// 카테고리1값 변경시
	$('select[name=cate1]').change(()=>{
		const cate1 = $('select[name=cate1]').val();
		
		$.post('/Kmarket/admin/product/getCate2.do?cate1='+cate1,(data)=>{
			// 카테고리2값 넣기전 비우기
			$('select[name=cate2]').empty();
			$('select[name=cate2]').append("<option value=''>2차 분류 선택</option>");
			for(const vo of data) {
				// 카테고리2값 입력
				$('select[name=cate2]').append("<option value='"+vo.cate2+"'>"+vo.cate2Name+"</option>");
			}
		});
	});
	
	// 카테고리2값 변경시
	$('select[name=cate2]').change(()=>{
		const cate1 = $('select[name=cate1]').val();
		const cate2 = $('select[name=cate2]').val();
		
		const table = document.getElementById('listTable');
		
		$.post('/Kmarket/admin/cs/faq/list.do?cate1='+cate1+'&cate2='+cate2,(data)=>{
			$('#listTable tr:gt(0)').remove();
			for(const vo of data) {
				const tr = document.createElement('tr');
				
				const td1 = document.createElement('td');
				const input = document.createElement('input');
				input.setAttribute('type', 'checkbox');
				input.setAttribute('name', '상품코드')
				td1.appendChild(input);
				tr.appendChild(td1);
				
				const td2 = document.createElement('td');
				td2.innerText = vo.faqNo;
				tr.appendChild(td2);
				
				const td3 = document.createElement('td');
				td3.innerText = vo.cate1Name;
				tr.appendChild(td3);
				
				const td4 = document.createElement('td');
				td4.innerText = vo.cate2Name;
				tr.appendChild(td4);
				
				const td5 = document.createElement('td');
				const a = document.createElement('a');
				a.setAttribute('href','./view.do?faqNo='+vo.faqNo);
				a.innerText += vo.faqTitle;
				td5.appendChild(a);
				tr.appendChild(td5);
				
				const td6 = document.createElement('td');
				td6.innerText = vo.faqHit;
				tr.appendChild(td6);
				
				const td7 = document.createElement('td');
				td7.innerText = vo.faqRdate;
				tr.appendChild(td7);
				
				const td8 = document.createElement('td');
				const a2 = document.createElement('a');
				const a3 = document.createElement('a');
				a2.setAttribute('href','./delete.do?faqNo='+vo.faqNo);
				a2.setAttribute('id', 'deleteSingle');
				a3.setAttribute('href','./modify.do?faqNo='+vo.faqNo);
				a2.innerText = '[삭제]';
				a3.innerText = '[수정]';
				td8.appendChild(a2);
				td8.appendChild(a3);
				tr.appendChild(td8);
				
				table.appendChild(tr);
			}
		});
	});
	
	// 선택 삭제 버튼 클릭시
	$('.deleteAll').click((e)=>{
		// 이벤트 취소
		e.preventDefault();
		
		// 삭제 전 확인 의사 묻기
		const deleteOk = confirm('삭제 하시겠습니까?');
		if(deleteOk == false) return false;
		
		// 선택한 게시물을 받아옴
		const trs = $('input[name=상품코드]:checked').parent().parent();
		
		// 게시물 번호를 받을 문자열
		let arrayFaqNo = "";
		
		// 배열에 게시물 번호를 담음
		for(tr of trs) {
			td = tr.children[1].innerText;
			arrayFaqNo += td
					   += ", ";
		}
		
		// 값이 없을 경우 리턴
		if(arrayFaqNo == "") {
			alert('삭제 할 게시물을 선택 하십시오.');
			return false;
		}
		
		
		// ajax 전송
		$.ajax({
			url: '/Kmarket/admin/cs/faq/delete.do',
			type: 'post',
			data: {'faqNo':arrayFaqNo},
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
});

function deleteNotice() {
	const deleteOk = confirm('삭제 하시겠습니까?');
	if(deleteOk == false) return false;
}