package com.huawei.nfc.carrera.logic.cardinfo.impl.pic;

import android.content.Context;
import com.huawei.nfc.carrera.server.ServerServiceFactory;
import com.huawei.nfc.carrera.ui.bus.exception.ShowBindBusResultActivity;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.p190v.C2538c;
import com.huawei.wallet.storage.path.NfcStorageUtil;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

abstract class CardPicDownloadTask implements Runnable {
    private static final String SUFFIX = ".tmp";
    private static final String TAG = "CardPicDownloadTask";
    protected String curId;
    private String curRemoteUrl;
    protected Context mContext;

    protected abstract boolean editPicFile(String str);

    protected abstract String getPicDirPath();

    protected abstract String getPicFilePath();

    protected abstract void handleDownloadResult(String str, int i);

    protected CardPicDownloadTask(Context context, String str, String str2) {
        this.mContext = context;
        this.curId = str;
        this.curRemoteUrl = str2;
    }

    public void run() {
        C2538c.b(TAG, new Object[]{"CardPicDownloadTask begin id = " + this.curId});
        if (!createStorageDir()) {
            C2538c.e(TAG, new Object[]{"createStorageDir failed."});
            handleDownloadResult(this.curId, -2);
        } else if (!createStorageFile()) {
            C2538c.e(TAG, new Object[]{"createStorageFile failed."});
            handleDownloadResult(this.curId, -3);
        } else if (downloadPicFile()) {
            C2538c.b(TAG, new Object[]{"downloadPicFile success"});
            handleDownloadResult(this.curId, 1);
        } else {
            C2538c.e(TAG, new Object[]{"downloadPicFile failed"});
            handleDownloadResult(this.curId, -1);
        }
    }

    private boolean createStorageDir() {
        String picDirPath = getPicDirPath();
        C2538c.b(TAG, new Object[]{"createStorageDir, picDirPath : " + picDirPath});
        if (StringUtil.isEmpty(picDirPath, true)) {
            C2538c.e(TAG, new Object[]{"createStorageDir, but picDirPath is illegal."});
            return false;
        } else if (!createDirectory(NfcStorageUtil.m28132a(this.mContext)) || !createDirectory(picDirPath)) {
            return false;
        } else {
            C2538c.b(TAG, new Object[]{"createDirectory success"});
            return true;
        }
    }

    private boolean createDirectory(String str) {
        C2538c.b(TAG, new Object[]{"createDirectory, dirPath: " + str});
        File file = new File(str);
        if ((file.exists() && file.isDirectory()) || file.mkdirs()) {
            return true;
        }
        C2538c.b(TAG, new Object[]{"createDirectory return false"});
        return false;
    }

    private boolean createStorageFile() {
        boolean delete;
        boolean z = false;
        C2538c.b(TAG, new Object[]{"enter createStorageFile"});
        File file = new File(getTmpPicFilePath());
        if (file.exists()) {
            delete = file.getAbsoluteFile().delete();
        } else {
            delete = true;
        }
        if (delete) {
            try {
                z = file.createNewFile();
            } catch (IOException e) {
                C2538c.e(TAG, new Object[]{"createStorageFile, create new file io exception."});
            }
        } else {
            C2538c.e(TAG, new Object[]{"createStorageFile, delete old file failed. tmpPicFilePath : " + r3, Boolean.valueOf(true)});
        }
        return z;
    }

    private boolean downloadPicFile() {
        C2538c.b(TAG, new Object[]{"enter downloadPicFile"});
        File file = new File(getTmpPicFilePath());
        int download = ServerServiceFactory.createFileDownloadApi(this.mContext).download(this.curRemoteUrl, file);
        C2538c.c(TAG, new Object[]{"downloadPicFile result: " + download});
        if (download != 0) {
            if (!(-1 == download || -5 == download || -3 == download)) {
                Map hashMap = new HashMap();
                String str = "downloadPicFile  failed. resultCode : " + download;
                hashMap.put("url", this.curRemoteUrl);
                hashMap.put(ShowBindBusResultActivity.FAIL_REASON_KEY, str);
                C2538c.e(TAG, new Object[]{" errorMsgs : " + hashMap + " ; message : " + str});
            }
            return false;
        } else if (editPicFile(file.getAbsolutePath())) {
            return true;
        } else {
            String picFilePath = getPicFilePath();
            C2538c.c(TAG, new Object[]{"downloadPicFile picFilePath: " + picFilePath + ",tmpPicFilePath=" + r2});
            return file.renameTo(new File(picFilePath));
        }
    }

    private String getTmpPicFilePath() {
        return getPicFilePath() + SUFFIX;
    }
}
