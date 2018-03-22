package com.huawei.wallet.logic.tlv;

import java.math.BigDecimal;
import java.nio.charset.Charset;

public class TlvBuilder {
    private static final Charset f21288a = Charset.forName("US-ASCII");
    private static final BigDecimal f21289b = new BigDecimal(100);
    private final int f21290c;
    private int f21291d;
    private byte[] f21292e;
    private final TlvTag f21293f;

    public TlvBuilder() {
        this((TlvTag) null);
    }

    public TlvBuilder(TlvTag tlvTag) {
        this(tlvTag, new byte[1024], 0);
    }

    public TlvBuilder(TlvTag tlvTag, byte[] bArr, int i) {
        this.f21292e = null;
        this.f21293f = tlvTag;
        if (bArr != null) {
            this.f21292e = new byte[bArr.length];
            System.arraycopy(bArr, 0, this.f21292e, 0, bArr.length);
        } else {
            this.f21292e = null;
        }
        this.f21291d = i;
        this.f21290c = i;
    }
}
