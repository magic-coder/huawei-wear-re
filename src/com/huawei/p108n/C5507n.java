package com.huawei.p108n;

import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import com.huawei.datatype.DataDeviceAvoidDisturbInfo;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.hwcommonmodel.datatypes.DeviceCapability;
import com.huawei.hwdevicemgr.dmsdatatype.datatype.DeviceCommand;
import com.huawei.n.c;
import com.huawei.p190v.C2538c;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: HWDeviceConfigManager */
class C5507n implements IBaseResponseCallback {
    final /* synthetic */ DeviceCapability f19409a;
    final /* synthetic */ List f19410b;
    final /* synthetic */ IBaseResponseCallback f19411c;
    final /* synthetic */ boolean f19412d;
    final /* synthetic */ c f19413e;

    C5507n(c cVar, DeviceCapability deviceCapability, List list, IBaseResponseCallback iBaseResponseCallback, boolean z) {
        this.f19413e = cVar;
        this.f19409a = deviceCapability;
        this.f19410b = list;
        this.f19411c = iBaseResponseCallback;
        this.f19412d = z;
    }

    public void onResponse(int i, Object obj) {
        List<DataDeviceAvoidDisturbInfo> list = (List) obj;
        if (list.size() != 0) {
            List arrayList = new ArrayList();
            for (DataDeviceAvoidDisturbInfo device_avoid_disturb_index : list) {
                arrayList.add(Integer.valueOf(device_avoid_disturb_index.getDevice_avoid_disturb_index()));
            }
            this.f19413e.a(arrayList, c.a(this.f19413e));
        }
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(1);
        deviceCommand.setCommandID(12);
        ByteBuffer allocate = ByteBuffer.allocate(22);
        if (this.f19409a != null && this.f19409a.isSupportQueryAllowDisturbContent()) {
            allocate = ByteBuffer.allocate(26);
        }
        for (DataDeviceAvoidDisturbInfo device_avoid_disturb_index2 : this.f19410b) {
            byte[] b;
            C2538c.a("03", 1, "HWDeviceConfigManager", new Object[]{"addDeviceAvoidDisturbingInfo:" + device_avoid_disturb_index2});
            allocate.put(TagName.ACTIVITY);
            if (this.f19409a == null || !this.f19409a.isSupportQueryAllowDisturbContent()) {
                allocate.put(TagName.ORDER_TIME);
            } else {
                allocate.put(TagName.ORDER_INVOICE_STATUS);
            }
            allocate.put((byte) 2);
            allocate.put((byte) 1);
            allocate.put(C0973a.b(C0973a.a(device_avoid_disturb_index2.getDevice_avoid_disturb_index())));
            allocate.put((byte) 3);
            allocate.put((byte) 1);
            if (device_avoid_disturb_index2.getDevice_avoid_disturb_time_switch() == 1 || device_avoid_disturb_index2.getDevice_avoid_disturb_switch() == 1) {
                allocate.put((byte) 1);
            } else {
                allocate.put((byte) 0);
            }
            allocate.put((byte) 4);
            allocate.put((byte) 1);
            allocate.put((byte) 0);
            allocate.put((byte) 5);
            allocate.put((byte) 2);
            if (1 == device_avoid_disturb_index2.getDevice_avoid_disturb_switch()) {
                b = C0973a.b(C0973a.b(C0973a.c(0)));
            } else {
                b = C0973a.b(C0973a.b(C0973a.c(device_avoid_disturb_index2.getDevice_avoid_disturb_start_time())));
            }
            allocate.put(b);
            allocate.put((byte) 6);
            allocate.put((byte) 2);
            if (1 == device_avoid_disturb_index2.getDevice_avoid_disturb_switch()) {
                b = C0973a.b(C0973a.b(C0973a.c(2359)));
            } else {
                b = C0973a.b(C0973a.b(C0973a.c(device_avoid_disturb_index2.getDevice_avoid_disturb_end_time())));
            }
            allocate.put(b);
            allocate.put((byte) 7);
            allocate.put((byte) 1);
            allocate.put(C0973a.b(C0973a.a(device_avoid_disturb_index2.getDevice_avoid_disturb_cycle())));
            if (this.f19409a != null && this.f19409a.isSupportQueryAllowDisturbContent()) {
                allocate.put((byte) 8);
                allocate.put((byte) 2);
                allocate.put(C0973a.b(C0973a.b(device_avoid_disturb_index2.getDevice_avoid_disturb_type())));
            }
            c.a(this.f19413e, deviceCommand, allocate, 12, this.f19411c, this.f19412d);
            if (this.f19412d) {
                if (list.size() == 0) {
                    C2538c.c("HWDeviceConfigManager", new Object[]{"addDeviceAvoidDisturbingInfo() size is 0, needRespond"});
                    c.a(this.f19413e, this.f19410b, null);
                } else {
                    C2538c.c("HWDeviceConfigManager", new Object[]{"addDeviceAvoidDisturbingInfo() size is not 0, needRespond"});
                    c.b(this.f19413e, this.f19410b, null);
                }
            } else if (list.size() == 0) {
                C2538c.c("HWDeviceConfigManager", new Object[]{"addDeviceAvoidDisturbingInfo() size is 0, not needRespond"});
                c.a(this.f19413e, this.f19410b, this.f19411c);
            } else {
                C2538c.c("HWDeviceConfigManager", new Object[]{"addDeviceAvoidDisturbingInfo() size is not 0, not needRespond"});
                c.b(this.f19413e, this.f19410b, this.f19411c);
            }
        }
    }
}
