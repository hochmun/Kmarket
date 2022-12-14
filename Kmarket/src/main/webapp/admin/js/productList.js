$(()=>{
	// 전체 선택
	$("#cbx_chkAll").click(function() {
		if($("#cbx_chkAll").is(":checked")) $("input[name=상품코드]").prop("checked", true);
		else $("input[name=상품코드]").prop("checked", false);
	});
	// 개별 선택
	$("input[name=상품코드]").click(function() {
		var total = $("input[name=상품코드]").length;
		var checked = $("input[name=상품코드]:checked").length;
		
		if(total != checked) $("#cbx_chkAll").prop("checked", false);
		else $("#cbx_chkAll").prop("checked", true); 
	});
	
	// 검색 기능
	$('input[name=btnSearch]').click(()=>{
		const s = $('input[name=search]').val();
		const st = $('select[name=searchType').val();
		
		location.href = '/Kmarket/admin/product/list.do?s='+s+'&st='+st;
	});
	
	// 개별 삭제 기능
	$('.deleteProduct').click(function(e){
		e.preventDefault();
		const deleteOk = confirm('상품을 제거 하시겠습니까?');
		if(deleteOk == false) return false;
		const tr = $(this).parent().parent();
		const prodNo = tr.children().eq(2).text();
		$.ajax({
			url:'/Kmarket/admin/product/list.do',
			type: 'POST',
			data: {'prodNo':prodNo},
			dataType: 'json',
			success: (data)=>{
				if(data.result > 0) {
					alert('상품 삭제 완료 했습니다.');
					tr.remove();
				} else {
					alert('상품 삭제에 실패 하였습니다.');
				}
			}
		});
	});
	
	// 다중 삭제 기능
	$('#deleteAll').click(()=>{
		const deleteOk = confirm('선택한 상품을 삭제 하시겠습니까?');
		if(deleteOk == false) return false;
		const trs = $('input[name=상품코드]:checked').parent().parent();
		let prodNo = "";
		for(tr of trs) {
			prodNo += tr.children[2].innerText;
			prodNo += ", ";
		}
		$.ajax({
			url:'/Kmarket/admin/product/list.do',
			type: 'POST',
			data: {'prodNo':prodNo},
			dataType: 'json',
			success: (data)=>{
				if(data.result > 0) {
					alert('상품 삭제 완료 했습니다.');
					trs.remove();
				} else {
					alert('상품 삭제에 실패 하였습니다.');
				}
			}
		});
	});
});