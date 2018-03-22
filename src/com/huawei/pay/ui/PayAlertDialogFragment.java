package com.huawei.pay.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.pay.e.c.a;
import com.huawei.ui.commonui.dialog.C6024w;
import com.sina.weibo.sdk.constant.WBConstants;

public class PayAlertDialogFragment extends DialogFragment {
    private Activity activity;
    AlertDialogListener mListener;
    private int what;

    public interface AlertDialogListener {
        void onAlertDialogKeyBack(int i);

        void onAlertDialogNegativeClick(int i);

        void onAlertDialogPositiveClick(int i);
    }

    class C57361 implements OnClickListener {
        C57361() {
        }

        public void onClick(View view) {
            if (PayAlertDialogFragment.this.mListener != null) {
                PayAlertDialogFragment.this.mListener.onAlertDialogPositiveClick(PayAlertDialogFragment.this.what);
                PayAlertDialogFragment.this.dismiss();
            }
        }
    }

    class C57372 implements OnClickListener {
        C57372() {
        }

        public void onClick(View view) {
            if (PayAlertDialogFragment.this.mListener != null) {
                PayAlertDialogFragment.this.mListener.onAlertDialogNegativeClick(PayAlertDialogFragment.this.what);
                PayAlertDialogFragment.this.dismiss();
            }
        }
    }

    class C57383 implements OnKeyListener {
        C57383() {
        }

        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i != 4 || keyEvent.getAction() != 0 || PayAlertDialogFragment.this.mListener == null) {
                return false;
            }
            dialogInterface.dismiss();
            PayAlertDialogFragment.this.mListener.onAlertDialogKeyBack(PayAlertDialogFragment.this.what);
            return true;
        }
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = activity;
        try {
            this.mListener = (AlertDialogListener) activity;
        } catch (Throwable e) {
            a.a("ClassCastException.", e, false);
        }
    }

    public static PayAlertDialogFragment newInstance(int i, String str, String str2, String str3, String str4, boolean z) {
        PayAlertDialogFragment payAlertDialogFragment = new PayAlertDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("what", i);
        bundle.putString("title", str);
        bundle.putString(WBConstants.ACTION_LOG_TYPE_MESSAGE, str2);
        bundle.putString("positive", str3);
        bundle.putString("negative", str4);
        bundle.putBoolean("cancelable", z);
        payAlertDialogFragment.setArguments(bundle);
        return payAlertDialogFragment;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        this.what = getArguments().getInt("what");
        String string = getArguments().getString("title");
        String string2 = getArguments().getString(WBConstants.ACTION_LOG_TYPE_MESSAGE);
        String string3 = getArguments().getString("positive");
        String string4 = getArguments().getString("negative");
        C6024w c6024w = new C6024w(this.activity);
        if (!TextUtils.isEmpty(string)) {
            c6024w.m27594a(string);
        }
        if (!TextUtils.isEmpty(string2)) {
            c6024w.m27598b(string2);
        }
        if (!TextUtils.isEmpty(string3)) {
            c6024w.m27595a(string3, new C57361());
        }
        if (!TextUtils.isEmpty(string4)) {
            c6024w.m27599b(string4, new C57372());
        }
        Dialog a = c6024w.m27590a();
        a.show();
        a.setCancelable(getArguments().getBoolean("cancelable"));
        a.setOnKeyListener(new C57383());
        a.setCanceledOnTouchOutside(false);
        return a;
    }
}
