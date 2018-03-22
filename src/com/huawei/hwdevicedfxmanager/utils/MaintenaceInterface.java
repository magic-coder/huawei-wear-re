package com.huawei.hwdevicedfxmanager.utils;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwdevicemgr.dmsdatatype.datatype.DeviceCommand;
import java.util.ArrayList;
import java.util.Date;

public interface MaintenaceInterface {
    void cutFolder(String str, String str2);

    void deleteTenDayFile();

    ArrayList filtertFile(ArrayList arrayList, int i);

    String getDayDateTime();

    String getDeviceName(int i);

    String getMaintCheckTime();

    int getMaintRetryNum();

    boolean getMaintRetryResult();

    String getmTransferDataContentPath();

    String getmTransferStateContentPath();

    void initMaintenanceFile();

    void initMaintenanceParame(int i, String str, String str2);

    DeviceCommand maintParametersCommand();

    void onDestroyMaintenance();

    void save2File(IBaseResponseCallback iBaseResponseCallback, boolean z);

    void setMaintCheckTime(String str);

    void setMaintRetryNum(int i);

    void setMaintRetryResult(boolean z);

    DeviceCommand transferFileEndProcess();

    void writeLogToFile(ArrayList<byte[]> arrayList, String str, Date date);
}
