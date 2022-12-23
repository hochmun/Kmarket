$(function(){
		// 글 삭제하기
		$('.btnDelete').click(function(){
			
			let qnaNo = $('input[name=qnaNo]').val();
			
			let del = confirm('문의글을 삭제하시겠습니까?');
			
			if(del){
				$.ajax({
					url: '/Kmarket/admin/cs/qna/delete.do',
					method: 'get',
					data : {"qnaNo":qnaNo},
					dataType : 'json',
					success:function(data){
						console.log("data : "+data.result);
						if(data.result == 1){
							alert('삭제완료');
							location.replace('/Kmarket/admin/cs/qna/list.do');
							return true;
						}else{
							alert('삭제실패');
							return false;
						}
					}
				});
			}else{
				return false;
			}
		});
		
		
	});