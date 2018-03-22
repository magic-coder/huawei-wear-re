package com.huawei.hwdevicedfxmanager.manager;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.google.gson.Gson;
import com.huawei.ab.C0630m;
import com.huawei.datatype.DataDeviceInfo;
import com.huawei.hwbasemgr.C0628a;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcloudmodel.p060b.C0969i;
import com.huawei.hwcloudmodel.p061c.C0970w;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.datatypes.TransferFileInfo;
import com.huawei.hwdevicedfxmanager.callback.IDeviceDFXBaseResponseCallback;
import com.huawei.hwdevicedfxmanager.datatype.BoneBroadcastJson;
import com.huawei.hwdevicedfxmanager.utils.MaintenaceInterface;
import com.huawei.hwdevicedfxmanager.utils.MaintenanceUtil;
import com.huawei.hwservicesmgr.C1057r;
import com.huawei.hwservicesmgr.C1059s;
import com.huawei.p108n.C1204c;
import com.huawei.p190v.C2538c;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Calendar;

public class HWDeviceDFXManager extends C0628a {
    private static final int DFX_FIREWARE_TIMEOUT = 100;
    private static final long FIREWARE_VERSION_TIME_OUT = 30000;
    private static final String TAG = "HWDeviceDFXManager";
    private static HWDeviceDFXManager mInstance = null;
    private String deviceMac = "";
    private int deviceType = -1;
    private String deviceVersion = "";
    private C1059s dfxITransferDFXFileUICallback = new 8(this);
    private C1059s dfxITransferSleepAndDFXFileCallback = new 6(this);
    private int logLevel = 1;
    private Context mContext = null;
    private WeakReference<IDeviceDFXBaseResponseCallback> mDFXResponseCallBack;
    private IBaseResponseCallback mFirmwareVersionCallback = new 5(this);
    private C1204c mHWDeviceConfigManager;
    private Handler mHandler;
    private boolean mManulCollectLog;
    private IBaseResponseCallback mUIFirmwareVersionCallback = new 9(this);
    private IDeviceDFXBaseResponseCallback maintenanceCallback;
    private MaintenaceInterface maintenanceUtil = null;
    private C1059s sleepITransferSleepAndDFXFileCallback = new 7(this);

    public static HWDeviceDFXManager getInstance(Context context) {
        if (mInstance == null && context != null) {
            C2538c.m12674b(TAG, "getInstance() context = " + context);
            mInstance = new HWDeviceDFXManager(BaseApplication.m2632b());
        }
        return mInstance;
    }

    private HWDeviceDFXManager(Context context) {
        super(context);
        this.mContext = context;
        this.mHandler = new HWDeviceDFXManagerHander(this, context.getMainLooper());
        this.mHWDeviceConfigManager = C1204c.m5370a(this.mContext);
        if (this.mHWDeviceConfigManager == null) {
            C2538c.m12680e(TAG, "mHWDeviceConfigManager is null");
            return;
        }
        C2538c.m12677c(TAG, "HWDeviceDFXManager new object!");
    }

    protected Integer getModuleId() {
        return Integer.valueOf(10);
    }

    public void setMaintCheckTime(String str) {
        if (this.maintenanceUtil != null) {
            this.maintenanceUtil.setMaintCheckTime(str);
        }
    }

    public String getMaintCheckTime() {
        if (this.maintenanceUtil != null) {
            return this.maintenanceUtil.getMaintCheckTime();
        }
        return "0";
    }

    public void setMaintRetryResult(boolean z) {
        if (this.maintenanceUtil != null) {
            this.maintenanceUtil.setMaintRetryResult(z);
        }
    }

    public boolean getMaintRetryResult() {
        if (this.maintenanceUtil != null) {
            return this.maintenanceUtil.getMaintRetryResult();
        }
        return false;
    }

    public void setMaintRetryNum(int i) {
        if (this.maintenanceUtil != null) {
            this.maintenanceUtil.setMaintRetryNum(i);
        }
    }

