package com.laptopshop.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class DonHang {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@OneToMany(mappedBy = "donHang")
	private List<ChiTietDonHang> danhSachChiTiet;

	private String diaChiNhan;
	private String sdtNhanHang;
	private String hoTenNguoiNhan;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+7")
	private Date ngayDatHang;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+7")
	private Date ngayGiaoHang;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+7")
	private Date ngayNhanHang;

	private String trangThaiDonHang;
	private String ghiChu;

	@ManyToOne(optional = true)
	@JoinColumn(name = "ma_nguoi_dat")
	private NguoiDung nguoiDat;

	@ManyToOne(optional = true)
	@JoinColumn(name = "ma_shipper")
	private NguoiDung shipper;

	private long tongGiaTri;

	public long getTongGiaTri() {
		return tongGiaTri;
	}

	public void setTongGiaTri(long tongGiaTri) {
		this.tongGiaTri = tongGiaTri;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<ChiTietDonHang> getDanhSachChiTiet() {
		return danhSachChiTiet;
	}

	public void setDanhSachChiTiet(List<ChiTietDonHang> danhSachChiTiet) {
		this.danhSachChiTiet = danhSachChiTiet;
	}

	public String getDiaChiNhan() {
		return diaChiNhan;
	}

	public void setDiaChiNhan(String diaChiNhan) {
		this.diaChiNhan = diaChiNhan;
	}

	public String getSdtNhanHang() {
		return sdtNhanHang;
	}

	public void setSdtNhanHang(String sdtNhanHang) {
		this.sdtNhanHang = sdtNhanHang;
	}

	public Date getNgayDatHang() {
		return ngayDatHang;
	}

	public void setNgayDatHang(Date ngayDatHang) {
		this.ngayDatHang = ngayDatHang;
	}

	public Date getNgayGiaoHang() {
		return ngayGiaoHang;
	}

	public void setNgayGiaoHang(Date ngayGiaoHang) {
		this.ngayGiaoHang = ngayGiaoHang;
	}

	public Date getNgayNhanHang() {
		return ngayNhanHang;
	}

	public void setNgayNhanHang(Date ngayNhanHang) {
		this.ngayNhanHang = ngayNhanHang;
	}

	public NguoiDung getNguoiDat() {
		return nguoiDat;
	}

	public void setNguoiDat(NguoiDung nguoiDat) {
		this.nguoiDat = nguoiDat;
	}

	public NguoiDung getShipper() {
		return shipper;
	}

	public void setShipper(NguoiDung shipper) {
		this.shipper = shipper;
	}

	public String getTrangThaiDonHang() {
		return trangThaiDonHang;
	}

	public void setTrangThaiDonHang(String trangThaiDonHang) {
		this.trangThaiDonHang = trangThaiDonHang;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public String getHoTenNguoiNhan() {
		return hoTenNguoiNhan;
	}

	public void setHoTenNguoiNhan(String hoTenNguoiNhan) {
		this.hoTenNguoiNhan = hoTenNguoiNhan;
	}

	public DonHang() {
		// TODO Auto-generated constructor stub
	}

}
