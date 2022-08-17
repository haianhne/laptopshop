<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="col-md-9 animated bounce">
	<h1 class="page-header">Dashboard</h1>
	<ul class="breadcrumb">
		<li><span class="glyphicon glyphicon-home">&nbsp;</span>Home</li>
		<li><a href="#">Dashboard</a></li>
	</ul>
	<table class="table table-hover danhMucTable">
		<thead>
			<tr>
				<th>Mã danh mục</th>
				<th>Tên Danh mục</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="danhMuc" items="${listDanhMuc }">
				<tr>
					<td>${danhMuc.id }</td>
					<td>${danhMuc.tenDanhMuc }</td>
				</tr>
			</c:forEach>
		</tbody>

	</table>
</div>
</div>