package com.google.zxing.p303g.p304a;

import android.support.v4.media.TransportMediator;
import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import com.google.zxing.C3900f;
import com.google.zxing.p278b.C3717b;
import com.huawei.crowdtestsdk.common.SpecialIssueType;
import com.huawei.crowdtestsdk.report.ReportInfoUtils;
import com.huawei.hihealth.HiUserInfo;
import org.apache.log4j.net.SyslogAppender;

/* compiled from: Version */
public final class C3918r {
    private static final int[] f15076a = new int[]{31892, 34236, 39577, 42195, 48118, 51042, 55367, 58893, 63784, 68472, 70749, 76311, 79154, 84390, 87683, 92361, 96236, 102084, 102881, 110507, 110734, 117786, 119615, 126325, 127568, 133589, 136944, 141498, 145311, 150283, 152622, 158308, 161089, 167017};
    private static final C3918r[] f15077b = C3918r.m19504f();
    private final int f15078c;
    private final int[] f15079d;
    private final C3920t[] f15080e;
    private final int f15081f;

    private C3918r(int i, int[] iArr, C3920t... c3920tArr) {
        int i2 = 0;
        this.f15078c = i;
        this.f15079d = iArr;
        this.f15080e = c3920tArr;
        int a = c3920tArr[0].m19513a();
        C3919s[] b = c3920tArr[0].m19514b();
        int length = b.length;
        int i3 = 0;
        while (i2 < length) {
            C3919s c3919s = b[i2];
            i3 += (c3919s.m19512b() + a) * c3919s.m19511a();
            i2++;
        }
        this.f15081f = i3;
    }

    public int m19505a() {
        return this.f15078c;
    }

    public int[] m19507b() {
        return this.f15079d;
    }

    public int m19508c() {
        return this.f15081f;
    }

    public int m19509d() {
        return (this.f15078c * 4) + 17;
    }

    public C3920t m19506a(C3914n c3914n) {
        return this.f15080e[c3914n.ordinal()];
    }

    public static C3918r m19501a(int i) throws C3900f {
        if (i % 4 != 1) {
            throw C3900f.m19459a();
        }
        try {
            return C3918r.m19502b((i - 17) >> 2);
        } catch (IllegalArgumentException e) {
            throw C3900f.m19459a();
        }
    }

    public static C3918r m19502b(int i) {
        if (i >= 1 && i <= 40) {
            return f15077b[i - 1];
        }
        throw new IllegalArgumentException();
    }

    static C3918r m19503c(int i) {
        int i2 = 0;
        int i3 = Integer.MAX_VALUE;
        int i4 = 0;
        while (i2 < f15076a.length) {
            int i5 = f15076a[i2];
            if (i5 == i) {
                return C3918r.m19502b(i2 + 7);
            }
            i5 = C3915o.m19493a(i, i5);
            if (i5 < i3) {
                i4 = i2 + 7;
                i3 = i5;
            }
            i2++;
        }
        if (i3 <= 3) {
            return C3918r.m19502b(i4);
        }
        return null;
    }

    C3717b m19510e() {
        int d = m19509d();
        C3717b c3717b = new C3717b(d);
        c3717b.m18711a(0, 0, 9, 9);
        c3717b.m18711a(d - 8, 0, 8, 9);
        c3717b.m18711a(0, d - 8, 9, 8);
        int length = this.f15079d.length;
        int i = 0;
        while (i < length) {
            int i2 = this.f15079d[i] - 2;
            int i3 = 0;
            while (i3 < length) {
                if (!((i == 0 && (i3 == 0 || i3 == length - 1)) || (i == length - 1 && i3 == 0))) {
                    c3717b.m18711a(this.f15079d[i3] - 2, i2, 5, 5);
                }
                i3++;
            }
            i++;
        }
        c3717b.m18711a(6, 9, 1, d - 17);
        c3717b.m18711a(9, 6, d - 17, 1);
        if (this.f15078c > 6) {
            c3717b.m18711a(d - 11, 0, 3, 6);
            c3717b.m18711a(0, d - 11, 6, 3);
        }
        return c3717b;
    }

