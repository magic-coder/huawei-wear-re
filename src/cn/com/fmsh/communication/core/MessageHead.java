package cn.com.fmsh.communication.core;

import cn.com.fmsh.util.FM_Bytes;

public class MessageHead {
    public static final int MESSAGE_HEAD_LENGTH = 12;
    public static final long SERIAL_MAK = 4294967295L;
    private final /* synthetic */ int f9341a = 2;
    private final /* synthetic */ int f9342b = 2;
    private final /* synthetic */ int f9343c = 4;
    private final /* synthetic */ int f9344d = 4;
    private final /* synthetic */ int f9345e = 8;
    private final /* synthetic */ int f9346f = 4;
    private /* synthetic */ byte f9347g;
    private /* synthetic */ ControlWord f9348h = new ControlWord();
    private /* synthetic */ byte[] f9349i = new byte[4];
    private /* synthetic */ long f9350j = 0;
    private /* synthetic */ byte[] f9351k = new byte[4];

    public enum CheckType {
        NOCHECK(0),
        MAC(1),
        CRC16(2);

        public int getValue() {
            return this.f9338a;
        }
    }

    public enum SecurityLevel {
        PLAIN(0),
        CIPHER(1);

        public int getValue() {
            return this.f9340a;
        }
    }

    public void fromBytes(byte[] bArr) {
        int i = 0;
        if (bArr != null && bArr.length == 12) {
            int i2;
            this.f9347g = bArr[0];
            this.f9348h.fromBytes(bArr[1]);
            for (i2 = 0; i2 < 2; i2++) {
                this.f9349i[i2] = bArr[i2 + 2];
            }
            byte[] bArr2 = new byte[4];
            for (i2 = 0; i2 < 4; i2++) {
                bArr2[i2] = bArr[i2 + 4];
            }
            this.f9350j = FM_Bytes.bytesToLong(FM_Bytes.join(new byte[1], bArr2));
            while (i < 4) {
                this.f9351k[i] = bArr[i + 8];
                i++;
            }
        }
    }

    public ControlWord getControlWord() {
        return this.f9348h;
    }

    public byte getProtocolVersion() {
        return this.f9347g;
    }

    public byte[] getSecurityLevel() {
        return this.f9349i;
    }

    public long getSerialNumber() {
        return this.f9350j;
    }

    public byte[] getSessionNumber() {
        return this.f9351k;
    }

    public void setControlWord(ControlWord controlWord) {
        this.f9348h = controlWord;
    }

    public void setProtocolVersion(byte b) {
        this.f9347g = b;
    }

    public void setSecurityLevel(byte[] bArr) {
        this.f9349i = bArr;
    }

    public void setSerialNumber(long j) {
        this.f9350j = j;
    }

    public void setSessionNumber(byte[] bArr) {
        this.f9351k = bArr;
    }

    public byte[] toBytes() {
        int i;
        int i2 = 0;
        byte[] bArr = new byte[12];
        bArr[0] = this.f9347g;
        bArr[1] = this.f9348h.toBytes();
        for (i = 0; i < 2; i++) {
            bArr[i + 2] = this.f9349i[i];
        }
        byte[] longToBytes = FM_Bytes.longToBytes(this.f9350j, 4);
        for (i = 0; i < 4; i++) {
            bArr[i + 4] = longToBytes[i];
        }
        while (i2 < 4) {
            bArr[i2 + 8] = this.f9351k[i2];
            i2++;
        }
        return bArr;
    }
}
