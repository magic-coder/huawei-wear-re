package com.huawei.nfc.carrera.ui.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.huawei.cp3.widget.C4372a;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.wallet.R;
import com.unionpay.tsmservice.widget.UPNewSaftyKeyboard;
import com.unionpay.tsmservice.widget.UPNewSaftyKeyboard.OnEditorListener;

public class CUPEditText extends EditText {
    final OnEditorListener listener = new C56883();
    private Drawable mDelForeSelector;
    private Drawable mDoneForeSelector;
    private String mFpan;
    private Drawable mFunctionBgSelector;
    private InputMethodManager mInputmanger;
    private UPNewSaftyKeyboard mKeyboard = null;
    private Drawable mNumBgSelector;

    class C56861 implements OnTouchListener {
        C56861() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                CUPEditText.this.showSafeKeyboard(view);
            }
            return true;
        }
    }

    class C56872 implements OnFocusChangeListener {
        C56872() {
        }

        public void onFocusChange(View view, boolean z) {
            if (z) {
                CUPEditText.this.showSafeKeyboard(view);
                return;
            }
            CUPEditText.this.mKeyboard.hide();
            CUPEditText.this.setCursorVisible(false);
        }
    }

    class C56883 implements OnEditorListener {
        C56883() {
        }

        public void onEditorChanged(int i) {
            int length = CUPEditText.this.getText().length();
            if (i >= 0 && i <= 6) {
                String str = "";
                if (i < length) {
                    str = CUPEditText.this.getText().toString().substring(0, length - 1);
                } else if (i > length) {
                    str = CUPEditText.this.getText() + "*";
                }
                CUPEditText.this.setText(str);
                CUPEditText.this.setSelection(str.length());
                if (str.length() == 6) {
                    CUPEditText.this.setError(null, CUPEditText.this.getResources().getDrawable(R.drawable.huaweipay_cardpay_nextbtn));
                    CUPEditText.this.mKeyboard.hide();
                }
            }
        }
    }

    public CUPEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initKeyBoard(context);
    }

    public CUPEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initKeyBoard(context);
    }

    public CUPEditText(Context context) {
        super(context);
        initKeyBoard(context);
    }

    private void initKeyBoard(Context context) {
        this.mInputmanger = (InputMethodManager) context.getSystemService("input_method");
        this.mNumBgSelector = context.getResources().getDrawable(R.drawable.bnt_keyboard_character_normal);
        this.mFunctionBgSelector = context.getResources().getDrawable(R.drawable.bnt_keyboard_function_normal);
        this.mDoneForeSelector = context.getResources().getDrawable(R.drawable.ic_keyboard_pack_up);
        this.mDelForeSelector = context.getResources().getDrawable(R.drawable.ic_keyboard_delete);
        try {
            this.mKeyboard = new UPNewSaftyKeyboard(context, 2000);
            this.mKeyboard.setKeyboardBackground(context.getResources().getDrawable(R.color.color_up_safe_keyboard_bg));
            if (C4372a.m21003c()) {
                this.mKeyboard.setKeyboardStartPosition(0, context.getResources().getDimensionPixelSize(R.dimen.nfc_up_safe_keyboard_start_y_axis));
                this.mKeyboard.setKeyBoardSize(0, context.getResources().getDimensionPixelSize(R.dimen.nfc_up_safe_keyboard_height_emui50));
            } else {
                this.mKeyboard.setKeyBoardSize(0, context.getResources().getDimensionPixelSize(R.dimen.nfc_up_safe_keyboard_height));
            }
            this.mKeyboard.enableLightStatusBar(true);
            this.mKeyboard.setKeyAreaPadding(context.getResources().getDimensionPixelSize(R.dimen.nfc_up_safe_keyboard_padding_start_end), context.getResources().getDimensionPixelSize(R.dimen.nfc_up_safe_keyboard_padding_top_bottom), context.getResources().getDimensionPixelSize(R.dimen.nfc_up_safe_keyboard_padding_start_end), context.getResources().getDimensionPixelSize(R.dimen.nfc_up_safe_keyboard_padding_top_bottom));
            this.mKeyboard.setTitleHeight(context.getResources().getDimensionPixelSize(R.dimen.nfc_up_safe_keyboard_title_height));
            this.mKeyboard.setTitleSize(context.getResources().getDimensionPixelSize(R.dimen.nfc_up_safe_keyboard_title_size));
            this.mKeyboard.setTitleText(context.getResources().getString(R.string.nfc_up_keyboard_security_mode));
            this.mKeyboard.setTitleColor(context.getResources().getColor(R.color.CS_black_50_percent));
            this.mKeyboard.setTitleDrawable(context.getResources().getDrawable(R.drawable.ic_keyboard_safety));
            this.mKeyboard.setTitleBackground(context.getResources().getDrawable(R.color.color_up_safe_keyboard_title_bg));
            this.mKeyboard.setNumKeyBackgroud(this.mNumBgSelector);
            this.mKeyboard.setNumberKeySize(context.getResources().getDimensionPixelSize(R.dimen.nfc_up_safe_keyboard_number_size));
            this.mKeyboard.setNumKeyMargin(context.getResources().getDimensionPixelSize(R.dimen.nfc_up_safe_keyboard_number_key_margin), context.getResources().getDimensionPixelSize(R.dimen.nfc_up_safe_keyboard_number_key_margin));
            this.mKeyboard.setDoneKeyDrawable(this.mDoneForeSelector, this.mFunctionBgSelector);
            this.mKeyboard.setDelKeyDrawable(this.mDelForeSelector, this.mFunctionBgSelector);
            this.mKeyboard.setKeyboardVibrate(false);
            this.mKeyboard.enableLightStatusBar(true);
        } catch (Throwable e) {
            LogX.e("mKeyboard err!", e);
        } catch (Throwable e2) {
            LogX.e("mKeyboard err!", e2);
        }
        setOnTouchListener(new C56861());
        setOnFocusChangeListener(new C56872());
    }

    public void showSafeKeyboard(View view) {
        this.mInputmanger.hideSoftInputFromWindow(view.getWindowToken(), 1);
        this.mKeyboard.setOnEditorListener(this.listener);
        this.mKeyboard.show();
        setFocusable(true);
        requestFocus();
        setCursorVisible(true);
    }

    public void setRecvTouchEventActivity(Activity activity) {
        activity.getWindow().setSoftInputMode(3);
    }

    public String getEnctyptText() {
        return this.mKeyboard.getInput(this.mFpan);
    }

    public void setFpan(String str) {
        this.mFpan = str;
    }
}
