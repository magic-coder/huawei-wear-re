package com.huawei.nfc.carrera.ui.bindcard;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.nfc.carrera.constant.AutoReportErrorCode;
import com.huawei.nfc.carrera.constant.Constant;
import com.huawei.nfc.carrera.logic.LogicApiFactory;
import com.huawei.nfc.carrera.logic.cardinfo.callback.QueryBankCardInfoCallback;
import com.huawei.nfc.carrera.logic.cardinfo.callback.QueryBankIssuerInfoCallback;
import com.huawei.nfc.carrera.logic.cardinfo.model.BankCardInfo;
import com.huawei.nfc.carrera.logic.cardinfo.model.BankIssuerInfo;
import com.huawei.nfc.carrera.logic.cardoperate.model.OpenCardInfo;
import com.huawei.nfc.carrera.logic.cardoperate.response.InstallCardResultCallback;
import com.huawei.nfc.carrera.storage.db.DataModel.CardOrderColumns;
import com.huawei.nfc.carrera.ui.NFCBaseActivity;
import com.huawei.nfc.carrera.ui.bus.exception.ShowBindBusResultActivity;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.nfc.carrera.util.logger.CloudEyeLogger;
import com.huawei.pay.p130e.p489b.C5728a;
import com.huawei.wallet.R;
import com.huawei.wallet.ui.cardholder.CardHolderActivity;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class BindCardActivity extends NFCBaseActivity implements InstallCardResultCallback, ShownBindSuccessEndListener, StartBindListener {
    private static final String DIAL_HEAD = "tel:";
    private static final String FRAGMENT_TAG_INPUT = "input_fragment";
    private static final String FRAGMENT_TAG_PROCESS = "process_fragment";
    private String cardNum;
    private int cardType;
    private String issuerId;
    private int issuerMode;
    private String mRefId;
    private boolean reAddFlag = false;

    class C55631 implements QueryBankIssuerInfoCallback {
        C55631() {
        }

        public void queryBankIssuerInfoCallback(int i, BankIssuerInfo bankIssuerInfo) {
            if (i == 0 && bankIssuerInfo != null) {
                String debitContactNumber = bankIssuerInfo.getDebitContactNumber();
                String crebitContactNumber = bankIssuerInfo.getCrebitContactNumber();
                if (debitContactNumber != null && debitContactNumber.length() > 0) {
                    BindCardActivity.this.callServicePhone(debitContactNumber);
                } else if (crebitContactNumber == null || crebitContactNumber.length() <= 0) {
                    BindCardActivity.this.callServicePhone(bankIssuerInfo.getContactNumber());
                } else {
                    BindCardActivity.this.callServicePhone(crebitContactNumber);
                }
            }
        }
    }

    class MyInstallCardResultCallback implements InstallCardResultCallback {
        private WeakReference<BindCardActivity> mBindCardAcitivityReference;
        private int mCardType;
        private String mIssuerId;

        public MyInstallCardResultCallback(BindCardActivity bindCardActivity, String str, int i) {
            this.mBindCardAcitivityReference = new WeakReference(bindCardActivity);
            this.mIssuerId = str;
            this.mCardType = i;
        }

        public void installResultCallback(int i, String str, String str2) {
            LogX.d("===123====绑定结果 resultCode = " + i);
            BindCardActivity bindCardActivity = (BindCardActivity) this.mBindCardAcitivityReference.get();
            BindCardProgressFragment bindCardProgressFragment = null;
            if (bindCardActivity != null) {
                bindCardProgressFragment = (BindCardProgressFragment) bindCardActivity.getFragmentManager().findFragmentByTag(BindCardActivity.FRAGMENT_TAG_PROCESS);
            } else {
                LogX.d("MyInstallCardResultCallback installResultCallback, mBindCardAcitivityReference get is null.");
            }
            if (i == 0) {
                if (bindCardActivity != null) {
                    bindCardActivity.setRedId(str2);
                }
                if (bindCardProgressFragment != null) {
                    bindCardProgressFragment.showBindSuccessView(this.mIssuerId, this.mCardType);
                    return;
                }
                return;
            }
            if (-99 == i) {
                Map hashMap = new HashMap();
                hashMap.put(ShowBindBusResultActivity.FAIL_REASON_KEY, "bind card fail");
                hashMap.put(CloudEyeLogger.FAIL_CODE, "" + i);
                hashMap.put("productId", str);
                LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_BIND_CARD_FAIL, hashMap, "processBindCard result: " + i, false, false);
            } else {
                LogX.e("startBind bind card fail resultCode: " + i);
            }
            if (bindCardProgressFragment != null) {
                LogX.d("===123====processFragment2 resultCode" + i);
                bindCardProgressFragment.bindFailed(i, this.mIssuerId, this.mCardType);
            }
        }
    }

    protected void onCreate(Bundle bundle) {
        LogX.d("===123===BindCardActivity onCreate");
        requestWindowFeature(1);
        super.onCreate(bundle);
        setRequestedOrientation(1);
        setTitle(R.string.nfc_fill_in_card_info);
        setContentView(R.layout.nfc_activity_bind_card_layout);
        if (!initParams()) {
            finish();
        } else if (this.reAddFlag) {
            LogX.d("onCreate rebind card.");
            setTitle(getResources().getString(R.string.nfc_add_bank_card));
            Fragment bindCardProgressFragment = new BindCardProgressFragment(this);
            if (!bindCardProgressFragment.isAdded()) {
                LogX.d("show progressfragment rebind card.");
                getFragmentManager().beginTransaction().add(R.id.bind_container, bindCardProgressFragment, FRAGMENT_TAG_PROCESS).commit();
                bindCardProgressFragment.binding();
            }
            doReaddCard(bindCardProgressFragment);
        } else {
            LogX.d("onCreate inputcardfragment add card.");
            Fragment bindCardInputFragment = new BindCardInputFragment(this);
            bindCardInputFragment.setArguments(getIntent().getExtras());
            if (bindCardInputFragment.isAdded()) {
                BindCardProgressFragment bindCardProgressFragment2 = (BindCardProgressFragment) getFragmentManager().findFragmentByTag(FRAGMENT_TAG_PROCESS);
                if (bindCardProgressFragment2 != null) {
                    getFragmentManager().beginTransaction().hide(bindCardProgressFragment2).show(bindCardInputFragment).commit();
                    return;
                }
                return;
            }
            getFragmentManager().beginTransaction().add(R.id.bind_container, bindCardInputFragment, FRAGMENT_TAG_INPUT).commit();
        }
    }

    private boolean initParams() {
        Intent intent = getIntent();
        if (intent == null) {
            LogX.e("initParams intent empty.");
            return false;
        }
        Bundle extras = intent.getExtras();
        if (extras == null) {
            LogX.e("bundle empty.");
            return false;
        }
        this.issuerId = extras.getString("issuer_id");
        this.cardNum = C5728a.m26404b(extras.getString(InputCardNumActivity.INTENT_KEY_CARD_NUM), getApplicationContext());
        this.cardType = extras.getInt("card_type");
        this.issuerMode = extras.getInt("issuer_mode");
        this.reAddFlag = extras.getBoolean("readd_card", false);
        this.mRefId = extras.getString(CardOrderColumns.COLUMN_NAME_REFENCE_ID);
        if (StringUtil.isEmpty(this.issuerId, true) || StringUtil.isEmpty(this.cardNum, true) || this.cardType <= 0 || this.issuerMode <= 0) {
            return false;
        }
        return true;
    }

    public void startBind(OpenCardInfo openCardInfo) {
        Fragment bindCardProgressFragment;
        setTitle(getResources().getString(R.string.nfc_add_bank_card));
        Fragment fragment = (BindCardProgressFragment) getFragmentManager().findFragmentByTag(FRAGMENT_TAG_PROCESS);
        if (fragment == null) {
            LogX.i("===123====processFragment=null");
            bindCardProgressFragment = new BindCardProgressFragment(this);
        } else {
            bindCardProgressFragment = fragment;
        }
        BindCardInputFragment bindCardInputFragment = (BindCardInputFragment) getFragmentManager().findFragmentByTag(FRAGMENT_TAG_INPUT);
        if (bindCardProgressFragment.isAdded()) {
            LogX.i("===123====!processFragment.isAdded()");
            if (bindCardInputFragment != null) {
                getFragmentManager().beginTransaction().hide(bindCardInputFragment).show(bindCardProgressFragment).commit();
            } else {
                getFragmentManager().beginTransaction().show(bindCardProgressFragment).commit();
            }
            bindCardProgressFragment.reBind();
            bindCardProgressFragment.binding();
        } else {
            LogX.i("===123====.isAdded()");
            if (bindCardInputFragment == null) {
                getFragmentManager().beginTransaction().add(R.id.bind_container, bindCardProgressFragment, FRAGMENT_TAG_PROCESS).commit();
            } else {
                getFragmentManager().beginTransaction().add(R.id.bind_container, bindCardProgressFragment, FRAGMENT_TAG_PROCESS).hide(bindCardInputFragment).commit();
            }
            bindCardProgressFragment.binding();
        }
        LogX.i("===123====!createCardOperateApi.");
        LogicApiFactory.createCardOperateApi(getApplicationContext()).openCard(this.issuerMode, openCardInfo, new MyInstallCardResultCallback(this, this.issuerId, this.cardType));
    }

    private void setRedId(String str) {
        this.mRefId = str;
    }

    public void bindSuccess(int i) {
        LogX.i("===123===BIND_CARD  bindResult = " + i);
        switch (i) {
            case 0:
                Intent intent = new Intent();
                intent.setClass(this, ActiveCardActivity.class);
                intent.putExtra("refId", this.mRefId);
                intent.putExtra(VerifySmsCodeActivity.ISSUER_MODE, this.issuerMode);
                startActivity(intent);
                finish();
                return;
            case 1:
            case 5:
                toHomeFragment();
                return;
            case 2:
                showInputFragment();
                return;
            case 3:
                LogX.i("===123===BIND_FAIL_REBIND");
                doRebind();
                return;
            case 4:
                contactToServer();
                return;
            case 6:
                callServicePhone(Constant.UNIONPAY_CONTACT_NUM);
                return;
            default:
                LogX.i("error operate type, jump to card list");
                toHomeFragment();
                return;
        }
    }

    private void doRebind() {
        Fragment bindCardProgressFragment;
        Fragment fragment = (BindCardProgressFragment) getFragmentManager().findFragmentByTag(FRAGMENT_TAG_PROCESS);
        if (fragment == null) {
            bindCardProgressFragment = new BindCardProgressFragment(this);
        } else {
            bindCardProgressFragment = fragment;
        }
        LogX.d("===123===BindCardActivity doRebind reAddFlag" + this.reAddFlag);
        if (this.reAddFlag) {
            bindCardProgressFragment.reBind();
            bindCardProgressFragment.binding();
            doReaddCard(bindCardProgressFragment);
            return;
        }
        LogX.d("===123===BindCardActivity BindCardInputFragment");
        fragment = (BindCardInputFragment) getFragmentManager().findFragmentByTag(FRAGMENT_TAG_INPUT);
        if (fragment == null) {
            LogX.d("===123===BindCardActivity inputFragment = null");
            fragment = new BindCardInputFragment(this);
        }
        switchFragment(bindCardProgressFragment, fragment);
    }

    private void toHomeFragment() {
        Intent intent = new Intent();
        intent.setClass(this, CardHolderActivity.class);
        intent.addFlags(HwAccountConstants.FLAG_TRANSLUCENT_STATUS);
        intent.setPackage(getPackageName());
        startActivity(intent);
        finish();
    }

    private void contactToServer() {
        LogicApiFactory.createCardManager(this).queryBankIssuerInfo(this.issuerId, new C55631());
    }

    private void showInputFragment() {
        Fragment bindCardProgressFragment;
        Fragment fragment = (BindCardProgressFragment) getFragmentManager().findFragmentByTag(FRAGMENT_TAG_PROCESS);
        if (fragment == null) {
            bindCardProgressFragment = new BindCardProgressFragment(this);
        } else {
            bindCardProgressFragment = fragment;
        }
        fragment = (BindCardInputFragment) getFragmentManager().findFragmentByTag(FRAGMENT_TAG_INPUT);
        if (fragment == null) {
            fragment = new BindCardInputFragment(this);
        }
        switchFragment(bindCardProgressFragment, fragment);
    }

    private void callServicePhone(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                startActivity(new Intent("android.intent.action.DIAL", Uri.parse(DIAL_HEAD + str)));
            } catch (Throwable e) {
                LogX.e("BindCardActivity jump to dial:", e, false);
            }
        }
    }

    private void switchFragment(Fragment fragment, Fragment fragment2) {
        getFragmentManager().beginTransaction().hide(fragment).show(fragment2).commit();
    }

    public Intent getIntent() {
        return super.getIntent();
    }

    public void installResultCallback(int i, String str, String str2) {
        BindCardProgressFragment bindCardProgressFragment = (BindCardProgressFragment) getFragmentManager().findFragmentByTag(FRAGMENT_TAG_PROCESS);
        if (i != 0) {
            if (-99 == i) {
                Map hashMap = new HashMap();
                hashMap.put(ShowBindBusResultActivity.FAIL_REASON_KEY, "bind card fail");
                hashMap.put("productId", str);
                hashMap.put(CloudEyeLogger.FAIL_CODE, "" + i);
                LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_BIND_CARD_FAIL, hashMap, "processBindCard result: " + i, false, false);
            } else {
                LogX.e("installResultCallback bind card fail resultCode: " + i);
            }
            if (bindCardProgressFragment != null) {
                LogX.e("===123====processFragment resultCode" + i);
                bindCardProgressFragment.reBind();
                bindCardProgressFragment.bindFailed(i, this.issuerId, this.cardType);
            }
        } else if (bindCardProgressFragment != null) {
            bindCardProgressFragment.showBindSuccessView(this.issuerId, this.cardType);
        }
    }

    private void doReaddCard(final BindCardProgressFragment bindCardProgressFragment) {
        if (this.mRefId == null) {
            LogX.d("===123====doReaddCard cardnull == mRefId");
            bindCardProgressFragment.bindFailed(-99, this.issuerId, this.cardType);
            return;
        }
        LogicApiFactory.createCardManager(this).queryBankCardInfo(this.mRefId, new QueryBankCardInfoCallback() {
            public void queryBankCardInfoCallback(int i, BankCardInfo bankCardInfo) {
                if (i != 0 || bankCardInfo == null) {
                    LogX.d("===123====rebindcard interface.else");
                    bindCardProgressFragment.bindFailed(-99, BindCardActivity.this.issuerId, BindCardActivity.this.cardType);
                    return;
                }
                LogX.d("rebindcard interface.");
                LogicApiFactory.createCardOperateApi(BindCardActivity.this).retryDownloadCard(BindCardActivity.this.mRefId, bankCardInfo.getProductId(), BindCardActivity.this);
            }
        });
    }
}
