package com.huawei.hwcommonmodel.datatypes;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.huawei.hwcommonmodel.p064d.C0978h;

public class DeviceCapability implements Parcelable {
    public static final Creator<DeviceCapability> CREATOR = new C0980h();
    public static final int DEVICE_DATA_TYPE_AF = 4;
    public static final int DEVICE_DATA_TYPE_COMMON = 1;
    public static final int DEVICE_DATA_TYPE_COMPRESSED = 0;
    public static final int DEVICE_DATA_TYPE_LEGENCY = 2;
    public static final int DEVICE_DATA_TYPE_SEPARATED = 3;
    public static final int MOTION_GOAL_CAP_CALORIE = 2;
    public static final int MOTION_GOAL_CAP_DISTANCE = 4;
    public static final int MOTION_GOAL_CAP_STEPS = 1;
    private boolean activity_reminder = false;
    private boolean auto_light_screen = false;
    private boolean avoid_disturb = false;
    private boolean bluetooth_off_alert = false;
    private boolean call_mute = false;
    private boolean calorie = false;
    private boolean climb = false;
    private boolean contacts = false;
    private boolean distance = false;
    private boolean event_alarm = false;
    private int event_alarm_num = 5;
    private boolean factory_reset = false;
    private int fitness_frame_type = 0;
    private boolean gold_card = false;
    private boolean isReserveSync = false;
    private boolean isSupportAccount = false;
    private boolean isSupportActivityType = false;
    private boolean isSupportAntiLost = false;
    private boolean isSupportAuthenticDevice = false;
    private boolean isSupportCallingOperationType = false;
    private boolean isSupportCoreSleep = false;
    private boolean isSupportDeleteMsg = false;
    private boolean isSupportDistanceDetail = false;
    private boolean isSupportEphemerisUpdate = false;
    private boolean isSupportEsim = false;
    private boolean isSupportExerciseAdvice = false;
    private boolean isSupportExerciseAdviceMonitor = false;
    private boolean isSupportExerciseAdviceTime = false;
    private boolean isSupportGPSData = false;
    private boolean isSupportGPSLocation = false;
    private boolean isSupportGPSSetParameter = false;
    private boolean isSupportGetBattery = false;
    private boolean isSupportGetFirmwareVersion = false;
    private boolean isSupportGetHandsetInfo = false;
    private boolean isSupportGetUserInfo = false;
    private boolean isSupportHRZone = false;
    private boolean isSupportHeartRate = false;
    private boolean isSupportHeartRateEnable = false;
    private boolean isSupportHeartRateInfo = false;
    private boolean isSupportHelp = false;
    private boolean isSupportLeftRightHandWearMode = false;
    private boolean isSupportMessageAlertInfo = false;
    private boolean isSupportMessageCenterPushDevice = false;
    private boolean isSupportMessageSupportInfo = false;
    private boolean isSupportMidware = false;
    private boolean isSupportMultiSim = false;
    private boolean isSupportNotificationIntervalInfo = false;
    private boolean isSupportOneLevelMenu = false;
    private boolean isSupportPairDevice = false;
    private boolean isSupportPay = false;
    private boolean isSupportQueryAllowDisturbContent = false;
    private boolean isSupportQueryCoreSleepSwitch = false;
    private boolean isSupportSampleFrame = false;
    private boolean isSupportSendCoreSleepOutState = false;
    private boolean isSupportSetUserInfoEncrypt = false;
    private boolean isSupportSportTotal = false;
    private boolean isSupportStress = false;
    private boolean isSupportStressInfo = false;
    private boolean isSupportThreshold = false;
    private boolean isSupportTimeSetting = false;
    private boolean isSupportWearMessagePush = false;
    private boolean isSupportWorkout = false;
    private boolean isSupportWorkoutExerciseDisplayLink = false;
    private boolean isSupportWorkoutInfo = false;
    private boolean isSupportWorkoutRecord = false;
    private boolean isSupportWorkoutRecordPaceMap = false;
    private boolean isSupportWorkoutReminder = false;
    private boolean language = false;
    private boolean maintenance = false;
    private boolean maintenance_get_data = false;
    private boolean maintenance_in_time = false;
    private boolean message_alert = false;
    private int motionGoalCap = 1;
    private boolean ota_update = false;
    private int prompt_push = 0;
    private boolean riding = false;
    private boolean rotate_switch_screen = false;
    private boolean run = false;
    private boolean sleep = false;
    private boolean sleep_deep = false;
    private boolean sleep_shallow = false;
    private boolean smart_alarm = false;
    private boolean stand = false;
    private boolean step = false;
    private boolean walk = false;
    private boolean weather_push = false;

