package com.laptopshop.service;

import com.laptopshop.entities.GioHang;
import com.laptopshop.entities.NguoiDung;

public interface GioHangService {
	
	GioHang getGioHangByNguoiDung(NguoiDung n);
	
	GioHang save(GioHang g);
}
