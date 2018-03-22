package cn.com.fmsh.communication.message.tagvalue;

import cn.com.fmsh.util.FM_CN;

public class StringValueHandler4cn implements StringValueHandler {
    public String getTagvalue(byte[] bArr) {
        return (bArr == null || bArr.length < 1) ? null : FM_CN.bcdBytesToString(bArr);
    }

    public byte[] setTagValue(String str) {
        return str == null ? null : FM_CN.string2Bcd(str);
    }
}
