package com.laptopshop.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QHangSanXuat is a Querydsl query type for HangSanXuat
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QHangSanXuat extends EntityPathBase<HangSanXuat> {

    private static final long serialVersionUID = -1338412222L;

    public static final QHangSanXuat hangSanXuat = new QHangSanXuat("hangSanXuat");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<SanPham, QSanPham> listSanPham = this.<SanPham, QSanPham>createList("listSanPham", SanPham.class, QSanPham.class, PathInits.DIRECT2);

    public final StringPath tenHangSanXuat = createString("tenHangSanXuat");

    public QHangSanXuat(String variable) {
        super(HangSanXuat.class, forVariable(variable));
    }

    public QHangSanXuat(Path<? extends HangSanXuat> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHangSanXuat(PathMetadata metadata) {
        super(HangSanXuat.class, metadata);
    }

}

