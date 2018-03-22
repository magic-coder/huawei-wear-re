package com.huawei.feedback.p033a.p034a;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.provider.BaseColumns;
import android.text.TextUtils;
import com.huawei.feedback.bean.C0810a;
import com.huawei.phoneserviceuni.common.p132d.C1373c;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AutouploadTable */
public final class C0807b implements BaseColumns {
    public static void m2696a(SQLiteDatabase sQLiteDatabase) {
        String str = "CREATE TABLE IF NOT EXISTS t_autologupload(_id INTEGER PRIMARY KEY AUTOINCREMENT, filePath varchar(256), fileSize LONG, eventId INTEGER, happenTime varchar(256), uploadFlags INTEGER, metadata varchar(256) )";
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS t_autologupload(_id INTEGER PRIMARY KEY AUTOINCREMENT, filePath varchar(256), fileSize LONG, eventId INTEGER, happenTime varchar(256), uploadFlags INTEGER, metadata varchar(256) )");
            } catch (SQLException e) {
                C1373c.m6140c("AutouploadTable", "create table t_autologupload Error");
            }
        }
    }

    public static synchronized long m2691a(C0806a c0806a, C0810a c0810a) {
        long j;
        synchronized (C0807b.class) {
            SQLiteDatabase sQLiteDatabase = null;
            j = -1;
            try {
                sQLiteDatabase = c0806a.getWritableDatabase();
                C1373c.m6140c("AutouploadTable", "insert table t_autologupload 0000000!");
                j = C0807b.m2690a(sQLiteDatabase, c0810a);
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
            } catch (SQLiteException e) {
                C1373c.m6140c("AutouploadTable", "insert table t_autologupload Error!");
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
            } catch (Throwable th) {
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
            }
        }
        return j;
    }

    public static synchronized void m2697a(C0806a c0806a, List<C0810a> list) {
        Throwable th;
        synchronized (C0807b.class) {
            if (list != null) {
                if (list.size() != 0) {
                    SQLiteDatabase sQLiteDatabase = null;
                    SQLiteDatabase writableDatabase;
                    try {
                        writableDatabase = c0806a.getWritableDatabase();
                        try {
                            for (C0810a c0810a : list) {
                                C1373c.m6140c("AutouploadTable", "step two delete table t_logupload Error!");
                                C0807b.m2698b(writableDatabase, c0810a);
                            }
                            if (writableDatabase != null) {
                                writableDatabase.close();
                            }
                        } catch (SQLiteException e) {
                            sQLiteDatabase = writableDatabase;
                            try {
                                C1373c.m6140c("AutouploadTable", "step three delete table t_logupload Error!");
                                if (sQLiteDatabase != null) {
                                    sQLiteDatabase.close();
                                }
                            } catch (Throwable th2) {
                                Throwable th3 = th2;
                                writableDatabase = sQLiteDatabase;
                                th = th3;
                                if (writableDatabase != null) {
                                    writableDatabase.close();
                                }
                                throw th;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            if (writableDatabase != null) {
                                writableDatabase.close();
                            }
                            throw th;
                        }
                    } catch (SQLiteException e2) {
                        C1373c.m6140c("AutouploadTable", "step three delete table t_logupload Error!");
                        if (sQLiteDatabase != null) {
                            sQLiteDatabase.close();
                        }
                    } catch (Throwable th22) {
                        th3 = th22;
                        writableDatabase = null;
                        th = th3;
                        if (writableDatabase != null) {
                            writableDatabase.close();
                        }
                        throw th;
                    }
                }
            }
            C1373c.m6140c("AutouploadTable", "step one delete table t_logupload Error!");
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void m2699b(com.huawei.feedback.p033a.p034a.C0806a r5, com.huawei.feedback.bean.C0810a r6) {
        /*
        r2 = com.huawei.feedback.p033a.p034a.C0807b.class;
        monitor-enter(r2);
        r0 = 0;
        r0 = r5.getWritableDatabase();	 Catch:{ SQLiteException -> 0x0012, all -> 0x0023 }
        com.huawei.feedback.p033a.p034a.C0807b.m2698b(r0, r6);	 Catch:{ SQLiteException -> 0x0012 }
        if (r0 == 0) goto L_0x0010;
    L_0x000d:
        r0.close();	 Catch:{ all -> 0x0020 }
    L_0x0010:
        monitor-exit(r2);
        return;
    L_0x0012:
        r1 = move-exception;
        r1 = "AutouploadTable";
        r3 = "delete table t_logupload Error!";
        com.huawei.phoneserviceuni.common.p132d.C1373c.m6140c(r1, r3);	 Catch:{ all -> 0x002d }
        if (r0 == 0) goto L_0x0010;
    L_0x001c:
        r0.close();	 Catch:{ all -> 0x0020 }
        goto L_0x0010;
    L_0x0020:
        r0 = move-exception;
        monitor-exit(r2);
        throw r0;
    L_0x0023:
        r1 = move-exception;
        r4 = r1;
        r1 = r0;
        r0 = r4;
    L_0x0027:
        if (r1 == 0) goto L_0x002c;
    L_0x0029:
        r1.close();	 Catch:{ all -> 0x0020 }
    L_0x002c:
        throw r0;	 Catch:{ all -> 0x0020 }
    L_0x002d:
        r1 = move-exception;
        r4 = r1;
        r1 = r0;
        r0 = r4;
        goto L_0x0027;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.feedback.a.a.b.b(com.huawei.feedback.a.a.a, com.huawei.feedback.bean.a):void");
    }

    public static synchronized List<C0810a> m2692a(C0806a c0806a) {
        List<C0810a> list;
        SQLiteException sQLiteException;
        Throwable th;
        Exception exception;
        synchronized (C0807b.class) {
            SQLiteDatabase sQLiteDatabase = null;
            List<C0810a> arrayList = new ArrayList(20);
            try {
                SQLiteDatabase readableDatabase = c0806a.getReadableDatabase();
                if (readableDatabase == null) {
                    if (readableDatabase != null) {
                        readableDatabase.close();
                    }
                    list = arrayList;
                } else {
                    try {
                        Cursor query = readableDatabase.query("t_autologupload", new String[]{"_id", "filePath", "fileSize", "eventId", "happenTime", "uploadFlags", "metadata"}, null, null, null, null, "happenTime ASC");
                        if (query != null) {
                            int columnIndex = query.getColumnIndex("_id");
                            int columnIndex2 = query.getColumnIndex("filePath");
                            int columnIndex3 = query.getColumnIndex("fileSize");
                            int columnIndex4 = query.getColumnIndex("eventId");
                            int columnIndex5 = query.getColumnIndex("happenTime");
                            int columnIndex6 = query.getColumnIndex("uploadFlags");
                            int columnIndex7 = query.getColumnIndex("metadata");
                            for (boolean moveToNext = query.moveToNext(); moveToNext; moveToNext = query.moveToNext()) {
                                C0810a c0810a = new C0810a();
                                c0810a.m2739a((long) query.getInt(columnIndex));
                                c0810a.m2740a(query.getString(columnIndex2));
                                c0810a.m2743b(query.getLong(columnIndex3));
                                c0810a.m2738a(query.getInt(columnIndex4));
                                c0810a.m2744b(query.getString(columnIndex5));
                                c0810a.m2741a(query.getInt(columnIndex6) == 1);
                                c0810a.m2746c(query.getString(columnIndex7));
                                arrayList.add(c0810a);
                            }
                            query.close();
                        }
                        if (readableDatabase != null) {
                            readableDatabase.close();
                        }
                    } catch (SQLiteException e) {
                        SQLiteException sQLiteException2 = e;
                        sQLiteDatabase = readableDatabase;
                        sQLiteException = sQLiteException2;
                        try {
                            C1373c.m6140c("AutouploadTable", "step one query table t_logupload all cols Error " + sQLiteException.getMessage());
                            if (sQLiteDatabase != null) {
                                sQLiteDatabase.close();
                            }
                            list = arrayList;
                            return list;
                        } catch (Throwable th2) {
                            th = th2;
                            if (sQLiteDatabase != null) {
                                sQLiteDatabase.close();
                            }
                            throw th;
                        }
                    } catch (Exception e2) {
                        Exception exception2 = e2;
                        sQLiteDatabase = readableDatabase;
                        exception = exception2;
                        C1373c.m6140c("AutouploadTable", "step two query table t_logupload all cols Error " + exception.getMessage());
                        if (sQLiteDatabase != null) {
                            sQLiteDatabase.close();
                        }
                        list = arrayList;
                        return list;
                    } catch (Throwable th3) {
                        Throwable th4 = th3;
                        sQLiteDatabase = readableDatabase;
                        th = th4;
                        if (sQLiteDatabase != null) {
                            sQLiteDatabase.close();
                        }
                        throw th;
                    }
                    list = arrayList;
                }
            } catch (SQLiteException e3) {
                sQLiteException = e3;
                C1373c.m6140c("AutouploadTable", "step one query table t_logupload all cols Error " + sQLiteException.getMessage());
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
                list = arrayList;
                return list;
            } catch (Exception e4) {
                exception = e4;
                C1373c.m6140c("AutouploadTable", "step two query table t_logupload all cols Error " + exception.getMessage());
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
                list = arrayList;
                return list;
            }
        }
        return list;
    }

    public static synchronized List<C0810a> m2694a(C0806a c0806a, boolean z) {
        List<C0810a> list;
        SQLiteException sQLiteException;
        Throwable th;
        Exception exception;
        SQLiteDatabase sQLiteDatabase = null;
        synchronized (C0807b.class) {
            List<C0810a> arrayList = new ArrayList(20);
            try {
                SQLiteDatabase readableDatabase = c0806a.getReadableDatabase();
                if (readableDatabase == null) {
                    if (readableDatabase != null) {
                        readableDatabase.close();
                    }
                    list = arrayList;
                } else {
                    String str;
                    if (z) {
                        try {
                            str = "1";
                        } catch (SQLiteException e) {
                            SQLiteException sQLiteException2 = e;
                            sQLiteDatabase = readableDatabase;
                            sQLiteException = sQLiteException2;
                            try {
                                C1373c.m6140c("AutouploadTable", "query table t_logupload all cols Error" + sQLiteException.getMessage());
                                if (sQLiteDatabase != null) {
                                    sQLiteDatabase.close();
                                }
                                list = arrayList;
                                return list;
                            } catch (Throwable th2) {
                                th = th2;
                                if (sQLiteDatabase != null) {
                                    sQLiteDatabase.close();
                                }
                                throw th;
                            }
                        } catch (Exception e2) {
                            Exception exception2 = e2;
                            sQLiteDatabase = readableDatabase;
                            exception = exception2;
                            C1373c.m6140c("AutouploadTable", "query table t_logupload all cols Error" + exception.getMessage());
                            if (sQLiteDatabase != null) {
                                sQLiteDatabase.close();
                            }
                            list = arrayList;
                            return list;
                        } catch (Throwable th3) {
                            Throwable th4 = th3;
                            sQLiteDatabase = readableDatabase;
                            th = th4;
                            if (sQLiteDatabase != null) {
                                sQLiteDatabase.close();
                            }
                            throw th;
                        }
                    }
                    str = "0";
                    C0807b.m2695a(readableDatabase.query("t_autologupload", new String[]{"_id", "filePath", "fileSize", "eventId", "happenTime", "uploadFlags", "metadata"}, "uploadFlags=?", new String[]{str}, null, null, "happenTime ASC"), (List) arrayList);
                    if (readableDatabase != null) {
                        readableDatabase.close();
                    }
                    list = arrayList;
                }
            } catch (SQLiteException e3) {
                sQLiteException = e3;
                C1373c.m6140c("AutouploadTable", "query table t_logupload all cols Error" + sQLiteException.getMessage());
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
                list = arrayList;
                return list;
            } catch (Exception e4) {
                exception = e4;
                C1373c.m6140c("AutouploadTable", "query table t_logupload all cols Error" + exception.getMessage());
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
                list = arrayList;
                return list;
            }
        }
        return list;
    }

    private static long m2690a(SQLiteDatabase sQLiteDatabase, C0810a c0810a) {
        if (sQLiteDatabase == null || c0810a == null) {
            C1373c.m6140c("AutouploadTable", "insert table t_autologupload 11111111!");
            return -1;
        }
        ContentValues contentValues = new ContentValues();
        C1373c.m6140c("AutouploadTable", "insert table t_autologupload COL_FILE_PATH!" + c0810a.m2745c());
        contentValues.put("filePath", c0810a.m2745c());
        contentValues.put("fileSize", Long.valueOf(c0810a.m2747d()));
        contentValues.put("eventId", Integer.valueOf(c0810a.m2742b()));
        contentValues.put("happenTime", c0810a.m2748e());
        contentValues.put("uploadFlags", Integer.valueOf(c0810a.m2750g() ? 1 : 0));
        contentValues.put("metadata", c0810a.m2749f());
        long insert = sQLiteDatabase.insert("t_autologupload", null, contentValues);
        if (-1 == insert) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("INSERT INTO ");
            stringBuilder.append("t_autologupload");
            stringBuilder.append(" failed ");
            stringBuilder.append("filePath = ");
            stringBuilder.append(c0810a.m2745c());
            stringBuilder.append(", ");
            stringBuilder.append("eventId = ");
            stringBuilder.append(c0810a.m2742b());
            stringBuilder.append(", ");
            stringBuilder.append("uploadflag = ");
            stringBuilder.append(c0810a.m2750g() ? "1" : "0");
            stringBuilder.append(", ");
            stringBuilder.append("happentime = ");
            stringBuilder.append(c0810a.m2748e());
            C1373c.m6140c("AutouploadTable", stringBuilder.toString());
            return -1;
        }
        C1373c.m6140c("AutouploadTable", "insert table t_autologupload pppp!" + insert);
        return insert;
    }

    private static void m2698b(SQLiteDatabase sQLiteDatabase, C0810a c0810a) {
        if (sQLiteDatabase == null || c0810a == null) {
            C1373c.m6140c("AutouploadTable", "step four delete table t_logupload Error!");
            return;
        }
        C1373c.m6140c("AutouploadTable", "uploadInfo.getDBid()!" + c0810a.m2737a());
        if (-1 == sQLiteDatabase.delete("t_autologupload", "_ID = ?", new String[]{"" + c0810a.m2737a()})) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("DELETE ");
            stringBuilder.append("t_autologupload");
            stringBuilder.append(" where ");
            stringBuilder.append("_ID = ");
            C1373c.m6140c("AutouploadTable", stringBuilder.toString());
        }
    }

    public static synchronized List<C0810a> m2693a(C0806a c0806a, String str) {
        List<C0810a> list;
        SQLiteException sQLiteException;
        Throwable th;
        Exception exception;
        SQLiteDatabase sQLiteDatabase = null;
        synchronized (C0807b.class) {
            List<C0810a> arrayList = new ArrayList(20);
            try {
                SQLiteDatabase readableDatabase = c0806a.getReadableDatabase();
                if (readableDatabase != null) {
                    try {
                        if (!TextUtils.isEmpty(str)) {
                            C0807b.m2695a(readableDatabase.query("t_autologupload", new String[]{"_id", "filePath", "fileSize", "eventId", "happenTime", "uploadFlags", "metadata"}, "filePath=?", new String[]{str}, null, null, "happenTime ASC"), (List) arrayList);
                            if (readableDatabase != null) {
                                readableDatabase.close();
                            }
                            list = arrayList;
                        }
                    } catch (SQLiteException e) {
                        SQLiteException sQLiteException2 = e;
                        sQLiteDatabase = readableDatabase;
                        sQLiteException = sQLiteException2;
                        try {
                            C1373c.m6140c("AutouploadTable", "query t_logupload all cols Error" + sQLiteException.getMessage());
                            if (sQLiteDatabase != null) {
                                sQLiteDatabase.close();
                            }
                            list = arrayList;
                            return list;
                        } catch (Throwable th2) {
                            th = th2;
                            if (sQLiteDatabase != null) {
                                sQLiteDatabase.close();
                            }
                            throw th;
                        }
                    } catch (Exception e2) {
                        Exception exception2 = e2;
                        sQLiteDatabase = readableDatabase;
                        exception = exception2;
                        C1373c.m6140c("AutouploadTable", "query t_logupload all cols Error" + exception.getMessage());
                        if (sQLiteDatabase != null) {
                            sQLiteDatabase.close();
                        }
                        list = arrayList;
                        return list;
                    } catch (Throwable th3) {
                        Throwable th4 = th3;
                        sQLiteDatabase = readableDatabase;
                        th = th4;
                        if (sQLiteDatabase != null) {
                            sQLiteDatabase.close();
                        }
                        throw th;
                    }
                }
                if (readableDatabase != null) {
                    readableDatabase.close();
                }
                list = arrayList;
            } catch (SQLiteException e3) {
                sQLiteException = e3;
                C1373c.m6140c("AutouploadTable", "query t_logupload all cols Error" + sQLiteException.getMessage());
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
                list = arrayList;
                return list;
            } catch (Exception e4) {
                exception = e4;
                C1373c.m6140c("AutouploadTable", "query t_logupload all cols Error" + exception.getMessage());
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
                list = arrayList;
                return list;
            }
        }
        return list;
    }

    private static void m2695a(Cursor cursor, List<C0810a> list) {
        if (cursor != null) {
            int columnIndex = cursor.getColumnIndex("_id");
            int columnIndex2 = cursor.getColumnIndex("filePath");
            int columnIndex3 = cursor.getColumnIndex("fileSize");
            int columnIndex4 = cursor.getColumnIndex("eventId");
            int columnIndex5 = cursor.getColumnIndex("happenTime");
            int columnIndex6 = cursor.getColumnIndex("uploadFlags");
            int columnIndex7 = cursor.getColumnIndex("metadata");
            boolean moveToNext = cursor.moveToNext();
            while (moveToNext) {
                C0810a c0810a = new C0810a();
                c0810a.m2739a((long) cursor.getInt(columnIndex));
                c0810a.m2740a(cursor.getString(columnIndex2));
                c0810a.m2743b(cursor.getLong(columnIndex3));
                c0810a.m2738a(cursor.getInt(columnIndex4));
                c0810a.m2744b(cursor.getString(columnIndex5));
                c0810a.m2741a(cursor.getInt(columnIndex6) == 1);
                c0810a.m2746c(cursor.getString(columnIndex7));
                list.add(c0810a);
                moveToNext = cursor.moveToNext();
            }
            cursor.close();
        }
    }
}
