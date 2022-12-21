/**
 2022/12/14 심규영 product/view.do 스크립트
 기능 => 
 	도착시간 계산
 	주문 갯수 plus, minus 및 총액 계산 스크립트
 	주문 버튼 click 시 처리
 */
window.onload = function(){
	// 예상 도착 날짜 불러오기
	var now = new Date();
	const after = new Date(now.setDate(now.getDate()+3));
	const arrival = after.toLocaleDateString('ko', {
		weekday: 'short',
		month: 'short',
		day: 'numeric'
	});
	document.getElementById("arrival").innerText=arrival+" 도착예정";
}

// 주문 갯수 스크립트
function count(type) {
	// 변화하는 값
	const num = document.getElementById("num");
	
	// 현재 표시된 값
	let number = num.value;
	
	// 더하기 빼기
	if(type === 'plus') {
		number = parseInt(number)+1;
	} else if(type === 'minus' && parseInt(number) > 1) {
		number = parseInt(number)-1;
	}
	
	// 결과 출력
	num.value = number;
	
	// 총 상품금액 변경
	
	const dispriseStr = document.getElementsByClassName('dis_price')[0].innerText;
	const disprise = dispriseStr.replace(/,/g, "");
	const totalprice = parseInt(disprise) * number + parseInt(delivery);
	const formatter = new Intl.NumberFormat('ko'); // 포맷
	
	document.getElementById('totalprice').innerText = formatter.format(totalprice);
	
}

// TODO - 나중에 수정하기 => js에 el문을 사용하면 js 분리시 오류가 남
// 주문하기 스크립트
function orderProduct(type){
	
	let Ok = null;
	
	if(type == 'cart') Ok = confirm('상품을 장바구니에 넣으시겠습니까?');
	if(type == 'order') Ok = confirm('상품 주문 페이지로 이동하시겠습니까?');
	
	if (Ok == false) return false;
	
	if(sessUserUid == "" || sessUserUid == null || sessUserUid == undefined) {
		alert('회원 로그인을 해 주십시오.');
		return false;
	}
	
	const countNum = document.getElementById('num').value;
	const totalStr = document.getElementById('totalprice').innerText;
	const total = totalStr.replace(/,/g, "");
	const points = point * countNum;
	
	// post 전송
	$.ajax({
		url: '/Kmarket/product/view.do',
		type: 'POST',
		data: {
			"uid":sessUserUid,
			"prodNo":prodNo,
			"prodCate1":prodCate1,
			"prodCate2":prodCate2,
			"thumb1":thumb1,
			"count":countNum,
			"price":price,
			"discount":discount,
			"point":points,
			"delivery":delivery,
			"total":total,
			"type":type,
			"prodName":prodName,
			"descript":descript
			},
		dataType: 'json',
		success: (data)=>{
			if(data.result > 0) {
				if (type == 'cart') alert('장바구니 등록 완료!');
				if (type == 'order') alert('주문 페이지로 이동합니다.');
				
				location.href = '/Kmarket/product/'+type+'.do';
			} else {
				alert('장바구니 등록 실패!');
				return false;
			}
				
		}
	});
}
