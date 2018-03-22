package cn.com.fmsh.util;

import cn.com.fmsh.FM_Exception;
import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import cn.com.fmsh.util.log.FMLog;
import cn.com.fmsh.util.log.LogFactory;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.nfc.carrera.logic.appletcardinfo.result.AppletCardResult;
import java.util.Arrays;
import org.apache.log4j.net.SyslogAppender;

public class FM_Bytes {
    private static /* synthetic */ FMLog f9841a = LogFactory.getInstance().getLog();
    private static /* synthetic */ String f9842b = FM_CN.equals("gyky/9+9gi\u0000\u0010\u0000P@P", 4);
    private static /* synthetic */ String f9843c = FM_Bytes.class.getName();
    public byte[] data;

    public FM_Bytes() {
        this.data = new byte[0];
    }

    public FM_Bytes(String str) {
        this.data = new byte[0];
        valueof(str);
    }

    public static byte[] and(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = null;
        if (bArr == null || bArr2 == null) {
            if (f9841a != null) {
                f9841a.error(f9843c, CRCUtil.substring(5, "东迍箟日２改纐乥$ lg"));
            }
        } else if (bArr.length == bArr2.length) {
            bArr3 = (byte[]) bArr.clone();
            for (int i = 0; i < bArr3.length; i++) {
                bArr3[i] = (byte) (bArr3[i] & bArr2[i]);
            }
        } else if (f9841a != null) {
            f9841a.error(f9843c, Util4Java.endsWith("丏迁篖旧ｍ3x%d敡纅镮廧乜筈", 4, 48));
        }
        return bArr3;
    }

    public static byte[] bytePatch4Des(byte[] bArr) {
        int i = 8;
        byte[] bArr2 = new byte[8];
        bArr2[0] = Byte.MIN_VALUE;
        if (bArr == null) {
            return null;
        }
        int length = bArr.length;
        if (length % 8 != 0) {
            i = 8 - (length % 8);
        }
        return join(bArr, copyOf(bArr2, i));
    }

    public static byte[] byteRemovePatch4Des(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        for (int length = bArr.length - 1; length > bArr.length - 9; length--) {
            if (Byte.MIN_VALUE == bArr[length]) {
                return Arrays.copyOf(bArr, length);
            }
        }
        return bArr;
    }

    public static String bytesToHexString(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        String str = "";
        return bytesToHexString(bArr, str, str);
    }

