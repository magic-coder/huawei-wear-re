package cn.com.fmsh.script.bean;

import cn.com.fmsh.script.constants.ScriptToolsConst.TagName;
import cn.com.fmsh.util.FM_Bytes;
import cn.com.fmsh.util.FM_Long;

public class ApduResponse {
    private /* synthetic */ int f9506a;
    private /* synthetic */ byte[] f9507b;
    private /* synthetic */ byte[] f9508c;

    public static void main(String[] strArr) {
        byte[] hexStringToBytes = FM_Bytes.hexStringToBytes(FM_Long.copyValueOf(";9", 3));
        ApduResponse apduResponse = new ApduResponse();
        apduResponse.setResult(hexStringToBytes);
        System.out.println(FM_Bytes.bytesToHexString(apduResponse.toBytes()));
    }

    public byte[] getApdu() {
        return this.f9507b;
    }

    public int getId() {
        return this.f9506a;
    }

    public byte[] getResult() {
        return this.f9508c;
    }

    public void setApdu(byte[] bArr) {
        this.f9507b = bArr;
    }

    public void setId(int i) {
        this.f9506a = i;
    }

    public void setResult(byte[] bArr) {
        this.f9508c = bArr;
    }

    public byte[] toBytes() {
        int i = 0;
        if (this.f9508c == null || this.f9508c.length < 1) {
            return null;
        }
        byte[] bArr = new byte[(this.f9508c.length + 3)];
        bArr[0] = TagName.ResponseSingle;
        bArr[1] = (byte) (this.f9508c.length + 1);
        bArr[2] = (byte) this.f9506a;
        while (i < this.f9508c.length) {
            bArr[i + 3] = this.f9508c[i];
            i++;
        }
        return bArr;
    }
}
