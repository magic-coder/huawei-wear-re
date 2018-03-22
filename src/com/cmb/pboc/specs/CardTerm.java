package com.cmb.pboc.specs;

import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import com.cmb.pboc.global.ApduHeader;
import com.cmb.pboc.global.PbocSW;
import com.cmb.pboc.logger.PbocLog;
import com.cmb.pboc.scard.Scard;
import com.cmb.pboc.utils.ParseUtils;

public class CardTerm {
    private static volatile CardTerm f13512a;
    private static String f13513b = CardTerm.class.getSimpleName();
    private static /* synthetic */ int[] f13514g;
    private Scard f13515c = null;
    private byte[] f13516d = null;
    private byte[] f13517e = null;
    private byte[] f13518f = null;

    private CardTerm(Scard scard) {
        this.f13515c = scard;
        this.f13518f = new byte[2];
        PbocLog.m17738a(f13513b, "Build CardTerm object.");
    }

    public static CardTerm m17788a(Scard scard) {
        if (f13512a == null) {
            synchronized (CardTerm.class) {
                if (f13512a == null) {
                    f13512a = new CardTerm(scard);
                }
            }
        }
        return f13512a;
    }

    private byte[] m17789a(ApduHeader apduHeader, String str) {
        Object obj;
        String str2;
        String str3;
        String a;
        switch (m17790a()[apduHeader.ordinal()]) {
            case 1:
                a = ApduHeader.SELECT_FILE.m17732a();
                break;
            case 2:
                a = ApduHeader.GET_RESPONSE.m17732a();
                break;
            case 3:
                a = ApduHeader.READ_RECORD.m17732a();
                break;
            case 4:
                a = ApduHeader.GET_DATA.m17732a();
                break;
            default:
                obj = "";
                break;
        }
        if (str == null || "".equals(str)) {
            str2 = "00";
            str = "";
            str3 = "";
        } else {
            str2 = String.format("%02X", new Object[]{Integer.valueOf(str.length() / 2)});
            str3 = "00";
        }
        return ParseUtils.m17797a(new StringBuilder(String.valueOf(obj)).append(str2).append(str).append(str3).toString());
    }

    private static /* synthetic */ int[] m17790a() {
        int[] iArr = f13514g;
        if (iArr == null) {
            iArr = new int[ApduHeader.values().length];
            try {
                iArr[ApduHeader.GET_DATA.ordinal()] = 4;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ApduHeader.GET_RESPONSE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[ApduHeader.READ_RECORD.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[ApduHeader.SELECT_FILE.ordinal()] = 1;
            } catch (NoSuchFieldError e4) {
            }
            f13514g = iArr;
        }
        return iArr;
    }

    public final byte[] m17791a(int i) {
        try {
            this.f13516d = m17789a(ApduHeader.GET_DATA, null);
            this.f13516d[2] = (byte) ((i >> 8) & 255);
            this.f13516d[3] = (byte) (i & 255);
            PbocLog.m17739b(f13513b, "CAPDU(GET DATA): " + ParseUtils.m17796a(this.f13516d));
            this.f13517e = this.f13515c.ExchangeApdu(this.f13516d);
            PbocLog.m17738a(f13513b, "RAPDU(GET DATA): " + ParseUtils.m17796a(this.f13517e));
            if (this.f13517e == null || this.f13517e.length <= 2) {
                return null;
            }
            this.f13518f[0] = this.f13517e[this.f13517e.length - 2];
            this.f13518f[1] = this.f13517e[this.f13517e.length - 1];
            return (this.f13518f[0] == PbocSW.f13419a[0] && this.f13518f[1] == PbocSW.f13419a[1]) ? this.f13517e : this.f13517e;
        } catch (Exception e) {
            PbocLog.m17741d(f13513b, e.getMessage());
            return null;
        }
    }

    public final byte[] m17792a(int i, int i2) {
        try {
            this.f13516d = m17789a(ApduHeader.READ_RECORD, null);
            this.f13516d[2] = (byte) 1;
            this.f13516d[3] = TagName.ORDER_TIME;
            PbocLog.m17739b(f13513b, "CAPDU(READ RECOED): " + ParseUtils.m17796a(this.f13516d));
            this.f13517e = this.f13515c.ExchangeApdu(this.f13516d);
            PbocLog.m17738a(f13513b, "RAPDU(READ RECOED): " + ParseUtils.m17796a(this.f13517e));
            if (this.f13517e == null || this.f13517e.length <= 2) {
                return null;
            }
            this.f13518f[0] = this.f13517e[this.f13517e.length - 2];
            this.f13518f[1] = this.f13517e[this.f13517e.length - 1];
            return (this.f13518f[0] == PbocSW.f13419a[0] && this.f13518f[1] == PbocSW.f13419a[1]) ? this.f13517e : this.f13517e;
        } catch (Exception e) {
            PbocLog.m17741d(f13513b, e.getMessage());
            return null;
        }
    }

    public final byte[] m17793a(String str) {
        try {
            this.f13516d = m17789a(ApduHeader.SELECT_FILE, str);
            PbocLog.m17738a(f13513b, "CAPDU(SELECT FILE): " + ParseUtils.m17796a(this.f13516d));
            this.f13517e = this.f13515c.ExchangeApdu(this.f13516d);
            PbocLog.m17738a(f13513b, "RAPDU(SELECT FILE): " + ParseUtils.m17796a(this.f13517e));
            if (this.f13517e == null || this.f13517e.length <= 2) {
                return null;
            }
            this.f13518f[0] = this.f13517e[this.f13517e.length - 2];
            this.f13518f[1] = this.f13517e[this.f13517e.length - 1];
            return (this.f13518f[0] == PbocSW.f13419a[0] && this.f13518f[1] == PbocSW.f13419a[1]) ? this.f13517e : this.f13517e;
        } catch (Exception e) {
            PbocLog.m17741d(f13513b, e.getMessage());
            return null;
        }
    }
}
