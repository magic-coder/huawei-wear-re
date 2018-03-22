package cn.com.fmsh;

public class FM_Exception extends Exception {
    private static final /* synthetic */ long serialVersionUID = -4590066155361981024L;

    public FM_Exception(String str) {
        super(str);
    }

    public static String insert(int i, int i2, String str) {
        int i3 = i + 4;
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
}
