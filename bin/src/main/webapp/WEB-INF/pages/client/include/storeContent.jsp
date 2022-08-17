<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script src="Frontend/js/jquery-1.js"></script>
<script src="Frontend/js/bootstrap.min.js"></script>

<style>
.carousel-caption {
    top: 210px;
    bottom: auto;
    color: black;
}
.img-resize{
	height: 250px;
	width: 300px;
}

.carousel-control.left, .carousel-control.right {
   background-image:none !important;
   filter:none !important;
}


.carousel-control .glyphicon-chevron-right, .carousel-control .icon-next {
  right: 0;  //or you can increase this
}

.carousel-control .glyphicon-chevron-left, .carousel-control .icon-prev {
  left: 0; //or you can increase this
}

</style>
<body>
<!-- Start first slide -->
<!-- data-interval set time each slide -->
<div>
<br>
<div>
	<h4 style="margin-left: 105px; display:inline"><b>LAPTOP GAMING - ĐỒ HOẠ</b></h4>
	<h4 style="margin-left: 855px; display:inline"><a href="#">Xem tất cả</a></h4>
</div>
<br>
<div class="container">
<div class="row">
<div class="col-xs-12">
<div id="myCarousel-one" class="carousel slide "  data-interval="10000"> 
	<ol class="carousel-indicators">
		<li data-target="#myCarousel-one" data-slide-to ="0" class="active"></li>
		<li data-target="#myCarousel-one" data-slide-to ="1"></li>
	</ol>
	<div class="carousel-inner">
		<div class="item active">
			<div class="row">
				<div class="col-xs-3">
					<a href="#"><img src="Frontend/img/1.png" alt="not found img" class="img-reponsive img-resize"></a>
				 	<div class="carousel-caption">DELL VOSTRO 5480 </div>
				 	<h4>Giá: 15.000.000 đ</h4>
					<h4> Màn hình:</h4>
					<h4>CPU:</h4>
					<h4>RAM:</h4>
					<h4>Hệ điều hành:</h4>
					<h4>Nặng:</h4>
				</div>
			
				<div class="col-xs-3">
					<a href="#"><img src="Frontend/img/1.png" alt="not found img" class="img-reponsive img-resize"></a>
				 	<div class="carousel-caption">DELL VOSTRO 5480 </div>
				 	<h4>Giá: 16.000.000 đ</h4>
					<h4> Màn hình:</h4>
					<h4>CPU:</h4>
					<h4>RAM:</h4>
					<h4>Hệ điều hành:</h4>
					<h4>Nặng:</h4>
					
				</div>
				
				<div class="col-xs-3">
					<a href="#"><img src="Frontend/img/1.png" alt="not found img" class="img-reponsive img-resize"></a>
				 	<div class="carousel-caption">DELL VOSTRO 5480 </div>
				 	<h4>Giá: 16.000.000 đ</h4>
					<h4> Màn hình:</h4>
					<h4>CPU:</h4>
					<h4>RAM:</h4>
					<h4>Hệ điều hành:</h4>
					<h4>Nặng:</h4>
				</div>
				
				<div class="col-xs-3">
					<a href="#"><img src="Frontend/img/1.png" alt="not found img" class="img-reponsive img-resize"></a>
				 	<div class="carousel-caption">DELL VOSTRO 5480 </div>
				 	<h4>Giá: 16.000.000 đ</h4>
					<h4> Màn hình:</h4>
					<h4>CPU:</h4>
					<h4>RAM:</h4>
					<h4>Hệ điều hành:</h4>
					<h4>Nặng:</h4>
				</div>
			
			</div>
			
			
		</div>
		
		<div class="item">
			<div class ="row">
				<div class="col-xs-3">
					<a href="#"><img src="Frontend/img/laptop-asus.jpg" alt="not found img" class="img-reponsive img-resize"></a>
				 	<div class="carousel-caption">Laptop Asus </div>
				 	<h4>Giá: 16.000.000 đ</h4>
					<h4> Màn hình:</h4>
					<h4>CPU:</h4>
					<h4>RAM:</h4>
					<h4>Hệ điều hành:</h4>
					<h4>Nặng:</h4>
				</div>
				<div class="col-xs-3">
					<a href="#"><img src="Frontend/img/laptop-asus.jpg" alt="not found img" class="img-reponsive img-resize"></a>
				 	<div class="carousel-caption">Laptop Asus </div>
				 	<h4>Giá: 16.000.000 đ</h4>
					<h4> Màn hình:</h4>
					<h4>CPU:</h4>
					<h4>RAM:</h4>
					<h4>Hệ điều hành:</h4>
					<h4>Nặng:</h4>
				</div>
				<div class="col-xs-3">
					<a href="#"><img src="Frontend/img/laptop-asus.jpg" alt="not found img" class="img-reponsive img-resize"></a>
				 	<div class="carousel-caption">Laptop Asus </div>
				 	<h4>Giá: 16.000.000 đ</h4>
					<h4> Màn hình:</h4>
					<h4>CPU:</h4>
					<h4>RAM:</h4>
					<h4>Hệ điều hành:</h4>
					<h4>Nặng:</h4>
				</div>
				<div class="col-xs-3">
					<a href="#"><img src="Frontend/img/laptop-asus.jpg" alt="not found img" class="img-reponsive img-resize"></a>
				 	<div class="carousel-caption">Laptop Asus </div>
				 	<h4>Giá: 16.000.000 đ</h4>
					<h4> Màn hình:</h4>
					<h4>CPU:</h4>
					<h4>RAM:</h4>
					<h4>Hệ điều hành:</h4>
					<h4>Nặng:</h4>
				</div>
			</div>
		</div>
		
	
	</div>
	
	<a class="carousel-control left" href="#myCarousel-one" data-slide="prev">
	<span class="icon-prev"></span>
	</a>
	
	<a class="carousel-control right" href="#myCarousel-one" data-slide="next">
	<span class="icon-next"></span>
	</a>
