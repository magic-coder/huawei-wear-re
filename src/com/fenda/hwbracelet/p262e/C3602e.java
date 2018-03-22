package com.fenda.hwbracelet.p262e;

import cn.com.fmsh.script.constants.ScriptToolsConst;
import cn.com.fmsh.tsm.business.constants.Constants.TagName;

/* compiled from: XbMessageType */
public enum C3602e {
    ALERT_CALL_IDLE((byte) 1),
    ALERT_CALL_RINGING((byte) 2),
    ALERT_CALL_NUMBER((byte) 3),
    ALERT_CALL_OFFHOOK((byte) 4),
    ALERT_CALL_MUTE((byte) 16),
    ALERT_CALL_REJECT((byte) 17),
    CAMERA_OPEN((byte) 33),
    CAMERA_CLOSE((byte) 34),
    CAMERA_SHUTTER((byte) 35),
    DATE_TIME(TagName.NOTICE_ID),
    FIND_PHONE(TagName.NOTICE_TITLE),
    ALERT_ALARM(TagName.ACTIVITY_CODE_LIST),
    APP_KEY(TagName.NOTICE_BODY),
    PERSONAL_PROFILE((byte) 53),
    ALERT_LOST_PHONE(TagName.NOTICE_START_TIME),
    ALERT_SPORT_REMINDER(TagName.NOTICE_END_TIME),
    GET_CURRENT_VERSION(ScriptToolsConst.TagName.TagSerial),
    GET_BAND_BATTERY(ScriptToolsConst.TagName.TagApdu),
    RESPOND_BAND_BATTERY(TagName.BUSINESS_ORDER_OP_TYPE),
    RESPOND_CURRENT_VERSION(TagName.CARD_APP_RAMDOM),
    DFU_UPGRADE_RESTART((byte) 64),
    MUTE_LOST_PHONE(TagName.TERMINAL_BACK_CONTENT),
    AUTO_SLEEP_TIME(TagName.TERMINAL_BACK_INFO_TYPE),
    MESSAGE_CONFIRM(TagName.TERMINAL_OS_VERSION),
    CLEAR_BRACELET_RECORD(TagName.TERMINAL_MODEL_NUMBER),
    GET_SPORT_REMINDER(TagName.TERMINAL_BASEBAND_VERSION),
    GET_AUTO_SLEEP_TIME(TagName.ACTIVITY_INFO),
    GET_ALARM(TagName.BUSINESS_ORDER_TYPE),
    GET_USER_INFO(TagName.ORDER_BRIEF_INFO),
    GET_DEVICE_TIME((byte) 74),
    GET_TOTAL_STEPS((byte) 75),
    GET_TOTAL_CALORIE(TagName.TERMINAL_OP_TYPE),
    RESPOND_SPORT_REMINDER((byte) 77),
    RESPOND_AUTO_SLEEP_TIME((byte) 78),
    RESPOND_ALARM(TagName.CP_NO),
    RESPOND_USER_INFO(TagName.ORDER_BRIEF_INFO_LIST),
    RESPOND_DEVICE_TIME((byte) 81),
    RESPOND_TOTAL_STEPS(TagName.TERMINAL_BACK_QUESTION_FLAG),
    RESPOND_TOTAL_CALORIE(TagName.TERMINAL_BACK_INFO),
    FACTORY_RESET(TagName.TERMINAL_BACK_INFO_LIST),
    GET_ST_VERSION(TagName.CARD_BUSINESS_OP_RECOMMENED),
    RESPOND_ST_VERSION((byte) 89),
    ACK_RECEIVE_MIN_DATA(TagName.PREDEPOSIT_TOTAL),
    APP_TOTAL_STEPS(TagName.MAIN_ORDER_LIST),
    APP_TOTAL_CALORIE(TagName.OPERATE_TIMING),
    GET_TOTAL_SLEEP_TIME(TagName.PAY_ORDER),
    RESPOND_TOTAL_SLEEP_TIME(TagName.PAY_ORDER_LIST),
    GET_TOTAL_SPTES_CALORIE(TagName.ORDER_TYPE),
    RESPOND_TOTAL_STEPS_CALORIE((byte) 102),
    DISPLAY_HIGHTLIGHT(TagName.DEVICE_MODEL),
    DISPLAY_NORMAL(TagName.MAIN_ORDER_ID),
    GESTURE_ACTIVE(TagName.PAY_ORDER_ID),
    GESTURE_OFF(TagName.ELECTRONIC),
    PERSONAL_GOAL(TagName.ELECTRONIC_LIST),
    ACTIVE_DISCONNECT(TagName.PUBLISH_END_TIME),
    LOW_POWER(TagName.ELECTRONIC_TYPE_ID),
    CLOSE_BAND(TagName.ELECTRONIC_NUMBER),
    LOST_PHONE_ON(TagName.ELECTRONIC_TYPE),
    LOST_PHONE_OFF(TagName.ELECTRONIC_USE_TYPE),
    ENTER_BOOTLOAD(TagName.ACTIVITY_NAME),
    APP_OTA_DATA(TagName.ACTIVITY_CODE),
    APP_OTA_FINAL(TagName.ACTIVITY_START),
    CMD_ACK((byte) -111),
    ST_DATA_ACK(TagName.TEXT_NOTICE),
    RETRY_TX_REQ(TagName.PLATFORM_NOTICES),
    RETRY_FIN_SUCCESS(TagName.UNSOLVED_NOTICES),
    SYNC_SINGLE_DATA((byte) -80),
    SYNC_JOLT((byte) -80),
    SYNC_DATA_REQUEST(TagName.SEID),
    SYNC_CONFIRM(TagName.APP_TYPE),
    SYNC_DAY_ToTAL_NUMBER(TagName.APP_AID),
    SYNC_DATA(TagName.PATCH_DATA),
    SYNC_TOTAL_DATA_NUMBER(TagName.BUSINESS_HANDLE_RESULT),
    SYNC_CURRENT_DATA_FINISHED(TagName.CPLC),
    SYNC_END((byte) -73),
    CHAOS((byte) -1);
    
    private final byte ay;

    private C3602e(byte b) {
        this.ay = b;
    }

    public byte m18082a() {
        return this.ay;
    }

    public static C3602e m18081a(byte b) {
        for (C3602e c3602e : C3602e.values()) {
            if (c3602e.ay == b) {
                return c3602e;
            }
        }
        return CHAOS;
    }
}