<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Quản lý tài khoản</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<jsp:include page="template/header.jsp"></jsp:include>
	<jsp:include page="template/sidebar.jsp"></jsp:include>

	<div class="col-md-9 animated bounce">
		<h3 class="page-header">Quản lý Tài khoản</h3>

		<button class="btn btn-success btnThemTaiKhoan">Thêm mới tài
			khoản</button>
		<hr>
		<div class="form-group form-inline">
			<label for="sel1"><strong>Lọc tài khoản:</strong> </label> <select
				id="vaiTro" class="form-control">
				<c:forEach var="vaiTro" items="${listVaiTro}">
					<option value="${vaiTro.tenVaiTro }">${vaiTro.tenVaiTro }</option>
				</c:forEach>
			</select>
		</div>
		<hr>


		<table class="table table-hover taiKhoanTable"
			style="text-align: center;">
			<thead>
				<tr>
					<th>Mã ND</th>
					<th>Họ tên</th>
					<th>Email</th>
					<th>Số điện thoại</th>
					<th>Địa chỉ</th>
					<th>Vai trò</th>
					<th></th>
				</tr>

			</thead>
			<tbody>
			</tbody>

		</table>
	</div>
	<div class="row col-md-6">
		<form class="taiKhoanForm" id="form">
			<div>
				<div class="modal fade" id="taiKhoanModal" tabindex="-1"
					role="dialog" aria-labelledby="exampleModalLabel"
					aria-hidden="true" data-backdrop="static" data-keyboard="false">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalLabel">Tạo mới tài
									khoản</h5>
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
							<div class="modal-body">
<!-- 								<div class="form-group">
									<input type="hidden" class="form-control" name="id" />
								</div> -->
								<div class="form-group">
									<label for="name">Email</label> <input type="email"
										class="form-control" name="email" required />
								</div>
								<div class="form-group">
									<label for="name">Mật khẩu:(8-32 ký tự)</label> <input
										type="password" class="form-control" name="password" required />
								</div>
								<div class="form-group">
									<label for="name">Nhắc lại mật khẩu:</label> <input type="password"
										class="form-control" name="confirmPassword" required />
								</div>

								<div class="form-group">
									<label for="name">Chọn vai trò:</label>
									<c:forEach var="vaiTro" items="${listVaiTro}">
										<label class="radio-inline"> 
										<input type="radio"
											name="tenVaiTro" value="${vaiTro.tenVaiTro}" checked="checked">
											${vaiTro.tenVaiTro}
										</label>
									</c:forEach>
								</div>

								<div class="form-group">
									<label for="name">Họ tên:</label> <input type="text"
										class="form-control" name="hoTen" required />
								</div>
								<div class="form-group">
									<label for="name">Số điện thoại:</label> <input type="text"
										class="form-control" name="sdt" required />
								</div>
								<div class="form-group">
									<label for="name">Địa chỉ:</label> <input type="text"
										class="form-control" name="diaChi" required />
								</div>


								<div class="modal-footer">
									<button type="button" class="btn btn-secondary"
										data-dismiss="modal">Hủy</button>
									<input class="btn btn-primary" id="btnSubmit" type="button"
										value="Xác nhận" />
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
	</div>

	<jsp:include page="template/footer.jsp"></jsp:include>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery.serializeJSON/2.9.0/jquery.serializejson.js"></script>
	<script src="<c:url value='/js/taiKhoanAjax.js'/>"></script>
</body>
</html>