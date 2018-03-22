package com.huawei.ui.commonui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

public class CustomAlertDialog extends Dialog {
    private static Handler f20612a = null;
    private C6005d f20613b;
    private Context f20614c;

    final class ButtonHandler extends Handler {
        private WeakReference<DialogInterface> f20611a;

        public ButtonHandler(DialogInterface dialogInterface) {
            this.f20611a = new WeakReference(dialogInterface);
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case -3:
                case -2:
                case -1:
                    if (message.obj instanceof OnClickListener) {
                        ((OnClickListener) message.obj).onClick((DialogInterface) this.f20611a.get(), message.what);
                        return;
                    }
                    return;
                case 1:
                    DialogInterface dialogInterface = (DialogInterface) this.f20611a.get();
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

    private CustomAlertDialog(Context context, int i) {
        super(context, i);
        this.f20614c = context;
        this.f20613b = new C6005d(this, context);
    }

    public void setTitle(int i) {
        this.f20613b.m27553a(this.f20614c.getString(i));
    }

    private C6005d m27466b() {
        return this.f20613b;
    }

    public static int m27462a(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }
}
