package com.google.zxing.p295e.p296a.p297a;

import android.support.v4.media.TransportMediator;
import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import com.android.volley.DefaultRetryPolicy;
import com.google.zxing.C3709a;
import com.google.zxing.C3880e;
import com.google.zxing.C3900f;
import com.google.zxing.C3922o;
import com.google.zxing.C3932i;
import com.google.zxing.C3934m;
import com.google.zxing.p278b.C3712a;
import com.google.zxing.p295e.C3856k;
import com.google.zxing.p295e.p296a.C3857a;
import com.google.zxing.p295e.p296a.C3859b;
import com.google.zxing.p295e.p296a.C3860c;
import com.google.zxing.p295e.p296a.C3863f;
import com.google.zxing.p295e.p296a.p297a.p298a.C3833j;
import com.huawei.crowdtestsdk.common.SpecialIssueType;
import com.huawei.crowdtestsdk.report.ReportInfoUtils;
import com.huawei.hihealth.HiUserInfo;
import com.huawei.nfc.carrera.logic.appletcardinfo.result.AppletCardResult;
import com.huawei.nfc.carrera.ui.NFCBaseActivity;
import com.snowballtech.business.constant.BusinessCode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.log4j.net.SyslogAppender;

/* compiled from: RSSExpandedReader */
public final class C3858d extends C3857a {
    private static final int[] f14891a = new int[]{7, 5, 4, 3, 1};
    private static final int[] f14892b = new int[]{4, 20, 52, 104, 204};
    private static final int[] f14893c;
    private static final int[][] f14894d = new int[][]{new int[]{1, 8, 4, 1}, new int[]{3, 6, 4, 1}, new int[]{3, 4, 6, 1}, new int[]{3, 2, 8, 1}, new int[]{2, 6, 5, 1}, new int[]{2, 2, 9, 1}};
    private static final int[][] f14895e = new int[][]{new int[]{1, 3, 9, 27, 81, 32, 96, 77}, new int[]{20, 60, 180, 118, 143, 7, 21, 63}, new int[]{189, 145, 13, 39, 117, 140, 209, 205}, new int[]{193, 157, 49, 147, 19, 57, 171, 91}, new int[]{62, 186, SyslogAppender.LOG_LOCAL1, 197, 169, 85, 44, 132}, new int[]{185, 133, 188, 142, 4, 12, 36, 108}, new int[]{113, 128, 173, 97, 80, 29, 87, 50}, new int[]{150, 28, 84, 41, ReportInfoUtils.FEEDBACK_SUCCESS, 158, 52, BusinessCode.CURRENCY_CODE_RMB}, new int[]{46, 138, 203, 187, 139, 206, 196, 166}, new int[]{76, 17, 51, 153, 37, 111, 122, 155}, new int[]{43, 129, SyslogAppender.LOG_LOCAL6, 106, 107, 110, TagName.ELECTRONIC_USE_COUNT, 146}, new int[]{16, 48, SyslogAppender.LOG_LOCAL2, 10, 30, 90, 59, 177}, new int[]{109, SpecialIssueType.BUG_TYPE_ID_CHARGE, 137, 200, 178, 112, 125, 164}, new int[]{70, 210, AppletCardResult.RESULT_FAILED_TRAFFIC_CARD_INFO_PIN_LOCKED, 202, SyslogAppender.LOG_LOCAL7, TransportMediator.KEYCODE_MEDIA_RECORD, 179, 115}, new int[]{134, 191, 151, 31, 93, 68, 204, 190}, new int[]{148, 22, 66, 198, 172, 94, 71, 2}, new int[]{6, 18, 54, 162, 64, 192, 154, 40}, new int[]{120, 149, 25, 75, 14, 42, TransportMediator.KEYCODE_MEDIA_PLAY, 167}, new int[]{79, 26, 78, 23, 69, 207, 199, 175}, new int[]{103, 98, 83, 38, 114, 131, 182, ReportInfoUtils.FEEDBACK_FAILED}, new int[]{161, 61, 183, 127, HiUserInfo.HEIGHT_DEFAULT, 88, 53, 159}, new int[]{55, 165, 73, 8, 24, 72, 5, 15}, new int[]{45, 135, 194, SyslogAppender.LOG_LOCAL4, 58, 174, 100, 89}};
    private static final int[][] f14896f;
    private final List<C3854b> f14897g = new ArrayList(11);
    private final List<C3855c> f14898h = new ArrayList();
    private final int[] f14899i = new int[2];
    private boolean f14900j = false;

