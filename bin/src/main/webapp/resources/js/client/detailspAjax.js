$(document).ready(function(){
	$(".add-to-cart").click(function(){
		ajaxGet($("#spid").text());
	});

	function ajaxGet(id){
		$.ajax({
			type: "GET",		
			url: "http://localhost:8080/laptopshop/api/gio-hang/addSanPham?id="+id,
			success: function(result){
				console.log("sucess");	
			},
			error : function(e){
				alert("Error: ",e);
				console.log("Error" , e );
			}
		});
	}
})
