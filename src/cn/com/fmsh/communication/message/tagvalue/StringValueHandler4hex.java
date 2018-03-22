package cn.com.fmsh.communication.message.tagvalue;

import cn.com.fmsh.util.FM_Bytes;

public class StringValueHandler4hex implements StringValueHandler {
    public String getTagvalue(byte[] bArr) {
        return (bArr == null || bArr.length < 1) ? null : FM_Bytes.bytesToHexString(bArr);
    }

    public byte[] setTagValue(String str) {
        return str == null ? null : FM_Bytes.hexStringToBytes(str);
    }
}
