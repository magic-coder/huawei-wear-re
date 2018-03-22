package com.huawei.pay.ui.oobe.widget;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.huawei.ag.d;
import com.huawei.ag.e;
import com.huawei.pay.e.c.a;
import com.huawei.wallet.utils.ReflectionUtils;
import java.lang.reflect.Method;

public class NetStatusBar extends LinearLayout {
    public static final int FIRST_SIM_SLOT = 0;
    public static final int SECOND_SIM_SLOT = 1;
    private static final int WIFI_LENGTH_FOUR = 4;
    private static final int WIFI_LENGTH_ONE = 1;
    private static final int WIFI_LENGTH_THREE = 3;
    private static final int WIFI_LENGTH_TWO = 2;
    private static final int WIFI_LENGTH_ZERO = 0;
    private boolean mIsRegister = false;
    private PhoneStateListener mPhoneStateListener;
    private int mSimActivity = 0;
    private ImageView mSimConnected;
    private FrameLayout mSimLayout;
    SimViewHandler mSimViewHandler;
    private int mWifiActivity = -1;
    private Object mWifiChannel;
    private ImageView mWifiConnected;
    private FrameLayout mWifiLayout;
    WifiLengthHandler mWifiLengthHandler;
    private WifiManager mWifiManager;
    WifiViewHandler mWifiViewHandler;
    private ImageView mWifisignal;
    private Context netContext;

    class C57421 extends PhoneStateListener {
        C57421() {
        }

        public void onDataActivity(int i) {
            if (i != NetStatusBar.this.mSimActivity) {
                NetStatusBar.this.mSimActivity = i;
                NetStatusBar.this.refreshSimViews(NetStatusBar.this.mSimActivity);
            }
        }
    }

    class SimViewHandler extends Handler {
        private NetStatusBar mNetStatusBar;

        public SimViewHandler(NetStatusBar netStatusBar) {
            this.mNetStatusBar = netStatusBar;
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (this.mNetStatusBar != null) {
                this.mNetStatusBar.handlerSimViewMsg(message);
            }
        }
    }

