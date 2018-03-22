package com.cmb.pboc.personal;

import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import com.cmb.pboc.logger.PbocLog;
import com.cmb.pboc.scard.Scard;
import com.cmb.pboc.utils.ParseUtils;
import java.util.ArrayList;
import java.util.List;

public class ApduInfo {
    private static final String f13472a = ApduInfo.class.getSimpleName();
    private int f13473b;
    private String f13474c;
    private byte[] f13475d;
    private byte[] f13476e;
    private List f13477f = new ArrayList();
    private byte[] f13478g = new byte[2];
    private int f13479h = 0;
    private byte[] f13480i;

    public ApduInfo(int i, String str) {
        if (str == null || "".equals(str)) {
            PbocLog.m17741d(f13472a, "Build #" + i + " ApduInfo failed. Data is null");
            return;
        }
        this.f13473b = i;
        this.f13474c = str;
        int length = this.f13474c.length();
        int indexOf = this.f13474c.indexOf(64);
        if (indexOf <= 0 || indexOf >= length) {
            this.f13475d = ParseUtils.m17797a(this.f13474c);
            return;
        }
        this.f13475d = ParseUtils.m17797a(this.f13474c.substring(0, indexOf));
        this.f13476e = ParseUtils.m17797a(this.f13474c.substring(indexOf + 1));
        indexOf = this.f13476e.length;
        length = 0;
        while (length < indexOf) {
            r3 = new byte[2];
            int i2 = length + 1;
            r3[0] = this.f13476e[length];
            length = i2 + 1;
            r3[1] = this.f13476e[i2];
            this.f13477f.add(r3);
        }
    }

    public final int m17770a() {
        return this.f13473b;
    }

    public final int m17771a(Scard scard) {
        if (this.f13475d == null || 1 > this.f13475d.length) {
            return -1;
        }
        Object ExchangeApdu = scard.ExchangeApdu(this.f13475d);
        if (ExchangeApdu == null || ExchangeApdu.length <= 0) {
            return -3;
        }
        byte[] bArr;
        byte b;
        int i;
        byte b2 = ExchangeApdu[ExchangeApdu.length - 2];
        byte b3 = ExchangeApdu[ExchangeApdu.length - 1];
        if (b2 == TagName.MAIN_ORDER_LIST) {
            byte[] bArr2 = new byte[5];
            bArr2[1] = TagName.STATION_ENAME;
            bArr2[4] = ExchangeApdu[ExchangeApdu.length - 1];
            ExchangeApdu = scard.ExchangeApdu(bArr2);
            if (ExchangeApdu == null || ExchangeApdu.length <= 0) {
                return -4;
            }
            b2 = ExchangeApdu[ExchangeApdu.length - 2];
            b3 = ExchangeApdu[ExchangeApdu.length - 1];
            bArr = ExchangeApdu;
            b = b2;
            b2 = b3;
        } else if (b2 == TagName.ELECTRONIC_LIST) {
            this.f13475d[4] = ExchangeApdu[ExchangeApdu.length - 1];
            ExchangeApdu = scard.ExchangeApdu(this.f13475d);
            if (ExchangeApdu == null || ExchangeApdu.length <= 0) {
                return -5;
            }
            b2 = ExchangeApdu[ExchangeApdu.length - 2];
            b3 = ExchangeApdu[ExchangeApdu.length - 1];
            r3 = ExchangeApdu;
            b = b2;
            b2 = b3;
        } else {
            r3 = ExchangeApdu;
            b = b2;
            b2 = b3;
        }
        this.f13478g[0] = b;
        this.f13478g[1] = b2;
        if (b == TagName.SYSTEM_VERSION) {
            i = 0;
        } else {
            for (byte[] bArr22 : this.f13477f) {
                PbocLog.m17738a(f13472a, "OK status:" + ParseUtils.m17796a(bArr22));
                if (bArr22 != null && 2 == bArr22.length && b == bArr22[0] && b2 == bArr22[1]) {
                    i = 0;
                    break;
                }
            }
            i = -11;
        }
        this.f13479h = bArr.length;
        this.f13480i = new byte[this.f13479h];
        System.arraycopy(bArr, 0, this.f13480i, 0, this.f13479h);
        if (bArr == null || bArr.length <= 0) {
            return i;
        }
        PbocLog.m17738a(f13472a, "APDU Resp's Content: " + ParseUtils.m17796a(bArr));
        return i;
    }

    public final String m17772b() {
        return this.f13474c;
    }

    public final int m17773c() {
        return this.f13479h;
    }

    public final byte[] m17774d() {
        return this.f13480i;
    }
}
