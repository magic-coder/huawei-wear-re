package com.huawei.nfc.carrera.logic.filedownload.unionpay;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.huawei.nfc.carrera.constant.Constant;
import com.huawei.nfc.carrera.logic.filedownload.unionpay.handler.RequestUnionpayInfoHandler;
import com.huawei.nfc.carrera.logic.filedownload.unionpay.handler.UnionpayDownLoadHandler;
import com.huawei.nfc.carrera.logic.filedownload.unionpay.handler.UnionpayInstallHandler;
import com.huawei.nfc.carrera.logic.filedownload.unionpay.listener.DownLoadCallback;
import com.huawei.nfc.carrera.logic.filedownload.unionpay.listener.UnionpayInfoCallback;
import com.huawei.nfc.carrera.logic.filedownload.unionpay.listener.UnionpayInstallCallBack;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.wallet.logic.install.PackageInstallHelper;
import com.huawei.wallet.utils.SHA_256;
import java.io.File;

public class UnionpayComponent {
    private DownLoadCallback callback;
    private UnionpayDownLoadHandler downLoadHandler;
    private UnionpayInfoCallback infoCallBack;
    private UnionpayInstallCallBack installCallBack;
    private UnionpayInstallHandler installHandler;
    private String localSavePath = "";
    private Context mContext;
    private PackageInstallHelper packageInstallHelper;
    private RequestUnionpayInfoHandler unionpayInfoHandler;

    public UnionpayComponent(Context context) {
        this.mContext = context;
    }

    public void registerListeners(UnionpayInstallCallBack unionpayInstallCallBack, UnionpayInfoCallback unionpayInfoCallback, DownLoadCallback downLoadCallback) {
        this.unionpayInfoHandler = new RequestUnionpayInfoHandler(this.mContext, unionpayInfoCallback);
        this.installHandler = new UnionpayInstallHandler(unionpayInstallCallBack);
        this.downLoadHandler = new UnionpayDownLoadHandler(this.mContext, downLoadCallback);
    }

    public void unregisterListeners() {
        if (this.unionpayInfoHandler != null) {
            this.unionpayInfoHandler.unregisterListener();
        }
        if (this.installHandler != null) {
            this.installHandler.unregisterListener();
        }
        if (this.downLoadHandler != null) {
            this.downLoadHandler.unregisterListener();
        }
    }

    public void install(final String str) {
        if (this.installHandler == null) {
            this.installHandler = new UnionpayInstallHandler(this.installCallBack);
        }
        final File file = new File(getAPKPath());
        if (new File(getLocalSavePath()).renameTo(file)) {
            new Thread() {
                public void run() {
                    if (UnionpayComponent.this.checkSign(file, str)) {
                        UnionpayComponent.this.installDirect(file);
                    } else {
                        UnionpayComponent.this.installHandler.sendWrongSignMessage();
                    }
                }
            }.start();
            return;
        }
        this.installHandler.sendFailedMessage();
        LogX.e("apk rename failed");
    }

    public boolean isAppHasInstallPermission() {
        if (this.packageInstallHelper == null) {
            this.packageInstallHelper = new PackageInstallHelper();
        }
        return this.packageInstallHelper.m28057a(this.mContext);
    }

    public void cleanTemp() {
        File file = new File(getLocalSavePath());
        if (!file.exists() || !file.delete()) {
            LogX.e("delete unionpay temp failed");
        }
    }

    public boolean delete() {
        File file = new File(getAPKPath());
        if (file.exists() && file.delete()) {
            return true;
        }
        LogX.e("unionpay apk delete failed");
        return false;
    }

    public void download(String str, String str2) {
        if (this.downLoadHandler == null) {
            this.downLoadHandler = new UnionpayDownLoadHandler(this.mContext, this.callback);
        }
        this.downLoadHandler.sendDownMessage(str, str2);
    }

    public void cancelDown() {
        if (this.downLoadHandler == null) {
            this.downLoadHandler = new UnionpayDownLoadHandler(this.mContext, this.callback);
        }
        this.downLoadHandler.sendCancelMessage();
    }

    public boolean isLocalFileExist() {
        return new File(getAPKPath()).exists();
    }

    public void getUnionpayAPKInfo() {
        if (this.unionpayInfoHandler == null) {
            this.unionpayInfoHandler = new RequestUnionpayInfoHandler(this.mContext, this.infoCallBack);
        }
        this.unionpayInfoHandler.requestUnionpayInfo();
    }

    public String getLocalSavePath() {
        if (this.mContext == null) {
            return "";
        }
        if (StringUtil.isEmpty(this.localSavePath, true)) {
            File externalCacheDir = this.mContext.getExternalCacheDir();
            if (externalCacheDir == null) {
                return "";
            }
            this.localSavePath = externalCacheDir.getAbsolutePath() + "/nfc/unionpay.temp";
        }
        return this.localSavePath;
    }

    public String getAPKPath() {
        return getLocalSavePath().replace(".temp", ".apk");
    }

    public void setCallback(DownLoadCallback downLoadCallback) {
        this.callback = downLoadCallback;
    }

    public void setInfoCallBack(UnionpayInfoCallback unionpayInfoCallback) {
        this.infoCallBack = unionpayInfoCallback;
    }

    public void setInstallCallBack(UnionpayInstallCallBack unionpayInstallCallBack) {
        this.installCallBack = unionpayInstallCallBack;
    }

    private boolean checkSign(File file, String str) {
        PackageInfo packageArchiveInfo = this.mContext.getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 64);
        if (packageArchiveInfo == null) {
            return false;
        }
        return str.equals(SHA_256.m28475a(packageArchiveInfo.signatures[0].toCharsString(), null));
    }

    private void installDirect(File file) {
        if (this.packageInstallHelper == null) {
            this.packageInstallHelper = new PackageInstallHelper();
        }
        this.packageInstallHelper.m28058a(this.mContext, this.installHandler, file.getAbsolutePath(), Constant.UNIONPAY_PACKAGENAME);
    }
}
