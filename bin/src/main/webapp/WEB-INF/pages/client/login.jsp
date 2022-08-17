<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>LaptopShop-Đăng nhập</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="application/x-javascript">
	
	
	
	 addEventListener("load", function()
		{ setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); }




</script>
<!-- Custom Theme files -->
<link href="Frontend/css/register.css" rel="stylesheet" type="text/css"
	media="all" />
<!-- //Custom Theme files -->
<!-- web font -->
<link
	href="//fonts.googleapis.com/css?family=Roboto:300,300i,400,400i,700,700i"
	rel="stylesheet">
<!-- //web font -->
</head>
<body>
	<!-- main -->

	<c:set var="contextPath" value="${pageContext.request.contextPath}" />	
	
	<div class="main-w3layouts wrapper">
		<h1>ĐĂNG NHẬP</h1>
		<div class="main-agileinfo">
			<div class="agileits-top">

				<c:if test="${param.error != null}">
					<div class="alert alert-danger">
						<p>Invalid username and password.</p>
					</div>
				</c:if>
				<c:if test="${param.logout != null}">
					<div class="alert alert-success">
						<p>You have been logged out successfully.</p>
					</div>
				</c:if>
				<c:if test="${param.accessDenied != null}">
					<div class="alert alert-danger">
						<p>Access Denied: You are not authorised!</p>
					</div>
				</c:if>

				<!-- cái required có sẵn, nó bắt mấy lỗi cơ bản, có thể xóa đi rồi validate = javascript cũng đc -->
				<form method="POST" action="${contextPath}/login">
					<input class="text" type="text" name="email"
						placeholder="Tên đăng nhập" required> <input class="text"
						type="password" name="password" placeholder="Mật khẩu" required>
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" /> <input type="submit" value="ĐĂNG NHẬP">
				</form>
				<p>
					Chưa có Tài Khoản? <a href="${contextPath}/register"> Đăng ký!</a>
				</p>
			</div>
		</div>
		<!-- copyright -->
		<div class="colorlibcopy-agile">
			<p>© 2018 All rights reserved | Design by Group 14 - Hanoi
				University of Science and Technology</p>
		</div>
	</div>
</body>
</html>