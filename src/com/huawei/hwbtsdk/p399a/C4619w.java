package com.huawei.hwbtsdk.p399a;

import android.content.Context;
import cn.com.fmsh.script.constants.ScriptToolsConst;
import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import com.huawei.hwcommonmodel.datatypes.DeviceCapability;
import com.huawei.p190v.C2538c;

/* compiled from: ParseDeviceCapability */
public class C4619w {
    static final byte[] f16883a = new byte[]{TagName.ELECTRONIC_TYPE, TagName.ELECTRONIC_TRANSFER_FLAG, TagName.PAY_ORDER_LIST, TagName.MAIN_ORDER_LIST, ScriptToolsConst.TagName.TagApdu};

    public static void m22049a(Context context, int i, DeviceCapability deviceCapability) {
        C2538c.a("01", 1, "ParseDeviceCapability", new Object[]{"Enter handleV1V0DeviceCapability()."});
        if (-1 == i || deviceCapability == null) {
            C2538c.a("0xA0200008", "01", 1, "ParseDeviceCapability", new Object[]{"Parameter is incorrect."});
            return;
        }
        switch (i) {
            case 0:
                C4619w.m22058c(deviceCapability);
                return;
            case 1:
                C4619w.m22062d(deviceCapability);
                return;
            case 3:
                C4619w.m22065e(deviceCapability);
                return;
            case 5:
                C4619w.m22054b(deviceCapability);
                return;
            default:
                return;
        }
    }

    private static void m22054b(DeviceCapability deviceCapability) {
        deviceCapability.configureSupportTimeSetting(true);
        deviceCapability.configureSupportGetFirmwareVersion(true);
        deviceCapability.configureSupportGetBattery(true);
        deviceCapability.configureAuto_light_screen(true);
        deviceCapability.configureAvoid_disturb(true);
        deviceCapability.configureFactory_reset(true);
        deviceCapability.configureSupportPairDevice(true);
        deviceCapability.configureSupportGetHandsetInfo(true);
        deviceCapability.configureSupportNotificationIntervalInfo(true);
        deviceCapability.configureSupportActivityType(false);
        deviceCapability.configureSupportAuthenticDevice(false);
        deviceCapability.configureGold_card(false);
        deviceCapability.configureSupportLeftRightHandWearMode(false);
        deviceCapability.configureMessage_alert(true);
        deviceCapability.configureSupportMessageAlertInfo(false);
        deviceCapability.configureSupportMessageSupportInfo(false);
        deviceCapability.configureupportMessageCenterPushDevice(false);
        deviceCapability.configureContacts(false);
        deviceCapability.configureSupportCallingOperationType(false);
        deviceCapability.configureMotionGoalCap(1);
        deviceCapability.configureFitness_frame_type(0);
        deviceCapability.configureActivity_reminder(true);
        deviceCapability.configureSupportSetUserInfoEncrypt(false);
        deviceCapability.configureSupportSampleFrame(false);
        deviceCapability.configureSupportThreshold(false);
        deviceCapability.configureReserveSync(false);
        deviceCapability.configureIsSupportHRZone(false);
        deviceCapability.configureIsSupportSendCoreSleepOutState(false);
        deviceCapability.configureIsSupportQueryDeviceCoreSleepSwitch(false);
        deviceCapability.configureEvent_alarm(true);
        deviceCapability.configureEvent_alarm_num(5);
        deviceCapability.configureSmart_alarm(true);
        deviceCapability.configureOta_update(true);
        deviceCapability.configureMaintenance(false);
        deviceCapability.configureMaintenance_in_time(false);
        deviceCapability.configureMaintenance_get_data(false);
        deviceCapability.configureSupportAntiLost(false);
        deviceCapability.configureBluetooth_off_alert(false);
        deviceCapability.configureLanguage(true);
        deviceCapability.configureWeather_push(false);
        deviceCapability.configureSupportExerciseAdvice(false);
        deviceCapability.configureSupportExerciseAdviceTime(false);
        deviceCapability.configureSupportExerciseAdviceMonitor(false);
        deviceCapability.configureSupportWorkout(false);
        deviceCapability.configureSupportWorkoutInfo(false);
        deviceCapability.configureSupportWorkoutReminder(false);
        deviceCapability.configureSupportWorkoutRecord(false);
        deviceCapability.configureSupportWorkoutExerciseDisplayLink(false);
        deviceCapability.configureSupportWorkoutRecordPaceMap(false);
        deviceCapability.configureSupportGPSLocation(false);
        deviceCapability.configureSupportGPSData(false);
        deviceCapability.configureSupportHeartRateInfo(false);
        deviceCapability.configureSleep(true);
        deviceCapability.configureClimb(false);
        deviceCapability.configureRiding(false);
        deviceCapability.configureStand(false);
        deviceCapability.configureSleep_shallow(true);
        deviceCapability.configureSleep_deep(true);
        deviceCapability.configureWalk(true);
        deviceCapability.configureRun(true);
        deviceCapability.configureStep(true);
        deviceCapability.configureCalorie(true);
        deviceCapability.configureDistance(true);
        deviceCapability.configureIsSupportHeartRate(false);
        deviceCapability.configurePromptPush(1);
        deviceCapability.configureCall_mute(false);
        deviceCapability.configureIsSupportHelp(true);
        deviceCapability.configureDistanceDetail(true);
        deviceCapability.configureRotate_switch_screen(false);
        deviceCapability.configureSupportQueryAllowDisturbContent(false);
        deviceCapability.configureSupportEphemerisInfoUpdate(false);
    }

    private static void m22058c(DeviceCapability deviceCapability) {
        deviceCapability.configureSupportTimeSetting(true);
        deviceCapability.configureSupportGetFirmwareVersion(true);
        deviceCapability.configureSupportGetBattery(true);
        deviceCapability.configureAuto_light_screen(false);
        deviceCapability.configureAvoid_disturb(false);
        deviceCapability.configureFactory_reset(true);
        deviceCapability.configureSupportPairDevice(false);
        deviceCapability.configureSupportGetHandsetInfo(false);
        deviceCapability.configureSupportNotificationIntervalInfo(false);
        deviceCapability.configureSupportActivityType(false);
        deviceCapability.configureSupportAuthenticDevice(false);
        deviceCapability.configureGold_card(false);
        deviceCapability.configureSupportLeftRightHandWearMode(false);
        deviceCapability.configureMessage_alert(false);
        deviceCapability.configureSupportMessageAlertInfo(false);
        deviceCapability.configureSupportMessageSupportInfo(false);
        deviceCapability.configureupportMessageCenterPushDevice(false);
        deviceCapability.configureContacts(false);
        deviceCapability.configureSupportCallingOperationType(false);
        deviceCapability.configureMotionGoalCap(1);
        deviceCapability.configureFitness_frame_type(2);
        deviceCapability.configureActivity_reminder(true);
        deviceCapability.configureSupportSetUserInfoEncrypt(false);
        deviceCapability.configureSupportSampleFrame(false);
        deviceCapability.configureSupportThreshold(false);
        deviceCapability.configureReserveSync(false);
        deviceCapability.configureIsSupportHRZone(false);
        deviceCapability.configureIsSupportSendCoreSleepOutState(false);
        deviceCapability.configureIsSupportQueryDeviceCoreSleepSwitch(false);
        deviceCapability.configureEvent_alarm(true);
        deviceCapability.configureEvent_alarm_num(5);
        deviceCapability.configureSmart_alarm(true);
        deviceCapability.configureOta_update(false);
        deviceCapability.configureMaintenance(false);
        deviceCapability.configureMaintenance_in_time(false);
        deviceCapability.configureMaintenance_get_data(false);
        deviceCapability.configureSupportAntiLost(false);
        deviceCapability.configureBluetooth_off_alert(false);
        deviceCapability.configureLanguage(false);
        deviceCapability.configureWeather_push(false);
        deviceCapability.configureSupportExerciseAdvice(false);
        deviceCapability.configureSupportExerciseAdviceTime(false);
        deviceCapability.configureSupportExerciseAdviceMonitor(false);
        deviceCapability.configureSupportWorkout(false);
        deviceCapability.configureSupportWorkoutInfo(false);
        deviceCapability.configureSupportWorkoutReminder(false);
        deviceCapability.configureSupportWorkoutRecord(false);
        deviceCapability.configureSupportWorkoutExerciseDisplayLink(false);
        deviceCapability.configureSupportWorkoutRecordPaceMap(false);
        deviceCapability.configureSupportGPSLocation(false);
        deviceCapability.configureSupportGPSData(false);
        deviceCapability.configureSupportHeartRateInfo(false);
        deviceCapability.configureSleep(true);
        deviceCapability.configureClimb(false);
        deviceCapability.configureRiding(false);
        deviceCapability.configureStand(false);
        deviceCapability.configureSleep_shallow(true);
        deviceCapability.configureSleep_deep(true);
        deviceCapability.configureWalk(true);
        deviceCapability.configureRun(false);
        deviceCapability.configureStep(true);
        deviceCapability.configureCalorie(true);
        deviceCapability.configureDistance(true);
        deviceCapability.configureIsSupportHeartRate(false);
        deviceCapability.configurePromptPush(0);
        deviceCapability.configureCall_mute(false);
        deviceCapability.configureIsSupportHelp(false);
        deviceCapability.configureDistanceDetail(true);
        deviceCapability.configureRotate_switch_screen(false);
        deviceCapability.configureSupportQueryAllowDisturbContent(false);
        deviceCapability.configureSupportEphemerisInfoUpdate(false);
    }

