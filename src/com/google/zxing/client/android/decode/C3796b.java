package com.google.zxing.client.android.decode;

import com.google.zxing.C3709a;
import java.util.Collection;
import java.util.EnumSet;
import java.util.regex.Pattern;

/* compiled from: DecodeFormatManager */
final class C3796b {
    static final Collection<C3709a> f14767a = EnumSet.of(C3709a.UPC_A, new C3709a[]{C3709a.UPC_E, C3709a.EAN_13, C3709a.EAN_8, C3709a.RSS_14, C3709a.RSS_EXPANDED});
    static final Collection<C3709a> f14768b = EnumSet.of(C3709a.CODE_39, C3709a.CODE_93, C3709a.CODE_128, C3709a.ITF, C3709a.CODABAR);
    static final Collection<C3709a> f14769c = EnumSet.of(C3709a.QR_CODE);
    static final Collection<C3709a> f14770d = EnumSet.of(C3709a.DATA_MATRIX);
    private static final Pattern f14771e = Pattern.compile(",");

    static {
        f14768b.addAll(f14767a);
    }
}