    public boolean isSupportMidware() {
        return this.isSupportMidware;
    }

    public void configureSupportMidware(boolean z) {
        this.isSupportMidware = z;
    }

    public boolean isSupportLeftRightHandWearMode() {
        return this.isSupportLeftRightHandWearMode;
    }

    public void configureSupportLeftRightHandWearMode(boolean z) {
        this.isSupportLeftRightHandWearMode = z;
    }

    public boolean isSupportQueryAllowDisturbContent() {
        return this.isSupportQueryAllowDisturbContent;
    }

    public void configureSupportQueryAllowDisturbContent(boolean z) {
        this.isSupportQueryAllowDisturbContent = z;
    }

    public boolean isSupportStress() {
        return this.isSupportStress;
    }

    public void configureSupportStress(boolean z) {
        this.isSupportStress = z;
    }

    public boolean isSupportPay() {
        return this.isSupportPay;
    }

    public void configureSupportPay(boolean z) {
        this.isSupportPay = z;
    }

    public boolean isSupportEsim() {
        return this.isSupportEsim;
    }

    public boolean isSupportMultiSim() {
        return this.isSupportMultiSim;
    }

    public void configureSupportEsim(boolean z) {
        this.isSupportEsim = z;
    }

    public void configureSupportMultiSim(boolean z) {
        this.isSupportMultiSim = z;
    }

    public boolean isLanguage() {
        return this.language;
    }

    public void configureLanguage(boolean z) {
        this.language = z;
    }

    public boolean isGold_card() {
        return this.gold_card;
    }

    public void configureGold_card(boolean z) {
        this.gold_card = z;
    }

    public boolean isClimb() {
        return this.climb;
    }

    public void configureClimb(boolean z) {
        this.climb = z;
    }

    public boolean isRiding() {
        return this.riding;
    }

    public void configureRiding(boolean z) {
        this.riding = z;
    }

    public boolean isStand() {
        return this.stand;
    }

    public void configureStand(boolean z) {
        this.stand = z;
    }

    public boolean isSleep_shallow() {
        return this.sleep_shallow;
    }

    public void configureSleep_shallow(boolean z) {
        this.sleep_shallow = z;
    }

    public boolean isSleep_deep() {
        return this.sleep_deep;
    }

    public void configureSleep_deep(boolean z) {
        this.sleep_deep = z;
    }

    public boolean isWalk() {
        return this.walk;
    }

    public void configureWalk(boolean z) {
        this.walk = z;
    }

    public boolean isRun() {
        return this.run;
    }

    public void configureRun(boolean z) {
        this.run = z;
    }

    public boolean isStep() {
        return this.step;
    }

    public void configureStep(boolean z) {
        this.step = z;
    }

    public boolean isCalorie() {
        return this.calorie;
    }

    public void configureCalorie(boolean z) {
        this.calorie = z;
    }

    public boolean isDistance() {
        return this.distance;
    }

    public void configureDistance(boolean z) {
        this.distance = z;
    }

    public boolean isSleep() {
        return this.sleep;
    }

    public void configureSleep(boolean z) {
        this.sleep = z;
    }

    public boolean isActivity_reminder() {
        return this.activity_reminder;
    }

    public void configureActivity_reminder(boolean z) {
        this.activity_reminder = z;
    }

    public boolean isBluetooth_off_alert() {
        return this.bluetooth_off_alert;
    }

    public void configureBluetooth_off_alert(boolean z) {
        this.bluetooth_off_alert = z;
    }

    public boolean isEvent_alarm() {
        return this.event_alarm;
    }

    public void configureEvent_alarm(boolean z) {
        this.event_alarm = z;
    }

    public int getEvent_alarm_num() {
        return this.event_alarm_num;
    }

    public void configureEvent_alarm_num(int i) {
        this.event_alarm_num = i;
    }

    public boolean isSmart_alarm() {
        return this.smart_alarm;
    }

    public void configureSmart_alarm(boolean z) {
        this.smart_alarm = z;
    }

    public boolean isAvoid_disturb() {
        return this.avoid_disturb;
    }

    public void configureAvoid_disturb(boolean z) {
        this.avoid_disturb = z;
    }

