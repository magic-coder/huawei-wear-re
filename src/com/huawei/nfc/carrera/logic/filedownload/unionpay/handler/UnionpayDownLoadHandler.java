package com.huawei.nfc.carrera.logic.filedownload.unionpay.handler;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.huawei.nfc.carrera.constant.AutoReportErrorCode;
import com.huawei.nfc.carrera.logic.filedownload.DownLoadListener;
import com.huawei.nfc.carrera.logic.filedownload.unionpay.listener.DownLoadCallback;
import com.huawei.nfc.carrera.server.download.impl.FileDownloadImpl;
import com.huawei.nfc.carrera.ui.bus.exception.ShowBindBusResultActivity;
import com.huawei.nfc.carrera.util.LogX;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.cookie.ClientCookie;

public class UnionpayDownLoadHandler extends Handler {
    public static final int DOWNLOAD_CANCEL = 5;
    private static final int DOWNLOAD_CONNECTED = 6;
    private static final int DOWNLOAD_FAILED = 2;
    private static final int DOWNLOAD_PROGRESS = 3;
    private static final int DOWNLOAD_REQUEST = 4;
    private static final int DOWNLOAD_SUCCESS = 1;
    private DownLoadCallback downLoadCallback;
    FileDownloadImpl fileDownloadApi = new FileDownloadImpl(this.mContext);
    private String filePath;
    private final Context mContext;

    public UnionpayDownLoadHandler(Context context, DownLoadCallback downLoadCallback) {
        this.downLoadCallback = downLoadCallback;
        this.mContext = context;
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (this.downLoadCallback == null) {
            Map hashMap = new HashMap();
            hashMap.put(ShowBindBusResultActivity.FAIL_REASON_KEY, "Unionpay Download, callback is null");
            LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_CUP_ADDON_ERR, hashMap, "download callback is null ，you need excute registeListeners()  method  before download() method", false, false);
            return;
        }
        Bundle data;
        switch (message.what) {
            case 1:
                this.downLoadCallback.downLoadSuccess((String) message.obj);
                return;
            case 2:
                this.downLoadCallback.downLoadFailed(message.arg1);
                return;
            case 3:
                data = message.getData();
                this.downLoadCallback.downProgress(data.getInt("progress"), data.getLong("currentSize"));
                return;
            case 4:
                data = message.getData();
                downLoad(data.getString("url"), data.getString(ClientCookie.PATH_ATTR));
                return;
            case 5:
                this.fileDownloadApi.cancelDownLoad();
                return;
            case 6:
                this.downLoadCallback.downLoadConnected(((Long) message.obj).longValue());
                return;
            default:
                hashMap = new HashMap();
                hashMap.put(ShowBindBusResultActivity.FAIL_REASON_KEY, "Unionpay Download, invalid message info : " + message.what);
                LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_CUP_ADDON_ERR, hashMap, "Unionpay Download, invalid message info : " + message.what, false, false);
                return;
        }
    }

    private void sendSuccessMessage(String str) {
        Message obtainMessage = obtainMessage(1);
        obtainMessage.obj = str;
        obtainMessage.sendToTarget();
    }

    private void sendProgressMessage(int i, long j) {
        Message obtainMessage = obtainMessage(3);
        Bundle data = obtainMessage.getData();
        data.putInt("progress", i);
        data.putLong("currentSize", j);
        obtainMessage.setData(data);
        obtainMessage.sendToTarget();
    }

    private void sendFailedMessage(int i) {
        Message obtainMessage = obtainMessage(2);
        obtainMessage.arg1 = i;
        obtainMessage.sendToTarget();
    }

    public void sendDownMessage(String str, String str2) {
        Message obtainMessage = obtainMessage(4);
        Bundle bundle = new Bundle();
        bundle.putString("url", str);
        bundle.putString(ClientCookie.PATH_ATTR, str2);
        obtainMessage.setData(bundle);
        obtainMessage.sendToTarget();
    }

    private void downLoad(final String str, final String str2) {
        new Thread() {

            class C55481 implements DownLoadListener {
                C55481() {
                }

                public void downProgress(int i, long j, String str) {
                    UnionpayDownLoadHandler.this.filePath = str;
                    UnionpayDownLoadHandler.this.sendProgressMessage(i, j);
                }

                public void downLoadConnected(long j) {
                    UnionpayDownLoadHandler.this.sendConnectedMessage(j);
                }
            }

            public void run() {
                int download = UnionpayDownLoadHandler.this.fileDownloadApi.download(str, new File(str2), new C55481());
                if (download == 0) {
                    UnionpayDownLoadHandler.this.sendSuccessMessage(UnionpayDownLoadHandler.this.filePath);
                } else if (download == -5) {
                    UnionpayDownLoadHandler.this.sendFailedMessage(5);
                } else {
                    UnionpayDownLoadHandler.this.sendFailedMessage(download);
                }
            }
        }.start();
    }

    public void sendCancelMessage() {
        sendEmptyMessage(5);
    }

    private void sendConnectedMessage(long j) {
        Message obtainMessage = obtainMessage(6);
        obtainMessage.obj = Long.valueOf(j);
        obtainMessage.sendToTarget();
    }

    public void unregisterListener() {
        this.downLoadCallback = null;
    }
}
