package com.huawei.pay.ui.widget.dialog;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.DialogFragment;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.huawei.cp3.widget.C4372a;
import com.huawei.cp3.widget.p382a.p383a.C4370a;
import java.util.Calendar;

public final class CommonBaseDialogFragment extends DialogFragment {
    private static final String ENUM_KEY = "enmu_key";
    private static final String LISTENER_KEY = "mlistener_key";
    private Activity activity;
    private DialogClass mDialogClass;
    private CommonBaseDialogListener mListener;

    public enum DialogClass {
        AlertDialog("enum_alertdialog"),
        DatePickerDialog("enum_datepickerdialog");
        
        private String message;

        private DialogClass(String str) {
            this.message = str;
        }

        public static DialogClass getEnumByName(String str) {
            if (str.equals("enum_alertdialog")) {
                return AlertDialog;
            }
            if (str.equals("enum_datepickerdialog")) {
                return DatePickerDialog;
            }
            return null;
        }

        public String getName() {
            return this.message;
        }
    }

    public interface OnClickListener {
        void onClick(CommonBaseDialogFragment commonBaseDialogFragment);
    }

    public CommonBaseDialogFragment() {
        this.mListener = null;
    }

    public CommonBaseDialogFragment(CommonAlertDialogListener commonAlertDialogListener) {
        this.mListener = null;
        this.mDialogClass = DialogClass.AlertDialog;
        this.mListener = commonAlertDialogListener;
    }

    public CommonBaseDialogFragment(CommonDatePickerDialogListener commonDatePickerDialogListener) {
        this.mListener = null;
        this.mDialogClass = DialogClass.DatePickerDialog;
        this.mListener = commonDatePickerDialogListener;
    }

    public CommonBaseDialogFragment(String str, String str2, String str3, boolean z) {
        this(str, str2, str3, null, null, null, null, z);
    }

    public CommonBaseDialogFragment(String str, String str2, String str3, OnClickListener onClickListener, OnClickListener onClickListener2, boolean z) {
        this(str, str2, str3, onClickListener, null, null, onClickListener2, z);
    }

    public CommonBaseDialogFragment(String str, String str2, String str3, OnClickListener onClickListener, String str4, OnClickListener onClickListener2, OnClickListener onClickListener3, boolean z) {
        this.mListener = null;
        final String str5 = str;
        final String str6 = str2;
        final String str7 = str3;
        final OnClickListener onClickListener4 = onClickListener;
        final String str8 = str4;
        final OnClickListener onClickListener5 = onClickListener2;
        final boolean z2 = z;
        final OnClickListener onClickListener6 = onClickListener3;
        CommonBaseDialogListener c57481 = new CommonAlertDialogListener() {
            public void onDialogInit(C4370a c4370a, final CommonBaseDialogFragment commonBaseDialogFragment) {
                if (!TextUtils.isEmpty(str5)) {
                    c4370a.mo4428a(str5);
                }
                if (!TextUtils.isEmpty(str6)) {
                    c4370a.mo4431b(str6);
                }
                if (!TextUtils.isEmpty(str7)) {
                    c4370a.mo4427a(str7, new android.content.DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i) {
                            if (onClickListener4 != null) {
                                onClickListener4.onClick(commonBaseDialogFragment);
                            } else {
                                commonBaseDialogFragment.dismissAllowingStateLoss();
                            }
                        }
                    });
                }
                if (!TextUtils.isEmpty(str8)) {
                    c4370a.mo4430b(str8, new android.content.DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i) {
                            if (onClickListener5 != null) {
                                onClickListener5.onClick(commonBaseDialogFragment);
                            } else {
                                commonBaseDialogFragment.dismissAllowingStateLoss();
                            }
                        }
                    });
                }
                c4370a.setCancelable(z2);
                c4370a.setOnKeyListener(new OnKeyListener() {
                    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                        if (i != 4 || keyEvent.getAction() != 0 || CommonBaseDialogFragment.this.mListener == null) {
                            return false;
                        }
                        if (onClickListener6 != null) {
                            onClickListener6.onClick(commonBaseDialogFragment);
                        } else {
                            commonBaseDialogFragment.dismissAllowingStateLoss();
                        }
                        return true;
                    }
                });
                c4370a.setCanceledOnTouchOutside(false);
            }

            public void onDialogDismiss() {
            }
        };
        this.mDialogClass = DialogClass.AlertDialog;
        this.mListener = c57481;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            Object string = bundle.getString(ENUM_KEY);
            if (!TextUtils.isEmpty(string)) {
                this.mDialogClass = DialogClass.getEnumByName(string);
            }
            Parcelable parcelable = bundle.getParcelable(LISTENER_KEY);
            if (parcelable != null && (parcelable instanceof CommonBaseDialogListener)) {
                this.mListener = (CommonBaseDialogListener) parcelable;
            }
        }
        if (this.mListener != null) {
            this.mListener.onCreate(bundle);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.mDialogClass != null) {
            bundle.putString(ENUM_KEY, this.mDialogClass.getName());
        }
        if (this.mListener != null) {
            bundle.putParcelable(LISTENER_KEY, this.mListener);
        }
        if (this.mListener != null) {
            this.mListener.onSaveInstanceState(bundle);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.mListener != null) {
            this.mListener.onDestory();
        }
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = activity;
    }

    public void onDetach() {
        super.onDetach();
        this.activity = null;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        if (this.mListener == null) {
            dismissAllowingStateLoss();
            return onCreateDialog;
        }
        switch (this.mDialogClass) {
            case AlertDialog:
                if (this.mListener instanceof CommonAlertDialogListener) {
                    C4370a a = C4372a.m20997a(this.activity);
                    ((CommonAlertDialogListener) this.mListener).onDialogInit(a, this);
                    return (Dialog) a;
                }
                dismissAllowingStateLoss();
                return onCreateDialog;
            case DatePickerDialog:
                if (this.mListener instanceof CommonDatePickerDialogListener) {
                    Calendar instance = Calendar.getInstance();
                    onCreateDialog = new DatePickerDialog(this.activity, getTheme(), (CommonDatePickerDialogListener) this.mListener, instance.get(1), instance.get(2), instance.get(5));
                    this.mListener.onDialogInit(onCreateDialog, this);
                    return onCreateDialog;
                }
                dismissAllowingStateLoss();
                return onCreateDialog;
            default:
                return onCreateDialog;
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
        if (this.mListener != null) {
            this.mListener.onDialogDismiss();
        }
        super.onDismiss(dialogInterface);
    }
}
