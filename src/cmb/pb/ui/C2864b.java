package cmb.pb.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.wallet.R;

final class C2864b implements OnClickListener {
    final /* synthetic */ PBKeyboardActivity f9292a;

    C2864b(PBKeyboardActivity pBKeyboardActivity) {
        this.f9292a = pBKeyboardActivity;
    }

    public final void onClick(View view) {
        if (this.f9292a.f9286s != null) {
            this.f9292a.f9286s.setText(this.f9292a.getResources().getString(R.string.cmbkb_finish));
            this.f9292a.f9286s.setOnClickListener(this.f9292a.f9265N);
            this.f9292a.f9276h.setKeyboard(this.f9292a.f9282o);
            this.f9292a.f9263D = PBKeyboardActivity.f9252K;
        }
    }
}
