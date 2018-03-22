package cn.com.fmsh.util;

import cn.com.fmsh.FM_Exception;
import cn.com.fmsh.script.constants.ScriptToolsConst;
import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import cn.com.fmsh.util.log.FMLog;
import cn.com.fmsh.util.log.LogFactory;
import java.util.Arrays;

public class FM_CN {
    private static /* synthetic */ FMLog f9844a = LogFactory.getInstance().getLog();
    private static /* synthetic */ String f9845b = FM_CN.class.getName();
    private static /* synthetic */ String f9846c = FM_Bytes.concat("iq5}!i5})a", 2, 71);
    public byte[] data;

    public FM_CN() {
        this.data = new byte[0];
    }

    public FM_CN(String str) {
        this.data = new byte[0];
        valueOf(str);
    }

    public static int bcdBytesToInt(byte[] bArr) {
        int i = 0;
        int length = bArr.length;
        int i2 = 0;
        while (i < length) {
            byte b = (byte) ((bArr[i] & 240) >>> 4);
            if (b > (byte) 9) {
                break;
            }
            int i3 = b * 10;
            byte b2 = (byte) (bArr[i] & 15);
            if (b2 > (byte) 9) {
                break;
            }
            i2 += (i3 + b2) * power(100, length - (i + 1));
            i++;
        }
        return i2;
    }

    public static String bcdBytesToString(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder(bArr.length << 1);
        for (int i = 0; i < bArr.length; i++) {
            stringBuilder.append((byte) ((bArr[i] & 240) >>> 4));
            stringBuilder.append((byte) (bArr[i] & 15));
        }
        String stringBuilder2 = stringBuilder.toString();
        while (stringBuilder2.charAt(0) == '0' && stringBuilder2.length() != 1) {
            stringBuilder2 = stringBuilder2.substring(1);
        }
        return stringBuilder2;
    }

