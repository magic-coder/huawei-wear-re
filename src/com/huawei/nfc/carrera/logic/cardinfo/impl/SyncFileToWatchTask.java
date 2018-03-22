package com.huawei.nfc.carrera.logic.cardinfo.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.nfc.PluginPay;
import com.huawei.nfc.PluginPayAdapter;
import com.huawei.nfc.carrera.logic.cardinfo.impl.pic.CardPicPathConfig;
import com.huawei.nfc.carrera.logic.ta.TACardInfo;
import com.huawei.nfc.carrera.logic.ta.WalletTaManager;
import com.huawei.p190v.C2538c;
import com.huawei.wallet.storage.path.NfcStorageUtil;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SyncFileToWatchTask {
    private static final String FILE_NAME = "FILE_NAME";
    private static final String FILE_TYPE = "FILE_TYPE";
    private static final int FILE_TYPE_IS_FILE = 1;
    private static final int FILE_TYPE_IS_PIC = 0;
    private static final String LEAK_PATH = "/fileShare/";
    private static final String STORAGE_DIRECTORY = (BaseApplication.b().getFilesDir() + LEAK_PATH);
    private static final String TAG = "SyncFileToWatchTask";
    private static PluginPayAdapter pluginPayAdapter = null;
    private final Context mContext;

    public SyncFileToWatchTask(Context context) {
        this.mContext = context;
        pluginPayAdapter = (PluginPayAdapter) PluginPay.getInstance(context).getAdapter();
        C2538c.b(TAG, new Object[]{"SyncFileToWatchTask getInstance ,pluginPayAdapter=" + pluginPayAdapter});
    }

    public boolean sendBTOfCardPicInfor(String str) {
        C2538c.b(TAG, new Object[]{" == saveBitmap sendBTOfCardPicInfor "});
        Bitmap decodeFile = BitmapFactory.decodeFile(NfcStorageUtil.m28133a(this.mContext, str));
        if (decodeFile == null) {
            C2538c.b(TAG, new Object[]{" == saveBitmap bitmap is null "});
            return false;
        }
        if (createDirectoryOfdata(STORAGE_DIRECTORY)) {
            saveBitmap(compressImage(decodeFile), str);
            String str2 = str + CardPicPathConfig.WALLET_CARD_ICON_STORAGE_NAME;
            List arrayList = new ArrayList();
            Map hashMap = new HashMap();
            hashMap.put(FILE_NAME, str2);
            hashMap.put(FILE_TYPE, Integer.valueOf(0));
            arrayList.add(hashMap);
            boolean notifyAfterTransferFile = pluginPayAdapter.notifyAfterTransferFile(arrayList);
            C2538c.b(TAG, new Object[]{" == saveBitmap InforSendToBT resultAddPICName : " + notifyAfterTransferFile});
            return notifyAfterTransferFile;
        }
        C2538c.c(TAG, new Object[]{"create file path success :" + r2});
        return false;
    }

    private boolean createDirectoryOfdata(String str) {
        File file = new File(str);
        if (file.exists()) {
            return true;
        }
        return file.mkdirs();
    }

    private void saveBitmap(Bitmap bitmap, String str) {
        IOException e;
        FileNotFoundException e2;
        OutputStream outputStream;
        Throwable th;
        C2538c.b(TAG, new Object[]{" == saveBitmap start"});
        FileOutputStream fileOutputStream = null;
        try {
            String str2 = STORAGE_DIRECTORY + str + CardPicPathConfig.WALLET_CARD_ICON_STORAGE_NAME;
            C2538c.b(TAG, new Object[]{" == saveBitmap path  " + str2});
            File file = new File(str2);
            if (!file.exists()) {
                if (file.createNewFile()) {
                    C2538c.b(TAG, new Object[]{" == saveBitmap createNewFile Success "});
                } else {
                    C2538c.b(TAG, new Object[]{" == saveBitmap createNewFile fail "});
                }
            }
            OutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                bitmap.compress(CompressFormat.JPEG, 100, fileOutputStream2);
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                        bitmap.recycle();
                    } catch (IOException e3) {
                        C2538c.e(TAG, new Object[]{"IOException", "fileos.close e : " + e3.getMessage()});
                    }
                }
            } catch (FileNotFoundException e4) {
                e2 = e4;
                outputStream = fileOutputStream2;
                try {
                    C2538c.e(TAG, new Object[]{" == saveBitmap FileNotFoundException can't create FileOutputStream e : " + e2.getMessage()});
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                            bitmap.recycle();
                        } catch (IOException e32) {
                            C2538c.e(TAG, new Object[]{"IOException", "fileos.close e : " + e32.getMessage()});
                        }
                    }
                    C2538c.e(TAG, new Object[]{" == saveBitmap end "});
                } catch (Throwable th2) {
                    th = th2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                            bitmap.recycle();
                        } catch (IOException e5) {
                            C2538c.e(TAG, new Object[]{"IOException", "fileos.close e : " + e5.getMessage()});
                        }
                    }
                    throw th;
                }
            } catch (IOException e6) {
                e32 = e6;
                outputStream = fileOutputStream2;
                C2538c.e(TAG, new Object[]{" == saveBitmap  IOException can't create e : " + e32.getMessage()});
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                        bitmap.recycle();
                    } catch (IOException e322) {
                        C2538c.e(TAG, new Object[]{"IOException", "fileos.close e : " + e322.getMessage()});
                    }
                }
                C2538c.e(TAG, new Object[]{" == saveBitmap end "});
            } catch (Throwable th3) {
                th = th3;
                outputStream = fileOutputStream2;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                    bitmap.recycle();
                }
                throw th;
            }
        } catch (FileNotFoundException e7) {
            e2 = e7;
            C2538c.e(TAG, new Object[]{" == saveBitmap FileNotFoundException can't create FileOutputStream e : " + e2.getMessage()});
            if (fileOutputStream != null) {
                fileOutputStream.close();
                bitmap.recycle();
            }
            C2538c.e(TAG, new Object[]{" == saveBitmap end "});
        } catch (IOException e8) {
            e322 = e8;
            C2538c.e(TAG, new Object[]{" == saveBitmap  IOException can't create e : " + e322.getMessage()});
            if (fileOutputStream != null) {
                fileOutputStream.close();
                bitmap.recycle();
            }
            C2538c.e(TAG, new Object[]{" == saveBitmap end "});
        }
        C2538c.e(TAG, new Object[]{" == saveBitmap end "});
    }

    private Bitmap compressImage(Bitmap bitmap) {
        int i = 1;
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(CompressFormat.JPEG, 100, byteArrayOutputStream);
        if (byteArrayOutputStream.toByteArray().length / 1024 > 1024) {
            byteArrayOutputStream.reset();
            bitmap.compress(CompressFormat.JPEG, 50, byteArrayOutputStream);
        }
        InputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        Options options = new Options();
        options.inJustDecodeBounds = true;
        options.inPreferredConfig = Config.RGB_565;
        BitmapFactory.decodeStream(byteArrayInputStream, null, options);
        options.inJustDecodeBounds = false;
        int i2 = options.outWidth;
        int i3 = options.outHeight;
        i2 = (i2 <= i3 || ((float) i2) <= 200.0f) ? (i2 >= i3 || ((float) i3) <= 200.0f) ? 1 : (int) (((float) options.outHeight) / 200.0f) : (int) (((float) options.outWidth) / 200.0f);
        if (i2 > 0) {
            i = i2;
        }
        options.inSampleSize = i;
        return BitmapFactory.decodeStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()), null, options);
    }

    private boolean sendBTOfCarFileInfor(TACardInfo tACardInfo) {
        C2538c.b(TAG, new Object[]{" enter sendBTOfCarFileInfor "});
        String str = tACardInfo.productId;
        String str2 = tACardInfo.issuerId;
        String str3 = tACardInfo.aid;
        str2 = NfcStorageUtil.m28139d(this.mContext, str2);
        C2538c.b(TAG, new Object[]{"== sendBTOfCarFileInfor refreshLocalRfFile filePath : " + str2});
        if (createDirectoryOfdata(STORAGE_DIRECTORY)) {
            saveRfFile(str2, str);
            str = str + CardPicPathConfig.WALLET_CARD_STORAGE_NAME;
            updateRFFilename(tACardInfo, str);
            List arrayList = new ArrayList();
            Map hashMap = new HashMap();
            hashMap.put(FILE_NAME, str);
            hashMap.put(FILE_TYPE, Integer.valueOf(1));
            arrayList.add(hashMap);
            boolean notifyAfterTransferFile = pluginPayAdapter.notifyAfterTransferFile(arrayList);
            C2538c.b(TAG, new Object[]{"== sendBTOfCarFileInfor resultAddFileName : " + notifyAfterTransferFile});
            return notifyAfterTransferFile;
        }
        C2538c.c(TAG, new Object[]{"create file path success :" + r3});
        return false;
    }

    private void saveRfFile(String str, String str2) {
        FileInputStream fileInputStream;
        FileNotFoundException e;
        IOException e2;
        Throwable th;
        FileOutputStream fileOutputStream = null;
        C2538c.b(TAG, new Object[]{" == saveRfFile start"});
        try {
            FileOutputStream fileOutputStream2;
            String str3 = STORAGE_DIRECTORY + str2 + CardPicPathConfig.WALLET_CARD_STORAGE_NAME;
            fileInputStream = new FileInputStream(new File(str));
            try {
                C2538c.b(TAG, new Object[]{" == saveRfFile path  " + str3});
                File file = new File(str3);
                if (file.exists()) {
                    file.delete();
                    C2538c.b(TAG, new Object[]{" == saveRfFile newxmlfile delete  "});
                }
                if (!file.exists()) {
                    if (file.createNewFile()) {
                        C2538c.b(TAG, new Object[]{" == saveRfFile createNewFile Success "});
                    } else {
                        C2538c.b(TAG, new Object[]{" == saveRfFile createNewFile fail "});
                    }
                }
                fileOutputStream2 = new FileOutputStream(file);
            } catch (FileNotFoundException e3) {
                e = e3;
                try {
                    C2538c.e(TAG, new Object[]{" == saveRfFile FileNotFoundException can't create FileOutputStream e : " + e.getMessage()});
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.flush();
                        } catch (IOException e22) {
                            C2538c.e(TAG, new Object[]{" == saveRfFile output flush e = ", e22.getMessage()});
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e222) {
                            C2538c.e(TAG, new Object[]{" == saveRfFile output close e = ", e222.getMessage()});
                        }
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e2222) {
                            C2538c.e(TAG, new Object[]{" == saveRfFile input close e = ", e2222.getMessage()});
                        }
                    }
                    C2538c.b(TAG, new Object[]{" == saveRfFile end "});
                } catch (Throwable th2) {
                    th = th2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.flush();
                        } catch (IOException e4) {
                            C2538c.e(TAG, new Object[]{" == saveRfFile output flush e = ", e4.getMessage()});
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e5) {
                            C2538c.e(TAG, new Object[]{" == saveRfFile output close e = ", e5.getMessage()});
                        }
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e6) {
                            C2538c.e(TAG, new Object[]{" == saveRfFile input close e = ", e6.getMessage()});
                        }
                    }
                    throw th;
                }
            } catch (IOException e7) {
                e2222 = e7;
                C2538c.e(TAG, new Object[]{" == saveRfFile  IOException can't create e : " + e2222.getMessage()});
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.flush();
                    } catch (IOException e22222) {
                        C2538c.e(TAG, new Object[]{" == saveRfFile output flush e = ", e22222.getMessage()});
                    }
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e222222) {
                        C2538c.e(TAG, new Object[]{" == saveRfFile output close e = ", e222222.getMessage()});
                    }
                }
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e2222222) {
                        C2538c.e(TAG, new Object[]{" == saveRfFile input close e = ", e2222222.getMessage()});
                    }
                }
                C2538c.b(TAG, new Object[]{" == saveRfFile end "});
            }
            try {
                byte[] bArr = new byte[5120];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream2.write(bArr, 0, read);
                }
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.flush();
                    } catch (IOException e22222222) {
                        C2538c.e(TAG, new Object[]{" == saveRfFile output flush e = ", e22222222.getMessage()});
                    }
                }
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e222222222) {
                        C2538c.e(TAG, new Object[]{" == saveRfFile output close e = ", e222222222.getMessage()});
                    }
                }
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e2222222222) {
                        C2538c.e(TAG, new Object[]{" == saveRfFile input close e = ", e2222222222.getMessage()});
                    }
                }
            } catch (FileNotFoundException e8) {
                e = e8;
                fileOutputStream = fileOutputStream2;
                C2538c.e(TAG, new Object[]{" == saveRfFile FileNotFoundException can't create FileOutputStream e : " + e.getMessage()});
                if (fileOutputStream != null) {
                    fileOutputStream.flush();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                C2538c.b(TAG, new Object[]{" == saveRfFile end "});
            } catch (IOException e9) {
                e2222222222 = e9;
                fileOutputStream = fileOutputStream2;
                C2538c.e(TAG, new Object[]{" == saveRfFile  IOException can't create e : " + e2222222222.getMessage()});
                if (fileOutputStream != null) {
                    fileOutputStream.flush();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                C2538c.b(TAG, new Object[]{" == saveRfFile end "});
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream != null) {
                    fileOutputStream.flush();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
        } catch (FileNotFoundException e10) {
            e = e10;
            fileInputStream = null;
            C2538c.e(TAG, new Object[]{" == saveRfFile FileNotFoundException can't create FileOutputStream e : " + e.getMessage()});
            if (fileOutputStream != null) {
                fileOutputStream.flush();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            C2538c.b(TAG, new Object[]{" == saveRfFile end "});
        } catch (IOException e11) {
            e2222222222 = e11;
            fileInputStream = null;
            C2538c.e(TAG, new Object[]{" == saveRfFile  IOException can't create e : " + e2222222222.getMessage()});
            if (fileOutputStream != null) {
                fileOutputStream.flush();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            C2538c.b(TAG, new Object[]{" == saveRfFile end "});
        } catch (Throwable th4) {
            th = th4;
            fileInputStream = null;
            if (fileOutputStream != null) {
                fileOutputStream.flush();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
        C2538c.b(TAG, new Object[]{" == saveRfFile end "});
    }

    public void getTACardToSendFile(String str) {
        C2538c.b(TAG, new Object[]{"enter getTACardToSendFile"});
        TACardInfo cardInfoByIssuerId = WalletTaManager.getInstance(this.mContext).getCardInfoByIssuerId(str);
        if (cardInfoByIssuerId == null) {
            C2538c.b(TAG, new Object[]{"getTACardToSendFile taCardInfo : null"});
        } else if (cardInfoByIssuerId.cardGroupType == 2) {
            sendBTOfCarFileInfor(cardInfoByIssuerId);
        }
    }

    private void updateRFFilename(TACardInfo tACardInfo, String str) {
        C2538c.b(TAG, new Object[]{"enter updateRFFilename  filename : " + str});
        tACardInfo.Rf_file_name = str;
        WalletTaManager.getInstance(this.mContext).updateCardRFFileName(tACardInfo);
    }
}
