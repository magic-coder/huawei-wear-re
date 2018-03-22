package com.huawei.hwservicesmgr.remote;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.al.a;
import com.huawei.datatype.HeartRateInfo;
import com.huawei.hwbasemgr.C0628a;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.datatypes.DeviceCapability;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.hwcommonmodel.datatypes.HuaweiHealthData;
import com.huawei.hwcommonmodel.datatypes.s;
import com.huawei.hwcommonmodel.datatypes.t;
import com.huawei.hwcommonmodel.datatypes.u;
import com.huawei.hwcommonmodel.datatypes.w;
import com.huawei.hwcommonmodel.p063b.C0976c;
import com.huawei.hwdataaccessmodel.sharedpreference.C0996a;
import com.huawei.hwdevicemgr.dmsdatatype.datatype.DeviceCommand;
import com.huawei.hwdevicemgr.p073a.C1023c;
import com.huawei.hwservicesmgr.remote.parser.IParser;
import com.huawei.hwservicesmgr.remote.utils.RemoteUtils;
import com.huawei.p190v.C2538c;
import com.huawei.ui.main.stories.lightcloud.constants.LightCloudConstants;
import com.sina.weibo.sdk.constant.WBConstants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class HWHeartRateManager extends C0628a implements IParser {
    private static final String FALSE = "false";
    private static final int GET_LEO_SUPPORT_PAIR_IN_HEALTH = 3;
    private static final int MESSAGECENTER = 1;
    private static final int MSG_CALIB_OPEN_TIMEOUT = 1;
    private static final int MSG_GAME_OPEN_TIMEOUT = 3;
    private static final int MSG_RELAX_OPEN_TIMEOUT = 2;
    private static final int MSG_STRESS_OPEN_TIMEOUT = 0;
    private static final int SAVE_HEALTH_SUPPORTED_DEVICE = 2;
    private static final int SET_SUPPORTED_DEVICE = 100;
    private static final int STRESS_SWITCH_OPEN_TIMEOUT_DELAY = 5000;
    private static final String TAG = "HWHeartRateManager";
    private static final String TRUE = "true";
    private static HWHeartRateManager instance;
    private static final Object lockObject = new Object();
    private static List<IBaseResponseCallback> mDeviceHeartRateCallbackList = new ArrayList();
    private static List<IBaseResponseCallback> mDeviceStressCallbackList = new ArrayList();
    private static List<IBaseResponseCallback> mSetHeartRateStatusCallbackList = new ArrayList();
    private static List<IBaseResponseCallback> mSetStressStatusCallbackList = new ArrayList();
    private List<Integer> getRRITime = new ArrayList();
    private C1023c hwDeviceMgr;
    private int loudspeakerMuteStatus = 0;
    private Handler mHandler = new Handler();
    private MyStressHandler mMyStressHandler;
    Runnable mRun = new 10(this);
    private HandlerThread mStressHandlerThread;
    private List<Integer> realRri = new ArrayList();
    private List<Integer> realTime = new ArrayList();
    private boolean receiverDataStatus;
    private List<Integer> rri = new ArrayList();
    private List<Integer> rritime = new ArrayList();
    private IBaseResponseCallback stressAlgorithmCallback = new 9(this);

    public static HWHeartRateManager getInstance() {
        HWHeartRateManager hWHeartRateManager;
        synchronized (lockObject) {
            if (instance == null) {
                instance = new HWHeartRateManager(BaseApplication.m2632b());
            }
            hWHeartRateManager = instance;
        }
        return hWHeartRateManager;
    }

    private HWHeartRateManager(Context context) {
        super(context);
        C2538c.m12677c(TAG, "enter HWHeartRateManager!");
        this.hwDeviceMgr = C1023c.m3920a(context);
        this.mStressHandlerThread = new HandlerThread(TAG);
        this.mStressHandlerThread.start();
        this.mMyStressHandler = new MyStressHandler(this.mStressHandlerThread.getLooper(), this);
    }

    public void setHeartRateReportStatus(JSONObject jSONObject, IBaseResponseCallback iBaseResponseCallback) throws JSONException {
        isLoudspeakerMuteOpenOrCloseHeartRate(2, jSONObject.getInt("status"), iBaseResponseCallback);
    }

    public void setStressReportStatus(JSONObject jSONObject, IBaseResponseCallback iBaseResponseCallback) throws JSONException {
        if (jSONObject != null) {
            C2538c.m12677c(TAG, "setStressReportStatus parameters = " + jSONObject.toString());
            JSONObject jSONObject2;
            switch (jSONObject.getInt("type")) {
                case 1:
                    processStressOpen(jSONObject, new 1(this, iBaseResponseCallback));
                    return;
                case 2:
                    C2538c.m12677c(TAG, "stress close");
                    jSONObject2 = new JSONObject();
                    jSONObject2.put("duration", jSONObject.getInt("duration"));
                    HWStressDataProvider.getInstance().getStressResult(2, jSONObject2, this.stressAlgorithmCallback);
                    setR1OpenOrCloseStress(4, null);
                    return;
                case 3:
                    processStressAbort(new 2(this, iBaseResponseCallback));
                    return;
                case 4:
                    processCalibOpen(jSONObject, new 3(this, iBaseResponseCallback));
                    return;
                case 5:
                    C2538c.m12677c(TAG, "stress calib close");
                    jSONObject2 = new JSONObject();
                    jSONObject2.put("duration", jSONObject.getInt("duration"));
                    HWStressDataProvider.getInstance().getStressResult(5, jSONObject2, this.stressAlgorithmCallback);
                    setR1OpenOrCloseStress(4, null);
                    return;
                case 6:
                    processCalibAbort(new 4(this, iBaseResponseCallback));
                    return;
                case 7:
                    C2538c.m12677c(TAG, "STRESS_CALIBRATION_CHECK");
                    getStressCalibFlag(this.stressAlgorithmCallback);
                    return;
                case 8:
                    C2538c.m12677c(TAG, "STRESS_CALIBRATION_RESET");
                    HWStressDataProvider.getInstance().getStressResult(8, null, this.stressAlgorithmCallback);
                    return;
                case 9:
                    processRelaxOpen(jSONObject, new 5(this, iBaseResponseCallback));
                    return;
                case 10:
                    C2538c.m12677c(TAG, "RELAX_CLOSE");
                    jSONObject2 = new JSONObject();
                    jSONObject2.put("duration", jSONObject.getInt("duration"));
                    HWStressDataProvider.getInstance().getStressResult(10, jSONObject2, this.stressAlgorithmCallback);
                    setR1OpenOrCloseStress(4, null);
                    return;
                case 11:
                    processRelaxAbort(new 6(this, iBaseResponseCallback));
                    return;
                case 12:
                    processGameOpen(jSONObject, new 7(this, iBaseResponseCallback));
                    return;
                case 13:
                    C2538c.m12677c(TAG, "GAME_CLOSE");
                    jSONObject2 = new JSONObject();
                    jSONObject2.put("duration", jSONObject.getInt("duration"));
                    jSONObject2.put(WBConstants.GAME_PARAMS_SCORE, jSONObject.getInt(WBConstants.GAME_PARAMS_SCORE));
                    HWStressDataProvider.getInstance().getStressResult(13, jSONObject2, this.stressAlgorithmCallback);
                    setR1OpenOrCloseStress(4, null);
                    return;
                case 14:
                    processGameAbort(new 8(this, iBaseResponseCallback));
                    return;
                case 15:
                    DeviceInfo currentConnectedDeviceInfo = getCurrentConnectedDeviceInfo();
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("type", 15);
                    if (currentConnectedDeviceInfo != null) {
                        C2538c.m12677c(TAG, "productType: " + currentConnectedDeviceInfo.getProductType());
                        DeviceCapability b = C1023c.m3920a(BaseApplication.m2632b()).m3993b();
                        if (b == null) {
                            C2538c.m12677c(TAG, "mDeviceCapability is null!");
                        }
                        if (11 == currentConnectedDeviceInfo.getProductType() && b != null && b.isSupportStressInfo()) {
                            C2538c.m12677c(TAG, "check connected success!");
                            jSONObject3.put("result_code", 0);
                        } else {
                            jSONObject3.put("result_code", 1);
                        }
                    } else {
                        jSONObject3.put("result_code", 1);
                    }
                    if (this.stressAlgorithmCallback != null) {
                        this.stressAlgorithmCallback.onResponse(0, jSONObject3.toString());
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        C2538c.m12677c(TAG, "setStressReportStatus parameters is null ");
    }

    private void processStressOpen(JSONObject jSONObject, IBaseResponseCallback iBaseResponseCallback) {
        C2538c.m12677c(TAG, "stress open");
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("max_duration", jSONObject.getInt("max_duration"));
        } catch (JSONException e) {
            C2538c.m12680e(TAG, "processStressOpen stress open fail," + e.getMessage());
        }
        HWStressDataProvider.getInstance().getStressResult(1, jSONObject2, null);
        setR1OpenOrCloseStress(3, iBaseResponseCallback);
        if (this.mMyStressHandler != null) {
            this.mMyStressHandler.sendEmptyMessageDelayed(0, 5000);
        }
    }

    private void processStressAbort(IBaseResponseCallback iBaseResponseCallback) {
        C2538c.m12677c(TAG, "stress abort");
        HWStressDataProvider.getInstance().getStressResult(3, null, null);
        setR1OpenOrCloseStress(4, iBaseResponseCallback);
    }

    private void processCalibOpen(JSONObject jSONObject, IBaseResponseCallback iBaseResponseCallback) {
        C2538c.m12677c(TAG, "stress calib open");
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(WBConstants.GAME_PARAMS_SCORE, jSONObject.getInt(WBConstants.GAME_PARAMS_SCORE));
            jSONObject2.put("max_duration", jSONObject.getInt("max_duration"));
        } catch (JSONException e) {
            C2538c.m12680e(TAG, "processCalibOpen calib open fail," + e.getMessage());
        }
        HWStressDataProvider.getInstance().getStressResult(4, jSONObject2, null);
        setR1OpenOrCloseStress(3, iBaseResponseCallback);
        if (this.mMyStressHandler != null) {
            this.mMyStressHandler.sendEmptyMessageDelayed(1, 5000);
        }
    }

    private void processCalibAbort(IBaseResponseCallback iBaseResponseCallback) {
        C2538c.m12677c(TAG, "stress calib abort");
        HWStressDataProvider.getInstance().getStressResult(6, null, null);
        setR1OpenOrCloseStress(4, iBaseResponseCallback);
    }

    private void processRelaxOpen(JSONObject jSONObject, IBaseResponseCallback iBaseResponseCallback) {
        C2538c.m12677c(TAG, "RELAX_OPEN");
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("max_duration", jSONObject.getInt("max_duration"));
        } catch (JSONException e) {
            C2538c.m12680e(TAG, "processRelaxOpen relax open fail, " + e.getMessage());
        }
        HWStressDataProvider.getInstance().getStressResult(9, jSONObject2, null);
        setR1OpenOrCloseStress(3, iBaseResponseCallback);
        if (this.mMyStressHandler != null) {
            this.mMyStressHandler.sendEmptyMessageDelayed(2, 5000);
        }
    }

    private void processRelaxAbort(IBaseResponseCallback iBaseResponseCallback) {
        C2538c.m12677c(TAG, "RELAX_ABORT");
        HWStressDataProvider.getInstance().getStressResult(11, null, null);
        setR1OpenOrCloseStress(4, iBaseResponseCallback);
    }

    private void processGameOpen(JSONObject jSONObject, IBaseResponseCallback iBaseResponseCallback) {
        C2538c.m12677c(TAG, "GAME_OPEN");
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("max_duration", jSONObject.getInt("max_duration"));
        } catch (JSONException e) {
            C2538c.m12680e(TAG, "processGameOpen game open fail," + e.getMessage());
        }
        HWStressDataProvider.getInstance().getStressResult(12, jSONObject2, null);
        setR1OpenOrCloseStress(3, iBaseResponseCallback);
        if (this.mMyStressHandler != null) {
            this.mMyStressHandler.sendEmptyMessageDelayed(3, 5000);
        }
    }

    private void processGameAbort(IBaseResponseCallback iBaseResponseCallback) {
        C2538c.m12677c(TAG, "GAME_ABORT");
        HWStressDataProvider.getInstance().getStressResult(14, null, null);
        setR1OpenOrCloseStress(4, iBaseResponseCallback);
    }

    private void getStressCalibFlag(IBaseResponseCallback iBaseResponseCallback) throws JSONException {
        int i;
        C2538c.m12677c(TAG, "getStressCalibFlag");
        String sharedPreference = getSharedPreference("calibration_flag");
        if (sharedPreference == null || sharedPreference.isEmpty()) {
            i = 1;
        } else {
            C2538c.m12677c(TAG, "calibrationFlagStr = " + sharedPreference);
            i = Integer.parseInt(sharedPreference);
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", 7);
        jSONObject.put("calibration_flag", i);
        C2538c.m12677c(TAG, "stress calib check ret data = " + jSONObject.toString());
        iBaseResponseCallback.onResponse(0, jSONObject.toString());
    }

    public void setHeartRateResponse(JSONObject jSONObject, IBaseResponseCallback iBaseResponseCallback) {
        C2538c.m12674b(TAG, "response of HeartRate info = ");
        synchronized (lockObject) {
            DeviceCommand deviceCommand = new DeviceCommand();
            deviceCommand.setServiceID(25);
            deviceCommand.setCommandID(3);
            try {
                String a = C0973a.m3507a((long) jSONObject.getInt("heart_rate_response"));
                String a2 = C0973a.m3506a(a.length() / 2);
                String a3 = C0973a.m3506a(127);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(a3);
                stringBuilder.append(a2);
                stringBuilder.append(a);
                deviceCommand.setDataLen(stringBuilder.length() / 2);
                deviceCommand.setDataContent(C0973a.m3512b(stringBuilder.toString()));
                this.hwDeviceMgr.m3995b(deviceCommand);
                iBaseResponseCallback.onResponse(100000, RemoteUtils.generateRetMap(LightCloudConstants.RESPONSE_RESULT_SUCCESS, "setHeartRateResponse"));
            } catch (JSONException e) {
                C2538c.m12680e(TAG, e.getMessage());
            }
        }
    }

    public void registerNotificationHRCallback(IBaseResponseCallback iBaseResponseCallback) {
        synchronized (mDeviceHeartRateCallbackList.getClass()) {
            if (mDeviceHeartRateCallbackList.contains(iBaseResponseCallback)) {
                return;
            }
            mDeviceHeartRateCallbackList.add(iBaseResponseCallback);
        }
    }

    public void unRegisterNotificationHRCallback(IBaseResponseCallback iBaseResponseCallback) {
        synchronized (mDeviceHeartRateCallbackList.getClass()) {
            if (mDeviceHeartRateCallbackList.contains(iBaseResponseCallback)) {
                mDeviceHeartRateCallbackList.remove(iBaseResponseCallback);
            }
        }
    }

    public void registerNotificationStressCallback(IBaseResponseCallback iBaseResponseCallback) {
        C2538c.m12677c(TAG, "registerNotificationStressCallback");
        synchronized (mDeviceStressCallbackList.getClass()) {
            if (mDeviceStressCallbackList.contains(iBaseResponseCallback)) {
                return;
            }
            mDeviceStressCallbackList.add(iBaseResponseCallback);
        }
    }

    public void getResult(byte[] bArr) {
        C2538c.m12677c(TAG, "getResult(): " + C0973a.m3509a(bArr));
        if (!w.a(bArr)) {
            String a = C0973a.m3509a(bArr);
            if (4 < a.length()) {
                try {
                    u a2 = new w().a(a.substring(4, a.length()));
                    List<s> list = a2.a;
                    List<u> list2 = a2.b;
                    List<s> list3;
                    switch (bArr[1]) {
                        case (byte) 1:
                            int i = 0;
                            for (s sVar : list) {
                                int parseInt;
                                switch (Integer.parseInt(sVar.a(), 16)) {
                                    case 127:
                                        parseInt = Integer.parseInt(sVar.b(), 16);
                                        break;
                                    default:
                                        parseInt = i;
                                        break;
                                }
                                i = parseInt;
                            }
                            synchronized (mSetHeartRateStatusCallbackList.getClass()) {
                                if (mSetHeartRateStatusCallbackList.size() != 0) {
                                    ((IBaseResponseCallback) mSetHeartRateStatusCallbackList.get(0)).onResponse(i, RemoteUtils.generateRetMap(Integer.valueOf(i), "setHeartRateReportStatus"));
                                    mSetHeartRateStatusCallbackList.remove(0);
                                }
                            }
                            synchronized (mSetStressStatusCallbackList.getClass()) {
                                if (mSetStressStatusCallbackList.size() != 0) {
                                    ((IBaseResponseCallback) mSetStressStatusCallbackList.get(0)).onResponse(0, Integer.valueOf(i));
                                    mSetStressStatusCallbackList.remove(0);
                                }
                            }
                            return;
                        case (byte) 3:
                            List arrayList = new ArrayList();
                            for (u uVar : list2) {
                                for (u a22 : uVar.b) {
                                    list3 = a22.a;
                                    HeartRateInfo heartRateInfo = new HeartRateInfo();
                                    for (s sVar2 : list3) {
                                        switch (Integer.parseInt(sVar2.a(), 16)) {
                                            case 3:
                                                heartRateInfo.setHr_info(Integer.parseInt(sVar2.b(), 16));
                                                break;
                                            case 4:
                                                heartRateInfo.setTime_info(Long.parseLong(sVar2.b(), 16) * 1000);
                                                break;
                                            default:
                                                break;
                                        }
                                    }
                                    sendRefreshHeartRateBroadcast(heartRateInfo);
                                    arrayList.add(heartRateInfo);
                                }
                            }
                            synchronized (mDeviceHeartRateCallbackList.getClass()) {
                                if (mDeviceHeartRateCallbackList.size() != 0) {
                                    ((IBaseResponseCallback) mDeviceHeartRateCallbackList.get(0)).onResponse(100000, RemoteUtils.generateRetMap(arrayList, "notificationHeartRateInfo"));
                                }
                            }
                            return;
                        case (byte) 4:
                            C2538c.m12677c(TAG, "orignal data = " + C0973a.m3509a(bArr));
                            for (u uVar2 : list2) {
                                for (u a222 : uVar2.b) {
                                    list3 = a222.a;
                                    HeartRateInfo heartRateInfo2 = new HeartRateInfo();
                                    for (s sVar22 : list3) {
                                        switch (Integer.parseInt(sVar22.a(), 16)) {
                                            case 1:
                                                heartRateInfo2.setTime_info(Long.parseLong(sVar22.b(), 16) * 1000);
                                                synchronized (this) {
                                                    this.getRRITime.add(Integer.valueOf((int) heartRateInfo2.getTime_info()));
                                                }
                                                break;
                                            case 4:
                                                heartRateInfo2.setHrri_info(Integer.parseInt(sVar22.b(), 16));
                                                synchronized (this) {
                                                    if (heartRateInfo2.getHrri_info() > 0) {
                                                        if (heartRateInfo2.getHrri_info() > 32768) {
                                                            this.rri.add(Integer.valueOf(heartRateInfo2.getHrri_info() - 32768));
                                                        } else {
                                                            this.rri.add(Integer.valueOf(heartRateInfo2.getHrri_info()));
                                                        }
                                                        this.rritime.add(Integer.valueOf(((Integer) this.rri.get(this.rri.size() - 1)).intValue() + (((Integer) this.getRRITime.get(this.getRRITime.size() - 1)).intValue() - ((Integer) this.getRRITime.get(0)).intValue())));
                                                        if (heartRateInfo2.getHrri_info() > 32768) {
                                                            this.realTime.add(Integer.valueOf(((Integer) this.rri.get(this.rri.size() - 1)).intValue() + (((Integer) this.getRRITime.get(this.getRRITime.size() - 1)).intValue() - ((Integer) this.getRRITime.get(0)).intValue())));
                                                            if (this.rritime.size() == 1) {
                                                                this.realRri.add(Integer.valueOf(heartRateInfo2.getHrri_info() - 32768));
                                                            }
                                                            if (this.rritime.size() > 1) {
                                                                this.realRri.add(Integer.valueOf(((Integer) this.rritime.get(this.rritime.size() - 1)).intValue() - ((Integer) this.rritime.get(this.rritime.size() - 2)).intValue()));
                                                            }
                                                        }
                                                    }
                                                }
                                                break;
                                            case 5:
                                                heartRateInfo2.setHrsqi_info(Integer.parseInt(sVar22.b(), 16));
                                                break;
                                            default:
                                                break;
                                        }
                                    }
                                }
                            }
                            return;
                        default:
                            return;
                    }
                } catch (t e) {
                    C2538c.m12680e(TAG, "接收命令错误 e=" + e.getMessage());
                    return;
                }
                C2538c.m12680e(TAG, "接收命令错误 e=" + e.getMessage());
                return;
            }
            C2538c.m12680e(TAG, "接收命令错误!");
        }
    }

    private void sendRefreshHeartRateBroadcast(HeartRateInfo heartRateInfo) {
        C2538c.m12677c(TAG, "enter sendRefreshHeartRateBroadcast");
        DeviceInfo currentDeviceInfo = RemoteUtils.getCurrentDeviceInfo(this.hwDeviceMgr);
        if (currentDeviceInfo != null && 11 == currentDeviceInfo.getProductType()) {
            this.receiverDataStatus = true;
            this.mHandler.removeCallbacks(this.mRun);
            this.mHandler.postDelayed(this.mRun, 3000);
            C2538c.m12677c(TAG, "sendUpdateHeartRateBroadcast.");
            Intent intent = new Intent();
            intent.setAction("com.huawei.bone.action.HEART_RATE_REFRESH");
            intent.putExtra("HEART_RATE", heartRateInfo.getHr_info());
            BaseApplication.m2632b().sendBroadcast(intent, C0976c.f1642a);
        }
    }

    public void isLoudspeakerMuteOpenOrCloseHeartRate(int i, int i2, IBaseResponseCallback iBaseResponseCallback) {
        C2538c.m12677c(TAG, "Enter isLoudspeakerMuteOpenOrCloseHeartRate isLoudspeakerMute = " + i + ";openOrClose = " + i2);
        DeviceInfo currentDeviceInfo = RemoteUtils.getCurrentDeviceInfo(this.hwDeviceMgr);
        if (i != 1 || !this.receiverDataStatus || this.loudspeakerMuteStatus != 2 || RemoteServiceMgr.getInstance().callbackIsNull()) {
            synchronized (lockObject) {
                DeviceCommand deviceCommand = new DeviceCommand();
                deviceCommand.setServiceID(25);
                deviceCommand.setCommandID(1);
                String a = C0973a.m3506a(i2);
                String e = C0973a.m3517e(1);
                String a2 = C0973a.m3506a(1);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(a2);
                stringBuilder.append(e);
                stringBuilder.append(a);
                if (currentDeviceInfo != null && 11 == currentDeviceInfo.getProductType()) {
                    String a3 = C0973a.m3506a(2);
                    a = C0973a.m3517e(1);
                    e = C0973a.m3506a(i);
                    stringBuilder.append(a3);
                    stringBuilder.append(a);
                    stringBuilder.append(e);
                }
                deviceCommand.setDataLen(stringBuilder.length() / 2);
                deviceCommand.setDataContent(C0973a.m3512b(stringBuilder.toString()));
                this.hwDeviceMgr.m3995b(deviceCommand);
                this.loudspeakerMuteStatus = i;
                synchronized (mSetHeartRateStatusCallbackList.getClass()) {
                    if (iBaseResponseCallback != null) {
                        mSetHeartRateStatusCallbackList.add(iBaseResponseCallback);
                    }
                }
            }
        }
    }

    public void sendHealthDataTohealth(JSONObject jSONObject, IBaseResponseCallback iBaseResponseCallback) {
        String string;
        JSONException e;
        HuaweiHealthData huaweiHealthData;
        C2538c.m12677c(TAG, "Enter unbindDevice");
        String str = "";
        try {
            string = jSONObject.getString("jsonString");
            try {
                C2538c.m12674b(TAG, "Enter sendHealthDataTohealth jsonString:" + string);
            } catch (JSONException e2) {
                e = e2;
                C2538c.m12680e(TAG, e.getMessage());
                huaweiHealthData = (HuaweiHealthData) new Gson().fromJson(string, HuaweiHealthData.class);
                if (huaweiHealthData != null) {
                    return;
                }
            }
        } catch (JSONException e3) {
            JSONException jSONException = e3;
            string = str;
            e = jSONException;
            C2538c.m12680e(TAG, e.getMessage());
            huaweiHealthData = (HuaweiHealthData) new Gson().fromJson(string, HuaweiHealthData.class);
            if (huaweiHealthData != null) {
            }
            return;
        }
        try {
            huaweiHealthData = (HuaweiHealthData) new Gson().fromJson(string, HuaweiHealthData.class);
        } catch (JsonSyntaxException e4) {
            C2538c.m12677c(TAG, "Enter JsonSyntaxException" + e4.getMessage());
            huaweiHealthData = null;
        }
        if (huaweiHealthData != null && 100 == huaweiHealthData.getCommandType()) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.huawei.bone", "com.huawei.bone.service.MessageCenterIntentService"));
            intent.putExtra("commandType", 2);
            intent.putExtra("content", huaweiHealthData.getData());
            BaseApplication.m2632b().startService(intent);
            if (iBaseResponseCallback != null) {
                iBaseResponseCallback.onResponse(0, RemoteUtils.generateRetMap(LightCloudConstants.RESPONSE_RESULT_SUCCESS, "sendHealthDataTohealth"));
            }
        }
    }

    public void unbindAllDeviceForV2(IBaseResponseCallback iBaseResponseCallback) {
        C2538c.m12674b(TAG, "Enter unbindAllDevice");
        List<DeviceInfo> a = C1023c.m3920a(BaseApplication.m2632b()).m3984a();
        if (a != null && a.size() > 0) {
            for (DeviceInfo deleteDevice : a) {
                deleteDevice(deleteDevice);
            }
            sendMessageToResetMessage();
        }
        if (iBaseResponseCallback != null) {
            iBaseResponseCallback.onResponse(0, RemoteUtils.generateRetMap(LightCloudConstants.RESPONSE_RESULT_SUCCESS, "unbindAllDeviceForV2"));
        }
    }

    public void unbindDevicesByTypes(JSONObject jSONObject, IBaseResponseCallback iBaseResponseCallback) {
        Object string;
        JSONException e;
        List arrayList;
        String[] split;
        List<DeviceInfo> a;
        C2538c.m12674b(TAG, "Enter unbindDevicesByTypes");
        String str = "";
        try {
            string = jSONObject.getString("typeList");
            try {
                C2538c.m12674b(TAG, "Enter unbindDevicesByTypes typeList:" + string);
            } catch (JSONException e2) {
                e = e2;
                C2538c.m12680e(TAG, e.getMessage());
                arrayList = new ArrayList();
                if (!TextUtils.isEmpty(string)) {
                    split = string.split(",");
                    if (split.length == 0) {
                        try {
                            for (String parseInt : split) {
                                arrayList.add(Integer.valueOf(Integer.parseInt(parseInt)));
                            }
                        } catch (NumberFormatException e3) {
                            C2538c.m12680e(TAG, "number exception,", e3.getMessage());
                        }
                    } else {
                        return;
                    }
                }
                a = C1023c.m3920a(BaseApplication.m2632b()).m3984a();
                for (DeviceInfo deleteDevice : a) {
                    deleteDevice(arrayList, deleteDevice);
                }
                sendMessageToResetMessage();
                if (iBaseResponseCallback == null) {
                    iBaseResponseCallback.onResponse(0, RemoteUtils.generateRetMap(LightCloudConstants.RESPONSE_RESULT_SUCCESS, "unbindDevicesByTypes"));
                }
            }
        } catch (JSONException e4) {
            JSONException jSONException = e4;
            string = str;
            e = jSONException;
            C2538c.m12680e(TAG, e.getMessage());
            arrayList = new ArrayList();
            if (TextUtils.isEmpty(string)) {
                split = string.split(",");
                if (split.length == 0) {
                    while (r0 < r4) {
                        arrayList.add(Integer.valueOf(Integer.parseInt(parseInt)));
                    }
                } else {
                    return;
                }
            }
            a = C1023c.m3920a(BaseApplication.m2632b()).m3984a();
            while (r3.hasNext()) {
                deleteDevice(arrayList, deleteDevice);
            }
            sendMessageToResetMessage();
            if (iBaseResponseCallback == null) {
                iBaseResponseCallback.onResponse(0, RemoteUtils.generateRetMap(LightCloudConstants.RESPONSE_RESULT_SUCCESS, "unbindDevicesByTypes"));
            }
        }
        arrayList = new ArrayList();
        if (TextUtils.isEmpty(string)) {
            split = string.split(",");
            if (split.length == 0) {
                while (r0 < r4) {
                    arrayList.add(Integer.valueOf(Integer.parseInt(parseInt)));
                }
            } else {
                return;
            }
        }
        a = C1023c.m3920a(BaseApplication.m2632b()).m3984a();
        if (a != null && a.size() > 0) {
            while (r3.hasNext()) {
                deleteDevice(arrayList, deleteDevice);
            }
            sendMessageToResetMessage();
        }
        if (iBaseResponseCallback == null) {
            iBaseResponseCallback.onResponse(0, RemoteUtils.generateRetMap(LightCloudConstants.RESPONSE_RESULT_SUCCESS, "unbindDevicesByTypes"));
        }
    }

    private void sendMessageToResetMessage() {
        Intent intent = new Intent();
        intent.setAction("com.huawei.delete.device.clearmessage");
        BaseApplication.m2632b().sendBroadcast(intent, C0976c.f1642a);
    }

    private void deleteDevice(DeviceInfo deviceInfo) {
        C2538c.m12674b(TAG, "Enter deleteDevice");
        if (deviceInfo == null) {
            C2538c.m12674b(TAG, "deleteDevice is null");
        } else if (2 != deviceInfo.getDeviceProtocol()) {
            C2538c.m12674b(TAG, "is not v2 device,so not need unbind!");
        } else {
            List<DeviceInfo> a = C1023c.m3920a(BaseApplication.m2632b()).m3984a();
            if (a != null && a.size() > 0) {
                C2538c.m12674b(TAG, "deleteDevice delete mac = " + deviceInfo.getDeviceIdentify());
                int i = -1;
                for (DeviceInfo deviceInfo2 : a) {
                    int indexOf;
                    C2538c.m12674b(TAG, "deleteDevice list mac = " + deviceInfo2.getDeviceIdentify());
                    if (deviceInfo2.getDeviceIdentify().equals(deviceInfo.getDeviceIdentify())) {
                        indexOf = a.indexOf(deviceInfo2);
                    } else {
                        indexOf = i;
                    }
                    i = indexOf;
                }
                C2538c.m12674b(TAG, "deleteDevice() id = " + i);
                if (-1 != i) {
                    a.remove(i);
                    C1023c.m3920a(BaseApplication.m2632b()).m3991a((List) a, true);
                }
            }
        }
    }

    private void deleteDevice(List<Integer> list, DeviceInfo deviceInfo) {
        C2538c.m12674b(TAG, "Enter deleteDevice");
        if (deviceInfo == null) {
            C2538c.m12674b(TAG, "deleteDevice is null");
        } else if (isUnbindDevice(deviceInfo.getProductType(), list)) {
            List<DeviceInfo> a = C1023c.m3920a(BaseApplication.m2632b()).m3984a();
            if (a != null && a.size() > 0) {
                C2538c.m12674b(TAG, "deleteDevice delete mac = " + deviceInfo.getDeviceIdentify());
                int i = -1;
                for (DeviceInfo deviceInfo2 : a) {
                    int indexOf;
                    C2538c.m12674b(TAG, "deleteDevice list mac = " + deviceInfo2.getDeviceIdentify());
                    if (deviceInfo2.getDeviceIdentify().equals(deviceInfo.getDeviceIdentify())) {
                        indexOf = a.indexOf(deviceInfo2);
                    } else {
                        indexOf = i;
                    }
                    i = indexOf;
                }
                C2538c.m12674b(TAG, "deleteDevice() id = " + i);
                if (-1 != i) {
                    a.remove(i);
                    C1023c.m3920a(BaseApplication.m2632b()).m3991a((List) a, true);
                }
            }
        } else {
            C2538c.m12674b(TAG, "is not unbind device,so not need unbind!");
        }
    }

    private boolean isUnbindDevice(int i, List<Integer> list) {
        for (Integer intValue : list) {
            if (i == intValue.intValue()) {
                return true;
            }
        }
        return false;
    }

    public void getDeviceList(IBaseResponseCallback iBaseResponseCallback) {
        C2538c.m12674b(TAG, "Enter getDeviceList");
        Gson gson = new Gson();
        if (iBaseResponseCallback != null) {
            iBaseResponseCallback.onResponse(0, RemoteUtils.generateRetMap(gson.toJson(getDeviceInfoList()), "getDeviceList"));
        }
    }

    private static List<com.huawei.hwservicesmgr.datetype.DeviceInfo> getDeviceInfoList() {
        List<DeviceInfo> a = C1023c.m3920a(BaseApplication.m2632b()).m3984a();
        List<com.huawei.hwservicesmgr.datetype.DeviceInfo> arrayList = new ArrayList();
        arrayList.clear();
        for (DeviceInfo createDeviceInfo : a) {
            arrayList.add(createDeviceInfo(createDeviceInfo));
        }
        C2538c.m12677c(TAG, "return getUsedDeviceList() with deviceInfoListBak size = " + arrayList.size());
        return arrayList;
    }

    private static com.huawei.hwservicesmgr.datetype.DeviceInfo createDeviceInfo(DeviceInfo deviceInfo) {
        com.huawei.hwservicesmgr.datetype.DeviceInfo deviceInfo2 = new com.huawei.hwservicesmgr.datetype.DeviceInfo();
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

    protected Integer getModuleId() {
        return Integer.valueOf(25);
    }

    public void setR1OpenOrCloseStress(int i, IBaseResponseCallback iBaseResponseCallback) {
        C2538c.m12677c(TAG, "isR1OpenOrCloseStress  openOrClose = " + i);
        if (i == 4) {
            synchronized (this) {
                int[] listToArryOfRRI = listToArryOfRRI(this.realRri);
                int[] listToArryOfRRI2 = listToArryOfRRI(this.realTime);
                C2538c.m12677c(TAG, "arrayRri size = " + listToArryOfRRI.length + " , arraytime size = " + listToArryOfRRI2.length);
                HWStressDataProvider.getInstance().processRRData(listToArryOfRRI, listToArryOfRRI2);
            }
        }
        synchronized (this) {
            C2538c.m12677c(TAG, "clear rri list");
            this.rri.clear();
            this.rritime.clear();
            this.getRRITime.clear();
            this.realRri.clear();
            this.realTime.clear();
        }
        isLoudspeakerMuteOpenOrCloseHeartRate(2, i, null);
        synchronized (mSetStressStatusCallbackList.getClass()) {
            if (iBaseResponseCallback != null) {
                mSetStressStatusCallbackList.add(iBaseResponseCallback);
            }
        }
    }

    public void getWearData(JSONObject jSONObject, IBaseResponseCallback iBaseResponseCallback) {
        String string;
        JSONException e;
        Object obj;
        C2538c.m12674b(TAG, "Enter getWearData");
        int i = -1;
        try {
            i = jSONObject.getInt("commandType");
            C2538c.m12674b(TAG, "Enter getWearData jsonString:" + i);
        } catch (JSONException e2) {
            C2538c.m12680e(TAG, e2.getMessage());
        }
        if (i > 0) {
            switch (i) {
                case 1:
                    Intent intent = new Intent();
                    intent.setComponent(new ComponentName("com.huawei.bone", "com.huawei.bone.service.MessageCenterIntentService"));
                    intent.putExtra("commandType", i);
                    BaseApplication.m2632b().startService(intent);
                    if (iBaseResponseCallback != null) {
                        iBaseResponseCallback.onResponse(0, RemoteUtils.generateRetMap(LightCloudConstants.RESPONSE_RESULT_SUCCESS, "getWearData"));
                        return;
                    }
                    return;
                case 3:
                    String str = "";
                    try {
                        string = jSONObject.getString("leomac");
                        try {
                            C2538c.m12674b(TAG, "Enter getWearData leomac:" + string);
                        } catch (JSONException e3) {
                            e = e3;
                            C2538c.m12680e(TAG, e.getMessage());
                            string = C0996a.m3612a(BaseApplication.m2632b(), String.valueOf(20009), string);
                            C2538c.m12677c(TAG, "Enter getWearData isSupport:" + string);
                            str = "";
                            if (TRUE.equals(string)) {
                                obj = TRUE;
                            } else {
                                obj = FALSE;
                            }
                            if (iBaseResponseCallback == null) {
                                iBaseResponseCallback.onResponse(0, RemoteUtils.generateRetMap(obj, "getWearData"));
                                return;
                            }
                            return;
                        }
                    } catch (JSONException e22) {
                        JSONException jSONException = e22;
                        string = str;
                        e = jSONException;
                        C2538c.m12680e(TAG, e.getMessage());
                        string = C0996a.m3612a(BaseApplication.m2632b(), String.valueOf(20009), string);
                        C2538c.m12677c(TAG, "Enter getWearData isSupport:" + string);
                        str = "";
                        if (TRUE.equals(string)) {
                            obj = FALSE;
                        } else {
                            obj = TRUE;
                        }
                        if (iBaseResponseCallback == null) {
                            iBaseResponseCallback.onResponse(0, RemoteUtils.generateRetMap(obj, "getWearData"));
                            return;
                        }
                        return;
                    }
                    string = C0996a.m3612a(BaseApplication.m2632b(), String.valueOf(20009), string);
                    C2538c.m12677c(TAG, "Enter getWearData isSupport:" + string);
                    str = "";
                    if (TRUE.equals(string)) {
                        obj = TRUE;
                    } else {
                        obj = FALSE;
                    }
                    if (iBaseResponseCallback == null) {
                        iBaseResponseCallback.onResponse(0, RemoteUtils.generateRetMap(obj, "getWearData"));
                        return;
                    }
                    return;
                default:
                    C2538c.m12677c(TAG, "Enter getWearData default");
                    return;
            }
        }
    }

    private int[] listToArryOfRRI(List list) {
        int[] iArr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            iArr[i] = ((Integer) list.get(i)).intValue();
        }
        return iArr;
    }

    private DeviceInfo getCurrentConnectedDeviceInfo() {
        C2538c.m12677c(TAG, "getCurrentConnectedDeviceInfo() enter");
        C1023c a = C1023c.m3920a(BaseApplication.m2632b());
        if (a == null) {
            return null;
        }
        List<DeviceInfo> a2 = a.m3984a();
        if (a2.size() != 0) {
            C2538c.m12677c(TAG, "getCurrentConnectedDeviceInfo() deviceInfoList.size() = " + a2.size());
            for (DeviceInfo deviceInfo : a2) {
                if (1 == deviceInfo.getDeviceActiveState() && 2 == deviceInfo.getDeviceConnectState()) {
                    return deviceInfo;
                }
            }
            C2538c.m12680e(TAG, "getCurrentConnectedDeviceInfo() deviceInfo's ActiveState not DeviceActiveState.DEVICE_ACTIVE_ENABLE");
            return null;
        }
        C2538c.m12680e(TAG, "getCurrentConnectedDeviceInfo() deviceInfoList is null");
        return null;
    }

    protected void onDestroy() {
        C2538c.m12677c(TAG, "onDestroy");
        super.onDestroy();
        if (this.mStressHandlerThread != null) {
            this.mStressHandlerThread.quit();
            this.mStressHandlerThread = null;
        }
        synchronized (lockObject) {
            C2538c.m12677c(TAG, "install  null");
            instance = null;
        }
    }
}
