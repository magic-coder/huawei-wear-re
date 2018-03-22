package com.huawei.nfc.carrera.logic.cardoperate.citic;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.huawei.nfc.carrera.logic.cardoperate.citic.acvite.ActiveCiticCardTask;
import com.huawei.nfc.carrera.logic.cardoperate.citic.acvite.HandleActiveCardResultTask;
import com.huawei.nfc.carrera.logic.cardoperate.citic.install.HandleInstallCardResultTask;
import com.huawei.nfc.carrera.logic.cardoperate.citic.install.InstallCardBaseTask;
import com.huawei.nfc.carrera.logic.cardoperate.citic.install.InstallCiticCardPrepareTask;
import com.huawei.nfc.carrera.logic.cardoperate.citic.install.InstallCiticCardTask;
import com.huawei.nfc.carrera.logic.cardoperate.citic.verifycode.HandleVerifyCodeResultTask;
import com.huawei.nfc.carrera.logic.cardoperate.citic.verifycode.RequestCiticVerifyCodeTask;
import com.huawei.nfc.carrera.logic.cardoperate.model.OpenCardInfo;
import com.huawei.nfc.carrera.logic.spi.SPIServiceFactory;
import com.huawei.nfc.carrera.logic.spi.citic.CITICService;
import com.huawei.nfc.carrera.server.ServerServiceFactory;
import com.huawei.nfc.carrera.server.card.CardServerApi;
import com.huawei.nfc.carrera.util.LogX;

public class CITICCardOperator {
    private CITICService citicServiceApi;
    private InstallCardBaseTask installCardTask;
    private Handler installHandler;
    private final Object lock = new Object();
    private Context mContext;
    private Handler prepareHandler;
    private CardServerApi serverApi;

    public CITICCardOperator(Context context, Handler handler) {
        this.mContext = context;
        this.serverApi = ServerServiceFactory.createCardServerApi(this.mContext);
        this.citicServiceApi = SPIServiceFactory.createCITICService(this.mContext);
        this.prepareHandler = handler;
    }

    public void startPrepareTask(String str) {
        synchronized (this.lock) {
            this.installCardTask = new InstallCiticCardTask(this.mContext, this.serverApi, this.citicServiceApi, str, new InstallCiticCardPrepareTask(this.mContext, str, this.serverApi, this.citicServiceApi));
            this.installCardTask.doPrepareTask(this.prepareHandler);
        }
    }

    public void install(OpenCardInfo openCardInfo, HandleInstallCardResultTask handleInstallCardResultTask) {
        synchronized (this.lock) {
            if (this.installHandler == null) {
                HandlerThread handlerThread = new HandlerThread("install_citic_card_thread");
                handlerThread.start();
                this.installHandler = new Handler(handlerThread.getLooper());
            }
            boolean z = false;
            if (this.installCardTask != null) {
                z = this.installCardTask.doInstallTask(this.installHandler, openCardInfo, handleInstallCardResultTask);
                LogX.d("install, start install task success.");
            }
            if (!z) {
                this.installCardTask = new InstallCiticCardTask(this.mContext, this.serverApi, this.citicServiceApi, openCardInfo.getCardNum(), new InstallCiticCardPrepareTask(this.mContext, openCardInfo.getCardNum(), this.serverApi, this.citicServiceApi));
                this.installCardTask.doInstallTask(this.installHandler, openCardInfo, handleInstallCardResultTask);
            }
        }
    }

    public void requestActiveVerifyCode(String str, HandleVerifyCodeResultTask handleVerifyCodeResultTask) {
        synchronized (this.lock) {
            this.prepareHandler.post(new RequestCiticVerifyCodeTask(this.mContext, str, handleVerifyCodeResultTask, 1, this.citicServiceApi));
        }
    }

    public void active(String str, String str2, HandleActiveCardResultTask handleActiveCardResultTask) {
        synchronized (this.lock) {
            this.prepareHandler.post(new ActiveCiticCardTask(this.mContext, str, str2, handleActiveCardResultTask, this.citicServiceApi));
        }
    }

    public void requestNullifyVerifyCode(String str, HandleVerifyCodeResultTask handleVerifyCodeResultTask) {
        synchronized (this.lock) {
            this.prepareHandler.post(new RequestCiticVerifyCodeTask(this.mContext, str, handleVerifyCodeResultTask, 2, this.citicServiceApi));
        }
    }

    public void nullify(String str, String str2, HandleNullifyCardResultTask handleNullifyCardResultTask) {
        synchronized (this.lock) {
            this.prepareHandler.post(new NullifyCiticCardTask(this.mContext, this.serverApi, this.citicServiceApi, str, str2, handleNullifyCardResultTask));
        }
    }
}
