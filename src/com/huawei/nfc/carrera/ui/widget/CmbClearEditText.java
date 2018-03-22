package com.huawei.nfc.carrera.ui.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.huawei.cp3.widget.custom.widget.HwErrorEditText;
import com.huawei.pay.p130e.C5730c;
import com.huawei.wallet.R;

public class CmbClearEditText extends HwErrorEditText implements TextWatcher, OnFocusChangeListener {
    private boolean isClearFunctionEnable;
    private Drawable mClearDrawable;

    public CmbClearEditText(Context context) {
        this(context, null);
    }

    public CmbClearEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842862);
    }

    public CmbClearEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isClearFunctionEnable = true;
        init(context);
    }

    private void init(Context context) {
        this.mClearDrawable = context.getResources().getDrawable(R.drawable.btn_cancle_black_selector);
        this.mClearDrawable.setBounds(0, 0, this.mClearDrawable.getIntrinsicWidth(), this.mClearDrawable.getIntrinsicHeight());
        setClearIconVisible(false);
        setOnFocusChangeListener(this);
        addTextChangedListener(this);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        Object obj = 1;
        if (getCompoundDrawables()[2] != null && this.isClearFunctionEnable && motionEvent.getAction() == 1) {
            if (motionEvent.getX() <= ((float) ((getWidth() - getPaddingRight()) - this.mClearDrawable.getIntrinsicWidth())) || motionEvent.getX() >= ((float) (getWidth() - getPaddingRight()))) {
                obj = null;
            }
            if (obj != null) {
                setText("");
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void onFocusChange(View view, boolean z) {
        if (z) {
            setClearIconVisible(getText().length() > 0);
        }
    }

    protected void setClearIconVisible(boolean z) {
        if (this.isClearFunctionEnable) {
            setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], z ? this.mClearDrawable : null, getCompoundDrawables()[3]);
            setPadding(getCompoundPaddingLeft(), getCompoundPaddingTop(), C5730c.m26406a(getContext(), 8.0f), getCompoundPaddingBottom());
        }
    }

    public void setClearFunctionEnable(boolean z) {
        this.isClearFunctionEnable = z;
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        setClearIconVisible(charSequence.length() > 0);
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void afterTextChanged(Editable editable) {
    }
}
