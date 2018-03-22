package com.huawei.p510u;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.huawei.af.C3991a;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwbasemgr.a;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.datatypes.DeviceCapability;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.hwdatamigrate.C4794a;
import com.huawei.hwdevicemgr.dmsdatatype.datatype.DeviceCommand;
import com.huawei.n.c;
import com.huawei.p190v.C2538c;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: HWLinkLossAlarmManager */
public class C5978a extends a {
    private static C5978a f20573a;
    private static List<IBaseResponseCallback> f20574d = new ArrayList();
    private static List<IBaseResponseCallback> f20575e = new ArrayList();
    private Context f20576b;
    private c f20577c;
    private C3991a f20578f;
    private IBaseResponseCallback f20579g = new C5979b(this);
    private BroadcastReceiver f20580h = new C5980c(this);
    private IBaseResponseCallback f20581i = new C5981d(this);

    public static C5978a m27400a() {
        if (f20573a == null) {
            f20573a = new C5978a(BaseApplication.b());
        }
        return f20573a;
    }

    private C5978a(Context context) {
        super(context);
        this.f20576b = context;
        this.f20577c = c.a(context);
        if (this.f20577c != null) {
            this.f20576b.registerReceiver(this.f20580h, new IntentFilter("com.huawei.bone.action.CONNECTION_STATE_CHANGED"), com.huawei.hwcommonmodel.b.c.a, null);
            this.f20577c.a(11, this.f20579g);
            m27408e();
        } else {
            C2538c.e("HWLinkLossAlarmManager", new Object[]{"HWLinkLossAlarmManager() hwDeviceConfigManager is null"});
        }
        this.f20578f = C3991a.m19745a(context);
        if (this.f20578f == null) {
            C2538c.e("HWLinkLossAlarmManager", new Object[]{"mHwCombineMigrateMgr is null"});
        }
    }

    protected Integer getModuleId() {
        return Integer.valueOf(11);
    }

    protected void onDestroy() {
        super.onDestroy();
        try {
            C5978a.m27406c();
            this.f20576b.unregisterReceiver(this.f20580h);
        } catch (IllegalArgumentException e) {
            C2538c.e("HWLinkLossAlarmManager", new Object[]{"mConnectStateChangedReceiver is not registered"});
        }
        C2538c.c("HWLinkLossAlarmManager", new Object[]{"onDestroy()"});
    }

    private static void m27406c() {
        f20573a = null;
        synchronized (C5978a.m27410g()) {
            f20575e.clear();
        }
        synchronized (C5978a.m27409f()) {
            f20574d.clear();
        }
    }

    public void m27411a(boolean z, IBaseResponseCallback iBaseResponseCallback) {
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(11);
        deviceCommand.setCommandID(3);
        ByteBuffer allocate = ByteBuffer.allocate(3);
        allocate.put((byte) 1);
        allocate.put((byte) 1);
        if (z) {
            allocate.put((byte) 1);
        } else {
            allocate.put((byte) 0);
        }
        deviceCommand.setDataLen(allocate.array().length);
        deviceCommand.setDataContent(allocate.array());
        this.f20577c.a(deviceCommand);
        synchronized (C5978a.m27410g()) {
            f20575e.add(iBaseResponseCallback);
        }
        m27403a(z);
    }

    public boolean m27412b() {
        boolean z;
        if (this.f20577c.c() != null) {
            if (1 != m27407d()) {
                z = false;
            }
            z = true;
        } else {
            C2538c.e("HWLinkLossAlarmManager", new Object[]{"getBTLostRemindEnable() : deviceInfo is null"});
            z = true;
        }
        C2538c.c("HWLinkLossAlarmManager", new Object[]{"getBTLostRemindEnable() : flag = " + z + " getBTLostRemindEnableToSharedPreference() = " + m27407d()});
        return z;
    }