    public String toString() {
        return String.valueOf(this.f15078c);
    }

    private static C3918r[] m19504f() {
        r0 = new C3918r[40];
        int[] iArr = new int[0];
        C3920t[] c3920tArr = new C3920t[4];
        c3920tArr[0] = new C3920t(7, new C3919s(1, 19));
        c3920tArr[1] = new C3920t(10, new C3919s(1, 16));
        c3920tArr[2] = new C3920t(13, new C3919s(1, 13));
        c3920tArr[3] = new C3920t(17, new C3919s(1, 9));
        r0[0] = new C3918r(1, iArr, c3920tArr);
        iArr = new int[]{6, 18};
        c3920tArr = new C3920t[4];
        c3920tArr[0] = new C3920t(10, new C3919s(1, 34));
        c3920tArr[1] = new C3920t(16, new C3919s(1, 28));
        c3920tArr[2] = new C3920t(22, new C3919s(1, 22));
        c3920tArr[3] = new C3920t(28, new C3919s(1, 16));
        r0[1] = new C3918r(2, iArr, c3920tArr);
        iArr = new int[]{6, 22};
        c3920tArr = new C3920t[4];
        c3920tArr[0] = new C3920t(15, new C3919s(1, 55));
        c3920tArr[1] = new C3920t(26, new C3919s(1, 44));
        c3920tArr[2] = new C3920t(18, new C3919s(2, 17));
        c3920tArr[3] = new C3920t(22, new C3919s(2, 13));
        r0[2] = new C3918r(3, iArr, c3920tArr);
        iArr = new int[]{6, 26};
        c3920tArr = new C3920t[4];
        c3920tArr[0] = new C3920t(20, new C3919s(1, 80));
        c3920tArr[1] = new C3920t(18, new C3919s(2, 32));
        c3920tArr[2] = new C3920t(26, new C3919s(2, 24));
        c3920tArr[3] = new C3920t(16, new C3919s(4, 9));
        r0[3] = new C3918r(4, iArr, c3920tArr);
        iArr = new int[]{6, 30};
        c3920tArr = new C3920t[4];
        c3920tArr[0] = new C3920t(26, new C3919s(1, 108));
        c3920tArr[1] = new C3920t(24, new C3919s(2, 43));
        c3920tArr[2] = new C3920t(18, new C3919s(2, 15), new C3919s(2, 16));
        c3920tArr[3] = new C3920t(22, new C3919s(2, 11), new C3919s(2, 12));
        r0[4] = new C3918r(5, iArr, c3920tArr);
        iArr = new int[]{6, 34};
        c3920tArr = new C3920t[4];
        c3920tArr[0] = new C3920t(18, new C3919s(2, 68));
        c3920tArr[1] = new C3920t(16, new C3919s(4, 27));
        c3920tArr[2] = new C3920t(24, new C3919s(4, 19));
        c3920tArr[3] = new C3920t(28, new C3919s(4, 15));
        r0[5] = new C3918r(6, iArr, c3920tArr);
        iArr = new int[]{6, 22, 38};
        c3920tArr = new C3920t[4];
        c3920tArr[0] = new C3920t(20, new C3919s(2, 78));
        c3920tArr[1] = new C3920t(18, new C3919s(4, 31));
        c3920tArr[2] = new C3920t(18, new C3919s(2, 14), new C3919s(4, 15));
        c3920tArr[3] = new C3920t(26, new C3919s(4, 13), new C3919s(1, 14));
        r0[6] = new C3918r(7, iArr, c3920tArr);
        iArr = new int[]{6, 24, 42};
        c3920tArr = new C3920t[4];
        c3920tArr[0] = new C3920t(24, new C3919s(2, 97));
        c3920tArr[1] = new C3920t(22, new C3919s(2, 38), new C3919s(2, 39));
        c3920tArr[2] = new C3920t(22, new C3919s(4, 18), new C3919s(2, 19));
        c3920tArr[3] = new C3920t(26, new C3919s(4, 14), new C3919s(2, 15));
        r0[7] = new C3918r(8, iArr, c3920tArr);
        iArr = new int[]{6, 26, 46};
        c3920tArr = new C3920t[4];
        c3920tArr[0] = new C3920t(30, new C3919s(2, SpecialIssueType.BUG_TYPE_ID_CHARGE));
        c3920tArr[1] = new C3920t(22, new C3919s(3, 36), new C3919s(2, 37));
        c3920tArr[2] = new C3920t(20, new C3919s(4, 16), new C3919s(4, 17));
        c3920tArr[3] = new C3920t(24, new C3919s(4, 12), new C3919s(4, 13));
        r0[8] = new C3918r(9, iArr, c3920tArr);
        iArr = new int[]{6, 28, 50};
        c3920tArr = new C3920t[4];
        c3920tArr[0] = new C3920t(18, new C3919s(2, 68), new C3919s(2, 69));
        c3920tArr[1] = new C3920t(26, new C3919s(4, 43), new C3919s(1, 44));
        c3920tArr[2] = new C3920t(24, new C3919s(6, 19), new C3919s(2, 20));
        c3920tArr[3] = new C3920t(28, new C3919s(6, 15), new C3919s(2, 16));
        r0[9] = new C3918r(10, iArr, c3920tArr);
        iArr = new int[]{6, 30, 54};
        c3920tArr = new C3920t[4];
        c3920tArr[0] = new C3920t(20, new C3919s(4, 81));
        c3920tArr[1] = new C3920t(30, new C3919s(1, 50), new C3919s(4, 51));
        c3920tArr[2] = new C3920t(28, new C3919s(4, 22), new C3919s(4, 23));
        c3920tArr[3] = new C3920t(24, new C3919s(3, 12), new C3919s(8, 13));
        r0[10] = new C3918r(11, iArr, c3920tArr);
        iArr = new int[]{6, 32, 58};
        c3920tArr = new C3920t[4];
        c3920tArr[0] = new C3920t(24, new C3919s(2, 92), new C3919s(2, 93));
        c3920tArr[1] = new C3920t(22, new C3919s(6, 36), new C3919s(2, 37));
        c3920tArr[2] = new C3920t(26, new C3919s(4, 20), new C3919s(6, 21));
        c3920tArr[3] = new C3920t(28, new C3919s(7, 14), new C3919s(4, 15));
        r0[11] = new C3918r(12, iArr, c3920tArr);
        iArr = new int[]{6, 34, 62};
        c3920tArr = new C3920t[4];
        c3920tArr[0] = new C3920t(26, new C3919s(4, 107));
        c3920tArr[1] = new C3920t(22, new C3919s(8, 37), new C3919s(1, 38));
        c3920tArr[2] = new C3920t(24, new C3919s(8, 20), new C3919s(4, 21));
        c3920tArr[3] = new C3920t(22, new C3919s(12, 11), new C3919s(4, 12));
        r0[12] = new C3918r(13, iArr, c3920tArr);
        iArr = new int[]{6, 26, 46, 66};
        c3920tArr = new C3920t[4];
        c3920tArr[0] = new C3920t(30, new C3919s(3, 115), new C3919s(1, SpecialIssueType.BUG_TYPE_ID_CHARGE));
        c3920tArr[1] = new C3920t(24, new C3919s(4, 40), new C3919s(5, 41));
        c3920tArr[2] = new C3920t(20, new C3919s(11, 16), new C3919s(5, 17));
        c3920tArr[3] = new C3920t(24, new C3919s(11, 12), new C3919s(5, 13));
        r0[13] = new C3918r(14, iArr, c3920tArr);
        iArr = new int[]{6, 26, 48, 70};
        c3920tArr = new C3920t[4];
        c3920tArr[0] = new C3920t(22, new C3919s(5, 87), new C3919s(1, 88));
        c3920tArr[1] = new C3920t(24, new C3919s(5, 41), new C3919s(5, 42));
        c3920tArr[2] = new C3920t(30, new C3919s(5, 24), new C3919s(7, 25));
        c3920tArr[3] = new C3920t(24, new C3919s(11, 12), new C3919s(7, 13));
        r0[14] = new C3918r(15, iArr, c3920tArr);
        iArr = new int[]{6, 26, 50, 74};
        c3920tArr = new C3920t[4];
        c3920tArr[0] = new C3920t(24, new C3919s(5, 98), new C3919s(1, 99));
        c3920tArr[1] = new C3920t(28, new C3919s(7, 45), new C3919s(3, 46));
        c3920tArr[2] = new C3920t(24, new C3919s(15, 19), new C3919s(2, 20));
        c3920tArr[3] = new C3920t(30, new C3919s(3, 15), new C3919s(13, 16));
        r0[15] = new C3918r(16, iArr, c3920tArr);
        iArr = new int[]{6, 30, 54, 78};
        c3920tArr = new C3920t[4];
        c3920tArr[0] = new C3920t(28, new C3919s(1, 107), new C3919s(5, 108));
        c3920tArr[1] = new C3920t(28, new C3919s(10, 46), new C3919s(1, 47));
        c3920tArr[2] = new C3920t(28, new C3919s(1, 22), new C3919s(15, 23));
        c3920tArr[3] = new C3920t(28, new C3919s(2, 14), new C3919s(17, 15));
        r0[16] = new C3918r(17, iArr, c3920tArr);
        iArr = new int[]{6, 30, 56, 82};
        c3920tArr = new C3920t[4];
        c3920tArr[0] = new C3920t(30, new C3919s(5, 120), new C3919s(1, 121));
        c3920tArr[1] = new C3920t(26, new C3919s(9, 43), new C3919s(4, 44));
        c3920tArr[2] = new C3920t(28, new C3919s(17, 22), new C3919s(1, 23));
        c3920tArr[3] = new C3920t(28, new C3919s(2, 14), new C3919s(19, 15));
        r0[17] = new C3918r(18, iArr, c3920tArr);
        iArr = new int[]{6, 30, 58, 86};
        c3920tArr = new C3920t[4];
        c3920tArr[0] = new C3920t(28, new C3919s(3, 113), new C3919s(4, 114));
        c3920tArr[1] = new C3920t(26, new C3919s(3, 44), new C3919s(11, 45));
        c3920tArr[2] = new C3920t(26, new C3919s(17, 21), new C3919s(4, 22));
        c3920tArr[3] = new C3920t(26, new C3919s(9, 13), new C3919s(16, 14));
        r0[18] = new C3918r(19, iArr, c3920tArr);
        iArr = new int[]{6, 34, 62, 90};
        c3920tArr = new C3920t[4];
        c3920tArr[0] = new C3920t(28, new C3919s(3, 107), new C3919s(5, 108));
        c3920tArr[1] = new C3920t(26, new C3919s(3, 41), new C3919s(13, 42));
        c3920tArr[2] = new C3920t(30, new C3919s(15, 24), new C3919s(5, 25));
        c3920tArr[3] = new C3920t(28, new C3919s(15, 15), new C3919s(10, 16));
        r0[19] = new C3918r(20, iArr, c3920tArr);
        iArr = new int[]{6, 28, 50, 72, 94};
        c3920tArr = new C3920t[4];
        c3920tArr[0] = new C3920t(28, new C3919s(4, SpecialIssueType.BUG_TYPE_ID_CHARGE), new C3919s(4, 117));
        c3920tArr[1] = new C3920t(26, new C3919s(17, 42));
        c3920tArr[2] = new C3920t(28, new C3919s(17, 22), new C3919s(6, 23));
        c3920tArr[3] = new C3920t(30, new C3919s(19, 16), new C3919s(6, 17));
        r0[20] = new C3918r(21, iArr, c3920tArr);
        iArr = new int[]{6, 26, 50, 74, 98};
        c3920tArr = new C3920t[4];
        c3920tArr[0] = new C3920t(28, new C3919s(2, 111), new C3919s(7, 112));
        c3920tArr[1] = new C3920t(28, new C3919s(17, 46));
        c3920tArr[2] = new C3920t(30, new C3919s(7, 24), new C3919s(16, 25));
        c3920tArr[3] = new C3920t(24, new C3919s(34, 13));
        r0[21] = new C3918r(22, iArr, c3920tArr);
        iArr = new int[]{6, 30, 54, 78, 102};
        c3920tArr = new C3920t[4];
        c3920tArr[0] = new C3920t(30, new C3919s(4, 121), new C3919s(5, 122));
        c3920tArr[1] = new C3920t(28, new C3919s(4, 47), new C3919s(14, 48));
        c3920tArr[2] = new C3920t(30, new C3919s(11, 24), new C3919s(14, 25));
        c3920tArr[3] = new C3920t(30, new C3919s(16, 15), new C3919s(14, 16));
        r0[22] = new C3918r(23, iArr, c3920tArr);
        iArr = new int[]{6, 28, 54, 80, 106};
        c3920tArr = new C3920t[4];
        c3920tArr[0] = new C3920t(30, new C3919s(6, 117), new C3919s(4, 118));
        c3920tArr[1] = new C3920t(28, new C3919s(6, 45), new C3919s(14, 46));
        c3920tArr[2] = new C3920t(30, new C3919s(11, 24), new C3919s(16, 25));
        c3920tArr[3] = new C3920t(30, new C3919s(30, 16), new C3919s(2, 17));
        r0[23] = new C3918r(24, iArr, c3920tArr);
        iArr = new int[]{6, 32, 58, 84, 110};
        c3920tArr = new C3920t[4];
        c3920tArr[0] = new C3920t(26, new C3919s(8, 106), new C3919s(4, 107));
        c3920tArr[1] = new C3920t(28, new C3919s(8, 47), new C3919s(13, 48));
        c3920tArr[2] = new C3920t(30, new C3919s(7, 24), new C3919s(22, 25));
        c3920tArr[3] = new C3920t(30, new C3919s(22, 15), new C3919s(13, 16));
        r0[24] = new C3918r(25, iArr, c3920tArr);
        iArr = new int[]{6, 30, 58, 86, 114};
        c3920tArr = new C3920t[4];
        c3920tArr[0] = new C3920t(28, new C3919s(10, 114), new C3919s(2, 115));
        c3920tArr[1] = new C3920t(28, new C3919s(19, 46), new C3919s(4, 47));
        c3920tArr[2] = new C3920t(28, new C3919s(28, 22), new C3919s(6, 23));
        c3920tArr[3] = new C3920t(30, new C3919s(33, 16), new C3919s(4, 17));
        r0[25] = new C3918r(26, iArr, c3920tArr);
        iArr = new int[]{6, 34, 62, 90, 118};
        c3920tArr = new C3920t[4];
        c3920tArr[0] = new C3920t(30, new C3919s(8, 122), new C3919s(4, ReportInfoUtils.FEEDBACK_SUCCESS));
        c3920tArr[1] = new C3920t(28, new C3919s(22, 45), new C3919s(3, 46));
        c3920tArr[2] = new C3920t(30, new C3919s(8, 23), new C3919s(26, 24));
        c3920tArr[3] = new C3920t(30, new C3919s(12, 15), new C3919s(28, 16));
        r0[26] = new C3918r(27, iArr, c3920tArr);
        iArr = new int[]{6, 26, 50, 74, 98, 122};
        c3920tArr = new C3920t[4];
        c3920tArr[0] = new C3920t(30, new C3919s(3, 117), new C3919s(10, 118));
        c3920tArr[1] = new C3920t(28, new C3919s(3, 45), new C3919s(23, 46));
        c3920tArr[2] = new C3920t(30, new C3919s(4, 24), new C3919s(31, 25));
        c3920tArr[3] = new C3920t(30, new C3919s(11, 15), new C3919s(31, 16));
        r0[27] = new C3918r(28, iArr, c3920tArr);
        iArr = new int[]{6, 30, 54, 78, 102, TransportMediator.KEYCODE_MEDIA_PLAY};
        c3920tArr = new C3920t[4];
        c3920tArr[0] = new C3920t(30, new C3919s(7, SpecialIssueType.BUG_TYPE_ID_CHARGE), new C3919s(7, 117));
        c3920tArr[1] = new C3920t(28, new C3919s(21, 45), new C3919s(7, 46));
        c3920tArr[2] = new C3920t(30, new C3919s(1, 23), new C3919s(37, 24));
        c3920tArr[3] = new C3920t(30, new C3919s(19, 15), new C3919s(26, 16));
        r0[28] = new C3918r(29, iArr, c3920tArr);
        iArr = new int[]{6, 26, 52, 78, 104, TransportMediator.KEYCODE_MEDIA_RECORD};
        c3920tArr = new C3920t[4];
        c3920tArr[0] = new C3920t(30, new C3919s(5, 115), new C3919s(10, SpecialIssueType.BUG_TYPE_ID_CHARGE));
        c3920tArr[1] = new C3920t(28, new C3919s(19, 47), new C3919s(10, 48));
        c3920tArr[2] = new C3920t(30, new C3919s(15, 24), new C3919s(25, 25));
        c3920tArr[3] = new C3920t(30, new C3919s(23, 15), new C3919s(25, 16));
        r0[29] = new C3918r(30, iArr, c3920tArr);
        iArr = new int[]{6, 30, 56, 82, 108, 134};
        c3920tArr = new C3920t[4];
        c3920tArr[0] = new C3920t(30, new C3919s(13, 115), new C3919s(3, SpecialIssueType.BUG_TYPE_ID_CHARGE));
        c3920tArr[1] = new C3920t(28, new C3919s(2, 46), new C3919s(29, 47));
        c3920tArr[2] = new C3920t(30, new C3919s(42, 24), new C3919s(1, 25));
        c3920tArr[3] = new C3920t(30, new C3919s(23, 15), new C3919s(28, 16));
        r0[30] = new C3918r(31, iArr, c3920tArr);
        iArr = new int[]{6, 34, 60, 86, 112, 138};
        c3920tArr = new C3920t[4];
        c3920tArr[0] = new C3920t(30, new C3919s(17, 115));
        c3920tArr[1] = new C3920t(28, new C3919s(10, 46), new C3919s(23, 47));
        c3920tArr[2] = new C3920t(30, new C3919s(10, 24), new C3919s(35, 25));
        c3920tArr[3] = new C3920t(30, new C3919s(19, 15), new C3919s(35, 16));
        r0[31] = new C3918r(32, iArr, c3920tArr);
        iArr = new int[]{6, 30, 58, 86, 114, 142};
        c3920tArr = new C3920t[4];
        c3920tArr[0] = new C3920t(30, new C3919s(17, 115), new C3919s(1, SpecialIssueType.BUG_TYPE_ID_CHARGE));
        c3920tArr[1] = new C3920t(28, new C3919s(14, 46), new C3919s(21, 47));
        c3920tArr[2] = new C3920t(30, new C3919s(29, 24), new C3919s(19, 25));
        c3920tArr[3] = new C3920t(30, new C3919s(11, 15), new C3919s(46, 16));
        r0[32] = new C3918r(33, iArr, c3920tArr);
        iArr = new int[]{6, 34, 62, 90, 118, 146};
        c3920tArr = new C3920t[4];
        c3920tArr[0] = new C3920t(30, new C3919s(13, 115), new C3919s(6, SpecialIssueType.BUG_TYPE_ID_CHARGE));
        c3920tArr[1] = new C3920t(28, new C3919s(14, 46), new C3919s(23, 47));
        c3920tArr[2] = new C3920t(30, new C3919s(44, 24), new C3919s(7, 25));
        c3920tArr[3] = new C3920t(30, new C3919s(59, 16), new C3919s(1, 17));
        r0[33] = new C3918r(34, iArr, c3920tArr);
        iArr = new int[]{6, 30, 54, 78, 102, TransportMediator.KEYCODE_MEDIA_PLAY, 150};
        c3920tArr = new C3920t[4];
        c3920tArr[0] = new C3920t(30, new C3919s(12, 121), new C3919s(7, 122));
        c3920tArr[1] = new C3920t(28, new C3919s(12, 47), new C3919s(26, 48));
        c3920tArr[2] = new C3920t(30, new C3919s(39, 24), new C3919s(14, 25));
        c3920tArr[3] = new C3920t(30, new C3919s(22, 15), new C3919s(41, 16));
        r0[34] = new C3918r(35, iArr, c3920tArr);
        iArr = new int[]{6, 24, 50, 76, 102, 128, 154};
        c3920tArr = new C3920t[4];
        c3920tArr[0] = new C3920t(30, new C3919s(6, 121), new C3919s(14, 122));
        c3920tArr[1] = new C3920t(28, new C3919s(6, 47), new C3919s(34, 48));
        c3920tArr[2] = new C3920t(30, new C3919s(46, 24), new C3919s(10, 25));
        c3920tArr[3] = new C3920t(30, new C3919s(2, 15), new C3919s(64, 16));
        r0[35] = new C3918r(36, iArr, c3920tArr);
        iArr = new int[]{6, 28, 54, 80, 106, 132, 158};
        c3920tArr = new C3920t[4];
        c3920tArr[0] = new C3920t(30, new C3919s(17, 122), new C3919s(4, ReportInfoUtils.FEEDBACK_SUCCESS));
        c3920tArr[1] = new C3920t(28, new C3919s(29, 46), new C3919s(14, 47));
        c3920tArr[2] = new C3920t(30, new C3919s(49, 24), new C3919s(10, 25));
        c3920tArr[3] = new C3920t(30, new C3919s(24, 15), new C3919s(46, 16));
        r0[36] = new C3918r(37, iArr, c3920tArr);
        iArr = new int[]{6, 32, 58, 84, 110, SyslogAppender.LOG_LOCAL1, 162};
        c3920tArr = new C3920t[4];
        c3920tArr[0] = new C3920t(30, new C3919s(4, 122), new C3919s(18, ReportInfoUtils.FEEDBACK_SUCCESS));
        c3920tArr[1] = new C3920t(28, new C3919s(13, 46), new C3919s(32, 47));
        c3920tArr[2] = new C3920t(30, new C3919s(48, 24), new C3919s(14, 25));
        c3920tArr[3] = new C3920t(30, new C3919s(42, 15), new C3919s(32, 16));
        r0[37] = new C3918r(38, iArr, c3920tArr);
        iArr = new int[]{6, 26, 54, 82, 110, 138, 166};
        c3920tArr = new C3920t[4];
        c3920tArr[0] = new C3920t(30, new C3919s(20, 117), new C3919s(4, 118));
        c3920tArr[1] = new C3920t(28, new C3919s(40, 47), new C3919s(7, 48));
        c3920tArr[2] = new C3920t(30, new C3919s(43, 24), new C3919s(22, 25));
        c3920tArr[3] = new C3920t(30, new C3919s(10, 15), new C3919s(67, 16));
        r0[38] = new C3918r(39, iArr, c3920tArr);
        iArr = new int[]{6, 30, 58, 86, 114, 142, HiUserInfo.HEIGHT_DEFAULT};
        c3920tArr = new C3920t[4];
        c3920tArr[0] = new C3920t(30, new C3919s(19, 118), new C3919s(6, TagName.ELECTRONIC_USE_COUNT));
        c3920tArr[1] = new C3920t(28, new C3919s(18, 47), new C3919s(31, 48));
        c3920tArr[2] = new C3920t(30, new C3919s(34, 24), new C3919s(34, 25));
        c3920tArr[3] = new C3920t(30, new C3919s(20, 15), new C3919s(61, 16));
        r0[39] = new C3918r(40, iArr, c3920tArr);
        return r0;
    }
}
