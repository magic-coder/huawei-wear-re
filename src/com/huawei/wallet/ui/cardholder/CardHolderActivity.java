package com.huawei.wallet.ui.cardholder;

import android.app.FragmentTransaction;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.ViewGroup;
import com.huawei.nfc.PluginPay;
import com.huawei.nfc.carrera.logic.cardinfo.impl.CardInfoManager;
import com.huawei.nfc.carrera.logic.ta.WalletTaManager;
import com.huawei.nfc.carrera.ui.NFCBaseActivity;
import com.huawei.p190v.C2538c;
import com.huawei.wallet.R;
import com.huawei.wallet.utils.UIUtil;

public class CardHolderActivity extends NFCBaseActivity {
    private CardHolderFragment f21452a;
    private NetworkChangeReceiver f21453b;
    private ViewGroup f21454c;
    private boolean f21455d;
    private Context f21456e;
    private boolean f21457f = true;

    class NetworkChangeReceiver extends BroadcastReceiver {
        final /* synthetic */ CardHolderActivity f21451a;

        private NetworkChangeReceiver(CardHolderActivity cardHolderActivity) {
            this.f21451a = cardHolderActivity;
        }

        public void onReceive(Context context, Intent intent) {
            if (this.f21451a.f21452a != null && this.f21451a.f21452a.m28320c() == -4) {
                this.f21451a.f21452a.m28319b();
            }
            if (!this.f21451a.f21457f) {
                CardInfoManager.getInstance(context).refreshCardList();
            }
            this.f21451a.f21457f = false;
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(0);
            NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(1);
            if (networkInfo == null || networkInfo2 == null) {
                Object obj;
                NetworkInfo networkInfo3;
                String str = "PluginPay CardHolderActivity";
                Object[] objArr = new Object[1];
                StringBuilder append = new StringBuilder().append(" NetworkChangeReceiver onReceive mobNetInfo ");
                if (networkInfo == null) {
                    obj = "null";
                } else {
                    networkInfo3 = networkInfo;
                }
                StringBuilder append2 = append.append(obj).append(" ; wifiNetInfo : ");
                if (networkInfo2 == null) {
                    obj = "null";
                } else {
                    networkInfo3 = networkInfo2;
                }
                objArr[0] = append2.append(obj).toString();
                C2538c.c(str, objArr);
                return;
            }
            if (networkInfo.isConnected() || networkInfo2.isConnected()) {
                this.f21451a.mNetConnected = true;
            } else {
                this.f21451a.mNetConnected = false;
            }
            C2538c.c("PluginPay CardHolderActivity", new Object[]{" NetworkChangeReceiver onReceive mNetConnected " + this.f21451a.mNetConnected});
            this.f21451a.refreshView(false);
        }
    }

    protected void watchConnectedChange(int i) {
        super.watchConnectedChange(i);
        C2538c.c("PluginPay CardHolderActivity", new Object[]{" watchConnectedChange onReceive connectedStatus " + i});
        if (this.f21456e == null) {
            C2538c.c("PluginPay CardHolderActivity", new Object[]{" Context is null "});
        } else if (i != 2) {
            C2538c.c("PluginPay CardHolderActivity", new Object[]{"watch dis connectedStatus "});
        } else {
            if (!this.f21457f) {
                CardInfoManager.getInstance(this.f21456e).refreshCardList();
            }
            this.f21457f = false;
        }
    }

    private void m28273a() {
        IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        if (this.f21453b == null) {
            this.f21453b = new NetworkChangeReceiver();
        }
        registerReceiver(this.f21453b, intentFilter);
    }

    private void m28276b() {
        if (this.f21453b != null) {
            unregisterReceiver(this.f21453b);
        }
    }

    protected void onResume() {
        super.onResume();
        this.f21452a.m28316a();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.act_card_holder);
        showHead(R.string.pocket_icon_text);
        m28274a(bundle);
        if (this.pluginPayAdapter != null) {
            this.mDevicesConnecteStatus = this.pluginPayAdapter.getDeviceConnectState();
        }
        PluginPay.getInstance(this.f21456e).setShowPay(true);
        m28273a();
    }

    private void m28274a(Bundle bundle) {
        this.f21454c = (ViewGroup) findViewById(R.id.content);
        if (this.f21455d) {
            UIUtil.m28488a(this, this.f21454c, true);
        }
        this.f21452a = (CardHolderFragment) getFragmentManager().findFragmentByTag("card_holder");
        FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
        if (this.f21452a == null) {
            this.f21452a = new CardHolderFragment();
            beginTransaction.add(R.id.content, this.f21452a, "card_holder").commit();
        }
        this.f21456e = this;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        this.f21452a.onActivityResult(i, i2, intent);
        super.onActivityResult(i, i2, intent);
    }

    protected void onDestroy() {
        super.onDestroy();
        PluginPay.getInstance(this.f21456e).setShowPay(false);
        WalletTaManager.destroy();
        m28276b();
        C2538c.c("PluginPay CardHolderActivity", new Object[]{"onDestroy()"});
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f21455d) {
            UIUtil.m28488a(this, this.f21454c, true);
        }
    }

    public void refreshView(boolean z) {
        super.refreshView(z);
        if (this.mDevicesConnecteStatus != 2) {
            C2538c.c("PluginPay CardHolderActivity", new Object[]{"refreshView,mDevicesConnecteStatus=" + this.mDevicesConnecteStatus});
            WalletTaManager.destroy();
        } else if (z) {
            this.f21452a.m28316a();
        }
    }
}
