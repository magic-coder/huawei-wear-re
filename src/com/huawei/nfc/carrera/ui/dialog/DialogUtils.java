package com.huawei.nfc.carrera.ui.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnKeyListener;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.huawei.cp3.widget.C4372a;
import com.huawei.cp3.widget.custom.p384a.C4374a;
import com.huawei.cp3.widget.p382a.p383a.C4370a;
import com.huawei.cp3.widget.p382a.p383a.C4371b;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.wallet.R;

public class DialogUtils {

    public class CustomAlertDialog {
        private C4370a dialog;
        private OnDialogListener mListener;

        class C56581 implements OnClickListener {
            C56581() {
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                if (CustomAlertDialog.this.mListener != null) {
                    CustomAlertDialog.this.mListener.onPositiveButtonClick();
                    CustomAlertDialog.this.dismiss();
                }
            }
        }

        class C56592 implements OnClickListener {
            C56592() {
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                if (CustomAlertDialog.this.mListener != null) {
                    CustomAlertDialog.this.mListener.onNegativeButtonClick();
                    CustomAlertDialog.this.dismiss();
                }
            }
        }

        class C56603 implements OnKeyListener {
            C56603() {
            }

            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (i != 4 || keyEvent.getAction() != 0 || CustomAlertDialog.this.mListener == null) {
                    return false;
                }
                CustomAlertDialog.this.dismiss();
                CustomAlertDialog.this.mListener.onKeyBack();
                return true;
            }
        }

        private CustomAlertDialog(Context context, OnDialogListener onDialogListener) {
            this.dialog = C4372a.m20997a(context);
            this.mListener = onDialogListener;
        }

        public void setTitle(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.dialog.mo4428a(str);
            }
        }

        public void setMessage(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.dialog.mo4431b(str);
            }
        }

        public void setPositiveButton(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.dialog.mo4427a((CharSequence) str, new C56581());
            }
        }

        public void setNegativeButton(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.dialog.mo4430b((CharSequence) str, new C56592());
            }
        }

        public void setOnKeyListener() {
            this.dialog.setOnKeyListener(new C56603());
        }

        public void setCancelable(boolean z) {
            this.dialog.setCancelable(z);
        }

        public void setCanceledOnTouchOutside(boolean z) {
            this.dialog.setCanceledOnTouchOutside(z);
        }

        public C4370a getDialogObject() {
            return this.dialog;
        }

        public void show() {
            if (this.dialog != null && !this.dialog.isShowing()) {
                try {
                    this.dialog.show();
                } catch (Exception e) {
                    LogX.e("show CustomAlertDialog failed.");
                }
            }
        }

        public void dismiss() {
            if (this.dialog != null && this.dialog.getWindow() != null && this.dialog.isShowing()) {
                this.dialog.dismiss();
            }
        }
    }

    public class CustomProgressBarDialog {
        private TextView downLoadProgressSize;
        private TextView downLoadProgressText;
        private ProgressBar downLoadProgressbar;
        private Context mContext;
        private C4370a progressBarDialog;

        class MyOnKeyListener implements OnKeyListener {
            private OnDialogKeyBackListener mListener;

            private MyOnKeyListener(OnDialogKeyBackListener onDialogKeyBackListener) {
                this.mListener = onDialogKeyBackListener;
            }

            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (i == 4 && keyEvent.getAction() == 0) {
                    this.mListener.onKeyBack();
                }
                return false;
            }
        }

        private CustomProgressBarDialog(Context context, OnDialogKeyBackListener onDialogKeyBackListener) {
            this.progressBarDialog = C4372a.m20997a(context);
            this.mContext = context.getApplicationContext();
            View inflate = LayoutInflater.from(context).inflate(R.layout.file_download_progress_dialog, null);
            if (this.progressBarDialog instanceof C4374a) {
                View a = ((C4374a) this.progressBarDialog).m21010a();
                a.setPadding(a.getPaddingLeft(), 0, a.getPaddingRight(), 0);
            }
            this.progressBarDialog.mo4426a(inflate);
            this.downLoadProgressbar = (ProgressBar) inflate.findViewById(R.id.download_progress_ps);
            this.downLoadProgressText = (TextView) inflate.findViewById(R.id.download_progress_text_tv);
            this.downLoadProgressText.setText(context.getString(R.string.download_progress1, new Object[]{"0%"}));
            this.downLoadProgressSize = (TextView) inflate.findViewById(R.id.file_isdowning_size_tv);
            this.progressBarDialog.setCanceledOnTouchOutside(false);
            this.progressBarDialog.setCancelable(false);
            this.progressBarDialog.setOnKeyListener(new MyOnKeyListener(onDialogKeyBackListener));
        }

        public void updateProgress(int i) {
            this.downLoadProgressbar.setProgress(i);
            this.downLoadProgressText.setText(this.mContext.getString(R.string.download_progress1, new Object[]{i + "%"}));
        }

        public void udpateView(String str) {
            this.downLoadProgressSize.setText(str);
        }

        public C4370a getDialogObject() {
            return this.progressBarDialog;
        }

        public void show() {
            if (this.progressBarDialog != null && !this.progressBarDialog.isShowing()) {
                try {
                    this.progressBarDialog.show();
                } catch (Exception e) {
                    LogX.e("show CustomProgressBarDialog failed.");
                }
            }
        }

        public void dismiss() {
            if (this.progressBarDialog != null && this.progressBarDialog.getWindow() != null && this.progressBarDialog.isShowing()) {
                this.progressBarDialog.dismiss();
            }
        }
    }

    public class CustomProgressDialog {
        private Context mContext;
        private C4371b progressDialog;

        private CustomProgressDialog(Context context, int i) {
            this.progressDialog = C4372a.m21001b(context);
            this.mContext = context;
            this.progressDialog.mo4439a(this.mContext.getString(R.string.hwpay_installing));
            this.progressDialog.setCanceledOnTouchOutside(false);
            this.progressDialog.setCancelable(false);
        }

        public void show() {
            if (this.progressDialog != null && !this.progressDialog.isShowing()) {
                try {
                    this.progressDialog.show();
                } catch (Exception e) {
                    LogX.e("show CustomProgressDialog failed.");
                }
            }
        }

        public void dismiss() {
            if (this.progressDialog != null && this.progressDialog.getWindow() != null && this.progressDialog.isShowing()) {
                this.progressDialog.dismiss();
            }
        }
    }

    public interface OnDialogKeyBackListener {
        void onKeyBack();
    }

    public interface OnDialogListener extends OnDialogKeyBackListener {
        void onNegativeButtonClick();

        void onPositiveButtonClick();
    }

    public static CustomAlertDialog createAlertDialog(Context context, String str, String str2, String str3, String str4, boolean z, OnDialogListener onDialogListener) {
        CustomAlertDialog customAlertDialog = new CustomAlertDialog(context, onDialogListener);
        customAlertDialog.setTitle(str);
        customAlertDialog.setMessage(str2);
        customAlertDialog.setPositiveButton(str3);
        customAlertDialog.setNegativeButton(str4);
        if (z) {
            customAlertDialog.setOnKeyListener();
        }
        customAlertDialog.setCancelable(z);
        customAlertDialog.setCanceledOnTouchOutside(false);
        return customAlertDialog;
    }

    public static CustomProgressDialog createProgressDialog(Context context, int i) {
        return new CustomProgressDialog(context, i);
    }

    public static CustomProgressBarDialog createProgressBarDialog(Context context, OnDialogKeyBackListener onDialogKeyBackListener) {
        return new CustomProgressBarDialog(context, onDialogKeyBackListener);
    }
}
