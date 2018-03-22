package com.huawei.p390z;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.support.v4.media.TransportMediator;
import com.huawei.datatype.PayAPDUInfo;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwbasemgr.a;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.datatypes.C4756w;
import com.huawei.hwdevicemgr.dmsdatatype.datatype.DeviceCommand;
import com.huawei.n.c;
import com.huawei.p190v.C2538c;
import com.huawei.p390z.p525a.C6182a;
import com.huawei.p481p.p482a.C5718a;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: HWPayManager */
public class C6184a extends a {
    private static C6184a f21693a;
    private static Map<Integer, List<IBaseResponseCallback>> f21694f = new HashMap();
    private static List<Integer> f21695g = new ArrayList(Arrays.asList(new Integer[]{Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(7), Integer.valueOf(8), Integer.valueOf(9), Integer.valueOf(10), Integer.valueOf(11), Integer.valueOf(12), Integer.valueOf(13)}));
    private Context f21696b;
    private C4480d f21697c = null;
    private C4756w f21698d = new C4756w();
    private c f21699e;
    private IBaseResponseCallback f21700h = new C6185b(this);
    private final BroadcastReceiver f21701i = new C6186c(this);

    public static C6184a m28626a() {
        C2538c.b("HWPayManager", new Object[]{"getInstance(),instance=" + f21693a});
        synchronized (C6184a.m28637c()) {
            if (f21694f.size() == 0) {
                for (Integer put : f21695g) {
                    f21694f.put(put, new ArrayList());
                }
            }
        }
        if (f21693a == null) {
            f21693a = new C6184a(BaseApplication.b());
        }
        return f21693a;
    }

    private C6184a(Context context) {
        super(context);
        this.f21696b = context;
        this.f21699e = c.a(this.f21696b);
        C2538c.b("HWPayManager", new Object[]{"HWPayManager(),hwDeviceConfigManager=" + this.f21699e});
        if (this.f21699e != null) {
            C2538c.e("HWPayManager", new Object[]{"registerIBaseResponseCallback() "});
            this.f21699e.a(27, this.f21700h);
        } else {
            C2538c.e("HWPayManager", new Object[]{"HWPayManager() hwDeviceConfigManager is null"});
        }
        m28639e();
    }

    public void m28643a(String str, int i, IBaseResponseCallback iBaseResponseCallback) {
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(27);
        deviceCommand.setCommandID(1);
        String str2 = "";
        String str3 = "";
        String str4 = "";
        if (str != null) {
            str3 = C0973a.e(str.length() / 2);
            str4 = C0973a.a(1);
        } else {
            str = str2;
        }
        str2 = C0973a.a(i);
        String e = C0973a.e(str2.length() / 2);
        String a = C0973a.a(2);
        ByteBuffer allocate = ByteBuffer.allocate((((((str4.length() / 2) + (str3.length() / 2)) + (str.length() / 2)) + (a.length() / 2)) + (e.length() / 2)) + (str2.length() / 2));
        allocate.put(C0973a.b(str4));
        allocate.put(C0973a.b(str3));
        allocate.put(C0973a.b(str));
        allocate.put(C0973a.b(a));
        allocate.put(C0973a.b(e));
        allocate.put(C0973a.b(str2));
        m28630a(deviceCommand, allocate, 1, iBaseResponseCallback);
    }

    public void m28640a(PayAPDUInfo payAPDUInfo, IBaseResponseCallback iBaseResponseCallback) {
        C2538c.b("HWPayManager", new Object[]{"executeApdu  payAPDUInfo : " + payAPDUInfo.toString()});
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(27);
        deviceCommand.setCommandID(2);
        String a = C0973a.a((long) payAPDUInfo.getReqid());
        String e = C0973a.e(a.length() / 2);
        String a2 = C0973a.a(1);
        String apdu = payAPDUInfo.getApdu();
        String e2 = C0973a.e(apdu.length() / 2);
        String a3 = C0973a.a(2);
        String a4 = C0973a.a(payAPDUInfo.getChannelID());
        String e3 = C0973a.e(a4.length() / 2);
        String a5 = C0973a.a(3);
        ByteBuffer allocate = ByteBuffer.allocate(((((((((a2.length() / 2) + (e.length() / 2)) + (a.length() / 2)) + (a3.length() / 2)) + (e2.length() / 2)) + (apdu.length() / 2)) + (a5.length() / 2)) + (e3.length() / 2)) + (a4.length() / 2));
        allocate.put(C0973a.b(a2));
        allocate.put(C0973a.b(e));
        allocate.put(C0973a.b(a));
        allocate.put(C0973a.b(a3));
        allocate.put(C0973a.b(e2));
        allocate.put(C0973a.b(apdu));
        allocate.put(C0973a.b(a5));
        allocate.put(C0973a.b(e3));
        allocate.put(C0973a.b(a4));
        C2538c.b("HWPayManager", new Object[]{"executeApdu  byteBufferAll : " + C0973a.a(allocate.array())});
        m28630a(deviceCommand, allocate, 2, iBaseResponseCallback);
    }

    public void m28641a(IBaseResponseCallback iBaseResponseCallback) {
        C2538c.b("HWPayManager", new Object[]{"closeChannel() callbacks =" + iBaseResponseCallback});
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(27);
        deviceCommand.setCommandID(3);
        String e = C0973a.e(0);
        String a = C0973a.a(1);
        ByteBuffer allocate = ByteBuffer.allocate((a.length() / 2) + (e.length() / 2));
        allocate.put(C0973a.b(a));
        allocate.put(C0973a.b(e));
        C2538c.b("HWPayManager", new Object[]{"closeChannel() byteBufferAll =" + C0973a.a(allocate.array())});
        m28630a(deviceCommand, allocate, 3, iBaseResponseCallback);
    }

    public void m28647b(IBaseResponseCallback iBaseResponseCallback) {
        C2538c.b("HWPayManager", new Object[]{"getCPLC() callbacks =" + iBaseResponseCallback});
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(27);
        deviceCommand.setCommandID(4);
        String e = C0973a.e(0);
        String a = C0973a.a(1);
        ByteBuffer allocate = ByteBuffer.allocate((a.length() / 2) + (e.length() / 2));
        allocate.put(C0973a.b(a));
        allocate.put(C0973a.b(e));
        C2538c.b("HWPayManager", new Object[]{"getCPLC() byteBufferAll =" + C0973a.a(allocate.array())});
        m28630a(deviceCommand, allocate, 4, iBaseResponseCallback);
    }

