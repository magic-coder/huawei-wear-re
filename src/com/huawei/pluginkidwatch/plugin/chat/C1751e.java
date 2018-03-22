package com.huawei.pluginkidwatch.plugin.chat;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1617f;

/* compiled from: ChatActivity */
class C1751e implements OnClickListener {
    final /* synthetic */ ChatActivity f4842a;

    C1751e(ChatActivity chatActivity) {
        this.f4842a = chatActivity;
    }

    public void onClick(View view) {
        if (((Boolean) this.f4842a.f4739w.getTag()).booleanValue()) {
            C2538c.m12674b("ChatActivity", "=====输入语音 ");
            this.f4842a.f4739w.setBackgroundResource(C1617f.chat_btn_text);
            this.f4842a.f4739w.setTag(Boolean.valueOf(false));
            this.f4842a.f4741y.setVisibility(8);
            this.f4842a.f4737u.setVisibility(0);
            ((InputMethodManager) this.f4842a.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
            return;
        }
        C2538c.m12674b("ChatActivity", "=====输入文字 ");
        this.f4842a.f4739w.setBackgroundResource(C1617f.chat_btn_voice);
        this.f4842a.f4739w.setTag(Boolean.valueOf(true));
        this.f4842a.f4741y.setVisibility(0);
        this.f4842a.f4737u.setVisibility(8);
        this.f4842a.f4740x.requestFocus();
        this.f4842a.f4740x.requestFocus(this.f4842a.f4740x.getText().toString().length());
        this.f4842a.m8369a(this.f4842a.f4740x);
    }
}
