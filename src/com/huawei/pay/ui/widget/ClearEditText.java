package com.huawei.pay.ui.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import com.huawei.ag.d;
import com.huawei.cp3.widget.custom.widget.HwErrorEditText;

public class ClearEditText extends HwErrorEditText implements TextWatcher, OnFocusChangeListener {
    private boolean isClearFunctionEnable;
    private Drawable mClearDrawable;
    private boolean mIsShowClearNow;
    private Drawable mRightDrawable;
    private OnClickListener mRightImgClickListener;

    public ClearEditText(Context context) {
        this(context, null);
    }

    public ClearEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842862);
    }

    public ClearEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isClearFunctionEnable = true;
        this.mRightImgClickListener = null;
        this.mIsShowClearNow = false;
        init();
    }

    private void init() {
        this.mRightDrawable = getCompoundDrawables()[2];
        this.mClearDrawable = getResources().getDrawable(d.btn_cancle_black_selector);
        setClearIconVisible(false);
        setOnFocusChangeListener(this);
        addTextChangedListener(this);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (getCompoundDrawables()[2] != null && this.isClearFunctionEnable) {
            boolean isTouchRightImg = isTouchRightImg(motionEvent);
            if (motionEvent.getAction() == 0) {
                if (isTouchRightImg) {
                    return true;
                }
            } else if (motionEvent.getAction() == 1 && isTouchRightImg) {
                if (this.mIsShowClearNow) {
                    setText("");
                    setError(null);
                    return true;
                }
                this.mRightImgClickListener.onClick(this);
                return true;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public boolean isTouchRightImg(MotionEvent motionEvent) {
        return motionEvent.getX() > ((float) ((getWidth() - getPaddingRight()) - this.mClearDrawable.getIntrinsicWidth())) && motionEvent.getX() < ((float) (getWidth() - getPaddingRight()));
    }

    public void onFocusChange(View view, boolean z) {
        if (z) {
            setClearIconVisible(getText().length() > 0);
        }
    }

    protected void setClearIconVisible(boolean z) {
        if (this.isClearFunctionEnable) {
            Drawable drawable = z ? this.mClearDrawable : this.mRightDrawable;
            if (drawable != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            }
            setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], null, getCompoundDrawables()[3]);
            setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], drawable, getCompoundDrawables()[3]);
            this.mIsShowClearNow = z;
        }
    }

    public void setClearFunctionEnable(boolean z) {
        this.isClearFunctionEnable = z;
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        setClearIconVisible(z);
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (getError() == null) {
            setClearIconVisible(charSequence.length() > 0);
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void afterTextChanged(Editable editable) {
    }

    public void setStaticRightEndImg(Drawable drawable, OnClickListener onClickListener) {
        this.mRightDrawable = drawable;
        this.mRightImgClickListener = onClickListener;
        setClearIconVisible(false);
    }

    public void setStaticRightEndImg(int i, OnClickListener onClickListener) {
        this.mRightDrawable = getResources().getDrawable(i);
        setStaticRightEndImg(this.mRightDrawable, onClickListener);
    }
}
