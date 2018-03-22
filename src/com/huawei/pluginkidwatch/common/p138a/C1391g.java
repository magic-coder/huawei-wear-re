package com.huawei.pluginkidwatch.common.p138a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.model.Contact;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ContactDB */
public class C1391g {
    public static final String f3065a;
    private static final String[] f3066e = new String[]{"_id", "contactId", "name", "phoneNum", "mType", "sosType", "imgUrl", "deviceCode", "type"};
    private SQLiteDatabase f3067b;
    private C1393i f3068c;
    private Context f3069d;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("create table  IF NOT EXISTS allcontact(");
        stringBuilder.append("_id integer primary key autoincrement,");
        stringBuilder.append("contactId integer not null,");
        stringBuilder.append("deviceCode NVARCHAR(300) not null,");
        stringBuilder.append("name NVARCHAR(300) not null,");
        stringBuilder.append("phoneNum NVARCHAR(300) not null,");
        stringBuilder.append("mType NVARCHAR(300) not null,");
        stringBuilder.append("sosType NVARCHAR(300) not null,");
        stringBuilder.append("imgUrl NVARCHAR(300) not null,");
        stringBuilder.append("type NVARCHAR(300) not null");
        stringBuilder.append(")");
        C2538c.m12674b("ContactDB", "===createTableSQL", stringBuilder.toString());
        f3065a = stringBuilder.toString();
    }

    public C1391g(Context context) {
        this.f3068c = C1393i.m6319a(context);
        this.f3069d = context;
    }

    public void m6263a() {
        if (this.f3067b == null) {
            this.f3067b = this.f3068c.m6327a();
        }
    }

    public void m6264b() {
        this.f3068c.m6328b();
        this.f3067b = null;
    }

    public long m6260a(Contact contact, String str) {
        try {
            long insert;
            m6263a();
            ContentValues contentValues = new ContentValues();
            contentValues.put("contactId", Integer.valueOf(contact.getContactId()));
            contentValues.put("name", C1392h.m6317j(this.f3069d, contact.getName()));
            if (contact.getBigHeadIcon() == null) {
                contentValues.put("imgUrl", "");
            } else {
                contentValues.put("imgUrl", C1392h.m6317j(this.f3069d, contact.getBigHeadIcon()));
            }
            contentValues.put("phoneNum", C1392h.m6317j(this.f3069d, contact.getPhoneNum()));
            contentValues.put("mType", C1392h.m6317j(this.f3069d, String.valueOf(contact.getmType())));
            contentValues.put("sosType", C1392h.m6317j(this.f3069d, String.valueOf(contact.getSosType())));
            contentValues.put("deviceCode", str);
            contentValues.put("type", C1392h.m6317j(this.f3069d, contact.getType()));
            if (this.f3067b != null) {
                insert = this.f3067b.insert("allcontact", null, contentValues);
            } else {
                insert = -1;
            }
            if (-1 == insert) {
                C2538c.m12680e("ContactDB", "insert() failed");
            }
            String str2 = "ContactDB";
            Object[] objArr = new Object[1];
            objArr[0] = "insert() result=" + (-1 == insert ? "failed" : "succeed") + ", table=" + contact + ", values=" + contentValues.toString();
            C2538c.m12674b(str2, objArr);
            m6264b();
            return insert;
        } catch (Exception e) {
            C2538c.m12680e("ContactDB", "insert() Exception=" + e.getMessage());
            m6264b();
            return -1;
        }
    }

    public int m6259a(Contact contact) {
        try {
            int update;
            m6263a();
            C2538c.m12674b("ContactDB", "==ww==  updataDB   contact ==" + contact.toString());
            ContentValues contentValues = new ContentValues();
            contentValues.put("name", C1392h.m6317j(this.f3069d, contact.getName()));
            contentValues.put("phoneNum", C1392h.m6317j(this.f3069d, contact.getPhoneNum()));
            if (contact.getBigHeadIcon() == null) {
                contentValues.put("imgUrl", "");
            } else {
                contentValues.put("imgUrl", C1392h.m6317j(this.f3069d, contact.getBigHeadIcon()));
            }
            contentValues.put("type", C1392h.m6317j(this.f3069d, contact.getType()));
            String str = "contactId= ?";
            String[] strArr = new String[]{String.valueOf(contact.getContactId())};
            if (this.f3067b != null) {
                update = this.f3067b.update("allcontact", contentValues, str, strArr);
            } else {
                update = 0;
            }
            if (update == 0) {
                C2538c.m12680e("ContactDB", "update() failed");
            }
            String str2 = "ContactDB";
            Object[] objArr = new Object[1];
            objArr[0] = "update() result=" + (update == 0 ? "failed" : "succeed") + ", table=" + contact + ", values=" + contact.toString();
            C2538c.m12674b(str2, objArr);
            m6264b();
            return update;
        } catch (Exception e) {
            C2538c.m12680e("ContactDB", "update() Exception=" + e.getMessage());
            m6264b();
            return -1;
        }
    }

    public Contact m6261a(int i) {
        Cursor query;
        NumberFormatException e;
        try {
            m6263a();
            String[] strArr = new String[]{String.valueOf(i)};
            C2538c.m12674b("ContactDB", "================selection:", "contactId= ?");
            if (this.f3067b != null) {
                query = this.f3067b.query("allcontact", f3066e, r3, strArr, null, null, null);
            } else {
                query = null;
            }
            if (query == null) {
                try {
                    m6264b();
                    return null;
                } catch (NumberFormatException e2) {
                    e = e2;
                    C2538c.m12680e("ContactDB", "get() Exception=" + e.getMessage());
                    if (query != null) {
                        query.close();
                        m6264b();
                    }
                    return null;
                }
            }
            Contact contact;
            if (query.moveToFirst()) {
                contact = new Contact();
                contact.contactId = query.getInt(query.getColumnIndex("contactId"));
                contact.name = C1392h.m6318k(this.f3069d, query.getString(query.getColumnIndex("name")));
                contact.phoneNum = C1392h.m6318k(this.f3069d, query.getString(query.getColumnIndex("phoneNum")));
                contact.mType = Integer.parseInt(C1392h.m6318k(this.f3069d, query.getString(query.getColumnIndex("mType"))));
                contact.sosType = Integer.parseInt(C1392h.m6318k(this.f3069d, query.getString(query.getColumnIndex("sosType"))));
                contact.bigHeadIcon = C1392h.m6318k(this.f3069d, query.getString(query.getColumnIndex("imgUrl")));
                contact.type = C1392h.m6318k(this.f3069d, query.getString(query.getColumnIndex("type")));
            } else {
                contact = null;
            }
            query.close();
            m6264b();
            return contact;
        } catch (NumberFormatException e3) {
            e = e3;
            query = null;
            C2538c.m12680e("ContactDB", "get() Exception=" + e.getMessage());
            if (query != null) {
                query.close();
                m6264b();
            }
            return null;
        }
    }

    public void m6266c() {
        try {
            m6263a();
            String str = "DELETE FROM allcontact;";
            if (this.f3067b != null) {
                this.f3067b.execSQL(str);
            }
            m6264b();
        } catch (SQLException e) {
            C2538c.m12680e("ContactDB", "deleteAll SQLException e = " + e.getMessage());
            m6264b();
        } catch (Exception e2) {
            C2538c.m12680e("ContactDB", "Exception e = " + e2.getMessage());
            m6264b();
        }
    }

    public void m6265b(int i) {
        try {
            m6263a();
            String str = "DELETE FROM allcontact Where contactId= ?";
            String[] strArr = new String[]{String.valueOf(i)};
            if (this.f3067b != null) {
                this.f3067b.execSQL(str, strArr);
            }
            m6264b();
        } catch (SQLException e) {
            C2538c.m12680e("ContactDB", "Exception e = " + e.getMessage());
            m6264b();
        }
    }

    public List<Contact> m6262a(String str) {
        Cursor rawQuery;
        SQLiteException e;
        Throwable th;
        Exception e2;
        try {
            m6263a();
            if (this.f3067b != null) {
                rawQuery = this.f3067b.rawQuery("select * from allcontact where deviceCode = ?", new String[]{str});
            } else {
                rawQuery = null;
            }
            if (rawQuery == null) {
                try {
                    m6264b();
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    m6264b();
                    return null;
                } catch (SQLiteException e3) {
                    e = e3;
                    try {
                        C2538c.m12680e("ContactDB", "getAllContactByDeviceCode() SQLiteException=" + e.getMessage());
                        if (rawQuery != null) {
                            rawQuery.close();
                        }
                        m6264b();
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (rawQuery != null) {
                            rawQuery.close();
                        }
                        m6264b();
                        throw th;
                    }
                } catch (Exception e4) {
                    e2 = e4;
                    C2538c.m12680e("ContactDB", "getAllContactByDeviceCode() Exception=" + e2.getMessage());
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    m6264b();
                    return null;
                }
            }
            ArrayList arrayList = new ArrayList();
            while (rawQuery.moveToNext()) {
                Contact contact = new Contact();
                contact.contactId = rawQuery.getInt(rawQuery.getColumnIndex("contactId"));
                contact.name = C1392h.m6318k(this.f3069d, rawQuery.getString(rawQuery.getColumnIndex("name")));
                contact.phoneNum = C1392h.m6318k(this.f3069d, rawQuery.getString(rawQuery.getColumnIndex("phoneNum")));
                contact.mType = Integer.parseInt(C1392h.m6318k(this.f3069d, rawQuery.getString(rawQuery.getColumnIndex("mType"))));
                contact.sosType = Integer.parseInt(C1392h.m6318k(this.f3069d, rawQuery.getString(rawQuery.getColumnIndex("sosType"))));
                contact.bigHeadIcon = C1392h.m6318k(this.f3069d, rawQuery.getString(rawQuery.getColumnIndex("imgUrl")));
                contact.type = C1392h.m6318k(this.f3069d, rawQuery.getString(rawQuery.getColumnIndex("type")));
                arrayList.add(contact);
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
            m6264b();
            return arrayList;
        } catch (SQLiteException e5) {
            e = e5;
            rawQuery = null;
            C2538c.m12680e("ContactDB", "getAllContactByDeviceCode() SQLiteException=" + e.getMessage());
            if (rawQuery != null) {
                rawQuery.close();
            }
            m6264b();
            return null;
        } catch (Exception e6) {
            e2 = e6;
            rawQuery = null;
            C2538c.m12680e("ContactDB", "getAllContactByDeviceCode() Exception=" + e2.getMessage());
            if (rawQuery != null) {
                rawQuery.close();
            }
            m6264b();
            return null;
        } catch (Throwable th3) {
            rawQuery = null;
            th = th3;
            if (rawQuery != null) {
                rawQuery.close();
            }
            m6264b();
            throw th;
        }
    }
}
