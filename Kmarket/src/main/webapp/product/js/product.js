$(function(){
		
var sold = document.getElementById('sold'); 	// 판매량
var low = document.getElementById('low');		// 낮은가격
var high = document.getElementById('high');		// 높은가격
var hstar = document.getElementById('hstar');	// 높은별점
var review = document.getElementById('review');	// 리뷰순
var latest = document.getElementById('latest');	// 최근게시

$(document).on('click', '#sold', function(e){
	e.preventDefault();
	let cate1 = $(this).attr('prodcate1');
	let cate2 = $(this).attr('prodcate2');
	let jsonData = {"cate1":cate1, "cate2":cate2};
	$.ajax({
		url:'/Kmarket/product/ProductCate1.do',
		method:'GET',
		data:jsonData,
		dataType:'json',
		success:function(data){
			$('.productList').empty();
			sold.classList.add('on');
			low.classList.remove('on');
			high.classList.remove('on');
			hstar.classList.remove('on');
			review.classList.remove('on');
			latest.classList.remove('on');
			
			for(let product of data){
				let price = product.price * (100-product.discount) * 0.01;
				
				const cn1 = (price).toLocaleString('ko-KR');
				const cn2 = (product.price).toLocaleString('ko-KR');
				const cn3 = (product.delivery).toLocaleString('ko-KR');
				
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

$(document).on('click', '#low', function(e){
	e.preventDefault();
	
	let cate1 = $(this).attr('prodcate1');
	let cate2 = $(this).attr('prodcate2');
	
	let jsonData = {"cate1":cate1, "cate2":cate2};
	
	$.ajax({
		url:'/Kmarket/product/ProductCate2.do',
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
		url:'/Kmarket/product/ProductCate3.do',
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
		url:'/Kmarket/product/ProductCate4.do',
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
		url:'/Kmarket/product/ProductCate5.do',
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
		url:'/Kmarket/product/ProductCate6.do',
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