    public void m28650c(IBaseResponseCallback iBaseResponseCallback) {
        C2538c.b("HWPayManager", new Object[]{"getBTCInfo() callbacks =" + iBaseResponseCallback});
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(27);
        deviceCommand.setCommandID(5);
        String e = C0973a.e(0);
        String a = C0973a.a(1);
        ByteBuffer allocate = ByteBuffer.allocate((a.length() / 2) + (e.length() / 2));
        allocate.put(C0973a.b(a));
        allocate.put(C0973a.b(e));
        C2538c.b("HWPayManager", new Object[]{"getBTCInfo() byteBufferAll =" + C0973a.a(allocate.array())});
        m28630a(deviceCommand, allocate, 5, iBaseResponseCallback);
    }

    public void m28646a(List<C5718a> list, IBaseResponseCallback iBaseResponseCallback) {
        String a;
        C2538c.b("HWPayManager", new Object[]{"transmitFile() callbacks =" + iBaseResponseCallback});
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(27);
        deviceCommand.setCommandID(7);
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 1; i <= list.size(); i++) {
            String b = ((C5718a) list.get(i - 1)).m26362b();
            int a2 = ((C5718a) list.get(i - 1)).m26359a();
            b = C0973a.e(b);
            String e = C0973a.e(b.length() / 2);
            String a3 = C0973a.a(4);
            a = C0973a.a(a2);
            String e2 = C0973a.e(a.length() / 2);
            String a4 = C0973a.a(3);
            stringBuffer = stringBuffer.append(C0973a.a(TransportMediator.KEYCODE_MEDIA_RECORD) + C0973a.e(((((a.length() + (e2.length() + a4.length())) + a3.length()) + e.length()) + b.length()) / 2) + (a4 + e2 + a + a3 + e + b));
        }
        a = stringBuffer.toString();
        String e3 = C0973a.e(a.length() / 2);
        String a5 = C0973a.a(129);
        ByteBuffer allocate = ByteBuffer.allocate(((a5.length() / 2) + (e3.length() / 2)) + (a.length() / 2));
        allocate.put(C0973a.b(a5 + e3 + a));
        C2538c.b("HWPayManager", new Object[]{"transmitFile() , byteBufferAll" + C0973a.a(allocate.array())});
        m28630a(deviceCommand, allocate, 7, iBaseResponseCallback);
    }

    public void m28644a(String str, IBaseResponseCallback iBaseResponseCallback) {
        C2538c.b("HWPayManager", new Object[]{"addCard(),payCardInfo" + str});
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(27);
        deviceCommand.setCommandID(8);
        String a = m28628a(str);
        ByteBuffer allocate = ByteBuffer.allocate(a.length() / 2);
        allocate.put(C0973a.b(a));
        m28630a(deviceCommand, allocate, 8, iBaseResponseCallback);
    }

    private String m28628a(String str) {
        C2538c.b("HWPayManager", new Object[]{"cardInfoTLV(),payCardInfo=" + str});
        C6182a c6182a = new C6182a(str);
        String str2 = "";
        String str3 = c6182a.f21673a;
        if (m28636b(str3)) {
            C2538c.e("HWPayManager", new Object[]{"aid is null"});
        } else {
            str3 = C0973a.e(str3);
            str2 = str2 + C0973a.a(1) + C0973a.e(str3.length() / 2) + str3;
        }
        str3 = c6182a.f21674b;
        if (m28636b(str3)) {
            str3 = "productId";
        }
        str3 = C0973a.e(str3);
        str2 = str2 + C0973a.a(2) + C0973a.e(str3.length() / 2) + str3;
        C2538c.b("HWPayManager", new Object[]{"cardInfoTLV(),name=" + c6182a.f21685m});
        str3 = C0973a.e(str3);
        str3 = str2 + C0973a.a(3) + C0973a.e(str3.length() / 2) + str3;
        str2 = c6182a.f21675c;
        if (m28636b(str2)) {
            str2 = "issuerId";
        }
        str2 = C0973a.e(str2);
        str3 = str3 + C0973a.a(4) + C0973a.e(str2.length() / 2) + str2;
        int i = c6182a.f21676d;
        if (2 == i) {
            i = 0;
        }
        str2 = C0973a.a(i);
        str3 = str3 + C0973a.a(5) + C0973a.e(str2.length() / 2) + str2;
        str2 = C0973a.a(c6182a.f21677e ? 1 : 0);
        str3 = str3 + C0973a.a(6) + C0973a.e(str2.length() / 2) + str2;
        str2 = c6182a.f21678f;
        if (m28636b(str2)) {
            str2 = "fpanDigest";
        }
        str2 = C0973a.e(str2);
        str3 = str3 + C0973a.a(7) + C0973a.e(str2.length() / 2) + str2;
        str2 = c6182a.f21679g;
        if (m28636b(str2)) {
            str2 = "fpanFour";
        }
        str2 = C0973a.e(str2);
        str3 = str3 + C0973a.a(8) + C0973a.e(str2.length() / 2) + str2;
        str2 = c6182a.f21680h;
        C2538c.b("HWPayManager", new Object[]{"cardInfoTLV(),dpanDigest=" + str2});
        if (m28636b(str2)) {
            str2 = c6182a.f21673a;
        }
        str2 = C0973a.e(str2);
        str3 = str3 + C0973a.a(9) + C0973a.e(str2.length() / 2) + str2;
        str2 = c6182a.f21681i;
        if (m28636b(str2)) {
            str2 = "dpanFour";
        }
        str2 = C0973a.e(str2);
        str2 = str3 + C0973a.a(10) + C0973a.e(str2.length() / 2) + str2;
        str3 = C0973a.a(c6182a.f21682j);
        str2 = str2 + C0973a.a(11) + C0973a.e(str3.length() / 2) + str3;
        str3 = C0973a.a(c6182a.f21683k);
        str2 = str2 + C0973a.a(12) + C0973a.e(str3.length() / 2) + str3;
        str3 = C0973a.a(c6182a.f21684l);
        str3 = str2 + C0973a.a(13) + C0973a.e(str3.length() / 2) + str3;
        str2 = c6182a.f21688p;
        if (m28636b(str2)) {
            str2 = "background_file_name";
        }
        str2 = C0973a.e(str2);
        str2 = str3 + C0973a.a(14) + C0973a.e(str2.length() / 2) + str2;
        str3 = C0973a.a(c6182a.f21689q);
        str3 = str2 + C0973a.a(15) + C0973a.e(str3.length() / 2) + str3;
        str2 = c6182a.f21686n;
        if (m28636b(str2)) {
            str2 = "Rf_file_name";
        }
        str2 = C0973a.e(str2);
        str2 = str3 + C0973a.a(16) + C0973a.e(str2.length() / 2) + str2;
        str3 = C0973a.a(c6182a.f21687o);
        return str2 + C0973a.a(17) + C0973a.e(str3.length() / 2) + str3;
    }

    public void m28649b(String str, IBaseResponseCallback iBaseResponseCallback) {
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(27);
        deviceCommand.setCommandID(9);
        String a = m28628a(str);
        ByteBuffer allocate = ByteBuffer.allocate(a.length() / 2);
        allocate.put(C0973a.b(a));
        m28630a(deviceCommand, allocate, 9, iBaseResponseCallback);
    }

    public void m28652d(IBaseResponseCallback iBaseResponseCallback) {
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(27);
        deviceCommand.setCommandID(10);
        String e = C0973a.e(0);
        String a = C0973a.a(1);
        ByteBuffer allocate = ByteBuffer.allocate((e.length() / 2) + (a.length() / 2));
        allocate.put(C0973a.b(a));
        allocate.put(C0973a.b(e));
        m28630a(deviceCommand, allocate, 10, iBaseResponseCallback);
    }

    public void m28651c(String str, IBaseResponseCallback iBaseResponseCallback) {
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(27);
        deviceCommand.setCommandID(11);
        C6182a c6182a = new C6182a(str);
        String str2 = c6182a.f21673a;
        if (1 == c6182a.f21676d) {
            str2 = c6182a.f21680h;
            C2538c.e("HWPayManager", new Object[]{"bank card ,ref_Id=" + str2});
        }
        String str3 = "";
        if (m28636b(str2)) {
            C2538c.e("HWPayManager", new Object[]{"ref_Id is null"});
            str2 = str3;
        } else {
            str2 = C0973a.e(str2);
            str2 = C0973a.a(1) + C0973a.e(str2.length() / 2) + str2;
        }
        ByteBuffer allocate = ByteBuffer.allocate(str2.length() / 2);
        allocate.put(C0973a.b(str2));
        m28630a(deviceCommand, allocate, 11, iBaseResponseCallback);
    }

    public void m28648b(String str, int i, IBaseResponseCallback iBaseResponseCallback) {
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(27);
        deviceCommand.setCommandID(13);
        String e = C0973a.e(str);
        String e2 = C0973a.e(e.length() / 2);
        String a = C0973a.a(1);
        String a2 = C0973a.a(i);
        String e3 = C0973a.e(a2.length() / 2);
        String a3 = C0973a.a(2);
        ByteBuffer allocate = ByteBuffer.allocate((((((e.length() / 2) + (e2.length() / 2)) + (a.length() / 2)) + (a2.length() / 2)) + (e3.length() / 2)) + (a3.length() / 2));
        allocate.put(C0973a.b(a));
        allocate.put(C0973a.b(e2));
        allocate.put(C0973a.b(e));
        allocate.put(C0973a.b(a3));
        allocate.put(C0973a.b(e3));
        allocate.put(C0973a.b(a2));
        m28630a(deviceCommand, allocate, 13, iBaseResponseCallback);
    }

    public void m28645a(String str, String str2, String str3, IBaseResponseCallback iBaseResponseCallback) {
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(27);
        deviceCommand.setCommandID(5);
        String e = C0973a.e(str);
        String e2 = C0973a.e(e.length() / 2);
        String a = C0973a.a(3);
        String e3 = C0973a.e(str2);
        String e4 = C0973a.e(e3.length() / 2);
        String a2 = C0973a.a(7);
        String e5 = C0973a.e(str3);
        String e6 = C0973a.e(e5.length() / 2);
        String a3 = C0973a.a(8);
        ByteBuffer allocate = ByteBuffer.allocate(((((((((a.length() / 2) + (e2.length() / 2)) + (e.length() / 2)) + (a2.length() / 2)) + (e4.length() / 2)) + (e3.length() / 2)) + (a3.length() / 2)) + (e6.length() / 2)) + (e5.length() / 2));
        allocate.put(C0973a.b(a));
        allocate.put(C0973a.b(e2));
        allocate.put(C0973a.b(e));
        allocate.put(C0973a.b(a2));
        allocate.put(C0973a.b(e4));
        allocate.put(C0973a.b(e3));
        allocate.put(C0973a.b(a3));
        allocate.put(C0973a.b(e6));
        allocate.put(C0973a.b(e5));
        m28630a(deviceCommand, allocate, 5, iBaseResponseCallback);
    }

    private void m28630a(DeviceCommand deviceCommand, ByteBuffer byteBuffer, int i, IBaseResponseCallback iBaseResponseCallback) {
        synchronized (C6184a.m28637c()) {
            if (iBaseResponseCallback != null) {
                List list = (List) f21694f.get(Integer.valueOf(i));
                if (list != null) {
                    C2538c.e("HWPayManager", new Object[]{"addToList() ,null != callbacks "});
                    list.add(iBaseResponseCallback);
                } else {
                    C2538c.e("HWPayManager", new Object[]{"addToList() callbacks is null"});
                }
            } else {
                C2538c.e("HWPayManager", new Object[]{"addToList() callback is null"});
            }
        }
        deviceCommand.setDataLen(byteBuffer.array().length);
        deviceCommand.setDataContent(byteBuffer.array());
        this.f21699e.a(deviceCommand);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m28633a(byte[] r15) {
        /*
        r14 = this;
        r4 = 0;
        r5 = r14.m28634b(r15);
        r0 = 100000; // 0x186a0 float:1.4013E-40 double:4.94066E-319;
        if (r0 != r5) goto L_0x001a;
    L_0x000a:
        r0 = 0;
        r1 = r0;
    L_0x000c:
        r0 = 1;
        r0 = r15[r0];
        switch(r0) {
            case 1: goto L_0x001d;
            case 2: goto L_0x009e;
            case 3: goto L_0x012d;
            case 4: goto L_0x0198;
            case 5: goto L_0x0203;
            case 6: goto L_0x0012;
            case 7: goto L_0x026e;
            case 8: goto L_0x0274;
            case 9: goto L_0x027a;
            case 10: goto L_0x0280;
            case 11: goto L_0x0473;
            case 12: goto L_0x0479;
            case 13: goto L_0x050e;
            default: goto L_0x0012;
        };
    L_0x0012:
        r2 = r4;
    L_0x0013:
        r0 = 1;
        r0 = r15[r0];
        r14.m28629a(r0, r1, r2);
        return;
    L_0x001a:
        r0 = -1;
        r1 = r0;
        goto L_0x000c;
    L_0x001d:
        r0 = com.huawei.hwcommonmodel.a.a(r15);
        r2 = 4;
        r3 = r0.length();
        r0 = r0.substring(r2, r3);
        r2 = r14.f21698d;	 Catch:{ t -> 0x007c }
        r0 = r2.m22743a(r0);	 Catch:{ t -> 0x007c }
        r2 = new com.huawei.datatype.PayOpenChannelInfo;	 Catch:{ t -> 0x007c }
        r2.<init>();	 Catch:{ t -> 0x007c }
        r3 = 0;
        r0 = r0.f17337a;	 Catch:{ t -> 0x0529 }
        r6 = r0.iterator();	 Catch:{ t -> 0x0529 }
        r1 = r4;
    L_0x003d:
        r0 = r6.hasNext();	 Catch:{ t -> 0x052e }
        if (r0 == 0) goto L_0x0076;
    L_0x0043:
        r0 = r6.next();	 Catch:{ t -> 0x052e }
        r0 = (com.huawei.hwcommonmodel.datatypes.C4752s) r0;	 Catch:{ t -> 0x052e }
        r4 = r0.m22732a();	 Catch:{ t -> 0x052e }
        r7 = 16;
        r4 = java.lang.Integer.parseInt(r4, r7);	 Catch:{ t -> 0x052e }
        switch(r4) {
            case 3: goto L_0x0062;
            case 4: goto L_0x0059;
            case 127: goto L_0x0071;
            default: goto L_0x0056;
        };	 Catch:{ t -> 0x052e }
    L_0x0056:
        r0 = r1;
    L_0x0057:
        r1 = r0;
        goto L_0x003d;
    L_0x0059:
        r0 = r0.m22733b();	 Catch:{ t -> 0x052e }
        r2.setApdu(r0);	 Catch:{ t -> 0x052e }
        r0 = r1;
        goto L_0x0057;
    L_0x0062:
        r0 = r0.m22733b();	 Catch:{ t -> 0x052e }
        r4 = 16;
        r0 = java.lang.Integer.parseInt(r0, r4);	 Catch:{ t -> 0x052e }
        r2.setChannelID(r0);	 Catch:{ t -> 0x052e }
        r0 = r1;
        goto L_0x0057;
    L_0x0071:
        r0 = java.lang.Integer.valueOf(r5);	 Catch:{ t -> 0x052e }
        goto L_0x0057;
    L_0x0076:
        if (r1 != 0) goto L_0x0079;
    L_0x0078:
        r1 = r2;
    L_0x0079:
        r2 = r1;
        r1 = r3;
        goto L_0x0013;
    L_0x007c:
        r0 = move-exception;
        r2 = r4;
    L_0x007e:
        r3 = "HWPayManager";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r7 = "getResult() COMMAND_ID_PAY_OPEN_CHANNEL PAY_OPEN_CHANNEL_APDU error e = ";
        r6 = r6.append(r7);
        r0 = r6.append(r0);
        r0 = r0.toString();
        r4[r5] = r0;
        com.huawei.v.c.e(r3, r4);
        goto L_0x0013;
    L_0x009e:
        r0 = com.huawei.hwcommonmodel.a.a(r15);
        r2 = 4;
        r3 = r0.length();
        r0 = r0.substring(r2, r3);
        r3 = new com.huawei.datatype.PayAPDUInfo;	 Catch:{ t -> 0x010b }
        r3.<init>();	 Catch:{ t -> 0x010b }
        r2 = r14.f21698d;	 Catch:{ t -> 0x010b }
        r0 = r2.m22743a(r0);	 Catch:{ t -> 0x010b }
        r0 = r0.f17337a;	 Catch:{ t -> 0x010b }
        r6 = r0.iterator();	 Catch:{ t -> 0x010b }
        r2 = r4;
    L_0x00bd:
        r0 = r6.hasNext();	 Catch:{ t -> 0x0526 }
        if (r0 == 0) goto L_0x0105;
    L_0x00c3:
        r0 = r6.next();	 Catch:{ t -> 0x0526 }
        r0 = (com.huawei.hwcommonmodel.datatypes.C4752s) r0;	 Catch:{ t -> 0x0526 }
        r4 = r0.m22732a();	 Catch:{ t -> 0x0526 }
        r7 = 16;
        r4 = java.lang.Integer.parseInt(r4, r7);	 Catch:{ t -> 0x0526 }
        switch(r4) {
            case 1: goto L_0x00d9;
            case 2: goto L_0x00e8;
            case 3: goto L_0x00f1;
            case 127: goto L_0x0100;
            default: goto L_0x00d6;
        };	 Catch:{ t -> 0x0526 }
    L_0x00d6:
        r0 = r2;
    L_0x00d7:
        r2 = r0;
        goto L_0x00bd;
    L_0x00d9:
        r0 = r0.m22733b();	 Catch:{ t -> 0x0526 }
        r4 = 16;
        r0 = java.lang.Integer.parseInt(r0, r4);	 Catch:{ t -> 0x0526 }
        r3.setReqid(r0);	 Catch:{ t -> 0x0526 }
        r0 = r2;
        goto L_0x00d7;
    L_0x00e8:
        r0 = r0.m22733b();	 Catch:{ t -> 0x0526 }
        r3.setApdu(r0);	 Catch:{ t -> 0x0526 }
        r0 = r2;
        goto L_0x00d7;
    L_0x00f1:
        r0 = r0.m22733b();	 Catch:{ t -> 0x0526 }
        r4 = 16;
        r0 = java.lang.Integer.parseInt(r0, r4);	 Catch:{ t -> 0x0526 }
        r3.setChannelID(r0);	 Catch:{ t -> 0x0526 }
        r0 = r2;
        goto L_0x00d7;
    L_0x0100:
        r0 = java.lang.Integer.valueOf(r5);	 Catch:{ t -> 0x0526 }
        goto L_0x00d7;
    L_0x0105:
        if (r2 != 0) goto L_0x0013;
    L_0x0107:
        r1 = 0;
        r2 = r3;
        goto L_0x0013;
    L_0x010b:
        r0 = move-exception;
        r2 = r4;
    L_0x010d:
        r3 = "HWPayManager";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r7 = "getResult() COMMAND_ID_PAY_EXECUTE_APDU error e = ";
        r6 = r6.append(r7);
        r0 = r6.append(r0);
        r0 = r0.toString();
        r4[r5] = r0;
        com.huawei.v.c.e(r3, r4);
        goto L_0x0013;
    L_0x012d:
        r0 = com.huawei.hwcommonmodel.a.a(r15);
        r2 = 4;
        r3 = r0.length();
        r0 = r0.substring(r2, r3);
        r2 = r14.f21698d;	 Catch:{ t -> 0x0176 }
        r0 = r2.m22743a(r0);	 Catch:{ t -> 0x0176 }
        r0 = r0.f17337a;	 Catch:{ t -> 0x0176 }
        r3 = r0.iterator();	 Catch:{ t -> 0x0176 }
        r2 = r4;
    L_0x0147:
        r0 = r3.hasNext();	 Catch:{ t -> 0x0523 }
        if (r0 == 0) goto L_0x0013;
    L_0x014d:
        r0 = r3.next();	 Catch:{ t -> 0x0523 }
        r0 = (com.huawei.hwcommonmodel.datatypes.C4752s) r0;	 Catch:{ t -> 0x0523 }
        r4 = r0.m22732a();	 Catch:{ t -> 0x0523 }
        r6 = 16;
        r4 = java.lang.Integer.parseInt(r4, r6);	 Catch:{ t -> 0x0523 }
        switch(r4) {
            case 2: goto L_0x0165;
            case 127: goto L_0x016e;
            default: goto L_0x0160;
        };	 Catch:{ t -> 0x0523 }
    L_0x0160:
        r0 = r1;
        r1 = r2;
    L_0x0162:
        r2 = r1;
        r1 = r0;
        goto L_0x0147;
    L_0x0165:
        r1 = 0;
        r0 = r0.m22733b();	 Catch:{ t -> 0x0523 }
        r13 = r1;
        r1 = r0;
        r0 = r13;
        goto L_0x0162;
    L_0x016e:
        r0 = java.lang.Integer.valueOf(r5);	 Catch:{ t -> 0x0523 }
        r13 = r1;
        r1 = r0;
        r0 = r13;
        goto L_0x0162;
    L_0x0176:
        r0 = move-exception;
        r2 = r4;
    L_0x0178:
        r3 = "HWPayManager";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r7 = "getResult() COMMAND_ID_PAY_CLOSE_CHANNEL error e = ";
        r6 = r6.append(r7);
        r0 = r6.append(r0);
        r0 = r0.toString();
        r4[r5] = r0;
        com.huawei.v.c.e(r3, r4);
        goto L_0x0013;
    L_0x0198:
        r0 = com.huawei.hwcommonmodel.a.a(r15);
        r2 = 4;
        r3 = r0.length();
        r0 = r0.substring(r2, r3);
        r2 = r14.f21698d;	 Catch:{ t -> 0x01e1 }
        r0 = r2.m22743a(r0);	 Catch:{ t -> 0x01e1 }
        r0 = r0.f17337a;	 Catch:{ t -> 0x01e1 }
        r3 = r0.iterator();	 Catch:{ t -> 0x01e1 }
        r2 = r4;
    L_0x01b2:
        r0 = r3.hasNext();	 Catch:{ t -> 0x0520 }
        if (r0 == 0) goto L_0x0013;
    L_0x01b8:
        r0 = r3.next();	 Catch:{ t -> 0x0520 }
        r0 = (com.huawei.hwcommonmodel.datatypes.C4752s) r0;	 Catch:{ t -> 0x0520 }
        r4 = r0.m22732a();	 Catch:{ t -> 0x0520 }
        r6 = 16;
        r4 = java.lang.Integer.parseInt(r4, r6);	 Catch:{ t -> 0x0520 }
        switch(r4) {
            case 1: goto L_0x01d0;
            case 127: goto L_0x01d9;
            default: goto L_0x01cb;
        };	 Catch:{ t -> 0x0520 }
    L_0x01cb:
        r0 = r1;
        r1 = r2;
    L_0x01cd:
        r2 = r1;
        r1 = r0;
        goto L_0x01b2;
    L_0x01d0:
        r1 = 0;
        r0 = r0.m22733b();	 Catch:{ t -> 0x0520 }
        r13 = r1;
        r1 = r0;
        r0 = r13;
        goto L_0x01cd;
    L_0x01d9:
        r0 = java.lang.Integer.valueOf(r5);	 Catch:{ t -> 0x0520 }
        r13 = r1;
        r1 = r0;
        r0 = r13;
        goto L_0x01cd;
    L_0x01e1:
        r0 = move-exception;
        r2 = r4;
    L_0x01e3:
        r3 = "HWPayManager";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r7 = "getResult() COMMAND_ID_PAY_GET_CPLC error e = ";
        r6 = r6.append(r7);
        r0 = r6.append(r0);
        r0 = r0.toString();
        r4[r5] = r0;
        com.huawei.v.c.e(r3, r4);
        goto L_0x0013;
    L_0x0203:
        r0 = com.huawei.hwcommonmodel.a.a(r15);
        r2 = 4;
        r3 = r0.length();
        r0 = r0.substring(r2, r3);
        r2 = r14.f21698d;	 Catch:{ t -> 0x024c }
        r0 = r2.m22743a(r0);	 Catch:{ t -> 0x024c }
        r0 = r0.f17337a;	 Catch:{ t -> 0x024c }
        r3 = r0.iterator();	 Catch:{ t -> 0x024c }
        r2 = r4;
    L_0x021d:
        r0 = r3.hasNext();	 Catch:{ t -> 0x051d }
        if (r0 == 0) goto L_0x0013;
    L_0x0223:
        r0 = r3.next();	 Catch:{ t -> 0x051d }
        r0 = (com.huawei.hwcommonmodel.datatypes.C4752s) r0;	 Catch:{ t -> 0x051d }
        r4 = r0.m22732a();	 Catch:{ t -> 0x051d }
        r6 = 16;
        r4 = java.lang.Integer.parseInt(r4, r6);	 Catch:{ t -> 0x051d }
        switch(r4) {
            case 1: goto L_0x023b;
            case 127: goto L_0x0244;
            default: goto L_0x0236;
        };	 Catch:{ t -> 0x051d }
    L_0x0236:
        r0 = r1;
        r1 = r2;
    L_0x0238:
        r2 = r1;
        r1 = r0;
        goto L_0x021d;
    L_0x023b:
        r1 = 0;
        r0 = r0.m22733b();	 Catch:{ t -> 0x051d }
        r13 = r1;
        r1 = r0;
        r0 = r13;
        goto L_0x0238;
    L_0x0244:
        r0 = java.lang.Integer.valueOf(r5);	 Catch:{ t -> 0x051d }
        r13 = r1;
        r1 = r0;
        r0 = r13;
        goto L_0x0238;
    L_0x024c:
        r0 = move-exception;
        r2 = r4;
    L_0x024e:
        r3 = "HWPayManager";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r7 = "getResult() COMMAND_ID_PAY_GET_BTC error e = ";
        r6 = r6.append(r7);
        r0 = r6.append(r0);
        r0 = r0.toString();
        r4[r5] = r0;
        com.huawei.v.c.e(r3, r4);
        goto L_0x0013;
    L_0x026e:
        r2 = java.lang.Integer.valueOf(r5);
        goto L_0x0013;
    L_0x0274:
        r2 = java.lang.Integer.valueOf(r5);
        goto L_0x0013;
    L_0x027a:
        r2 = java.lang.Integer.valueOf(r5);
        goto L_0x0013;
    L_0x0280:
        r0 = com.huawei.hwcommonmodel.a.a(r15);
        r2 = "HWPayManager";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r5 = 0;
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r7 = "List,messageHex=";
        r6 = r6.append(r7);
        r6 = r6.append(r0);
        r6 = r6.toString();
        r3[r5] = r6;
        com.huawei.v.c.b(r2, r3);
        r2 = 4;
        r3 = r0.length();
        if (r2 >= r3) goto L_0x0012;
    L_0x02a9:
        r2 = 4;
        r3 = r0.length();
        r0 = r0.substring(r2, r3);
        r2 = new com.huawei.hwcommonmodel.datatypes.w;	 Catch:{ t -> 0x037b }
        r2.<init>();	 Catch:{ t -> 0x037b }
        r0 = r2.m22743a(r0);	 Catch:{ t -> 0x037b }
        r0 = r0.f17338b;	 Catch:{ t -> 0x037b }
        r2 = new java.util.ArrayList;	 Catch:{ t -> 0x037b }
        r2.<init>();	 Catch:{ t -> 0x037b }
        r1 = 0;
        r3 = r0.iterator();	 Catch:{ t -> 0x037b }
    L_0x02c7:
        r0 = r3.hasNext();	 Catch:{ t -> 0x037b }
        if (r0 == 0) goto L_0x0013;
    L_0x02cd:
        r0 = r3.next();	 Catch:{ t -> 0x037b }
        r0 = (com.huawei.hwcommonmodel.datatypes.C4754u) r0;	 Catch:{ t -> 0x037b }
        r0 = r0.f17338b;	 Catch:{ t -> 0x037b }
        r5 = r0.iterator();	 Catch:{ t -> 0x037b }
    L_0x02d9:
        r0 = r5.hasNext();	 Catch:{ t -> 0x037b }
        if (r0 == 0) goto L_0x02c7;
    L_0x02df:
        r0 = r5.next();	 Catch:{ t -> 0x037b }
        r0 = (com.huawei.hwcommonmodel.datatypes.C4754u) r0;	 Catch:{ t -> 0x037b }
        r0 = r0.f17337a;	 Catch:{ t -> 0x037b }
        r6 = "HWPayManager";
        r7 = 1;
        r7 = new java.lang.Object[r7];	 Catch:{ t -> 0x037b }
        r8 = 0;
        r9 = new java.lang.StringBuilder;	 Catch:{ t -> 0x037b }
        r9.<init>();	 Catch:{ t -> 0x037b }
        r10 = "List,childtlv=";
        r9 = r9.append(r10);	 Catch:{ t -> 0x037b }
        r10 = r0.size();	 Catch:{ t -> 0x037b }
        r9 = r9.append(r10);	 Catch:{ t -> 0x037b }
        r9 = r9.toString();	 Catch:{ t -> 0x037b }
        r7[r8] = r9;	 Catch:{ t -> 0x037b }
        com.huawei.v.c.b(r6, r7);	 Catch:{ t -> 0x037b }
        r6 = new com.huawei.z.a.a;	 Catch:{ t -> 0x037b }
        r6.<init>();	 Catch:{ t -> 0x037b }
        r7 = r0.iterator();	 Catch:{ t -> 0x037b }
    L_0x0312:
        r0 = r7.hasNext();	 Catch:{ t -> 0x037b }
        if (r0 == 0) goto L_0x046a;
    L_0x0318:
        r0 = r7.next();	 Catch:{ t -> 0x037b }
        r0 = (com.huawei.hwcommonmodel.datatypes.C4752s) r0;	 Catch:{ t -> 0x037b }
        r8 = "HWPayManager";
        r9 = 1;
        r9 = new java.lang.Object[r9];	 Catch:{ t -> 0x037b }
        r10 = 0;
        r11 = new java.lang.StringBuilder;	 Catch:{ t -> 0x037b }
        r11.<init>();	 Catch:{ t -> 0x037b }
        r12 = "List,getTag=";
        r11 = r11.append(r12);	 Catch:{ t -> 0x037b }
        r12 = r0.m22732a();	 Catch:{ t -> 0x037b }
        r11 = r11.append(r12);	 Catch:{ t -> 0x037b }
        r11 = r11.toString();	 Catch:{ t -> 0x037b }
        r9[r10] = r11;	 Catch:{ t -> 0x037b }
        com.huawei.v.c.b(r8, r9);	 Catch:{ t -> 0x037b }
        r8 = "HWPayManager";
        r9 = 1;
        r9 = new java.lang.Object[r9];	 Catch:{ t -> 0x037b }
        r10 = 0;
        r11 = new java.lang.StringBuilder;	 Catch:{ t -> 0x037b }
        r11.<init>();	 Catch:{ t -> 0x037b }
        r12 = "List,getValue=";
        r11 = r11.append(r12);	 Catch:{ t -> 0x037b }
        r12 = r0.m22733b();	 Catch:{ t -> 0x037b }
        r11 = r11.append(r12);	 Catch:{ t -> 0x037b }
        r11 = r11.toString();	 Catch:{ t -> 0x037b }
        r9[r10] = r11;	 Catch:{ t -> 0x037b }
        com.huawei.v.c.b(r8, r9);	 Catch:{ t -> 0x037b }
        r8 = r0.m22732a();	 Catch:{ t -> 0x037b }
        r9 = 16;
        r8 = java.lang.Integer.parseInt(r8, r9);	 Catch:{ t -> 0x037b }
        switch(r8) {
            case 3: goto L_0x0370;
            case 4: goto L_0x038c;
            case 5: goto L_0x0398;
            case 6: goto L_0x03a4;
            case 7: goto L_0x03b0;
            case 8: goto L_0x03c5;
            case 9: goto L_0x03dc;
            case 10: goto L_0x03e8;
            case 11: goto L_0x03f4;
            case 12: goto L_0x0400;
            case 13: goto L_0x040c;
            case 14: goto L_0x041a;
            case 15: goto L_0x0428;
            case 16: goto L_0x0436;
            case 17: goto L_0x0442;
            case 18: goto L_0x0450;
            case 19: goto L_0x045c;
            default: goto L_0x036f;
        };	 Catch:{ t -> 0x037b }
    L_0x036f:
        goto L_0x0312;
    L_0x0370:
        r0 = r0.m22733b();	 Catch:{ t -> 0x037b }
        r0 = com.huawei.hwcommonmodel.a.c(r0);	 Catch:{ t -> 0x037b }
        r6.f21673a = r0;	 Catch:{ t -> 0x037b }
        goto L_0x0312;
    L_0x037b:
        r0 = move-exception;
        r0 = "HWPayManager";
        r2 = 1;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r5 = "cardList TLV error";
        r2[r3] = r5;
        com.huawei.v.c.e(r0, r2);
        r2 = r4;
        goto L_0x0013;
    L_0x038c:
        r0 = r0.m22733b();	 Catch:{ t -> 0x037b }
        r0 = com.huawei.hwcommonmodel.a.c(r0);	 Catch:{ t -> 0x037b }
        r6.f21674b = r0;	 Catch:{ t -> 0x037b }
        goto L_0x0312;
    L_0x0398:
        r0 = r0.m22733b();	 Catch:{ t -> 0x037b }
        r0 = com.huawei.hwcommonmodel.a.c(r0);	 Catch:{ t -> 0x037b }
        r6.f21685m = r0;	 Catch:{ t -> 0x037b }
        goto L_0x0312;
    L_0x03a4:
        r0 = r0.m22733b();	 Catch:{ t -> 0x037b }
        r0 = com.huawei.hwcommonmodel.a.c(r0);	 Catch:{ t -> 0x037b }
        r6.f21675c = r0;	 Catch:{ t -> 0x037b }
        goto L_0x0312;
    L_0x03b0:
        r0 = r0.m22733b();	 Catch:{ t -> 0x037b }
        r8 = 16;
        r0 = java.lang.Integer.parseInt(r0, r8);	 Catch:{ t -> 0x037b }
        r6.f21676d = r0;	 Catch:{ t -> 0x037b }
        r0 = r6.f21676d;	 Catch:{ t -> 0x037b }
        if (r0 != 0) goto L_0x0312;
    L_0x03c0:
        r0 = 2;
        r6.f21676d = r0;	 Catch:{ t -> 0x037b }
        goto L_0x0312;
    L_0x03c5:
        r0 = r0.m22733b();	 Catch:{ t -> 0x037b }
        r8 = 16;
        r0 = java.lang.Integer.parseInt(r0, r8);	 Catch:{ t -> 0x037b }
        r8 = 1;
        if (r8 != r0) goto L_0x03d7;
    L_0x03d2:
        r0 = 1;
        r6.f21677e = r0;	 Catch:{ t -> 0x037b }
        goto L_0x0312;
    L_0x03d7:
        r0 = 0;
        r6.f21677e = r0;	 Catch:{ t -> 0x037b }
        goto L_0x0312;
    L_0x03dc:
        r0 = r0.m22733b();	 Catch:{ t -> 0x037b }
        r0 = com.huawei.hwcommonmodel.a.c(r0);	 Catch:{ t -> 0x037b }
        r6.f21678f = r0;	 Catch:{ t -> 0x037b }
        goto L_0x0312;
    L_0x03e8:
        r0 = r0.m22733b();	 Catch:{ t -> 0x037b }
        r0 = com.huawei.hwcommonmodel.a.c(r0);	 Catch:{ t -> 0x037b }
        r6.f21679g = r0;	 Catch:{ t -> 0x037b }
        goto L_0x0312;
    L_0x03f4:
        r0 = r0.m22733b();	 Catch:{ t -> 0x037b }
        r0 = com.huawei.hwcommonmodel.a.c(r0);	 Catch:{ t -> 0x037b }
        r6.f21680h = r0;	 Catch:{ t -> 0x037b }
        goto L_0x0312;
    L_0x0400:
        r0 = r0.m22733b();	 Catch:{ t -> 0x037b }
        r0 = com.huawei.hwcommonmodel.a.c(r0);	 Catch:{ t -> 0x037b }
        r6.f21681i = r0;	 Catch:{ t -> 0x037b }
        goto L_0x0312;
    L_0x040c:
        r0 = r0.m22733b();	 Catch:{ t -> 0x037b }
        r8 = 16;
        r0 = java.lang.Integer.parseInt(r0, r8);	 Catch:{ t -> 0x037b }
        r6.f21682j = r0;	 Catch:{ t -> 0x037b }
        goto L_0x0312;
    L_0x041a:
        r0 = r0.m22733b();	 Catch:{ t -> 0x037b }
        r8 = 16;
        r8 = java.lang.Long.parseLong(r0, r8);	 Catch:{ t -> 0x037b }
        r6.f21683k = r8;	 Catch:{ t -> 0x037b }
        goto L_0x0312;
    L_0x0428:
        r0 = r0.m22733b();	 Catch:{ t -> 0x037b }
        r8 = 16;
        r0 = java.lang.Integer.parseInt(r0, r8);	 Catch:{ t -> 0x037b }
        r6.f21684l = r0;	 Catch:{ t -> 0x037b }
        goto L_0x0312;
    L_0x0436:
        r0 = r0.m22733b();	 Catch:{ t -> 0x037b }
        r0 = com.huawei.hwcommonmodel.a.c(r0);	 Catch:{ t -> 0x037b }
        r6.f21688p = r0;	 Catch:{ t -> 0x037b }
        goto L_0x0312;
    L_0x0442:
        r0 = r0.m22733b();	 Catch:{ t -> 0x037b }
        r8 = 16;
        r8 = java.lang.Long.parseLong(r0, r8);	 Catch:{ t -> 0x037b }
        r6.f21689q = r8;	 Catch:{ t -> 0x037b }
        goto L_0x0312;
    L_0x0450:
        r0 = r0.m22733b();	 Catch:{ t -> 0x037b }
        r0 = com.huawei.hwcommonmodel.a.c(r0);	 Catch:{ t -> 0x037b }
        r6.f21686n = r0;	 Catch:{ t -> 0x037b }
        goto L_0x0312;
    L_0x045c:
        r0 = r0.m22733b();	 Catch:{ t -> 0x037b }
        r8 = 16;
        r8 = java.lang.Long.parseLong(r0, r8);	 Catch:{ t -> 0x037b }
        r6.f21687o = r8;	 Catch:{ t -> 0x037b }
        goto L_0x0312;
    L_0x046a:
        r0 = r6.m28620a();	 Catch:{ t -> 0x037b }
        r2.add(r0);	 Catch:{ t -> 0x037b }
        goto L_0x02d9;
    L_0x0473:
        r2 = java.lang.Integer.valueOf(r5);
        goto L_0x0013;
    L_0x0479:
        r0 = com.huawei.hwcommonmodel.a.a(r15);
        r2 = 4;
        r3 = r0.length();
        r0 = r0.substring(r2, r3);
        r2 = r14.f21698d;	 Catch:{ Exception -> 0x04ec }
        r0 = r2.m22743a(r0);	 Catch:{ Exception -> 0x04ec }
        r3 = new com.huawei.z.a.b;	 Catch:{ Exception -> 0x04ec }
        r3.<init>();	 Catch:{ Exception -> 0x04ec }
        r2 = 0;
        r0 = r0.f17337a;	 Catch:{ Exception -> 0x0514 }
        r6 = r0.iterator();	 Catch:{ Exception -> 0x0514 }
        r1 = r4;
    L_0x0499:
        r0 = r6.hasNext();	 Catch:{ Exception -> 0x0518 }
        if (r0 == 0) goto L_0x04e3;
    L_0x049f:
        r0 = r6.next();	 Catch:{ Exception -> 0x0518 }
        r0 = (com.huawei.hwcommonmodel.datatypes.C4752s) r0;	 Catch:{ Exception -> 0x0518 }
        r4 = r0.m22732a();	 Catch:{ Exception -> 0x0518 }
        r7 = 16;
        r4 = java.lang.Integer.parseInt(r4, r7);	 Catch:{ Exception -> 0x0518 }
        switch(r4) {
            case 1: goto L_0x04b5;
            case 2: goto L_0x04c2;
            case 3: goto L_0x04cf;
            case 127: goto L_0x04de;
            default: goto L_0x04b2;
        };	 Catch:{ Exception -> 0x0518 }
    L_0x04b2:
        r0 = r1;
    L_0x04b3:
        r1 = r0;
        goto L_0x0499;
    L_0x04b5:
        r0 = r0.m22733b();	 Catch:{ Exception -> 0x0518 }
        r0 = com.huawei.hwcommonmodel.a.c(r0);	 Catch:{ Exception -> 0x0518 }
        r3.m28624a(r0);	 Catch:{ Exception -> 0x0518 }
        r0 = r1;
        goto L_0x04b3;
    L_0x04c2:
        r0 = r0.m22733b();	 Catch:{ Exception -> 0x0518 }
        r0 = com.huawei.hwcommonmodel.a.c(r0);	 Catch:{ Exception -> 0x0518 }
        r3.m28625b(r0);	 Catch:{ Exception -> 0x0518 }
        r0 = r1;
        goto L_0x04b3;
    L_0x04cf:
        r0 = r0.m22733b();	 Catch:{ Exception -> 0x0518 }
        r4 = 16;
        r0 = java.lang.Integer.parseInt(r0, r4);	 Catch:{ Exception -> 0x0518 }
        r3.m28623a(r0);	 Catch:{ Exception -> 0x0518 }
        r0 = r1;
        goto L_0x04b3;
    L_0x04de:
        r0 = java.lang.Integer.valueOf(r5);	 Catch:{ Exception -> 0x0518 }
        goto L_0x04b3;
    L_0x04e3:
        r1 = r3.m28622a();	 Catch:{ Exception -> 0x0518 }
        r13 = r2;
        r2 = r1;
        r1 = r13;
        goto L_0x0013;
    L_0x04ec:
        r0 = move-exception;
        r2 = r4;
    L_0x04ee:
        r3 = "HWPayManager";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r7 = "getResult() COMMAND_ID_PAY_ABILITY error e = ";
        r6 = r6.append(r7);
        r0 = r6.append(r0);
        r0 = r0.toString();
        r4[r5] = r0;
        com.huawei.v.c.e(r3, r4);
        goto L_0x0013;
    L_0x050e:
        r2 = java.lang.Integer.valueOf(r5);
        goto L_0x0013;
    L_0x0514:
        r0 = move-exception;
        r1 = r2;
        r2 = r4;
        goto L_0x04ee;
    L_0x0518:
        r0 = move-exception;
        r13 = r2;
        r2 = r1;
        r1 = r13;
        goto L_0x04ee;
    L_0x051d:
        r0 = move-exception;
        goto L_0x024e;
    L_0x0520:
        r0 = move-exception;
        goto L_0x01e3;
    L_0x0523:
        r0 = move-exception;
        goto L_0x0178;
    L_0x0526:
        r0 = move-exception;
        goto L_0x010d;
    L_0x0529:
        r0 = move-exception;
        r1 = r3;
        r2 = r4;
        goto L_0x007e;
    L_0x052e:
        r0 = move-exception;
        r2 = r1;
        r1 = r3;
        goto L_0x007e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.z.a.a(byte[]):void");
    }

    private void m28629a(int i, int i2, Object obj) {
        synchronized (C6184a.m28637c()) {
            List list = (List) f21694f.get(Integer.valueOf(i));
            if (list == null) {
                C2538c.c("HWPayManager", new Object[]{"procCallback callback,callbackList is null"});
            } else if (obj != null && list.size() != 0) {
                C2538c.c("HWPayManager", new Object[]{"procCallback callback,commandID=" + i});
                ((IBaseResponseCallback) list.get(0)).onResponse(i2, obj);
                list.remove(0);
            } else if (list.size() != 0) {
                ((IBaseResponseCallback) list.get(0)).onResponse(100001, "UNKNOWN_ERROR");
                list.remove(0);
            }
        }
    }

    private int m28634b(byte[] bArr) {
        String a = C0973a.a(bArr);
        try {
            return Integer.parseInt(a.substring(8, a.length()), 16);
        } catch (Exception e) {
            return 0;
        }
    }

    protected Integer getModuleId() {
        return Integer.valueOf(27);
    }

    protected void onDestroy() {
        super.onDestroy();
        this.f21699e.a(27);
        synchronized (C6184a.m28637c()) {
            for (int i = 0; i < f21695g.size(); i++) {
                if (f21694f.get(f21695g.get(i)) != null) {
                    ((List) f21694f.get(f21695g.get(i))).clear();
                }
            }
        }
        m28638d();
        C2538c.c("HWPayManager", new Object[]{"onDestroy()"});
        this.f21697c = null;
        f21693a = null;
        C2538c.c("HWPayManager", new Object[]{"onDestroy() complete"});
    }

    private static synchronized Object m28637c() {
        Map map;
        synchronized (C6184a.class) {
            map = f21694f;
        }
        return map;
    }

    public void m28653e(IBaseResponseCallback iBaseResponseCallback) {
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(27);
        deviceCommand.setCommandID(12);
        String a = C0973a.a(1);
        String e = C0973a.e(0);
        ByteBuffer allocate = ByteBuffer.allocate((e.length() / 2) + (a.length() / 2));
        allocate.put(C0973a.b(a));
        allocate.put(C0973a.b(e));
        m28630a(deviceCommand, allocate, 12, iBaseResponseCallback);
    }

    private boolean m28636b(String str) {
        if (str == null || "".equals(str)) {
            return true;
        }
        return false;
    }

    public void m28642a(C4480d c4480d) {
        this.f21697c = c4480d;
    }

    private void m28638d() {
        try {
            C2538c.c("HWPayManager", new Object[]{"Enter unregisterNonLocalBroadcast()!"});
            this.f21696b.unregisterReceiver(this.f21701i);
        } catch (IllegalArgumentException e) {
            C2538c.c("HWPayManager", new Object[]{e.getMessage()});
        }
    }

    private void m28639e() {
        this.f21696b.registerReceiver(this.f21701i, new IntentFilter("com.huawei.bone.action.CONNECTION_STATE_CHANGED"), com.huawei.hwcommonmodel.b.c.a, null);
    }
}
