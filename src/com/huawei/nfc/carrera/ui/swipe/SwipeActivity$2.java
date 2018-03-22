package com.huawei.nfc.carrera.ui.swipe;

import android.os.Handler;
import android.os.Message;
import com.huawei.nfc.carrera.logic.LogicApiFactory;
import com.huawei.nfc.carrera.util.LogX;

class SwipeActivity$2 extends Handler {
    final /* synthetic */ SwipeActivity this$0;

    SwipeActivity$2(SwipeActivity swipeActivity) {
        this.this$0 = swipeActivity;
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 10:
                LogX.i("queryPayableCardInfos begin");
                SwipeActivity.access$402(this.this$0, LogicApiFactory.createCardManager(this.this$0));
                SwipeActivity.access$400(this.this$0).queryPayableCardInfos(this.this$0);
                SwipeActivity.access$400(this.this$0).syncRFConfFiles(false);
                return;
            case 11:
                SwipeActivity.access$500(this.this$0);
                return;
            case 29:
                this.this$0.finish();
                return;
            default:
                return;
        }
    }
}
