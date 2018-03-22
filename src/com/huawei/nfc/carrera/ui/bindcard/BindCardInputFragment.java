package com.huawei.nfc.carrera.ui.bindcard;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Fragment;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.location.LocationManagerProxy;
import com.amap.api.location.LocationProviderProxy;
import com.huawei.nfc.PluginPay;
import com.huawei.nfc.PluginPayAdapter;
import com.huawei.nfc.carrera.logic.LogicApiFactory;
import com.huawei.nfc.carrera.logic.cardinfo.callback.QueryBankIssuerInfoCallback;
import com.huawei.nfc.carrera.logic.cardinfo.impl.CardInfoManager;
import com.huawei.nfc.carrera.logic.cardinfo.model.BankIssuerInfo;
import com.huawei.nfc.carrera.logic.cardoperate.model.OpenCardInfo;
import com.huawei.nfc.carrera.logic.util.NfcHianalyticsUtil;
import com.huawei.nfc.carrera.server.card.model.CaptureMethod;
import com.huawei.nfc.carrera.ui.NFCBaseActivity;
import com.huawei.nfc.carrera.ui.webview.NormalWebViewActivity;
import com.huawei.nfc.carrera.ui.widget.CUPEditText;
import com.huawei.nfc.carrera.ui.widget.ValidDatePickerDialog;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.MoneyUtil;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.p190v.C2538c;
import com.huawei.pay.p130e.C5727a;
import com.huawei.pay.p130e.p489b.C5728a;
import com.huawei.pay.p473a.p474a.p475a.C5565a;
import com.huawei.pay.ui.widget.ClearEditText;
import com.huawei.ui.commonui.dialog.C6002a;
import com.huawei.ui.commonui.dialog.C6027z;
import com.huawei.ui.commonui.dialog.ab;
import com.huawei.wallet.R;
import java.lang.ref.WeakReference;

@SuppressLint({"NewApi"})
public class BindCardInputFragment extends Fragment implements OnClickListener, QueryBankIssuerInfoCallback {
    private static final int CARD_INFO_COUNT = 5;
    private static final int CVV2_INFO = 1;
    private static final int CVV2_KEY = 2;
    private static final int CVV2_MAX_LENGTH = 3;
    private static final int DATE_INFO = 3;
    private static final int DATE_KEY = 1;
    private static final int IDNUM_KEY = 4;
    private static final int IDNUM_MAX_LENGTH = 18;
    private static final int MASSAGE_DISMSS_LOAD = 2;
    private static final int MASSAGE_SHOW_LOAD = 1;
    private static final int PASSWORD_MAX_LENGTH = 6;
    private static final int PHONE_INFO = 2;
    private static final int PHONE_KEY = 3;
    private static final int PHONE_MAX_LENGTH = 11;
    private static final int PWD_KEY = 0;
    private static final int START_BIND = 3;
    private static final String TAG = "BindCardInputFragment";
    private LocationManagerProxy aMapLocManager;
    AMapLocationListener aMapLocationListener = new C55683();
    private TextView andText;
    private ImageView bankIconView;
    private TextView bankNameView;
    private StartBindListener bindListener;
    private TextView cardCardType;
    private TextView cardEndNum;
    private EditText[] cardInfoList;
    private boolean[] cardKeyList;
    private String cardNum;
    private int cardType;
    private String dateInfomation = "";
    private boolean isAgreeLicence = false;
    private String issuerId;
    private int issuerMode;
    Double latitude = Double.valueOf(0.0d);
    private CheckBox licenceAgreeView;
    private LinearLayout licenceAgreementsLayout;
    private String licenceAgreementsTitleUrl;
    private TextView licenceAgreemntsTitle;
    private LinearLayout licenceTermsLayout;
    private TextView licenceTermsTitle;
    private String licenceTermsTitleUrl;
    Double longitude = Double.valueOf(0.0d);
    private Handler mHandler = new Handler() {
        public void dispatchMessage(Message message) {
            if (1 == message.what) {
                BindCardInputFragment.this.showLoadingDialog(R.string.huaweipay_loading);
            } else if (2 == message.what) {
                BindCardInputFragment.this.destroyLoadingDialog();
            } else if (3 == message.what) {
                BindCardInputFragment.this.bindCardInputNextStep();
            }
        }
    };
    protected C6002a mLoadingDialog21;
    public int mLockscreenStatus = -1;
    private ValidDatePickerDialog mValidDatePickerDialog;
    private TextView nextStepText;
    public PluginPayAdapter pluginPayAdapter;
    private View rootView;
    private Runnable runnable = new C55672();

