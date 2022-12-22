$(document).ready(function(){
	// 카테고리1값 변경시
	$('select[name=cate1]').change(()=>{
		const cate1 = $('select[name=cate1]').val();
		
		$.post('/Kmarket/admin/product/getCate2.do?cate1='+cate1,(data)=>{
			// 카테고리2값 넣기전 비우기
			$('select[name=cate2]').empty();
			$('select[name=cate2]').append("<option value=''>2차 선택</option>");
			for(const vo of data) {
				// 카테고리2값 입력
				$('select[name=cate2]').append("<option value='"+vo.cate2+"'>"+vo.cate2Name+"</option>");
			}
		});
	});
	
	$('.w-btn-green').click(function(e){
		e.preventDefault();
		const cate1 = $('select[name=cate1]').val();
		const cate2 = $('select[name=cate2]').val();
		const title = $('input[name=title]').val();
		const content = $('textarea[name=content]').val();
		
		// 검사
		if(cate1 == null || cate1 == "") {
			alert('카테고리1을 선택하십시오');
			return false;	
		}
		
		if(cate2 == null || cate2 == "") {
			alert('카테고리2를 선택하십시오.');
			return false;
		}
		
		if(title == null || title == "") {
			alert('제목을 입력 하십시오.');
			return false;
		}
		
		if(content == null || content == "") {
			alert('내용을 입력 하십시오.');
			return false;
		}
		
		// 데이터베이스 전송
		$.ajax({
			url: '/Kmarket/admin/cs/faq/write.do',
			type: 'POST',
			data: {"cate1":cate1,"cate2":cate2,"title":title,"content":content},
			dataType: 'json',
			success: (data)=>{
				if(data.result > 0) {
					alert('게시물 등록 완료!');
					location.href = '/Kmarket/admin/cs/faq/list.do';
				} else {
					alert('게시물 등록 실패!');
					return false;
				}
			}
		});
	});
	
});

