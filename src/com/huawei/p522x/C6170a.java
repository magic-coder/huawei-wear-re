package com.huawei.p522x;

import android.content.Context;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwbasemgr.a;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.datatypes.C4756w;
import com.huawei.hwdevicemgr.dmsdatatype.datatype.DeviceCommand;
import com.huawei.n.c;
import com.huawei.p190v.C2538c;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: HWOneLevelMenuManager */
public class C6170a extends a {
    private static c f21625a;
    private static C6170a f21626b;
    private static Map<Integer, List<IBaseResponseCallback>> f21627e = new HashMap();
    private static List<Integer> f21628f = new ArrayList(Arrays.asList(new Integer[]{Integer.valueOf(1), Integer.valueOf(2)}));
    private C4756w f21629c = new C4756w();
    private Context f21630d;
    private IBaseResponseCallback f21631g = new C6171b(this);

    private static synchronized Object m28551a() {
        Map map;
        synchronized (C6170a.class) {
            map = f21627e;
        }
        return map;
    }

    private C6170a(Context context) {
        super(context);
        this.f21630d = context;
        f21625a = c.a(this.f21630d);
        if (f21625a != null) {
            f21625a.a(34, this.f21631g);
            return;
        }
        C2538c.e("HWOneLevelMenuManager", new Object[]{"HWWearableManager() hwDeviceConfigManager is null"});
    }

