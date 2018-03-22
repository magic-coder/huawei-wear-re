package com.huawei.nfc.carrera.logic.cardinfo.impl.pic;

import android.content.Context;
import java.io.File;

public class CardPicPathConfig {
    private static final String WALLET_CARD_APKICON_STORAGE_NAME_SUFFIX = ".png";
    public static final String WALLET_CARD_ICON_STORAGE_NAME = "_icon_watch.png";
    private static final String WALLET_CARD_ICON_STORAGE_NAME_SUFFIX = "_icon.png";
    private static final String WALLET_CARD_LOGO_STORAGE_NAME_SUFFIX = "_logo.png";
    public static final String WALLET_CARD_STORAGE_NAME = "_watch.conf";
    private static final String WALLET_NFC_APKICON_STORAGE_DIRECTORY = "apkicon/";
    private static final String WALLET_NFC_ICON_STORAGE_DIRECTORY = "icon/";
    private static final String WALLET_NFC_LOGO_STORAGE_DIRECTORY = "logo/";
    private static final String WALLET_NFC_STORAGE_DIRECTORY = "/nfc/";

    static String getNfcDirPath(Context context) {
        File externalFilesDir = context.getExternalFilesDir(null);
        if (externalFilesDir != null) {
            return externalFilesDir.getAbsolutePath() + WALLET_NFC_STORAGE_DIRECTORY;
        }
        return "";
    }

    static String getCardIconDirPath(Context context) {
        return getNfcDirPath(context) + WALLET_NFC_ICON_STORAGE_DIRECTORY;
    }

    static String getCardLogoDirPath(Context context) {
        return getNfcDirPath(context) + WALLET_NFC_LOGO_STORAGE_DIRECTORY;
    }

    static String getCardApkIconDirPath(Context context) {
        return getNfcDirPath(context) + WALLET_NFC_APKICON_STORAGE_DIRECTORY;
    }

    static String getCardLogoPath(Context context, String str) {
        return getNfcDirPath(context) + WALLET_NFC_LOGO_STORAGE_DIRECTORY + str + WALLET_CARD_LOGO_STORAGE_NAME_SUFFIX;
    }

    static String getCardApkIconPath(Context context, String str) {
        return getNfcDirPath(context) + WALLET_NFC_APKICON_STORAGE_DIRECTORY + str + WALLET_CARD_APKICON_STORAGE_NAME_SUFFIX;
    }
}
