package com.huawei.pay.ui.widget.dialog;

import android.app.DatePickerDialog.OnDateSetListener;
import android.os.Bundle;
import android.os.Parcel;
import android.widget.DatePicker;

public abstract class CommonDatePickerDialogListener extends CommonBaseDialogListener implements OnDateSetListener {
    public abstract void onDateSet(DatePicker datePicker, int i, int i2, int i3);

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
}