    private static void m22062d(DeviceCapability deviceCapability) {
        deviceCapability.configureSupportTimeSetting(true);
        deviceCapability.configureSupportGetFirmwareVersion(true);
        deviceCapability.configureSupportGetBattery(true);
        deviceCapability.configureAuto_light_screen(true);
        deviceCapability.configureAvoid_disturb(true);
        deviceCapability.configureFactory_reset(true);
        deviceCapability.configureSupportPairDevice(false);
        deviceCapability.configureSupportGetHandsetInfo(false);
        deviceCapability.configureSupportNotificationIntervalInfo(false);
        deviceCapability.configureSupportActivityType(false);
        deviceCapability.configureSupportAuthenticDevice(false);
        deviceCapability.configureGold_card(false);
        deviceCapability.configureSupportLeftRightHandWearMode(false);
        deviceCapability.configureMessage_alert(true);
        deviceCapability.configureSupportMessageAlertInfo(false);
        deviceCapability.configureSupportMessageSupportInfo(false);
        deviceCapability.configureupportMessageCenterPushDevice(false);
        deviceCapability.configureContacts(false);
        deviceCapability.configureSupportCallingOperationType(false);
        deviceCapability.configureMotionGoalCap(1);
        deviceCapability.configureFitness_frame_type(0);
        deviceCapability.configureActivity_reminder(true);
        deviceCapability.configureSupportSetUserInfoEncrypt(false);
        deviceCapability.configureSupportSampleFrame(false);
        deviceCapability.configureSupportThreshold(false);
        deviceCapability.configureReserveSync(false);
        deviceCapability.configureIsSupportHRZone(false);
        deviceCapability.configureIsSupportSendCoreSleepOutState(false);
        deviceCapability.configureIsSupportQueryDeviceCoreSleepSwitch(false);
        deviceCapability.configureEvent_alarm(true);
        deviceCapability.configureEvent_alarm_num(5);
        deviceCapability.configureSmart_alarm(true);
        deviceCapability.configureOta_update(true);
        deviceCapability.configureMaintenance(false);
        deviceCapability.configureMaintenance_in_time(false);
        deviceCapability.configureMaintenance_get_data(false);
        deviceCapability.configureSupportAntiLost(true);
        deviceCapability.configureBluetooth_off_alert(false);
        deviceCapability.configureLanguage(true);
        deviceCapability.configureWeather_push(true);
        deviceCapability.configureSupportExerciseAdvice(false);
        deviceCapability.configureSupportExerciseAdviceTime(false);
        deviceCapability.configureSupportExerciseAdviceMonitor(false);
        deviceCapability.configureSupportWorkout(false);
        deviceCapability.configureSupportWorkoutInfo(false);
        deviceCapability.configureSupportWorkoutReminder(false);
        deviceCapability.configureSupportWorkoutRecord(false);
        deviceCapability.configureSupportWorkoutExerciseDisplayLink(false);
        deviceCapability.configureSupportWorkoutRecordPaceMap(false);
        deviceCapability.configureSupportGPSLocation(false);
        deviceCapability.configureSupportGPSData(false);
        deviceCapability.configureSupportHeartRateInfo(false);
        deviceCapability.configureSleep(true);
        deviceCapability.configureClimb(false);
        deviceCapability.configureRiding(true);
        deviceCapability.configureStand(false);
        deviceCapability.configureSleep_shallow(true);
        deviceCapability.configureSleep_deep(true);
        deviceCapability.configureWalk(true);
        deviceCapability.configureRun(true);
        deviceCapability.configureStep(true);
        deviceCapability.configureCalorie(true);
        deviceCapability.configureDistance(true);
        deviceCapability.configureIsSupportHeartRate(false);
        deviceCapability.configurePromptPush(3);
        deviceCapability.configureCall_mute(false);
        deviceCapability.configureIsSupportHelp(true);
        deviceCapability.configureDistanceDetail(true);
        deviceCapability.configureRotate_switch_screen(false);
        deviceCapability.configureSupportQueryAllowDisturbContent(false);
        deviceCapability.configureSupportEphemerisInfoUpdate(false);
    }

    private static void m22065e(DeviceCapability deviceCapability) {
        deviceCapability.configureSupportTimeSetting(false);
        deviceCapability.configureSupportGetFirmwareVersion(true);
        deviceCapability.configureSupportGetBattery(true);
        deviceCapability.configureAuto_light_screen(false);
        deviceCapability.configureAvoid_disturb(false);
        deviceCapability.configureFactory_reset(false);
        deviceCapability.configureSupportPairDevice(false);
        deviceCapability.configureSupportGetHandsetInfo(false);
        deviceCapability.configureSupportNotificationIntervalInfo(false);
        deviceCapability.configureSupportActivityType(false);
        deviceCapability.configureSupportAuthenticDevice(false);
        deviceCapability.configureGold_card(true);
        deviceCapability.configureSupportLeftRightHandWearMode(false);
        deviceCapability.configureMessage_alert(false);
        deviceCapability.configureSupportMessageAlertInfo(false);
        deviceCapability.configureSupportMessageSupportInfo(false);
        deviceCapability.configureupportMessageCenterPushDevice(false);
        deviceCapability.configureContacts(false);
        deviceCapability.configureSupportCallingOperationType(false);
        deviceCapability.configureMotionGoalCap(1);
        deviceCapability.configureFitness_frame_type(1);
        deviceCapability.configureActivity_reminder(false);
        deviceCapability.configureSupportSetUserInfoEncrypt(false);
        deviceCapability.configureSupportSampleFrame(false);
        deviceCapability.configureSupportThreshold(false);
        deviceCapability.configureReserveSync(false);
        deviceCapability.configureIsSupportHRZone(false);
        deviceCapability.configureIsSupportCoreSleep(false);
        deviceCapability.configureIsSupportSendCoreSleepOutState(false);
        deviceCapability.configureIsSupportQueryDeviceCoreSleepSwitch(false);
        deviceCapability.configureEvent_alarm(false);
        deviceCapability.configureEvent_alarm_num(0);
        deviceCapability.configureSmart_alarm(false);
        deviceCapability.configureOta_update(false);
        deviceCapability.configureMaintenance(false);
        deviceCapability.configureMaintenance_in_time(false);
        deviceCapability.configureMaintenance_get_data(false);
        deviceCapability.configureSupportAntiLost(false);
        deviceCapability.configureBluetooth_off_alert(false);
        deviceCapability.configureLanguage(false);
        deviceCapability.configureWeather_push(false);
        deviceCapability.configureSupportExerciseAdvice(false);
        deviceCapability.configureSupportExerciseAdviceTime(false);
        deviceCapability.configureSupportExerciseAdviceMonitor(false);
        deviceCapability.configureSupportWorkout(false);
        deviceCapability.configureSupportWorkoutInfo(false);
        deviceCapability.configureSupportWorkoutReminder(false);
        deviceCapability.configureSupportWorkoutRecord(false);
        deviceCapability.configureSupportWorkoutExerciseDisplayLink(false);
        deviceCapability.configureSupportWorkoutRecordPaceMap(false);
        deviceCapability.configureSupportGPSLocation(false);
        deviceCapability.configureSupportGPSData(false);
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
        deviceCapability.configureRotate_switch_screen(false);
        deviceCapability.configureSupportQueryAllowDisturbContent(false);
        deviceCapability.configureSupportEphemerisInfoUpdate(false);
    }

    public static void m22050a(DeviceCapability deviceCapability) {
        deviceCapability.configureSupportTimeSetting(false);
        deviceCapability.configureSupportGetFirmwareVersion(false);
        deviceCapability.configureSupportGetBattery(false);
        deviceCapability.configureAuto_light_screen(false);
        deviceCapability.configureAvoid_disturb(false);
        deviceCapability.configureFactory_reset(false);
        deviceCapability.configureSupportPairDevice(false);
        deviceCapability.configureSupportGetHandsetInfo(false);
        deviceCapability.configureSupportNotificationIntervalInfo(false);
        deviceCapability.configureSupportActivityType(false);
        deviceCapability.configureSupportAuthenticDevice(false);
        deviceCapability.configureGold_card(false);
        deviceCapability.configureSupportLeftRightHandWearMode(false);
        deviceCapability.configureMessage_alert(false);
        deviceCapability.configureSupportMessageAlertInfo(false);
        deviceCapability.configureSupportMessageSupportInfo(false);
        deviceCapability.configureupportMessageCenterPushDevice(false);
        deviceCapability.configureContacts(false);
        deviceCapability.configureSupportCallingOperationType(false);
        deviceCapability.configureMotionGoalCap(1);
        deviceCapability.configureFitness_frame_type(4);
        deviceCapability.configureActivity_reminder(false);
        deviceCapability.configureSupportSetUserInfoEncrypt(false);
        deviceCapability.configureSupportSampleFrame(false);
        deviceCapability.configureSupportThreshold(false);
        deviceCapability.configureReserveSync(false);
        deviceCapability.configureIsSupportHRZone(false);
        deviceCapability.configureIsSupportSendCoreSleepOutState(false);
        deviceCapability.configureIsSupportQueryDeviceCoreSleepSwitch(false);
        deviceCapability.configureEvent_alarm(false);
        deviceCapability.configureEvent_alarm_num(0);
        deviceCapability.configureSmart_alarm(false);
        deviceCapability.configureOta_update(false);
        deviceCapability.configureMaintenance(false);
        deviceCapability.configureMaintenance_in_time(false);
        deviceCapability.configureMaintenance_get_data(false);
        deviceCapability.configureSupportAntiLost(false);
        deviceCapability.configureBluetooth_off_alert(false);
        deviceCapability.configureLanguage(false);
        deviceCapability.configureWeather_push(false);
        deviceCapability.configureSupportExerciseAdvice(false);
        deviceCapability.configureSupportExerciseAdviceTime(false);
        deviceCapability.configureSupportExerciseAdviceMonitor(false);
        deviceCapability.configureSupportWorkout(false);
        deviceCapability.configureSupportWorkoutInfo(false);
        deviceCapability.configureSupportWorkoutReminder(false);
        deviceCapability.configureSupportWorkoutRecord(false);
        deviceCapability.configureSupportWorkoutExerciseDisplayLink(false);
        deviceCapability.configureSupportGPSLocation(false);
        deviceCapability.configureSupportGPSData(false);
        deviceCapability.configureSupportHeartRateInfo(false);
        deviceCapability.configureSleep(true);
        deviceCapability.configureClimb(false);
        deviceCapability.configureRiding(false);
        deviceCapability.configureStand(false);
        deviceCapability.configureSleep_shallow(true);
        deviceCapability.configureSleep_deep(true);
        deviceCapability.configureWalk(true);
        deviceCapability.configureRun(false);
        deviceCapability.configureStep(true);
        deviceCapability.configureCalorie(true);
        deviceCapability.configureDistance(true);
        deviceCapability.configureIsSupportHeartRate(false);
        deviceCapability.configurePromptPush(0);
        deviceCapability.configureCall_mute(false);
        deviceCapability.configureIsSupportHelp(false);
        deviceCapability.configureDistanceDetail(false);
        deviceCapability.configureRotate_switch_screen(false);
        deviceCapability.configureSupportQueryAllowDisturbContent(false);
        deviceCapability.configureSupportEphemerisInfoUpdate(false);
    }

