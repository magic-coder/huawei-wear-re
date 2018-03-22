package com.huawei.hwdatamigrate.hihealth.p409b.p413d;

import android.content.ContentValues;
import com.huawei.hihealth.HiAccountInfo;
import com.huawei.hihealth.HiAppInfo;
import com.huawei.hihealth.HiDeviceInfo;
import com.huawei.hihealth.HiGoalInfo;
import com.huawei.hihealth.HiHealthData;
import com.huawei.hihealth.HiUserInfo;
import com.huawei.hihealth.HiUserPreference;
import com.huawei.hihealth.p394c.C4540b;
import com.huawei.hwdatamigrate.hihealth.d.g;
import com.huawei.hwdatamigrate.hihealth.p409b.p411b.C4807a;
import com.huawei.hwdatamigrate.hihealth.p409b.p411b.C4808b;
import com.huawei.hwdatamigrate.hihealth.p409b.p411b.C4809c;
import com.huawei.hwid.core.datatype.SMSKeyInfo;
import com.huawei.nfc.PluginPayAdapter;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.huawei.nfc.carrera.storage.db.DataModel.ReportCardInfo;
import com.sina.weibo.sdk.constant.WBConstants;
import com.unionpay.tsmservice.data.Constant;
import java.util.UUID;

/* compiled from: BuildContentValueUtil */
public class C4836a {
    public static ContentValues m23307a(HiHealthData hiHealthData, int i, int i2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("start_time", Long.valueOf(hiHealthData.getStartTime()));
        contentValues.put("end_time", Long.valueOf(hiHealthData.getEndTime()));
        contentValues.put("type_id", Integer.valueOf(hiHealthData.getType()));
        contentValues.put("value", Double.valueOf(hiHealthData.getValue()));
        contentValues.put("metadata", hiHealthData.getMetaData());
        contentValues.put("unit_id", Integer.valueOf(hiHealthData.getPointUnit()));
        contentValues.put(WBConstants.AUTH_PARAMS_CLIENT_ID, Integer.valueOf(i));
        contentValues.put("merged", Integer.valueOf(i2));
        contentValues.put("sync_status", Integer.valueOf(hiHealthData.getSyncStatus()));
        contentValues.put("timeZone", C4540b.m21752a(hiHealthData.getTimeZone()));
        contentValues.put("modified_time", Long.valueOf(System.currentTimeMillis()));
        return contentValues;
    }

    public static ContentValues m23315b(HiHealthData hiHealthData, int i, int i2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("start_time", Long.valueOf(hiHealthData.getStartTime()));
        contentValues.put("end_time", Long.valueOf(hiHealthData.getEndTime()));
        contentValues.put("type_id", Integer.valueOf(hiHealthData.getType()));
        contentValues.put("value", Double.valueOf(hiHealthData.getValue()));
        contentValues.put("metadata", hiHealthData.getMetaData());
        contentValues.put("unit_id", Integer.valueOf(hiHealthData.getPointUnit()));
        contentValues.put(WBConstants.AUTH_PARAMS_CLIENT_ID, Integer.valueOf(i));
        contentValues.put("merged", Integer.valueOf(i2));
        contentValues.put("sync_status", Integer.valueOf(hiHealthData.getSyncStatus()));
        contentValues.put("timeZone", C4540b.m21752a(hiHealthData.getTimeZone()));
        contentValues.put("modified_time", Long.valueOf(System.currentTimeMillis()));
        return contentValues;
    }

    public static ContentValues m23306a(HiHealthData hiHealthData, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("value", Double.valueOf(hiHealthData.getValue()));
        contentValues.put("metadata", hiHealthData.getMetaData());
        contentValues.put("unit_id", Integer.valueOf(hiHealthData.getPointUnit()));
        contentValues.put("sync_status", Integer.valueOf(hiHealthData.getSyncStatus()));
        contentValues.put("merged", Integer.valueOf(i));
        contentValues.put("modified_time", Long.valueOf(System.currentTimeMillis()));
        return contentValues;
    }

    public static ContentValues m23314b(HiHealthData hiHealthData, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("value", Double.valueOf(hiHealthData.getValue()));
        contentValues.put("metadata", hiHealthData.getMetaData());
        contentValues.put("unit_id", Integer.valueOf(hiHealthData.getPointUnit()));
        contentValues.put("sync_status", Integer.valueOf(hiHealthData.getSyncStatus()));
        contentValues.put("merged", Integer.valueOf(i));
        contentValues.put("modified_time", Long.valueOf(System.currentTimeMillis()));
        return contentValues;
    }

