<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="Frontend/css/checkout.css">
<link rel="stylesheet" href="Frontend/css/cartTable.css">
<style>
html
{
    font-size: 100%;
}
</style>
</head>
<body>

<div class="container">
	<form action="" method="post" class="">
	<div class="row">
	<div>
		<div class="col-md-3">
		<div class="">
					<div class="">
						<span>Thông tin khách hàng</span>
					</div>
					<div class="">
						<div class="">
							<label>Họ tên Quý khách *</label>
							<input type="text" name="kh_name" value="" id="kh_name" required="required"  />
						</div>
						<div class="">
							<label>Địa chỉ Email *</label>
							<input type="text" name="kh_email" value="" id="kh_email" required="required"  />
						</div>
						<div class="">
							<label>Số điện thoại *</label>
							<input type="text" name="kh_phone" value="" id="kh_phone" required="required"  />
						</div>
						<div class="">
							<label>Địa chỉ (số nhà, đường, tỉnh thành) *</label>
							<textarea name="kh_address" cols="40" rows="10" id="kh_address" required="required" value="" ></textarea>
						</div>
					</div>

					</div>

		</div>
		
		<div class="col-md-3">
		<div class="">
						<span>Thông tin nhận hàng</span>
					</div>
					<div class="">
						<div class="">
							<label>Họ tên người nhận hàng *</label>
							<input type="text" name="nh_name" value="" id="nh_name" required="required"  />
						</div>
						<div class="">
							<label>Số điện thoại *</label>
							<input type="text" name="nh_phone" value="" id="nh_phone" required="required"  />
						</div>
						<div class="">
							<label>Địa chỉ (số nhà, đường, tỉnh thành) *</label>
							<textarea name="nh_address" cols="40" rows="10" id="nh_address" required="required" value="" ></textarea>
						</div>
						<div class=""">
							<label>Ghi chú</label>
							<textarea name="nh_note" cols="40" rows="10" id="nh_note" value="" ></textarea>
						</div>
					</div>

		</div>
		</div>
		<div class="col-md-3">
		
		</div>
		
		<div class="col-md-3">
	
	
	<table class="tablecart">
					<tr>
						<td>Ảnh</td>
						<td>Tên sản phẩm</td>
						<td>Đơn giá</td>
						<td>Tổng</td>
					</tr>
					<tr>
						<td><img src="h"></td>
						<td>
							<a href="">NZXT P240 Black - Orange/ White</a>
						</td>
						<td>1,319,000 VND x 1</td>
						<td>
							<b>1,319,000 VND</b>
						</td>
					</tr>
										<tr>
						<td colspan="4">
							<p class="cart_tongdonhang">Tổng giá trị đơn hàng : <span>1,319,000 VND</span></p>
						</td>
					</tr>
				</table>
		<div class="">
					<a class="paymentbtn backtocart" href="">Quay lại giỏ hàng</a>
					<input type="submit" name="submitorder" class="" value="Gửi đơn hàng">
				</div>
	
	
		</div>
	
	</div>
		
	</form>
</div>
</body>
</html>

