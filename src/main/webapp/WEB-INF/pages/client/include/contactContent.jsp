<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Liên hệ</title>
</head>
<body>
	<div class="container">
	<br>
	    <p style="font-size: 30px">Liên hệ với chúng tôi</p>
	    <hr>
<!-- 		<form>		
			<label>Địa chỉ emai của bạn:</label> <br>
			<p id="emailWarning" style="color: red"></p>
			<input id="email" type="text">
			<br>
			<label>Nội dung liên hệ:</label> <br>
			<p id="contentWarning" style="color: red"></p>
			<textarea id="content" rows="4" cols="50"></textarea>
			<br>	
		</form>
		<button >Gửi yêu cầu</button> -->
		
		
		<form>
			<div class="form-group">
				<label for="email">Địa chỉ email của bạn:</label> 
				<p id="emailWarning" style="color: red"></p>
				<input type="email" class="form-control" id="email">
			</div>
			<div class="form-group">
				<label for="content">Thông tin liên hệ:</label> 
				<p id="contentWarning" style="color: red"></p>
				<textarea class="form-control" id="content"></textarea>
			</div>
		</form>
		<button onClick="sendContact()" class="btn btn-primary">Gửi liên hệ</button>
	</div>
<script src="<c:url value='/js/client/contactAjax.js'/>" ></script>	
</body>
</html>
