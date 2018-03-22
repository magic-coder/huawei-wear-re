package com.huawei.p108n;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.Cursor;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings.System;
import android.text.TextUtils;
import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import com.google.gson.Gson;
import com.huawei.af.a;
import com.huawei.datatype.CommandSend;
import com.huawei.datatype.DBObject;
import com.huawei.datatype.DataDeviceAvoidDisturbInfo;
import com.huawei.datatype.DataDeviceInfo;
import com.huawei.datatype.WearableOpenAppInfo;
import com.huawei.hwbasemgr.C0628a;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.datatypes.DeviceCapability;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.hwcommonmodel.datatypes.TransferFileInfo;
import com.huawei.hwcommonmodel.datatypes.s;
import com.huawei.hwcommonmodel.datatypes.t;
import com.huawei.hwcommonmodel.datatypes.u;
import com.huawei.hwcommonmodel.datatypes.w;
import com.huawei.hwcommonmodel.p062a.C0972a;
import com.huawei.hwcommonmodel.p063b.C0976c;
import com.huawei.hwcommonmodel.p064d.C0977d;
import com.huawei.hwdataaccessmodel.p065a.C0993c;
import com.huawei.hwdataaccessmodel.sharedpreference.C0996a;
import com.huawei.hwdatamigrate.a.bi;
import com.huawei.hwdevicemgr.dmsdatatype.datatype.DeviceCommand;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.hwmessagenotifymgr.notifymanager.C1035a;
import com.huawei.hwservicesmgr.C1046a;
import com.huawei.hwservicesmgr.C1049e;
import com.huawei.hwservicesmgr.C1052j;
import com.huawei.hwservicesmgr.C1057r;
import com.huawei.hwservicesmgr.p076a.C1045q;
import com.huawei.login.ui.login.C1093a;
import com.huawei.n.d;
import com.huawei.n.e;
import com.huawei.n.h;
import com.huawei.n.i;
import com.huawei.n.j;
import com.huawei.n.k;
import com.huawei.n.l;
import com.huawei.n.m;
import com.huawei.n.n;
import com.huawei.n.o;
import com.huawei.n.q;
import com.huawei.n.r;
import com.huawei.n.v;
import com.huawei.n.x;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.huawei.p190v.C2538c;
import com.huawei.pluginmessagecenter.C1971j;
import com.huawei.ui.main.stories.lightcloud.constants.JoinConstants;
import com.unionpay.tsmservice.data.AppStatus;
import java.lang.reflect.Type;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

/* compiled from: HWDeviceConfigManager */
public class C1204c extends C0628a {
    static String f2619b = "";
    private static C1204c f2620d;
    private static DataDeviceInfo f2621g;
    private static Object f2622h = new Object();
    private static Map<Integer, IBaseResponseCallback> f2623i = new HashMap();
    private static Map<Integer, List<IBaseResponseCallback>> f2624j = new HashMap();
    private static List<int[]> f2625k = new ArrayList();
    private static List<List<CommandSend>> f2626l = new ArrayList();
    private static Object f2627p = new Object();
    private static final Object f2628s = new Object();
    private static List<Integer> f2629v = new ArrayList(Arrays.asList(new Integer[]{Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(6), Integer.valueOf(5), Integer.valueOf(7), Integer.valueOf(8), Integer.valueOf(9), Integer.valueOf(10), Integer.valueOf(11), Integer.valueOf(12), Integer.valueOf(13), Integer.valueOf(16), Integer.valueOf(20), Integer.valueOf(21), Integer.valueOf(23), Integer.valueOf(24), Integer.valueOf(25), Integer.valueOf(27), Integer.valueOf(26), Integer.valueOf(29)}));
    private IBaseResponseCallback f2630A = null;
    IBaseResponseCallback f2631a = new d(this);
    IBaseResponseCallback f2632c = new h(this);
    private Context f2633e;
    private w f2634f = new w();
    private HandlerThread f2635m = null;
    private Handler f2636n;
    private List<DeviceInfo> f2637o = new ArrayList();
    private IBaseResponseCallback f2638q;
    private final Object f2639r = new Object();
    private int f2640t = 0;
    private a f2641u;
    private IBaseResponseCallback f2642w = null;
    private C1049e f2643x = new r(this);
    private BroadcastReceiver f2644y = new v(this);
    private IBaseResponseCallback f2645z = new com.huawei.n.w(this);

    public static C1204c m5370a(Context context) {
        C1204c c1204c;
        synchronized (C1204c.m5419y()) {
            if (f2624j.size() == 0) {
                for (Integer put : f2629v) {
                    f2624j.put(put, new ArrayList());
                }
            }
        }
        synchronized (f2628s) {
            if (f2620d == null) {
                f2620d = new C1204c(BaseApplication.m2632b());
            }
            c1204c = f2620d;
        }
        return c1204c;
    }

    private C1204c(Context context) {
        super(context);
        this.f2633e = context;
        if (this.f2635m == null) {
            this.f2635m = new HandlerThread("HWDeviceConfigManager");
            this.f2635m.start();
            this.f2636n = new x(this, this.f2635m.getLooper());
        }
        if (this.f2633e != null) {
            try {
                C2538c.m12677c("HWDeviceConfigManager", "HWDeviceConfigManager() start");
                C1045q.m4407a(this.f2643x);
                m5352C();
                IntentFilter intentFilter = new IntentFilter("com.huawei.bone.action.CONNECTION_STATE_CHANGED");
                intentFilter.setPriority(Integer.MAX_VALUE);
                this.f2633e.registerReceiver(this.f2644y, intentFilter, C0976c.f1642a, null);
                this.f2633e.registerReceiver(this.f2644y, new IntentFilter("android.intent.action.TIMEZONE_CHANGED"));
                this.f2633e.registerReceiver(this.f2644y, new IntentFilter("android.intent.action.TIME_SET"));
                intentFilter = new IntentFilter("com.huawei.bone.action.PHONE_SERVICE_BIND_SUCCESS");
                intentFilter.addAction("com.huawei.bone.action.PHONE_SERVICE_BIND_SUCCESS");
                intentFilter.setPriority(Integer.MAX_VALUE);
                this.f2633e.registerReceiver(this.f2644y, intentFilter, C0976c.f1642a, null);
                m5423a(2, this.f2632c);
                m5361L();
                m5357H();
                C2538c.m12677c("HWDeviceConfigManager", "HWDeviceConfigManager() end");
                this.f2641u = a.a(this.f2633e);
                if (this.f2641u == null) {
                    C2538c.m12680e("HWDeviceConfigManager", "mHwCombineMigrateMgr is null");
                }
            } catch (Exception e) {
                C2538c.m12680e("HWDeviceConfigManager", "HWDeviceConfigManager() e = " + e);
            }
        }
    }

    private void m5414t() {
        C2538c.m12674b("HWDeviceConfigManager", "enter midware");
        boolean c = C1035a.m4176b().m4187c();
        int a = C1035a.m4176b().m4177a("com.huawei.intelligent");
        C2538c.m12677c("HWDeviceConfigManager", "enter midware isClosed" + c);
        C1035a.m4176b().m4179a(true);
        C1035a.m4176b().m4185b(true);
        C1035a.m4176b().m4186c(true);
        if (a == 0) {
            m5380a(Boolean.valueOf(c), Boolean.valueOf(false));
        } else if (a == 1) {
            m5380a(Boolean.valueOf(c), Boolean.valueOf(true));
        }
        m5415u();
    }

    private void m5380a(Boolean bool, Boolean bool2) {
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(33);
        deviceCommand.setCommandID(1);
        byte[] a = C1035a.m4176b().m4183a(bool, bool2.booleanValue());
        deviceCommand.setDataLen(a.length);
        deviceCommand.setDataContent(a);
        m5427a(deviceCommand);
    }

    private void m5415u() {
        m5423a(33, this.f2631a);
    }

    private void m5381a(byte[] bArr) {
        C2538c.m12677c("HWDeviceConfigManager", "enter procResult");
        w wVar = new w();
        String a = C0973a.m3509a(bArr);
        if (a.length() > 4) {
            C2538c.m12677c("HWDeviceConfigManager", "enter procResult + tlvString:" + a.substring(4, a.length()));
            try {
                List<u> list = wVar.a(a.substring(4, a.length())).b;
                if (list != null && list.size() > 0) {
                    for (u uVar : list) {
                        for (s sVar : uVar.a) {
                            switch (Integer.parseInt(sVar.a(), 16)) {
                                case 2:
                                    C2538c.m12677c("HWDeviceConfigManager", "MID_WIRE_NOTIFICATION value:" + Integer.parseInt(sVar.b(), 16));
                                    int parseInt = Integer.parseInt(sVar.b(), 16) / 256;
                                    int parseInt2 = Integer.parseInt(sVar.b(), 16) % 256;
                                    C2538c.m12677c("HWDeviceConfigManager", "MID_WIRE_NOTIFICATION type:" + parseInt + "value:" + parseInt2);
                                    if (parseInt != 1) {
                                        if (parseInt != 2) {
                                            if (parseInt != 3) {
                                                break;
                                            }
                                            C1035a.m4176b().m4186c(parseInt2 == 0);
                                            break;
                                        }
                                        C1035a.m4176b().m4185b(parseInt2 == 0);
                                        break;
                                    }
                                    boolean z;
                                    C1035a b = C1035a.m4176b();
                                    if (parseInt2 == 0) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    b.m4179a(z);
                                    break;
                                default:
                                    break;
                            }
                        }
                    }
                }
            } catch (t e) {
                C2538c.m12680e("HWDeviceConfigManager", "isSupportedCommand() tlv resolve exception.");
            }
            DeviceCommand deviceCommand = new DeviceCommand();
            deviceCommand.setServiceID(33);
            deviceCommand.setCommandID(2);
            byte[] b2 = C0973a.m3512b(C0973a.m3506a(127) + C0973a.m3506a(4) + C0973a.m3507a(100000));
            deviceCommand.setDataLen(b2.length);
            deviceCommand.setDataContent(b2);
            C1204c.m5370a(BaseApplication.m2632b()).m5427a(deviceCommand);
        }
    }

    protected Integer getModuleId() {
        return Integer.valueOf(1);
    }

    public void m5423a(int i, IBaseResponseCallback iBaseResponseCallback) {
        C2538c.m12680e("HWDeviceConfigManager", "registerIBaseResponseCallback() serviceID =" + i);
        synchronized (C1204c.m5418x()) {
            if (f2623i.get(Integer.valueOf(i)) != null) {
                C2538c.m12680e("HWDeviceConfigManager", "null != serviceCallback.get(serviceID");
                f2623i.remove(Integer.valueOf(i));
            }
            f2623i.put(Integer.valueOf(i), iBaseResponseCallback);
        }
    }

    public void m5422a(int i) {
        C2538c.m12680e("HWDeviceConfigManager", "unRegisterIBaseResponseCallback,serviceID=" + i);
        synchronized (C1204c.m5418x()) {
            f2623i.remove(Integer.valueOf(i));
        }
    }

    public void m5424a(int i, String str, List<String> list, C1046a c1046a, String str2) throws RemoteException {
        synchronized (this.f2639r) {
            if (C1045q.m4404a() != null) {
                C1045q.m4404a().mo2320a(i, str, (List) list, c1046a, str2);
            } else {
                C2538c.m12680e("HWDeviceConfigManager", "addDevice() iPhoneServiceAIDL is null");
                C1045q.m4405a(BaseApplication.m2632b());
            }
        }
    }

    public List<DeviceInfo> m5421a() throws RemoteException {
        List<DeviceInfo> a;
        synchronized (this.f2639r) {
            if (C1045q.m4404a() != null) {
                a = C1045q.m4404a().mo2317a();
            } else {
                C2538c.m12680e("HWDeviceConfigManager", "getUsedDeviceList() iPhoneServiceAIDL is null");
                C1045q.m4405a(BaseApplication.m2632b());
                a = null;
            }
        }
        return a;
    }

    public void m5433a(List<DeviceInfo> list) throws RemoteException {
        synchronized (this.f2639r) {
            if (C1045q.m4404a() != null) {
                C1045q.m4404a().mo2331a((List) list);
            } else {
                C2538c.m12680e("HWDeviceConfigManager", "setUsedDeviceList() iPhoneServiceAIDL is null");
                C1045q.m4405a(BaseApplication.m2632b());
            }
        }
    }

    public DeviceInfo m5439b() {
        synchronized (this.f2639r) {
            if (C1045q.m4404a() != null) {
                try {
                    List<DeviceInfo> a = m5421a();
                    if (a != null) {
                        for (DeviceInfo deviceInfo : a) {
                            if (2 == deviceInfo.getDeviceConnectState()) {
                                return deviceInfo;
                            }
                        }
                        return null;
                    }
                    C2538c.m12680e("HWDeviceConfigManager", "getConnectDeviceInfo() deviceInfoList is null");
                    return null;
                } catch (RemoteException e) {
                    C2538c.m12680e("HWDeviceConfigManager", "getConnectDeviceInfo() error = " + e.getMessage());
                    C1045q.m4405a(BaseApplication.m2632b());
                    return null;
                }
            }
            C2538c.m12680e("HWDeviceConfigManager", "getConnectDeviceInfo() iPhoneServiceAIDL is null");
            C1045q.m4405a(BaseApplication.m2632b());
            return null;
        }
    }

    public DeviceInfo m5447c() {
        synchronized (this.f2639r) {
            if (C1045q.m4404a() != null) {
                try {
                    List<DeviceInfo> a = m5421a();
                    if (a != null) {
                        C2538c.m12677c("HWDeviceConfigManager", "getCurrentDeviceInfo() deviceInfoList.size() = " + a.size());
                        for (DeviceInfo deviceInfo : a) {
                            if (1 == deviceInfo.getDeviceActiveState()) {
                                return deviceInfo;
                            }
                        }
                        C2538c.m12680e("HWDeviceConfigManager", "getCurrentDeviceInfo() deviceInfo's ActiveState not DeviceActiveState.DEVICE_ACTIVE_ENABLE");
                        return null;
                    }
                    C2538c.m12680e("HWDeviceConfigManager", "getCurrentDeviceInfo() deviceInfoList is null");
                    return null;
                } catch (RemoteException e) {
                    C2538c.m12680e("HWDeviceConfigManager", "getCurrentDeviceInfo() error = " + e.getMessage());
                    C1045q.m4405a(BaseApplication.m2632b());
                    return null;
                }
            }
            C2538c.m12680e("HWDeviceConfigManager", "getCurrentDeviceInfo() iPhoneServiceAIDL is null");
            C1045q.m4405a(BaseApplication.m2632b());
            return null;
        }
    }

