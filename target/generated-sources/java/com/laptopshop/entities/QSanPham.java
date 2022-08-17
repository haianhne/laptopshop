package com.laptopshop.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSanPham is a Querydsl query type for SanPham
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSanPham extends EntityPathBase<SanPham> {

    private static final long serialVersionUID = 1718976072L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSanPham sanPham = new QSanPham("sanPham");

    public final StringPath cpu = createString("cpu");

    public final QDanhMuc danhMuc;

    public final NumberPath<Long> donGia = createNumber("donGia", Long.class);

    public final NumberPath<Integer> donViBan = createNumber("donViBan", Integer.class);

    public final NumberPath<Integer> donViKho = createNumber("donViKho", Integer.class);

    public final StringPath dungLuongPin = createString("dungLuongPin");

    public final QHangSanXuat hangSanXuat;

    public final StringPath heDieuHanh = createString("heDieuHanh");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath manHinh = createString("manHinh");

    public final StringPath ram = createString("ram");

    public final StringPath tenSanPham = createString("tenSanPham");

    public final StringPath thietKe = createString("thietKe");

    public final StringPath thongTinBaoHanh = createString("thongTinBaoHanh");

    public final StringPath thongTinChung = createString("thongTinChung");

    public QSanPham(String variable) {
        this(SanPham.class, forVariable(variable), INITS);
    }

    public QSanPham(Path<? extends SanPham> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSanPham(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSanPham(PathMetadata metadata, PathInits inits) {
        this(SanPham.class, metadata, inits);
    }

    public QSanPham(Class<? extends SanPham> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.danhMuc = inits.isInitialized("danhMuc") ? new QDanhMuc(forProperty("danhMuc")) : null;
        this.hangSanXuat = inits.isInitialized("hangSanXuat") ? new QHangSanXuat(forProperty("hangSanXuat")) : null;
    }

}

