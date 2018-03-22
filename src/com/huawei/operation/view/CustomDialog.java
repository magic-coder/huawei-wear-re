package com.huawei.operation.view;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

public class CustomDialog extends Dialog {

    final class ButtonHandler extends Handler {
        private WeakReference<DialogInterface> f19475a;

        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message != null) {
                switch (message.what) {
                    case -3:
                    case -2:
                    case -1:
                        if (message.obj != null && this.f19475a.get() != null) {
                            ((OnClickListener) message.obj).onClick((DialogInterface) this.f19475a.get(), message.what);
                            return;
                        }
                        return;
                    case 1:
                        DialogInterface dialogInterface = (DialogInterface) this.f19475a.get();
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
    }
}
