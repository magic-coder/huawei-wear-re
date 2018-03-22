package com.huawei.hwdevicemgr.p073a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.fenda.hwbracelet.p261d.C3597a;
import com.google.gson.Gson;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwbtsdk.p057b.p058a.C4620b;
import com.huawei.hwbtsdk.p057b.p400b.C4625b;
import com.huawei.hwbtsdk.p399a.C4619w;
import com.huawei.hwbtsdk.p057b.p058a.C0957a;
import com.huawei.hwbtsdk.p057b.p058a.C0958f;
import com.huawei.hwbtsdk.p059c.BTSDKApi;
import com.huawei.hwbtsdk.p399a.C4600d;
import com.huawei.hwbtsdk.p399a.C4610m;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.datatypes.DeviceCapability;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.hwcommonmodel.datatypes.HWOTAParameter;
import com.huawei.hwcommonmodel.p063b.C0976c;
import com.huawei.hwcommonmodel.p064d.C0977d;
import com.huawei.hwdataaccessmodel.sharedpreference.C0996a;
import com.huawei.hwdevicemgr.a.e;
import com.huawei.hwdevicemgr.a.f;
import com.huawei.hwdevicemgr.a.g;
import com.huawei.hwdevicemgr.a.h;
import com.huawei.hwdevicemgr.a.i;
import com.huawei.hwdevicemgr.a.j;
import com.huawei.hwdevicemgr.dmsdatatype.datatype.C1025h;
import com.huawei.hwdevicemgr.dmsdatatype.datatype.DataOtaParametersV2;
import com.huawei.hwdevicemgr.dmsdatatype.datatype.DeviceCommand;
import com.huawei.hwdevicemgr.dmsdatatype.p074a.C1024b;
import com.huawei.nfc.PluginPayAdapter;
import com.huawei.p029c.C0669b;
import com.huawei.p190v.C2538c;
import com.huawei.pluginaf500.connect_ble.C5775a;
import com.huawei.pluginaf500.ui.AF500IntroduceActivity;
import java.nio.ByteBuffer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import net.sqlcipher.database.SQLiteDatabase;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: HWDeviceMgr */
public class C1023c {
    private static C1023c f1829e = null;
    private static final Object f1830y = new Object();
    private BroadcastReceiver f1831A = new C4988g(this);
    private C3597a f1832B = new C4990i(this);
    C4600d f1833a = C4600d.m21899a();
    C0669b f1834b = new C4986e(this);
    public final C4620b f1835c = new C4989h(this);
    private Context f1836d = BaseApplication.m2632b();
    private BTSDKApi f1837f = null;
    private C1024b f1838g;
    private String f1839h = "";
    private String f1840i = "";
    private int f1841j = -1;
    private int f1842k = 3;
    private boolean f1843l = false;
    private List<DeviceInfo> f1844m = new ArrayList();
    private HandlerThread f1845n;
    private Handler f1846o;
    private j f1847p;
    private C0669b f1848q = null;
    private boolean f1849r = false;
    private DeviceCapability f1850s = new DeviceCapability();
    private C5775a f1851t = null;
    private C4984b f1852u = null;
    private C4983a f1853v = null;
    private String f1854w = "";
    private String f1855x = "";
    private C0958f f1856z = new C4987f(this);

    private C1023c() {
        C2538c.m12672b("02", 0, "HWDeviceMgr", "Init BTSDK.");
        this.f1837f = BTSDKApi.m3425a(this.f1836d);
        this.f1837f.m3458a(this.f1856z);
        this.f1851t = C5775a.a(this.f1836d);
        this.f1851t.a(this.f1832B);
        this.f1852u = new C4984b(this.f1836d);
        this.f1853v = new C4983a(this.f1836d);
        this.f1851t.a(this.f1852u);
        this.f1851t.a(this.f1853v);
        this.f1838g = null;
        this.f1845n = new HandlerThread("save_dms_data");
        this.f1845n.start();
        this.f1846o = new Handler(this.f1845n.getLooper());
        if (this.f1844m != null) {
            C2538c.m12661a("02", 0, "HWDeviceMgr", "Start to find last active device.");
            m3972h();
            if (-1 != m3978k()) {
                C2538c.m12661a("02", 0, "HWDeviceMgr", "Find active device.");
                m3991a(this.f1844m, false);
            }
        }
        if (this.f1836d != null) {
            this.f1836d.registerReceiver(this.f1831A, new IntentFilter("android.intent.action.TIMEZONE_CHANGED"));
            this.f1836d.registerReceiver(this.f1831A, new IntentFilter("android.intent.action.TIME_SET"));
            this.f1836d.registerReceiver(this.f1831A, new IntentFilter("android.intent.action.DATE_CHANGED"));
        }
        if (this.f1833a != null) {
            this.f1833a.a(this.f1835c);
        }
    }

    private synchronized Object m3968g() {
        return this.f1844m;
    }

    private void m3972h() {
        C2538c.m12661a("02", 0, "HWDeviceMgr", "Enter getUsedDevicesFromStorage().");
        Map b = C0996a.m3618b(this.f1836d, String.valueOf(1000));
        if (b == null) {
            C2538c.m12672b("02", 0, "HWDeviceMgr", "map is null.");
            return;
        }
        synchronized (m3968g()) {
            this.f1844m.clear();
        }
        for (Entry value : b.entrySet()) {
            DeviceInfo deviceInfo = (DeviceInfo) new Gson().fromJson((String) value.getValue(), DeviceInfo.class);
            deviceInfo.setDeviceConnectState(3);
            synchronized (m3968g()) {
                this.f1844m.add(deviceInfo);
            }
        }
        if (this.f1844m.size() == 0) {
            C2538c.m12661a("02", 0, "HWDeviceMgr", "update has device db info with 0.");
            C1025h.m4002a(false);
            return;
        }
        C2538c.m12661a("02", 0, "HWDeviceMgr", "update has device db info with 1.");
        C1025h.m4002a(true);
    }

    private void m3975i() {
        C2538c.m12661a("02", 0, "HWDeviceMgr", "Enter setUsedDevicesToStorage().");
        this.f1846o.post(new com.huawei.hwdevicemgr.a.d(this));
    }

    public static C1023c m3920a(Context context) {
        C1023c c1023c;
        synchronized (f1830y) {
            if (f1829e == null) {
                f1829e = new C1023c();
            }
            c1023c = f1829e;
        }
        return c1023c;
    }

    public void m3985a(int i, String str, List<String> list, C0957a c0957a, String str2) {
        C2538c.m12661a("02", 0, "HWDeviceMgr", "Enter addDevice().");
        if (this.f1837f != null) {
            C2538c.m12661a("02", 0, "HWDeviceMgr", "Start to disable current device.");
            this.f1837f.m3460a(null);
            int k = m3978k();
            if (k > -1) {
                List arrayList = new ArrayList();
                arrayList.add(this.f1844m.get(k));
                C2538c.m12661a("02", 0, "HWDeviceMgr", "Start to send disconnect broadcast to EMUI.");
                m3950c(arrayList);
            }
            C2538c.m12661a("02", 0, "HWDeviceMgr", "Start to disable all device.");
            m3981l();
            if (this.f1851t != null) {
                this.f1851t.a(false);
                k = this.f1851t.d();
                if (1 == k || 2 == k) {
                    C2538c.m12661a("02", 0, "HWDeviceMgr", "AF500 is connected while add device.");
                    this.f1851t.a();
                }
            }
        }
        String str3 = "";
        if (list != null && 1 == list.size()) {
            str3 = (String) list.get(0);
        }
        if ("ColorBand".equalsIgnoreCase(str3)) {
            C2538c.m12661a("02", 0, "HWDeviceMgr", "Want to add ColorBand.");
            Intent intent = new Intent();
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            intent.putExtra("isStartupGuide", true);
            intent.setClass(this.f1836d, AF500IntroduceActivity.class);
            this.f1836d.startActivity(intent);
        } else if (this.f1837f != null) {
            this.f1837f.m3453a(i, str, list, c0957a, str2);
        }
    }

