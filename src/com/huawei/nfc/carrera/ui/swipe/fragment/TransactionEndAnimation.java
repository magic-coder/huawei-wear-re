package com.huawei.nfc.carrera.ui.swipe.fragment;

import android.os.Handler;
import android.os.Message;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import com.android.volley.DefaultRetryPolicy;
import com.huawei.nfc.carrera.util.LogX;

class TransactionEndAnimation {
    private static final int TRADE_CARD_SUCCESS = 1;
    private static final int TRADE_SUCCESS = 2;
    private static final int TRADE_SUCCESS_END = 3;
    private ImageView doneCircle;
    private ImageView doneOk;
    private Handler handler = new C56703();
    private ImageView nfctradeCardSuccessBg;
    private ImageView nfctradeCardSuccessFg;

    class C56681 implements AnimationListener {
        C56681() {
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
            TransactionEndAnimation.this.handler.sendEmptyMessage(2);
        }
    }

    class C56692 implements AnimationListener {
        C56692() {
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
            TransactionEndAnimation.this.handler.sendEmptyMessage(3);
        }
    }

    class C56703 extends Handler {
        C56703() {
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    TransactionEndAnimation.this.nfctradeCardSuccessBg.setVisibility(0);
                    TransactionEndAnimation.this.nfctradeCardSuccessBg.startAnimation(TransactionEndAnimation.this.getBindCardSuccessSmallScaleAnimation());
                    TransactionEndAnimation.this.nfctradeCardSuccessFg.setVisibility(0);
                    TransactionEndAnimation.this.nfctradeCardSuccessFg.startAnimation(TransactionEndAnimation.this.gettradeCardSuccessBigScaleAnimation());
                    return;
                case 2:
                    TransactionEndAnimation.this.nfctradeCardSuccessBg.setVisibility(8);
                    TransactionEndAnimation.this.nfctradeCardSuccessFg.setVisibility(4);
                    TransactionEndAnimation.this.doneCircle.setVisibility(0);
                    TransactionEndAnimation.this.doneOk.setVisibility(0);
                    TransactionEndAnimation.this.doneOk.startAnimation(TransactionEndAnimation.this.gettradeSuccessAnimation());
                    return;
                case 3:
                    TransactionEndAnimation.this.doneCircle.clearAnimation();
                    TransactionEndAnimation.this.doneCircle.setAnimation(null);
                    TransactionEndAnimation.this.doneCircle.setVisibility(8);
                    TransactionEndAnimation.this.doneOk.clearAnimation();
                    TransactionEndAnimation.this.doneOk.setAnimation(null);
                    TransactionEndAnimation.this.doneOk.setVisibility(8);
                    TransactionEndAnimation.this.nfctradeCardSuccessFg.setVisibility(0);
                    return;
                default:
                    LogX.d("TransactionTimeoutFragment unknow msg what : " + message.what);
                    return;
            }
        }
    }

    TransactionEndAnimation(ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4) {
        this.nfctradeCardSuccessBg = imageView;
        this.nfctradeCardSuccessFg = imageView2;
        this.doneCircle = imageView3;
        this.doneOk = imageView4;
    }

    void show() {
        this.nfctradeCardSuccessBg.setVisibility(0);
        this.nfctradeCardSuccessBg.startAnimation(getBindCardSuccessSmallScaleAnimation());
        this.nfctradeCardSuccessFg.setVisibility(0);
        this.nfctradeCardSuccessFg.startAnimation(gettradeCardSuccessBigScaleAnimation());
    }

    private Animation gettradeCardSuccessBigScaleAnimation() {
        Animation scaleAnimation = new ScaleAnimation(0.2f, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, 0.2f, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(316);
        scaleAnimation.setAnimationListener(new C56681());
        return scaleAnimation;
    }

    private Animation gettradeSuccessAnimation() {
        Animation scaleAnimation = new ScaleAnimation(DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, 1.2f, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, 1.2f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(133);
        scaleAnimation.setRepeatCount(0);
        scaleAnimation.setAnimationListener(new C56692());
        return scaleAnimation;
    }

    private Animation getBindCardSuccessSmallScaleAnimation() {
        Animation scaleAnimation = new ScaleAnimation(DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, 0.0f, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, 0.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(116);
        return scaleAnimation;
    }
}
