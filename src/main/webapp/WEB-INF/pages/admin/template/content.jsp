<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="col-md-9 animated bounce">
	<h3 class="page-header">Danh sách công việc</h3>
	<c:if test = "${listCongViec.soDonHangMoi > 0}">
         <p>Bạn có: <a href='<c:url value="/admin/don-hang" />'> ${listCongViec.soDonHangMoi} đơn hàng mới</a><p>
    </c:if>
    
    <c:if test = "${listCongViec.soDonhangChoDuyet > 0}">
         <p>Bạn có: <a href='<c:url value="/admin/don-hang" />'> ${listCongViec.soDonhangChoDuyet} đơn hàng chờ duyệt</a><p>
    </c:if>

	<c:if test = "${listCongViec.soLienHeMoi > 0}">
         <p>Bạn có: <a href='<c:url value="/admin/lien-he" />'> ${listCongViec.soLienHeMoi} liên hệ mới</a><p>
    </c:if>
    
</div>
</div>