    public void m5426a(TransferFileInfo transferFileInfo, C1057r c1057r) {
        try {
            if (C1045q.m4404a() != null) {
                C1045q.m4404a().mo2324a(transferFileInfo, c1057r);
                return;
            }
            C2538c.m12680e("HWDeviceConfigManager", "getFile() iPhoneServiceAIDL is null");
            C1045q.m4405a(BaseApplication.m2632b());
        } catch (RemoteException e) {
            C2538c.m12680e("HWDeviceConfigManager", "getFile() error = " + e.getMessage());
        }
    }

    public void m5427a(DeviceCommand deviceCommand) {
        synchronized (this.f2639r) {
            try {
                if (m5439b() != null) {
                    C2538c.m12677c("HWDeviceConfigManager", "sendDeviceData(): Command = " + C0973a.m3506a(deviceCommand.getServiceID()) + C0973a.m3506a(deviceCommand.getCommandID()) + C0973a.m3509a(deviceCommand.getDataContent()));
                    if (C1045q.m4404a() != null) {
                        C1045q.m4404a().mo2325a(deviceCommand);
                    } else {
                        C2538c.m12680e("HWDeviceConfigManager", "sendDeviceData() iPhoneServiceAIDL is null");
                        C1045q.m4405a(BaseApplication.m2632b());
                    }
                }
            } catch (Exception e) {
                C2538c.m12680e("HWDeviceConfigManager", "sendDeviceData() e = " + e);
            }
        }
    }

    public void m5442b(DeviceCommand deviceCommand) {
        synchronized (this.f2639r) {
            try {
                C2538c.m12677c("HWDeviceConfigManager", "sendOTAData(): data = " + C0973a.m3509a(deviceCommand.getDataContent()));
                if (C1045q.m4404a() != null) {
                    C1045q.m4404a().mo2335b(deviceCommand);
                } else {
                    C2538c.m12680e("HWDeviceConfigManager", "sendOTAData() iPhoneServiceAIDL is null");
                    C1045q.m4405a(BaseApplication.m2632b());
                }
            } catch (Exception e) {
                C2538c.m12680e("HWDeviceConfigManager", "sendOTAData() e = " + e);
            }
        }
    }

    public void m5431a(String str, String str2, String str3, int i, C1052j c1052j) {
        synchronized (this.f2639r) {
            try {
                if (C1045q.m4404a() != null) {
                    C1045q.m4404a().mo2329a(str, str2, str3, i, c1052j);
                } else {
                    C2538c.m12680e("HWDeviceConfigManager", "sendOTAFileData() iPhoneServiceAIDL is null");
                    C1045q.m4405a(BaseApplication.m2632b());
                }
            } catch (Exception e) {
                C2538c.m12680e("HWDeviceConfigManager", "sendOTAFileData() e = " + e);
            }
        }
    }

    private void m5374a(DeviceCommand deviceCommand, ByteBuffer byteBuffer, int i, IBaseResponseCallback iBaseResponseCallback, boolean z) {
        synchronized (C1204c.m5419y()) {
            if (iBaseResponseCallback != null && z) {
                ((List) f2624j.get(Integer.valueOf(i))).add(iBaseResponseCallback);
            }
        }
        deviceCommand.setDataLen(byteBuffer.array().length);
        deviceCommand.setDataContent(byteBuffer.array());
        m5427a(deviceCommand);
    }

    private synchronized DeviceCapability m5416v() {
        DeviceCapability deviceCapability;
        deviceCapability = null;
        if (C1045q.m4404a() != null) {
            try {
                deviceCapability = C1045q.m4404a().mo2333b();
            } catch (RemoteException e) {
                C2538c.m12680e("HWDeviceConfigManager", "capabilityNegotiation() occur remoteException = " + e.getMessage());
            }
        }
        return deviceCapability;
    }

    private void m5371a(int i, int i2, IBaseResponseCallback iBaseResponseCallback, boolean z) {
        C2538c.m12661a("03", 1, "HWDeviceConfigManager", "setDeviceDateDisplayFormat");
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(1);
        deviceCommand.setCommandID(4);
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.put(TagName.ACTIVITY);
        allocate.put((byte) 6);
        allocate.put((byte) 2);
        allocate.put((byte) 1);
        allocate.put(C0973a.m3512b(C0973a.m3506a(i)));
        allocate.put((byte) 3);
        allocate.put((byte) 1);
        allocate.put(C0973a.m3512b(C0973a.m3506a(i2)));
        m5374a(deviceCommand, allocate, 4, iBaseResponseCallback, z);
    }

    public void m5425a(IBaseResponseCallback iBaseResponseCallback) {
        C2538c.m12677c("HWDeviceConfigManager", "getFirmwareVersion() dataDeviceInfo = " + f2621g + " callback = " + iBaseResponseCallback);
        DeviceInfo c = m5447c();
        if (c != null) {
            C2538c.m12677c("HWDeviceConfigManager", "getFirmwareVersion() deviceInfo = " + c.toString());
        }
        synchronized (C1204c.m5351B()) {
            if (f2621g == null) {
                ByteBuffer allocate;
                DeviceCommand deviceCommand = new DeviceCommand();
                deviceCommand.setServiceID(1);
                deviceCommand.setCommandID(7);
                deviceCommand.setPriority(2);
                if (m5459i() == 0) {
                    allocate = ByteBuffer.allocate(2);
                    allocate.put((byte) 2);
                    allocate.put((byte) 0);
                } else {
                    if (c == null || 10 != c.getProductType()) {
                        allocate = ByteBuffer.allocate(22);
                    } else {
                        allocate = ByteBuffer.allocate(24);
                    }
                    allocate.put((byte) 1);
                    allocate.put((byte) 0);
                    allocate.put((byte) 2);
                    allocate.put((byte) 0);
                    allocate.put((byte) 3);
                    allocate.put((byte) 0);
                    allocate.put((byte) 4);
                    allocate.put((byte) 0);
                    allocate.put((byte) 5);
                    allocate.put((byte) 0);
                    allocate.put((byte) 6);
                    allocate.put((byte) 0);
                    allocate.put((byte) 7);
                    allocate.put((byte) 0);
                    allocate.put((byte) 8);
                    allocate.put((byte) 0);
                    allocate.put((byte) 9);
                    allocate.put((byte) 0);
                    allocate.put((byte) 10);
                    allocate.put((byte) 0);
                    allocate.put(TagName.IDENTIFYING_TYPE);
                    allocate.put((byte) 0);
                    if (c != null && 10 == c.getProductType()) {
                        allocate.put(TagName.PAY_CHANNEL);
                        allocate.put((byte) 0);
                    }
                }
                m5374a(deviceCommand, allocate, 7, iBaseResponseCallback, true);
            } else if (iBaseResponseCallback != null) {
                iBaseResponseCallback.onResponse(0, f2621g);
            } else {
                C2538c.m12680e("HWDeviceConfigManager", "getFirmwareVersion() callback is null");
            }
        }
    }

    public void m5441b(IBaseResponseCallback iBaseResponseCallback) {
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(1);
        deviceCommand.setCommandID(8);
        deviceCommand.setPriority(2);
        ByteBuffer allocate = ByteBuffer.allocate(2);
        if (m5459i() == 0) {
            allocate.put((byte) 8);
            allocate.put((byte) 0);
        } else {
            allocate.put((byte) 1);
            allocate.put((byte) 0);
        }
        m5374a(deviceCommand, allocate, 8, iBaseResponseCallback, true);
    }

    public void m5438a(boolean z, IBaseResponseCallback iBaseResponseCallback, boolean z2) {
        C2538c.m12661a("03", 1, "HWDeviceConfigManager", "setAutoLightScreenSwitchStatus" + z);
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(1);
        deviceCommand.setCommandID(9);
        ByteBuffer allocate = ByteBuffer.allocate(3);
        allocate.put((byte) 1);
        allocate.put((byte) 1);
        if (z) {
            allocate.put((byte) 1);
        } else {
            allocate.put((byte) 0);
        }
        m5374a(deviceCommand, allocate, 9, iBaseResponseCallback, z2);
        m5387b(z);
    }

    public void m5437a(boolean z, IBaseResponseCallback iBaseResponseCallback) {
        m5405k(iBaseResponseCallback);
        C2538c.m12661a("04", 1, "HWDeviceConfigManager", "setWearMessagePushSwitchStatus" + z);
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(2);
        deviceCommand.setCommandID(8);
        ByteBuffer allocate = ByteBuffer.allocate(3);
        allocate.put((byte) 1);
        allocate.put((byte) 1);
        if (z) {
            allocate.put((byte) 0);
        } else {
            allocate.put((byte) 1);
        }
        deviceCommand.setDataLen(allocate.array().length);
        deviceCommand.setDataContent(allocate.array());
        m5427a(deviceCommand);
        m5393c(z);
    }

    private void m5405k(IBaseResponseCallback iBaseResponseCallback) {
        this.f2642w = iBaseResponseCallback;
    }

    public void m5445b(boolean z, IBaseResponseCallback iBaseResponseCallback, boolean z2) {
        C2538c.m12661a("03", 1, "HWDeviceConfigManager", "setRotateSwitchScreenSwitchStatus" + z);
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(1);
        deviceCommand.setCommandID(27);
        ByteBuffer allocate = ByteBuffer.allocate(3);
        allocate.put((byte) 1);
        allocate.put((byte) 1);
        if (z) {
            allocate.put((byte) 1);
        } else {
            allocate.put((byte) 0);
        }
        m5374a(deviceCommand, allocate, 27, iBaseResponseCallback, z2);
        m5396d(z);
    }

    public boolean m5450d() {
        C2538c.m12677c("HWDeviceConfigManager", "getWearMessagePushSwitchStatus() flag =" + m5354E());
        if (m5354E() == 0) {
            return true;
        }
        return false;
    }

    public boolean m5452e() {
        C2538c.m12677c("HWDeviceConfigManager", "getAutoLightScreenSwitchStatus() flag =" + m5353D());
        if (m5353D() == 1) {
            return true;
        }
        return false;
    }

    public boolean m5454f() {
        C2538c.m12677c("HWDeviceConfigManager", "getRotateSwitchScreenSwitchStatus() flag =" + m5355F());
        if (m5355F() == 1) {
            return true;
        }
        return false;
    }

    public void m5448c(boolean z, IBaseResponseCallback iBaseResponseCallback, boolean z2) {
        C2538c.m12661a("03", 1, "HWDeviceConfigManager", "setLeftOrRightHandWearStatus" + z);
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(1);
        deviceCommand.setCommandID(26);
        ByteBuffer allocate = ByteBuffer.allocate(3);
        allocate.put((byte) 1);
        allocate.put((byte) 1);
        if (z) {
            allocate.put((byte) 1);
        } else {
            allocate.put((byte) 0);
        }
        m5374a(deviceCommand, allocate, 26, iBaseResponseCallback, z2);
        m5398e(z);
    }

    public int m5446c(IBaseResponseCallback iBaseResponseCallback) {
        boolean z = true;
        int G = m5356G();
        C2538c.m12677c("HWDeviceConfigManager", "getLeftOrRightHandWearStatus() flag =" + G);
        if (iBaseResponseCallback != null) {
            if (G != 1) {
                z = false;
            }
            iBaseResponseCallback.onResponse(0, Boolean.valueOf(z));
        }
        return G;
    }

    public void m5435a(List<DataDeviceAvoidDisturbInfo> list, IBaseResponseCallback iBaseResponseCallback, boolean z) {
        m5406l(new n(this, C0972a.m3499a(), list, iBaseResponseCallback, z));
    }

    public void m5449d(IBaseResponseCallback iBaseResponseCallback) {
        m5406l(iBaseResponseCallback);
    }

    private void m5417w() {
        C2538c.m12677c("HWDeviceConfigManager", "Enter requestDeviceAllowDisturbContent 5!");
        DeviceCapability a = C0972a.m3499a();
        if (a == null || !a.isSupportQueryAllowDisturbContent()) {
            C2538c.m12677c("HWDeviceConfigManager", "Leave requestDeviceAllowDisturbContent no support return!");
            return;
        }
        com.huawei.ak.a.a().a(new o(this));
        C2538c.m12677c("HWDeviceConfigManager", "Leave requestDeviceAllowDisturbContent !");
    }

    public int m5455g() {
        return this.f2640t;
    }

    public void m5451e(IBaseResponseCallback iBaseResponseCallback) {
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(1);
        deviceCommand.setCommandID(29);
        ByteBuffer allocate = ByteBuffer.allocate(2);
        allocate.put((byte) 1);
        allocate.put((byte) 0);
        m5374a(deviceCommand, allocate, 29, iBaseResponseCallback, true);
    }

    public boolean onDataMigrate() {
        C2538c.m12677c("HWDeviceConfigManager", "onDataMigrate() ENTER");
        com.huawei.hwdatamigrate.a a = com.huawei.hwdatamigrate.a.a(this.f2633e);
        bi g = a.g(this.f2633e);
        if (g != null) {
            C2538c.m12677c("HWDeviceConfigManager", "onDataMigrate() voidDisturbTable=" + g);
            List arrayList = new ArrayList();
            DataDeviceAvoidDisturbInfo dataDeviceAvoidDisturbInfo = new DataDeviceAvoidDisturbInfo();
            if (g.c && g.d) {
                dataDeviceAvoidDisturbInfo.setDevice_avoid_disturb_switch(0);
                dataDeviceAvoidDisturbInfo.setDevice_avoid_disturb_time_switch(1);
            } else {
                if (g.c) {
                    dataDeviceAvoidDisturbInfo.setDevice_avoid_disturb_switch(1);
                }
                if (g.d) {
                    dataDeviceAvoidDisturbInfo.setDevice_avoid_disturb_time_switch(1);
                }
            }
            dataDeviceAvoidDisturbInfo.setDevice_avoid_disturb_start_time(Integer.parseInt(g.f.replace(":", "")));
            dataDeviceAvoidDisturbInfo.setDevice_avoid_disturb_end_time(Integer.parseInt(g.g.replace(":", "")));
            C2538c.m12677c("HWDeviceConfigManager", "onDataMigrate() dataDeviceAvoidDisturbInfo=" + dataDeviceAvoidDisturbInfo);
            arrayList.add(dataDeviceAvoidDisturbInfo);
            m5406l(new q(this, arrayList));
        }
        m5387b(a.i(this.f2633e));
        return true;
    }

    public void m5434a(List<Integer> list, IBaseResponseCallback iBaseResponseCallback) {
        C2538c.m12661a("03", 1, "HWDeviceConfigManager", "deleteDeviceAvoidDisturbingInfo");
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(1);
        deviceCommand.setCommandID(11);
        ByteBuffer allocate = ByteBuffer.allocate(list.size() + 4);
        allocate.put(TagName.ACTIVITY);
        allocate.put((byte) (list.size() + 2));
        allocate.put((byte) 2);
        allocate.put((byte) list.size());
        for (Integer intValue : list) {
            allocate.put(C0973a.m3512b(C0973a.m3506a(intValue.intValue())));
        }
        m5374a(deviceCommand, allocate, 11, iBaseResponseCallback, true);
    }

