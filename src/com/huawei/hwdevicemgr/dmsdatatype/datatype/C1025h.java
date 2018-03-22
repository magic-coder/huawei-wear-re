package com.huawei.hwdevicemgr.dmsdatatype.datatype;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwdataaccessmodel.db.a;
import com.huawei.p190v.C2538c;

/* compiled from: DeviceDBUtil */
public class C1025h {
    public static void m4002a(boolean z) {
        C2538c.m12677c("DeviceDBUtil", "enter updateHasDeviceDBInfo with hasDevice = " + z);
        a.a(BaseApplication.m2632b(), String.valueOf(1000), "has_device_table", 2, "hasDeviceKey varchar primary key ,hasDeviceValue hasDeviceValue varchar");
        ContentValues contentValues = new ContentValues();
        contentValues.put("hasDeviceKey", "hasDeviceInfo");
        if (z) {
            contentValues.put("hasDeviceValue", String.valueOf(1));
        } else {
            contentValues.put("hasDeviceValue", String.valueOf(0));
        }
        if (C1025h.m4004b()) {
            a.a(BaseApplication.m2632b(), String.valueOf(1000), "has_device_table", 2, contentValues, null);
        } else {
            a.a(BaseApplication.m2632b(), String.valueOf(1000), "has_device_table", 2, contentValues);
        }
    }

    public static boolean m4003a() {
        C2538c.m12677c("DeviceDBUtil", "enter getHasDeviceDBInfo");
        C2538c.m12677c("DeviceDBUtil", "getHasDeviceDBInfo selection: " + "hasDeviceKey='hasDeviceInfo'");
        Cursor c = a.c(BaseApplication.m2632b(), String.valueOf(1000), "has_device_table", 2, "hasDeviceKey='hasDeviceInfo'");
        C2538c.m12677c("DeviceDBUtil", "start to get cursor.");
        Object obj = "";
        if (c != null) {
            if (c.moveToNext()) {
                obj = c.getString(c.getColumnIndex("hasDeviceValue"));
            }
            c.close();
            C2538c.m12677c("DeviceDBUtil", "content = " + obj);
            if (TextUtils.isEmpty(obj)) {
                return false;
            }
            try {
                boolean z;
                if (1 == Integer.parseInt(obj)) {
                    z = true;
                } else {
                    z = false;
                }
                return z;
            } catch (NumberFormatException e) {
                C2538c.m12677c("DeviceDBUtil", "NumberFormatException Error = " + e.getMessage());
                return false;
            }
        }
        C2538c.m12677c("DeviceDBUtil", "Query Storage Data fail.");
        return false;
    }

    private static boolean m4004b() {
        boolean z;
        C2538c.m12677c("DeviceDBUtil", "enter isHaveKeyInfo");
        Cursor c = a.c(BaseApplication.m2632b(), String.valueOf(1000), "has_device_table", 2, "hasDeviceKey='hasDeviceInfo'");
        if (c != null) {
            if (c.getCount() > 0) {
                z = true;
            } else {
                z = false;
            }
            c.close();
        } else {
            z = false;
        }
        C2538c.m12674b("DeviceDBUtil", "isHaveKeyInfo:", Boolean.valueOf(z));
        return z;
    }
}
