package com.huawei.ui.main.stories.nps.interactors.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.huawei.hwdataaccessmodel.db.a;
import com.huawei.p190v.C2538c;
import com.huawei.ui.main.stories.nps.interactors.C2442a;
import com.huawei.ui.main.stories.nps.interactors.mode.QstnSurveyCommitParam;
import java.util.ArrayList;
import java.util.List;

/* compiled from: QstnSurveyDB */
public class C2448a {
    public static final String[] f8811a = new String[]{"_id", "deviceID", "lastSurveyTime", "deviceType", "times", "questionid", QstnSurveyCommitParam.surveyID, "countryCode", "Data1", "Data2", "Data3", "Data4", "Data5"};
    public static final String f8812b;
    private boolean f8813c = true;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("_id integer primary key autoincrement,");
        stringBuilder.append("deviceID NVARCHAR(128) not null,");
        stringBuilder.append("lastSurveyTime Long not null,");
        stringBuilder.append("deviceType NVARCHAR(64),");
        stringBuilder.append("surveyID NVARCHAR(32),");
        stringBuilder.append("questionid integer not null,");
        stringBuilder.append("countryCode NVARCHAR(32),");
        stringBuilder.append("Data1 NVARCHAR(64),");
        stringBuilder.append("Data2 NVARCHAR(64),");
        stringBuilder.append("Data3 NVARCHAR(64),");
        stringBuilder.append("Data4 NVARCHAR(64),");
        stringBuilder.append("Data5 NVARCHAR(64),");
        stringBuilder.append("times integer not null");
        f8812b = stringBuilder.toString();
    }

    public C2448a(Context context) {
    }

    public void m12278a(C2442a c2442a) {
        c2442a.createStorageDataTable("questionSurvey", 1, f8812b);
    }

    public void m12279a(C2442a c2442a, Integer num, Context context) {
        if (c2442a != null && context != null) {
            List<QstnSurveyTable> arrayList = new ArrayList();
            m12280a(c2442a, (List) arrayList);
            c2442a.deleteStorageData(String.valueOf(num), 1, null);
            a.a(context, String.valueOf(num), "questionSurvey", 1);
            m12278a(c2442a);
            for (QstnSurveyTable a : arrayList) {
                m12277a(c2442a, a);
            }
            this.f8813c = false;
        }
    }

    public boolean m12281a() {
        return this.f8813c;
    }

    public void m12280a(C2442a c2442a, List<QstnSurveyTable> list) {
        Cursor cursor = null;
        try {
            cursor = c2442a.queryStorageData("questionSurvey", 1, null);
            if (cursor != null && cursor.moveToFirst()) {
                do {
                    QstnSurveyTable qstnSurveyTable = new QstnSurveyTable();
                    qstnSurveyTable.deviceID = cursor.getString(cursor.getColumnIndex("deviceID"));
                    qstnSurveyTable.lastSurveyTime = cursor.getLong(cursor.getColumnIndex("lastSurveyTime"));
                    qstnSurveyTable.deviceType = cursor.getString(cursor.getColumnIndex("deviceType"));
                    qstnSurveyTable.times = Integer.valueOf(cursor.getInt(cursor.getColumnIndex("times")));
                    qstnSurveyTable.id = cursor.getInt(cursor.getColumnIndex("questionid"));
                    qstnSurveyTable.surveyID = "" + qstnSurveyTable.id;
                    list.add(qstnSurveyTable);
                } while (cursor.moveToNext());
                if (cursor != null) {
                    cursor.close();
                }
            } else if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e) {
            if (cursor != null) {
                cursor.close();
            }
            C2538c.m12677c("QuestionSurveyDB", "getOldSurveyDBData Exception e!!!");
        }
    }

    public long m12277a(C2442a c2442a, QstnSurveyTable qstnSurveyTable) {
        long j = -1;
        if (qstnSurveyTable != null) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("deviceID", qstnSurveyTable.deviceID);
                contentValues.put("lastSurveyTime", Long.valueOf(qstnSurveyTable.lastSurveyTime));
                contentValues.put("deviceType", qstnSurveyTable.deviceType);
                contentValues.put("times", qstnSurveyTable.times);
                contentValues.put(QstnSurveyCommitParam.surveyID, qstnSurveyTable.surveyID);
                contentValues.put("questionid", Integer.valueOf(qstnSurveyTable.id));
                j = c2442a.insertStorageData("questionSurvey", 1, contentValues);
            } catch (Exception e) {
                C2538c.m12677c("QuestionSurveyDB", "insertDBTable Exception e!!!");
            }
        }
        return j;
    }

    public boolean m12282a(C2442a c2442a, String str) {
        Cursor queryStorageData;
        boolean moveToFirst;
        if (str == null || "".equals(str)) {
            return false;
        }
        try {
            queryStorageData = c2442a.queryStorageData("questionSurvey", 1, "deviceID='" + str + "'");
            if (queryStorageData == null) {
                return false;
            }
            try {
                moveToFirst = queryStorageData.moveToFirst();
                try {
                    queryStorageData.close();
                    return moveToFirst;
                } catch (Exception e) {
                    if (queryStorageData != null) {
                        queryStorageData.close();
                    }
                    C2538c.m12677c("QuestionSurveyDB", "isDeviceIDInDBTable Exception e!!!");
                    return moveToFirst;
                }
            } catch (Exception e2) {
                moveToFirst = false;
                if (queryStorageData != null) {
                    queryStorageData.close();
                }
                C2538c.m12677c("QuestionSurveyDB", "isDeviceIDInDBTable Exception e!!!");
                return moveToFirst;
            }
        } catch (Exception e3) {
            queryStorageData = null;
            moveToFirst = false;
            if (queryStorageData != null) {
                queryStorageData.close();
            }
            C2538c.m12677c("QuestionSurveyDB", "isDeviceIDInDBTable Exception e!!!");
            return moveToFirst;
        }
    }

    public QstnSurveyTable m12284b(C2442a c2442a, String str) {
        Cursor queryStorageData;
        QstnSurveyTable qstnSurveyTable = null;
        if (str != null) {
            try {
                queryStorageData = c2442a.queryStorageData("questionSurvey", 1, "deviceID='" + str + "'");
                if (queryStorageData != null) {
                    try {
                        if (queryStorageData.moveToFirst()) {
                            QstnSurveyTable qstnSurveyTable2 = new QstnSurveyTable();
                            try {
                                qstnSurveyTable2.deviceID = queryStorageData.getString(queryStorageData.getColumnIndex("deviceID"));
                                qstnSurveyTable2.lastSurveyTime = queryStorageData.getLong(queryStorageData.getColumnIndex("lastSurveyTime"));
                                qstnSurveyTable2.deviceType = queryStorageData.getString(queryStorageData.getColumnIndex("deviceType"));
                                qstnSurveyTable2.times = Integer.valueOf(queryStorageData.getInt(queryStorageData.getColumnIndex("times")));
                                qstnSurveyTable2.id = queryStorageData.getInt(queryStorageData.getColumnIndex("questionid"));
                                qstnSurveyTable2.surveyID = queryStorageData.getString(queryStorageData.getColumnIndex(QstnSurveyCommitParam.surveyID));
                                qstnSurveyTable = qstnSurveyTable2;
                            } catch (Exception e) {
                                qstnSurveyTable = qstnSurveyTable2;
                                if (queryStorageData != null) {
                                    queryStorageData.close();
                                }
                                C2538c.m12677c("QuestionSurveyDB", "selectSurveyTableByDeviceId Exception e!!!");
                                return qstnSurveyTable;
                            }
                        }
                    } catch (Exception e2) {
                        if (queryStorageData != null) {
                            queryStorageData.close();
                        }
                        C2538c.m12677c("QuestionSurveyDB", "selectSurveyTableByDeviceId Exception e!!!");
                        return qstnSurveyTable;
                    }
                }
                if (queryStorageData != null) {
                    queryStorageData.close();
                }
            } catch (Exception e3) {
                queryStorageData = null;
                if (queryStorageData != null) {
                    queryStorageData.close();
                }
                C2538c.m12677c("QuestionSurveyDB", "selectSurveyTableByDeviceId Exception e!!!");
                return qstnSurveyTable;
            }
        }
        return qstnSurveyTable;
    }

    public int m12283b(C2442a c2442a, QstnSurveyTable qstnSurveyTable) {
        int i = 0;
        if (qstnSurveyTable != null) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("lastSurveyTime", Long.valueOf(qstnSurveyTable.lastSurveyTime));
                contentValues.put("times", qstnSurveyTable.times);
                contentValues.put(QstnSurveyCommitParam.surveyID, qstnSurveyTable.surveyID);
                contentValues.put("questionid", Integer.valueOf(qstnSurveyTable.id));
                i = c2442a.updateStorageData("questionSurvey", 1, contentValues, "deviceID ='" + qstnSurveyTable.deviceID + "'");
            } catch (Exception e) {
                C2538c.m12677c("QuestionSurveyDB", "upDateSurveyTableByDeviceId Exception e!!!");
            }
        }
        return i;
    }
}
