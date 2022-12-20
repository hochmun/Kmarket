// 전체 체크 함수
function allchecked(selectAll) {
	const checkboxes = document.getElementsByName('productCheck');
	
	// 전체 선택 번튼과 선택 유형이 다를 경우 클릭 이벤트 실행
	checkboxes.forEach((checkbox)=>{
		if(selectAll.checked != checkbox.checked) {
			checkbox.click();
		}
	});
};

// 전체 취소 버튼
function deleteChecked() {
	const checkboxes = document.querySelectorAll('input[type="checkbox"]');
	
	// 체크박스가 클릭 되어 있을 경우 클릭 이벤트 실행
	checkboxes.forEach((checkbox)=>{
		if(checkbox.checked == true) {
			checkbox.click();
		}
	})
}

// 개별 선택 버튼
function productCheck2(thisProduct) {
	const formatter = new Intl.NumberFormat('ko'); // 포맷
	
	// 정보 받기
	const ProductTr = thisProduct.parentElement.parentElement;
	const count = parseInt(ProductTr.children[2].innerText);
	const price = parseInt(ProductTr.children[3].innerText.replace(/,/g, ""));
	const discount = parseInt(ProductTr.children[4].innerText);
	const point = parseInt(ProductTr.children[5].innerText.replace(/,/g, ""));
	// delivery 가 문자일 경우 0으로 설정
	let delivery = parseInt(ProductTr.children[6].innerText.replace(/,/g, ""));
	if(isNaN(delivery)==true) delivery = 0;
	
	// 할인 금액
	const disPrice = parseInt(price * (discount/100));
	
	// 전체 합계의 tr들을 불러옴
	let trs = document.getElementsByClassName('total')[0].children[1].children[0].children;
	let totalCount = trs[0].children[1].innerText;
	let totalPrice = trs[1].children[1].innerText.replace(/,/g, "");
	let totalDisPrice = trs[2].children[1].innerText.replace(/,/g, "");
	let totalDelivery = trs[3].children[1].innerText.replace(/,/g, "");
	let totalPoint = trs[4].children[1].innerText.replace(/,/g, "");
	
	// 상품을 체크 했을 경우
	if(thisProduct.checked == true) {
		// 더하기
		trs[0].children[1].innerText = parseInt(totalCount) + count;
		trs[1].children[1].innerText = formatter.format(parseInt(totalPrice) + (price * count));
		trs[2].children[1].innerText = formatter.format(parseInt(totalDisPrice) + (disPrice * count));
		trs[3].children[1].innerText = formatter.format(parseInt(totalDelivery) + delivery);
		trs[4].children[1].innerText = formatter.format(parseInt(totalPoint) + point);
		trs[5].children[1].innerText = formatter.format((parseInt(totalPrice) + (price * count))-(parseInt(totalDisPrice) + (disPrice * count)) + (parseInt(totalDelivery) + delivery) );
	} else {
		// 상품 체크 해제 했을 경우
		// 빼기
		trs[0].children[1].innerText = parseInt(totalCount) - count;
		trs[1].children[1].innerText = formatter.format(parseInt(totalPrice) - (price*count));
		trs[2].children[1].innerText = formatter.format(parseInt(totalDisPrice) - (disPrice * count));
		trs[3].children[1].innerText = formatter.format(parseInt(totalDelivery) - delivery);
		trs[4].children[1].innerText = formatter.format(parseInt(totalPoint) - point);
		trs[5].children[1].innerText = formatter.format((parseInt(totalPrice) - (price * count))-(parseInt(totalDisPrice) - (disPrice * count)) + (parseInt(totalDelivery) - delivery) );
	}
};

// 주문하기
function ProductOrder() {
	event.preventDefault();
	
	// 체크박스를 전부 가져옴
	const checkboxes = document.getElementsByName('productCheck');
	
	// checklist Array
	let checkArray = [];
	
	
	checkboxes.forEach((checkbox)=>{
		// 체크박스가 체크 되어 있을 경우 배열에 값 입력
		if(checkbox.checked == true) checkArray.push(checkbox.value);
	});
	
	// 배열의 길이가 0일 경우 리턴
	if(checkArray.length == 0) return false;
	
	location.href = '/Kmarket/product/order.do?array='+checkArray;
}