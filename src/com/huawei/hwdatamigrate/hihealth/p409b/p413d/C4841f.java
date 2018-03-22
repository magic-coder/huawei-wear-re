package com.huawei.hwdatamigrate.hihealth.p409b.p413d;

import android.database.Cursor;
import com.huawei.hihealth.HiHealthData;
import com.huawei.hihealth.p394c.C4545g;
import com.huawei.p190v.C2538c;
import com.sina.weibo.sdk.constant.WBConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ParseCursorUtil */
public class C4841f {
    public static List<HiHealthData> m23353a(Cursor cursor, String str) {
        if (cursor == null) {
            C2538c.d("Debug_ParseCursorUtil", new Object[]{"parsePointListWithDeviceUUID() Cursor query == null"});
            return null;
        }
        List<HiHealthData> arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            try {
                HiHealthData hiHealthData = new HiHealthData();
                hiHealthData.setDataID(cursor.getLong(cursor.getColumnIndex("_id")));
                hiHealthData.setStartTime(cursor.getLong(cursor.getColumnIndex("start_time")));
                hiHealthData.setEndTime(cursor.getLong(cursor.getColumnIndex("end_time")));
                hiHealthData.setType(cursor.getInt(cursor.getColumnIndex("type_id")));
                hiHealthData.setValue(cursor.getDouble(cursor.getColumnIndex("value")));
                hiHealthData.setMetaData(cursor.getString(cursor.getColumnIndex("metadata")));
                hiHealthData.setPointUnit(cursor.getInt(cursor.getColumnIndex("unit_id")));
                hiHealthData.setSyncStatus(cursor.getInt(cursor.getColumnIndex("sync_status")));
                hiHealthData.setDeviceUUID(str);
                hiHealthData.putInt("merged", cursor.getInt(cursor.getColumnIndex("merged")));
                hiHealthData.setTimeZone(cursor.getString(cursor.getColumnIndex("timeZone")));
                hiHealthData.setClientID(cursor.getInt(cursor.getColumnIndex(WBConstants.AUTH_PARAMS_CLIENT_ID)));
                arrayList.add(hiHealthData);
            } finally {
                cursor.close();
            }
        }
        return arrayList;
    }

    public static List<HiHealthData> m23352a(Cursor cursor) {
        if (cursor == null) {
            C2538c.d("Debug_ParseCursorUtil", new Object[]{"parseMergePointListWithClientIdAndMerged() Cursor query == null"});
            return null;
        }
        List<HiHealthData> arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            try {
                HiHealthData hiHealthData = new HiHealthData();
                hiHealthData.setDataID(cursor.getLong(cursor.getColumnIndex("_id")));
                hiHealthData.setStartTime(cursor.getLong(cursor.getColumnIndex("start_time")));
                hiHealthData.setEndTime(cursor.getLong(cursor.getColumnIndex("end_time")));
                hiHealthData.setType(cursor.getInt(cursor.getColumnIndex("type_id")));
                hiHealthData.setValue(cursor.getDouble(cursor.getColumnIndex("value")));
                hiHealthData.setMetaData(cursor.getString(cursor.getColumnIndex("metadata")));
                hiHealthData.setPointUnit(cursor.getInt(cursor.getColumnIndex("unit_id")));
                hiHealthData.setSyncStatus(cursor.getInt(cursor.getColumnIndex("sync_status")));
                hiHealthData.setClientID(cursor.getInt(cursor.getColumnIndex(WBConstants.AUTH_PARAMS_CLIENT_ID)));
                hiHealthData.putInt("merged", cursor.getInt(cursor.getColumnIndex("merged")));
                hiHealthData.setTimeZone(cursor.getString(cursor.getColumnIndex("timeZone")));
                arrayList.add(hiHealthData);
            } finally {
                cursor.close();
            }
        }
        return arrayList;
    }

    public static List<HiHealthData> m23356b(Cursor cursor) {
        if (cursor == null) {
            C2538c.d("Debug_ParseCursorUtil", new Object[]{"parseNoSyncPointList() Cursor query == null"});
            return null;
        }
        List<HiHealthData> arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            try {
                HiHealthData hiHealthData = new HiHealthData();
                hiHealthData.setDataID(cursor.getLong(cursor.getColumnIndex("_id")));
                hiHealthData.setStartTime(cursor.getLong(cursor.getColumnIndex("start_time")));
                hiHealthData.setEndTime(cursor.getLong(cursor.getColumnIndex("end_time")));
                hiHealthData.setType(cursor.getInt(cursor.getColumnIndex("type_id")));
                hiHealthData.setValue(cursor.getDouble(cursor.getColumnIndex("value")));
                hiHealthData.setMetaData(cursor.getString(cursor.getColumnIndex("metadata")));
                hiHealthData.setPointUnit(cursor.getInt(cursor.getColumnIndex("unit_id")));
                hiHealthData.setSyncStatus(cursor.getInt(cursor.getColumnIndex("sync_status")));
                hiHealthData.setTimeZone(cursor.getString(cursor.getColumnIndex("timeZone")));
                hiHealthData.setClientID(cursor.getInt(cursor.getColumnIndex(WBConstants.AUTH_PARAMS_CLIENT_ID)));
                hiHealthData.putLong("modified_time", cursor.getLong(cursor.getColumnIndex("modified_time")));
                arrayList.add(hiHealthData);
            } finally {
                cursor.close();
            }
        }
        return arrayList;
    }

    public static List<HiHealthData> m23355a(Cursor cursor, String[] strArr) {
        if (cursor == null) {
            C2538c.d("Debug_ParseCursorUtil", new Object[]{"parseRawSportCursor() Cursor query == null"});
            return null;
        }
        List<HiHealthData> arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            try {
                HiHealthData hiHealthData = new HiHealthData();
                hiHealthData.setDataID(cursor.getLong(cursor.getColumnIndex("_id")));
                hiHealthData.setStartTime(cursor.getLong(cursor.getColumnIndex("start_time")));
                hiHealthData.setEndTime(cursor.getLong(cursor.getColumnIndex("end_time")));
                hiHealthData.setType(cursor.getInt(cursor.getColumnIndex("type_id")));
                hiHealthData.setClientID(cursor.getInt(cursor.getColumnIndex(WBConstants.AUTH_PARAMS_CLIENT_ID)));
                hiHealthData.setMetaData(cursor.getString(cursor.getColumnIndex("metadata")));
                hiHealthData.setTimeZone(cursor.getString(cursor.getColumnIndex("timezone")));
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

    public static List<HiHealthData> m23358b(Cursor cursor, String[] strArr) {
        if (cursor == null) {
            C2538c.d("Debug_ParseCursorUtil", new Object[]{"parseAggregatePointCursor() Cursor query == null"});
            return null;
        }
        List<HiHealthData> arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            try {
                HiHealthData hiHealthData = new HiHealthData();
                hiHealthData.setStartTime(cursor.getLong(cursor.getColumnIndex("start_time")));
                hiHealthData.setEndTime(cursor.getLong(cursor.getColumnIndex("end_time")));
                hiHealthData.setType(cursor.getInt(cursor.getColumnIndex("type_id")));
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

    public static List<HiHealthData> m23361c(Cursor cursor, String[] strArr) {
        if (cursor == null) {
            C2538c.d("Debug_ParseCursorUtil", new Object[]{"parseAggregateHealthPointCursor() Cursor query == null"});
            return null;
        }
        List<HiHealthData> arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            try {
                HiHealthData hiHealthData = new HiHealthData();
                hiHealthData.setStartTime(cursor.getLong(cursor.getColumnIndex("start_time")));
                hiHealthData.setEndTime(cursor.getLong(cursor.getColumnIndex("end_time")));
                hiHealthData.setType(cursor.getInt(cursor.getColumnIndex("type_id")));
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

    public static List<HiHealthData> m23364d(Cursor cursor, String[] strArr) {
        if (cursor == null) {
            C2538c.d("Debug_ParseCursorUtil", new Object[]{"parseAggregateRawMixCursor() Cursor query == null"});
            return null;
        }
        List<HiHealthData> arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            try {
                HiHealthData hiHealthData = new HiHealthData();
                hiHealthData.setStartTime(cursor.getLong(cursor.getColumnIndex("start_time")));
                hiHealthData.setEndTime(cursor.getLong(cursor.getColumnIndex("end_time")));
                hiHealthData.setType(cursor.getInt(cursor.getColumnIndex("type_id")));
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

    public static List<HiHealthData> m23367e(Cursor cursor, String[] strArr) {
        if (cursor == null) {
            C2538c.d("Debug_ParseCursorUtil", new Object[]{"parseAggregateHealthSessionCursor() Cursor query == null"});
            return null;
        }
        List<HiHealthData> arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            try {
                HiHealthData hiHealthData = new HiHealthData();
                hiHealthData.setStartTime(cursor.getLong(cursor.getColumnIndex("start_time")));
                hiHealthData.setEndTime(cursor.getLong(cursor.getColumnIndex("end_time")));
                hiHealthData.setType(cursor.getInt(cursor.getColumnIndex("type_id")));
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

    public static List<HiHealthData> m23357b(Cursor cursor, String str) {
        if (cursor == null) {
            C2538c.d("Debug_ParseCursorUtil", new Object[]{"parseAggregateRawSessionCursor() Cursor query == null"});
            return null;
        }
        List<HiHealthData> arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            try {
                HiHealthData hiHealthData = new HiHealthData();
                hiHealthData.setStartTime(cursor.getLong(cursor.getColumnIndex("start_time")));
                hiHealthData.setEndTime(cursor.getLong(cursor.getColumnIndex("end_time")));
                hiHealthData.setType(cursor.getInt(cursor.getColumnIndex("type_id")));
                hiHealthData.putDouble(str, cursor.getDouble(cursor.getColumnIndex(str)));
                arrayList.add(hiHealthData);
            } finally {
                cursor.close();
            }
        }
        return arrayList;
    }

    public static List<HiHealthData> m23360c(Cursor cursor, String str) {
        if (cursor == null) {
            C2538c.d("Debug_ParseCursorUtil", new Object[]{"parseAggregateRawSessionCursor() Cursor query == null"});
            return null;
        }
        List<HiHealthData> arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            try {
                HiHealthData hiHealthData = new HiHealthData();
                hiHealthData.setStartTime(cursor.getLong(cursor.getColumnIndex("start_time")));
                hiHealthData.setEndTime(cursor.getLong(cursor.getColumnIndex("end_time")));
                hiHealthData.setType(cursor.getInt(cursor.getColumnIndex("type_id")));
                hiHealthData.putDouble(str, cursor.getDouble(cursor.getColumnIndex(str)));
                arrayList.add(hiHealthData);
            } finally {
                cursor.close();
            }
        }
        return arrayList;
    }

    public static List<HiHealthData> m23363d(Cursor cursor, String str) {
        if (cursor == null) {
            C2538c.d("Debug_ParseCursorUtil", new Object[]{"parseAggregateSessionChangeCountCursor() Cursor query == null"});
            return null;
        }
        List<HiHealthData> arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            try {
                HiHealthData hiHealthData = new HiHealthData();
                hiHealthData.putInt(str, cursor.getInt(cursor.getColumnIndex(str)));
                arrayList.add(hiHealthData);
            } finally {
                cursor.close();
            }
        }
        return arrayList;
    }

    public static List<HiHealthData> m23359c(Cursor cursor) {
        if (cursor == null) {
            C2538c.d("Debug_ParseCursorUtil", new Object[]{"parseSessionCursor query == null"});
            return null;
        }
        List<HiHealthData> arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            try {
                HiHealthData hiHealthData = new HiHealthData();
                hiHealthData.setDataID(cursor.getLong(cursor.getColumnIndex("_id")));
                hiHealthData.setStartTime(cursor.getLong(cursor.getColumnIndex("start_time")));
                hiHealthData.setEndTime(cursor.getLong(cursor.getColumnIndex("end_time")));
                hiHealthData.setType(cursor.getInt(cursor.getColumnIndex("type_id")));
                hiHealthData.setMetaData(cursor.getString(cursor.getColumnIndex("metadata")));
                hiHealthData.putInt("merged", cursor.getInt(cursor.getColumnIndex("merged")));
                hiHealthData.setSyncStatus(cursor.getInt(cursor.getColumnIndex("sync_status")));
                hiHealthData.setTimeZone(cursor.getString(cursor.getColumnIndex("timezone")));
                hiHealthData.setClientID(cursor.getInt(cursor.getColumnIndex(WBConstants.AUTH_PARAMS_CLIENT_ID)));
                hiHealthData.putLong("modified_time", cursor.getLong(cursor.getColumnIndex("modified_time")));
                arrayList.add(hiHealthData);
            } finally {
                cursor.close();
            }
        }
        return arrayList;
    }

    public static List<HiHealthData> m23362d(Cursor cursor) {
        if (cursor == null) {
            C2538c.d("Debug_ParseCursorUtil", new Object[]{"parseSessionCursor query == null"});
            return null;
        }
        List<HiHealthData> arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            try {
                HiHealthData hiHealthData = new HiHealthData();
                hiHealthData.setDataID(cursor.getLong(cursor.getColumnIndex("_id")));
                hiHealthData.setStartTime(cursor.getLong(cursor.getColumnIndex("start_time")));
                hiHealthData.setEndTime(cursor.getLong(cursor.getColumnIndex("end_time")));
                hiHealthData.setType(cursor.getInt(cursor.getColumnIndex("type_id")));
                hiHealthData.setMetaData(cursor.getString(cursor.getColumnIndex("metadata")));
                hiHealthData.putInt("merged", cursor.getInt(cursor.getColumnIndex("merged")));
                hiHealthData.setSyncStatus(cursor.getInt(cursor.getColumnIndex("sync_status")));
                hiHealthData.setTimeZone(cursor.getString(cursor.getColumnIndex("timezone")));
                hiHealthData.setClientID(cursor.getInt(cursor.getColumnIndex(WBConstants.AUTH_PARAMS_CLIENT_ID)));
                hiHealthData.putLong("modified_time", cursor.getLong(cursor.getColumnIndex("modified_time")));
                arrayList.add(hiHealthData);
            } finally {
                cursor.close();
            }
        }
        return arrayList;
    }

    public static List<HiHealthData> m23354a(Cursor cursor, boolean z) {
        if (cursor == null) {
            C2538c.d("Debug_ParseCursorUtil", new Object[]{"parseSequenceDatasCursor() Cursor query == null"});
            return null;
        }
        List<HiHealthData> arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            try {
                HiHealthData hiHealthData = new HiHealthData();
                hiHealthData.setDataID(cursor.getLong(cursor.getColumnIndex("_id")));
                hiHealthData.setStartTime(cursor.getLong(cursor.getColumnIndex("start_time")));
                hiHealthData.setEndTime(cursor.getLong(cursor.getColumnIndex("end_time")));
                hiHealthData.setType(cursor.getInt(cursor.getColumnIndex("type_id")));
                String string = cursor.getString(cursor.getColumnIndex("data"));
                if (z) {
                    hiHealthData.setSequenceData(C4545g.m21791b(string));
                } else {
                    hiHealthData.setSequenceData(string);
                }
                hiHealthData.setMetaData(cursor.getString(cursor.getColumnIndex("meta_data")));
                hiHealthData.setClientID(cursor.getInt(cursor.getColumnIndex(WBConstants.AUTH_PARAMS_CLIENT_ID)));
                hiHealthData.setSyncStatus(cursor.getInt(cursor.getColumnIndex("sync_status")));
                hiHealthData.putInt("merged", cursor.getInt(cursor.getColumnIndex("merged")));
                hiHealthData.setTimeZone(cursor.getString(cursor.getColumnIndex("timeZone")));
                hiHealthData.putLong("modified_time", cursor.getLong(cursor.getColumnIndex("modified_time")));
                arrayList.add(hiHealthData);
            } catch (IOException e) {
                C2538c.e("Debug_ParseCursorUtil", new Object[]{"parseSequenceDatasCursor() uncompress e = ", e.getMessage()});
            } catch (Throwable th) {
                cursor.close();
            }
        }
        cursor.close();
        return arrayList;
    }

    public static List<Integer> m23365e(Cursor cursor) {
        if (cursor == null) {
            C2538c.d("Debug_ParseCursorUtil", new Object[]{"getHiHealthClientList query is null "});
            return null;
        }
        List<Integer> arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            try {
                arrayList.add(Integer.valueOf(cursor.getInt(cursor.getColumnIndex("_id"))));
            } finally {
                cursor.close();
            }
        }
        return arrayList;
    }

    public static List<Integer> m23366e(Cursor cursor, String str) {
        if (cursor == null) {
            C2538c.d("Debug_ParseCursorUtil", new Object[]{"parseOneIntListCursor is null"});
            return null;
        }
        List<Integer> arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            try {
                arrayList.add(Integer.valueOf(cursor.getInt(cursor.getColumnIndex(str))));
            } finally {
                cursor.close();
            }
        }
        return arrayList;
    }

    public static boolean m23368f(Cursor cursor) {
        boolean z = false;
        if (cursor != null) {
            try {
                if (cursor.moveToNext()) {
                    z = true;
                }
                cursor.close();
            } catch (Throwable th) {
                cursor.close();
            }
        }
        return z;
    }
}
