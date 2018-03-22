package cmb.pb.ui;

import android.view.View;
import android.view.View.OnFocusChangeListener;

final class C2871d implements OnFocusChangeListener {
    final /* synthetic */ PBKeyboardActivity f9316a;

    C2871d(PBKeyboardActivity pBKeyboardActivity) {
        this.f9316a = pBKeyboardActivity;
    }

    public final void onFocusChange(View view, boolean z) {
        if (z) {
            PBKeyboardActivity.m12967a(this.f9316a, view);
        }
    }
}
