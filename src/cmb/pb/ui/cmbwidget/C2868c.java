package cmb.pb.ui.cmbwidget;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

final class C2868c implements OnTouchListener {
    final /* synthetic */ CmbEditText f9311a;

    private C2868c(CmbEditText cmbEditText) {
        this.f9311a = cmbEditText;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z = true;
        if (this.f9311a.getCompoundDrawables()[2] != null && motionEvent.getAction() == 1) {
            CmbEditText cmbEditText = this.f9311a;
            if (motionEvent.getX() <= ((float) ((this.f9311a.getWidth() - this.f9311a.getPaddingRight()) - this.f9311a.f9305k.getIntrinsicWidth())) || motionEvent.getX() >= ((float) (this.f9311a.getWidth() - this.f9311a.getPaddingRight()))) {
                z = false;
            }
            cmbEditText.f9306l = z;
            if (this.f9311a.f9306l) {
                this.f9311a.m13001a();
            }
        }
        this.f9311a.setSelection(this.f9311a.length());
        CmbEditText cmbEditText2 = this.f9311a;
        CmbEditText.m12992a(this.f9311a);
        if (!this.f9311a.f9301g) {
            this.f9311a.m13003b();
        }
        return false;
    }
}
