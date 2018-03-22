package com.huawei.p085j;

import android.content.Context;
import com.huawei.hwbasemgr.C0628a;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.datatypes.DeviceCapability;
import com.huawei.hwcommonmodel.p062a.C0972a;
import com.huawei.hwdevicemgr.dmsdatatype.datatype.DeviceCommand;
import com.huawei.j.b;
import com.huawei.p108n.C1204c;
import com.huawei.p190v.C2538c;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: HWWearableManager */
public class C1089a extends C0628a {
    private static C1089a f2207a;
    private static C1204c f2208b;
    private static Map<Integer, List<IBaseResponseCallback>> f2209c = new HashMap();
    private static List<Integer> f2210d = new ArrayList(Arrays.asList(new Integer[]{Integer.valueOf(1)}));
    private IBaseResponseCallback f2211e = new b(this);

    public static C1089a m4692a() {
        synchronized (C1089a.m4697b()) {
            if (f2209c.size() == 0) {
                for (Integer put : f2210d) {
                    f2209c.put(put, new ArrayList());
                }
            }
        }
        if (f2207a == null) {
            f2207a = new C1089a(BaseApplication.m2632b());
        }
        return f2207a;
    }

    private C1089a(Context context) {
        super(context);
        f2208b = C1204c.m5370a(context);
        if (f2208b != null) {
            f2208b.m5423a(26, this.f2211e);
            return;
        }
        C2538c.m12680e("HWWearableManager", "HWWearableManager() hwDeviceConfigManager is null");
    }