    public void m3988a(DeviceCommand deviceCommand) {
        if (deviceCommand == null) {
            C2538c.m12672b("02", 0, "HWDeviceMgr", "---sendOTACommand error, deviceCommand is null---.");
            return;
        }
        C2538c.m12661a("02", 0, "HWDeviceMgr", "Enter sendOTACommand() ota business with data = " + C0973a.m3509a(deviceCommand.getDataContent()));
        this.f1849r = true;
        if (2 == this.f1842k) {
            C4625b bVar = new C4625b();
            bVar.e(deviceCommand.getServiceID());
            bVar.a(deviceCommand.getDataContent());
            bVar.a(deviceCommand.getDataContent().length);
            bVar.a(deviceCommand.getNeedAck());
            bVar.b(deviceCommand.getPriority());
            bVar.a(this.f1839h);
            bVar.b(deviceCommand.getNeedEncrypt());
            bVar.d(2);
            if (this.f1837f != null) {
                this.f1837f.m3459a(bVar);
            }
        }
    }

    public void m3990a(String str, String str2, String str3, int i, C0669b c0669b) {
        DataOtaParametersV2 dataOtaParametersV2 = null;
        C2538c.m12661a("02", 0, "HWDeviceMgr", "Enter sendOTAFileData enter.");
        if (this.f1847p != null) {
            this.f1847p.a();
            this.f1847p = null;
        }
        this.f1847p = new j(this.f1837f, this.f1839h, this.f1841j);
        this.f1848q = c0669b;
        if (5 == this.f1841j) {
            HWOTAParameter hWOTAParameter;
            if (TextUtils.isEmpty(str3)) {
                C2538c.m12672b("02", 0, "HWDeviceMgr", "sendOTAFileData parameter is null.");
            } else {
                hWOTAParameter = (HWOTAParameter) new Gson().fromJson(str3, HWOTAParameter.class);
            }
            this.f1847p.a(str, str2, hWOTAParameter, i, this.f1834b);
            return;
        }
        if (TextUtils.isEmpty(str3)) {
            C2538c.m12672b("02", 0, "HWDeviceMgr", "sendOTAFileData parameter is null.");
        } else {
            dataOtaParametersV2 = (DataOtaParametersV2) new Gson().fromJson(str3, DataOtaParametersV2.class);
        }
        if (i == 0) {
            this.f1849r = true;
        }
        this.f1847p.a(str, str2, dataOtaParametersV2, i, this.f1834b);
    }

    private void m3939b(List<DeviceInfo> list, boolean z) {
        C2538c.m12661a("02", 0, "HWDeviceMgr", "Enter removeUsedDevice().");
        if (list == null) {
            C2538c.m12661a("02", 0, "HWDeviceMgr", "Parameter is incorrect.");
            return;
        }
        List arrayList = new ArrayList();
        for (int i = 0; i < this.f1844m.size(); i++) {
            String deviceIdentify = ((DeviceInfo) this.f1844m.get(i)).getDeviceIdentify();
            int productType = ((DeviceInfo) this.f1844m.get(i)).getProductType();
            for (DeviceInfo deviceIdentify2 : list) {
                if (deviceIdentify.equalsIgnoreCase(deviceIdentify2.getDeviceIdentify())) {
                    int i2 = 1;
                    break;
                }
            }
            boolean z2 = false;
            if (i2 == 0) {
                C2538c.m12661a("02", 0, "HWDeviceMgr", "wanted remove device identify = " + deviceIdentify);
                if (deviceIdentify.equalsIgnoreCase(this.f1839h)) {
                    this.f1841j = -1;
                    this.f1839h = "";
                    this.f1842k = 3;
                    if (-2 == productType && this.f1851t != null && this.f1851t.b().equalsIgnoreCase(deviceIdentify)) {
                        i2 = this.f1851t.d();
                        if (1 == i2 || 2 == i2) {
                            C2538c.m12661a("02", 0, "HWDeviceMgr", "Start to disconnect AF500 device for remove.");
                            this.f1851t.a(false);
                            this.f1851t.a();
                        }
                    }
                }
                if (-2 != productType) {
                    C2538c.m12661a("02", 0, "HWDeviceMgr", "Add wanted deleted device into list.");
                    arrayList.add(this.f1844m.get(i));
                }
                synchronized (m3968g()) {
                    C2538c.m12661a("02", 0, "HWDeviceMgr", "Remove Device from list.");
                    this.f1844m.remove(i);
                    m3977j();
                }
                if (-2 == productType) {
                    C2538c.m12661a("02", 0, "HWDeviceMgr", "Save AF500 device remove info.");
                    m3975i();
                }
            }
        }
        if (arrayList.size() != 0) {
            m3975i();
            if (this.f1837f != null) {
                this.f1837f.m3462a(arrayList, z);
                m3950c(arrayList);
                return;
            }
            return;
        }
        C2538c.m12661a("02", 0, "HWDeviceMgr", "Do not need delete device.");
    }

    private void m3927a(List<DeviceInfo> list) {
        C2538c.m12661a("02", 0, "HWDeviceMgr", "Enter setUsedDevice().");
        if (list == null) {
            C2538c.m12672b("02", 0, "HWDeviceMgr", "Parameter is incorrect.");
            return;
        }
        DeviceInfo deviceInfo;
        for (DeviceInfo deviceInfo2 : list) {
            if (deviceInfo2 != null && 1 == deviceInfo2.getDeviceActiveState()) {
                deviceInfo = deviceInfo2;
                break;
            }
        }
        deviceInfo = null;
        if (deviceInfo == null) {
            C2538c.m12672b("02", 0, "HWDeviceMgr", "Used List do not have active device.");
            return;
        }
        if (this.f1844m != null) {
            int d = m3951d(deviceInfo.getDeviceIdentify());
            int k = m3978k();
            if (-1 == d) {
                C2538c.m12672b("02", 0, "HWDeviceMgr", "History List do not have active device.");
                return;
            }
            int productType;
            if (1 != ((DeviceInfo) this.f1844m.get(d)).getDeviceActiveState()) {
                this.f1850s.resetDeviceCapability();
                ((DeviceInfo) this.f1844m.get(d)).setDeviceActiveState(1);
                if (-1 != k) {
                    ((DeviceInfo) this.f1844m.get(k)).setDeviceActiveState(0);
                    productType = ((DeviceInfo) this.f1844m.get(k)).getProductType();
                } else {
                    productType = -1;
                }
                m3975i();
            } else {
                productType = -1;
            }
            int productType2 = deviceInfo.getProductType();
            if (-2 == productType && -2 == productType2) {
                C2538c.m12661a("02", 0, "HWDeviceMgr", "Current device is AF500 and wanted device is AF500.");
                if (this.f1851t != null) {
                    this.f1851t.a(deviceInfo.getDeviceIdentify(), null);
                    return;
                }
            } else if (-2 == productType && -2 != productType2) {
                C2538c.m12661a("02", 0, "HWDeviceMgr", "Current device is AF500 and wanted device is not AF500.");
                if (this.f1851t != null) {
                    this.f1851t.a(false);
                    this.f1851t.a();
                }
            } else if (-2 == productType || -2 != productType2) {
                C2538c.m12661a("02", 0, "HWDeviceMgr", "Current device is not AF500 and wanted device is not AF500.");
            } else {
                C2538c.m12661a("02", 0, "HWDeviceMgr", "Current device is not AF500 and wanted device is AF500.");
                if (this.f1837f != null) {
                    this.f1837f.m3475e();
                }
                if (this.f1851t != null) {
                    this.f1851t.a(deviceInfo.getDeviceIdentify(), null);
                    return;
                }
                return;
            }
        }
        if (this.f1837f != null) {
            this.f1837f.m3460a(deviceInfo);
        }
    }

