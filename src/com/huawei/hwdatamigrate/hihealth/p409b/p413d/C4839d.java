package com.huawei.hwdatamigrate.hihealth.p409b.p413d;

import android.database.Cursor;
import com.huawei.hihealth.HiHealthData;
import com.huawei.hihealth.HiUserPreference;
import com.huawei.hihealth.p394c.C4540b;
import com.huawei.hihealth.p394c.C4545g;
import com.huawei.hwid.core.datatype.SMSKeyInfo;
import com.huawei.nfc.carrera.storage.db.DataModel.ReportCardInfo;
import com.huawei.p190v.C2538c;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MCursorUtil */
public class C4839d {
    public static HiUserPreference m23336a(Cursor cursor) {
        HiUserPreference hiUserPreference = null;
        if (cursor == null) {
            C2538c.d("Debug_MCursorUtil", new Object[]{"parseUserPreferenceCursor query is null!"});
        } else {
            try {
                if (cursor.moveToNext()) {
                    hiUserPreference = new HiUserPreference();
                    hiUserPreference.setId(cursor.getInt(cursor.getColumnIndex("_id")));
                    hiUserPreference.setKey(cursor.getString(cursor.getColumnIndex(SMSKeyInfo.TAG_KEY)));
                    hiUserPreference.setValue(cursor.getString(cursor.getColumnIndex("value")));
                    hiUserPreference.setUserId(cursor.getInt(cursor.getColumnIndex(ReportCardInfo.COLUMN_NAME_CARD_USERID)));
                    hiUserPreference.setSyncStatus(cursor.getInt(cursor.getColumnIndex("sync_status")));
                    hiUserPreference.setCreateTime(cursor.getLong(cursor.getColumnIndex("create_time")));
                    hiUserPreference.setModifiedTime(cursor.getLong(cursor.getColumnIndex("modified_time")));
                }
                cursor.close();
            } catch (Throwable th) {
                cursor.close();
            }
        }
        return hiUserPreference;
    }

    public static List<HiHealthData> m23337a(Cursor cursor, String str) {
        if (cursor == null) {
            C2538c.d("Debug_MCursorUtil", new Object[]{"parseHealthPointCursor query == null"});
            return null;
        }
        List<HiHealthData> arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            try {
                HiHealthData hiHealthData = new HiHealthData();
                hiHealthData.setStartTime(cursor.getLong(cursor.getColumnIndex("start_time")));
                hiHealthData.setEndTime(cursor.getLong(cursor.getColumnIndex("end_time")));
                hiHealthData.setType(cursor.getInt(cursor.getColumnIndex("type_id")));
                hiHealthData.setValue(cursor.getDouble(cursor.getColumnIndex("value")));
                hiHealthData.setMetaData(cursor.getString(cursor.getColumnIndex("metadata")));
                hiHealthData.setPointUnit(cursor.getInt(cursor.getColumnIndex("unit_id")));
                hiHealthData.setDeviceUUID(str);
                hiHealthData.setTimeZone(cursor.getString(cursor.getColumnIndex("timeZone")));
                arrayList.add(hiHealthData);
            } finally {
                cursor.close();
            }
        }
        return arrayList;
    }

    public static List<HiHealthData> m23340b(Cursor cursor, String str) {
        if (cursor == null) {
            C2538c.d("Debug_MCursorUtil", new Object[]{"parseSequenceMetaDataCursor() Cursor query == null"});
            return null;
        }
        List<HiHealthData> arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            try {
                HiHealthData hiHealthData = new HiHealthData();
                hiHealthData.setStartTime(cursor.getLong(cursor.getColumnIndex("start_time")));
                hiHealthData.setEndTime(cursor.getLong(cursor.getColumnIndex("end_time")));
                hiHealthData.setType(cursor.getInt(cursor.getColumnIndex("type_id")));
                C2538c.c("Debug_MCursorUtil", new Object[]{"parseSequenceDatasCursor() zipLength = ", Integer.valueOf(cursor.getString(cursor.getColumnIndex("data")).length())});
                hiHealthData.setSequenceData(C4545g.m21791b(cursor.getString(cursor.getColumnIndex("data"))));
                C2538c.c("Debug_MCursorUtil", new Object[]{"parseSequenceDatasCursor() unZipLength = ", Integer.valueOf(C4545g.m21791b(r2).length())});
                hiHealthData.setMetaData(cursor.getString(cursor.getColumnIndex("meta_data")));
                hiHealthData.setDeviceUUID(str);
                hiHealthData.setTimeZone(cursor.getString(cursor.getColumnIndex("timeZone")));
                arrayList.add(hiHealthData);
            } catch (IOException e) {
                C2538c.e("Debug_MCursorUtil", new Object[]{"parseSequenceDatasCursor() uncompress e = ", e.getMessage()});
            } catch (Throwable th) {
                cursor.close();
            }
        }
        cursor.close();
        return arrayList;
    }

    public static List<HiHealthData> m23341c(Cursor cursor, String str) {
        if (cursor == null) {
            C2538c.d("Debug_MCursorUtil", new Object[]{"parseSessionCoreCursor query == null"});
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

    public static List<HiHealthData> m23339b(Cursor cursor) {
        if (cursor == null) {
            C2538c.d("Debug_MCursorUtil", new Object[]{"parseStatDatasCursor() Cursor query == null"});
            return null;
        }
        List<HiHealthData> arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            try {
                HiHealthData hiHealthData = new HiHealthData();
                hiHealthData.setDataID((long) cursor.getInt(cursor.getColumnIndex("_id")));
                long a = C4540b.m21751a(cursor.getInt(cursor.getColumnIndex("date")));
                hiHealthData.setStartTime(a);
                hiHealthData.setEndTime(a);
                hiHealthData.setType(cursor.getInt(cursor.getColumnIndex("stat_type")));
                hiHealthData.setValue(cursor.getDouble(cursor.getColumnIndex("value")));
                hiHealthData.setPointUnit(cursor.getInt(cursor.getColumnIndex("unit_id")));
                hiHealthData.setTimeZone(cursor.getString(cursor.getColumnIndex("timeZone")));
                hiHealthData.setDeviceUUID("-1");
                arrayList.add(hiHealthData);
            } finally {
                cursor.close();
            }
        }
        return arrayList;
    }

    public static List<HiHealthData> m23342d(Cursor cursor, String str) {
        if (cursor == null) {
            C2538c.d("Debug_MCursorUtil", new Object[]{"parseSessionCursor query == null"});
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

    public static List<HiHealthData> m23338a(Cursor cursor, String[] strArr) {
        if (cursor == null) {
            C2538c.d("Debug_MCursorUtil", new Object[]{"parseAggregateStatCursor() Cursor query == null"});
            return null;
        }
        List<HiHealthData> arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            try {
                HiHealthData hiHealthData = new HiHealthData();
                hiHealthData.setStartTime(C4540b.m21751a(cursor.getInt(cursor.getColumnIndex("date"))));
                hiHealthData.setType(cursor.getInt(cursor.getColumnIndex("stat_type")));
                hiHealthData.setTimeZone(cursor.getString(cursor.getColumnIndex("timeZone")));
                hiHealthData.putLong("modified_time", cursor.getLong(cursor.getColumnIndex("modified_time")));
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
}