    class WifiHandler extends Handler {
        WifiHandler() {
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            Object a = ReflectionUtils.m28473a("AsyncChannel", "CMD_CHANNEL_HALF_CONNECTED");
            boolean z = a != null && (a instanceof Integer) && message.what == ((Integer) a).intValue();
            if (z) {
                a.b("zgs->CMD_CHANNEL_HALF_CONNECTED", false);
                a = ReflectionUtils.m28473a("AsyncChannel", "STATUS_SUCCESSFUL");
                if (a != null && (a instanceof Integer) && message.arg1 == ((Integer) a).intValue()) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    Object a2 = ReflectionUtils.m28473a("AsyncChannel", "CMD_CHANNEL_FULL_CONNECTION");
                    if (a2 == null || !(a2 instanceof Integer)) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (z && NetStatusBar.this.mWifiChannel != null && (NetStatusBar.this.mWifiChannel instanceof Handler)) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        ((Handler) NetStatusBar.this.mWifiChannel).sendMessage(Message.obtain(this, ((Integer) a2).intValue()));
                        return;
                    } else {
                        a.c("reflexObj is null or reflexObj is not Integer type or mWiFiChannel is null or mWifiChannel is not Handler", false);
                        return;
                    }
                }
                a.b("Failed to connect to wifi", false);
            } else if (message.what == ReflectionNetStatusHelper.getFieldInt(NetStatusBar.this.mWifiManager.getClass(), "DATA_ACTIVITY_NOTIFICATION") && message.arg1 != NetStatusBar.this.mWifiActivity) {
                NetStatusBar.this.mWifiActivity = message.arg1;
                a.a("zgs", "zgs->mWifiActivity=" + NetStatusBar.this.mWifiActivity, false);
                NetStatusBar.this.refreshWifiViews(NetStatusBar.this.mWifiActivity);
            }
        }
    }

    class WifiLengthHandler extends Handler {
        private NetStatusBar mNetStatusBar;

        public WifiLengthHandler(NetStatusBar netStatusBar) {
            this.mNetStatusBar = netStatusBar;
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (this.mNetStatusBar != null) {
                this.mNetStatusBar.handlerWifiLengthMsg(message);
            }
        }
    }

    class WifiViewHandler extends Handler {
        private NetStatusBar mNetStatusBar;

        public WifiViewHandler(NetStatusBar netStatusBar) {
            this.mNetStatusBar = netStatusBar;
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (this.mNetStatusBar != null) {
                this.mNetStatusBar.handlerWifiViewMsg(message);
            }
        }
    }

    public NetStatusBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.netContext = context;
        this.mPhoneStateListener = new C57421();
        ((TelephonyManager) context.getSystemService("phone")).listen(this.mPhoneStateListener, 128);
        createWifiHandler();
    }

    public void refreshNetStatusBar() {
        refreshWifiViews(this.mWifiActivity);
        refreshSimViews(this.mSimActivity);
    }

    private void createWifiHandler() {
        this.mWifiManager = (WifiManager) this.netContext.getSystemService("wifi");
        this.mWifiActivity = ReflectionNetStatusHelper.getFieldInt(this.mWifiManager.getClass(), "DATA_ACTIVITY_NONE");
        WifiHandler wifiHandler = new WifiHandler();
        this.mWifiChannel = ReflectionUtils.m28470a("com.android.internal.util.AsyncChannel");
        if (((Messenger) ReflectionNetStatusHelper.invoke(this.mWifiManager, ReflectionNetStatusHelper.getMethod(this.mWifiManager.getClass(), "getWifiServiceMessenger", new Class[0]), new Object[0])) != null) {
            ReflectionUtils.m28471a(this.mWifiChannel, "connect", this.netContext, wifiHandler, (Messenger) ReflectionNetStatusHelper.invoke(this.mWifiManager, ReflectionNetStatusHelper.getMethod(this.mWifiManager.getClass(), "getWifiServiceMessenger", new Class[0]), new Object[0]));
            return;
        }
        a.b("wifiMessenger is null.", false);
    }

    private boolean isSimCardsExits() {
        TelephonyManager telephonyManager = (TelephonyManager) this.netContext.getSystemService("phone");
        if (telephonyManager != null && telephonyManager.hasIccCard()) {
            return true;
        }
        Class cls = ReflectionNetStatusHelper.getClass("com.huawei.telephony.HuaweiTelephonyManager");
        Method method = ReflectionNetStatusHelper.getMethod(cls, "getDefault", new Class[0]);
        Method method2 = ReflectionNetStatusHelper.getMethod(cls, "isCardPresent", Integer.TYPE);
        try {
            Object invoke = ReflectionNetStatusHelper.invoke(null, method, new Object[0]);
            boolean z = ((Boolean) ReflectionNetStatusHelper.invoke(invoke, method2, Integer.valueOf(0))).booleanValue() || ((Boolean) ReflectionNetStatusHelper.invoke(invoke, method2, Integer.valueOf(1))).booleanValue();
            return z;
        } catch (UnsupportedOperationException e) {
            return false;
        }
    }

    public void refreshWifiViews(int i) {
        this.mWifiConnected.setVisibility(0);
        this.mWifiViewHandler = new WifiViewHandler(this);
        this.mWifiViewHandler.sendEmptyMessage(i);
    }

    protected void refreshSimViews(int i) {
        this.mSimConnected.setVisibility(0);
        this.mSimViewHandler = new SimViewHandler(this);
        this.mSimViewHandler.sendEmptyMessage(i);
    }

    private void handlerSimViewMsg(Message message) {
        switch (message.what) {
            case 0:
                this.mSimConnected.setVisibility(8);
                return;
            case 1:
                this.mSimConnected.setImageResource(d.stat_sys_signal_in_sim);
                return;
            case 2:
                this.mSimConnected.setImageResource(d.stat_sys_signal_out_sim);
                return;
            case 3:
                this.mSimConnected.setImageResource(d.stat_sys_signal_inout_sim);
                return;
            default:
                return;
        }
    }

    private void handlerWifiViewMsg(Message message) {
        if (message.what == ReflectionNetStatusHelper.getFieldInt(this.mWifiManager.getClass(), "DATA_ACTIVITY_IN")) {
            this.mWifiConnected.setImageResource(d.stat_sys_signal_in);
        } else if (message.what == ReflectionNetStatusHelper.getFieldInt(this.mWifiManager.getClass(), "DATA_ACTIVITY_OUT")) {
            this.mWifiConnected.setImageResource(d.stat_sys_signal_out);
        } else if (message.what == ReflectionNetStatusHelper.getFieldInt(this.mWifiManager.getClass(), "DATA_ACTIVITY_INOUT")) {
            this.mWifiConnected.setImageResource(d.stat_sys_signal_inout);
        } else if (message.what == ReflectionNetStatusHelper.getFieldInt(this.mWifiManager.getClass(), "DATA_ACTIVITY_NONE")) {
            this.mWifiConnected.setVisibility(8);
        }
    }

    private void handlerWifiLengthMsg(Message message) {
        switch (message.what) {
            case 0:
                this.mWifisignal.setImageResource(d.stat_sys_wifi_signal_4);
                return;
            case 1:
                this.mWifisignal.setImageResource(d.stat_sys_wifi_signal_3);
                return;
            case 2:
                this.mWifisignal.setImageResource(d.stat_sys_wifi_signal_2);
                return;
            case 3:
                this.mWifisignal.setImageResource(d.stat_sys_wifi_signal_1);
                return;
            case 4:
                this.mWifisignal.setImageResource(d.stat_sys_wifi_signal_0);
                return;
            default:
                a.b("handleMessage msg.what = " + message.what, false);
                this.mWifisignal.setImageResource(d.stat_sys_wifi_signal_0);
                return;
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        unregisterBroadcast();
        ((TelephonyManager) this.netContext.getSystemService("phone")).listen(this.mPhoneStateListener, 0);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mSimLayout = (FrameLayout) findViewById(e.sim_layout);
        this.mWifiLayout = (FrameLayout) findViewById(e.wifi_layout);
        this.mSimConnected = (ImageView) findViewById(e.sim_connected);
        this.mWifiConnected = (ImageView) findViewById(e.wifi_connected);
        this.mWifisignal = (ImageView) findViewById(e.wifi_signal);
        if (isSimCardsExits()) {
            this.mSimLayout.setVisibility(0);
        } else {
            this.mSimLayout.setVisibility(8);
        }
        registerBroadcast();
    }

    protected void setWifiLength(int i) {
        this.mWifiLengthHandler = new WifiLengthHandler(this);
        this.mWifiLengthHandler.sendEmptyMessage(i / -20);
    }

    private void registerBroadcast() {
        if (!this.mIsRegister) {
            this.mIsRegister = true;
        }
    }

    private void unregisterBroadcast() {
        if (this.mIsRegister) {
            this.mIsRegister = false;
        }
    }
}