    public void m3991a(List<DeviceInfo> list, boolean z) {
        C2538c.m12661a("02", 0, "HWDeviceMgr", "Enter setUsedDeviceList().");
        if (list == null) {
            C2538c.m12661a("02", 0, "HWDeviceMgr", "Parameter is incorrect.");
        } else if (list.size() != this.f1844m.size()) {
            m3939b((List) list, z);
        } else {
            this.f1841j = -1;
            this.f1839h = "";
            this.f1842k = 3;
            if (!m3933b((List) list).equalsIgnoreCase(m3933b(this.f1844m))) {
                int k = m3978k();
                if (k > -1) {
                    List arrayList = new ArrayList();
                    arrayList.add(this.f1844m.get(k));
                    m3950c(arrayList);
                }
            }
            m3927a((List) list);
        }
    }

    private DeviceInfo m3919a(DeviceInfo deviceInfo) {
        DeviceInfo deviceInfo2 = new DeviceInfo();
        deviceInfo2.setDeviceActiveState(deviceInfo.getDeviceActiveState());
        deviceInfo2.setDeviceConnectState(deviceInfo.getDeviceConnectState());
        deviceInfo2.setDeviceName(deviceInfo.getDeviceName());
        deviceInfo2.setProductType(deviceInfo.getProductType());
        deviceInfo2.setDeviceIdentify(deviceInfo.getDeviceIdentify());
        if ("".equals(deviceInfo.getUUID())) {
            deviceInfo2.setUUID(deviceInfo.getDeviceIdentify());
        } else {
            deviceInfo2.setUUID(deviceInfo.getUUID());
        }
        deviceInfo2.setDeviceProtocol(deviceInfo.getDeviceProtocol());
        deviceInfo2.setEncryptType(deviceInfo.getEncryptType());
        deviceInfo2.setDeviceBTType(deviceInfo.getDeviceBTType());
        C2538c.m12677c("HWDeviceMgr", "deviceInfoTemp.getFirstConnectTime() = " + deviceInfo.getFirstConnectTime());
        deviceInfo2.setFirstConnectTime(deviceInfo.getFirstConnectTime());
        if (deviceInfo.getProductType() == 10 && !TextUtils.isEmpty(deviceInfo.getDeviceModel())) {
            deviceInfo2.setDeviceModel(deviceInfo.getDeviceModel());
            C2538c.m12661a("02", 0, "HWDeviceMgr", "device name:" + deviceInfo.getDeviceModel());
            if (TextUtils.equals(deviceInfo.getDeviceModel(), "PORSCHE DESIGN")) {
                deviceInfo2.setDeviceName(deviceInfo.getDeviceModel());
            }
        }
        return deviceInfo2;
    }

    public List<DeviceInfo> m3984a() {
        List<DeviceInfo> arrayList;
        synchronized (m3968g()) {
            C2538c.m12661a("02", 0, "HWDeviceMgr", "Enter getUsedDeviceList() with mDeviceInfoList size = " + this.f1844m.size());
            arrayList = new ArrayList();
            arrayList.clear();
            for (DeviceInfo a : this.f1844m) {
                arrayList.add(m3919a(a));
            }
            C2538c.m12661a("02", 0, "HWDeviceMgr", "return getUsedDeviceList() with deviceInfoListBak size = " + arrayList.size());
        }
        return arrayList;
    }

    public void m3987a(C1024b c1024b) {
        C2538c.m12661a("02", 0, "HWDeviceMgr", "Enter registerDeviceStateCallBack().");
        this.f1838g = c1024b;
        if (this.f1852u != null) {
            this.f1852u.a(this.f1838g);
        }
        if (this.f1853v != null) {
            this.f1853v.a(this.f1838g);
        }
    }

    public void m3994b(C1024b c1024b) {
        C2538c.m12661a("02", 0, "HWDeviceMgr", "Enter unRegisterDeviceStateCallBack().");
        this.f1838g = null;
        if (this.f1852u != null) {
            this.f1852u.a(null);
        }
        if (this.f1853v != null) {
            this.f1853v.a(null);
        }
    }

    private void m3977j() {
        C2538c.m12661a("02", 0, "HWDeviceMgr", "sendDeviceListChangeBroadcast.");
        this.f1836d.sendBroadcast(new Intent("com.huawei.bone.action.DEVICE_LIST_CHANGED"), C0976c.f1642a);
    }

    private void m3934b(DeviceInfo deviceInfo) {
        C2538c.m12661a("02", 0, "HWDeviceMgr", "Enter sendConnectStateBroadcast().");
        if (deviceInfo.getDeviceBTType() == 0 && deviceInfo.getDeviceConnectState() == 2) {
            String deviceIdentify = deviceInfo.getDeviceIdentify();
            int d = m3951d(deviceIdentify);
            if (-1 != d) {
                ((DeviceInfo) this.f1844m.get(d)).setProductType(deviceInfo.getProductType());
                if (deviceInfo.getProductType() == 3) {
                    ((DeviceInfo) this.f1844m.get(d)).setUUID(deviceIdentify);
                    deviceInfo.setUUID(deviceIdentify);
                } else if (deviceInfo.getProductType() == 10) {
                    ((DeviceInfo) this.f1844m.get(d)).setUUID(deviceInfo.getUUID());
                    if ("".equals(deviceInfo.getUUID())) {
                        deviceInfo.setUUID(deviceIdentify);
                    }
                }
                m3975i();
            }
            C2538c.m12661a("02", 0, "HWDeviceMgr", "mDeviceInfoList.get(deviceInfoIndex).getProductType : " + ((DeviceInfo) this.f1844m.get(d)).getProductType() + " ; name : " + ((DeviceInfo) this.f1844m.get(d)).getDeviceName());
        }
        Intent intent = new Intent("com.huawei.bone.action.CONNECTION_STATE_CHANGED");
        intent.setExtrasClassLoader(DeviceInfo.class.getClassLoader());
        Bundle bundle = new Bundle();
        bundle.putParcelable("deviceinfo", deviceInfo);
        intent.putExtras(bundle);
        this.f1836d.sendOrderedBroadcast(intent, C0976c.f1642a);
        m3957e(deviceInfo);
        if (deviceInfo.getDeviceConnectState() == 2) {
            C2538c.m12677c("HWDeviceMgr", "mAppCheckTime" + this.f1836d.getSharedPreferences("deviceUpdateSharedPreferences", 0).getString("deviceUpdateCheckTime", ""));
            if (!C1023c.m3941b(this.f1836d.getSharedPreferences("deviceUpdateSharedPreferences", 0).getString("deviceUpdateCheckTime", ""))) {
                this.f1836d.sendBroadcast(new Intent("com.huawei.bone.action.UPDATE_DEVICE"), C0976c.f1642a);
            }
        }
    }

