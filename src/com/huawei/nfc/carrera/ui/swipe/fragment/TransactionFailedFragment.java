package com.huawei.nfc.carrera.ui.swipe.fragment;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.nfc.carrera.logic.util.timeout.TimeoutListener;
import com.huawei.nfc.carrera.logic.util.timeout.TimeoutTimer;
import com.huawei.nfc.carrera.ui.swipe.listener.NeedReswipeListener;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.VibratorUtil;
import com.huawei.wallet.R;

public class TransactionFailedFragment extends Fragment implements TimeoutListener {
    private static final int RESWIPE_FOBIDDEN_TIMEOUT = 3000;
    private NeedReswipeListener restartListener;
    private TimeoutTimer reswipeForbiddenTimer;
    private TextView swipeResultView;

    public TransactionFailedFragment(NeedReswipeListener needReswipeListener) {
        this.restartListener = needReswipeListener;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.nfc_swipe_fragment_trade_failed, viewGroup, false);
        ((AnimationDrawable) ((ImageView) inflate.findViewById(R.id.done_ok)).getDrawable()).start();
        this.swipeResultView = (TextView) inflate.findViewById(R.id.swipe_result);
        this.swipeResultView.setTextColor(getActivity().getResources().getColor(R.color.finger_tips_txt_color));
        this.swipeResultView.setText(R.string.nfc_swipe_done_alert_text_failed);
        return inflate;
    }

    public void onStart() {
        super.onStart();
        LogX.i("TransactionFailedFragment onStart.");
        VibratorUtil.vibrate(getActivity().getApplicationContext(), 80);
        this.reswipeForbiddenTimer = new TimeoutTimer(RESWIPE_FOBIDDEN_TIMEOUT, this);
        this.reswipeForbiddenTimer.startTimer();
    }

    public void onStop() {
        super.onStop();
        LogX.i("TransactionFailedFragment onStop.");
        if (this.reswipeForbiddenTimer != null) {
            this.reswipeForbiddenTimer.stopTimer();
        }
        LogX.d("TransactionFailedFragment, allowReswipe");
        if (this.restartListener != null) {
            this.restartListener.needReswipe();
        }
    }

    public void onPause() {
        super.onPause();
        LogX.i("TransactionFailedFragment onPause.");
    }

    public void onResume() {
        super.onResume();
        LogX.i("TransactionFailedFragment onResume.");
    }

    public void timeout() {
        LogX.d("TransactionFailedFragment, allowReswipe");
        if (this.restartListener != null) {
            this.restartListener.needReswipe();
        }
    }
}
