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

public class HWDeviceGPSFileWrokoutManager extends a implements IParser {
    private static final String TAG = "HWDeviceGPSFileWrokoutManager";
    private static HWDeviceGPSFileWrokoutManager mInstance = null;
    private Context mContext = null;

    public static HWDeviceGPSFileWrokoutManager getInstance() {
        if (mInstance == null) {
            mInstance = new HWDeviceGPSFileWrokoutManager(BaseApplication.b());
        }
        return mInstance;
    }

    private HWDeviceGPSFileWrokoutManager(Context context) {
        super(context);
        this.mContext = context;
        C2538c.b(TAG, new Object[]{"HWDeviceGPSFileWrokoutManager() context = " + this.mContext});
    }

    public void getWorkOutDetailFromDevice(List<Integer> list, C4334c c4334c) {
        C2538c.c(TAG, new Object[]{"getWorkOutDetailFromDevice!"});
        TransferFileInfo transferFileInfo = new TransferFileInfo();
        transferFileInfo.setType(1);
        transferFileInfo.setGpsType(1);
        transferFileInfo.setRecordId(list);
        p.a().a(transferFileInfo, c4334c);
    }

    public void getResult(byte[] bArr) {
    }

    protected Integer getModuleId() {
        return Integer.valueOf(1012);
    }

    protected void onDestroy() {
        super.onDestroy();
    }
}
