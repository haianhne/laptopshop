<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<link rel="stylesheet" href="Frontend/css/detailsp.css">
</head>
	
<body>
	<div class="container">
		<div class="card">
			<div class="container-fliud">
				<div class="wrapper row">
					<div class="preview col-md-6">
						
						<div class="preview-pic tab-content">
						  <div class="tab-pane active" id="pic-1"><img src="/laptopshop/img/${sp.getId()}.png" /></div>
						</div>		
					</div>
					<div class="details col-md-6">
						<p style="display:none" id="spid">${sp.getId()}</p>
						<h2 class="product-title">${sp.getTenSanPham()}</h2>
						<h4 class="price">Mô tả sản phẩm</h4>
						<c:if test = "${sp.getCpu().length() > 0}">
							<p class="product-description">CPU: ${sp.getCpu()}</p>
						</c:if>
						<c:if test = "${sp.getRam().length() > 0}">
							<p class="product-description">RAM: ${sp.getRam()}</p>
						</c:if>
						<c:if test = "${sp.getThietKe().length() > 0}">
						<p class="product-description">Thiết kế: ${sp.getThietKe()}</p>
						</c:if>
						<c:if test = "${sp.getHeDieuHanh().length() > 0}">
							<p class="product-description">Hệ điều hành: ${sp.getHeDieuHanh()}</p>
						</c:if>
						<c:if test = "${sp.getManHinh().length() > 0}">
							<p class="product-description">Màn hình: ${sp.getManHinh()}</p>
						</c:if>
						<c:if test = "${sp.getDungLuongPin().length() > 0}">
							<p class="product-description">Dung lượng pin: ${sp.getDungLuongPin()}</p>
						</c:if>
						<p class="product-description"><span class="important">Thông tin chung:</span> ${sp.getThongTinChung()}</p>
						<p class="product-description"><span class="important">Bảo hành:</span> ${sp.getThongTinBaoHanh()}</p>
						<h4 class="price">Giá bán: <span>${sp.getDonGia()} VND</span></h4>
						<div class="action">
							<button class="add-to-cart btn btn-default" type="button" onclick='window.alert("Đã thêm sản phẩm vào giỏ hàng");'>Giỏ hàng</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

<script src="<c:url value='/js/client/detailspAjax.js'/>" ></script>	 