package com.huawei.p108n;

import com.huawei.datatype.DBTableKeyInfo;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.n.c;
import com.huawei.ui.main.stories.lightcloud.constants.JoinConstants;
import java.util.ArrayList;
import java.util.List;

/* compiled from: HWDeviceConfigManager */
class C5512s implements Runnable {
    final /* synthetic */ c f19419a;

    C5512s(c cVar) {
        this.f19419a = cVar;
    }

    public void run() {
        List arrayList = new ArrayList();
        DBTableKeyInfo dBTableKeyInfo = new DBTableKeyInfo();
        dBTableKeyInfo.setKeyName("indexs");
        dBTableKeyInfo.setKeyType("integer");
        DBTableKeyInfo dBTableKeyInfo2 = new DBTableKeyInfo();
        dBTableKeyInfo2.setKeyName("switch");
        dBTableKeyInfo2.setKeyType("integer");
        DBTableKeyInfo dBTableKeyInfo3 = new DBTableKeyInfo();
        dBTableKeyInfo3.setKeyName("time_switch");
        dBTableKeyInfo3.setKeyType("integer");
        DBTableKeyInfo dBTableKeyInfo4 = new DBTableKeyInfo();
        dBTableKeyInfo4.setKeyName("type");
        dBTableKeyInfo4.setKeyType("integer");
        DBTableKeyInfo dBTableKeyInfo5 = new DBTableKeyInfo();
        dBTableKeyInfo5.setKeyName("start_time");
        dBTableKeyInfo5.setKeyType("varchar(50)");
        DBTableKeyInfo dBTableKeyInfo6 = new DBTableKeyInfo();
        dBTableKeyInfo6.setKeyName("end_time");
        dBTableKeyInfo6.setKeyType("varchar(50)");
        DBTableKeyInfo dBTableKeyInfo7 = new DBTableKeyInfo();
        dBTableKeyInfo7.setKeyName(JoinConstants.CYCLE);
        dBTableKeyInfo7.setKeyType("integer");
        arrayList.add(dBTableKeyInfo);
        arrayList.add(dBTableKeyInfo2);
        arrayList.add(dBTableKeyInfo3);
        arrayList.add(dBTableKeyInfo4);
        arrayList.add(dBTableKeyInfo5);
        arrayList.add(dBTableKeyInfo6);
        arrayList.add(dBTableKeyInfo7);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("User_ID varchar(50) primary key,");
        for (int i = 0; i < arrayList.size(); i++) {
            if (i + 1 == arrayList.size()) {
                stringBuilder.append(((DBTableKeyInfo) arrayList.get(i)).getKeyName()).append(HwAccountConstants.BLANK).append(((DBTableKeyInfo) arrayList.get(i)).getKeyType());
            } else {
                stringBuilder.append(((DBTableKeyInfo) arrayList.get(i)).getKeyName()).append(HwAccountConstants.BLANK).append(((DBTableKeyInfo) arrayList.get(i)).getKeyType()).append(",");
            }
        }
        this.f19419a.createStorageDataTable("avoid_disturb", 1, stringBuilder.toString());
        this.f19419a.d(new C5513t(this));
    }
}
