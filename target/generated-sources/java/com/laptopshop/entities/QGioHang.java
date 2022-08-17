package com.laptopshop.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QGioHang is a Querydsl query type for GioHang
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QGioHang extends EntityPathBase<GioHang> {

    private static final long serialVersionUID = -111421437L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QGioHang gioHang = new QGioHang("gioHang");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QNguoiDung nguoiDung;

    public final StringPath tong_tien = createString("tong_tien");

    public QGioHang(String variable) {
        this(GioHang.class, forVariable(variable), INITS);
    }

    public QGioHang(Path<? extends GioHang> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QGioHang(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QGioHang(PathMetadata metadata, PathInits inits) {
        this(GioHang.class, metadata, inits);
    }

    public QGioHang(Class<? extends GioHang> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.nguoiDung = inits.isInitialized("nguoiDung") ? new QNguoiDung(forProperty("nguoiDung")) : null;
    }

}

