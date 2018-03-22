package com.huawei.appmarket.sdk.foundation.p367e.p371c;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.C4241a;
import com.huawei.appmarket.sdk.foundation.p367e.p369b.p370a.C4278c;

public class C4283a {
    private static final Uri f15960a = Uri.parse("content://telephony/carriers/preferapn");
    private static final Uri f15961b = Uri.parse("content://telephony/carriers/preferapn/0");
    private static final Uri f15962c = Uri.parse("content://telephony/carriers/preferapn/1");

    public static C4284b m20668a(Context context) throws SecurityException {
        Throwable e;
        Cursor cursor;
        Throwable th;
        Cursor cursor2;
        Throwable th2;
        C4284b c4284b = new C4284b();
        Cursor d;
        try {
            d = C4278c.m20650b() ? C4283a.m20671d(context) : C4283a.m20670c(context);
            if (d != null) {
                while (d.moveToNext()) {
                    try {
                        c4284b.m20675a(d.getString(d.getColumnIndex("_id")));
                        c4284b.m20678c(d.getString(d.getColumnIndex("name")));
                        c4284b.m20677b(d.getString(d.getColumnIndex("apn")).toLowerCase());
                    } catch (SecurityException e2) {
                        e = e2;
                        cursor = d;
                    } catch (Throwable e3) {
                        th = e3;
                        cursor2 = d;
                        th2 = th;
                    } catch (Throwable th3) {
                        e = th3;
                    }
                }
                if (d != null) {
                    d.close();
                }
                return c4284b.m20674a() == null ? c4284b : null;
            } else if (d == null) {
                return null;
            } else {
                d.close();
                return null;
            }
        } catch (Throwable e4) {
            th = e4;
            Object obj = null;
            e = th;
            try {
                C4241a.m20530a("ApnUtil", "getDefaultAPN, SecurityException: ", e);
                throw e;
            } catch (Throwable th4) {
                e = th4;
                d = cursor;
                if (d != null) {
                    d.close();
                }
                throw e;
            }
        } catch (Exception e5) {
            th2 = e5;
            cursor2 = null;
            try {
                C4241a.m20530a("ApnUtil", "getDefaultAPN, Exception: ", th2);
                if (cursor2 != null) {
                    cursor2.close();
                }
                if (c4284b.m20674a() == null) {
                }
            } catch (Throwable th5) {
                e = th5;
                d = cursor2;
                if (d != null) {
                    d.close();
                }
                throw e;
            }
        } catch (Throwable e42) {
            d = null;
            e = e42;
            if (d != null) {
                d.close();
            }
            throw e;
        }
    }

    public static boolean m20669b(Context context) {
        try {
            C4284b a = C4283a.m20668a(context);
            return a == null || !(a == null || a.m20676b() == null || !a.m20676b().contains("wap"));
        } catch (Throwable e) {
            C4241a.m20530a("ApnUtil", "isWap(), SecurityException: ", e);
            return false;
        }
    }

    private static Cursor m20670c(Context context) {
        return context.getContentResolver().query(f15960a, null, null, null, null);
    }

    private static Cursor m20671d(Context context) {
        Cursor f;
        if (C4278c.m20649a().mo4396a() == 0) {
            f = C4283a.m20673f(context);
            if (f == null) {
                f = C4283a.m20672e(context);
            }
        } else {
            f = C4283a.m20672e(context);
            if (f == null) {
                f = C4283a.m20673f(context);
            }
        }
        return f == null ? C4283a.m20670c(context) : f;
    }

    private static Cursor m20672e(Context context) {
        return context.getContentResolver().query(f15962c, null, null, null, null);
    }

    private static Cursor m20673f(Context context) {
        return context.getContentResolver().query(f15961b, null, null, null, null);
    }
}
