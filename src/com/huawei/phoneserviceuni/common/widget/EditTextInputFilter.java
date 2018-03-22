package com.huawei.phoneserviceuni.common.widget;

import android.content.Context;
import android.text.InputFilter;
import android.text.Spanned;
import com.huawei.phoneserviceuni.common.d.f;

public class EditTextInputFilter implements InputFilter {
    private Context mContext;
    private int maxLength;
    private String toaststr;

    public EditTextInputFilter(Context context, int i, String str) {
        this.mContext = context;
        this.maxLength = i;
        this.toaststr = str;
    }

    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        int length = this.maxLength - (spanned.length() - (i4 - i3));
        if (length <= 0) {
            f.a(this.mContext, this.toaststr);
            return "";
        } else if (length >= i2 - i) {
            return null;
        } else {
            if (length < charSequence.length()) {
                f.a(this.mContext, this.toaststr);
            }
            return charSequence.subSequence(i, length + i);
        }
    }
}
