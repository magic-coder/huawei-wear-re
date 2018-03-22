package com.huawei.hwservicesmgr;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.text.TextUtils;
import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import com.google.gson.Gson;
import com.huawei.ac.p016a.C0631a;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.datatypes.C0979f;
import com.huawei.hwcommonmodel.datatypes.DataPromptData;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.hwcommonmodel.datatypes.MsgText;
import com.huawei.hwdataaccessmodel.p065a.C0993c;
import com.huawei.hwdataaccessmodel.sharedpreference.C0996a;
import com.huawei.hwdatamigrate.common.C0998f;
import com.huawei.hwdatamigrate.common.C0999h;
import com.huawei.hwdevicemgr.dmsdatatype.p074a.C1024b;
import com.huawei.hwdevicemgr.p073a.C1023c;
import com.huawei.hwservicesmgr.p076a.C1038a;
import com.huawei.hwservicesmgr.p076a.C1042c;
import com.huawei.hwservicesmgr.p076a.C1043e;
import com.huawei.hwservicesmgr.p076a.C1044h;
import com.huawei.hwservicesmgr.p076a.p077a.C1037a;
import com.huawei.hwservicesmgr.p076a.p078b.C1039c;
import com.huawei.hwservicesmgr.p076a.p078b.C1040d;
import com.huawei.hwservicesmgr.receiver.NetworkConnectReceiver;
import com.huawei.hwservicesmgr.remote.HWExerciseAdviceManager;
import com.huawei.hwservicesmgr.remote.HWHeartRateManager;
import com.huawei.hwservicesmgr.remote.HWWorkoutServiceManager;
import com.huawei.hwservicesmgr.remote.RemoteServiceMgr;
import com.huawei.hwservicesmgr.remote.parser.IParser;
import com.huawei.p030d.p031a.C0800a;
import com.huawei.p030d.p031a.C0801b;
import com.huawei.p169s.C1972b;
import com.huawei.p190v.C2538c;
import com.huawei.ui.main.stories.account.interactor.WeChat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PhoneService extends Service {
    private static int f1931a;
    private static C1048d f1932b;
    private static Map<String, String> f1933j = new HashMap();
    private static Map<Integer, IParser> f1934k = new HashMap();
    private C1023c f1935c;
    private C1044h f1936d;
    private C1042c f1937e;
    private C1038a f1938f;
    private C1043e f1939g;
    private C0631a f1940h;
    private List<C1065z> f1941i = new ArrayList();
    private RemoteServiceMgr f1942l;
    private Handler f1943m = new Handler();
    private long f1944n = 1000;
    private final long f1945o = 600000;
    private ExecutorService f1946p = Executors.newSingleThreadExecutor();
    private C0801b f1947q;
    private BroadcastReceiver f1948r;
    private C1024b f1949s = new C1060u(this);
    private final C1055n f1950t = new C1062w(this);

    public static void m4195a(int i) {
        f1931a = i;
    }

    static {
        f1933j.put("528e0a2b895739ac57fcdf053b74092c", WeChat.HEALTH_PACKAGE_NAME);
    }

    private void m4199a(byte[] bArr) {
        if (bArr.length < 2) {
            C2538c.m12679d("PhoneService", "handleNotify ,length < 2, return");
            return;
        }
        switch (bArr[0]) {
            case (byte) 1:
                if (this.f1940h != null && TagName.ORDER_TERMINAL == bArr[1] && !m4208d()) {
                    C2538c.m12674b("PhoneService", "null!=mHwWakeAppManager && DeviceConfigConstants.COMMAND_ID_OPEN_APP_PAGE == data[1] ,open app");
                    this.f1940h.m2328a(bArr);
                    return;
                }
                return;
            case (byte) 2:
                if (this.f1936d != null) {
                    this.f1936d.m4401a(bArr);
                }
                if (this.f1939g != null) {
                    this.f1939g.m4377a(bArr);
                    return;
                }
                return;
            case (byte) 4:
                if (this.f1937e != null) {
                    this.f1937e.m4356a(bArr);
                    return;
                }
                return;
            case (byte) 11:
                if (this.f1938f != null) {
                    this.f1938f.m4269a(bArr);
                    return;
                }
                return;
            default:
                return;
        }
    }

    private boolean m4208d() {
        List<RunningTaskInfo> runningTasks = ((ActivityManager) getSystemService("activity")).getRunningTasks(5);
        if (runningTasks != null && runningTasks.size() > 0) {
            for (RunningTaskInfo runningTaskInfo : runningTasks) {
                C2538c.m12674b("PhoneService", "appProcess.getPackageName=" + runningTaskInfo.topActivity.getPackageName());
                if ("com.huawei.bone".equals(((RunningTaskInfo) r3.next()).topActivity.getPackageName())) {
                    return true;
                }
            }
        }
        return false;
    }

    public void onCreate() {
        super.onCreate();
        this.f1946p.execute(new C1061v(this));
        m4217a();
        this.f1935c = C1023c.m3920a((Context) this);
        this.f1942l = RemoteServiceMgr.getInstance();
        HWExerciseAdviceManager instance = HWExerciseAdviceManager.getInstance();
        HWWorkoutServiceManager instance2 = HWWorkoutServiceManager.getInstance();
        HWHeartRateManager instance3 = HWHeartRateManager.getInstance();
        C1040d a = C1040d.m4273a();
        C1972b a2 = C1972b.m10261a();
        C1039c a3 = C1039c.m4270a();
        C1037a a4 = C1037a.m4219a();
        f1934k.put(Integer.valueOf(22), instance);
        f1934k.put(Integer.valueOf(23), instance2);
        f1934k.put(Integer.valueOf(25), instance3);
        f1934k.put(Integer.valueOf(1014), a);
        f1934k.put(Integer.valueOf(24), a2);
        f1934k.put(Integer.valueOf(31), a4);
        f1934k.put(Integer.valueOf(28), a3);
        m4214g();
        if (C0800a.m2682a()) {
            this.f1947q = new C0801b();
            this.f1947q.m2685a((Context) this);
        }
        m4210e();
        C2538c.m12674b("PhoneService", "====qingdong MessageCenterIntentService=====");
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.huawei.bone", "com.huawei.bone.service.MessageCenterIntentService"));
        intent.putExtra("commandType", 1);
        BaseApplication.m2632b().startService(intent);
    }

    private void m4210e() {
        this.f1948r = new NetworkConnectReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        registerReceiver(this.f1948r, intentFilter);
    }

    private void m4212f() {
        unregisterReceiver(this.f1948r);
    }

    public void m4217a() {
        if (getDatabasePath("SportDatas.db").exists()) {
            C2538c.m12674b("PhoneService", "====isFirstRun=====" + C0996a.m3612a((Context) this, String.valueOf(1008), "onDataMigrate_isFirstRun_phoneservice"));
            if (!"true".equals(C0996a.m3612a((Context) this, String.valueOf(1008), "onDataMigrate_isFirstRun_phoneservice"))) {
                C0996a.m3611a((Context) this, String.valueOf(1008), "onDataMigrate_isFirstRun_phoneservice", "true", new C0993c());
                List<Object> arrayList = new ArrayList();
                DeviceInfo deviceInfo = new DeviceInfo();
                Object a = C0998f.m3621a(getContentResolver(), "selected_device_type");
                if (!TextUtils.isEmpty(a)) {
                    m4197a(deviceInfo, Integer.parseInt(a));
                }
                if (-1 != deviceInfo.getProductType()) {
                    if (3 == deviceInfo.getProductType()) {
                        deviceInfo.setDeviceIdentify("AndroidWear");
                    } else {
                        deviceInfo.setDeviceIdentify(C0999h.m3630b(this));
                    }
                    deviceInfo.setDeviceActiveState(1);
                    C2538c.m12677c("PhoneService", "======onDataMigrate=======type=" + deviceInfo.getProductType());
                    C2538c.m12677c("PhoneService", "======onDataMigrate=======id=" + deviceInfo.getDeviceIdentify());
                    arrayList.add(deviceInfo);
                    C0996a.m3620c(this, String.valueOf(1000));
                    for (Object obj : arrayList) {
                        C0996a.m3611a((Context) this, String.valueOf(1000), obj.getDeviceIdentify(), new Gson().toJson(obj), new C0993c());
                    }
                    return;
                }
                return;
            }
            return;
        }
        C2538c.m12677c("PhoneService", "====not update from 1.5 version=====");
    }

    private void m4197a(DeviceInfo deviceInfo, int i) {
        switch (i) {
            case 0:
                deviceInfo.setProductType(0);
                deviceInfo.setDeviceBTType(1);
                deviceInfo.setDeviceProtocol(0);
                return;
            case 1:
                deviceInfo.setProductType(1);
                deviceInfo.setDeviceBTType(1);
                deviceInfo.setDeviceProtocol(1);
                return;
            case 2:
                C2538c.m12674b("PhoneService", "====not support=====");
                deviceInfo.setProductType(4);
                deviceInfo.setDeviceBTType(1);
                deviceInfo.setDeviceProtocol(1);
                return;
            case 3:
                deviceInfo.setProductType(3);
                deviceInfo.setDeviceBTType(0);
                deviceInfo.setDeviceProtocol(1);
                return;
            case 4:
                deviceInfo.setProductType(5);
                deviceInfo.setDeviceBTType(2);
                deviceInfo.setDeviceProtocol(1);
                return;
            case 5:
                C2538c.m12674b("PhoneService", "====not support=====");
                return;
            case 6:
                deviceInfo.setProductType(7);
                deviceInfo.setDeviceBTType(1);
                deviceInfo.setDeviceProtocol(2);
                return;
            case 7:
                C2538c.m12674b("PhoneService", "====not support=====");
                return;
            case 99:
                C2538c.m12674b("PhoneService", "==== AF500 =====");
                deviceInfo.setProductType(-2);
                deviceInfo.setDeviceBTType(2);
                deviceInfo.setDeviceProtocol(-1);
                return;
            default:
                return;
        }
    }

    private void m4214g() {
        this.f1936d = new C1044h(this);
        this.f1936d.m4400a();
        this.f1937e = C1042c.m4354a((Context) this);
        this.f1938f = C1038a.m4260a((Context) this);
        this.f1939g = C1043e.m4358a((Context) this);
        this.f1940h = C0631a.m2326a((Context) this);
        C2538c.m12677c("PhoneService", "---initManager finish---");
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        C2538c.m12677c("PhoneService", "---onStartCommand enter---");
        if (this.f1942l != null) {
            RemoteServiceMgr remoteServiceMgr = this.f1942l;
            RemoteServiceMgr.reconnect();
        }
        if (intent != null) {
            m4196a(intent);
            return super.onStartCommand(intent, i, i2);
        }
        C2538c.m12680e("PhoneService", "error, intent is null");
        return 1;
    }

    public void onLowMemory() {
        C2538c.m12680e("PhoneService", "onLowMemory");
        super.onLowMemory();
    }

    public boolean onUnbind(Intent intent) {
        C2538c.m12680e("PhoneService", "onUnbind " + intent.getAction());
        return super.onUnbind(intent);
    }

    private void m4196a(Intent intent) {
        C2538c.m12677c("PhoneService", "Enter handleIntent: intent = " + intent);
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            C2538c.m12680e("PhoneService", "error, action is null");
            return;
        }
        C2538c.m12677c("PhoneService", "handleIntent: action = " + action);
        boolean z = true;
        switch (action.hashCode()) {
            case -1343153562:
                if (action.equals("com.huawei.bone.ACTION_NOTIFICATION_DELETE")) {
                    z = true;
                    break;
                }
                break;
            case -57849172:
                if (action.equals("com.huawei.bone.action.REGISTER_PHONE_LISTEN")) {
                    z = true;
                    break;
                }
                break;
            case 823795052:
                if (action.equals("android.intent.action.USER_PRESENT")) {
                    z = true;
                    break;
                }
                break;
            case 1306405379:
                if (action.equals("com.huawei.iconnect.ACTION_RECONNECT_MSG")) {
                    z = true;
                    break;
                }
                break;
            case 1366571669:
                if (action.equals("com.huawei.bone.ACTION_NOTIFICATION_PUSH")) {
                    z = false;
                    break;
                }
                break;
            case 1601123058:
                if (action.equals("com.huawei.intelligent.action.NOTIFY_MSG")) {
                    z = true;
                    break;
                }
                break;
        }
        switch (z) {
            case false:
                m4205c(intent);
                return;
            case true:
                m4202b(intent);
                return;
            case true:
                C2538c.m12677c("PhoneService", "==EMUI iConnect start reconnect...");
                this.f1935c.m3992a(true);
                return;
            case true:
                C2538c.m12677c("PhoneService", "Receive unlock phone msg, so force connect device.");
                if (this.f1935c != null) {
                    this.f1935c.m3992a(false);
                    return;
                }
                C2538c.m12677c("PhoneService", "mDeviceMgr is null.");
                return;
            case true:
                C2538c.m12677c("PhoneService", "REGISTER_PHONE_LISTEN_ACTION enter");
                if (this.f1936d != null) {
                    this.f1936d.m4403c();
                    return;
                }
                return;
            case true:
                m4207d(intent);
                C2538c.m12677c("PhoneService", "ACTION_NOTIFICATION_DELETE");
                return;
            default:
                return;
        }
    }

    private void m4202b(Intent intent) {
        String stringExtra = intent.getStringExtra("type");
        String stringExtra2 = intent.getStringExtra("message_short");
        C2538c.m12677c("PhoneService", "pushPromptToDevice, type = " + stringExtra + ", message_short = " + stringExtra2);
        if (stringExtra != null && stringExtra2 != null) {
            DataPromptData dataPromptData = new DataPromptData();
            dataPromptData.setMotor_enable(1);
            dataPromptData.setText_format(2);
            dataPromptData.setText_content(stringExtra2);
            C0979f c0979f = new C0979f(false, false, false, false, false, true, true, true);
            boolean z = true;
            switch (stringExtra.hashCode()) {
                case -1271823248:
                    if (stringExtra.equals("flight")) {
                        z = false;
                        break;
                    }
                    break;
                case 110621192:
                    if (stringExtra.equals("train")) {
                        z = true;
                        break;
                    }
                    break;
                case 1223440372:
                    if (stringExtra.equals("weather")) {
                        z = true;
                        break;
                    }
                    break;
                case 1899453439:
                    if (stringExtra.equals("warm_remind")) {
                        z = true;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    dataPromptData.setPrompt_type(7);
                    z = true;
                    break;
                case true:
                    dataPromptData.setPrompt_type(8);
                    z = true;
                    break;
                case true:
                    dataPromptData.setPrompt_type(9);
                    z = true;
                    break;
                case true:
                    dataPromptData.setPrompt_type(10);
                    z = true;
                    break;
                default:
                    z = false;
                    break;
            }
            C2538c.m12677c("PhoneService", "pushPromptToDevice, b_choose = " + z);
            if (z) {
                C2538c.m12677c("PhoneService", "pushPromptToDevice start NotifySendData to send command");
                if (this.f1939g != null) {
                    this.f1939g.m4375a(this.f1939g.m4373a(dataPromptData, c0979f), 1);
                    return;
                }
                return;
            }
            C2538c.m12680e("PhoneService", "postPromptMsg failure: type is not support!");
        }
    }

    private void m4205c(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            int i = extras.getInt("type");
            List arrayList = new ArrayList();
            List arrayList2 = new ArrayList();
            MsgText msgText = new MsgText();
            msgText.setTextType(extras.getInt("title_type"));
            msgText.setTextContent(extras.getString("title"));
            arrayList2.add(msgText);
            msgText = new MsgText();
            msgText.setTextType(extras.getInt("text_type"));
            msgText.setTextContent(extras.getString("text"));
            arrayList2.add(msgText);
            if (this.f1939g != null) {
                this.f1939g.m4375a(this.f1939g.m4372a(i, true, arrayList, arrayList2), 2);
            }
        }
    }

    public void onDestroy() {
        C2538c.m12674b("PhoneService", "onDestroy");
        super.onDestroy();
        m4212f();
        m4215h();
    }

    private void m4215h() {
        if (this.f1936d != null) {
            this.f1936d.m4402b();
        }
        if (this.f1939g != null) {
            this.f1939g.m4374a();
        }
        if (this.f1938f != null) {
            this.f1938f.m4267a();
        }
    }

    public IBinder onBind(Intent intent) {
        return this.f1950t;
    }

    private long m4216i() {
        this.f1944n = 2 * this.f1944n;
        if (this.f1944n <= 600000) {
            return this.f1944n;
        }
        return 600000;
    }

    private void m4207d(Intent intent) {
        C2538c.m12677c("PhoneService", "delteMsgToDevice: msgType：" + intent.getIntExtra("type", 0));
        if (this.f1939g != null) {
            this.f1939g.m4375a(this.f1939g.m4371a(r0), 2);
        }
    }
}
