package com.huawei.nfc.carrera.ui.swipe.fragment;

import android.graphics.Paint.Style;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.volley.DefaultRetryPolicy;
import com.huawei.nfc.carrera.logic.swipe.SwipeTransactionPerformer;
import com.huawei.nfc.carrera.logic.swipe.listener.SwipePerformStateListener;
import com.huawei.nfc.carrera.ui.swipe.listener.SwipeResultListener;
import com.huawei.nfc.carrera.ui.swipe.view.WaveView;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.NfcUtil;
import com.huawei.wallet.R;

public class WaitingTransactionFragment extends Fragment implements SwipePerformStateListener {
    private static final int DELAY_TIME = 300;
    private static final int DURATION = 900;
    private static final int REPEAT_COUNT = 0;
    private static final int WAVE_DURATION = 900;
    private int cardType;
    private boolean isVerifyByFinger = true;
    private Handler mHandler = new C56744();
    private WaveView mWaveViewF;
    private WaveView mWaveViewS;
    private SwipeTransactionPerformer performer;
    private TextView posTipTextView;
    private SwipeResultListener swipeResultListener;
    private ImageView unipayQuickpassView;

    class C56711 implements Runnable {
        C56711() {
        }

        public void run() {
            WaitingTransactionFragment.this.unipayQuickpassView.startAnimation(WaitingTransactionFragment.this.runAnimationSet());
            WaitingTransactionFragment.this.mWaveViewF.start();
            WaitingTransactionFragment.this.mHandler.sendEmptyMessageDelayed(0, 300);
        }
    }

    class C56722 implements AnimationListener {
        C56722() {
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
            WaitingTransactionFragment.this.unipayQuickpassView.startAnimation(WaitingTransactionFragment.this.runAnimationAgainSet());
            WaitingTransactionFragment.this.mWaveViewF.stop();
            WaitingTransactionFragment.this.mWaveViewS.stop();
        }
    }

    class C56733 implements AnimationListener {
        C56733() {
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
            WaitingTransactionFragment.this.unipayQuickpassView.startAnimation(WaitingTransactionFragment.this.runAnimationSet());
            WaitingTransactionFragment.this.mWaveViewF.start();
            WaitingTransactionFragment.this.mHandler.sendEmptyMessageDelayed(0, 300);
        }
    }

    class C56744 extends Handler {
        C56744() {
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 0) {
                WaitingTransactionFragment.this.mWaveViewS.start();
            }
        }
    }

    public WaitingTransactionFragment(boolean z, SwipeResultListener swipeResultListener) {
        this.isVerifyByFinger = z;
        this.swipeResultListener = swipeResultListener;
    }

    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (!z) {
            showAnimationSet();
            startPerListener();
        }
    }

    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (!z) {
            removePerListener();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.nfc_swipe_fragment_waiting_trade, viewGroup, false);
        this.unipayQuickpassView = (ImageView) inflate.findViewById(R.id.unipay_quickpass_view);
        initView(inflate);
        return inflate;
    }

    public void updateCardType(int i) {
        this.cardType = i;
        if (this.posTipTextView != null) {
            if (i == 2) {
                this.posTipTextView.setText(getString(R.string.nfc_swipe_wait_traffic_text));
            } else {
                this.posTipTextView.setText(getString(R.string.nfc_swipe_wait_pos_text));
            }
        }
    }

    private void initView(View view) {
        this.mWaveViewF = (WaveView) view.findViewById(R.id.waveView_1);
        this.mWaveViewS = (WaveView) view.findViewById(R.id.waveView_2);
        initWaveView(this.mWaveViewF);
        initWaveView(this.mWaveViewS);
        this.posTipTextView = (TextView) view.findViewById(R.id.nfc_swipe_tip);
        updateCardType(this.cardType);
    }

    private void initWaveView(WaveView waveView) {
        int dimension = (int) getActivity().getResources().getDimension(R.dimen.nfc_waiting_circle_radius);
        waveView.setInitialRadius(((float) dimension) * 0.2f);
        waveView.setMaxRadius(((float) dimension) * 1.7f);
        waveView.setDuration(900);
        waveView.setStyle(Style.FILL);
        waveView.setColor(-1);
        waveView.setSpeed(1);
        waveView.setInterpolator(new AccelerateInterpolator());
    }

    public void onStart() {
        super.onStart();
        LogX.i("WaitingTransactionFragment onStart");
        startPerListener();
    }

    private void startPerListener() {
        if (NfcUtil.isSupportNFCSwipe(getActivity())) {
            if (this.performer == null) {
                this.performer = new SwipeTransactionPerformer(getActivity());
            }
            this.performer.startAndAddListener(this.isVerifyByFinger, this);
            return;
        }
        LogX.i("don't support NFC swipe,don't need to startAndAddListener");
    }

    public void onResume() {
        super.onResume();
        LogX.i("WaitingTransactionFragment onResume");
        showAnimationSet();
    }

    private void showAnimationSet() {
        new Handler().post(new C56711());
    }

    public void onStop() {
        super.onStop();
        LogX.i("WaitingTransactionFragment onStop");
        removePerListener();
    }

    private void removePerListener() {
        if (this.performer != null) {
            this.performer.stopAndRemoveListener();
            this.performer = null;
        }
    }

    public void onDestroy() {
        super.onDestroy();
        LogX.i("WaitingTransactionFragment onDestroy");
    }

    public void swipePrepare(boolean z) {
        LogX.i("WaitingTransactionFragment, swipePrepare: " + z);
        if (!z && this.swipeResultListener != null) {
            this.swipeResultListener.swipeResult(2);
        }
    }

    public void swipeState(int i) {
        LogX.i("WaitingTransactionFragment, stateCode: " + i);
        if (this.swipeResultListener == null) {
            LogX.d("no need to handle the result");
        } else if (i == 0) {
            this.swipeResultListener.swipeResult(0);
        } else if (-1 == i) {
            this.swipeResultListener.swipeResult(1);
        }
    }

    public AnimationSet runAnimationSet() {
        Animation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, -20.0f);
        translateAnimation.setRepeatCount(0);
        Animation scaleAnimation = new ScaleAnimation(DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, 0.9f, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, 0.9f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setRepeatCount(0);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(scaleAnimation);
        animationSet.setDuration(900);
        animationSet.setAnimationListener(new C56722());
        return animationSet;
    }

    public AnimationSet runAnimationAgainSet() {
        Animation translateAnimation = new TranslateAnimation(0.0f, 0.0f, -20.0f, 0.0f);
        translateAnimation.setRepeatCount(0);
        Animation scaleAnimation = new ScaleAnimation(0.9f, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, 0.9f, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setRepeatCount(0);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(scaleAnimation);
        animationSet.setDuration(900);
        animationSet.setAnimationListener(new C56733());
        return animationSet;
    }
}