    public static String bcdBytesToString(byte[] bArr, int i) {
        if (bArr.length <= i) {
            return bcdBytesToString(bArr);
        }
        byte[] bArr2 = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            bArr2[i2] = bArr[i2];
        }
        return bcdBytesToString(bArr2);
    }

    public static String equals(String str, int i) {
        int i2 = i - 13;
        char[] toCharArray = str.toCharArray();
        int length = toCharArray.length;
        int i3 = i2;
        i2 = 0;
        while (i2 != length) {
            int i4 = i3 - 15;
            i3 = i2 + 1;
            toCharArray[i2] = (char) ((i3 & 95) ^ toCharArray[i2]);
            i2 = i3;
            i3 = i4;
        }
        return String.valueOf(toCharArray, 0, length).intern();
    }

    public static byte[] intToBcdBytes(int i, int i2) {
        if (i2 < 1) {
            if (f9844a != null) {
                f9844a.error(f9845b, FM_Int.replace(4, "匘辇剩kk|垀敺敡轸戇X^D砂孑芋敼绋旤９挟宁孉苃攴纃锵廫霎欰"));
            }
            return null;
        }
        byte[] bArr = new byte[i2];
        for (int i3 = i2 - 1; i3 >= 0; i3--) {
            int i4 = i % 100;
            bArr[i3] = (byte) (((byte) ((i4 % 10) & 15)) + ((byte) ((i4 / 10) << 4)));
            i /= 100;
        }
        return bArr;
    }

    public static byte[] longToBcdBytes(long j, int i) {
        if (i < 1) {
            if (f9844a != null) {
                f9844a.error(f9845b, BCCUtil.getChars("匓辞刮'q#垜敾攭轼戓\u0014J\u0018硎孕苗攸统斸ｍ挓寝孍芏攰绗镹廿青欼", 2, 83));
            }
            return null;
        }
        byte[] bArr = new byte[i];
        for (int i2 = i - 1; i2 >= 0; i2--) {
            int i3 = (int) (j % 100);
            bArr[i2] = (byte) (((byte) ((i3 % 10) & 15)) + ((byte) ((i3 / 10) << 4)));
            j /= 100;
        }
        return bArr;
    }

    public static void main(String[] strArr) {
        System.out.println(new StringBuilder(FM_Long.copyValueOf("x|w?", 3)).append(FM_Bytes.bytesToHexString(intToBcdBytes(500, 3))).toString());
        FM_CN fm_cn = new FM_CN(FM_Exception.insert(4, 86, "8o&9u"));
        System.out.println(fm_cn.intValue());
        try {
            fm_cn.setData(0, new byte[]{(byte) 1, (byte) 35, TagName.MOC});
            System.out.println(fm_cn.intValue());
        } catch (FM_Exception e) {
            e.printStackTrace();
        }
    }

    protected static int power(int i, int i2) {
        int i3 = 1;
        for (int i4 = 0; i4 < i2; i4++) {
            i3 *= i;
        }
        return i3;
    }

    public static byte[] string2Bcd(String str) {
        int length = str.length();
        if (length % 2 != 0) {
            str = "0" + str;
            length = str.length();
        }
        if (length >= 2) {
            length /= 2;
        }
        byte[] bArr = new byte[length];
        byte[] bytes = str.getBytes();
        for (int i = 0; i < length; i++) {
            int i2 = (bytes[i * 2] < TagName.APK_SIZE || bytes[i * 2] > ScriptToolsConst.TagName.TagApdu) ? (bytes[i * 2] < TagName.MAIN_ORDER_LIST || bytes[i * 2] > TagName.ELECTRONIC_OUT_STATE) ? (bytes[i * 2] - 65) + 10 : (bytes[i * 2] - 97) + 10 : bytes[i * 2] - 48;
            int i3 = (bytes[(i * 2) + 1] < TagName.APK_SIZE || bytes[(i * 2) + 1] > ScriptToolsConst.TagName.TagApdu) ? (bytes[(i * 2) + 1] < TagName.MAIN_ORDER_LIST || bytes[(i * 2) + 1] > TagName.ELECTRONIC_OUT_STATE) ? (bytes[(i * 2) + 1] - 65) + 10 : (bytes[(i * 2) + 1] - 97) + 10 : bytes[(i * 2) + 1] - 48;
            bArr[i] = (byte) ((i2 << 4) + i3);
        }
        return bArr;
    }

    protected long bcd2Dec() {
        int length = this.data.length;
        long j = 0;
        for (int i = 0; i < length; i++) {
            byte b = (byte) ((this.data[i] & 240) >>> 4);
            if (b > (byte) 9) {
                break;
            }
            long j2 = (long) (b * 10);
            byte b2 = (byte) (this.data[i] & 15);
            j += (b2 > (byte) 9 ? j2 + 0 : j2 + ((long) b2)) * ((long) power(100, length - (i + 1)));
        }
        return j;
    }

    public void clear() {
        if (this.data == null) {
            this.data = new byte[0];
        } else if (this.data.length > 0) {
            this.data = new byte[0];
        }
    }

    public String getBCD() {
        return this.data.length > 0 ? toHexString('\u0000') : null;
    }

    public byte getByte(int i) {
        return i < this.data.length ? this.data[i] : (byte) -1;
    }

    public byte[] getData() {
        return this.data;
    }

    public byte getNumber(int i) {
        if (i == 0 || i > (this.data.length << 1)) {
            return (byte) -1;
        }
        byte b = this.data[(i - 1) / 2];
        return i % 2 == 1 ? (byte) (b >>> 4) : (byte) (b & 15);
    }

    public int intValue() {
        if (this.data.length > 0) {
            long bcd2Dec = bcd2Dec();
            if (bcd2Dec <= 2147483647L && bcd2Dec >= -2147483648L) {
                return (int) bcd2Dec;
            }
        }
        return 0;
    }

    public boolean isEmpty() {
        return this.data == null;
    }

    public int length() {
        return this.data.length;
    }

    public long longValue() {
        return this.data.length > 0 ? bcd2Dec() : 0;
    }

    public int preplace(int i) {
        return preplace(i, (byte) -1);
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

    public boolean setBCD_L(String str, int i) {
        clear();
        if (i <= 0) {
            return false;
        }
        this.data = new byte[i];
        Arrays.fill(this.data, (byte) -1);
        String toUpperCase = str.toUpperCase();
        int length = toUpperCase.length();
        if (length <= 0) {
            return false;
        }
        int i2 = 0;
        int i3 = 0;
        while (i2 < length && i2 < (i << 1)) {
            int indexOf = f9846c.indexOf(toUpperCase.charAt(i2));
            if (indexOf == -1) {
                return false;
            }
            if (i2 % 2 == 1) {
                byte b = (byte) (indexOf | 240);
                byte[] bArr = this.data;
                bArr[i3] = (byte) (b & bArr[i3]);
                i3++;
            } else {
                this.data[i3] = (byte) (((indexOf & 15) << 4) | 15);
            }
            i2++;
        }
        return true;
    }

    public boolean setBCD_R(String str, int i) {
        int i2 = 0;
        clear();
        if (i <= 0) {
            return false;
        }
        this.data = new byte[i];
        Arrays.fill(this.data, (byte) 0);
        String toUpperCase = str.toUpperCase();
        int length = toUpperCase.length();
        if (length <= 0) {
            return false;
        }
        int i3;
        if (length >= (this.data.length << 1)) {
            length = this.data.length << 1;
            i3 = 0;
        } else {
            i3 = (this.data.length << 1) - length;
        }
        int i4 = i3;
        while (i2 < length) {
            i3 = f9846c.indexOf(toUpperCase.charAt(i2));
            i3 = i3 == -1 ? 15 : (byte) (i3 & 15);
            this.data[i4 >> 1] = (byte) ((i4 % 2 == 1 ? (byte) (i3 & 15) : (byte) (((byte) (i3 << 4)) & 240)) | this.data[i4 >> 1]);
            i2++;
            i4++;
        }
        return true;
    }

    public boolean setData(int i, String str) throws FM_Exception {
        int i2 = 0;
        int length = (str.length() + 1) / 2;
        if (length > 0) {
            byte[] bArr = new byte[length];
            String toUpperCase = str.toUpperCase();
            length = 0;
            byte b = (byte) 0;
            int i3 = 0;
            int i4 = 0;
            while (length < toUpperCase.length()) {
                int indexOf = f9846c.indexOf(toUpperCase.charAt(length));
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
                    length++;
                } else {
                    clear();
                    return false;
                }
            }
            if (i4 % 2 == 1) {
                length = i3 + 1;
                bArr[i3] = b;
                i3 = length;
            }
            if (i + i3 > this.data.length) {
                throw new FM_Exception(Util4Java.endsWith("n0.bf.:4)z;==`h9?rzr<", 4, 101));
            }
            while (i2 < i3) {
                this.data[i + i2] = bArr[i2];
                i2++;
            }
        }
        return true;
    }

    public boolean setData(int i, byte[] bArr) throws FM_Exception {
        return setData(i, bArr, 0, bArr.length);
    }

    public boolean setData(int i, byte[] bArr, int i2, int i3) throws FM_Exception {
        if (i2 < 0 || i2 + i3 > bArr.length) {
            throw new FM_Exception(BCCUtil.getChars("3m:4r.492*f|+jl$x`", 138, 41));
        } else if (i + i3 > this.data.length) {
            throw new FM_Exception(Util4Java.endsWith(" *ldpdx:w09;+zjgq(84*", 114, 13));
        } else {
            Arrays.fill(this.data, i, i + i3, (byte) -1);
            int i4 = 0;
            while (i4 < i3) {
                byte b = (byte) ((bArr[i2 + i4] >> 4) & 15);
                if (b < (byte) 10) {
                    byte[] bArr2 = this.data;
                    int i5 = i + i4;
                    bArr2[i5] = (byte) (((b << 4) | 15) & bArr2[i5]);
                    b = (byte) (bArr[i2 + i4] & 15);
                    if (b < (byte) 10) {
                        bArr2 = this.data;
                        i5 = i + i4;
                        bArr2[i5] = (byte) ((b | 240) & bArr2[i5]);
                        i4++;
                    } else if (b != (byte) 15) {
                        clear();
                        return false;
                    }
                } else if (b != (byte) 15) {
                    clear();
                    return false;
                }
                return true;
            }
            return true;
        }
    }

    public short shortValue() {
        if (this.data.length > 0) {
            long bcd2Dec = bcd2Dec();
            if (bcd2Dec <= 32767 && bcd2Dec >= -32768) {
                return (short) ((int) bcd2Dec);
            }
        }
        return (short) 0;
    }

    public String toHexString(char c) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : this.data) {
            stringBuilder.append(f9846c.charAt((b & 240) >> 4));
            stringBuilder.append(f9846c.charAt(b & 15));
            if (c != '\u0000') {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }

    public boolean valueOf(String str) {
        clear();
        int length = (str.length() + 1) / 2;
        if (length <= 0) {
            return false;
        }
        this.data = new byte[length];
        Arrays.fill(this.data, (byte) -1);
        String toUpperCase = str.toUpperCase();
        length = 0;
        int i = 0;
        int i2 = 0;
        while (length < toUpperCase.length()) {
            int indexOf = f9846c.indexOf(toUpperCase.charAt(length));
            if (indexOf != -1) {
                if (length % 2 == 1) {
                    byte b = (byte) (i & (indexOf | 240));
                    byte[] bArr = this.data;
                    i = i2 + 1;
                    bArr[i2] = (byte) (b & bArr[i2]);
                    i2 = i;
                    i = 0;
                } else {
                    i = (byte) (i | ((indexOf << 4) | 15));
                    this.data[i2] = i;
                }
                length++;
            } else {
                clear();
                return false;
            }
        }
        return true;
    }
}