    public void m5453f(IBaseResponseCallback iBaseResponseCallback) {
        ByteBuffer allocate;
        C2538c.m12661a("03", 1, "HWDeviceConfigManager", "factoryReset");
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(1);
        deviceCommand.setCommandID(13);
        if (m5459i() == 0) {
            allocate = ByteBuffer.allocate(2);
            allocate.put((byte) 64);
            allocate.put((byte) 0);
        } else {
            allocate = ByteBuffer.allocate(3);
            allocate.put((byte) 1);
            allocate.put((byte) 1);
            allocate.put((byte) 1);
        }
        m5374a(deviceCommand, allocate, 13, iBaseResponseCallback, true);
        m5428a("");
        C2538c.m12677c("HWDeviceConfigManager", "factoryReset clear KEY_ALARM_IDENTIFY data");
    }

    private void m5385b(List<Integer> list) {
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(1);
        deviceCommand.setCommandID(16);
        String e = C0973a.m3518e(Build.BOARD);
        String e2 = C0973a.m3518e(Build.BRAND);
        String e3 = C0973a.m3518e(Build.DEVICE);
        String e4 = C0973a.m3518e(Build.MODEL);
        String e5 = C0973a.m3518e(Build.HARDWARE);
        String e6 = C0973a.m3518e(Build.PRODUCT);
        String e7 = C0973a.m3518e(Build.MANUFACTURER);
        String e8 = C0973a.m3518e(VERSION.RELEASE);
        String a = C0973a.m3506a(VERSION.SDK_INT);
        String str = "";
        String O = m5364O();
        String P = m5365P();
        try {
            str = C0973a.m3518e(this.f2633e.getPackageManager().getPackageInfo(this.f2633e.getPackageName(), 0).versionName);
        } catch (NameNotFoundException e9) {
            Object[] objArr = new Object[1];
            objArr[0] = "getHandsetInfo() e = " + e9.getMessage();
            C2538c.m12680e("HWDeviceConfigManager", objArr);
        }
        String a2 = C0973a.m3506a(2);
        String a3 = C0973a.m3506a(m5366Q());
        byte[] b = C0973a.m3512b("01" + C0973a.m3506a(e.length() / 2) + e);
        byte[] b2 = C0973a.m3512b("02" + C0973a.m3506a(e2.length() / 2) + e2);
        byte[] b3 = C0973a.m3512b("03" + C0973a.m3506a(e3.length() / 2) + e3);
        byte[] b4 = C0973a.m3512b("04" + C0973a.m3506a(e4.length() / 2) + e4);
        byte[] b5 = C0973a.m3512b("05" + C0973a.m3506a(e5.length() / 2) + e5);
        byte[] b6 = C0973a.m3512b("06" + C0973a.m3506a(e6.length() / 2) + e6);
        byte[] b7 = C0973a.m3512b(AppStatus.VIEW + C0973a.m3506a(e7.length() / 2) + e7);
        byte[] b8 = C0973a.m3512b(SNBConstant.PAYMENT_CHANNEL + C0973a.m3506a(e8.length() / 2) + e8);
        byte[] b9 = C0973a.m3512b("09" + C0973a.m3506a(a.length() / 2) + a);
        byte[] b10 = C0973a.m3512b("0A" + C0973a.m3506a(str.length() / 2) + str);
        byte[] b11 = C0973a.m3512b("0B" + C0973a.m3506a(O.length() / 2) + O);
        byte[] b12 = C0973a.m3512b("0C" + C0973a.m3506a(P.length() / 2) + P);
        byte[] b13 = C0973a.m3512b("0D" + C0973a.m3506a(a2.length() / 2) + a2);
        byte[] b14 = C0973a.m3512b("0E" + C0973a.m3506a(a3.length() / 2) + a3);
        int i = 0;
        for (Integer intValue : list) {
            int length;
            switch (intValue.intValue()) {
                case 1:
                    length = b.length + i;
                    break;
                case 2:
                    length = b2.length + i;
                    break;
                case 3:
                    length = b3.length + i;
                    break;
                case 4:
                    length = b4.length + i;
                    break;
                case 5:
                    length = b5.length + i;
                    break;
                case 6:
                    length = b6.length + i;
                    break;
                case 7:
                    length = b7.length + i;
                    break;
                case 8:
                    length = b8.length + i;
                    break;
                case 9:
                    length = b9.length + i;
                    break;
                case 10:
                    length = b10.length + i;
                    break;
                case 11:
                    length = b11.length + i;
                    break;
                case 12:
                    length = b12.length + i;
                    break;
                case 13:
                    length = b13.length + i;
                    break;
                case 14:
                    length = b14.length + i;
                    break;
                default:
                    length = i;
                    break;
            }
            i = length;
        }
        ByteBuffer allocate = ByteBuffer.allocate(i);
        for (Integer intValue2 : list) {
            switch (intValue2.intValue()) {
                case 1:
                    allocate.put(b);
                    break;
                case 2:
                    allocate.put(b2);
                    break;
                case 3:
                    allocate.put(b3);
                    break;
                case 4:
                    allocate.put(b4);
                    break;
                case 5:
                    allocate.put(b5);
                    break;
                case 6:
                    allocate.put(b6);
                    break;
                case 7:
                    allocate.put(b7);
                    break;
                case 8:
                    allocate.put(b8);
                    break;
                case 9:
                    allocate.put(b9);
                    break;
                case 10:
                    allocate.put(b10);
                    break;
                case 11:
                    allocate.put(b11);
                    break;
                case 12:
                    allocate.put(b12);
                    break;
                case 13:
                    allocate.put(b13);
                    break;
                case 14:
                    allocate.put(b14);
                    break;
                default:
                    break;
            }
        }
        m5374a(deviceCommand, allocate, 16, null, true);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m5388b(byte[] r18) {
        /*
        r17 = this;
        r6 = 0;
        r2 = 1;
        r2 = r18[r2];
        switch(r2) {
            case 2: goto L_0x0058;
            case 3: goto L_0x00bf;
            case 4: goto L_0x01ea;
            case 5: goto L_0x01f5;
            case 6: goto L_0x0200;
            case 7: goto L_0x0297;
            case 8: goto L_0x03ee;
            case 9: goto L_0x04bc;
            case 10: goto L_0x04c7;
            case 11: goto L_0x04d2;
            case 12: goto L_0x04dd;
            case 13: goto L_0x04e8;
            case 14: goto L_0x0007;
            case 15: goto L_0x0007;
            case 16: goto L_0x0648;
            case 17: goto L_0x0007;
            case 18: goto L_0x0007;
            case 19: goto L_0x0007;
            case 20: goto L_0x06c6;
            case 21: goto L_0x0007;
            case 22: goto L_0x0007;
            case 23: goto L_0x077e;
            case 24: goto L_0x0706;
            case 25: goto L_0x0773;
            case 26: goto L_0x07fb;
            case 27: goto L_0x0806;
            case 28: goto L_0x0007;
            case 29: goto L_0x0811;
            default: goto L_0x0007;
        };
    L_0x0007:
        r4 = r6;
    L_0x0008:
        r5 = com.huawei.p108n.C1204c.m5419y();
        monitor-enter(r5);
        r2 = f2624j;	 Catch:{ all -> 0x0055 }
        r3 = 1;
        r3 = r18[r3];	 Catch:{ all -> 0x0055 }
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ all -> 0x0055 }
        r2 = r2.get(r3);	 Catch:{ all -> 0x0055 }
        r2 = (java.util.List) r2;	 Catch:{ all -> 0x0055 }
        if (r2 == 0) goto L_0x0868;
    L_0x001e:
        if (r4 == 0) goto L_0x087a;
    L_0x0020:
        r3 = r2.size();	 Catch:{ all -> 0x0055 }
        if (r3 == 0) goto L_0x087a;
    L_0x0026:
        r3 = 8;
        r6 = 1;
        r6 = r18[r6];	 Catch:{ all -> 0x0055 }
        if (r3 != r6) goto L_0x086a;
    L_0x002d:
        r0 = r4;
        r0 = (java.lang.Integer) r0;	 Catch:{ all -> 0x0055 }
        r3 = r0;
        r3 = r3.intValue();	 Catch:{ all -> 0x0055 }
        r6 = 100;
        if (r3 <= r6) goto L_0x085c;
    L_0x0039:
        r3 = 100;
        r4 = r3;
    L_0x003c:
        r6 = r2.iterator();	 Catch:{ all -> 0x0055 }
    L_0x0040:
        r3 = r6.hasNext();	 Catch:{ all -> 0x0055 }
        if (r3 == 0) goto L_0x0865;
    L_0x0046:
        r3 = r6.next();	 Catch:{ all -> 0x0055 }
        r3 = (com.huawei.hwbasemgr.IBaseResponseCallback) r3;	 Catch:{ all -> 0x0055 }
        r7 = 0;
        r8 = java.lang.Integer.valueOf(r4);	 Catch:{ all -> 0x0055 }
        r3.onResponse(r7, r8);	 Catch:{ all -> 0x0055 }
        goto L_0x0040;
    L_0x0055:
        r2 = move-exception;
        monitor-exit(r5);	 Catch:{ all -> 0x0055 }
        throw r2;
    L_0x0058:
        r0 = r18;
        r2 = r0.length;
        r2 = r2 + -4;
        r6 = new byte[r2];
        r2 = 4;
        r3 = 0;
        r4 = r6.length;
        r0 = r18;
        java.lang.System.arraycopy(r0, r2, r6, r3, r4);
        r4 = new java.util.HashMap;
        r4.<init>();
        r2 = 0;
        r3 = com.huawei.p108n.C1204c.m5420z();
        monitor-enter(r3);
        r5 = f2625k;	 Catch:{ all -> 0x00a1 }
        r5 = r5.size();	 Catch:{ all -> 0x00a1 }
        if (r5 == 0) goto L_0x089a;
    L_0x007a:
        r2 = f2625k;	 Catch:{ all -> 0x00a1 }
        r5 = 0;
        r2 = r2.get(r5);	 Catch:{ all -> 0x00a1 }
        r2 = (int[]) r2;	 Catch:{ all -> 0x00a1 }
        r5 = r2;
    L_0x0084:
        monitor-exit(r3);	 Catch:{ all -> 0x00a1 }
        if (r5 == 0) goto L_0x00a6;
    L_0x0087:
        r2 = 0;
    L_0x0088:
        r3 = r6.length;
        if (r2 >= r3) goto L_0x00a6;
    L_0x008b:
        r3 = r6[r2];
        switch(r3) {
            case 0: goto L_0x00a4;
            default: goto L_0x0090;
        };
    L_0x0090:
        r3 = 1;
    L_0x0091:
        r7 = r5[r2];
        r7 = java.lang.Integer.valueOf(r7);
        r3 = java.lang.Boolean.valueOf(r3);
        r4.put(r7, r3);
        r2 = r2 + 1;
        goto L_0x0088;
    L_0x00a1:
        r2 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x00a1 }
        throw r2;
    L_0x00a4:
        r3 = 0;
        goto L_0x0091;
    L_0x00a6:
        r3 = com.huawei.p108n.C1204c.m5420z();
        monitor-enter(r3);
        r2 = f2625k;	 Catch:{ all -> 0x00bc }
        r2 = r2.size();	 Catch:{ all -> 0x00bc }
        if (r2 == 0) goto L_0x00b9;
    L_0x00b3:
        r2 = f2625k;	 Catch:{ all -> 0x00bc }
        r5 = 0;
        r2.remove(r5);	 Catch:{ all -> 0x00bc }
    L_0x00b9:
        monitor-exit(r3);	 Catch:{ all -> 0x00bc }
        goto L_0x0008;
    L_0x00bc:
        r2 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x00bc }
        throw r2;
    L_0x00bf:
        r2 = com.huawei.hwcommonmodel.C0973a.m3509a(r18);
        r5 = new java.util.ArrayList;
        r5.<init>();
        r3 = 4;
        r4 = r2.length();
        r2 = r2.substring(r3, r4);
        r0 = r17;
        r3 = r0.f2634f;	 Catch:{ t -> 0x0134 }
        r7 = r3.a(r2);	 Catch:{ t -> 0x0134 }
        r4 = 0;
        r3 = 0;
        r2 = 0;
        r8 = com.huawei.p108n.C1204c.m5350A();	 Catch:{ t -> 0x0134 }
        monitor-enter(r8);	 Catch:{ t -> 0x0134 }
        r9 = f2626l;	 Catch:{ all -> 0x0131 }
        r9 = r9.size();	 Catch:{ all -> 0x0131 }
        if (r9 == 0) goto L_0x0897;
    L_0x00e9:
        r2 = f2626l;	 Catch:{ all -> 0x0131 }
        r9 = 0;
        r2 = r2.get(r9);	 Catch:{ all -> 0x0131 }
        r2 = (java.util.List) r2;	 Catch:{ all -> 0x0131 }
        r9 = r2;
    L_0x00f3:
        monitor-exit(r8);	 Catch:{ all -> 0x0131 }
        if (r9 == 0) goto L_0x01e8;
    L_0x00f6:
        r2 = r7.b;	 Catch:{ t -> 0x0134 }
        r10 = r2.iterator();	 Catch:{ t -> 0x0134 }
        r8 = r3;
    L_0x00fd:
        r2 = r10.hasNext();	 Catch:{ t -> 0x0134 }
        if (r2 == 0) goto L_0x01c9;
    L_0x0103:
        r2 = r10.next();	 Catch:{ t -> 0x0134 }
        r2 = (com.huawei.hwcommonmodel.datatypes.u) r2;	 Catch:{ t -> 0x0134 }
        r2 = r2.a;	 Catch:{ t -> 0x0134 }
        r11 = r2.iterator();	 Catch:{ t -> 0x0134 }
    L_0x010f:
        r2 = r11.hasNext();	 Catch:{ t -> 0x0134 }
        if (r2 == 0) goto L_0x01c4;
    L_0x0115:
        r2 = r11.next();	 Catch:{ t -> 0x0134 }
        r2 = (com.huawei.hwcommonmodel.datatypes.s) r2;	 Catch:{ t -> 0x0134 }
        r3 = r9.get(r8);	 Catch:{ t -> 0x0134 }
        r3 = (com.huawei.datatype.CommandSend) r3;	 Catch:{ t -> 0x0134 }
        r7 = r2.a();	 Catch:{ t -> 0x0134 }
        r12 = 16;
        r7 = java.lang.Integer.parseInt(r7, r12);	 Catch:{ t -> 0x0134 }
        switch(r7) {
            case 2: goto L_0x0157;
            case 3: goto L_0x012e;
            case 4: goto L_0x0162;
            default: goto L_0x012e;
        };
    L_0x012e:
        r2 = r4;
    L_0x012f:
        r4 = r2;
        goto L_0x010f;
    L_0x0131:
        r2 = move-exception;
        monitor-exit(r8);	 Catch:{ all -> 0x0131 }
        throw r2;	 Catch:{ t -> 0x0134 }
    L_0x0134:
        r2 = move-exception;
        r3 = r6;
    L_0x0136:
        r4 = "HWDeviceConfigManager";
        r5 = 1;
        r5 = new java.lang.Object[r5];
        r6 = 0;
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r8 = "COMMAND_ID_COMMAND_CAPABILITY_NEGOTIATION error e = ";
        r7 = r7.append(r8);
        r2 = r7.append(r2);
        r2 = r2.toString();
        r5[r6] = r2;
        com.huawei.p190v.C2538c.m12680e(r4, r5);
        r4 = r3;
        goto L_0x0008;
    L_0x0157:
        r2 = r2.b();	 Catch:{ t -> 0x0134 }
        r3 = 16;
        r2 = java.lang.Integer.parseInt(r2, r3);	 Catch:{ t -> 0x0134 }
        goto L_0x012f;
    L_0x0162:
        r12 = new com.huawei.datatype.CommandResponse;	 Catch:{ t -> 0x0134 }
        r12.<init>();	 Catch:{ t -> 0x0134 }
        r12.setServiceID(r4);	 Catch:{ t -> 0x0134 }
        r13 = new java.util.HashMap;	 Catch:{ t -> 0x0134 }
        r13.<init>();	 Catch:{ t -> 0x0134 }
        r14 = r2.b();	 Catch:{ t -> 0x0134 }
        if (r3 == 0) goto L_0x01bb;
    L_0x0175:
        r7 = 0;
        r2 = 0;
    L_0x0177:
        r15 = r14.length();	 Catch:{ t -> 0x0134 }
        if (r2 >= r15) goto L_0x01bb;
    L_0x017d:
        r15 = r2 + 2;
        r15 = r14.substring(r2, r15);	 Catch:{ t -> 0x0134 }
        r16 = 16;
        r15 = java.lang.Integer.parseInt(r15, r16);	 Catch:{ t -> 0x0134 }
        r16 = 1;
        r0 = r16;
        if (r15 != r0) goto L_0x01a7;
    L_0x018f:
        r15 = r3.getCommandIDs();	 Catch:{ t -> 0x0134 }
        r15 = r15.get(r7);	 Catch:{ t -> 0x0134 }
        r16 = 1;
        r16 = java.lang.Boolean.valueOf(r16);	 Catch:{ t -> 0x0134 }
        r0 = r16;
        r13.put(r15, r0);	 Catch:{ t -> 0x0134 }
    L_0x01a2:
        r7 = r7 + 1;
        r2 = r2 + 2;
        goto L_0x0177;
    L_0x01a7:
        r15 = r3.getCommandIDs();	 Catch:{ t -> 0x0134 }
        r15 = r15.get(r7);	 Catch:{ t -> 0x0134 }
        r16 = 0;
        r16 = java.lang.Boolean.valueOf(r16);	 Catch:{ t -> 0x0134 }
        r0 = r16;
        r13.put(r15, r0);	 Catch:{ t -> 0x0134 }
        goto L_0x01a2;
    L_0x01bb:
        r12.setFlags(r13);	 Catch:{ t -> 0x0134 }
        r5.add(r12);	 Catch:{ t -> 0x0134 }
        r2 = r4;
        goto L_0x012f;
    L_0x01c4:
        r2 = r8 + 1;
        r8 = r2;
        goto L_0x00fd;
    L_0x01c9:
        r3 = com.huawei.p108n.C1204c.m5350A();	 Catch:{ t -> 0x01e4 }
        monitor-enter(r3);	 Catch:{ t -> 0x01e4 }
        r2 = f2626l;	 Catch:{ all -> 0x01e1 }
        r2 = r2.size();	 Catch:{ all -> 0x01e1 }
        if (r2 == 0) goto L_0x01dc;
    L_0x01d6:
        r2 = f2626l;	 Catch:{ all -> 0x01e1 }
        r4 = 0;
        r2.remove(r4);	 Catch:{ all -> 0x01e1 }
    L_0x01dc:
        monitor-exit(r3);	 Catch:{ all -> 0x01e1 }
        r2 = r5;
    L_0x01de:
        r4 = r2;
        goto L_0x0008;
    L_0x01e1:
        r2 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x01e1 }
        throw r2;	 Catch:{ t -> 0x01e4 }
    L_0x01e4:
        r2 = move-exception;
        r3 = r5;
        goto L_0x0136;
    L_0x01e8:
        r2 = 0;
        goto L_0x01de;
    L_0x01ea:
        r2 = r17.m5390c(r18);
        r3 = java.lang.Integer.valueOf(r2);
        r4 = r3;
        goto L_0x0008;
    L_0x01f5:
        r2 = r17.m5390c(r18);
        r3 = java.lang.Integer.valueOf(r2);
        r4 = r3;
        goto L_0x0008;
    L_0x0200:
        r3 = new com.huawei.datatype.DataGMTTime;
        r3.<init>();
        r2 = com.huawei.hwcommonmodel.C0973a.m3509a(r18);
        r4 = 4;
        r5 = r2.length();
        r2 = r2.substring(r4, r5);
        r0 = r17;
        r4 = r0.f2634f;	 Catch:{ t -> 0x024b }
        r2 = r4.a(r2);	 Catch:{ t -> 0x024b }
        r2 = r2.a;	 Catch:{ t -> 0x024b }
        r4 = r2.iterator();	 Catch:{ t -> 0x024b }
    L_0x0220:
        r2 = r4.hasNext();	 Catch:{ t -> 0x024b }
        if (r2 == 0) goto L_0x0294;
    L_0x0226:
        r2 = r4.next();	 Catch:{ t -> 0x024b }
        r2 = (com.huawei.hwcommonmodel.datatypes.s) r2;	 Catch:{ t -> 0x024b }
        r5 = r2.a();	 Catch:{ t -> 0x024b }
        r7 = 16;
        r5 = java.lang.Integer.parseInt(r5, r7);	 Catch:{ t -> 0x024b }
        switch(r5) {
            case 1: goto L_0x023a;
            case 2: goto L_0x026d;
            default: goto L_0x0239;
        };	 Catch:{ t -> 0x024b }
    L_0x0239:
        goto L_0x0220;
    L_0x023a:
        r2 = r2.b();	 Catch:{ t -> 0x024b }
        r5 = 16;
        r8 = java.lang.Long.parseLong(r2, r5);	 Catch:{ t -> 0x024b }
        r10 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r8 = r8 * r10;
        r3.setTime(r8);	 Catch:{ t -> 0x024b }
        goto L_0x0220;
    L_0x024b:
        r2 = move-exception;
        r3 = "HWDeviceConfigManager";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r8 = "COMMAND_ID_GET_DATE error e = ";
        r7 = r7.append(r8);
        r2 = r7.append(r2);
        r2 = r2.toString();
        r4[r5] = r2;
        com.huawei.p190v.C2538c.m12680e(r3, r4);
        r4 = r6;
        goto L_0x0008;
    L_0x026d:
        r5 = r2.b();	 Catch:{ t -> 0x024b }
        r7 = 0;
        r8 = 2;
        r5 = r5.substring(r7, r8);	 Catch:{ t -> 0x024b }
        r7 = 16;
        r5 = java.lang.Integer.parseInt(r5, r7);	 Catch:{ t -> 0x024b }
        r5 = r5 * 100;
        r2 = r2.b();	 Catch:{ t -> 0x024b }
        r7 = 2;
        r8 = 4;
        r2 = r2.substring(r7, r8);	 Catch:{ t -> 0x024b }
        r7 = 16;
        r2 = java.lang.Integer.parseInt(r2, r7);	 Catch:{ t -> 0x024b }
        r2 = r2 + r5;
        r3.setTimeZone(r2);	 Catch:{ t -> 0x024b }
        goto L_0x0220;
    L_0x0294:
        r4 = r3;
        goto L_0x0008;
    L_0x0297:
        r2 = r17.m5447c();
        if (r2 == 0) goto L_0x0007;
    L_0x029d:
        r4 = com.huawei.p108n.C1204c.m5351B();
        monitor-enter(r4);
        r2 = new com.huawei.datatype.DataDeviceInfo;	 Catch:{ all -> 0x0353 }
        r2.<init>();	 Catch:{ all -> 0x0353 }
        f2621g = r2;	 Catch:{ all -> 0x0353 }
        r2 = r17.m5459i();	 Catch:{ all -> 0x0353 }
        if (r2 != 0) goto L_0x02db;
    L_0x02af:
        r2 = "";
        r0 = r18;
        r3 = r0.length;	 Catch:{ all -> 0x0353 }
        r5 = 3;
        if (r3 <= r5) goto L_0x02d6;
    L_0x02b7:
        r3 = 127; // 0x7f float:1.78E-43 double:6.27E-322;
        r5 = 2;
        r5 = r18[r5];	 Catch:{ all -> 0x0353 }
        if (r3 != r5) goto L_0x02d6;
    L_0x02be:
        r3 = "HWDeviceConfigManager";
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x0353 }
        r6 = 0;
        r7 = "getResult() get V0 device version info timeout.";
        r5[r6] = r7;	 Catch:{ all -> 0x0353 }
        com.huawei.p190v.C2538c.m12680e(r3, r5);	 Catch:{ all -> 0x0353 }
    L_0x02cb:
        r3 = f2621g;	 Catch:{ all -> 0x0353 }
        r3.setDevice_soft_version(r2);	 Catch:{ all -> 0x0353 }
        r3 = f2621g;	 Catch:{ all -> 0x0353 }
    L_0x02d2:
        monitor-exit(r4);	 Catch:{ all -> 0x0353 }
        r4 = r3;
        goto L_0x0008;
    L_0x02d6:
        r2 = r17.m5395d(r18);	 Catch:{ all -> 0x0353 }
        goto L_0x02cb;
    L_0x02db:
        r2 = com.huawei.hwcommonmodel.C0973a.m3509a(r18);	 Catch:{ all -> 0x0353 }
        r3 = 4;
        r5 = r2.length();	 Catch:{ all -> 0x0353 }
        r2 = r2.substring(r3, r5);	 Catch:{ all -> 0x0353 }
        r0 = r17;
        r3 = r0.f2634f;	 Catch:{ t -> 0x031e }
        r2 = r3.a(r2);	 Catch:{ t -> 0x031e }
        r2 = r2.a;	 Catch:{ t -> 0x031e }
        r3 = r2.iterator();	 Catch:{ t -> 0x031e }
    L_0x02f6:
        r2 = r3.hasNext();	 Catch:{ t -> 0x031e }
        if (r2 == 0) goto L_0x03ea;
    L_0x02fc:
        r2 = r3.next();	 Catch:{ t -> 0x031e }
        r2 = (com.huawei.hwcommonmodel.datatypes.s) r2;	 Catch:{ t -> 0x031e }
        r5 = r2.a();	 Catch:{ t -> 0x031e }
        r7 = 16;
        r5 = java.lang.Integer.parseInt(r5, r7);	 Catch:{ t -> 0x031e }
        switch(r5) {
            case 1: goto L_0x0310;
            case 2: goto L_0x0343;
            case 3: goto L_0x0356;
            case 4: goto L_0x0364;
            case 5: goto L_0x0372;
            case 6: goto L_0x0381;
            case 7: goto L_0x0390;
            case 8: goto L_0x039f;
            case 9: goto L_0x03ae;
            case 10: goto L_0x03bd;
            case 11: goto L_0x03cc;
            case 12: goto L_0x030f;
            case 13: goto L_0x03db;
            default: goto L_0x030f;
        };	 Catch:{ t -> 0x031e }
    L_0x030f:
        goto L_0x02f6;
    L_0x0310:
        r5 = f2621g;	 Catch:{ t -> 0x031e }
        r2 = r2.b();	 Catch:{ t -> 0x031e }
        r2 = com.huawei.hwcommonmodel.C0973a.m3514c(r2);	 Catch:{ t -> 0x031e }
        r5.setBT_version(r2);	 Catch:{ t -> 0x031e }
        goto L_0x02f6;
    L_0x031e:
        r2 = move-exception;
        r3 = "HWDeviceConfigManager";
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x0353 }
        r7 = 0;
        r8 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0353 }
        r8.<init>();	 Catch:{ all -> 0x0353 }
        r9 = "Exception = ";
        r8 = r8.append(r9);	 Catch:{ all -> 0x0353 }
        r2 = r2.getMessage();	 Catch:{ all -> 0x0353 }
        r2 = r8.append(r2);	 Catch:{ all -> 0x0353 }
        r2 = r2.toString();	 Catch:{ all -> 0x0353 }
        r5[r7] = r2;	 Catch:{ all -> 0x0353 }
        com.huawei.p190v.C2538c.m12680e(r3, r5);	 Catch:{ all -> 0x0353 }
        r3 = r6;
        goto L_0x02d2;
    L_0x0343:
        r5 = f2621g;	 Catch:{ t -> 0x031e }
        r2 = r2.b();	 Catch:{ t -> 0x031e }
        r7 = 16;
        r2 = java.lang.Integer.parseInt(r2, r7);	 Catch:{ t -> 0x031e }
        r5.setDevice_type(r2);	 Catch:{ t -> 0x031e }
        goto L_0x02f6;
    L_0x0353:
        r2 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0353 }
        throw r2;
    L_0x0356:
        r5 = f2621g;	 Catch:{ t -> 0x031e }
        r2 = r2.b();	 Catch:{ t -> 0x031e }
        r2 = com.huawei.hwcommonmodel.C0973a.m3514c(r2);	 Catch:{ t -> 0x031e }
        r5.setDevice_version(r2);	 Catch:{ t -> 0x031e }
        goto L_0x02f6;
    L_0x0364:
        r5 = f2621g;	 Catch:{ t -> 0x031e }
        r2 = r2.b();	 Catch:{ t -> 0x031e }
        r2 = com.huawei.hwcommonmodel.C0973a.m3514c(r2);	 Catch:{ t -> 0x031e }
        r5.setDevice_phone_numbe(r2);	 Catch:{ t -> 0x031e }
        goto L_0x02f6;
    L_0x0372:
        r5 = f2621g;	 Catch:{ t -> 0x031e }
        r2 = r2.b();	 Catch:{ t -> 0x031e }
        r2 = com.huawei.hwcommonmodel.C0973a.m3514c(r2);	 Catch:{ t -> 0x031e }
        r5.setDevice_bt_mac(r2);	 Catch:{ t -> 0x031e }
        goto L_0x02f6;
    L_0x0381:
        r5 = f2621g;	 Catch:{ t -> 0x031e }
        r2 = r2.b();	 Catch:{ t -> 0x031e }
        r2 = com.huawei.hwcommonmodel.C0973a.m3514c(r2);	 Catch:{ t -> 0x031e }
        r5.setDevice_imei(r2);	 Catch:{ t -> 0x031e }
        goto L_0x02f6;
    L_0x0390:
        r5 = f2621g;	 Catch:{ t -> 0x031e }
        r2 = r2.b();	 Catch:{ t -> 0x031e }
        r2 = com.huawei.hwcommonmodel.C0973a.m3514c(r2);	 Catch:{ t -> 0x031e }
        r5.setDevice_soft_version(r2);	 Catch:{ t -> 0x031e }
        goto L_0x02f6;
    L_0x039f:
        r5 = f2621g;	 Catch:{ t -> 0x031e }
        r2 = r2.b();	 Catch:{ t -> 0x031e }
        r2 = com.huawei.hwcommonmodel.C0973a.m3514c(r2);	 Catch:{ t -> 0x031e }
        r5.setDevice_opensource_version(r2);	 Catch:{ t -> 0x031e }
        goto L_0x02f6;
    L_0x03ae:
        r5 = f2621g;	 Catch:{ t -> 0x031e }
        r2 = r2.b();	 Catch:{ t -> 0x031e }
        r2 = com.huawei.hwcommonmodel.C0973a.m3514c(r2);	 Catch:{ t -> 0x031e }
        r5.setDevice_sn(r2);	 Catch:{ t -> 0x031e }
        goto L_0x02f6;
    L_0x03bd:
        r5 = f2621g;	 Catch:{ t -> 0x031e }
        r2 = r2.b();	 Catch:{ t -> 0x031e }
        r2 = com.huawei.hwcommonmodel.C0973a.m3514c(r2);	 Catch:{ t -> 0x031e }
        r5.setDevice_model(r2);	 Catch:{ t -> 0x031e }
        goto L_0x02f6;
    L_0x03cc:
        r5 = f2621g;	 Catch:{ t -> 0x031e }
        r2 = r2.b();	 Catch:{ t -> 0x031e }
        r2 = com.huawei.hwcommonmodel.C0973a.m3514c(r2);	 Catch:{ t -> 0x031e }
        r5.setDevice_emmc_id(r2);	 Catch:{ t -> 0x031e }
        goto L_0x02f6;
    L_0x03db:
        r5 = f2621g;	 Catch:{ t -> 0x031e }
        r2 = r2.b();	 Catch:{ t -> 0x031e }
        r2 = com.huawei.hwcommonmodel.C0973a.m3515d(r2);	 Catch:{ t -> 0x031e }
        r5.setDevice_support_healthapp(r2);	 Catch:{ t -> 0x031e }
        goto L_0x02f6;
    L_0x03ea:
        r3 = f2621g;	 Catch:{ t -> 0x031e }
        goto L_0x02d2;
    L_0x03ee:
        r4 = new android.content.Intent;
        r4.<init>();
        r2 = "com.huawei.bone.action.BATTERY_LEVEL";
        r4.setAction(r2);
        r2 = r17.m5459i();
        if (r2 != 0) goto L_0x044b;
    L_0x03fe:
        r0 = r18;
        r2 = r0.length;
        r3 = 3;
        if (r2 <= r3) goto L_0x0420;
    L_0x0404:
        r2 = 127; // 0x7f float:1.78E-43 double:6.27E-322;
        r3 = 2;
        r3 = r18[r3];
        if (r2 != r3) goto L_0x0420;
    L_0x040b:
        r2 = 0;
        r3 = java.lang.Integer.valueOf(r2);
        r2 = "HWDeviceConfigManager";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = "getResult() get V0 battery level timeout.";
        r4[r5] = r6;
        com.huawei.p190v.C2538c.m12680e(r2, r4);
        r4 = r3;
        goto L_0x0008;
    L_0x0420:
        r2 = 14;
        r2 = r18[r2];
        r3 = 100;
        if (r2 <= r3) goto L_0x0446;
    L_0x0428:
        r2 = 100;
    L_0x042a:
        r3 = java.lang.Integer.valueOf(r2);
        r5 = "BATTERY_LEVEL";
        r2 = r3;
        r2 = (java.lang.Integer) r2;
        r2 = r2.intValue();
        r4.putExtra(r5, r2);
        r0 = r17;
        r2 = r0.f2633e;
        r5 = com.huawei.hwcommonmodel.p063b.C0976c.f1642a;
        r2.sendBroadcast(r4, r5);
        r4 = r3;
        goto L_0x0008;
    L_0x0446:
        r2 = 14;
        r2 = r18[r2];
        goto L_0x042a;
    L_0x044b:
        r0 = r18;
        r2 = r0.length;
        r3 = 3;
        if (r2 <= r3) goto L_0x046d;
    L_0x0451:
        r2 = 127; // 0x7f float:1.78E-43 double:6.27E-322;
        r3 = 2;
        r3 = r18[r3];
        if (r2 != r3) goto L_0x046d;
    L_0x0458:
        r2 = 0;
        r3 = java.lang.Integer.valueOf(r2);
        r2 = "HWDeviceConfigManager";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = "getResult() get !V0 battery level timeout.";
        r4[r5] = r6;
        com.huawei.p190v.C2538c.m12680e(r2, r4);
        r4 = r3;
        goto L_0x0008;
    L_0x046d:
        r2 = r17.m5390c(r18);	 Catch:{ NumberFormatException -> 0x0493 }
        r3 = 100;
        if (r2 <= r3) goto L_0x0477;
    L_0x0475:
        r2 = 100;
    L_0x0477:
        r3 = java.lang.Integer.valueOf(r2);	 Catch:{ NumberFormatException -> 0x0493 }
    L_0x047b:
        r5 = "BATTERY_LEVEL";
        r2 = r3;
        r2 = (java.lang.Integer) r2;
        r2 = r2.intValue();
        r4.putExtra(r5, r2);
        r0 = r17;
        r2 = r0.f2633e;
        r5 = com.huawei.hwcommonmodel.p063b.C0976c.f1642a;
        r2.sendBroadcast(r4, r5);
        r4 = r3;
        goto L_0x0008;
    L_0x0493:
        r2 = move-exception;
        r3 = "HWDeviceConfigManager";
        r5 = 1;
        r5 = new java.lang.Object[r5];
        r6 = 0;
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r8 = "Exception = ";
        r7 = r7.append(r8);
        r2 = r2.getMessage();
        r2 = r7.append(r2);
        r2 = r2.toString();
        r5[r6] = r2;
        com.huawei.p190v.C2538c.m12680e(r3, r5);
        r2 = 0;
        r3 = java.lang.Integer.valueOf(r2);
        goto L_0x047b;
    L_0x04bc:
        r2 = r17.m5390c(r18);
        r3 = java.lang.Integer.valueOf(r2);
        r4 = r3;
        goto L_0x0008;
    L_0x04c7:
        r2 = r17.m5390c(r18);
        r3 = java.lang.Integer.valueOf(r2);
        r4 = r3;
        goto L_0x0008;
    L_0x04d2:
        r2 = r17.m5390c(r18);
        r3 = java.lang.Integer.valueOf(r2);
        r4 = r3;
        goto L_0x0008;
    L_0x04dd:
        r2 = r17.m5390c(r18);
        r3 = java.lang.Integer.valueOf(r2);
        r4 = r3;
        goto L_0x0008;
    L_0x04e8:
        r2 = r17.m5459i();
        if (r2 != 0) goto L_0x05d2;
    L_0x04ee:
        r2 = 100001; // 0x186a1 float:1.40131E-40 double:4.9407E-319;
        r0 = r18;
        r3 = r0.length;
        r4 = 3;
        if (r3 <= r4) goto L_0x0508;
    L_0x04f7:
        r3 = 127; // 0x7f float:1.78E-43 double:6.27E-322;
        r4 = 2;
        r4 = r18[r4];
        if (r3 != r4) goto L_0x0508;
    L_0x04fe:
        r2 = 100009; // 0x186a9 float:1.40142E-40 double:4.9411E-319;
    L_0x0501:
        r3 = java.lang.Integer.valueOf(r2);
        r4 = r3;
        goto L_0x0008;
    L_0x0508:
        r3 = 3;
        r0 = r18;
        r4 = r0.length;
        if (r3 != r4) goto L_0x0501;
    L_0x050e:
        r2 = 2;
        r2 = r18[r2];
        if (r2 != 0) goto L_0x059f;
    L_0x0513:
        r2 = "HWDeviceConfigManager";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r5 = "V0 Device factory reset success.";
        r3[r4] = r5;
        com.huawei.p190v.C2538c.m12677c(r2, r3);
        r3 = 100000; // 0x186a0 float:1.4013E-40 double:4.94066E-319;
        r4 = com.huawei.p108n.C1204c.m5362M();	 Catch:{ RemoteException -> 0x0565 }
        monitor-enter(r4);	 Catch:{ RemoteException -> 0x0565 }
        r17.m5363N();	 Catch:{ all -> 0x0562 }
        r0 = r17;
        r2 = r0.f2637o;	 Catch:{ all -> 0x0562 }
        r5 = r2.iterator();	 Catch:{ all -> 0x0562 }
    L_0x0533:
        r2 = r5.hasNext();	 Catch:{ all -> 0x0562 }
        if (r2 == 0) goto L_0x0592;
    L_0x0539:
        r2 = r5.next();	 Catch:{ all -> 0x0562 }
        r2 = (com.huawei.hwcommonmodel.datatypes.DeviceInfo) r2;	 Catch:{ all -> 0x0562 }
        r6 = "HWDeviceConfigManager";
        r7 = 1;
        r7 = new java.lang.Object[r7];	 Catch:{ all -> 0x0562 }
        r8 = 0;
        r9 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0562 }
        r9.<init>();	 Catch:{ all -> 0x0562 }
        r10 = "getResult() V0 列表中的设备Mac = ";
        r9 = r9.append(r10);	 Catch:{ all -> 0x0562 }
        r2 = r2.getDeviceIdentify();	 Catch:{ all -> 0x0562 }
        r2 = r9.append(r2);	 Catch:{ all -> 0x0562 }
        r2 = r2.toString();	 Catch:{ all -> 0x0562 }
        r7[r8] = r2;	 Catch:{ all -> 0x0562 }
        com.huawei.p190v.C2538c.m12677c(r6, r7);	 Catch:{ all -> 0x0562 }
        goto L_0x0533;
    L_0x0562:
        r2 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0562 }
        throw r2;	 Catch:{ RemoteException -> 0x0565 }
    L_0x0565:
        r2 = move-exception;
        r4 = "HWDeviceConfigManager";
        r5 = 1;
        r5 = new java.lang.Object[r5];
        r6 = 0;
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r8 = "getResult() setUsedDeviceList error e = ";
        r7 = r7.append(r8);
        r2 = r2.getMessage();
        r2 = r7.append(r2);
        r2 = r2.toString();
        r5[r6] = r2;
        com.huawei.p190v.C2538c.m12680e(r4, r5);
        r2 = com.huawei.hwcommonmodel.application.BaseApplication.m2632b();
        com.huawei.hwservicesmgr.p076a.C1045q.m4405a(r2);
        r2 = r3;
        goto L_0x0501;
    L_0x0592:
        r0 = r17;
        r2 = r0.f2637o;	 Catch:{ all -> 0x0562 }
        r0 = r17;
        r0.m5433a(r2);	 Catch:{ all -> 0x0562 }
        monitor-exit(r4);	 Catch:{ all -> 0x0562 }
        r2 = r3;
        goto L_0x0501;
    L_0x059f:
        r3 = 1;
        if (r3 != r2) goto L_0x05b1;
    L_0x05a2:
        r3 = "HWDeviceConfigManager";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = "V0 Device factory reset fail for time remove.";
        r4[r5] = r6;
        com.huawei.p190v.C2538c.m12680e(r3, r4);
        goto L_0x0501;
    L_0x05b1:
        r3 = 2;
        if (r3 != r2) goto L_0x05c3;
    L_0x05b4:
        r3 = "HWDeviceConfigManager";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = "V0 Device factory reset fail for flash remove.";
        r4[r5] = r6;
        com.huawei.p190v.C2538c.m12680e(r3, r4);
        goto L_0x0501;
    L_0x05c3:
        r3 = "HWDeviceConfigManager";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = "V0 Device factory reset fail for unknown.";
        r4[r5] = r6;
        com.huawei.p190v.C2538c.m12680e(r3, r4);
        goto L_0x0501;
    L_0x05d2:
        r3 = r17.m5390c(r18);
        r2 = 100000; // 0x186a0 float:1.4013E-40 double:4.94066E-319;
        if (r2 != r3) goto L_0x0613;
    L_0x05db:
        r4 = com.huawei.p108n.C1204c.m5362M();	 Catch:{ RemoteException -> 0x061d }
        monitor-enter(r4);	 Catch:{ RemoteException -> 0x061d }
        r17.m5363N();	 Catch:{ all -> 0x061a }
        r2 = "HWDeviceConfigManager";
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x061a }
        r6 = 0;
        r7 = new java.lang.StringBuilder;	 Catch:{ all -> 0x061a }
        r7.<init>();	 Catch:{ all -> 0x061a }
        r8 = "getResult() V2 usedDeviceList.size()";
        r7 = r7.append(r8);	 Catch:{ all -> 0x061a }
        r0 = r17;
        r8 = r0.f2637o;	 Catch:{ all -> 0x061a }
        r8 = r8.size();	 Catch:{ all -> 0x061a }
        r7 = r7.append(r8);	 Catch:{ all -> 0x061a }
        r7 = r7.toString();	 Catch:{ all -> 0x061a }
        r5[r6] = r7;	 Catch:{ all -> 0x061a }
        com.huawei.p190v.C2538c.m12677c(r2, r5);	 Catch:{ all -> 0x061a }
        r0 = r17;
        r2 = r0.f2637o;	 Catch:{ all -> 0x061a }
        r0 = r17;
        r0.m5433a(r2);	 Catch:{ all -> 0x061a }
        monitor-exit(r4);	 Catch:{ all -> 0x061a }
    L_0x0613:
        r3 = java.lang.Integer.valueOf(r3);
        r4 = r3;
        goto L_0x0008;
    L_0x061a:
        r2 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x061a }
        throw r2;	 Catch:{ RemoteException -> 0x061d }
    L_0x061d:
        r2 = move-exception;
        r4 = "HWDeviceConfigManager";
        r5 = 1;
        r5 = new java.lang.Object[r5];
        r6 = 0;
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r8 = "getResult() setUsedDeviceList error e = ";
        r7 = r7.append(r8);
        r2 = r2.getMessage();
        r2 = r7.append(r2);
        r2 = r2.toString();
        r5[r6] = r2;
        com.huawei.p190v.C2538c.m12680e(r4, r5);
        r2 = com.huawei.hwcommonmodel.application.BaseApplication.m2632b();
        com.huawei.hwservicesmgr.p076a.C1045q.m4405a(r2);
        goto L_0x0613;
    L_0x0648:
        r2 = com.huawei.hwcommonmodel.C0973a.m3509a(r18);
        r3 = 4;
        r4 = r2.length();
        r2 = r2.substring(r3, r4);
        r4 = new java.util.ArrayList;
        r4.<init>();
        r3 = 0;
        r0 = r17;
        r5 = r0.f2634f;	 Catch:{ t -> 0x0699 }
        r2 = r5.a(r2);	 Catch:{ t -> 0x0699 }
        r2 = r2.a;	 Catch:{ t -> 0x0699 }
        r5 = r2.iterator();	 Catch:{ t -> 0x0699 }
    L_0x0669:
        r2 = r5.hasNext();	 Catch:{ t -> 0x0699 }
        if (r2 == 0) goto L_0x06bc;
    L_0x066f:
        r2 = r5.next();	 Catch:{ t -> 0x0699 }
        r2 = (com.huawei.hwcommonmodel.datatypes.s) r2;	 Catch:{ t -> 0x0699 }
        r7 = 127; // 0x7f float:1.78E-43 double:6.27E-322;
        r8 = r2.a();	 Catch:{ t -> 0x0699 }
        r9 = 16;
        r8 = java.lang.Integer.parseInt(r8, r9);	 Catch:{ t -> 0x0699 }
        if (r7 != r8) goto L_0x0686;
    L_0x0683:
        r2 = 1;
    L_0x0684:
        r3 = r2;
        goto L_0x0669;
    L_0x0686:
        r2 = r2.a();	 Catch:{ t -> 0x0699 }
        r7 = 16;
        r2 = java.lang.Integer.parseInt(r2, r7);	 Catch:{ t -> 0x0699 }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ t -> 0x0699 }
        r4.add(r2);	 Catch:{ t -> 0x0699 }
        r2 = r3;
        goto L_0x0684;
    L_0x0699:
        r2 = move-exception;
        r5 = "HWDeviceConfigManager";
        r7 = 1;
        r7 = new java.lang.Object[r7];
        r8 = 0;
        r9 = new java.lang.StringBuilder;
        r9.<init>();
        r10 = "getResult() getHandsetInfo error e = ";
        r9 = r9.append(r10);
        r2 = r2.getMessage();
        r2 = r9.append(r2);
        r2 = r2.toString();
        r7[r8] = r2;
        com.huawei.p190v.C2538c.m12680e(r5, r7);
    L_0x06bc:
        if (r3 != 0) goto L_0x0007;
    L_0x06be:
        r0 = r17;
        r0.m5385b(r4);
        r4 = r6;
        goto L_0x0008;
    L_0x06c6:
        r2 = r17.m5390c(r18);
        r2 = java.lang.Integer.toBinaryString(r2);
        r5 = r2.length();
        r3 = 8;
        if (r3 <= r5) goto L_0x06f3;
    L_0x06d6:
        r3 = 0;
    L_0x06d7:
        r4 = 8 - r5;
        if (r3 >= r4) goto L_0x06f3;
    L_0x06db:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r6 = "0";
        r4 = r4.append(r6);
        r2 = r4.append(r2);
        r4 = r2.toString();
        r2 = r3 + 1;
        r3 = r2;
        r2 = r4;
        goto L_0x06d7;
    L_0x06f3:
        r3 = 4;
        r4 = 5;
        r2 = r2.substring(r3, r4);
        r3 = "1";
        r2 = r2.equals(r3);
        r3 = java.lang.Boolean.valueOf(r2);
        r4 = r3;
        goto L_0x0008;
    L_0x0706:
        r2 = com.huawei.hwcommonmodel.C0973a.m3509a(r18);
        r3 = 4;
        r4 = r2.length();
        r2 = r2.substring(r3, r4);
        r0 = r17;
        r3 = r0.f2634f;	 Catch:{ t -> 0x0750 }
        r2 = r3.a(r2);	 Catch:{ t -> 0x0750 }
        r2 = r2.a;	 Catch:{ t -> 0x0750 }
        r4 = r2.iterator();	 Catch:{ t -> 0x0750 }
        r3 = r6;
    L_0x0722:
        r2 = r4.hasNext();	 Catch:{ t -> 0x0894 }
        if (r2 == 0) goto L_0x074d;
    L_0x0728:
        r2 = r4.next();	 Catch:{ t -> 0x0894 }
        r2 = (com.huawei.hwcommonmodel.datatypes.s) r2;	 Catch:{ t -> 0x0894 }
        r5 = r2.a();	 Catch:{ t -> 0x0894 }
        r6 = 16;
        r5 = java.lang.Integer.parseInt(r5, r6);	 Catch:{ t -> 0x0894 }
        switch(r5) {
            case 1: goto L_0x073e;
            default: goto L_0x073b;
        };	 Catch:{ t -> 0x0894 }
    L_0x073b:
        r2 = r3;
    L_0x073c:
        r3 = r2;
        goto L_0x0722;
    L_0x073e:
        r2 = r2.b();	 Catch:{ t -> 0x0894 }
        r5 = 16;
        r2 = java.lang.Integer.parseInt(r2, r5);	 Catch:{ t -> 0x0894 }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ t -> 0x0894 }
        goto L_0x073c;
    L_0x074d:
        r4 = r3;
        goto L_0x0008;
    L_0x0750:
        r2 = move-exception;
        r3 = r6;
    L_0x0752:
        r4 = "HWDeviceConfigManager";
        r5 = 1;
        r5 = new java.lang.Object[r5];
        r6 = 0;
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r8 = "getResult() COMMAND_ID_PAY_GET_CPLC error e = ";
        r7 = r7.append(r8);
        r2 = r7.append(r2);
        r2 = r2.toString();
        r5[r6] = r2;
        com.huawei.p190v.C2538c.m12680e(r4, r5);
        r4 = r3;
        goto L_0x0008;
    L_0x0773:
        r2 = r17.m5390c(r18);
        r3 = java.lang.Integer.toBinaryString(r2);
        r4 = r3;
        goto L_0x0008;
    L_0x077e:
        r3 = new com.huawei.datatype.WearableOpenAppInfo;
        r3.<init>();
        r4 = 0;
        r2 = com.huawei.hwcommonmodel.C0973a.m3509a(r18);
        r5 = 4;
        r7 = r2.length();
        r2 = r2.substring(r5, r7);
        r0 = r17;
        r5 = r0.f2634f;	 Catch:{ t -> 0x07c5 }
        r2 = r5.a(r2);	 Catch:{ t -> 0x07c5 }
        r2 = r2.a;	 Catch:{ t -> 0x07c5 }
        r5 = r2.iterator();	 Catch:{ t -> 0x07c5 }
    L_0x079f:
        r2 = r5.hasNext();	 Catch:{ t -> 0x07c5 }
        if (r2 == 0) goto L_0x07f3;
    L_0x07a5:
        r2 = r5.next();	 Catch:{ t -> 0x07c5 }
        r2 = (com.huawei.hwcommonmodel.datatypes.s) r2;	 Catch:{ t -> 0x07c5 }
        r7 = r2.a();	 Catch:{ t -> 0x07c5 }
        r8 = 16;
        r7 = java.lang.Integer.parseInt(r7, r8);	 Catch:{ t -> 0x07c5 }
        switch(r7) {
            case 1: goto L_0x07b9;
            case 2: goto L_0x07e7;
            default: goto L_0x07b8;
        };	 Catch:{ t -> 0x07c5 }
    L_0x07b8:
        goto L_0x079f;
    L_0x07b9:
        r2 = r2.b();	 Catch:{ t -> 0x07c5 }
        r2 = com.huawei.hwcommonmodel.C0973a.m3514c(r2);	 Catch:{ t -> 0x07c5 }
        r3.setPackageName(r2);	 Catch:{ t -> 0x07c5 }
        goto L_0x079f;
    L_0x07c5:
        r2 = move-exception;
        r3 = "HWDeviceConfigManager";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r8 = "COMMAND_ID_GET_DATE error e = ";
        r7 = r7.append(r8);
        r2 = r7.append(r2);
        r2 = r2.toString();
        r4[r5] = r2;
        com.huawei.p190v.C2538c.m12680e(r3, r4);
        r4 = r6;
        goto L_0x0008;
    L_0x07e7:
        r2 = r2.b();	 Catch:{ t -> 0x07c5 }
        r2 = com.huawei.hwcommonmodel.C0973a.m3514c(r2);	 Catch:{ t -> 0x07c5 }
        r3.setClassName(r2);	 Catch:{ t -> 0x07c5 }
        goto L_0x079f;
    L_0x07f3:
        r0 = r17;
        r0.m5372a(r4, r3);	 Catch:{ t -> 0x07c5 }
        r4 = r6;
        goto L_0x0008;
    L_0x07fb:
        r2 = r17.m5390c(r18);
        r3 = java.lang.Integer.valueOf(r2);
        r4 = r3;
        goto L_0x0008;
    L_0x0806:
        r2 = r17.m5390c(r18);
        r3 = java.lang.Integer.valueOf(r2);
        r4 = r3;
        goto L_0x0008;
    L_0x0811:
        r2 = com.huawei.hwcommonmodel.C0973a.m3509a(r18);
        r3 = "HWDeviceConfigManager";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r7 = "getResult getAllowDisturbContentlist message = ";
        r6 = r6.append(r7);
        r2 = r6.append(r2);
        r2 = r2.toString();
        r4[r5] = r2;
        com.huawei.p190v.C2538c.m12677c(r3, r4);
        r2 = r17.m5390c(r18);
        r3 = java.lang.Integer.valueOf(r2);
        r2 = "HWDeviceConfigManager";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r7 = "getResult getAllowDisturbContentlist object = ";
        r6 = r6.append(r7);
        r6 = r6.append(r3);
        r6 = r6.toString();
        r4[r5] = r6;
        com.huawei.p190v.C2538c.m12677c(r2, r4);
        r4 = r3;
        goto L_0x0008;
    L_0x085c:
        r4 = (java.lang.Integer) r4;	 Catch:{ all -> 0x0055 }
        r3 = r4.intValue();	 Catch:{ all -> 0x0055 }
        r4 = r3;
        goto L_0x003c;
    L_0x0865:
        r2.clear();	 Catch:{ all -> 0x0055 }
    L_0x0868:
        monitor-exit(r5);	 Catch:{ all -> 0x0055 }
        return;
    L_0x086a:
        r3 = 0;
        r3 = r2.get(r3);	 Catch:{ all -> 0x0055 }
        r3 = (com.huawei.hwbasemgr.IBaseResponseCallback) r3;	 Catch:{ all -> 0x0055 }
        r6 = 0;
        r3.onResponse(r6, r4);	 Catch:{ all -> 0x0055 }
        r3 = 0;
        r2.remove(r3);	 Catch:{ all -> 0x0055 }
        goto L_0x0868;
    L_0x087a:
        r3 = r2.size();	 Catch:{ all -> 0x0055 }
        if (r3 == 0) goto L_0x0868;
    L_0x0880:
        r3 = 0;
        r3 = r2.get(r3);	 Catch:{ all -> 0x0055 }
        r3 = (com.huawei.hwbasemgr.IBaseResponseCallback) r3;	 Catch:{ all -> 0x0055 }
        r4 = 100001; // 0x186a1 float:1.40131E-40 double:4.9407E-319;
        r6 = "UNKNOWN_ERROR";
        r3.onResponse(r4, r6);	 Catch:{ all -> 0x0055 }
        r3 = 0;
        r2.remove(r3);	 Catch:{ all -> 0x0055 }
        goto L_0x0868;
    L_0x0894:
        r2 = move-exception;
        goto L_0x0752;
    L_0x0897:
        r9 = r2;
        goto L_0x00f3;
    L_0x089a:
        r5 = r2;
        goto L_0x0084;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.n.c.b(byte[]):void");
    }

    private int m5390c(byte[] bArr) {
        String a = C0973a.m3509a(bArr);
        return Integer.parseInt(a.substring(8, a.length()), 16);
    }

    private static synchronized Object m5418x() {
        Map map;
        synchronized (C1204c.class) {
            map = f2623i;
        }
        return map;
    }

    private static synchronized Object m5419y() {
        Map map;
        synchronized (C1204c.class) {
            map = f2624j;
        }
        return map;
    }

    private static synchronized Object m5420z() {
        List list;
        synchronized (C1204c.class) {
            list = f2625k;
        }
        return list;
    }

    private static synchronized Object m5350A() {
        List list;
        synchronized (C1204c.class) {
            list = f2626l;
        }
        return list;
    }

    private static synchronized Object m5351B() {
        Object obj;
        synchronized (C1204c.class) {
            obj = f2622h;
        }
        return obj;
    }

    private void m5352C() {
        synchronized (this.f2639r) {
            if (this.f2636n != null) {
                this.f2636n.post(new com.huawei.n.s(this));
            }
        }
    }

    private void m5386b(List<DataDeviceAvoidDisturbInfo> list, IBaseResponseCallback iBaseResponseCallback) {
        synchronized (this.f2639r) {
            C2538c.m12677c("HWDeviceConfigManager", "insertDeviceAvoidDisturbingToDB()");
            DBObject dBObject = new DBObject();
            dBObject.setiBaseResponseCallback(iBaseResponseCallback);
            dBObject.setObject(list);
            Message obtainMessage = this.f2636n.obtainMessage();
            obtainMessage.what = 1;
            obtainMessage.obj = dBObject;
            this.f2636n.sendMessage(obtainMessage);
            if (this.f2641u != null) {
                this.f2641u.d(list, false);
            }
        }
    }

    private void m5392c(List<DataDeviceAvoidDisturbInfo> list, IBaseResponseCallback iBaseResponseCallback) {
        synchronized (this.f2639r) {
            C2538c.m12677c("HWDeviceConfigManager", "updateDeviceAvoidDisturbingToDB()");
            DBObject dBObject = new DBObject();
            dBObject.setiBaseResponseCallback(iBaseResponseCallback);
            dBObject.setObject(list);
            Message obtainMessage = this.f2636n.obtainMessage();
            obtainMessage.what = 2;
            obtainMessage.obj = dBObject;
            this.f2636n.sendMessage(obtainMessage);
            if (this.f2641u != null) {
                this.f2641u.d(list, false);
            }
        }
    }

    private void m5406l(IBaseResponseCallback iBaseResponseCallback) {
        synchronized (this.f2639r) {
            Message obtainMessage = this.f2636n.obtainMessage();
            obtainMessage.what = 3;
            obtainMessage.obj = iBaseResponseCallback;
            this.f2636n.sendMessage(obtainMessage);
        }
    }

    public List<DataDeviceAvoidDisturbInfo> m5457h() {
        List<DataDeviceAvoidDisturbInfo> arrayList;
        synchronized (this.f2639r) {
            arrayList = new ArrayList();
            Cursor queryStorageData = queryStorageData("avoid_disturb", 1, "User_ID='" + C1204c.m5404j() + "'");
            if (queryStorageData != null) {
                while (queryStorageData.moveToNext()) {
                    DataDeviceAvoidDisturbInfo dataDeviceAvoidDisturbInfo = new DataDeviceAvoidDisturbInfo();
                    dataDeviceAvoidDisturbInfo.setDevice_avoid_disturb_index(queryStorageData.getInt(queryStorageData.getColumnIndex("indexs")));
                    dataDeviceAvoidDisturbInfo.setDevice_avoid_disturb_switch(queryStorageData.getInt(queryStorageData.getColumnIndex("switch")));
                    dataDeviceAvoidDisturbInfo.setDevice_avoid_disturb_time_switch(queryStorageData.getInt(queryStorageData.getColumnIndex("time_switch")));
                    dataDeviceAvoidDisturbInfo.setDevice_avoid_disturb_type(queryStorageData.getInt(queryStorageData.getColumnIndex("type")));
                    dataDeviceAvoidDisturbInfo.setDevice_avoid_disturb_start_time(C0973a.m3519f(queryStorageData.getString(queryStorageData.getColumnIndex("start_time"))));
                    dataDeviceAvoidDisturbInfo.setDevice_avoid_disturb_end_time(C0973a.m3519f(queryStorageData.getString(queryStorageData.getColumnIndex("end_time"))));
                    dataDeviceAvoidDisturbInfo.setDevice_avoid_disturb_cycle(queryStorageData.getInt(queryStorageData.getColumnIndex(JoinConstants.CYCLE)));
                    arrayList.add(dataDeviceAvoidDisturbInfo);
                }
                queryStorageData.close();
            } else {
                C2538c.m12677c("HWDeviceConfigManager", "cursor is null");
            }
        }
        return arrayList;
    }

    private synchronized void m5387b(boolean z) {
        int i = 1;
        synchronized (this) {
            C2538c.m12677c("HWDeviceConfigManager", "setAutoLightScreenToSharedPreference() :" + z);
            String c = C1093a.m4739a(BaseApplication.m2632b()).m4750c();
            if (TextUtils.isEmpty(c)) {
                c = "default_id";
            }
            if (!z) {
                i = 0;
            }
            setSharedPreference(c + "screen_light_key", String.valueOf(i), null);
            if (this.f2641u != null) {
                this.f2641u.b(String.valueOf(i), false);
            }
        }
    }

    private synchronized int m5353D() {
        int i = 1;
        synchronized (this) {
            String c = C1093a.m4739a(BaseApplication.m2632b()).m4750c();
            if (TextUtils.isEmpty(c)) {
                c = "default_id";
            }
            Object sharedPreference = getSharedPreference(c + "screen_light_key");
            if (TextUtils.isEmpty(sharedPreference)) {
                DeviceInfo c2 = m5447c();
                if (c2 != null) {
                    String sharedPreference2 = getSharedPreference(c2.getDeviceIdentify());
                    C2538c.m12677c("HWDeviceConfigManager", "getAutoLightScreenFromSharedPreference() stats = " + sharedPreference2);
                    if (!"".equals(sharedPreference2)) {
                        i = Integer.parseInt(sharedPreference2);
                        setSharedPreference(c + "screen_light_key", sharedPreference2, null);
                    }
                } else {
                    C2538c.m12680e("HWDeviceConfigManager", "getAutoLightScreenFromSharedPreference() deviceInfo is null  ");
                }
            } else {
                i = Integer.parseInt(sharedPreference);
            }
        }
        return i;
    }

    private synchronized void m5393c(boolean z) {
        int i = 0;
        synchronized (this) {
            C2538c.m12677c("HWDeviceConfigManager", "setWearMessagePushToSharedPreference() :" + z);
            String c = C1093a.m4739a(BaseApplication.m2632b()).m4750c();
            if (TextUtils.isEmpty(c)) {
                c = "default_id";
            }
            if (!z) {
                i = 1;
            }
            setSharedPreference(c + "wear_push_message_key", String.valueOf(i), null);
        }
    }

    private synchronized int m5354E() {
        int i = 0;
        synchronized (this) {
            String c = C1093a.m4739a(BaseApplication.m2632b()).m4750c();
            if (TextUtils.isEmpty(c)) {
                c = "default_id";
            }
            Object sharedPreference = getSharedPreference(c + "wear_push_message_key");
            if (TextUtils.isEmpty(sharedPreference)) {
                DeviceInfo c2 = m5447c();
                if (c2 != null) {
                    String sharedPreference2 = getSharedPreference(c2.getDeviceIdentify());
                    C2538c.m12677c("HWDeviceConfigManager", "getWearMessagePushFromSharePreference() state = " + sharedPreference2);
                    if (!"".equals(sharedPreference2)) {
                        i = Integer.parseInt(sharedPreference2);
                        setSharedPreference(c + "wear_push_message_key", sharedPreference2, null);
                    }
                } else {
                    C2538c.m12680e("HWDeviceConfigManager", "getWearMessagePushFromSharePreference() deviceInfo is null  ");
                }
            } else {
                i = Integer.parseInt(sharedPreference);
            }
        }
        return i;
    }

    private synchronized void m5396d(boolean z) {
        int i = 1;
        synchronized (this) {
            C2538c.m12677c("HWDeviceConfigManager", "setRotateSwitchScreenSwitchStatus() :" + z);
            String c = C1093a.m4739a(BaseApplication.m2632b()).m4750c();
            if (TextUtils.isEmpty(c)) {
                c = "default_id";
            }
            c = c + "screen_rotate_key";
            if (!z) {
                i = 0;
            }
            setSharedPreference(c, String.valueOf(i), null);
            if (this.f2641u != null) {
                this.f2641u.c(String.valueOf(i), false);
            }
        }
    }

    private synchronized int m5355F() {
        int i = 0;
        synchronized (this) {
            String c = C1093a.m4739a(BaseApplication.m2632b()).m4750c();
            if (TextUtils.isEmpty(c)) {
                c = "default_id";
            }
            Object sharedPreference = getSharedPreference(c + "screen_rotate_key");
            if (TextUtils.isEmpty(sharedPreference)) {
                DeviceInfo c2 = m5447c();
                if (c2 != null) {
                    String sharedPreference2 = getSharedPreference(c2.getDeviceIdentify() + "rotate_switch_screen");
                    C2538c.m12677c("HWDeviceConfigManager", "getRotateSwitchScreenFromSharedPreference() stats = " + sharedPreference2);
                    if (!"".equals(sharedPreference2)) {
                        i = Integer.parseInt(sharedPreference2);
                        setSharedPreference(c + "screen_rotate_key", sharedPreference2, null);
                    }
                } else {
                    C2538c.m12680e("HWDeviceConfigManager", "getRotateSwitchScreenFromSharedPreference() deviceInfo is null  ");
                }
            } else {
                i = Integer.parseInt(sharedPreference);
            }
        }
        return i;
    }

    private synchronized void m5398e(boolean z) {
        int i = 1;
        synchronized (this) {
            C2538c.m12677c("HWDeviceConfigManager", "setLeftRightHandStateToSharedPreference() :" + z);
            String c = C1093a.m4739a(BaseApplication.m2632b()).m4750c();
            if (TextUtils.isEmpty(c)) {
                c = "default_id";
            }
            if (!z) {
                i = 0;
            }
            setSharedPreference(c + "left_or_right_hand_wear_state", String.valueOf(i), null);
            if (this.f2641u != null) {
                this.f2641u.g(String.valueOf(i), false);
            }
        }
    }

    private synchronized int m5356G() {
        int i = 0;
        synchronized (this) {
            String c = C1093a.m4739a(BaseApplication.m2632b()).m4750c();
            if (TextUtils.isEmpty(c)) {
                c = "default_id";
            }
            Object sharedPreference = getSharedPreference(c + "left_or_right_hand_wear_state");
            if (TextUtils.isEmpty(sharedPreference)) {
                DeviceInfo c2 = m5447c();
                if (c2 != null) {
                    String sharedPreference2 = getSharedPreference(c2.getDeviceIdentify() + "left_or_right_hand_wear_state");
                    C2538c.m12677c("HWDeviceConfigManager", "getLeftRightHandStateFromSharedPreference() stats = " + sharedPreference2);
                    if (!"".equals(sharedPreference2)) {
                        i = Integer.parseInt(sharedPreference2);
                        setSharedPreference(c + "left_or_right_hand_wear_state", sharedPreference2, null);
                    }
                } else {
                    C2538c.m12680e("HWDeviceConfigManager", "getLeftRightHandStateFromSharedPreference() deviceInfo is null  ");
                }
            } else {
                i = Integer.parseInt(sharedPreference);
            }
        }
        return i;
    }

    private void m5357H() {
        DeviceInfo c = m5447c();
        if (c != null) {
            DeviceCapability a = C0972a.m3499a();
            if (c.getDeviceProtocol() != 0) {
                if (a != null) {
                    boolean z;
                    if (a.isSupportGetFirmwareVersion()) {
                        m5425a(this.f2645z);
                    } else {
                        C2538c.m12680e("HWDeviceConfigManager", "autoSendCommend() not Support GetFirmwareVersion");
                    }
                    if (a.isSupportTimeSetting()) {
                        m5371a(m5359J(), m5358I(), this.f2645z, true);
                    } else {
                        C2538c.m12680e("HWDeviceConfigManager", "autoSendCommend() not Support TimeSetting");
                    }
                    if (m5353D() == 0) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (a.isAuto_light_screen()) {
                        m5438a(z, this.f2645z, true);
                    } else {
                        C2538c.m12680e("HWDeviceConfigManager", "autoSendCommend() not Support Auto_light_screen");
                    }
                    if (m5355F() == 0) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (a.isRotate_switch_screen()) {
                        m5445b(z, this.f2645z, true);
                    } else {
                        C2538c.m12680e("HWDeviceConfigManager", "autoSendCommend() not Support Rotate_switch_screen");
                    }
                    if (a.isSupportLeftRightHandWearMode()) {
                        if (1 == m5356G()) {
                            z = true;
                        } else {
                            z = false;
                        }
                        C2538c.m12677c("HWDeviceConfigManager", "autoSendCommend() setLeftOrRightHandWearStatus wearState = " + z);
                        m5448c(z, this.f2645z, true);
                    } else {
                        C2538c.m12680e("HWDeviceConfigManager", "autoSendCommend() not isSupportLeftRightHandWearMode");
                    }
                    m5406l(new com.huawei.n.u(this, a));
                    if (a.isSupportWearMessagePush()) {
                        m5437a(m5354E() == 0, null);
                    }
                    if (a.isSupportMidware()) {
                        C2538c.m12677c("HWDeviceConfigManager", "autoSendCommend() Support midware");
                        m5414t();
                    } else {
                        C1035a.m4176b().m4179a(false);
                        C1035a.m4176b().m4185b(false);
                        C1035a.m4176b().m4186c(false);
                        C2538c.m12677c("HWDeviceConfigManager", "autoSendCommend() not Support midware");
                    }
                } else {
                    C2538c.m12680e("HWDeviceConfigManager", "autoSendCommend() deviceCapability is null");
                }
            }
        } else {
            C2538c.m12680e("HWDeviceConfigManager", "autoSendCommend() deviceInfo is null");
        }
        m5417w();
    }

    private int m5358I() {
        ContentResolver contentResolver = this.f2633e.getContentResolver();
        C2538c.m12677c("HWDeviceConfigManager", "getSystemTimeFormat() mContext = " + this.f2633e);
        String string = System.getString(contentResolver, "time_12_24");
        C2538c.m12677c("HWDeviceConfigManager", "getSystemTimeFormat() strTimeFormat = " + string);
        if (string == null || HwAccountConstants.TYPE_GOOGLEPLUS.equals(string)) {
            return 2;
        }
        return 1;
    }

    private int m5359J() {
        ContentResolver contentResolver = this.f2633e.getContentResolver();
        C2538c.m12677c("HWDeviceConfigManager", "getSystemDateFormat() mContext = " + this.f2633e);
        String string = System.getString(contentResolver, "date_format");
        C2538c.m12677c("HWDeviceConfigManager", "getSystemDateFormat() strDateFormat = " + string);
        if (string == null || string.length() < 2 || "yy".equals(string.substring(0, 2))) {
            return 1;
        }
        if ("MM".equals(string.substring(0, 2))) {
            return 2;
        }
        if ("dd".equals(string.substring(0, 2))) {
            return 3;
        }
        return 1;
    }

    protected void onDestroy() {
        super.onDestroy();
        this.f2635m.quit();
        this.f2635m = null;
        m5422a(2);
        C1204c.m5360K();
        try {
            this.f2633e.unregisterReceiver(this.f2644y);
        } catch (IllegalArgumentException e) {
            C2538c.m12680e("HWDeviceConfigManager", "mConnectStateChangedReceiver is not registered");
        }
        synchronized (C1204c.m5419y()) {
            for (int i = 0; i < f2629v.size(); i++) {
                if (f2624j.get(f2629v.get(i)) != null) {
                    ((List) f2624j.get(f2629v.get(i))).clear();
                }
            }
        }
        C2538c.m12677c("HWDeviceConfigManager", "onDestroy()");
    }

    private static void m5360K() {
        synchronized (f2628s) {
            f2620d = null;
        }
        synchronized (C1204c.m5351B()) {
            f2621g = null;
        }
    }

    private String m5395d(byte[] bArr) {
        C2538c.m12677c("HWDeviceConfigManager", "Enter getV0DeviceVersion().");
        String str = "";
        if (bArr == null) {
            C2538c.m12680e("HWDeviceConfigManager", "Parameter is incorrect.");
            return str;
        } else if (14 != bArr.length) {
            C2538c.m12680e("HWDeviceConfigManager", "V0 device version info is incorrect.");
            return str;
        } else {
            str = C0973a.m3509a(bArr);
            int parseInt = Integer.parseInt(str.substring(6, 8), 16);
            int parseInt2 = Integer.parseInt(str.substring(8, 10), 16);
            int parseInt3 = Integer.parseInt(str.substring(10, 14), 16);
            int parseInt4 = Integer.parseInt(str.substring(14, 18), 16);
            int parseInt5 = Integer.parseInt(str.substring(18, 22), 16);
            int parseInt6 = Integer.parseInt(str.substring(22, 26), 16);
            return String.valueOf(parseInt / 100) + String.valueOf(parseInt2) + "." + String.format("%02X.", new Object[]{Integer.valueOf(parseInt3)}) + String.format("%02X.", new Object[]{Integer.valueOf(parseInt4)}) + String.format("%02X.", new Object[]{Integer.valueOf(parseInt5)}) + String.format("%02X", new Object[]{Integer.valueOf(parseInt6)});
        }
    }

    public int m5459i() {
        DeviceInfo c = m5447c();
        if (c != null) {
            return c.getDeviceProtocol();
        }
        return -1;
    }

    public static String m5404j() {
        f2619b = C1093a.m4739a(BaseApplication.m2632b()).m4750c();
        if (f2619b == null) {
            f2619b = "";
        }
        return f2619b;
    }

    private void m5373a(DeviceInfo deviceInfo) {
        if (deviceInfo != null) {
            C2538c.m12677c("HWDeviceConfigManager", "Enter generateConnectedMessage !!!");
            C1971j a = C1971j.m10236a(this.f2633e);
            a.m10254b("device", "device_type_connected", new e(this, a, deviceInfo));
            return;
        }
        C2538c.m12679d("HWDeviceConfigManager", "generateConnectedMessage fail, btDeviceInfo is null");
    }

    private void m5361L() {
        DeviceInfo b = m5439b();
        if (b != null) {
            Object v = m5416v();
            if (v != null) {
                C0972a.m3500a((DeviceCapability) v);
                String toJson = new Gson().toJson(v, (Type) DeviceCapability.class);
                C2538c.m12674b("HWDeviceConfigManager", "initDeviceInfo setSharedPreference");
                C0996a.m3611a(this.f2633e, String.valueOf(getModuleId()), "kStorage_DeviceCfgMgr_Capability", toJson, null);
            }
            C0972a.m3501a(b);
            return;
        }
        Gson gson = new Gson();
        toJson = C0996a.m3612a(this.f2633e, String.valueOf(getModuleId()), "kStorage_DeviceCfgMgr_Capability");
        if (toJson != null && !"".equalsIgnoreCase(toJson)) {
            C2538c.m12674b("HWDeviceConfigManager", "initDeviceInfo getSharedPreference");
            C0972a.m3500a((DeviceCapability) gson.fromJson(toJson, DeviceCapability.class));
        }
    }

    private static synchronized Object m5362M() {
        Object obj;
        synchronized (C1204c.class) {
            obj = f2627p;
        }
        return obj;
    }

    private void m5363N() {
        try {
            this.f2637o.clear();
            List<DeviceInfo> a = m5421a();
            if (a != null) {
                for (DeviceInfo add : a) {
                    this.f2637o.add(add);
                }
                C2538c.m12677c("HWDeviceConfigManager", "deleteUseDeviceList() 删除前usedDeviceList.size() = " + this.f2637o.size());
                DeviceInfo c = m5447c();
                if (c != null) {
                    C2538c.m12677c("HWDeviceConfigManager", "deleteUseDeviceList() 需要删除的设备Mac = " + c.getDeviceIdentify());
                    int i = -1;
                    for (DeviceInfo add2 : this.f2637o) {
                        int indexOf;
                        C2538c.m12677c("HWDeviceConfigManager", "deleteUseDeviceList() 列表中的设备Mac = " + add2.getDeviceIdentify());
                        if (add2.getDeviceIdentify().equals(c.getDeviceIdentify())) {
                            indexOf = this.f2637o.indexOf(add2);
                        } else {
                            indexOf = i;
                        }
                        i = indexOf;
                    }
                    C2538c.m12677c("HWDeviceConfigManager", "deleteUseDeviceList() id = " + i);
                    if (-1 != i) {
                        this.f2637o.remove(i);
                    }
                    C2538c.m12677c("HWDeviceConfigManager", "deleteUseDeviceList() 删除后usedDeviceList.size() = " + this.f2637o.size());
                    return;
                }
                C2538c.m12677c("HWDeviceConfigManager", "deleteUseDeviceList() removeDevice is null");
                return;
            }
            C2538c.m12677c("HWDeviceConfigManager", "deleteUseDeviceList() getUsedDeviceList() is null");
        } catch (RemoteException e) {
            C2538c.m12680e("HWDeviceConfigManager", "deleteUseDeviceList() error = " + e.getMessage());
            C1045q.m4405a(BaseApplication.m2632b());
        }
    }

    public void m5428a(String str) {
        C0993c c0993c = new C0993c();
        c0993c.f1664a = 0;
        C0996a.m3611a(this.f2633e, String.valueOf(10010), "kStorage_AlarmMgr_MAC", str, c0993c);
    }

    public String m5462k() {
        return C0996a.m3612a(this.f2633e, String.valueOf(10010), "kStorage_AlarmMgr_MAC");
    }

    private String m5364O() {
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        return C0973a.m3506a(currentTimeMillis >> 24) + C0973a.m3506a((currentTimeMillis >> 16) & 255) + C0973a.m3506a((currentTimeMillis >> 8) & 255) + C0973a.m3506a(currentTimeMillis & 255);
    }

    private String m5365P() {
        TimeZone timeZone = TimeZone.getDefault();
        int rawOffset = (timeZone.getRawOffset() / 3600) / 1000;
        if (timeZone.inDaylightTime(new Date())) {
            rawOffset += (timeZone.getDSTSavings() / 3600) / 1000;
        }
        int abs = (Math.abs((timeZone.getRawOffset() / 3600) % 1000) * 60) / 1000;
        if (rawOffset < 0) {
            rawOffset = (Math.abs(rawOffset) + 128) << 8;
        } else {
            rawOffset <<= 8;
        }
        rawOffset += abs;
        return C0973a.m3506a(rawOffset >> 8) + C0973a.m3506a(rawOffset & 255);
    }

    public void m5456g(IBaseResponseCallback iBaseResponseCallback) {
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(1);
        deviceCommand.setCommandID(24);
        ByteBuffer allocate = ByteBuffer.allocate(2);
        allocate.put((byte) 1);
        allocate.put((byte) 0);
        m5374a(deviceCommand, allocate, 24, iBaseResponseCallback, true);
    }

    public void m5458h(IBaseResponseCallback iBaseResponseCallback) {
        this.f2638q = iBaseResponseCallback;
        C2538c.m12677c("HWDeviceConfigManager", "registerOpenAppIBaseResponseCallback() callback = " + iBaseResponseCallback);
    }

    public void m5463l() {
        this.f2638q = null;
    }

    private void m5372a(int i, WearableOpenAppInfo wearableOpenAppInfo) {
        this.f2638q.onResponse(i, wearableOpenAppInfo);
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(1);
        deviceCommand.setCommandID(23);
        ByteBuffer allocate = ByteBuffer.allocate(6);
        allocate.put(TagName.ELECTRONIC_PUBLISH_START_TIME);
        allocate.put((byte) 4);
        allocate.put(C0973a.m3512b(C0973a.m3507a(100000)));
        deviceCommand.setDataLen(allocate.array().length);
        deviceCommand.setDataContent(allocate.array());
        m5374a(deviceCommand, allocate, 23, null, true);
        C2538c.m12677c("HWDeviceConfigManager", "openApp() callback = " + this.f2638q);
    }

    public void m5430a(String str, IBaseResponseCallback iBaseResponseCallback) {
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(1);
        deviceCommand.setCommandID(25);
        String e = C0973a.m3518e(str);
        String e2 = C0973a.m3517e(e.length() / 2);
        String a = C0973a.m3506a(1);
        ByteBuffer allocate = ByteBuffer.allocate(((a.length() / 2) + (e2.length() / 2)) + (e.length() / 2));
        allocate.put(C0973a.m3512b(a));
        allocate.put(C0973a.m3512b(e2));
        allocate.put(C0973a.m3512b(e));
        m5374a(deviceCommand, allocate, 25, iBaseResponseCallback, true);
    }

    public void m5443b(String str) {
        synchronized (this.f2639r) {
            try {
                if (m5439b() != null) {
                    C2538c.m12677c("HWDeviceConfigManager", "sendAWFilePath(): filepath = " + str);
                    if (C1045q.m4404a() != null) {
                        C1045q.m4404a().mo2327a(str);
                    } else {
                        C2538c.m12680e("HWDeviceConfigManager", "sendAWFilePath() iPhoneServiceAIDL is null");
                        C1045q.m4405a(BaseApplication.m2632b());
                    }
                }
            } catch (RemoteException e) {
                C2538c.m12680e("HWDeviceConfigManager", "sendAWFilePath " + e.getMessage());
                C1045q.m4405a(BaseApplication.m2632b());
            }
        }
    }

    private int m5366Q() {
        int i;
        if (C0977d.m3570j(this.f2633e)) {
            i = 1;
        } else {
            i = 2;
        }
        C2538c.m12677c("HWDeviceConfigManager", "getHWHealthStatus() flag = " + i);
        return i;
    }

    public boolean m5464m() throws RemoteException {
        if (C1045q.m4404a() != null) {
            return C1045q.m4404a().mo2338d();
        }
        C2538c.m12680e("HWDeviceConfigManager", "getSystemBluetoothSwitchState() iPhoneServiceAIDL is null");
        C1045q.m4405a(BaseApplication.m2632b());
        return false;
    }

    public void m5436a(boolean z) throws RemoteException {
        if (C1045q.m4404a() != null) {
            C1045q.m4404a().mo2332a(z);
            return;
        }
        C2538c.m12680e("HWDeviceConfigManager", "openSystemBluetoothSwitch() iPhoneServiceAIDL is null");
        C1045q.m4405a(BaseApplication.m2632b());
    }

    public void m5429a(String str, int i, long j, int i2, String str2, String str3, byte[] bArr, IBaseResponseCallback iBaseResponseCallback) {
        C2538c.m12677c("FAQ", "Enter sendFAQMessageToDevice !");
        m5407m(iBaseResponseCallback);
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(2);
        deviceCommand.setCommandID(7);
        String e = C0973a.m3518e(str);
        String e2 = C0973a.m3517e(e.length() / 2);
        String a = C0973a.m3506a(1);
        String a2 = C0973a.m3506a(i);
        String e3 = C0973a.m3517e(a2.length() / 2);
        String a3 = C0973a.m3506a(2);
        String a4 = C0973a.m3507a(j);
        String e4 = C0973a.m3517e(a4.length() / 2);
        String a5 = C0973a.m3506a(3);
        String a6 = C0973a.m3506a(i2);
        String e5 = C0973a.m3517e(a6.length() / 2);
        String a7 = C0973a.m3506a(4);
        String e6 = C0973a.m3518e(str2);
        String e7 = C0973a.m3517e(e6.length() / 2);
        String a8 = C0973a.m3506a(5);
        String e8 = C0973a.m3518e(str3);
        String e9 = C0973a.m3517e(e8.length() / 2);
        String a9 = C0973a.m3506a(6);
        String str4 = "";
        if (bArr != null) {
            str4 = C0973a.m3509a(bArr);
        }
        String e10 = C0973a.m3517e(str4.length() / 2);
        String a10 = C0973a.m3506a(7);
        ByteBuffer allocate = ByteBuffer.allocate(((((((((((((((((((((a.length() / 2) + (e2.length() / 2)) + (e.length() / 2)) + (a3.length() / 2)) + (e3.length() / 2)) + (a2.length() / 2)) + (a5.length() / 2)) + (e4.length() / 2)) + (a4.length() / 2)) + (a7.length() / 2)) + (e5.length() / 2)) + (a6.length() / 2)) + (a8.length() / 2)) + (e7.length() / 2)) + (e6.length() / 2)) + (a9.length() / 2)) + (e9.length() / 2)) + (e8.length() / 2)) + (a10.length() / 2)) + (e10.length() / 2)) + (str4.length() / 2));
        allocate.put(C0973a.m3512b(a));
        allocate.put(C0973a.m3512b(e2));
        allocate.put(C0973a.m3512b(e));
        allocate.put(C0973a.m3512b(a3));
        allocate.put(C0973a.m3512b(e3));
        allocate.put(C0973a.m3512b(a2));
        allocate.put(C0973a.m3512b(a5));
        allocate.put(C0973a.m3512b(e4));
        allocate.put(C0973a.m3512b(a4));
        allocate.put(C0973a.m3512b(a7));
        allocate.put(C0973a.m3512b(e5));
        allocate.put(C0973a.m3512b(a6));
        allocate.put(C0973a.m3512b(a8));
        allocate.put(C0973a.m3512b(e7));
        allocate.put(C0973a.m3512b(e6));
        allocate.put(C0973a.m3512b(a9));
        allocate.put(C0973a.m3512b(e9));
        allocate.put(C0973a.m3512b(e8));
        allocate.put(C0973a.m3512b(a10));
        allocate.put(C0973a.m3512b(e10));
        if (bArr != null) {
            allocate.put(bArr);
        } else {
            allocate.put(C0973a.m3512b(str4));
        }
        deviceCommand.setDataLen(allocate.array().length);
        deviceCommand.setDataContent(allocate.array());
        m5427a(deviceCommand);
    }

    private void m5407m(IBaseResponseCallback iBaseResponseCallback) {
        this.f2630A = iBaseResponseCallback;
        m5423a(2, this.f2632c);
    }

    public void m5460i(IBaseResponseCallback iBaseResponseCallback) throws RemoteException {
        if (C1045q.m4404a() != null) {
            C1045q.m4404a().mo2323a(new i(this, iBaseResponseCallback));
            return;
        }
        C2538c.m12680e("HWDeviceConfigManager", "getDeviceListFromHealth() iPhoneServiceAIDL is null");
        C1045q.m4405a(BaseApplication.m2632b());
    }

    public void m5461j(IBaseResponseCallback iBaseResponseCallback) throws RemoteException {
        if (C1045q.m4404a() != null) {
            C1045q.m4404a().mo2322a(new j(this, iBaseResponseCallback));
            return;
        }
        C2538c.m12680e("HWDeviceConfigManager", "getDeviceListFromHealth() iPhoneServiceAIDL is null");
        C1045q.m4405a(BaseApplication.m2632b());
    }

    public void m5444b(String str, IBaseResponseCallback iBaseResponseCallback) throws RemoteException {
        C2538c.m12677c("HWDeviceConfigManager", "Enter sendDataToHealth ");
        if (C1045q.m4404a() != null) {
            C1045q.m4404a().mo2328a(str, new k(this, iBaseResponseCallback));
            return;
        }
        C2538c.m12680e("HWDeviceConfigManager", "sendDataToHealth() iPhoneServiceAIDL is null");
        C1045q.m4405a(BaseApplication.m2632b());
    }

    public void m5432a(String str, boolean z, IBaseResponseCallback iBaseResponseCallback) throws RemoteException {
        C2538c.m12677c("HWDeviceConfigManager", "Enter sendLeoSuppoptInHealthFlag ");
        if (C1045q.m4404a() != null) {
            C1045q.m4404a().mo2330a(str, z, new l(this, iBaseResponseCallback));
            return;
        }
        C2538c.m12680e("HWDeviceConfigManager", "sendLeoSuppoptInHealthFlag() iPhoneServiceAIDL is null");
        C1045q.m4405a(BaseApplication.m2632b());
    }

    public void m5440b(int i, IBaseResponseCallback iBaseResponseCallback) throws RemoteException {
        C2538c.m12677c("HWDeviceConfigManager", "Enter getCommonData ");
        if (C1045q.m4404a() != null) {
            C1045q.m4404a().mo2319a(i, new m(this, iBaseResponseCallback, i));
            return;
        }
        C2538c.m12680e("HWDeviceConfigManager", "isHealthSupportWearDevice() iPhoneServiceAIDL is null");
        iBaseResponseCallback.onResponse(-1, "honeServiceBinder is null");
        C1045q.m4405a(BaseApplication.m2632b());
    }
}
