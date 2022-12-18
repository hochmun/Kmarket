// 맨처 처음 페이지가 로드 될때 실행 되는 함수
window.addEventListener('load', ()=>{
	$.get('/Kmarket/product/getside.do', function(data){
		for(let cate1 of data) {
			
			let category = document.getElementsByClassName('category')[0];
			
			let newLiTag = document.createElement('li');
			newLiTag.addEventListener('mouseover', ()=>{
				overCate1(cate1.cate1, newLiTag);
			}, {once:true});
			
			let newATag = document.createElement('a');
			newATag.setAttribute('href', '/Kmarket/product/list.do?cate1='+cate1.cate1);
			
			let newITag = document.createElement('i');
			
			if(parseInt(cate1.cate1) == parseInt(10)) newITag.setAttribute('class', 'fas fa-shopping-bag');
			if(parseInt(cate1.cate1) == parseInt(11)) newITag.setAttribute('class', 'fas fa-tshirt');
			if(parseInt(cate1.cate1) == parseInt(12)) newITag.setAttribute('class', 'fas fa-baby-carriage');
			if(parseInt(cate1.cate1) == parseInt(13)) newITag.setAttribute('class', 'fas fa-utensils');
			if(parseInt(cate1.cate1) == parseInt(14)) newITag.setAttribute('class', 'fas fa-home');
			if(parseInt(cate1.cate1) == parseInt(15)) newITag.setAttribute('class', 'fas fa-tv');
			if(parseInt(cate1.cate1) == parseInt(16)) newITag.setAttribute('class', 'fas fa-running');
			if(parseInt(cate1.cate1) == parseInt(17)) newITag.setAttribute('class', 'fas fa-car');
			if(parseInt(cate1.cate1) == parseInt(18)) newITag.setAttribute('class', 'fas fa-book');
			
			console.log(newITag);
			
			newATag.appendChild(newITag);
			newATag.innerHTML += cate1.c1Name;
			
			newLiTag.appendChild(newATag);
			/*
			let newOlTag = document.createElement('ol');
			
			$.get('getside.do?cate1='+cate1.cate1, (data)=>{
				for(let cate2 of data) {
					let newLiTag2 = document.createElement('li');
					let newATag2 = document.createElement('a');
					
					newATag2.setAttribute('href', 'Kmarket/product/list.do?cate1='+cate2.cate1+'&cate2='+cate2.cate2);
					newATag2.innerHTML += cate2.c2Name;
					
					newLiTag2.appendChild(newATag2);
					newOlTag.appendChild(newLiTag2);
				}
			});
			
			newLiTag.appendChild(newOlTag);
			*/
			category.appendChild(newLiTag);
			
		}
	});
});

// 마우스 올릴시 get실행
function overCate1(cate1, newLiTag) {
	let newOlTag = document.createElement('ol');
			
	$.get('getside.do?cate1='+cate1, (data)=>{
		for(let cate2 of data) {
			let newLiTag2 = document.createElement('li');
			let newATag2 = document.createElement('a');
			
			newATag2.setAttribute('href', 'Kmarket/product/list.do?cate1='+cate2.cate1+'&cate2='+cate2.cate2);
			newATag2.innerHTML += cate2.c2Name;
			
			newLiTag2.appendChild(newATag2);
			newOlTag.appendChild(newLiTag2);
		}
	});
	
	newLiTag.appendChild(newOlTag);
}