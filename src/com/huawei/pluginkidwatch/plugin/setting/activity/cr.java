package com.huawei.pluginkidwatch.plugin.setting.activity;

import android.text.Editable;
import android.text.TextWatcher;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;

/* compiled from: SetRewardGoalActivity */
class cr implements TextWatcher {
    final /* synthetic */ SetRewardGoalActivity f6672a;
    private CharSequence f6673b;
    private int f6674c;
    private int f6675d;

    cr(SetRewardGoalActivity setRewardGoalActivity) {
        this.f6672a = setRewardGoalActivity;
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.f6673b = charSequence;
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void afterTextChanged(Editable editable) {
        this.f6674c = this.f6672a.f6559f.getSelectionStart();
        this.f6675d = this.f6672a.f6559f.getSelectionEnd();
        if (this.f6673b.length() > 20) {
            editable.delete(this.f6674c - 1, this.f6675d);
            this.f6672a.f6559f.setText(editable);
            this.f6672a.f6559f.setSelection(editable.length());
            if (!this.f6672a.f6549G) {
                this.f6672a.f6549G = true;
                this.f6672a.f6550H.postDelayed(this.f6672a.f6554L, 3000);
                C1483c.m6832c(this.f6672a.f6557d, String.format(this.f6672a.f6557d.getResources().getString(C1680l.IDS_plugin_kidwatch_feature_reward_baby_hope_length_alert), new Object[]{Integer.valueOf(20)}));
            }
        }
    }
}
