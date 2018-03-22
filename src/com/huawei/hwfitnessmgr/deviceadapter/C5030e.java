package com.huawei.hwfitnessmgr.deviceadapter;

import com.huawei.datatype.FitnessUserInfo;
import com.huawei.hwcommonmodel.datatypes.C4753t;
import com.huawei.hwcommonmodel.datatypes.C4756w;
import com.huawei.hwcommonmodel.fitnessdatatype.DataTotalMotion;
import com.huawei.hwfitnessmgr.deviceadapter.datatype.C5018a;
import com.huawei.hwfitnessmgr.deviceadapter.datatype.C5019b;
import com.huawei.hwfitnessmgr.deviceadapter.datatype.C5022e;
import com.huawei.hwfitnessmgr.deviceadapter.datatype.C5023f;
import com.huawei.hwfitnessmgr.deviceadapter.datatype.C5026i;
import com.huawei.hwfitnessmgr.deviceadapter.datatype.C5028k;
import com.huawei.p190v.C2538c;
import java.util.List;

/* compiled from: FitnessUnPackage */
public class C5030e {
    public static int m24253a(byte[] bArr) throws C4753t {
        String a = a.a(bArr);
        int[] a2 = C5035j.m24276a(new C4756w().m22743a(a.substring(4, a.length())));
        C2538c.c("FitnessUnPackage", new Object[]{"Error Code:" + a2[0]});
        if (a2[0] == 100000) {
            return 0;
        }
        return a2[0];
    }

    public static C5023f m24255b(byte[] bArr) throws Exception {
        C4756w c4756w = new C4756w();
        String a = a.a(bArr);
        return C5035j.m24277b(c4756w.m22743a(a.substring(4, a.length())));
    }

    public static C5022e m24256c(byte[] bArr) throws Exception {
        C4756w c4756w = new C4756w();
        String a = a.a(bArr);
        return C5032g.m24266a(c4756w.m22743a(a.substring(4, a.length())));
    }

    public static C5018a m24257d(byte[] bArr) throws Exception {
        String a = a.a(bArr);
        return C5032g.m24267b(new C4756w().m22743a(a.substring(4, a.length())));
    }

    public static List<C5019b> m24258e(byte[] bArr) throws Exception {
        String a = a.a(bArr);
        return C5032g.m24268c(new C4756w().m22743a(a.substring(4, a.length())));
    }

    public static int m24259f(byte[] bArr) throws Exception {
        String a = a.a(bArr);
        return C5033h.m24269a(new C4756w().m22743a(a.substring(4, a.length())));
    }

    public static C5026i m24260g(byte[] bArr) throws Exception {
        String a = a.a(bArr);
        return C5033h.m24272b(new C4756w().m22743a(a.substring(4, a.length())));
    }

    public static int m24261h(byte[] bArr) throws Exception {
        String a = a.a(bArr);
        return C5034i.m24273a(new C4756w().m22743a(a.substring(4, a.length())));
    }

    public static C5028k m24262i(byte[] bArr) throws Exception {
        String a = a.a(bArr);
        return C5034i.m24275b(new C4756w().m22743a(a.substring(4, a.length())));
    }

    public static int m24263j(byte[] bArr) throws Exception {
        String a = a.a(bArr);
        return C5035j.m24278c(new C4756w().m22743a(a.substring(4, a.length())));
    }

    public static FitnessUserInfo m24264k(byte[] bArr) throws C4753t {
        String a = a.a(bArr);
        return C5035j.m24279d(new C4756w().m22743a(a.substring(4, a.length())));
    }

    public static C5023f m24254a(int i, int i2, int i3, int i4, int i5) throws Exception {
        C5023f c5023f = new C5023f();
        c5023f.m24209a(i2);
        DataTotalMotion dataTotalMotion = new DataTotalMotion();
        dataTotalMotion.setMotion_type(1);
        dataTotalMotion.setCalorie(i2);
        dataTotalMotion.setDistance(i3);
        dataTotalMotion.setStep(i);
        c5023f.m24212b().add(dataTotalMotion);
        dataTotalMotion = new DataTotalMotion();
        dataTotalMotion.setMotion_type(6);
        dataTotalMotion.setSleep_time(i5);
        c5023f.m24212b().add(dataTotalMotion);
        dataTotalMotion = new DataTotalMotion();
        dataTotalMotion.setMotion_type(7);
        dataTotalMotion.setSleep_time(i4);
        c5023f.m24212b().add(dataTotalMotion);
        return c5023f;
    }
}
