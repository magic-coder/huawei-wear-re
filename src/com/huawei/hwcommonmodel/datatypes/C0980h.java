package com.huawei.hwcommonmodel.datatypes;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: DeviceCapability */
final class C0980h implements Creator<DeviceCapability> {
    C0980h() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m3588a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m3589a(i);
    }

    public DeviceCapability[] m3589a(int i) {
        return new DeviceCapability[i];
    }

    public DeviceCapability m3588a(Parcel parcel) {
        boolean z;
        boolean z2 = parcel.readByte() == (byte) 1;
        boolean z3 = parcel.readByte() == (byte) 1;
        boolean z4 = parcel.readByte() == (byte) 1;
        boolean z5 = parcel.readByte() == (byte) 1;
        boolean z6 = parcel.readByte() == (byte) 1;
        boolean z7 = parcel.readByte() == (byte) 1;
        boolean z8 = parcel.readByte() == (byte) 1;
        boolean z9 = parcel.readByte() == (byte) 1;
        boolean z10 = parcel.readByte() == (byte) 1;
        boolean z11 = parcel.readByte() == (byte) 1;
        boolean z12 = parcel.readByte() == (byte) 1;
        boolean z13 = parcel.readByte() == (byte) 1;
        boolean z14 = parcel.readByte() == (byte) 1;
        boolean z15 = parcel.readByte() == (byte) 1;
        boolean z16 = parcel.readByte() == (byte) 1;
        boolean z17 = parcel.readByte() == (byte) 1;
        boolean z18 = parcel.readByte() == (byte) 1;
        boolean z19 = parcel.readByte() == (byte) 1;
        boolean z20 = parcel.readByte() == (byte) 1;
        int readInt = parcel.readInt();
        int readInt2 = parcel.readInt();
        boolean z21 = parcel.readByte() == (byte) 1;
        boolean z22 = parcel.readByte() == (byte) 1;
        boolean z23 = parcel.readByte() == (byte) 1;
        boolean z24 = parcel.readByte() == (byte) 1;
        boolean z25 = parcel.readByte() == (byte) 1;
        boolean z26 = parcel.readByte() == (byte) 1;
        boolean z27 = parcel.readByte() == (byte) 1;
        boolean z28 = parcel.readByte() == (byte) 1;
        boolean z29 = parcel.readByte() == (byte) 1;
        boolean z30 = parcel.readByte() == (byte) 1;
        boolean z31 = parcel.readByte() == (byte) 1;
        int readInt3 = parcel.readInt();
        boolean z32 = parcel.readByte() == (byte) 1;
        boolean z33 = parcel.readByte() == (byte) 1;
        boolean z34 = parcel.readByte() == (byte) 1;
        boolean z35 = parcel.readByte() == (byte) 1;
        boolean z36 = parcel.readByte() == (byte) 1;
        boolean z37 = parcel.readByte() == (byte) 1;
        boolean z38 = parcel.readByte() == (byte) 1;
        boolean z39 = parcel.readByte() == (byte) 1;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        boolean z40 = parcel.readByte() == (byte) 1;
        boolean z41 = parcel.readByte() == (byte) 1;
        boolean z42 = parcel.readByte() == (byte) 1;
        boolean z43 = parcel.readByte() == (byte) 1;
        boolean z44 = parcel.readByte() == (byte) 1;
        boolean z45 = parcel.readByte() == (byte) 1;
        boolean z46 = parcel.readByte() == (byte) 1;
        boolean z47 = parcel.readByte() == (byte) 1;
        boolean z48 = parcel.readByte() == (byte) 1;
        boolean z49 = parcel.readByte() == (byte) 1;
        boolean z50 = parcel.readByte() == (byte) 1;
        boolean z51 = parcel.readByte() == (byte) 1;
        boolean z52 = parcel.readByte() == (byte) 1;
        boolean z53 = parcel.readByte() == (byte) 1;
        boolean z54 = parcel.readByte() == (byte) 1;
        boolean z55 = parcel.readByte() == (byte) 1;
        boolean z56 = parcel.readByte() == (byte) 1;
        boolean z57 = parcel.readByte() == (byte) 1;
        boolean z58 = parcel.readByte() == (byte) 1;
        boolean z59 = parcel.readByte() == (byte) 1;
        boolean z60 = parcel.readByte() == (byte) 1;
        boolean z61 = parcel.readByte() == (byte) 1;
        boolean z62 = parcel.readByte() == (byte) 1;
        boolean z63 = parcel.readByte() == (byte) 1;
        boolean z64 = parcel.readByte() == (byte) 1;
        int readInt4 = parcel.readInt();
        boolean z65 = parcel.readByte() == (byte) 1;
        boolean z66 = parcel.readByte() == (byte) 1;
        boolean z67 = parcel.readByte() == (byte) 1;
        boolean z68 = parcel.readByte() == (byte) 1;
        boolean z69 = parcel.readByte() == (byte) 1;
        boolean z70 = parcel.readByte() == (byte) 1;
        boolean z71 = parcel.readByte() == (byte) 1;
        boolean z72 = parcel.readByte() == (byte) 1;
        boolean z73 = parcel.readByte() == (byte) 1;
        boolean z74 = parcel.readByte() == (byte) 1;
        boolean z75 = parcel.readByte() == (byte) 1;
        boolean z76 = parcel.readByte() == (byte) 1;
        boolean z77 = parcel.readByte() == (byte) 1;
        boolean z78 = parcel.readByte() == (byte) 1;
        boolean z79 = parcel.readByte() == (byte) 1;
        boolean z80 = parcel.readByte() == (byte) 1;
        boolean z81 = parcel.readByte() == (byte) 1;
        DeviceCapability deviceCapability = new DeviceCapability();
        deviceCapability.configureSupportTimeSetting(z2);
        deviceCapability.configureSupportGetFirmwareVersion(z3);
        deviceCapability.configureSupportGetBattery(z4);
        deviceCapability.configureAuto_light_screen(z5);
        deviceCapability.configureAvoid_disturb(z6);
        deviceCapability.configureFactory_reset(z7);
        deviceCapability.configureSupportPairDevice(z8);
        deviceCapability.configureSupportGetHandsetInfo(z9);
        deviceCapability.configureSupportNotificationIntervalInfo(z10);
        deviceCapability.configureSupportActivityType(z11);
        deviceCapability.configureSupportAuthenticDevice(z12);
        deviceCapability.configureGold_card(z13);
        deviceCapability.configureMessage_alert(z14);
        deviceCapability.configureSupportMessageAlertInfo(z15);
        deviceCapability.configureSupportMessageSupportInfo(z16);
        deviceCapability.configureupportMessageCenterPushDevice(z17);
        deviceCapability.configureSupportWearMessagePush(z18);
        deviceCapability.configureContacts(z19);
        deviceCapability.configureSupportCallingOperationType(z20);
        deviceCapability.configureMotionGoalCap(readInt);
        deviceCapability.configureFitness_frame_type(readInt2);
        deviceCapability.configureActivity_reminder(z21);
        deviceCapability.configureSupportSetUserInfoEncrypt(z22);
        deviceCapability.configureSupportSampleFrame(z23);
        deviceCapability.configureSupportThreshold(z24);
        deviceCapability.configureReserveSync(z25);
        deviceCapability.configureIsSupportHRZone(z26);
        deviceCapability.configureIsSupportCoreSleep(z27);
        deviceCapability.configureSupportGetUserInfo(z28);
        deviceCapability.configureIsSupportSendCoreSleepOutState(z29);
        deviceCapability.configureIsSupportQueryDeviceCoreSleepSwitch(z30);
        deviceCapability.configureEvent_alarm(z31);
        deviceCapability.configureEvent_alarm_num(readInt3);
        deviceCapability.configureSmart_alarm(z32);
        deviceCapability.configureOta_update(z33);
        deviceCapability.configureMaintenance(z34);
        deviceCapability.configureMaintenance_in_time(z35);
        deviceCapability.configureMaintenance_get_data(z36);
        deviceCapability.configureSupportAntiLost(z37);
        deviceCapability.configureBluetooth_off_alert(z38);
        deviceCapability.configureLanguage(z39);
        deviceCapability.configureWeather_push(z);
        deviceCapability.configureSupportExerciseAdvice(z40);
        deviceCapability.configureSupportExerciseAdviceTime(z41);
        deviceCapability.configureSupportExerciseAdviceMonitor(z42);
        deviceCapability.configureSupportWorkout(z43);
        deviceCapability.configureSupportWorkoutInfo(z44);
        deviceCapability.configureSupportWorkoutReminder(z45);
        deviceCapability.configureSupportWorkoutRecord(z46);
        deviceCapability.configureSupportWorkoutExerciseDisplayLink(z47);
        deviceCapability.configureSupportWorkoutRecordPaceMap(z48);
        deviceCapability.configureSupportGPSLocation(z49);
        deviceCapability.configureSupportGPSData(z50);
        deviceCapability.configureSupportGPSSetParameter(z51);
        deviceCapability.configureSupportHeartRateInfo(z52);
        deviceCapability.configureSleep(z53);
        deviceCapability.configureClimb(z54);
        deviceCapability.configureRiding(z55);
        deviceCapability.configureStand(z56);
        deviceCapability.configureSleep_shallow(z57);
        deviceCapability.configureSleep_deep(z58);
        deviceCapability.configureWalk(z59);
        deviceCapability.configureRun(z60);
        deviceCapability.configureStep(z61);
        deviceCapability.configureCalorie(z62);
        deviceCapability.configureDistance(z63);
        deviceCapability.configureIsSupportHeartRate(z64);
        deviceCapability.configurePromptPush(readInt4);
        deviceCapability.configureCall_mute(z65);
        deviceCapability.configureIsSupportHelp(z66);
        deviceCapability.configureDistanceDetail(z67);
        deviceCapability.configureSupportEsim(z68);
        deviceCapability.configureSupportMultiSim(z69);
        deviceCapability.configureSupportPay(z70);
        deviceCapability.configureisSupportHeartRateEnable(z71);
        deviceCapability.configureRotate_switch_screen(z72);
        deviceCapability.configureSupportQueryAllowDisturbContent(z73);
        deviceCapability.configureSupportLeftRightHandWearMode(z74);
        deviceCapability.configureSupportStress(z75);
        deviceCapability.configureSupportMidware(z76);
        deviceCapability.configureSupportSportTotal(z77);
        deviceCapability.configureSupportAccount(z78);
        deviceCapability.configureSupportOneLevelMenu(z79);
        deviceCapability.configureSupportDeleteMsg(z80);
        deviceCapability.configureSupportEphemerisInfoUpdate(z81);
        return deviceCapability;
    }
}