</div>
</div>
</div>
</div>
</div>
<!-- End first slide -->

<hr style=" width:80%;">

<!-- Start second slide -->
<div>
<br>
<div>
<h4 style="margin-left: 105px; display:inline"><b>LAPTOP GIÁ RẺ</b></h4>
<h4 style="margin-left: 945px; display:inline"><a href="#">Xem tất cả</a></h4>
</div>

<br>
<div class="container">
<div class="row">
<div class="col-xs-12">
<div id="myCarousel-two" class="carousel slide"  data-interval="10000"> 
	<ol class="carousel-indicators">
		<li data-target="#myCarousel-two" data-slide-to ="0" class="active"></li>
		<li data-target="#myCarousel-two" data-slide-to ="1"></li>
	</ol>
	<div class="carousel-inner">
		<div class="item active">
			<div class="row">
				<div class="col-xs-3">
					<img src="Frontend/img/1.png" alt="not found img" class="img-reponsive img-resize">
				 	<div class="carousel-caption">DELL VOSTRO 5480 </div>
					<h4> Màn hình:</h4>
					<h4>CPU:</h4>
					<h4>RAM:</h4>
					<h4>Hệ điều hành:</h4>
					<h4>Nặng:</h4>
				</div>
			
				<div class="col-xs-3">
					<img src="Frontend/img/1.png" alt="not found img" class="img-reponsive img-resize">
				 	<div class="carousel-caption">DELL VOSTRO 5480 </div>
					<h4> Màn hình:</h4>
					<h4>CPU:</h4>
					<h4>RAM:</h4>
					<h4>Hệ điều hành:</h4>
					<h4>Nặng:</h4>
					
				</div>
				
				<div class="col-xs-3">
					<img src="Frontend/img/1.png" alt="not found img" class="img-reponsive img-resize">
				 	<div class="carousel-caption">DELL VOSTRO 5480 </div>
					<h4> Màn hình:</h4>
					<h4>CPU:</h4>
					<h4>RAM:</h4>
					<h4>Hệ điều hành:</h4>
					<h4>Nặng:</h4>
				</div>
				
				<div class="col-xs-3">
					<img src="Frontend/img/1.png" alt="not found img" class="img-reponsive img-resize">
				 	<div class="carousel-caption">DELL VOSTRO 5480 </div>
					<h4> Màn hình:</h4>
					<h4>CPU:</h4>
					<h4>RAM:</h4>
					<h4>Hệ điều hành:</h4>
					<h4>Nặng:</h4>
				</div>
			
			</div>
			
			
		</div>
		
		<div class="item">
			<div class ="row">
				<div class="col-xs-3">
					<img src="Frontend/img/laptop-asus.jpg" alt="not found img" class="img-reponsive img-resize">
				 	<div class="carousel-caption">Laptop Asus </div>
					<h4> Màn hình:</h4>
					<h4>CPU:</h4>
					<h4>RAM:</h4>
					<h4>Hệ điều hành:</h4>
					<h4>Nặng:</h4>
				</div>
				<div class="col-xs-3">
					<img src="Frontend/img/laptop-asus.jpg" alt="not found img" class="img-reponsive img-resize">
				 	<div class="carousel-caption">Laptop Asus </div>
					<h4> Màn hình:</h4>
					<h4>CPU:</h4>
					<h4>RAM:</h4>
					<h4>Hệ điều hành:</h4>
					<h4>Nặng:</h4>
				</div>
				<div class="col-xs-3">
					<img src="Frontend/img/laptop-asus.jpg" alt="not found img" class="img-reponsive img-resize">
				 	<div class="carousel-caption">Laptop Asus </div>
					<h4> Màn hình:</h4>
					<h4>CPU:</h4>
					<h4>RAM:</h4>
					<h4>Hệ điều hành:</h4>
					<h4>Nặng:</h4>
				</div>
				<div class="col-xs-3">
					<img src="Frontend/img/laptop-asus.jpg" alt="not found img" class="img-reponsive img-resize">
				 	<div class="carousel-caption">Laptop Asus </div>
					<h4> Màn hình:</h4>
					<h4>CPU:</h4>
					<h4>RAM:</h4>
					<h4>Hệ điều hành:</h4>
					<h4>Nặng:</h4>
				</div>
			</div>
		</div>
		
	
	</div>
	
	<a class="carousel-control left" href="#myCarousel-two" data-slide="prev">
	<span class="icon-prev"></span>
	</a>
	
	<a class="carousel-control right" href="#myCarousel-two" data-slide="next">
	<span class="icon-next"></span>
	</a>
