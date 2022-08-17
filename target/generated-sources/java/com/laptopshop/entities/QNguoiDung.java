package com.laptopshop.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QNguoiDung is a Querydsl query type for NguoiDung
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QNguoiDung extends EntityPathBase<NguoiDung> {

    private static final long serialVersionUID = -801972988L;

    public static final QNguoiDung nguoiDung = new QNguoiDung("nguoiDung");

    public final StringPath diaChi = createString("diaChi");

    public final StringPath email = createString("email");

    public final StringPath hoTen = createString("hoTen");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath password = createString("password");

    public final StringPath soDienThoai = createString("soDienThoai");

    public final SetPath<VaiTro, QVaiTro> vaiTro = this.<VaiTro, QVaiTro>createSet("vaiTro", VaiTro.class, QVaiTro.class, PathInits.DIRECT2);

    public QNguoiDung(String variable) {
        super(NguoiDung.class, forVariable(variable));
    }

    public QNguoiDung(Path<? extends NguoiDung> path) {
        super(path.getType(), path.getMetadata());
    }

    public QNguoiDung(PathMetadata metadata) {
        super(NguoiDung.class, metadata);
    }

}

