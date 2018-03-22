package com.huawei.hwdatamigrate.hihealth.p409b.p413d;

import android.database.Cursor;
import com.huawei.hihealth.HiAppInfo;
import com.huawei.hihealth.HiDeviceInfo;
import com.huawei.hwdatamigrate.hihealth.d.g;
import com.huawei.hwdatamigrate.hihealth.p409b.p411b.C4807a;
import com.huawei.nfc.PluginPayAdapter;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.huawei.nfc.carrera.storage.db.DataModel.ReportCardInfo;
import com.huawei.p190v.C2538c;
import com.unionpay.tsmservice.data.Constant;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MParseUtil */
public class C4840e {
    public static C4807a m23343a(Cursor cursor) {
        C4807a c4807a = null;
        if (cursor == null) {
            C2538c.d("Debug_ParseUtil", new Object[]{"parseOneStatCursor() Cursor query == null"});
        } else {
            try {
                if (cursor.moveToNext()) {
                    c4807a = new C4807a();
                    c4807a.m23027a(cursor.getInt(cursor.getColumnIndex("date")));
                    c4807a.m23031b(cursor.getInt(cursor.getColumnIndex("hihealth_type")));
                    c4807a.m23034c(cursor.getInt(cursor.getColumnIndex("stat_type")));
                    c4807a.m23026a(cursor.getDouble(cursor.getColumnIndex("value")));
                    c4807a.m23040f(cursor.getInt(cursor.getColumnIndex("unit_id")));
                    c4807a.m23029a(cursor.getString(cursor.getColumnIndex("timeZone")));
                    c4807a.m23032b(cursor.getLong(cursor.getColumnIndex("modified_time")));
                }
                cursor.close();
            } catch (Throwable th) {
                cursor.close();
            }
        }
        return c4807a;
    }