    private static void m22048a(int i, boolean z, DeviceCapability deviceCapability) {
        if (deviceCapability != null) {
            C4619w.m22053b(i, z, deviceCapability);
            C4619w.m22057c(i, z, deviceCapability);
        }
    }

    private static void m22053b(int i, boolean z, DeviceCapability deviceCapability) {
        switch (i) {
            case 4:
                C2538c.a("01", 0, "ParseDeviceCapability", new Object[]{"handleV2DMSCapability() setSupportTimeSetting() supportValue = " + z});
                deviceCapability.configureSupportTimeSetting(z);
                return;
            case 7:
                C2538c.a("01", 0, "ParseDeviceCapability", new Object[]{"handleV2DMSCapability() setSupportGetFirmwareVersion() supportValue = " + z});
                deviceCapability.configureSupportGetFirmwareVersion(z);
                return;
            case 8:
                C2538c.a("01", 0, "ParseDeviceCapability", new Object[]{"handleV2DMSCapability() setSupportGetBattery() supportValue = " + z});
                deviceCapability.configureSupportGetBattery(z);
                return;
            case 9:
                C2538c.a("01", 0, "ParseDeviceCapability", new Object[]{"handleV2DMSCapability() setAuto_light_screen() supportValue = " + z});
                deviceCapability.configureAuto_light_screen(z);
                return;
            case 10:
                C2538c.a("01", 0, "ParseDeviceCapability", new Object[]{"handleV2DMSCapability() setAvoid_disturb() supportValue = " + z});
                deviceCapability.configureAvoid_disturb(z);
                return;
            case 26:
                C2538c.a("01", 0, "ParseDeviceCapability", new Object[]{"handleV2DMSCapability() setSupportLeftRightHandWearMode supportValue = " + z});
                deviceCapability.configureSupportLeftRightHandWearMode(z);
                return;
            case 27:
                C2538c.a("01", 0, "ParseDeviceCapability", new Object[]{"handleV2DMSCapability() setRotate_switch_screen() supportValue = " + z});
                deviceCapability.configureRotate_switch_screen(z);
                return;
            case 29:
                C2538c.a("01", 0, "ParseDeviceCapability", new Object[]{"handleV2DMSCapability() setQueryAllowDisturbContent() supportValue = " + z});
                deviceCapability.configureSupportQueryAllowDisturbContent(z);
                return;
            default:
                return;
        }
    }

    private static void m22057c(int i, boolean z, DeviceCapability deviceCapability) {
        switch (i) {
            case 13:
                C2538c.a("01", 0, "ParseDeviceCapability", new Object[]{"handleV2DMSCapability() setFactory_reset() supportValue = " + z});
                deviceCapability.configureFactory_reset(z);
                return;
            case 14:
                C2538c.a("01", 0, "ParseDeviceCapability", new Object[]{"handleV2DMSCapability() setSupportPairDevice() supportValue = " + z});
                deviceCapability.configureSupportPairDevice(z);
                return;
            case 16:
                C2538c.a("01", 0, "ParseDeviceCapability", new Object[]{"handleV2DMSCapability() setSupportGetHandsetInfo() supportValue = " + z});
                deviceCapability.configureSupportGetHandsetInfo(z);
                return;
            case 17:
                C2538c.a("01", 0, "ParseDeviceCapability", new Object[]{"handleV2DMSCapability() setSupportNotificationIntervalInfo() supportValue = " + z});
                deviceCapability.configureSupportNotificationIntervalInfo(z);
                return;
            case 18:
                C2538c.a("01", 0, "ParseDeviceCapability", new Object[]{"handleV2DMSCapability() setSupportActivityType() supportValue = " + z});
                deviceCapability.configureSupportActivityType(z);
                return;
            case 19:
                C2538c.a("01", 0, "ParseDeviceCapability", new Object[]{"handleV2DMSCapability() setSupportAuthenticDevice() supportValue = " + z});
                deviceCapability.configureSupportAuthenticDevice(z);
                return;
            case 20:
                C2538c.a("01", 0, "ParseDeviceCapability", new Object[]{"handleV2DMSCapability() setGold_card() supportValue = " + z});
                deviceCapability.configureGold_card(z);
                return;
            default:
                return;
        }
    }

    private static void m22061d(int i, boolean z, DeviceCapability deviceCapability) {
        if (deviceCapability != null) {
            switch (i) {
                case 1:
                    C2538c.a("01", 0, "ParseDeviceCapability", new Object[]{"handleV2NotificationCapability() setMessage_alert() supportValue = " + z});
                    deviceCapability.configureMessage_alert(z);
                    return;
                case 4:
                    C2538c.a("01", 0, "ParseDeviceCapability", new Object[]{"handleV2NotificationCapability() setSupportMessageAlertInfo() supportValue = " + z});
                    deviceCapability.configureSupportMessageAlertInfo(z);
                    return;
                case 5:
                    C2538c.a("01", 0, "ParseDeviceCapability", new Object[]{"handleV2NotificationCapability() setSupportMessageSupportInfo() supportValue = " + z});
                    deviceCapability.configureSupportMessageSupportInfo(z);
                    return;
                case 6:
                    C2538c.a("01", 0, "ParseDeviceCapability", new Object[]{"handleV2NotificationCapability() setSupportDeleteMsg() supportValue = " + z});
                    deviceCapability.configureSupportDeleteMsg(z);
                    return;
                case 7:
                    C2538c.a("01", 0, "ParseDeviceCapability", new Object[]{"handleV2NotificationCapability() setMessageCenterPushDevice() supportValue = " + z});
                    deviceCapability.configureupportMessageCenterPushDevice(z);
                    return;
                case 8:
                    C2538c.a("01", 0, "ParseDeviceCapability", new Object[]{"handleV2NotificationCapability() setWearMessagePush() supportValue = " + z});
                    deviceCapability.configureSupportWearMessagePush(z);
                    return;
                default:
                    return;
            }
        }
    }

    private static void m22064e(int i, boolean z, DeviceCapability deviceCapability) {
        if (deviceCapability != null) {
            switch (i) {
                case 1:
                    C2538c.a("01", 0, "ParseDeviceCapability", new Object[]{"handleV2AddressBookCapability() setContacts() supportValue = " + z});
                    deviceCapability.configureContacts(z);
                    return;
                default:
                    return;
            }
        }
    }

    private static void m22066f(int i, boolean z, DeviceCapability deviceCapability) {
        if (deviceCapability != null) {
            switch (i) {
                case 1:
                    C2538c.a("01", 0, "ParseDeviceCapability", new Object[]{"handleV2CallingCapability() supportValue = " + z});
                    deviceCapability.configureSupportCallingOperationType(z);
                    return;
                default:
                    return;
            }
        }
    }

    private static void m22068g(int i, boolean z, DeviceCapability deviceCapability) {
        if (deviceCapability != null) {
            switch (i) {
                case 1:
                    C2538c.a("01", 0, "ParseDeviceCapability", new Object[]{"handleV2PingRingCapability() supportValue = " + z});
                    return;
                default:
                    return;
            }
        }
    }

    private static void m22070h(int i, boolean z, DeviceCapability deviceCapability) {
        if (deviceCapability != null) {
            switch (i) {
                case 1:
                    C2538c.a("01", 0, "ParseDeviceCapability", new Object[]{"handleV2MusicCapability() supportValue = " + z});
                    return;
                default:
                    return;
            }
        }
    }

    private static void m22072i(int i, boolean z, DeviceCapability deviceCapability) {
        if (deviceCapability != null) {
            C4619w.m22074j(i, z, deviceCapability);
            C4619w.m22076k(i, z, deviceCapability);
        }
    }

