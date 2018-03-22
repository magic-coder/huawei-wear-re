package cn.com.fmsh.util;

public class FM_Long {
    private /* synthetic */ long f9849a;

    public FM_Long(long j) {
        this.f9849a = j;
    }

    public static String copyValueOf(String str, int i) {
        int i2 = i + 8;
        char[] toCharArray = str.toCharArray();
        int length = toCharArray.length;
        int i3 = i2;
        i2 = 0;
        while (i2 != length) {
            int i4 = i3 - 3;
            i3 = i2 + 1;
            toCharArray[i2] = (char) ((i3 & 95) ^ toCharArray[i2]);
            i2 = i3;
            i3 = i4;
        }
        return String.valueOf(toCharArray, 0, length).intern();
    }

    public long getValue() {
        return this.f9849a;
    }

    public void setValue(long j) {
        this.f9849a = j;
    }
}
