package com.google.tagmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.huawei.hwid.core.datatype.SMSKeyInfo;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import org.apache.log4j.spi.LocationInfo;

/* compiled from: DataLayerPersistentStoreImpl */
class C3688n implements C3682k {
    private static final String f14342a = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' STRING NOT NULL, '%s' BLOB NOT NULL, '%s' INTEGER NOT NULL);", new Object[]{"datalayer", "ID", SMSKeyInfo.TAG_KEY, "value", "expires"});
    private final Executor f14343b;
    private final Context f14344c;
    private C3692r f14345d;
    private C3678c f14346e;
    private int f14347f;

    public C3688n(Context context) {
        this(context, new C3689o(), "google_tagmanager.db", 2000, Executors.newSingleThreadExecutor());
    }

    C3688n(Context context, C3678c c3678c, String str, int i, Executor executor) {
        this.f14344c = context;
        this.f14346e = c3678c;
        this.f14347f = i;
        this.f14343b = executor;
        this.f14345d = new C3692r(this, this.f14344c, str);
    }

    public void mo4293a(List<C3686i> list, long j) {
        this.f14343b.execute(new C3690p(this, m18594b((List) list), j));
    }

    public void mo4292a(C3684l c3684l) {
        this.f14343b.execute(new C3691q(this, c3684l));
    }

    private List<C3686i> m18592b() {
        try {
            m18587a(this.f14346e.mo4295a());
            List<C3686i> a = m18585a(m18596c());
            return a;
        } finally {
            m18599e();
        }
    }

    private List<C3686i> m18585a(List<C3693s> list) {
        List<C3686i> arrayList = new ArrayList();
        for (C3693s c3693s : list) {
            arrayList.add(new C3686i(c3693s.f14354a, m18582a(c3693s.f14355b)));
        }
        return arrayList;
    }

    private List<C3693s> m18594b(List<C3686i> list) {
        List<C3693s> arrayList = new ArrayList();
        for (C3686i c3686i : list) {
            arrayList.add(new C3693s(c3686i.f14340a, m18590a(c3686i.f14341b)));
        }
        return arrayList;
    }

