package com.huawei.p192w;

import android.content.ContentValues;
import android.database.Cursor;
import com.huawei.p190v.C2538c;
import com.huawei.w.c;

/* compiled from: HWMultiSimAuthDB */
public class C6138a {
    private String m27946a() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("_id integer primary key autoincrement,");
        stringBuffer.append("Package_Name NVARCHAR(300) not null,");
        stringBuffer.append("Device_ID NVARCHAR(300) not null");
        return String.valueOf(stringBuffer);
    }

    public void m27947a(c cVar) {
        cVar.createStorageDataTable("HWMultiSimAuthDB", 1, m27946a());
    }

    private ContentValues m27945a(String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("Package_Name", str);
        contentValues.put("Device_ID", str2);
        return contentValues;
    }

    public void m27948a(c cVar, String str, String str2) {
        C2538c.c("HWMultiSimAuthDB", new Object[]{"updateAuthStatus enter"});
        ContentValues a = m27945a(str, str2);
        Cursor queryStorageData = cVar.queryStorageData("HWMultiSimAuthDB", 1, "Package_Name='" + str + "' AND " + "Device_ID" + "='" + str2 + "'");
        if (queryStorageData == null) {
            C2538c.e("HWMultiSimAuthDB", new Object[]{"updateAuthStatus query DB failure"});
            return;
        }
        if (queryStorageData.moveToFirst()) {
            cVar.updateStorageData("HWMultiSimAuthDB", 1, a, "Package_Name='" + str + "' AND " + "Device_ID" + "='" + str2 + "'");
        } else {
            cVar.insertStorageData("HWMultiSimAuthDB", 1, a);
        }
        queryStorageData.close();
    }

    public boolean m27949b(c cVar, String str, String str2) {
        boolean z = true;
        Cursor queryStorageData = cVar.queryStorageData("HWMultiSimAuthDB", 1, "Package_Name='" + str + "' AND " + "Device_ID" + "='" + str2 + "'");
        if (queryStorageData == null) {
            C2538c.e("HWMultiSimAuthDB", new Object[]{"getAuthStatus query DB failure"});
            return false;
        }
        if (!queryStorageData.moveToFirst()) {
            z = false;
        }
        queryStorageData.close();
        return z;
    }
}
