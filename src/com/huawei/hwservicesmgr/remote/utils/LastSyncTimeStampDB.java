package com.huawei.hwservicesmgr.remote.utils;

import android.content.ContentValues;
import android.database.Cursor;
import com.huawei.hwservicesmgr.remote.HWExerciseAdviceManager;
import com.huawei.p190v.C2538c;

public class LastSyncTimeStampDB {
    private static final String Column_Device_ID = "Device_ID";
    private static final String Column_ID = "_id";
    private static final String Column_Time_Stamp = "Time_Stamp";
    private static final String TAG = "HWExerciseAdviceManagerDB";
    public static final String TableID = "HWExerciseAdviceManagerDB";

    private String getCreateSQLCmd() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("_id integer primary key autoincrement,");
        stringBuffer.append("Device_ID NVARCHAR(300) not null,");
        stringBuffer.append("Time_Stamp integer not null");
        return String.valueOf(stringBuffer);
    }

    private String getCurrDataTableID(HWExerciseAdviceManager hWExerciseAdviceManager) {
        return "HWExerciseAdviceManagerDB";
    }

    public void createDBTable(HWExerciseAdviceManager hWExerciseAdviceManager) {
        hWExerciseAdviceManager.createStorageDataTable(getCurrDataTableID(hWExerciseAdviceManager), 1, getCreateSQLCmd());
    }

    public ContentValues getContentValues(long j, String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Column_Device_ID, str);
        contentValues.put(Column_Time_Stamp, Long.valueOf(j));
        return contentValues;
    }

    private long getAndFillDataTable(Cursor cursor) {
        return cursor.getLong(cursor.getColumnIndex(Column_Time_Stamp));
    }

    public long getLastTimeStamp(HWExerciseAdviceManager hWExerciseAdviceManager) {
        long j = 0;
        Cursor queryStorageData = hWExerciseAdviceManager.queryStorageData(getCurrDataTableID(hWExerciseAdviceManager), 1, "Device_ID='" + hWExerciseAdviceManager.getCurrDeviceId() + "'");
        if (queryStorageData == null) {
            C2538c.e("HWExerciseAdviceManagerDB", new Object[]{"get lastTimeStamp query error "});
        } else {
            if (queryStorageData.moveToNext()) {
                C2538c.b("HWExerciseAdviceManagerDB", new Object[]{"getLastTimeStamp moveToNext() is not null "});
                j = getAndFillDataTable(queryStorageData);
            }
            queryStorageData.close();
            C2538c.b("HWExerciseAdviceManagerDB", new Object[]{"getLastTimeStamp = " + j});
        }
        return j;
    }

    public void setLastTimeStamp(HWExerciseAdviceManager hWExerciseAdviceManager, long j) {
        String currDataTableID = getCurrDataTableID(hWExerciseAdviceManager);
        Cursor queryStorageData = hWExerciseAdviceManager.queryStorageData(currDataTableID, 1, "Device_ID='" + hWExerciseAdviceManager.getCurrDeviceId() + "'");
        if (queryStorageData == null) {
            C2538c.e("HWExerciseAdviceManagerDB", new Object[]{"setLastTimeStamp query error "});
            return;
        }
        if (queryStorageData.moveToNext()) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(Column_Time_Stamp, Long.valueOf(j));
            hWExerciseAdviceManager.updateStorageData(currDataTableID, 1, contentValues, "Device_ID='" + hWExerciseAdviceManager.getCurrDeviceId() + "'");
            C2538c.b("HWExerciseAdviceManagerDB", new Object[]{"setLastTimeStamp update "});
        } else {
            hWExerciseAdviceManager.insertStorageData(currDataTableID, 1, getContentValues(j, hWExerciseAdviceManager.getCurrDeviceId()));
            C2538c.b("HWExerciseAdviceManagerDB", new Object[]{"setLastTimeStamp new "});
        }
        queryStorageData.close();
    }
}
