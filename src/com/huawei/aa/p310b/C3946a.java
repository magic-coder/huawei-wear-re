package com.huawei.aa.p310b;

import android.content.ContentValues;
import android.database.Cursor;
import com.huawei.aa.a;
import com.huawei.p190v.C2538c;

/* compiled from: StressLastSyncTimeStoreDB */
public class C3946a {
    private String m19622a() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("_id integer primary key autoincrement,");
        stringBuffer.append("Device_ID NVARCHAR(300) not null,");
        stringBuffer.append("Time_Stamp integer not null");
        return String.valueOf(stringBuffer);
    }

    private String m19623b() {
        return "HWStressManagerDB";
    }

    public void m19625a(a aVar) {
        aVar.createStorageDataTable(m19623b(), 1, m19622a());
    }

    public ContentValues m19624a(long j, String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("Device_ID", str);
        contentValues.put("Time_Stamp", Long.valueOf(j));
        return contentValues;
    }

    private long m19621a(Cursor cursor) {
        return cursor.getLong(cursor.getColumnIndex("Time_Stamp"));
    }

    public long m19627b(a aVar) {
        long j = 0;
        Cursor queryStorageData = aVar.queryStorageData(m19623b(), 1, "Device_ID='" + aVar.c() + "'");
        if (queryStorageData == null) {
            C2538c.e("StressLastSyncTimeStoreDB", new Object[]{"getLastTimeStamp query error "});
        } else {
            if (queryStorageData.moveToNext()) {
                C2538c.b("StressLastSyncTimeStoreDB", new Object[]{"getLastTimeStamp cursor.moveToNext() is not null "});
                j = m19621a(queryStorageData);
            }
            queryStorageData.close();
            C2538c.b("StressLastSyncTimeStoreDB", new Object[]{"getLastTimeStamp = " + j});
        }
        return j;
    }

    public void m19626a(a aVar, long j) {
        String b = m19623b();
        Cursor queryStorageData = aVar.queryStorageData(b, 1, "Device_ID='" + aVar.c() + "'");
        if (queryStorageData == null) {
            C2538c.e("StressLastSyncTimeStoreDB", new Object[]{"setLastTimeStamp query error "});
            return;
        }
        if (queryStorageData.moveToNext()) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("Time_Stamp", Long.valueOf(j));
            aVar.updateStorageData(b, 1, contentValues, "Device_ID='" + aVar.c() + "'");
            C2538c.b("StressLastSyncTimeStoreDB", new Object[]{"setLastTimeStamp update "});
        } else {
            aVar.insertStorageData(b, 1, m19624a(j, aVar.c()));
            C2538c.b("StressLastSyncTimeStoreDB", new Object[]{"setLastTimeStamp new "});
        }
        queryStorageData.close();
    }
}
