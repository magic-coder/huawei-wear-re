package com.huawei.nfc.carrera.logic.cardoperate.opencardlogupload;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.huawei.nfc.carrera.server.ServerServiceFactory;
import com.huawei.nfc.carrera.server.card.request.ReportEventBaseRequest;
import com.huawei.nfc.carrera.server.card.response.CardServerBaseResponse;
import com.huawei.nfc.carrera.util.LogX;

public class LogUploadTask implements Runnable {
    private final Context context;
    private final Handler handler = new Handler();
    private final ReportEventBaseRequest request;

    public LogUploadTask(Context context, ReportEventBaseRequest reportEventBaseRequest) {
        this.context = context;
        this.request = reportEventBaseRequest;
    }

    public void run() {
        CardServerBaseResponse reportOpenCardEvent = ServerServiceFactory.createCardServerApi(this.context).reportOpenCardEvent(this.request);
        Message message = new Message();
        if (reportOpenCardEvent == null) {
            LogX.d("openCardLogUpload,  get response fail.");
            message.what = -99;
            this.handler.sendMessage(message);
            return;
        }
        LogX.d("openCardLogUpload, response code: " + reportOpenCardEvent.returnCode);
        message.what = reportOpenCardEvent.returnCode;
        this.handler.sendMessage(message);
    }
}
