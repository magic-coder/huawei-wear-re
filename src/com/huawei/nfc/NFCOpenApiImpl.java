package com.huawei.nfc;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.nfc.carrera.logic.LogicApiFactory;
import com.huawei.nfc.carrera.logic.NFCOpenApi;
import com.huawei.nfc.carrera.logic.cardinfo.impl.CardInfoManager;
import com.huawei.nfc.carrera.logic.lostmanager.CardLostManagerApi;
import com.huawei.nfc.carrera.logic.lostmanager.callback.CheckDeviceStatusCallback;
import com.huawei.nfc.carrera.logic.lostmanager.callback.HandleDeviceRepairCallback;
import com.huawei.nfc.carrera.logic.security.receiver.FpManagerReceiver;
import com.huawei.nfc.carrera.logic.ta.WalletTaManager;
import com.huawei.nfc.carrera.storage.sp.NFCPreferences;
import com.huawei.nfc.carrera.ui.cardlist.explanddetail.ExplandCardInstruction;
import com.huawei.nfc.carrera.ui.cardlist.explanddetail.ExplandCardInstructionLoading;
import com.huawei.nfc.carrera.ui.cardlist.explanddetail.ExplandCardInstructionLock;
import com.huawei.nfc.carrera.ui.cardlist.explanddetail.ExplandCardInstructionToActive;
import com.huawei.nfc.carrera.ui.cardlist.explanddetail.ExplandCardInstructionToDelete;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.util.NFCFragmentUtil;
import com.huawei.p190v.C2538c;
import com.huawei.pay.p130e.C5730c;
import com.huawei.pay.ui.util.ToastManager;
import com.huawei.ui.commonui.dialog.C6002a;
import com.huawei.ui.commonui.dialog.C6022u;
import com.huawei.ui.commonui.dialog.C6024w;
import com.huawei.wallet.R;
import com.huawei.wallet.model.unicard.UniCardInfo;
import com.huawei.wallet.ui.carddisplay.CardListInfoListener;
import java.util.List;

public final class NFCOpenApiImpl implements NFCOpenApi {
    private static final String KEY_FIRST_INTO_CARDLIST = "key_first_into_cardlist";
    private static final byte[] SYNC_LOCK = new byte[0];
    private static final String TAG = "NFCOpenApiImpl";
    private static NFCOpenApiImpl instance;
    private final CardLostManagerApi cardLostManagerApi;
    private final CardInfoManager cardManager;
    private final Context mContext;
    private C6022u mDlg = null;
    private C6002a mLoadingDialog21;
    private final BroadcastReceiver mNonLocalBroadcastReceiver = new C55306();
    private BroadcastReceiver networkReceiver = new C55295();

    class C55253 implements OnClickListener {
        C55253() {
        }

        public void onClick(View view) {
            NFCOpenApiImpl.this.cardLostManagerApi.handleDeviceRepair(1, null);
            LogX.d("start change server status ...");
        }
    }

    class C55295 extends BroadcastReceiver {
        C55295() {
        }