    public void m4698a(String str, IBaseResponseCallback iBaseResponseCallback) {
        C2538c.m12677c("HWWearableManager", "ENTER sendAccount ");
        DeviceCapability a = C0972a.m3499a();
        C2538c.m12677c("HWWearableManager", "sendAccount ability : " + a);
        if (a == null) {
            if (iBaseResponseCallback != null) {
                iBaseResponseCallback.onResponse(-2, Integer.valueOf(-2));
            }
            C2538c.m12677c("HWWearableManager", "ability is null , Do not sendAccount ");
        } else if (a.isSupportAccount()) {
            DeviceCommand deviceCommand = new DeviceCommand();
            deviceCommand.setServiceID(26);
            deviceCommand.setCommandID(1);
            String e = C0973a.m3518e(str);
            String a2 = C0973a.m3506a(e.length() / 2);
            String a3 = C0973a.m3506a(1);
            ByteBuffer allocate = ByteBuffer.allocate(((a3.length() / 2) + (a2.length() / 2)) + (e.length() / 2));
            allocate.put(C0973a.m3512b(a3));
            allocate.put(C0973a.m3512b(a2));
            allocate.put(C0973a.m3512b(e));
            m4693a(deviceCommand, allocate, 1, iBaseResponseCallback);
        } else {
            if (iBaseResponseCallback != null) {
                iBaseResponseCallback.onResponse(-2, Integer.valueOf(-2));
            }
            C2538c.m12677c("HWWearableManager", " bot SupportAccount , Do not sendAccount ");
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m4695a(byte[] r10) {
        /*
        r9 = this;
        r7 = 1;
        r1 = 0;
        r3 = 0;
        r0 = r9.m4696b(r10);
        r2 = 100000; // 0x186a0 float:1.4013E-40 double:4.94066E-319;
        if (r2 != r0) goto L_0x005d;
    L_0x000c:
        r0 = r1;
    L_0x000d:
        r2 = "HWWearableManager";
        r4 = new java.lang.Object[r7];
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "getResult err_code = ";
        r5 = r5.append(r6);
        r5 = r5.append(r0);
        r5 = r5.toString();
        r4[r1] = r5;
        com.huawei.p190v.C2538c.m12680e(r2, r4);
        r2 = r10[r7];
        switch(r2) {
            case 1: goto L_0x005f;
            default: goto L_0x002e;
        };
    L_0x002e:
        r2 = r0;
    L_0x002f:
        r4 = com.huawei.p085j.C1089a.m4697b();
        monitor-enter(r4);
        r0 = f2209c;	 Catch:{ all -> 0x00f0 }
        r1 = 1;
        r1 = r10[r1];	 Catch:{ all -> 0x00f0 }
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ all -> 0x00f0 }
        r0 = r0.get(r1);	 Catch:{ all -> 0x00f0 }
        r0 = (java.util.List) r0;	 Catch:{ all -> 0x00f0 }
        if (r0 == 0) goto L_0x005b;
    L_0x0045:
        if (r3 == 0) goto L_0x00d5;
    L_0x0047:
        r1 = r0.size();	 Catch:{ all -> 0x00f0 }
        if (r1 == 0) goto L_0x00d5;
    L_0x004d:
        r1 = 0;
        r1 = r0.get(r1);	 Catch:{ all -> 0x00f0 }
        r1 = (com.huawei.hwbasemgr.IBaseResponseCallback) r1;	 Catch:{ all -> 0x00f0 }
        r1.onResponse(r2, r3);	 Catch:{ all -> 0x00f0 }
        r1 = 0;
        r0.remove(r1);	 Catch:{ all -> 0x00f0 }
    L_0x005b:
        monitor-exit(r4);	 Catch:{ all -> 0x00f0 }
        return;
    L_0x005d:
        r0 = -1;
        goto L_0x000d;
    L_0x005f:
        r2 = com.huawei.hwcommonmodel.C0973a.m3509a(r10);
        r4 = 4;
        r5 = r2.length();
        r2 = r2.substring(r4, r5);
        r4 = new com.huawei.hwcommonmodel.datatypes.w;	 Catch:{ t -> 0x00b3 }
        r4.<init>();	 Catch:{ t -> 0x00b3 }
        r2 = r4.a(r2);	 Catch:{ t -> 0x00b3 }
        r2 = r2.a;	 Catch:{ t -> 0x00b3 }
        r4 = r2.iterator();	 Catch:{ t -> 0x00b3 }
        r2 = r0;
    L_0x007c:
        r0 = r4.hasNext();	 Catch:{ t -> 0x00f3 }
        if (r0 == 0) goto L_0x002f;
    L_0x0082:
        r0 = r4.next();	 Catch:{ t -> 0x00f3 }
        r0 = (com.huawei.hwcommonmodel.datatypes.s) r0;	 Catch:{ t -> 0x00f3 }
        r5 = r0.a();	 Catch:{ t -> 0x00f3 }
        r6 = 16;
        r5 = java.lang.Integer.parseInt(r5, r6);	 Catch:{ t -> 0x00f3 }
        switch(r5) {
            case 1: goto L_0x009a;
            case 127: goto L_0x00a1;
            default: goto L_0x0095;
        };
    L_0x0095:
        r0 = r2;
        r2 = r3;
    L_0x0097:
        r3 = r2;
        r2 = r0;
        goto L_0x007c;
    L_0x009a:
        r0 = r0.b();	 Catch:{ t -> 0x00f5 }
        r2 = r0;
        r0 = r1;
        goto L_0x0097;
    L_0x00a1:
        r0 = r0.b();	 Catch:{ t -> 0x00f3 }
        r5 = 16;
        r0 = java.lang.Integer.parseInt(r0, r5);	 Catch:{ t -> 0x00f3 }
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ t -> 0x00f3 }
        r8 = r2;
        r2 = r0;
        r0 = r8;
        goto L_0x0097;
    L_0x00b3:
        r2 = move-exception;
        r8 = r2;
        r2 = r0;
        r0 = r8;
    L_0x00b7:
        r4 = "HWWearableManager";
        r5 = new java.lang.Object[r7];
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r7 = "COMMAND_ID_GET_DATE error e = ";
        r6 = r6.append(r7);
        r0 = r6.append(r0);
        r0 = r0.toString();
        r5[r1] = r0;
        com.huawei.p190v.C2538c.m12680e(r4, r5);
        goto L_0x002f;
    L_0x00d5:
        r1 = r0.size();	 Catch:{ all -> 0x00f0 }
        if (r1 == 0) goto L_0x005b;
    L_0x00db:
        r1 = 0;
        r1 = r0.get(r1);	 Catch:{ all -> 0x00f0 }
        r1 = (com.huawei.hwbasemgr.IBaseResponseCallback) r1;	 Catch:{ all -> 0x00f0 }
        r2 = 100001; // 0x186a1 float:1.40131E-40 double:4.9407E-319;
        r3 = "UNKNOWN_ERROR";
        r1.onResponse(r2, r3);	 Catch:{ all -> 0x00f0 }
        r1 = 0;
        r0.remove(r1);	 Catch:{ all -> 0x00f0 }
        goto L_0x005b;
    L_0x00f0:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x00f0 }
        throw r0;
    L_0x00f3:
        r0 = move-exception;
        goto L_0x00b7;
    L_0x00f5:
        r0 = move-exception;
        r2 = r1;
        goto L_0x00b7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.j.a.a(byte[]):void");
    }

    private int m4696b(byte[] bArr) {
        String a = C0973a.m3509a(bArr);
        try {
            return Integer.parseInt(a.substring(8, a.length()), 16);
        } catch (Exception e) {
            return 0;
        }
    }

    protected Integer getModuleId() {
        return Integer.valueOf(26);
    }

    protected void onDestroy() {
        super.onDestroy();
        f2208b.m5422a(26);
        synchronized (C1089a.m4697b()) {
            for (int i = 0; i < f2210d.size(); i++) {
                if (f2209c.get(f2210d.get(i)) != null) {
                    ((List) f2209c.get(f2210d.get(i))).clear();
                }
            }
        }
        f2207a = null;
        C2538c.m12677c("HWWearableManager", "onDestroy() complete");
    }

    private static synchronized Object m4697b() {
        Map map;
        synchronized (C1089a.class) {
            map = f2209c;
        }
        return map;
    }

    private void m4693a(DeviceCommand deviceCommand, ByteBuffer byteBuffer, int i, IBaseResponseCallback iBaseResponseCallback) {
        synchronized (C1089a.m4697b()) {
            if (iBaseResponseCallback != null) {
                List list = (List) f2209c.get(Integer.valueOf(i));
                if (list != null) {
                    list.add(iBaseResponseCallback);
                } else {
                    C2538c.m12680e("HWWearableManager", "addToList() callbacks is null");
                }
            } else {
                C2538c.m12680e("HWWearableManager", "addToList() callback is null");
            }
        }
        deviceCommand.setDataLen(byteBuffer.array().length);
        deviceCommand.setDataContent(byteBuffer.array());
        f2208b.m5427a(deviceCommand);
    }
}
