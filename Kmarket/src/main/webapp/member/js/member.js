 // 검증용 정규표현식
const reUid = /^[a-z]+[a-z0-9]{5,19}$/g;
const rePass = /^(?=.*[a-zA-z])(?=.*[0-9])(?=.*[$`~!@$!%*#^?&\\(\\)\-_=+]).{8,255}$/;
const reName = /^[ㄱ-힣]+$/;
const reEmail = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
const reHp = /^01(?:0|1|[6-9])-(?:\d{4})-\d{4}$/;

let isUidOk 	= false;
let isPassOk 	= false;
let isNameOk 	= false;
let isEmailOk 	= false;
let isHpOk 		= false;

$(function(){
	
	// 아이디 검사하기
	$('input[name=km_uid]').change(function(){
		isUidOk = false;
		$('.msgId').text('');
	});
	
	$('input[name=km_uid]').change(function(){
		
		if(isUidOk) {
			return;
		}
		
		let uid = $('input[name=km_uid]').val();
		
		if (!uid.match(reUid)) {
			isUidOk = false;
			$('.msgId').css('color','red').text('유효한 아이디가 아닙니다.');
			return;
		}
		
		let jsonData = {
				"km_uid" : uid
		};
		
		$('.msgId').css('color','black').text('...');
			
		$.ajax({
			url: '/Kmarket/member/checkUid.do',
			method:'get',
			data: jsonData,
			dataType:'json',
			success:(data)=>{
					if(data.result == 0) {
						isUidOk = true;
						$('.msgId').css('color','green').text('사용 가능한 아이디 입니다.');
					} else {
						isUidOk = false;
						$('.msgId').css('color','red').text('이미 사용중인 아이디 입니다.');
					}
			}
		});
	});
	
	// 비밀번호 검사하기
	$('input[name=km_pass2]').focusout(function(){
		let pass1 = $('input[name=km_pass]').val();
		let pass2 = $('input[name=km_pass2]').val();
		
		if(pass2.match(rePass)) {
			if(pass1 == pass2) {
				isPassOk = true;
				$('.msgPass').css('color', 'green').text('사용하실 수 있는 비밀번호 입니다.');
			} else {
				isPassOk =false;
				$('.msgPass').css('color', 'red').text('비밀번호가 일치하지 않습니다.');
			}
		} else {
			isPassOk = false;
			$('.msgPass').css('color', 'red').text('비밀번호는 숫자,영문,특수문자 포함 8자리 이상 이어야 합니다.');
		}
	});
	
	// 이름 검사하기
	$('input[name=km_name]').focusout(function(){
		let name = $(this).val();
		
		if(name.match(reName)) {
			isNameOk = true;
			$('.msgName').text('사용 가능한 이름입니다.');
		} else {
			isNameOk = false;
			$('.msgName').css('color','red').text('유효한 이름이 아닙니다.');
		}
	});
	
	// 이메일 검사하기
	$('input[name=km_email]').change(function(){
		const email = $(this).val();
		
		if (email.match(reEmail)) {
			isEmailOk = true;
			$('.msgEmail').text('사용 가능한 이메일 입니다.');
		} else {
			isEmailOk = false;
			$('.msgEmail').css('color','red').text('유효한 메일이 아닙니다.');
		}
	});
	
	// 휴대폰 검사하기
	$('input[name=km_hp]').focusout(function(){
		const hp = $(this).val();
		
		if (hp.match(reHp)) {
			isHpOk = true;
			$('.msgHp').text('');
		} else {
			isHpOk = false;
			$('.msgHp').css('color','red').text('유효한 번호가 아닙니다.');
		}
	});
	
	// 최종 폼 전송할 때
	$('.register > form').submit(function(){
		// ID 검증
		if(!isUidOk) {
			alert('아이디가 유효하지 않습니다.');
			return false;
		}
		// 비밀번호 검증
		if(!isPassOk) {
			alert('비밀번호가 유효하지 않습니다.');
			return false;
		}
		// 이름 검증
		if(!isNameOk) {
			alert('이름이 유효하지 않습니다.');
			return false;
		}
		// 이메일 검증
		if(!isEmailOk) {
			alert('이메일이 유효하지 않습니다.');
			return false;
		}
		// 휴대폰 검증
		if(!isHpOk) {
			alert('휴대폰이 유효하지 않습니다.');
			return false;
		}
		
		return true;
	});
});