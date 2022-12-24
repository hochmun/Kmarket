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
	
	// 타입 선택시 동적 처리
	$('select[name=type]').change(function(){
		const t = $(this).val();
		$.ajax({
			url:'',
			
		});
	});
});