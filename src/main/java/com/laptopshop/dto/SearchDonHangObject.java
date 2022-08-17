package com.laptopshop.dto;


public class SearchDonHangObject {

	private String trangThaiDon;
	private String tuNgay;
	private String denNgay;

	public SearchDonHangObject() {
		trangThaiDon = "";
		tuNgay = "";
		denNgay = "";
	}

	public String getTrangThaiDon() {
		return trangThaiDon;
	}

	public void setTrangThaiDon(String trangThaiDon) {
		this.trangThaiDon = trangThaiDon;
	}

	public String getTuNgay() {
		return tuNgay;
	}

	public void setTuNgay(String tuNgay) {
		this.tuNgay = tuNgay;
	}

	public String getDenNgay() {
		return denNgay;
	}

	public void setDenNgay(String denNgay) {
		this.denNgay = denNgay;
	}

	@Override
	public String toString() {
		return "SearchDonHangObject [trangThaiDon=" + trangThaiDon + ", tuNgay=" + tuNgay + ", denNgay=" + denNgay
				+ "]";
	}
	
	
}