    private Object m18582a(byte[] bArr) {
        ObjectInputStream objectInputStream;
        Object readObject;
        Throwable th;
        ObjectInputStream objectInputStream2 = null;
        InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            objectInputStream = new ObjectInputStream(byteArrayInputStream);
            try {
                readObject = objectInputStream.readObject();
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e) {
                    }
                }
                byteArrayInputStream.close();
            } catch (IOException e2) {
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e3) {
                    }
                }
                byteArrayInputStream.close();
                return readObject;
            } catch (ClassNotFoundException e4) {
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e5) {
                    }
                }
                byteArrayInputStream.close();
                return readObject;
            } catch (Throwable th2) {
                th = th2;
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e6) {
                        throw th;
                    }
                }
                byteArrayInputStream.close();
                throw th;
            }
        } catch (IOException e7) {
            objectInputStream = objectInputStream2;
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            byteArrayInputStream.close();
            return readObject;
        } catch (ClassNotFoundException e8) {
            objectInputStream = objectInputStream2;
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            byteArrayInputStream.close();
            return readObject;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            objectInputStream = objectInputStream2;
            th = th4;
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            byteArrayInputStream.close();
            throw th;
        }
        return readObject;
    }

    private byte[] m18590a(Object obj) {
        ObjectOutputStream objectOutputStream;
        Throwable th;
        byte[] bArr = null;
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            try {
                objectOutputStream.writeObject(obj);
                bArr = byteArrayOutputStream.toByteArray();
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException e) {
                    }
                }
                byteArrayOutputStream.close();
            } catch (IOException e2) {
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException e3) {
                    }
                }
                byteArrayOutputStream.close();
                return bArr;
            } catch (Throwable th2) {
                th = th2;
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException e4) {
                        throw th;
                    }
                }
                byteArrayOutputStream.close();
                throw th;
            }
        } catch (IOException e5) {
            objectOutputStream = bArr;
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
            byteArrayOutputStream.close();
            return bArr;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            objectOutputStream = bArr;
            th = th4;
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
            byteArrayOutputStream.close();
            throw th;
        }
        return bArr;
    }

    private synchronized void m18595b(List<C3693s> list, long j) {
        try {
            long a = this.f14346e.mo4295a();
            m18587a(a);
            m18586a(list.size());
            m18597c(list, a + j);
            m18599e();
        } catch (Throwable th) {
            m18599e();
        }
    }

    private List<C3693s> m18596c() {
        SQLiteDatabase a = m18581a("Error opening database for loadSerialized.");
        List<C3693s> arrayList = new ArrayList();
        if (a == null) {
            return arrayList;
        }
        Cursor query = a.query("datalayer", new String[]{SMSKeyInfo.TAG_KEY, "value"}, null, null, null, null, "ID", null);
        while (query.moveToNext()) {
            try {
                arrayList.add(new C3693s(query.getString(0), query.getBlob(1)));
            } finally {
                query.close();
            }
        }
        return arrayList;
    }

    private void m18597c(List<C3693s> list, long j) {
        SQLiteDatabase a = m18581a("Error opening database for writeEntryToDatabase.");
        if (a != null) {
            for (C3693s c3693s : list) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("expires", Long.valueOf(j));
                contentValues.put(SMSKeyInfo.TAG_KEY, c3693s.f14354a);
                contentValues.put("value", c3693s.f14355b);
                a.insert("datalayer", null, contentValues);
            }
        }
    }

    private void m18586a(int i) {
        int d = (m18598d() - this.f14347f) + i;
        if (d > 0) {
            List b = m18593b(d);
            C3700z.m18627c("DataLayer store full, deleting " + b.size() + " entries to make room.");
            m18589a((String[]) b.toArray(new String[0]));
        }
    }

    private void m18587a(long j) {
        SQLiteDatabase a = m18581a("Error opening database for deleteOlderThan.");
        if (a != null) {
            try {
                C3700z.m18628d("Deleted " + a.delete("datalayer", "expires <= ?", new String[]{Long.toString(j)}) + " expired items");
            } catch (SQLiteException e) {
                C3700z.m18626b("Error deleting old entries.");
            }
        }
    }

    private void m18589a(String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            SQLiteDatabase a = m18581a("Error opening database for deleteEntries.");
            if (a != null) {
                try {
                    a.delete("datalayer", String.format("%s in (%s)", new Object[]{"ID", TextUtils.join(",", Collections.nCopies(strArr.length, LocationInfo.NA))}), strArr);
                } catch (SQLiteException e) {
                    C3700z.m18626b("Error deleting entries " + Arrays.toString(strArr));
                }
            }
        }
    }

    private List<String> m18593b(int i) {
        Cursor query;
        SQLiteException e;
        Throwable th;
        List<String> arrayList = new ArrayList();
        if (i <= 0) {
            C3700z.m18626b("Invalid maxEntries specified. Skipping.");
            return arrayList;
        }
        SQLiteDatabase a = m18581a("Error opening database for peekEntryIds.");
        if (a == null) {
            return arrayList;
        }
        try {
            query = a.query("datalayer", new String[]{"ID"}, null, null, null, null, String.format("%s ASC", new Object[]{"ID"}), Integer.toString(i));
            try {
                if (query.moveToFirst()) {
                    do {
                        arrayList.add(String.valueOf(query.getLong(0)));
                    } while (query.moveToNext());
                }
                if (query != null) {
                    query.close();
                }
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    C3700z.m18626b("Error in peekEntries fetching entryIds: " + e.getMessage());
                    if (query != null) {
                        query.close();
                    }
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            query = null;
            C3700z.m18626b("Error in peekEntries fetching entryIds: " + e.getMessage());
            if (query != null) {
                query.close();
            }
            return arrayList;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
        return arrayList;
    }

    private int m18598d() {
        Cursor cursor = null;
        int i = 0;
        SQLiteDatabase a = m18581a("Error opening database for getNumStoredEntries.");
        if (a != null) {
            try {
                cursor = a.rawQuery("SELECT COUNT(*) from datalayer", null);
                if (cursor.moveToFirst()) {
                    i = (int) cursor.getLong(0);
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (SQLiteException e) {
                C3700z.m18626b("Error getting numStoredEntries");
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
        return i;
    }

    private SQLiteDatabase m18581a(String str) {
        try {
            return this.f14345d.getWritableDatabase();
        } catch (SQLiteException e) {
            C3700z.m18626b(str);
            return null;
        }
    }

    private void m18599e() {
        try {
            this.f14345d.close();
        } catch (SQLiteException e) {
        }
    }
}
