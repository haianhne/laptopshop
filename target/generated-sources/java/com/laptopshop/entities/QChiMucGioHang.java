package com.laptopshop.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QChiMucGioHang is a Querydsl query type for ChiMucGioHang
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QChiMucGioHang extends EntityPathBase<ChiMucGioHang> {

    private static final long serialVersionUID = -344890228L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QChiMucGioHang chiMucGioHang = new QChiMucGioHang("chiMucGioHang");

    public final QGioHang gioHang;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QSanPham sanPham;

    public final NumberPath<Integer> so_luong = createNumber("so_luong", Integer.class);

    public QChiMucGioHang(String variable) {
        this(ChiMucGioHang.class, forVariable(variable), INITS);
    }

    public QChiMucGioHang(Path<? extends ChiMucGioHang> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QChiMucGioHang(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QChiMucGioHang(PathMetadata metadata, PathInits inits) {
        this(ChiMucGioHang.class, metadata, inits);
    }

    public QChiMucGioHang(Class<? extends ChiMucGioHang> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.gioHang = inits.isInitialized("gioHang") ? new QGioHang(forProperty("gioHang"), inits.get("gioHang")) : null;
        this.sanPham = inits.isInitialized("sanPham") ? new QSanPham(forProperty("sanPham"), inits.get("sanPham")) : null;
    }

}

