package com.laptopshop.dto;

public class SearchLienHeObject {

	private String trangThaiLienHe;
	private String tuNgay;
	private String denNgay;
	
	public SearchLienHeObject() {
		trangThaiLienHe = "";
		tuNgay = "";
		denNgay = "";
	}

	public String getTrangThaiLienHe() {
		return trangThaiLienHe;
	}

	public void setTrangThaiLienHe(String trangThaiLienHe) {
		this.trangThaiLienHe = trangThaiLienHe;
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

}
