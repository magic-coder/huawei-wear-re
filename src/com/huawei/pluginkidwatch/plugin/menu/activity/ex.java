package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: ImportContactActivity */
class ex implements TextWatcher {
    final /* synthetic */ ImportContactActivity f6105a;
    private String f6106b;

    ex(ImportContactActivity importContactActivity) {
        this.f6105a = importContactActivity;
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.f6106b = charSequence.toString();
        if ("".equals(this.f6106b)) {
            this.f6105a.f5770m.sendEmptyMessage(4);
        } else if (this.f6105a.f5774q.matcher(this.f6106b).find() || this.f6105a.f5776s.matcher(this.f6106b).find()) {
            new ey(this).execute(new String[0]);
        } else if (!this.f6105a.f5775r.matcher(this.f6106b).find() && !this.f6105a.f5774q.matcher(this.f6106b).find() && !this.f6105a.f5776s.matcher(this.f6106b).find()) {
            this.f6105a.f5770m.sendEmptyMessage(5);
        } else if (this.f6105a.f5775r.matcher(this.f6106b).find()) {
            new ez(this).execute(new String[0]);
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void afterTextChanged(Editable editable) {
    }
}