    public static ContentValues m23301a(int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("merged", Integer.valueOf(i));
        contentValues.put("modified_time", Long.valueOf(System.currentTimeMillis()));
        return contentValues;
    }

    public static ContentValues m23320c(HiHealthData hiHealthData, int i, int i2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("start_time", Long.valueOf(hiHealthData.getStartTime()));
        contentValues.put("end_time", Long.valueOf(hiHealthData.getEndTime()));
        contentValues.put("type_id", Integer.valueOf(hiHealthData.getType()));
        contentValues.put("metadata", hiHealthData.getMetaData());
        contentValues.put(WBConstants.AUTH_PARAMS_CLIENT_ID, Integer.valueOf(i));
        contentValues.put("merged", Integer.valueOf(i2));
        contentValues.put("sync_status", Integer.valueOf(hiHealthData.getSyncStatus()));
        contentValues.put("timezone", C4540b.m21752a(hiHealthData.getTimeZone()));
        contentValues.put("modified_time", Long.valueOf(System.currentTimeMillis()));
        return contentValues;
    }

    public static ContentValues m23322d(HiHealthData hiHealthData, int i, int i2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("start_time", Long.valueOf(hiHealthData.getStartTime()));
        contentValues.put("end_time", Long.valueOf(hiHealthData.getEndTime()));
        contentValues.put("type_id", Integer.valueOf(hiHealthData.getType()));
        contentValues.put("metadata", hiHealthData.getMetaData());
        contentValues.put(WBConstants.AUTH_PARAMS_CLIENT_ID, Integer.valueOf(i));
        contentValues.put("merged", Integer.valueOf(i2));
        contentValues.put("sync_status", Integer.valueOf(hiHealthData.getSyncStatus()));
        contentValues.put("timezone", C4540b.m21752a(hiHealthData.getTimeZone()));
        contentValues.put("modified_time", Long.valueOf(System.currentTimeMillis()));
        return contentValues;
    }

    public static ContentValues m23319c(HiHealthData hiHealthData, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("type_id", Integer.valueOf(hiHealthData.getType()));
        contentValues.put("metadata", hiHealthData.getMetaData());
        contentValues.put("merged", Integer.valueOf(i));
        contentValues.put("sync_status", Integer.valueOf(hiHealthData.getSyncStatus()));
        contentValues.put("modified_time", Long.valueOf(System.currentTimeMillis()));
        return contentValues;
    }

    public static ContentValues m23321d(HiHealthData hiHealthData, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("type_id", Integer.valueOf(hiHealthData.getType()));
        contentValues.put("metadata", hiHealthData.getMetaData());
        contentValues.put("merged", Integer.valueOf(i));
        contentValues.put("sync_status", Integer.valueOf(hiHealthData.getSyncStatus()));
        contentValues.put("modified_time", Long.valueOf(System.currentTimeMillis()));
        return contentValues;
    }

    public static ContentValues m23324e(HiHealthData hiHealthData, int i, int i2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("start_time", Long.valueOf(hiHealthData.getStartTime()));
        contentValues.put("end_time", Long.valueOf(hiHealthData.getEndTime()));
        contentValues.put("type_id", Integer.valueOf(hiHealthData.getType()));
        contentValues.put("data", hiHealthData.getSequenceData());
        contentValues.put("meta_data", hiHealthData.getMetaData());
        contentValues.put(WBConstants.AUTH_PARAMS_CLIENT_ID, Integer.valueOf(i));
        contentValues.put("merged", Integer.valueOf(i2));
        contentValues.put("sync_status", Integer.valueOf(hiHealthData.getSyncStatus()));
        contentValues.put("timeZone", C4540b.m21752a(hiHealthData.getTimeZone()));
        contentValues.put("modified_time", Long.valueOf(System.currentTimeMillis()));
        return contentValues;
    }

    public static ContentValues m23323e(HiHealthData hiHealthData, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("data", hiHealthData.getSequenceData());
        contentValues.put("meta_data", hiHealthData.getMetaData());
        contentValues.put("merged", Integer.valueOf(i));
        contentValues.put("sync_status", Integer.valueOf(hiHealthData.getSyncStatus()));
        contentValues.put("modified_time", Long.valueOf(System.currentTimeMillis()));
        return contentValues;
    }

