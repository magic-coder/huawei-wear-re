package com.fenda.p255a.p256a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.fenda.hwbracelet.mode.Alarm;
import com.huawei.p190v.C2538c;

import java.util.ArrayList;
import java.util.List;

/* compiled from: DBAlarmManager */
public class C3565a {
    String f13579a = "alarm";
    String f13580b = "_name";
    String f13581c = "_time";
    String f13582d = "_sun";
    String f13583e = "_mon";
    String f13584f = "_tue";
    String f13585g = "_wed";
    String f13586h = "_thu";
    String f13587i = "_fri";
    String f13588j = "_sta";
    String f13589k = "_onoff";
    private C3567c f13590l;
    private SQLiteDatabase f13591m;
    private final Object f13592n = new Object();

    public C3565a(Context context) {
        this.f13590l = C3567c.m17910a(context);
    }

    private void m17896c() {
        synchronized (this.f13592n) {
            this.f13590l.m17912b();
            this.f13591m = null;
        }
    }

    public void m17900a(Alarm alarm) {
        synchronized (this.f13592n) {
            try {
                if (m17897d()) {
                    return;
                }
                this.f13591m.execSQL("delete from " + this.f13579a + " where id =" + alarm.getId());
                ContentValues contentValues = new ContentValues();
                contentValues.put(this.f13580b, alarm.getName());
                contentValues.put(this.f13581c, alarm.getTime());
                contentValues.put(this.f13582d, Integer.valueOf(alarm.getSun()));
                contentValues.put(this.f13583e, Integer.valueOf(alarm.getMon()));
                contentValues.put(this.f13584f, Integer.valueOf(alarm.getTue()));
                contentValues.put(this.f13585g, Integer.valueOf(alarm.getWed()));
                contentValues.put(this.f13586h, Integer.valueOf(alarm.getThu()));
                contentValues.put(this.f13587i, Integer.valueOf(alarm.getFri()));
                contentValues.put(this.f13588j, Integer.valueOf(alarm.getSta()));
                contentValues.put(this.f13589k, Integer.valueOf(alarm.getOnOff()));
                long insert = this.f13591m.insert(this.f13579a, null, contentValues);
                C2538c.c("DBAlarmManager", new Object[]{"insert alarm：" + insert});
                m17896c();
            } catch (Exception e) {
            }
        }
    }

    public void m17901a(List<Alarm> list) {
        synchronized (this.f13592n) {
            m17902b();
            for (int i = 0; i < list.size(); i++) {
                m17900a((Alarm) list.get(i));
            }
        }
    }

    public List<Alarm> m17898a() {
        List<Alarm> list = null;
        synchronized (this.f13592n) {
            try {
                if (m17897d()) {
                } else {
                    List<Alarm> arrayList = new ArrayList();
                    try {
                        Cursor rawQuery = this.f13591m.rawQuery("SELECT * FROM " + this.f13579a, null);
                        if (rawQuery.getCount() == 0) {
                            C2538c.e("DBAlarmManager", new Object[]{"the alarms in the database is null"});
                            rawQuery.close();
                            m17896c();
                        } else {
                            while (rawQuery.moveToNext()) {
                                Alarm alarm = new Alarm();
                                alarm.setId(rawQuery.getInt(rawQuery.getColumnIndex("id")));
                                alarm.setName(rawQuery.getString(rawQuery.getColumnIndex(this.f13580b)));
                                alarm.setTime(rawQuery.getString(rawQuery.getColumnIndex(this.f13581c)));
                                alarm.setSun(rawQuery.getInt(rawQuery.getColumnIndex(this.f13582d)));
                                alarm.setMon(rawQuery.getInt(rawQuery.getColumnIndex(this.f13583e)));
                                alarm.setTue(rawQuery.getInt(rawQuery.getColumnIndex(this.f13584f)));
                                alarm.setWed(rawQuery.getInt(rawQuery.getColumnIndex(this.f13585g)));
                                alarm.setThu(rawQuery.getInt(rawQuery.getColumnIndex(this.f13586h)));
                                alarm.setFri(rawQuery.getInt(rawQuery.getColumnIndex(this.f13587i)));
                                alarm.setSta(rawQuery.getInt(rawQuery.getColumnIndex(this.f13588j)));
                                alarm.setOnOff(rawQuery.getInt(rawQuery.getColumnIndex(this.f13589k)));
                                arrayList.add(alarm);
                            }
                            rawQuery.close();
                            m17896c();
                            list = arrayList;
                        }
                    } catch (Exception e) {
                        list = arrayList;
                    }
                }
            } catch (Exception e2) {
            }
        }
        return list;
    }

    public void m17899a(int i) {
        synchronized (this.f13592n) {
            try {
                if (m17897d()) {
                    return;
                }
                this.f13591m.execSQL("delete from " + this.f13579a + " where id =" + i);
                m17896c();
            } catch (Exception e) {
            }
        }
    }

    public void m17902b() {
        synchronized (this.f13592n) {
            try {
                if (m17897d()) {
                    return;
                }
                this.f13591m.execSQL("delete from " + this.f13579a);
                m17896c();
            } catch (Exception e) {
                C2538c.e("DBAlarmManager", new Object[]{"delete alarm exception"});
            }
        }
    }

    private boolean m17897d() {
        boolean z;
        synchronized (this.f13592n) {
            if (this.f13591m == null) {
                this.f13591m = this.f13590l.m17911a();
                if (this.f13591m == null) {
                    Log.e("DBAlarmManager", "Error occur, db == null");
                    z = true;
                }
            }
            z = false;
        }
        return z;
    }
}
