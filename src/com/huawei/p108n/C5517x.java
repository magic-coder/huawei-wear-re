package com.huawei.p108n;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.huawei.datatype.DBObject;
import com.huawei.datatype.DataDeviceAvoidDisturbInfo;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.n.c;
import com.huawei.p190v.C2538c;
import com.huawei.ui.main.stories.lightcloud.constants.JoinConstants;
import java.util.ArrayList;
import java.util.List;

/* compiled from: HWDeviceConfigManager */
class C5517x extends Handler {
    final /* synthetic */ c f19425a;

    public C5517x(c cVar, Looper looper) {
        this.f19425a = cVar;
        super(looper);
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        DBObject dBObject;
        ContentValues contentValues;
        switch (message.what) {
            case 1:
                dBObject = (DBObject) message.obj;
                IBaseResponseCallback iBaseResponseCallback = dBObject.getiBaseResponseCallback();
                List<DataDeviceAvoidDisturbInfo> list = (List) dBObject.getObject();
                long j = 0;
                int i = 0;
                for (DataDeviceAvoidDisturbInfo dataDeviceAvoidDisturbInfo : list) {
                    if (i != list.size()) {
                        contentValues = new ContentValues();
                        contentValues.put("User_ID", c.j());
                        contentValues.put("indexs", Integer.valueOf(i + 1));
                        contentValues.put("switch", Integer.valueOf(dataDeviceAvoidDisturbInfo.getDevice_avoid_disturb_switch()));
                        contentValues.put("time_switch", Integer.valueOf(dataDeviceAvoidDisturbInfo.getDevice_avoid_disturb_time_switch()));
                        contentValues.put("type", Integer.valueOf(dataDeviceAvoidDisturbInfo.getDevice_avoid_disturb_type()));
                        contentValues.put("start_time", C0973a.d(dataDeviceAvoidDisturbInfo.getDevice_avoid_disturb_start_time()));
                        contentValues.put("end_time", C0973a.d(dataDeviceAvoidDisturbInfo.getDevice_avoid_disturb_end_time()));
                        contentValues.put(JoinConstants.CYCLE, Integer.valueOf(dataDeviceAvoidDisturbInfo.getDevice_avoid_disturb_cycle()));
                        j = this.f19425a.insertStorageData("avoid_disturb", 1, contentValues);
                        if (-1 != j) {
                            i++;
                        } else if (-1 != j && iBaseResponseCallback != null) {
                            iBaseResponseCallback.onResponse(-1, Integer.valueOf(101001));
                            return;
                        } else if (iBaseResponseCallback != null) {
                            iBaseResponseCallback.onResponse(0, Integer.valueOf(100000));
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                }
                if (-1 != j) {
                }
                if (iBaseResponseCallback != null) {
                    iBaseResponseCallback.onResponse(0, Integer.valueOf(100000));
                    return;
                }
                return;
            case 2:
                dBObject = (DBObject) message.obj;
                IBaseResponseCallback iBaseResponseCallback2 = dBObject.getiBaseResponseCallback();
                for (DataDeviceAvoidDisturbInfo dataDeviceAvoidDisturbInfo2 : (List) dBObject.getObject()) {
                    contentValues = new ContentValues();
                    contentValues.put("User_ID", c.j());
                    contentValues.put("indexs", Integer.valueOf(dataDeviceAvoidDisturbInfo2.getDevice_avoid_disturb_index()));
                    contentValues.put("switch", Integer.valueOf(dataDeviceAvoidDisturbInfo2.getDevice_avoid_disturb_switch()));
                    contentValues.put("time_switch", Integer.valueOf(dataDeviceAvoidDisturbInfo2.getDevice_avoid_disturb_time_switch()));
                    contentValues.put("type", Integer.valueOf(dataDeviceAvoidDisturbInfo2.getDevice_avoid_disturb_type()));
                    contentValues.put("start_time", C0973a.d(dataDeviceAvoidDisturbInfo2.getDevice_avoid_disturb_start_time()));
                    contentValues.put("end_time", C0973a.d(dataDeviceAvoidDisturbInfo2.getDevice_avoid_disturb_end_time()));
                    contentValues.put(JoinConstants.CYCLE, Integer.valueOf(dataDeviceAvoidDisturbInfo2.getDevice_avoid_disturb_cycle()));
                    this.f19425a.updateStorageData("avoid_disturb", 1, contentValues, "User_ID='" + c.j() + "' AND indexs='" + dataDeviceAvoidDisturbInfo2.getDevice_avoid_disturb_index() + "'");
                }
                if (iBaseResponseCallback2 != null) {
                    iBaseResponseCallback2.onResponse(0, Integer.valueOf(100000));
                    return;
                }
                return;
            case 3:
                IBaseResponseCallback iBaseResponseCallback3 = (IBaseResponseCallback) message.obj;
                List arrayList = new ArrayList();
                Cursor queryStorageData = this.f19425a.queryStorageData("avoid_disturb", 1, "User_ID='" + c.j() + "'");
                if (queryStorageData != null) {
                    while (queryStorageData.moveToNext()) {
                        DataDeviceAvoidDisturbInfo dataDeviceAvoidDisturbInfo3 = new DataDeviceAvoidDisturbInfo();
                        dataDeviceAvoidDisturbInfo3.setDevice_avoid_disturb_index(queryStorageData.getInt(queryStorageData.getColumnIndex("indexs")));
                        dataDeviceAvoidDisturbInfo3.setDevice_avoid_disturb_switch(queryStorageData.getInt(queryStorageData.getColumnIndex("switch")));
                        dataDeviceAvoidDisturbInfo3.setDevice_avoid_disturb_time_switch(queryStorageData.getInt(queryStorageData.getColumnIndex("time_switch")));
                        dataDeviceAvoidDisturbInfo3.setDevice_avoid_disturb_type(queryStorageData.getInt(queryStorageData.getColumnIndex("type")));
                        dataDeviceAvoidDisturbInfo3.setDevice_avoid_disturb_start_time(C0973a.f(queryStorageData.getString(queryStorageData.getColumnIndex("start_time"))));
                        dataDeviceAvoidDisturbInfo3.setDevice_avoid_disturb_end_time(C0973a.f(queryStorageData.getString(queryStorageData.getColumnIndex("end_time"))));
                        dataDeviceAvoidDisturbInfo3.setDevice_avoid_disturb_cycle(queryStorageData.getInt(queryStorageData.getColumnIndex(JoinConstants.CYCLE)));
                        arrayList.add(dataDeviceAvoidDisturbInfo3);
                    }
                    queryStorageData.close();
                    iBaseResponseCallback3.onResponse(0, arrayList);
                    return;
                }
                C2538c.c("HWDeviceConfigManager", new Object[]{"cursor is null"});
                iBaseResponseCallback3.onResponse(100001, arrayList);
                return;
            case 4:
                for (Integer intValue : (List) message.obj) {
                    this.f19425a.deleteStorageData("avoid_disturb", 1, "User_ID='" + c.j() + "' AND indexs=" + intValue.intValue());
                }
                return;
            default:
                return;
        }
    }
}
