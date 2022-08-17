package com.laptopshop.dto;

public class ListCongViecDTO {

	private int soDonHangMoi; // số đơn hàng mới
	private int soLienHeMoi; // số liên hệ mới;
	private int soDonhangChoDuyet; // số đơn hàng chờ duyệt
	
	public int getSoDonHangMoi() {
		return soDonHangMoi;
	}
	public void setSoDonHangMoi(int soDonHangMoi) {
		this.soDonHangMoi = soDonHangMoi;
	}
	
	public int getSoLienHeMoi() {
		return soLienHeMoi;
	}
	public void setSoLienHeMoi(int soLienHeMoi) {
		this.soLienHeMoi = soLienHeMoi;
	}
	public int getSoDonhangChoDuyet() {
		return soDonhangChoDuyet;
	}
	public void setSoDonhangChoDuyet(int soDonhangChoDuyet) {
		this.soDonhangChoDuyet = soDonhangChoDuyet;
	}
}
