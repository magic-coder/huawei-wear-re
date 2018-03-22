package com.huawei.nfc.carrera.logic.cardoperate.cmb;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.huawei.nfc.carrera.logic.cardoperate.citic.HandleNullifyCardResultTask;
import com.huawei.nfc.carrera.logic.cardoperate.citic.acvite.HandleActiveCardResultTask;
import com.huawei.nfc.carrera.logic.cardoperate.citic.install.HandleInstallCardResultTask;
import com.huawei.nfc.carrera.logic.cardoperate.citic.install.InstallCardBaseTask;
import com.huawei.nfc.carrera.logic.cardoperate.citic.verifycode.HandleVerifyCodeResultTask;
import com.huawei.nfc.carrera.logic.cardoperate.cmb.active.ActiveCmbCardTask;
import com.huawei.nfc.carrera.logic.cardoperate.cmb.install.InstallCmbCardPrepareTask;
import com.huawei.nfc.carrera.logic.cardoperate.cmb.install.InstallCmbCardTask;
import com.huawei.nfc.carrera.logic.cardoperate.cmb.verifycode.RequestCmbVerifyCodeTask;
import com.huawei.nfc.carrera.logic.cardoperate.model.OpenCardInfo;
import com.huawei.nfc.carrera.logic.spi.SPIServiceFactory;
import com.huawei.nfc.carrera.logic.spi.cmb.CMBService;
import com.huawei.nfc.carrera.server.ServerServiceFactory;
import com.huawei.nfc.carrera.server.card.CardServerApi;
import com.huawei.nfc.carrera.util.LogX;

public class CMBCardOperator {
    private CMBService cmbServiceApi;
    private InstallCardBaseTask installCardTask;
    private Handler installHandler;
    private final Object lock = new Object();
    private Context mContext;
    private Handler prepareHandler;
    private CardServerApi serverApi;

    public CMBCardOperator(Context context, Handler handler) {
        this.mContext = context;
        this.serverApi = ServerServiceFactory.createCardServerApi(this.mContext);
        this.cmbServiceApi = SPIServiceFactory.createCMBService(this.mContext);
        this.prepareHandler = handler;
    }

    public void startPrepareTask(String str) {
        synchronized (this.lock) {
            this.installCardTask = new InstallCmbCardTask(this.mContext, this.serverApi, this.cmbServiceApi, str, new InstallCmbCardPrepareTask(this.mContext, str, this.serverApi, this.cmbServiceApi));
            this.installCardTask.doPrepareTask(this.prepareHandler);
        }
    }

    public void install(OpenCardInfo openCardInfo, HandleInstallCardResultTask handleInstallCardResultTask) {
        synchronized (this.lock) {
            if (this.installHandler == null) {
                HandlerThread handlerThread = new HandlerThread("install_cmb_card_thread");
                handlerThread.start();
                this.installHandler = new Handler(handlerThread.getLooper());
            }
            boolean z = false;
            if (this.installCardTask != null) {
                z = this.installCardTask.doInstallTask(this.installHandler, openCardInfo, handleInstallCardResultTask);
                LogX.d("install, start install task success.");
            }
            if (!z) {
                this.installCardTask = new InstallCmbCardTask(this.mContext, this.serverApi, this.cmbServiceApi, openCardInfo.getCardNum(), new InstallCmbCardPrepareTask(this.mContext, openCardInfo.getCardNum(), this.serverApi, this.cmbServiceApi));
                this.installCardTask.doInstallTask(this.installHandler, openCardInfo, handleInstallCardResultTask);
            }
        }
    }

    public void requestActiveVerifyCode(String str, HandleVerifyCodeResultTask handleVerifyCodeResultTask) {
        synchronized (this.lock) {
            this.prepareHandler.post(new RequestCmbVerifyCodeTask(this.mContext, str, handleVerifyCodeResultTask, 1, this.cmbServiceApi));
        }
    }

    public void active(String str, String str2, HandleActiveCardResultTask handleActiveCardResultTask) {
        synchronized (this.lock) {
            this.prepareHandler.post(new ActiveCmbCardTask(this.mContext, str, str2, handleActiveCardResultTask, this.cmbServiceApi));
        }
    }

    public void nullify(String str, HandleNullifyCardResultTask handleNullifyCardResultTask) {
        synchronized (this.lock) {
            this.prepareHandler.post(new NullifyCmbCardTask(this.mContext, this.serverApi, this.cmbServiceApi, str, handleNullifyCardResultTask));
        }
    }
}
