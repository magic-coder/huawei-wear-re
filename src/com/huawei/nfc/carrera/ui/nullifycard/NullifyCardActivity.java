package com.huawei.nfc.carrera.ui.nullifycard;

import android.content.Intent;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.nfc.carrera.logic.LogicApiFactory;
import com.huawei.nfc.carrera.logic.cardoperate.response.NullifyCardResultCallback;
import com.huawei.nfc.carrera.ui.bindcard.VerifySmsCodeActivity;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.wallet.R;
import com.huawei.wallet.ui.cardholder.CardHolderActivity;

public class NullifyCardActivity extends VerifySmsCodeActivity implements NullifyCardResultCallback {
    protected int getTitleResId() {
        return R.string.nfc_nullify_card_title;
    }

    protected int getButtonNameResId() {
        return R.string.nfc_nullify_card_title;
    }

    public void nullifyResultCallback(int i) {
        dismissProgressDialog();
        switch (i) {
            case -7:
                showToast(R.string.nfc_detail_nullify_card_entrance_others_fail);
                return;
            case -6:
                showToast(R.string.nfc_detail_nullify_card_entrance_smscode_overtime);
                return;
            case -5:
                showToast(R.string.nfc_detail_nullify_card_entrance_smscode_unmatch);
                return;
            case -3:
                showToast(R.string.nfc_detail_nullify_card_entrance_network_unable);
                return;
            case 0:
                LogX.d("nullifyResultCallback: Delete card success,go to NFC HomeFragment.");
                stopRetryCountDown();
                showToast(R.string.nfc_detail_nullify_card_entrance_success);
                Intent intent = new Intent();
                intent.setClass(this, CardHolderActivity.class);
                intent.addFlags(HwAccountConstants.FLAG_TRANSLUCENT_STATUS);
                intent.setPackage(getPackageName());
                startActivity(intent);
                finish();
                return;
            default:
                showToast(R.string.nfc_detail_nullify_card_entrance_others_fail);
                return;
        }
    }

    protected int getButtonNameColor() {
        return R.color.CS_delete_red;
    }

    protected void onDestroy() {
        dismissProgressDialog();
        stopRetryCountDown();
        super.onDestroy();
    }

    protected void getSmsCode(String str, int i) {
        LogicApiFactory.createCardOperateApi(getApplicationContext()).requestNullifySmsCode(this.mRefId, i, this);
    }

    protected void verifySmsCode(String str, int i, String str2) {
        showProgressDialog(null, getString(R.string.nfc_nullify_card_nullifying), false);
        LogicApiFactory.createCardOperateApi(getApplicationContext()).nullifyCard(str, i, str2, this);
    }
}
