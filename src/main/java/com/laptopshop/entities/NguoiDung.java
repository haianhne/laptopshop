package com.laptopshop.entities;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class NguoiDung {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String email;
	
	@JsonIgnore
	private String password;
	
	@Transient
	@JsonIgnore
	private String confirmPassword;
	private String hoTen;
	private String soDienThoai;
	private String diaChi;
	
	@ManyToMany
	@JoinTable(name="nguoidung_vaitro",
	           joinColumns=@JoinColumn(name="ma_nguoi_dung"), 
	           inverseJoinColumns=@JoinColumn(name="ma_vai_tro"))
	private Set<VaiTro> vaiTro;
	
	@Transient
	@JsonIgnore
	private List<DonHang> listDonHang;
	
	public List<DonHang> getListDonHang() {
		return listDonHang;
	}

	public void setListDonHang(List<DonHang> listDonHang) {
		this.listDonHang = listDonHang;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public Set<VaiTro> getVaiTro() {
		return vaiTro;
	}

	public void setVaiTro(Set<VaiTro> vaiTro) {
		this.vaiTro = vaiTro;
	}
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public NguoiDung(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	public NguoiDung() {
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public String toString() {
		return "NguoiDung [id=" + id + ", email=" + email + ", password=" + password + ", confirmPassword="
				+ confirmPassword + ", hoTen=" + hoTen + ", soDienThoai=" + soDienThoai + ", diaChi=" + diaChi;
	}	
}
