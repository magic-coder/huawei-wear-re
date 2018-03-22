package com.huawei.nfc.carrera.server;

import android.content.Context;
import com.huawei.nfc.carrera.server.card.CardServerApi;
import com.huawei.nfc.carrera.server.card.impl.CardServer;
import com.huawei.nfc.carrera.server.download.FileDownloadApi;
import com.huawei.nfc.carrera.server.download.impl.FileDownloadImpl;

public class ServerServiceFactory {
    public static CardServerApi createCardServerApi(Context context) {
        return new CardServer(context);
    }

    public static FileDownloadApi createFileDownloadApi(Context context) {
        return new FileDownloadImpl(context);
    }
}