    public boolean isMessage_alert() {
        return this.message_alert;
    }

    public void configureMessage_alert(boolean z) {
        this.message_alert = z;
    }

    public boolean isCall_mute() {
        return this.call_mute;
    }

    public void configureCall_mute(boolean z) {
        this.call_mute = z;
    }

    public boolean isWeather_push() {
        return this.weather_push;
    }

    public void configureWeather_push(boolean z) {
        this.weather_push = z;
    }

    public boolean isAuto_light_screen() {
        return this.auto_light_screen;
    }

    public void configureAuto_light_screen(boolean z) {
        this.auto_light_screen = z;
    }

    public boolean isRotate_switch_screen() {
        return this.rotate_switch_screen;
    }

    public void configureRotate_switch_screen(boolean z) {
        this.rotate_switch_screen = z;
    }

    public boolean isContacts() {
        return this.contacts;
    }

    public void configureContacts(boolean z) {
        this.contacts = z;
    }

    public boolean isOta_update() {
        return this.ota_update;
    }

    public void configureOta_update(boolean z) {
        this.ota_update = z;
    }

    public boolean isFactory_reset() {
        return this.factory_reset;
    }

    public void configureFactory_reset(boolean z) {
        this.factory_reset = z;
    }

    public void configureFitness_frame_type(int i) {
        this.fitness_frame_type = i;
    }

    public int getFitness_frame_type() {
        return ((Integer) C0978h.m3579a(Integer.valueOf(this.fitness_frame_type))).intValue();
    }

    public int isPromptPush() {
        return this.prompt_push;
    }

    public void configurePromptPush(int i) {
        this.prompt_push = i;
    }

    public void configureMotionGoalCap(int i) {
        this.motionGoalCap = i;
    }

    public int getMotionGoalCap() {
        return this.motionGoalCap;
    }

    public void configureIsSupportHeartRate(boolean z) {
        this.isSupportHeartRate = z;
    }

    public boolean isSupportHeartRate() {
        return this.isSupportHeartRate;
    }

    public void configureIsSupportHRZone(boolean z) {
        this.isSupportHRZone = z;
    }

    public boolean isSupportHRZone() {
        return this.isSupportHRZone;
    }

    public void configureIsSupportCoreSleep(boolean z) {
        this.isSupportCoreSleep = z;
    }

    public boolean isSupportCoreSleep() {
        return this.isSupportCoreSleep;
    }

    public boolean isSupportSendCoreSleepOutState() {
        return this.isSupportSendCoreSleepOutState;
    }

    public void configureIsSupportSendCoreSleepOutState(boolean z) {
        this.isSupportSendCoreSleepOutState = z;
    }

    public boolean isSupportQueryDeviceCoreSleepSwitch() {
        return this.isSupportQueryCoreSleepSwitch;
    }

    public void configureIsSupportQueryDeviceCoreSleepSwitch(boolean z) {
        this.isSupportQueryCoreSleepSwitch = z;
    }

    public void configureisSupportHeartRateEnable(boolean z) {
        this.isSupportHeartRateEnable = z;
    }

    public boolean isSupportHeartRateEnable() {
        return this.isSupportHeartRateEnable;
    }

    public boolean isSupportGetUserInfo() {
        return this.isSupportGetUserInfo;
    }

    public void configureSupportGetUserInfo(boolean z) {
        this.isSupportGetUserInfo = z;
    }

    public void configureIsSupportHelp(boolean z) {
        this.isSupportHelp = z;
    }

    public boolean isSupportHelp() {
        return this.isSupportHelp;
    }

    public void configureSupportExerciseAdvice(boolean z) {
        this.isSupportExerciseAdvice = z;
    }

    public boolean isSupportExerciseAdvice() {
        return this.isSupportExerciseAdvice;
    }

    public void configureSupportWorkout(boolean z) {
        this.isSupportWorkout = z;
    }

    public boolean isSupportWorkout() {
        return this.isSupportWorkout;
    }

    public void configureReserveSync(boolean z) {
        this.isReserveSync = z;
    }

    public boolean isReserveSync() {
        return this.isReserveSync;
    }

    public void configureSupportGPSLocation(boolean z) {
        this.isSupportGPSLocation = z;
    }

    public boolean isSupportGPSLocation() {
        return this.isSupportGPSLocation;
    }

    public boolean isMaintenance() {
        return this.maintenance;
    }