    private static void m22074j(int i, boolean z, DeviceCapability deviceCapability) {
        switch (i) {
            case 1:
                C2538c.a("01", 0, "ParseDeviceCapability", new Object[]{"handleV2FitnessCapability() setMotionGoalCap() supportValue = " + z});
                deviceCapability.configureMotionGoalCap(1);
                return;
            case 3:
                C2538c.a("01", 0, "ParseDeviceCapability", new Object[]{"handleV2FitnessCapability() setSupportSportTotal() supportValue = " + z});
                deviceCapability.configureSupportSportTotal(z);
                return;
            case 5:
                C2538c.a("01", 0, "ParseDeviceCapability", new Object[]{"handleV2FitnessCapability() setFitness_frame_type() supportValue = " + z});
                if (z) {
                    deviceCapability.configureFitness_frame_type(0);
                    return;
                }
                return;
            case 6:
                C2538c.a("01", 0, "ParseDeviceCapability", new Object[]{"handleV2FitnessCapability() setActivity_reminder() supportValue = " + z});
                deviceCapability.configureActivity_reminder(z);
                return;
            case 8:
                C2538c.a("01", 0, "ParseDeviceCapability", new Object[]{"handleV2FitnessCapability() setFitness_frame_type() supportValue = " + z});
                if (z) {
                    deviceCapability.configureFitness_frame_type(1);
                    return;
                }
                return;
            case 9:
                C2538c.a("01", 0, "ParseDeviceCapability", new Object[]{"handleV2FitnessCapability() setSupportSetUserInfoEncrypt() supportValue = " + z});
                deviceCapability.configureSupportSetUserInfoEncrypt(z);
                return;
            default:
                return;
        }
    }

    private static void m22076k(int i, boolean z, DeviceCapability deviceCapability) {
        switch (i) {
            case 10:
                C2538c.a("01", 0, "ParseDeviceCapability", new Object[]{"handleV2FitnessCapability() setSupportSampleFrame() supportValue = " + z});
                deviceCapability.configureSupportSampleFrame(z);
                if (z) {
                    deviceCapability.configureFitness_frame_type(3);
                    return;
                }
                return;
            case 14:
                C2538c.a("01", 0, "ParseDeviceCapability", new Object[]{"handleV2FitnessCapability() setSupportThreshold() supportValue = " + z});
                deviceCapability.configureSupportThreshold(z);
                return;
            case 16:
                C2538c.a("01", 0, "ParseDeviceCapability", new Object[]{"handleV2FitnessCapability() setReserveSync() supportValue = " + z});
                deviceCapability.configureReserveSync(z);
                return;
            case 19:
                C2538c.a("01", 0, "ParseDeviceCapability", new Object[]{"handleV2FitnessCapability() setIsSupportHRZone() supportValue = " + z});
                deviceCapability.configureIsSupportHRZone(z);
                return;
            case 21:
                C2538c.a("01", 0, "ParseDeviceCapability", new Object[]{"handleV2FitnessCapability() setSupportGetUserInfo() supportValue = " + z});
                deviceCapability.configureSupportGetUserInfo(z);
                return;
            case 22:
                C2538c.a("01", 0, "ParseDeviceCapability", new Object[]{"handleV2FitnessCapability() setIsSupportCoreSleep() supportValue = " + z});
                deviceCapability.configureIsSupportCoreSleep(z);
                return;
            case 23:
                C2538c.a("01", 0, "ParseDeviceCapability", new Object[]{"handleV2FitnessCapability() setIsSupportHeartRateEnable() supportValue = " + z});
                deviceCapability.configureisSupportHeartRateEnable(z);
                return;
            case 24:
                C2538c.a("01", 0, "ParseDeviceCapability", new Object[]{"handleV2FitnessCapability() setIsSupportSendCoreSleepOutState() supportValue = " + z});
                deviceCapability.configureIsSupportSendCoreSleepOutState(z);
                return;
            case 27:
                C2538c.a("01", 0, "ParseDeviceCapability", new Object[]{"handleV2FitnessCapability() setIsSupportQueryDeviceCoreSleepSwitch() supportValue = " + z});
                deviceCapability.configureIsSupportQueryDeviceCoreSleepSwitch(z);
                return;
            default:
                return;
        }
    }

    private static void m22078l(int i, boolean z, DeviceCapability deviceCapability) {
        if (deviceCapability != null) {
            switch (i) {
                case 1:
                    C2538c.a("01", 0, "ParseDeviceCapability", new Object[]{"handleV2AlarmCapability() setEvent_alarm() supportValue = " + z});
                    deviceCapability.configureEvent_alarm(z);
                    return;
                case 2:
                    C2538c.a("01", 0, "ParseDeviceCapability", new Object[]{"handleV2AlarmCapability() setSmart_alarm() supportValue = " + z});
                    deviceCapability.configureSmart_alarm(z);
                    return;
                default:
                    return;
            }
        }
    }

    private static void m22079m(int i, boolean z, DeviceCapability deviceCapability) {
        if (deviceCapability != null) {
            switch (i) {
                case 1:
                    C2538c.a("01", 0, "ParseDeviceCapability", new Object[]{"handleV2OTACapability() supportValue = " + z});
                    deviceCapability.configureOta_update(z);
                    return;
                default:
                    return;
            }
        }
    }

    private static void m22080n(int i, boolean z, DeviceCapability deviceCapability) {
        if (deviceCapability != null) {
            switch (i) {
                case 1:
                    C2538c.a("01", 0, "ParseDeviceCapability", new Object[]{"handleV2MaintenanceCapability() setMaintenance() supportValue = " + z});
                    deviceCapability.configureMaintenance(z);
                    return;
                case 9:
                    C2538c.a("01", 0, "ParseDeviceCapability", new Object[]{"handleV2MaintenanceCapability() setMaintenance_in_time() supportValue = " + z});
                    deviceCapability.configureMaintenance_in_time(z);
                    return;
                case 10:
                    C2538c.a("01", 0, "ParseDeviceCapability", new Object[]{"handleV2MaintenanceCapability() setMaintenance_get_data() supportValue = " + z});
                    deviceCapability.configureMaintenance_get_data(z);
                    return;
                default:
                    return;
            }
        }
    }

    private static void m22081o(int i, boolean z, DeviceCapability deviceCapability) {
        if (deviceCapability != null) {
            switch (i) {
                case 1:
                    C2538c.a("01", 0, "ParseDeviceCapability", new Object[]{"handleV2LinkLossCapability() setSupportAntiLost() supportValue = " + z});
                    deviceCapability.configureSupportAntiLost(z);
                    return;
                case 3:
                    C2538c.a("01", 0, "ParseDeviceCapability", new Object[]{"handleV2LinkLossCapability() setBluetooth_off_alert() supportValue = " + z});
                    deviceCapability.configureBluetooth_off_alert(z);
                    return;
                default:
                    return;
            }
        }
    }

    private static void m22082p(int i, boolean z, DeviceCapability deviceCapability) {
        if (deviceCapability != null) {
            switch (i) {
                case 1:
                    C2538c.a("01", 0, "ParseDeviceCapability", new Object[]{"handleV2FontCapability() supportValue = " + z});
                    deviceCapability.configureLanguage(z);
                    return;
                default:
                    return;
            }
        }
    }

    private static void m22083q(int i, boolean z, DeviceCapability deviceCapability) {
        if (deviceCapability != null) {
            switch (i) {
                case 1:
                    C2538c.a("01", 0, "ParseDeviceCapability", new Object[]{"handleV2PhoneBatteryCapability() supportValue = " + z});
                    return;
                default:
                    return;
            }
        }
    }

    private static void m22084r(int i, boolean z, DeviceCapability deviceCapability) {
        if (deviceCapability != null) {
            switch (i) {
                case 1:
                    C2538c.a("01", 0, "ParseDeviceCapability", new Object[]{"handleV2MotionCapability() supportValue = " + z});
                    return;
                default:
                    return;
            }
        }
    }

    private static void m22085s(int i, boolean z, DeviceCapability deviceCapability) {
        if (deviceCapability != null) {
            switch (i) {
                case 1:
                    C2538c.a("01", 0, "ParseDeviceCapability", new Object[]{"handleV2WeatherCapability() supportValue = " + z});
                    deviceCapability.configureWeather_push(z);
                    return;
                default:
                    return;
            }
        }
    }

    private static void m22086t(int i, boolean z, DeviceCapability deviceCapability) {
        if (deviceCapability != null) {
            switch (i) {
                case 1:
                    C2538c.a("01", 0, "ParseDeviceCapability", new Object[]{"handleV2CalendarCapability() supportValue = " + z});
                    return;
                default:
                    return;
            }
        }
    }

    private static void m22087u(int i, boolean z, DeviceCapability deviceCapability) {
        if (deviceCapability != null) {
            switch (i) {
                case 1:
                    C2538c.a("01", 0, "ParseDeviceCapability", new Object[]{"handleV2MusicManagementCapability() supportValue = " + z});
                    return;
                default:
                    return;
            }
        }
    }

    private static void m22088v(int i, boolean z, DeviceCapability deviceCapability) {
        if (deviceCapability != null) {
            switch (i) {
                case 1:
                    C2538c.a("01", 0, "ParseDeviceCapability", new Object[]{"handleV2FileTransferCapability() supportValue = " + z});
                    return;
                default:
                    return;
            }
        }
    }

    private static void m22089w(int i, boolean z, DeviceCapability deviceCapability) {
        if (deviceCapability != null) {
            switch (i) {
                case 1:
                    C2538c.a("01", 0, "ParseDeviceCapability", new Object[]{"handleV2BTFactoryTestCapability() supportValue = " + z});
                    return;
                default:
                    return;
            }
        }
    }

