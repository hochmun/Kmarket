function Inquiry(type){

	let sessUserUid = "sessUser.uid";
		
	if (sessUserUid == "" || sessUserUid == null){
		alert("로그인이 필요합니다.");
		location.href="/Kmarket/cs/list.do?cate1="+cate1+"";
	}else{
		location.href="/Kmarket/cs/write.do?cate1=$"+cate1+"";
	}
}