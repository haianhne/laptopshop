<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
  			
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		
		<link href="Frontend/css/style.css" rel="stylesheet" type="text/css"  media="all" />
		<link href='//fonts.googleapis.com/css?family=Londrina+Solid|Coda+Caption:800|Open+Sans' rel='stylesheet' type='text/css'>
		
		<link rel="stylesheet" href="Frontend/css/responsiveslides.css">
		<script src="Frontend/js/jquery.min.js"></script>
		<script src="Frontend/js/responsiveslides.min.js"></script>
		
		
		
    
 
		
		
		  <script>
		    // You can also use "$(window).load(function() {"
			    $(function () {
			
			      // Slideshow 1
			      $("#slider1").responsiveSlides({
			        maxwidth: 1600,
			        speed: 600
			      });
			});
		  </script>
	</head>
	<body>
	<!--  
	<img alt ="not found" src="resources/Frontend/images/m1.jpg">
	<img alt="not found" src="Frontend/img/m1.jpg">
	<img alt="not found" src="<c:url value='/img/m1.jpg' />"> -->
	
		<div class="wrap">
		<!----start-Header---->
		<div class="header">
			<div class="search-bar">
				<form action="/laptopshop/search">
					<input type="text" name="name"><input type="submit" value="Search" />
				</form>
			</div>
			<div class="clear"> </div>
			
			<div class="header-top-nav ">
					<c:if test="${pageContext.request.userPrincipal.name != null}">
						
						<ul>
						<li>
							Welcome ${pageContext.request.userPrincipal.name} </li>
							
						<li><a href="#">Vận chuyển</a></li>
						<li><a href="<%=request.getContextPath()%>/checkout"">Thanh toán</a></li>
						<li><a href="<%=request.getContextPath()%>/account">Tài khoản</a></li>
						<li><a href="<%=request.getContextPath()%>/cart"><span>Giỏ hàng&nbsp;&nbsp;: </span></a><span class="glyphicon glyphicon-shopping-cart"></span></li>
						<li><a href="<%=request.getContextPath()%>/logout"> Đăng xuất</a></li>
						</ul>
					</c:if>
					
					<c:if test="${pageContext.request.userPrincipal.name == null}">
					<ul>
						<li><a href="<%=request.getContextPath()%>/register">Đăng kí</a></li>
						<li><a href="<%=request.getContextPath()%>/login">Đăng nhập</a></li>
						<li><a href="<%=request.getContextPath()%>/cart"><span>Giỏ hàng&nbsp;&nbsp;&nbsp;</span></a><span class="glyphicon glyphicon-shopping-cart"></span></li>
						
</ul>
					</c:if>
			</div>
			<div class="clear"> </div>
		</div>
		</div>
		<div class="clear"> </div>
		<div class="top-header">
			<div class="wrap">
		<!----start-logo---->
			<div class="logo">
				<a href="<%=request.getContextPath()%>/"><img src="Frontend/img/logo3.png" title="logo"/></a>
			</div>
		<!----end-logo---->
		<!----start-top-nav---->
		<div class="top-nav">
			<ul>
				<li><a href="<%=request.getContextPath()%>/">Trang Chủ</a></li>
				
				<li><a href="<%=request.getContextPath()%>/store">Cửa hàng</a></li>
				<li><a href="store.html">Phụ kiện</a></li>
				<li><a href="blog.html">Khuyến mại</a></li>
				<li><a href="about.html">Giới thiệu</a></li>
				<li><a href="contact.html">Liên hệ</a></li>
			</ul>
		</div>
		<div class="clear"> </div>
		</div>
		</div>
		<!----End-top-nav---->
		<!----End-Header---->
	
		    	