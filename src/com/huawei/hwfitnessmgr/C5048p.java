package com.huawei.hwfitnessmgr;

import android.database.Cursor;
import com.huawei.hwcommonmodel.fitnessdatatype.MotionGoal;
import com.huawei.p190v.C2538c;

/* compiled from: FitnessMotionGoalDB */
public class C5048p {
    private String m24346a() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("_id integer primary key autoincrement,");
        stringBuffer.append("User_Id NVARCHAR(300) not null,");
        stringBuffer.append("Is_Upload integer not null,");
        stringBuffer.append("Goal_Type integer not null,");
        stringBuffer.append("Sport_Type integer not null,");
        stringBuffer.append("Data_Type integer not null,");
        stringBuffer.append("Steps_Goal integer not null,");
        stringBuffer.append("Calories_Goal integer not null,");
        stringBuffer.append("Distance_Goal integer not null,");
        stringBuffer.append("Duration_Goal integer not null");
        return String.valueOf(stringBuffer);
    }

    public void m24348a(q qVar) {
        qVar.createStorageDataTable("FitnessMotionGoalDB", 1, m24346a());
    }

    private MotionGoal m24345a(Cursor cursor) {
        MotionGoal motionGoal = new MotionGoal();
        motionGoal.setGoalType(cursor.getInt(cursor.getColumnIndex("Goal_Type")));
        motionGoal.setMotionType(cursor.getInt(cursor.getColumnIndex("Sport_Type")));
        motionGoal.setDataType(cursor.getInt(cursor.getColumnIndex("Data_Type")));
        motionGoal.setStepGoal(cursor.getInt(cursor.getColumnIndex("Steps_Goal")));
        motionGoal.setCalorieGoal(cursor.getInt(cursor.getColumnIndex("Calories_Goal")));
        motionGoal.setDistanceGoal(cursor.getInt(cursor.getColumnIndex("Distance_Goal")));
        motionGoal.setDutationGoal(cursor.getInt(cursor.getColumnIndex("Duration_Goal")));
        return motionGoal;
    }

    public MotionGoal m24347a(q qVar, MotionGoal motionGoal) {
        MotionGoal motionGoal2 = new MotionGoal();
        Cursor queryStorageData = qVar.queryStorageData("FitnessMotionGoalDB", 1, "User_Id='" + q.g() + "' AND " + "Goal_Type" + "=" + motionGoal.getGoalType() + " AND " + "Sport_Type" + "=" + motionGoal.getMotionType());
        if (queryStorageData == null) {
            C2538c.e("FitnessMotionGoalDB", new Object[]{"getSingleMotionGoal query DB failure"});
        } else {
            if (queryStorageData.moveToFirst()) {
                motionGoal2 = m24345a(queryStorageData);
            }
            queryStorageData.close();
        }
        return motionGoal2;
    }
}