    public static ContentValues m23310a(C4807a c4807a) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("date", Integer.valueOf(c4807a.m23025a()));
        contentValues.put("hihealth_type", Integer.valueOf(c4807a.m23030b()));
        contentValues.put("stat_type", Integer.valueOf(c4807a.m23033c()));
        contentValues.put("value", Double.valueOf(c4807a.m23035d()));
        contentValues.put(WBConstants.AUTH_PARAMS_CLIENT_ID, Integer.valueOf(c4807a.m23039f()));
        contentValues.put("unit_id", Integer.valueOf(c4807a.m23043h()));
        contentValues.put(ReportCardInfo.COLUMN_NAME_CARD_USERID, Integer.valueOf(c4807a.m23037e()));
        contentValues.put("timeZone", C4540b.m21752a(c4807a.m23041g()));
        contentValues.put("sync_status", Integer.valueOf(c4807a.m23044i()));
        contentValues.put("modified_time", Long.valueOf(c4807a.m23045j()));
        return contentValues;
    }

    public static ContentValues m23317b(C4807a c4807a) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("value", Double.valueOf(c4807a.m23035d()));
        contentValues.put("unit_id", Integer.valueOf(c4807a.m23043h()));
        contentValues.put(ReportCardInfo.COLUMN_NAME_CARD_USERID, Integer.valueOf(c4807a.m23037e()));
        contentValues.put("sync_status", Integer.valueOf(c4807a.m23044i()));
        contentValues.put("modified_time", Long.valueOf(c4807a.m23045j()));
        return contentValues;
    }

    public static ContentValues m23303a(HiAppInfo hiAppInfo, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(SNBConstant.FIELD_PKG, hiAppInfo.getPackageName());
        contentValues.put("app_name", hiAppInfo.getAppName());
        contentValues.put("version", hiAppInfo.getVersion());
        contentValues.put(Constant.KEY_SIGNATURE, hiAppInfo.getSignature());
        contentValues.put("cloud_code", Long.valueOf(hiAppInfo.getCloudCode()));
        contentValues.put("sync_status", Integer.valueOf(i));
        contentValues.put("createTime", Long.valueOf(System.currentTimeMillis()));
        return contentValues;
    }

    public static ContentValues m23304a(HiDeviceInfo hiDeviceInfo) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("device_unique_code", hiDeviceInfo.getDeviceUniqueCode());
        contentValues.put("deviceName", hiDeviceInfo.getDeviceName());
        contentValues.put("device_type", Integer.valueOf(hiDeviceInfo.getDeviceType()));
        contentValues.put("firmwareVersion", hiDeviceInfo.getFirmwareVersion());
        contentValues.put("hardwareVersion", hiDeviceInfo.getHardwareVersion());
        contentValues.put("softwareVersion", hiDeviceInfo.getSoftwareVersion());
        contentValues.put("manufacturer", hiDeviceInfo.getManufacturer());
        contentValues.put("model", hiDeviceInfo.getModel());
        contentValues.put(PluginPayAdapter.KEY_DEVICE_INFO_SN, hiDeviceInfo.getDeviceSN());
        contentValues.put("device_mac", hiDeviceInfo.getDeviceMac());
        contentValues.put("createTime", Long.valueOf(System.currentTimeMillis()));
        return contentValues;
    }

    public static ContentValues m23313a(g gVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("client_uuid", UUID.randomUUID().toString());
        contentValues.put(ReportCardInfo.COLUMN_NAME_CARD_USERID, Integer.valueOf(gVar.f()));
        contentValues.put(SNBConstant.FIELD_DEVICE_ID, Integer.valueOf(gVar.e()));
        contentValues.put("app_id", Integer.valueOf(gVar.d()));
        contentValues.put("sync_status", Integer.valueOf(gVar.a()));
        contentValues.put("cloud_device", Long.valueOf(gVar.g()));
        contentValues.put("create_time", Long.valueOf(System.currentTimeMillis()));
        return contentValues;
    }

    public static ContentValues m23318b(g gVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("sync_status", Integer.valueOf(gVar.a()));
        contentValues.put("cloud_device", Long.valueOf(gVar.g()));
        return contentValues;
    }

    public static ContentValues m23308a(HiUserInfo hiUserInfo, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("huid", hiUserInfo.getHuid());
        contentValues.put("nick_name", hiUserInfo.getName());
        contentValues.put("head_url", hiUserInfo.getHeadImgUrl());
        contentValues.put("relate_type", Integer.valueOf(hiUserInfo.getRelateType()));
        contentValues.put("height", Integer.valueOf(hiUserInfo.getHeight()));
        contentValues.put("weight", Float.valueOf(hiUserInfo.getWeight()));
        contentValues.put("email", hiUserInfo.getEmail());
        contentValues.put("mobile", hiUserInfo.getMobile());
        contentValues.put("unit_category", Integer.valueOf(hiUserInfo.getUnitType()));
        contentValues.put("sex", Integer.valueOf(hiUserInfo.getGender()));
        contentValues.put("birthday", Integer.valueOf(hiUserInfo.getBirthday()));
        contentValues.put("age", Integer.valueOf(hiUserInfo.getAge()));
        contentValues.put("sync_status", Integer.valueOf(i));
        contentValues.put("create_time", Long.valueOf(hiUserInfo.getCreateTime()));
        return contentValues;
    }

    public static ContentValues m23302a(HiAccountInfo hiAccountInfo) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("huid", hiAccountInfo.getHuid());
        contentValues.put("app_id", Integer.valueOf(hiAccountInfo.getAppId()));
        contentValues.put("user_name", hiAccountInfo.getUserName());
        contentValues.put("access_token", hiAccountInfo.getAccessToken());
        contentValues.put("service_token", hiAccountInfo.getServiceToken());
        contentValues.put("third_open_id", hiAccountInfo.getThirdOpenId());
        contentValues.put("third_token", hiAccountInfo.getThirdToken());
        contentValues.put("site_id", Integer.valueOf(hiAccountInfo.getSiteId()));
        contentValues.put("expires_in", Integer.valueOf(hiAccountInfo.getExpiresIn()));
        contentValues.put("is_login", Integer.valueOf(hiAccountInfo.getIsLogin()));
        contentValues.put("type", Integer.valueOf(hiAccountInfo.getType()));
        contentValues.put("create_time", Long.valueOf(System.currentTimeMillis()));
        return contentValues;
    }

    public static ContentValues m23305a(HiGoalInfo hiGoalInfo, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("goal_type", Integer.valueOf(hiGoalInfo.getGoalType()));
        contentValues.put("goal_value", Double.valueOf(hiGoalInfo.getGoalValue()));
        contentValues.put("goal_unit", Integer.valueOf(hiGoalInfo.getGoalUnit()));
        contentValues.put(ReportCardInfo.COLUMN_NAME_CARD_USERID, Integer.valueOf(hiGoalInfo.getOwnerId()));
        contentValues.put("target_type", Integer.valueOf(hiGoalInfo.getTargetType()));
        contentValues.put("deadline", Integer.valueOf(hiGoalInfo.getDealLine()));
        contentValues.put("sync_status", Integer.valueOf(i));
        contentValues.put("modified_time", Long.valueOf(System.currentTimeMillis()));
        return contentValues;
    }

    public static ContentValues m23311a(C4808b c4808b) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("main_user_id", Integer.valueOf(c4808b.m23055e()));
        contentValues.put("cloud_code", Long.valueOf(c4808b.m23049b()));
        contentValues.put("sync_data_type", Integer.valueOf(c4808b.m23046a()));
        contentValues.put("sync_type_version", Long.valueOf(c4808b.m23052c()));
        contentValues.put("sync_type_time", Integer.valueOf(c4808b.m23054d()));
        contentValues.put("modify_time", Long.valueOf(System.currentTimeMillis()));
        return contentValues;
    }

    public static ContentValues m23312a(C4809c c4809c) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("userId", Integer.valueOf(c4809c.m23056a()));
        contentValues.put("dataType", Integer.valueOf(c4809c.m23060b()));
        contentValues.put("data", c4809c.m23062c());
        contentValues.put("dataTime", Long.valueOf(c4809c.m23063d()));
        contentValues.put("isDone", Integer.valueOf(c4809c.m23064e()));
        contentValues.put("modifiedTime", Long.valueOf(System.currentTimeMillis()));
        return contentValues;
    }

    public static ContentValues m23309a(HiUserPreference hiUserPreference) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(SMSKeyInfo.TAG_KEY, hiUserPreference.getKey());
        contentValues.put("value", hiUserPreference.getValue());
        contentValues.put(ReportCardInfo.COLUMN_NAME_CARD_USERID, Integer.valueOf(hiUserPreference.getUserId()));
        contentValues.put("sync_status", Integer.valueOf(hiUserPreference.getSyncStatus()));
        contentValues.put("create_time", Long.valueOf(System.currentTimeMillis()));
        contentValues.put("modified_time", Long.valueOf(hiUserPreference.getModifiedTime()));
        return contentValues;
    }

    public static ContentValues m23316b(HiUserPreference hiUserPreference) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("value", hiUserPreference.getValue());
        contentValues.put("sync_status", Integer.valueOf(hiUserPreference.getSyncStatus()));
        contentValues.put("modified_time", Long.valueOf(hiUserPreference.getModifiedTime()));
        return contentValues;
    }
}