    public void m3995b(DeviceCommand deviceCommand) {
        C2538c.m12661a("02", 0, "HWDeviceMgr", "Enter sendDeviceData().");
        if (deviceCommand == null) {
            C2538c.m12672b("02", 0, "HWDeviceMgr", "deviceCommand is null.");
        } else if (this.f1849r) {
            C2538c.m12672b("02", 0, "HWDeviceMgr", "OTA update, other command can't send...");
        } else if (-2 == this.f1841j) {
            C2538c.m12661a("02", 0, "HWDeviceMgr", "Current device is AF500.");
            if (this.f1851t != null) {
                this.f1851t.a(deviceCommand.getServiceID(), deviceCommand.getCommandID(), deviceCommand.getDataContent());
            }
        } else {
            C2538c.m12661a("02", 0, "HWDeviceMgr", "ServiceID = " + deviceCommand.getServiceID() + " CommandID = " + deviceCommand.getCommandID());
            if (2 == this.f1842k) {
                C4625b bVar = new C4625b();
                ByteBuffer allocate = ByteBuffer.allocate(deviceCommand.getDataLen() + 2);
                allocate.put(C0973a.m3512b(C0973a.m3506a(deviceCommand.getServiceID())));
                allocate.put(C0973a.m3512b(C0973a.m3506a(deviceCommand.getCommandID())));
                if (deviceCommand.getDataContent() != null) {
                    allocate.put(deviceCommand.getDataContent());
                    C2538c.m12661a("02", 0, "HWDeviceMgr", "command data = " + C0973a.m3509a(deviceCommand.getDataContent()));
                } else {
                    C2538c.m12672b("02", 0, "HWDeviceMgr", "command data is null, if not OTA, data incorrect.");
                }
                allocate.flip();
                bVar.a(allocate.array());
                bVar.a(allocate.array().length);
                bVar.a(deviceCommand.getNeedAck());
                bVar.b(deviceCommand.getPriority());
                C2538c.m12661a("02", 0, "HWDeviceMgr", "mDeviceIdentify = " + this.f1839h);
                bVar.a(this.f1839h);
                bVar.b(deviceCommand.getNeedEncrypt());
                bVar.e(deviceCommand.getServiceID());
                bVar.f(deviceCommand.getCommandID());
                if (this.f1837f != null) {
                    this.f1837f.m3459a(bVar);
                }
            }
        }
    }

    private String m3933b(List<DeviceInfo> list) {
        String deviceIdentify;
        C2538c.m12661a("02", 0, "HWDeviceMgr", "Enter getActiveDeviceIdentify().");
        String str = "";
        if (!(list == null || list.size() == 0)) {
            for (int i = 0; i < list.size(); i++) {
                if (1 == ((DeviceInfo) list.get(i)).getDeviceActiveState()) {
                    deviceIdentify = ((DeviceInfo) list.get(i)).getDeviceIdentify();
                    break;
                }
            }
        }
        deviceIdentify = str;
        C2538c.m12661a("02", 0, "HWDeviceMgr", "active device Identify = " + deviceIdentify);
        return deviceIdentify;
    }

    private int m3978k() {
        int i;
        C2538c.m12661a("02", 0, "HWDeviceMgr", "Enter getActiveDeviceIndex().");
        if (!(this.f1844m == null || this.f1844m.size() == 0)) {
            i = 0;
            while (i < this.f1844m.size()) {
                if (1 == ((DeviceInfo) this.f1844m.get(i)).getDeviceActiveState()) {
                    break;
                }
                i++;
            }
        }
        i = -1;
        C2538c.m12661a("02", 0, "HWDeviceMgr", "active device index = " + i);
        return i;
    }

    private int m3951d(String str) {
        if (!(this.f1844m == null || this.f1844m.size() == 0)) {
            for (int i = 0; i < this.f1844m.size(); i++) {
                if (str.equalsIgnoreCase(((DeviceInfo) this.f1844m.get(i)).getDeviceIdentify())) {
                    return i;
                }
            }
        }
        return -1;
    }

    private boolean m3960e(String str) {
        int k = m3978k();
        if (-1 != k) {
            return ((DeviceInfo) this.f1844m.get(k)).getDeviceIdentify().equalsIgnoreCase(str);
        }
        return false;
    }

    private void m3947c(DeviceInfo deviceInfo) {
        C2538c.m12661a("02", 0, "HWDeviceMgr", "Enter addDeviceInfoToList().");
        if (-1 != m3951d(deviceInfo.getDeviceIdentify())) {
            m3969g(deviceInfo);
            C2538c.m12661a("02", 0, "HWDeviceMgr", "Find the same device during add device.");
            return;
        }
        this.f1839h = deviceInfo.getDeviceIdentify();
        C2538c.m12661a("02", 0, "HWDeviceMgr", "mDeviceIdentify = " + this.f1839h + "device model" + deviceInfo.getDeviceModel());
        this.f1842k = 2;
        deviceInfo.setDeviceActiveState(1);
        deviceInfo.setDeviceConnectState(2);
        deviceInfo.setFirstConnectTime(C1023c.m3962f());
        C2538c.m12677c("HWDeviceMgr", "setFirstConnectTime ");
        int k = m3978k();
        if (-1 != k) {
            ((DeviceInfo) this.f1844m.get(k)).setDeviceActiveState(0);
        }
        synchronized (m3968g()) {
            this.f1844m.add(deviceInfo);
        }
        if (this.f1837f != null) {
            if (-2 == deviceInfo.getProductType()) {
                this.f1837f.m3475e();
            } else {
                this.f1837f.m3461a(deviceInfo.getDeviceIdentify());
                this.f1837f.m3460a(deviceInfo);
                this.f1837f.m3473d(deviceInfo.getDeviceIdentify());
            }
        }
        m3975i();
        m3977j();
        m3934b(deviceInfo);
    }

    private void m3923a(DeviceInfo deviceInfo, int i) {
        C2538c.m12661a("02", 0, "HWDeviceMgr", "Enter handleDeviceEqualActiveDevice().");
        this.f1839h = deviceInfo.getDeviceIdentify();
        C2538c.m12661a("02", 0, "HWDeviceMgr", "mDeviceIdentify = " + this.f1839h);
        if (-1 == this.f1841j) {
            int k = m3978k();
            if (-1 != k) {
                this.f1841j = ((DeviceInfo) this.f1844m.get(k)).getProductType();
                if (-1 == this.f1841j) {
                    C2538c.m12672b("02", 0, "HWDeviceMgr", "List has this device but the product type is unknown.");
                    return;
                }
                deviceInfo.setProductType(this.f1841j);
            }
        }
        String deviceName = ((DeviceInfo) this.f1844m.get(i)).getDeviceName();
        if ("".equals(deviceName)) {
            String deviceName2 = deviceInfo.getDeviceName();
            C2538c.m12676c("02", 0, "HWDeviceMgr", "====name3=====" + deviceName2);
            if (deviceName2 == null || deviceName2.equals("")) {
                ((DeviceInfo) this.f1844m.get(i)).setDeviceName(deviceInfo.getDeviceIdentify());
            } else {
                ((DeviceInfo) this.f1844m.get(i)).setDeviceName(deviceInfo.getDeviceName());
            }
        }
        if (!(deviceInfo.getDeviceName() == null || deviceInfo.getDeviceName().equalsIgnoreCase(deviceName))) {
            C2538c.m12661a("02", 0, "HWDeviceMgr", "device name changed with name = " + deviceInfo.getDeviceName());
            ((DeviceInfo) this.f1844m.get(i)).setDeviceName(deviceInfo.getDeviceName());
            m3975i();
        }
        if (((DeviceInfo) this.f1844m.get(i)).getProductType() != deviceInfo.getProductType() && (3 == deviceInfo.getProductType() || 10 == deviceInfo.getProductType())) {
            C2538c.m12661a("02", 0, "HWDeviceMgr", "change type " + deviceInfo.getDeviceName());
            ((DeviceInfo) this.f1844m.get(i)).setProductType(deviceInfo.getProductType());
            m3975i();
        }
        ((DeviceInfo) this.f1844m.get(i)).setDeviceConnectState(2);
        deviceInfo.setDeviceConnectState(2);
        this.f1842k = 2;
        m3934b(deviceInfo);
    }

