package com.huawei.pluginkidwatch.common.ui.view;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import android.os.Message;
import com.huawei.pluginkidwatch.m;
import java.lang.ref.WeakReference;

public class CustomDialog extends Dialog {
    private static Handler f3800a = null;
    private C1597x f3801b;
    private Context f3802c;

    final class ButtonHandler extends Handler {
        private WeakReference<DialogInterface> f3799a;

        public ButtonHandler(DialogInterface dialogInterface) {
            this.f3799a = new WeakReference(dialogInterface);
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case -3:
                case -2:
                case -1:
                    ((OnClickListener) message.obj).onClick((DialogInterface) this.f3799a.get(), message.what);
                    return;
                case 1:
                    DialogInterface dialogInterface = (DialogInterface) this.f3799a.get();
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
        this(context, m.common_ui_customdialog);
    }

    public CustomDialog(Context context, int i) {
        super(context, i);
        this.f3802c = context;
        this.f3801b = new C1597x(this, context);
    }

    public void setTitle(int i) {
        this.f3801b.m7361a(this.f3802c.getString(i));
    }

    public C1597x m7203a() {
        return this.f3801b;
    }
}
