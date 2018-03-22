package com.huawei.p192w;

import android.content.ContentValues;
import android.database.Cursor;
import com.huawei.multisimservice.model.MultiSimDeviceInfo;
import com.huawei.p190v.C2538c;
import com.huawei.w.c;

/* compiled from: HWMultiSimBindStatusDB */
public class C6139b {
    private String m27951a() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("_id integer primary key autoincrement,");
        stringBuffer.append("Primary_Num NVARCHAR(300) not null,");
        stringBuffer.append("Paired_SN NVARCHAR(300),");
        stringBuffer.append("Paired_IMSI NVARCHAR(300) not null,");
        stringBuffer.append("Paired_IMEI NVARCHAR(300) not null,");
        stringBuffer.append("Paired_Num NVARCHAR(300) ,");
        stringBuffer.append("Reservered NVARCHAR(300) ,");
        stringBuffer.append("Bind_Status integer not null");
        return String.valueOf(stringBuffer);
    }

    public void m27953a(c cVar) {
        cVar.createStorageDataTable("HWMultiSimBindStatusDB", 1, m27951a());
    }

    private ContentValues m27950a(String str, int i, String str2, MultiSimDeviceInfo multiSimDeviceInfo) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("Primary_Num", str);
        contentValues.put("Paired_SN", multiSimDeviceInfo.getDeviceSerialNumber());
        contentValues.put("Paired_IMSI", multiSimDeviceInfo.getActiveSimProfileInfo().getIMSI());
        contentValues.put("Paired_IMEI", multiSimDeviceInfo.getDeviceIMEI());
        contentValues.put("Paired_Num", str2);
        contentValues.put("Bind_Status", Integer.valueOf(i));
        return contentValues;
    }

    public void m27955a(c cVar, String str, String str2, MultiSimDeviceInfo multiSimDeviceInfo) {
        C2538c.c("HWMultiSimBindStatusDB", new Object[]{"deleteBindStatus enter"});
        cVar.deleteStorageData("HWMultiSimBindStatusDB", 1, "( Paired_IMEI='" + multiSimDeviceInfo.getDeviceIMEI() + "'  AND " + "Paired_IMSI" + "='" + cVar.n() + "' )");
    }

    public void m27954a(c cVar, String str, int i, String str2, MultiSimDeviceInfo multiSimDeviceInfo) {
        C2538c.c("HWMultiSimBindStatusDB", new Object[]{"updateBindStatus enter"});
        if (i != 1) {
            C2538c.c("HWMultiSimBindStatusDB", new Object[]{"status bind =", Integer.valueOf(i)});
            m27955a(cVar, str, str2, multiSimDeviceInfo);
            return;
        }
        C2538c.c("HWMultiSimBindStatusDB", new Object[]{"updateBindStatus enter insert"});
        ContentValues a = m27950a(str, i, str2, multiSimDeviceInfo);
        Cursor queryStorageData = cVar.queryStorageData("HWMultiSimBindStatusDB", 1, "( Paired_IMEI='" + multiSimDeviceInfo.getDeviceIMEI() + "'  AND " + "Paired_IMSI" + "='" + cVar.n() + "' )");
        if (queryStorageData == null) {
            C2538c.e("HWMultiSimBindStatusDB", new Object[]{"updateBindStatus query DB failure"});
            return;
        }
        if (queryStorageData.moveToFirst()) {
            cVar.updateStorageData("HWMultiSimBindStatusDB", 1, a, "Paired_IMEI='" + multiSimDeviceInfo.getDeviceIMEI() + "'");
        } else {
            cVar.insertStorageData("HWMultiSimBindStatusDB", 1, a);
        }
        queryStorageData.close();
    }

    public int m27952a(c cVar, MultiSimDeviceInfo multiSimDeviceInfo) {
        int i = 0;
        Cursor queryStorageData = cVar.queryStorageData("HWMultiSimBindStatusDB", 1, "( Paired_IMEI='" + multiSimDeviceInfo.getDeviceIMEI() + "'  AND " + "Paired_IMSI" + "='" + cVar.n() + "' )");
        if (queryStorageData == null) {
            C2538c.e("HWMultiSimBindStatusDB", new Object[]{"getBindStatus query DB failure"});
        } else {
            if (queryStorageData.moveToFirst()) {
                i = queryStorageData.getInt(queryStorageData.getColumnIndex("Bind_Status"));
            }
            queryStorageData.close();
        }
        return i;
    }

    public String m27956b(c cVar, MultiSimDeviceInfo multiSimDeviceInfo) {
        String str = "";
        Cursor queryStorageData = cVar.queryStorageData("HWMultiSimBindStatusDB", 1, "( Paired_IMEI='" + multiSimDeviceInfo.getDeviceIMEI() + "'  AND " + "Paired_IMSI" + "='" + cVar.n() + "' )");
        if (queryStorageData == null) {
            C2538c.e("HWMultiSimBindStatusDB", new Object[]{"getPhoneNum query DB failure"});
        } else {
            if (queryStorageData.moveToFirst()) {
                str = queryStorageData.getString(queryStorageData.getColumnIndex("Primary_Num"));
            }
            queryStorageData.close();
        }
        return str;
    }

    public String m27957c(c cVar, MultiSimDeviceInfo multiSimDeviceInfo) {
        String str = "";
        Cursor queryStorageData = cVar.queryStorageData("HWMultiSimBindStatusDB", 1, "( Paired_IMEI='" + multiSimDeviceInfo.getDeviceIMEI() + "'  AND " + "Paired_IMSI" + "='" + cVar.n() + "' )");
        if (queryStorageData == null) {
            C2538c.e("HWMultiSimBindStatusDB", new Object[]{"getPairedNum query DB failure"});
        } else {
            if (queryStorageData.moveToFirst()) {
                str = queryStorageData.getString(queryStorageData.getColumnIndex("Paired_Num"));
            }
            queryStorageData.close();
        }
        return str;
    }
}
