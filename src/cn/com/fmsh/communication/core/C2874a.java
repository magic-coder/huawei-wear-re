package cn.com.fmsh.communication.core;

import cn.com.fmsh.util.BCCUtil;
import cn.com.fmsh.util.FM_Bytes;
import cn.com.fmsh.util.FM_CN;
import cn.com.fmsh.util.FM_Int;
import cn.com.fmsh.util.FM_Utils;
import cn.com.fmsh.util.Util4Java;
import cn.com.fmsh.util.algorithm.RSA;
import cn.com.fmsh.util.log.FMLog;
import cn.com.fmsh.util.log.LogFactory;
import com.snowballtech.business.constant.BusinessCode;

class C2874a {
    public static final int TEMP_KEY_LENGTH = 16;
    public static final int TERMINAL_RANDOM_LENGTH = 8;
    private /* synthetic */ FMLog f9400a = LogFactory.getInstance().getLog();
    private final /* synthetic */ String f9401b = C2874a.class.getName();
    private /* synthetic */ byte f9402c;
    private /* synthetic */ byte[] f9403d;
    private /* synthetic */ byte f9404e;
    private /* synthetic */ byte[] f9405f;
    private /* synthetic */ byte[] f9406g;
    private /* synthetic */ byte[] f9407h;
    private /* synthetic */ byte[] f9408i;
    private /* synthetic */ byte[] f9409j;
    private /* synthetic */ byte[] f9410k;
    private /* synthetic */ byte[] f9411l;
    private /* synthetic */ byte[] f9412m;

    /* synthetic */ C2874a() {
    }

    private final /* synthetic */ byte[] m13015a() {
        int i;
        int i2 = 1;
        int length = (this.f9409j == null || this.f9409j.length <= 0) ? 1 : this.f9409j.length + 1;
        int i3 = 63 + length;
        int length2 = (this.f9410k == null || this.f9410k.length <= 0) ? 1 : this.f9410k.length + 1;
        int i4 = (i3 + length2) + 1;
        byte[] bArr = new byte[i4];
        for (i = 0; i < 8; i++) {
            bArr[i + 0] = this.f9405f[i];
        }
        if (this.f9406g == null || this.f9406g.length != 32) {
            if (this.f9400a != null) {
                this.f9400a.warn(FM_Int.replace(6, "\u0014.djTo~czywNzspmxz"), FM_CN.equals("\u00179?%Ohm|i>,\u0001!dsr{-j/#_wku-纚窬罂厲敦捩丕吁沏", 5));
            }
            return null;
        }
        for (i = 0; i < 32; i++) {
            bArr[i + 8] = this.f9406g[i];
        }
        if (this.f9407h == null || this.f9407h.length < 1) {
            this.f9407h = FM_CN.string2Bcd(Util4Java.date2string(FM_CN.equals("vy(;\u001e\tqb_@4'(?", BusinessCode.CURRENCY_CODE_RMB)));
        }
        if (this.f9407h.length != 7) {
            if (this.f9400a != null) {
                this.f9400a.warn(FM_Utils.regionMatches(5, 122, "\u001a?,-\u000e2\"8,pwAhvt~f{"), FM_Utils.regionMatches(5, 112, "\u001a50+F`fv<*;\u0017pt``&1u1zGlq0i纝窪旣闱敥捫乘呍沀"));
            }
            return null;
        }
        for (i = 0; i < 7; i++) {
            bArr[i + 40] = this.f9407h[i];
        }
        for (i = 0; i < 16; i++) {
            bArr[i + 47] = this.f9408i[i];
        }
        if (length > 1) {
            bArr[63] = (byte) (length - 1);
            for (i = 1; i < length; i++) {
                bArr[i + 63] = this.f9409j[i - 1];
            }
        } else {
            bArr[63] = (byte) 0;
        }
        if (length2 > 1) {
            bArr[length + 63] = (byte) (length2 - 1);
            while (i2 < length2) {
                bArr[(length + 63) + i2] = this.f9410k[i2 - 1];
                i2++;
            }
        } else {
            bArr[length + 63] = (byte) 0;
        }
        bArr[i4 - 1] = BCCUtil.calculateBCC(bArr);
        return bArr;
    }

    public byte[] getAppend() {
        return this.f9410k;
    }

    public byte getBusinessVersion() {
        return this.f9402c;
    }

    public byte[] getExponent() {
        return this.f9412m;
    }

    public byte getKeyIndex() {
        return this.f9404e;
    }

    public byte[] getModulus() {
        return this.f9411l;
    }

    public byte[] getSecurityCode() {
        return this.f9409j;
    }

    public byte[] getTempKey() {
        return this.f9408i;
    }

    public byte[] getTerminalNumber() {
        return this.f9406g;
    }

    public byte[] getTerminalRandom() {
        return this.f9405f;
    }

    public byte[] getTerminalTime() {
        return this.f9407h;
    }

    public byte[] getTerminalType() {
        return this.f9403d;
    }

    public void setAppend(byte[] bArr) {
        this.f9410k = bArr;
    }

    public void setBusinessVersion(byte b) {
        this.f9402c = b;
    }

    public void setExponent(byte[] bArr) {
        this.f9412m = bArr;
    }

    public void setKeyIndex(byte b) {
        this.f9404e = b;
    }

    public void setModulus(byte[] bArr) {
        this.f9411l = bArr;
    }

    public void setSecurityCode(byte[] bArr) {
        this.f9409j = bArr;
    }

    public void setTempKey(byte[] bArr) {
        this.f9408i = bArr;
    }

    public void setTerminalNumber(byte[] bArr) {
        this.f9406g = bArr;
    }

    public void setTerminalRandom(byte[] bArr) {
        this.f9405f = bArr;
    }

    public void setTerminalTime(byte[] bArr) {
        this.f9407h = bArr;
    }

    public void setTerminalType(byte[] bArr) {
        this.f9403d = bArr;
    }

    public byte[] toBytes() {
        byte[] encrtyByPublic = RSA.encrtyByPublic(this.f9411l, this.f9412m, m13015a(), true);
        if (encrtyByPublic == null) {
            return null;
        }
        int length = encrtyByPublic.length;
        byte[] bArr = new byte[(length + 5)];
        if (this.f9403d.length == 2) {
            bArr[0] = (byte) 0;
            bArr[1] = this.f9403d[0];
            bArr[2] = this.f9403d[1];
            bArr[3] = getBusinessVersion();
            bArr[4] = this.f9404e;
            for (int i = 0; i < length; i++) {
                bArr[i + 5] = encrtyByPublic[i];
            }
            return bArr;
        } else if (this.f9400a == null) {
            return null;
        } else {
            this.f9400a.debug(this.f9401b, new StringBuilder(BCCUtil.getChars("rq{\":w`\u00067jfh", 2, 32)).append(FM_Bytes.bytesToHexString(encrtyByPublic)).toString());
            return null;
        }
    }
}