    public int getMaintRetryNum() {
        if (this.maintenanceUtil != null) {
            return this.maintenanceUtil.getMaintRetryNum();
        }
        return 0;
    }

    public void getMaintenanceFile(int i, IDeviceDFXBaseResponseCallback iDeviceDFXBaseResponseCallback) {
        int i2 = Calendar.getInstance().get(11);
        C2538c.m12677c(TAG, "getMaintenanceFile getDFXlog localHour = " + i2);
        if (6 <= i2 && i2 < 10) {
            if (iDeviceDFXBaseResponseCallback != null) {
                iDeviceDFXBaseResponseCallback.onFailure(2, "time is error!!!");
            }
            C2538c.m12677c(TAG, "getMaintenanceFile getDFXlog 6 < localHour < 10 return !!!");
        } else if (this.mManulCollectLog) {
            C2538c.m12677c(TAG, "getMaintenanceFile  collecting device log manually ");
        } else {
            C2538c.m12677c(TAG, "getMaintenanceFile  level = " + i + ",+ callback = " + iDeviceDFXBaseResponseCallback);
            if (isDeviceSuport()) {
                this.maintenanceUtil = MaintenanceUtil.getMainInstance();
                boolean needMaintenance = needMaintenance();
                C2538c.m12677c(TAG, "checkMaintDate() canMaint = " + needMaintenance);
                if (needMaintenance) {
                    this.logLevel = 0;
                    this.maintenanceCallback = iDeviceDFXBaseResponseCallback;
                    new Thread(new 1(this)).start();
                    return;
                }
                C2538c.m12677c(TAG, "checkMaintDate() today has maint or retry > 3 ");
                return;
            }
            C2538c.m12674b(TAG, "getMaintenanceFile 不支持该设备!");
        }
    }

    public void getMaintanceFileNoRestrict(int i, IDeviceDFXBaseResponseCallback iDeviceDFXBaseResponseCallback) {
        C2538c.m12674b(TAG, "the version do not support");
    }

    public void getCrowdTestAndMaint(int i, IDeviceDFXBaseResponseCallback iDeviceDFXBaseResponseCallback) {
        if (this.mManulCollectLog) {
            C2538c.m12677c(TAG, "getCrowdTestAndMaint  collecting device log manually ");
        } else if (isDeviceSuport()) {
            C2538c.m12677c(TAG, "getCrowdTestAndMaint  level = " + i + ",+ callback = " + iDeviceDFXBaseResponseCallback);
            this.logLevel = 0;
            this.maintenanceCallback = iDeviceDFXBaseResponseCallback;
            this.maintenanceUtil = MaintenanceUtil.getMainInstance();
            new Thread(new 3(this)).start();
        } else {
            C2538c.m12674b(TAG, "getMaintanceFileNoRestrict 不支持该设备!");
        }
    }

    public void getCrowdFirmwareVersion() {
        C2538c.m12674b(TAG, "getCrowdFirmwareVersion mHWDeviceConfigManager = " + this.mHWDeviceConfigManager);
        if (this.mHWDeviceConfigManager == null) {
            C2538c.m12674b(TAG, "getCrowdFirmwareVersion mHWDeviceConfigManager = null");
            return;
        }
        C2538c.m12674b(TAG, "getCrowdFirmwareVersion mHWDeviceConfigManager.getCurrentDeviceInfo() = " + this.mHWDeviceConfigManager.m5447c());
        if (this.mHWDeviceConfigManager.m5447c() == null) {
            C2538c.m12674b(TAG, "getCrowdFirmwareVersion mHWDeviceConfigManager.getCurrentDeviceInfo() = null");
            return;
        }
        this.deviceType = this.mHWDeviceConfigManager.m5447c().getProductType();
        C2538c.m12674b(TAG, "getCrowdFirmwareVersion deviceType = " + this.deviceType);
        this.deviceMac = this.mHWDeviceConfigManager.m5447c().getDeviceIdentify();
        C2538c.m12674b(TAG, "getCrowdFirmwareVersion deviceMac = " + this.deviceMac);
        this.mHWDeviceConfigManager.m5425a(new 4(this));
    }