    public void configureMaintenance(boolean z) {
        this.maintenance = z;
    }

    public boolean isMaintenance_in_time() {
        return this.maintenance_in_time;
    }

    public void configureMaintenance_in_time(boolean z) {
        this.maintenance_in_time = z;
    }

    public boolean isMaintenance_get_data() {
        return this.maintenance_get_data;
    }

    public void configureMaintenance_get_data(boolean z) {
        this.maintenance_get_data = z;
    }

    public void configureDistanceDetail(boolean z) {
        this.isSupportDistanceDetail = z;
    }

    public boolean getDistanceDetail() {
        return this.isSupportDistanceDetail;
    }

    public boolean isSupportTimeSetting() {
        return this.isSupportTimeSetting;
    }

    public void configureSupportTimeSetting(boolean z) {
        this.isSupportTimeSetting = z;
    }

    public boolean isSupportGetFirmwareVersion() {
        return this.isSupportGetFirmwareVersion;
    }

    public void configureSupportGetFirmwareVersion(boolean z) {
        this.isSupportGetFirmwareVersion = z;
    }

    public boolean isSupportGetBattery() {
        return this.isSupportGetBattery;
    }

    public void configureSupportGetBattery(boolean z) {
        this.isSupportGetBattery = z;
    }

    public boolean isSupportPairDevice() {
        return this.isSupportPairDevice;
    }

    public void configureSupportPairDevice(boolean z) {
        this.isSupportPairDevice = z;
    }

    public boolean isSupportGetHandsetInfo() {
        return this.isSupportGetHandsetInfo;
    }

    public void configureSupportGetHandsetInfo(boolean z) {
        this.isSupportGetHandsetInfo = z;
    }

    public boolean isSupportNotificationIntervalInfo() {
        return this.isSupportNotificationIntervalInfo;
    }

    public void configureSupportNotificationIntervalInfo(boolean z) {
        this.isSupportNotificationIntervalInfo = z;
    }

    public boolean isSupportActivityType() {
        return this.isSupportActivityType;
    }

    public void configureSupportActivityType(boolean z) {
        this.isSupportActivityType = z;
    }

    public boolean isSupportAuthenticDevice() {
        return this.isSupportAuthenticDevice;
    }

    public void configureSupportAuthenticDevice(boolean z) {
        this.isSupportAuthenticDevice = z;
    }

    public boolean isSupportMessageAlertInfo() {
        return this.isSupportMessageAlertInfo;
    }

    public void configureSupportMessageAlertInfo(boolean z) {
        this.isSupportMessageAlertInfo = z;
    }

    public boolean isSupportMessageSupportInfo() {
        return this.isSupportMessageSupportInfo;
    }

    public void configureSupportMessageSupportInfo(boolean z) {
        this.isSupportMessageSupportInfo = z;
    }

    public boolean isSupportMessageCenterPushDevice() {
        return this.isSupportMessageCenterPushDevice;
    }

    public void configureupportMessageCenterPushDevice(boolean z) {
        this.isSupportMessageCenterPushDevice = z;
    }

    public boolean isSupportWearMessagePush() {
        return this.isSupportWearMessagePush;
    }

    public void configureSupportWearMessagePush(boolean z) {
        this.isSupportWearMessagePush = z;
    }

    public boolean isSupportCallingOperationType() {
        return this.isSupportCallingOperationType;
    }

    public void configureSupportCallingOperationType(boolean z) {
        this.isSupportCallingOperationType = z;
    }

    public boolean isSupportSetUserInfoEncrypt() {
        return this.isSupportSetUserInfoEncrypt;
    }

    public void configureSupportSetUserInfoEncrypt(boolean z) {
        this.isSupportSetUserInfoEncrypt = z;
    }

    public boolean isSupportSampleFrame() {
        return this.isSupportSampleFrame;
    }

    public void configureSupportSampleFrame(boolean z) {
        this.isSupportSampleFrame = z;
    }

    public boolean isSupportThreshold() {
        return this.isSupportThreshold;
    }

    public void configureSupportThreshold(boolean z) {
        this.isSupportThreshold = z;
    }

    public boolean isSupportAntiLost() {
        return this.isSupportAntiLost;
    }

    public void configureSupportAntiLost(boolean z) {
        this.isSupportAntiLost = z;
    }

    public boolean isSupportExerciseAdviceTime() {
        return this.isSupportExerciseAdviceTime;
    }

