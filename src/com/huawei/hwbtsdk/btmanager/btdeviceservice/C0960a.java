package com.huawei.hwbtsdk.btmanager.btdeviceservice;

import android.bluetooth.BluetoothDevice;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C0378p;
import com.google.android.gms.common.api.C0379q;
import com.google.android.gms.common.api.C0380r;
import com.google.android.gms.common.api.C0381s;
import com.google.android.gms.common.api.C0382t;
import com.google.android.gms.common.data.C0399g;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.C0520b;
import com.google.android.gms.wearable.C0522l;
import com.google.android.gms.wearable.C0523u;
import com.google.android.gms.wearable.C0525c;
import com.google.android.gms.wearable.C0526d;
import com.google.android.gms.wearable.C0535v;
import com.google.android.gms.wearable.C0538z;
import com.google.android.gms.wearable.C0550m;
import com.google.android.gms.wearable.C0552n;
import com.google.android.gms.wearable.C0568w;
import com.google.android.gms.wearable.C0569x;
import com.google.android.gms.wearable.C0570o;
import com.google.android.gms.wearable.C0571r;
import com.google.android.gms.wearable.C0572s;
import com.google.android.gms.wearable.PutDataRequest;
import com.google.android.gms.wearable.aa;
import com.google.android.gms.wearable.ab;
import com.google.android.gms.wearable.ac;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwbtsdk.p057b.p058a.C0958f;
import com.huawei.hwbtsdk.p059c.BTSDKApi;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.hwcommonmodel.p064d.C0977d;
import com.huawei.nfc.carrera.ui.NFCBaseActivity;
import com.huawei.p190v.C2538c;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import net.sqlcipher.database.SQLiteDatabase;

/* compiled from: BTDeviceAWService */
public class C0960a implements C0380r, C0381s, aa, C0520b, C0522l, C0523u, C0959q {
    private static String f1575n = "health_watch_message";
    private static String f1576o = "health_watch_file";
    private static C0960a f1577p = null;
    private Context f1578a = null;
    private C0378p f1579b;
    private C0966g f1580c;
    private C0967h f1581d = null;
    private DeviceInfo f1582e = new DeviceInfo();
    private C0958f f1583f = null;
    private IBaseResponseCallback f1584g = null;
    private C0569x f1585h = null;
    private int f1586i = 0;
    private HandlerThread f1587j = new HandlerThread("BTDeviceAWService");
    private C0965f f1588k = null;
    private int f1589l = 0;
    private int f1590m = 0;
    private HandlerThread f1591q = new HandlerThread("BTDeviceAWServiceData");
    private Handler f1592r = null;

    public static C0960a m3374a() {
        if (f1577p == null) {
            f1577p = new C0960a();
        }
        return f1577p;
    }

    public static C0960a m3375a(Context context, BluetoothDevice bluetoothDevice, C0958f c0958f) {
        C0960a a = C0960a.m3374a();
        a.f1578a = context;
        a.f1583f = c0958f;
        if (a.f1582e != null) {
            a.f1582e.configureDeviceIdentify("AndroidWear");
            a.f1582e.configureDeviceName("HUAWEI WATCH");
            a.f1582e.configureDeviceBTType(0);
        }
        return f1577p;
    }

    public void m3392a(Context context) {
        C2538c.m12661a("01", 1, "BTDeviceAWService", "Enter gmsConnect ");
        if (this.f1579b != null) {
            this.f1579b.mo1807b();
            return;
        }
        this.f1579b = new C0379q(context).m394a(ac.f928l).m395a((C0380r) this).m396a((C0381s) this).m393a(this.f1592r).m398b();
        if (this.f1579b == null) {
            C2538c.m12663a("0xA0200009", "01", 1, "BTDeviceAWService", "mGoogleApiClient is null");
            return;
        }
        this.f1579b.mo1807b();
    }

