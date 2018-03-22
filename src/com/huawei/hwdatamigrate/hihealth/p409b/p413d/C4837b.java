package com.huawei.hwdatamigrate.hihealth.p409b.p413d;

import android.database.Cursor;
import com.huawei.hihealth.HiAccountInfo;
import com.huawei.hihealth.HiGoalInfo;
import com.huawei.hihealth.HiHealthData;
import com.huawei.hihealth.HiUserInfo;
import com.huawei.hihealth.HiUserPreference;
import com.huawei.hwdatamigrate.hihealth.p409b.p411b.C4808b;
import com.huawei.hwid.core.datatype.SMSKeyInfo;
import com.huawei.nfc.carrera.storage.db.DataModel.ReportCardInfo;
import com.huawei.p190v.C2538c;
import com.sina.weibo.sdk.constant.WBConstants;
import java.util.ArrayList;
import java.util.List;

/* compiled from: CursorUtil */
public class C4837b {
    public static List<HiHealthData> m23327a(Cursor cursor, String[] strArr) {
        if (cursor == null) {
            C2538c.d("Debug_CursorUtil", new Object[]{"parseAggregateStatCursor() Cursor query == null"});
            return null;
        }
        List<HiHealthData> arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            try {
                HiHealthData hiHealthData = new HiHealthData();
                hiHealthData.setStartTime(cursor.getLong(cursor.getColumnIndex("start_time")));
                hiHealthData.setEndTime(cursor.getLong(cursor.getColumnIndex("end_time")));
                hiHealthData.setType(cursor.getInt(cursor.getColumnIndex("type_id")));
                hiHealthData.setTimeZone(cursor.getString(cursor.getColumnIndex("timeZone")));
                hiHealthData.setClientID(cursor.getInt(cursor.getColumnIndex(WBConstants.AUTH_PARAMS_CLIENT_ID)));
                for (String str : strArr) {
                    hiHealthData.putDouble(str, cursor.getDouble(cursor.getColumnIndex(str)));
                }
                arrayList.add(hiHealthData);
            } finally {
                cursor.close();
            }
        }
        return arrayList;
    }

    public static List<HiHealthData> m23326a(Cursor cursor, String str) {
        if (cursor == null) {
            C2538c.d("Debug_CursorUtil", new Object[]{"parseHealthSessionCursor query == null"});
            return null;
        }
        List<HiHealthData> arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            try {
                HiHealthData hiHealthData = new HiHealthData();
                hiHealthData.setStartTime(cursor.getLong(cursor.getColumnIndex("start_time")));
                hiHealthData.setEndTime(cursor.getLong(cursor.getColumnIndex("end_time")));
                hiHealthData.setType(cursor.getInt(cursor.getColumnIndex("type_id")));
                hiHealthData.setMetaData(cursor.getString(cursor.getColumnIndex("metadata")));
                hiHealthData.setTimeZone(cursor.getString(cursor.getColumnIndex("timezone")));
                hiHealthData.setDeviceUUID(str);
                arrayList.add(hiHealthData);
            } finally {
                cursor.close();
            }
        }
        return arrayList;
    }

    public static HiUserInfo m23325a(Cursor cursor) {
        HiUserInfo hiUserInfo = null;
        if (cursor == null) {
            C2538c.d("Debug_CursorUtil", new Object[]{"parseUserInfoCursor() query is null "});
        } else {
            try {
                if (cursor.moveToNext()) {
                    hiUserInfo = new HiUserInfo();
                    hiUserInfo.setOwerID(cursor.getInt(cursor.getColumnIndex("_id")));
                    hiUserInfo.setHuid(cursor.getString(cursor.getColumnIndex("huid")));
                    hiUserInfo.setName(cursor.getString(cursor.getColumnIndex("nick_name")));
                    hiUserInfo.setHeadImgUrl(cursor.getString(cursor.getColumnIndex("head_url")));
                    hiUserInfo.setRelateType(cursor.getInt(cursor.getColumnIndex("relate_type")));
                    hiUserInfo.setHeight(cursor.getInt(cursor.getColumnIndex("height")));
                    hiUserInfo.setWeight(cursor.getFloat(cursor.getColumnIndex("weight")));
                    hiUserInfo.setEmail(cursor.getString(cursor.getColumnIndex("email")));
                    hiUserInfo.setMobile(cursor.getString(cursor.getColumnIndex("mobile")));
                    hiUserInfo.setUnitType(cursor.getInt(cursor.getColumnIndex("unit_category")));
                    hiUserInfo.setGender(cursor.getInt(cursor.getColumnIndex("sex")));
                    hiUserInfo.setBirthday(cursor.getInt(cursor.getColumnIndex("birthday")));
                    hiUserInfo.setAge(cursor.getInt(cursor.getColumnIndex("age")));
                    hiUserInfo.setCreateTime(cursor.getLong(cursor.getColumnIndex("create_time")));
                }
                cursor.close();
                C2538c.b("Debug_CursorUtil", new Object[]{"parseUserInfoCursor() userInfo  = ", hiUserInfo});
            } catch (Throwable th) {
                cursor.close();
            }
        }
        return hiUserInfo;
    }

    public static HiAccountInfo m23328b(Cursor cursor) {
        HiAccountInfo hiAccountInfo = null;
        if (cursor == null) {
            C2538c.d("Debug_CursorUtil", new Object[]{"parseAccountInfoCursor query is null!"});
        } else {
            try {
                if (cursor.moveToNext()) {
                    hiAccountInfo = new HiAccountInfo();
                    hiAccountInfo.setHuid(cursor.getString(cursor.getColumnIndex("huid")));
                    hiAccountInfo.setAppId(cursor.getInt(cursor.getColumnIndex("app_id")));
                    hiAccountInfo.setUserName(cursor.getString(cursor.getColumnIndex("user_name")));
                    hiAccountInfo.setAccessToken(cursor.getString(cursor.getColumnIndex("access_token")));
                    hiAccountInfo.setServiceToken(cursor.getString(cursor.getColumnIndex("service_token")));
                    hiAccountInfo.setThirdOpenId(cursor.getString(cursor.getColumnIndex("third_open_id")));
                    hiAccountInfo.setThirdToken(cursor.getString(cursor.getColumnIndex("third_token")));
                    hiAccountInfo.setSiteId(cursor.getInt(cursor.getColumnIndex("site_id")));
                    hiAccountInfo.setExpiresIn(cursor.getInt(cursor.getColumnIndex("expires_in")));
                    hiAccountInfo.setLogin(cursor.getInt(cursor.getColumnIndex("is_login")));
                    hiAccountInfo.setType(cursor.getInt(cursor.getColumnIndex("type")));
                }
                cursor.close();
            } catch (Throwable th) {
                cursor.close();
            }
        }
        return hiAccountInfo;
    }

    public static List<HiGoalInfo> m23329c(Cursor cursor) {
        if (cursor == null) {
            C2538c.d("Debug_CursorUtil", new Object[]{"parseGoalInfoCursor query is null!"});
            return null;
        }
        List<HiGoalInfo> arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            try {
                HiGoalInfo hiGoalInfo = new HiGoalInfo();
                hiGoalInfo.setGoalType(cursor.getInt(cursor.getColumnIndex("goal_type")));
                hiGoalInfo.setGoalValue(cursor.getDouble(cursor.getColumnIndex("goal_value")));
                hiGoalInfo.setGoalUnit(cursor.getInt(cursor.getColumnIndex("goal_unit")));
                hiGoalInfo.setOwnerId(cursor.getInt(cursor.getColumnIndex(ReportCardInfo.COLUMN_NAME_CARD_USERID)));
                hiGoalInfo.setTargetType(cursor.getInt(cursor.getColumnIndex("target_type")));
                hiGoalInfo.setDealLine(cursor.getInt(cursor.getColumnIndex("deadline")));
                arrayList.add(hiGoalInfo);
            } finally {
                cursor.close();
            }
        }
        return arrayList;
    }

    public static C4808b m23330d(Cursor cursor) {
        C4808b c4808b = null;
        if (cursor == null) {
            C2538c.d("Debug_CursorUtil", new Object[]{"parseSyncAnchorTableCursor query is null!"});
        } else {
            try {
                if (cursor.moveToNext()) {
                    c4808b = new C4808b();
                    c4808b.m23053c(cursor.getInt(cursor.getColumnIndex("main_user_id")));
                    c4808b.m23048a(cursor.getLong(cursor.getColumnIndex("cloud_code")));
                    c4808b.m23047a(cursor.getInt(cursor.getColumnIndex("sync_data_type")));
                    c4808b.m23051b(cursor.getLong(cursor.getColumnIndex("sync_type_version")));
                    c4808b.m23050b(cursor.getInt(cursor.getColumnIndex("modify_time")));
                }
                cursor.close();
            } catch (Throwable th) {
                cursor.close();
            }
        }
        return c4808b;
    }

    public static List<HiUserPreference> m23331e(Cursor cursor) {
        if (cursor == null) {
            C2538c.d("Debug_CursorUtil", new Object[]{"parseUserPreferencesCursor query is null!"});
            return null;
        }
        List<HiUserPreference> arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            try {
                HiUserPreference hiUserPreference = new HiUserPreference();
                hiUserPreference.setId(cursor.getInt(cursor.getColumnIndex("_id")));
                hiUserPreference.setKey(cursor.getString(cursor.getColumnIndex(SMSKeyInfo.TAG_KEY)));
                hiUserPreference.setValue(cursor.getString(cursor.getColumnIndex("value")));
                hiUserPreference.setUserId(cursor.getInt(cursor.getColumnIndex(ReportCardInfo.COLUMN_NAME_CARD_USERID)));
                hiUserPreference.setSyncStatus(cursor.getInt(cursor.getColumnIndex("sync_status")));
                hiUserPreference.setModifiedTime((long) cursor.getInt(cursor.getColumnIndex("modified_time")));
                arrayList.add(hiUserPreference);
            } finally {
                cursor.close();
            }
        }
        return arrayList;
    }
}
