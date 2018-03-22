package com.huawei.nfc.carrera.ui.bus;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.huawei.cp3.widget.C4372a;
import com.huawei.cp3.widget.p382a.p383a.C4371b;
import com.huawei.nfc.carrera.logic.CardInfoManagerApi;
import com.huawei.nfc.carrera.logic.CardOperateLogicApi;
import com.huawei.nfc.carrera.logic.LogicApiFactory;
import com.huawei.nfc.carrera.logic.cardoperate.opencardlogupload.LogUploadOperator;
import com.huawei.nfc.carrera.ui.NFCBaseActivity;
import com.huawei.nfc.carrera.ui.bus.exception.ShowBindBusResultActivity;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.ui.commonui.dialog.C6002a;
import com.huawei.p190v.C2538c;
import com.huawei.wallet.R;

public abstract class BusBaseActivity extends NFCBaseActivity {
    private static final String TAG = "BusBaseActivity";
    protected CardInfoManagerApi cardInfoManager;
    protected CardOperateLogicApi cardOperateLogicManager;
    protected boolean isVisible;
    protected C4371b progressDialog;
    protected C6002a progressDialog21;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cardOperateLogicManager = LogicApiFactory.createCardOperateApi(getApplicationContext());
        this.cardInfoManager = LogicApiFactory.createCardManager(getApplicationContext());
    }

    protected void init() {
        this.progressDialog = C4372a.m21001b(this);
        this.progressDialog.setCanceledOnTouchOutside(false);
        C6002a c6002a = new C6002a(this, R.style.app_update_dialogActivity);
        this.progressDialog21 = C6002a.m27468a((Context) this);
        this.progressDialog21.setCanceledOnTouchOutside(false);
    }

    protected void onResume() {
        super.onResume();
        this.isVisible = true;
    }

    protected void onPause() {
        super.onPause();
        this.isVisible = false;
    }

    protected void showProgress(C4371b c4371b, String str, boolean z, OnCancelListener onCancelListener) {
        C2538c.c(TAG, new Object[]{"HwProgressDialogInterface showLoadingDialog : " + c4371b + " ; message : " + str + " ; isCancelable " + z});
        if (c4371b != null && !c4371b.isShowing()) {
            c4371b.mo4439a((CharSequence) str);
            c4371b.setCancelable(z);
            c4371b.setOnCancelListener(onCancelListener);
            c4371b.show();
        }
    }

    protected void dismissProgress(C4371b c4371b) {
        C2538c.c(TAG, new Object[]{"HwProgressDialogInterface dismissProgress progress : " + c4371b});
        if (isFinishing()) {
            LogX.w("dismissProgress, activity is finishing");
        } else if (c4371b != null && c4371b.isShowing()) {
            c4371b.dismiss();
        }
    }

    protected void showProgress(C6002a c6002a, String str, boolean z, OnCancelListener onCancelListener) {
        showLoadingDialog(str, z, onCancelListener);
    }

    protected void dismissProgress(C6002a c6002a) {
        destroyLoadingDialog();
    }

    protected void setCardImageSize(ImageView imageView) {
        int dimension = getResources().getDisplayMetrics().widthPixels - (((int) getResources().getDimension(R.dimen.bus_card_image_margin_left_or_right)) * 2);
        int i = (int) (((double) dimension) / 1.6d);
        LayoutParams layoutParams = imageView.getLayoutParams();
        layoutParams.width = dimension;
        layoutParams.height = i;
        imageView.setLayoutParams(layoutParams);
    }

    protected boolean handleCommonErrorCode(int i) {
        C2538c.c(TAG, new Object[]{"handleCommonErrorCode  errorCode : " + i});
        switch (i) {
            case -2:
                showToast(R.string.nfc_bindcard_error_connection_failed);
                return true;
            case 11:
                showToast(R.string.nfc_bindcard_error_no_network_failed);
                return true;
            case 20:
                showToast(R.string.nfc_bus_offline_read_card_failed);
                return true;
            case 21:
                showToast(R.string.nfc_bus_offline_card_disabled);
                return true;
            case 22:
                showToast(R.string.nfc_bus_offline_card_in_blacklist);
                return true;
            case 23:
                showToast(R.string.nfc_bus_offline_card_balance_error);
                return true;
            case 24:
                showToast(R.string.nfc_bus_offline_card_balance_error);
                return true;
            case 26:
                showToast(R.string.nfc_bus_offline_card_date_error);
                return true;
            case 28:
                showToast(R.string.nfc_bus_offline_card_after_expire_date_error);
                return true;
            case 29:
                showToast(R.string.nfc_bus_offline_card_date_error);
                return true;
            default:
                return false;
        }
    }

    protected String getCommonErrorMessage(int i) {
        switch (i) {
            case -2:
            case 11:
                return getString(R.string.nfc_no_network_connection);
            case 12:
                return getString(R.string.nfc_nfc_not_open);
            default:
                return null;
        }
    }

    protected void jump2ResultActivity(String str, String str2, int i, String str3, String str4, int i2, boolean z, boolean z2) {
        Intent intent = new Intent(this, ShowBindBusResultActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("fail_desc", str);
        bundle.putString(ShowBindBusResultActivity.FAIL_REASON_KEY, str2);
        bundle.putInt(ShowBindBusResultActivity.FAIL_OPR_TYPE_KEY, i);
        bundle.putString("issuerId", str3);
        bundle.putString(ShowBindBusResultActivity.CARD_AID, str4);
        bundle.putInt("key_enterance", i2);
        bundle.putBoolean(ShowBindBusResultActivity.RETRY_KEY, z);
        bundle.putBoolean(ShowBindBusResultActivity.OPENCARD_KEY, z2);
        intent.putExtras(bundle);
        startActivity(intent);
        if (i == 0) {
            setResult(-1);
            finish();
        }
    }

    protected void openCardLogUpload(String str, String str2, String str3) {
        LogUploadOperator.getInstance(this).init(str, str2, str3, 11);
    }
}