</div>
</div>
</div>
</div>
</div>
<!-- End second slide -->
<hr style=" width:80%;">
<!-- Start thirst slide -->
<div>
<br>
<div>
<h4 style="margin-left: 105px; display:inline"><b>LAPTOP SINH VIÊN - VĂN PHÒNG</b></h4>
<h4 style="margin-left: 805px; display:inline"><a href="#">Xem tất cả</a></h4>
</div>

<br>
<div class="container">
<div class="row">
<div class="col-xs-12">
<div id="myCarousel-three" class="carousel slide"  data-interval="10000"> 
	<ol class="carousel-indicators">
		<li data-target="#myCarousel-three" data-slide-to ="0" class="active"></li>
		<li data-target="#myCarousel-three" data-slide-to ="1"></li>
	</ol>
	<div class="carousel-inner">
		<div class="item active">
			<div class="row">
				<div class="col-xs-3">
					<img src="Frontend/img/1.png" alt="not found img" class="img-reponsive img-resize">
				 	<div class="carousel-caption">DELL VOSTRO 5480 </div>
					<h4> Màn hình:</h4>
					<h4>CPU:</h4>
					<h4>RAM:</h4>
					<h4>Hệ điều hành:</h4>
					<h4>Nặng:</h4>
				</div>
			
				<div class="col-xs-3">
					<img src="Frontend/img/1.png" alt="not found img" class="img-reponsive img-resize">
				 	<div class="carousel-caption">DELL VOSTRO 5480 </div>
					<h4> Màn hình:</h4>
					<h4>CPU:</h4>
					<h4>RAM:</h4>
					<h4>Hệ điều hành:</h4>
					<h4>Nặng:</h4>
					
				</div>
				
				<div class="col-xs-3">
					<img src="Frontend/img/1.png" alt="not found img" class="img-reponsive img-resize">
				 	<div class="carousel-caption">DELL VOSTRO 5480 </div>
					<h4> Màn hình:</h4>
					<h4>CPU:</h4>
					<h4>RAM:</h4>
					<h4>Hệ điều hành:</h4>
					<h4>Nặng:</h4>
				</div>
				
				<div class="col-xs-3">
					<img src="Frontend/img/1.png" alt="not found img" class="img-reponsive img-resize">
				 	<div class="carousel-caption">DELL VOSTRO 5480 </div>
					<h4> Màn hình:</h4>
					<h4>CPU:</h4>
					<h4>RAM:</h4>
					<h4>Hệ điều hành:</h4>
					<h4>Nặng:</h4>
				</div>
			
			</div>
			
			
		</div>
		
		<div class="item">
			<div class ="row">
				<div class="col-xs-3">
					<img src="Frontend/img/laptop-asus.jpg" alt="not found img" class="img-reponsive img-resize">
				 	<div class="carousel-caption">Laptop Asus </div>
					<h4> Màn hình:</h4>
					<h4>CPU:</h4>
					<h4>RAM:</h4>
					<h4>Hệ điều hành:</h4>
					<h4>Nặng:</h4>
				</div>
				<div class="col-xs-3">
					<img src="Frontend/img/laptop-asus.jpg" alt="not found img" class="img-reponsive img-resize">
				 	<div class="carousel-caption">Laptop Asus </div>
					<h4> Màn hình:</h4>
					<h4>CPU:</h4>
					<h4>RAM:</h4>
					<h4>Hệ điều hành:</h4>
					<h4>Nặng:</h4>
				</div>
				<div class="col-xs-3">
					<img src="Frontend/img/laptop-asus.jpg" alt="not found img" class="img-reponsive img-resize">
				 	<div class="carousel-caption">Laptop Asus </div>
					<h4> Màn hình:</h4>
					<h4>CPU:</h4>
					<h4>RAM:</h4>
					<h4>Hệ điều hành:</h4>
					<h4>Nặng:</h4>
				</div>
				<div class="col-xs-3">
					<img src="Frontend/img/laptop-asus.jpg" alt="not found img" class="img-reponsive img-resize">
				 	<div class="carousel-caption">Laptop Asus </div>
					<h4> Màn hình:</h4>
					<h4>CPU:</h4>
					<h4>RAM:</h4>
					<h4>Hệ điều hành:</h4>
					<h4>Nặng:</h4>
				</div>
			</div>
		</div>
		
	
	</div>
	
	<a class="carousel-control left" href="#myCarousel-three" data-slide="prev">
	<span class="icon-prev"></span>
	</a>
	
	<a class="carousel-control right" href="#myCarousel-three" data-slide="next">
	<span class="icon-next"></span>
	</a>
