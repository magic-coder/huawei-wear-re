package com.huawei.nfc.carrera.logic.lostmanager;

import com.huawei.nfc.carrera.logic.lostmanager.callback.CheckDeviceStatusCallback;
import com.huawei.nfc.carrera.logic.lostmanager.callback.HandleDeviceRepairCallback;
import com.huawei.nfc.carrera.logic.lostmanager.callback.HandleServerCardLostMsgCallback;

public interface CardLostManagerApi {
    void checkCardStatusWaitingReport();

    void checkDeviceStatus(CheckDeviceStatusCallback checkDeviceStatusCallback);

    void clearAllNullifiedCardLocalInfo();

    void clearNullifiedCardLocalInfo(String str);

    void handleDeviceRepair(int i, HandleDeviceRepairCallback handleDeviceRepairCallback);

    void handleServerCardLostMessage(String str, String str2, String str3, String str4, HandleServerCardLostMsgCallback handleServerCardLostMsgCallback);

    void reportCardDeletedStatus(String str, String str2);

    void reportCardDeletedStatus(String str, String str2, boolean z);

    void reportCardLockedStatus(String str, String str2);

    void reportCardOpenedAvailableStatus(String str, String str2, String str3, String str4, String str5, int i);

    void reportCardOpenedNotActiveStatus(String str, String str2, String str3, String str4);
}
