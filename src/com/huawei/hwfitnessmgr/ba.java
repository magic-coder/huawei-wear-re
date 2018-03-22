package com.huawei.hwfitnessmgr;

import android.content.ContentValues;
import android.database.Cursor;
import com.huawei.al.C4028a;
import com.huawei.hwfitnessmgr.p421a.p422a.C5009a;
import com.huawei.p190v.C2538c;

/* compiled from: LastTotalValueDB */
public class ba {
    private String m24105a() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("_id integer primary key autoincrement,");
        stringBuffer.append("User_ID NVARCHAR(300) not null,");
        stringBuffer.append("Device_ID NVARCHAR(300) not null,");
        stringBuffer.append("LastTotalSteps integer not null,");
        stringBuffer.append("LastTotalCalories integer not null,");
        stringBuffer.append("LastTotalDistance integer not null,");
        stringBuffer.append("Time_Stamp integer not null");
        return String.valueOf(stringBuffer);
    }

    private String m24106d(q qVar) {
        return "LastTotalValueDB";
    }

    public void m24109a(q qVar) {
        qVar.createStorageDataTable(m24106d(qVar), 1, m24105a());
    }

    public ContentValues m24108a(C5009a c5009a, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("User_ID", str);
        contentValues.put("Device_ID", str2);
        contentValues.put("LastTotalSteps", Integer.valueOf(c5009a.m24060a()));
        contentValues.put("LastTotalCalories", Integer.valueOf(c5009a.m24063b()));
        contentValues.put("LastTotalDistance", Integer.valueOf(c5009a.m24065c()));
        contentValues.put("Time_Stamp", Long.valueOf(c5009a.m24067d()));
        return contentValues;
    }

    private C5009a m24104a(Cursor cursor) {
        C5009a c5009a = new C5009a();
        c5009a.m24061a(cursor.getInt(cursor.getColumnIndex("LastTotalSteps")));
        c5009a.m24066c(cursor.getInt(cursor.getColumnIndex("LastTotalCalories")));
        c5009a.m24069e(cursor.getInt(cursor.getColumnIndex("LastTotalDistance")));
        c5009a.m24062a((long) cursor.getInt(cursor.getColumnIndex("Time_Stamp")));
        return c5009a;
    }

    private String m24107e(q qVar) {
        String str = "";
        return "( Device_ID='" + C4028a.m19823a() + "' AND " + "User_ID" + "='" + q.g() + "' )";
    }

    public C5009a m24111b(q qVar) {
        C5009a c5009a = new C5009a();
        Cursor queryStorageData = qVar.queryStorageData(m24106d(qVar), 1, m24107e(qVar));
        if (queryStorageData == null) {
            C2538c.e("LastTotalValueDB", new Object[]{"getLastTotalCalories query error "});
        } else {
            if (queryStorageData.moveToNext()) {
                c5009a = m24104a(queryStorageData);
            }
            queryStorageData.close();
            C2538c.a("05", 1, "LastTotalValueDB", new Object[]{"getTotalValue :" + c5009a});
        }
        return c5009a;
    }

    public long m24112c(q qVar) {
        long j = 0;
        C5009a b = m24111b(qVar);
        if (b != null) {
            j = b.m24067d();
        }
        C2538c.a("05", 1, "LastTotalValueDB", new Object[]{"getLastTimeStamp timeStamp=" + j});
        return j;
    }

    public void m24110a(q qVar, C5009a c5009a) {
        ContentValues a = m24108a(c5009a, q.g(), C4028a.m19823a());
        String d = m24106d(qVar);
        C2538c.a("05", 1, "LastTotalValueDB", new Object[]{"setLastTotalValue total=", c5009a});
        Cursor queryStorageData = qVar.queryStorageData(d, 1, m24107e(qVar));
        if (queryStorageData == null) {
            C2538c.e("LastTotalValueDB", new Object[]{"setLastTimeStamp query error "});
            return;
        }
        if (queryStorageData.moveToNext()) {
            qVar.updateStorageData(d, 1, a, m24107e(qVar));
        } else {
            qVar.insertStorageData(d, 1, a);
        }
        queryStorageData.close();
    }
}
