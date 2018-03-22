package com.huawei.nfc.carrera.lifecycle.aidlservice;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import com.huawei.nfc.carrera.logic.ese.ESEApiFactory;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.pay.p130e.p131c.C1368a;
import com.unionpay.p109a.p110a.C1207e;
import com.unionpay.p109a.p110a.C2673a;

public class CUPAidlService extends Service {
    public static final int CMD_GET_CPLC = 0;
    public static final int CMD_OTHERS = -1;
    private C1207e binder = new C12082();
    private Thread excThread = null;
    private Handler handler = null;

    class C12051 extends Thread {
        C12051() {
        }

        public void run() {
            Looper.prepare();
            CUPAidlService.this.handler = new 1(this);
            Looper.loop();
        }
    }

    class C12082 extends C1207e {
        C12082() {
        }

        public void setDefaultCard(C2673a c2673a, String str, Bundle bundle) throws RemoteException {
            CUPAidlService.this.handler.sendMessage(CUPAidlService.this.handler.obtainMessage(-1, c2673a));
        }

        public void getDefaultCard(C2673a c2673a, String str) throws RemoteException {
            CUPAidlService.this.handler.sendMessage(CUPAidlService.this.handler.obtainMessage(-1, c2673a));
        }

        public void getCPLC(C2673a c2673a) throws RemoteException {
            LogX.m5475i("wallet upserver aidl service get CPLC");
            CUPAidlService.this.handler.sendMessage(CUPAidlService.this.handler.obtainMessage(0, c2673a));
        }

        public void createSSD(C2673a c2673a) throws RemoteException {
            CUPAidlService.this.handler.sendMessage(CUPAidlService.this.handler.obtainMessage(-1, c2673a));
        }
    }

    public void onCreate() {
        super.onCreate();
        this.excThread = new C12051();
        this.excThread.start();
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.handler != null) {
            Looper looper = this.handler.getLooper();
            this.handler = null;
            if (looper != null) {
                looper.quit();
            }
        }
        this.excThread = null;
    }

    public IBinder onBind(Intent intent) {
        return this.binder;
    }

    private void executeCmd(Message message) {
        if (message.what != 0) {
            try {
                ((C2673a) message.obj).m12777a(new Bundle());
            } catch (Throwable e) {
                C1368a.m6086a("up sdk err : ", e, false);
            }
        } else if (message.obj instanceof C2673a) {
            String queryCplc = ESEApiFactory.createESEInfoManagerApi(getApplicationContext()).queryCplc();
            Bundle bundle = new Bundle();
            bundle.putString("cplcData", queryCplc);
            try {
                ((C2673a) message.obj).m12777a(bundle);
            } catch (Throwable e2) {
                LogX.m5473e("up sdk get cplc err : ", e2, false);
            }
        }
    }
}
