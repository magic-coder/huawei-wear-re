package com.huawei.nfc.carrera.util;

import android.os.Environment;

public class FusionField {
    private static final String FILE_NAME = "HwWallet";
    public static final String IMAGE_SAVEPATH = (SDCARDDIR + "/" + FILE_NAME + "/image/");
    public static final String OTO_X509_P2 = "85b9";
    public static final String PACKAGE_NAME = "com.huawei.wallet";
    public static final String SDCARDDIR = Environment.getExternalStorageDirectory().getAbsolutePath();
    public static final String SECTION_2 = "c5";
    public static final String SYSDATADIR = Environment.getDataDirectory().getAbsolutePath();
    public static final String UPDATE_FILE_NAME = "HwWallet.apk";
    public static final String UPDATE_VERSION_SAVEPATH = (SDCARDDIR + "/" + FILE_NAME + "/update/");
    public static final String UPDATE_VERSION_SAVEPATH_NO_SDCARD = (SYSDATADIR + "/data/" + "com.huawei.wallet" + "/update/");
}
