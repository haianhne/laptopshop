<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Quản lý Liên hệ</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<style type="text/css">
td, #noiDungLienHe, .noiDungLienHe, #noiDungTraLoi {
	word-wrap: break-word;
}
</style>
</head>
<body>
	<jsp:include page="template/header.jsp"></jsp:include>
	<jsp:include page="template/sidebar.jsp"></jsp:include>

	<div class="col-md-9 animated bounce">
		<h3 class="page-header">Quản lý Liên hệ</h3>
		<div class="form-group form-inline">
			<div class="form-group">
				<select class="form-control trangThai">
					<option value="Đang chờ trả lời">Đang chờ trả lời</option>
					<option value="Đã trả lời">Đã trả lời</option>
					<option value="">Tất cả</option>
				</select>
			</div>

			<div class="form-group">
				<input class="form-control" type="text" id="fromDate"
					placeholder="Từ ngày">
			</div>

			<div class="form-group">
				<input class="form-control" type="text" id="toDate"
					placeholder="Đến ngày">
			</div>
			&nbsp;&nbsp; &nbsp;&nbsp;
			<button type="button" class="btn btn-primary" id="btnDuyetLienHe">Duyệt
				Liên Hệ</button>
		</div>
		<hr>

		<table class="table table-hover lienHeTable"
			style="text-align: center;">
			<thead>
				<tr>
					<th>Mã</th>
					<th>Email</th>
					<th>Ngày gửi</th>
					<th>Trạng thái</th>
					<th>Ngày trả lời</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
			</tbody>

		</table>
		<ul class="pagination">
		</ul>
	</div>
	<div class="row col-md-6">
		<form class="chiTietForm" id="form">
			<div>
				<div class="modal fade" id="chiTietModal" tabindex="-1"
					role="dialog" aria-labelledby="exampleModalLabel"
					aria-hidden="true" data-backdrop="static" data-keyboard="false">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalLabel">Thông tin
									liên hệ</h5>
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
							<div class="modal-body">
								<div class="form-group">
									<p id="email"></p>
									<br>
									<p id="noiDungLienHe"></p>
									<br>
									<p id="ngayLienHe"></p>
									<br>
									<p id="trangThai"></p>
									<br>
									<p id="noiDungTraLoi"></p>
									<br>
									<p id="ngayTraLoi"></p>
									<br>
								</div>

								<div class="modal-footer">
									<button type="button" class="btn btn-secondary"
										data-dismiss="modal">Đóng</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>

	<div class="row col-md-6">
		<form class="lienHeForm" id="form">
			<div>
				<div class="modal fade" id="lienHeModal" tabindex="-1" role="dialog"
					aria-labelledby="exampleModalLabel" aria-hidden="true"
					data-backdrop="static" data-keyboard="false">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalLabel">Trả lời liên hệ </h5>
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
							<div class="modal-body">
								<div class="form-group">
									<input type="hidden" name="lienHeId" class="form-control" />
								</div>
								<div class="form-group">
									<label for="name">Email liên hệ:</label> <input type="text"
										name="emailLienHe" id="emailLienHe" style="border: 0"
										readonly="readonly" />
								</div>

								<div class="form-group">
									<label for="name">Nội dung liên hệ:</label>
									<textarea class="form-control" name="noiDungLienHe"
										id="ndLienHe" style="border: 0; background-color: #fff"
										rows="3" readonly="readonly"></textarea>
								</div>
								<div class="form-group">
									<label for="noiDungTraLoi">Nội dung trả lời</label>
									<textarea class="form-control" name="noiDungTraLoi"
										id="ndTraLoi" rows="5"></textarea>

								</div>
							</div>

							<div class="modal-footer">
								<button type="button" class="btn btn-secondary"
									data-dismiss="modal">Đóng</button>
								<input type="button" class="btn btn-primary btnSubmitTraLoi"
									value="Xác nhận">
							</div>
						</div>
					</div>
				</div>
			</div>
			</form>
	</div>
	</form>
	</div>
	</div>

	<jsp:include page="template/footer.jsp"></jsp:include>
	<script type="text/javascript">
		$(function() {
			var from = $("#fromDate").datepicker({
				dateFormat : "dd-mm-yy",
				changeMonth : true
			}).on("change", function() {
				to.datepicker("option", "minDate", getDate(this));
			}), to = $("#toDate").datepicker({
				dateFormat : "dd-mm-yy",
				changeMonth : true
			}).on("change", function() {
				from.datepicker("option", "maxDate", getDate(this));
			});

			function getDate(element) {
				var date;
				var dateFormat = "dd-mm-yy";
				try {
					date = $.datepicker.parseDate(dateFormat, element.value);
				} catch (error) {
					date = null;
				}

				return date;
			}
		});
	</script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery.serializeJSON/2.9.0/jquery.serializejson.js"></script>
	<script src="<c:url value='/js/lienHeAjax.js'/>"></script>
</body>
</html>