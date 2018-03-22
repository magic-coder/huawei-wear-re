package cn.com.fmsh.communication.message.tagvalue;

import cn.com.fmsh.util.CRCUtil;
import cn.com.fmsh.util.FM_Long;
import java.io.UnsupportedEncodingException;

public class StringValueHandler4gbk implements StringValueHandler {
    public String getTagvalue(byte[] bArr) {
        if (bArr == null || bArr.length < 1) {
            return null;
        }
        try {
            return new String(bArr, CRCUtil.substring(4, "v~l"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public byte[] setTagValue(String str) {
        byte[] bArr = null;
        if (str != null) {
            try {
                bArr = str.getBytes(FM_Long.copyValueOf("kkm", 4));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return bArr;
    }
}