    private void m3935b(DeviceInfo deviceInfo, int i) {
        C2538c.m12661a("02", 0, "HWDeviceMgr", "Enter handleDeviceUnequalActiveDevice().");
        int k = m3978k();
        C2538c.m12661a("02", 0, "HWDeviceMgr", "activeDeviceIndex = " + k);
        if (-1 != i) {
            this.f1841j = deviceInfo.getProductType();
            if (-1 == this.f1841j && -1 != k) {
                C2538c.m12661a("02", 0, "HWDeviceMgr", "mProductType is unknown.");
                this.f1841j = ((DeviceInfo) this.f1844m.get(k)).getProductType();
                if (-1 == this.f1841j) {
                    C2538c.m12672b("02", 0, "HWDeviceMgr", "List has this device but the product type is unknown.");
                    return;
                }
                deviceInfo.setProductType(this.f1841j);
            }
            if (deviceInfo.getDeviceName() != null) {
                if (!deviceInfo.getDeviceName().equalsIgnoreCase(((DeviceInfo) this.f1844m.get(i)).getDeviceName())) {
                    C2538c.m12661a("02", 0, "HWDeviceMgr", "device name changed with name = " + deviceInfo.getDeviceName());
                    ((DeviceInfo) this.f1844m.get(i)).setDeviceName(deviceInfo.getDeviceName());
                    m3975i();
                }
            }
            String deviceIdentify = deviceInfo.getDeviceIdentify();
            C2538c.m12661a("02", 0, "HWDeviceMgr", "Wanted Device Identify = " + deviceIdentify);
            if (-1 != k || -1 == i) {
                C2538c.m12661a("02", 0, "HWDeviceMgr", "Active Device Identify = " + ((DeviceInfo) this.f1844m.get(k)).getDeviceIdentify());
                if (!((DeviceInfo) this.f1844m.get(k)).getDeviceIdentify().equalsIgnoreCase(deviceIdentify)) {
                    C2538c.m12661a("02", 0, "HWDeviceMgr", "active is unequal with wanted device so set active info.");
                    ((DeviceInfo) this.f1844m.get(k)).setDeviceActiveState(0);
                    ((DeviceInfo) this.f1844m.get(i)).setDeviceActiveState(1);
                }
            } else {
                C2538c.m12661a("02", 0, "HWDeviceMgr", "activeDeviceIndex do not exist and deviceInfoIndex exist.");
                ((DeviceInfo) this.f1844m.get(i)).setDeviceActiveState(1);
                if (this.f1837f != null) {
                    C2538c.m12661a("02", 0, "HWDeviceMgr", "Start to set active device.");
                    this.f1837f.m3461a(deviceInfo.getDeviceIdentify());
                    C2538c.m12661a("02", 0, "HWDeviceMgr", "Start to set current device.");
                    this.f1837f.m3460a(deviceInfo);
                }
            }
            this.f1839h = deviceIdentify;
            deviceInfo.setDeviceConnectState(2);
            deviceInfo.setDeviceActiveState(1);
            ((DeviceInfo) this.f1844m.get(i)).setDeviceConnectState(2);
            this.f1842k = 2;
            if (-2 == deviceInfo.getProductType() && this.f1837f != null) {
                this.f1837f.m3475e();
            }
            m3975i();
            m3977j();
            m3934b(deviceInfo);
            return;
        }
        C2538c.m12672b("02", 0, "HWDeviceMgr", "List do not has this device.");
    }

    private void m3953d(DeviceInfo deviceInfo) {
        C2538c.m12661a("02", 0, "HWDeviceMgr", "Enter reportConnectFail()");
        this.f1842k = 4;
        deviceInfo.setDeviceConnectState(this.f1842k);
        int d = m3951d(deviceInfo.getDeviceIdentify());
        if (-1 != d) {
            C2538c.m12661a("02", 0, "HWDeviceMgr", "Update DeviceInfo state");
            ((DeviceInfo) this.f1844m.get(d)).setDeviceConnectState(this.f1842k);
        }
        if (this.f1837f != null) {
            this.f1837f.m3466b(deviceInfo);
            this.f1837f.m3467b(deviceInfo.getDeviceIdentify());
        }
    }

    private void m3924a(DeviceInfo deviceInfo, byte[] bArr) {
        if (2 == deviceInfo.getDeviceProtocol()) {
            C2538c.m12661a("02", 0, "HWDeviceMgr", "Start to check Version Response.");
            if (C4610m.a(this.f1836d, deviceInfo.getDeviceProtocol(), bArr)) {
                C2538c.m12661a("02", 0, "HWDeviceMgr", "Get Version Command send timeout.");
                m3953d(deviceInfo);
                return;
            }
            try {
                JSONObject f = C4610m.f(this.f1836d, bArr);
                int i = f.getInt("type");
                this.f1841j = i;
                this.f1840i = "";
                if (f.has(PluginPayAdapter.KEY_DEVICE_INFO_MODEL)) {
                    this.f1840i = f.getString(PluginPayAdapter.KEY_DEVICE_INFO_MODEL);
                }
                C2538c.m12661a("02", 0, "HWDeviceMgr", "DeviceModel : " + this.f1840i);
                if (f.has("device_version")) {
                    this.f1854w = f.getString("device_version");
                }
                if (f.has(PluginPayAdapter.KEY_DEVICE_INFO_SOFT_VERSION)) {
                    this.f1855x = f.getString(PluginPayAdapter.KEY_DEVICE_INFO_SOFT_VERSION);
                }
                this.f1839h = deviceInfo.getDeviceIdentify();
                if (f.has("UUID")) {
                    deviceInfo.setUUID(f.getString("UUID"));
                }
                deviceInfo.setProductType(i);
                if (-1 == i) {
                    C2538c.m12661a("02", 0, "HWDeviceMgr", "Get Wrong Version Command.");
                    m3953d(deviceInfo);
                    return;
                }
                C4625b b = C4610m.b();
                b.a(deviceInfo.getDeviceIdentify());
                if (this.f1837f != null) {
                    C2538c.m12661a("02", 0, "HWDeviceMgr", "Start to set device time.");
                    this.f1837f.m3459a(b);
                }
            } catch (JSONException e) {
                C2538c.m12672b("02", 0, "HWDeviceMgr", e.getMessage());
            }
        }
    }

