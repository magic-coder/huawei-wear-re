package com.huawei.hwfitnessmgr;

import android.content.ContentValues;
import android.database.Cursor;
import com.huawei.hwcommonmodel.fitnessdatatype.ActivityReminder;
import com.huawei.p190v.C2538c;

/* compiled from: FitnessActivityReminderDB */
public class C5010a {
    private String m24072a() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("_id integer primary key autoincrement,");
        stringBuffer.append("User_Id NVARCHAR(300) not null,");
        stringBuffer.append("Is_Upload integer not null,");
        stringBuffer.append("Enable integer not null,");
        stringBuffer.append("Interval integer not null,");
        stringBuffer.append("Start_Time integer not null,");
        stringBuffer.append("End_Time integer not null,");
        stringBuffer.append("Cycle integer not null");
        return String.valueOf(stringBuffer);
    }

    public void m24074a(q qVar) {
        qVar.createStorageDataTable("FitnessActivityReminderTable", 1, m24072a());
    }

    public ContentValues m24073a(String str, int i, ActivityReminder activityReminder) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("User_Id", str);
        contentValues.put("Is_Upload", Integer.valueOf(i));
        contentValues.put("Enable", Integer.valueOf(activityReminder.isEnabled() ? 1 : 0));
        contentValues.put("Interval", Integer.valueOf(activityReminder.getInterval()));
        contentValues.put("Start_Time", Integer.valueOf(activityReminder.getStartTime()));
        contentValues.put("End_Time", Integer.valueOf(activityReminder.getEndTime()));
        contentValues.put("Cycle", Integer.valueOf(activityReminder.getCycle()));
        return contentValues;
    }

    public void m24075a(q qVar, int i, ActivityReminder activityReminder) {
        ContentValues a = m24073a(q.g(), i, activityReminder);
        Cursor queryStorageData = qVar.queryStorageData("FitnessActivityReminderTable", 1, "User_Id='" + q.g() + "'");
        if (queryStorageData == null) {
            C2538c.e("FitnessARDB", new Object[]{"updateActivityReminder query faile"});
            return;
        }
        if (queryStorageData.moveToFirst()) {
            qVar.updateStorageData("FitnessActivityReminderTable", 1, a, "User_Id='" + q.g() + "'");
        } else {
            qVar.insertStorageData("FitnessActivityReminderTable", 1, a);
        }
        queryStorageData.close();
    }

    private ActivityReminder m24071a(Cursor cursor) {
        boolean z;
        ActivityReminder activityReminder = new ActivityReminder();
        activityReminder.setInterval(cursor.getInt(cursor.getColumnIndex("Interval")));
        activityReminder.setStartTime(cursor.getInt(cursor.getColumnIndex("Start_Time")));
        activityReminder.setEndTime(cursor.getInt(cursor.getColumnIndex("End_Time")));
        activityReminder.setCycle(cursor.getInt(cursor.getColumnIndex("Cycle")));
        if (1 == cursor.getInt(cursor.getColumnIndex("Enable"))) {
            z = true;
        } else {
            z = false;
        }
        activityReminder.setEnabled(z);
        C2538c.a("05", 1, "FitnessARDB", new Object[]{"getAndFillDataTable enable" + activityReminder});
        return activityReminder;
    }

    public ActivityReminder m24076b(q qVar) {
        ActivityReminder activityReminder = new ActivityReminder();
        Cursor queryStorageData = qVar.queryStorageData("FitnessActivityReminderTable", 1, "User_Id='" + q.g() + "'");
        if (queryStorageData == null) {
            C2538c.e("FitnessARDB", new Object[]{"getUserInfo error on query"});
        } else {
            if (queryStorageData.moveToFirst()) {
                C2538c.c("FitnessARDB", new Object[]{"getActivityReminder  get cursor"});
                activityReminder = m24071a(queryStorageData);
            } else {
                C2538c.c("FitnessARDB", new Object[]{"getActivityReminder not get cursor"});
            }
            queryStorageData.close();
        }
        return activityReminder;
    }
}