    public static String bytesToHexString(byte[] bArr, String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bArr) {
            String toHexString = Integer.toHexString(b & 255);
            if (toHexString.length() == 1) {
                toHexString = new StringBuilder(String.valueOf('0')).append(toHexString).toString();
            }
            if (!(str == null || "".equals(str))) {
                stringBuilder.append(str);
            }
            stringBuilder.append(toHexString.toUpperCase());
            if (!(str2 == null || "".equals(str2))) {
                stringBuilder.append(str2);
            }
        }
        return stringBuilder.toString();
    }

    public static int bytesToInt(byte[] bArr) {
        return bytesToInt(bArr, true);
    }

    public static int bytesToInt(byte[] bArr, boolean z) {
        int i = 1;
        if (bArr == null) {
            if (f9841a == null) {
                return -1;
            }
            f9841a.error(f9843c, BCCUtil.getChars("嬆芆攧绎轱所卂辍刿敨政旴ｙ數统乴o!kv", 1, 51));
            return -1;
        } else if (bArr.length < 1) {
            if (f9841a == null) {
                return -1;
            }
            f9841a.error(f9843c, FM_CN.equals("嬃苇攦纃轴戙卛运剪改攮方ｌ敡细镬庢乯v", 1));
            return -1;
        } else if (bArr.length == 1) {
            return bArr[0] & 255;
        } else {
            int i2;
            if (z) {
                i2 = bArr[0];
                while (i < bArr.length) {
                    i2 = (i2 << 8) | (bArr[i] & 255);
                    i++;
                }
                return i2;
            }
            i2 = bArr[bArr.length - 1];
            for (i = bArr.length - 2; i >= 0; i--) {
                i2 = (i2 << 8) | (bArr[i] & 255);
            }
            return i2;
        }
    }

    public static long bytesToLong(byte[] bArr) {
        return bytesToLong(bArr, true);
    }

    public static long bytesToLong(byte[] bArr, boolean z) {
        int i = 1;
        if (bArr == null) {
            if (f9841a == null) {
                return -1;
            }
            f9841a.error(f9843c, FM_Utils.regionMatches(230, 88, "嬁芌敶纚轺戞匇迅删攺收旨ｚ放绂乤8{j2"));
            return -1;
        } else if (bArr.length < 1) {
            if (f9841a == null) {
                return -1;
            }
            f9841a.error(f9843c, FM_CN.equals("嬏苋攪纏轰戝卟返制攥攲斥ｈ敥绂镨庮乣z", 5));
            return -1;
        } else if (bArr.length == 1) {
            return (long) (bArr[0] & 255);
        } else {
            long j;
            if (z) {
                j = (long) (bArr[0] & 255);
                while (i < bArr.length) {
                    j = (j << 8) | ((long) (bArr[i] & 255));
                    i++;
                }
                return j;
            }
            j = (long) bArr[bArr.length - 1];
            for (i = bArr.length - 2; i >= 0; i--) {
                j = (j << 8) | ((long) (bArr[i] & 255));
            }
            return j;
        }
    }

    public static String concat(String str, int i, int i2) {
        int i3 = i - 9;
        char[] toCharArray = str.toCharArray();
        int length = toCharArray.length;
        int i4 = i3;
        i3 = 0;
        while (i3 != length) {
            int i5 = i4 + i2;
            i4 = i3 + 1;
            toCharArray[i3] = (char) ((i4 & 95) ^ toCharArray[i3]);
            i3 = i4;
            i4 = i5;
        }
        return String.valueOf(toCharArray, 0, length).intern();
    }

    public static byte[] concatArrays(byte[] bArr, byte[]... bArr2) {
        int length = bArr.length;
        for (byte[] length2 : bArr2) {
            length += length2.length;
        }
        Object copyOf = Arrays.copyOf(bArr, length);
        int length3 = bArr.length;
        length = length3;
        for (Object obj : bArr2) {
            System.arraycopy(obj, 0, copyOf, length, obj.length);
            length += obj.length;
        }
        return copyOf;
    }

    public static byte[] copyOf(byte[] bArr, int i) {
        int i2 = 0;
        if (bArr == null) {
            throw new NullPointerException(CRCUtil.substring(5, "2rzzy :>&uAyd`udb$+c ,hc"));
        }
        byte[] bArr2 = new byte[i];
        if (bArr.length < i) {
            while (i2 < bArr.length) {
                bArr2[i2] = bArr[i2];
                i2++;
            }
        } else {
            while (i2 < i) {
                bArr2[i2] = bArr[i2];
                i2++;
            }
        }
        return bArr2;
    }

    public static byte[] copyOfRange(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new NullPointerException(FM_Long.copyValueOf("+gwk8577?p\f85%8-{1&r!9%*", 3));
        } else if (i2 - i <= 0) {
            throw new IllegalArgumentException(new StringBuilder(FM_Int.replace(3, "x=,ni\\")).append(i).append(FM_Long.copyValueOf("I/zdS", 300)).append(i2).append("]").toString());
        } else if (bArr.length < i2 || bArr.length < i) {
            throw new IllegalArgumentException(HwAccountConstants.BLANK);
        } else {
            int i3 = i2 - i;
            byte[] bArr2 = new byte[i3];
            for (int i4 = 0; i4 < i3; i4++) {
                bArr2[i4] = bArr[i + i4];
            }
            return bArr2;
        }
    }

    public static byte getByteParity(byte[] bArr) {
        int i = 1;
        if (bArr == null || bArr.length == 0) {
            return (byte) -1;
        }
        if (bArr.length == 1) {
            return bArr[0];
        }
        byte b = bArr[0];
        while (i < bArr.length) {
            b = (byte) (b ^ bArr[i]);
            i++;
        }
        return b;
    }

    public static byte[] hexStringToBytes(String str) {
        int i = 0;
        if (str == null || str.length() < 1) {
            return null;
        }
        int length = (str.length() + 1) / 2;
        if (length <= 0) {
            return new byte[0];
        }
        int i2;
        byte[] bArr = new byte[length];
        String toUpperCase = str.toUpperCase();
        byte b = (byte) 0;
        int i3 = 0;
        int i4 = 0;
        for (i2 = 0; i2 < toUpperCase.length(); i2++) {
            int indexOf = f9842b.indexOf(toUpperCase.charAt(i2));
            if (indexOf != -1) {
                i4++;
                if (i4 % 2 == 1) {
                    b = (byte) (b | (indexOf << 4));
                } else {
                    byte b2 = (byte) (b | indexOf);
                    int i5 = i3 + 1;
                    bArr[i3] = b2;
                    i3 = i5;
                    b = (byte) 0;
                }
            }
        }
        if (i4 % 2 == 1) {
            i2 = i3 + 1;
            bArr[i3] = b;
            i3 = i2;
        }
        if (i3 == length) {
            return bArr;
        }
        if (i3 == 0) {
            return new byte[0];
        }
        byte[] bArr2 = new byte[i3];
        while (i < i3) {
            bArr2[i] = bArr[i];
            i++;
        }
        return bArr2;
    }

    public static byte[] intToBytes(int i, int i2) {
        return intToBytes(i, i2, true);
    }

    public static byte[] intToBytes(int i, int i2, boolean z) {
        if (i2 < 1) {
            if (f9841a != null) {
                f9841a.error(f9843c, BCCUtil.getChars("匙迒剬\"r9敪敿輬戁孕苑整纑新；捏它皎攫终锢廨靁欳", 232, 81));
            }
            return null;
        }
        byte[] bArr = new byte[i2];
        int length;
        if (z) {
            for (length = bArr.length - 1; length > -1; length--) {
                bArr[length] = Integer.valueOf(i & 255).byteValue();
                i >>= 8;
            }
        } else {
            for (length = 0; length < bArr.length; length++) {
                bArr[length] = Integer.valueOf(i & 255).byteValue();
                i >>= 8;
            }
        }
        return bArr;
    }

    public static boolean isEnd(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr.length < bArr2.length) {
            return false;
        }
        int length = bArr.length;
        for (int length2 = bArr2.length - 1; length2 >= 0; length2--) {
            length--;
            if (bArr2[length2] != bArr[length]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isEnd9000(byte[] bArr) {
        byte[] bArr2 = new byte[2];
        bArr2[0] = TagName.SYSTEM_VERSION;
        return isEnd(bArr, bArr2);
    }

    public static boolean isPatch4Des(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        for (int length = bArr.length - 1; length > bArr.length - 9; length--) {
            if (Byte.MIN_VALUE == bArr[length]) {
                return true;
            }
        }
        return false;
    }

    public static byte[] join(byte[] bArr, byte[] bArr2) {
        int i = 0;
        if (bArr != null && bArr2 != null) {
            int length = bArr.length;
            byte[] bArr3 = new byte[(bArr.length + bArr2.length)];
            for (int i2 = 0; i2 < length; i2++) {
                bArr3[i2] = bArr[i2];
            }
            while (i < bArr2.length) {
                bArr3[length + i] = bArr2[i];
                i++;
            }
            return bArr3;
        } else if (f9841a == null) {
            return bArr;
        } else {
            f9841a.error(f9843c, FM_Int.replace(AppletCardResult.RESULT_FAILED_TRAFFIC_CARD_INFO_PIN_LOCKED, "嬒苊攻纊呙帢斡ｖ攭纄乹(< #"));
            return bArr;
        }
    }

    public static byte[] longToAsciiBytes(long j) {
        char[] toCharArray = new StringBuilder(String.valueOf(j)).toString().toCharArray();
        int length = toCharArray.length;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr[i] = (byte) (Integer.parseInt(new StringBuilder(String.valueOf(toCharArray[i])).toString()) + 48);
        }
        return bArr;
    }

    public static byte[] longToBytes(long j, int i) {
        return longToBytes(j, i, true);
    }

    public static byte[] longToBytes(long j, int i, boolean z) {
        if (i < 1) {
            if (f9841a != null) {
                f9841a.error(f9843c, FM_CN.equals("博迗别b0>&攦攳轸戕孁芅攨纍斬ｇ挛宗皚敿组键廤霍欧", 72));
            }
            return null;
        }
        byte[] bArr = new byte[i];
        int length;
        if (z) {
            for (length = bArr.length - 1; length > -1; length--) {
                bArr[length] = Long.valueOf(j & 255).byteValue();
                j >>= 8;
            }
        } else {
            for (length = 0; length < bArr.length; length++) {
                bArr[length] = Long.valueOf(j & 255).byteValue();
                j >>= 8;
            }
        }
        return bArr;
    }

    public static void main(String[] strArr) {
        byte[] bArr = new byte[2];
        bArr[0] = TagName.ELECTRONIC_STARTTIME;
        System.out.println(isEnd9000(bArr));
    }

    public static byte[] not(byte[] bArr) {
        if (bArr == null) {
            if (f9841a != null) {
                f9841a.error(f9843c, concat("压变旻ｉ攭纑丷kh9!", 6, 24));
            }
            return null;
        }
        byte[] bArr2 = (byte[]) bArr.clone();
        for (int i = 0; i < bArr2.length; i++) {
            bArr2[i] = (byte) (bArr[i] ^ -1);
        }
        return bArr2;
    }

    public static byte[] or(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = null;
        if (bArr == null || bArr2 == null) {
            if (f9841a != null) {
                f9841a.error(f9843c, BCCUtil.getChars("扃运篜斠－攼纓丸#-o\"", 5, 43));
            }
        } else if (bArr.length == bArr2.length) {
            bArr3 = (byte[]) bArr.clone();
            for (int i = 0; i < bArr3.length; i++) {
                bArr3[i] = (byte) (bArr3[i] | bArr2[i]);
            }
        } else if (f9841a != null) {
            f9841a.error(f9843c, CRCUtil.substring(2, "戙迊箒旦７$((\"攢纙長庵专筀"));
        }
        return bArr3;
    }

    public static byte[] patch(byte[] bArr, int i, byte b) {
        int i2 = 0;
        if (bArr == null || i <= 0) {
            return null;
        }
        int length = bArr.length;
        if (length >= i) {
            return (byte[]) bArr.clone();
        }
        byte[] bArr2 = new byte[i];
        for (int i3 = 0; i3 < length; i3++) {
            bArr2[i3] = bArr[i3];
        }
        while (i2 < i - length) {
            bArr2[length + i2] = b;
            i2++;
        }
        return bArr2;
    }

    public static void reverse(byte[] bArr) {
        int length = bArr.length;
        byte[] copyOf = copyOf(bArr, length);
        for (int i = 0; i < length; i++) {
            bArr[i] = copyOf[(length - i) - 1];
        }
    }

    public static boolean tlv(byte[] bArr, byte b, byte b2, byte[] bArr2) {
        byte b3 = (byte) 0;
        if (b != bArr[0] || b2 != bArr[1] || bArr.length != b2 + 2 || bArr2.length != b2) {
            return false;
        }
        while (b3 < b2) {
            bArr2[b3] = bArr[b3 + 2];
            b3++;
        }
        return true;
    }

    public static byte[] xor(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = null;
        if (bArr == null || bArr2 == null) {
            if (f9841a != null) {
                f9841a.error(f9843c, BCCUtil.getChars("彖扜时ｚ攼细乢 q6<", 4, 86));
            }
        } else if (bArr.length == bArr2.length) {
            bArr3 = (byte[]) bArr.clone();
            for (int i = 0; i < bArr3.length; i++) {
                bArr3[i] = (byte) (bArr3[i] ^ bArr2[i]);
            }
        } else if (f9841a != null) {
            f9841a.error(f9843c, FM_Exception.insert(4, 65, "弊扟旼ｇn4z*敠纕镭廵丙笜"));
        }
        return bArr3;
    }

    public void clear() {
        if (this.data == null) {
            this.data = new byte[0];
        } else if (this.data.length > 0) {
            this.data = new byte[0];
        }
    }

    public void copy(int i) throws FM_Exception {
        if (i < 0 || i < this.data.length) {
            throw new FM_Exception(CRCUtil.substring(4, "~jb`n<6.i 7o5bdc/(604"));
        }
        this.data = copyOf(this.data, i);
    }

    public int hashCode() {
        return Arrays.hashCode(this.data);
    }

    public int intValue() throws FM_Exception {
        return intValue(0, false);
    }

    public int intValue(int i, boolean z) throws FM_Exception {
        if (i + 4 > this.data.length) {
            throw new FM_Exception(concat(".~*d.0n\"94o+5>,?|>t4", 106, 71));
        }
        int i2;
        int i3;
        int i4;
        if (z) {
            i2 = this.data[i];
            i3 = 1;
            while (i3 < 4) {
                i4 = (this.data[i + i3] & 255) | (i2 << 8);
                i3++;
                i2 = i4;
            }
        } else {
            i2 = this.data[i + 3];
            i3 = 2;
            while (i3 >= 0) {
                i4 = (this.data[i + i3] & 255) | (i2 << 8);
                i3--;
                i2 = i4;
            }
        }
        return i2;
    }

    public int intValue(boolean z) throws FM_Exception {
        return intValue(0, z);
    }

    public int length() {
        return this.data.length;
    }

    public long longValue() throws FM_Exception {
        return longValue(0, false);
    }

    public long longValue(int i, boolean z) throws FM_Exception {
        if (i + 8 > this.data.length) {
            throw new FM_Exception(FM_CN.equals(":02:j~~|}:75aplak2&*0", 2));
        }
        long j;
        int i2;
        long j2;
        if (z) {
            j = (long) this.data[i];
            i2 = 1;
            while (i2 < 8) {
                j2 = ((long) (this.data[i + i2] & 255)) | (j << 8);
                i2++;
                j = j2;
            }
        } else {
            j = (long) this.data[i + 7];
            i2 = 6;
            while (i2 >= 0) {
                j2 = ((long) (this.data[i + i2] & 255)) | (j << 8);
                i2--;
                j = j2;
            }
        }
        return j;
    }

    public long longValue(boolean z) throws FM_Exception {
        return longValue(0, z);
    }

    public int preplace(int i) {
        return preplace(i, (byte) 0);
    }

    public int preplace(int i, byte b) {
        if (this.data.length != i) {
            this.data = new byte[i];
        }
        for (int i2 = 0; i2 < i; i2++) {
            this.data[i2] = b;
        }
        return this.data.length;
    }

    public boolean setData(int i, String str) throws FM_Exception {
        int i2 = 0;
        int length = (str.length() + 1) / 2;
        if (length > 0) {
            byte[] bArr = new byte[length];
            String toUpperCase = str.toUpperCase();
            byte b = (byte) 0;
            int i3 = 0;
            int i4 = 0;
            for (length = 0; length < toUpperCase.length(); length++) {
                int indexOf = f9842b.indexOf(toUpperCase.charAt(length));
                if (indexOf != -1) {
                    i4++;
                    if (i4 % 2 == 1) {
                        b = (byte) (b | (indexOf << 4));
                    } else {
                        byte b2 = (byte) (b | indexOf);
                        int i5 = i3 + 1;
                        bArr[i3] = b2;
                        i3 = i5;
                        b = (byte) 0;
                    }
                }
            }
            if (i4 % 2 == 1) {
                length = i3 + 1;
                bArr[i3] = b;
                i3 = length;
            }
            if (i + i3 > this.data.length) {
                throw new FM_Exception(FM_Long.copyValueOf("eqas-/=%r;$,f!/(435#7", 2));
            }
            while (i2 < i3) {
                this.data[i + i2] = bArr[i2];
                i2++;
            }
        }
        return true;
    }

    public boolean setData(int i, byte[] bArr) throws FM_Exception {
        if (bArr.length + i > this.data.length) {
            throw new FM_Exception(FM_Utils.regionMatches(3, 40, "<m&9`o&{3/kns9l>=\"9j"));
        }
        for (int i2 = 0; i2 < bArr.length; i2++) {
            this.data[i + i2] = bArr[i2];
        }
        return true;
    }

    public boolean setData(int i, byte[] bArr, int i2, int i3) throws FM_Exception {
        if (i2 < 0 || i2 + i3 > bArr.length) {
            throw new FM_Exception(FM_Exception.insert(76, 23, "9)(t`*>qx~d,)>fl2$"));
        } else if (i + i3 > this.data.length) {
            throw new FM_Exception(FM_Utils.regionMatches(SyslogAppender.LOG_LOCAL2, 64, "o6e2s4e0 4h% \"o5n$a2y"));
        } else {
            for (int i4 = 0; i4 < i3; i4++) {
                this.data[i + i4] = bArr[i2 + i4];
            }
            return true;
        }
    }

    public short shortValue() throws FM_Exception {
        return shortValue(0, false);
    }

    public short shortValue(int i, boolean z) throws FM_Exception {
        if (i + 2 <= this.data.length) {
            return z ? (short) (((short) (this.data[i] << 8)) | (this.data[i + 1] & 255)) : (short) (((short) (this.data[i + 1] << 8)) | (this.data[i] & 255));
        } else {
            throw new FM_Exception(CRCUtil.substring(212, ".:2p~lf~90'?e24sxf`d"));
        }
    }

    public short shortValue(boolean z) throws FM_Exception {
        return shortValue(0, z);
    }

    public String toHexString(char c) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : this.data) {
            stringBuilder.append(f9842b.charAt((b & 240) >> 4));
            stringBuilder.append(f9842b.charAt(b & 15));
            if (c != '\u0000') {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }

    public String toString() {
        return toHexString(' ');
    }

    public boolean valueof(String str) {
        int i = 0;
        int length = (str.length() + 1) / 2;
        if (length > 0) {
            int i2;
            byte[] bArr = new byte[length];
            String toUpperCase = str.toUpperCase();
            byte b = (byte) 0;
            int i3 = 0;
            int i4 = 0;
            for (i2 = 0; i2 < toUpperCase.length(); i2++) {
                int indexOf = f9842b.indexOf(toUpperCase.charAt(i2));
                if (indexOf != -1) {
                    i4++;
                    if (i4 % 2 == 1) {
                        b = (byte) (b | (indexOf << 4));
                    } else {
                        byte b2 = (byte) (b | indexOf);
                        int i5 = i3 + 1;
                        bArr[i3] = b2;
                        i3 = i5;
                        b = (byte) 0;
                    }
                }
            }
            if (i4 % 2 == 1) {
                i2 = i3 + 1;
                bArr[i3] = b;
                i3 = i2;
            }
            if (i3 == length) {
                this.data = bArr;
            } else if (i3 == 0) {
                this.data = new byte[0];
            } else {
                this.data = new byte[i3];
                while (i < i3) {
                    this.data[i] = bArr[i];
                    i++;
                }
            }
        } else {
            this.data = new byte[0];
        }
        return true;
    }
}
