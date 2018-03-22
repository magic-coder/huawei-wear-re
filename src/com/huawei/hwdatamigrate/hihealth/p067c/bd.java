package com.huawei.hwdatamigrate.hihealth.p067c;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import com.huawei.hwcloudmodel.b.i;
import com.huawei.hwdatamigrate.hihealth.c.be;
import com.huawei.hwdatamigrate.hihealth.c.bf;
import com.huawei.nfc.carrera.logic.appletcardinfo.model.HciConfigInfo;
import com.huawei.p190v.C2538c;

import java.util.ArrayList;

/* compiled from: MigrateDB */
public class bd {
    public void m23498a(be beVar) {
        beVar.createStorageDataTable("migrate_acc_tab_s", 1, m23494a());
    }

    private String m23494a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("_id integer,");
        stringBuilder.append("originalhuid  NVARCHAR(500) ,");
        stringBuilder.append("originalst  NVARCHAR(500) ,");
        stringBuilder.append("tohuid  NVARCHAR(500) ,");
        stringBuilder.append("time  NVARCHAR(500) ,");
        stringBuilder.append("sendcommondfinished  NVARCHAR(500) ,");
        stringBuilder.append("cloudfinished  NVARCHAR(500) ,");
        stringBuilder.append("localfinished  NVARCHAR(500) ,");
        stringBuilder.append("noticefinished  NVARCHAR(500) ,");
        stringBuilder.append("data1  NVARCHAR(500) ,");
        stringBuilder.append("data2  NVARCHAR(500) ,");
        stringBuilder.append("primary key(originalhuid ,tohuid)");
        return String.valueOf(stringBuilder);
    }

    public long m23496a(be beVar, bf bfVar) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("originalhuid", bfVar.a());
            contentValues.put("originalst", bfVar.c());
            contentValues.put("tohuid", bfVar.b());
            contentValues.put(HciConfigInfo.HCI_DATA_TYPE_TRANSCTION_TIME, bfVar.d());
            contentValues.put("sendcommondfinished", bfVar.e() ? "true" : "false");
            contentValues.put("localfinished", bfVar.g() ? "true" : "false");
            contentValues.put("cloudfinished", bfVar.f() ? "true" : "false");
            contentValues.put("noticefinished", bfVar.h() ? "true" : "false");
            return beVar.insertStorageData("migrate_acc_tab_s", 1, contentValues);
        } catch (SQLiteException e) {
            C2538c.b("MigrateDB", new Object[]{"error1:", e.getMessage()});
            return -1;
        } catch (Exception e2) {
            C2538c.b("MigrateDB", new Object[]{"error:", e2.getMessage()});
            return -1;
        }
    }

    public int m23495a(be beVar, String str, String str2) {
        try {
            return beVar.deleteStorageData("migrate_acc_tab_s", 1, "originalhuid = " + str + " AND " + "tohuid" + " = " + str2);
        } catch (Exception e) {
            C2538c.b("MigrateDB", new Object[]{"error:", e.getMessage()});
            return -1;
        }
    }

    public int m23499b(be beVar, String str, String str2) {
        C2538c.c("MigrateDB", new Object[]{"Enter updateLocalTofinished"});
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("localfinished", "true");
            return beVar.updateStorageData("migrate_acc_tab_s", 1, contentValues, "originalhuid=" + str + " and " + "tohuid" + "=" + str2);
        } catch (Exception e) {
            C2538c.e("MigrateDB", new Object[]{"updateLocalTofinished error" + e.getMessage()});
            return -1;
        }
    }

    public int m23501c(be beVar, String str, String str2) {
        C2538c.c("MigrateDB", new Object[]{"Enter updateCloudTofinished"});
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("cloudfinished", "true");
            return beVar.updateStorageData("migrate_acc_tab_s", 1, contentValues, "originalhuid=" + str + " and " + "tohuid" + "=" + str2);
        } catch (Exception e) {
            C2538c.b("MigrateDB", new Object[]{"updateLocalTofinished error" + e.getMessage()});
            return -1;
        }
    }

    public boolean m23503d(be beVar, String str, String str2) {
        boolean z;
        Exception e;
        try {
            Cursor rawQueryStorageData = beVar.rawQueryStorageData(1, "SELECT  *  FROM " + beVar.getTableFullName("migrate_acc_tab_s") + " WHERE " + "tohuid" + " like ?  AND " + "originalhuid" + " like ? ", new String[]{str2, str});
            if (rawQueryStorageData == null) {
                return false;
            }
            if (rawQueryStorageData.getCount() > 0) {
                C2538c.b("MigrateDB", new Object[]{"isExist cursor.getCount():", Integer.valueOf(rawQueryStorageData.getCount())});
                z = true;
            } else {
                z = false;
            }
            try {
                rawQueryStorageData.close();
            } catch (Exception e2) {
                e = e2;
                C2538c.b("MigrateDB", new Object[]{"error:", e.getMessage()});
                return z;
            }
            return z;
        } catch (Exception e3) {
            e = e3;
            z = false;
            C2538c.b("MigrateDB", new Object[]{"error:", e.getMessage()});
            return z;
        }
    }

    public ArrayList<bf> m23497a(be beVar, String str) {
        ArrayList<bf> arrayList = new ArrayList();
        try {
            Cursor rawQueryStorageData = beVar.rawQueryStorageData(1, "SELECT  *  FROM " + beVar.getTableFullName("migrate_acc_tab_s") + " WHERE " + "tohuid" + " like ?  AND " + "localfinished" + " like ?  AND " + "cloudfinished" + " like ?  AND " + "noticefinished" + " like ? ", new String[]{str, "true", "true", "false"});
            if (rawQueryStorageData == null) {
                return null;
            }
            C2538c.b("MigrateDB", new Object[]{"fetchLocalToNotice cursor.getCount():", r1});
            C2538c.b("MigrateDB", new Object[]{"fetchLocalToNotice cursor.getCount():", Integer.valueOf(rawQueryStorageData.getCount())});
            while (rawQueryStorageData.moveToNext()) {
                bf bfVar = new bf();
                bfVar.a(rawQueryStorageData.getString(rawQueryStorageData.getColumnIndex("originalhuid")));
                bfVar.c(rawQueryStorageData.getString(rawQueryStorageData.getColumnIndex("originalst")));
                bfVar.b(rawQueryStorageData.getString(rawQueryStorageData.getColumnIndex("tohuid")));
                bfVar.d(rawQueryStorageData.getString(rawQueryStorageData.getColumnIndex(HciConfigInfo.HCI_DATA_TYPE_TRANSCTION_TIME)));
                if ("true".equals(rawQueryStorageData.getString(rawQueryStorageData.getColumnIndex("localfinished")))) {
                    bfVar.c(true);
                } else {
                    bfVar.c(false);
                }
                if ("true".equals(rawQueryStorageData.getString(rawQueryStorageData.getColumnIndex("sendcommondfinished")))) {
                    bfVar.a(true);
                } else {
                    bfVar.a(false);
                }
                if ("true".equals(rawQueryStorageData.getString(rawQueryStorageData.getColumnIndex("cloudfinished")))) {
                    bfVar.b(true);
                } else {
                    bfVar.b(false);
                }
                if ("true".equals(rawQueryStorageData.getString(rawQueryStorageData.getColumnIndex("noticefinished")))) {
                    bfVar.d(true);
                } else {
                    bfVar.d(false);
                }
                bfVar.d(rawQueryStorageData.getString(rawQueryStorageData.getColumnIndex(HciConfigInfo.HCI_DATA_TYPE_TRANSCTION_TIME)));
                C2538c.b("MigrateDB", new Object[]{"fetchLocalToNotice migrateTable:", bfVar.toString()});
                arrayList.add(bfVar);
            }
            rawQueryStorageData.close();
            return arrayList;
        } catch (RuntimeException e) {
            C2538c.b("MigrateDB", new Object[]{"RuntimeException:", e.getMessage()});
            return arrayList;
        } catch (Exception e2) {
            C2538c.b("MigrateDB", new Object[]{"Exception:", e2.getMessage()});
            return arrayList;
        }
    }

    public ArrayList<bf> m23500b(be beVar, String str) {
        ArrayList<bf> arrayList = new ArrayList();
        try {
            Cursor rawQueryStorageData = beVar.rawQueryStorageData(1, "SELECT  *  FROM " + beVar.getTableFullName("migrate_acc_tab_s") + " WHERE " + "tohuid" + " like ?  AND " + "localfinished" + " like ? ", new String[]{str, "false"});
            if (rawQueryStorageData == null) {
                return null;
            }
            C2538c.b("MigrateDB", new Object[]{"fetchLocalToMigrate cursor.getCount():", r1});
            C2538c.b("MigrateDB", new Object[]{"fetchLocalToMigrate cursor.getCount():", Integer.valueOf(rawQueryStorageData.getCount())});
            while (rawQueryStorageData.moveToNext()) {
                bf bfVar = new bf();
                bfVar.a(rawQueryStorageData.getString(rawQueryStorageData.getColumnIndex("originalhuid")));
                bfVar.c(rawQueryStorageData.getString(rawQueryStorageData.getColumnIndex("originalst")));
                bfVar.b(rawQueryStorageData.getString(rawQueryStorageData.getColumnIndex("tohuid")));
                bfVar.d(rawQueryStorageData.getString(rawQueryStorageData.getColumnIndex(HciConfigInfo.HCI_DATA_TYPE_TRANSCTION_TIME)));
                if ("true".equals(rawQueryStorageData.getString(rawQueryStorageData.getColumnIndex("sendcommondfinished")))) {
                    bfVar.a(true);
                } else {
                    bfVar.a(false);
                }
                if ("true".equals(rawQueryStorageData.getString(rawQueryStorageData.getColumnIndex("localfinished")))) {
                    bfVar.c(true);
                } else {
                    bfVar.c(false);
                }
                if ("true".equals(rawQueryStorageData.getString(rawQueryStorageData.getColumnIndex("cloudfinished")))) {
                    bfVar.b(true);
                } else {
                    bfVar.b(false);
                }
                if ("true".equals(rawQueryStorageData.getString(rawQueryStorageData.getColumnIndex("noticefinished")))) {
                    bfVar.d(true);
                } else {
                    bfVar.d(false);
                }
                bfVar.d(rawQueryStorageData.getString(rawQueryStorageData.getColumnIndex(HciConfigInfo.HCI_DATA_TYPE_TRANSCTION_TIME)));
                C2538c.b("MigrateDB", new Object[]{"fetchLocalToMigrate migrateTable:", bfVar.toString()});
                arrayList.add(bfVar);
            }
            rawQueryStorageData.close();
            return arrayList;
        } catch (RuntimeException e) {
            C2538c.b("MigrateDB", new Object[]{"RuntimeException:", e.getMessage()});
            return arrayList;
        } catch (Exception e2) {
            C2538c.b("MigrateDB", new Object[]{"Exception:", e2.getMessage()});
            return arrayList;
        }
    }

    public ArrayList<bf> m23502c(be beVar, String str) {
        ArrayList<bf> arrayList = new ArrayList();
        try {
            Cursor rawQueryStorageData = beVar.rawQueryStorageData(1, "SELECT  *  FROM " + beVar.getTableFullName("migrate_acc_tab_s") + " WHERE " + "tohuid" + " = ?", new String[]{str});
            if (rawQueryStorageData == null) {
                return null;
            }
            C2538c.c("MigrateDB", new Object[]{"fetch cursor.getCount():", Integer.valueOf(rawQueryStorageData.getCount())});
            while (rawQueryStorageData.moveToNext()) {
                bf bfVar = new bf();
                bfVar.a(rawQueryStorageData.getString(rawQueryStorageData.getColumnIndex("originalhuid")));
                bfVar.c(rawQueryStorageData.getString(rawQueryStorageData.getColumnIndex("originalst")));
                bfVar.b(rawQueryStorageData.getString(rawQueryStorageData.getColumnIndex("tohuid")));
                bfVar.d(rawQueryStorageData.getString(rawQueryStorageData.getColumnIndex(HciConfigInfo.HCI_DATA_TYPE_TRANSCTION_TIME)));
                if ("true".equals(rawQueryStorageData.getString(rawQueryStorageData.getColumnIndex("sendcommondfinished")))) {
                    bfVar.a(true);
                } else {
                    bfVar.a(false);
                }
                if (!i.a(57)) {
                    bfVar.b(true);
                } else if ("true".equals(rawQueryStorageData.getString(rawQueryStorageData.getColumnIndex("cloudfinished")))) {
                    bfVar.b(true);
                } else {
                    bfVar.b(false);
                }
                if ("true".equals(rawQueryStorageData.getString(rawQueryStorageData.getColumnIndex("localfinished")))) {
                    bfVar.c(true);
                } else {
                    bfVar.c(false);
                }
                if ("true".equals(rawQueryStorageData.getString(rawQueryStorageData.getColumnIndex("noticefinished")))) {
                    bfVar.d(true);
                } else {
                    bfVar.d(false);
                }
                C2538c.b("MigrateDB", new Object[]{"fetch migrateTable:", bfVar.toString()});
                arrayList.add(bfVar);
            }
            rawQueryStorageData.close();
            return arrayList;
        } catch (Exception e) {
            C2538c.b("MigrateDB", new Object[]{"error:", e.getMessage()});
            return arrayList;
        }
    }
}
