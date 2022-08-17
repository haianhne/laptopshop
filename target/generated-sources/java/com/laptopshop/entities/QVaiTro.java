package com.laptopshop.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QVaiTro is a Querydsl query type for VaiTro
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QVaiTro extends EntityPathBase<VaiTro> {

    private static final long serialVersionUID = -412995825L;

    public static final QVaiTro vaiTro = new QVaiTro("vaiTro");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final SetPath<NguoiDung, QNguoiDung> nguoiDung = this.<NguoiDung, QNguoiDung>createSet("nguoiDung", NguoiDung.class, QNguoiDung.class, PathInits.DIRECT2);

    public final StringPath tenVaiTro = createString("tenVaiTro");

    public QVaiTro(String variable) {
        super(VaiTro.class, forVariable(variable));
    }

    public QVaiTro(Path<? extends VaiTro> path) {
        super(path.getType(), path.getMetadata());
    }

    public QVaiTro(PathMetadata metadata) {
        super(VaiTro.class, metadata);
    }

}