    private static void m22090x(int i, boolean z, DeviceCapability deviceCapability) {
        if (deviceCapability != null) {
            switch (i) {
                case 1:
                    C2538c.a("01", 0, "ParseDeviceCapability", new Object[]{"handleV2MCUFactoryTestCapability() supportValue = " + z});
                    return;
                default:
                    return;
            }
        }
    }

    private static void m22091y(int i, boolean z, DeviceCapability deviceCapability) {
        if (deviceCapability != null) {
            switch (i) {
                case 1:
                    C2538c.a("01", 0, "ParseDeviceCapability", new Object[]{"handleV2SensorCapability() supportValue = " + z});
                    return;
                default:
                    return;
            }
        }
    }

    private static void m22092z(int i, boolean z, DeviceCapability deviceCapability) {
        if (deviceCapability != null) {
            switch (i) {
                case 1:
                    C2538c.a("01", 0, "ParseDeviceCapability", new Object[]{"handleV2ExerciseAdviceCapability() setSupportExerciseAdvice() supportValue = " + z});
                    deviceCapability.configureSupportExerciseAdvice(z);
                    return;
                case 3:
                    C2538c.a("01", 0, "ParseDeviceCapability", new Object[]{"handleV2ExerciseAdviceCapability() setSupportExerciseAdviceTime() supportValue = " + z});
                    deviceCapability.configureSupportExerciseAdviceTime(z);
                    return;
                case 7:
                    C2538c.a("01", 0, "ParseDeviceCapability", new Object[]{"handleV2ExerciseAdviceCapability() setSupportExerciseAdviceMonitor() supportValue = " + z});
                    deviceCapability.configureSupportExerciseAdviceMonitor(z);
                    return;
                default:
                    return;
            }
        }
    }

    private static void m22036A(int i, boolean z, DeviceCapability deviceCapability) {
        if (deviceCapability != null) {
            switch (i) {
                case 1:
                    C2538c.a("01", 0, "ParseDeviceCapability", new Object[]{"handleV2WorkoutCapability() setSupportWorkout() supportValue = " + z});
                    deviceCapability.configureSupportWorkout(z);
                    return;
                case 4:
                    C2538c.a("01", 0, "ParseDeviceCapability", new Object[]{"handleV2WorkoutCapability() setSupportWorkoutInfo() supportValue = " + z});
                    deviceCapability.configureSupportWorkoutInfo(z);
                    return;
                case 6:
                    C2538c.a("01", 0, "ParseDeviceCapability", new Object[]{"handleV2WorkoutCapability() setSupportWorkoutReminder() supportValue = " + z});
                    deviceCapability.configureSupportWorkoutReminder(z);
                    return;
                case 7:
                    C2538c.a("01", 0, "ParseDeviceCapability", new Object[]{"handleV2WorkoutCapability() setSupportWorkoutRecord() supportValue = " + z});
                    deviceCapability.configureSupportWorkoutRecord(z);
                    return;
                case 11:
                    C2538c.a("01", 0, "ParseDeviceCapability", new Object[]{"handleV2WorkoutCapability() setSupportWorkoutExerciseDisplayLink() supportValue = " + z});
                    deviceCapability.configureSupportWorkoutExerciseDisplayLink(z);
                    return;
                case 12:
                    C2538c.a("01", 0, "ParseDeviceCapability", new Object[]{"handleV2WorkoutCapability() setSupportWorkoutRecordPaceMap() supportvalue = " + z});
                    deviceCapability.configureSupportWorkoutRecordPaceMap(z);
                    return;
                default:
                    return;
            }
        }
    }

    private static void m22037B(int i, boolean z, DeviceCapability deviceCapability) {
        if (deviceCapability != null) {
            switch (i) {
                case 1:
                    C2538c.a("01", 0, "ParseDeviceCapability", new Object[]{"handleV2GPSLocationCapability() setSupportGPSLocation() supportValue = " + z});
                    deviceCapability.configureSupportGPSLocation(z);
                    return;
                case 2:
                    C2538c.a("01", 0, "ParseDeviceCapability", new Object[]{"handleV2GPSLocationCapability() setSupportGPSData() supportValue = " + z});
                    deviceCapability.configureSupportGPSData(z);
                    return;
                case 4:
                    C2538c.a("01", 0, "ParseDeviceCapability", new Object[]{"handleV2GPSLocationCapability() setSupportGPSSetParameter() supportValue = " + z});
                    deviceCapability.configureSupportGPSSetParameter(z);
                    return;
                default:
                    return;
            }
        }
    }

    private static void m22038C(int i, boolean z, DeviceCapability deviceCapability) {
        if (deviceCapability != null) {
            switch (i) {
                case 1:
                    C2538c.a("01", 0, "ParseDeviceCapability", new Object[]{"handleV2HeartRateCapability() COMMAND_ID_MULTSIM_OPEN_ESIM = " + z});
                    deviceCapability.configureSupportEsim(z);
                    return;
                case 6:
                    C2538c.a("01", 0, "ParseDeviceCapability", new Object[]{"handleV2HeartRateCapability() COMMAND_ID_MULTSIM_QUIRE_SIM_INFO = " + z});
                    deviceCapability.configureSupportMultiSim(z);
                    return;
                default:
                    return;
            }
        }
    }

    private static void m22039D(int i, boolean z, DeviceCapability deviceCapability) {
        C2538c.a("01", 0, "ParseDeviceCapability", new Object[]{"handleV2EphemerisCapability() eph CommandID = " + i + "   supportValue = " + z});
        if (deviceCapability != null) {
            deviceCapability.configureSupportEphemerisInfoUpdate(true);
        }
    }

    private static void m22040E(int i, boolean z, DeviceCapability deviceCapability) {
        if (deviceCapability != null) {
            switch (i) {
                case 1:
                    C2538c.a("01", 0, "ParseDeviceCapability", new Object[]{"handleV2MidwareCapability() COMMAND_ID_MID_WARE = " + z});
                    deviceCapability.configureSupportMidware(z);
                    return;
                default:
                    return;
            }
        }
    }

    private static void m22041F(int i, boolean z, DeviceCapability deviceCapability) {
        if (deviceCapability != null) {
            switch (i) {
                case 1:
                    C2538c.a("01", 0, "ParseDeviceCapability", new Object[]{"handleV2HeartRateCapability() supportValue = " + z});
                    deviceCapability.configureSupportHeartRateInfo(z);
                    return;
                case 4:
                    C2538c.a("01", 0, "ParseDeviceCapability", new Object[]{"handleV2HeartRateCapability() stress supportValue = " + z});
                    deviceCapability.configureSupportStressInfo(z);
                    return;
                default:
                    return;
            }
        }
    }

    private static void m22042G(int i, boolean z, DeviceCapability deviceCapability) {
        if (deviceCapability != null) {
            switch (i) {
                case 1:
                    C2538c.a("01", 0, "ParseDeviceCapability", new Object[]{"handleV2WalletCapability() supportValue = " + z});
                    deviceCapability.configureSupportPay(z);
                    return;
                default:
                    return;
            }
        }
    }

    private static void m22043H(int i, boolean z, DeviceCapability deviceCapability) {
        if (deviceCapability != null) {
            switch (i) {
                case 1:
                    C2538c.a("01", 0, "ParseDeviceCapability", new Object[]{"handleV2StressCapability() supportValue = " + z});
                    deviceCapability.configureSupportStress(z);
                    return;
                default:
                    return;
            }
        }
    }

    public static void m22046a(int i, int i2, boolean z, DeviceCapability deviceCapability) {
        if (deviceCapability != null) {
            C4619w.m22051b(i, i2, z, deviceCapability);
            C4619w.m22055c(i, i2, z, deviceCapability);
            C4619w.m22059d(i, i2, z, deviceCapability);
            C4619w.m22063e(i, i2, z, deviceCapability);
        }
    }

    private static void m22044I(int i, boolean z, DeviceCapability deviceCapability) {
        if (deviceCapability != null) {
            switch (i) {
                case 1:
                    C2538c.a("01", 0, "ParseDeviceCapability", new Object[]{"handleV2AccountCapability() COMMAND_ID_MID_WARE = " + z});
                    deviceCapability.configureSupportAccount(z);
                    return;
                default:
                    return;
            }
        }
    }

    private static void m22045J(int i, boolean z, DeviceCapability deviceCapability) {
        if (deviceCapability != null) {
            switch (i) {
                case 1:
                    C2538c.a("01", 0, "ParseDeviceCapability", new Object[]{"handleV2AccountCapability() COMMAND_ID_MID_WARE = " + z});
                    deviceCapability.configureSupportOneLevelMenu(z);
                    return;
                default:
                    return;
            }
        }
    }

    private static void m22051b(int i, int i2, boolean z, DeviceCapability deviceCapability) {
        switch (i) {
            case 1:
                C4619w.m22048a(i2, z, deviceCapability);
                return;
            case 2:
                C4619w.m22061d(i2, z, deviceCapability);
                return;
            case 3:
                C4619w.m22064e(i2, z, deviceCapability);
                return;
            case 4:
                C4619w.m22066f(i2, z, deviceCapability);
                return;
            case 5:
                C4619w.m22068g(i2, z, deviceCapability);
                return;
            case 6:
                C4619w.m22070h(i2, z, deviceCapability);
                return;
            case 7:
                C4619w.m22072i(i2, z, deviceCapability);
                return;
            default:
                return;
        }
    }

