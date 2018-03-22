package com.huawei.hwservicesmgr.remote;

import android.content.Context;
import com.huawei.hwbasemgr.a;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.datatypes.TransferFileInfo;
import com.huawei.hwservicesmgr.a.b.p;
import com.huawei.hwservicesmgr.remote.parser.IParser;
import com.huawei.p029c.C4334c;
import com.huawei.p190v.C2538c;

import java.util.List;

public class HWDeviceGPSFileRunPlanManager extends a implements IParser {
    private static final String TAG = "HWDeviceGPSFileRunPlanManager";
    private static HWDeviceGPSFileRunPlanManager mInstance = null;
    private Context mContext = null;

    public static HWDeviceGPSFileRunPlanManager getInstance() {
        if (mInstance == null) {
            mInstance = new HWDeviceGPSFileRunPlanManager(BaseApplication.b());
        }
        return mInstance;
    }

    private HWDeviceGPSFileRunPlanManager(Context context) {
        super(context);
        this.mContext = context;
        C2538c.b(TAG, new Object[]{"HWDeviceGPSFileRunPlanManager() context = " + this.mContext});
    }

    public void getRunPlanDetailFromDevice(List<Integer> list, C4334c c4334c) {
        C2538c.c(TAG, new Object[]{"getRunPlanDetailFromDevice!"});
        TransferFileInfo transferFileInfo = new TransferFileInfo();
        transferFileInfo.setType(1);
        transferFileInfo.setGpsType(2);
        transferFileInfo.setRecordId(list);
        p.a().a(transferFileInfo, c4334c);
    }

    public void getResult(byte[] bArr) {
    }

    protected Integer getModuleId() {
        return Integer.valueOf(1013);
    }

    protected void onDestroy() {
        super.onDestroy();
    }
}
