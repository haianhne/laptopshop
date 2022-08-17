$(document).ready(function() {
	
	// load first when coming page
	ajaxGet(1);	
	
	function ajaxGet(page){		
		var data = { trangThaiLienHe : $('.trangThai').val(), tuNgay: $('#fromDate').val(), denNgay: $('#toDate').val()  } 
		$.ajax({
			type: "GET",		
			data: data,
			contentType : "application/json",
			url: "http://localhost:8080/laptopshop/api/lien-he/all" + '?page=' + page,
			success: function(result){
				$.each(result.content, function(i, lienHe){
					var lienHeRow = '<tr>' +
					                  '<td>' + lienHe.id+ '</td>' +
					                  '<td>' + lienHe.emailLienHe + '</td>' +
					                  '<td>' + lienHe.ngayLienHe + '</td>' +
					                  '<td>' + lienHe.trangThai + '</td>' +
					                  '<td>' + lienHe.ngayTraLoi + '</td>';
				
					        lienHeRow += '<td width="0%">'+'<input type="hidden" id="lienHeId" value=' + lienHe.id + '>'+ '</td>'+
					                  '<td><button class="btn btn-primary btnChiTiet" >Chi Tiết</button>' +
                                      '&nbsp; <button class="btn btn-warning btnTraLoi" >Trả lời</button></td>';
					                  
					$('.lienHeTable tbody').append(lienHeRow);
					
					$('td').each( function(i){
						if ($(this).html() == 'null'){
							$(this).html('');
						}
					});
				});
								
				if(result.totalPages > 1 ){
					for(var numberPage = 1; numberPage <= result.totalPages; numberPage++) {
						var li = '<li class="page-item "><a class="pageNumber">'+numberPage+'</a></li>';
					    $('.pagination').append(li);
					};				
					
					// active page pagination
			    	$(".pageNumber").each(function(index){	
			    		if($(this).text() == page){
			    			$(this).parent().removeClass().addClass("page-item active");
			    		}
			    	});
				};
			},
			error : function(e){
				alert("Error: ",e);
				console.log("Error" , e );
			}
		});
	};
	
	
	$(document).on('click', '#btnDuyetLienHe', function (event) {
		event.preventDefault();
		console.log("123");
		resetData();
	});	
	
    // reset table after post, put, filter
    function resetData(){   	
    	var page = $('li.active').children().text();
    	$('.lienHeTable tbody tr').remove();
    	$('.pagination li').remove();
        ajaxGet(page);
    };
    
    // event khi click vào phân trang Đơn hàng
	$(document).on('click', '.pageNumber', function (event){
//		event.preventDefault();
		var page = $(this).text();	
    	$('.lienHeTable tbody tr').remove();
    	$('.pagination li').remove();
    	ajaxGet(page);	
	});
	
	// btnChiTiet click event
	$(document).on('click', '.btnChiTiet', function (event){
		event.preventDefault();
		var lienHeId =  $(this).parent().prev().children().val();
		var href = "http://localhost:8080/laptopshop/api/lien-he/"+lienHeId;
		$.get(href, function(lienHe) {
			$('#noiDungLienHe').html("<strong>Nội dung liên hệ</strong>: <br> "+ lienHe.noiDungLienHe);
			$('#ngayLienHe').html("<strong>Ngày liên hệ</strong>: "+ lienHe.ngayLienHe);
			$('#email').html("<strong>Email liên hệ</strong>: "+ lienHe.emailLienHe);
			$('#trangThai').html("<strong>Trạng thái</strong>: "+ lienHe.trangThaiLienHe);
			
			if(lienHe.trangThai == "Đã trả lời"){
			  $('#noiDungTraLoi').html("<strong>Nội dung trả lời</strong>: "+ lienHe.noiDungTraLoi);
			  $('#ngayTraLoi').html("<strong>Ngày trả lời</strong>: "+ lienHe.ngayTraLoi);
			}
		});		
		
		$("#chiTietModal").modal();
	});
	
	
	// btnChiTiet click event
	$(document).on('click', '.btnTraLoi', function (event){
		event.preventDefault();
		var lienHeId =  $(this).parent().prev().children().val();
		var href = "http://localhost:8080/laptopshop/api/lien-he/"+lienHeId;
		$.get(href, function(lienHe) {
			$('#ndLienHe').val(lienHe.noiDungLienHe);
			$('#emailLienHe').val(lienHe.emailLienHe);
		});
		$("#lienHeModal").modal();
	});

	// event khi ẩn modal chi tiết
//	$('#chiTietModal').on('hidden.bs.modal', function(e) {
//		e.preventDefault();
//		$("#chiTietForm p").text(""); // reset text thẻ p
//		$('.chiTietTable tbody tr').remove();
//	});
});