    public static C6170a m28550a(Context context) {
        synchronized (C6170a.m28551a()) {
            C2538c.c("OneLevelMenuManagerActivity", new Object[]{"===123===instance" + f21626b});
            if (f21626b != null) {
                f21626b.onDestroy();
            }
            if (f21627e.size() == 0) {
                for (Integer put : f21628f) {
                    f21627e.put(put, new ArrayList());
                }
            }
        }
        if (f21626b == null && context != null) {
            f21626b = new C6170a(BaseApplication.b());
        }
        return f21626b;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m28555a(byte[] r11) {
        /*
        r10 = this;
        r8 = 1;
        r1 = 0;
        r4 = 0;
        r2 = r10.m28556b(r11);
        r0 = 100000; // 0x186a0 float:1.4013E-40 double:4.94066E-319;
        if (r0 != r2) goto L_0x0039;
    L_0x000c:
        r0 = r1;
    L_0x000d:
        r3 = "HWOneLevelMenuManager";
        r5 = new java.lang.Object[r8];
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r7 = "getResult(): ";
        r6 = r6.append(r7);
        r7 = com.huawei.hwcommonmodel.a.a(r11);
        r6 = r6.append(r7);
        r6 = r6.toString();
        r5[r1] = r6;
        com.huawei.v.c.c(r3, r5);
        r3 = r11[r8];
        switch(r3) {
            case 1: goto L_0x0040;
            case 2: goto L_0x003b;
            default: goto L_0x0032;
        };
    L_0x0032:
        r1 = r4;
    L_0x0033:
        r2 = r11[r8];
        r10.m28552a(r2, r0, r1);
        return;
    L_0x0039:
        r0 = -1;
        goto L_0x000d;
    L_0x003b:
        r1 = java.lang.Integer.valueOf(r2);
        goto L_0x0033;
    L_0x0040:
        r2 = com.huawei.hwcommonmodel.a.a(r11);
        r3 = 4;
        r5 = r2.length();
        r2 = r2.substring(r3, r5);
        r3 = new java.util.HashMap;
        r3.<init>();
        r5 = r10.f21629c;	 Catch:{ t -> 0x009c }
        r2 = r5.m22743a(r2);	 Catch:{ t -> 0x009c }
        r2 = r2.f17337a;	 Catch:{ t -> 0x009c }
        r5 = r2.iterator();	 Catch:{ t -> 0x009c }
        r2 = r0;
    L_0x005f:
        r0 = r5.hasNext();	 Catch:{ t -> 0x00bc }
        if (r0 == 0) goto L_0x0099;
    L_0x0065:
        r0 = r5.next();	 Catch:{ t -> 0x00bc }
        r0 = (com.huawei.hwcommonmodel.datatypes.C4752s) r0;	 Catch:{ t -> 0x00bc }
        r6 = r0.m22732a();	 Catch:{ t -> 0x00bc }
        r7 = 16;
        r6 = java.lang.Integer.parseInt(r6, r7);	 Catch:{ t -> 0x00bc }
        switch(r6) {
            case 1: goto L_0x007b;
            case 2: goto L_0x008a;
            default: goto L_0x0078;
        };
    L_0x0078:
        r0 = r2;
    L_0x0079:
        r2 = r0;
        goto L_0x005f;
    L_0x007b:
        r0 = r0.m22733b();	 Catch:{ t -> 0x00c1 }
        r0 = com.huawei.hwcommonmodel.a.b(r0);	 Catch:{ t -> 0x00c1 }
        r2 = "all";
        r3.put(r2, r0);	 Catch:{ t -> 0x00c1 }
        r0 = r1;
        goto L_0x0079;
    L_0x008a:
        r0 = r0.m22733b();	 Catch:{ t -> 0x00c1 }
        r0 = com.huawei.hwcommonmodel.a.b(r0);	 Catch:{ t -> 0x00c1 }
        r2 = "open";
        r3.put(r2, r0);	 Catch:{ t -> 0x00c1 }
        r0 = r1;
        goto L_0x0079;
    L_0x0099:
        r0 = r2;
        r1 = r3;
        goto L_0x0033;
    L_0x009c:
        r2 = move-exception;
    L_0x009d:
        r3 = "HWOneLevelMenuManager";
        r5 = new java.lang.Object[r8];
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r7 = "getResult() COMMAND_ID_MUNE_SET = ";
        r6 = r6.append(r7);
        r2 = r6.append(r2);
        r2 = r2.toString();
        r5[r1] = r2;
        com.huawei.v.c.e(r3, r5);
        r1 = r4;
        goto L_0x0033;
    L_0x00bc:
        r0 = move-exception;
        r9 = r0;
        r0 = r2;
        r2 = r9;
        goto L_0x009d;
    L_0x00c1:
        r0 = move-exception;
        r2 = r0;
        r0 = r1;
        goto L_0x009d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.x.a.a(byte[]):void");
    }

    private void m28552a(int i, int i2, Object obj) {
        synchronized (C6170a.m28551a()) {
            List list = (List) f21627e.get(Integer.valueOf(i));
            if (list == null) {
                C2538c.c("HWOneLevelMenuManager", new Object[]{"procCallback callback,callbackList is null"});
            } else if (obj != null && list.size() != 0) {
                C2538c.c("HWOneLevelMenuManager", new Object[]{"procCallback callback,commandID=" + i});
                ((IBaseResponseCallback) list.get(0)).onResponse(i2, obj);
                list.remove(0);
            } else if (list.size() != 0) {
                ((IBaseResponseCallback) list.get(0)).onResponse(100001, "UNKNOWN_ERROR");
                list.remove(0);
            }
        }
    }

    public void m28558a(List<Integer> list, IBaseResponseCallback iBaseResponseCallback) {
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(34);
        deviceCommand.setCommandID(2);
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            stringBuffer.append(C0973a.a(((Integer) list.get(i)).intValue()));
        }
        String stringBuffer2 = stringBuffer.toString();
        String e = C0973a.e(stringBuffer2.length() / 2);
        String a = C0973a.a(2);
        ByteBuffer allocate = ByteBuffer.allocate(((a.length() / 2) + (e.length() / 2)) + (stringBuffer2.length() / 2));
        allocate.put(C0973a.b(a + e + stringBuffer2));
        C2538c.b("HWOneLevelMenuManager", new Object[]{"transmitFile() , byteBufferAll" + C0973a.a(allocate.array())});
        m28553a(deviceCommand, allocate, 2, iBaseResponseCallback);
    }

    public void m28557a(IBaseResponseCallback iBaseResponseCallback) {
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(34);
        deviceCommand.setCommandID(1);
        String e = C0973a.e(0);
        String a = C0973a.a(1);
        String e2 = C0973a.e(0);
        String a2 = C0973a.a(2);
        ByteBuffer allocate = ByteBuffer.allocate((((e.length() / 2) + (a.length() / 2)) + (a2.length() / 2)) + (e2.length() / 2));
        allocate.put(C0973a.b(a));
        allocate.put(C0973a.b(e));
        allocate.put(C0973a.b(a2));
        allocate.put(C0973a.b(e2));
        C2538c.b("HWOneLevelMenuManager", new Object[]{"getBTCInfo() byteBufferAll =" + C0973a.a(allocate.array())});
        m28553a(deviceCommand, allocate, 1, iBaseResponseCallback);
    }

    private void m28553a(DeviceCommand deviceCommand, ByteBuffer byteBuffer, int i, IBaseResponseCallback iBaseResponseCallback) {
        synchronized (C6170a.m28551a()) {
            if (iBaseResponseCallback != null) {
                List list = (List) f21627e.get(Integer.valueOf(i));
                if (list != null) {
                    C2538c.e("HWOneLevelMenuManager", new Object[]{"addToList() ,null != callbacks "});
                    list.add(iBaseResponseCallback);
                } else {
                    C2538c.e("HWOneLevelMenuManager", new Object[]{"addToList() callbacks is null"});
                }
            } else {
                C2538c.e("HWOneLevelMenuManager", new Object[]{"addToList() callback is null"});
            }
        }
        deviceCommand.setDataLen(byteBuffer.array().length);
        deviceCommand.setDataContent(byteBuffer.array());
        f21625a.a(deviceCommand);
    }

    protected void onDestroy() {
        super.onDestroy();
        C2538c.c("OneLevelMenuManagerActivity", new Object[]{"===123===OneLevelMenu onDestroy"});
        f21625a.a(34);
        synchronized (C6170a.m28551a()) {
            for (int i = 0; i < f21628f.size(); i++) {
                if (f21627e.get(f21628f.get(i)) != null) {
                    ((List) f21627e.get(f21628f.get(i))).clear();
                }
            }
        }
        C2538c.c("HWOneLevelMenuManager", new Object[]{"onDestroy()"});
        f21626b = null;
        C2538c.c("HWOneLevelMenuManager", new Object[]{"onDestroy() complete"});
    }

    private int m28556b(byte[] bArr) {
        String a = C0973a.a(bArr);
        try {
            return Integer.parseInt(a.substring(8, a.length()), 16);
        } catch (Exception e) {
            return 0;
        }
    }

    protected Integer getModuleId() {
        return Integer.valueOf(34);
    }
}
