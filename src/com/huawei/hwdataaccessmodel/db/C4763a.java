package com.huawei.hwdataaccessmodel.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.huawei.crowdtestsdk.db.DBConstants;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwdataaccessmodel.db.contentprovider.a;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.p190v.C2538c;

/* compiled from: DBManager */
public class C4763a {
    public static final String f17349a = (DBConstants.SCHEME + BaseApplication.c().a() + ".data.access.provider" + "/");

    public static int m22759a(Context context, String str, String str2, int i, String str3) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("create table IF NOT EXISTS ");
        stringBuffer.append("module_" + str + HwAccountConstants.SPLIIT_UNDERLINE + str2 + "(");
        stringBuffer.append(str3);
        stringBuffer.append(")");
        if (1 == i) {
            try {
                if (C4764b.m22772a(context, str).m22774b() != null) {
                    C4764b.m22772a(context, str).m22774b().execSQL(String.valueOf(stringBuffer));
                }
            } catch (Exception e) {
                C2538c.e("DBManager", new Object[]{"createStorageDataTable() failed. ", e.getMessage()});
            }
        } else {
            a.a(context).a(String.valueOf(stringBuffer));
        }
        return 0;
    }

    public static int m22756a(Context context, String str, String str2, int i) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("DROP TABLE IF EXISTS ");
        stringBuffer.append("module_" + str + HwAccountConstants.SPLIIT_UNDERLINE + str2);
        if (1 == i) {
            try {
                if (C4764b.m22772a(context, str).m22774b() != null) {
                    C4764b.m22772a(context, str).m22774b().execSQL(String.valueOf(stringBuffer));
                }
            } catch (Exception e) {
                C2538c.e("DBManager", new Object[]{"deleteStorageDataTable() failed. ", e.getMessage()});
            }
        } else {
            a.a(context).a(String.valueOf(stringBuffer));
        }
        return 0;
    }

    public static long m22761a(Context context, String str, String str2, int i, ContentValues contentValues) {
        if (1 == i) {
            try {
                C4764b.m22772a(context, str).m22775c();
                if (C4764b.m22772a(context, str).m22774b() != null) {
                    return C4764b.m22772a(context, str).m22774b().insert("module_" + str + HwAccountConstants.SPLIIT_UNDERLINE + str2, null, contentValues);
                }
                return 0;
            } catch (Exception e) {
                C2538c.e("DBManager", new Object[]{"insertStorageData insert() Exception=" + e});
                return 201000;
            }
        }
        long j;
        if (context.getContentResolver().insert(Uri.parse(f17349a + "module_" + str + HwAccountConstants.SPLIIT_UNDERLINE + str2), contentValues) == null) {
            j = -1;
        } else {
            j = 0;
        }
        if (-1 != j) {
            return 0;
        }
        C2538c.e("DBManager", new Object[]{"insertStorageData() failed"});
        return 201000;
    }

    public static long m22762a(Context context, String str, String str2, int i, ContentValues contentValues, int i2) {
        long j = 0;
        if (1 == i) {
            try {
                C4764b.m22772a(context, str).m22775c();
                if (C4764b.m22772a(context, str).m22774b() != null) {
                    return C4764b.m22772a(context, str).m22774b().insertWithOnConflict("module_" + str + HwAccountConstants.SPLIIT_UNDERLINE + str2, null, contentValues, 5);
                }
                return 0;
            } catch (Exception e) {
                C2538c.e("DBManager", new Object[]{"insertStorageDataWithOnConfict insert() Exception=" + e});
                return 201000;
            }
        }
        if (context.getContentResolver().insert(Uri.parse(f17349a + "module_" + str + HwAccountConstants.SPLIIT_UNDERLINE + str2), contentValues) == null) {
            j = -1;
        }
        if (-1 != j) {
            return 0;
        }
        C2538c.e("DBManager", new Object[]{"insertStorageDataWithOnConfict insert() failed"});
        return 201000;
    }

    public static int m22767b(Context context, String str, String str2, int i, String str3) {
        try {
            C2538c.e("DBManager", new Object[]{"delete() start"});
            if (1 == i) {
                C4764b.m22772a(context, str).m22775c();
                if (C4764b.m22772a(context, str).m22774b() == null) {
                    return 0;
                }
                C4764b.m22772a(context, str).m22774b().delete("module_" + str + HwAccountConstants.SPLIIT_UNDERLINE + str2, str3, null);
                return 0;
            }
            context.getContentResolver().delete(Uri.parse(f17349a + "module_" + str + HwAccountConstants.SPLIIT_UNDERLINE + str2), str3, null);
            return 0;
        } catch (Exception e) {
            C2538c.e("DBManager", new Object[]{"delete() Exception=" + e});
            return 201000;
        }
    }

    public static int m22760a(Context context, String str, String str2, int i, String str3, String[] strArr) {
        try {
            C2538c.e("DBManager", new Object[]{"delete() start"});
            if (1 == i) {
                C4764b.m22772a(context, str).m22775c();
                if (C4764b.m22772a(context, str).m22774b() == null) {
                    return 0;
                }
                C4764b.m22772a(context, str).m22774b().delete("module_" + str + HwAccountConstants.SPLIIT_UNDERLINE + str2, str3, strArr);
                return 0;
            }
            context.getContentResolver().delete(Uri.parse(f17349a + "module_" + str + HwAccountConstants.SPLIIT_UNDERLINE + str2), str3, strArr);
            return 0;
        } catch (Exception e) {
            C2538c.e("DBManager", new Object[]{"delete() Exception=" + e});
            return 201000;
        }
    }

    public static int m22758a(Context context, String str, String str2, int i, ContentValues contentValues, String str3, String[] strArr) {
        try {
            C2538c.e("DBManager", new Object[]{"update() start"});
            if (1 == i) {
                C4764b.m22772a(context, str).m22775c();
                if (C4764b.m22772a(context, str).m22774b() != null) {
                    return C4764b.m22772a(context, str).m22774b().update("module_" + str + HwAccountConstants.SPLIIT_UNDERLINE + str2, contentValues, str3, strArr);
                }
                return 0;
            }
            context.getContentResolver().update(Uri.parse(f17349a + "module_" + str + HwAccountConstants.SPLIIT_UNDERLINE + str2), contentValues, str3, strArr);
            return 0;
        } catch (Exception e) {
            C2538c.e("DBManager", new Object[]{"update() Exception=" + e});
            return 201000;
        }
    }

    public static int m22757a(Context context, String str, String str2, int i, ContentValues contentValues, String str3) {
        try {
            C2538c.e("DBManager", new Object[]{"update() start"});
            if (1 == i) {
                C4764b.m22772a(context, str).m22775c();
                if (C4764b.m22772a(context, str).m22774b() == null) {
                    return 0;
                }
                C4764b.m22772a(context, str).m22774b().update("module_" + str + HwAccountConstants.SPLIIT_UNDERLINE + str2, contentValues, str3, null);
                return 0;
            }
            context.getContentResolver().update(Uri.parse(f17349a + "module_" + str + HwAccountConstants.SPLIIT_UNDERLINE + str2), contentValues, str3, null);
            return 0;
        } catch (Exception e) {
            C2538c.e("DBManager", new Object[]{"update() Exception=" + e});
            return 201000;
        }
    }

    public static Cursor m22770c(Context context, String str, String str2, int i, String str3) {
        if (1 != i) {
            return context.getContentResolver().query(Uri.parse(f17349a + "module_" + str + HwAccountConstants.SPLIIT_UNDERLINE + str2), null, str3, null, null);
        }
        try {
            C4764b.m22772a(context, str).m22775c();
            if (C4764b.m22772a(context, str).m22774b() != null) {
                return C4764b.m22772a(context, str).m22774b().query("module_" + str + HwAccountConstants.SPLIIT_UNDERLINE + str2, null, str3, null, null, null, null);
            }
            return null;
        } catch (Exception e) {
            C2538c.b("DBManager", new Object[]{"queryStorageData error", e.getMessage(), " selection=", str3});
            return null;
        }
    }

    public static Cursor m22764a(Context context, String str, String str2, int i, String str3, String str4) {
        if (1 != i) {
            return context.getContentResolver().query(Uri.parse(f17349a + "module_" + str + HwAccountConstants.SPLIIT_UNDERLINE + str2), null, str3, null, str4);
        }
        try {
            C4764b.m22772a(context, str).m22775c();
            if (C4764b.m22772a(context, str).m22774b() != null) {
                return C4764b.m22772a(context, str).m22774b().query("module_" + str + HwAccountConstants.SPLIIT_UNDERLINE + str2, null, str3, null, null, null, str4);
            }
            return null;
        } catch (Exception e) {
            C2538c.e("DBManager", new Object[]{"queryStorageDataToOrder execSQL() Exception=" + e.getMessage()});
            return null;
        }
    }

    public static Cursor m22763a(Context context, String str, int i, String str2, String[] strArr) {
        Cursor cursor = null;
        if (1 == i) {
            try {
                C4764b.m22772a(context, str).m22775c();
                if (C4764b.m22772a(context, str).m22774b() != null) {
                    cursor = C4764b.m22772a(context, str).m22774b().rawQuery(str2, strArr);
                }
            } catch (Exception e) {
                C2538c.e("DBManager", new Object[]{"rawQueryStorageData execSQL() Exception=" + e.getMessage()});
            }
        }
        return cursor;
    }

    public static String m22766a(String str, String str2) {
        return "module_" + str + HwAccountConstants.SPLIIT_UNDERLINE + str2;
    }

    public static String m22765a(String str) {
        Cursor c = C4763a.m22770c(BaseApplication.b(), String.valueOf(1010), "commonPropertyTable", 2, "propertyDataKey='" + str + "'");
        String str2 = "";
        if (c != null) {
            if (c.getCount() > 0 && c.moveToFirst()) {
                str2 = c.getString(c.getColumnIndex("propertyDataValue"));
            }
            c.close();
        }
        return str2;
    }

    public static void m22768b(String str, String str2) {
        C4763a.m22759a(BaseApplication.b(), String.valueOf(1010), "commonPropertyTable", 2, "propertyDataKey  varchar primary key ,propertyDataValue varchar");
        ContentValues contentValues = new ContentValues();
        contentValues.put("propertyDataKey", str);
        contentValues.put("propertyDataValue", str2);
        if (C4763a.m22769b(str)) {
            C4763a.m22757a(BaseApplication.b(), String.valueOf(1010), "commonPropertyTable", 2, contentValues, null);
        } else {
            C4763a.m22761a(BaseApplication.b(), String.valueOf(1010), "commonPropertyTable", 2, contentValues);
        }
    }

    private static boolean m22769b(String str) {
        boolean z;
        Cursor c = C4763a.m22770c(BaseApplication.b(), String.valueOf(1010), "commonPropertyTable", 2, "propertyDataKey='" + str + "'");
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
        c.b("DBManager", new Object[]{"isHave:", Boolean.valueOf(z)});
        return z;
    }
}