    private static void m22055c(int i, int i2, boolean z, DeviceCapability deviceCapability) {
        switch (i) {
            case 8:
                C4619w.m22078l(i2, z, deviceCapability);
                return;
            case 9:
                C4619w.m22079m(i2, z, deviceCapability);
                return;
            case 10:
                C4619w.m22080n(i2, z, deviceCapability);
                return;
            case 11:
                C4619w.m22081o(i2, z, deviceCapability);
                return;
            case 12:
                C4619w.m22082p(i2, z, deviceCapability);
                return;
            case 13:
                C4619w.m22083q(i2, z, deviceCapability);
                return;
            case 14:
                C4619w.m22084r(i2, z, deviceCapability);
                return;
            default:
                return;
        }
    }

    private static void m22059d(int i, int i2, boolean z, DeviceCapability deviceCapability) {
        switch (i) {
            case 15:
                C4619w.m22085s(i2, z, deviceCapability);
                return;
            case 16:
                C4619w.m22086t(i2, z, deviceCapability);
                return;
            case 17:
                C4619w.m22087u(i2, z, deviceCapability);
                return;
            case 18:
                C4619w.m22088v(i2, z, deviceCapability);
                return;
            case 19:
                C4619w.m22089w(i2, z, deviceCapability);
                return;
            case 20:
                C4619w.m22090x(i2, z, deviceCapability);
                return;
            case 21:
                C4619w.m22091y(i2, z, deviceCapability);
                return;
            default:
                return;
        }
    }

    private static void m22063e(int i, int i2, boolean z, DeviceCapability deviceCapability) {
        switch (i) {
            case 22:
                C4619w.m22092z(i2, z, deviceCapability);
                return;
            case 23:
                C4619w.m22036A(i2, z, deviceCapability);
                return;
            case 24:
                C4619w.m22037B(i2, z, deviceCapability);
                return;
            case 25:
                C4619w.m22041F(i2, z, deviceCapability);
                return;
            case 26:
                C4619w.m22044I(i2, z, deviceCapability);
                return;
            case 27:
                C4619w.m22042G(i2, z, deviceCapability);
                return;
            case 29:
                C4619w.m22038C(i2, z, deviceCapability);
                return;
            case 31:
                C4619w.m22039D(i2, z, deviceCapability);
                return;
            case 32:
                C4619w.m22043H(i2, z, deviceCapability);
                return;
            case 33:
                C4619w.m22040E(i2, z, deviceCapability);
                return;
            case 34:
                C4619w.m22045J(i2, z, deviceCapability);
                return;
            default:
                return;
        }
    }

    public static void m22047a(int i, DeviceCapability deviceCapability) {
        switch (i) {
            case 3:
            case 10:
                C4619w.m22065e(deviceCapability);
                return;
            case 7:
            case 14:
                C4619w.m22067f(deviceCapability);
                return;
            case 8:
                C4619w.m22069g(deviceCapability);
                return;
            case 11:
                C4619w.m22077k(deviceCapability);
                return;
            case 12:
                C4619w.m22075j(deviceCapability);
                return;
            case 13:
                C4619w.m22071h(deviceCapability);
                return;
            case 15:
                C4619w.m22073i(deviceCapability);
                return;
            default:
                return;
        }
    }

    public static void m22052b(int i, DeviceCapability deviceCapability) {
        switch (i) {
            case 4:
                deviceCapability.configureWalk(true);
                return;
            case 7:
                deviceCapability.configureRun(true);
                return;
            case 8:
                deviceCapability.configureClimb(true);
                return;
            case 9:
                deviceCapability.configureRiding(true);
                return;
            case 10:
                deviceCapability.configureSleep(true);
                deviceCapability.configureSleep_shallow(true);
                deviceCapability.configureSleep_deep(true);
                return;
            default:
                return;
        }
    }

    public static void m22056c(int i, DeviceCapability deviceCapability) {
        if (1 == ((i >> 5) & 1)) {
            deviceCapability.configureIsSupportHeartRate(true);
        } else {
            deviceCapability.configureIsSupportHeartRate(false);
        }
    }

    public static void m22060d(int i, DeviceCapability deviceCapability) {
        deviceCapability.configurePromptPush(i);
    }

    private static void m22067f(DeviceCapability deviceCapability) {
        deviceCapability.configureSupportTimeSetting(true);
        deviceCapability.configureSupportGetFirmwareVersion(true);
        deviceCapability.configureSupportGetBattery(true);
        deviceCapability.configureAuto_light_screen(true);
        deviceCapability.configureAvoid_disturb(true);
        deviceCapability.configureFactory_reset(true);
        deviceCapability.configureSupportPairDevice(false);
        deviceCapability.configureSupportGetHandsetInfo(false);
        deviceCapability.configureSupportNotificationIntervalInfo(true);
        deviceCapability.configureSupportActivityType(false);
        deviceCapability.configureSupportAuthenticDevice(true);
        deviceCapability.configureGold_card(false);
        deviceCapability.configureSupportLeftRightHandWearMode(false);
        deviceCapability.configureMessage_alert(true);
        deviceCapability.configureSupportMessageAlertInfo(true);
        deviceCapability.configureSupportMessageSupportInfo(false);
        deviceCapability.configureupportMessageCenterPushDevice(false);
        deviceCapability.configureContacts(true);
        deviceCapability.configureSupportCallingOperationType(false);
        deviceCapability.configureMotionGoalCap(1);
        deviceCapability.configureFitness_frame_type(0);
        deviceCapability.configureActivity_reminder(true);
        deviceCapability.configureSupportSetUserInfoEncrypt(false);
        deviceCapability.configureSupportSampleFrame(false);
        deviceCapability.configureSupportThreshold(false);
        deviceCapability.configureReserveSync(false);
        deviceCapability.configureIsSupportHRZone(false);
        deviceCapability.configureIsSupportSendCoreSleepOutState(false);
        deviceCapability.configureIsSupportQueryDeviceCoreSleepSwitch(false);
        deviceCapability.configureEvent_alarm(true);
        deviceCapability.configureEvent_alarm_num(5);
        deviceCapability.configureSmart_alarm(true);
        deviceCapability.configureOta_update(true);
        deviceCapability.configureMaintenance(true);
        deviceCapability.configureMaintenance_in_time(true);
        deviceCapability.configureMaintenance_get_data(true);
        deviceCapability.configureSupportAntiLost(true);
        deviceCapability.configureBluetooth_off_alert(false);
        deviceCapability.configureLanguage(true);
        deviceCapability.configureWeather_push(false);
        deviceCapability.configureSupportExerciseAdvice(false);
        deviceCapability.configureSupportExerciseAdviceTime(false);
        deviceCapability.configureSupportExerciseAdviceMonitor(false);
        deviceCapability.configureSupportWorkout(false);
        deviceCapability.configureSupportWorkoutInfo(false);
        deviceCapability.configureSupportWorkoutReminder(false);
        deviceCapability.configureSupportWorkoutRecord(false);
        deviceCapability.configureSupportWorkoutExerciseDisplayLink(false);
        deviceCapability.configureSupportWorkoutRecordPaceMap(false);
        deviceCapability.configureSupportGPSLocation(false);
        deviceCapability.configureSupportGPSData(false);
        deviceCapability.configureSupportHeartRateInfo(false);
        deviceCapability.configureSleep(true);
        deviceCapability.configureClimb(true);
        deviceCapability.configureRiding(true);
        deviceCapability.configureStand(false);
        deviceCapability.configureSleep_shallow(true);
        deviceCapability.configureSleep_deep(true);
        deviceCapability.configureWalk(true);
        deviceCapability.configureRun(true);
        deviceCapability.configureStep(true);
        deviceCapability.configureCalorie(true);
        deviceCapability.configureDistance(true);
        deviceCapability.configureIsSupportHeartRate(false);
        deviceCapability.configurePromptPush(-1);
        deviceCapability.configureCall_mute(false);
        deviceCapability.configureIsSupportHelp(true);
        deviceCapability.configureDistanceDetail(true);
        deviceCapability.configureRotate_switch_screen(false);
        deviceCapability.configureSupportQueryAllowDisturbContent(false);
        deviceCapability.configureSupportEphemerisInfoUpdate(false);
    }

