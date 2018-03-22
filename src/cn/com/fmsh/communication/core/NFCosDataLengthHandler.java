package cn.com.fmsh.communication.core;

import cn.com.fmsh.util.FM_Bytes;
import cn.com.fmsh.util.FM_Utils;
import cn.com.fmsh.util.log.FMLog;
import cn.com.fmsh.util.log.LogFactory;
import cn.com.fmsh.util.socket.DataLengthHandle;
import java.io.DataInputStream;
import java.io.IOException;

public class NFCosDataLengthHandler implements DataLengthHandle {
    private /* synthetic */ FMLog f9352a = null;
    private /* synthetic */ String f9353b = NFCosDataLengthHandler.class.getName();

    public int getDataSize(DataInputStream dataInputStream) throws IOException {
        if (this.f9352a != null) {
            this.f9352a = LogFactory.getInstance().getLog();
        }
        if (dataInputStream == null) {
            return -1;
        }
        int available = dataInputStream.available();
        if (this.f9352a != null) {
            this.f9352a.debug(this.f9353b, new StringBuilder(FM_Utils.regionMatches(3, 118, "\u0017(+4\u0002/gxwJ{w>0*}2?~|g`uafc")).append(available).toString());
        }
        byte readByte = dataInputStream.readByte();
        byte readByte2 = dataInputStream.readByte();
        while (true) {
            if (readByte != (readByte2 ^ -1)) {
                readByte = readByte2;
                readByte2 = dataInputStream.readByte();
            } else {
                readByte = dataInputStream.readByte();
                byte readByte3 = dataInputStream.readByte();
                if (readByte2 == (readByte ^ readByte3)) {
                    byte[] bArr = new byte[4];
                    bArr[2] = readByte;
                    bArr[3] = readByte3;
                    return FM_Bytes.bytesToInt(bArr);
                }
                readByte = readByte2;
                readByte2 = dataInputStream.readByte();
            }
        }
    }

    public byte[] initDataSize(int i) {
        r0 = new byte[4];
        byte[] intToBytes = FM_Bytes.intToBytes(i, 2);
        r0[1] = (byte) (intToBytes[0] ^ intToBytes[1]);
        r0[0] = (byte) (r0[1] ^ -1);
        r0[2] = intToBytes[0];
        r0[3] = intToBytes[1];
        return r0;
    }
}
