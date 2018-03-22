package cmb.pb.ui.cmbwidget;

import android.os.Handler;
import android.os.Message;

final class C2869d extends Handler {
    final /* synthetic */ CmbEditText f9312a;

    public C2869d(CmbEditText cmbEditText) {
        this.f9312a = cmbEditText;
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 345:
                this.f9312a.m13003b();
                return;
            default:
                return;
        }
    }
}
