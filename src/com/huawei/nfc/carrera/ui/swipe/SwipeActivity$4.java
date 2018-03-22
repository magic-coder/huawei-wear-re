package com.huawei.nfc.carrera.ui.swipe;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.huawei.nfc.carrera.logic.cardinfo.impl.NFCOpenLogic;

class SwipeActivity$4 implements OnClickListener {
    final /* synthetic */ SwipeActivity this$0;

    SwipeActivity$4(SwipeActivity swipeActivity) {
        this.this$0 = swipeActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        NFCOpenLogic.getInstance(this.this$0).setAutoOpenNFC();
        NFCOpenLogic.getInstance(this.this$0).openNFCEnvironment(this.this$0);
    }
}
