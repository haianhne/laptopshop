package com.laptopshop.dto;

public class SearchSanPhamObject {
	private String danhMucId;
	private String hangSXId;
	private String donGia;
	
	// sap xep theo gia
	private String sapXepTheoGia;
	private String[] keyword;
	private String sort;
	
	// sap xep theo danhmuc va hangsx
	private String brand;
	private String manufactor;
	
	// theo ram, pin, OS
	private String os;
	private String ram;
	private String pin;

	public SearchSanPhamObject() {
		danhMucId = "";
		hangSXId = "";
		donGia = "";
		sapXepTheoGia = "ASC";
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getDanhMucId() {
		return danhMucId;
	}

	public void setDanhMucId(String danhMucId) {
		this.danhMucId = danhMucId;
	}

	public String getHangSXId() {
		return hangSXId;
	}

	public void setHangSXId(String hangSXId) {
		this.hangSXId = hangSXId;
	}

	public String getDonGia() {
		return donGia;
	}

	public void setDonGia(String donGia) {
		this.donGia = donGia;
	}

	public String[] getKeyword() {
		return keyword;
	}

	public void setKeyword(String[] keyword) {
		this.keyword = keyword;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getSapXepTheoGia() {
		return sapXepTheoGia;
	}

	public void setSapXepTheoGia(String sapXepTheoGia) {
		this.sapXepTheoGia = sapXepTheoGia;
	}
	
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public String getManufactor() {
		return manufactor;
	}

	public void setManufactor(String manufactor) {
		this.manufactor = manufactor;
	}

	@Override
	public String toString() {
		return "SearchObject [danhMucId=" + danhMucId + ", hangSXId=" + hangSXId + ", price=" + donGia + "]";
	}
}
