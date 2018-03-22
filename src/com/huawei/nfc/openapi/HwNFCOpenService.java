package com.huawei.nfc.openapi;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Process;
import android.os.RemoteException;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.openapi.impl.HwNFCOpenApiImpl;
import com.huawei.nfc.sdk.service.IHwNFCOpenService.Stub;
import java.util.Arrays;

public class HwNFCOpenService extends Service {
    public static final String OPENAPI_ACTION = "com.huawei.nfc.action.OPEN_API";
    private IBinder mBinder;

    class HwNFCOpenServiceImpl extends Stub {
        private String mCallerPkg;
        private Context mContext;
        private HwNFCOpenApi mOperator;

        public HwNFCOpenServiceImpl(Context context) {
            this.mContext = context;
            this.mOperator = HwNFCOpenApiImpl.getInstance(context);
        }

        public int createSSD(String str, String str2, String str3, String str4) throws RemoteException {
            return this.mOperator.createSSD(this.mCallerPkg, str, str2, str3, str4);
        }

        public int deleteSSD(String str, String str2, String str3, String str4) throws RemoteException {
            return this.mOperator.deleteSSD(this.mCallerPkg, str, str2, str3, str4);
        }

        public String getCplc() throws RemoteException {
            return this.mOperator.getCplc(this.mCallerPkg);
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            String[] packagesForUid = this.mContext.getPackageManager().getPackagesForUid(getCallingUid());
            if (packagesForUid != null && packagesForUid.length > 0) {
                LogX.m5465d("HwESESSDService the caller pkg [ " + Arrays.toString(packagesForUid) + " ]");
                this.mCallerPkg = packagesForUid[0];
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }
    }

    public IBinder onBind(Intent intent) {
        if (OPENAPI_ACTION.equals(intent.getAction())) {
            return this.mBinder;
        }
        return null;
    }

    public void onCreate() {
        LogX.m5475i("HwNFCOpenService onCreate");
        this.mBinder = new HwNFCOpenServiceImpl(getApplicationContext());
        super.onCreate();
    }

    public void onDestroy() {
        LogX.m5475i("HwNFCOpenService onDestory");
        this.mBinder = null;
        super.onDestroy();
        Process.killProcess(Process.myPid());
    }
}
