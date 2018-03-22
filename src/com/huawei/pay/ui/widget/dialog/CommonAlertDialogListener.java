package com.huawei.pay.ui.widget.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Parcel;
import com.huawei.cp3.widget.p382a.p383a.C4370a;

public abstract class CommonAlertDialogListener extends CommonBaseDialogListener {
    public abstract void onDialogInit(C4370a c4370a, CommonBaseDialogFragment commonBaseDialogFragment);

    public /* bridge */ /* synthetic */ int describeContents() {
        return super.describeContents();
    }

    public /* bridge */ /* synthetic */ void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public /* bridge */ /* synthetic */ void onDestory() {
        super.onDestory();
    }

    public /* bridge */ /* synthetic */ void onDialogDismiss() {
        super.onDialogDismiss();
    }

    public /* bridge */ /* synthetic */ void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    public /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }

    public void onDialogInit(Dialog dialog, CommonBaseDialogFragment commonBaseDialogFragment) {
    }
}
