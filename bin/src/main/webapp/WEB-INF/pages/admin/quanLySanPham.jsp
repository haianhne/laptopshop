<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Quản lý sản phẩm</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
.modal-open {
	overflow: scroll;
}
</style>
</head>
<body>
	<jsp:include page="template/header.jsp"></jsp:include>
	<jsp:include page="template/sidebar.jsp"></jsp:include>

	<div class="col-md-9 animated bounce">
		<h3 class="page-header">Quản lý Sản Phẩm</h3>

		<div class="form-group form-inline">
			<label for="sel1">THÊM MỚI SẢN PHẨM (THEO DANH MỤC): </label> <select
				id="danhMucDropdown" class="form-control">
				<c:forEach var="danhMuc" items="${listDanhMuc}">
					<option value="${danhMuc.id }">${danhMuc.tenDanhMuc }</option>
				</c:forEach>
			</select>
		</div>
		<hr>

		<form class="form-inline" id="searchForm" name="searchObject">
			<div class="form-group">
				<select class="form-control" name="danhMucId" id="danhMuc">
					<c:forEach var="danhMuc" items="${listDanhMuc }">
						<option value="${danhMuc.id}">${danhMuc.tenDanhMuc}</option>
					</c:forEach>
				</select>
			</div>
			&nbsp;&nbsp;

			<div class="form-group">
				<select class="form-control" name="hangSXId" id="hangSanXuat">
					<option value="">Tất cả</option>
					<c:forEach var="nhanHieu" items="${listNhanHieu }">
						<option value="${nhanHieu.id}">${nhanHieu.tenHangSanXuat}</option>
					</c:forEach>
				</select>
			</div>
			&nbsp;&nbsp;

			<div class="form-group">
				<select class="form-control" name="donGia" id="price">
					<option value="">Tất cả giá</option>
					<option value="duoi-2-trieu">Dưới 2 triệu</option>
					<option value="2-trieu-den-4-trieu">2 triệu đến 4 triệu</option>
					<option value="4-trieu-den-6-trieu">4 triệu - 6 triệu</option>
					<option value="6-trieu-den-10-trieu">6 triệu - 10 triệu</option>
					<option value="tren-10-trieu">Trên 10 triệu</option>
				</select>
			</div>

			<div class="form-group">
				<select class="form-control" name="sapXepTheoGia">
					<option value="asc">Sắp xếp theo giá tăng dần</option>
					<option value="desc">Sắp xếp theo giá giảm dần</option>
				</select>
			</div>

			&nbsp;&nbsp;
			<button type="button" class="btn btn-primary" id="btnDuyetSanPham">Duyệt
				sản phẩm</button>
		</form>
		<hr />
		<table class="table table-hover sanPhamTable " style="text-align: center;">
			<thead>
				<tr>
					<th>Hình ảnh</th>
					<th>Tên SP</th>
					<th>Danh Mục</th>
					<th>Hãng sản xuất</th>
					<th>Đơn giá</th>
					<th>Số lượng</th>
				</tr>
			</thead>
			<tbody>
			</tbody>

		</table>

		<ul class="pagination">
		</ul>
	</div>

	<div class="row col-md-6">
		<form id="lapTopForm" class="lapTopForm">
			<div class="modal fade lapTopModal" tabindex="-1" role="dialog"
				data-keyboard="false" data-backdrop="static">
				<div class="modal-dialog modal-lg" role="document"
					style="width: 60%;">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel">Thêm mới/ Cập
								nhật Laptop</h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body">
							<div class="row">
								<div>
									<input type="hidden" class="form-control" name="danhMucId"
										id="idDanhMucLaptop">
								</div>
								<div>
									<input type="hidden" class="form-control" name="id"
										id="idSanPhamLapTop" readonly>
								</div>
								<div class="form-group col-md-7">
									<label for="inputPassword4">Tên sản phẩm</label> <input
										type="text" class="form-control" name="tenSanPham">
								</div>
								<div class="form-group col-md-5">
									<label for="inputPassword4">Đơn giá</label> <input
										type="number" class="form-control" name="donGia" min="0"
										value="0" id="test">
								</div>
							</div>

							<div class="row">
								<div class="form-group col-md-4">
									<label for="inputState">Hãng Sản Xuất</label> <select
										name="nhaSXId" class="form-control" id="nhaSXId">
										<c:forEach var="nhanHieu" items="${listNhanHieu }">
											<option value="${nhanHieu.id}">${nhanHieu.tenHangSanXuat}</option>
										</c:forEach>
									</select>
								</div>
								<div class="form-group col-md-4">
									<label for="inputPassword4">Hệ điều hành</label> <input
										type="text" class="form-control" name="heDieuHanh">
								</div>

								<div class="form-group col-md-4">
									<label for="inputEmail4">Ram</label> <input type="text"
										class="form-control" name="ram" required="required">
								</div>

							</div>

							<div class="row">

								<div class="form-group col-md-4">
									<label for="inputPassword4">Màn hình</label> <input type="text"
										class="form-control" name="manHinh" required="required">
								</div>
								<div class="form-group col-md-4">
									<label for="inputEmail4">CPU</label> <input type="text"
										class="form-control" name="cpu">
								</div>
								<div class="form-group col-md-4">
									<label for="inputPassword4">Thiết kế</label> <input type="text"
										class="form-control" name="thietKe" required="required">
								</div>
							</div>

							<div class="row">
								<div class="form-group col-md-12">
									<label for="inputPassword4">Mô tả chung</label>
									<textarea class="form-control" name="thongTinChung"
										placeholder="" rows="2" required="required"></textarea>
								</div>
							</div>

							<div class="row">
								<div class="form-group col-md-4">
									<label for="inputEmail4">Dung lượng Pin</label> <input
										type="text" class="form-control" name="dungLuongPin"
										required="required">
								</div>
								<div class="form-group col-md-4">
									<label for="inputEmail4">Thông tin bảo hành</label> <input
										type="text" class="form-control" name="thongTinBaoHanh"
										required="required">
								</div>

								<div class="form-group col-md-4">
									<label for="inputPassword4">Số lượng</label> <input
										type="number" class="form-control" name="donViKho" min="0"
										required="required" value="0" id="test2">
								</div>
							</div>
							<div>
								<label for="inputEmail4">Hình ảnh</label> <input type="file"
									class="form-control" id="inputEmail4" name="hinhAnh">
							</div>
						</div>

						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">Hủy</button>
							<input class="btn btn-primary" id="btnSubmit" type="button"
								value="Xác nhận" />
						</div>

					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal-dialog -->
			</div>
		</form>
	</div>


	<div class="row col-md-6">
		<form class="otherForm" id="otherForm">
			<div class="modal fade otherModal" tabindex="-1" role="dialog">
				<div class="modal-dialog modal-lg" role="document"
					style="width: 60%;">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel"></h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body">
							<div class="row">
								<div>
									<input type="hidden" class="form-control" name='danhMucId'
										id="idDanhMucKhac">
								</div>
								<div>
									<input type="hidden" class="form-control" name="id"
										id="idSanPhamKhac" readonly="true">
								</div>
								<div class="form-group col-md-12">
									<label for="inputPassword4">Tên sản phẩm</label> <input
										type="text" class="form-control" name="tenSanPham">
								</div>
							</div>

							<div class="row">
								<div class="form-group col-md-6">
									<label for="inputState">Hãng Sản Xuất</label> <select
										name="nhaSXId" id="nhaSXIdKhac" class="form-control">
										<c:forEach var="nhanHieu" items="${listNhanHieu }">
											<option value="${nhanHieu.id }">${nhanHieu.tenHangSanXuat}
											</option>
										</c:forEach>
									</select>
								</div>
								<div class="form-group col-md-6">
									<label for="inputPassword4">Đơn giá</label> <input
										type="number" class="form-control" name="donGia" min="0"
										value="0" id="donGiaKhac">
								</div>
							</div>

							<div class="row">
								<div class="form-group col-md-12">
									<label for="inputPassword4">Mô tả chung</label>
									<textarea class="form-control" id="inputPassword4"
										placeholder="" rows="2" name="thongTinChung"></textarea>
								</div>
							</div>
							<div class="row">
								<div class="form-group col-md-6">
									<label for="inputEmail4">Thông tin bảo hành</label> <input
										type="text" class="form-control" id="inputEmail4"
										name="thongTinBaoHanh">
								</div>

								<div class="form-group col-md-6">
									<label for="inputPassword4">Số lượng</label> <input
										type="number" class="form-control" name="donViKho" min="0"
										value="0">
								</div>
							</div>
							<div>
								<label for="inputEmail4">Hình ảnh</label> <input type="file"
									class="form-control" name="hinhAnh">
							</div>
						</div>

						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">Hủy</button>
							<button class="btn btn-primary" id="btnSubmit" type="submit">Xác
								nhận</button>
						</div>
					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal-dialog -->
			</div>
		</form>
	</div>
	</div>


	<jsp:include page="template/footer.jsp"></jsp:include>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery.serializeJSON/2.9.0/jquery.serializejson.js"></script>
	<script src="<c:url value='/js/sanPhamAjax.js'/>"></script>
</body>
</html>