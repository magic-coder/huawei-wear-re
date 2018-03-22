package com.unionpay.tsmservice;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.unionpay.tsmservice.ITsmActivityCallback.Stub;

public class TsmActivityListener extends Stub {
    private Context mContext;

    public TsmActivityListener(Context context) {
        this.mContext = context;
    }

    public void StartActivity(String str, String str2, Bundle bundle) throws RemoteException {
        ComponentName componentName = new ComponentName(str, str2);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        intent.setComponent(componentName);
        this.mContext.startActivity(intent);
    }
}
