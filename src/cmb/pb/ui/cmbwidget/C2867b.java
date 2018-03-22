package cmb.pb.ui.cmbwidget;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.MotionEvent;
import cmb.pb.cmbsafe.CmbService;
import cmb.pb.ui.PBKeyboardActivity;

final class C2867b extends Handler {
    final /* synthetic */ CmbEditText f9310a;

    public C2867b(CmbEditText cmbEditText) {
        this.f9310a = cmbEditText;
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 0:
                if (this.f9310a != null) {
                    this.f9310a.requestFocus();
                    if (this.f9310a.f9306l) {
                        PBKeyboardActivity.m12971b().m12989a();
                        this.f9310a.setText("");
                        this.f9310a.f9306l = false;
                        return;
                    }
                    this.f9310a.getText().insert(this.f9310a.getSelectionStart(), Character.toString((char) message.getData().getInt("KeyCode")));
                    return;
                }
                return;
            case 1:
                if (this.f9310a != null) {
                    this.f9310a.requestFocus();
                    if (this.f9310a.f9306l) {
                        PBKeyboardActivity.m12971b().m12989a();
                        this.f9310a.setText("");
                        this.f9310a.f9306l = false;
                        return;
                    }
                    this.f9310a.setText(message.getData().getString("KeyString"));
                    CmbEditText cmbEditText = this.f9310a;
                    CmbEditText.m12992a(this.f9310a);
                    return;
                }
                return;
            case 2:
                this.f9310a.f9301g = false;
                if (this.f9310a.f9307n != null) {
                    Bundle data = message.getData();
                    float f = data.getFloat("rawX");
                    float f2 = data.getFloat("rawY");
                    this.f9310a.f9307n.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 0, f, f2, 0));
                    this.f9310a.f9307n.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 1, f, f2, 0));
                }
                this.f9310a.f9307n.stopService(new Intent(this.f9310a.f9307n, CmbService.class));
                return;
            default:
                return;
        }
    }
}
