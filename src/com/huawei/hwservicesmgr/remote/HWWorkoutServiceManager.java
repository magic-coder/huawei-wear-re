package com.huawei.hwservicesmgr.remote;

import android.content.Context;
import com.huawei.datatype.DataHeader;
import com.huawei.datatype.OperatorStatus;
import com.huawei.datatype.PaceIndexStruct;
import com.huawei.datatype.SportReminder;
import com.huawei.datatype.SportType;
import com.huawei.datatype.WorkRecordIndexPaceMapList;
import com.huawei.datatype.WorkoutDataInfo;
import com.huawei.datatype.WorkoutDataStruct;
import com.huawei.datatype.WorkoutRealTimeInfo;
import com.huawei.datatype.WorkoutRecord;
import com.huawei.datatype.WorkoutRecordPaceMap;
import com.huawei.datatype.WorkoutRecordSpeechPlay;
import com.huawei.datatype.WorkoutRecordStatistic;
import com.huawei.datatype.WorkoutRecordStruct;
import com.huawei.hwbasemgr.C0628a;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.hwcommonmodel.datatypes.s;
import com.huawei.hwcommonmodel.datatypes.t;
import com.huawei.hwcommonmodel.datatypes.u;
import com.huawei.hwcommonmodel.datatypes.w;
import com.huawei.hwdevicemgr.dmsdatatype.datatype.DeviceCommand;
import com.huawei.hwdevicemgr.p073a.C1023c;
import com.huawei.hwservicesmgr.remote.parser.IParser;
import com.huawei.hwservicesmgr.remote.utils.RemoteUtils;
import com.huawei.p190v.C2538c;
import com.huawei.ui.main.stories.lightcloud.constants.LightCloudConstants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class HWWorkoutServiceManager extends C0628a implements IParser {
    private static final String TAG = "HWWorkoutServiceManager";
    private static List<IBaseResponseCallback> getNotificationGetWorkoutRecordStatisticCallbackList = new ArrayList();
    private static List<IBaseResponseCallback> getNotificationSportReminderCallbackList = new ArrayList();
    private static List<IBaseResponseCallback> getNotificationStatusCallbackList = new ArrayList();
    private static List<IBaseResponseCallback> getNotificationWorkoutRealTimeInfoCallbackList = new ArrayList();
    private static List<IBaseResponseCallback> getNotificationWorkoutRecordSpeechPlayCallbackList = new ArrayList();
    private static List<IBaseResponseCallback> getOperatorCallbackList = new ArrayList();
    private static List<IBaseResponseCallback> getWorkoutDataCallbackList = new ArrayList();
    private static List<IBaseResponseCallback> getWorkoutOperatorRealtimeDataCallbackList = new ArrayList();
    private static List<IBaseResponseCallback> getWorkoutRealTimeInfoCallbackList = new ArrayList();
    private static List<IBaseResponseCallback> getWorkoutRecordCallbackList = new ArrayList();
    private static List<IBaseResponseCallback> getWorkoutRecordStatisticCallbackList = new ArrayList();
    private static HWWorkoutServiceManager instance;
    private static List<IBaseResponseCallback> mGetWorkoutRecordPaceMapListCallbackList = new ArrayList();
    private static List<IBaseResponseCallback> setOperatorCallbackList = new ArrayList();
    private C1023c hwDeviceMgr;
    private final Object lockObject = new Object();
    private Context mContext;

    public static HWWorkoutServiceManager getInstance() {
        if (instance == null) {
            instance = new HWWorkoutServiceManager(BaseApplication.m2632b());
        }
        return instance;
    }

    private HWWorkoutServiceManager(Context context) {
        super(context);
        this.mContext = context;
        C1023c c1023c = this.hwDeviceMgr;
        this.hwDeviceMgr = C1023c.m3920a(this.mContext);
    }

    public void setOperator(JSONObject jSONObject, IBaseResponseCallback iBaseResponseCallback) throws JSONException {
        synchronized (this.lockObject) {
            DeviceInfo currentDeviceInfo = RemoteUtils.getCurrentDeviceInfo(this.hwDeviceMgr);
            if (currentDeviceInfo == null || currentDeviceInfo.getDeviceConnectState() != 2) {
                C2538c.m12677c(TAG, "no device is connected.");
                iBaseResponseCallback.onResponse(0, RemoteUtils.generateRetMap(Integer.valueOf(100001), "no device is connected."));
                return;
            }
            int i;
            int i2;
            int i3;
            int length;
            String e;
            String e2;
            StringBuilder stringBuilder;
            C2538c.m12677c(TAG, "setOperator enter");
            DeviceCommand deviceCommand = new DeviceCommand();
            deviceCommand.setServiceID(23);
            deviceCommand.setCommandID(1);
            String a = C0973a.m3506a(129);
            String a2 = C0973a.m3506a(jSONObject.getInt("sport_type"));
            String e3 = C0973a.m3517e(a2.length() / 2);
            String a3 = C0973a.m3506a(3);
            int i4 = SportType.SPORT_TYPE_RUN;
            if (jSONObject.has("workout_type")) {
                i4 = jSONObject.getInt("workout_type");
            }
            String a4 = C0973a.m3506a(transSportType(i4));
            String e4 = C0973a.m3517e(a4.length() / 2);
            String a5 = C0973a.m3506a(5);
            i4 = 0;
            if (jSONObject.has("run_plan_date")) {
                i4 = (int) (jSONObject.getLong("run_plan_date") / 1000);
            }
            String str = C0973a.m3506a(i4 >> 24) + C0973a.m3506a((i4 >> 16) & 255) + C0973a.m3506a((i4 >> 8) & 255) + C0973a.m3506a(i4 & 255);
            String e5 = C0973a.m3517e(str.length() / 2);
            String a6 = C0973a.m3506a(4);
            String a7 = C0973a.m3506a(jSONObject.getInt("operator_type"));
            String e6 = C0973a.m3517e(a7.length() / 2);
            String a8 = C0973a.m3506a(2);
            i4 = (int) (jSONObject.getLong("operation_time") / 1000);
            String str2 = C0973a.m3506a(i4 >> 24) + C0973a.m3506a((i4 >> 16) & 255) + C0973a.m3506a((i4 >> 8) & 255) + C0973a.m3506a(i4 & 255);
            String e7 = C0973a.m3517e(str2.length() / 2);
            String a9 = C0973a.m3506a(6);
            String a10 = C0973a.m3506a(135);
            i4 = 0;
            if (jSONObject.has("distance")) {
                i = jSONObject.getInt("distance");
            } else {
                i = 0;
            }
            String a11 = C0973a.m3507a((long) i);
            String e8 = C0973a.m3517e(a11.length() / 2);
            String a12 = C0973a.m3506a(8);
            if (jSONObject.has("calorie")) {
                i2 = jSONObject.getInt("calorie");
            } else {
                i2 = 0;
            }
            String a13 = C0973a.m3507a((long) i2);
            String e9 = C0973a.m3517e(a13.length() / 2);
            String a14 = C0973a.m3506a(9);
            if (jSONObject.has("duration")) {
                i3 = jSONObject.getInt("duration");
            } else {
                i3 = 0;
            }
            String a15 = C0973a.m3507a((long) i3);
            String e10 = C0973a.m3517e(a15.length() / 2);
            String a16 = C0973a.m3506a(10);
            if (!(i == 0 && i2 == 0 && i3 == 0)) {
                if (i != 0) {
                    i4 = 0 + ((a12.length() + e8.length()) + a11.length());
                }
                if (i2 != 0) {
                    i4 += (a14.length() + e9.length()) + a13.length();
                }
                if (i3 != 0) {
                    length = i4 + ((a16.length() + e10.length()) + a15.length());
                    e = C0973a.m3517e(length / 2);
                    i4 = ((((((((((a8.length() + e6.length()) + a7.length()) + a3.length()) + e3.length()) + a2.length()) + a5.length()) + e4.length()) + a4.length()) + a9.length()) + e7.length()) + str2.length();
                    if (length == 0) {
                        length = i4 + ((length + a10.length()) + e.length());
                    } else {
                        length = i4;
                    }
                    if (2 != jSONObject.getInt("sport_type")) {
                        e2 = C0973a.m3517e((((a6.length() + length) + e5.length()) + str.length()) / 2);
                    } else {
                        e2 = C0973a.m3517e(length / 2);
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(a);
                    stringBuilder.append(e2);
                    stringBuilder.append(a8);
                    stringBuilder.append(e6);
                    stringBuilder.append(a7);
                    stringBuilder.append(a3);
                    stringBuilder.append(e3);
                    stringBuilder.append(a2);
                    if (2 == jSONObject.getInt("sport_type")) {
                        stringBuilder.append(a6);
                        stringBuilder.append(e5);
                        stringBuilder.append(str);
                    }
                    stringBuilder.append(a5);
                    stringBuilder.append(e4);
                    stringBuilder.append(a4);
                    stringBuilder.append(a9);
                    stringBuilder.append(e7);
                    stringBuilder.append(str2);
                    if (length != 0) {
                        stringBuilder.append(a10);
                        stringBuilder.append(e);
                        if (i != 0) {
                            stringBuilder.append(a12);
                            stringBuilder.append(e8);
                            stringBuilder.append(a11);
                        }
                        if (i2 != 0) {
                            stringBuilder.append(a14);
                            stringBuilder.append(e9);
                            stringBuilder.append(a13);
                        }
                        if (i3 != 0) {
                            stringBuilder.append(a16);
                            stringBuilder.append(e10);
                            stringBuilder.append(a15);
                        }
                    }
                    deviceCommand.setDataLen(stringBuilder.length() / 2);
                    deviceCommand.setDataContent(C0973a.m3512b(stringBuilder.toString()));
                    this.hwDeviceMgr.m3995b(deviceCommand);
                    synchronized (getSetOperatorCallbackList()) {
                        setOperatorCallbackList.add(iBaseResponseCallback);
                    }
                }
            }
            length = i4;
            e = C0973a.m3517e(length / 2);
            i4 = ((((((((((a8.length() + e6.length()) + a7.length()) + a3.length()) + e3.length()) + a2.length()) + a5.length()) + e4.length()) + a4.length()) + a9.length()) + e7.length()) + str2.length();
            if (length == 0) {
                length = i4;
            } else {
                length = i4 + ((length + a10.length()) + e.length());
            }
            if (2 != jSONObject.getInt("sport_type")) {
                e2 = C0973a.m3517e(length / 2);
            } else {
                e2 = C0973a.m3517e((((a6.length() + length) + e5.length()) + str.length()) / 2);
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append(a);
            stringBuilder.append(e2);
            stringBuilder.append(a8);
            stringBuilder.append(e6);
            stringBuilder.append(a7);
            stringBuilder.append(a3);
            stringBuilder.append(e3);
            stringBuilder.append(a2);
            if (2 == jSONObject.getInt("sport_type")) {
                stringBuilder.append(a6);
                stringBuilder.append(e5);
                stringBuilder.append(str);
            }
            stringBuilder.append(a5);
            stringBuilder.append(e4);
            stringBuilder.append(a4);
            stringBuilder.append(a9);
            stringBuilder.append(e7);
            stringBuilder.append(str2);
            if (length != 0) {
                stringBuilder.append(a10);
                stringBuilder.append(e);
                if (i != 0) {
                    stringBuilder.append(a12);
                    stringBuilder.append(e8);
                    stringBuilder.append(a11);
                }
                if (i2 != 0) {
                    stringBuilder.append(a14);
                    stringBuilder.append(e9);
                    stringBuilder.append(a13);
                }
                if (i3 != 0) {
                    stringBuilder.append(a16);
                    stringBuilder.append(e10);
                    stringBuilder.append(a15);
                }
            }
            deviceCommand.setDataLen(stringBuilder.length() / 2);
            deviceCommand.setDataContent(C0973a.m3512b(stringBuilder.toString()));
            this.hwDeviceMgr.m3995b(deviceCommand);
            synchronized (getSetOperatorCallbackList()) {
                setOperatorCallbackList.add(iBaseResponseCallback);
            }
        }
    }

    public void getOperator(IBaseResponseCallback iBaseResponseCallback) {
        synchronized (this.lockObject) {
            C2538c.m12677c(TAG, "getOperator called");
            DeviceInfo currentDeviceInfo = RemoteUtils.getCurrentDeviceInfo(this.hwDeviceMgr);
            if (currentDeviceInfo == null || currentDeviceInfo.getDeviceConnectState() != 2) {
                C2538c.m12677c(TAG, "no device is connected.");
                iBaseResponseCallback.onResponse(0, RemoteUtils.generateRetMap(Integer.valueOf(100001), "no device is connected."));
                return;
            }
            DeviceCommand deviceCommand = new DeviceCommand();
            deviceCommand.setServiceID(23);
            deviceCommand.setCommandID(3);
            String e = C0973a.m3517e(0);
            String a = C0973a.m3506a(129);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(a);
            stringBuilder.append(e);
            deviceCommand.setDataLen(stringBuilder.length() / 2);
            deviceCommand.setDataContent(C0973a.m3512b(stringBuilder.toString()));
            this.hwDeviceMgr.m3995b(deviceCommand);
            synchronized (getGetOperatorCallbackList()) {
                getOperatorCallbackList.add(iBaseResponseCallback);
            }
        }
    }

    public void getWorkoutRealTimeInfo(JSONObject jSONObject, IBaseResponseCallback iBaseResponseCallback) throws JSONException {
        synchronized (this.lockObject) {
            DeviceCommand deviceCommand = new DeviceCommand();
            deviceCommand.setServiceID(23);
            deviceCommand.setCommandID(4);
            String e = C0973a.m3517e(3);
            String a = C0973a.m3506a(1);
            String a2 = C0973a.m3506a(jSONObject.getInt("sport_type"));
            String e2 = C0973a.m3517e(a2.length() / 2);
            String a3 = C0973a.m3506a(2);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(a);
            stringBuilder.append(e);
            stringBuilder.append(a3);
            stringBuilder.append(e2);
            stringBuilder.append(a2);
            deviceCommand.setDataLen(stringBuilder.length() / 2);
            deviceCommand.setDataContent(C0973a.m3512b(stringBuilder.toString()));
            this.hwDeviceMgr.m3995b(deviceCommand);
            synchronized (getGetWorkoutRealTimeInfoCallbackList()) {
                getWorkoutRealTimeInfoCallbackList.add(iBaseResponseCallback);
            }
        }
    }

    public void getWorkoutRecord(JSONObject jSONObject, IBaseResponseCallback iBaseResponseCallback) throws JSONException {
        synchronized (this.lockObject) {
            DeviceCommand deviceCommand = new DeviceCommand();
            deviceCommand.setServiceID(23);
            deviceCommand.setCommandID(7);
            String e = C0973a.m3517e(12);
            String a = C0973a.m3506a(129);
            int i = (int) (jSONObject.getLong("startTime") / 1000);
            String str = C0973a.m3506a(i >> 24) + C0973a.m3506a((i >> 16) & 255) + C0973a.m3506a((i >> 8) & 255) + C0973a.m3506a(i & 255);
            String e2 = C0973a.m3517e(str.length() / 2);
            String a2 = C0973a.m3506a(3);
            int i2 = (int) (jSONObject.getLong("endTime") / 1000);
            String str2 = C0973a.m3506a(i2 >> 24) + C0973a.m3506a((i2 >> 16) & 255) + C0973a.m3506a((i2 >> 8) & 255) + C0973a.m3506a(i2 & 255);
            String e3 = C0973a.m3517e(str2.length() / 2);
            String a3 = C0973a.m3506a(4);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(a);
            stringBuilder.append(e);
            stringBuilder.append(a2);
            stringBuilder.append(e2);
            stringBuilder.append(str);
            stringBuilder.append(a3);
            stringBuilder.append(e3);
            stringBuilder.append(str2);
            deviceCommand.setDataLen(stringBuilder.length() / 2);
            deviceCommand.setDataContent(C0973a.m3512b(stringBuilder.toString()));
            this.hwDeviceMgr.m3995b(deviceCommand);
            synchronized (getGetWorkoutRecordCallbackList()) {
                getWorkoutRecordCallbackList.add(iBaseResponseCallback);
            }
        }
    }

    public void getWorkoutRecordStatistic(JSONObject jSONObject, IBaseResponseCallback iBaseResponseCallback) throws JSONException {
        synchronized (this.lockObject) {
            DeviceCommand deviceCommand = new DeviceCommand();
            deviceCommand.setServiceID(23);
            deviceCommand.setCommandID(8);
            String e = C0973a.m3517e(4);
            String a = C0973a.m3506a(129);
            C2538c.m12677c(TAG, "get getWorkoutRecordStatistic id ");
            String b = C0973a.m3510b(jSONObject.getInt("id"));
            String e2 = C0973a.m3517e(b.length() / 2);
            String a2 = C0973a.m3506a(2);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(a);
            stringBuilder.append(e);
            stringBuilder.append(a2);
            stringBuilder.append(e2);
            stringBuilder.append(b);
            deviceCommand.setDataLen(stringBuilder.length() / 2);
            deviceCommand.setDataContent(C0973a.m3512b(stringBuilder.toString()));
            this.hwDeviceMgr.m3995b(deviceCommand);
            synchronized (getGetWorkoutRecordStatisticCallbackList()) {
                getWorkoutRecordStatisticCallbackList.add(iBaseResponseCallback);
            }
        }
    }

    public void getWorkoutData(JSONObject jSONObject, IBaseResponseCallback iBaseResponseCallback) throws JSONException {
        synchronized (this.lockObject) {
            DeviceCommand deviceCommand = new DeviceCommand();
            deviceCommand.setServiceID(23);
            deviceCommand.setCommandID(10);
            String e = C0973a.m3517e(8);
            String a = C0973a.m3506a(129);
            C2538c.m12677c(TAG, "get getWorkoutData id ");
            C2538c.m12677c(TAG, "the parameters are " + jSONObject.toString());
            String b = C0973a.m3510b(jSONObject.getInt("workout_record_id"));
            String e2 = C0973a.m3517e(b.length() / 2);
            String a2 = C0973a.m3506a(2);
            String b2 = C0973a.m3510b(jSONObject.getInt("workout_data_index"));
            String e3 = C0973a.m3517e(b.length() / 2);
            String a3 = C0973a.m3506a(3);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(a);
            stringBuilder.append(e);
            stringBuilder.append(a2);
            stringBuilder.append(e2);
            stringBuilder.append(b);
            stringBuilder.append(a3);
            stringBuilder.append(e3);
            stringBuilder.append(b2);
            deviceCommand.setDataLen(stringBuilder.length() / 2);
            deviceCommand.setDataContent(C0973a.m3512b(stringBuilder.toString()));
            this.hwDeviceMgr.m3995b(deviceCommand);
            synchronized (getGetWorkoutDataCallbackList()) {
                getWorkoutDataCallbackList.add(iBaseResponseCallback);
            }
        }
    }

    public void workoutOperateRealtimeData(JSONObject jSONObject, IBaseResponseCallback iBaseResponseCallback) throws JSONException {
        C2538c.m12677c(TAG, "setRealTimeData enter");
        synchronized (this.lockObject) {
            String e;
            DeviceCommand deviceCommand = new DeviceCommand();
            deviceCommand.setServiceID(23);
            deviceCommand.setCommandID(11);
            String a = C0973a.m3506a(129);
            if (jSONObject.has("pace")) {
                e = C0973a.m3517e(26);
            } else {
                e = C0973a.m3517e(22);
            }
            String a2 = C0973a.m3507a((long) jSONObject.getInt("exercise_duration"));
            String e2 = C0973a.m3517e(a2.length() / 2);
            String a3 = C0973a.m3506a(2);
            String a4 = C0973a.m3507a((long) (jSONObject.getInt("distance") * 10));
            String e3 = C0973a.m3517e(a4.length() / 2);
            String a5 = C0973a.m3506a(3);
            String a6 = C0973a.m3507a((long) jSONObject.getInt("calorie"));
            String e4 = C0973a.m3517e(a6.length() / 2);
            String a7 = C0973a.m3506a(4);
            String b = C0973a.m3510b(jSONObject.getInt("speed"));
            String e5 = C0973a.m3517e(b.length() / 2);
            String a8 = C0973a.m3506a(5);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(a);
            stringBuilder.append(e);
            stringBuilder.append(a3);
            stringBuilder.append(e2);
            stringBuilder.append(a2);
            stringBuilder.append(a5);
            stringBuilder.append(e3);
            stringBuilder.append(a4);
            stringBuilder.append(a7);
            stringBuilder.append(e4);
            stringBuilder.append(a6);
            stringBuilder.append(a8);
            stringBuilder.append(e5);
            stringBuilder.append(b);
            if (jSONObject.has("pace")) {
                e = C0973a.m3510b(jSONObject.getInt("pace"));
                a = C0973a.m3517e(e.length() / 2);
                stringBuilder.append(C0973a.m3506a(6));
                stringBuilder.append(a);
                stringBuilder.append(e);
            }
            deviceCommand.setDataLen(stringBuilder.length() / 2);
            deviceCommand.setDataContent(C0973a.m3512b(stringBuilder.toString()));
            this.hwDeviceMgr.m3995b(deviceCommand);
            synchronized (getGetWorkoutOperatorRealtimeDataCallbackList()) {
                getWorkoutOperatorRealtimeDataCallbackList.add(iBaseResponseCallback);
            }
        }
    }

    public void registerNotificationStatusCallbackList(IBaseResponseCallback iBaseResponseCallback) {
        synchronized (getGetNotificationStatusCallbackList()) {
            if (getNotificationStatusCallbackList.size() == 0) {
                getNotificationStatusCallbackList.add(iBaseResponseCallback);
            } else if (!getNotificationStatusCallbackList.contains(iBaseResponseCallback)) {
                getNotificationStatusCallbackList.add(iBaseResponseCallback);
            }
        }
    }

    public void unRegisterNotificationStatusCallbackList(IBaseResponseCallback iBaseResponseCallback) {
        synchronized (getGetNotificationStatusCallbackList()) {
            if (getNotificationStatusCallbackList.contains(iBaseResponseCallback)) {
                getNotificationStatusCallbackList.remove(iBaseResponseCallback);
            }
        }
    }

    public void setNotificationStatusResponse(JSONObject jSONObject, IBaseResponseCallback iBaseResponseCallback) {
        C2538c.m12674b(TAG, "response of NotificationStatus info = ");
        synchronized (this.lockObject) {
            DeviceCommand deviceCommand = new DeviceCommand();
            deviceCommand.setServiceID(23);
            deviceCommand.setCommandID(2);
            try {
                String a = C0973a.m3507a((long) jSONObject.getInt("notification_status_response"));
                String a2 = C0973a.m3506a(a.length() / 2);
                String a3 = C0973a.m3506a(127);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(a3);
                stringBuilder.append(a2);
                stringBuilder.append(a);
                deviceCommand.setDataLen(stringBuilder.length() / 2);
                deviceCommand.setDataContent(C0973a.m3512b(stringBuilder.toString()));
                this.hwDeviceMgr.m3995b(deviceCommand);
                iBaseResponseCallback.onResponse(100000, RemoteUtils.generateRetMap(LightCloudConstants.RESPONSE_RESULT_SUCCESS, "setNotificationStatusResponse"));
            } catch (JSONException e) {
                C2538c.m12680e(TAG, e.getMessage());
            }
        }
    }

    public void registerNotificationWorkoutRealTimeInfoCallbackList(IBaseResponseCallback iBaseResponseCallback) {
        synchronized (getGetNotificationWorkoutRealTimeInfoCallbackList()) {
            if (getNotificationWorkoutRealTimeInfoCallbackList.size() == 0) {
                getNotificationWorkoutRealTimeInfoCallbackList.add(iBaseResponseCallback);
            } else if (!getNotificationWorkoutRealTimeInfoCallbackList.contains(iBaseResponseCallback)) {
                getNotificationWorkoutRealTimeInfoCallbackList.add(iBaseResponseCallback);
            }
        }
    }

    public void unRegisterNotificationWorkoutRealTimeInfoCallbackList(IBaseResponseCallback iBaseResponseCallback) {
        synchronized (getGetNotificationWorkoutRealTimeInfoCallbackList()) {
            if (getNotificationWorkoutRealTimeInfoCallbackList.contains(iBaseResponseCallback)) {
                getNotificationWorkoutRealTimeInfoCallbackList.remove(iBaseResponseCallback);
            }
        }
    }

    public void registerNotificationSportReminderCallbackList(IBaseResponseCallback iBaseResponseCallback) {
        synchronized (getGetNotificationSportReminderCallbackList()) {
            if (getNotificationSportReminderCallbackList.size() == 0) {
                getNotificationSportReminderCallbackList.add(iBaseResponseCallback);
            } else if (!getNotificationSportReminderCallbackList.contains(iBaseResponseCallback)) {
                getNotificationSportReminderCallbackList.add(iBaseResponseCallback);
            }
        }
    }

    public void unRegisterNotificationSportReminderCallbackList(IBaseResponseCallback iBaseResponseCallback) {
        synchronized (getGetNotificationSportReminderCallbackList()) {
            if (getNotificationSportReminderCallbackList.contains(iBaseResponseCallback)) {
                getNotificationSportReminderCallbackList.remove(iBaseResponseCallback);
            }
        }
    }

    public void registerNotificationGetWorkoutRecordStatisticCallbackList(IBaseResponseCallback iBaseResponseCallback) {
        synchronized (getGetNotificationGetWorkoutRecordStatisticCallbackList()) {
            if (getNotificationGetWorkoutRecordStatisticCallbackList.size() == 0) {
                getNotificationGetWorkoutRecordStatisticCallbackList.add(iBaseResponseCallback);
            } else if (!getNotificationGetWorkoutRecordStatisticCallbackList.contains(iBaseResponseCallback)) {
                getNotificationGetWorkoutRecordStatisticCallbackList.add(iBaseResponseCallback);
            }
        }
    }

    public void unRegisterNotificationGetWorkoutRecordStatisticCallbackList(IBaseResponseCallback iBaseResponseCallback) {
        synchronized (getGetNotificationGetWorkoutRecordStatisticCallbackList()) {
            if (getNotificationGetWorkoutRecordStatisticCallbackList.contains(iBaseResponseCallback)) {
                getNotificationGetWorkoutRecordStatisticCallbackList.remove(iBaseResponseCallback);
            }
        }
    }

    public void getWorkoutRecordPaceMap(PaceIndexStruct paceIndexStruct, IBaseResponseCallback iBaseResponseCallback) {
        synchronized (this.lockObject) {
            DeviceCommand deviceCommand = new DeviceCommand();
            deviceCommand.setServiceID(23);
            deviceCommand.setCommandID(12);
            String a = C0973a.m3506a(129);
            String e = C0973a.m3517e(4);
            String b = C0973a.m3510b(paceIndexStruct.getRecordId());
            String e2 = C0973a.m3517e(b.length() / 2);
            String a2 = C0973a.m3506a(2);
            String str = "";
            String str2 = "";
            String str3 = "";
            if (paceIndexStruct.getPaceIndex() >= 0) {
                e = C0973a.m3517e(8);
                str = C0973a.m3510b(paceIndexStruct.getPaceIndex());
                str2 = C0973a.m3517e(str.length() / 2);
                str3 = C0973a.m3506a(8);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(a);
            stringBuilder.append(e);
            stringBuilder.append(a2);
            stringBuilder.append(e2);
            stringBuilder.append(b);
            if (paceIndexStruct.getPaceIndex() >= 0) {
                stringBuilder.append(str3);
                stringBuilder.append(str2);
                stringBuilder.append(str);
            }
            deviceCommand.setDataLen(stringBuilder.length() / 2);
            deviceCommand.setDataContent(C0973a.m3512b(stringBuilder.toString()));
            this.hwDeviceMgr.m3995b(deviceCommand);
            synchronized (getGetWorkoutRecordPaceMapListCallbackList()) {
                mGetWorkoutRecordPaceMapListCallbackList.add(iBaseResponseCallback);
            }
        }
    }

    public void registerNotificationWorkoutRecordSpeechPlayCallbackList(IBaseResponseCallback iBaseResponseCallback) {
        synchronized (getGetNotificationWorkoutRecordSpeechPlayCallbackList()) {
            if (getNotificationWorkoutRecordSpeechPlayCallbackList.size() == 0) {
                getNotificationWorkoutRecordSpeechPlayCallbackList.add(iBaseResponseCallback);
            } else if (!getNotificationWorkoutRecordSpeechPlayCallbackList.contains(iBaseResponseCallback)) {
                getNotificationWorkoutRecordSpeechPlayCallbackList.add(iBaseResponseCallback);
            }
        }
    }

    public void unRegisterNotificationWorkoutRecordSpeechPlayCallbackList(IBaseResponseCallback iBaseResponseCallback) {
        synchronized (getGetNotificationWorkoutRecordSpeechPlayCallbackList()) {
            if (getNotificationWorkoutRecordSpeechPlayCallbackList.contains(iBaseResponseCallback)) {
                getNotificationWorkoutRecordSpeechPlayCallbackList.remove(iBaseResponseCallback);
            }
        }
    }

    public void notificationWorkoutRecordSpeechPlayReportStatus(JSONObject jSONObject, IBaseResponseCallback iBaseResponseCallback) {
        C2538c.m12674b(TAG, "ENTER notificationWorkoutRecordSpeechPlayReportStatus... ");
        synchronized (this.lockObject) {
            if (jSONObject != null) {
                if (jSONObject.optInt("result") == 0) {
                    DeviceCommand deviceCommand = new DeviceCommand();
                    deviceCommand.setServiceID(23);
                    deviceCommand.setCommandID(13);
                    String a = C0973a.m3506a(1);
                    String e = C0973a.m3517e(1);
                    String a2 = C0973a.m3506a(2);
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(a2);
                    stringBuilder.append(e);
                    stringBuilder.append(a);
                    deviceCommand.setDataLen(stringBuilder.length() / 2);
                    deviceCommand.setDataContent(C0973a.m3512b(stringBuilder.toString()));
                    this.hwDeviceMgr.m3995b(deviceCommand);
                }
            }
        }
    }

    public void getResult(byte[] bArr) {
        C2538c.m12677c(TAG, "getResult(): " + C0973a.m3509a(bArr));
        String a = C0973a.m3509a(bArr);
        if (4 < a.length()) {
            try {
                u a2 = new w().a(a.substring(4, a.length()));
                List<s> list = a2.a;
                List<u> list2 = a2.b;
                int parseInt;
                OperatorStatus operatorStatus;
                WorkoutRealTimeInfo workoutRealTimeInfo;
                List arrayList;
                List<s> list3;
                WorkoutRecordStatistic workoutRecordStatistic;
                switch (bArr[1]) {
                    case (byte) 1:
                        parseInt = Integer.parseInt(((s) list.get(0)).b(), 16);
                        synchronized (getSetOperatorCallbackList()) {
                            if (setOperatorCallbackList.size() != 0) {
                                ((IBaseResponseCallback) setOperatorCallbackList.get(0)).onResponse(parseInt, RemoteUtils.generateRetMap(Integer.valueOf(parseInt), "setOperator"));
                                setOperatorCallbackList.remove(0);
                            }
                        }
                        return;
                    case (byte) 2:
                        operatorStatus = new OperatorStatus();
                        for (u uVar : list2) {
                            for (s sVar : uVar.a) {
                                switch (Integer.parseInt(sVar.a(), 16)) {
                                    case 2:
                                        operatorStatus.setOperator_type(Integer.parseInt(sVar.b(), 16));
                                        break;
                                    case 3:
                                        operatorStatus.setSport_type(Integer.parseInt(sVar.b(), 16));
                                        break;
                                    case 4:
                                        operatorStatus.setRun_plan_date(1000 * Long.parseLong(sVar.b(), 16));
                                        break;
                                    case 5:
                                        operatorStatus.setWorkout_type(Integer.parseInt(sVar.b(), 16));
                                        break;
                                    case 6:
                                        operatorStatus.setOperation_time(Long.parseLong(sVar.b(), 16));
                                        break;
                                    default:
                                        break;
                                }
                            }
                        }
                        synchronized (getGetNotificationStatusCallbackList()) {
                            for (IBaseResponseCallback onResponse : getNotificationStatusCallbackList) {
                                onResponse.onResponse(100000, RemoteUtils.generateRetMap(operatorStatus, "notificationStatus"));
                            }
                        }
                        return;
                    case (byte) 3:
                        if (list != null) {
                            if (list.size() > 0 && 127 == Integer.parseInt(((s) list.get(0)).a(), 16)) {
                                synchronized (getGetOperatorCallbackList()) {
                                    parseInt = Integer.parseInt(((s) list.get(0)).b(), 16);
                                    ((IBaseResponseCallback) getOperatorCallbackList.get(0)).onResponse(parseInt, RemoteUtils.generateRetMap(Integer.valueOf(parseInt), "getOperator"));
                                    getOperatorCallbackList.remove(0);
                                }
                                return;
                            }
                        }
                        operatorStatus = new OperatorStatus();
                        for (u uVar2 : list2) {
                            for (s sVar2 : uVar2.a) {
                                switch (Integer.parseInt(sVar2.a(), 16)) {
                                    case 2:
                                        operatorStatus.setTrain_monitor_state(Integer.parseInt(sVar2.b(), 16));
                                        break;
                                    case 3:
                                        operatorStatus.setOperator_type(Integer.parseInt(sVar2.b(), 16));
                                        break;
                                    case 4:
                                        operatorStatus.setSport_type(Integer.parseInt(sVar2.b(), 16));
                                        break;
                                    case 5:
                                        operatorStatus.setRun_plan_date(Long.parseLong(sVar2.b(), 16) * 1000);
                                        break;
                                    case 6:
                                        operatorStatus.setWorkout_type(Integer.parseInt(sVar2.b(), 16));
                                        break;
                                    default:
                                        break;
                                }
                            }
                        }
                        synchronized (getGetOperatorCallbackList()) {
                            ((IBaseResponseCallback) getOperatorCallbackList.get(0)).onResponse(100000, RemoteUtils.generateRetMap(operatorStatus, "getOperator"));
                            getOperatorCallbackList.remove(0);
                        }
                        return;
                    case (byte) 4:
                        if (list.size() <= 0 || 127 != Integer.parseInt(((s) list.get(0)).a(), 16)) {
                            workoutRealTimeInfo = new WorkoutRealTimeInfo();
                            for (u uVar3 : list2) {
                                for (s sVar22 : uVar3.a) {
                                    switch (Integer.parseInt(sVar22.a(), 16)) {
                                        case 2:
                                        case 3:
                                        case 4:
                                        case 6:
                                            workoutRealTimeInfo.setSport_type(Integer.parseInt(sVar22.b(), 16));
                                            break;
                                        case 5:
                                            workoutRealTimeInfo.setClime_info(Long.parseLong(sVar22.b(), 16) * 1000);
                                            break;
                                        case 7:
                                            workoutRealTimeInfo.setDistance_info(Long.parseLong(sVar22.b(), 16));
                                            break;
                                        case 8:
                                            workoutRealTimeInfo.setClime_info(Long.parseLong(sVar22.b(), 16));
                                            break;
                                        default:
                                            break;
                                    }
                                }
                            }
                            synchronized (getGetWorkoutRealTimeInfoCallbackList()) {
                                ((IBaseResponseCallback) getWorkoutRealTimeInfoCallbackList.get(0)).onResponse(100000, RemoteUtils.generateRetMap(workoutRealTimeInfo, "getWorkoutRealTimeInfo"));
                                getWorkoutRealTimeInfoCallbackList.remove(0);
                            }
                            return;
                        }
                        synchronized (getGetWorkoutRealTimeInfoCallbackList()) {
                            parseInt = Integer.parseInt(((s) list.get(0)).b(), 16);
                            ((IBaseResponseCallback) getWorkoutRealTimeInfoCallbackList.get(0)).onResponse(parseInt, RemoteUtils.generateRetMap(Integer.valueOf(parseInt), "getWorkoutRealTimeInfo"));
                            getWorkoutRealTimeInfoCallbackList.remove(0);
                        }
                        return;
                    case (byte) 5:
                        workoutRealTimeInfo = new WorkoutRealTimeInfo();
                        for (u uVar4 : list2) {
                            for (s sVar222 : uVar4.a) {
                                switch (Integer.parseInt(sVar222.a(), 16)) {
                                    case 2:
                                        workoutRealTimeInfo.setSport_type(Integer.parseInt(sVar222.b(), 16));
                                        break;
                                    case 3:
                                        workoutRealTimeInfo.setSpeed_info(((float) Integer.parseInt(sVar222.b(), 16)) / 10.0f);
                                        break;
                                    case 4:
                                        workoutRealTimeInfo.setSport_type(Integer.parseInt(sVar222.b(), 16));
                                        break;
                                    case 5:
                                        workoutRealTimeInfo.setClime_info(Long.parseLong(sVar222.b(), 16) * 1000);
                                        break;
                                    case 6:
                                        workoutRealTimeInfo.setCalorie_info(Long.parseLong(sVar222.b(), 16));
                                        break;
                                    case 7:
                                        workoutRealTimeInfo.setDistance_info(Long.parseLong(sVar222.b(), 16));
                                        break;
                                    case 8:
                                        workoutRealTimeInfo.setClime_info(Long.parseLong(sVar222.b(), 16));
                                        break;
                                    default:
                                        break;
                                }
                            }
                        }
                        synchronized (getGetNotificationWorkoutRealTimeInfoCallbackList()) {
                            for (IBaseResponseCallback onResponse2 : getNotificationWorkoutRealTimeInfoCallbackList) {
                                onResponse2.onResponse(100000, RemoteUtils.generateRetMap(workoutRealTimeInfo, "notificationWorkoutRealTimeInfo"));
                            }
                        }
                        return;
                    case (byte) 6:
                        SportReminder sportReminder = new SportReminder();
                        for (u uVar5 : list2) {
                            for (s sVar2222 : uVar5.a) {
                                switch (Integer.parseInt(sVar2222.a(), 16)) {
                                    case 3:
                                        sportReminder.setReminder_type(Integer.parseInt(sVar2222.b(), 16));
                                        break;
                                    case 4:
                                        sportReminder.setRun_phrase_number(Integer.parseInt(sVar2222.b(), 16));
                                        break;
                                    case 5:
                                        arrayList = new ArrayList();
                                        arrayList.add(Integer.valueOf(Integer.parseInt(sVar2222.b().substring(0, 4), 16)));
                                        arrayList.add(Integer.valueOf(Integer.parseInt(sVar2222.b().substring(4, 8), 16)));
                                        sportReminder.setRun_phrase_variable(arrayList);
                                        break;
                                    case 6:
                                        sportReminder.setDistance_info(Long.parseLong(sVar2222.b(), 16));
                                        break;
                                    case 7:
                                        sportReminder.setTime_info(Long.parseLong(sVar2222.b(), 16));
                                        break;
                                    case 8:
                                        sportReminder.setHr_value_info(Integer.parseInt(sVar2222.b(), 16));
                                        break;
                                    case 9:
                                        sportReminder.setHr_status_info(Integer.parseInt(sVar2222.b(), 16));
                                        break;
                                    default:
                                        break;
                                }
                            }
                        }
                        synchronized (getGetNotificationSportReminderCallbackList()) {
                            for (IBaseResponseCallback onResponse22 : getNotificationSportReminderCallbackList) {
                                onResponse22.onResponse(100000, RemoteUtils.generateRetMap(sportReminder, "notificationSportReminder"));
                            }
                        }
                        return;
                    case (byte) 7:
                        if (list.size() <= 0 || 127 != Integer.parseInt(((s) list.get(0)).a(), 16)) {
                            WorkoutRecord workoutRecord = new WorkoutRecord();
                            arrayList = new ArrayList();
                            for (u uVar6 : list2) {
                                for (s sVar3 : uVar6.a) {
                                    switch (Integer.parseInt(sVar3.a(), 16)) {
                                        case 2:
                                            workoutRecord.setWorkout_record_count(Integer.parseInt(sVar3.b(), 16));
                                            break;
                                        default:
                                            break;
                                    }
                                }
                                for (u a22 : uVar6.b) {
                                    list3 = a22.a;
                                    WorkoutRecordStruct workoutRecordStruct = new WorkoutRecordStruct();
                                    for (s sVar22222 : list3) {
                                        switch (Integer.parseInt(sVar22222.a(), 16)) {
                                            case 6:
                                                workoutRecordStruct.setWorkout_record_id(Integer.parseInt(sVar22222.b(), 16));
                                                break;
                                            case 7:
                                                workoutRecordStruct.setWorkout_index_count(Integer.parseInt(sVar22222.b(), 16));
                                                break;
                                            case 8:
                                                workoutRecordStruct.setPaceIndexCount(Integer.parseInt(sVar22222.b(), 16));
                                                break;
                                            default:
                                                break;
                                        }
                                    }
                                    arrayList.add(workoutRecordStruct);
                                }
                            }
                            workoutRecord.setWorkoutRecordStructList(arrayList);
                            synchronized (getGetWorkoutRecordCallbackList()) {
                                if (getWorkoutRecordCallbackList.size() != 0) {
                                    ((IBaseResponseCallback) getWorkoutRecordCallbackList.get(0)).onResponse(100000, RemoteUtils.generateRetMap(workoutRecord, "getWorkoutRecord"));
                                    getWorkoutRecordCallbackList.remove(0);
                                }
                            }
                            return;
                        }
                        synchronized (getGetWorkoutRecordCallbackList()) {
                            if (getWorkoutRecordCallbackList.size() != 0) {
                                parseInt = Integer.parseInt(((s) list.get(0)).b(), 16);
                                ((IBaseResponseCallback) getWorkoutRecordCallbackList.get(0)).onResponse(parseInt, RemoteUtils.generateRetMap(Integer.valueOf(parseInt), "getWorkoutRecord"));
                                getWorkoutRecordCallbackList.remove(0);
                            }
                        }
                        return;
                    case (byte) 8:
                        if (list.size() <= 0 || 127 != Integer.parseInt(((s) list.get(0)).a(), 16)) {
                            workoutRecordStatistic = new WorkoutRecordStatistic();
                            for (u uVar7 : list2) {
                                for (s sVar222222 : uVar7.a) {
                                    switch (Integer.parseInt(sVar222222.a(), 16)) {
                                        case 2:
                                            workoutRecordStatistic.setWorkout_record_id(Integer.parseInt(sVar222222.b(), 16));
                                            break;
                                        case 3:
                                            workoutRecordStatistic.setWorkout_record_status(Integer.parseInt(sVar222222.b(), 16));
                                            break;
                                        case 4:
                                            workoutRecordStatistic.setWorkout_record_start_time(Long.parseLong(sVar222222.b(), 16) * 1000);
                                            break;
                                        case 5:
                                            workoutRecordStatistic.setWorkout_record_end_time(Long.parseLong(sVar222222.b(), 16) * 1000);
                                            break;
                                        case 6:
                                            workoutRecordStatistic.setWorkout_record_calorie(Integer.parseInt(sVar222222.b(), 16));
                                            break;
                                        case 7:
                                            workoutRecordStatistic.setWorkout_record_distance(Integer.parseInt(sVar222222.b(), 16));
                                            break;
                                        case 8:
                                            workoutRecordStatistic.setWorkout_record_step(Long.parseLong(sVar222222.b(), 16));
                                            break;
                                        case 9:
                                            workoutRecordStatistic.setWorkout_record_total_time(Long.parseLong(sVar222222.b(), 16));
                                            break;
                                        case 10:
                                            workoutRecordStatistic.setWorkout_record_speed(Integer.parseInt(sVar222222.b(), 16));
                                            break;
                                        case 11:
                                            workoutRecordStatistic.setWorkout_climb(Long.parseLong(sVar222222.b(), 16));
                                            break;
                                        case 12:
                                            workoutRecordStatistic.setWorkout_HrABS_peak_min(Integer.parseInt(sVar222222.b().substring(0, 2), 16));
                                            workoutRecordStatistic.setWorkout_HrABS_peak_max(Integer.parseInt(sVar222222.b().substring(2, 4), 16));
                                            break;
                                        case 13:
                                            workoutRecordStatistic.setWorkout_load_peak(Integer.parseInt(sVar222222.b(), 16));
                                            break;
                                        case 14:
                                            workoutRecordStatistic.setWorkout_etraining_effect(Integer.parseInt(sVar222222.b(), 16));
                                            break;
                                        case 15:
                                            workoutRecordStatistic.setWorkout_Epoc(Integer.parseInt(sVar222222.b(), 16));
                                            break;
                                        case 16:
                                            workoutRecordStatistic.setWorkout_maxMET(Integer.parseInt(sVar222222.b(), 16));
                                            break;
                                        case 17:
                                            workoutRecordStatistic.setWorkout_recovery_time(Integer.parseInt(sVar222222.b(), 16));
                                            break;
                                        case 18:
                                            workoutRecordStatistic.setWorkout_exercise_duration(Long.parseLong(sVar222222.b(), 16) * 1000);
                                            break;
                                        case 19:
                                            workoutRecordStatistic.setWorkout_date_Info(Long.parseLong(sVar222222.b(), 16));
                                            break;
                                        case 20:
                                            workoutRecordStatistic.setWorkout_type(Integer.parseInt(sVar222222.b(), 16));
                                            break;
                                        case 21:
                                            workoutRecordStatistic.setSwim_type(Integer.parseInt(sVar222222.b(), 16));
                                            break;
                                        case 22:
                                            workoutRecordStatistic.setSwim_pull_times(Integer.parseInt(sVar222222.b(), 16));
                                            break;
                                        case 23:
                                            workoutRecordStatistic.setSwim_pull_rate(Integer.parseInt(sVar222222.b(), 16));
                                            break;
                                        case 24:
                                            workoutRecordStatistic.setSwim_pool_length(Integer.parseInt(sVar222222.b(), 16));
                                            break;
                                        case 25:
                                            workoutRecordStatistic.setSwim_trip_times(Integer.parseInt(sVar222222.b(), 16));
                                            break;
                                        case 26:
                                            workoutRecordStatistic.setSwim_avg_swolf(Integer.parseInt(sVar222222.b(), 16));
                                            break;
                                        default:
                                            break;
                                    }
                                }
                            }
                            synchronized (getGetWorkoutRecordStatisticCallbackList()) {
                                if (getWorkoutRecordStatisticCallbackList.size() != 0) {
                                    ((IBaseResponseCallback) getWorkoutRecordStatisticCallbackList.get(0)).onResponse(100000, RemoteUtils.generateRetMap(workoutRecordStatistic, "getWorkoutRecordStatistic"));
                                    getWorkoutRecordStatisticCallbackList.remove(0);
                                }
                            }
                            return;
                        }
                        synchronized (getGetWorkoutRecordStatisticCallbackList()) {
                            if (getWorkoutRecordStatisticCallbackList.size() != 0) {
                                parseInt = Integer.parseInt(((s) list.get(0)).b(), 16);
                                ((IBaseResponseCallback) getWorkoutRecordStatisticCallbackList.get(0)).onResponse(parseInt, RemoteUtils.generateRetMap(Integer.valueOf(parseInt), "getWorkoutRecordStatistic"));
                                getWorkoutRecordStatisticCallbackList.remove(0);
                            }
                        }
                        return;
                    case (byte) 9:
                        workoutRecordStatistic = new WorkoutRecordStatistic();
                        for (u uVar8 : list2) {
                            for (s sVar2222222 : uVar8.a) {
                                switch (Integer.parseInt(sVar2222222.a(), 16)) {
                                    case 2:
                                        workoutRecordStatistic.setWorkout_record_id(Integer.parseInt(sVar2222222.b(), 16));
                                        break;
                                    case 3:
                                        workoutRecordStatistic.setWorkout_record_status(Integer.parseInt(sVar2222222.b(), 16));
                                        break;
                                    case 4:
                                        workoutRecordStatistic.setWorkout_record_start_time(Long.parseLong(sVar2222222.b(), 16) * 1000);
                                        break;
                                    case 5:
                                        workoutRecordStatistic.setWorkout_record_end_time(Long.parseLong(sVar2222222.b(), 16) * 1000);
                                        break;
                                    case 6:
                                        workoutRecordStatistic.setWorkout_record_calorie(Integer.parseInt(sVar2222222.b(), 16));
                                        break;
                                    case 7:
                                        workoutRecordStatistic.setWorkout_record_distance(Integer.parseInt(sVar2222222.b(), 16));
                                        break;
                                    case 8:
                                        workoutRecordStatistic.setWorkout_record_step(Long.parseLong(sVar2222222.b(), 16));
                                        break;
                                    case 9:
                                        workoutRecordStatistic.setWorkout_record_total_time(Long.parseLong(sVar2222222.b(), 16));
                                        break;
                                    case 10:
                                        workoutRecordStatistic.setWorkout_record_speed(Integer.parseInt(sVar2222222.b(), 16));
                                        break;
                                    case 11:
                                        workoutRecordStatistic.setWorkout_climb(Long.parseLong(sVar2222222.b(), 16));
                                        break;
                                    case 12:
                                        workoutRecordStatistic.setWorkout_HrABS_peak_max(Integer.parseInt(sVar2222222.b().substring(0, 2), 16));
                                        workoutRecordStatistic.setWorkout_HrABS_peak_min(Integer.parseInt(sVar2222222.b().substring(2, 4), 16));
                                        break;
                                    case 13:
                                        workoutRecordStatistic.setWorkout_load_peak(Integer.parseInt(sVar2222222.b(), 16));
                                        break;
                                    case 14:
                                        workoutRecordStatistic.setWorkout_etraining_effect(Integer.parseInt(sVar2222222.b(), 16));
                                        break;
                                    case 15:
                                        workoutRecordStatistic.setWorkout_Epoc(Integer.parseInt(sVar2222222.b(), 16));
                                        break;
                                    case 16:
                                        workoutRecordStatistic.setWorkout_maxMET(Integer.parseInt(sVar2222222.b(), 16));
                                        break;
                                    case 17:
                                        workoutRecordStatistic.setWorkout_recovery_time(Integer.parseInt(sVar2222222.b(), 16));
                                        break;
                                    case 18:
                                        workoutRecordStatistic.setWorkout_exercise_duration(Long.parseLong(sVar2222222.b(), 16));
                                        break;
                                    case 19:
                                        workoutRecordStatistic.setWorkout_date_Info(Long.parseLong(sVar2222222.b(), 16));
                                        break;
                                    default:
                                        break;
                                }
                            }
                        }
                        synchronized (getGetNotificationGetWorkoutRecordStatisticCallbackList()) {
                            for (IBaseResponseCallback onResponse222 : getNotificationGetWorkoutRecordStatisticCallbackList) {
                                onResponse222.onResponse(100000, RemoteUtils.generateRetMap(workoutRecordStatistic, "notificationGetWorkoutRecordStatistic"));
                            }
                        }
                        return;
                    case (byte) 10:
                        if (list != null) {
                            if (list.size() > 0 && 127 == Integer.parseInt(((s) list.get(0)).a(), 16)) {
                                synchronized (getGetWorkoutDataCallbackList()) {
                                    if (getWorkoutDataCallbackList.size() != 0) {
                                        parseInt = Integer.parseInt(((s) list.get(0)).b(), 16);
                                        ((IBaseResponseCallback) getWorkoutDataCallbackList.get(0)).onResponse(parseInt, RemoteUtils.generateRetMap(Integer.valueOf(parseInt), "getWorkoutData"));
                                        getWorkoutDataCallbackList.remove(0);
                                    }
                                }
                                return;
                            }
                        }
                        WorkoutDataStruct workoutDataStruct = new WorkoutDataStruct();
                        if (list2 != null && list2.size() > 0) {
                            for (u a222 : list2) {
                                list3 = a222.a;
                                DataHeader dataHeader = new DataHeader();
                                List arrayList2 = new ArrayList();
                                parseInt = 0;
                                List arrayList3 = new ArrayList();
                                for (s sVar22222222 : list3) {
                                    int i;
                                    switch (Integer.parseInt(sVar22222222.a(), 16)) {
                                        case 2:
                                            workoutDataStruct.setWorkout_record_id(Integer.parseInt(sVar22222222.b(), 16));
                                            i = parseInt;
                                            break;
                                        case 3:
                                            workoutDataStruct.setWorkout_data_index(Integer.parseInt(sVar22222222.b(), 16));
                                            i = parseInt;
                                            break;
                                        case 4:
                                            dataHeader.setSportID(Integer.parseInt(sVar22222222.b().substring(0, 4), 16));
                                            dataHeader.setFrameID(Integer.parseInt(sVar22222222.b().substring(4, 8), 16));
                                            dataHeader.setTime(Long.parseLong(sVar22222222.b().substring(8, 16), 16) * 1000);
                                            dataHeader.setTimeInterval(Integer.parseInt(sVar22222222.b().substring(16, 18), 16));
                                            parseInt = Integer.parseInt(sVar22222222.b().substring(18, 22), 16);
                                            String stringBuffer = new StringBuffer(Integer.toBinaryString(Integer.parseInt(sVar22222222.b().substring(24, sVar22222222.b().length()), 16))).reverse().toString();
                                            for (i = 0; i < stringBuffer.length(); i++) {
                                                if (i + 1 <= stringBuffer.length()) {
                                                    arrayList3.add(stringBuffer.substring(i, i + 1));
                                                } else {
                                                    arrayList3.add("0");
                                                }
                                            }
                                            i = parseInt;
                                            break;
                                        case 5:
                                            int i2;
                                            List arrayList4 = new ArrayList();
                                            for (i2 = 0; i2 < sVar22222222.b().length(); i2 += 2) {
                                                arrayList4.add(sVar22222222.b().substring(i2, i2 + 2));
                                            }
                                            if (arrayList4.size() > 0) {
                                                for (int i3 = 0; i3 < parseInt; i3++) {
                                                    WorkoutDataInfo workoutDataInfo = new WorkoutDataInfo();
                                                    for (i2 = 0; i2 < arrayList3.size(); i2++) {
                                                        if ("1".equals(arrayList3.get(i2))) {
                                                            switch (i2) {
                                                                case 0:
                                                                    workoutDataInfo.setData1(Integer.parseInt((String) arrayList4.get(0), 16));
                                                                    break;
                                                                case 1:
                                                                    a = (String) arrayList4.get(0);
                                                                    arrayList4.remove(0);
                                                                    workoutDataInfo.setData2(Integer.parseInt(a + ((String) arrayList4.get(0)), 16));
                                                                    break;
                                                                case 2:
                                                                    workoutDataInfo.setData3(Integer.parseInt((String) arrayList4.get(0), 16));
                                                                    break;
                                                                case 3:
                                                                    workoutDataInfo.setData4(Integer.parseInt((String) arrayList4.get(0), 16));
                                                                    break;
                                                                case 4:
                                                                    workoutDataInfo.setData5(Integer.parseInt((String) arrayList4.get(0), 16));
                                                                    break;
                                                                case 5:
                                                                    workoutDataInfo.setData6(Integer.parseInt((String) arrayList4.get(0), 16));
                                                                    break;
                                                                case 6:
                                                                    workoutDataInfo.setData7(Integer.parseInt((String) arrayList4.get(0), 16));
                                                                    break;
                                                                case 7:
                                                                    workoutDataInfo.setData8(Integer.parseInt((String) arrayList4.get(0), 16));
                                                                    break;
                                                                case 8:
                                                                    workoutDataInfo.setData9(Integer.parseInt((String) arrayList4.get(0), 16));
                                                                    break;
                                                                case 9:
                                                                    workoutDataInfo.setData10(Integer.parseInt((String) arrayList4.get(0), 16));
                                                                    break;
                                                                case 10:
                                                                    workoutDataInfo.setData11(Integer.parseInt((String) arrayList4.get(0), 16));
                                                                    break;
                                                                case 11:
                                                                    workoutDataInfo.setData12(Integer.parseInt((String) arrayList4.get(0), 16));
                                                                    break;
                                                                case 12:
                                                                    workoutDataInfo.setData13(Integer.parseInt((String) arrayList4.get(0), 16));
                                                                    break;
                                                                case 13:
                                                                    workoutDataInfo.setData14(Integer.parseInt((String) arrayList4.get(0), 16));
                                                                    break;
                                                                case 14:
                                                                    workoutDataInfo.setData15(Integer.parseInt((String) arrayList4.get(0), 16));
                                                                    break;
                                                                case 15:
                                                                    workoutDataInfo.setData16(Integer.parseInt((String) arrayList4.get(0), 16));
                                                                    break;
                                                            }
                                                            arrayList4.remove(0);
                                                        }
                                                    }
                                                    arrayList2.add(workoutDataInfo);
                                                }
                                            }
                                            dataHeader.setWorkoutDataInfoList(arrayList2);
                                            workoutDataStruct.setDataHeader(dataHeader);
                                            i = parseInt;
                                            break;
                                        default:
                                            i = parseInt;
                                            break;
                                    }
                                    parseInt = i;
                                }
                            }
                        }
                        synchronized (getGetWorkoutDataCallbackList()) {
                            if (getWorkoutDataCallbackList.size() != 0) {
                                ((IBaseResponseCallback) getWorkoutDataCallbackList.get(0)).onResponse(100000, RemoteUtils.generateRetMap(workoutDataStruct, "getWorkoutData"));
                                getWorkoutDataCallbackList.remove(0);
                            }
                        }
                        return;
                    case (byte) 11:
                        synchronized (getGetWorkoutOperatorRealtimeDataCallbackList()) {
                            if (getWorkoutOperatorRealtimeDataCallbackList.size() != 0) {
                                parseInt = Integer.parseInt(((s) list.get(0)).b(), 16);
                                ((IBaseResponseCallback) getWorkoutOperatorRealtimeDataCallbackList.get(0)).onResponse(parseInt, RemoteUtils.generateRetMap(Integer.valueOf(parseInt), "workoutOperateRealtimeData"));
                                getWorkoutOperatorRealtimeDataCallbackList.remove(0);
                            }
                        }
                        return;
                    case (byte) 12:
                        if (list.size() <= 0 || 127 != Integer.parseInt(((s) list.get(0)).a(), 16)) {
                            WorkRecordIndexPaceMapList workRecordIndexPaceMapList = new WorkRecordIndexPaceMapList();
                            List arrayList5 = new ArrayList();
                            for (s sVar222222222 : ((u) list2.get(0)).a) {
                                if (2 == Integer.parseInt(sVar222222222.a(), 16)) {
                                    workRecordIndexPaceMapList.setWorkout_record_id(Integer.parseInt(sVar222222222.b(), 16));
                                } else if (8 == Integer.parseInt(sVar222222222.a(), 16)) {
                                    workRecordIndexPaceMapList.setPaceIndex(Integer.parseInt(sVar222222222.b(), 16));
                                }
                            }
                            for (u uVar9 : ((u) list2.get(0)).b) {
                                WorkoutRecordPaceMap workoutRecordPaceMap = new WorkoutRecordPaceMap();
                                for (s sVar2222222222 : uVar9.a) {
                                    switch (Integer.parseInt(sVar2222222222.a(), 16)) {
                                        case 4:
                                            workoutRecordPaceMap.setDistance(Integer.parseInt(sVar2222222222.b(), 16));
                                            break;
                                        case 5:
                                            workoutRecordPaceMap.setUnit_type(Integer.parseInt(sVar2222222222.b(), 16));
                                            break;
                                        case 6:
                                            workoutRecordPaceMap.setPace(Integer.parseInt(sVar2222222222.b(), 16));
                                            break;
                                        case 7:
                                            workoutRecordPaceMap.setPoint_index(Integer.parseInt(sVar2222222222.b(), 16));
                                            break;
                                        case 9:
                                            workoutRecordPaceMap.setLastLessDistance(Integer.parseInt(sVar2222222222.b(), 16));
                                            workoutRecordPaceMap.setIsLastLessDistance(true);
                                            break;
                                        default:
                                            break;
                                    }
                                }
                                arrayList5.add(workoutRecordPaceMap);
                            }
                            workRecordIndexPaceMapList.setPaceMapList(arrayList5);
                            synchronized (getGetWorkoutRecordPaceMapListCallbackList()) {
                                if (mGetWorkoutRecordPaceMapListCallbackList.size() != 0) {
                                    ((IBaseResponseCallback) mGetWorkoutRecordPaceMapListCallbackList.get(0)).onResponse(100000, RemoteUtils.generateRetMap(workRecordIndexPaceMapList, "getWorkoutRecordPaceMap"));
                                    mGetWorkoutRecordPaceMapListCallbackList.remove(0);
                                }
                            }
                            return;
                        }
                        synchronized (getGetWorkoutRecordPaceMapListCallbackList()) {
                            if (mGetWorkoutRecordPaceMapListCallbackList.size() != 0) {
                                parseInt = Integer.parseInt(((s) list.get(0)).b(), 16);
                                ((IBaseResponseCallback) mGetWorkoutRecordPaceMapListCallbackList.get(0)).onResponse(parseInt, RemoteUtils.generateRetMap(Integer.valueOf(parseInt), "getWorkoutRecordPaceMap"));
                                mGetWorkoutRecordPaceMapListCallbackList.remove(0);
                            }
                        }
                        return;
                    case (byte) 13:
                        WorkoutRecordSpeechPlay workoutRecordSpeechPlay = new WorkoutRecordSpeechPlay();
                        for (s sVar22222222222 : list) {
                            if (1 == Integer.parseInt(sVar22222222222.a(), 16)) {
                                workoutRecordSpeechPlay.setWorkout_record_speech_play_request_report(Integer.parseInt(sVar22222222222.b(), 16));
                            }
                        }
                        synchronized (getGetNotificationWorkoutRecordSpeechPlayCallbackList()) {
                            for (IBaseResponseCallback onResponse2222 : getNotificationWorkoutRecordSpeechPlayCallbackList) {
                                onResponse2222.onResponse(100000, RemoteUtils.generateRetMap(workoutRecordSpeechPlay, "notificationWorkoutRecordSpeechPlay"));
                            }
                        }
                        return;
                    default:
                        return;
                }
            } catch (t e) {
                C2538c.m12680e(TAG, "接收命令错误 e=" + e.getMessage());
                return;
            } catch (IndexOutOfBoundsException e2) {
                C2538c.m12680e(TAG, "接收命令错误 IndexOutOfBoundsException =" + e2.getMessage());
                return;
            } catch (Exception e3) {
                C2538c.m12680e(TAG, "接收命令错误 Exception =" + e3.getMessage());
                return;
            }
        }
        C2538c.m12680e(TAG, "接收命令错误 data lenth less 4");
    }

    private int transSportType(int i) {
        switch (i) {
            case 257:
                return 2;
            case SportType.SPORT_TYPE_BIKE /*259*/:
                return 3;
            default:
                return 1;
        }
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected Integer getModuleId() {
        return Integer.valueOf(23);
    }

    private static synchronized Object getSetOperatorCallbackList() {
        List list;
        synchronized (HWWorkoutServiceManager.class) {
            list = setOperatorCallbackList;
        }
        return list;
    }

    private static synchronized Object getGetOperatorCallbackList() {
        List list;
        synchronized (HWWorkoutServiceManager.class) {
            list = getOperatorCallbackList;
        }
        return list;
    }

    private static synchronized Object getGetWorkoutRealTimeInfoCallbackList() {
        List list;
        synchronized (HWWorkoutServiceManager.class) {
            list = getWorkoutRealTimeInfoCallbackList;
        }
        return list;
    }

    private static synchronized Object getGetWorkoutRecordCallbackList() {
        List list;
        synchronized (HWWorkoutServiceManager.class) {
            list = getWorkoutRecordCallbackList;
        }
        return list;
    }

    private static synchronized Object getGetWorkoutRecordStatisticCallbackList() {
        List list;
        synchronized (HWWorkoutServiceManager.class) {
            list = getWorkoutRecordStatisticCallbackList;
        }
        return list;
    }

    private static synchronized Object getGetWorkoutDataCallbackList() {
        List list;
        synchronized (HWWorkoutServiceManager.class) {
            list = getWorkoutDataCallbackList;
        }
        return list;
    }

    private static synchronized Object getGetNotificationStatusCallbackList() {
        List list;
        synchronized (HWWorkoutServiceManager.class) {
            list = getNotificationStatusCallbackList;
        }
        return list;
    }

    private static synchronized Object getGetNotificationWorkoutRealTimeInfoCallbackList() {
        List list;
        synchronized (HWWorkoutServiceManager.class) {
            list = getNotificationWorkoutRealTimeInfoCallbackList;
        }
        return list;
    }

    private static synchronized Object getGetNotificationSportReminderCallbackList() {
        List list;
        synchronized (HWWorkoutServiceManager.class) {
            list = getNotificationSportReminderCallbackList;
        }
        return list;
    }

    private static synchronized Object getGetNotificationGetWorkoutRecordStatisticCallbackList() {
        List list;
        synchronized (HWWorkoutServiceManager.class) {
            list = getNotificationGetWorkoutRecordStatisticCallbackList;
        }
        return list;
    }

    public static List<IBaseResponseCallback> getGetWorkoutOperatorRealtimeDataCallbackList() {
        return getWorkoutOperatorRealtimeDataCallbackList;
    }

    private static synchronized Object getGetWorkoutRecordPaceMapListCallbackList() {
        List list;
        synchronized (HWWorkoutServiceManager.class) {
            list = mGetWorkoutRecordPaceMapListCallbackList;
        }
        return list;
    }

    public static Object getGetNotificationWorkoutRecordSpeechPlayCallbackList() {
        return getNotificationWorkoutRecordSpeechPlayCallbackList;
    }
}