    private static void m22069g(DeviceCapability deviceCapability) {
        deviceCapability.configureSupportTimeSetting(true);
        deviceCapability.configureSupportGetFirmwareVersion(true);
        deviceCapability.configureSupportGetBattery(true);
        deviceCapability.configureAuto_light_screen(true);
        deviceCapability.configureAvoid_disturb(true);
        deviceCapability.configureFactory_reset(true);
        deviceCapability.configureSupportPairDevice(false);
        deviceCapability.configureSupportGetHandsetInfo(false);
        deviceCapability.configureSupportNotificationIntervalInfo(true);
        deviceCapability.configureSupportActivityType(true);
        deviceCapability.configureSupportAuthenticDevice(true);
        deviceCapability.configureGold_card(false);
        deviceCapability.configureSupportLeftRightHandWearMode(false);
        deviceCapability.configureMessage_alert(true);
        deviceCapability.configureSupportMessageAlertInfo(true);
        deviceCapability.configureSupportMessageSupportInfo(true);
        deviceCapability.configureupportMessageCenterPushDevice(false);
        deviceCapability.configureContacts(false);
        deviceCapability.configureSupportCallingOperationType(false);
        deviceCapability.configureMotionGoalCap(1);
        deviceCapability.configureFitness_frame_type(3);
        deviceCapability.configureActivity_reminder(true);
        deviceCapability.configureSupportSetUserInfoEncrypt(true);
        deviceCapability.configureSupportSampleFrame(true);
        deviceCapability.configureSupportThreshold(true);
        deviceCapability.configureReserveSync(true);
        deviceCapability.configureIsSupportHRZone(true);
        deviceCapability.configureIsSupportSendCoreSleepOutState(false);
        deviceCapability.configureIsSupportQueryDeviceCoreSleepSwitch(false);
        deviceCapability.configureEvent_alarm(true);
        deviceCapability.configureEvent_alarm_num(5);
        deviceCapability.configureSmart_alarm(true);
        deviceCapability.configureOta_update(true);
        deviceCapability.configureMaintenance(true);
        deviceCapability.configureMaintenance_in_time(true);
        deviceCapability.configureMaintenance_get_data(true);
        deviceCapability.configureSupportAntiLost(false);
        deviceCapability.configureBluetooth_off_alert(true);
        deviceCapability.configureLanguage(true);
        deviceCapability.configureWeather_push(false);
        deviceCapability.configureSupportExerciseAdvice(false);
        deviceCapability.configureSupportExerciseAdviceTime(false);
        deviceCapability.configureSupportExerciseAdviceMonitor(false);
        deviceCapability.configureSupportWorkout(false);
        deviceCapability.configureSupportWorkoutInfo(false);
        deviceCapability.configureSupportWorkoutReminder(false);
        deviceCapability.configureSupportWorkoutRecord(false);
        deviceCapability.configureSupportWorkoutExerciseDisplayLink(false);
        deviceCapability.configureSupportWorkoutRecordPaceMap(false);
        deviceCapability.configureSupportGPSLocation(false);
        deviceCapability.configureSupportGPSData(false);
        deviceCapability.configureSupportHeartRateInfo(true);
        deviceCapability.configureSleep(true);
        deviceCapability.configureClimb(false);
        deviceCapability.configureRiding(true);
        deviceCapability.configureStand(false);
        deviceCapability.configureSleep_shallow(true);
        deviceCapability.configureSleep_deep(true);
        deviceCapability.configureWalk(true);
        deviceCapability.configureRun(true);
        deviceCapability.configureStep(true);
        deviceCapability.configureCalorie(true);
        deviceCapability.configureDistance(true);
        deviceCapability.configureIsSupportHeartRate(true);
        deviceCapability.configurePromptPush(-1);
        deviceCapability.configureCall_mute(false);
        deviceCapability.configureIsSupportHelp(true);
        deviceCapability.configureDistanceDetail(true);
        deviceCapability.configureRotate_switch_screen(false);
        deviceCapability.configureSupportQueryAllowDisturbContent(false);
        deviceCapability.configureSupportEphemerisInfoUpdate(false);
    }

    private static void m22071h(DeviceCapability deviceCapability) {
        deviceCapability.configureSupportTimeSetting(true);
        deviceCapability.configureSupportGetFirmwareVersion(true);
        deviceCapability.configureSupportGetBattery(true);
        deviceCapability.configureAuto_light_screen(true);
        deviceCapability.configureAvoid_disturb(true);
        deviceCapability.configureFactory_reset(true);
        deviceCapability.configureSupportPairDevice(false);
        deviceCapability.configureSupportGetHandsetInfo(false);
        deviceCapability.configureSupportNotificationIntervalInfo(true);
        deviceCapability.configureSupportActivityType(true);
        deviceCapability.configureSupportAuthenticDevice(true);
        deviceCapability.configureGold_card(false);
        deviceCapability.configureSupportLeftRightHandWearMode(true);
        deviceCapability.configureMessage_alert(true);
        deviceCapability.configureSupportMessageAlertInfo(true);
        deviceCapability.configureSupportMessageSupportInfo(true);
        deviceCapability.configureupportMessageCenterPushDevice(false);
        deviceCapability.configureContacts(false);
        deviceCapability.configureSupportCallingOperationType(false);
        deviceCapability.configureMotionGoalCap(1);
        deviceCapability.configureFitness_frame_type(3);
        deviceCapability.configureActivity_reminder(true);
        deviceCapability.configureSupportSetUserInfoEncrypt(true);
        deviceCapability.configureSupportSampleFrame(true);
        deviceCapability.configureSupportThreshold(true);
        deviceCapability.configureReserveSync(true);
        deviceCapability.configureIsSupportHRZone(true);
        deviceCapability.configureisSupportHeartRateEnable(true);
        deviceCapability.configureIsSupportSendCoreSleepOutState(false);
        deviceCapability.configureIsSupportQueryDeviceCoreSleepSwitch(false);
        deviceCapability.configureEvent_alarm(true);
        deviceCapability.configureEvent_alarm_num(5);
        deviceCapability.configureSmart_alarm(true);
        deviceCapability.configureOta_update(true);
        deviceCapability.configureMaintenance(true);
        deviceCapability.configureMaintenance_in_time(true);
        deviceCapability.configureMaintenance_get_data(true);
        deviceCapability.configureSupportAntiLost(false);
        deviceCapability.configureBluetooth_off_alert(true);
        deviceCapability.configureLanguage(true);
        deviceCapability.configureWeather_push(false);
        deviceCapability.configureSupportExerciseAdvice(false);
        deviceCapability.configureSupportExerciseAdviceTime(false);
        deviceCapability.configureSupportExerciseAdviceMonitor(false);
        deviceCapability.configureSupportWorkout(false);
        deviceCapability.configureSupportWorkoutInfo(false);
        deviceCapability.configureSupportWorkoutReminder(false);
        deviceCapability.configureSupportWorkoutRecord(false);
        deviceCapability.configureSupportWorkoutExerciseDisplayLink(false);
        deviceCapability.configureSupportWorkoutRecordPaceMap(false);
        deviceCapability.configureSupportGPSLocation(false);
        deviceCapability.configureSupportGPSData(false);
        deviceCapability.configureSupportHeartRateInfo(true);
        deviceCapability.configureSleep(true);
        deviceCapability.configureClimb(false);
        deviceCapability.configureRiding(true);
        deviceCapability.configureStand(false);
        deviceCapability.configureSleep_shallow(true);
        deviceCapability.configureSleep_deep(true);
        deviceCapability.configureWalk(true);
        deviceCapability.configureRun(true);
        deviceCapability.configureStep(true);
        deviceCapability.configureCalorie(true);
        deviceCapability.configureDistance(true);
        deviceCapability.configureIsSupportHeartRate(true);
        deviceCapability.configurePromptPush(-1);
        deviceCapability.configureCall_mute(false);
        deviceCapability.configureIsSupportHelp(true);
        deviceCapability.configureDistanceDetail(true);
        deviceCapability.configureRotate_switch_screen(true);
        deviceCapability.configureSupportQueryAllowDisturbContent(false);
        deviceCapability.configureSupportEphemerisInfoUpdate(false);
    }

    private static void m22073i(DeviceCapability deviceCapability) {
        deviceCapability.configureSupportTimeSetting(true);
        deviceCapability.configureSupportGetFirmwareVersion(true);
        deviceCapability.configureSupportGetBattery(true);
        deviceCapability.configureAuto_light_screen(true);
        deviceCapability.configureAvoid_disturb(true);
        deviceCapability.configureFactory_reset(true);
        deviceCapability.configureSupportPairDevice(false);
        deviceCapability.configureSupportGetHandsetInfo(false);
        deviceCapability.configureSupportNotificationIntervalInfo(true);
        deviceCapability.configureSupportActivityType(true);
        deviceCapability.configureSupportAuthenticDevice(true);
        deviceCapability.configureGold_card(false);
        deviceCapability.configureSupportLeftRightHandWearMode(true);
        deviceCapability.configureMessage_alert(true);
        deviceCapability.configureSupportMessageAlertInfo(true);
        deviceCapability.configureSupportMessageSupportInfo(true);
        deviceCapability.configureupportMessageCenterPushDevice(false);
        deviceCapability.configureContacts(false);
        deviceCapability.configureSupportCallingOperationType(false);
        deviceCapability.configureMotionGoalCap(1);
        deviceCapability.configureFitness_frame_type(3);
        deviceCapability.configureActivity_reminder(true);
        deviceCapability.configureSupportSetUserInfoEncrypt(true);
        deviceCapability.configureSupportSampleFrame(true);
        deviceCapability.configureSupportThreshold(true);
        deviceCapability.configureReserveSync(true);
        deviceCapability.configureIsSupportHRZone(true);
        deviceCapability.configureisSupportHeartRateEnable(true);
        deviceCapability.configureIsSupportSendCoreSleepOutState(false);
        deviceCapability.configureIsSupportQueryDeviceCoreSleepSwitch(false);
        deviceCapability.configureEvent_alarm(true);
        deviceCapability.configureEvent_alarm_num(5);
        deviceCapability.configureSmart_alarm(true);
        deviceCapability.configureOta_update(true);
        deviceCapability.configureMaintenance(true);
        deviceCapability.configureMaintenance_in_time(true);
        deviceCapability.configureMaintenance_get_data(true);
        deviceCapability.configureSupportAntiLost(false);
        deviceCapability.configureBluetooth_off_alert(true);
        deviceCapability.configureLanguage(true);
        deviceCapability.configureWeather_push(false);
        deviceCapability.configureSupportExerciseAdvice(false);
        deviceCapability.configureSupportExerciseAdviceTime(false);
        deviceCapability.configureSupportExerciseAdviceMonitor(false);
        deviceCapability.configureSupportWorkout(false);
        deviceCapability.configureSupportWorkoutInfo(false);
        deviceCapability.configureSupportWorkoutReminder(false);
        deviceCapability.configureSupportWorkoutRecord(false);
        deviceCapability.configureSupportWorkoutExerciseDisplayLink(false);
        deviceCapability.configureSupportWorkoutRecordPaceMap(false);
        deviceCapability.configureSupportGPSLocation(false);
        deviceCapability.configureSupportGPSData(false);
        deviceCapability.configureSupportHeartRateInfo(true);
        deviceCapability.configureSleep(true);
        deviceCapability.configureClimb(false);
        deviceCapability.configureRiding(true);
        deviceCapability.configureStand(false);
        deviceCapability.configureSleep_shallow(true);
        deviceCapability.configureSleep_deep(true);
        deviceCapability.configureWalk(true);
        deviceCapability.configureRun(true);
        deviceCapability.configureStep(true);
        deviceCapability.configureCalorie(true);
        deviceCapability.configureDistance(true);
        deviceCapability.configureIsSupportHeartRate(true);
        deviceCapability.configurePromptPush(-1);
        deviceCapability.configureCall_mute(false);
        deviceCapability.configureIsSupportHelp(true);
        deviceCapability.configureDistanceDetail(true);
        deviceCapability.configureRotate_switch_screen(true);
        deviceCapability.configureSupportQueryAllowDisturbContent(false);
        deviceCapability.configureSupportEphemerisInfoUpdate(false);
    }

