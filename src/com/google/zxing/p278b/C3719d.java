package com.google.zxing.p278b;

import com.google.zxing.C3900f;
import com.huawei.hihealth.HiUserInfo;
import com.sina.weibo.sdk.component.GameManager;
import java.util.HashMap;
import java.util.Map;

/* compiled from: CharacterSetECI */
public enum C3719d {
    Cp437((String) r3, (int) new String[0]),
    ISO8859_1((String) new int[]{1, 3}, (int) new String[]{"ISO-8859-1"}),
    ISO8859_2((String) 4, (int) new String[]{"ISO-8859-2"}),
    ISO8859_3((String) 5, (int) new String[]{"ISO-8859-3"}),
    ISO8859_4((String) 6, (int) new String[]{"ISO-8859-4"}),
    ISO8859_5((String) 7, (int) new String[]{"ISO-8859-5"}),
    ISO8859_6((String) 8, (int) new String[]{"ISO-8859-6"}),
    ISO8859_7((String) 9, (int) new String[]{"ISO-8859-7"}),
    ISO8859_8((String) 10, (int) new String[]{"ISO-8859-8"}),
    ISO8859_9((String) 11, (int) new String[]{"ISO-8859-9"}),
    ISO8859_10((String) 12, (int) new String[]{"ISO-8859-10"}),
    ISO8859_11((String) 13, (int) new String[]{"ISO-8859-11"}),
    ISO8859_13((String) 15, (int) new String[]{"ISO-8859-13"}),
    ISO8859_14((String) 16, (int) new String[]{"ISO-8859-14"}),
    ISO8859_15((String) 17, (int) new String[]{"ISO-8859-15"}),
    ISO8859_16((String) 18, (int) new String[]{"ISO-8859-16"}),
    SJIS((String) 20, (int) new String[]{"Shift_JIS"}),
    Cp1250((String) 21, (int) new String[]{"windows-1250"}),
    Cp1251((String) 22, (int) new String[]{"windows-1251"}),
    Cp1252((String) 23, (int) new String[]{"windows-1252"}),
    Cp1256((String) 24, (int) new String[]{"windows-1256"}),
    UnicodeBigUnmarked((String) 25, (int) new String[]{"UTF-16BE", "UnicodeBig"}),
    UTF8((String) 26, (int) new String[]{GameManager.DEFAULT_CHARSET}),
    ASCII((String) new int[]{27, HiUserInfo.HEIGHT_DEFAULT}, (int) new String[]{"US-ASCII"}),
    Big5(28),
    GB18030((String) 29, (int) new String[]{"GB2312", "EUC_CN", "GBK"}),
    EUC_KR((String) 30, (int) new String[]{"EUC-KR"});
    
    private static final Map<Integer, C3719d> f14443B = null;
    private static final Map<String, C3719d> f14444C = null;
    private final int[] f14472D;
    private final String[] f14473E;

    static {
        f14443B = new HashMap();
        f14444C = new HashMap();
        for (C3719d c3719d : C3719d.values()) {
            for (int valueOf : c3719d.f14472D) {
                f14443B.put(Integer.valueOf(valueOf), c3719d);
            }
            f14444C.put(c3719d.name(), c3719d);
            for (Object put : c3719d.f14473E) {
                f14444C.put(put, c3719d);
            }
        }
    }

    private C3719d(int i) {
        this(r3, r4, new int[]{i}, new String[0]);
    }

    private C3719d(int i, String... strArr) {
        this.f14472D = new int[]{i};
        this.f14473E = strArr;
    }

    private C3719d(int[] iArr, String... strArr) {
        this.f14472D = iArr;
        this.f14473E = strArr;
    }

    public static C3719d m18725a(int i) throws C3900f {
        if (i >= 0 && i < 900) {
            return (C3719d) f14443B.get(Integer.valueOf(i));
        }
        throw C3900f.m19459a();
    }
}
