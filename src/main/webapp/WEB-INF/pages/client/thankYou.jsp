<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<script src="Frontend/js/jquery.min.js"></script>
		<script src="Frontend/js/responsiveslides.min.js"></script>
		<script src="js/client/accounting.js"></script>
	<title>Thanh toán</title>
	</head>

	<script type="text/javascript">	  
	$(document).ready(function() { 
		 $(".mytable .donGia .check").each(function() {
			  var value = accounting.formatMoney($(this).text())+ ' VND';
			  $(this).html(value);
			});
	  
		 $(".mytable .total").each(function() {
			  var value = accounting.formatMoney($(this).text()) + ' VND ';
			  $(this).html(value);
			 
			});
	  });
	</script>
	<body>
		
		<!----start-Header---->
	 <jsp:include page="include/homeHeader.jsp"></jsp:include>
		<!----End-Header---->
		 
	<div class= "container">
	<div class="row">
		<div class="col-md-1">
		</div>
		<div class="col-md-10">
		<br>
		<p><b>QUÝ KHÁCH ĐÃ ĐẶT HÀNG THÀNH CÔNG</b></p><br>
		
		<p> Thông tin đơn hàng đã đặt :</p><br>
		<p><b>ID/Mã đơn hàng: </b> ${donhang.getId() }</p><br>
		<p><b>Họ tên người nhận hàng: </b> ${donhang.getHoTenNguoiNhan()}</p><br>
		<p><b>Số điện thoại: </b>${donhang.getSdtNhanHang()}</p><br>
		<p><b>Địa chỉ: </b>${donhang.getDiaChiNhan()}</p><br>
		<p><b>Ghi chú: </b>${donhang.getGhiChu() } </p><br>
		<p>Vào lúc ${donhang.getNgayDatHang()} chúng tôi đã nhận được đơn đặt hàng với những sản phẩm như sau:</p><br>
		
		
		
					<table class="table-cart-checkout mytable">
					 <tr>
						    <th>Ảnh</th>
						    <th>Tên sản phẩm</th>
						    <th>Đơn giá</th>
						    <th>Tổng</th>
					</tr>
					<c:forEach items="${cart}" var="sanpham" >
				
					 <tr style="text-align: center;">
						    <td>
						    	<img src="/laptopshop/img/${sanpham.id}.png" alt="not found img" class="img-reponsive fix-size-img">
						    </td>
						    <td style="color:green">
						    ${sanpham.tenSanPham}
						    </td>
						    
						    <td class="donGia" >
						    	<div class="check " style ="display: inline-block; ">${sanpham.donGia}</div> 
						    	<div style="display: inline-block; "> x ${quanity[sanpham.id]}</div>
						    </td>
						    
						    <td>
						    	<div class="total">${sanpham.donGia*quanity[sanpham.id]}</div> 
						    </td>
					</tr>
					</c:forEach>
					
				</table>
		
		<br>
			<p>Tổng giá trị đơn hàng:     <b id="ordertotal"> </b></p>
			<br>
		
		
		
		

		<p>LaptopShop xin chân thành cảm ơn quý khách hàng đã tin tưởng sử dụng dịch vụ, sản phẩm của chúng tôi</p><br>
		<a href="<%=request.getContextPath()%>/">Nhấn vào đây để tiếp tục mua sắm</a>
		</div>
		<div class="col-md-1">
		</div>
	
	
	
	</div>
	
	
	</div>
		   
		<!----start-Footder---->
	<jsp:include page="include/homeFooter.jsp"></jsp:include>
	<!----End-Footder---->
	<script src="<c:url value='/js/client/checkoutAjax.js'/>" ></script>	
	</body>
</html>

