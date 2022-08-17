package com.laptopshop.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLienHe is a Querydsl query type for LienHe
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QLienHe extends EntityPathBase<LienHe> {

    private static final long serialVersionUID = -691994657L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QLienHe lienHe = new QLienHe("lienHe");

    public final StringPath emailLienHe = createString("emailLienHe");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.util.Date> ngayLienHe = createDateTime("ngayLienHe", java.util.Date.class);

    public final DateTimePath<java.util.Date> ngayTraLoi = createDateTime("ngayTraLoi", java.util.Date.class);

    public final QNguoiDung nguoiTraLoi;

    public final StringPath noiDungLienHe = createString("noiDungLienHe");

    public final StringPath noiDungTraLoi = createString("noiDungTraLoi");

    public final StringPath trangThai = createString("trangThai");

    public QLienHe(String variable) {
        this(LienHe.class, forVariable(variable), INITS);
    }

    public QLienHe(Path<? extends LienHe> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QLienHe(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QLienHe(PathMetadata metadata, PathInits inits) {
        this(LienHe.class, metadata, inits);
    }

    public QLienHe(Class<? extends LienHe> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.nguoiTraLoi = inits.isInitialized("nguoiTraLoi") ? new QNguoiDung(forProperty("nguoiTraLoi")) : null;
    }

}

