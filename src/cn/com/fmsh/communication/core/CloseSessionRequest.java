package cn.com.fmsh.communication.core;

import cn.com.fmsh.util.BCCUtil;
import cn.com.fmsh.util.FM_CN;
import cn.com.fmsh.util.Util4Java;
import com.huawei.nfc.carrera.logic.appletcardinfo.result.AppletCardResult;

public class CloseSessionRequest {
    private /* synthetic */ byte[] f9320a;

    public void fromBytes(byte[] bArr) {
        if (bArr != null && bArr.length == 7) {
            this.f9320a = bArr;
        }
    }

    public byte[] getTerminalTime() {
        return this.f9320a;
    }

    public void setTerminalTime(byte[] bArr) {
        this.f9320a = bArr;
    }

    public byte[] toBytes() {
        byte[] bArr = new byte[7];
        if (this.f9320a == null) {
            this.f9320a = FM_CN.string2Bcd(Util4Java.date2string(BCCUtil.getChars("9e!-]A, H\u00145yc?", AppletCardResult.RESULT_FAILED_TRAFFIC_CARD_INFO_PIN_LOCKED, 92)));
        }
        for (int i = 0; i < 7; i++) {
            bArr[i + 0] = this.f9320a[i];
        }
        return bArr;
    }
}
