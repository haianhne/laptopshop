$(document).ready(function() {
	
	// load first when coming page
	ajaxGet(1);	
	
	function ajaxGet(page){		
		var data = { trangThai : $('#trangThai').val(), tuNgay: $('#fromDate').val(), denNgay: $('#toDate').val()  } 
		$.ajax({
			type: "GET",		
			data: data,
			contentType : "application/json",
			url: "http://localhost:8080/laptopshop/api/don-hang/all" + '?page=' + page,
			success: function(result){
				$.each(result.content, function(i, donHang){
					// tính giá trị đơn hàng
					var sum = 0;
					$.each(donHang.danhSachChiTiet, function(i, chiTiet){
						sum += chiTiet.donGia * chiTiet.soLuong;
					});
					var donHangRow = '<tr>' +
					                  '<td>' + donHang.id+ '</td>' +
					                  '<td>' + donHang.hoTenNguoiNhan + '</td>' +
					                  '<td>' + donHang.trangThaiDonHang + '</td>' +
					                  '<td>' + sum + '</td>' +
					                  '<td>' + donHang.ngayDatHang + '</td>' +
					                  '<td>' + donHang.ngayGiaoHang + '</td>' +
					                  '<td>' + donHang.ngayNhanHang + '</td>' +
					                  '<td width="0%">'+'<input type="hidden" id="donHangId" value=' + donHang.id + '>'+ '</td>'+
					                  '<td><button class="btn btn-primary btnChiTiet" >Chi Tiết</button></td>';
					     if(donHang.trangThaiDonHang == "Đang chờ giao" || donHang.trangThaiDonHang == "Đang giao"){
					    	 donHangRow += '<td><button class="btn btn-danger btnPhanCong">Phân công</button></td>';
					     }
					     donHangRow += '<td><button class="btn btn-primary btnCapNhat" >Cập Nhật</button></td>';
					                  
					$('.donHangTable tbody').append(donHangRow);
					
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
	
	$(document).on('click', '#btnPhanCongSubmit', function (event) {
		var email = $("select[name=shipper]").val();
		var donHangId = $("#donHangId").val();

		ajaxPostPhanCongDonHang(email, donHangId)

	});	
	
	function ajaxPostPhanCongDonHang(email, donHangId) { 

    	 $.ajax({
     		async:false,
 			type : "POST",
 			contentType : "application/json",
 			url : "http://localhost:8080/laptopshop/api/don-hang/update?shipper="+email+"&donHangId="+donHangId,
 			enctype: 'multipart/form-data',
 	        
 			success : function(response) {
 				alert("Phân công đơn hàng thành công");
 				var trangThai = $('#trangThai').val();
			    location.href = window.location.href;
 			},
 			error : function(e) {
 				alert("Error!")
 				console.log("ERROR: ", e);
 			}
 		}); 
    }	
		
	$(document).on('click', '#btnDuyetDonHang', function (event) {
		event.preventDefault();
		resetData();
	});	
	
    // reset table after post, put, filter
    function resetData(){   	
    	var page = $('li.active').children().text();
    	$('.donHangTable tbody tr').remove();
    	$('.pagination li').remove();
        ajaxGet(page);
    };
    
    // event khi click vào phân trang Đơn hàng
	$(document).on('click', '.pageNumber', function (event){
//		event.preventDefault();
		var page = $(this).text();	
    	$('.donHangTable tbody tr').remove();
    	$('.pagination li').remove();
    	ajaxGet(page);	
	});
	
    // event khi click vào button Chi tiết đơn
	$(document).on('click', '.btnChiTiet', function (event){
		event.preventDefault();
		
		var donHangId = $(this).parent().prev().children().val();		
		var href = "http://localhost:8080/laptopshop/api/don-hang/"+donHangId;
		$.get(href, function(donHang) {
			$('#maDonHang').text("Mã đơn hàng: "+ donHang.id);
			$('#hoTenNguoiNhan').text("Người nhận: "+ donHang.hoTenNguoiNhan);
			$('#sdtNhanHang').text("SĐT: "+ donHang.sdtNhanHang);
			$('#diaChiNhan').text("Địa chỉ: "+ donHang.diaChiNhan);
			$('#trangThaiDonHang').text("Trạng thái đơn: "+ donHang.trangThaiDonHang);
			$("#ngayDatHang").text("Ngày đặt: "+ donHang.ngayDatHang);
			
			if(donHang.ngayGiaoHang != null){
				$("#ngayShipHang").text("Ngày giao: "+ donHang.ngayGiaoHang);
			}
			
			if(donHang.ngayNhanHang != null){
				$("#ngayNhanHang").text("Ngày nhận: "+ donHang.ngayNhanHang);
			}
			
			if(donHang.ghiChu != null){
				$("#ghiChu").text("Ghi chú: "+ donHang.ghiChu);
			}
			
			if(donHang.nguoiDat != null){
				$("#nguoiDat").text("Người đặt: "+ donHang.nguoiDat.hoTen);
			}
			
			if(donHang.nguoiDat != null){
				$("#shipper").text("Shipper: "+ donHang.shipper.hoTen);
			}
			
			// thêm bảng:
			var stt = 1;
			$.each(donHang.danhSachChiTiet, function(i, chiTiet){
				var chiTietRow = '<tr>' +
				'<td>' + stt + '</td>' +
                '<td>' + chiTiet.sanPham.tenSanPham + '</td>' +
                '<td>' + chiTiet.soLuong+ '</td>' +
                '<td>' + chiTiet.donGia + '</td>';
				 $('.chiTietTable tbody').append(chiTietRow);
                stt++;
	    	  });		
			var sum = 0;
			$.each(donHang.danhSachChiTiet, function(i, chiTiet){
				sum += chiTiet.donGia * chiTiet.soLuong;
			});
			$("#tongTien").text("Tổng : "+ sum);
		});
		$("#chiTietModal").modal();
	});
	
    // event khi click vào button Chi tiết đơn
	$(document).on('click', '.btnPhanCong', function (event){
		event.preventDefault();
		var donHangId = $(this).parent().prev().prev().children().val();
		$("#donHangId").val(donHangId);
		$("#phanCongModal").modal();
	});
	
	// event khi ẩn modal chi tiết
	$('#chiTietModal').on('hidden.bs.modal', function(e) {
		e.preventDefault();
		$("#chiTietForm p").text(""); // reset text thẻ p
		$('.chiTietTable tbody tr').remove();
	});
});