    static {
        int[] iArr = new int[5];
        iArr[1] = 348;
        iArr[2] = 1388;
        iArr[3] = 2948;
        iArr[4] = 3988;
        f14893c = iArr;
        r0 = new int[10][];
        int[] iArr2 = new int[]{1, 1, iArr2};
        iArr2 = new int[]{2, 1, 3, iArr2};
        iArr2 = new int[]{4, 1, 3, 2, iArr2};
        iArr2 = new int[]{4, 1, 3, 3, 5, iArr2};
        int[] iArr3 = new int[]{4, 1, 3, 4, 5, 5, iArr3};
        iArr3 = new int[8];
        iArr3[2] = 1;
        iArr3[3] = 1;
        iArr3[4] = 2;
        iArr3[5] = 2;
        iArr3[6] = 3;
        iArr3[7] = 3;
        r0[6] = iArr3;
        iArr3 = new int[9];
        iArr3[2] = 1;
        iArr3[3] = 1;
        iArr3[4] = 2;
        iArr3[5] = 2;
        iArr3[6] = 3;
        iArr3[7] = 4;
        iArr3[8] = 4;
        r0[7] = iArr3;
        iArr2 = new int[10];
        iArr2[2] = 1;
        iArr2[3] = 1;
        iArr2[4] = 2;
        iArr2[5] = 2;
        iArr2[6] = 3;
        iArr2[7] = 4;
        iArr2[8] = 5;
        iArr2[9] = 5;
        r0[8] = iArr2;
        iArr3 = new int[11];
        iArr3[2] = 1;
        iArr3[3] = 1;
        iArr3[4] = 2;
        iArr3[5] = 3;
        iArr3[6] = 3;
        iArr3[7] = 4;
        iArr3[8] = 4;
        iArr3[9] = 5;
        iArr3[10] = 5;
        r0[9] = iArr3;
        f14896f = r0;
    }

    public C3934m mo4321a(int i, C3712a c3712a, Map<C3880e, ?> map) throws C3932i, C3900f {
        this.f14897g.clear();
        this.f14900j = false;
        try {
            return C3858d.m19202a(m19217a(i, c3712a));
        } catch (C3932i e) {
            this.f14897g.clear();
            this.f14900j = true;
            return C3858d.m19202a(m19217a(i, c3712a));
        }
    }

    public void mo4302a() {
        this.f14897g.clear();
        this.f14898h.clear();
    }

    List<C3854b> m19217a(int i, C3712a c3712a) throws C3932i {
        while (true) {
            try {
                this.f14897g.add(m19214a(c3712a, this.f14897g, i));
            } catch (C3932i e) {
                if (this.f14897g.isEmpty()) {
                    throw e;
                } else if (m19213h()) {
                    return this.f14897g;
                } else {
                    boolean z = !this.f14898h.isEmpty();
                    m19206a(i, false);
                    if (z) {
                        List<C3854b> a = m19204a(false);
                        if (a != null) {
                            return a;
                        }
                        a = m19204a(true);
                        if (a != null) {
                            return a;
                        }
                    }
                    throw C3932i.m19565a();
                }
            }
        }
    }

    private List<C3854b> m19204a(boolean z) {
        List<C3854b> list = null;
        if (this.f14898h.size() > 25) {
            this.f14898h.clear();
        } else {
            this.f14897g.clear();
            if (z) {
                Collections.reverse(this.f14898h);
            }
            try {
                list = m19203a(new ArrayList(), 0);
            } catch (C3932i e) {
            }
            if (z) {
                Collections.reverse(this.f14898h);
            }
        }
        return list;
    }