    private void m3936b(DeviceInfo deviceInfo, byte[] bArr) {
        C2538c.m12661a("02", 0, "HWDeviceMgr", "Start to check GATT Response.");
        if (C4610m.a(this.f1836d, deviceInfo.getDeviceProtocol(), bArr)) {
            C2538c.m12661a("02", 0, "HWDeviceMgr", "GATT Command send timeout.");
            m3953d(deviceInfo);
            return;
        }
        boolean e;
        if (deviceInfo.getDeviceProtocol() == 0) {
            e = C4610m.e(this.f1836d, bArr);
        } else {
            e = C4610m.d(this.f1836d, bArr);
        }
        if (e) {
            this.f1850s.resetDeviceCapability();
            if (2 == deviceInfo.getDeviceProtocol()) {
                C4625b b = C4610m.b(this.f1836d);
                b.a(deviceInfo.getDeviceIdentify());
                if (this.f1837f != null) {
                    C2538c.m12661a("02", 0, "HWDeviceMgr", "Start to get device service id list info. Command = " + C0973a.m3506a(b.i()) + C0973a.m3506a(b.j()) + C0973a.m3509a(b.c()));
                    this.f1837f.m3459a(b);
                    return;
                }
                return;
            }
            int productType = deviceInfo.getProductType();
            C2538c.m12661a("02", 0, "HWDeviceMgr", "Product type = " + productType);
            if (-1 != productType) {
                C4619w.a(this.f1836d, productType, this.f1850s);
            }
            m3964f(deviceInfo);
            return;
        }
        C2538c.m12672b("02", 0, "HWDeviceMgr", "GATT Time Set fail.");
        m3953d(deviceInfo);
    }

    private void m3948c(DeviceInfo deviceInfo, byte[] bArr) {
        if (C4610m.a(this.f1836d, deviceInfo.getDeviceProtocol(), bArr)) {
            C2538c.m12661a("02", 0, "HWDeviceMgr", "Get device service id list info send timeout.");
            m3953d(deviceInfo);
            return;
        }
        List g = C4610m.g(this.f1836d, bArr);
        if (g != null) {
            C4625b a = C4610m.a(this.f1836d, g);
            if (a != null) {
                if (10 == this.f1841j && "73617766697368".equals(this.f1854w) && "372E312E31".equals(this.f1855x)) {
                    C2538c.m12672b("02", 0, "HWDeviceMgr", "refresh.");
                    String str = "0103814E020101030C040708090A0D0E1011121314020107030B01050708090A0E1013161502010A030301090A02010C03010102011603030103070201170306010406070B0C02011903010102011B030101";
                    a.a(C0973a.m3512b(str));
                    a.a(str.length() / 2);
                }
                a.a(deviceInfo.getDeviceIdentify());
                if (this.f1837f != null) {
                    C2538c.m12661a("02", 0, "HWDeviceMgr", "Start to get device command id list info.Command：" + C0973a.m3506a(a.i()) + C0973a.m3506a(a.j()) + C0973a.m3509a(a.c()));
                    this.f1837f.m3459a(a);
                    return;
                }
                return;
            }
            C2538c.m12672b("02", 0, "HWDeviceMgr", "btDeviceCommand is null.");
            return;
        }
        C2538c.m12672b("02", 0, "HWDeviceMgr", "Get device command id list info fail.");
        m3953d(deviceInfo);
    }

    private void m3954d(DeviceInfo deviceInfo, byte[] bArr) {
        if (C4610m.a(this.f1836d, deviceInfo.getDeviceProtocol(), bArr)) {
            C2538c.m12661a("02", 0, "HWDeviceMgr", "Get device command id list info send timeout.");
            m3953d(deviceInfo);
            return;
        }
        C4619w.a(deviceInfo.getProductType(), this.f1850s);
        if (C4610m.a().contains(Integer.valueOf(3))) {
            this.f1850s.configureContacts(false);
        }
        if (C4610m.a(this.f1836d, bArr, this.f1850s)) {
            C4625b f;
            C2538c.m12661a("02", 0, "HWDeviceMgr", "Start to handle V2 protocol other capability.");
            if (10 == this.f1841j && "73617766697368".equals(this.f1854w) && "372E312E31".equals(this.f1855x)) {
                C2538c.m12661a("02", 0, "HWDeviceMgr", "leo problem version, reset capability");
                m3922a(this.f1850s);
            }
            if (10 == this.f1841j && "736177736861726B".equals(this.f1854w) && ("4E5847313250".equals(this.f1855x) || "4E4C4731334E".equals(this.f1855x))) {
                C2538c.m12661a("02", 0, "HWDeviceMgr", "leo problem version, reset heart rate capability");
                this.f1850s.configureSupportHeartRateInfo(false);
            }
            if (C4610m.a(1, 20, bArr)) {
                C2538c.m12661a("02", 0, "HWDeviceMgr", "is support Gold card");
                f = C4610m.f();
                f.a(deviceInfo.getDeviceIdentify());
                if (this.f1837f != null) {
                    C2538c.m12661a("02", 0, "HWDeviceMgr", "Start to get is support gold card");
                    this.f1837f.m3459a(f);
                }
            }
            if (C4610m.a(1, 18, bArr)) {
                this.f1850s.configureSupportActivityType(true);
                f = C4610m.c();
                f.a(deviceInfo.getDeviceIdentify());
                if (this.f1837f != null) {
                    C2538c.m12661a("02", 0, "HWDeviceMgr", "Start to get device activity type info.");
                    this.f1837f.m3459a(f);
                    return;
                }
                return;
            } else if (C4610m.a(2, 5, bArr)) {
                this.f1850s.configureSupportMessageSupportInfo(true);
                f = C4610m.d();
                f.a(deviceInfo.getDeviceIdentify());
                if (this.f1837f != null) {
                    C2538c.m12661a("02", 0, "HWDeviceMgr", "Start to get device notification type info.");
                    this.f1837f.m3459a(f);
                    return;
                }
                return;
            } else {
                C2538c.m12672b("02", 0, "HWDeviceMgr", "Not supported activity and notification type");
                m3964f(deviceInfo);
                return;
            }
        }
        C2538c.m12661a("02", 0, "HWDeviceMgr", "Get device command id list info fail.");
        m3953d(deviceInfo);
    }

