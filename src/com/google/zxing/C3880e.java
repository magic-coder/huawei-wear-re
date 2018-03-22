package com.google.zxing;

import java.util.List;

/* compiled from: DecodeHintType */
public enum C3880e {
    OTHER(Object.class),
    PURE_BARCODE(Void.class),
    POSSIBLE_FORMATS(List.class),
    TRY_HARDER(Void.class),
    CHARACTER_SET(String.class),
    ALLOWED_LENGTHS(int[].class),
    ASSUME_CODE_39_CHECK_DIGIT(Void.class),
    ASSUME_GS1(Void.class),
    RETURN_CODABAR_START_END(Void.class),
    NEED_RESULT_POINT_CALLBACK(C3803p.class);
    
    private final Class<?> f14978k;

    private C3880e(Class<?> cls) {
        this.f14978k = cls;
    }
}