        public void onReceive(Context context, Intent intent) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(0);
            NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(1);
            if (networkInfo == null || networkInfo2 == null || networkInfo.isConnected() || networkInfo2.isConnected()) {
                C2538c.c(NFCOpenApiImpl.TAG, new Object[]{"网络连接"});
                NFCOpenApiImpl.this.cardLostManagerApi.clearAllNullifiedCardLocalInfo();
                return;
            }
            C2538c.c(NFCOpenApiImpl.TAG, new Object[]{"网络未连接"});
        }
    }

    class C55306 extends BroadcastReceiver {
        C55306() {
        }

        public void onReceive(Context context, Intent intent) {
            C2538c.c(NFCOpenApiImpl.TAG, new Object[]{" NFCBaseActivity connectedChanged mNonLocalBroadcastReceiver(): intent = " + intent.getAction()});
            String action = intent.getAction();
            if (action != null && action.equals("com.huawei.bone.action.CONNECTION_STATE_CHANGED")) {
                try {
                    DeviceInfo deviceInfo = (DeviceInfo) intent.getParcelableExtra("deviceinfo");
                    if (deviceInfo != null) {
                        int deviceConnectState = deviceInfo.getDeviceConnectState();
                        C2538c.b(NFCOpenApiImpl.TAG, new Object[]{"connectedChanged(): " + deviceInfo.getDeviceName() + ",state = " + deviceConnectState});
                        if (deviceConnectState == 2) {
                            NFCOpenApiImpl.this.cardLostManagerApi.clearAllNullifiedCardLocalInfo();
                            return;
                        }
                        return;
                    }
                    C2538c.e(NFCOpenApiImpl.TAG, new Object[]{"deviceInfo is null!"});
                } catch (ClassCastException e) {
                    C2538c.e(NFCOpenApiImpl.TAG, new Object[]{"ClassCastException e=" + e.getMessage()});
                }
            }
        }
    }

    public static NFCOpenApi getInstance(Context context) {
        NFCOpenApi nFCOpenApi;
        synchronized (SYNC_LOCK) {
            if (instance == null) {
                instance = new NFCOpenApiImpl(context);
            }
            nFCOpenApi = instance;
        }
        return nFCOpenApi;
    }

    private NFCOpenApiImpl(Context context) {
        if (context instanceof Activity) {
            this.mContext = context.getApplicationContext();
        } else {
            this.mContext = context;
        }
        this.cardManager = CardInfoManager.getInstance(this.mContext);
        this.cardLostManagerApi = LogicApiFactory.createCardLostManagerApi(this.mContext);
    }

    public void registerCardListInfoListener(CardListInfoListener cardListInfoListener) {
        this.cardManager.registerCardListListener(cardListInfoListener);
    }

    public void unregisterCardListListener(CardListInfoListener cardListInfoListener) {
        this.cardManager.unregisterCardListListener(cardListInfoListener);
    }

    public void refreshCardList() {
        this.cardManager.refreshCardList();
    }

    public void initNFC(Activity activity) {
        regiesterOnlineFP(activity);
        checkAndHandleDeviceStatus(activity);
        registerNetWorkReceiver();
        registerNonLocalBroadcast();
    }

    private void regiesterOnlineFP(Context context) {
        IntentFilter intentFilter = new IntentFilter(FpManagerReceiver.ACTION_FINGERPRINT_UPDATED);
        LocalBroadcastManager instance = LocalBroadcastManager.getInstance(context);
        if (instance != null) {
            instance.registerReceiver(new FpManagerReceiver(), intentFilter);
        } else {
            LogX.e("localBroadcastManager is null", false);
        }
    }

    private void checkAndHandleDeviceStatus(final Activity activity) {
        LogX.d("nfc checkAndHandleDeviceStatus");
        this.cardLostManagerApi.checkDeviceStatus(new CheckDeviceStatusCallback() {

            class C55201 implements Runnable {
                C55201() {
                }

                public void run() {
                    NFCOpenApiImpl.this.showRepairDeviceDlgJudgeByUser(activity);
                }
            }

            public void checkDeviceStatusCallback(String str) {
                if ("4".equals(str)) {
                    activity.runOnUiThread(new C55201());
                }
            }
        });
    }

    public void showRepairDeviceDlgJudgeByUser(final Activity activity) {
        LogX.d("NFC home Fragment : : show judge device status dialog");
        C2538c.b(TAG, new Object[]{"checkAccount showDialog"});
        if (this.mDlg == null || !this.mDlg.isShowing()) {
            C6024w c6024w = new C6024w(activity);
            c6024w.m27591a(R.string.nfc_device_status_repair_dlg_title);
            c6024w.m27596b(R.string.nfc_device_status_repair_dlg_content);
            c6024w.m27593a(R.string.nfc_cancel, new C55253()).m27597b(R.string.nfc_device_status_repair_dlg_do_repair, new OnClickListener() {

                class C55231 implements HandleDeviceRepairCallback {
                    C55231() {
                    }

                    public void handleDeviceRepairCallback(final boolean z) {
                        activity.runOnUiThread(new Runnable() {
                            public void run() {
                                NFCOpenApiImpl.this.getClearCardResult(z, activity);
                            }
                        });
                    }
                }

                public void onClick(View view) {
                    NFCOpenApiImpl.this.cardLostManagerApi.handleDeviceRepair(2, new C55231());
                    LogX.d("start delete cards ...");
                    NFCOpenApiImpl.this.startProgress(activity, activity.getResources().getString(R.string.nfc_device_status_repair_wait_progress_content));
                }
            });
            this.mDlg = c6024w.m27590a();
            this.mDlg.setCancelable(false);
            if (!this.mDlg.isShowing()) {
                this.mDlg.show();
                return;
            }
            return;
        }
        C2538c.b(TAG, new Object[]{"showBandUnavailableDialog Already show!"});
    }

    private void startProgress(Activity activity, String str) {
        if (this.mLoadingDialog21 == null) {
            C6002a c6002a = new C6002a(activity, R.style.app_update_dialogActivity);
            this.mLoadingDialog21 = C6002a.m27468a((Context) activity);
            this.mLoadingDialog21.m27476a(str);
            this.mLoadingDialog21.m27474a();
            this.mLoadingDialog21.setCanceledOnTouchOutside(false);
        }
        if (!activity.isFinishing() && this.mLoadingDialog21 != null) {
            this.mLoadingDialog21.show();
            C2538c.c(TAG, new Object[]{"mLoadingDialog.show()"});
        }
    }

    private void cancelProgress(Activity activity) {
        if (!activity.isFinishing() && this.mLoadingDialog21 != null) {
            this.mLoadingDialog21.cancel();
            this.mLoadingDialog21 = null;
            C2538c.c(TAG, new Object[]{"destroy mLoadingDialog21"});
        }
    }

    private void getClearCardResult(boolean z, final Activity activity) {
        cancelProgress(activity);
        LogX.d("end get delete cards result : " + z);
        if (z) {
            ToastManager.show((Context) activity, R.string.nfc_device_status_repair_dlg_deal_success);
            return;
        }
        C6024w c6024w = new C6024w(activity);
        c6024w.m27591a(R.string.nfc_device_status_repair_dlg_title);
        c6024w.m27596b(R.string.nfc_device_status_repair_continue_del_content);
        c6024w.m27597b(R.string.nfc_device_status_repair_continue_del_btn, new OnClickListener() {

            class C55271 implements HandleDeviceRepairCallback {
                C55271() {
                }

                public void handleDeviceRepairCallback(final boolean z) {
                    activity.runOnUiThread(new Runnable() {
                        public void run() {
                            NFCOpenApiImpl.this.getClearCardResult(z, activity);
                        }
                    });
                }
            }

            public void onClick(View view) {
                NFCOpenApiImpl.this.cardLostManagerApi.handleDeviceRepair(2, new C55271());
            }
        });
        C6022u a = c6024w.m27590a();
        a.setCancelable(false);
        if (!a.isShowing()) {
            a.show();
        }
    }

    public static boolean isDevicesSuportHuaweiPay(Context context) {
        return NFCFragmentUtil.getNFCShowPlan(context) == 2;
    }

    public void jumpToAddCardActivity(Activity activity) {
        Intent intent = new Intent();
        intent.setClass(activity, NFCEntranceActivity.class);
        intent.setAction(NFCEntranceActivity.CARD_PACKAGE_JUMP_TO_ADD_CARD_ACTION);
        intent.setPackage(activity.getPackageName());
        activity.startActivity(intent);
    }

    public boolean isCanDragStop(int i, int i2, List<UniCardInfo> list, Context context) {
        if (i == i2) {
            return false;
        }
        int size = list.size();
        if ((i2 != size - 1 || ((UniCardInfo) list.get(i)).m28102a() == 2) && (i != list.size() - 1 || ((UniCardInfo) list.get(size - 2)).m28102a() == 2)) {
            return true;
        }
        ToastManager.show(context, R.string.nfc_set_unactivited_as_default_card_fail);
        return false;
    }

    public void onDragStop(int i, int i2, List<UniCardInfo> list) {
        this.cardManager.updateCardOrder(i, i2, list);
    }

    public View getCardDetailView(UniCardInfo uniCardInfo, Activity activity, int i) {
        C2538c.c(TAG, new Object[]{"getCardDetailView(),info.getCardStatus()=" + uniCardInfo.m28102a()});
        View explandCardInstruction;
        if (uniCardInfo.m28102a() == 2) {
            explandCardInstruction = new ExplandCardInstruction(activity);
            explandCardInstruction.setData(uniCardInfo);
            LayoutParams layoutParams = new LayoutParams(-1, -2);
            layoutParams.height = i;
            explandCardInstruction.setLayoutParams(layoutParams);
            return explandCardInstruction;
        } else if (uniCardInfo.m28102a() == 99 || uniCardInfo.m28102a() == 92) {
            ExplandCardInstructionLock explandCardInstructionLock = new ExplandCardInstructionLock(activity);
            explandCardInstruction = explandCardInstructionLock.initView(i);
            explandCardInstructionLock.setData(uniCardInfo);
            return explandCardInstruction;
        } else if (uniCardInfo.m28102a() == 1 || uniCardInfo.m28102a() == 11 || uniCardInfo.m28102a() == 12 || uniCardInfo.m28102a() == 13) {
            ExplandCardInstructionToActive explandCardInstructionToActive = new ExplandCardInstructionToActive(activity);
            explandCardInstruction = explandCardInstructionToActive.initView(i);
            explandCardInstructionToActive.setData(uniCardInfo);
            return explandCardInstruction;
        } else if (uniCardInfo.m28102a() == 95 || uniCardInfo.m28102a() == 96 || uniCardInfo.m28102a() == 97 || uniCardInfo.m28102a() == 98 || uniCardInfo.m28102a() == 3) {
            ExplandCardInstructionLoading explandCardInstructionLoading = new ExplandCardInstructionLoading(activity);
            explandCardInstructionLoading.setData(uniCardInfo);
            return explandCardInstructionLoading.initView(i);
        } else if (uniCardInfo.m28102a() != 94 && uniCardInfo.m28102a() != 93) {
            return null;
        } else {
            ExplandCardInstructionToDelete explandCardInstructionToDelete = new ExplandCardInstructionToDelete(activity);
            explandCardInstruction = explandCardInstructionToDelete.initView(i);
            explandCardInstructionToDelete.setData(uniCardInfo);
            return explandCardInstruction;
        }
    }

    public boolean isShowQuickPayTipDialog(Context context) {
        boolean z = true;
        boolean z2 = NFCPreferences.getInstance(context).getBoolean(KEY_FIRST_INTO_CARDLIST, true);
        if (!z2) {
            z = z2;
        } else if (!C5730c.m26412c(context) || C5730c.m26411b(context)) {
            z = false;
        } else {
            List cardList = WalletTaManager.getInstance(context).getCardList();
            if (cardList == null || cardList.isEmpty()) {
                z = false;
            }
        }
        if (z) {
            NFCPreferences.getInstance(context).putBoolean(KEY_FIRST_INTO_CARDLIST, false);
        }
        return z;
    }

    public void setRefreshRF(boolean z) {
        this.cardManager.setRefreshRF(z);
    }

    private void registerNetWorkReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        this.mContext.registerReceiver(this.networkReceiver, intentFilter);
    }

    private void registerNonLocalBroadcast() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.huawei.bone.action.CONNECTION_STATE_CHANGED");
        intentFilter.addAction("com.huawei.bone.action.PHONE_SERVICE_BIND_SUCCESS");
        this.mContext.registerReceiver(this.mNonLocalBroadcastReceiver, intentFilter, com.huawei.hwcommonmodel.b.c.a, null);
    }
}
