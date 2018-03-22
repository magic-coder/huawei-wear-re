package com.huawei.nfc.carrera.ui.bindcard;

import android.content.Intent;
import com.huawei.nfc.carrera.logic.LogicApiFactory;
import com.huawei.nfc.carrera.logic.cardoperate.response.ActiveCardCallback;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.wallet.R;

public class ActiveCardActivity extends VerifySmsCodeActivity implements ActiveCardCallback {
    protected int getTitleResId() {
        return R.string.nfc_active_card_title;
    }

    protected int getButtonNameResId() {
        return R.string.nfc_next_step;
    }

    protected void getSmsCode(String str, int i) {
        LogicApiFactory.createCardOperateApi(getApplicationContext()).requestActiveSmsCode(str, i, this);
    }

    protected void verifySmsCode(String str, int i, String str2) {
        showLoadingDialog(R.string.nfc_waiting_for_active_card);
        LogicApiFactory.createCardOperateApi(getApplicationContext()).activeCard(str, i, str2, this);
    }

    public void activeResultCallback(int i) {
        LogX.d("active card result: " + i);
        destroyLoadingDialog();
        switch (i) {
            case -9:
                stopRetryCountDown();
                showVerifyDialog();
                return;
            case -8:
                showToast(R.string.nfc_activate_card_fail_retry_later_or_contact_bank);
                return;
            case -7:
                stopRetryCountDown();
                return;
            case -4:
                showToast(R.string.nfc_detail_active_card_entrance_auto_notmatch);
                return;
            case -3:
                showToast(R.string.nfc_detail_active_card_entrance_auth_overtime);
                return;
            case 0:
                if (isFinishing()) {
                    showToast(R.string.nfc_detail_active_card_entrance_success);
                    return;
                }
                stopRetryCountDown();
                destroyLoadingDialog();
                startActivity(new Intent(this, BindCardSuccessActvity.class));
                finish();
                return;
            default:
                showToast(R.string.nfc_detail_active_card_entrance_unknown_errors);
                return;
        }
    }

    protected void onDestroy() {
        destroyLoadingDialog();
        stopRetryCountDown();
        super.onDestroy();
    }
}
