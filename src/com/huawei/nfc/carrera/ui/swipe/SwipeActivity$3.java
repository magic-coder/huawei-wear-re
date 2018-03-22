package com.huawei.nfc.carrera.ui.swipe;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.pay.ui.util.ToastManager;
import com.huawei.wallet.R;

class SwipeActivity$3 implements OnClickListener {
    final /* synthetic */ SwipeActivity this$0;

    SwipeActivity$3(SwipeActivity swipeActivity) {
        this.this$0 = swipeActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        LogX.i("cancel to openNFC");
        ToastManager.show(this.this$0, R.string.nfc_card_list_cancel_tip);
        this.this$0.finish();
    }
}
