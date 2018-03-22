package com.huawei.hwservicesmgr.remote;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.RemoteException;
import android.util.SparseArray;
import com.google.gson.Gson;
import com.huawei.al.a;
import com.huawei.datatype.HeartRateData;
import com.huawei.datatype.MotionPath;
import com.huawei.datatype.MotionPathSimplify;
import com.huawei.datatype.PaceIndexStruct;
import com.huawei.datatype.RunPlanInfo;
import com.huawei.datatype.RunPlanParameter;
import com.huawei.datatype.RunPlanRecord;
import com.huawei.datatype.RunPlanRecordInfo;
import com.huawei.datatype.RunPlanRecordStruct;
import com.huawei.datatype.RunPlanReminder;
import com.huawei.datatype.RunPlanStruct;
import com.huawei.datatype.SportType;
import com.huawei.datatype.StepRateData;
import com.huawei.datatype.TrainingStruct;
import com.huawei.datatype.WorkoutDisplayInfo;
import com.huawei.e.g;
import com.huawei.hihealth.HiDataInsertOption;
import com.huawei.hihealth.HiHealthData;
import com.huawei.hihealth.data.model.HiTrackMetaData;
import com.huawei.hihealth.p036a.C0824b;
import com.huawei.hms.support.api.entity.pay.PayStatusCodes;
import com.huawei.hwbasemgr.C0628a;
import com.huawei.hwbasemgr.C0956c;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.d.m;
import com.huawei.hwcommonmodel.datatypes.DeviceCapability;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.hwcommonmodel.datatypes.s;
import com.huawei.hwcommonmodel.datatypes.t;
import com.huawei.hwcommonmodel.datatypes.u;
import com.huawei.hwcommonmodel.datatypes.w;
import com.huawei.hwcommonmodel.p063b.C0976c;
import com.huawei.hwdevicemgr.dmsdatatype.datatype.DeviceCommand;
import com.huawei.hwdevicemgr.p073a.C1023c;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.hwservicesmgr.PhoneService;
import com.huawei.hwservicesmgr.remote.parser.IParser;
import com.huawei.hwservicesmgr.remote.utils.LastSyncTimeStampDB;
import com.huawei.hwservicesmgr.remote.utils.RemoteUtils;
import com.huawei.nfc.carrera.logic.appletcardinfo.model.HciConfigInfo;
import com.huawei.p190v.C2538c;
import com.huawei.ui.main.stories.lightcloud.constants.LightCloudConstants;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HWExerciseAdviceManager extends C0628a implements IParser {
    public static final String COM_HUAWEI_BONE = "com.huawei.bone";
    private static final int EXERCISEADVICE_BLUETOOTH_PINGPONG_TIMEOUT = 300000;
    private static final int EXERCISEADVICE_SYNC_DETAIL_TIMEOUT = 300000;
    private static final int EXERCISE_MGR_POOL_NUM = 5;
    private static final int HOUR = 3600;
    private static final int MSG_EXERCISEADVICE_BT_DISCONNECTED = 1;
    private static final int MSG_EXERCISEADVICE_DEVICE_STOP_APP_TRACK_CHECK = 4;
    private static final int MSG_EXERCISEADVICE_ETE_REPORT_DELAYTIME = 5000;
    private static final int MSG_EXERCISEADVICE_ETE_REPORT_TIMEOUT = 2;
    private static final int MSG_EXERCISEADVICE_SYNC_DETAIL_TIMEOUT = 0;
    private static final int MSG_GET_LOCATION_GPS = 3;
    private static final int OBTAIN_GPS_ERROR = -1;
    private static long ONE_DAY_SECOND = 86400000;
    private static final Object Object = new Object();
    private static final String PLANSHAKEY = "planshakey";
    private static long SEVEN_DAY_SECOND = (7 * ONE_DAY_SECOND);
    private static final int SWIM_AVG_SWOLF_DEFAULT = -1;
    private static final int SWIM_POOL_LENGTH_DEFAULT = -1;
    private static final int SWIM_PULL_RATE_DEFAULT = -1;
    private static final int SWIM_PULL_TIMES_DEFAULT = -1;
    private static final int SWIM_TRIP_TIMES_DEFAULT = -1;
    private static final int SWIM_TYPE_DEFAULT = -1;
    private static final String TAG = "HWExerciseAdviceManager";
    public static final String TRACK_RUN_CURRENT_TIME = "track_run_curenttime";
    public static final String TRACK_RUN_PRE_TIME = "track_run_pretime";
    public static final String WORKOUT_RECORD_SAVE_FINISH = "com.huawei.health.workout_record_save_finish";
    static IBaseResponseCallback deviceSportRemindCallback = new 4();
    private static List<IBaseResponseCallback> getRunPlanRecordCallbackList = new ArrayList();
    private static List<IBaseResponseCallback> getRunPlanRecordInfoCallbackList = new ArrayList();
    private static C1023c hwDeviceMgr;
    private static HWExerciseAdviceManager instance;
    private static String mDevicePlanSha = "";
    private static List<IBaseResponseCallback> notificationRunPlanRecordInfoCallbackList = new ArrayList();
    private static List<IBaseResponseCallback> runPlanParameterCallbackList = new ArrayList();
    private static List<IBaseResponseCallback> setRunPlanCallbackList = new ArrayList();
    private static List<IBaseResponseCallback> setRunPlanReminderSwitchCallbackList = new ArrayList();
    private String currDeviceId = "";
    private long currentTime = 0;
    private String deviceIndentify = "";
    private IBaseResponseCallback deviceWorkoutDetailCallback = new 14(this);
    private IBaseResponseCallback getAdviceParamCallback = new 13(this);
    private IBaseResponseCallback getWorkoutRecordPaceMapCallback = new 7(this);
    private Gson gson = new Gson();
    private g iCallbackInterface;
    private boolean isDetailSyncing = false;
    private long lastSyncTime = 0;
    private final Object lockObject = new Object();
    private List<Integer> lstGPSRunPlanRecordID = new ArrayList();
    private List<Integer> lstGPSWorkoutRecordID = new ArrayList();
    private List<JSONObject> lstWorkoutData = new ArrayList();
    private List<JSONObject> lstWorkoutDetailData = new ArrayList();
    private List<PaceIndexStruct> lstWorkoutRecordPaceMapIDList = new ArrayList();
    private List<JSONObject> lstWorkoutRecordPaceMapList = new ArrayList();
    private BroadcastReceiver mConnectStateChangedReceiver = new 3(this);
    private Context mContext;
    private boolean mDeviceStopAppTrackFlag = false;
    private boolean mDeviceSupportCapacity = false;
    private boolean mDeviceSupportPaceMap = false;
    private Handler mHWExerciseAdviceMgrHandler;
    private HandlerThread mHandlerThread = null;
    private boolean mIsUsingETE = false;
    private String mPlanSha = "0";
    private boolean mRunPlanETEResultFlag = false;
    private int mRunPlanExecuteState = 3;
    private JSONObject mRunPlanRecord;
    private int mRunPlanRecordStatisticIndex = 0;
    private SparseArray<JSONObject> mRunPlanRecordsStatistic = new SparseArray();
    private int mSaveDataItemNum = 0;
    private int[] mSyncPlanSize = new int[]{5, 7};
    private ExecutorService mThreadPool;
    private JSONObject mWorkoutRecord;
    private int mWorkoutRecordStatisticIndex = 0;
    private SparseArray<JSONObject> mWorkoutRecordsStatistic = new SparseArray();
    private Map<Integer, Map<Long, double[]>> mapGPSRunPlan = new HashMap();
    private Map<Integer, Map<Long, double[]>> mapGPSWorkout = new HashMap();
    private Map<Integer, Integer> mapGPSWorkoutAndRunPlanType = new HashMap();
    private String mplanID = "0";
    private boolean notificationGPSParaEnable = true;
    private IBaseResponseCallback syncSuccessCallback = null;

    public void setiCallbackInterface(g gVar) {
        this.iCallbackInterface = gVar;
    }

    public static HWExerciseAdviceManager getInstance() {
        HWExerciseAdviceManager hWExerciseAdviceManager;
        synchronized (Object) {
            if (instance == null) {
                instance = new HWExerciseAdviceManager(BaseApplication.m2632b());
            }
            hWExerciseAdviceManager = instance;
        }
        return hWExerciseAdviceManager;
    }

    private HWExerciseAdviceManager(Context context) {
        super(context);
        this.mContext = context;
        hwDeviceMgr = C1023c.m3920a(this.mContext);
        initDeviceInfo();
        this.mThreadPool = Executors.newFixedThreadPool(5);
        BroadcastReceiver syncWorkoutBroadcastReceiver = new SyncWorkoutBroadcastReceiver(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.huawei.bone.action.FITNESS_DATA_DETAIL_SYNC");
        intentFilter.addAction("com.huawei.phoneservice.sync_workout_broadcast_action");
        C2538c.m12677c(TAG, "HWExerciseAdviceManager to register broadcast");
        this.mContext.registerReceiver(syncWorkoutBroadcastReceiver, intentFilter, C0976c.f1642a, null);
    }

    private void initDeviceInfo() {
        getDeviceSupportCapacity();
        new LastSyncTimeStampDB().createDBTable(this);
        this.mHandlerThread = new HandlerThread(TAG);
        this.mHandlerThread.start();
        this.mHWExerciseAdviceMgrHandler = new HWExerciseAdviceMgrHandler(this, this.mHandlerThread.getLooper());
        this.mPlanSha = getSharedPreference(PLANSHAKEY);
        C2538c.m12674b(TAG, "====advice===initDeviceInfo planSHA=" + this.mPlanSha);
        IntentFilter intentFilter = new IntentFilter("com.huawei.bone.action.CONNECTION_STATE_CHANGED");
        intentFilter.addAction("com.huawei.bone.action.PHONE_SERVICE_BIND_SUCCESS");
        this.mContext.registerReceiver(this.mConnectStateChangedReceiver, intentFilter, C0976c.f1642a, null);
    }

    private void btDisconnectMsgProcess() {
        if (this.notificationGPSParaEnable) {
            C2538c.m12674b(TAG, "unRegisterLocationCallback");
            this.notificationGPSParaEnable = false;
        }
        if (this.mIsUsingETE && 3 != this.mRunPlanExecuteState) {
            this.mIsUsingETE = false;
        }
    }

    public String getCurrDeviceId() {
        String str = "";
        DeviceInfo currentDeviceInfo = getCurrentDeviceInfo();
        if (currentDeviceInfo != null) {
            return currentDeviceInfo.getDeviceIdentify();
        }
        return str;
    }

    private static DeviceInfo getCurrentDeviceInfo() {
        List<DeviceInfo> a = hwDeviceMgr.m3984a();
        if (a.size() != 0) {
            C2538c.m12677c(TAG, "getCurrentDeviceInfo() deviceInfoList.size() = " + a.size());
            for (DeviceInfo deviceInfo : a) {
                if (1 == deviceInfo.getDeviceActiveState()) {
                    return deviceInfo;
                }
            }
            C2538c.m12680e(TAG, "getCurrentDeviceInfo() deviceInfo's ActiveState not DeviceActiveState.DEVICE_ACTIVE_ENABLE");
            return null;
        }
        C2538c.m12680e(TAG, "getCurrentDeviceInfo() deviceInfoList is null");
        return null;
    }

    private void setLastSyncTime(long j) {
        C2538c.m12674b(TAG, "setLastSyncTime time=" + j);
        new LastSyncTimeStampDB().setLastTimeStamp(this, j);
    }

    private long getLastSyncTime() {
        C2538c.m12674b(TAG, "getLastSyncTime enter");
        return new LastSyncTimeStampDB().getLastTimeStamp(this);
    }

    private void notifyDetailSyncComplete(int i, String str) {
        C2538c.m12677c(TAG, "notifyDetailSyncComplete errCode=" + i);
        if (this.mHWExerciseAdviceMgrHandler != null) {
            this.mHWExerciseAdviceMgrHandler.removeMessages(0);
        }
        if (i == 0 || -1 == i) {
            new Thread(new 1(this, i)).start();
        } else {
            this.isDetailSyncing = false;
            C2538c.m12680e(TAG, "notifyDetailSyncComplete fail for " + str);
        }
        notifyToSyncStressData();
    }

    private void notifyToSyncStressData() {
        C2538c.m12677c(TAG, "notifyToSyncStressData() enter.");
        Intent intent = new Intent("com.huawei.bone.stress_and_relax_sync");
        intent.setPackage("com.huawei.bone");
        BaseApplication.m2632b().sendBroadcast(intent, C0976c.f1642a);
    }

    private void saveDate() {
        PhoneService.m4195a(0);
        this.mSaveDataItemNum = 0;
        try {
            JSONObject jSONObject;
            JSONArray jSONArray;
            Integer num;
            int intValue;
            if (this.mWorkoutRecord != null) {
                JSONArray jSONArray2 = this.mWorkoutRecord.getJSONArray("workoutRecordStructList");
                for (int i = 0; i < jSONArray2.length(); i++) {
                    int i2 = jSONArray2.getJSONObject(i).getInt("workout_record_id");
                    C2538c.m12674b(TAG, "=====zz======== " + i + "  保存：=recordid" + i2);
                    jSONObject = (JSONObject) this.mWorkoutRecordsStatistic.get(i2);
                    jSONArray = new JSONArray();
                    for (JSONObject jSONObject2 : this.lstWorkoutDetailData) {
                        if (i2 == jSONObject2.getInt("workout_record_id")) {
                            jSONArray.put(jSONObject2);
                        }
                    }
                    JSONArray jSONArray3 = new JSONArray();
                    for (JSONObject jSONObject22 : this.lstWorkoutRecordPaceMapList) {
                        if (i2 == jSONObject22.getInt("workout_record_id")) {
                            jSONArray3.put(jSONObject22);
                        }
                    }
                    C2538c.m12674b(TAG, "=====zz=========DetailData size:" + jSONArray.length() + ", workout type:" + jSONObject.get("workout_type"));
                    if (this.mapGPSWorkout.get(Integer.valueOf(i2)) != null) {
                        C2538c.m12677c(TAG, "=====zz=========mapGPSWorkout size:" + ((Map) this.mapGPSWorkout.get(Integer.valueOf(i2))).size());
                    }
                    if (checkSupportWorkoutType(jSONObject.getInt("workout_type"))) {
                        this.mSaveDataItemNum++;
                        num = (Integer) this.mapGPSWorkoutAndRunPlanType.get(Integer.valueOf(i2));
                        if (num != null) {
                            intValue = num.intValue();
                        } else {
                            intValue = -1;
                        }
                        saveDatatoTrack(jSONObject, jSONArray, (Map) this.mapGPSWorkout.get(Integer.valueOf(i2)), intValue, jSONArray3);
                    } else {
                        C2538c.m12674b(TAG, "workout type:" + jSONObject.getInt("workout_type") + ",is not support, do not save!");
                    }
                }
            }
            if (this.mRunPlanRecord != null) {
                JSONArray jSONArray4 = this.mRunPlanRecord.getJSONArray("runPlanRecordStructList");
                for (int i3 = 0; i3 < jSONArray4.length(); i3++) {
                    int intValue2;
                    intValue = jSONArray4.getJSONObject(i3).getInt("run_plan_record_id");
                    jSONObject = (JSONObject) this.mRunPlanRecordsStatistic.get(intValue);
                    jSONArray = new JSONArray();
                    for (JSONObject jSONObject222 : this.lstWorkoutDetailData) {
                        if (intValue == jSONObject222.getInt("workout_record_id")) {
                            jSONArray.put(jSONObject222);
                        }
                    }
                    JSONArray jSONArray5 = new JSONArray();
                    for (JSONObject jSONObject2222 : this.lstWorkoutRecordPaceMapList) {
                        if (intValue == jSONObject2222.getInt("workout_record_id")) {
                            jSONArray5.put(jSONObject2222);
                        }
                    }
                    C2538c.m12677c(TAG, "=====zz=========runplan_workout_id:" + jSONArray4.getJSONObject(i3).getInt("run_plan_workout_id"));
                    C2538c.m12674b(TAG, "=====zz=========DetailData size:" + jSONArray.length());
                    if (this.mapGPSRunPlan.get(Integer.valueOf(intValue)) != null) {
                        C2538c.m12677c(TAG, "=====zz=========mapGPSRunPlan size:" + ((Map) this.mapGPSRunPlan.get(Integer.valueOf(intValue))).size());
                    }
                    this.mSaveDataItemNum++;
                    num = (Integer) this.mapGPSWorkoutAndRunPlanType.get(Integer.valueOf(intValue));
                    if (num != null) {
                        intValue2 = num.intValue();
                    } else {
                        intValue2 = -1;
                    }
                    saveDatatoTrack(jSONObject, jSONArray, jSONArray4.getJSONObject(i3).getInt("run_plan_workout_id"), (Map) this.mapGPSRunPlan.get(Integer.valueOf(intValue)), intValue2, jSONArray5);
                }
            }
        } catch (JSONException e) {
            C2538c.m12680e(TAG, e.getMessage());
        }
    }

    private void saveDatatoTrack(JSONObject jSONObject, JSONArray jSONArray, int i, Map<Long, double[]> map, int i2, JSONArray jSONArray2) {
        MotionPath motionPath = new MotionPath();
        Object motionPathSimplify = new MotionPathSimplify();
        motionPathSimplify.setMapType(i2);
        if (map != null) {
            motionPath.setLbsDataMap(map);
        }
        try {
            Map changePaceMapStruct;
            int i3 = (int) jSONObject.getLong("run_plan_record_info_exercise_duration");
            if (jSONArray2 != null) {
                changePaceMapStruct = changePaceMapStruct(jSONArray2, 0);
                motionPath.setPaceMap(changePaceMapStruct);
                motionPathSimplify.setPaceMap(changePaceMapStruct);
                changePaceMapStruct = changePaceMapStruct(jSONArray2, 1);
                motionPath.setBritishPaceMap(changePaceMapStruct);
                motionPathSimplify.setBritishPaceMap(changePaceMapStruct);
                motionPathSimplify.setPartTimeMap(changePartTimePaceMapStruct(jSONArray2, 0, i3 / 1000));
                motionPathSimplify.setBritishPartTimeMap(changePartTimePaceMapStruct(jSONArray2, 1, i3 / 1000));
            }
            motionPathSimplify.setTotalSteps(jSONObject.getInt("run_plan_record_info_step"));
            motionPathSimplify.setTotalTime((long) i3);
            packTrackData(jSONArray, motionPath, motionPathSimplify);
            WorkoutDisplayInfo workoutDisplayInfo = new WorkoutDisplayInfo();
            checkWorkoutDisplayInfo(1, map, workoutDisplayInfo);
            motionPathSimplify.setChiefSportDataType(workoutDisplayInfo.getChiefSportDataType());
            motionPathSimplify.setIsFreeMotion(workoutDisplayInfo.getFreeMotion());
            motionPathSimplify.setSportType(workoutDisplayInfo.getWorkoutType());
            motionPathSimplify.setHasTrackPoint(workoutDisplayInfo.isHasTrackPoint());
            motionPathSimplify.setSportDataSource(workoutDisplayInfo.getSportDataSource());
            motionPathSimplify.setStartTime(jSONObject.getLong("run_plan_record_info_start_time"));
            C2538c.m12674b(TAG, "=====zz========startTime:" + jSONObject.getLong("run_plan_record_info_start_time") + "===");
            motionPathSimplify.setEndTime(jSONObject.getLong("run_plan_record_info_end_time"));
            C2538c.m12674b(TAG, "=====zz========endTime:" + jSONObject.getLong("run_plan_record_info_end_time") + "===");
            motionPathSimplify.setMaxHeartRate(jSONObject.getInt("run_plan_record_info_HrABS_max"));
            motionPathSimplify.setMinHeartRate(jSONObject.getInt("run_plan_record_info_HrABS_min"));
            motionPathSimplify.setTotalDistance(jSONObject.getInt("run_plan_record_info_distance"));
            motionPathSimplify.setTotalCalories(jSONObject.getInt("run_plan_record_info_calorie") * 1000);
            motionPathSimplify.setCreepingWave((float) jSONObject.getInt("run_plan_record_info_climb"));
            if (jSONObject.getInt("run_plan_record_info_distance") == 0) {
                C2538c.m12674b(TAG, "=====zz========run record speed:" + jSONObject.getInt("run_plan_record_info_speed") + "===");
                motionPathSimplify.setAvgPace(0.0f);
            } else {
                motionPathSimplify.setAvgPace(1000.0f / ((((float) jSONObject.getInt("run_plan_record_info_distance")) * 1000.0f) / ((float) jSONObject.getInt("run_plan_record_info_exercise_duration"))));
            }
            motionPathSimplify.setAvgStepRate((int) ((((float) (jSONObject.getInt("run_plan_record_info_step") * 1000)) / ((float) jSONObject.getInt("run_plan_record_info_exercise_duration"))) * 60.0f));
            changePaceMapStruct = new HashMap();
            changePaceMapStruct.put("record_id", Integer.valueOf(jSONObject.getInt("run_plan_record_info_id")));
            changePaceMapStruct.put("status", Integer.valueOf(jSONObject.getInt("run_plan_record_info_status")));
            changePaceMapStruct.put("load_peak", Integer.valueOf(jSONObject.getInt("run_plan_record_info_load_peak")));
            changePaceMapStruct.put("etraining_effect", Integer.valueOf(jSONObject.getInt("run_plan_record_info_etraining_effect")));
            changePaceMapStruct.put("extra_poc", Integer.valueOf(jSONObject.getInt("run_plan_record_info_Epoc")));
            changePaceMapStruct.put("max_met", Integer.valueOf(jSONObject.getInt("run_plan_record_info_maxMET")));
            changePaceMapStruct.put("recovery_time", Integer.valueOf(jSONObject.getInt("run_plan_record_info_recovery_time")));
            changePaceMapStruct.put("achieve_percent", Integer.valueOf(jSONObject.getInt("run_plan_record_info_achieve_percent")));
            motionPathSimplify.setSportData(changePaceMapStruct);
            try {
                if (this.iCallbackInterface != null) {
                    Map a = this.iCallbackInterface.a(new Gson().toJson(motionPathSimplify), i);
                    if (a.containsKey(TRACK_RUN_CURRENT_TIME)) {
                        changePaceMapStruct.put(TRACK_RUN_CURRENT_TIME, a.get(TRACK_RUN_CURRENT_TIME));
                    }
                    if (a.containsKey(TRACK_RUN_PRE_TIME)) {
                        changePaceMapStruct.put(TRACK_RUN_PRE_TIME, a.get(TRACK_RUN_PRE_TIME));
                    }
                }
            } catch (RemoteException e) {
                C2538c.m12680e(TAG, e.getMessage());
            }
            motionPathSimplify.setSportData(changePaceMapStruct);
        } catch (JSONException e2) {
            C2538c.m12680e(TAG, e2.getMessage());
        }
        saveTrackData(motionPathSimplify, motionPath);
        C2538c.m12677c(TAG, "save runPlan Record DatatoTrack finish");
    }

    public int saveTrackData(MotionPathSimplify motionPathSimplify, MotionPath motionPath) {
        C2538c.m12677c(TAG, "saveTrackData MotionPath is enter");
        HiDataInsertOption hiDataInsertOption = new HiDataInsertOption();
        convertHealthTrackDataToHiData(motionPathSimplify, motionPath, hiDataInsertOption);
        DeviceInfo currentDeviceInfo = getCurrentDeviceInfo();
        if (currentDeviceInfo != null) {
            a.a(currentDeviceInfo);
        }
        C0824b.m2914a(BaseApplication.m2632b()).m2903a(hiDataInsertOption, new 2(this));
        return 1;
    }

    private Map<Integer, Float> changePaceMapStruct(JSONArray jSONArray, int i) {
        if (jSONArray == null) {
            return null;
        }
        Map<Integer, Float> treeMap = new TreeMap();
        int i2 = 0;
        while (i2 < jSONArray.length()) {
            try {
                JSONObject jSONObject = (JSONObject) jSONArray.get(i2);
                C2538c.m12674b(TAG, "paceMapList=" + jSONObject.getJSONArray("paceMapList").toString());
                JSONArray jSONArray2 = jSONObject.getJSONArray("paceMapList");
                int i3;
                int i4;
                JSONObject jSONObject2;
                boolean z;
                int i5;
                int i6;
                int round;
                if (i == 0) {
                    i3 = 0;
                    for (i4 = 0; i4 < jSONArray2.length(); i4++) {
                        jSONObject2 = jSONArray2.getJSONObject(i4);
                        if (jSONObject2.optInt("unit_type", -1) == 0) {
                            z = jSONObject2.getBoolean("isLastLessDistance");
                            i5 = jSONObject2.getInt("pace");
                            i6 = jSONObject2.getInt("point_index");
                            if (z) {
                                round = (int) Math.round(((double) jSONObject2.getInt("lastLessDistance")) / 100.0d);
                                if (round != 0) {
                                    treeMap.put(Integer.valueOf(((round + (i3 * 100)) * 100000) + i6), Float.valueOf((float) i5));
                                }
                            } else {
                                i3 = jSONObject2.getInt("distance");
                                treeMap.put(Integer.valueOf(((i3 * 100) * 100000) + i6), Float.valueOf((float) i5));
                            }
                        }
                    }
                    continue;
                } else {
                    i3 = 0;
                    for (i4 = 0; i4 < jSONArray2.length(); i4++) {
                        jSONObject2 = jSONArray2.getJSONObject(i4);
                        if (1 == jSONObject2.optInt("unit_type", -1)) {
                            z = jSONObject2.getBoolean("isLastLessDistance");
                            i5 = jSONObject2.getInt("pace");
                            i6 = jSONObject2.getInt("point_index");
                            if (z) {
                                round = (int) Math.round(C0956c.m3342a(((double) jSONObject2.getInt("lastLessDistance")) / 100.0d, 3));
                                if (round != 0) {
                                    treeMap.put(Integer.valueOf(((round + (i3 * 100)) * 100000) + i6), Float.valueOf((float) i5));
                                }
                            } else {
                                i3 = jSONObject2.getInt("distance");
                                treeMap.put(Integer.valueOf(((i3 * 100) * 100000) + i6), Float.valueOf((float) i5));
                            }
                        }
                    }
                }
                i2++;
            } catch (JSONException e) {
                C2538c.m12680e(TAG, "changePaceMapStruct error = " + e.getMessage());
                return null;
            }
        }
        C2538c.m12674b(TAG, "changePaceMapStruct paceMap size=" + treeMap.size());
        return treeMap;
    }

    private Map<Double, Double> changePartTimePaceMapStruct(JSONArray jSONArray, int i, int i2) {
        if (jSONArray == null) {
            return null;
        }
        Map<Double, Double> treeMap = new TreeMap();
        int i3 = 0;
        int i4 = 0;
        while (i4 < jSONArray.length()) {
            try {
                JSONObject jSONObject = (JSONObject) jSONArray.get(i4);
                JSONArray jSONArray2 = new JSONArray();
                JSONArray jSONArray3 = jSONObject.getJSONArray("paceMapList");
                for (int i5 = 0; i5 < jSONArray3.length(); i5++) {
                    jSONObject = (JSONObject) jSONArray3.get(i5);
                    if (i == jSONObject.optInt("unit_type", -1)) {
                        jSONArray2.put(jSONObject);
                    }
                }
                int i6 = i3;
                for (i3 = 0; i3 < jSONArray2.length(); i3++) {
                    JSONObject jSONObject2 = jSONArray2.getJSONObject(i3);
                    if (!jSONObject2.getBoolean("isLastLessDistance")) {
                        i6 += jSONObject2.getInt("pace");
                        treeMap.put(Double.valueOf(((double) (jSONObject2.getInt("distance") * 10000)) / 10000.0d), Double.valueOf((double) i6));
                    }
                }
                i4++;
                i3 = i6;
            } catch (JSONException e) {
                C2538c.m12680e(TAG, "changePartTimePaceMapStruct error = " + e.getMessage());
                return null;
            }
        }
        C2538c.m12674b(TAG, "changePartTimePaceMapStruct paceMap size=" + treeMap.size());
        return treeMap;
    }

    private boolean checkSupportWorkoutType(int i) {
        if (1 == i || 2 == i || 3 == i || 9 == i || 10 == i || 6 == i || 8 == i || 5 == i || 7 == i || 255 == i) {
            return true;
        }
        return false;
    }

    private void checkWorkoutDisplayInfo(int i, Map<Long, double[]> map, WorkoutDisplayInfo workoutDisplayInfo) {
        if (map == null || map.size() <= 2) {
            workoutDisplayInfo.setHasTrackPoint(false);
        } else {
            workoutDisplayInfo.setHasTrackPoint(true);
        }
        switch (i) {
            case 1:
            case 9:
            case 10:
                workoutDisplayInfo.setWorkoutType(SportType.SPORT_TYPE_RUN);
                return;
            case 2:
                workoutDisplayInfo.setWorkoutType(257);
                return;
            case 3:
                workoutDisplayInfo.setWorkoutType(SportType.SPORT_TYPE_BIKE);
                return;
            case 5:
                workoutDisplayInfo.setWorkoutType(SportType.SPORT_TYPE_TREADMILL);
                workoutDisplayInfo.setFreeMotion(true);
                return;
            case 6:
                workoutDisplayInfo.setWorkoutType(SportType.SPORT_TYPE_SWIM);
                workoutDisplayInfo.setChiefSportDataType(0);
                workoutDisplayInfo.setFreeMotion(true);
                return;
            case 7:
                workoutDisplayInfo.setWorkoutType(265);
                workoutDisplayInfo.setChiefSportDataType(1);
                workoutDisplayInfo.setFreeMotion(true);
                return;
            case 8:
                workoutDisplayInfo.setWorkoutType(266);
                workoutDisplayInfo.setChiefSportDataType(0);
                workoutDisplayInfo.setFreeMotion(true);
                return;
            case 255:
                workoutDisplayInfo.setWorkoutType(279);
                workoutDisplayInfo.setChiefSportDataType(1);
                workoutDisplayInfo.setFreeMotion(true);
                return;
            default:
                workoutDisplayInfo.setWorkoutType(SportType.SPORT_TYPE_RUN);
                return;
        }
    }

    public static void convertHealthTrackDataToHiData(MotionPathSimplify motionPathSimplify, MotionPath motionPath, HiDataInsertOption hiDataInsertOption) {
        C2538c.m12677c(TAG, "convertHealthTrackDataToHiData, simplifyData " + motionPathSimplify.toString());
        C2538c.m12677c(TAG, "convertHealthTrackDataToHiData, motionData " + motionPath.toString());
        Object hiTrackMetaData = new HiTrackMetaData();
        String str = null;
        if (motionPathSimplify.getMapType() == 0) {
            str = "AMAP";
        } else if (1 == motionPathSimplify.getMapType()) {
            str = "GOOGLE";
        }
        if (str != null) {
            C2538c.m12677c(TAG, "convertHealthTrackDataToHiData, null != vendor ,vendor=" + str);
            hiTrackMetaData.setVendor(str);
        }
        hiTrackMetaData.setAvgStepRate(motionPathSimplify.getAvgStepRate());
        hiTrackMetaData.setAvgHeartRate(motionPathSimplify.getAvgHeartRate());
        hiTrackMetaData.setAvgPace(motionPathSimplify.getAvgPace());
        hiTrackMetaData.setBestPace(motionPathSimplify.getBestPace());
        hiTrackMetaData.setBestStepRate(motionPathSimplify.getBestStepRate());
        hiTrackMetaData.setMaxHeartRate(motionPathSimplify.getMaxHeartRate());
        hiTrackMetaData.setSportType(motionPathSimplify.getSportType());
        hiTrackMetaData.setTotalCalories(motionPathSimplify.getTotalCalories());
        hiTrackMetaData.setTotalDistance(motionPathSimplify.getTotalDistance());
        hiTrackMetaData.setTotalSteps(motionPathSimplify.getTotalSteps());
        hiTrackMetaData.setTotalTime(motionPathSimplify.getTotalTime());
        hiTrackMetaData.setWearSportData(motionPathSimplify.getSportData());
        hiTrackMetaData.setCreepingWave(motionPathSimplify.getCreepingWave());
        hiTrackMetaData.setMinHeartRate(motionPathSimplify.getMinHeartRate());
        hiTrackMetaData.setTrackType(motionPathSimplify.getTrackType());
        hiTrackMetaData.setWearSportData(motionPathSimplify.getSportData());
        hiTrackMetaData.setIsFreeMotion(motionPathSimplify.getIsFreeMotion());
        hiTrackMetaData.setSportDataSource(motionPathSimplify.getSportDataSource());
        hiTrackMetaData.setChiefSportDataType(motionPathSimplify.getChiefSportDataType());
        hiTrackMetaData.setHasTrackPoint(motionPathSimplify.getHasTrackPoint());
        hiTrackMetaData.setPaceMap(motionPathSimplify.getPaceMap());
        hiTrackMetaData.setPartTimeMap(motionPathSimplify.getPartTimeMap());
        hiTrackMetaData.setBritishPaceMap(motionPathSimplify.getBritishPaceMap());
        hiTrackMetaData.setBritishPartTimeMap(motionPathSimplify.getBritishPartTimeMap());
        int a = com.huawei.f.a.a(motionPathSimplify.getSportType(), motionPathSimplify.getPaceMap(), motionPathSimplify.getAvgPace());
        C2538c.m12677c(TAG, "mAbnormalTrack:" + a + HwAccountConstants.BLANK + motionPathSimplify.getSportType() + HwAccountConstants.BLANK + motionPathSimplify.getAvgPace());
        motionPathSimplify.saveAbnormalTrack(a);
        hiTrackMetaData.setAbnormalTrack(motionPathSimplify.requestAbnormalTrack());
        HiHealthData hiHealthData = new HiHealthData();
        hiHealthData.setStartTime(motionPathSimplify.getStartTime());
        hiHealthData.setEndTime(motionPathSimplify.getEndTime());
        hiHealthData.setType(PayStatusCodes.PAY_STATE_PARAM_ERROR);
        hiHealthData.setSequenceData(motionPath.toString());
        hiHealthData.setMetaData(new Gson().toJson(hiTrackMetaData, (Type) HiTrackMetaData.class));
        str = "";
        DeviceInfo currentDeviceInfo = getCurrentDeviceInfo();
        if (currentDeviceInfo != null) {
            str = currentDeviceInfo.getUUID();
        } else {
            C2538c.m12677c(TAG, "convertHealthTrackDataToHiData, deviceInfo is null");
        }
        hiHealthData.setDeviceUUID(str + "#ANDROID21");
        hiDataInsertOption.addData(hiHealthData);
    }

    private void saveDatatoTrack(JSONObject jSONObject, JSONArray jSONArray, Map<Long, double[]> map, int i, JSONArray jSONArray2) {
        MotionPath motionPath = new MotionPath();
        if (map != null) {
            motionPath.setLbsDataMap(map);
        }
        MotionPathSimplify motionPathSimplify = new MotionPathSimplify();
        motionPathSimplify.setMapType(i);
        try {
            int i2 = (int) jSONObject.getLong("workout_exercise_duration");
            if (jSONArray2 != null) {
                Map changePaceMapStruct = changePaceMapStruct(jSONArray2, 0);
                motionPath.setPaceMap(changePaceMapStruct);
                motionPathSimplify.setPaceMap(changePaceMapStruct);
                changePaceMapStruct = changePaceMapStruct(jSONArray2, 1);
                motionPath.setBritishPaceMap(changePaceMapStruct);
                motionPathSimplify.setBritishPaceMap(changePaceMapStruct);
                motionPathSimplify.setPartTimeMap(changePartTimePaceMapStruct(jSONArray2, 0, i2 / 1000));
                motionPathSimplify.setBritishPartTimeMap(changePartTimePaceMapStruct(jSONArray2, 1, i2 / 1000));
            }
            motionPathSimplify.setTotalTime((long) i2);
            motionPathSimplify.setTotalSteps(((Integer) jSONObject.get("workout_record_step")).intValue());
            packTrackData(jSONArray, motionPath, motionPathSimplify);
            WorkoutDisplayInfo workoutDisplayInfo = new WorkoutDisplayInfo();
            checkWorkoutDisplayInfo(jSONObject.getInt("workout_type"), map, workoutDisplayInfo);
            motionPathSimplify.setChiefSportDataType(workoutDisplayInfo.getChiefSportDataType());
            motionPathSimplify.setIsFreeMotion(workoutDisplayInfo.getFreeMotion());
            motionPathSimplify.setSportType(workoutDisplayInfo.getWorkoutType());
            motionPathSimplify.setHasTrackPoint(workoutDisplayInfo.isHasTrackPoint());
            motionPathSimplify.setSportDataSource(workoutDisplayInfo.getSportDataSource());
            C2538c.m12674b(TAG, "=====zz========workout_type:" + workoutDisplayInfo.getWorkoutType() + "===");
            motionPathSimplify.setStartTime(jSONObject.getLong("workout_record_start_time"));
            C2538c.m12674b(TAG, "=====zz========startTime:" + jSONObject.getLong("workout_record_start_time") + "===");
            motionPathSimplify.setEndTime(jSONObject.getLong("workout_record_end_time"));
            C2538c.m12674b(TAG, "=====zz========endTime:" + jSONObject.getLong("workout_record_end_time") + "===");
            motionPathSimplify.setMaxHeartRate(jSONObject.getInt("workout_HrABS_peak_max"));
            motionPathSimplify.setMinHeartRate(jSONObject.getInt("workout_HrABS_peak_min"));
            motionPathSimplify.setTotalDistance(jSONObject.getInt("workout_record_distance"));
            motionPathSimplify.setTotalCalories(jSONObject.getInt("workout_record_calorie") * 1000);
            motionPathSimplify.setTotalTime(jSONObject.getLong("workout_exercise_duration"));
            C2538c.m12674b(TAG, "=====zz========exercise_duration:" + jSONObject.getLong("workout_exercise_duration") + "===");
            motionPathSimplify.setCreepingWave((float) jSONObject.getDouble("workout_climb"));
            motionPathSimplify.setTotalSteps(((Integer) jSONObject.get("workout_record_step")).intValue());
            if (jSONObject.getInt("workout_record_distance") == 0) {
                C2538c.m12674b(TAG, "=====zz========record speed:" + jSONObject.getInt("workout_record_speed") + "===");
                motionPathSimplify.setAvgPace(0.0f);
            } else {
                motionPathSimplify.setAvgPace(1000.0f / ((((float) jSONObject.getInt("workout_record_distance")) * 1000.0f) / ((float) jSONObject.getLong("workout_exercise_duration"))));
            }
            motionPathSimplify.setAvgStepRate((int) ((((float) (jSONObject.getInt("workout_record_step") * 1000)) / ((float) jSONObject.getLong("workout_exercise_duration"))) * 60.0f));
            if (SportType.SPORT_TYPE_SWIM == workoutDisplayInfo.getWorkoutType() || 266 == workoutDisplayInfo.getWorkoutType()) {
                i2 = jSONObject.getInt("workout_record_speed");
                C2538c.m12674b(TAG, "swim, speed:" + i2);
                if (i2 != 0) {
                    float f = 10000.0f / ((float) i2);
                    C2538c.m12674b(TAG, "swim, speed_float:" + f);
                    motionPathSimplify.setAvgPace(f);
                } else {
                    C2538c.m12674b(TAG, "swim, speed:" + i2);
                    motionPathSimplify.setAvgPace(0.0f);
                }
                i2 = jSONObject.getInt("workout_record_distance");
                C2538c.m12674b(TAG, "swim, distance_swim:" + i2);
                if (i2 == 0) {
                    motionPathSimplify.setChiefSportDataType(2);
                } else {
                    motionPathSimplify.setChiefSportDataType(0);
                }
            }
            Map hashMap = new HashMap();
            hashMap.put("record_id", Integer.valueOf(jSONObject.getInt("workout_record_id")));
            hashMap.put("status", Integer.valueOf(jSONObject.getInt("workout_record_status")));
            hashMap.put("load_peak", Integer.valueOf(jSONObject.getInt("workout_load_peak")));
            hashMap.put("etraining_effect", Integer.valueOf(jSONObject.getInt("workout_etraining_effect")));
            hashMap.put("extra_poc", Integer.valueOf(jSONObject.getInt("workout_Epoc")));
            hashMap.put("max_met", Integer.valueOf(jSONObject.getInt("workout_maxMET")));
            hashMap.put("recovery_time", Integer.valueOf(jSONObject.getInt("workout_recovery_time")));
            C2538c.m12674b(TAG, "swim, swim_type:" + jSONObject.getInt("swim_type"));
            C2538c.m12674b(TAG, "swim, swim_pull_times:" + jSONObject.getInt("swim_pull_times"));
            C2538c.m12674b(TAG, "swim, swim_pull_rate:" + jSONObject.getInt("swim_pull_rate"));
            C2538c.m12674b(TAG, "swim, swim_pool_length:" + jSONObject.getInt("swim_pool_length"));
            C2538c.m12674b(TAG, "swim, swim_trip_times:" + jSONObject.getInt("swim_trip_times"));
            C2538c.m12674b(TAG, "swim, swim_avg_swolf:" + jSONObject.getInt("swim_avg_swolf"));
            if (-1 != jSONObject.getInt("swim_type")) {
                hashMap.put("swim_stroke", Integer.valueOf(jSONObject.getInt("swim_type")));
            }
            if (-1 != jSONObject.getInt("swim_pull_times")) {
                hashMap.put("swim_pull_times", Integer.valueOf(jSONObject.getInt("swim_pull_times")));
            }
            if (-1 != jSONObject.getInt("swim_pull_rate")) {
                hashMap.put("swim_pull_freq", Integer.valueOf(jSONObject.getInt("swim_pull_rate")));
            }
            if (-1 != jSONObject.getInt("swim_pool_length")) {
                hashMap.put("swim_pool_length", Integer.valueOf(jSONObject.getInt("swim_pool_length")));
            }
            if (-1 != jSONObject.getInt("swim_trip_times")) {
                hashMap.put("swim_laps", Integer.valueOf(jSONObject.getInt("swim_trip_times")));
            }
            if (-1 != jSONObject.getInt("swim_avg_swolf")) {
                hashMap.put("swim_avg_swolf", Integer.valueOf(jSONObject.getInt("swim_avg_swolf")));
            }
            motionPathSimplify.setSportData(hashMap);
            saveTrackData(motionPathSimplify, motionPath);
            C2538c.m12677c(TAG, "save workout Record DatatoTrack finish");
        } catch (JSONException e) {
            C2538c.m12680e(TAG, "JSONException :" + e.getMessage());
        }
    }

    private void packTrackData(JSONArray jSONArray, MotionPath motionPath, MotionPathSimplify motionPathSimplify) {
        int i;
        int i2;
        long j;
        int i3;
        long j2;
        JSONException jSONException;
        long j3;
        int i4;
        int i5;
        JSONException jSONException2;
        int i6;
        int i7;
        long j4;
        long j5;
        long j6;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i8 = 0;
        long j7 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        long j8 = 0;
        int i12 = 0;
        int i13 = 0;
        long j9 = 0;
        int length = jSONArray.length();
        C2538c.m12677c(TAG, "the size is " + length);
        C2538c.m12677c(TAG, "the detail is " + jSONArray.toString());
        try {
            i12 = motionPathSimplify.getTotalSteps();
            j9 = motionPathSimplify.getTotalTime();
            int i14 = 0;
            i = 0;
            i13 = 0;
            int i15 = 0;
            i2 = 0;
            j = 0;
            while (i14 < length) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i14);
                    C2538c.m12674b(TAG, (Object[]) new Object[]{"=====zz=====detailID" + jSONObject.getInt("workout_record_id") + "===index:" + jSONObject.getInt("workout_data_index") + "==="});
                    long j10 = jSONObject.getJSONObject("dataHeader").getLong(HciConfigInfo.HCI_DATA_TYPE_TRANSCTION_TIME);
                    int i16 = jSONObject.getJSONObject("dataHeader").getInt("timeInterval");
                    int length2 = jSONObject.getJSONObject("dataHeader").getJSONArray("workoutDataInfoList").length();
                    i3 = i9 + length2;
                    int i17 = i10;
                    j2 = j8;
                    int i18 = i11;
                    int i19 = 0;
                    long j11 = j2;
                    i9 = i13;
                    i13 = i15;
                    while (i19 < length2) {
                        JSONObject jSONObject2 = jSONObject.getJSONObject("dataHeader").getJSONArray("workoutDataInfoList").getJSONObject(i19);
                        if (i18 % 12 == 0) {
                            j11 = (((long) (i16 * i19)) * 1000) + j10;
                        }
                        int i20 = jSONObject2.getInt("data1");
                        C2538c.m12674b(TAG, (Object[]) new Object[]{"=====zz======== heart value :" + i20});
                        i15 = jSONObject2.getInt("data2");
                        if (i15 > i2) {
                            i2 = i15;
                        }
                        C2538c.m12674b(TAG, "=====zz========time:" + ((((long) (i16 * i19)) * 1000) + j10) + "===详细数据== 速度=" + i15);
                        j += (long) i15;
                        i15 = jSONObject2.getInt("data3");
                        String str = TAG;
                        String[] strArr = new Object[1];
                        strArr[0] = "=====zz========time:" + ((((long) (i16 * i19)) * 1000) + j10) + "===详细数据== 步频(data3)=" + i15;
                        C2538c.m12674b(str, (Object[]) strArr);
                        i8 += i15;
                        i15 += i17;
                        if (!(i20 == 0 || 255 == i20)) {
                            HeartRateData heartRateData = new HeartRateData();
                            heartRateData.setTime((((long) (i16 * i19)) * 1000) + j10);
                            heartRateData.setHeartRate(i20);
                            j7 += (long) i20;
                            i9++;
                            arrayList.add(heartRateData);
                        }
                        i18++;
                        if (i18 % 12 == 0) {
                            StepRateData stepRateData = new StepRateData();
                            stepRateData.setTime(j11);
                            stepRateData.setStepRate(i15);
                            arrayList2.add(stepRateData);
                            if (i15 > i13) {
                                try {
                                    i = arrayList2.size() - 1;
                                    i13 = i15;
                                } catch (JSONException e) {
                                    jSONException = e;
                                    i13 = i;
                                    j3 = j9;
                                    i4 = i9;
                                    i5 = i3;
                                    jSONException2 = jSONException;
                                    long j12 = j7;
                                    i6 = i8;
                                    i7 = i15;
                                    j4 = j12;
                                    j5 = j3;
                                }
                            }
                            try {
                                C2538c.m12674b(TAG, (Object[]) new Object[]{"=====zz========time:" + j11 + "===详细数据== 步频=" + i15});
                                i15 = 0;
                            } catch (JSONException e2) {
                                j3 = j9;
                                i4 = i9;
                                i5 = i3;
                                jSONException2 = e2;
                                int i21 = i;
                                j5 = j3;
                                long j13 = j7;
                                i6 = i8;
                                i7 = i13;
                                j4 = j13;
                                i13 = i21;
                            }
                        }
                        i19++;
                        i17 = i15;
                    }
                    i14++;
                    i15 = i13;
                    i13 = i9;
                    i9 = i3;
                    j8 = j11;
                    i10 = i17;
                    i11 = i18;
                } catch (JSONException e3) {
                    jSONException2 = e3;
                    j2 = j9;
                    i4 = i13;
                    i5 = i9;
                    i13 = i;
                    j6 = j7;
                    i6 = i8;
                    i7 = i15;
                    j4 = j6;
                    j5 = j2;
                }
            }
            if (i11 % 12 != 0) {
                StepRateData stepRateData2 = new StepRateData();
                stepRateData2.setTime(j8);
                stepRateData2.setStepRate(i10);
                arrayList2.add(stepRateData2);
                if (i10 > i15) {
                    try {
                        i = arrayList2.size() - 1;
                        i15 = i10;
                    } catch (JSONException e22) {
                        jSONException2 = e22;
                        j2 = j9;
                        i4 = i13;
                        i5 = i9;
                        i13 = i;
                        j5 = j2;
                        j6 = j7;
                        i6 = i8;
                        i7 = i10;
                        j4 = j6;
                        C2538c.m12680e(TAG, jSONException2.getMessage());
                        C2538c.m12677c(TAG, "summaryTotalStep=" + i12 + ", iTotalStep=" + i6 + ", totaltime=" + ((j5 / 1000) / 60));
                        i3 = (int) ((((float) (i12 - i6)) / ((float) arrayList2.size())) + 0.5f);
                        for (i12 = 0; i12 < arrayList2.size(); i12++) {
                            ((StepRateData) arrayList2.get(i12)).setStepRate(((StepRateData) arrayList2.get(i12)).getStepRate() + i3);
                        }
                        if (i13 < arrayList2.size()) {
                            i7 = ((StepRateData) arrayList2.get(i13)).getStepRate();
                        }
                        motionPath.setHeartRateList(arrayList);
                        motionPath.setStepRateList(arrayList2);
                        motionPathSimplify.setSportId("gps_maptracking_" + m.a(new Date(), "yyyyMMddHHmmssSSS"));
                        C2538c.m12674b(TAG, "=====zz========sportId:" + r4 + "===");
                        motionPathSimplify.setSportType(SportType.SPORT_TYPE_RUN);
                        if (0 == j) {
                            motionPathSimplify.setAvgPace(0.0f);
                        } else {
                            motionPathSimplify.setAvgPace(3600.0f / ((((float) j) / 10.0f) / ((float) i5)));
                        }
                        C2538c.m12674b(TAG, "=====zz=====avg Pace:" + motionPathSimplify.getAvgPace() + "===");
                        if (i2 == 0) {
                            motionPathSimplify.setBestPace(0.0f);
                        } else {
                            motionPathSimplify.setBestPace(3600.0f / (((float) i2) / 10.0f));
                        }
                        C2538c.m12674b(TAG, "=====zz=====best pace:" + motionPathSimplify.getBestPace() + "===");
                        if (i4 == 0) {
                            motionPathSimplify.setAvgHeartRate(0);
                        } else {
                            motionPathSimplify.setAvgHeartRate(Long.valueOf(j4 / ((long) i4)).intValue());
                        }
                        C2538c.m12674b(TAG, "=====zz=====" + j4 + "===avgHear:" + motionPathSimplify.getAvgHeartRate() + "===");
                        motionPathSimplify.setAvgStepRate((int) ((((float) i6) / (((float) i5) * 5.0f)) * 60.0f));
                        C2538c.m12674b(TAG, "=====zz========avgStep:" + i + "===");
                        motionPathSimplify.setBestStepRate(i7);
                        C2538c.m12674b(TAG, "=====zz========BestStep:" + i7 + "===");
                        motionPathSimplify.setTrackType(RemoteUtils.getTrackTypeByClassification(hwDeviceMgr));
                    }
                }
                C2538c.m12674b(TAG, (Object[]) new Object[]{"=====zz========time:" + j8 + "===详细数据== 步频=" + i10});
            }
            j2 = j9;
            i4 = i13;
            i5 = i9;
            i13 = i;
            j6 = j7;
            i6 = i8;
            i7 = i15;
            j4 = j6;
            j5 = j2;
        } catch (JSONException e4) {
            jSONException = e4;
            j3 = j9;
            i4 = 0;
            i5 = 0;
            j5 = j3;
            i6 = 0;
            i7 = 0;
            j4 = 0;
            jSONException2 = jSONException;
            i2 = 0;
            j = 0;
            C2538c.m12680e(TAG, jSONException2.getMessage());
            C2538c.m12677c(TAG, "summaryTotalStep=" + i12 + ", iTotalStep=" + i6 + ", totaltime=" + ((j5 / 1000) / 60));
            i3 = (int) ((((float) (i12 - i6)) / ((float) arrayList2.size())) + 0.5f);
            for (i12 = 0; i12 < arrayList2.size(); i12++) {
                ((StepRateData) arrayList2.get(i12)).setStepRate(((StepRateData) arrayList2.get(i12)).getStepRate() + i3);
            }
            if (i13 < arrayList2.size()) {
                i7 = ((StepRateData) arrayList2.get(i13)).getStepRate();
            }
            motionPath.setHeartRateList(arrayList);
            motionPath.setStepRateList(arrayList2);
            motionPathSimplify.setSportId("gps_maptracking_" + m.a(new Date(), "yyyyMMddHHmmssSSS"));
            C2538c.m12674b(TAG, "=====zz========sportId:" + r4 + "===");
            motionPathSimplify.setSportType(SportType.SPORT_TYPE_RUN);
            if (0 == j) {
                motionPathSimplify.setAvgPace(3600.0f / ((((float) j) / 10.0f) / ((float) i5)));
            } else {
                motionPathSimplify.setAvgPace(0.0f);
            }
            C2538c.m12674b(TAG, "=====zz=====avg Pace:" + motionPathSimplify.getAvgPace() + "===");
            if (i2 == 0) {
                motionPathSimplify.setBestPace(3600.0f / (((float) i2) / 10.0f));
            } else {
                motionPathSimplify.setBestPace(0.0f);
            }
            C2538c.m12674b(TAG, "=====zz=====best pace:" + motionPathSimplify.getBestPace() + "===");
            if (i4 == 0) {
                motionPathSimplify.setAvgHeartRate(Long.valueOf(j4 / ((long) i4)).intValue());
            } else {
                motionPathSimplify.setAvgHeartRate(0);
            }
            C2538c.m12674b(TAG, "=====zz=====" + j4 + "===avgHear:" + motionPathSimplify.getAvgHeartRate() + "===");
            motionPathSimplify.setAvgStepRate((int) ((((float) i6) / (((float) i5) * 5.0f)) * 60.0f));
            C2538c.m12674b(TAG, "=====zz========avgStep:" + i + "===");
            motionPathSimplify.setBestStepRate(i7);
            C2538c.m12674b(TAG, "=====zz========BestStep:" + i7 + "===");
            motionPathSimplify.setTrackType(RemoteUtils.getTrackTypeByClassification(hwDeviceMgr));
        }
        C2538c.m12677c(TAG, "summaryTotalStep=" + i12 + ", iTotalStep=" + i6 + ", totaltime=" + ((j5 / 1000) / 60));
        if (i12 > i6 && ((long) (i12 - i6)) > (j5 / 1000) / 60) {
            i3 = (int) ((((float) (i12 - i6)) / ((float) arrayList2.size())) + 0.5f);
            for (i12 = 0; i12 < arrayList2.size(); i12++) {
                ((StepRateData) arrayList2.get(i12)).setStepRate(((StepRateData) arrayList2.get(i12)).getStepRate() + i3);
            }
            if (i13 < arrayList2.size()) {
                i7 = ((StepRateData) arrayList2.get(i13)).getStepRate();
            }
        }
        motionPath.setHeartRateList(arrayList);
        motionPath.setStepRateList(arrayList2);
        motionPathSimplify.setSportId("gps_maptracking_" + m.a(new Date(), "yyyyMMddHHmmssSSS"));
        C2538c.m12674b(TAG, "=====zz========sportId:" + r4 + "===");
        motionPathSimplify.setSportType(SportType.SPORT_TYPE_RUN);
        if (0 == j) {
            motionPathSimplify.setAvgPace(0.0f);
        } else {
            motionPathSimplify.setAvgPace(3600.0f / ((((float) j) / 10.0f) / ((float) i5)));
        }
        C2538c.m12674b(TAG, "=====zz=====avg Pace:" + motionPathSimplify.getAvgPace() + "===");
        if (i2 == 0) {
            motionPathSimplify.setBestPace(0.0f);
        } else {
            motionPathSimplify.setBestPace(3600.0f / (((float) i2) / 10.0f));
        }
        C2538c.m12674b(TAG, "=====zz=====best pace:" + motionPathSimplify.getBestPace() + "===");
        if (i4 == 0) {
            motionPathSimplify.setAvgHeartRate(0);
        } else {
            motionPathSimplify.setAvgHeartRate(Long.valueOf(j4 / ((long) i4)).intValue());
        }
        C2538c.m12674b(TAG, "=====zz=====" + j4 + "===avgHear:" + motionPathSimplify.getAvgHeartRate() + "===");
        motionPathSimplify.setAvgStepRate((int) ((((float) i6) / (((float) i5) * 5.0f)) * 60.0f));
        C2538c.m12674b(TAG, "=====zz========avgStep:" + i + "===");
        motionPathSimplify.setBestStepRate(i7);
        C2538c.m12674b(TAG, "=====zz========BestStep:" + i7 + "===");
        motionPathSimplify.setTrackType(RemoteUtils.getTrackTypeByClassification(hwDeviceMgr));
    }

    public void getRunPlanParameter(IBaseResponseCallback iBaseResponseCallback) {
        synchronized (this.lockObject) {
            DeviceCommand deviceCommand = new DeviceCommand();
            deviceCommand.setServiceID(22);
            deviceCommand.setCommandID(1);
            String e = C0973a.m3517e(0);
            String a = C0973a.m3506a(129);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(a);
            stringBuilder.append(e);
            deviceCommand.setDataLen(stringBuilder.length() / 2);
            deviceCommand.setDataContent(C0973a.m3512b(stringBuilder.toString()));
            hwDeviceMgr.m3995b(deviceCommand);
            synchronized (getRunPlanParameterCallbackList()) {
                runPlanParameterCallbackList.add(iBaseResponseCallback);
            }
        }
    }

    public void setRunPlan(JSONObject jSONObject, IBaseResponseCallback iBaseResponseCallback) throws JSONException {
        synchronized (this.lockObject) {
            Object obj = (RunPlanInfo) this.gson.fromJson(jSONObject.getString("runPlanInfo"), RunPlanInfo.class);
            C2538c.m12677c(TAG, "setRunPlan called~~~~~~");
            C2538c.m12677c(TAG, this.gson.toJson(obj));
            DeviceCommand deviceCommand = new DeviceCommand();
            deviceCommand.setServiceID(22);
            deviceCommand.setCommandID(2);
            List arrayList = new ArrayList();
            List runPlanStructList = obj.getRunPlanStructList();
            if (runPlanStructList == null) {
                C2538c.m12680e(TAG, "setRunPlan runPlanStructList is null");
                return;
            }
            String a;
            String e;
            String b;
            String e2;
            String str;
            String e3;
            String str2;
            for (int i = 0; i < runPlanStructList.size(); i++) {
                int i2;
                String a2;
                String a3;
                String e4;
                String a4;
                String a5;
                String e5;
                String a6;
                String a7;
                String e6;
                String a8;
                List arrayList2 = new ArrayList();
                List trainingStructList = ((RunPlanStruct) runPlanStructList.get(i)).getTrainingStructList();
                if (trainingStructList != null) {
                    for (i2 = 0; i2 < trainingStructList.size(); i2++) {
                        a = C0973a.m3506a(((TrainingStruct) trainingStructList.get(i2)).getTraining_type());
                        e = C0973a.m3517e(a.length() / 2);
                        a2 = C0973a.m3506a(13);
                        a3 = C0973a.m3506a(((TrainingStruct) trainingStructList.get(i2)).getTraining_speed_limit_high());
                        a3 = a3 + C0973a.m3506a(((TrainingStruct) trainingStructList.get(i2)).getTraining_speed_limit_low());
                        e4 = C0973a.m3517e(a3.length() / 2);
                        a4 = C0973a.m3506a(14);
                        a5 = C0973a.m3506a(((TrainingStruct) trainingStructList.get(i2)).getTraining_hr_limit_high());
                        a5 = a5 + C0973a.m3506a(((TrainingStruct) trainingStructList.get(i2)).getTraining_hr_limit_low());
                        e5 = C0973a.m3517e(a5.length() / 2);
                        a6 = C0973a.m3506a(15);
                        a7 = C0973a.m3506a(((TrainingStruct) trainingStructList.get(i2)).getTraining_intensity_limit_high());
                        a7 = a7 + C0973a.m3506a(((TrainingStruct) trainingStructList.get(i2)).getTraining_intensity_limit_low());
                        e6 = C0973a.m3517e(a7.length() / 2);
                        a8 = C0973a.m3506a(16);
                        b = C0973a.m3510b(((TrainingStruct) trainingStructList.get(i2)).getTraining_duration());
                        b = a2 + e + a + a4 + e4 + a3 + a6 + e5 + a5 + a8 + e6 + a7 + C0973a.m3506a(17) + C0973a.m3517e(b.length() / 2) + b;
                        arrayList2.add(C0973a.m3506a(140) + C0973a.m3517e(b.length() / 2) + b);
                    }
                }
                StringBuilder stringBuilder = new StringBuilder();
                for (i2 = 0; i2 < arrayList2.size(); i2++) {
                    stringBuilder.append((String) arrayList2.get(i2));
                }
                e2 = C0973a.m3517e(stringBuilder.length() / 2);
                String a9 = C0973a.m3506a(139);
                a = C0973a.m3518e(((RunPlanStruct) runPlanStructList.get(i)).getRun_plan_name());
                e = C0973a.m3517e(a.length() / 2);
                a2 = C0973a.m3506a(6);
                int run_plan_date = (int) (((RunPlanStruct) runPlanStructList.get(i)).getRun_plan_date() / 1000);
                a3 = C0973a.m3506a(run_plan_date >> 24) + C0973a.m3506a((run_plan_date >> 16) & 255) + C0973a.m3506a((run_plan_date >> 8) & 255) + C0973a.m3506a(run_plan_date & 255);
                e4 = C0973a.m3517e(a3.length() / 2);
                a4 = C0973a.m3506a(7);
                a5 = C0973a.m3507a((long) ((RunPlanStruct) runPlanStructList.get(i)).getRun_plan_workout_id());
                e5 = C0973a.m3517e(a5.length() / 2);
                a6 = C0973a.m3506a(18);
                a7 = C0973a.m3506a(((RunPlanStruct) runPlanStructList.get(i)).getRun_plan_train_effect());
                e6 = C0973a.m3517e(a7.length() / 2);
                a8 = C0973a.m3506a(8);
                String a10 = C0973a.m3506a(((RunPlanStruct) runPlanStructList.get(i)).getRun_plan_repeats());
                String e7 = C0973a.m3517e(a10.length() / 2);
                String a11 = C0973a.m3506a(9);
                b = C0973a.m3507a((long) ((RunPlanStruct) runPlanStructList.get(i)).getRun_plan_distance());
                b = a2 + e + a + a4 + e4 + a3 + a8 + e6 + a7 + a11 + e7 + a10 + C0973a.m3506a(10) + C0973a.m3517e(b.length() / 2) + b + a9 + e2 + stringBuilder + a6 + e5 + a5;
                arrayList.add(C0973a.m3506a(133) + C0973a.m3517e(b.length() / 2) + b);
            }
            if (obj.getRun_plan_total_sign() == null || obj.getRun_plan_total_sign().equals("")) {
                a9 = C0973a.m3517e(0);
                str = null;
            } else {
                e2 = C0973a.m3518e(obj.getRun_plan_total_sign());
                a9 = C0973a.m3517e(e2.length() / 2);
                str = e2;
            }
            a = C0973a.m3506a(2);
            if (obj.getRun_plan_sign() == null || obj.getRun_plan_sign().equals("")) {
                e3 = C0973a.m3517e(0);
                str2 = null;
            } else {
                e2 = obj.getRun_plan_sign();
                e3 = C0973a.m3517e(e2.length() / 2);
                str2 = e2;
            }
            e = C0973a.m3506a(3);
            StringBuilder stringBuilder2 = new StringBuilder();
            for (i2 = 0; i2 < arrayList.size(); i2++) {
                stringBuilder2.append((String) arrayList.get(i2));
            }
            if (str == null || str.equals("")) {
                b = a + a9;
            } else {
                b = a + a9 + str;
            }
            if (str2 == null || str2.equals("")) {
                b = b + e + e3;
            } else {
                b = b + e + e3 + str2;
            }
            int run_plan_start_date = (int) (obj.getRun_plan_start_date() / 1000);
            String str3 = C0973a.m3506a(run_plan_start_date >> 24) + C0973a.m3506a((run_plan_start_date >> 16) & 255) + C0973a.m3506a((run_plan_start_date >> 8) & 255) + C0973a.m3506a(run_plan_start_date & 255);
            str3 = b + C0973a.m3506a(4) + C0973a.m3517e(str3.length() / 2) + str3 + stringBuilder2.toString();
            b = C0973a.m3517e(str3.length() / 2);
            e2 = C0973a.m3506a(129);
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(e2);
            stringBuilder3.append(b);
            stringBuilder3.append(str3);
            deviceCommand.setDataLen(stringBuilder3.length() / 2);
            deviceCommand.setDataContent(C0973a.m3512b(stringBuilder3.toString()));
            C2538c.m12677c(TAG, "parsing has been finished~~~~");
            hwDeviceMgr.m3995b(deviceCommand);
            synchronized (getSetRunPlanCallbackList()) {
                setRunPlanCallbackList.add(iBaseResponseCallback);
            }
        }
    }

    public void setRunPlanReminderSwitch(JSONObject jSONObject, IBaseResponseCallback iBaseResponseCallback) throws JSONException {
        synchronized (this.lockObject) {
            RunPlanReminder runPlanReminder = (RunPlanReminder) this.gson.fromJson(jSONObject.getString("runPlanReminder"), RunPlanReminder.class);
            DeviceCommand deviceCommand = new DeviceCommand();
            deviceCommand.setServiceID(22);
            deviceCommand.setCommandID(3);
            String a = C0973a.m3506a(runPlanReminder.getRun_plan_reminder_switch());
            String e = C0973a.m3517e(a.length() / 2);
            String a2 = C0973a.m3506a(1);
            String a3 = C0973a.m3506a(runPlanReminder.getRun_plan_reminder_time_hour());
            String str = a3 + C0973a.m3506a(runPlanReminder.getRun_plan_reminder_time_minute());
            a3 = C0973a.m3517e(str.length() / 2);
            String a4 = C0973a.m3506a(2);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(a2);
            stringBuilder.append(e);
            stringBuilder.append(a);
            stringBuilder.append(a4);
            stringBuilder.append(a3);
            stringBuilder.append(str);
            deviceCommand.setDataLen(stringBuilder.length() / 2);
            deviceCommand.setDataContent(C0973a.m3512b(stringBuilder.toString()));
            hwDeviceMgr.m3995b(deviceCommand);
            synchronized (getSetRunPlanReminderSwitchCallbackList()) {
                setRunPlanReminderSwitchCallbackList.add(iBaseResponseCallback);
            }
        }
    }

    public void getRunPlanRecord(JSONObject jSONObject, IBaseResponseCallback iBaseResponseCallback) throws JSONException {
        synchronized (this.lockObject) {
            DeviceCommand deviceCommand = new DeviceCommand();
            deviceCommand.setServiceID(22);
            deviceCommand.setCommandID(4);
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
            hwDeviceMgr.m3995b(deviceCommand);
            synchronized (getGetRunPlanRecordCallbackList()) {
                getRunPlanRecordCallbackList.add(iBaseResponseCallback);
            }
        }
    }

    public void getRunPlanRecordInfo(JSONObject jSONObject, IBaseResponseCallback iBaseResponseCallback) throws JSONException {
        synchronized (this.lockObject) {
            DeviceCommand deviceCommand = new DeviceCommand();
            deviceCommand.setServiceID(22);
            deviceCommand.setCommandID(5);
            String b = C0973a.m3510b(jSONObject.getInt("id"));
            b = C0973a.m3506a(2) + C0973a.m3517e(b.length() / 2) + b;
            String e = C0973a.m3517e(b.length() / 2);
            String a = C0973a.m3506a(129);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(a);
            stringBuilder.append(e);
            stringBuilder.append(b);
            deviceCommand.setDataLen(stringBuilder.length() / 2);
            deviceCommand.setDataContent(C0973a.m3512b(stringBuilder.toString()));
            hwDeviceMgr.m3995b(deviceCommand);
            synchronized (getGetRunPlanRecordInfoCallbackList()) {
                getRunPlanRecordInfoCallbackList.add(iBaseResponseCallback);
            }
        }
    }

    public void registerNotificationRunPlanRecordInfoCallbackList(IBaseResponseCallback iBaseResponseCallback) {
        synchronized (getNotificationRunPlanRecordInfoCallbackList()) {
            notificationRunPlanRecordInfoCallbackList.add(iBaseResponseCallback);
        }
    }

    public void unRegisterNotificationRunPlanRecordInfoCallbackList(IBaseResponseCallback iBaseResponseCallback) {
        synchronized (getNotificationRunPlanRecordInfoCallbackList()) {
            if (notificationRunPlanRecordInfoCallbackList.size() != 0 && notificationRunPlanRecordInfoCallbackList.contains(iBaseResponseCallback)) {
                notificationRunPlanRecordInfoCallbackList.remove(iBaseResponseCallback);
            }
        }
    }

    public void getResult(byte[] bArr) {
        C2538c.m12677c(TAG, "HWExerciseAdviceManager getResult(): " + C0973a.m3509a(bArr));
        if (!w.a(bArr)) {
            String a = C0973a.m3509a(bArr);
            if (4 < a.length()) {
                try {
                    u a2 = new w().a(a.substring(4, a.length()));
                    List<s> a3 = a2.a();
                    List<u> b = a2.b();
                    int run_plan_sync_size;
                    int parseInt;
                    List arrayList;
                    List<s> a4;
                    RunPlanRecordInfo runPlanRecordInfo;
                    switch (bArr[1]) {
                        case (byte) 1:
                            if (a3 == null || a3.size() <= 0 || 127 != Integer.parseInt(((s) a3.get(0)).a(), 16)) {
                                RunPlanParameter runPlanParameter = new RunPlanParameter();
                                if (b != null && b.size() > 0) {
                                    for (u a5 : b) {
                                        for (s sVar : a5.a()) {
                                            switch (Integer.parseInt(sVar.a(), 16)) {
                                                case 2:
                                                    runPlanParameter.setRun_plan_total_sign(C0973a.m3514c(sVar.b()));
                                                    break;
                                                case 3:
                                                    runPlanParameter.setRun_plan_sign(sVar.b());
                                                    break;
                                                case 4:
                                                    runPlanParameter.setRun_plan_algorithm_type(Integer.parseInt(sVar.b(), 16));
                                                    break;
                                                case 5:
                                                    runPlanParameter.setRun_plan_algorithm_version(C0973a.m3514c(sVar.b()));
                                                    break;
                                                case 6:
                                                    runPlanParameter.setRun_plan_sync_size(Integer.parseInt(sVar.b(), 16));
                                                    break;
                                                default:
                                                    break;
                                            }
                                        }
                                    }
                                }
                                synchronized (getRunPlanParameterCallbackList()) {
                                    if (runPlanParameterCallbackList.size() != 0) {
                                        run_plan_sync_size = runPlanParameter.getRun_plan_sync_size();
                                        int i = run_plan_sync_size / 256;
                                        run_plan_sync_size %= 256;
                                        runPlanParameter.setRun_plan_sync_size_pre(i);
                                        runPlanParameter.setRun_plan_sync_size_sub(run_plan_sync_size);
                                        ((IBaseResponseCallback) runPlanParameterCallbackList.get(0)).onResponse(100000, RemoteUtils.generateRetMap(runPlanParameter, "getRunPlanParameter"));
                                        runPlanParameterCallbackList.remove(0);
                                    }
                                }
                                return;
                            }
                            synchronized (getRunPlanParameterCallbackList()) {
                                if (runPlanParameterCallbackList.size() != 0) {
                                    parseInt = Integer.parseInt(((s) a3.get(0)).b(), 16);
                                    ((IBaseResponseCallback) runPlanParameterCallbackList.get(0)).onResponse(parseInt, RemoteUtils.generateRetMap(Integer.valueOf(parseInt), "getRunPlanParameter"));
                                    runPlanParameterCallbackList.remove(0);
                                }
                            }
                            return;
                        case (byte) 2:
                            parseInt = 0;
                            for (s sVar2 : a3) {
                                switch (Integer.parseInt(sVar2.a(), 16)) {
                                    case 127:
                                        run_plan_sync_size = Integer.parseInt(sVar2.b(), 16);
                                        break;
                                    default:
                                        run_plan_sync_size = parseInt;
                                        break;
                                }
                                parseInt = run_plan_sync_size;
                            }
                            synchronized (getSetRunPlanCallbackList()) {
                                if (setRunPlanCallbackList.size() != 0) {
                                    ((IBaseResponseCallback) setRunPlanCallbackList.get(0)).onResponse(parseInt, RemoteUtils.generateRetMap(Integer.valueOf(parseInt), "setRunPlan"));
                                    setRunPlanCallbackList.remove(0);
                                }
                            }
                            return;
                        case (byte) 3:
                            parseInt = 0;
                            for (s sVar22 : a3) {
                                switch (Integer.parseInt(sVar22.a(), 16)) {
                                    case 127:
                                        run_plan_sync_size = Integer.parseInt(sVar22.b(), 16);
                                        break;
                                    default:
                                        run_plan_sync_size = parseInt;
                                        break;
                                }
                                parseInt = run_plan_sync_size;
                            }
                            synchronized (getSetRunPlanReminderSwitchCallbackList()) {
                                if (setRunPlanReminderSwitchCallbackList.size() != 0) {
                                    ((IBaseResponseCallback) setRunPlanReminderSwitchCallbackList.get(0)).onResponse(parseInt, RemoteUtils.generateRetMap(Integer.valueOf(parseInt), "setRunPlanReminderSwitch"));
                                    setRunPlanReminderSwitchCallbackList.remove(0);
                                }
                            }
                            return;
                        case (byte) 4:
                            if (a3.size() <= 0 || 127 != Integer.parseInt(((s) a3.get(0)).a(), 16)) {
                                RunPlanRecord runPlanRecord = new RunPlanRecord();
                                List arrayList2 = new ArrayList();
                                for (u uVar : b) {
                                    for (s sVar3 : uVar.a()) {
                                        switch (Integer.parseInt(sVar3.a(), 16)) {
                                            case 2:
                                                runPlanRecord.setRun_plan_record_count(Integer.parseInt(sVar3.b(), 16));
                                                break;
                                            default:
                                                break;
                                        }
                                    }
                                    for (u uVar2 : uVar.b()) {
                                        RunPlanRecordStruct runPlanRecordStruct = new RunPlanRecordStruct();
                                        for (s sVar222 : uVar2.a()) {
                                            switch (Integer.parseInt(sVar222.a(), 16)) {
                                                case 6:
                                                    runPlanRecordStruct.setRun_plan_workout_id(Integer.parseInt(sVar222.b(), 16));
                                                    break;
                                                case 7:
                                                    runPlanRecordStruct.setRun_plan_record_id(Integer.parseInt(sVar222.b(), 16));
                                                    break;
                                                case 8:
                                                    runPlanRecordStruct.setRun_plan_index_count(Integer.parseInt(sVar222.b(), 16));
                                                    break;
                                                case 9:
                                                    runPlanRecordStruct.setPaceIndextCount(Integer.parseInt(sVar222.b(), 16));
                                                    break;
                                                default:
                                                    break;
                                            }
                                        }
                                        arrayList2.add(runPlanRecordStruct);
                                    }
                                }
                                runPlanRecord.setRunPlanRecordStructList(arrayList2);
                                synchronized (getGetRunPlanRecordCallbackList()) {
                                    if (getRunPlanRecordCallbackList.size() != 0) {
                                        ((IBaseResponseCallback) getRunPlanRecordCallbackList.get(0)).onResponse(100000, RemoteUtils.generateRetMap(runPlanRecord, "getRunPlanRecord"));
                                        getRunPlanRecordCallbackList.remove(0);
                                    }
                                }
                                return;
                            }
                            synchronized (getGetRunPlanRecordCallbackList()) {
                                if (getRunPlanRecordCallbackList.size() != 0) {
                                    parseInt = Integer.parseInt(((s) a3.get(0)).b(), 16);
                                    ((IBaseResponseCallback) getRunPlanRecordCallbackList.get(0)).onResponse(parseInt, RemoteUtils.generateRetMap(Integer.valueOf(parseInt), "getRunPlanRecord"));
                                    getRunPlanRecordCallbackList.remove(0);
                                }
                            }
                            return;
                        case (byte) 5:
                            if (a3.size() <= 0 || 127 != Integer.parseInt(((s) a3.get(0)).a(), 16)) {
                                arrayList = new ArrayList();
                                for (u a22 : b) {
                                    a4 = a22.a();
                                    runPlanRecordInfo = new RunPlanRecordInfo();
                                    for (s sVar2222 : a4) {
                                        switch (Integer.parseInt(sVar2222.a(), 16)) {
                                            case 2:
                                                runPlanRecordInfo.setRun_plan_record_info_id(Integer.parseInt(sVar2222.b(), 16));
                                                break;
                                            case 3:
                                                runPlanRecordInfo.setRun_plan_record_info_status(Integer.parseInt(sVar2222.b(), 16));
                                                break;
                                            case 4:
                                                runPlanRecordInfo.setRun_plan_record_info_start_time(Long.parseLong(sVar2222.b(), 16) * 1000);
                                                break;
                                            case 5:
                                                runPlanRecordInfo.setRun_plan_record_info_end_time(Long.parseLong(sVar2222.b(), 16) * 1000);
                                                break;
                                            case 6:
                                                runPlanRecordInfo.setRun_plan_record_info_calorie(Integer.parseInt(sVar2222.b(), 16));
                                                break;
                                            case 7:
                                                runPlanRecordInfo.setRun_plan_record_info_distance(Integer.parseInt(sVar2222.b(), 16));
                                                break;
                                            case 8:
                                                runPlanRecordInfo.setRun_plan_record_info_step(Integer.parseInt(sVar2222.b(), 16));
                                                break;
                                            case 9:
                                                runPlanRecordInfo.setRun_plan_record_info_total_time(Integer.parseInt(sVar2222.b(), 16));
                                                break;
                                            case 10:
                                                runPlanRecordInfo.setRun_plan_record_info_speed(((float) Integer.parseInt(sVar2222.b(), 16)) / 10.0f);
                                                break;
                                            case 11:
                                                runPlanRecordInfo.setRun_plan_record_info_climb(Integer.parseInt(sVar2222.b(), 16));
                                                break;
                                            case 12:
                                                runPlanRecordInfo.setRun_plan_record_info_HrABS_min(Integer.parseInt(sVar2222.b().substring(0, 2), 16));
                                                runPlanRecordInfo.setRun_plan_record_info_HrABS_max(Integer.parseInt(sVar2222.b().substring(2, 4), 16));
                                                break;
                                            case 13:
                                                runPlanRecordInfo.setRun_plan_record_info_load_peak(Integer.parseInt(sVar2222.b(), 16));
                                                break;
                                            case 14:
                                                runPlanRecordInfo.setRun_plan_record_info_etraining_effect(Integer.parseInt(sVar2222.b(), 16));
                                                break;
                                            case 15:
                                                runPlanRecordInfo.setRun_plan_record_info_achieve_percent(Integer.parseInt(sVar2222.b(), 16));
                                                break;
                                            case 16:
                                                runPlanRecordInfo.setRun_plan_record_info_Epoc(Integer.parseInt(sVar2222.b(), 16));
                                                break;
                                            case 17:
                                                runPlanRecordInfo.setRun_plan_record_info_maxMET(Integer.parseInt(sVar2222.b(), 16));
                                                break;
                                            case 18:
                                                runPlanRecordInfo.setRun_plan_record_info_recovery_time(Integer.parseInt(sVar2222.b(), 16));
                                                break;
                                            case 19:
                                                break;
                                            case 20:
                                                runPlanRecordInfo.setRun_plan_record_info_exercise_duration(Integer.parseInt(sVar2222.b(), 16) * 1000);
                                                break;
                                            case 21:
                                                runPlanRecordInfo.setRun_plan_record_info_date_info(Integer.parseInt(sVar2222.b(), 16));
                                                break;
                                            default:
                                                break;
                                        }
                                    }
                                    arrayList.add(runPlanRecordInfo);
                                }
                                synchronized (getGetRunPlanRecordInfoCallbackList()) {
                                    if (getRunPlanRecordInfoCallbackList.size() != 0) {
                                        ((IBaseResponseCallback) getRunPlanRecordInfoCallbackList.get(0)).onResponse(100000, RemoteUtils.generateRetMap(arrayList, "getRunPlanRecordInfo"));
                                        getRunPlanRecordInfoCallbackList.remove(0);
                                    }
                                }
                                return;
                            }
                            synchronized (getGetRunPlanRecordInfoCallbackList()) {
                                if (getRunPlanRecordInfoCallbackList.size() != 0) {
                                    parseInt = Integer.parseInt(((s) a3.get(0)).b(), 16);
                                    ((IBaseResponseCallback) getRunPlanRecordInfoCallbackList.get(0)).onResponse(parseInt, RemoteUtils.generateRetMap(Integer.valueOf(parseInt), "getRunPlanRecordInfo"));
                                    getRunPlanRecordInfoCallbackList.remove(0);
                                }
                            }
                            return;
                        case (byte) 6:
                            arrayList = new ArrayList();
                            try {
                                for (u a222 : b) {
                                    a4 = a222.a();
                                    runPlanRecordInfo = new RunPlanRecordInfo();
                                    for (s sVar22222 : a4) {
                                        switch (Integer.parseInt(sVar22222.a(), 16)) {
                                            case 2:
                                                runPlanRecordInfo.setRun_plan_record_info_wourkout_id(Integer.parseInt(sVar22222.b(), 16));
                                                break;
                                            case 3:
                                                runPlanRecordInfo.setRun_plan_record_info_status(Integer.parseInt(sVar22222.b(), 16));
                                                break;
                                            case 4:
                                                runPlanRecordInfo.setRun_plan_record_info_start_time(Long.parseLong(sVar22222.b(), 16) * 1000);
                                                break;
                                            case 5:
                                                runPlanRecordInfo.setRun_plan_record_info_end_time(Long.parseLong(sVar22222.b(), 16) * 1000);
                                                break;
                                            case 6:
                                                runPlanRecordInfo.setRun_plan_record_info_calorie(Integer.parseInt(sVar22222.b(), 16));
                                                break;
                                            case 7:
                                                runPlanRecordInfo.setRun_plan_record_info_distance(Integer.parseInt(sVar22222.b(), 16));
                                                break;
                                            case 8:
                                                runPlanRecordInfo.setRun_plan_record_info_step(Integer.parseInt(sVar22222.b(), 16));
                                                break;
                                            case 9:
                                                runPlanRecordInfo.setRun_plan_record_info_total_time(Integer.parseInt(sVar22222.b(), 16));
                                                break;
                                            case 10:
                                                runPlanRecordInfo.setRun_plan_record_info_speed(((float) Integer.parseInt(sVar22222.b(), 16)) / 10.0f);
                                                break;
                                            case 11:
                                                runPlanRecordInfo.setRun_plan_record_info_climb(Integer.parseInt(sVar22222.b(), 16));
                                                break;
                                            case 12:
                                                runPlanRecordInfo.setRun_plan_record_info_HrABS_min(Integer.parseInt(sVar22222.b().substring(0, 2), 16));
                                                runPlanRecordInfo.setRun_plan_record_info_HrABS_max(Integer.parseInt(sVar22222.b().substring(2, 4), 16));
                                                break;
                                            case 13:
                                                runPlanRecordInfo.setRun_plan_record_info_load_peak(Integer.parseInt(sVar22222.b(), 16));
                                                break;
                                            case 14:
                                                runPlanRecordInfo.setRun_plan_record_info_etraining_effect(Integer.parseInt(sVar22222.b(), 16));
                                                break;
                                            case 15:
                                                runPlanRecordInfo.setRun_plan_record_info_achieve_percent(Integer.parseInt(sVar22222.b(), 16));
                                                break;
                                            case 16:
                                                runPlanRecordInfo.setRun_plan_record_info_Epoc(Integer.parseInt(sVar22222.b(), 16));
                                                break;
                                            case 17:
                                                runPlanRecordInfo.setRun_plan_record_info_maxMET(Integer.parseInt(sVar22222.b(), 16));
                                                break;
                                            case 18:
                                                runPlanRecordInfo.setRun_plan_record_info_recovery_time(Integer.parseInt(sVar22222.b(), 16));
                                                break;
                                            case 19:
                                                runPlanRecordInfo.setRun_plan_record_info_daily_score(Integer.parseInt(sVar22222.b(), 16));
                                                break;
                                            case 20:
                                                runPlanRecordInfo.setRun_plan_record_info_exercise_duration(Integer.parseInt(sVar22222.b(), 16) * 1000);
                                                break;
                                            case 21:
                                                runPlanRecordInfo.setRun_plan_record_info_date_info(Integer.parseInt(sVar22222.b(), 16));
                                                break;
                                            default:
                                                break;
                                        }
                                    }
                                    arrayList.add(runPlanRecordInfo);
                                }
                            } catch (NumberFormatException e) {
                                C2538c.m12680e(TAG, "NOTIFICATION_RUN_PLAN_RECORD_INFO", e.getMessage());
                            }
                            synchronized (getNotificationRunPlanRecordInfoCallbackList()) {
                                for (IBaseResponseCallback onResponse : notificationRunPlanRecordInfoCallbackList) {
                                    onResponse.onResponse(100000, RemoteUtils.generateRetMap(arrayList, "registerNotificationRunPlanRecordInfoCallbackList"));
                                }
                            }
                            return;
                        default:
                            return;
                    }
                } catch (t e2) {
                    C2538c.m12680e(TAG, "接收命令错误 e=" + e2.getMessage());
                    return;
                }
                C2538c.m12680e(TAG, "接收命令错误 e=" + e2.getMessage());
                return;
            }
            C2538c.m12680e(TAG, "接收命令错误!");
        }
    }

    public void sendRunPlanToDevice() {
        if (this.mDeviceSupportCapacity) {
            getRunPlanParameter(this.getAdviceParamCallback);
        }
    }

    public RunPlanRecordInfo getDeviceRunPlanETEResult() {
        if (this.mDeviceSupportCapacity && 2 == getCurrentDeviceState() && this.mIsUsingETE) {
            int i = 0;
            while (i < 5000) {
                C2538c.m12674b(TAG, "getDeviceRunPlanETEResult checktime=" + i);
                if (this.mRunPlanETEResultFlag) {
                    C2538c.m12677c(TAG, "getDeviceRunPlanETEResult return runplan record");
                    break;
                }
                try {
                    Thread.sleep(500);
                    i += 500;
                } catch (InterruptedException e) {
                    C2538c.m12680e(TAG, "getDeviceRunPlanETEResult exception e=" + e.getMessage());
                }
            }
            this.mIsUsingETE = false;
        }
        return null;
    }

    public void syncDeviceWorkoutRecordInfo(IBaseResponseCallback iBaseResponseCallback) {
        this.mThreadPool.execute(new 5(this, iBaseResponseCallback));
    }

    private void testWorkoutRecordInfoDebug() {
        C2538c.m12674b(TAG, "testWorkoutRecordInfoDebug enter");
        int i = 0;
        while (i < this.mWorkoutRecordsStatistic.size()) {
            try {
                JSONObject jSONObject = (JSONObject) this.mWorkoutRecordsStatistic.valueAt(i);
                C2538c.m12677c(TAG, "==zz=workout id=" + jSONObject.get("workout_record_id") + ",workout statuc=" + jSONObject.get("workout_record_status") + ",startime=" + jSONObject.get("workout_record_start_time") + ",endtime=" + jSONObject.get("workout_record_end_time"));
                C2538c.m12677c(TAG, "==zz=calorie=" + jSONObject.get("workout_record_calorie") + ",distance=" + jSONObject.get("workout_record_distance") + ",step=" + jSONObject.get("workout_record_step") + ",time=" + jSONObject.get("workout_record_total_time") + ",speed=" + jSONObject.get("workout_record_speed") + ",climb=" + jSONObject.get("workout_climb"));
                C2538c.m12677c(TAG, "==zz=HrMax=" + jSONObject.get("workout_HrABS_peak_max") + ",HrMin=" + jSONObject.get("workout_HrABS_peak_min") + ",loadPeak=" + jSONObject.get("workout_load_peak") + ",effect=" + jSONObject.get("workout_etraining_effect") + ",epoc=" + jSONObject.get("workout_Epoc"));
                C2538c.m12677c(TAG, "==zz=MET=" + jSONObject.get("workout_maxMET") + ",revoeryTime=" + jSONObject.get("workout_recovery_time") + ",duration=" + jSONObject.get("workout_exercise_duration") + ",date=" + jSONObject.get("workout_date_Info"));
                C2538c.m12677c(TAG, "==zz=totalTime=" + jSONObject.get("workout_record_total_time") + ",workout_type=" + jSONObject.get("workout_type"));
                C2538c.m12677c(TAG, "swim, swim_type=" + jSONObject.get("swim_type") + ",swim_pull_times=" + jSONObject.get("swim_pull_times") + ",swim_pull_rate=" + jSONObject.get("swim_pull_rate") + ",swim_pool_length=" + jSONObject.get("swim_pool_length") + ",swim_trip_times=" + jSONObject.get("swim_trip_times") + ",swim_avg_swolf=" + jSONObject.get("swim_avg_swolf"));
                i++;
            } catch (JSONException e) {
                C2538c.m12680e(TAG, e.getMessage());
                return;
            }
        }
    }

    private void testRunPlanRecordInfoDebug() {
        C2538c.m12674b(TAG, "testRunPlanRecordInfoDebug enter");
        int i = 0;
        while (i < this.mRunPlanRecordsStatistic.size()) {
            try {
                JSONObject jSONObject = (JSONObject) this.mRunPlanRecordsStatistic.valueAt(i);
                C2538c.m12677c(TAG, "workout id=" + jSONObject.get("run_plan_record_info_id") + ",workout statuc=" + jSONObject.get("run_plan_record_info_status") + ",startime=" + jSONObject.get("run_plan_record_info_start_time") + ",endtime=" + jSONObject.get("run_plan_record_info_end_time"));
                C2538c.m12677c(TAG, "calorie=" + jSONObject.get("run_plan_record_info_calorie") + ",distance=" + jSONObject.get("run_plan_record_info_distance") + ",step=" + jSONObject.get("run_plan_record_info_step") + ",time=" + jSONObject.get("run_plan_record_info_total_time") + ",speed=" + jSONObject.get("run_plan_record_info_speed") + ",climb=" + jSONObject.get("run_plan_record_info_climb"));
                C2538c.m12677c(TAG, "HrMax=" + jSONObject.get("run_plan_record_info_HrABS_max") + ",HrMin=" + jSONObject.get("run_plan_record_info_HrABS_min") + ",loadPeak=" + jSONObject.get("run_plan_record_info_load_peak") + ",effect=" + jSONObject.get("run_plan_record_info_etraining_effect") + ",epoc=" + jSONObject.get("run_plan_record_info_Epoc"));
                C2538c.m12677c(TAG, "MET=" + jSONObject.get("run_plan_record_info_maxMET") + ", finishRate=" + jSONObject.get("run_plan_record_info_achieve_percent") + ",revoeryTime=" + jSONObject.get("run_plan_record_info_recovery_time") + ",duration=" + jSONObject.get("run_plan_record_info_exercise_duration") + ",date=" + jSONObject.get("run_plan_record_info_date_info"));
                C2538c.m12677c(TAG, "==zz=totalTime=" + jSONObject.get("run_plan_record_info_total_time"));
                i++;
            } catch (JSONException e) {
                C2538c.m12680e(TAG, e.getMessage());
                return;
            }
        }
    }

    private void getDetailData() {
        this.lstWorkoutData.clear();
        syncWorkoutDetailData(this.mWorkoutRecord);
        syncRunPlanDetailData(this.mRunPlanRecord);
        if (this.lstWorkoutData.size() > 0) {
            getWorkoutDetailData((JSONObject) this.lstWorkoutData.get(0));
        } else if (!this.mDeviceSupportPaceMap || this.lstWorkoutRecordPaceMapIDList.size() <= 0) {
            getWorkOutDetailFromDevice();
        } else {
            getWorkoutRecordPaceMap((PaceIndexStruct) this.lstWorkoutRecordPaceMapIDList.get(0));
        }
    }

    private void getWorkOutDetailFromDevice() {
        this.mapGPSWorkout.clear();
        this.mapGPSWorkoutAndRunPlanType.clear();
        if (8 == getConncetedDeviceType()) {
            C2538c.m12677c(TAG, "metis not need track file workout");
            notifyDetailSyncComplete(0, null);
            return;
        }
        HWDeviceGPSFileWrokoutManager.getInstance().getWorkOutDetailFromDevice(this.lstGPSWorkoutRecordID, new 6(this));
    }

    private void getWorkoutRecordPaceMap(PaceIndexStruct paceIndexStruct) {
        HWWorkoutServiceManager.getInstance().getWorkoutRecordPaceMap(paceIndexStruct, this.getWorkoutRecordPaceMapCallback);
    }

    private int getConncetedDeviceType() {
        int productType;
        List<DeviceInfo> a = C1023c.m3920a(BaseApplication.m2632b()).m3984a();
        C2538c.m12677c(TAG, "getConncetedDeviceType() deviceList.size() = " + a.size());
        for (DeviceInfo deviceInfo : a) {
            if (1 == deviceInfo.getDeviceActiveState()) {
                break;
            }
        }
        DeviceInfo deviceInfo2 = null;
        if (deviceInfo2 != null) {
            productType = deviceInfo2.getProductType();
        } else {
            productType = -1;
        }
        C2538c.m12677c(TAG, "getConncetedDeviceType() deviceType " + productType);
        return productType;
    }

    private void getRunPlanDetailFromDevice(boolean z) {
        this.mapGPSRunPlan.clear();
        if (8 == getConncetedDeviceType()) {
            C2538c.m12677c(TAG, "metis not need track file");
            notifyDetailSyncComplete(0, null);
            return;
        }
        HWDeviceGPSFileRunPlanManager.getInstance().getRunPlanDetailFromDevice(this.lstGPSRunPlanRecordID, new 8(this, z));
    }

    private void getDeviceWorkoutRecordStatistic() {
        try {
            if (this.mWorkoutRecord != null) {
                JSONArray jSONArray = this.mWorkoutRecord.getJSONArray("workoutRecordStructList");
                JSONObject jSONObject;
                if (this.mWorkoutRecordStatisticIndex < jSONArray.length()) {
                    int i = jSONArray.getJSONObject(this.mWorkoutRecordStatisticIndex).getInt("workout_record_id");
                    C2538c.m12677c(TAG, "getWorkoutRecord id size=" + jSONArray.length() + ",id=" + i);
                    jSONObject = new JSONObject();
                    jSONObject.put("id", i);
                    HWWorkoutServiceManager.getInstance().getWorkoutRecordStatistic(jSONObject, new 9(this));
                    return;
                }
                testWorkoutRecordInfoDebug();
                jSONObject = new JSONObject();
                jSONObject.put("startTime", this.lastSyncTime);
                jSONObject.put("endTime", this.currentTime);
                getDeviceRunPlanRecordIdList(jSONObject);
            }
        } catch (JSONException e) {
            C2538c.m12680e(TAG, e.getMessage());
        }
    }

    private void getDeviceRunPlanRecordStatistic() {
        try {
            if (this.mRunPlanRecord != null) {
                JSONArray jSONArray = this.mRunPlanRecord.getJSONArray("runPlanRecordStructList");
                if (this.mRunPlanRecordStatisticIndex < this.mRunPlanRecord.getJSONArray("runPlanRecordStructList").length()) {
                    int i = jSONArray.getJSONObject(this.mRunPlanRecordStatisticIndex).getInt("run_plan_record_id");
                    C2538c.m12677c(TAG, "getRunPlanRecordStatistic id size=" + jSONArray.length() + ",id=" + i);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("id", i);
                    getRunPlanRecordInfo(jSONObject, new 10(this));
                    return;
                }
                testRunPlanRecordInfoDebug();
                getDetailData();
            }
        } catch (JSONException e) {
            C2538c.m12680e(TAG, e.getMessage());
        }
    }

    private void getDeviceWorkoutRecordIdList(JSONObject jSONObject) {
        this.mWorkoutRecord = null;
        try {
            HWWorkoutServiceManager.getInstance().getWorkoutRecord(jSONObject, new 11(this));
        } catch (JSONException e) {
            C2538c.m12680e(TAG, e.getMessage());
        }
    }

    private void getDeviceRunPlanRecordIdList(JSONObject jSONObject) {
        this.mRunPlanRecord = null;
        try {
            getRunPlanRecord(jSONObject, new 12(this));
        } catch (JSONException e) {
            C2538c.m12680e(TAG, e.getMessage());
        }
    }

    private void getPaceIndexArray(int i, int i2) {
        if (-1 == i2) {
            PaceIndexStruct paceIndexStruct = new PaceIndexStruct();
            paceIndexStruct.setRecordId(i);
            paceIndexStruct.setPaceIndex(-1);
            this.lstWorkoutRecordPaceMapIDList.add(paceIndexStruct);
        } else if (i2 > 0) {
            for (int i3 = 0; i3 < i2; i3++) {
                PaceIndexStruct paceIndexStruct2 = new PaceIndexStruct();
                paceIndexStruct2.setRecordId(i);
                paceIndexStruct2.setPaceIndex(i3);
                this.lstWorkoutRecordPaceMapIDList.add(paceIndexStruct2);
            }
        }
    }

    private void getDeviceSupportCapacity() {
        DeviceCapability b = hwDeviceMgr.m3993b();
        if (b != null) {
            this.mDeviceSupportCapacity = b.isSupportExerciseAdvice();
            this.mDeviceSupportPaceMap = b.isSupportWorkoutRecordPaceMap();
        }
        C2538c.m12677c(TAG, "get Device Support runplan Capacity, capacity=" + this.mDeviceSupportCapacity + ",paceMapSupport=" + this.mDeviceSupportPaceMap);
    }

    public void registerForTrackCallback(com.huawei.c.a aVar) {
        C2538c.m12677c(TAG, "======trace registerForTrackCallback enter=======");
    }

    public void unRegisterForTrackCallback() {
    }

    public void setRunPlanReminder(String str) {
    }

    public void planReminderChange() {
        setRunPlanReminder(this.mplanID);
    }

    private int getCurrentDeviceState() {
        if (hwDeviceMgr != null) {
            DeviceInfo currentDeviceInfo = getCurrentDeviceInfo();
            if (currentDeviceInfo != null) {
                return currentDeviceInfo.getDeviceConnectState();
            }
        }
        return 3;
    }

    private void syncWorkoutDetailData(JSONObject jSONObject) {
        if (jSONObject == null) {
            try {
                C2538c.m12677c(TAG, "syncWorkoutDetailData wr is null");
                return;
            } catch (JSONException e) {
                C2538c.m12680e(TAG, e.getMessage());
                return;
            }
        }
        JSONArray jSONArray = jSONObject.getJSONArray("workoutRecordStructList");
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            for (int i2 = 0; i2 < jSONObject2.getInt("workout_index_count"); i2++) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("workout_record_id", jSONObject2.get("workout_record_id"));
                jSONObject3.put("workout_data_index", i2);
                this.lstWorkoutData.add(jSONObject3);
            }
        }
    }

    private void syncRunPlanDetailData(JSONObject jSONObject) {
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("runPlanRecordStructList");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                for (int i2 = 0; i2 < jSONObject2.getInt("run_plan_index_count"); i2++) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("workout_record_id", jSONObject2.get("run_plan_record_id"));
                    jSONObject3.put("workout_data_index", i2);
                    this.lstWorkoutData.add(jSONObject3);
                }
            }
        } catch (JSONException e) {
            C2538c.m12680e(TAG, e.getMessage());
        }
    }

    private void getWorkoutDetailData(JSONObject jSONObject) {
        try {
            HWWorkoutServiceManager.getInstance().getWorkoutData(jSONObject, this.deviceWorkoutDetailCallback);
        } catch (JSONException e) {
            C2538c.m12680e(TAG, e.getMessage());
        }
    }

    public void triggerHiHealthCloutSync() {
        C2538c.m12677c(TAG, "triggerHiHealthCloutSync ");
        this.mThreadPool.execute(new 15(this));
    }

    public void syncFitnessDetailData(IBaseResponseCallback iBaseResponseCallback) {
        DeviceInfo currentDeviceInfo = getCurrentDeviceInfo();
        if (currentDeviceInfo == null || currentDeviceInfo.getDeviceConnectState() != 2) {
            C2538c.m12677c(TAG, "no device is connected.");
            iBaseResponseCallback.onResponse(100001, RemoteUtils.generateRetMap("failure", "syncFitnessDetailData"));
            return;
        }
        Intent intent = new Intent("com.huawei.hihealth.action_receive_push_remote");
        intent.setPackage("com.huawei.bone");
        this.mContext.sendBroadcast(intent);
        iBaseResponseCallback.onResponse(100000, RemoteUtils.generateRetMap(LightCloudConstants.RESPONSE_RESULT_SUCCESS, "syncFitnessDetailData"));
    }

    public void initLogin() {
        Intent intent = new Intent("com.huawei.hihealth.action_receive_push_relogin");
        intent.setPackage("com.huawei.bone");
        this.mContext.sendBroadcast(intent, C0976c.f1642a);
    }

    public void setMetricUnit(JSONObject jSONObject, IBaseResponseCallback iBaseResponseCallback) {
        if (jSONObject != null) {
            try {
                if (jSONObject.has("unit")) {
                    int i;
                    boolean z = jSONObject.getBoolean("unit");
                    C2538c.m12677c(TAG, "imperail unit is set to " + z);
                    if (z) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    Intent intent = new Intent("com.huawei.bone.action.health_refresh_imperial_unit");
                    intent.putExtra("unit", i);
                    this.mContext.sendBroadcast(intent, C0976c.f1642a);
                }
            } catch (JSONException e) {
                C2538c.m12680e(TAG, "setMetricUnit json error e=" + e.getMessage());
            }
        }
        if (iBaseResponseCallback != null) {
            iBaseResponseCallback.onResponse(100001, null);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        C2538c.m12677c(TAG, "OnDestroy!");
    }

    protected Integer getModuleId() {
        return Integer.valueOf(22);
    }

    private static synchronized Object getRunPlanParameterCallbackList() {
        List list;
        synchronized (HWExerciseAdviceManager.class) {
            list = runPlanParameterCallbackList;
        }
        return list;
    }

    private static synchronized Object getSetRunPlanCallbackList() {
        List list;
        synchronized (HWExerciseAdviceManager.class) {
            list = setRunPlanCallbackList;
        }
        return list;
    }

    private static synchronized Object getSetRunPlanReminderSwitchCallbackList() {
        List list;
        synchronized (HWExerciseAdviceManager.class) {
            list = setRunPlanReminderSwitchCallbackList;
        }
        return list;
    }

    private static synchronized Object getGetRunPlanRecordCallbackList() {
        List list;
        synchronized (HWExerciseAdviceManager.class) {
            list = getRunPlanRecordCallbackList;
        }
        return list;
    }

    private static synchronized Object getGetRunPlanRecordInfoCallbackList() {
        List list;
        synchronized (HWExerciseAdviceManager.class) {
            list = getRunPlanRecordInfoCallbackList;
        }
        return list;
    }

    private static synchronized Object getNotificationRunPlanRecordInfoCallbackList() {
        List list;
        synchronized (HWExerciseAdviceManager.class) {
            list = notificationRunPlanRecordInfoCallbackList;
        }
        return list;
    }
}
