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
		const div = document.getElementsByClassName('paging')[0];
		
		$.post('/Kmarket/admin/cs/qna/list.do?cate1='+cate1+'&cate2='+cate2,(data)=>{
			$('#listTable tr:gt(0)').remove();
			for(const vo of data.vos) {
				const tr = document.createElement('tr');
				
				const td1 = document.createElement('td');
				const input = document.createElement('input');
				input.setAttribute('type', 'checkbox');
				input.setAttribute('name', '상품코드')
				td1.appendChild(input);
				tr.appendChild(td1);
				
				const td2 = document.createElement('td');
				td2.innerText = vo.qnaNo;
				tr.appendChild(td2);
				
				const td3 = document.createElement('td');
				td3.innerText = vo.cate1Name;
				tr.appendChild(td3);
				
				const td4 = document.createElement('td');
				td4.innerText = vo.cate2Name;
				tr.appendChild(td4);
				
				const td5 = document.createElement('td');
				const a = document.createElement('a');
				a.setAttribute('href','/Kmarket/admin/cs/qna/reply.do?qnaNo='+vo.qnaNo);
				a.innerText += vo.qnaTitle;
				td5.appendChild(a);
				tr.appendChild(td5);
				
				const td6 = document.createElement('td');
				td6.innerText = vo.uid;
				tr.appendChild(td6);
				
				const td7 = document.createElement('td');
				td7.innerText = vo.qnaRdate;
				tr.appendChild(td7);
				
				const td8 = document.createElement('td');
				if(vo.qnaType == 1){
					td8.innerText = '검토중'
				}else{
					td8.innerText = '답변완료'
				}
				tr.appendChild(td8);
				
				table.appendChild(tr);
				
				
			}
			
			
			
			$('.paging span').remove();
			
			
			// 페이징 추가
			if(data.pageGroupStart > 1) {
				const span1 = document.createElement('span');
				span1.setAttribute('class', 'prev');
				const a10 = document.createElement('a');
				a10.setAttribute('href', '/Kmarket/admin/cs/qna/list.do?pg='+(data.pageGroupStart-1)+'&cate1='+cate1+'&cate2='+cate2);
				a10.textContent = ' 이전';
				span1.appendChild(a10);
				div.appendChild(span1);
			}
			
			const span2 = document.createElement('span');
			span2.setAttribute('class', 'num');
			console.log("pageGroupEnd"+data.pageGroupEnd);
			console.log("pageGroupStart"+data.pageGroupStart);
			
			for(let pg = data.pageGroupStart; pg <= data.pageGroupEnd; pg++) {
				const a11 = document.createElement('a');
				a11.setAttribute('href', '/Kmarket/admin/cs/qna/list.do?pg='+pg+'&cate1='+cate1+'&cate2='+cate2);
				if(data.currentPage == pg) a11.setAttribute('class', 'w-btn-outline w-btn-blue-outline on');
				a11.textContent = pg;
				span2.appendChild(a11);
				div.appendChild(span2);
			}
			
			if(data.pageGroupEnd < data.lastPageNum) {
				const span3 = document.createElement('span');
				span3.setAttribute('class', 'next');
				const a12 = document.createElement('a');
				a12.setAttribute('href', '/Kmarket/admin/cs/qna/list/do?pg='+(data.pageGroupEnd+1)+'&cate1='+cate1+'&cate2='+cate2);
				a12.textContent = '다음 ';
				span3.appendChild(a12);
				div.appendChild(span3);
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
		let arrayQnaNo = "";
		
		// 배열에 게시물 번호를 담음
		for(tr of trs) {
			td = tr.children[1].innerText;
			arrayQnaNo += td
					   += ", ";
		}
		
		// 값이 없을 경우 리턴
		if(arrayQnaNo == "") {
			alert('삭제 할 게시물을 선택 하십시오.');
			return false;
		}
		
		
		// ajax 전송
		$.ajax({
			url: '/Kmarket/admin/cs/qna/delete.do',
			type: 'post',
			data: {'qnaNo':arrayQnaNo},
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