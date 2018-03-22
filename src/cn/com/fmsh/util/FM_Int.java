package cn.com.fmsh.util;

public class FM_Int {
    private /* synthetic */ int f9848a;

    public FM_Int(int i) {
        this.f9848a = i;
    }

    public static String replace(int i, String str) {
        int i2 = i - 11;
        char[] toCharArray = str.toCharArray();
        int length = toCharArray.length;
        int i3 = i2;
        i2 = 0;
        while (i2 != length) {
            int i4 = i3 + 3;
            i3 = i2 + 1;
            toCharArray[i2] = (char) ((i3 & 95) ^ toCharArray[i2]);
            i2 = i3;
            i3 = i4;
        }
        return String.valueOf(toCharArray, 0, length).intern();
    }

    public int getValue() {
        return this.f9848a;
    }

    public void setValue(int i) {
        this.f9848a = i;
    }
}
