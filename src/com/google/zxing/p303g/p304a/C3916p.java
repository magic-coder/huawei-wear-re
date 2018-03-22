package com.google.zxing.p303g.p304a;

/* compiled from: Mode */
public enum C3916p {
    TERMINATOR(new int[3], 0),
    NUMERIC(new int[]{10, 12, 14}, 1),
    ALPHANUMERIC(new int[]{9, 11, 13}, 2),
    STRUCTURED_APPEND(new int[3], 3),
    BYTE(new int[]{8, 16, 16}, 4),
    ECI(new int[3], 7),
    KANJI(new int[]{8, 10, 12}, 8),
    FNC1_FIRST_POSITION(new int[3], 5),
    FNC1_SECOND_POSITION(new int[3], 9),
    HANZI(new int[]{8, 10, 12}, 13);
    
    private final int[] f15073k;
    private final int f15074l;

    private C3916p(int[] iArr, int i) {
        this.f15073k = iArr;
        this.f15074l = i;
    }

    public static C3916p m19498a(int i) {
        switch (i) {
            case 0:
                return TERMINATOR;
            case 1:
                return NUMERIC;
            case 2:
                return ALPHANUMERIC;
            case 3:
                return STRUCTURED_APPEND;
            case 4:
                return BYTE;
            case 5:
                return FNC1_FIRST_POSITION;
            case 7:
                return ECI;
            case 8:
                return KANJI;
            case 9:
                return FNC1_SECOND_POSITION;
            case 13:
                return HANZI;
            default:
                throw new IllegalArgumentException();
        }
    }

    public int m19499a(C3918r c3918r) {
        int a = c3918r.m19505a();
        if (a <= 9) {
            a = 0;
        } else if (a <= 26) {
            a = 1;
        } else {
            a = 2;
        }
        return this.f15073k[a];
    }
}
