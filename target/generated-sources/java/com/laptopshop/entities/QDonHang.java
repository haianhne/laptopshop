package com.laptopshop.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDonHang is a Querydsl query type for DonHang
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDonHang extends EntityPathBase<DonHang> {

    private static final long serialVersionUID = 1691886201L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QDonHang donHang = new QDonHang("donHang");

    public final ListPath<ChiTietDonHang, QChiTietDonHang> danhSachChiTiet = this.<ChiTietDonHang, QChiTietDonHang>createList("danhSachChiTiet", ChiTietDonHang.class, QChiTietDonHang.class, PathInits.DIRECT2);

    public final StringPath diaChiNhan = createString("diaChiNhan");

    public final StringPath ghiChu = createString("ghiChu");

    public final StringPath hoTenNguoiNhan = createString("hoTenNguoiNhan");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.util.Date> ngayDatHang = createDateTime("ngayDatHang", java.util.Date.class);

    public final DateTimePath<java.util.Date> ngayGiaoHang = createDateTime("ngayGiaoHang", java.util.Date.class);

    public final DateTimePath<java.util.Date> ngayNhanHang = createDateTime("ngayNhanHang", java.util.Date.class);

    public final QNguoiDung nguoiDat;

    public final StringPath sdtNhanHang = createString("sdtNhanHang");

    public final QNguoiDung shipper;

    public final NumberPath<Long> tongGiaTri = createNumber("tongGiaTri", Long.class);

    public final StringPath trangThaiDonHang = createString("trangThaiDonHang");

    public QDonHang(String variable) {
        this(DonHang.class, forVariable(variable), INITS);
    }

    public QDonHang(Path<? extends DonHang> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QDonHang(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QDonHang(PathMetadata metadata, PathInits inits) {
        this(DonHang.class, metadata, inits);
    }

    public QDonHang(Class<? extends DonHang> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.nguoiDat = inits.isInitialized("nguoiDat") ? new QNguoiDung(forProperty("nguoiDat")) : null;
        this.shipper = inits.isInitialized("shipper") ? new QNguoiDung(forProperty("shipper")) : null;
    }

}

