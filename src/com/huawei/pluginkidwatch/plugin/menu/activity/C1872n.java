package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: AddContactActivity */
class C1872n implements OnClickListener {
    final /* synthetic */ AddContactActivity f6177a;

    C1872n(AddContactActivity addContactActivity) {
        this.f6177a = addContactActivity;
    }

    public void onClick(View view) {
        this.f6177a.startActivity(new Intent(this.f6177a, ImportContactActivity.class));
    }
}