    public void configureSupportExerciseAdviceTime(boolean z) {
        this.isSupportExerciseAdviceTime = z;
    }

    public boolean isSupportExerciseAdviceMonitor() {
        return this.isSupportExerciseAdviceMonitor;
    }

    public void configureSupportExerciseAdviceMonitor(boolean z) {
        this.isSupportExerciseAdviceMonitor = z;
    }

    public boolean isSupportWorkoutInfo() {
        return this.isSupportWorkoutInfo;
    }

    public void configureSupportWorkoutInfo(boolean z) {
        this.isSupportWorkoutInfo = z;
    }

    public boolean isSupportWorkoutReminder() {
        return this.isSupportWorkoutReminder;
    }

    public void configureSupportWorkoutReminder(boolean z) {
        this.isSupportWorkoutReminder = z;
    }

    public boolean isSupportWorkoutRecord() {
        return this.isSupportWorkoutRecord;
    }

    public void configureSupportWorkoutRecord(boolean z) {
        this.isSupportWorkoutRecord = z;
    }

    public boolean isSupportWorkoutExerciseDisplayLink() {
        return this.isSupportWorkoutExerciseDisplayLink;
    }

    public void configureSupportWorkoutExerciseDisplayLink(boolean z) {
        this.isSupportWorkoutExerciseDisplayLink = z;
    }

    public boolean isSupportWorkoutRecordPaceMap() {
        return this.isSupportWorkoutRecordPaceMap;
    }

    public void configureSupportWorkoutRecordPaceMap(boolean z) {
        this.isSupportWorkoutRecordPaceMap = z;
    }

    public boolean isSupportGPSData() {
        return this.isSupportGPSData;
    }

    public void configureSupportGPSData(boolean z) {
        this.isSupportGPSData = z;
    }

    public boolean isSupportGPSSetParameter() {
        return this.isSupportGPSSetParameter;
    }

    public void configureSupportGPSSetParameter(boolean z) {
        this.isSupportGPSSetParameter = z;
    }

    public boolean isSupportHeartRateInfo() {
        return this.isSupportHeartRateInfo;
    }

    public void configureSupportHeartRateInfo(boolean z) {
        this.isSupportHeartRateInfo = z;
    }

    public void configureSupportStressInfo(boolean z) {
        this.isSupportStressInfo = z;
    }

    public boolean isSupportStressInfo() {
        return this.isSupportStressInfo;
    }

    public boolean isSupportSportTotal() {
        return this.isSupportSportTotal;
    }

    public void configureSupportSportTotal(boolean z) {
        this.isSupportSportTotal = z;
    }

    public boolean isSupportAccount() {
        return this.isSupportAccount;
    }

    public void configureSupportAccount(boolean z) {
        this.isSupportAccount = z;
    }

    public boolean isSupportOneLevelMenu() {
        return this.isSupportOneLevelMenu;
    }

    public void configureSupportOneLevelMenu(boolean z) {
        this.isSupportOneLevelMenu = z;
    }

    public boolean isSupportDeleteMsg() {
        return this.isSupportDeleteMsg;
    }

    public void configureSupportDeleteMsg(boolean z) {
        this.isSupportDeleteMsg = z;
    }

    public boolean isSupportEphemerisInfoUpdate() {
        return this.isSupportEphemerisUpdate;
    }

    public void configureSupportEphemerisInfoUpdate(boolean z) {
        this.isSupportEphemerisUpdate = z;
    }