    class C55661 implements Runnable {
        C55661() {
        }

        public void run() {
            BindCardInputFragment.this.mHandler.removeCallbacks(BindCardInputFragment.this.runnable);
            BindCardInputFragment.this.mHandler.postDelayed(BindCardInputFragment.this.runnable, 10000);
            BindCardInputFragment.this.aMapLocManager.requestLocationData(LocationProviderProxy.AMapNetwork, 200, 100.0f, BindCardInputFragment.this.aMapLocationListener);
        }
    }

    class C55672 implements Runnable {
        C55672() {
        }

        public void run() {
            C2538c.b(BindCardInputFragment.TAG, new Object[]{"================runnable 时间到停止定位"});
            BindCardInputFragment.this.stopLocation();
        }
    }

    class C55683 implements AMapLocationListener {
        C55683() {
        }

        public void onLocationChanged(AMapLocation aMapLocation) {
            BindCardInputFragment.this.latitude = Double.valueOf(aMapLocation.getLatitude());
            BindCardInputFragment.this.longitude = Double.valueOf(aMapLocation.getLongitude());
            C2538c.b(BindCardInputFragment.TAG, new Object[]{"===123===requestLocationData latitude=" + BindCardInputFragment.this.latitude + "longitude" + BindCardInputFragment.this.longitude});
            BindCardInputFragment.this.stopLocation();
        }

        public void onLocationChanged(Location location) {
        }

        public void onStatusChanged(String str, int i, Bundle bundle) {
        }

        public void onProviderEnabled(String str) {
        }

        public void onProviderDisabled(String str) {
        }
    }

