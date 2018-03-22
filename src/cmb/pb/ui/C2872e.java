package cmb.pb.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

final class C2872e implements OnTouchListener {
    final /* synthetic */ PBKeyboardActivity f9317a;

    C2872e(PBKeyboardActivity pBKeyboardActivity) {
        this.f9317a = pBKeyboardActivity;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            PBKeyboardActivity.m12967a(this.f9317a, view);
        }
        return true;
    }
}
