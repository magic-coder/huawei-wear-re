package cmb.pb.ui.cmbwidget;

import android.view.View;
import android.view.View.OnFocusChangeListener;

final class C2866a implements OnFocusChangeListener {
    final /* synthetic */ CmbEditText f9309a;

    private C2866a(CmbEditText cmbEditText) {
        this.f9309a = cmbEditText;
    }

    public final void onFocusChange(View view, boolean z) {
        boolean z2 = false;
        if (z) {
            CmbEditText cmbEditText = this.f9309a;
            CmbEditText.m12991a(this.f9309a);
            this.f9309a.setSelection(this.f9309a.length());
            cmbEditText = this.f9309a;
            CmbEditText.m12992a(this.f9309a);
            if (!this.f9309a.f9301g) {
                this.f9309a.m13003b();
            }
            cmbEditText = this.f9309a;
            if (this.f9309a.getText().length() > 0) {
                z2 = true;
            }
            cmbEditText.m13002a(z2);
            return;
        }
        this.f9309a.m13004c();
        this.f9309a.m13002a(false);
    }
}
