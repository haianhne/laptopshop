<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="Frontend/css/cartTable.css">
<style>
html
{
    font-size: 100%;
}
</style>
</head>


<body>
<br>
<br>
<p> <a>Trang chủ</a> >> Giỏ hàng </p>
<div class="container">
  <div class="row">
  <div class="col-10">
  <table class="tablecart">
 <tr>
		<td>STT</td>
		<td>Ảnh</td>
		<td>Tên sản phẩm</td>
		<td>Đơn giá</td>
		<td>Số lượng</td>
		<td>Tổng</td>
		<td>Xóa</td>
</tr>
<c:forEach var="sanpham" items="${cart}" varStatus="loop">			
<tr class="cart_line" id="item${sanpham.id}">
		
		<div>
		<td>${loop.index+1}</td>
		<td><img src="/laptopshop/img/${sanpham.id}.png" style="width: 150px" class="cart-img"></td>
		<td>
			<p class="cart_ten"><a href="#">${sanpham.tenSanPham}</a></p>
			<p class="cart_masanpham">Mã sản phẩm : <span>${sanpham.id}</span></p>
			<p class="">Bảo hành : ${sanpham.thongTinBaoHanh}</p>
		</td>
		<td>${sanpham.donGia}</td>
		<td>
			<input class="input_num_cart" type="number" value="${quanity[sanpham.id]}" min="1" onChange="changeQuanity(${sanpham.id},this.value,${sanpham.donGia})">
		</td>
		<td><b><span class="total" id="item${sanpham.id}_total">${sanpham.donGia*quanity[sanpham.id]}</span> VND</b></td>
		<td class="cart-img">
				<a onClick="deleteFromCart(${sanpham.id})">
				<img  src="Frontend/img/icon_trash.png"></img>
				</a>
		</td>
		</div>
	
</tr>
</c:forEach>
<tr>
		<td colspan="3">
		<span class="next_payment"><a class="paymentbtn" href="#">Thanh toán</a></span>
		<span class="next_payment"><a class="paymentbtn" href="#">Mua thêm sản phẩm khác</a></span>
		</td>
		<td colspan="4">
			<p class="cart_tongdonhang">Tổng giá trị đơn hàng : <span id="ordertotal"></span> VND</p>

		</td>
</tr>
</table>
  
</div>  
  
  <div class="col-xs-1">
  
  </div>
  
  
 
  
  
  </div>
</div>

<script src="<c:url value='/js/client/cartAjax.js'/>" ></script>	 

</body>
</html>