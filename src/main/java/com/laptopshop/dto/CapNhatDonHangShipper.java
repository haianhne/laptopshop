package com.laptopshop.dto;

import java.util.List;

public class CapNhatDonHangShipper {
	
	private long idDonHang;
	private String ghiChuShipper;
	private List<CapNhatChiTietDon> danhSachCapNhatChiTietDon;


	public static class CapNhatChiTietDon {
		private long idChiTiet;
		private int soLuongNhanHang;

		public long getIdChiTiet() {
			return idChiTiet;
		}

		public void setIdChiTiet(long idChiTiet) {
			this.idChiTiet = idChiTiet;
		}

		public int getSoLuongNhanHang() {
			return soLuongNhanHang;
		}

		public void setSoLuongNhanHang(int soLuongNhanHang) {
			this.soLuongNhanHang = soLuongNhanHang;
		}
	}

	public String getGhiChuShipper() {
		return ghiChuShipper;
	}

	public void setGhiChuShipper(String ghiChuShipper) {
		this.ghiChuShipper = ghiChuShipper;
	}

	public List<CapNhatChiTietDon> getDanhSachCapNhatChiTietDon() {
		return danhSachCapNhatChiTietDon;
	}

	public void setDanhSachCapNhatChiTietDon(List<CapNhatChiTietDon> danhSachCapNhatChiTietDon) {
		this.danhSachCapNhatChiTietDon = danhSachCapNhatChiTietDon;
	}

	public long getIdDonHang() {
		return idDonHang;
	}

	public void setIdDonHang(long idDonHang) {
		this.idDonHang = idDonHang;
	}


}
