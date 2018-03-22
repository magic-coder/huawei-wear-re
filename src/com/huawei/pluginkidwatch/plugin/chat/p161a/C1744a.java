package com.huawei.pluginkidwatch.plugin.chat.p161a;

import android.graphics.Bitmap;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.common.p138a.ab;

/* compiled from: ChatModal */
public class C1744a implements Comparable<C1744a> {
    public Integer f4766a;
    public String f4767b;
    public boolean f4768c;
    public String f4769d;
    public String f4770e;
    public boolean f4771f;
    public int f4772g;
    public Integer f4773h;
    public boolean f4774i;
    public String f4775j;
    public boolean f4776k;
    public String f4777l;
    public String f4778m;
    public Bitmap f4779n;
    public String f4780o;
    public String f4781p;
    public String f4782q;
    public String f4783r;
    public String f4784s;
    public String f4785t;
    public boolean f4786u;
    public boolean f4787v;

    public /* synthetic */ int compareTo(Object obj) {
        return m8469a((C1744a) obj);
    }

    private C1744a() {
        this.f4777l = "";
        this.f4778m = "";
        this.f4779n = null;
        this.f4780o = "";
        this.f4781p = "";
        this.f4782q = "";
        this.f4783r = "";
        this.f4784s = "";
        this.f4785t = "";
        this.f4786u = false;
        this.f4787v = false;
        this.f4766a = Integer.valueOf(0);
        this.f4767b = "";
        this.f4768c = false;
        this.f4769d = "";
        this.f4772g = 0;
        this.f4770e = "";
        this.f4773h = Integer.valueOf(0);
        this.f4771f = false;
        this.f4774i = false;
        this.f4775j = "";
        this.f4776k = false;
        this.f4777l = "";
        this.f4778m = "";
        this.f4780o = "";
        this.f4781p = "";
        this.f4782q = "";
        this.f4783r = "";
        this.f4784s = "";
        this.f4785t = "";
        this.f4786u = false;
        this.f4787v = false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.Integer m8468a(java.lang.String r13) {
        /*
        r12 = this;
        r4 = 1;
        r3 = 0;
        if (r13 != 0) goto L_0x0014;
    L_0x0004:
        r0 = "ChatModal";
        r1 = new java.lang.Object[r4];
        r2 = "==========null == path";
        r1[r3] = r2;
        com.huawei.p190v.C2538c.m12674b(r0, r1);
        r0 = java.lang.Integer.valueOf(r3);
    L_0x0013:
        return r0;
    L_0x0014:
        r5 = new android.media.MediaPlayer;
        r5.<init>();
        r2 = 0;
        r5.reset();	 Catch:{ IllegalArgumentException -> 0x0094, SecurityException -> 0x00e1, IllegalStateException -> 0x0130, IOException -> 0x017f }
        r0 = new java.io.File;	 Catch:{ IllegalArgumentException -> 0x0094, SecurityException -> 0x00e1, IllegalStateException -> 0x0130, IOException -> 0x017f }
        r0.<init>(r13);	 Catch:{ IllegalArgumentException -> 0x0094, SecurityException -> 0x00e1, IllegalStateException -> 0x0130, IOException -> 0x017f }
        r1 = r0.exists();	 Catch:{ IllegalArgumentException -> 0x0094, SecurityException -> 0x00e1, IllegalStateException -> 0x0130, IOException -> 0x017f }
        if (r1 == 0) goto L_0x022d;
    L_0x0028:
        r1 = new java.io.FileInputStream;	 Catch:{ IllegalArgumentException -> 0x0094, SecurityException -> 0x00e1, IllegalStateException -> 0x0130, IOException -> 0x017f }
        r1.<init>(r0);	 Catch:{ IllegalArgumentException -> 0x0094, SecurityException -> 0x00e1, IllegalStateException -> 0x0130, IOException -> 0x017f }
        r0 = r1.getFD();	 Catch:{ IllegalArgumentException -> 0x0220, SecurityException -> 0x0213, IllegalStateException -> 0x0206, IOException -> 0x01fa, all -> 0x01f7 }
        r5.setDataSource(r0);	 Catch:{ IllegalArgumentException -> 0x0220, SecurityException -> 0x0213, IllegalStateException -> 0x0206, IOException -> 0x01fa, all -> 0x01f7 }
        r5.prepare();	 Catch:{ IllegalArgumentException -> 0x0220, SecurityException -> 0x0213, IllegalStateException -> 0x0206, IOException -> 0x01fa, all -> 0x01f7 }
        r2 = r5.getDuration();	 Catch:{ IllegalArgumentException -> 0x0220, SecurityException -> 0x0213, IllegalStateException -> 0x0206, IOException -> 0x01fa, all -> 0x01f7 }
        r0 = "ChatModal";
        r6 = 1;
        r6 = new java.lang.Object[r6];	 Catch:{ IllegalArgumentException -> 0x0226, SecurityException -> 0x0219, IllegalStateException -> 0x020c, IOException -> 0x01ff, all -> 0x01f7 }
        r7 = 0;
        r8 = new java.lang.StringBuilder;	 Catch:{ IllegalArgumentException -> 0x0226, SecurityException -> 0x0219, IllegalStateException -> 0x020c, IOException -> 0x01ff, all -> 0x01f7 }
        r8.<init>();	 Catch:{ IllegalArgumentException -> 0x0226, SecurityException -> 0x0219, IllegalStateException -> 0x020c, IOException -> 0x01ff, all -> 0x01f7 }
        r9 = "getDuration:";
        r8 = r8.append(r9);	 Catch:{ IllegalArgumentException -> 0x0226, SecurityException -> 0x0219, IllegalStateException -> 0x020c, IOException -> 0x01ff, all -> 0x01f7 }
        r8 = r8.append(r2);	 Catch:{ IllegalArgumentException -> 0x0226, SecurityException -> 0x0219, IllegalStateException -> 0x020c, IOException -> 0x01ff, all -> 0x01f7 }
        r8 = r8.toString();	 Catch:{ IllegalArgumentException -> 0x0226, SecurityException -> 0x0219, IllegalStateException -> 0x020c, IOException -> 0x01ff, all -> 0x01f7 }
        r6[r7] = r8;	 Catch:{ IllegalArgumentException -> 0x0226, SecurityException -> 0x0219, IllegalStateException -> 0x020c, IOException -> 0x01ff, all -> 0x01f7 }
        com.huawei.p190v.C2538c.m12674b(r0, r6);	 Catch:{ IllegalArgumentException -> 0x0226, SecurityException -> 0x0219, IllegalStateException -> 0x020c, IOException -> 0x01ff, all -> 0x01f7 }
        r0 = 9500; // 0x251c float:1.3312E-41 double:4.6936E-320;
        if (r2 <= r0) goto L_0x006f;
    L_0x005d:
        r0 = 10;
    L_0x005f:
        if (r0 >= r4) goto L_0x0062;
    L_0x0061:
        r0 = r4;
    L_0x0062:
        if (r1 == 0) goto L_0x0067;
    L_0x0064:
        r1.close();	 Catch:{ IOException -> 0x0072 }
    L_0x0067:
        r5.release();
        r0 = java.lang.Integer.valueOf(r0);
        goto L_0x0013;
    L_0x006f:
        r0 = r2 / 1000;
        goto L_0x005f;
    L_0x0072:
        r1 = move-exception;
        r2 = "ChatModal";
        r4 = new java.lang.Object[r4];
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r7 = "==========fis.close() error!!! ";
        r6 = r6.append(r7);
        r1 = r1.getMessage();
        r1 = r6.append(r1);
        r1 = r1.toString();
        r4[r3] = r1;
        com.huawei.p190v.C2538c.m12674b(r2, r4);
        goto L_0x0067;
    L_0x0094:
        r0 = move-exception;
        r1 = r0;
        r0 = r3;
    L_0x0097:
        r6 = "ChatModal";
        r7 = 1;
        r7 = new java.lang.Object[r7];	 Catch:{ all -> 0x01ce }
        r8 = 0;
        r9 = new java.lang.StringBuilder;	 Catch:{ all -> 0x01ce }
        r9.<init>();	 Catch:{ all -> 0x01ce }
        r10 = "====IllegalArgumentException=====error:";
        r9 = r9.append(r10);	 Catch:{ all -> 0x01ce }
        r1 = r1.getMessage();	 Catch:{ all -> 0x01ce }
        r1 = r9.append(r1);	 Catch:{ all -> 0x01ce }
        r1 = r1.toString();	 Catch:{ all -> 0x01ce }
        r7[r8] = r1;	 Catch:{ all -> 0x01ce }
        com.huawei.p190v.C2538c.m12674b(r6, r7);	 Catch:{ all -> 0x01ce }
        if (r2 == 0) goto L_0x0067;
    L_0x00bb:
        r2.close();	 Catch:{ IOException -> 0x00bf }
        goto L_0x0067;
    L_0x00bf:
        r1 = move-exception;
        r2 = "ChatModal";
        r4 = new java.lang.Object[r4];
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r7 = "==========fis.close() error!!! ";
        r6 = r6.append(r7);
        r1 = r1.getMessage();
        r1 = r6.append(r1);
        r1 = r1.toString();
        r4[r3] = r1;
        com.huawei.p190v.C2538c.m12674b(r2, r4);
        goto L_0x0067;
    L_0x00e1:
        r0 = move-exception;
        r1 = r0;
        r0 = r3;
    L_0x00e4:
        r6 = "ChatModal";
        r7 = 1;
        r7 = new java.lang.Object[r7];	 Catch:{ all -> 0x01ce }
        r8 = 0;
        r9 = new java.lang.StringBuilder;	 Catch:{ all -> 0x01ce }
        r9.<init>();	 Catch:{ all -> 0x01ce }
        r10 = "====SecurityException=====error:";
        r9 = r9.append(r10);	 Catch:{ all -> 0x01ce }
        r1 = r1.getMessage();	 Catch:{ all -> 0x01ce }
        r1 = r9.append(r1);	 Catch:{ all -> 0x01ce }
        r1 = r1.toString();	 Catch:{ all -> 0x01ce }
        r7[r8] = r1;	 Catch:{ all -> 0x01ce }
        com.huawei.p190v.C2538c.m12674b(r6, r7);	 Catch:{ all -> 0x01ce }
        if (r2 == 0) goto L_0x0067;
    L_0x0108:
        r2.close();	 Catch:{ IOException -> 0x010d }
        goto L_0x0067;
    L_0x010d:
        r1 = move-exception;
        r2 = "ChatModal";
        r4 = new java.lang.Object[r4];
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r7 = "==========fis.close() error!!! ";
        r6 = r6.append(r7);
        r1 = r1.getMessage();
        r1 = r6.append(r1);
        r1 = r1.toString();
        r4[r3] = r1;
        com.huawei.p190v.C2538c.m12674b(r2, r4);
        goto L_0x0067;
    L_0x0130:
        r0 = move-exception;
        r1 = r0;
        r0 = r3;
    L_0x0133:
        r6 = "ChatModal";
        r7 = 1;
        r7 = new java.lang.Object[r7];	 Catch:{ all -> 0x01ce }
        r8 = 0;
        r9 = new java.lang.StringBuilder;	 Catch:{ all -> 0x01ce }
        r9.<init>();	 Catch:{ all -> 0x01ce }
        r10 = "====IllegalStateException=====error:";
        r9 = r9.append(r10);	 Catch:{ all -> 0x01ce }
        r1 = r1.getMessage();	 Catch:{ all -> 0x01ce }
        r1 = r9.append(r1);	 Catch:{ all -> 0x01ce }
        r1 = r1.toString();	 Catch:{ all -> 0x01ce }
        r7[r8] = r1;	 Catch:{ all -> 0x01ce }
        com.huawei.p190v.C2538c.m12674b(r6, r7);	 Catch:{ all -> 0x01ce }
        if (r2 == 0) goto L_0x0067;
    L_0x0157:
        r2.close();	 Catch:{ IOException -> 0x015c }
        goto L_0x0067;
    L_0x015c:
        r1 = move-exception;
        r2 = "ChatModal";
        r4 = new java.lang.Object[r4];
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r7 = "==========fis.close() error!!! ";
        r6 = r6.append(r7);
        r1 = r1.getMessage();
        r1 = r6.append(r1);
        r1 = r1.toString();
        r4[r3] = r1;
        com.huawei.p190v.C2538c.m12674b(r2, r4);
        goto L_0x0067;
    L_0x017f:
        r0 = move-exception;
        r1 = r0;
        r0 = r3;
    L_0x0182:
        r6 = "ChatModal";
        r7 = 1;
        r7 = new java.lang.Object[r7];	 Catch:{ all -> 0x01ce }
        r8 = 0;
        r9 = new java.lang.StringBuilder;	 Catch:{ all -> 0x01ce }
        r9.<init>();	 Catch:{ all -> 0x01ce }
        r10 = "====IOException=====error:";
        r9 = r9.append(r10);	 Catch:{ all -> 0x01ce }
        r1 = r1.getMessage();	 Catch:{ all -> 0x01ce }
        r1 = r9.append(r1);	 Catch:{ all -> 0x01ce }
        r1 = r1.toString();	 Catch:{ all -> 0x01ce }
        r7[r8] = r1;	 Catch:{ all -> 0x01ce }
        com.huawei.p190v.C2538c.m12674b(r6, r7);	 Catch:{ all -> 0x01ce }
        if (r2 == 0) goto L_0x0067;
    L_0x01a6:
        r2.close();	 Catch:{ IOException -> 0x01ab }
        goto L_0x0067;
    L_0x01ab:
        r1 = move-exception;
        r2 = "ChatModal";
        r4 = new java.lang.Object[r4];
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r7 = "==========fis.close() error!!! ";
        r6 = r6.append(r7);
        r1 = r1.getMessage();
        r1 = r6.append(r1);
        r1 = r1.toString();
        r4[r3] = r1;
        com.huawei.p190v.C2538c.m12674b(r2, r4);
        goto L_0x0067;
    L_0x01ce:
        r0 = move-exception;
    L_0x01cf:
        if (r2 == 0) goto L_0x01d4;
    L_0x01d1:
        r2.close();	 Catch:{ IOException -> 0x01d5 }
    L_0x01d4:
        throw r0;
    L_0x01d5:
        r1 = move-exception;
        r2 = "ChatModal";
        r4 = new java.lang.Object[r4];
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "==========fis.close() error!!! ";
        r5 = r5.append(r6);
        r1 = r1.getMessage();
        r1 = r5.append(r1);
        r1 = r1.toString();
        r4[r3] = r1;
        com.huawei.p190v.C2538c.m12674b(r2, r4);
        goto L_0x01d4;
    L_0x01f7:
        r0 = move-exception;
        r2 = r1;
        goto L_0x01cf;
    L_0x01fa:
        r0 = move-exception;
        r2 = r1;
        r1 = r0;
        r0 = r3;
        goto L_0x0182;
    L_0x01ff:
        r0 = move-exception;
        r11 = r0;
        r0 = r2;
        r2 = r1;
        r1 = r11;
        goto L_0x0182;
    L_0x0206:
        r0 = move-exception;
        r2 = r1;
        r1 = r0;
        r0 = r3;
        goto L_0x0133;
    L_0x020c:
        r0 = move-exception;
        r11 = r0;
        r0 = r2;
        r2 = r1;
        r1 = r11;
        goto L_0x0133;
    L_0x0213:
        r0 = move-exception;
        r2 = r1;
        r1 = r0;
        r0 = r3;
        goto L_0x00e4;
    L_0x0219:
        r0 = move-exception;
        r11 = r0;
        r0 = r2;
        r2 = r1;
        r1 = r11;
        goto L_0x00e4;
    L_0x0220:
        r0 = move-exception;
        r2 = r1;
        r1 = r0;
        r0 = r3;
        goto L_0x0097;
    L_0x0226:
        r0 = move-exception;
        r11 = r0;
        r0 = r2;
        r2 = r1;
        r1 = r11;
        goto L_0x0097;
    L_0x022d:
        r1 = r2;
        r0 = r3;
        goto L_0x0062;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.pluginkidwatch.plugin.chat.a.a.a(java.lang.String):java.lang.Integer");
    }

    public static C1744a m8467a(ab abVar) {
        if (abVar == null) {
            return null;
        }
        C1744a c1744a = new C1744a();
        if (C1462f.m6744i().equals(abVar.f2993d)) {
            c1744a.f4768c = true;
        } else {
            c1744a.f4768c = false;
        }
        c1744a.f4769d = abVar.f2996g;
        c1744a.f4774i = false;
        c1744a.f4771f = false;
        c1744a.f4775j = abVar.f2992c;
        c1744a.f4772g = abVar.f3002m;
        c1744a.f4767b = abVar.f2997h;
        c1744a.f4784s = abVar.f2994e;
        c1744a.f4776k = abVar.f3003n;
        if ("0".equals(abVar.f2994e)) {
            c1744a.f4773h = c1744a.m8468a(abVar.f2997h);
            if (c1744a.f4773h.hashCode() == 0) {
                c1744a.f4772g = 3;
            }
        }
        c1744a.f4780o = abVar.f2998i;
        c1744a.f4781p = abVar.f2993d;
        c1744a.f4782q = abVar.f2999j + "";
        c1744a.f4783r = abVar.f3006q;
        c1744a.f4777l = abVar.f3007r;
        c1744a.f4785t = abVar.f2995f;
        return c1744a;
    }

    public int m8469a(C1744a c1744a) {
        if (C1492l.m6922f(this.f4769d) > C1492l.m6922f(c1744a.f4769d)) {
            return 1;
        }
        if (C1492l.m6922f(this.f4769d) == C1492l.m6922f(c1744a.f4769d)) {
            return 0;
        }
        return -1;
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return "ChatModal{msgId=" + this.f4766a + ", filepath='" + this.f4767b + '\'' + ", owner=" + this.f4768c + ", time='" + this.f4769d + '\'' + ", downloadPath='" + this.f4770e + '\'' + ", isUploading=" + this.f4771f + ", status=" + this.f4772g + ", soundTime=" + this.f4773h + ", isPlay=" + this.f4774i + ", fromName='" + this.f4775j + '\'' + ", isReaded=" + this.f4776k + ", createTime='" + this.f4777l + '\'' + ", endTime='" + this.f4778m + '\'' + ", headImage=" + this.f4779n + ", headUrl='" + this.f4780o + '\'' + ", fromId='" + this.f4781p + '\'' + ", groupId='" + this.f4782q + '\'' + ", relationType='" + this.f4783r + '\'' + ", messageType='" + this.f4784s + '\'' + ", textContent='" + this.f4785t + '\'' + ", mIsShowCheck=" + this.f4786u + ", mIsSelected=" + this.f4787v + '}';
    }
}
