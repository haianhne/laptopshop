<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Thay đổi thông tin tài khoản</title>
</head>
<body>
<div class="container">
	<form>
		<div class="col-md-3" >
			<br>
			<p class="border-p" style="line-height:1.5;"><b>Thông tin khách hàng</b></p>
			
			<p style="line-height:2;">Họ tên Quý khách *</p>
			<p style="line-height:2;" id="nameWarning"></p>
			<input size="27" value="${user.hoTen}" id="name">
		
			<p style="line-height:2;"> Số điện thoại *</p>
			<p style="line-height:2;" id="phoneWarning"></p>
			<input size="27" value="${user.soDienThoai}" id="phone">
			
			<p style="line-height:2;">Địa chỉ(số nhà, đường, tỉnh thành) *</p>
			<p style="line-height:2;" id="addressWarning"></p>
			<textarea rows="5" cols="29" id="address">${user.diaChi}</textarea>
			<br><br>
		</div>		
	</form>
	<button onClick="changeInformation()" class="btn btn-primary">Đổi thông tin</button>
</div>

</body>
</html>
<script src="<c:url value='/js/client/information.js'/>" ></script>	