package com.huawei.p461i;

import android.support.v4.media.TransportMediator;
import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import com.huawei.datatype.EventAlarmInfo;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.hwdevicemgr.dmsdatatype.datatype.DeviceCommand;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: HWAlarmManager */
class C5394b implements IBaseResponseCallback {
    final /* synthetic */ List f19204a;
    final /* synthetic */ boolean f19205b;
    final /* synthetic */ IBaseResponseCallback f19206c;
    final /* synthetic */ C5393a f19207d;

    C5394b(C5393a c5393a, List list, boolean z, IBaseResponseCallback iBaseResponseCallback) {
        this.f19207d = c5393a;
        this.f19204a = list;
        this.f19205b = z;
        this.f19206c = iBaseResponseCallback;
    }

    public void onResponse(int i, Object obj) {
        List list = (List) obj;
        if (list.size() != 0) {
            this.f19207d.m25963c(list);
        }
        if (this.f19207d.m25988c() == 0) {
            this.f19207d.m25986b(this.f19204a);
        } else {
            ByteBuffer allocate;
            DeviceCommand deviceCommand = new DeviceCommand();
            deviceCommand.setServiceID(8);
            deviceCommand.setCommandID(1);
            List<ByteBuffer> arrayList = new ArrayList();
            int i2 = 0;
            for (int i3 = 0; i3 < C5393a.f19188h; i3++) {
                if (i3 >= this.f19204a.size()) {
                    allocate = ByteBuffer.allocate(5);
                    allocate.put(TagName.ACTIVITY_NAME);
                    allocate.put((byte) 3);
                    allocate.put((byte) 3);
                    allocate.put((byte) 1);
                    allocate.put((byte) (i3 + 1));
                } else {
                    String a = a.a(i3 + 1);
                    String a2 = a.a(1);
                    String a3 = a.a(3);
                    String a4 = a.a(((EventAlarmInfo) this.f19204a.get(i3)).getEventAlarmEnable());
                    String a5 = a.a(1);
                    String a6 = a.a(4);
                    String b = a.b(a.c(((EventAlarmInfo) this.f19204a.get(i3)).getEventAlarmStartTime_mins() + (((EventAlarmInfo) this.f19204a.get(i3)).getEventAlarmStartTime_hour() * 100)));
                    String a7 = a.a(2);
                    String a8 = a.a(5);
                    String a9 = a.a(((EventAlarmInfo) this.f19204a.get(i3)).getEventAlarmRepeat());
                    String a10 = a.a(1);
                    String a11 = a.a(6);
                    String e = a.e(((EventAlarmInfo) this.f19204a.get(i3)).getEventAlarmName());
                    e = a3 + a2 + a + a6 + a5 + a4 + a8 + a7 + b + a11 + a10 + a9 + a.a(7) + a.e(e.length() / 2) + e;
                    byte[] b2 = a.b(a.a(TransportMediator.KEYCODE_MEDIA_RECORD) + a.e(e.length() / 2) + e);
                    allocate = ByteBuffer.allocate(b2.length);
                    allocate.put(b2);
                }
                i2 += allocate.array().length;
                arrayList.add(allocate);
            }
            byte[] b3 = C0973a.b(C0973a.e(i2));
            ByteBuffer allocate2 = ByteBuffer.allocate((b3.length + i2) + 1);
            allocate2.put(TagName.ACTIVITY);
            allocate2.put(b3);
            for (ByteBuffer allocate3 : arrayList) {
                allocate2.put(allocate3.array());
            }
            deviceCommand.setDataLen(allocate2.array().length);
            deviceCommand.setDataContent(allocate2.array());
            this.f19207d.f19194e.a(deviceCommand);
        }
        if (this.f19205b) {
            synchronized (C5393a.m25973l()) {
                C5393a.f19186f.add(this.f19206c);
            }
            this.f19207d.m25954a(this.f19204a, null);
            return;
        }
        this.f19207d.m25954a(this.f19204a, this.f19206c);
    }
}