    private void m27403a(boolean z) {
        C2538c.c("HWLinkLossAlarmManager", new Object[]{"saveBTLostRemindEnableToSharedPreference() : flag = " + z});
        String c = com.huawei.login.ui.login.a.a(BaseApplication.b()).c();
        if (TextUtils.isEmpty(c)) {
            c = "default_id";
        }
        if (z) {
            setSharedPreference(c + "lost_remind_key", String.valueOf(1), null);
            if (this.f20578f != null) {
                this.f20578f.m19759a(String.valueOf(1), false);
                return;
            }
            return;
        }
        setSharedPreference(c + "lost_remind_key", String.valueOf(0), null);
        if (this.f20578f != null) {
            this.f20578f.m19759a(String.valueOf(0), false);
        }
    }

    private int m27407d() {
        int i = -1;
        String c = com.huawei.login.ui.login.a.a(BaseApplication.b()).c();
        if (TextUtils.isEmpty(c)) {
            c = "default_id";
        }
        Object sharedPreference = getSharedPreference(c + "lost_remind_key");
        if (!TextUtils.isEmpty(sharedPreference)) {
            return Integer.parseInt(sharedPreference);
        }
        DeviceInfo c2 = this.f20577c.c();
        if (c2 != null) {
            String sharedPreference2 = getSharedPreference(c2.getDeviceIdentify());
            if (!"".equals(sharedPreference2)) {
                i = Integer.parseInt(sharedPreference2);
                setSharedPreference(c + "lost_remind_key", sharedPreference2, null);
            }
        } else {
            C2538c.e("HWLinkLossAlarmManager", new Object[]{"getBTLostRemindEnableToSharedPreference() : deviceInfo is null"});
        }
        return i;
    }

    private void m27404a(byte[] bArr) {
        int i = -1;
        C2538c.c("HWLinkLossAlarmManager", new Object[]{"getResult(): " + C0973a.a(bArr)});
        int b;
        switch (bArr[1]) {
            case (byte) 2:
                b = m27405b(bArr);
                if (100000 == b) {
                    i = 0;
                }
                synchronized (C5978a.m27409f()) {
                    if (f20574d.size() != 0) {
                        ((IBaseResponseCallback) f20574d.get(0)).onResponse(i, Integer.valueOf(b));
                        f20574d.remove(0);
                    }
                }
                return;
            case (byte) 3:
                b = m27405b(bArr);
                if (100000 == b) {
                    i = 0;
                }
                synchronized (C5978a.m27410g()) {
                    if (f20575e.size() != 0) {
                        ((IBaseResponseCallback) f20575e.get(0)).onResponse(i, Integer.valueOf(b));
                        f20575e.remove(0);
                    }
                }
                return;
            default:
                return;
        }
    }

    private int m27405b(byte[] bArr) {
        String a = C0973a.a(bArr);
        return Integer.parseInt(a.substring(8, a.length()), 16);
    }

    private void m27408e() {
        boolean z;
        C2538c.c("HWLinkLossAlarmManager", new Object[]{"autoSendCommend() enter."});
        if (1 == m27407d()) {
            z = true;
        } else {
            z = false;
        }
        DeviceCapability a = C0973a.a.a();
        if (a != null && a.isBluetooth_off_alert()) {
            C2538c.c("HWLinkLossAlarmManager", new Object[]{"autoSendCommend() flag = " + z + " getBTLostRemindEnableToSharedPreference() = " + m27407d()});
            m27411a(z, this.f20581i);
        }
    }

    private static synchronized Object m27409f() {
        List list;
        synchronized (C5978a.class) {
            list = f20574d;
        }
        return list;
    }

    private static synchronized Object m27410g() {
        List list;
        synchronized (C5978a.class) {
            list = f20575e;
        }
        return list;
    }

    public boolean onDataMigrate() {
        m27403a(C4794a.m22935a(this.f20576b).m22948j(this.f20576b));
        return true;
    }
}