    public void resetDeviceCapability() {
        this.isSupportTimeSetting = false;
        this.isSupportGetFirmwareVersion = false;
        this.isSupportGetBattery = false;
        this.auto_light_screen = false;
        this.avoid_disturb = false;
        this.factory_reset = false;
        this.isSupportPairDevice = false;
        this.isSupportGetHandsetInfo = false;
        this.isSupportNotificationIntervalInfo = false;
        this.isSupportActivityType = false;
        this.isSupportAuthenticDevice = false;
        this.gold_card = false;
        this.message_alert = false;
        this.isSupportMessageAlertInfo = false;
        this.isSupportMessageSupportInfo = false;
        this.contacts = false;
        this.isSupportCallingOperationType = false;
        this.motionGoalCap = 1;
        this.fitness_frame_type = 0;
        this.activity_reminder = false;
        this.isSupportSetUserInfoEncrypt = false;
        this.isSupportSampleFrame = false;
        this.isSupportThreshold = false;
        this.isReserveSync = false;
        this.isSupportHRZone = false;
        this.isSupportCoreSleep = false;
        this.isSupportSendCoreSleepOutState = false;
        this.isSupportQueryCoreSleepSwitch = false;
        this.isSupportMessageCenterPushDevice = false;
        this.isSupportWearMessagePush = false;
        this.isSupportGetUserInfo = false;
        this.event_alarm = false;
        this.event_alarm_num = 5;
        this.smart_alarm = false;
        this.ota_update = false;
        this.maintenance = false;
        this.maintenance_in_time = false;
        this.maintenance_get_data = false;
        this.isSupportAntiLost = false;
        this.bluetooth_off_alert = false;
        this.language = false;
        this.weather_push = false;
        this.isSupportExerciseAdvice = false;
        this.isSupportExerciseAdviceTime = false;
        this.isSupportExerciseAdviceMonitor = false;
        this.isSupportWorkout = false;
        this.isSupportWorkoutInfo = false;
        this.isSupportWorkoutReminder = false;
        this.isSupportWorkoutRecord = false;
        this.isSupportWorkoutExerciseDisplayLink = false;
        this.isSupportWorkoutRecordPaceMap = false;
        this.isSupportGPSLocation = false;
        this.isSupportGPSData = false;
        this.isSupportGPSSetParameter = false;
        this.isSupportHeartRateInfo = false;
        this.isSupportHeartRateEnable = false;
        this.isSupportStressInfo = false;
        this.sleep = false;
        this.climb = false;
        this.riding = false;
        this.stand = false;
        this.sleep_shallow = false;
        this.sleep_deep = false;
        this.walk = false;
        this.run = false;
        this.step = false;
        this.calorie = false;
        this.distance = false;
        this.isSupportHeartRate = false;
        this.prompt_push = 0;
        this.call_mute = false;
        this.isSupportHelp = false;
        this.isSupportDistanceDetail = false;
        this.isSupportEsim = false;
        this.isSupportMultiSim = false;
        this.isSupportPay = false;
        this.rotate_switch_screen = false;
        this.isSupportLeftRightHandWearMode = false;
        this.isSupportStress = false;
        this.isSupportMidware = false;
        this.isSupportSportTotal = false;
        this.isSupportAccount = false;
        this.isSupportOneLevelMenu = false;
        this.isSupportDeleteMsg = false;
        this.isSupportQueryAllowDisturbContent = false;
        this.isSupportEphemerisUpdate = false;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte((byte) getByte(this.isSupportTimeSetting));
        parcel.writeByte((byte) getByte(this.isSupportGetFirmwareVersion));
        parcel.writeByte((byte) getByte(this.isSupportGetBattery));
        parcel.writeByte((byte) getByte(this.auto_light_screen));
        parcel.writeByte((byte) getByte(this.avoid_disturb));
        parcel.writeByte((byte) getByte(this.factory_reset));
        parcel.writeByte((byte) getByte(this.isSupportPairDevice));
        parcel.writeByte((byte) getByte(this.isSupportGetHandsetInfo));
        parcel.writeByte((byte) getByte(this.isSupportNotificationIntervalInfo));
        parcel.writeByte((byte) getByte(this.isSupportActivityType));
        parcel.writeByte((byte) getByte(this.isSupportAuthenticDevice));
        parcel.writeByte((byte) getByte(this.gold_card));
        parcel.writeByte((byte) getByte(this.message_alert));
        parcel.writeByte((byte) getByte(this.isSupportMessageAlertInfo));
        parcel.writeByte((byte) getByte(this.isSupportMessageSupportInfo));
        parcel.writeByte((byte) getByte(this.isSupportMessageCenterPushDevice));
        parcel.writeByte((byte) getByte(this.isSupportWearMessagePush));
        parcel.writeByte((byte) getByte(this.contacts));
        parcel.writeByte((byte) getByte(this.isSupportCallingOperationType));
        parcel.writeInt(this.motionGoalCap);
        parcel.writeInt(this.fitness_frame_type);
        parcel.writeByte((byte) getByte(this.activity_reminder));
        parcel.writeByte((byte) getByte(this.isSupportSetUserInfoEncrypt));
        parcel.writeByte((byte) getByte(this.isSupportSampleFrame));
        parcel.writeByte((byte) getByte(this.isSupportThreshold));
        parcel.writeByte((byte) getByte(this.isReserveSync));
        parcel.writeByte((byte) getByte(this.isSupportHRZone));
        parcel.writeByte((byte) (this.isSupportCoreSleep ? 1 : 0));
        parcel.writeByte((byte) getByte(this.isSupportGetUserInfo));
        parcel.writeByte((byte) getByte(this.isSupportSendCoreSleepOutState));
        parcel.writeByte((byte) getByte(this.isSupportQueryCoreSleepSwitch));
        parcel.writeByte((byte) getByte(this.event_alarm));
        parcel.writeInt(this.event_alarm_num);
        parcel.writeByte((byte) getByte(this.smart_alarm));
        parcel.writeByte((byte) getByte(this.ota_update));
        parcel.writeByte((byte) getByte(this.maintenance));
        parcel.writeByte((byte) getByte(this.maintenance_in_time));
        parcel.writeByte((byte) getByte(this.maintenance_get_data));
        parcel.writeByte((byte) getByte(this.isSupportAntiLost));
        parcel.writeByte((byte) getByte(this.bluetooth_off_alert));
        parcel.writeByte((byte) getByte(this.language));
        parcel.writeByte((byte) getByte(this.weather_push));
        parcel.writeByte((byte) getByte(this.isSupportExerciseAdvice));
        parcel.writeByte((byte) getByte(this.isSupportExerciseAdviceTime));
        parcel.writeByte((byte) getByte(this.isSupportExerciseAdviceMonitor));
        parcel.writeByte((byte) getByte(this.isSupportWorkout));
        parcel.writeByte((byte) getByte(this.isSupportWorkoutInfo));
        parcel.writeByte((byte) getByte(this.isSupportWorkoutReminder));
        parcel.writeByte((byte) getByte(this.isSupportWorkoutRecord));
        parcel.writeByte((byte) getByte(this.isSupportWorkoutExerciseDisplayLink));
        parcel.writeByte((byte) getByte(this.isSupportWorkoutRecordPaceMap));
        parcel.writeByte((byte) getByte(this.isSupportGPSLocation));
        parcel.writeByte((byte) getByte(this.isSupportGPSData));
        parcel.writeByte((byte) getByte(this.isSupportGPSSetParameter));
        parcel.writeByte((byte) getByte(this.isSupportHeartRateInfo));
        parcel.writeByte((byte) getByte(this.sleep));
        parcel.writeByte((byte) getByte(this.climb));
        parcel.writeByte((byte) getByte(this.riding));
        parcel.writeByte((byte) getByte(this.stand));
        parcel.writeByte((byte) getByte(this.sleep_shallow));
        parcel.writeByte((byte) getByte(this.sleep_deep));
        parcel.writeByte((byte) getByte(this.walk));
        parcel.writeByte((byte) getByte(this.run));
        parcel.writeByte((byte) getByte(this.step));
        parcel.writeByte((byte) getByte(this.calorie));
        parcel.writeByte((byte) getByte(this.distance));
        parcel.writeByte((byte) getByte(this.isSupportHeartRate));
        parcel.writeInt(this.prompt_push);
        parcel.writeByte((byte) getByte(this.call_mute));
        parcel.writeByte((byte) getByte(this.isSupportHelp));
        parcel.writeByte((byte) getByte(this.isSupportDistanceDetail));
        parcel.writeByte((byte) getByte(this.isSupportEsim));
        parcel.writeByte((byte) getByte(this.isSupportMultiSim));
        parcel.writeByte((byte) getByte(this.isSupportPay));
        parcel.writeByte((byte) getByte(this.isSupportHeartRateEnable));
        parcel.writeByte((byte) getByte(this.rotate_switch_screen));
        parcel.writeByte((byte) getByte(this.isSupportQueryAllowDisturbContent));
        parcel.writeByte((byte) getByte(this.isSupportLeftRightHandWearMode));
        parcel.writeByte((byte) getByte(this.isSupportStress));
        parcel.writeByte((byte) getByte(this.isSupportMidware));
        parcel.writeByte((byte) getByte(this.isSupportSportTotal));
        parcel.writeByte((byte) getByte(this.isSupportAccount));
        parcel.writeByte((byte) getByte(this.isSupportOneLevelMenu));
        parcel.writeByte((byte) getByte(this.isSupportDeleteMsg));
        parcel.writeByte((byte) getByte(this.isSupportEphemerisUpdate));
    }

    private int getByte(boolean z) {
        return z ? 1 : 0;
    }
}
