package com.huawei.p461i;

import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import com.huawei.datatype.SmartAlarmInfo;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.hwdevicemgr.dmsdatatype.datatype.DeviceCommand;
import com.huawei.p190v.C2538c;

import java.nio.ByteBuffer;
import java.util.List;

/* compiled from: HWAlarmManager */
class C5395c implements IBaseResponseCallback {
    final /* synthetic */ List f19208a;
    final /* synthetic */ boolean f19209b;
    final /* synthetic */ IBaseResponseCallback f19210c;
    final /* synthetic */ C5393a f19211d;

    C5395c(C5393a c5393a, List list, boolean z, IBaseResponseCallback iBaseResponseCallback) {
        this.f19211d = c5393a;
        this.f19208a = list;
        this.f19209b = z;
        this.f19210c = iBaseResponseCallback;
    }

    public void onResponse(int i, Object obj) {
        List list = (List) obj;
        if (list.size() != 0) {
            this.f19211d.m25965d(list);
        }
        if (this.f19211d.m25988c() == 0) {
            this.f19211d.m25981a(this.f19208a);
        } else {
            SmartAlarmInfo smartAlarmInfo;
            ByteBuffer allocate;
            byte[] b;
            C2538c.c("HWAlarmManager", new Object[]{"setSmartAlarm() before smartAlarmInfoList.size() = " + this.f19208a.size()});
            if (this.f19208a.size() > 1) {
                smartAlarmInfo = (SmartAlarmInfo) this.f19208a.get(0);
                this.f19208a.clear();
                this.f19208a.add(smartAlarmInfo);
            }
            C2538c.c("HWAlarmManager", new Object[]{"setSmartAlarm() after smartAlarmInfoList.size() = " + this.f19208a.size()});
            DeviceCommand deviceCommand = new DeviceCommand();
            deviceCommand.setServiceID(8);
            deviceCommand.setCommandID(2);
            int size = this.f19208a.size() * 18;
            if (255 < size) {
                allocate = ByteBuffer.allocate(size + 3);
                b = C0973a.b(C0973a.b(size));
            } else {
                allocate = ByteBuffer.allocate(size + 2);
                b = C0973a.b(C0973a.a(size));
            }
            allocate.put(TagName.ACTIVITY);
            allocate.put(b);
            for (SmartAlarmInfo smartAlarmInfo2 : this.f19208a) {
                allocate.put(TagName.ACTIVITY_NAME);
                allocate.put(C0973a.b(C0973a.a(16)));
                allocate.put((byte) 3);
                allocate.put((byte) 1);
                allocate.put(C0973a.b(C0973a.a(smartAlarmInfo2.getSmartAlarmIndex())));
                allocate.put((byte) 4);
                allocate.put((byte) 1);
                allocate.put(C0973a.b(C0973a.a(smartAlarmInfo2.getSmartAlarmEnable())));
                allocate.put((byte) 5);
                allocate.put((byte) 2);
                allocate.put(C0973a.b(C0973a.b(C0973a.c((smartAlarmInfo2.getSmartAlarmStartTime_hour() * 100) + smartAlarmInfo2.getSmartAlarmStartTime_mins()))));
                allocate.put((byte) 6);
                allocate.put((byte) 1);
                allocate.put(C0973a.b(C0973a.a(smartAlarmInfo2.getSmartAlarmRepeat())));
                allocate.put((byte) 7);
                allocate.put((byte) 1);
                allocate.put(C0973a.b(C0973a.a(smartAlarmInfo2.getSmartAlarmAheadTime())));
            }
            deviceCommand.setDataLen(allocate.array().length);
            deviceCommand.setDataContent(allocate.array());
            this.f19211d.f19194e.a(deviceCommand);
        }
        if (this.f19209b) {
            synchronized (C5393a.m25974m()) {
                C5393a.f19187g.add(this.f19210c);
            }
            this.f19211d.m25960b(this.f19208a, null);
            return;
        }
        this.f19211d.m25960b(this.f19208a, this.f19210c);
    }
}
