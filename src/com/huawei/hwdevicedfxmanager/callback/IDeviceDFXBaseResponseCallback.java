package com.huawei.hwdevicedfxmanager.callback;

public interface IDeviceDFXBaseResponseCallback {
    void onFailure(int i, String str);

    void onSuccess(int i, String str);
}