    private void broadcastCrowdDeviceInfoResult() {
        C2538c.m12677c(TAG, "broadcastCrowdDeviceInfoResult: deviceType = " + this.deviceType + ",+deviceVersion = " + this.deviceVersion + ",+ deviceMac = " + this.deviceMac);
        String deviceName = MaintenanceUtil.getMainInstance().getDeviceName(this.deviceType);
        C2538c.m12674b(TAG, "broadcastCrowdDeviceInfoResult name = " + deviceName);
        C2538c.m12674b(TAG, "broadcastCrowdDeviceInfoResult SEND_GET_BETA_INFO = com.huawei.crowdtest.action.GET_BETA_INFO");
        Intent intent = new Intent("com.huawei.crowdtest.action.GET_BETA_INFO");
        Object boneBroadcastJson = new BoneBroadcastJson();
        boneBroadcastJson.setProductType(deviceName);
        boneBroadcastJson.setBuildNumber(this.deviceVersion);
        boneBroadcastJson.setDeviceID(this.deviceMac);
        intent.putExtra("Request", new Gson().toJson(boneBroadcastJson));
        this.mContext.sendBroadcast(intent);
        C2538c.m12677c(TAG, "broadcastCrowdDeviceInfoResult: 发送设备信息！！！");
    }

    public boolean isDeviceSuport() {
        boolean b = C0970w.m3489b();
        if (this.mHWDeviceConfigManager != null) {
            this.mHWDeviceConfigManager = C1204c.m5370a(this.mContext);
        }
        boolean c = C0630m.m2297a(this.mContext).m2318c();
        C2538c.m12674b(TAG, "BuildConfig.SUPPORT_LOG_FEEDBACK false,experenceSwitch: " + c + ",isNoCloud: " + b);
        if (this.mHWDeviceConfigManager == null || this.mHWDeviceConfigManager.m5447c() == null) {
            return false;
        }
        this.deviceType = this.mHWDeviceConfigManager.m5447c().getProductType();
        C2538c.m12674b(TAG, "该设备为 = " + this.deviceType);
        if (7 != this.deviceType && 8 != this.deviceType && 13 != this.deviceType && 14 != this.deviceType && 15 != this.deviceType && 10 != this.deviceType) {
            return false;
        }
        C2538c.m12677c(TAG, "BuildConfig.RELEASE_EVENT_LOG_UPLOAD : true");
        if (C0969i.m3482a(48) && c && !b) {
            return true;
        }
        return false;
    }

    private boolean delayedOneDay(String str) {
        String maintCheckTime = getMaintCheckTime();
        if (this.maintenanceUtil == null || str == null) {
            return false;
        }
        C2538c.m12677c(TAG, "canMaintTime: strLastTime = " + maintCheckTime + ", strCurTime = " + str);
        try {
            if (Long.parseLong(str) - Long.parseLong(maintCheckTime) >= 86400000) {
                return true;
            }
        } catch (NumberFormatException e) {
            C2538c.m12680e(TAG, " delayedEightHour exception: " + e.getMessage());
        }
        return false;
    }

    private boolean needMaintenance() {
        String dayDateTime = this.maintenanceUtil.getDayDateTime();
        if (delayedOneDay(dayDateTime)) {
            setMaintCheckTime(dayDateTime);
            setMaintRetryNum(1);
            return true;
        }
        int maintRetryNum = getMaintRetryNum();
        boolean maintRetryResult = getMaintRetryResult();
        C2538c.m12677c(TAG, "canMaintTime() failTime = " + maintRetryNum + ", isSuccess = " + maintRetryResult);
        if (maintRetryNum >= 3 || maintRetryResult) {
            C2538c.m12677c(TAG, "canMaintTime() today has no sucess maint,but retry > 3");
            return false;
        }
        int i = maintRetryNum + 1;
        setMaintCheckTime(dayDateTime);
        setMaintRetryNum(i);
        return true;
    }

