package com.huawei.pluginkidwatch.plugin.menu.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.TextView.BufferType;
import com.huawei.pluginkidwatch.common.lib.utils.C1489i;

public class FenceAddressEditText extends EditText {
    private C1857c f6245a;
    private boolean f6246b = false;
    private boolean f6247c = true;
    private CharSequence f6248d;

    public void setAddressFocusChandeListener(C1857c c1857c) {
        this.f6245a = (C1857c) C1489i.m6887a(c1857c);
    }

    public FenceAddressEditText(Context context) {
        super(context);
        m9710b();
    }

    public FenceAddressEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m9710b();
    }

    private void m9710b() {
        this.f6248d = "";
        this.f6246b = false;
        this.f6247c = true;
        setOnFocusChangeListener(new C1907a(this));
        addTextChangedListener(new C1908b(this));
    }

    public void setText(CharSequence charSequence, BufferType bufferType) {
        super.setText(charSequence, bufferType);
        this.f6248d = charSequence;
        this.f6246b = false;
        this.f6247c = false;
    }

    public boolean m9713a() {
        return this.f6246b && this.f6247c;
    }
}
