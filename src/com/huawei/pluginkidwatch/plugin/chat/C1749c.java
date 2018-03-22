package com.huawei.pluginkidwatch.plugin.chat;

import android.text.Editable;
import android.text.TextWatcher;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;

/* compiled from: ChatActivity */
class C1749c implements TextWatcher {
    final /* synthetic */ ChatActivity f4840a;

    C1749c(ChatActivity chatActivity) {
        this.f4840a = chatActivity;
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void afterTextChanged(Editable editable) {
        C2538c.m12666a(false, "ChatActivity", "===========mTextWatcher afterTextChanged arg0:" + editable.length());
        if (editable.toString().trim().length() > 30) {
            C2538c.m12666a(false, "ChatActivity", "===========mTextWatcher afterTextChanged a > 30:");
            String obj = editable.toString();
            String a = this.f4840a.m8362a(obj.length() - this.f4840a.m8365a(obj).length());
            int selectionEnd = this.f4840a.f4740x.getSelectionEnd();
            a = a + editable.toString().trim().substring(0, 30);
            this.f4840a.f4740x.setText(a);
            if (a.length() < selectionEnd) {
                selectionEnd = a.length();
            }
            this.f4840a.f4740x.setSelection(selectionEnd);
            if (!this.f4840a.ag) {
                this.f4840a.ag = true;
                this.f4840a.ay.postDelayed(this.f4840a.at, 3000);
                C1483c.m6832c(this.f4840a.f4709Q, String.format(this.f4840a.f4709Q.getResources().getString(C1680l.IDS_plugin_kidwatch_chat_message_too_long), new Object[]{Integer.valueOf(30)}));
            }
        }
    }
}