</div>
</div>
</div>
</div>
</div>
<!-- End thirst slide -->
<hr style=" width:80%;">
<!-- Start fourth slide -->
<div>
<br>
<div>
<h4 style="margin-left: 105px; display:inline"><b>LAPTOP MỎNG NHẸ</b></h4>
<h4 style="margin-left: 905px; display:inline"><a href="#">Xem tất cả</a></h4>
</div>

<br>
<div class="container">
<div class="row">
<div class="col-xs-12">
<div id="myCarousel-four" class="carousel slide"  data-interval="10000"> 
	<ol class="carousel-indicators">
		<li data-target="#myCarousel-four" data-slide-to ="0" class="active"></li>
		<li data-target="#myCarousel-four" data-slide-to ="1"></li>
	</ol>
	<div class="carousel-inner">
		<div class="item active">
			<div class="row">
				<div class="col-xs-3">
					<img src="Frontend/img/1.png" alt="not found img" class="img-reponsive img-resize">
				 	<div class="carousel-caption">DELL VOSTRO 5480 </div>
					<h4> Màn hình:</h4>
					<h4>CPU:</h4>
					<h4>RAM:</h4>
					<h4>Hệ điều hành:</h4>
					<h4>Nặng:</h4>
				</div>
			
				<div class="col-xs-3">
					<img src="Frontend/img/1.png" alt="not found img" class="img-reponsive img-resize">
				 	<div class="carousel-caption">DELL VOSTRO 5480 </div>
					<h4> Màn hình:</h4>
					<h4>CPU:</h4>
					<h4>RAM:</h4>
					<h4>Hệ điều hành:</h4>
					<h4>Nặng:</h4>
					
				</div>
				
				<div class="col-xs-3">
					<img src="Frontend/img/1.png" alt="not found img" class="img-reponsive img-resize">
				 	<div class="carousel-caption">DELL VOSTRO 5480 </div>
					<h4> Màn hình:</h4>
					<h4>CPU:</h4>
					<h4>RAM:</h4>
					<h4>Hệ điều hành:</h4>
					<h4>Nặng:</h4>
				</div>
				
				<div class="col-xs-3">
					<img src="Frontend/img/1.png" alt="not found img" class="img-reponsive img-resize">
				 	<div class="carousel-caption">DELL VOSTRO 5480 </div>
					<h4> Màn hình:</h4>
					<h4>CPU:</h4>
					<h4>RAM:</h4>
					<h4>Hệ điều hành:</h4>
					<h4>Nặng:</h4>
				</div>
			
			</div>
			
			
		</div>
		
		<div class="item">
			<div class ="row">
				<div class="col-xs-3">
					<img src="Frontend/img/laptop-asus.jpg" alt="not found img" class="img-reponsive img-resize">
				 	<div class="carousel-caption">Laptop Asus </div>
					<h4> Màn hình:</h4>
					<h4>CPU:</h4>
					<h4>RAM:</h4>
					<h4>Hệ điều hành:</h4>
					<h4>Nặng:</h4>
				</div>
				<div class="col-xs-3">
					<img src="Frontend/img/laptop-asus.jpg" alt="not found img" class="img-reponsive img-resize">
				 	<div class="carousel-caption">Laptop Asus </div>
					<h4> Màn hình:</h4>
					<h4>CPU:</h4>
					<h4>RAM:</h4>
					<h4>Hệ điều hành:</h4>
					<h4>Nặng:</h4>
				</div>
				<div class="col-xs-3">
					<img src="Frontend/img/laptop-asus.jpg" alt="not found img" class="img-reponsive img-resize">
				 	<div class="carousel-caption">Laptop Asus </div>
					<h4> Màn hình:</h4>
					<h4>CPU:</h4>
					<h4>RAM:</h4>
					<h4>Hệ điều hành:</h4>
					<h4>Nặng:</h4>
				</div>
				<div class="col-xs-3">
					<img src="Frontend/img/laptop-asus.jpg" alt="not found img" class="img-reponsive img-resize">
				 	<div class="carousel-caption">Laptop Asus </div>
					<h4> Màn hình:</h4>
					<h4>CPU:</h4>
					<h4>RAM:</h4>
					<h4>Hệ điều hành:</h4>
					<h4>Nặng:</h4>
				</div>
			</div>
		</div>
		
	
	</div>
	
	<a class="carousel-control left" href="#myCarousel-four" data-slide="prev">
	<span class="icon-prev"></span>
	</a>
	
	<a class="carousel-control right" href="#myCarousel-four" data-slide="next">
	<span class="icon-next"></span>
	</a>
</div>
</div>
</div>
</div>
</div>
<!-- End fourth slide -->

<hr style=" width:80%;">

</body>