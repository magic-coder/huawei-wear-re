package cn.com.fmsh.util.algorithm;

import cn.com.fmsh.FM_Exception;
import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import cn.com.fmsh.util.FM_Bytes;
import cn.com.fmsh.util.FM_Int;
import cn.com.fmsh.util.FM_Utils;
import cn.com.fmsh.util.Util4Java;
import cn.com.fmsh.util.log.FMLog;
import cn.com.fmsh.util.log.LogFactory;
import java.lang.reflect.Array;

public class MAC {
    private static /* synthetic */ FMLog f9857a = LogFactory.getInstance().getLog();

    public static byte[] MAC4DESNoPadding(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr3 == null) {
            f9857a.error(MAC.class.getName(), FM_Bytes.concat("\u0016N\u0000讶篜斩？攷捵乵mb's", 4, 52));
            return null;
        } else if (bArr3.length % 8 != 0) {
            f9857a.error(MAC.class.getName(), FM_Exception.insert(250, 88, "\u0013\u0017M讧築无＂收捰镩廨之昱n益個攮"));
            return null;
        } else {
            int i;
            if (bArr2 == null) {
                bArr2 = new byte[8];
            }
            int length = bArr3.length / 8;
            byte[][] bArr4 = (byte[][]) Array.newInstance(Byte.TYPE, new int[]{length, 8});
            for (int i2 = 0; i2 < length; i2++) {
                for (i = 0; i < 8; i++) {
                    bArr4[i2][i] = bArr3[(i2 << 3) + i];
                }
            }
            byte[] xor = FM_Bytes.xor(bArr2, bArr4[0]);
            for (i = 1; i < length; i++) {
                xor = FM_Bytes.xor(DES.encrypt4des(bArr, xor), bArr4[i]);
            }
            return DES.encrypt4des(bArr, xor);
        }
    }

    public static byte[] calculateMAC4DES(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        byte[] bArr4 = new byte[8];
        bArr4[0] = Byte.MIN_VALUE;
        if (bArr3 == null) {
            f9857a.error(MAC.class.getName(), Util4Java.endsWith("M\u001aU记篛斱．攭挶丩`<(s", 3, 91));
        }
        if (bArr2 == null) {
            bArr2 = new byte[8];
        }
        byte[] join = FM_Bytes.join(bArr3, FM_Bytes.copyOf(bArr4, bArr3.length % 8 != 0 ? 8 - (bArr3.length % 8) : 8));
        int length = join.length / 8;
        byte[][] bArr5 = (byte[][]) Array.newInstance(Byte.TYPE, new int[]{length, 8});
        for (int i = 0; i < length; i++) {
            for (int i2 = 0; i2 < 8; i2++) {
                bArr5[i][i2] = join[(i << 3) + i2];
            }
        }
        bArr4 = FM_Bytes.xor(bArr2, bArr5[0]);
        for (int i3 = 1; i3 < length; i3++) {
            bArr4 = FM_Bytes.xor(DES.encrypt4des(bArr, bArr4), bArr5[i3]);
        }
        return DES.encrypt4des(bArr, bArr4);
    }

    public static byte[] calculateMAC4DES3(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        byte[] bArr4 = new byte[8];
        bArr4[0] = Byte.MIN_VALUE;
        if (bArr3 == null) {
            f9857a.error(MAC.class.getName(), FM_Int.replace(2, "\u001a\u001b\u001e计箔旰％敼捡丨{mwr"));
        }
        if (bArr2 == null) {
            bArr2 = new byte[8];
        }
        byte[] join = FM_Bytes.join(bArr3, FM_Bytes.copyOf(bArr4, bArr3.length % 8 != 0 ? 8 - (bArr3.length % 8) : 8));
        int length = join.length / 8;
        byte[][] bArr5 = (byte[][]) Array.newInstance(Byte.TYPE, new int[]{length, 8});
        for (int i = 0; i < length; i++) {
            for (int i2 = 0; i2 < 8; i2++) {
                bArr5[i][i2] = join[(i << 3) + i2];
            }
        }
        bArr4 = FM_Bytes.xor(bArr2, bArr5[0]);
        for (int i3 = 1; i3 < length; i3++) {
            bArr4 = FM_Bytes.xor(DES.encrypt4des(bArr, bArr4), bArr5[i3]);
        }
        return DES.encrypt4des3(bArr, bArr4);
    }

    public static byte[] calculateMAC4DES3AN919(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        byte[] bArr4 = new byte[8];
        if (bArr3 == null) {
            f9857a.error(MAC.class.getName(), FM_Utils.regionMatches(312, 108, "EUC语篏斲＜敬捦乮.9th"));
        }
        if (bArr2 == null) {
            bArr2 = new byte[8];
        }
        byte[] join = FM_Bytes.join(bArr3, FM_Bytes.copyOf(bArr4, bArr3.length % 8 != 0 ? 8 - (bArr3.length % 8) : 0));
        int length = join.length / 8;
        byte[][] bArr5 = (byte[][]) Array.newInstance(Byte.TYPE, new int[]{length, 8});
        for (int i = 0; i < length; i++) {
            for (int i2 = 0; i2 < 8; i2++) {
                bArr5[i][i2] = join[(i << 3) + i2];
            }
        }
        bArr4 = FM_Bytes.xor(bArr2, bArr5[0]);
        for (int i3 = 1; i3 < length; i3++) {
            bArr4 = FM_Bytes.xor(DES.encrypt4des(bArr, bArr4), bArr5[i3]);
        }
        return DES.encrypt4des3(bArr, bArr4);
    }

    public static void main(String[] strArr) {
        byte[] bArr = new byte[16];
        bArr[1] = TagName.PREDEPOSIT_INFO;
        bArr[2] = TagName.USER_LOCK_TIME;
        bArr[3] = TagName.MAIN_ORDER;
        bArr[4] = (byte) -86;
        bArr[5] = TagName.TERMINAL_BACK_CHILDREN_ID;
        bArr[6] = TagName.ELECTRONIC_STARTTIME;
        bArr[7] = TagName.ORDER_TYPE;
        bArr[8] = TagName.ORDER_BRIEF_INFO_LIST;
        bArr[9] = (byte) -12;
        bArr[10] = TagName.PREDEPOSIT_LIST;
        bArr[11] = TagName.BUSINESS_ORDER_TYPE;
        bArr[12] = TagName.TERMINAL_BACK_INFO_LIST;
        bArr[13] = TagName.PAY_ORDER;
        bArr[14] = (byte) -73;
        bArr[15] = TagName.ORDER_INVOICE_STATUS;
        System.out.println(new StringBuilder(FM_Int.replace(1, ";8?e")).append(FM_Bytes.bytesToHexString(calculateMAC4DES3AN919(FM_Bytes.hexStringToBytes(FM_Bytes.concat("ogy\u0019fz\u0007-*H1T=3\u001afzu\u001c}^,>6[$Dh\u0017tq", 3, TagName.ELECTRONIC_USE_COUNT)), new byte[8], bArr))).toString());
    }
}
