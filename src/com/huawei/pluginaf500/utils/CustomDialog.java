package com.huawei.pluginaf500.utils;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import android.os.Message;
import com.huawei.pluginaf500.i;
import java.lang.ref.WeakReference;

public class CustomDialog extends Dialog {

    final class ButtonHandler extends Handler {
        private WeakReference<DialogInterface> f19985a;

        public ButtonHandler(DialogInterface dialogInterface) {
            this.f19985a = new WeakReference(dialogInterface);
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case -3:
                case -2:
                case -1:
                    ((OnClickListener) message.obj).onClick((DialogInterface) this.f19985a.get(), message.what);
                    return;
                case 1:
                    DialogInterface dialogInterface = (DialogInterface) this.f19985a.get();
                    if (dialogInterface != null) {
                        dialogInterface.dismiss();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public CustomDialog(Context context) {
        this(context, i.CustomDialog);
    }

    public CustomDialog(Context context, int i) {
        super(context, i);
    }
}
