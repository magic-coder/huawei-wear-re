package com.huawei.nfc;

import android.content.Context;
import android.content.Intent;
import com.huawei.ah.C0639a;
import com.huawei.ah.C0640b;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.nfc.carrera.lifecycle.push.NFCPushServiceManager;
import com.huawei.nfc.carrera.logic.LogicApiFactory;
import com.huawei.nfc.carrera.logic.lostmanager.CardLostManagerApi;
import com.huawei.p190v.C2538c;
import com.huawei.wallet.ui.cardholder.CardHolderActivity;
import net.sqlcipher.database.SQLiteDatabase;

public class PluginPay extends C0639a {
    private static final byte[] SYNC_LOCK = new byte[0];
    private static final String TAG = "PluginPay";
    private static PluginPay mInstance;
    private CardLostManagerApi cardLostManagerApi = null;
    private boolean isShowPay = false;
    private Context mContext;

    private PluginPay(Context context) {
        this.mContext = context;
    }

    public static PluginPay getInstance(Context context) {
        PluginPay pluginPay;
        synchronized (SYNC_LOCK) {
            if (mInstance == null) {
                mInstance = new PluginPay(BaseApplication.m2632b());
            }
            pluginPay = mInstance;
        }
        return pluginPay;
    }

    public void setAdapter(C0640b c0640b) {
        super.setAdapter(c0640b);
    }

    public void goToCardListActivity() {
        Intent intent = new Intent(this.mContext, CardHolderActivity.class);
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        this.mContext.startActivity(intent);
    }

    public Class<?> getCardListActivityClass() {
        C2538c.m12674b(TAG, "getCardListActivityClass");
        return null;
    }

    public void finish() {
        super.finish();
    }

    public void SyncCardInformation() {
        NFCPushServiceManager.getInstance(this.mContext).getPushToken();
        this.cardLostManagerApi = LogicApiFactory.createCardLostManagerApi(this.mContext);
        C2538c.m12674b(TAG, "== card status enter SyncCardInformation");
        this.cardLostManagerApi.checkDeviceStatus(new 1(this));
    }

    public boolean isShowPay() {
        return this.isShowPay;
    }

    public void setShowPay(boolean z) {
        this.isShowPay = z;
    }
}
