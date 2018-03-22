package cn.com.fmsh.communication.core;

import cn.com.fmsh.communication.exception.session.OpenSessionException;
import cn.com.fmsh.util.Util4Java;
import com.huawei.crowdtestsdk.report.ReportInfoUtils;

public class OpenSessionResponse {
    public final int DATA_LENGTH = 32;
    public final int SESSION_KEY_LENGTH = 16;
    private /* synthetic */ byte[] f9354a = new byte[8];
    private /* synthetic */ byte[] f9355b = new byte[4];
    private /* synthetic */ byte[] f9356c = new byte[16];
    private /* synthetic */ byte[] f9357d = new byte[4];
    private final /* synthetic */ int f9358e = 0;
    private final /* synthetic */ int f9359f = 8;
    private final /* synthetic */ int f9360g = 8;
    private final /* synthetic */ int f9361h = 4;
    private final /* synthetic */ int f9362i = 12;
    private final /* synthetic */ int f9363j = 28;
    private final /* synthetic */ int f9364k = 4;

    public void fromBytes(byte[] bArr) throws OpenSessionException {
        int i = 0;
        if (bArr != null) {
            if (bArr.length != 32) {
                throw new OpenSessionException(Util4Java.endsWith("签剬咕廀攠挢锷廢乍呔沍", 3, ReportInfoUtils.FEEDBACK_FAILED));
            }
            int i2;
            for (i2 = 0; i2 < 8; i2++) {
                this.f9354a[i2] = bArr[i2 + 0];
            }
            for (i2 = 0; i2 < 4; i2++) {
                this.f9355b[i2] = bArr[i2 + 8];
            }
            for (i2 = 0; i2 < 16; i2++) {
                this.f9356c[i2] = bArr[i2 + 12];
            }
            while (i < 4) {
                this.f9357d[i] = bArr[i + 28];
                i++;
            }
        }
    }

    public byte[] getSerialNumber() {
        return this.f9357d;
    }

    public byte[] getSessionKey() {
        return this.f9356c;
    }

    public byte[] getSessionNumber() {
        return this.f9355b;
    }

    public byte[] getTerminalRandom() {
        return this.f9354a;
    }

    public void setSerialNumber(byte[] bArr) {
        this.f9357d = bArr;
    }

    public void setSessionKey(byte[] bArr) {
        this.f9356c = bArr;
    }

    public void setSessionNumber(byte[] bArr) {
        this.f9355b = bArr;
    }

    public void setTerminalRandom(byte[] bArr) {
        this.f9354a = bArr;
    }

    public byte[] toBytes() {
        int i;
        int i2 = 0;
        byte[] bArr = new byte[32];
        for (i = 0; i < 8; i++) {
            bArr[i + 0] = this.f9354a[i];
        }
        for (i = 0; i < 4; i++) {
            bArr[i + 8] = this.f9355b[i];
        }
        for (i = 0; i < 16; i++) {
            bArr[i + 12] = this.f9356c[i];
        }
        while (i2 < 4) {
            bArr[i2 + 28] = this.f9357d[i2];
            i2++;
        }
        return bArr;
    }
}
