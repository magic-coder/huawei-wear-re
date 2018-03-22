package com.huawei.nfc.carrera.ui.bindcard;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.huawei.cp3.widget.C4372a;
import com.huawei.cp3.widget.p382a.p383a.C4370a;
import com.huawei.nfc.carrera.constant.Constant;
import com.huawei.nfc.carrera.logic.CardOperateLogicApi;
import com.huawei.nfc.carrera.logic.LogicApiFactory;
import com.huawei.nfc.carrera.logic.cardoperate.response.CardTypeIdentifyCallback;
import com.huawei.nfc.carrera.server.card.model.CaptureMethod;
import com.huawei.nfc.carrera.ui.cardlist.AddBankOrBusCardActivity;
import com.huawei.nfc.carrera.ui.dialog.PayManagerSettingSwitchDialog;
import com.huawei.nfc.carrera.ui.identifycard.CardReaderBaseActivity;
import com.huawei.nfc.carrera.ui.identifycard.TagReadCardNumActivity;
import com.huawei.nfc.carrera.ui.util.PaySecurityManagerSettingUtils;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.NfcUtil;
import com.huawei.p190v.C2538c;
import com.huawei.pay.p130e.p489b.C5728a;
import com.huawei.pay.p473a.p476b.C5587b;
import com.huawei.pay.p473a.p476b.C5720a;
import com.huawei.pay.ui.widget.ClearEditText;
import com.huawei.pay.ui.widget.HwPayKeyBoardView;
import com.huawei.pay.ui.widget.HwPayKeyBoardView.KeyBoardOnClickListener;
import com.huawei.ui.commonui.dialog.C6002a;
import com.huawei.ui.commonui.dialog.C6022u;
import com.huawei.ui.commonui.dialog.C6024w;
import com.huawei.wallet.R;
import com.huawei.wallet.logic.cardidentify.CardCameraIdentifyHelper;
import com.huawei.wallet.logic.cardidentify.CardIdentifyInfo;
import com.huawei.wallet.logic.cardidentify.ICardIdentifyCallBack;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InputCardNumActivity extends CardReaderBaseActivity implements OnKeyListener, ICardIdentifyCallBack {
    private static final int APK_VERSION = 23;
    private static final String INPUT_SPACE_STR = " ";
    public static final String INTENT_KEY_CARD_NUM = "card_num";
    public static final String INTENT_KRY_CARD_IMG = "card_img";
    public static final int REQUEST_CODE_NFC_TAG = 1;
    private static final String TAG = "InputCardNumActivity";
    private int beforeSpaceNum = 0;
    private int beforeTextLength = 0;
    private CardOperateLogicApi bindCardApi;
    private final StringBuffer buffer = new StringBuffer();
    private ImageView cardNumImg;
    private ClearEditText cardNumInputView;
    private CardTypeIdentifyCallback identifyCallback;
    private boolean isChanged = false;
    private HwPayKeyBoardView keyboardView;
    private int location = 0;
    private Bitmap mCardBitmap;
    private String mCardNumber;
    protected C6002a mLoadingDialog21;
    private Button nextStepButton;
    private int onTextLength = 0;
    private LinearLayout readNumberLinearLayout;

    class C55961 implements OnClickListener {

        class C55951 implements C5587b {
            C55951() {
            }

            public void onRequestPermissionsResult(int[] iArr) {
                LogX.i("onRequestPermissionsResult ", false);
                if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
                    LogX.i("no CAMERA permission start Camera", false);
                    InputCardNumActivity.this.showToast(R.string.nfc_card_check_camera_permissions);
                    return;
                }
                InputCardNumActivity.this.identifyCardNumByCamera();
            }
        }

        C55961() {
        }

        public void onClick(View view) {
            if (TextUtils.isEmpty(InputCardNumActivity.this.cardNumInputView.getText().toString())) {
                C5720a.m26366a().m26371a(new C55951(), InputCardNumActivity.this, "android.permission.CAMERA");
            }
        }
    }

    class C55972 implements KeyBoardOnClickListener {
        C55972() {
        }

        public void onNumKeyClick(int i) {
            InputCardNumActivity.this.cardNumInputView.getText().insert(InputCardNumActivity.this.cardNumInputView.getSelectionStart(), i + "");
            CaptureMethod.setMunalMode();
        }

        public void onHideKeyClick() {
            InputCardNumActivity.this.nextStepButton.setVisibility(0);
        }

        public void onDelKeyClick() {
            Editable text = InputCardNumActivity.this.cardNumInputView.getText();
            int selectionStart = InputCardNumActivity.this.cardNumInputView.getSelectionStart();
            if (text != null && selectionStart > 0) {
                text.delete(selectionStart - 1, selectionStart);
            }
        }

        public void onDelKeyLongClick() {
            InputCardNumActivity.this.cardNumInputView.setText(null);
            if (!InputCardNumActivity.this.cardNumInputView.isFocused()) {
                InputCardNumActivity.this.cardNumInputView.requestFocus();
                ((InputMethodManager) InputCardNumActivity.this.cardNumInputView.getContext().getSystemService("input_method")).toggleSoftInput(0, 2);
            }
            if (InputCardNumActivity.this.cardNumInputView.getError() != null) {
                InputCardNumActivity.this.cardNumInputView.setError(null);
            }
        }
    }

    class C55983 implements OnTouchListener {
        C55983() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (InputCardNumActivity.this.cardNumInputView.isTouchRightImg(motionEvent)) {
                return false;
            }
            if (InputCardNumActivity.this.keyboardView.getVisibility() != 0) {
                InputCardNumActivity.this.keyboardView.setVisibility(0);
                if (InputCardNumActivity.this.getResources().getConfiguration().orientation == 2) {
                    InputCardNumActivity.this.nextStepButton.setVisibility(8);
                }
            }
            InputCardNumActivity.this.cardNumInputView.onTouchEvent(motionEvent);
            return true;
        }
    }

    class C55994 implements CardTypeIdentifyCallback {
        C55994() {
        }

        public void identifyResult(int i, String str, int i2, int i3) {
            LogX.d("identify card result: " + i + " and issuerId: " + str + " cardType: " + i2 + "bankCardMode" + i3);
            InputCardNumActivity.this.stopProgress();
            if (1 == i) {
                InputCardNumActivity.this.jumpToCardInstructionActivity(str, i2, i3);
            } else {
                InputCardNumActivity.this.dealFailedIdentifyResult(i);
            }
        }
    }

    class C56016 implements DialogInterface.OnClickListener {
        C56016() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            LogX.i("jump to NFC setting ");
            try {
                InputCardNumActivity.this.startActivity(new Intent(Constant.OPEN_NFC_INTENT_ACTION));
            } catch (Exception e) {
                LogX.e("jump to NFC setting fail  the action erro");
            }
        }
    }

    class C56027 implements OnClickListener {
        C56027() {
        }

        public void onClick(View view) {
        }
    }

    protected void onCreate(Bundle bundle) {
        getCardNumberDataByIntent();
        super.onCreate(bundle);
        setRequestedOrientation(1);
        setTitle(R.string.nfc_input_card_num_title);
        setContentView(R.layout.nfc_input_card_num_activity_layout);
        initViews();
        initCardOperateApi();
    }

    private void getCardNumberDataByIntent() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mCardNumber = intent.getStringExtra(INTENT_KEY_CARD_NUM);
            this.mCardBitmap = (Bitmap) intent.getParcelableExtra(INTENT_KRY_CARD_IMG);
        }
    }

    protected void onResume() {
        super.onResume();
    }

    private void initViews() {
        this.nextStepButton = (Button) findViewById(R.id.nfc_bind_card_next_button);
        this.cardNumInputView = (ClearEditText) findViewById(R.id.card_number);
        this.cardNumImg = (ImageView) findViewById(R.id.card_num_image);
        this.cardNumImg.setVisibility(8);
        this.readNumberLinearLayout = (LinearLayout) findViewById(R.id.card_number_layout);
        if (NfcUtil.isEnabledNFC(getApplicationContext())) {
            this.readNumberLinearLayout.setVisibility(0);
        } else {
            this.readNumberLinearLayout.setVisibility(4);
        }
        this.cardNumInputView.setOnKeyListener(this);
        this.cardNumInputView.setStaticRightEndImg(R.drawable.nfc_icon_camara, new C55961());
        bankCardNumAddSpace(this.cardNumInputView);
        initKeyBroardView();
        if (!TextUtils.isEmpty(this.mCardNumber)) {
            setCardNumberData(this.mCardNumber);
        }
        if (this.keyboardView != null && this.keyboardView.getVisibility() == 0) {
            this.nextStepButton.setVisibility(0);
            this.keyboardView.setVisibility(8);
        }
    }

    private void setCardNumberData(String str) {
        if (!(this.cardNumInputView == null || TextUtils.isEmpty(str))) {
            this.cardNumInputView.setText(str);
            CharSequence text = this.cardNumInputView.getText();
            if (text instanceof Spannable) {
                Selection.setSelection((Spannable) text, text.length());
            }
        }
        setCardNumImg();
    }

    private void initCardOperateApi() {
        if (this.bindCardApi == null) {
            this.bindCardApi = LogicApiFactory.createCardOperateApi(getApplicationContext());
        }
        this.bindCardApi.initEseInfo();
        this.bindCardApi.initCUPCardOperator(null);
    }

    private void initKeyBroardView() {
        this.keyboardView = (HwPayKeyBoardView) findViewById(R.id.hwpay_keyboard_input);
        this.keyboardView.setKeyBoardListener(new C55972());
        if (VERSION.SDK_INT >= 11) {
            getWindow().setSoftInputMode(3);
            try {
                Method method = EditText.class.getMethod("setShowSoftInputOnFocus", new Class[]{Boolean.TYPE});
                method.setAccessible(true);
                method.invoke(this.cardNumInputView, new Object[]{Boolean.valueOf(false)});
            } catch (NoSuchMethodException e) {
                LogX.i("NoSuchMethodException error: ", false);
            } catch (IllegalAccessException e2) {
                LogX.i("IllegalAccessException error: ", false);
            } catch (IllegalArgumentException e3) {
                LogX.i("IllegalArgumentException error: ", false);
            } catch (InvocationTargetException e4) {
                LogX.i("InvocationTargetException  error: ", false);
            }
        } else {
            this.cardNumInputView.setInputType(0);
        }
        this.cardNumInputView.setOnTouchListener(new C55983());
    }

    public void onClickEvent(View view) {
        int id = view.getId();
        if (R.id.txt_tag_read_card_number == id) {
            tagReadCardNumButton();
        } else if (R.id.nfc_bind_card_next_button == id) {
            checkCardNum();
        }
    }

    private void identifyCardNumByCamera() {
        new CardCameraIdentifyHelper().m27968a(this, this);
        CaptureMethod.setCameraMode();
    }

    private void checkCardNum() {
        if (this.identifyCallback == null) {
            this.identifyCallback = new C55994();
        }
        startProgress(getString(R.string.nfc_check_card_valid));
        String replaceAll = this.cardNumInputView.getText().toString().replaceAll(" ", "");
        if (this.bindCardApi == null) {
            this.bindCardApi = LogicApiFactory.createCardOperateApi(getApplicationContext());
        }
        this.bindCardApi.identifyCardType(replaceAll, this.identifyCallback);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getAction() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.keyboardView == null || this.keyboardView.getVisibility() != 0) {
            setResult(0);
            Intent intent = new Intent(this, AddBankOrBusCardActivity.class);
            intent.setFlags(65536);
            startActivity(intent);
            finish();
            return true;
        }
        this.nextStepButton.setVisibility(0);
        this.keyboardView.setVisibility(8);
        return true;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        LogX.i("onActivityResult", "requestCode==" + i);
        if (1 != i) {
            LogX.i("onActivityResult", "do nothing!");
        } else if (intent == null) {
            LogX.i("onActivityResult", "data is null!");
        } else if (intent.hasExtra(TagReadCardNumActivity.EXTRA_READ_RESULT_CARD_NUMBER)) {
            this.cardNumInputView.setText(C5728a.m26404b(intent.getStringExtra(TagReadCardNumActivity.EXTRA_READ_RESULT_CARD_NUMBER), getApplicationContext()));
            this.cardNumInputView.setSelection(this.cardNumInputView.getText().toString().length());
            CaptureMethod.setCameraMode();
        }
    }

    private void tagReadCardNumButton() {
        startActivityForResult(new Intent(this, TagReadCardNumActivity.class), 1);
    }

    protected void getBankNumber(String str) {
        CaptureMethod.setUnKnownMode();
        this.cardNumInputView.setText(str);
        this.cardNumInputView.setSelection(this.cardNumInputView.getText().toString().length());
        this.cardNumImg.setVisibility(8);
    }

    public void onIndetify(CardIdentifyInfo cardIdentifyInfo) {
        if (cardIdentifyInfo != null) {
            C2538c.b(TAG, new Object[]{" == cardIdentifyInfo ： " + cardIdentifyInfo.toString()});
            this.mCardBitmap = cardIdentifyInfo.m27972b();
            this.cardNumInputView.setText(cardIdentifyInfo.m27969a());
            setCardNumImg();
            CharSequence text = this.cardNumInputView.getText();
            if (text instanceof Spannable) {
                Selection.setSelection((Spannable) text, text.length());
            }
        }
    }

    private void bankCardNumAddSpace(final EditText editText) {
        editText.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                int i4 = 0;
                InputCardNumActivity.this.beforeTextLength = charSequence.length();
                if (InputCardNumActivity.this.buffer.length() > 0) {
                    InputCardNumActivity.this.buffer.delete(0, InputCardNumActivity.this.buffer.length());
                }
                InputCardNumActivity.this.beforeSpaceNum = 0;
                while (i4 < charSequence.length()) {
                    if (' ' == charSequence.charAt(i4)) {
                        InputCardNumActivity.this.beforeSpaceNum = InputCardNumActivity.this.beforeSpaceNum + 1;
                    }
                    i4++;
                }
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                InputCardNumActivity.this.onTextLength = charSequence.length();
                InputCardNumActivity.this.buffer.append(charSequence.toString());
                if (InputCardNumActivity.this.onTextLength == InputCardNumActivity.this.beforeTextLength || InputCardNumActivity.this.onTextLength <= 3 || InputCardNumActivity.this.isChanged) {
                    InputCardNumActivity.this.isChanged = false;
                } else {
                    InputCardNumActivity.this.isChanged = true;
                }
            }

            public void afterTextChanged(Editable editable) {
                if (InputCardNumActivity.this.isChanged) {
                    InputCardNumActivity.this.location = editText.getSelectionEnd();
                    LogX.d("EditTextUtil  afterTextChanged  location : " + InputCardNumActivity.this.location);
                    InputCardNumActivity.this.removeSpace();
                    int i = 0;
                    int i2 = 0;
                    while (i < InputCardNumActivity.this.buffer.length()) {
                        if (i % 5 == 4) {
                            InputCardNumActivity.this.buffer.insert(i, " ");
                            i2++;
                        }
                        i++;
                    }
                    LogX.d("before space num : " + InputCardNumActivity.this.beforeSpaceNum + " --- after space num : " + i2);
                    CharSequence access$1400 = InputCardNumActivity.this.updateLocation(i2, i);
                    LogX.d("EditTextUtil afterTextChanged  location : " + InputCardNumActivity.this.location);
                    editText.setText(access$1400);
                    Spannable text = editText.getText();
                    LogX.d("EditTextUtil afterTextChanged  location : " + InputCardNumActivity.this.location);
                    Selection.setSelection(text, InputCardNumActivity.this.location);
                    InputCardNumActivity.this.isChanged = false;
                }
                if (InputCardNumActivity.this.cardNumInputView.getText().toString().length() > 0) {
                    InputCardNumActivity.this.nextStepButton.setEnabled(true);
                } else {
                    InputCardNumActivity.this.nextStepButton.setEnabled(false);
                }
            }
        });
    }

    private void removeSpace() {
        int i = 0;
        while (i < this.buffer.length()) {
            if (this.buffer.charAt(i) == " ".charAt(0)) {
                this.buffer.deleteCharAt(i);
            } else {
                i++;
            }
        }
    }

    private String updateLocation(int i, int i2) {
        if (this.onTextLength < this.beforeTextLength && this.location % 5 == 0) {
            this.location--;
        } else if (this.onTextLength <= this.beforeTextLength || this.location % 5 != 0) {
            if (this.onTextLength - this.beforeTextLength > 2) {
                this.location = i2 + i;
            }
        } else if (3 >= this.beforeTextLength) {
            this.location += i - this.beforeSpaceNum;
        } else {
            this.location++;
        }
        LogX.d("EditTextUtil afterTextChanged   : " + this.location);
        this.buffer.getChars(0, this.buffer.length(), new char[this.buffer.length()], 0);
        String stringBuffer = this.buffer.toString();
        if (this.location > stringBuffer.length()) {
            this.location = stringBuffer.length();
        } else if (this.location < 0) {
            this.location = 0;
        }
        return stringBuffer;
    }

    private void jumpToCardInstructionActivity(String str, int i, int i2) {
        String replaceAll = this.cardNumInputView.getText().toString().replaceAll(" ", "");
        Intent intent = new Intent(this, CardInstructionActivity.class);
        intent.putExtra("issuer_id", str);
        intent.putExtra("card_type", i);
        intent.putExtra("issuer_mode", i2);
        intent.putExtra(INTENT_KEY_CARD_NUM, C5728a.m26402a(replaceAll, getApplicationContext()));
        startActivity(intent);
        finish();
    }

    private void startProgress(String str) {
        if (this.mLoadingDialog21 == null) {
            C6002a c6002a = new C6002a(this.mContext, R.style.app_update_dialogActivity);
            this.mLoadingDialog21 = C6002a.m27468a(this.mContext);
            this.mLoadingDialog21.m27476a(str);
            this.mLoadingDialog21.m27474a();
            return;
        }
        C2538c.c(TAG, new Object[]{"mLoadingDialog21 is not null"});
    }

    private void stopProgress() {
        if (this.mLoadingDialog21 != null) {
            this.mLoadingDialog21.cancel();
            this.mLoadingDialog21 = null;
            C2538c.c(TAG, new Object[]{"destroy mLoadingDialog21"});
        }
    }

    private void dealFailedIdentifyResult(int i) {
        LogX.d("dealFailedIdentifyResult identifyResult   : " + i);
        switch (i) {
            case -10:
                showErrDialog(R.string.nfc_bind_card_fail_open_reach_bank_limit);
                return;
            case -9:
                showErrDialog(R.string.nfc_bank_card_has_been_applied);
                return;
            case -8:
                showQueryCplcErro();
                return;
            case -7:
            case -5:
                showToast(R.string.nfc_common_wifi_error_suggestion);
                return;
            case -6:
                showBindFailDialog();
                return;
            case -4:
                showToast(R.string.no_network);
                return;
            case -2:
                showToast(R.string.nfc_identify_error_unsupported_card);
                return;
            case -1:
                showToast(R.string.nfc_identify_error_illegal_num);
                return;
            default:
                showToast(R.string.nfc_identify_error_other_error);
                return;
        }
    }

    private void showQueryCplcErro() {
        if (!isFinishing()) {
            C4370a a = C4372a.m20997a((Context) this);
            a.setCancelable(false);
            a.mo4428a(getString(R.string.nfc_card_list_dialog_title));
            a.mo4431b(getString(R.string.nfc_query_cplc_erro));
            a.mo4427a(getString(R.string.nfc_setting), new C56016());
            a.mo4429b(R.string.nfc_cancel, null);
            a.show();
        }
    }

    protected void showErrDialog(int i) {
        if (!isFinishing()) {
            C6024w c6024w = new C6024w(this.mContext);
            c6024w.m27591a(R.string.nfc_card_list_dialog_title);
            c6024w.m27596b(i);
            c6024w.m27593a(R.string.nfc_quick_pass_button_text, new C56027());
            C6022u a = c6024w.m27590a();
            a.setCancelable(false);
            if (!a.isShowing()) {
                a.show();
            }
        }
    }

    private void showBindFailDialog() {
        PayManagerSettingSwitchDialog payManagerSettingSwitchDialog = new PayManagerSettingSwitchDialog(this.mContext, R.style.app_update_dialogActivity);
        payManagerSettingSwitchDialog = PayManagerSettingSwitchDialog.createNotice(this.mContext);
        payManagerSettingSwitchDialog.setNoticeTitle(this.mContext.getString(R.string.nfc_card_list_dialog_title));
        payManagerSettingSwitchDialog.setNoticeMessage(R.string.nfc_security_manager_setting_swich_message, R.string.nfc_security_manager_setting_swich_message1, this.mContext.getString(R.string.nfc_security_manager_setting_swich_message_more));
        payManagerSettingSwitchDialog.setPositiveButton(this.mContext.getString(R.string.nfc_card_dialog_getlocation_service_positive_text), new OnClickListener() {
            public void onClick(View view) {
                PaySecurityManagerSettingUtils.gotoSetting(InputCardNumActivity.this.mContext);
                payManagerSettingSwitchDialog.dismiss();
            }
        });
        payManagerSettingSwitchDialog.setNegativeButton(this.mContext.getString(R.string.nfc_cancel), new OnClickListener() {
            public void onClick(View view) {
                payManagerSettingSwitchDialog.dismiss();
            }
        });
        payManagerSettingSwitchDialog.startNotice();
    }

    public void onSwitch2Input() {
    }

    public void onCardBackPressed() {
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 67) {
            Object obj = this.cardNumInputView.getText().toString();
            if (!TextUtils.isEmpty(obj) && obj.indexOf("*") > -1) {
                this.cardNumInputView.setText("");
            }
            this.cardNumInputView.requestFocus();
        }
        return false;
    }

    private void setCardNumImg() {
        C2538c.b(TAG, new Object[]{" == cardNumImg ： " + this.cardNumImg + " ; mCardBitmap : " + this.mCardBitmap});
        if (this.cardNumImg == null) {
            return;
        }
        if (this.mCardBitmap != null) {
            this.cardNumImg.setVisibility(0);
            this.cardNumImg.setImageBitmap(this.mCardBitmap);
            return;
        }
        this.cardNumImg.setVisibility(8);
    }
}