    private void m3922a(DeviceCapability deviceCapability) {
        deviceCapability.resetDeviceCapability();
        deviceCapability.configureSupportTimeSetting(false);
        deviceCapability.configureSupportGetFirmwareVersion(true);
        deviceCapability.configureSupportGetBattery(true);
        deviceCapability.configureAuto_light_screen(false);
        deviceCapability.configureAvoid_disturb(false);
        deviceCapability.configureFactory_reset(false);
        deviceCapability.configureSupportPairDevice(false);
        deviceCapability.configureSupportGetHandsetInfo(true);
        deviceCapability.configureSupportNotificationIntervalInfo(true);
        deviceCapability.configureSupportActivityType(true);
        deviceCapability.configureSupportAuthenticDevice(true);
        deviceCapability.configureGold_card(true);
        deviceCapability.configureMessage_alert(false);
        deviceCapability.configureSupportMessageAlertInfo(false);
        deviceCapability.configureSupportMessageSupportInfo(false);
        deviceCapability.configureupportMessageCenterPushDevice(false);
        deviceCapability.configureSupportWearMessagePush(false);
        deviceCapability.configureContacts(false);
        deviceCapability.configureSupportCallingOperationType(false);
        deviceCapability.configureMotionGoalCap(1);
        deviceCapability.configureFitness_frame_type(3);
        deviceCapability.configureActivity_reminder(false);
        deviceCapability.configureSupportSetUserInfoEncrypt(false);
        deviceCapability.configureSupportSampleFrame(true);
        deviceCapability.configureSupportThreshold(true);
        deviceCapability.configureReserveSync(true);
        deviceCapability.configureIsSupportHRZone(true);
        deviceCapability.configureSupportGetUserInfo(true);
        deviceCapability.configureIsSupportCoreSleep(false);
        deviceCapability.configureisSupportHeartRateEnable(false);
        deviceCapability.configureIsSupportSendCoreSleepOutState(false);
        deviceCapability.configureIsSupportQueryDeviceCoreSleepSwitch(false);
        deviceCapability.configureEvent_alarm(false);
        deviceCapability.configureEvent_alarm_num(0);
        deviceCapability.configureSmart_alarm(false);
        deviceCapability.configureOta_update(false);
        deviceCapability.configureMaintenance(true);
        deviceCapability.configureMaintenance_in_time(false);
        deviceCapability.configureMaintenance_get_data(false);
        deviceCapability.configureSupportAntiLost(false);
        deviceCapability.configureBluetooth_off_alert(false);
        deviceCapability.configureLanguage(true);
        deviceCapability.configureWeather_push(false);
        deviceCapability.configureSupportExerciseAdvice(true);
        deviceCapability.configureSupportExerciseAdviceTime(true);
        deviceCapability.configureSupportExerciseAdviceMonitor(false);
        deviceCapability.configureSupportWorkout(false);
        deviceCapability.configureSupportWorkoutInfo(false);
        deviceCapability.configureSupportWorkoutReminder(false);
        deviceCapability.configureSupportWorkoutRecord(true);
        deviceCapability.configureSupportWorkoutExerciseDisplayLink(false);
        deviceCapability.configureSupportWorkoutRecordPaceMap(false);
        deviceCapability.configureSupportGPSLocation(false);
        deviceCapability.configureSupportGPSData(false);
        deviceCapability.configureSupportGPSSetParameter(false);
        deviceCapability.configureSupportHeartRateInfo(false);
        deviceCapability.configureSleep(false);
        deviceCapability.configureClimb(true);
        deviceCapability.configureRiding(false);
        deviceCapability.configureStand(false);
        deviceCapability.configureSleep_shallow(false);
        deviceCapability.configureSleep_deep(false);
        deviceCapability.configureWalk(true);
        deviceCapability.configureRun(true);
        deviceCapability.configureStep(true);
        deviceCapability.configureCalorie(true);
        deviceCapability.configureDistance(true);
        deviceCapability.configureIsSupportHeartRate(false);
        deviceCapability.configurePromptPush(0);
        deviceCapability.configureCall_mute(false);
        deviceCapability.configureIsSupportHelp(true);
        deviceCapability.configureDistanceDetail(true);
        deviceCapability.configureSupportPay(true);
        deviceCapability.configureSupportEsim(false);
        deviceCapability.configureSupportMultiSim(false);
        deviceCapability.configureRotate_switch_screen(false);
        deviceCapability.configureSupportLeftRightHandWearMode(false);
        deviceCapability.configureSupportStress(false);
        deviceCapability.configureSupportQueryAllowDisturbContent(false);
        deviceCapability.configureSupportEphemerisInfoUpdate(false);
    }

    private void m3958e(DeviceInfo deviceInfo, byte[] bArr) {
        if (C4610m.a(this.f1836d, deviceInfo.getDeviceProtocol(), bArr)) {
            C2538c.m12661a("02", 0, "HWDeviceMgr", "Get device activity type info send timeout.");
            m3953d(deviceInfo);
            return;
        }
        C2538c.m12661a("02", 0, "HWDeviceMgr", "Start to handle BT device supported activity type.");
        if (!C4610m.a(bArr, this.f1850s)) {
            C2538c.m12672b("02", 0, "HWDeviceMgr", "Get device activity type info fail.");
            m3953d(deviceInfo);
        } else if (C4610m.a(2, 5, bArr)) {
            this.f1850s.configureSupportMessageSupportInfo(true);
            C4625b d = C4610m.d();
            d.a(deviceInfo.getDeviceIdentify());
            if (this.f1837f != null) {
                C2538c.m12661a("02", 0, "HWDeviceMgr", "Start to get device notification type info.");
                this.f1837f.m3459a(d);
            }
        } else {
            m3964f(deviceInfo);
        }
    }

    private void m3965f(DeviceInfo deviceInfo, byte[] bArr) {
        if (C4610m.a(this.f1836d, deviceInfo.getDeviceProtocol(), bArr)) {
            C2538c.m12661a("02", 0, "HWDeviceMgr", "Get device notification type info send timeout.");
            m3953d(deviceInfo);
            return;
        }
        C2538c.m12661a("02", 0, "HWDeviceMgr", "Start to handle BT device supported notification type.");
        if (C4610m.b(bArr, this.f1850s)) {
            m3964f(deviceInfo);
            return;
        }
        C2538c.m12672b("02", 0, "HWDeviceMgr", "Get device notification type info fail.");
        m3953d(deviceInfo);
    }

    public void m3992a(boolean z) {
        if (this.f1837f != null) {
            this.f1837f.m3474d(z);
            return;
        }
        C2538c.m12672b("02", 0, "HWDeviceMgr", "mBTSDKApi is null");
    }

    public DeviceCapability m3993b() {
        return this.f1850s;
    }

    private void m3957e(DeviceInfo deviceInfo) {
        C2538c.m12672b("02", 0, "HWDeviceMgr", "===EMUI===SendConnectBroadcastToEMUI, btDeviceInfo.getDeviceConnectState = " + deviceInfo.getDeviceConnectState());
        if (2 != deviceInfo.getDeviceConnectState()) {
            return;
        }
        if (deviceInfo.getDeviceIdentify().equalsIgnoreCase("AndroidWear")) {
            C2538c.m12676c("02", 0, "HWDeviceMgr", "===EMUI===SendConnectBroadcastToEMUI, don't need send broadcast for AndroidWear");
            return;
        }
        Intent intent = new Intent("com.huawei.bone.device.action.BONE_BOND_STATE_CHANGED");
        intent.putExtra("com.huawei.bone.extra.DEVICE_MAC_ADDRESS", deviceInfo.getDeviceIdentify());
        intent.putExtra("android.bluetooth.device.extra.BOND_STATE", 12);
        this.f1836d.sendBroadcast(intent, "com.huawei.bone.permission.ACCESS_DEVICE_CONNECTION_STATE");
        C2538c.m12676c("02", 0, "HWDeviceMgr", "===EMUI===SendConnectBroadcastToEMUI, send BOND_BONDED broadcast, curMac = " + deviceInfo.getDeviceIdentify());
    }

    private void m3950c(List<DeviceInfo> list) {
        C2538c.m12661a("02", 0, "HWDeviceMgr", "===EMUI===SendDisconnectBroadcastToEMUI...");
        for (int i = 0; i < list.size(); i++) {
            DeviceInfo deviceInfo = (DeviceInfo) list.get(i);
            if (deviceInfo.getDeviceIdentify().equalsIgnoreCase("AndroidWear")) {
                C2538c.m12676c("02", 0, "HWDeviceMgr", "===EMUI===SendDisconnectBroadcastToEMUI, don't need send broadcast for AndroidWear");
            } else {
                Intent intent = new Intent("com.huawei.bone.device.action.BONE_BOND_STATE_CHANGED");
                intent.putExtra("com.huawei.bone.extra.DEVICE_MAC_ADDRESS", deviceInfo.getDeviceIdentify());
                intent.putExtra("android.bluetooth.device.extra.BOND_STATE", 10);
                this.f1836d.sendBroadcast(intent, "com.huawei.bone.permission.ACCESS_DEVICE_CONNECTION_STATE");
                C2538c.m12676c("02", 0, "HWDeviceMgr", "===EMUI===SendDisconnectBroadcastToEMUI, send BOND_NONE broadcast, curMac = " + deviceInfo.getDeviceIdentify());
            }
        }
    }

    public int m3997c() {
        return this.f1837f.m3452a();
    }

    private void m3981l() {
        C2538c.m12661a("02", 0, "HWDeviceMgr", "Enter setAllDeviceDisable().");
        synchronized (m3968g()) {
            for (int i = 0; i < this.f1844m.size(); i++) {
                ((DeviceInfo) this.f1844m.get(i)).setDeviceActiveState(0);
            }
        }
        m3975i();
    }

