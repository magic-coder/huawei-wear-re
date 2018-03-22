package com.huawei.nfc.carrera.logic.cardoperate.bus.task.base;

import android.content.Context;
import com.huawei.nfc.carrera.logic.cardinfo.impl.CardAndIssuerInfoCache;
import com.huawei.nfc.carrera.logic.cardoperate.bus.TrafficCardOperator;
import com.huawei.nfc.carrera.logic.cardoperate.impl.SPIOperatorManager;
import com.huawei.nfc.carrera.logic.dbmanager.IssuerInfoItem;
import com.huawei.nfc.carrera.util.LogX;

public abstract class TrafficCardBaseTask implements Runnable {
    protected Context mContext;
    protected String mIssuerId;
    protected SPIOperatorManager operatorManager;

    protected abstract void excuteAction(TrafficCardOperator trafficCardOperator, IssuerInfoItem issuerInfoItem);

    public TrafficCardBaseTask(Context context, SPIOperatorManager sPIOperatorManager, String str) {
        this.mContext = context;
        this.mIssuerId = str;
        this.operatorManager = sPIOperatorManager;
    }

    public void run() {
        LogX.i("TrafficCardBaseTask run begin");
        IssuerInfoItem cacheIssuerInfoItem = CardAndIssuerInfoCache.getInstance(this.mContext).cacheIssuerInfoItem(this.mIssuerId);
        if (cacheIssuerInfoItem == null) {
            LogX.w("TrafficCardBaseTask run failed. issuer info dose not exist. issuerId = " + this.mIssuerId);
            return;
        }
        int mode = cacheIssuerInfoItem.getMode();
        TrafficCardOperator trafficCardOpertor = this.operatorManager.getTrafficCardOpertor(mode);
        if (trafficCardOpertor == null) {
            LogX.w("TrafficCardBaseTask run failed. don't support the mode. mode = " + mode);
            return;
        }
        excuteAction(trafficCardOpertor, cacheIssuerInfoItem);
        LogX.i("TrafficCardBaseTask run end");
    }
}
