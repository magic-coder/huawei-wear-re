package cn.com.fmsh.communication.message.tagvalue;

public class StringValueHandler4asc implements StringValueHandler {
    public String getTagvalue(byte[] bArr) {
        return (bArr == null || bArr.length < 1) ? null : new String(bArr);
    }

    public byte[] setTagValue(String str) {
        return str == null ? null : str.getBytes();
    }
}