    private void m3964f(DeviceInfo deviceInfo) {
        C2538c.m12661a("02", 0, "HWDeviceMgr", "Enter handleHandshakeSuccess().");
        this.f1843l = false;
        String deviceIdentify = deviceInfo.getDeviceIdentify();
        if ("".equals(deviceInfo.getUUID())) {
            deviceInfo.setUUID(deviceIdentify);
        }
        if (!TextUtils.isEmpty(this.f1840i) && deviceInfo.getProductType() == 10) {
            C2538c.m12661a("02", 0, "HWDeviceMgr", "Enter handleHandshakeSuccess() set Device model :" + this.f1840i);
            deviceInfo.setDeviceModel(this.f1840i);
            if (TextUtils.equals(this.f1840i, "PORSCHE DESIGN")) {
                deviceInfo.setDeviceName("PORSCHE DESIGN");
            }
        }
        int d = m3951d(deviceIdentify);
        if (-1 == d) {
            C2538c.m12661a("02", 0, "HWDeviceMgr", "Device List do not has this device.");
            m3947c(deviceInfo);
            return;
        }
        C2538c.m12677c("HWDeviceMgr", "mDeviceInfoList.get(deviceInfoIndex).getFirstConnectTime() " + ((DeviceInfo) this.f1844m.get(d)).getFirstConnectTime());
        if (TextUtils.isEmpty(((DeviceInfo) this.f1844m.get(d)).getFirstConnectTime())) {
            ((DeviceInfo) this.f1844m.get(d)).setFirstConnectTime(C1023c.m3962f());
            m3975i();
        } else {
            ((DeviceInfo) this.f1844m.get(d)).setFirstConnectTime(m3963f(((DeviceInfo) this.f1844m.get(d)).getFirstConnectTime()));
            m3975i();
        }
        C2538c.m12661a("02", 0, "HWDeviceMgr", "Device List has this device.");
        if (m3960e(deviceIdentify)) {
            C2538c.m12661a("02", 0, "HWDeviceMgr", "current Mac Address equals active device Mac address.");
            m3923a(deviceInfo, d);
            return;
        }
        C2538c.m12661a("02", 0, "HWDeviceMgr", "pre MacAddress do not equals current Mac address.");
        m3935b(deviceInfo, d);
    }

    public void m3989a(String str) {
        if (2 == this.f1842k && this.f1837f != null) {
            C2538c.m12661a("02", 0, "HWDeviceMgr", "Enter sendBTDeviceData by asset way with filepath: " + str);
            this.f1837f.m3470c(str);
        }
    }

    public void m3986a(IBaseResponseCallback iBaseResponseCallback) {
        if (this.f1837f != null) {
            C2538c.m12661a("02", 0, "HWDeviceMgr", "Enter setFileCallback callback: " + iBaseResponseCallback);
            this.f1837f.m3456a(iBaseResponseCallback);
        }
    }

    private void m3970g(DeviceInfo deviceInfo, byte[] bArr) {
        C2538c.m12661a("02", 0, "HWDeviceMgr", "enter handleGetGoldCard.");
        if (C4610m.a(this.f1836d, deviceInfo.getDeviceProtocol(), bArr)) {
            C2538c.m12661a("02", 0, "HWDeviceMgr", "handleGetGoldCard  timeout.");
            return;
        }
        C2538c.m12661a("02", 0, "HWDeviceMgr", "Start to handle handleGetGoldCard.");
        if (C4610m.b(bArr)) {
            C2538c.m12661a("02", 0, "HWDeviceMgr", " support Gold!");
            this.f1850s.configureGold_card(true);
            return;
        }
        C2538c.m12661a("02", 0, "HWDeviceMgr", "not support Gold!");
        this.f1850s.configureGold_card(false);
    }

    public int m3998d() {
        int a;
        C2538c.m12677c("HWDeviceMgr", "getConncetedDeviceType() deviceList.size() = " + m3984a().size());
        for (DeviceInfo deviceInfo : r0) {
            if (1 == deviceInfo.getDeviceActiveState()) {
                break;
            }
        }
        DeviceInfo deviceInfo2 = null;
        if (deviceInfo2 != null) {
            a = m3916a(deviceInfo2.getProductType());
        } else {
            a = -1;
        }
        C2538c.m12677c("HWDeviceMgr", "getConncetedDeviceClassification() deviceClassification " + a);
        return a;
    }

    private int m3916a(int i) {
        C2538c.m12677c("HWDeviceMgr", "getDeviceClassification() deviceType " + i);
        int b = m3929b(i);
        if (-1 == b) {
            b = m3942c(i);
        }
        C2538c.m12677c("HWDeviceMgr", "getDeviceClassification() deviceClassification " + b);
        return b;
    }

    private int m3929b(int i) {
        switch (i) {
            case -2:
            case 0:
            case 1:
            case 5:
            case 7:
            case 12:
            case 13:
            case 14:
            case 15:
                return 1;
            default:
                return -1;
        }
    }

    private int m3942c(int i) {
        switch (i) {
            case 2:
            case 9:
                return 4;
            case 3:
            case 8:
            case 10:
                return 2;
            case 4:
            case 11:
                return 3;
            default:
                return -1;
        }
    }

    public void m3996b(boolean z) {
        if (this.f1837f != null) {
            C2538c.m12677c("HWDeviceMgr", "openSystemBluetoothSwitch switchState = " + z);
            this.f1837f.m3468b(z);
        }
    }

    public boolean m3999e() {
        int i = -1;
        if (this.f1837f != null) {
            i = this.f1837f.m3452a();
        }
        if (3 != i) {
            return false;
        }
        return true;
    }

    public static boolean m3941b(String str) {
        C2538c.m12677c("HWDeviceMgr", "isAlreadyUpdatedOfBand: strLastTime = " + str);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Date c = C1023c.m3946c(str);
        if (c == null) {
            return false;
        }
        if (Math.abs(System.currentTimeMillis() - c.getTime()) <= 259200000) {
            return true;
        }
        return false;
    }

    public static Date m3946c(String str) {
        try {
            return new SimpleDateFormat("yyyyMMdd").parse(str);
        } catch (ParseException e) {
            C2538c.m12677c("HWDeviceMgr", "Exception e = " + e.getMessage());
            return null;
        }
    }

    public static String m3962f() {
        C2538c.m12677c("TAG", "getCurrentTime: strCurTime");
        try {
            C2538c.m12677c("TAG", "getCurrentTime: strCurTime = " + String.valueOf(new Date().getTime()));
            return String.valueOf(new Date().getTime());
        } catch (Exception e) {
            C2538c.m12677c("TAG", "Exception e = " + e.getMessage());
            return null;
        }
    }

    private void m3969g(DeviceInfo deviceInfo) {
        C2538c.m12677c("HWDeviceMgr", "firstConnectionTime is  = " + deviceInfo.getFirstConnectTime());
        C2538c.m12677c("HWDeviceMgr", "getDeviceIdentify is = " + deviceInfo.getDeviceName());
        if (TextUtils.isEmpty(deviceInfo.getFirstConnectTime())) {
            deviceInfo.setFirstConnectTime(C1023c.m3962f());
        }
    }

    private String m3963f(String str) {
        if (TextUtils.isEmpty(str)) {
            return C1023c.m3962f();
        }
        long longValue = C0977d.m3541b(str).longValue();
        return (longValue == 0 || new Date().getTime() - longValue > 0) ? str : C1023c.m3962f();
    }
}