    private void handlerFirmwareVersion(DataDeviceInfo dataDeviceInfo, C1057r c1057r) {
        if (dataDeviceInfo != null) {
            this.deviceVersion = dataDeviceInfo.getDevice_soft_version();
            C2538c.m12674b(TAG, "mFirmwareVersionCallback deviceVersion = " + this.deviceVersion);
            if (this.mHWDeviceConfigManager.m5447c() == null) {
                C2538c.m12674b(TAG, "mFirmwareVersionCallback getCurrentDeviceInfo() = null");
                return;
            }
            this.deviceMac = this.mHWDeviceConfigManager.m5447c().getDeviceIdentify();
            C2538c.m12674b(TAG, "mFirmwareVersionCallback 222222222222 = ");
            setMaintRetryResult(false);
            TransferFileInfo transferFileInfo = new TransferFileInfo();
            transferFileInfo.setType(0);
            transferFileInfo.setRecordId(new ArrayList());
            transferFileInfo.setLevel(this.logLevel);
            int device_type = dataDeviceInfo.getDevice_type();
            if (device_type == 10) {
                transferFileInfo.setDeviceMac(dataDeviceInfo.getDevice_sn());
            } else {
                transferFileInfo.setDeviceMac(this.deviceMac);
            }
            transferFileInfo.setDeviceType(device_type);
            transferFileInfo.setDeviceVersion(this.deviceVersion);
            C2538c.m12677c(TAG, "deviceMac==" + this.deviceMac + "==deviceType==" + this.deviceType + "==deviceVersion==" + this.deviceVersion);
            C1204c.m5370a(this.mContext).m5426a(transferFileInfo, c1057r);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        this.mManulCollectLog = false;
    }

    public void getSleepDetailFromDevice(int i, int i2, boolean z, IDeviceDFXBaseResponseCallback iDeviceDFXBaseResponseCallback) {
        C2538c.m12677c(TAG, "enter getSleepDetailFromDevice()! startTime = " + i + " , endTime = " + i2);
        TransferFileInfo transferFileInfo = new TransferFileInfo();
        transferFileInfo.setType(2);
        transferFileInfo.setRecordId(new ArrayList());
        transferFileInfo.setStartTime(i);
        transferFileInfo.setEndTime(i2);
        this.maintenanceCallback = iDeviceDFXBaseResponseCallback;
        C1204c.m5370a(this.mContext).m5426a(transferFileInfo, this.sleepITransferSleepAndDFXFileCallback);
    }

    public void getDeviceLog(IDeviceDFXBaseResponseCallback iDeviceDFXBaseResponseCallback) {
        if (!isDeviceSuport()) {
            C2538c.m12674b(TAG, "getMaintanceFileNoRestrict 不支持该设备!");
            if (iDeviceDFXBaseResponseCallback != null) {
                iDeviceDFXBaseResponseCallback.onFailure(2, null);
            }
        } else if (this.mManulCollectLog) {
            iDeviceDFXBaseResponseCallback.onFailure(2, null);
        } else {
            this.mManulCollectLog = true;
            this.maintenanceUtil = MaintenanceUtil.getMainInstance();
            this.logLevel = 0;
            this.mDFXResponseCallBack = new WeakReference(iDeviceDFXBaseResponseCallback);
            if (this.mHandler != null) {
                this.mHandler.removeMessages(100);
                this.mHandler.sendEmptyMessageDelayed(100, 30000);
            }
            this.mHWDeviceConfigManager.m5425a(this.mUIFirmwareVersionCallback);
        }
    }
}