    private List<C3854b> m19203a(List<C3855c> list, int i) throws C3932i {
        while (i < this.f14898h.size()) {
            C3855c c3855c = (C3855c) this.f14898h.get(i);
            this.f14897g.clear();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f14897g.addAll(((C3855c) list.get(i2)).m19179a());
            }
            this.f14897g.addAll(c3855c.m19179a());
            if (C3858d.m19211b(this.f14897g)) {
                if (m19213h()) {
                    return this.f14897g;
                }
                List arrayList = new ArrayList();
                arrayList.addAll(list);
                arrayList.add(c3855c);
                try {
                    return m19203a(arrayList, i + 1);
                } catch (C3932i e) {
                }
            }
            i++;
        }
        throw C3932i.m19565a();
    }

    private static boolean m19211b(List<C3854b> list) {
        for (int[] iArr : f14896f) {
            if (list.size() <= iArr.length) {
                boolean z;
                for (int i = 0; i < list.size(); i++) {
                    if (((C3854b) list.get(i)).m19177c().m19221a() != iArr[i]) {
                        z = false;
                        break;
                    }
                }
                z = true;
                if (z) {
                    return true;
                }
            }
        }
        return false;
    }

    private void m19206a(int i, boolean z) {
        boolean z2 = false;
        boolean z3 = false;
        int i2 = 0;
        while (i2 < this.f14898h.size()) {
            C3855c c3855c = (C3855c) this.f14898h.get(i2);
            if (c3855c.m19181b() > i) {
                z2 = c3855c.m19180a(this.f14897g);
                break;
            }
            i2++;
            z3 = c3855c.m19180a(this.f14897g);
        }
        if (!z2 && !r1 && !C3858d.m19209a(this.f14897g, this.f14898h)) {
            this.f14898h.add(i2, new C3855c(this.f14897g, i, z));
            C3858d.m19207a(this.f14897g, this.f14898h);
        }
    }

    private static void m19207a(List<C3854b> list, List<C3855c> list2) {
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            C3855c c3855c = (C3855c) it.next();
            if (c3855c.m19179a().size() != list.size()) {
                Object obj;
                for (C3854b c3854b : c3855c.m19179a()) {
                    for (C3854b equals : list) {
                        if (c3854b.equals(equals)) {
                            int i = 1;
                            continue;
                            break;
                        }
                    }
                    obj = null;
                    continue;
                    if (obj == null) {
                        obj = null;
                        break;
                    }
                }
                obj = 1;
                if (obj != null) {
                    it.remove();
                }
            }
        }
    }

    private static boolean m19209a(Iterable<C3854b> iterable, Iterable<C3855c> iterable2) {
        for (C3855c c3855c : iterable2) {
            Object obj;
            for (C3854b c3854b : iterable) {
                for (C3854b equals : c3855c.m19179a()) {
                    if (c3854b.equals(equals)) {
                        int i = 1;
                        continue;
                        break;
                    }
                }
                Object obj2 = null;
                continue;
                if (obj2 == null) {
                    obj = null;
                    continue;
                    break;
                }
            }
            obj = 1;
            continue;
            if (obj != null) {
                return true;
            }
        }
        return false;
    }

    static C3934m m19202a(List<C3854b> list) throws C3932i, C3900f {
        String a = C3833j.m19109a(C3853a.m19172a(list)).mo4319a();
        C3922o[] c = ((C3854b) list.get(0)).m19177c().m19223c();
        C3922o[] c2 = ((C3854b) list.get(list.size() - 1)).m19177c().m19223c();
        return new C3934m(a, null, new C3922o[]{c[0], c[1], c2[0], c2[1]}, C3709a.RSS_EXPANDED);
    }

    private boolean m19213h() {
        C3854b c3854b = (C3854b) this.f14897g.get(0);
        C3859b a = c3854b.m19175a();
        C3859b b = c3854b.m19176b();
        if (b == null) {
            return false;
        }
        int i = 2;
        int b2 = b.m19220b();
        for (int i2 = 1; i2 < this.f14897g.size(); i2++) {
            c3854b = (C3854b) this.f14897g.get(i2);
            b2 += c3854b.m19175a().m19220b();
            i++;
            b = c3854b.m19176b();
            if (b != null) {
                b2 += b.m19220b();
                i++;
            }
        }
        if ((b2 % 211) + ((i - 4) * 211) != a.m19219a()) {
            return false;
        }
        return true;
    }

    private static int m19200a(C3712a c3712a, int i) {
        if (c3712a.m18678a(i)) {
            return c3712a.m18682c(c3712a.m18684d(i));
        }
        return c3712a.m18684d(c3712a.m18682c(i));
    }

    C3854b m19214a(C3712a c3712a, List<C3854b> list, int i) throws C3932i {
        boolean z;
        C3860c a;
        boolean z2 = list.size() % 2 == 0;
        if (this.f14900j) {
            if (z2) {
                z2 = false;
            } else {
                z2 = true;
            }
            z = z2;
        } else {
            z = z2;
        }
        int i2 = -1;
        boolean z3 = true;
        do {
            m19210b(c3712a, list, i2);
            a = m19201a(c3712a, i, z);
            if (a == null) {
                i2 = C3858d.m19200a(c3712a, this.f14899i[0]);
                continue;
            } else {
                z3 = false;
                continue;
            }
        } while (z3);
        C3859b a2 = m19215a(c3712a, a, z, true);
        if (list.isEmpty() || !((C3854b) list.get(list.size() - 1)).m19178d()) {
            C3859b a3;
            try {
                a3 = m19215a(c3712a, a, z, false);
            } catch (C3932i e) {
                a3 = null;
            }
            return new C3854b(a2, a3, a, true);
        }
        throw C3932i.m19565a();
    }

    private void m19210b(C3712a c3712a, List<C3854b> list, int i) throws C3932i {
        int[] b = m19194b();
        b[0] = 0;
        b[1] = 0;
        b[2] = 0;
        b[3] = 0;
        int a = c3712a.m18676a();
        if (i < 0) {
            if (list.isEmpty()) {
                i = 0;
            } else {
                i = ((C3854b) list.get(list.size() - 1)).m19177c().m19222b()[1];
            }
        }
        Object obj = list.size() % 2 != 0 ? 1 : null;
        if (this.f14900j) {
            obj = obj != null ? null : 1;
        }
        int i2 = 0;
        int i3 = i;
        while (i3 < a) {
            i2 = c3712a.m18678a(i3) ? 0 : 1;
            if (i2 == 0) {
                break;
            }
            i3++;
        }
        int i4 = i3;
        i3 = 0;
        int i5 = i2;
        i2 = i4;
        for (int i6 = i3; i6 < a; i6++) {
            if ((c3712a.m18678a(i6) ^ i5) != 0) {
                b[i3] = b[i3] + 1;
            } else {
                if (i3 == 3) {
                    if (obj != null) {
                        C3858d.m19212c(b);
                    }
                    if (C3857a.m19193b(b)) {
                        this.f14899i[0] = i2;
                        this.f14899i[1] = i6;
                        return;
                    }
                    if (obj != null) {
                        C3858d.m19212c(b);
                    }
                    i2 += b[0] + b[1];
                    b[0] = b[2];
                    b[1] = b[3];
                    b[2] = 0;
                    b[3] = 0;
                    i3--;
                } else {
                    i3++;
                }
                b[i3] = 1;
                i5 = i5 != 0 ? 0 : 1;
            }
        }
        throw C3932i.m19565a();
    }

    private static void m19212c(int[] iArr) {
        int length = iArr.length;
        for (int i = 0; i < length / 2; i++) {
            int i2 = iArr[i];
            iArr[i] = iArr[(length - i) - 1];
            iArr[(length - i) - 1] = i2;
        }
    }

    private C3860c m19201a(C3712a c3712a, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        if (z) {
            i2 = this.f14899i[0] - 1;
            while (i2 >= 0 && !c3712a.m18678a(i2)) {
                i2--;
            }
            i3 = i2 + 1;
            i2 = this.f14899i[0] - i3;
            i4 = this.f14899i[1];
        } else {
            i3 = this.f14899i[0];
            i4 = c3712a.m18684d(this.f14899i[1] + 1);
            i2 = i4 - this.f14899i[1];
        }
        Object b = m19194b();
        System.arraycopy(b, 0, b, 1, b.length - 1);
        b[0] = i2;
        try {
            return new C3860c(C3857a.m19190a((int[]) b, f14894d), new int[]{i3, i4}, i3, i4, i);
        } catch (C3932i e) {
            return null;
        }
    }

    C3859b m19215a(C3712a c3712a, C3860c c3860c, boolean z, boolean z2) throws C3932i {
        int i;
        int length;
        int[] c = m19195c();
        c[0] = 0;
        c[1] = 0;
        c[2] = 0;
        c[3] = 0;
        c[4] = 0;
        c[5] = 0;
        c[6] = 0;
        c[7] = 0;
        if (z2) {
            C3856k.m19185b(c3712a, c3860c.m19222b()[0], c);
        } else {
            C3856k.m19183a(c3712a, c3860c.m19222b()[1], c);
            i = 0;
            for (length = c.length - 1; i < length; length--) {
                int i2 = c[i];
                c[i] = c[length];
                c[length] = i2;
                i++;
            }
        }
        float a = ((float) C3857a.m19189a(c)) / ((float) 17);
        float f = ((float) (c3860c.m19222b()[1] - c3860c.m19222b()[0])) / 15.0f;
        if (Math.abs(a - f) / f > NFCBaseActivity.PERCENT_MARGIN_30) {
            throw C3932i.m19565a();
        }
        int length2;
        int[] f2 = m19198f();
        int[] g = m19199g();
        float[] d = m19196d();
        float[] e = m19197e();
        for (length = 0; length < c.length; length++) {
            float f3 = (DefaultRetryPolicy.DEFAULT_BACKOFF_MULT * ((float) c[length])) / a;
            i = (int) (0.5f + f3);
            if (i < 1) {
                if (f3 < NFCBaseActivity.PERCENT_MARGIN_30) {
                    throw C3932i.m19565a();
                }
                i = 1;
            } else if (i > 8) {
                if (f3 > 8.7f) {
                    throw C3932i.m19565a();
                }
                i = 8;
            }
            int i3 = length >> 1;
            if ((length & 1) == 0) {
                f2[i3] = i;
                d[i3] = f3 - ((float) i);
            } else {
                g[i3] = i;
                e[i3] = f3 - ((float) i);
            }
        }
        m19205a(17);
        int a2 = ((z2 ? 0 : 1) + ((c3860c.m19221a() * 4) + (z ? 0 : 2))) - 1;
        i2 = 0;
        i = f2.length - 1;
        length = 0;
        while (i >= 0) {
            if (C3858d.m19208a(c3860c, z, z2)) {
                length += f14895e[a2][i * 2] * f2[i];
            }
            i--;
            i2 = f2[i] + i2;
        }
        i = 0;
        for (length2 = g.length - 1; length2 >= 0; length2--) {
            if (C3858d.m19208a(c3860c, z, z2)) {
                i += f14895e[a2][(length2 * 2) + 1] * g[length2];
            }
        }
        length += i;
        if ((i2 & 1) != 0 || i2 > 13 || i2 < 4) {
            throw C3932i.m19565a();
        }
        i = (13 - i2) / 2;
        length2 = f14891a[i];
        return new C3859b(f14893c[i] + ((C3863f.m19238a(f2, length2, true) * f14892b[i]) + C3863f.m19238a(g, 9 - length2, false)), length);
    }

    private static boolean m19208a(C3860c c3860c, boolean z, boolean z2) {
        return (c3860c.m19221a() == 0 && z && z2) ? false : true;
    }

    private void m19205a(int i) throws C3932i {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5 = null;
        Object obj6 = 1;
        int a = C3857a.m19189a(m19198f());
        int a2 = C3857a.m19189a(m19199g());
        int i2 = (a + a2) - i;
        Object obj7 = (a & 1) == 1 ? 1 : null;
        if ((a2 & 1) == 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (a > 13) {
            obj2 = 1;
            obj3 = null;
        } else if (a < 4) {
            obj2 = null;
            int i3 = 1;
        } else {
            obj2 = null;
            obj3 = null;
        }
        if (a2 > 13) {
            obj4 = null;
            obj5 = 1;
        } else if (a2 < 4) {
            int i4 = 1;
        } else {
            obj4 = null;
        }
        int i5;
        if (i2 == 1) {
            if (obj7 != null) {
                if (obj != null) {
                    throw C3932i.m19565a();
                }
                obj2 = obj3;
                obj6 = obj4;
                obj4 = 1;
            } else if (obj == null) {
                throw C3932i.m19565a();
            } else {
                i5 = 1;
                obj6 = obj4;
                obj4 = obj2;
                obj2 = obj3;
            }
        } else if (i2 == -1) {
            if (obj7 != null) {
                if (obj != null) {
                    throw C3932i.m19565a();
                }
                r12 = obj4;
                obj4 = obj2;
                r3 = 1;
                obj6 = r12;
            } else if (obj == null) {
                throw C3932i.m19565a();
            } else {
                obj4 = obj2;
                obj2 = obj3;
            }
        } else if (i2 != 0) {
            throw C3932i.m19565a();
        } else if (obj7 != null) {
            if (obj == null) {
                throw C3932i.m19565a();
            } else if (a < a2) {
                i5 = 1;
                r12 = obj4;
                obj4 = obj2;
                r3 = 1;
                obj6 = r12;
            } else {
                i4 = 1;
                obj2 = obj3;
            }
        } else if (obj != null) {
            throw C3932i.m19565a();
        } else {
            obj6 = obj4;
            obj4 = obj2;
            obj2 = obj3;
        }
        if (obj2 != null) {
            if (obj4 != null) {
                throw C3932i.m19565a();
            }
            C3857a.m19191a(m19198f(), m19196d());
        }
        if (obj4 != null) {
            C3857a.m19192b(m19198f(), m19196d());
        }
        if (obj6 != null) {
            if (obj5 != null) {
                throw C3932i.m19565a();
            }
            C3857a.m19191a(m19199g(), m19196d());
        }
        if (obj5 != null) {
            C3857a.m19192b(m19199g(), m19197e());
        }
    }
}
