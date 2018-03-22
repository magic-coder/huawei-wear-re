package com.huawei.hwservicesmgr.remote;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.gson.Gson;
import com.huawei.al.a;
import com.huawei.e.g;
import com.huawei.e.m;
import com.huawei.hihealth.data.b.f;
import com.huawei.hihealth.p036a.C0824b;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.p063b.C0976c;
import com.huawei.hwdevicemgr.dmsdatatype.datatype.DeviceCommand;
import com.huawei.hwdevicemgr.p073a.C1023c;
import com.huawei.hwservicesmgr.C1050g;
import com.huawei.hwservicesmgr.datetype.DeviceInfo;
import com.huawei.hwservicesmgr.remote.parser.IParser;
import com.huawei.p032e.C0802a;
import com.huawei.p032e.C0804j;
import com.huawei.p190v.C2538c;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RemoteServiceMgr {
    public static final String DEVICE_CONNECTED = "deviceConnected";
    public static final String DEVICE_DISCONNECTED = "deviceDisconnected";
    public static final String DEVICE_INSTANT_CONNECTETED = "deviceInstantConnected";
    public static final String DEVICE_INSTANT_DISCONNECTETED = "deviceInstantDisconnected";
    private static final int EXERCISEADVICE_BLUETOOTH_PINGPONG_TIMEOUT = 300000;
    public static final String FUNC_NAME = "funcName";
    private static final long MAX_DELAYED_TIME_OF_RECONNECTION = 600000;
    private static final int MSG_EXERCISEADVICE_BT_DISCONNECTED = 1;
    private static final String PACKAGE_COM_HUAWEI_BONE = "com.huawei.bone";
    private static final String PACKAGE_NAME_HUAWEI_HEALTH = "com.huawei.health";
    public static final String PARAMETERS = "parameters";
    public static final String STATE = "state";
    private static final String TAG = "RemoteServiceMgr";
    public static final int THREAD_POOL_SIZE = 20;
    private static Gson gson = new Gson();
    private static C1023c hwDeviceMgr;
    private static IBaseResponseCallback iBaseResponseCallback = new 3();
    private static g iCallbackInterface;
    private static RemoteServiceMgr instance;
    private static boolean isDisconnectedReported = false;
    private static String lastKnownDeviceIdentify = null;
    private static byte[] lock = new byte[0];
    private static Map<String, IParser> methodMap = new HashMap();
    private static MgrHandler mgrHandler;
    private ExecutorService executorService = Executors.newSingleThreadExecutor();
    private Handler handler = new Handler();
    private m iRemoteProxyCallback = new 4(this);
    private BroadcastReceiver mConnectStateChangedReceiver = new 5(this);
    private long mConnectedDelayTime = 1000;
    private ServiceConnection mConnection = new 1(this);
    private Context mContext;
    private List<Integer> mDeviceInfoConfigSuccessList = null;
    private List<Integer> mHiSubscribeTypeList = new ArrayList();
    private com.huawei.hihealth.data.b.g mHiUnSubscribeListener = new 2(this);
    private f mSubscribeListener = new 7(this);
    private IBinder mToken = new Binder();
    private ExecutorService threadPool = Executors.newFixedThreadPool(20);

    public static RemoteServiceMgr getInstance() {
        if (instance == null) {
            instance = new RemoteServiceMgr(BaseApplication.m2632b());
            mgrHandler = new MgrHandler(instance);
            hwDeviceMgr = C1023c.m3920a(BaseApplication.m2632b());
            initializeMethodMap();
        }
        return instance;
    }

    public void getDeviceListSizeFromHealth(C0804j c0804j) {
        C2538c.m12674b(TAG, "Enter getDeviceListSizeFromHealth");
        try {
            if (iCallbackInterface != null) {
                iCallbackInterface.b(c0804j);
                return;
            }
            startRemoteService();
            c0804j.m2688a(-1, 0);
        } catch (RemoteException e) {
            C2538c.m12677c(TAG, "Enter RemoteException:" + e.getMessage());
        } catch (Exception e2) {
            C2538c.m12677c(TAG, "Enter Exception:" + e2.getMessage());
        }
    }

    public void unbindDeviceListFromHealth(C0802a c0802a) {
        C2538c.m12674b(TAG, "Enter unbindDeviceListFromHealth");
        try {
            if (iCallbackInterface != null) {
                iCallbackInterface.a(c0802a);
                return;
            }
            startRemoteService();
            c0802a.m2686a(-1, null);
        } catch (RemoteException e) {
            C2538c.m12677c(TAG, "Enter RemoteException:" + e.getMessage());
        } catch (Exception e2) {
            C2538c.m12677c(TAG, "Enter Exception:" + e2.getMessage());
        }
    }

    public void isHealthSupportWearDevice(C0802a c0802a) {
        C2538c.m12674b(TAG, "Enter isHealthSupportWearDevice");
    }

    public void sendDataToHealth(String str, C0802a c0802a) {
        C2538c.m12677c(TAG, "Enter sendDataToHealth ");
        try {
            if (iCallbackInterface != null) {
                C2538c.m12677c(TAG, "Enter sendDataToHealth 2");
                iCallbackInterface.a(str, c0802a);
                return;
            }
            startRemoteService();
            c0802a.m2686a(-1, null);
        } catch (RemoteException e) {
            C2538c.m12677c(TAG, "Enter sendDataToHealth RemoteException:" + e.getMessage());
        } catch (Exception e2) {
            C2538c.m12677c(TAG, "Enter sendDataToHealth Exception:" + e2.getMessage());
        }
    }

    public void getCommonData(int i, C0802a c0802a) {
        C2538c.m12677c(TAG, "Enter getCommonData ");
        try {
            if (iCallbackInterface != null) {
                iCallbackInterface.a(i, c0802a);
                return;
            }
            C2538c.m12677c(TAG, "Enter getCommonData iCallbackInterface is null");
            startRemoteService();
            c0802a.m2686a(-1, null);
        } catch (RemoteException e) {
            C2538c.m12677c(TAG, "Enter getCommonData RemoteException:" + e.getMessage());
        } catch (Exception e2) {
            C2538c.m12677c(TAG, "Enter getCommonData Exception:" + e2.getMessage());
        }
    }

    private RemoteServiceMgr(Context context) {
        this.mContext = context;
        initConnection();
        initializeListener();
        IntentFilter intentFilter = new IntentFilter("com.huawei.bone.action.CONNECTION_STATE_CHANGED");
        intentFilter.addAction("com.huawei.bone.action.PHONE_SERVICE_BIND_SUCCESS");
        BaseApplication.m2632b().registerReceiver(this.mConnectStateChangedReceiver, intentFilter, C0976c.f1642a, null);
    }

    public static void reconnect() {
        if (iCallbackInterface == null) {
            instance.initConnection();
        }
    }

    private void initConnection() {
        this.executorService.execute(new 6(this));
    }

    private void startRemoteService() {
        if (iCallbackInterface == null) {
            C2538c.m12677c(TAG, "starting callbackservice ....");
            Intent intent = new Intent();
            intent.setAction("com.huawei.health.callbackservice");
            intent.setPackage("com.huawei.health");
            intent.setComponent(new ComponentName("com.huawei.health", "com.huawei.health.hwhealthlinkage.wearsdk.CallbackService"));
            Context context = this.mContext;
            ServiceConnection serviceConnection = this.mConnection;
            Context context2 = this.mContext;
            context.bindService(intent, serviceConnection, 1);
        }
    }

    public void sendDeviceData(DeviceCommand deviceCommand) {
        hwDeviceMgr.m3995b(deviceCommand);
    }

    private long getDelayedTime() {
        if (this.mConnectedDelayTime > MAX_DELAYED_TIME_OF_RECONNECTION) {
            return MAX_DELAYED_TIME_OF_RECONNECTION;
        }
        this.mConnectedDelayTime = 2 * this.mConnectedDelayTime;
        if (this.mConnectedDelayTime <= MAX_DELAYED_TIME_OF_RECONNECTION) {
            return this.mConnectedDelayTime;
        }
        return MAX_DELAYED_TIME_OF_RECONNECTION;
    }

    private static void initializeMethodMap() {
        int i = 0;
        HWWorkoutServiceManager instance = HWWorkoutServiceManager.getInstance();
        HWExerciseAdviceManager instance2 = HWExerciseAdviceManager.getInstance();
        HWHeartRateManager instance3 = HWHeartRateManager.getInstance();
        Method[] declaredMethods = instance.getClass().getDeclaredMethods();
        Method[] declaredMethods2 = instance2.getClass().getDeclaredMethods();
        Method[] declaredMethods3 = instance3.getClass().getDeclaredMethods();
        for (Method name : declaredMethods) {
            methodMap.put(name.getName(), instance);
        }
        for (Method name2 : declaredMethods2) {
            methodMap.put(name2.getName(), instance2);
        }
        int length = declaredMethods3.length;
        while (i < length) {
            methodMap.put(declaredMethods3[i].getName(), instance3);
            i++;
        }
    }

    private void initializeListener() {
        HWHeartRateManager instance = HWHeartRateManager.getInstance();
        instance.registerNotificationHRCallback(iBaseResponseCallback);
        instance.registerNotificationStressCallback(iBaseResponseCallback);
        HWExerciseAdviceManager.getInstance().registerNotificationRunPlanRecordInfoCallbackList(iBaseResponseCallback);
        HWWorkoutServiceManager instance2 = HWWorkoutServiceManager.getInstance();
        instance2.registerNotificationSportReminderCallbackList(iBaseResponseCallback);
        instance2.registerNotificationStatusCallbackList(iBaseResponseCallback);
        instance2.registerNotificationGetWorkoutRecordStatisticCallbackList(iBaseResponseCallback);
        instance2.registerNotificationWorkoutRecordSpeechPlayCallbackList(iBaseResponseCallback);
    }

    private void initialHiLogin() {
        HWExerciseAdviceManager.getInstance().initLogin();
        regDeviceInfoConfigListener();
    }

    private boolean checkIsHealthAPPInstalled() {
        try {
            BaseApplication.m2632b().getPackageManager().getApplicationInfo("com.huawei.health", 0);
            return true;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    private void regDeviceInfoConfigListener() {
        C2538c.m12677c(TAG, "regDeviceInfoConfigListener");
        this.mHiSubscribeTypeList.clear();
        this.mHiSubscribeTypeList.add(Integer.valueOf(102));
        this.mHiSubscribeTypeList.add(Integer.valueOf(100));
        this.mHiSubscribeTypeList.add(Integer.valueOf(101));
        C0824b.m2914a(this.mContext).m2908a(this.mHiSubscribeTypeList, this.mSubscribeListener);
    }

    private static List<DeviceInfo> getDeviceInfoList() {
        List<com.huawei.hwcommonmodel.datatypes.DeviceInfo> a = hwDeviceMgr.m3984a();
        List<DeviceInfo> arrayList = new ArrayList();
        arrayList.clear();
        for (com.huawei.hwcommonmodel.datatypes.DeviceInfo createDeviceInfo : a) {
            arrayList.add(createDeviceInfo(createDeviceInfo));
        }
        C2538c.m12677c(TAG, "return getUsedDeviceList() with deviceInfoListBak size = " + arrayList.size());
        return arrayList;
    }

    private static DeviceInfo createDeviceInfo(com.huawei.hwcommonmodel.datatypes.DeviceInfo deviceInfo) {
        DeviceInfo deviceInfo2 = new DeviceInfo();
        deviceInfo2.setDeviceActiveState(deviceInfo.getDeviceActiveState());
        deviceInfo2.setDeviceConnectState(deviceInfo.getDeviceConnectState());
        deviceInfo2.setDeviceName(deviceInfo.getDeviceName());
        deviceInfo2.setProductType(a.a(deviceInfo.getProductType()));
        deviceInfo2.setDeviceIdentify(deviceInfo.getDeviceIdentify());
        if ("".equals(deviceInfo.getUUID())) {
            deviceInfo2.setUUID(deviceInfo.getDeviceIdentify());
        } else {
            deviceInfo2.setUUID(deviceInfo.getUUID());
        }
        deviceInfo2.setDeviceProtocol(deviceInfo.getDeviceProtocol());
        deviceInfo2.setEncryptType(deviceInfo.getEncryptType());
        deviceInfo2.setDeviceBTType(deviceInfo.getDeviceBTType());
        return deviceInfo2;
    }

    public void isLoudspeakerMuteOpenOrCloseHeartRate(int i, int i2, C1050g c1050g) throws RemoteException {
        HWHeartRateManager.getInstance().isLoudspeakerMuteOpenOrCloseHeartRate(i, i2, new 8(this, c1050g));
    }

    public boolean callbackIsNull() {
        return iCallbackInterface == null;
    }
}