    class C55694 implements OnEditorActionListener {
        C55694() {
        }

        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i == 5) {
                ((CUPEditText) BindCardInputFragment.this.cardInfoList[0]).showSafeKeyboard(textView);
            }
            return false;
        }
    }

    class C55705 implements C5565a {
        C55705() {
        }

        public void onTextChanged(String str, String str2) {
            BindCardInputFragment.this.validButtonState();
        }
    }

    class C55716 implements C5565a {
        C55716() {
        }

        public void onTextChanged(String str, String str2) {
            BindCardInputFragment.this.validButtonState();
        }
    }

    class C55727 implements OnFocusChangeListener {
        C55727() {
        }

        public void onFocusChange(View view, boolean z) {
            if (!z) {
                CharSequence obj = BindCardInputFragment.this.cardInfoList[3].getText().toString();
                if (BindCardInputFragment.this.checkPhoneNum() || TextUtils.isEmpty(obj)) {
                    BindCardInputFragment.this.setErrorIconDismiss(BindCardInputFragment.this.cardInfoList[3]);
                } else {
                    BindCardInputFragment.this.throwPhoneError();
                }
            }
        }
    }

    class C55738 implements OnClickListener {
        C55738() {
        }

        public void onClick(View view) {
            BindCardInputFragment.this.showInfoDialog(2);
        }
    }

    class C55749 implements C5565a {
        C55749() {
        }

        public void onTextChanged(String str, String str2) {
            BindCardInputFragment.this.validButtonState();
        }
    }

    class MyQueryBankIssuerInfoCallback implements QueryBankIssuerInfoCallback {
        private WeakReference<BindCardInputFragment> mBindCardInputFragmentReference;

        public MyQueryBankIssuerInfoCallback(BindCardInputFragment bindCardInputFragment) {
            this.mBindCardInputFragmentReference = new WeakReference(bindCardInputFragment);
        }

        public void queryBankIssuerInfoCallback(int i, BankIssuerInfo bankIssuerInfo) {
            BindCardInputFragment bindCardInputFragment = (BindCardInputFragment) this.mBindCardInputFragmentReference.get();
            if (i == 0 && bankIssuerInfo != null && bindCardInputFragment != null) {
                bindCardInputFragment.refreshCardNameIconInfo(bankIssuerInfo);
            }
        }
    }

    class ValidDateListener implements OnDateSetListener {
        private final ClearEditText clearEditText;

        public ValidDateListener(ClearEditText clearEditText) {
            this.clearEditText = clearEditText;
        }

        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            String str;
            if (i2 <= 9) {
                str = "0" + i2;
            } else {
                str = String.valueOf(i2);
            }
            String str2 = "";
            int i4 = (i % 1000) % 100;
            if (i4 <= 9) {
                str2 = "0" + i4;
            } else {
                str2 = String.valueOf(i4);
            }
            this.clearEditText.setText(str + "/" + str2);
            this.clearEditText.setError(null);
            BindCardInputFragment.this.dateInfomation = i + "" + str;
            C2538c.b(BindCardInputFragment.TAG, new Object[]{"==valid date onDateSet : " + BindCardInputFragment.this.dateInfomation + " ; setEditText : " + str2 + str});
        }
    }

    public BindCardInputFragment(StartBindListener startBindListener) {
        this.bindListener = startBindListener;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        this.issuerId = arguments.getString("issuer_id");
        this.cardNum = C5728a.m26404b(arguments.getString(InputCardNumActivity.INTENT_KEY_CARD_NUM), getActivity().getApplicationContext());
        this.cardType = arguments.getInt("card_type");
        this.issuerMode = arguments.getInt("issuer_mode");
        this.pluginPayAdapter = (PluginPayAdapter) PluginPay.getInstance(getActivity()).getAdapter();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (getActivity() != null) {
            getActivity().getWindow().addFlags(8192);
        }
        this.rootView = layoutInflater.inflate(R.layout.nfc_fragment_bind_card_input, viewGroup, false);
        this.cardKeyList = getCardInfo();
        initViews();
        initViewStub(this.cardKeyList);
        LogicApiFactory.createCardManager(getActivity().getApplicationContext()).queryBankIssuerInfo(this.issuerId, new MyQueryBankIssuerInfoCallback(this));
        C2538c.b(TAG, new Object[]{"===123====Enter onCreateView"});
        getPositionByMobileNet();
        return this.rootView;
    }

    private void getPositionByMobileNet() {
        C2538c.b(TAG, new Object[]{"Enter getPositionByMobileNet"});
        this.aMapLocManager = LocationManagerProxy.getInstance(getActivity());
        if (this.aMapLocManager != null) {
            new Thread(new C55661()).start();
        }
        C2538c.b(TAG, new Object[]{"Leave getPositionByMobileNet"});
    }

    private void stopLocation() {
        C2538c.b(TAG, new Object[]{"================Enter stopLocation"});
        if (this.aMapLocManager != null) {
            this.aMapLocManager.removeUpdates(this.aMapLocationListener);
            this.aMapLocManager.destroy();
        }
        this.aMapLocManager = null;
    }

    private void initViews() {
        this.bankIconView = (ImageView) this.rootView.findViewById(R.id.bank_icon);
        this.bankNameView = (TextView) this.rootView.findViewById(R.id.bank_name);
        this.cardEndNum = (TextView) this.rootView.findViewById(R.id.nfc_card_end_number);
        this.cardCardType = (TextView) this.rootView.findViewById(R.id.nfc_card_type_credit);
        this.licenceAgreeView = (CheckBox) this.rootView.findViewById(R.id.agree_view);
        this.licenceAgreeView.setOnClickListener(this);
        this.licenceTermsTitle = (TextView) this.rootView.findViewById(R.id.nfc_wallet_use_licence_title);
        this.licenceTermsTitle.setOnClickListener(this);
        this.licenceAgreemntsTitle = (TextView) this.rootView.findViewById(R.id.nfc_wallet_use_agreements_title);
        this.licenceAgreemntsTitle.setOnClickListener(this);
        this.licenceTermsLayout = (LinearLayout) this.rootView.findViewById(R.id.nfc_wallet_use_licence_layout);
        this.licenceAgreementsLayout = (LinearLayout) this.rootView.findViewById(R.id.nfc_wallet_use_agreements_layout);
        this.andText = (TextView) this.rootView.findViewById(R.id.nfc_wallet_use_agreements_title_and);
        this.nextStepText = (TextView) this.rootView.findViewById(R.id.bind_card_next_step);
        this.nextStepText.setOnClickListener(this);
    }

    private void refreshCardNameIconInfo(BankIssuerInfo bankIssuerInfo) {
        if (!StringUtil.isEmpty(bankIssuerInfo.getIssuerName(), true)) {
            this.bankNameView.setText(bankIssuerInfo.getIssuerName());
        }
        this.cardEndNum.setText(getText(R.string.nfc_bind_end_number) + getCardNumEndFour(this.cardNum));
        if (2 == this.cardType) {
            this.cardCardType.setText(R.string.nfc_card_type_debit);
            this.licenceTermsTitleUrl = bankIssuerInfo.getDebitTermsUrl();
            this.licenceTermsTitle.setText(bankIssuerInfo.getDebitTermsTitle());
        } else {
            this.cardCardType.setText(R.string.nfc_card_type_credit);
            this.licenceTermsTitleUrl = bankIssuerInfo.getCreditTermsUrl();
            this.licenceTermsTitle.setText(bankIssuerInfo.getCreditTermsTitle());
        }
        if (StringUtil.isEmpty(this.licenceTermsTitleUrl, true) && StringUtil.isEmpty(bankIssuerInfo.getBankAgreementUrl(), true)) {
            this.nextStepText.setEnabled(false);
            this.isAgreeLicence = true;
            this.licenceTermsLayout.setVisibility(8);
        } else if (StringUtil.isEmpty(bankIssuerInfo.getBankAgreementUrl(), true)) {
            this.licenceAgreementsLayout.setVisibility(8);
        } else {
            this.licenceAgreemntsTitle.setText(bankIssuerInfo.getBankAgreementTitle());
            this.licenceAgreementsTitleUrl = bankIssuerInfo.getBankAgreementUrl();
            if (StringUtil.isEmpty(this.licenceTermsTitleUrl, true)) {
                this.andText.setVisibility(8);
            }
        }
        this.bankIconView.setImageBitmap(bankIssuerInfo.getLogoIcon());
    }

    public void onClick(View view) {
        boolean z = true;
        int id = view.getId();
        if (R.id.agree_view == id) {
            view.setFocusable(true);
            view.requestFocusFromTouch();
            if (this.isAgreeLicence) {
                z = false;
            }
            this.isAgreeLicence = z;
            validButtonState();
        } else if (R.id.nfc_wallet_use_licence_title == id) {
            r0 = new Intent();
            r0.setClass(getActivity(), NormalWebViewActivity.class);
            r0.putExtra(NormalWebViewActivity.BUNDLE_KEY_WEBVEIW_TITLE, this.licenceTermsTitle.getText().toString());
            r0.putExtra(NormalWebViewActivity.BUNDLE_KEY_WEBVEIW_URL, this.licenceTermsTitleUrl);
            startActivity(r0);
        } else if (R.id.nfc_wallet_use_agreements_title == id) {
            r0 = new Intent();
            r0.setClass(getActivity(), NormalWebViewActivity.class);
            r0.putExtra(NormalWebViewActivity.BUNDLE_KEY_WEBVEIW_TITLE, this.licenceAgreemntsTitle.getText().toString());
            r0.putExtra(NormalWebViewActivity.BUNDLE_KEY_WEBVEIW_URL, this.licenceAgreementsTitleUrl);
            startActivity(r0);
        } else if (R.id.bind_card_next_step == id) {
            C2538c.c(TAG, new Object[]{"====123===点击进入下一步"});
            checkWatchStatusAndNextStep();
        }
    }

    private void reportBI() {
        CardInfoManager.getInstance(getActivity()).queryBankIssuerInfo(this.issuerId, this);
    }

    private boolean checkAndFillInCardInfo(OpenCardInfo openCardInfo) {
        openCardInfo.setCardType(this.cardType);
        openCardInfo.setCardNum(this.cardNum);
        openCardInfo.setIssuerId(this.issuerId);
        openCardInfo.setCaptureMethod(CaptureMethod.getMode());
        C2538c.c(TAG, new Object[]{"====123===location longitude" + this.longitude + "latitude" + this.latitude});
        if (!(Double.compare(this.longitude.doubleValue(), 0.0d) == 0 && Double.compare(this.latitude.doubleValue(), 0.0d) == 0)) {
            String formatMoneyByTwoPoint = MoneyUtil.formatMoneyByTwoPoint(this.longitude.doubleValue());
            if (!formatMoneyByTwoPoint.startsWith("-")) {
                formatMoneyByTwoPoint = "+" + formatMoneyByTwoPoint;
            }
            String formatMoneyByTwoPoint2 = MoneyUtil.formatMoneyByTwoPoint(this.latitude.doubleValue());
            if (!formatMoneyByTwoPoint2.startsWith("-")) {
                formatMoneyByTwoPoint2 = "+" + formatMoneyByTwoPoint2;
            }
            openCardInfo.setLocation(formatMoneyByTwoPoint2 + "/" + formatMoneyByTwoPoint);
        }
        if (this.cardKeyList[3] && !checkPhoneValid(openCardInfo)) {
            return false;
        }
        if (this.cardKeyList[0] && !checkPwdValid(openCardInfo)) {
            return false;
        }
        if (this.cardKeyList[1] && !checkDateValid(openCardInfo)) {
            return false;
        }
        if (this.cardKeyList[2] && !checkCvvValid(openCardInfo)) {
            return false;
        }
        if (!this.cardKeyList[4] || checkIdNumValid(openCardInfo)) {
            return true;
        }
        return false;
    }

    private boolean checkPhoneValid(OpenCardInfo openCardInfo) {
        if (this.cardInfoList[3] == null) {
            return true;
        }
        openCardInfo.setPhone(this.cardInfoList[3].getText().toString());
        if (StringUtil.isEmpty(openCardInfo.getPhone(), true)) {
            this.cardInfoList[3].setError(getResources().getString(R.string.nfc_input_legal_phone_toast));
            return false;
        }
        setErrorIconDismiss(this.cardInfoList[3]);
        return true;
    }

    private boolean checkPwdValid(OpenCardInfo openCardInfo) {
        if (this.cardInfoList[0] != null) {
            if (this.cardInfoList[0] instanceof CUPEditText) {
                openCardInfo.setPwd(((CUPEditText) this.cardInfoList[0]).getEnctyptText());
            } else {
                LogX.e("keyboard type err!");
            }
            String obj = this.cardInfoList[0].getText().toString();
            if (StringUtil.isEmpty(obj, true) || obj.length() != 6) {
                this.cardInfoList[0].setError(getResources().getString(R.string.nfc_input_legal_passwd_toast));
                this.cardInfoList[0].requestFocus();
                return false;
            }
            setErrorIconDismiss(this.cardInfoList[0]);
        }
        return true;
    }

    private boolean checkDateValid(OpenCardInfo openCardInfo) {
        if (this.cardInfoList[1] != null) {
            String obj = this.cardInfoList[1].getText().toString();
            if (!StringUtil.isEmpty(obj, true)) {
                openCardInfo.setDate(obj.substring(0, 2) + obj.substring(3, 5));
            }
            if (StringUtil.isEmpty(openCardInfo.getDate(), true)) {
                this.cardInfoList[1].setError(getResources().getString(R.string.nfc_input_legal_date_toast));
                this.cardInfoList[1].callOnClick();
                return false;
            }
            setErrorIconDismiss(this.cardInfoList[1]);
        }
        return true;
    }

    private boolean checkCvvValid(OpenCardInfo openCardInfo) {
        if (this.cardInfoList[2] == null) {
            return true;
        }
        openCardInfo.setCvv2(this.cardInfoList[2].getText().toString());
        if (StringUtil.isEmpty(openCardInfo.getCvv2(), true)) {
            this.cardInfoList[2].setError(getResources().getString(R.string.nfc_input_legal_cvvcode_toast));
            return false;
        }
        setErrorIconDismiss(this.cardInfoList[2]);
        return true;
    }

    private boolean checkIdNumValid(OpenCardInfo openCardInfo) {
        if (this.cardInfoList[4] == null) {
            return true;
        }
        openCardInfo.setIdNum(this.cardInfoList[4].getText().toString());
        if (StringUtil.isEmpty(openCardInfo.getIdNum(), true)) {
            this.cardInfoList[4].setError(getResources().getString(R.string.hwpay_idcard_error));
            return false;
        }
        setErrorIconDismiss(this.cardInfoList[4]);
        return true;
    }

    private String getCardNumEndFour(String str) {
        return str.substring(str.length() - 4);
    }

    private boolean[] getCardInfo() {
        boolean[] zArr = new boolean[5];
        if (this.issuerMode != 13 && this.issuerMode != 11) {
            LogX.e("Can not identify issuerMode! issuerMode = " + this.issuerMode);
        } else if (this.cardType == 2) {
            zArr[0] = true;
            zArr[1] = false;
            zArr[2] = false;
            zArr[3] = true;
        } else if (this.cardType == 3) {
            zArr[0] = false;
            zArr[1] = true;
            zArr[2] = true;
            zArr[3] = true;
        } else {
            LogX.e("Can not identify issuerMode! cardType = " + this.cardType);
        }
        return zArr;
    }

    private void initViewStub(boolean[] zArr) {
        if (this.cardInfoList == null) {
            this.cardInfoList = new EditText[5];
        }
        for (int i = 0; i < 5; i++) {
            this.cardInfoList[i] = null;
        }
        if (zArr[1]) {
            initDate();
        }
        if (zArr[2]) {
            initCVV2();
        }
        if (zArr[3]) {
            initPhone();
        }
        if (zArr[0]) {
            initPWD();
        }
        if (zArr[4]) {
            initIdNum();
        }
    }

    private void initPWD() {
        ((RelativeLayout) this.rootView.findViewById(R.id.open_card_info_pwd)).setVisibility(0);
        ((TextView) this.rootView.findViewById(R.id.cardinfo_pwd_title_tx)).setText(R.string.hwpay_cardinfo_id_pwd);
        if (this.issuerMode == 13) {
            CUPEditText cUPEditText = (CUPEditText) this.rootView.findViewById(R.id.cup_cardinfo_pwd_input_edittx);
            cUPEditText.setRecvTouchEventActivity(getActivity());
            cUPEditText.setVisibility(0);
            cUPEditText.setFilters(new InputFilter[]{new LengthFilter(6)});
            cUPEditText.setFpan(this.cardNum);
            cUPEditText.setHint(R.string.hwpay_cardinfo_id_pwd_hint);
            this.cardInfoList[0] = cUPEditText;
            if (this.cardInfoList[3] != null) {
                this.cardInfoList[3].setNextFocusDownId(R.id.cup_cardinfo_pwd_input_edittx);
                this.cardInfoList[3].setOnEditorActionListener(new C55694());
            }
            C5727a.m26398a(this.cardInfoList[0], new C55705());
            return;
        }
        LogX.e("There is no this keyboard");
    }

    private void initPhone() {
        View inflate = ((ViewStub) this.rootView.findViewById(R.id.card_info_phone)).inflate();
        ((TextView) inflate.findViewById(R.id.cardinfo_title_tx)).setText(R.string.huaweipay_bank_telephone);
        ClearEditText clearEditText = (ClearEditText) inflate.findViewById(R.id.cardinfo_input_edittx);
        clearEditText.setInputType(3);
        clearEditText.setHint(R.string.huaweipay_bank_phoen_hint);
        clearEditText.setFilters(new InputFilter[]{new LengthFilter(11)});
        this.cardInfoList[3] = clearEditText;
        C5727a.m26398a(this.cardInfoList[3], new C55716());
        this.cardInfoList[3].setOnFocusChangeListener(new C55727());
        ImageView imageView = (ImageView) inflate.findViewById(R.id.cardinfo_tips_img);
        imageView.setVisibility(0);
        imageView.setOnClickListener(new C55738());
    }

    private void initCVV2() {
        View inflate = ((ViewStub) this.rootView.findViewById(R.id.card_info_cvv2)).inflate();
        ((TextView) inflate.findViewById(R.id.cardinfo_title_tx)).setText(R.string.secure_code);
        ClearEditText clearEditText = (ClearEditText) inflate.findViewById(R.id.cardinfo_input_edittx);
        clearEditText.setInputType(2);
        clearEditText.setHint(R.string.huaweipay_cvv2_tip);
        clearEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        clearEditText.setFilters(new InputFilter[]{new LengthFilter(3)});
        this.cardInfoList[2] = clearEditText;
        C5727a.m26398a(this.cardInfoList[2], new C55749());
        this.cardInfoList[2].setOnFocusChangeListener(new OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    CharSequence obj = BindCardInputFragment.this.cardInfoList[2].getText().toString();
                    if (BindCardInputFragment.this.checkCvv2() || TextUtils.isEmpty(obj)) {
                        BindCardInputFragment.this.setErrorIconDismiss(BindCardInputFragment.this.cardInfoList[2]);
                    } else {
                        BindCardInputFragment.this.throwCvv2Error();
                    }
                }
            }
        });
        ImageView imageView = (ImageView) inflate.findViewById(R.id.cardinfo_tips_img);
        imageView.setVisibility(0);
        imageView.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                BindCardInputFragment.this.showInfoDialog(1);
            }
        });
    }

    private void initDate() {
        View inflate = ((ViewStub) this.rootView.findViewById(R.id.card_info_valid_time)).inflate();
        ((TextView) inflate.findViewById(R.id.cardinfo_title_tx)).setText(R.string.huaweipay_card_date_for_tip);
        final ClearEditText clearEditText = (ClearEditText) inflate.findViewById(R.id.cardinfo_input_edittx);
        clearEditText.setClickable(true);
        clearEditText.setFocusable(false);
        clearEditText.setCursorVisible(false);
        clearEditText.setClearFunctionEnable(false);
        clearEditText.setHint(R.string.huaweipay_cardinfo_data);
        clearEditText.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                BindCardInputFragment.this.showDatePickerDialog(clearEditText);
            }
        });
        this.cardInfoList[1] = clearEditText;
        ImageView imageView = (ImageView) inflate.findViewById(R.id.cardinfo_tips_img);
        imageView.setVisibility(0);
        imageView.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                BindCardInputFragment.this.showInfoDialog(3);
            }
        });
    }

    private void initIdNum() {
        View inflate = ((ViewStub) this.rootView.findViewById(R.id.card_info_idnum)).inflate();
        ((TextView) inflate.findViewById(R.id.cardinfo_title_tx)).setText(R.string.hwpay_cardinfo_id_card_id);
        ClearEditText clearEditText = (ClearEditText) inflate.findViewById(R.id.cardinfo_input_edittx);
        clearEditText.setInputType(2);
        clearEditText.setHint(getString(R.string.hwpay_input_id_card_tips, new Object[]{Integer.valueOf(18)}));
        clearEditText.setFilters(new InputFilter[]{new LengthFilter(18)});
        this.cardInfoList[4] = clearEditText;
        C5727a.m26398a(this.cardInfoList[4], new C5565a() {
            public void onTextChanged(String str, String str2) {
                BindCardInputFragment.this.validButtonState();
            }
        });
        this.cardInfoList[4].setOnFocusChangeListener(new OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    CharSequence obj = BindCardInputFragment.this.cardInfoList[4].getText().toString();
                    if (BindCardInputFragment.this.checkIdNum() || TextUtils.isEmpty(obj)) {
                        BindCardInputFragment.this.setErrorIconDismiss(BindCardInputFragment.this.cardInfoList[4]);
                    } else {
                        BindCardInputFragment.this.throwIdNumError();
                    }
                }
            }
        });
        ((ImageView) inflate.findViewById(R.id.cardinfo_tips_img)).setVisibility(4);
    }

    private void showInfoDialog(int i) {
        ab abVar = new ab(getActivity());
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.nfc_info_dialog, null);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.info_body_image);
        TextView textView = (TextView) inflate.findViewById(R.id.info_body_txt);
        switch (i) {
            case 1:
                abVar.m27489a(getResources().getString(R.string.huaweipay_tips_cvv2_title));
                imageView.setImageResource(R.drawable.cvv2_tip);
                textView.setText(getResources().getString(R.string.huaweipay_tips_cvv2));
                break;
            case 2:
                abVar.m27489a(getResources().getString(R.string.hwpay_phone_img_tips_title));
                imageView.setImageResource(R.drawable.phone_tips);
                textView.setText(getResources().getString(R.string.hwpay_phone_img_tips));
                break;
            case 3:
                abVar.m27489a(getResources().getString(R.string.huaweipay_tips_date_title));
                imageView.setImageResource(R.drawable.dead_date_tip);
                textView.setText(getResources().getString(R.string.huaweipay_tips_date));
                break;
            default:
                LogX.d(TAG, "showInfoDialog, unknown which");
                break;
        }
        abVar.m27487a(R.string.nfc_cvv_code_introduction_ok, new OnClickListener() {
            public void onClick(View view) {
            }
        });
        abVar.m27488a(inflate);
        C6027z a = abVar.m27491a();
        a.setCancelable(false);
        a.setCanceledOnTouchOutside(false);
        a.show();
    }

    private void showDatePickerDialog(ClearEditText clearEditText) {
        if (this.mValidDatePickerDialog == null || !this.mValidDatePickerDialog.isShow()) {
            this.mValidDatePickerDialog = new ValidDatePickerDialog(getActivity(), new ValidDateListener(clearEditText), this.dateInfomation);
            this.mValidDatePickerDialog.show();
        }
    }

    private boolean checkCvv2() {
        if (this.cardInfoList[2] != null) {
            return "YES".equals(C5727a.m26397a(this.cardInfoList[2], "\\d{3}"));
        }
        return true;
    }

    private boolean checkPsw() {
        if (this.cardInfoList[0] == null) {
            return true;
        }
        String obj = this.cardInfoList[0].getText().toString();
        if (StringUtil.isEmpty(obj, true) || obj.length() != 6) {
            return false;
        }
        return true;
    }

    private boolean checkPhoneNum() {
        if (this.cardInfoList[3] != null) {
            return "YES".equals(C5727a.m26397a(this.cardInfoList[3], "[1]{1}\\d{10}"));
        }
        return true;
    }

    private boolean checkIdNum() {
        if (this.cardInfoList[4] != null) {
            return "YES".equals(C5727a.m26397a(this.cardInfoList[4], "\\d{15}|\\d{17}[0-9Xx]"));
        }
        return true;
    }

    private void throwCvv2Error() {
        this.cardInfoList[2].setError(getResources().getString(R.string.huaweipay_cvv2_error));
    }

    private void throwPhoneError() {
        this.cardInfoList[3].setError(getResources().getString(R.string.huaweipay_telephone_error));
    }

    private void throwIdNumError() {
        this.cardInfoList[4].setError(getResources().getString(R.string.hwpay_idcard_error));
    }

    protected void setErrorIconDismiss(EditText editText) {
        if (editText != null) {
            editText.setError(null, getResources().getDrawable(R.drawable.huaweipay_cardpay_nextbtn));
        }
    }

    private void validButtonState() {
        if (checkCvv2() && checkPhoneNum() && checkIdNum() && this.isAgreeLicence && checkPsw()) {
            this.nextStepText.setEnabled(true);
        } else {
            this.nextStepText.setEnabled(false);
        }
    }

    private void hideSoftInputWindow(View view) {
        ((InputMethodManager) getActivity().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public void queryBankIssuerInfoCallback(int i, BankIssuerInfo bankIssuerInfo) {
        NfcHianalyticsUtil.onReportForCardOpenAction(getActivity(), "", bankIssuerInfo.getIssuerName(), this.issuerId);
    }

    private void checkWatchStatusAndNextStep() {
        new Thread(new Runnable() {
            public void run() {
                BindCardInputFragment.this.mHandler.sendEmptyMessage(1);
                BindCardInputFragment.this.mLockscreenStatus = BindCardInputFragment.this.pluginPayAdapter.getLockscreenStatus();
                C2538c.c(BindCardInputFragment.TAG, new Object[]{"== checkWatchStatus LockscreenStatus : " + BindCardInputFragment.this.mLockscreenStatus});
                int deviceConnectState = BindCardInputFragment.this.pluginPayAdapter.getDeviceConnectState();
                C2538c.c(BindCardInputFragment.TAG, new Object[]{"== checkWatchStatus btconnect : " + deviceConnectState});
                if (BindCardInputFragment.this.mLockscreenStatus == 0 || deviceConnectState != 2) {
                    BindCardInputFragment.this.mHandler.sendEmptyMessage(2);
                    BindCardInputFragment.this.mHandler.sendEmptyMessage(3);
                    return;
                }
                BindCardInputFragment.this.mHandler.sendEmptyMessage(2);
                Intent intent = new Intent();
                intent.setClass(BindCardInputFragment.this.getActivity(), CardLockScreenActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt(NFCBaseActivity.LOCKSCREENSTATUS, BindCardInputFragment.this.mLockscreenStatus);
                bundle.putString(NFCBaseActivity.FROM_ADD_CARD_PAGE, NFCBaseActivity.BIND_CARD_ACTIVITY);
                intent.putExtras(bundle);
                BindCardInputFragment.this.startActivityForResult(intent, NFCBaseActivity.TO_ADD);
            }
        }).start();
    }

    public void bindCardInputNextStep() {
        C2538c.b(TAG, new Object[]{"====123=== bindCardInputNextStep 点击进入下一步"});
        OpenCardInfo openCardInfo = new OpenCardInfo();
        if (!checkAndFillInCardInfo(openCardInfo)) {
            C2538c.b(TAG, new Object[]{"info filled error"});
        } else if (this.rootView == null) {
            C2538c.b(TAG, new Object[]{"rootView is null "});
        } else {
            hideSoftInputWindow(this.rootView);
            this.bindListener.startBind(openCardInfo);
            reportBI();
        }
    }

    protected void destroyLoadingDialog() {
        if (this.mLoadingDialog21 != null) {
            this.mLoadingDialog21.cancel();
            this.mLoadingDialog21 = null;
            C2538c.c(TAG, new Object[]{"destroy mLoadingDialog21"});
        }
    }

    protected void showLoadingDialog(int i) {
        if (this.mLoadingDialog21 == null) {
            C6002a c6002a = new C6002a(getActivity(), R.style.app_update_dialogActivity);
            this.mLoadingDialog21 = C6002a.m27468a(getActivity());
            this.mLoadingDialog21.m27476a(getActivity().getString(i));
            this.mLoadingDialog21.m27474a();
            this.mLoadingDialog21.setCancelable(false);
            return;
        }
        C2538c.c(TAG, new Object[]{"mLoadingDialog21 is not null"});
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (NFCBaseActivity.TO_ADD == i && i2 == -1) {
            C2538c.b(TAG, new Object[]{"onActivityResult resultCode ： " + i2 + " ; requestCode : " + i});
            bindCardInputNextStep();
            return;
        }
        C2538c.b(TAG, new Object[]{"No this resultCode in onActivityResult"});
    }

    public void onDestroy() {
        super.onDestroy();
        this.mHandler.removeCallbacks(this.runnable);
    }
}
