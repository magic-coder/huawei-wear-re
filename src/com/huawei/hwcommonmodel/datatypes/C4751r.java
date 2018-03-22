package com.huawei.hwcommonmodel.datatypes;

import android.graphics.Bitmap;
import java.util.ArrayList;

/* compiled from: PromptBitmapToByte */
public class C4751r {
    public byte[] m22731a(Bitmap bitmap) {
        ArrayList a = m22730a(new ArrayList(), bitmap);
        if (a == null) {
            return null;
        }
        byte[] bArr = new byte[a.size()];
        for (int i = 0; i < a.size(); i++) {
            bArr[i] = (byte) ((Integer) a.get(i)).intValue();
        }
        return bArr;
    }

    private ArrayList<Integer> m22730a(ArrayList<Integer> arrayList, Bitmap bitmap) {
        if (arrayList == null || bitmap == null) {
            return null;
        }
        int i;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        ArrayList arrayList2 = new ArrayList(height);
        for (i = 0; i < height; i++) {
            int i2;
            StringBuilder stringBuilder = new StringBuilder();
            for (i2 = 0; i2 < width; i2++) {
                if (((short) (bitmap.getPixel(i2, i) & 255)) <= (short) 127) {
                    stringBuilder.append("0");
                } else {
                    stringBuilder.append("1");
                }
            }
            arrayList2.add(stringBuilder.toString());
        }
        for (int i3 = 0; i3 < width; i3++) {
            String str = "";
            int i4 = height / 8;
            int i5 = height % 8;
            System.out.println("a = " + i4 + ",b =" + i5);
            StringBuilder stringBuilder2 = new StringBuilder();
            for (i = 0; i < height; i++) {
                stringBuilder2.append(((String) arrayList2.get(i)).charAt(i3));
            }
            String stringBuilder3 = stringBuilder2.toString();
            if (i4 == 0) {
                arrayList.add(Integer.valueOf(Integer.parseInt(stringBuilder3, 2)));
            } else {
                for (i2 = 0; i2 < i4; i2++) {
                    arrayList.add(Integer.valueOf(Integer.parseInt(stringBuilder3.substring(i2 * 8, (i2 + 1) * 8), 2)));
                }
                if (i5 != 0) {
                    str = stringBuilder3.substring(i4 * 8, stringBuilder3.length());
                    arrayList.add(Integer.valueOf(Integer.parseInt("00000000".substring(str.length()) + str, 2)));
                }
            }
        }
        return arrayList;
    }
}
