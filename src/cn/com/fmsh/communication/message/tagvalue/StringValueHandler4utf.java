package cn.com.fmsh.communication.message.tagvalue;

import cn.com.fmsh.util.CRCUtil;
import cn.com.fmsh.util.FM_Bytes;
import cn.com.fmsh.util.FM_Int;
import cn.com.fmsh.util.Util4Java;
import com.huawei.hwcommonmodel.fitnessdatatype.FitnessSleepType;
import java.io.UnsupportedEncodingException;

public class StringValueHandler4utf implements StringValueHandler {
    public static void main(String[] strArr) {
        byte[] bArr = null;
        try {
            bArr = "€".getBytes(FM_Int.replace(5, "/)f.>"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(FM_Bytes.bytesToHexString(bArr));
    }

    public String getTagvalue(byte[] bArr) {
        if (bArr == null || bArr.length < 1) {
            return null;
        }
        try {
            return new String(bArr, CRCUtil.substring(FitnessSleepType.HW_FITNESS_SLEEP, ".rw1?"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public byte[] setTagValue(String str) {
        byte[] bArr = null;
        if (str != null) {
            try {
                bArr = str.getBytes(Util4Java.endsWith("|/+ri", 140, 114));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return bArr;
    }
}
