package com.huawei.wallet.logic.tlv;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

public class Tlv {
    private static final Charset f21284b = Charset.forName("US-ASCII");
    protected final List<Tlv> f21285a;
    private final TlvTag f21286c;
    private byte[] f21287d;

    public Tlv(TlvTag tlvTag, List<Tlv> list) {
        this.f21286c = tlvTag;
        this.f21285a = list;
        this.f21287d = null;
    }

    public Tlv(TlvTag tlvTag, byte[] bArr) {
        this.f21286c = tlvTag;
        if (bArr == null) {
            this.f21287d = null;
        } else if (bArr.length > 0) {
            this.f21287d = new byte[bArr.length];
            System.arraycopy(bArr, 0, this.f21287d, 0, this.f21287d.length);
        } else {
            this.f21287d = new byte[0];
        }
        this.f21285a = null;
    }

    public TlvTag m28075a() {
        return this.f21286c;
    }

    public boolean m28076b() {
        return this.f21286c.m28094a();
    }

    public Tlv m28074a(TlvTag tlvTag) {
        if (tlvTag.equals(m28075a())) {
            return this;
        }
        if (!m28076b()) {
            return null;
        }
        for (Tlv a : this.f21285a) {
            if (a.m28074a(tlvTag) != null) {
                return a.m28074a(tlvTag);
            }
        }
        return null;
    }

    public String m28077c() {
        if (!m28076b()) {
            return TlvUtil.m28096a(this.f21287d);
        }
        throw new IllegalStateException("Tag is CONSTRUCTED " + TlvUtil.m28096a(this.f21286c.f21299a));
    }

    public byte[] m28078d() {
        if (m28076b()) {
            throw new IllegalStateException("TLV [" + this.f21286c + "]is constructed");
        } else if (this.f21287d == null) {
            return null;
        } else {
            if (this.f21287d.length <= 0) {
                return new byte[0];
            }
            Object obj = new byte[this.f21287d.length];
            System.arraycopy(this.f21287d, 0, obj, 0, obj.length);
            return obj;
        }
    }

    public String toString() {
        return "BerTlv{theTag=" + this.f21286c + ", theValue=" + Arrays.toString(this.f21287d) + ", theList=" + this.f21285a + '}';
    }
}