    private C0960a() {
        this.f1587j.start();
        this.f1588k = new C0965f(this, this.f1587j.getLooper());
        this.f1591q.start();
        this.f1592r = new Handler(this.f1591q.getLooper());
    }

    public void mo2291a(BluetoothDevice bluetoothDevice) {
        C2538c.m12661a("01", 1, "BTDeviceAWService", "Enter connectBTDevice() with device state = " + this.f1586i);
        if (this.f1578a == null) {
            m3386d(4);
            return;
        }
        BTDeviceAWHostService.m3355a(this.f1578a);
        this.f1585h = null;
        m3386d(1);
        if (this.f1579b == null) {
            C2538c.m12661a("01", 1, "BTDeviceAWService", "blockingConnect mGoogleApiClient is null");
        } else if (this.f1579b.mo1811e()) {
            m3387h();
        } else if (this.f1579b.mo1812f()) {
            C2538c.m12661a("01", 1, "BTDeviceAWService", "GoogleApiClient isConnecting");
        } else {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(NFCBaseActivity.AW_NAME_CN, "com.google.android.gms.wearable.service.WearableService"));
            this.f1578a.startService(intent);
            C2538c.m12661a("01", 1, "BTDeviceAWService", "started gms service");
            this.f1579b.mo1807b();
            C2538c.m12663a("0xA0200009", "01", 1, "BTDeviceAWService", "GoogleApiClient try connect");
        }
    }

    public void mo1829a(Bundle bundle) {
        C2538c.m12661a("01", 1, "BTDeviceAWService", "onConnected");
        m3387h();
    }

    public void mo1907a(C0526d c0526d) {
        if (this.f1578a != null) {
            DeviceInfo j = BTSDKApi.m3425a(this.f1578a).m3480j();
            if (j != null && j.getDeviceBTType() == 0) {
                C2538c.m12661a("01", 1, "BTDeviceAWService", "onCapabilityChanged:" + c0526d);
                if (this.f1585h == null) {
                    C2538c.m12661a("01", 1, "BTDeviceAWService", "onCapabilityChanged mDeviceNode is null ");
                    mo2291a(null);
                    return;
                }
                Set<C0569x> nodes = c0526d.getNodes();
                if (nodes == null) {
                    C2538c.m12661a("01", 1, "BTDeviceAWService", "onCapabilityChanged nodeSet is null ");
                    return;
                }
                for (C0569x c0569x : nodes) {
                    if (this.f1585h.getId().equals(c0569x.getId())) {
                        mo1910a(c0569x);
                        C2538c.m12661a("01", 1, "BTDeviceAWService", "onCapabilityChanged onPeerConnected");
                        return;
                    }
                }
                m3389j();
            } else if (j != null) {
                C2538c.m12661a("01", 1, "BTDeviceAWService", "deviceInfo is not AW " + j);
            }
        }
    }

    private void m3387h() {
        C2538c.m12661a("01", 1, "BTDeviceAWService", "Enter connectedSuccess");
        ac.f920d.mo2005a(this.f1579b, this).mo1849a(new C0961b(this));
        if (this.f1581d == null) {
            this.f1581d = new C0967h(this);
            this.f1581d.start();
        }
    }

    public void mo2295b() {
        C2538c.m12661a("01", 1, "BTDeviceAWService", "start to disconnect.");
        mo2299e();
        m3389j();
    }

    public void mo1828a(int i) {
        C2538c.m12661a("01", 1, "BTDeviceAWService", "onConnectionSuspended i=" + i);
        m3389j();
    }

    public void mo1908a(C0570o c0570o) {
        List<C0552n> a = C0399g.m468a(c0570o);
        if (this.f1582e != null) {
            String str;
            String str2;
            C2538c.m12661a("01", 1, "BTDeviceAWService", "onDataChanged, watch layer = " + this.f1582e.getDeviceProtocol());
            if (2 == this.f1582e.getDeviceProtocol()) {
                str = "/wear_request_data";
                str2 = "wear_request_data";
            } else {
                str = "/wear";
                str2 = "byte";
            }
            C2538c.m12661a("01", 0, "BTDeviceAWService", "onDataChanged, rev_path = " + str + ", key = " + str2);
            for (C0552n c0552n : a) {
                if (c0552n.mo2024b() == 1) {
                    String path = c0552n.mo2023a().getUri().getPath();
                    C2538c.m12661a("01", 0, "BTDeviceAWService", "onDataChanged, watch path = " + path);
                    C0571r a2 = C0572s.m2255a(c0552n.mo2023a()).m2257a();
                    byte[] c;
                    if (path.startsWith("/wear_request_data")) {
                        if (a2 != null) {
                            c = a2.m2254c(str2);
                            if (c != null) {
                                C2538c.m12661a("01", 0, "BTDeviceAWService", "Device-->SDK：" + C0973a.m3509a(c));
                                if (this.f1583f == null) {
                                    C2538c.m12661a("01", 1, "BTDeviceAWService", "onDataChanged(), mBTDeviceStateCallback is null");
                                } else if (this.f1586i == 0 || 3 == this.f1586i) {
                                    C2538c.m12663a("0xA0200009", "01", 1, "BTDeviceAWService", "onDataChanged() status error drop data, mBTConnectState=" + this.f1586i);
                                    return;
                                } else {
                                    this.f1583f.m3354a(this.f1582e, c.length, c);
                                    C2538c.m12661a("01", 0, "BTDeviceAWService", "onDataChanged() bytes handle success!");
                                }
                            } else {
                                C2538c.m12661a("01", 1, "BTDeviceAWService", "onDataChanged(), bytes is null");
                            }
                        } else {
                            C2538c.m12661a("01", 1, "BTDeviceAWService", "onDataChanged(), dataMap is null");
                        }
                    } else if (path.equals("/wear")) {
                        if (a2 != null) {
                            c = a2.m2254c("byte");
                            if (c != null) {
                                C2538c.m12661a("01", 0, "BTDeviceAWService", "Device-->SDK：" + C0973a.m3509a(c));
                                if (this.f1583f != null) {
                                    this.f1583f.m3354a(this.f1582e, c.length, c);
                                    C2538c.m12661a("01", 0, "BTDeviceAWService", "onDataChanged() bytes handle success!");
                                } else {
                                    C2538c.m12661a("01", 1, "BTDeviceAWService", "onDataChanged(), mBTDeviceStateCallback is null");
                                }
                            } else {
                                C2538c.m12661a("01", 1, "BTDeviceAWService", "onDataChanged(), bytes is null");
                            }
                        } else {
                            C2538c.m12661a("01", 1, "BTDeviceAWService", "onDataChanged(), dataMap is null");
                        }
                    } else if ("/wear_request_asset".equals(path)) {
                        if (a2 != null) {
                            Asset b = a2.m2250b("wear_request_asset");
                            if (b != null) {
                                C2538c.m12661a("01", 0, "BTDeviceAWService", "Asset Device-->SDK：" + C0973a.m3509a(m3404a(b)));
                                if (this.f1584g != null) {
                                    this.f1584g.onResponse(0, c);
                                    C2538c.m12661a("01", 0, "BTDeviceAWService", "onDataChanged() asset handle success");
                                } else {
                                    C2538c.m12661a("01", 1, "BTDeviceAWService", "onDataChanged(), mBTDeviceFileCallback is null");
                                }
                            } else {
                                C2538c.m12661a("01", 1, "BTDeviceAWService", "onDataChanged(), asset is null");
                            }
                        } else {
                            C2538c.m12661a("01", 1, "BTDeviceAWService", "onDataChanged(), dataMap is null");
                        }
                    }
                } else if (c0552n.mo2024b() == 2) {
                    C2538c.m12661a("01", 0, "BTDeviceAWService", "onDataChanged() DataItem Deleted: " + c0552n.mo2023a().toString());
                }
            }
            return;
        }
        C2538c.m12661a("01", 1, "BTDeviceAWService", "onDataChanged() mDeviceInfo is null");
    }

    public void m3396a(ab abVar) {
        PutDataRequest b = abVar.m1690b();
        C2538c.m12661a("01", 0, "BTDeviceAWService", "Generating DataItem: " + b + "isConnected = " + this.f1579b.mo1811e());
        if (this.f1579b.mo1811e()) {
            C2538c.m12661a("01", 1, "BTDeviceAWService", "mGoogleApiClient.isConnected() = true");
            b.setUrgent();
            ac.f917a.mo2021a(this.f1579b, b).mo1849a(new C0962c(this));
            return;
        }
        this.f1579b.mo1810d();
    }

    public void m3395a(C0382t<C0535v> c0382t, ab abVar) {
        if (c0382t != null) {
            c0382t.mo1849a(new C0963d(this, abVar));
            return;
        }
        C2538c.m12672b("01", 1, "BTDeviceAWService", "pendingResult is null.");
    }

    public boolean mo2294a(byte[] bArr) {
        String str;
        String str2;
        C2538c.m12661a("01", 1, "BTDeviceAWService", "sendBTDeviceData, watch layer = " + this.f1582e.getDeviceProtocol());
        C2538c.m12661a("01", 0, "BTDeviceAWService", "SDK-->Device : " + C0973a.m3509a(bArr));
        if (2 != this.f1582e.getDeviceProtocol()) {
            str = "/phone";
            str2 = "byte";
        } else if (this.f1589l > 0) {
            if (this.f1590m <= 0 || this.f1590m >= this.f1589l + 1) {
                this.f1590m = 0;
                str2 = "/mobile_response_data";
            } else {
                str2 = "/mobile_response_data" + Integer.toString(this.f1590m);
            }
            C2538c.m12661a("01", 0, "BTDeviceAWService", "mCurrentChannel = " + this.f1590m);
            this.f1590m++;
            str = str2;
            str2 = "mobile_response_data";
        } else {
            str = "/mobile_response_data";
            str2 = "mobile_response_data";
        }
        C2538c.m12661a("01", 0, "BTDeviceAWService", "sendBTDeviceData,path = " + str + ", key = " + str2);
        ab a = ab.m1688a(str);
        a.m1689a().m2246a(str2, bArr);
        a.m1689a().m2240a("current_time", System.currentTimeMillis());
        if (this.f1585h != null) {
            a.m1689a().m2243a("NODE", this.f1585h.getId());
            C2538c.m12661a("01", 0, "BTDeviceAWService", " NODE = " + this.f1585h.getId());
        } else {
            C2538c.m12661a("01", 1, "BTDeviceAWService", "sendBTDeviceData NODE = null");
        }
        Object b = m3381b(f1575n);
        if (TextUtils.isEmpty(b)) {
            C2538c.m12661a("01", 1, "BTDeviceAWService", "sendBTDeviceData use dataLayer");
            m3396a(a);
        } else {
            C2538c.m12661a("01", 1, "BTDeviceAWService", "sendBTDeviceData use messageApi");
            m3395a(ac.f919c.mo2001a(this.f1579b, b, str, bArr), a);
        }
        m3384c(bArr);
        return true;
    }

    private String m3381b(String str) {
        C0526d a = ((C0525c) ac.f918b.mo2015a(this.f1579b, str, 1).mo1846a(5, TimeUnit.SECONDS)).mo2018a();
        if (a == null) {
            C2538c.m12663a("0xA0200009", "01", 1, "BTDeviceAWService", "getNodeId GetCapabilityResult info is null");
            return "";
        }
        C2538c.m12661a("01", 0, "BTDeviceAWService", "initConnectStatus CapabilityInfo = " + a);
        Set<C0569x> nodes = a.getNodes();
        if (nodes == null) {
            C2538c.m12663a("0xA0200009", "01", 1, "BTDeviceAWService", "getNodeId GetCapabilityResult info.getNodes() is null");
            return "";
        } else if (nodes.isEmpty()) {
            C2538c.m12663a("0xA0200009", "01", 1, "BTDeviceAWService", "getNodeId GetCapabilityResult list is empty");
            return "";
        } else {
            String str2 = null;
            C2538c.m12661a("01", 1, "BTDeviceAWService", "getNodeId CapabilityInfo count：" + nodes.size());
            for (C0569x c0569x : nodes) {
                if (c0569x.isNearby()) {
                    str2 = c0569x.getId();
                    break;
                }
                str2 = c0569x.getId();
            }
            C2538c.m12661a("01", 1, "BTDeviceAWService", "getNodeId CapabilityInfo node name:" + str + " node Id:" + str2);
            return str2;
        }
    }

    private Collection<C0569x> m3388i() {
        Collection hashSet = new HashSet();
        for (C0569x id : ((C0538z) ac.f920d.mo2004a(this.f1579b).mo1846a(5, TimeUnit.SECONDS)).mo2008a()) {
            C2538c.m12661a("01", 1, "BTDeviceAWService", "getNodes() already found watch：" + id.getDisplayName() + ",ID = " + id.getId());
            hashSet.add(id);
        }
        return hashSet;
    }

    public void mo1909a(C0568w c0568w) {
        if (c0568w == null || c0568w.getPath() == null) {
            C2538c.m12661a("01", 1, "BTDeviceAWService", "onMessageReceived messageEvent or path is null");
            return;
        }
        C2538c.m12661a("01", 0, "BTDeviceAWService", "Enter onMessageReceived() RequestId = " + c0568w.getRequestId() + "Path = " + c0568w.getPath());
        String path = c0568w.getPath();
        if (this.f1580c != null) {
            this.f1580c.execute(new String[]{path});
        }
        if ("/wear_request_message".equalsIgnoreCase(path)) {
            byte[] data = c0568w.getData();
            C2538c.m12661a("01", 0, "BTDeviceAWService", "onMessageReceived message data = " + C0973a.m3509a(data));
            if (data.length > 6 && (byte) 1 == data[4] && TagName.ORDER_TRADE_STATUS == data[5]) {
                m3408c();
            }
        }
        if (path.startsWith("/wear_request_data")) {
            byte[] data2 = c0568w.getData();
            if (data2 != null) {
                C2538c.m12661a("01", 1, "BTDeviceAWService", "MessageAPI Device-->SDK: " + C0973a.m3509a(data2));
                if (this.f1583f == null) {
                    C2538c.m12663a("0xA0200009", "01", 1, "BTDeviceAWService", "onMessageReceived(), mBTDeviceStateCallback is null");
                    return;
                } else if (this.f1586i == 0 || 3 == this.f1586i) {
                    C2538c.m12663a("0xA0200009", "01", 1, "BTDeviceAWService", "onMessageReceived() status error drop data, mBTConnectState=" + this.f1586i);
                    return;
                } else {
                    this.f1583f.m3354a(this.f1582e, data2.length, data2);
                    C2538c.m12661a("01", 1, "BTDeviceAWService", "onMessageReceived() handle success");
                    return;
                }
            }
            C2538c.m12663a("0xA0200009", "01", 1, "BTDeviceAWService", "onMessageReceived(), bytes is null");
        }
    }

    public void m3408c() {
        PackageInfo packageInfo;
        C2538c.m12661a("01", 0, "BTDeviceAWService", "Enter startAPP.");
        try {
            packageInfo = this.f1578a.getPackageManager().getPackageInfo("com.huawei.bone", 0);
        } catch (NameNotFoundException e) {
            C2538c.m12661a("01", 1, "BTDeviceAWService", "NameNotFoundException e= " + e.getMessage());
            packageInfo = null;
        }
        if (packageInfo == null) {
            C2538c.m12661a("01", 1, "BTDeviceAWService", "packageInfo is null");
            return;
        }
        Intent intent = new Intent("android.intent.action.MAIN", null);
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setPackage(packageInfo.packageName);
        ResolveInfo resolveInfo = (ResolveInfo) this.f1578a.getPackageManager().queryIntentActivities(intent, 0).iterator().next();
        if (resolveInfo != null) {
            String str = resolveInfo.activityInfo.packageName;
            String str2 = resolveInfo.activityInfo.name;
            intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            intent.setComponent(new ComponentName(str, str2));
            this.f1578a.startActivity(intent);
            C2538c.m12661a("01", 1, "BTDeviceAWService", "startAPP ,startActivity intent = " + intent);
        }
    }

    public void mo1910a(C0569x c0569x) {
        C2538c.m12661a("01", 0, "BTDeviceAWService", "onPeerConnected, connected watch: " + c0569x.getDisplayName() + ",ID = " + c0569x.getId());
        if (this.f1585h != null && this.f1585h.getId() != null && this.f1585h.getId().equals(c0569x.getId())) {
            if (1 != this.f1586i) {
                m3386d(1);
            }
            m3386d(2);
        } else if (this.f1585h == null) {
            this.f1585h = c0569x;
            if (1 != this.f1586i) {
                m3386d(1);
            }
            m3386d(2);
        } else {
            C2538c.m12672b("01", 1, "BTDeviceAWService", "onPeerConnected with connected different watch.");
        }
    }

    public void mo1912b(C0569x c0569x) {
        C2538c.m12661a("01", 0, "BTDeviceAWService", "aw device disconnected with displayName = " + c0569x.getDisplayName() + " id = " + c0569x.getId());
        if (this.f1585h == null || this.f1585h.getId() == null || !this.f1585h.getId().equals(c0569x.getId())) {
            C2538c.m12672b("01", 1, "BTDeviceAWService", "onPeerDisconnected but not wanted aw device.");
            return;
        }
        m3389j();
    }

    public void mo1830a(ConnectionResult connectionResult) {
        C2538c.m12661a("01", 1, "BTDeviceAWService", "onConnectionFailed, errCode = " + connectionResult.getErrorCode());
        m3386d(4);
    }

    private void m3389j() {
        C2538c.m12661a("01", 1, "BTDeviceAWService", "connectionLost() called");
        this.f1581d = null;
        m3386d(3);
    }

    private synchronized void m3386d(int i) {
        if (this.f1583f == null || this.f1582e == null) {
            C2538c.m12672b("01", 1, "BTDeviceAWService", "reportConnectState error with mBTDeviceStateCallback is null.");
        } else if (i == this.f1586i) {
            C2538c.m12661a("01", 1, "BTDeviceAWService", "reportConnectState , status not changed = " + i);
        } else {
            this.f1586i = i;
            if (i != this.f1582e.getDeviceConnectState()) {
                if (this.f1585h != null) {
                    m3383c(this.f1585h.getDisplayName());
                }
                C2538c.m12661a("01", 1, "BTDeviceAWService", "reportConnectState , awConnectState = " + i + ";add:" + this);
                if (2 != i) {
                    C2538c.m12661a("01", 1, "BTDeviceAWService", "clear path extend num and current channel flag.");
                    this.f1589l = 0;
                    this.f1590m = 0;
                }
                this.f1583f.m3353a(this.f1582e, i);
            }
        }
    }

    private void m3383c(String str) {
        C2538c.m12661a("01", 1, "BTDeviceAWService", "setName , AndroidWear name = " + str);
        if (!TextUtils.isEmpty(str)) {
            if (str.contains("HUAWEI")) {
                this.f1582e.configureDeviceName(str);
            } else {
                this.f1582e.configureDeviceName("HUAWEI WATCH");
            }
        }
    }

    public DeviceInfo mo2298d() {
        return this.f1582e;
    }

    public void mo2296b(int i) {
        C2538c.m12661a("01", 1, "BTDeviceAWService", "Enter btSwitchChangeInfo() with status = " + i);
    }

    public void mo2293a(String str) {
        C2538c.m12661a("01", 0, "BTDeviceAWService", "sendBTDeviceAssetData,assetpath = " + str);
        C2538c.m12661a("01", 0, "BTDeviceAWService", "sendBTDeviceAssetData,path = " + "/mobile_response_asset" + " ; key : " + r1);
        C2538c.m12661a("01", 0, "BTDeviceAWService", "sendBTDeviceAssetData,assetpath = " + str);
        byte[] c = C0977d.m3549c(str);
        ab a = ab.m1688a("/mobile_response_asset");
        a.m1689a().m2241a("mobile_response_asset", C0960a.m3379b(c));
        a.m1689a().m2243a("mobile_response_asset_name", str);
        a.m1689a().m2240a("current_time", System.currentTimeMillis());
        if (this.f1585h != null) {
            a.m1689a().m2243a("NODE", this.f1585h.getId());
            C2538c.m12661a("01", 0, "BTDeviceAWService", "NODE = " + this.f1585h.getId());
        } else {
            C2538c.m12663a("0xA0200009", "01", 1, "BTDeviceAWService", "sendBTFilePath NODE = null");
        }
        m3396a(a);
        C2538c.m12661a("01", 0, "BTDeviceAWService", "SDK-->Device : Asset : " + a);
    }

    private static Asset m3379b(byte[] bArr) {
        return Asset.createFromBytes(bArr);
    }

    public void mo2292a(IBaseResponseCallback iBaseResponseCallback) {
        this.f1584g = iBaseResponseCallback;
    }

    public byte[] m3404a(Asset asset) {
        if (asset == null) {
            throw new IllegalArgumentException("Asset must be non-null");
        }
        InputStream b = ((C0550m) ac.f917a.mo2020a(this.f1579b, asset).mo1846a(5, TimeUnit.SECONDS)).mo2022b();
        if (b == null) {
            C2538c.m12672b("01", 1, "BTDeviceAWService", "transToByteArrayFromAsset,Requested an unknown Asset.");
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            int available = b.available();
            C2538c.m12661a("01", 1, "BTDeviceAWService", "transToByteArrayFromAsset() length = " + available);
            byte[] bArr = new byte[available];
            while (true) {
                int read = b.read(bArr, 0, available);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (IOException e) {
            C2538c.m12663a("0xA0200006", "01", 1, "BTDeviceAWService", "output stream write err");
        }
        byte[] toByteArray = byteArrayOutputStream.toByteArray();
        try {
            b.close();
            byteArrayOutputStream.close();
            return toByteArray;
        } catch (IOException e2) {
            C2538c.m12663a("0xA0200006", "01", 1, "BTDeviceAWService", "transToByteArrayFromAsset ,Stream close err");
            return toByteArray;
        }
    }

    public void mo2299e() {
        C2538c.m12661a("01", 1, "BTDeviceAWService", "start to disconnectGMS.");
        if (this.f1579b != null) {
            ac.f920d.mo2006b(this.f1579b, this).mo1849a(new C0964e(this));
            this.f1579b.mo1809c();
        }
    }

    private void m3384c(byte[] bArr) {
        C2538c.m12661a("01", 1, "BTDeviceAWService", "Enter sendV1CheckCommand().");
        if (bArr != null && bArr.length > 6 && (byte) 1 == bArr[4] && (byte) 1 == bArr[5] && this.f1588k != null) {
            this.f1588k.sendEmptyMessageDelayed(1, 10000);
        }
    }

    public void mo2300f() {
        if (this.f1588k != null) {
            this.f1588k.removeMessages(1);
        }
    }

    public void mo2297c(int i) {
        C2538c.m12661a("01", 1, "BTDeviceAWService", "Enter setPathExtendNum with pathExtendNum = " + i);
        this.f1589l = i;
    }

    public int mo2301g() {
        return this.f1586i;
    }
}
