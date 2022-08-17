package com.laptopshop.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDanhMuc is a Querydsl query type for DanhMuc
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDanhMuc extends EntityPathBase<DanhMuc> {

    private static final long serialVersionUID = 1292012392L;

    public static final QDanhMuc danhMuc = new QDanhMuc("danhMuc");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<SanPham, QSanPham> listSanPham = this.<SanPham, QSanPham>createList("listSanPham", SanPham.class, QSanPham.class, PathInits.DIRECT2);

    public final StringPath tenDanhMuc = createString("tenDanhMuc");

    public QDanhMuc(String variable) {
        super(DanhMuc.class, forVariable(variable));
    }

    public QDanhMuc(Path<? extends DanhMuc> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDanhMuc(PathMetadata metadata) {
        super(DanhMuc.class, metadata);
    }

}

