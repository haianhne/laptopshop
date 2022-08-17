$(document).ready(function(){
	ajaxGet();

	function ajaxGet(){
		$.ajax({
			type: "GET",		
			url: "http://localhost:8080/laptopshop/api/san-pham/latest",
			success: function(result){
				var content;
				var section = '<div class="section group">';
				var endsection = '</div>';
				$.each(result, function(i, sanpham){
					if(i != result.length-1)
					{
						if(i%4==0)
						{
							content = '';
							content = '<div class="grid_1_of_4 images_1_of_4 products-info"><a href="sp?id='+sanpham.id+'">' +
									'<img src="/laptopshop/img/'+sanpham.id+'.png">' +
									'<h3>'+sanpham.tenSanPham+'</h3>' +
									'<h4>'+sanpham.donGia+'</h4></a></div>';
						}else 
						{
							content = content+'<div class="grid_1_of_4 images_1_of_4 products-info"><a href="sp?id='+sanpham.id+'">' +
									'<img src="/laptopshop/img/'+sanpham.id+'.png">' +
									'<h3>'+sanpham.tenSanPham+'</h3>' +
									'<h4>'+sanpham.donGia+'</h4></a></div>';
							if(i%4==3)
							{
								content = section + content + endsection;
								$('.content-grids').append(content);
							}				
						}
					}else
					{
						if(i%4==0)
						{
							content = '';
							content = '<div class="grid_1_of_4 images_1_of_4 products-info"><a href="sp?id='+sanpham.id+'">' +
									'<img src="/laptopshop/img/'+sanpham.id+'.png">' +
									'<h3>'+sanpham.tenSanPham+'</h3>' +
									'<h4>'+sanpham.donGia+'</h4></a></div>';
							content = section + content + endsection;
							$('.content-grids').append(content);
						}else
						{
							content = content+'<div class="grid_1_of_4 images_1_of_4 products-info"><a href="sp?id='+sanpham.id+'">' +
									'<img src="/laptopshop/img/'+sanpham.id+'.png">' +
									'<h3>'+sanpham.tenSanPham+'</h3>' +
									'<h4>'+sanpham.donGia+'</h4></a></div>';
							content = section + content + endsection;
							$('.content-grids').append(content);
						}
					}
					console.log(result);
					console.log(result.numberOfElements);
				});
			},
			error : function(e){
				alert("Error: ",e);
				console.log("Error" , e );
			}
		});
	}
})