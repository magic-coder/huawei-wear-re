package com.huawei.p461i;

import com.huawei.datatype.DBTableKeyInfo;
import com.huawei.hwid.core.constants.HwAccountConstants;
import java.util.ArrayList;
import java.util.List;

/* compiled from: HWAlarmManager */
class C5397e implements Runnable {
    final /* synthetic */ C5393a f19213a;

    C5397e(C5393a c5393a) {
        this.f19213a = c5393a;
    }

    public void run() {
        int i = 0;
        List arrayList = new ArrayList();
        DBTableKeyInfo dBTableKeyInfo = new DBTableKeyInfo();
        dBTableKeyInfo.setKeyName("event_alarm_enable");
        dBTableKeyInfo.setKeyType("integer");
        DBTableKeyInfo dBTableKeyInfo2 = new DBTableKeyInfo();
        dBTableKeyInfo2.setKeyName("event_alarm_time");
        dBTableKeyInfo2.setKeyType("varchar(50)");
        DBTableKeyInfo dBTableKeyInfo3 = new DBTableKeyInfo();
        dBTableKeyInfo3.setKeyName("event_alarm_cycle");
        dBTableKeyInfo3.setKeyType("integer");
        DBTableKeyInfo dBTableKeyInfo4 = new DBTableKeyInfo();
        dBTableKeyInfo4.setKeyName("event_alarm_name");
        dBTableKeyInfo4.setKeyType("varchar(50)");
        DBTableKeyInfo dBTableKeyInfo5 = new DBTableKeyInfo();
        dBTableKeyInfo5.setKeyName("User_ID");
        dBTableKeyInfo5.setKeyType("varchar(50)");
        arrayList.add(dBTableKeyInfo);
        arrayList.add(dBTableKeyInfo2);
        arrayList.add(dBTableKeyInfo3);
        arrayList.add(dBTableKeyInfo4);
        arrayList.add(dBTableKeyInfo5);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("event_alarm_index integer,");
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (i2 + 1 == arrayList.size()) {
                stringBuilder.append(((DBTableKeyInfo) arrayList.get(i2)).getKeyName()).append(HwAccountConstants.BLANK).append(((DBTableKeyInfo) arrayList.get(i2)).getKeyType());
            } else {
                stringBuilder.append(((DBTableKeyInfo) arrayList.get(i2)).getKeyName()).append(HwAccountConstants.BLANK).append(((DBTableKeyInfo) arrayList.get(i2)).getKeyType()).append(",");
            }
        }
        this.f19213a.createStorageDataTable("event_alarm", 1, stringBuilder.toString());
        arrayList.clear();
        dBTableKeyInfo = new DBTableKeyInfo();
        dBTableKeyInfo.setKeyName("smart_alarm_enable");
        dBTableKeyInfo.setKeyType("integer");
        dBTableKeyInfo2 = new DBTableKeyInfo();
        dBTableKeyInfo2.setKeyName("smart_alarm_time");
        dBTableKeyInfo2.setKeyType("varchar(50)");
        dBTableKeyInfo3 = new DBTableKeyInfo();
        dBTableKeyInfo3.setKeyName("smart_alarm_cycle");
        dBTableKeyInfo3.setKeyType("integer");
        dBTableKeyInfo4 = new DBTableKeyInfo();
        dBTableKeyInfo4.setKeyName("smart_alarm_ahead_time");
        dBTableKeyInfo4.setKeyType("integer");
        dBTableKeyInfo5 = new DBTableKeyInfo();
        dBTableKeyInfo5.setKeyName("User_ID");
        dBTableKeyInfo5.setKeyType("varchar(50)");
        arrayList.add(dBTableKeyInfo);
        arrayList.add(dBTableKeyInfo2);
        arrayList.add(dBTableKeyInfo3);
        arrayList.add(dBTableKeyInfo4);
        arrayList.add(dBTableKeyInfo5);
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("smart_alarm_index integer,");
        while (i < arrayList.size()) {
            if (i + 1 == arrayList.size()) {
                stringBuilder2.append(((DBTableKeyInfo) arrayList.get(i)).getKeyName()).append(HwAccountConstants.BLANK).append(((DBTableKeyInfo) arrayList.get(i)).getKeyType());
            } else {
                stringBuilder2.append(((DBTableKeyInfo) arrayList.get(i)).getKeyName()).append(HwAccountConstants.BLANK).append(((DBTableKeyInfo) arrayList.get(i)).getKeyType()).append(",");
            }
            i++;
        }
        this.f19213a.createStorageDataTable("smart_alarm", 1, stringBuilder2.toString());
        this.f19213a.m25985b(new C5398f(this));
    }
}
