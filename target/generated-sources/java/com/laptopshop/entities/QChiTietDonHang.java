package com.laptopshop.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QChiTietDonHang is a Querydsl query type for ChiTietDonHang
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QChiTietDonHang extends EntityPathBase<ChiTietDonHang> {

    private static final long serialVersionUID = -378674199L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QChiTietDonHang chiTietDonHang = new QChiTietDonHang("chiTietDonHang");

    public final NumberPath<Long> donGia = createNumber("donGia", Long.class);

    public final QDonHang donHang;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QSanPham sanPham;

    public final NumberPath<Integer> soLuongDat = createNumber("soLuongDat", Integer.class);

    public final NumberPath<Integer> soLuongNhanHang = createNumber("soLuongNhanHang", Integer.class);

    public QChiTietDonHang(String variable) {
        this(ChiTietDonHang.class, forVariable(variable), INITS);
    }

    public QChiTietDonHang(Path<? extends ChiTietDonHang> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QChiTietDonHang(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QChiTietDonHang(PathMetadata metadata, PathInits inits) {
        this(ChiTietDonHang.class, metadata, inits);
    }

    public QChiTietDonHang(Class<? extends ChiTietDonHang> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.donHang = inits.isInitialized("donHang") ? new QDonHang(forProperty("donHang"), inits.get("donHang")) : null;
        this.sanPham = inits.isInitialized("sanPham") ? new QSanPham(forProperty("sanPham"), inits.get("sanPham")) : null;
    }

}

