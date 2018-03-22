package com.huawei.hwdatamigrate.hihealth.p409b.p413d;

import android.database.Cursor;
import com.huawei.hihealth.HiHealthData;
import com.huawei.p190v.C2538c;
import com.sina.weibo.sdk.constant.WBConstants;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ParseUtil */
public class C4842g {
    public static List<HiHealthData> m23371a(Cursor cursor, String[] strArr) {
        if (cursor == null) {
            C2538c.d("Debug_ParseUtil", new Object[]{"parseAggregateRawSequenceCursor() Cursor query == null"});
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

    public static List<String> m23370a(Cursor cursor) {
        if (cursor == null) {
            C2538c.d("Debug_ParseUtil", new Object[]{"parseSequenceMetaDataCursor() Cursor query == null"});
            return null;
        }
        List<String> arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            try {
                arrayList.add(cursor.getString(cursor.getColumnIndex("meta_data")));
            } finally {
                cursor.close();
            }
        }
        return arrayList;
    }

    public static List<HiHealthData> m23373b(Cursor cursor) {
        if (cursor == null) {
            C2538c.d("Debug_ParseUtil", new Object[]{"parseSequenceDatasCursor() Cursor query == null"});
            return null;
        }
        List<HiHealthData> arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            try {
                HiHealthData hiHealthData = new HiHealthData();
                hiHealthData.setStartTime(cursor.getLong(cursor.getColumnIndex("start_time")));
                hiHealthData.setEndTime(cursor.getLong(cursor.getColumnIndex("end_time")));
                hiHealthData.setType(cursor.getInt(cursor.getColumnIndex("type_id")));
                hiHealthData.setMetaData(cursor.getString(cursor.getColumnIndex("meta_data")));
                hiHealthData.setTimeZone(cursor.getString(cursor.getColumnIndex("timeZone")));
                hiHealthData.setSyncStatus(cursor.getInt(cursor.getColumnIndex("sync_status")));
                hiHealthData.putInt("merged", cursor.getInt(cursor.getColumnIndex("merged")));
                hiHealthData.setClientID(cursor.getInt(cursor.getColumnIndex(WBConstants.AUTH_PARAMS_CLIENT_ID)));
                arrayList.add(hiHealthData);
            } finally {
                cursor.close();
            }
        }
        return arrayList;
    }

    public static Double m23369a(Cursor cursor, String str) {
        Double d = null;
        if (cursor == null) {
            C2538c.d("Debug_ParseUtil", new Object[]{"parseOneDataValueCursor() Cursor query == null"});
        } else {
            try {
                if (cursor.moveToNext()) {
                    d = Double.valueOf(cursor.getDouble(cursor.getColumnIndex(str)));
                }
                cursor.close();
            } catch (Throwable th) {
                cursor.close();
            }
        }
        return d;
    }

    public static int m23372b(Cursor cursor, String str) {
        int i = 0;
        if (cursor == null) {
            C2538c.d("Debug_ParseUtil", new Object[]{"parseOneIntCursor is null"});
        } else {
            try {
                if (cursor.moveToNext()) {
                    i = cursor.getInt(cursor.getColumnIndex(str));
                }
                cursor.close();
            } catch (Throwable th) {
                cursor.close();
            }
        }
        return i;
    }
}
