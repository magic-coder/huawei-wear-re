package com.huawei.nfc.carrera.ui.swipe;

import com.huawei.nfc.carrera.ui.swipe.listener.QueryPaymentListener;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.wallet.R;
import java.util.List;

class SwipeActivity$1 implements QueryPaymentListener {
    final /* synthetic */ SwipeActivity this$0;

    SwipeActivity$1(SwipeActivity swipeActivity) {
        this.this$0 = swipeActivity;
    }

    public void queryFailed(int i) {
        if (SwipeActivity.access$000(this.this$0) != null && SwipeActivity.access$000(this.this$0).isShowing()) {
            SwipeActivity.access$000(this.this$0).dismiss();
        }
        if (1 == i) {
            SwipeActivity.access$102(this.this$0, false);
            SwipeActivity.access$200(this.this$0, this.this$0.getString(R.string.nfc_scanpay_no_login));
            LogX.i("queryPayment failed , not login...");
        }
    }

    public void getOpenPayAppMsg(List<String> list, int i) {
        if (SwipeActivity.access$000(this.this$0) != null && SwipeActivity.access$000(this.this$0).isShowing()) {
            SwipeActivity.access$000(this.this$0).dismiss();
        }
        LogX.i("packageNames is " + list);
        SwipeActivity.access$300(this.this$0, list);
    }
}
