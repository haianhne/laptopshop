<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Thông tin cá nhân</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<style>
.form-profile input {
	border: 0;
}
</style>

</head>
<body>
	<jsp:include page="template/header.jsp"></jsp:include>
	<jsp:include page="template/sidebar.jsp"></jsp:include>

	<div class="col-md-9 animated bounce">
		<h3 class="page-header">Thông tin cá nhân</h3>

		<button class="btn btn-success btnCapNhatThongTin">Cập nhật
			thông tin</button>
		&nbsp;&nbsp;&nbsp;
		<button class="btn btn-primary btnDoiMatKhau">Đổi mật khẩu</button>
		<hr />

		<form class="form-profile">

			<div class="form-group row">
				<div class="col-sm-10">
					<input type="hidden" class="form-control-plaintext nguoiDungId"
						value="${user.id }">
				</div>
			</div>
			<div class="form-group row">
				<label for="staticEmail" class="col-sm-2 col-form-label">Họ
					Tên</label>
				<div class="col-sm-10">
					<input type="text" readonly class="form-control-plaintext"
						value="${user.hoTen }">
				</div>
			</div>

			<div class="form-group row">
				<label for="staticEmail" class="col-sm-2 col-form-label">Email
					đăng ký</label>
				<div class="col-sm-10">
					<input type="text" readonly class="form-control-plaintext"
						value="${user.email }">
				</div>
			</div>

			<div class="form-group row">
				<label for="staticEmail" class="col-sm-2 col-form-label">Số
					điện thoại</label>
				<div class="col-sm-10">
					<input type="text" readonly class="form-control-plaintext"
						value="${user.soDienThoai }">
				</div>
			</div>

			<div class="form-group row">
				<label for="staticEmail" class="col-sm-2 col-form-label">Địa
					chỉ</label>
				<div class="col-sm-10">
					<input type="text" readonly class="form-control-plaintext"
						value="${user.diaChi }">
				</div>
			</div>
		</form>
	</div>

	<div class="row col-md-6">
		<form class="formCapNhat"
			action="${contextPath }/admin/profile/update" method="post">
			<div>
				<div class="modal fade" id="capNhatModal" tabindex="-1"
					role="dialog" aria-labelledby="exampleModalLabel"
					aria-hidden="true" data-backdrop="static" data-keyboard="false">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalLabel">Cập nhật
									thông tin cá nhân</h5>
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
							<div class="modal-body">

								<input type="hidden" name="${_csrf.parameterName}"
									value="${_csrf.token}" />
								<div class="form-group">
									<input type="hidden" class="form-control" name="id"
										value="${user.id }" />
								</div>
								<div class="form-group">
									<label for="name">Họ tên</label> <input type="text"
										class="form-control" name="hoTen" required="required" />
								</div>
								<div class="form-group">
									<label for="name">Số điện thoại</label> <input type="text"
										class="form-control" name="soDienThoai" required="required" />
								</div>
								<div class="form-group">
									<label for="name">Địa chỉ</label> <input type="text"
										class="form-control" name="diaChi" required="required" />
								</div>

								<div class="modal-footer">
									<button type="button" class="btn btn-secondary"
										data-dismiss="modal">Hủy</button>
									<input class="btn btn-primary" id="btnSubmit" type="submit"
										value="Xác nhận" />
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>

		<form class="formDoiMatKhau">
			<div>
				<div class="modal fade" id="doiMKModal" tabindex="-1" role="dialog"
					aria-labelledby="exampleModalLabel" aria-hidden="true"
					data-backdrop="static" data-keyboard="false">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalLabel">Đổi mật khẩu</h5>
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
							<div class="modal-body">
								<div>
									<input type="hidden" name="${_csrf.parameterName}"
										value="${_csrf.token}" />
								</div>

								<div class="form-group">
									<label for="name">Mật khẩu cũ</label> <input type="password"
										class="form-control" name="oldPassword" required="required" />
								</div>
								<div class="form-group">
									<label for="name">Mật khẩu mới</label> <input type="password"
										class="form-control" name="newPassword" required="required" />
								</div>
								<div class="form-group">
									<label for="name">Nhắc lại mật khẩu mới</label> <input
										type="password" class="form-control" name="confirmNewPassword"
										required="required" />
								</div>

								<div class="modal-footer">
									<button type="button" class="btn btn-secondary"
										data-dismiss="modal">Hủy</button>
									<input class="btn btn-primary" type="button"
										id="btnXacNhanDoiMK" value="Xác nhận" />
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
	<script src="<c:url value='/js/profileAdminAjax.js'/>"></script>
</body>
</html>