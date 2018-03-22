package com.huawei.wallet.logic.install;

import android.content.pm.IPackageInstallObserver.Stub;
import android.os.Handler;
import android.os.RemoteException;
import android.text.TextUtils;
import com.huawei.wallet.utils.log.LogC;

public class PackageInstallObserver extends Stub {
    private Handler f21268a;
    private String f21269b;

    public PackageInstallObserver(Handler handler, String str) {
        this.f21268a = handler;
        this.f21269b = str;
    }

    public void packageInstalled(String str, int i) throws RemoteException {
        LogC.m28530b("packagename is " + str + ",code is " + i + "=== " + this.f21269b, false);
        if (!TextUtils.isEmpty(this.f21269b) && this.f21269b.equals(str) && i == 1) {
            this.f21268a.sendEmptyMessage(1);
        } else {
            this.f21268a.sendEmptyMessage(-2001);
        }
    }
}
