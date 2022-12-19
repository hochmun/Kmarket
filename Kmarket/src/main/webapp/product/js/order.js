/**
	날짜 : 2022/12/16
	이름 : 심규영
	내용 : order script
	기능 : 유효성 검사
		  우편번호 찾기
		  포인트 사용 함수
 */

// 유효성 검사 리스트
const reHp = /^01(?:0|1|[6-9])-(?:\d{4})-\d{4}$/;
const reNum = /[0-9]/g;

// 유효성 체크
let isHpOk = false

// 포맷
const formatter = new Intl.NumberFormat('ko');


// 휴대폰 유효성 검사 함수
function isHpCheck(value) {
	// 내용이 변경 되면 유효성 취소
	isHpOk = false;
	
	// 입력한 휴대폰 번호
	const hp = value;
	
	// 유효성 체크
	if (!hp.match(reHp)) {
		isHpOk = false;
		document.getElementsByClassName('msgHp')[0].innerText = "잘못된 형태의 전화번호 입니다.";
		return;
	} else {
		isHpOk = true;
		document.getElementsByClassName('msgHp')[0].innerText = "";
	}
}

// 포인트 적용 함수
function usedPoint() {
	let value2 = document.getElementsByName('point')[0].value;
	
	if (!value2.match(reNum)) {
		alert('숫자만 입력 가능 합니다.');
		return false;
	}
	
	if (parseInt(value2) < parseInt(5000)) {
		alert('5,000 포인트 이상 부터 사용 가능 합니다.');
		return false;
	}
	
	if (parseInt(value2) > parseInt(havingPoint)) {
		alert('소유하고 있는 포인트 보다 높은 값을 사용 할 수 없습니다.');
		return false;
	}
	
	// 포인트 사용 값 입력	
	document.getElementById('totallyPoint').innerText = formatter.format(value2);
	
	// 전체 결제 금액 수정
	const totallyTotal = document.getElementById('totallyTotal');
	totallyTotal.innerText = formatter.format(productTotal2 - value2);
	
}


// 우편 번호 찾기 함수
function zipcode() {
	new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var addr = ''; // 주소 변수
            var extraAddr = ''; // 참고항목 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
            if(data.userSelectedType === 'R'){
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraAddr !== ''){
                    extraAddr = ' (' + extraAddr + ')';
                }
                // 조합된 참고항목을 해당 필드에 넣는다.
                //document.getElementById("sample6_extraAddress").value = extraAddr;
            
            } else {
                //document.getElementById("sample6_extraAddress").value = '';
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('zip').value = data.zonecode;
            document.getElementById("addr1").value = addr;
            // 커서를 상세주소 필드로 이동한다.
            document.getElementById("addr2").focus();
        }
    }).open();
}

// 결제 하기 함수
function orderComplete() {
	// 결제 하기 전 동의 묻기
	const orderOk = confirm('상품을 주문 하시겠습니까?');
	
	if (orderOk == false) return false;
	
	// 전송할 데이터 받기
	// 주문자 정보
	const orderer = document.getElementsByName('orderer')[0].value;
	const hp = document.getElementsByName('hp')[0].value;
	const zip = document.getElementsByName('zip')[0].value;
	const addr1 = document.getElementsByName('addr1')[0].value;
	const addr2 = document.getElementsByName('addr2')[0].value;
	
	// 결제방법 체크 확인
	let payment = '0';
	const paymentCheckList = document.getElementsByName('payment');
	paymentCheckList.forEach((node)=>{
		if(node.checked) {
			payment = node.value;
		}
	});
	
	// 최종결제 정보
	const ordCount = document.getElementById('totallyCount').innerText.slice(0, -2);
	const ordPrice = document.getElementById('totallyPrice').innerText.replace(/,/g, "");
	const ordDiscount = document.getElementById('totallyDisprice').innerText.slice(1).replace(/,/g,"");
	const ordDelivery = document.getElementById('totallyDelivery').innerText.replace(/,/g,"");
	const usedPoint = document.getElementById('totallyPoint').innerText.replace(/,/g,"");
	const ordTotPrice = document.getElementById('totallyTotal').innerText.replace(/,/g,"");
	
	console.log(productCartNoArray);
	
	// 유효성 검사
	if(orderer == '') {
		alert('주문자를 입력 하세요.');
		return false;
	}
	if(!isHpOk) {
		alert('휴대폰 입력을 확인하여 주십시오.');
		return false;
	}
	if(zip == '') {
		alert('주소를 입력하세요.');
		return false;
	}
	if(addr1 == '') {
		alert('주소를 입력하세요.');
		return false;
	}
	if(addr2 == '') {
		alert('상세 주소를 입력하세요.');
		return false;
	}
	if(payment == '0') {
		alert('결제 방식을 선택하세요');
		return false;
	}
	
	// 비동기 ajax post 전송 => order.do
	const jsonData = {
		"productCartNoArray":productCartNoArray,
		"ordCount":ordCount,
		"ordPrice":ordPrice,
		"ordDiscount":ordDiscount,
		"ordDelivery":ordDelivery,
		"savePoint":savePoint,
		"usedPoint":usedPoint,
		"ordTotPrice":ordTotPrice,
		"recipName":orderer,
		"recipHp":hp,
		"recipZip":zip,
		"recipAddr1":addr1,
		"recipAddr2":addr2,
		"ordPayment":payment
	}
	
	$.ajax({
		url: '/Kmarket/product/order.do',
		type: 'POST',
		data: jsonData,
		dataType: 'json',
		traditional: true,
		success: (data)=>{
			if(data.ordNo != '' || data.ordNo != null) {
				alert('주문을 완료 했습니다.');
				location.href = '/Kmarket/product/complete.do';
			} else {
				alert('주문에 실패 했습니다.');
				return false;
			}
		}
	});
}
