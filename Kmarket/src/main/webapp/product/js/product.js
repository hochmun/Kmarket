$(function(){
		
var sold = document.getElementById('sold'); 	// 판매량
var low = document.getElementById('low');		// 낮은가격
var high = document.getElementById('high');		// 높은가격
var hstar = document.getElementById('hstar');	// 높은별점
var review = document.getElementById('review');	// 리뷰순
var latest = document.getElementById('latest');	// 최근게시


$('#sold').click(function(){
	const cate1t = $(this).val();
	const cate2t = $(this).val();
	$.ajax({
		url:'/Kmarket/product/ProductCate1.do?cate1='+cate1+'&cate2='+cate2+'&pg='+pg,
		method:'POST',
		data:{"cate1t":cate1t, "cate2t":cate2t},
		dataType:'json',
		success:(data)=>{
			$('.productList').empty();
			sold.classList.add('on');
			low.classList.remove('on');
			high.classList.remove('on');
			hstar.classList.remove('on');
			review.classList.remove('on');
			latest.classList.remove('on');
			
			const table = document.querySelector('table');
			const div = document.getElementsByClassName('paging')[0];
			
			// 기본 내용 제거
			$('.productList tr:gt(0)').remove();
			$('.paging').children().remove();
				
			for(vo of data.vos){
				let price = vo.price * (100-vo.discount) * 0.01;
				
				const cn1 = price.toLocaleString('ko-KR');
				const cn2 = vo.price.toLocaleString('ko-KR');
				const cn3 = vo.delivery.toLocaleString('ko-KR');
				
				const tr = table.insertRow();
				
				const td1 = tr.insertCell(0);
				const a1 = document.createElement('a');
				a1.setAttribute('href', '/Kmarket/product/view.do?prodNo='+vo.prodNo);
				a1.setAttribute('class', 'thumb');
				const img1 = document.createElement('img');
				img1.setAttribute('src', '/thumb/'+vo.prodCate1+"/"+vo.prodCate2+"/"+vo.thumb1);
				img1.setAttribute('alt', '상품이미지');
				td1.appendChild(img1);
				td1.appendChild(a1);
				
				const td2 = tr.insertCell(1);
				const h3 = document.createElement('h3');
				h3.setAttribute('class', 'name')
				h3.textContent = vo.prodName;
				const a2 = document.createElement('a');
				a2.setAttribute('href', '#');
				a2.setAttribute('class', 'desc');
				a2.textContent = vo.descript;
				h3.appendChild(a2);
				td2.appendChild(a2);
				td2.appendChild(h3);
				
				const td3 = tr.insertCell(2);
				const ul1 = document.createElement('ul');
				const li1 = document.createElement('li');
				const ins1 = document.createElement('ins');
				ins1.setattribute('class', 'dis-price');
				ins1.textContent = cn1;
				
				const li2 = document.createElement('li');
				const del1 = document.createElement('del');
				if(vo.discount > 0){
				del1.setattribute('class', 'org-price');
				del1.textContent = cn2;
				const span1 = document.createElement('span');
				span1.setattribute('class', 'discount');
				span1.textContent = vo.discount+'%';
				}else{
					del1.setAttribute('class', 'dis-price');
					del1.textContent = cn2;
					li2.appendChild(del1);
				}
				if(vo.delevery == 0){
				const li3 = document.createElement('li');
				const span2 = document.createElement('span');
				span2.setAttribute('class', 'free-delivery');
				span2.textContent = '무료배송';
				}else{
					const li3 = document.createElement('li');
					const span2 = document.createElement('span');
					span2.textContent = '배송비 '+cn3;
				}
				td3.appendChild(span2);
				td3.appendChild(li3);
				td3.appendChild(span1);
				td3.appendChild(del1);
				td3.appendChild(li2);
				td3.appendChild(ins1);
				td3.appendChild(li1);
				td3.appendChild(ul1);
				
				const td4 = tr.insertCell(3);
				const h4 = document.createElement('h4');
				h4.setAttribute('class', 'seller');
				const i1 = document.createElement('i');
				i1.setAttribute('class', 'fas fa-home');
				h4.textContent = '&nbsp;'+vo.seller;
				const h5 = document.createElement('h5');
				h5.setAttribute('class', 'badge power');
				h5.textContent = 판매자등급;
				const h6 = document.createElement('h6');
				switch(vo.score){
						case 1:
							h6.setAttribute('class', 'rating star1');
							h6.textContent = 상품평;
							break;
						case 2:
							h6.setAttribute('class', 'rating star2');
							h6.textContent = 상품평;
							break;
						case 3:
							h6.setAttribute('class', 'rating star3');
							h6.textContent = 상품평;
							break;
						case 4:
							h6.setAttribute('class', 'rating star4');
							h6.textContent = 상품평;
							break;
						case 5:
							h6.setAttribute('class', 'rating star5');
							h6.textContent = 상품평;
							break;
						case 6:
							h6.setAttribute('class', 'rating star6');
							h6.textContent = 상품평;
							break;
						case 7:
							h6.setAttribute('class', 'rating star7');
							h6.textContent = 상품평;
							break;
						case 8:
							h6.setAttribute('class', 'rating star8');
							h6.textContent = 상품평;
							break;
						case 9:
							h6.setAttribute('class', 'rating star9');
							h6.textContent = 상품평;
							break;
						default :
								h6.setAttribute('class', 'rating star10');
								h6.textContent = 상품평;
						}
					td4.appendChild(h6);
					td4.appendChild(h5);
					td4.appendChild(i1);
					td4.appendChild(h4);
					
				$('.productList').append(table);
			}
			$('.paging span').remove();
			// 페이징 추가
				if(data.pageGroupStart > 1) {
					const span10 = document.createElement('span');
					span10.setAttribute('class', 'prev');
					const a10 = document.createElement('a');
					a10.setAttribute('href', '/Kmarket/product/list.do?pg='+(data.pageGroupStart-1)+'&cate1='+cate1+'&cate2='+cate2);
					a10.textContent = ' 이전';
					span10.appendChild(a10);
					div.appendChild(span10);
				}
				
				const span11 = document.createElement('span');
				span11.setAttribute('class', 'num');
				for(let i = data.pageGroupStart; i <= data.pageGroupEnd; i++) {
					const a11 = document.createElement('a');
					a11.setAttribute('href', '/Kmarket/product/list.do?pg='+pg+'&cate1='+cate1+'&cate2='+cate2);
					if(data.currentPage == i) a11.setAttribute('class', 'on');
					a11.textContent = i;
					span11.appendChild(a11);
				}
				div.appendChild(span2);
				
				if(data.pageGroupEnd < data.lastPageNum) {
					const span12 = document.createElement('span');
					span12.setAttribute('class', 'next');
					const a12 = document.createElement('a');
					a12.setAttribute('href', '/Kmarket/product/list/do?pg='+(data.pageGroupEnd+1)+'&cate1='+cate1+'&cate2='+cate2);
					a12.textContent = '다음 ';
					span12.appendChild(a12);
					div.appendChild(span12);
				}
			
		}
	});
});
$(document).on('click', '#low', function(e){
	e.preventDefault();
	
	let cate1 = $(this).attr('prodcate1');
	let cate2 = $(this).attr('prodcate2');
	
	let jsonData = {"cate1":cate1, "cate2":cate2};
	
	$.ajax({
		url:'/Kmarket/product/ProductCate2.do?cate1='+cate1+'&cate2='+cate2,
		method:'GET',
		data:jsonData,
		dataType:'json',
		success:function(data){
			$('.productList').empty();
			
			sold.classList.remove('on');
			low.classList.add('on')
			high.classList.remove('on');
			hstar.classList.remove('on');
			review.classList.remove('on');
			latest.classList.remove('on');
			
			for(let product of data){
				let price = product.price * (100-product.discount) * 0.01;
				
				const cn1 = price.toLocaleString('ko-KR');
				const cn2 = product.price.toLocaleString('ko-KR');
				const cn3 = product.delivery.toLocaleString('ko-KR');
				
				let table  = "<tr>";
					table += "<td><a href='/Kmarket/product/view.do?prodNo="+product.prodNo+"' class='thumb'><img src='/thumb/"+product.prodCate1+"/"+product.prodCate2+"/"+product.thumb1+"' alt='상품이미지'></a></td>";
					table += "<td>"
					table += "<h3 class='name'>"+product.prodName+"</h3>";
					table += "<a href='#' class='desc'>"+product.descript+"</a>";
					table += "</td>";
					table += "<td>";
					table += "<ul>";
					if(product.discount > 0){
						table += "<li><ins class='dis-price'>"+cn1+"</ins></li>";
						table += "<li><del class='org-price'>"+cn2+"</del>";	
						table += "<span class='discount'>"+product.discount+"%</span></li>";	
					}else{
						table += "<li><del class='dis-price'>"+cn2+"</del></li>";	
					}
					if(product.delivery == 0){
						table += "<li><span class='free-delivery'>무료배송</span></li>";	
					}else{
						table += "<li><span>배송비 "+cn3+"</span></li>";	
					}
					table += "</ul>";
					table += "</td>";
					table += "<td><h4 class='seller'><i class='fas fa-home'></i>&nbsp;"+product.seller+"</h4><h5 class='badge power'>판매자등급</h5>"
					switch(product.score){
						case 1:
							table += "<h6 class='rating star1'>상품평</h6>";
							break;
						case 2:
							table += "<h6 class='rating star2'>상품평</h6>";
							break;
						case 3:
							table += "<h6 class='rating star3'>상품평</h6>";
							break;
						case 4:
							table += "<h6 class='rating star4'>상품평</h6>";
							break;
						case 5:
							table += "<h6 class='rating star5'>상품평</h6>";
							break;
						case 6:
							table += "<h6 class='rating star6'>상품평</h6>";
							break;
						case 7:
							table += "<h6 class='rating star7'>상품평</h6>";
							break;
						case 8:
							table += "<h6 class='rating star8'>상품평</h6>";
							break;
						case 9:
							table += "<h6 class='rating star9'>상품평</h6>";
							break;
						default :
							table += "<h6 class='rating star10'>상품평</h6>";
					}
					table += "</td>"
					table += "</tr>"
			
				$('.productList').append(table);

			}
			
		}
	});
});
$(document).on('click', '#high', function(e){
	e.preventDefault();
	
	let cate1 = $(this).attr('prodcate1');
	let cate2 = $(this).attr('prodcate2');
	
	let jsonData = {"cate1":cate1, "cate2":cate2};
	
	$.ajax({
		url:'/Kmarket/product/ProductCate3.do?cate1='+cate1+'&cate2='+cate2,
		method:'GET',
		data:jsonData,
		dataType:'json',
		success:function(data){
			$('.productList').empty();
			
			sold.classList.remove('on');
			low.classList.remove('on')
			high.classList.add('on');
			hstar.classList.remove('on');
			review.classList.remove('on');
			latest.classList.remove('on');
			
			for(let product of data){
				let price = product.price * (100-product.discount) * 0.01;
				
				const cn1 = price.toLocaleString('ko-KR');
				const cn2 = product.price.toLocaleString('ko-KR');
				const cn3 = product.delivery.toLocaleString('ko-KR');
				
				let table  = "<tr>";
					table += "<td><a href='/Kmarket/product/view.do?prodNo="+product.prodNo+"' class='thumb'><img src='/thumb/"+product.prodCate1+"/"+product.prodCate2+"/"+product.thumb1+"' alt='상품이미지'></a></td>";
					table += "<td>"
					table += "<h3 class='name'>"+product.prodName+"</h3>";
					table += "<a href='#' class='desc'>"+product.descript+"</a>";
					table += "</td>";
					table += "<td>";
					table += "<ul>";
					if(product.discount > 0){
						table += "<li><ins class='dis-price'>"+cn1+"</ins></li>";
						table += "<li><del class='org-price'>"+cn2+"</del>";	
						table += "<span class='discount'>"+product.discount+"%</span></li>";	
					}else{
						table += "<li><del class='dis-price'>"+cn2+"</del></li>";	
					}
					if(product.delivery == 0){
						table += "<li><span class='free-delivery'>무료배송</span></li>";	
					}else{
						table += "<li><span>배송비 "+cn3+"</span></li>";	
					}
					table += "</ul>";
					table += "</td>";
					table += "<td><h4 class='seller'><i class='fas fa-home'></i>&nbsp;"+product.seller+"</h4><h5 class='badge power'>판매자등급</h5>"
					switch(product.score){
						case 1:
							table += "<h6 class='rating star1'>상품평</h6>";
							break;
						case 2:
							table += "<h6 class='rating star2'>상품평</h6>";
							break;
						case 3:
							table += "<h6 class='rating star3'>상품평</h6>";
							break;
						case 4:
							table += "<h6 class='rating star4'>상품평</h6>";
							break;
						case 5:
							table += "<h6 class='rating star5'>상품평</h6>";
							break;
						case 6:
							table += "<h6 class='rating star6'>상품평</h6>";
							break;
						case 7:
							table += "<h6 class='rating star7'>상품평</h6>";
							break;
						case 8:
							table += "<h6 class='rating star8'>상품평</h6>";
							break;
						case 9:
							table += "<h6 class='rating star9'>상품평</h6>";
							break;
						default :
							table += "<h6 class='rating star10'>상품평</h6>";
					}
					table += "</td>"
					table += "</tr>"
			
				$('.productList').append(table);
			}
			
		}
	});
});
$(document).on('click', '#hstar', function(e){
	e.preventDefault();
	
	let cate1 = $(this).attr('prodcate1');
	let cate2 = $(this).attr('prodcate2');
	
	let jsonData = {"cate1":cate1, "cate2":cate2};
	
	$.ajax({
		url:'/Kmarket/product/ProductCate4.do?cate1='+cate1+'&cate2='+cate2,
		method:'GET',
		data:jsonData,
		dataType:'json',
		success:function(data){
			$('.productList').empty();
			
			sold.classList.remove('on');
			low.classList.remove('on')
			high.classList.remove('on');
			hstar.classList.add('on');
			review.classList.remove('on');
			latest.classList.remove('on');
			
			for(let product of data){
				let price = product.price * (100-product.discount) * 0.01;
				
				const cn1 = price.toLocaleString('ko-KR');
				const cn2 = product.price.toLocaleString('ko-KR');
				const cn3 = product.delivery.toLocaleString('ko-KR');
				
				let table  = "<tr>";
					table += "<td><a href='/Kmarket/product/view.do?prodNo="+product.prodNo+"' class='thumb'><img src='/thumb/"+product.prodCate1+"/"+product.prodCate2+"/"+product.thumb1+"' alt='상품이미지'></a></td>";
					table += "<td>"
					table += "<h3 class='name'>"+product.prodName+"</h3>";
					table += "<a href='#' class='desc'>"+product.descript+"</a>";
					table += "</td>";
					table += "<td>";
					table += "<ul>";
					if(product.discount > 0){
						table += "<li><ins class='dis-price'>"+cn1+"</ins></li>";
						table += "<li><del class='org-price'>"+cn2+"</del>";	
						table += "<span class='discount'>"+product.discount+"%</span></li>";	
					}else{
						table += "<li><del class='dis-price'>"+cn2+"</del></li>";	
					}
					if(product.delivery == 0){
						table += "<li><span class='free-delivery'>무료배송</span></li>";	
					}else{
						table += "<li><span>배송비 "+cn3+"</span></li>";	
					}
					table += "</ul>";
					table += "</td>";
					table += "<td><h4 class='seller'><i class='fas fa-home'></i>&nbsp;"+product.seller+"</h4><h5 class='badge power'>판매자등급</h5>"
					switch(product.score){
						case 1:
							table += "<h6 class='rating star1'>상품평</h6>";
							break;
						case 2:
							table += "<h6 class='rating star2'>상품평</h6>";
							break;
						case 3:
							table += "<h6 class='rating star3'>상품평</h6>";
							break;
						case 4:
							table += "<h6 class='rating star4'>상품평</h6>";
							break;
						case 5:
							table += "<h6 class='rating star5'>상품평</h6>";
							break;
						case 6:
							table += "<h6 class='rating star6'>상품평</h6>";
							break;
						case 7:
							table += "<h6 class='rating star7'>상품평</h6>";
							break;
						case 8:
							table += "<h6 class='rating star8'>상품평</h6>";
							break;
						case 9:
							table += "<h6 class='rating star9'>상품평</h6>";
							break;
						default :
							table += "<h6 class='rating star10'>상품평</h6>";
					}
					table += "</td>"
					table += "</tr>"
			
				$('.productList').append(table);
			}
			
		}
	});
});
$(document).on('click', '#review', function(e){
	e.preventDefault();
	
	let cate1 = $(this).attr('prodcate1');
	let cate2 = $(this).attr('prodcate2');
	
	let jsonData = {"cate1":cate1, "cate2":cate2};
	
	$.ajax({
		url:'/Kmarket/product/ProductCate5.do?cate1='+cate1+'&cate2='+cate2,
		method:'GET',
		data:jsonData,
		dataType:'json',
		success:function(data){
			console.log('here4');
			$('.productList').empty();
			
			sold.classList.remove('on');
			low.classList.remove('on')
			high.classList.remove('on');
			hstar.classList.remove('on');
			review.classList.add('on');
			latest.classList.remove('on');
			
			for(let product of data){
				let price = product.price * (100-product.discount) * 0.01;
				
				const cn1 = price.toLocaleString('ko-KR');
				const cn2 = product.price.toLocaleString('ko-KR');
				const cn3 = product.delivery.toLocaleString('ko-KR');
				
				let table  = "<tr>";
					table += "<td><a href='/Kmarket/product/view.do?prodNo="+product.prodNo+"' class='thumb'><img src='/thumb/"+product.prodCate1+"/"+product.prodCate2+"/"+product.thumb1+"' alt='상품이미지'></a></td>";
					table += "<td>"
					table += "<h3 class='name'>"+product.prodName+"</h3>";
					table += "<a href='#' class='desc'>"+product.descript+"</a>";
					table += "</td>";
					table += "<td>";
					table += "<ul>";
					if(product.discount > 0){
						table += "<li><ins class='dis-price'>"+cn1+"</ins></li>";
						table += "<li><del class='org-price'>"+cn2+"</del>";	
						table += "<span class='discount'>"+product.discount+"%</span></li>";	
					}else{
						table += "<li><del class='dis-price'>"+cn2+"</del></li>";	
					}
					if(product.delivery == 0){
						table += "<li><span class='free-delivery'>무료배송</span></li>";	
					}else{
						table += "<li><span>배송비 "+cn3+"</span></li>";	
					}
					table += "</ul>";
					table += "</td>";
					table += "<td><h4 class='seller'><i class='fas fa-home'></i>&nbsp;"+product.seller+"</h4><h5 class='badge power'>판매자등급</h5>"
					switch(product.score){
						case 1:
							table += "<h6 class='rating star1'>상품평</h6>";
							break;
						case 2:
							table += "<h6 class='rating star2'>상품평</h6>";
							break;
						case 3:
							table += "<h6 class='rating star3'>상품평</h6>";
							break;
						case 4:
							table += "<h6 class='rating star4'>상품평</h6>";
							break;
						case 5:
							table += "<h6 class='rating star5'>상품평</h6>";
							break;
						case 6:
							table += "<h6 class='rating star6'>상품평</h6>";
							break;
						case 7:
							table += "<h6 class='rating star7'>상품평</h6>";
							break;
						case 8:
							table += "<h6 class='rating star8'>상품평</h6>";
							break;
						case 9:
							table += "<h6 class='rating star9'>상품평</h6>";
							break;
						default :
							table += "<h6 class='rating star10'>상품평</h6>";
					}
					table += "</td>"
					table += "</tr>"
			
				$('.productList').append(table);
			}
			
		}
	});
});
$(document).on('click', '#latest', function(e){
	e.preventDefault();
	
	let cate1 = $(this).attr('prodcate1');
	let cate2 = $(this).attr('prodcate2');
	
	let jsonData = {"cate1":cate1, "cate2":cate2};
	
	$.ajax({
		url:'/Kmarket/product/ProductCate6.do?cate1='+cate1+'&cate2='+cate2,
		method:'GET',
		data:jsonData,
		dataType:'json',
		success:function(data){
			$('.productList').empty();
			
			sold.classList.remove('on');
			low.classList.remove('on')
			high.classList.remove('on');
			hstar.classList.remove('on');
			review.classList.remove('on');
			latest.classList.add('on');
			
			for(let product of data){
				let price = product.price * (100-product.discount) * 0.01;
				
				const cn1 = price.toLocaleString('ko-KR');
				const cn2 = product.price.toLocaleString('ko-KR');
				const cn3 = product.delivery.toLocaleString('ko-KR');
				
				let table  = "<tr>";
					table += "<td><a href='/Kmarket/product/view.do?prodNo="+product.prodNo+"' class='thumb'><img src='/thumb/"+product.prodCate1+"/"+product.prodCate2+"/"+product.thumb1+"' alt='상품이미지'></a></td>";
					table += "<td>"
					table += "<h3 class='name'>"+product.prodName+"</h3>";
					table += "<a href='#' class='desc'>"+product.descript+"</a>";
					table += "</td>";
					table += "<td>";
					table += "<ul>";
					if(product.discount > 0){
						table += "<li><ins class='dis-price'>"+cn1+"</ins></li>";
						table += "<li><del class='org-price'>"+cn2+"</del>";	
						table += "<span class='discount'>"+product.discount+"%</span></li>";	
					}else{
						table += "<li><del class='dis-price'>"+cn2+"</del></li>";	
					}
					if(product.delivery == 0){
						table += "<li><span class='free-delivery'>무료배송</span></li>";	
					}else{
						table += "<li><span>배송비 "+cn3+"</span></li>";	
					}
					table += "</ul>";
					table += "</td>";
					table += "<td><h4 class='seller'><i class='fas fa-home'></i>&nbsp;"+product.seller+"</h4><h5 class='badge power'>판매자등급</h5>"
					switch(product.score){
						case 1:
							table += "<h6 class='rating star1'>상품평</h6>";
							break;
						case 2:
							table += "<h6 class='rating star2'>상품평</h6>";
							break;
						case 3:
							table += "<h6 class='rating star3'>상품평</h6>";
							break;
						case 4:
							table += "<h6 class='rating star4'>상품평</h6>";
							break;
						case 5:
							table += "<h6 class='rating star5'>상품평</h6>";
							break;
						case 6:
							table += "<h6 class='rating star6'>상품평</h6>";
							break;
						case 7:
							table += "<h6 class='rating star7'>상품평</h6>";
							break;
						case 8:
							table += "<h6 class='rating star8'>상품평</h6>";
							break;
						case 9:
							table += "<h6 class='rating star9'>상품평</h6>";
							break;
						default :
							table += "<h6 class='rating star10'>상품평</h6>";
					}
					table += "</td>"
					table += "</tr>"
			
				$('.productList').append(table);
			}
			
		}
	});
});
});