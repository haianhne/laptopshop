package com.laptopshop.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class LienHe {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String emailLienHe;

	private String noiDungLienHe;

	private String noiDungTraLoi;

	@DateTimeFormat(pattern="dd/MM/yyyy HH:mm")
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm", timezone="GMT+7")
	private Date ngayLienHe;

	@DateTimeFormat(pattern="dd/MM/yyyy HH:mm")
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm", timezone="GMT+7")
	private Date ngayTraLoi;

	private String trangThai;
	
	@ManyToOne
	@JoinColumn(name = "ma_nguoi_tra_loi")
	private NguoiDung nguoiTraLoi;

	public NguoiDung getNguoiTraLoi() {
		return nguoiTraLoi;
	}

	public void setNguoiTraLoi(NguoiDung nguoiTraLoi) {
		this.nguoiTraLoi = nguoiTraLoi;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmailLienHe() {
		return emailLienHe;
	}

	public void setEmailLienHe(String emailLienHe) {
		this.emailLienHe = emailLienHe;
	}

	public String getNoiDungLienHe() {
		return noiDungLienHe;
	}

	public void setNoiDungLienHe(String noiDungLienHe) {
		this.noiDungLienHe = noiDungLienHe;
	}

	public String getNoiDungTraLoi() {
		return noiDungTraLoi;
	}

	public void setNoiDungTraLoi(String noiDungTraLoi) {
		this.noiDungTraLoi = noiDungTraLoi;
	}

	public Date getNgayLienHe() {
		return ngayLienHe;
	}

	public void setNgayLienHe(Date ngayLienHe) {
		this.ngayLienHe = ngayLienHe;
	}

	public Date getNgayTraLoi() {
		return ngayTraLoi;
	}

	public void setNgayTraLoi(Date ngayTraLoi) {
		this.ngayTraLoi = ngayTraLoi;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
}