    public static List<Integer> m23346b(Cursor cursor) {
        if (cursor == null) {
            C2538c.d("Debug_ParseUtil", new Object[]{"parseStatCursorDays() Cursor query == null"});
            return null;
        }
        List<Integer> arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            try {
                arrayList.add(Integer.valueOf(cursor.getInt(cursor.getColumnIndex("date"))));
            } finally {
                cursor.close();
            }
        }
        return arrayList;
    }

    public static HiAppInfo m23347c(Cursor cursor) {
        HiAppInfo hiAppInfo = null;
        if (cursor == null) {
            C2538c.d("Debug_ParseUtil", new Object[]{"parseAppInfoCursor query is null "});
        } else {
            try {
                if (cursor.moveToNext()) {
                    hiAppInfo = new HiAppInfo();
                    hiAppInfo.setAppID(cursor.getInt(cursor.getColumnIndex("_id")));
                    hiAppInfo.setPackageName(cursor.getString(cursor.getColumnIndex(SNBConstant.FIELD_PKG)));
                    hiAppInfo.setAppName(cursor.getString(cursor.getColumnIndex("app_name")));
                    hiAppInfo.setVersion(cursor.getString(cursor.getColumnIndex("version")));
                    hiAppInfo.setSignature(cursor.getString(cursor.getColumnIndex(Constant.KEY_SIGNATURE)));
                }
                cursor.close();
            } catch (Throwable th) {
                cursor.close();
            }
        }
        return hiAppInfo;
    }

    public static HiDeviceInfo m23348d(Cursor cursor) {
        HiDeviceInfo hiDeviceInfo = null;
        if (cursor == null) {
            C2538c.d("Debug_ParseUtil", new Object[]{"parseDeviceInfoCursor query is null "});
        } else {
            try {
                if (cursor.moveToNext()) {
                    hiDeviceInfo = new HiDeviceInfo();
                    hiDeviceInfo.setDeviceID(cursor.getInt(cursor.getColumnIndex("_id")));
                    hiDeviceInfo.setDeviceUniqueCode(cursor.getString(cursor.getColumnIndex("device_unique_code")));
                    hiDeviceInfo.setDeviceName(cursor.getString(cursor.getColumnIndex("deviceName")));
                    hiDeviceInfo.setDeviceType(cursor.getInt(cursor.getColumnIndex("device_type")));
                    hiDeviceInfo.setFirmwareVersion(cursor.getString(cursor.getColumnIndex("firmwareVersion")));
                    hiDeviceInfo.setHardwareVersion(cursor.getString(cursor.getColumnIndex("hardwareVersion")));
                    hiDeviceInfo.setSoftwareVersion(cursor.getString(cursor.getColumnIndex("softwareVersion")));
                    hiDeviceInfo.setManufacturer(cursor.getString(cursor.getColumnIndex("manufacturer")));
                    hiDeviceInfo.setModel(cursor.getString(cursor.getColumnIndex("model")));
                    hiDeviceInfo.setDeviceSN(cursor.getString(cursor.getColumnIndex(PluginPayAdapter.KEY_DEVICE_INFO_SN)));
                    hiDeviceInfo.setDeviceMac(cursor.getString(cursor.getColumnIndex("device_mac")));
                }
                cursor.close();
            } catch (Throwable th) {
                cursor.close();
            }
        }
        return hiDeviceInfo;
    }

    public static List<HiDeviceInfo> m23349e(Cursor cursor) {
        if (cursor == null) {
            C2538c.d("Debug_ParseUtil", new Object[]{"parseDeviceInfoListCursor query is null "});
            return null;
        }
        List<HiDeviceInfo> arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            try {
                HiDeviceInfo hiDeviceInfo = new HiDeviceInfo();
                hiDeviceInfo.setDeviceID(cursor.getInt(cursor.getColumnIndex("_id")));
                hiDeviceInfo.setDeviceUniqueCode(cursor.getString(cursor.getColumnIndex("device_unique_code")));
                hiDeviceInfo.setDeviceName(cursor.getString(cursor.getColumnIndex("deviceName")));
                hiDeviceInfo.setDeviceType(cursor.getInt(cursor.getColumnIndex("device_type")));
                hiDeviceInfo.setFirmwareVersion(cursor.getString(cursor.getColumnIndex("firmwareVersion")));
                hiDeviceInfo.setHardwareVersion(cursor.getString(cursor.getColumnIndex("hardwareVersion")));
                hiDeviceInfo.setSoftwareVersion(cursor.getString(cursor.getColumnIndex("softwareVersion")));
                hiDeviceInfo.setManufacturer(cursor.getString(cursor.getColumnIndex("manufacturer")));
                hiDeviceInfo.setModel(cursor.getString(cursor.getColumnIndex("model")));
                hiDeviceInfo.setDeviceSN(cursor.getString(cursor.getColumnIndex(PluginPayAdapter.KEY_DEVICE_INFO_SN)));
                hiDeviceInfo.setDeviceMac(cursor.getString(cursor.getColumnIndex("device_mac")));
                arrayList.add(hiDeviceInfo);
            } finally {
                cursor.close();
            }
        }
        return arrayList;
    }

    public static List<g> m23350f(Cursor cursor) {
        if (cursor == null) {
            C2538c.d("Debug_ParseUtil", new Object[]{"getHiHealthClientList query is null "});
            return null;
        }
        List<g> arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            try {
                g gVar = new g();
                gVar.b(cursor.getInt(cursor.getColumnIndex("_id")));
                gVar.e(cursor.getInt(cursor.getColumnIndex(ReportCardInfo.COLUMN_NAME_CARD_USERID)));
                gVar.c(cursor.getInt(cursor.getColumnIndex("app_id")));
                gVar.d(cursor.getInt(cursor.getColumnIndex(SNBConstant.FIELD_DEVICE_ID)));
                gVar.a(cursor.getInt(cursor.getColumnIndex("sync_status")));
                gVar.a(cursor.getLong(cursor.getColumnIndex("cloud_device")));
                arrayList.add(gVar);
            } finally {
                cursor.close();
            }
        }
        return arrayList;
    }

    public static g m23351g(Cursor cursor) {
        g gVar = null;
        if (cursor == null) {
            C2538c.d("Debug_ParseUtil", new Object[]{"parseClientCursor query is null "});
        } else {
            try {
                if (cursor.moveToNext()) {
                    gVar = new g();
                    gVar.b(cursor.getInt(cursor.getColumnIndex("_id")));
                    gVar.e(cursor.getInt(cursor.getColumnIndex(ReportCardInfo.COLUMN_NAME_CARD_USERID)));
                    gVar.c(cursor.getInt(cursor.getColumnIndex("app_id")));
                    gVar.d(cursor.getInt(cursor.getColumnIndex(SNBConstant.FIELD_DEVICE_ID)));
                    gVar.a(cursor.getLong(cursor.getColumnIndex("cloud_device")));
                    gVar.a(cursor.getInt(cursor.getColumnIndex("sync_status")));
                }
                cursor.close();
            } catch (Throwable th) {
                cursor.close();
            }
        }
        return gVar;
    }

    public static String m23344a(Cursor cursor, String str) {
        String str2 = null;
        if (cursor == null) {
            C2538c.d("Debug_ParseUtil", new Object[]{"parseOneStringCursor is null"});
        } else {
            try {
                if (cursor.moveToNext()) {
                    str2 = cursor.getString(cursor.getColumnIndex(str));
                }
                cursor.close();
            } catch (Throwable th) {
                cursor.close();
            }
        }
        return str2;
    }

    public static long m23345b(Cursor cursor, String str) {
        long j = 0;
        if (cursor == null) {
            C2538c.d("Debug_ParseUtil", new Object[]{"parseOneStringCursor is null"});
        } else {
            try {
                if (cursor.moveToNext()) {
                    j = cursor.getLong(cursor.getColumnIndex(str));
                }
                cursor.close();
            } catch (Throwable th) {
                cursor.close();
            }
        }
        return j;
    }
}
