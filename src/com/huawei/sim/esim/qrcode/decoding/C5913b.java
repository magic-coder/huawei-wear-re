package com.huawei.sim.esim.qrcode.decoding;

import com.google.zxing.C3709a;
import java.util.Vector;
import java.util.regex.Pattern;

/* compiled from: DecodeFormatManager */
public final class C5913b {
    public static final Vector<C3709a> f20271a = new Vector(f20273c.size() + 4);
    public static final Vector<C3709a> f20272b = new Vector(1);
    public static final Vector<C3709a> f20273c = new Vector(5);
    public static final Vector<C3709a> f20274d = new Vector(1);
    private static final Pattern f20275e = Pattern.compile(",");

    static {
        f20273c.add(C3709a.UPC_A);
        f20273c.add(C3709a.UPC_E);
        f20273c.add(C3709a.EAN_13);
        f20273c.add(C3709a.EAN_8);
        f20273c.add(C3709a.RSS_14);
        f20271a.addAll(f20273c);
        f20271a.add(C3709a.CODE_39);
        f20271a.add(C3709a.CODE_93);
        f20271a.add(C3709a.CODE_128);
        f20271a.add(C3709a.ITF);
        f20272b.add(C3709a.QR_CODE);
        f20274d.add(C3709a.DATA_MATRIX);
    }
}
