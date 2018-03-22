package com.huawei.pay.ui.widget.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

abstract class CommonBaseDialogListener implements Parcelable {
    public abstract void onDialogInit(Dialog dialog, CommonBaseDialogFragment commonBaseDialogFragment);

    CommonBaseDialogListener() {
    }

    public void onCreate(Bundle bundle) {
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    public void onDestory() {
    }

    public void onDialogDismiss() {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
    }
}
