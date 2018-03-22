package com.huawei.nfc.carrera.logic.cardinfo.impl.pic;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import com.huawei.nfc.carrera.constant.AutoReportErrorCode;
import com.huawei.nfc.carrera.ui.bus.exception.ShowBindBusResultActivity;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.wallet.storage.path.NfcStorageUtil;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

class CardIconDownloadTask extends CardPicDownloadTask {
    private CardIconDownloadResultCallback mCallback;

    CardIconDownloadTask(Context context, String str, String str2, CardIconDownloadResultCallback cardIconDownloadResultCallback) {
        super(context, str, str2);
        this.mCallback = cardIconDownloadResultCallback;
    }

    protected String getPicDirPath() {
        return NfcStorageUtil.m28136c(this.mContext);
    }

    protected String getPicFilePath() {
        return NfcStorageUtil.m28133a(this.mContext, this.curId);
    }

    protected void handleDownloadResult(String str, int i) {
        LogX.i("card icon downloaded productId: " + str + ",result: " + i);
        if (!(i == 1 || i == 0)) {
            Map hashMap = new HashMap();
            String str2 = "CardIconDownloadTask download card product icon failed. resultCode : " + i;
            hashMap.put("productId", str);
            hashMap.put(ShowBindBusResultActivity.FAIL_REASON_KEY, str2);
            LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_DOWNLOAD_CARD_ICON_ERR, hashMap, str2, false, false);
        }
        if (this.mCallback != null) {
            this.mCallback.downloadIconResult(0, str, i);
        }
    }

    protected boolean editPicFile(String str) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        Throwable th;
        Bitmap decodeFile = BitmapFactory.decodeFile(str);
        if (decodeFile == null) {
            return false;
        }
        int height = decodeFile.getHeight();
        Bitmap roundedCornerBitmap = CardPicRescManager.getInstance(this.mContext).getRoundedCornerBitmap(decodeFile, decodeFile.getWidth(), height);
        if (roundedCornerBitmap == null) {
            LogX.d("bitmap is null,return.");
            return false;
        }
        try {
            File file = new File(str + ".tem");
            if (file.exists()) {
                LogX.d("delete .tem file result : " + file.delete());
            }
            fileOutputStream = new FileOutputStream(file);
            try {
                boolean delete;
                roundedCornerBitmap.compress(CompressFormat.PNG, 100, fileOutputStream);
                fileOutputStream.flush();
                File file2 = new File(getPicFilePath());
                if (file2.exists()) {
                    delete = file2.delete();
                } else {
                    delete = true;
                }
                if (!delete) {
                    LogX.d("delete temp file failed.");
                    LogX.d("delete temp file result : " + file.delete());
                    if (fileOutputStream == null) {
                        return false;
                    }
                    try {
                        fileOutputStream.close();
                        return false;
                    } catch (IOException e) {
                        LogX.w("CardIconDownload editPicFile FileOutputStream close failed. IOException");
                        return false;
                    }
                } else if (file.renameTo(file2)) {
                    File file3 = new File(str);
                    if (file3.exists()) {
                        LogX.d("deleteTmpResult : " + file3.delete());
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e2) {
                            LogX.w("CardIconDownload editPicFile FileOutputStream close failed. IOException");
                        }
                    }
                    return true;
                } else {
                    LogX.d("rename failed,return");
                    LogX.d("renameResult : " + file.delete());
                    if (fileOutputStream == null) {
                        return false;
                    }
                    try {
                        fileOutputStream.close();
                        return false;
                    } catch (IOException e3) {
                        LogX.w("CardIconDownload editPicFile FileOutputStream close failed. IOException");
                        return false;
                    }
                }
            } catch (FileNotFoundException e4) {
                fileOutputStream2 = fileOutputStream;
                try {
                    LogX.w("CardIconDownload editPicFile failed. FileNotFoundException");
                    if (fileOutputStream2 != null) {
                        return false;
                    }
                    try {
                        fileOutputStream2.close();
                        return false;
                    } catch (IOException e5) {
                        LogX.w("CardIconDownload editPicFile FileOutputStream close failed. IOException");
                        return false;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e6) {
                            LogX.w("CardIconDownload editPicFile FileOutputStream close failed. IOException");
                        }
                    }
                    throw th;
                }
            } catch (IOException e7) {
                try {
                    LogX.w("CardIconDownload editPicFile failed. IOException");
                    if (fileOutputStream != null) {
                        return false;
                    }
                    try {
                        fileOutputStream.close();
                        return false;
                    } catch (IOException e8) {
                        LogX.w("CardIconDownload editPicFile FileOutputStream close failed. IOException");
                        return false;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw th;
                }
            }
        } catch (FileNotFoundException e9) {
            fileOutputStream2 = null;
            LogX.w("CardIconDownload editPicFile failed. FileNotFoundException");
            if (fileOutputStream2 != null) {
                return false;
            }
            fileOutputStream2.close();
            return false;
        } catch (IOException e10) {
            fileOutputStream = null;
            LogX.w("CardIconDownload editPicFile failed. IOException");
            if (fileOutputStream != null) {
                return false;
            }
            fileOutputStream.close();
            return false;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw th;
        }
    }
}
