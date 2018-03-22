package com.huawei.al;

import android.content.Context;
import android.support.v4.internal.view.SupportMenu;
import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import com.huawei.p190v.C2538c;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Array;

/* compiled from: FontFile */
public class C4030c {
    private RandomAccessFile f15311a = null;
    private byte[] f15312b = new byte[16];
    private byte[][] f15313c = ((byte[][]) null);
    private int f15314d = 0;
    private int[] f15315e = null;
    private int[] f15316f = null;
    private long[] f15317g = null;
    private int f15318h = 0;
    private short f15319i = (short) 0;
    private long f15320j = 0;
    private byte[] f15321k = new byte[512];
    private int f15322l = 0;

    public C4030c(Context context, File file) {
        C2538c.b("FontFile", new Object[]{"FontFile ctor: file = " + file.getPath()});
        if (m19830a(file)) {
            C2538c.c("FontFile", new Object[]{"FontFile init success..."});
            return;
        }
        C2538c.e("FontFile", new Object[]{"FontFile init failed..."});
    }

    private boolean m19830a(File file) {
        try {
            this.f15311a = new RandomAccessFile(file, "r");
            int read = this.f15311a.read(this.f15312b);
            C2538c.b("FontFile", new Object[]{"init: read head size = " + read + ", mHead = " + C4030c.m19829a(this.f15312b)});
            if (this.f15312b[0] != TagName.TERMINAL_BACK_CHILDREN_ID || this.f15312b[1] != TagName.TERMINAL_BASEBAND_VERSION || this.f15312b[2] != TagName.TERMINAL_OP_TYPE) {
                return false;
            }
            if (this.f15312b[0] == TagName.TERMINAL_BACK_CHILDREN_ID) {
                this.f15314d = this.f15312b[8];
                this.f15318h = this.f15312b[9];
                C2538c.b("FontFile", new Object[]{"init: mSectionSize = " + this.f15314d + ", mFontHeight = " + this.f15318h});
                if (this.f15314d > 0) {
                    this.f15313c = (byte[][]) Array.newInstance(Byte.TYPE, new int[]{this.f15314d, 8});
                    this.f15315e = new int[this.f15314d];
                    this.f15316f = new int[this.f15314d];
                    this.f15317g = new long[this.f15314d];
                    for (read = 0; read < this.f15314d; read++) {
                        int read2 = this.f15311a.read(this.f15313c[read]);
                        C2538c.b("FontFile", new Object[]{"init: read " + read + " section size = " + read2 + ", mSection = " + C4030c.m19829a(this.f15313c[read])});
                        this.f15315e[read] = ((this.f15313c[read][1] << 8) | (this.f15313c[read][0] & 255)) & SupportMenu.USER_MASK;
                        this.f15316f[read] = ((this.f15313c[read][2] << 8) | (this.f15313c[read][2] & 255)) & SupportMenu.USER_MASK;
                        this.f15317g[read] = (long) ((((this.f15313c[read][7] << 24) | (this.f15313c[read][6] << 16)) | (this.f15313c[read][5] << 8)) | this.f15313c[read][4]);
                        C2538c.b("FontFile", new Object[]{"init: mSectionFirstChar = " + this.f15315e[read] + ", mSectionLastChar = " + this.f15316f[read] + ", mSectionOffAddr = " + this.f15317g[read]});
                    }
                    return true;
                }
            }
            return false;
        } catch (FileNotFoundException e) {
            C2538c.e("FontFile", new Object[]{"Exception e = " + e.getMessage()});
        } catch (IOException e2) {
            C2538c.e("FontFile", new Object[]{"Exception e = " + e2.getMessage()});
        }
    }

    public static byte m19828a(int i) {
        String toBinaryString = Integer.toBinaryString(i);
        String str = "00000000".substring(toBinaryString.length()) + toBinaryString;
        StringBuffer stringBuffer = new StringBuffer();
        toBinaryString = "";
        for (int i2 = 7; i2 >= 0; i2--) {
            stringBuffer.append(str.charAt(i2));
        }
        return (byte) Integer.parseInt(stringBuffer.toString(), 2);
    }

    private static String m19829a(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder(bArr.length);
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            stringBuilder.append(String.format("%02X ", new Object[]{Byte.valueOf(bArr[i])}));
        }
        return stringBuilder.toString();
    }
}