    private static void m22075j(DeviceCapability deviceCapability) {
        deviceCapability.configureSupportTimeSetting(true);
        deviceCapability.configureSupportGetFirmwareVersion(true);
        deviceCapability.configureSupportGetBattery(true);
        deviceCapability.configureAuto_light_screen(true);
        deviceCapability.configureAvoid_disturb(true);
        deviceCapability.configureFactory_reset(true);
        deviceCapability.configureSupportPairDevice(false);
        deviceCapability.configureSupportGetHandsetInfo(false);
        deviceCapability.configureSupportNotificationIntervalInfo(true);
        deviceCapability.configureSupportActivityType(true);
        deviceCapability.configureSupportAuthenticDevice(true);
        deviceCapability.configureGold_card(false);
        deviceCapability.configureSupportLeftRightHandWearMode(false);
        deviceCapability.configureMessage_alert(true);
        deviceCapability.configureSupportMessageAlertInfo(true);
        deviceCapability.configureSupportMessageSupportInfo(true);
        deviceCapability.configureupportMessageCenterPushDevice(false);
        deviceCapability.configureContacts(false);
        deviceCapability.configureSupportCallingOperationType(false);
        deviceCapability.configureMotionGoalCap(1);
        deviceCapability.configureFitness_frame_type(3);
        deviceCapability.configureActivity_reminder(true);
        deviceCapability.configureSupportSetUserInfoEncrypt(true);
        deviceCapability.configureSupportSampleFrame(true);
        deviceCapability.configureSupportThreshold(true);
        deviceCapability.configureReserveSync(true);
        deviceCapability.configureIsSupportHRZone(true);
        deviceCapability.configureIsSupportSendCoreSleepOutState(false);
        deviceCapability.configureIsSupportQueryDeviceCoreSleepSwitch(false);
        deviceCapability.configureEvent_alarm(true);
        deviceCapability.configureEvent_alarm_num(5);
        deviceCapability.configureSmart_alarm(true);
        deviceCapability.configureOta_update(true);
        deviceCapability.configureMaintenance(true);
        deviceCapability.configureMaintenance_in_time(true);
        deviceCapability.configureMaintenance_get_data(true);
        deviceCapability.configureSupportAntiLost(false);
        deviceCapability.configureBluetooth_off_alert(true);
        deviceCapability.configureLanguage(true);
        deviceCapability.configureWeather_push(false);
        deviceCapability.configureSupportExerciseAdvice(false);
        deviceCapability.configureSupportExerciseAdviceTime(false);
        deviceCapability.configureSupportExerciseAdviceMonitor(false);
        deviceCapability.configureSupportWorkout(false);
        deviceCapability.configureSupportWorkoutInfo(false);
        deviceCapability.configureSupportWorkoutReminder(false);
        deviceCapability.configureSupportWorkoutRecord(false);
        deviceCapability.configureSupportWorkoutExerciseDisplayLink(false);
        deviceCapability.configureSupportWorkoutRecordPaceMap(false);
        deviceCapability.configureSupportGPSLocation(false);
        deviceCapability.configureSupportGPSData(false);
        deviceCapability.configureSupportHeartRateInfo(true);
        deviceCapability.configureSleep(true);
        deviceCapability.configureClimb(false);
        deviceCapability.configureRiding(true);
        deviceCapability.configureStand(false);
        deviceCapability.configureSleep_shallow(true);
        deviceCapability.configureSleep_deep(true);
        deviceCapability.configureWalk(true);
        deviceCapability.configureRun(true);
        deviceCapability.configureStep(true);
        deviceCapability.configureCalorie(true);
        deviceCapability.configureDistance(true);
        deviceCapability.configureIsSupportHeartRate(true);
        deviceCapability.configurePromptPush(-1);
        deviceCapability.configureCall_mute(false);
        deviceCapability.configureIsSupportHelp(true);
        deviceCapability.configureDistanceDetail(true);
        deviceCapability.configureRotate_switch_screen(false);
        deviceCapability.configureSupportQueryAllowDisturbContent(false);
        deviceCapability.configureSupportEphemerisInfoUpdate(false);
    }

    private static void m22077k(DeviceCapability deviceCapability) {
        deviceCapability.configureSupportTimeSetting(false);
        deviceCapability.configureSupportGetFirmwareVersion(true);
        deviceCapability.configureSupportGetBattery(false);
        deviceCapability.configureAuto_light_screen(false);
        deviceCapability.configureAvoid_disturb(true);
        deviceCapability.configureFactory_reset(true);
        deviceCapability.configureSupportPairDevice(false);
        deviceCapability.configureSupportGetHandsetInfo(false);
        deviceCapability.configureSupportNotificationIntervalInfo(true);
        deviceCapability.configureSupportActivityType(true);
        deviceCapability.configureSupportAuthenticDevice(true);
        deviceCapability.configureGold_card(false);
        deviceCapability.configureSupportLeftRightHandWearMode(false);
        deviceCapability.configureMessage_alert(false);
        deviceCapability.configureSupportMessageAlertInfo(false);
        deviceCapability.configureSupportMessageSupportInfo(false);
        deviceCapability.configureupportMessageCenterPushDevice(false);
        deviceCapability.configureContacts(false);
        deviceCapability.configureSupportCallingOperationType(false);
        deviceCapability.configureMotionGoalCap(1);
        deviceCapability.configureFitness_frame_type(3);
        deviceCapability.configureActivity_reminder(false);
        deviceCapability.configureSupportSetUserInfoEncrypt(false);
        deviceCapability.configureSupportSampleFrame(false);
        deviceCapability.configureSupportThreshold(false);
        deviceCapability.configureReserveSync(true);
        deviceCapability.configureIsSupportHRZone(true);
        deviceCapability.configureIsSupportSendCoreSleepOutState(false);
        deviceCapability.configureIsSupportQueryDeviceCoreSleepSwitch(false);
        deviceCapability.configureEvent_alarm(false);
        deviceCapability.configureEvent_alarm_num(5);
        deviceCapability.configureSmart_alarm(false);
        deviceCapability.configureOta_update(false);
        deviceCapability.configureMaintenance(false);
        deviceCapability.configureMaintenance_in_time(false);
        deviceCapability.configureMaintenance_get_data(false);
        deviceCapability.configureSupportAntiLost(false);
        deviceCapability.configureBluetooth_off_alert(false);
        deviceCapability.configureLanguage(true);
        deviceCapability.configureWeather_push(false);
        deviceCapability.configureSupportExerciseAdvice(false);
        deviceCapability.configureSupportExerciseAdviceTime(false);
        deviceCapability.configureSupportExerciseAdviceMonitor(false);
        deviceCapability.configureSupportWorkout(false);
        deviceCapability.configureSupportWorkoutInfo(false);
        deviceCapability.configureSupportWorkoutReminder(false);
        deviceCapability.configureSupportWorkoutRecord(false);
        deviceCapability.configureSupportWorkoutExerciseDisplayLink(false);
        deviceCapability.configureSupportWorkoutRecordPaceMap(false);
        deviceCapability.configureSupportGPSLocation(false);
        deviceCapability.configureSupportGPSData(false);
        deviceCapability.configureSupportHeartRateInfo(true);
        deviceCapability.configureSupportStressInfo(false);
        deviceCapability.configureSleep(false);
        deviceCapability.configureClimb(false);
        deviceCapability.configureRiding(false);
        deviceCapability.configureStand(false);
        deviceCapability.configureSleep_shallow(false);
        deviceCapability.configureSleep_deep(false);
        deviceCapability.configureWalk(true);
        deviceCapability.configureRun(true);
        deviceCapability.configureStep(true);
        deviceCapability.configureCalorie(true);
        deviceCapability.configureDistance(true);
        deviceCapability.configureIsSupportHeartRate(true);
        deviceCapability.configurePromptPush(-1);
        deviceCapability.configureCall_mute(false);
        deviceCapability.configureIsSupportHelp(true);
        deviceCapability.configureDistanceDetail(true);
        deviceCapability.configureRotate_switch_screen(false);
        deviceCapability.configureSupportQueryAllowDisturbContent(false);
        deviceCapability.configureSupportEphemerisInfoUpdate(false);
    }
}
