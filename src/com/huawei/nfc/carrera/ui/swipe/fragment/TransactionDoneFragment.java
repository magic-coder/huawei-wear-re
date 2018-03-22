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

public class TransactionDoneFragment extends Fragment implements TimeoutListener {
    private static final int RESWIPE_FOBIDDEN_TIMEOUT = 3000;
    private TimeoutTimer reswipeForbiddenTimer;
    private NeedReswipeListener reswipeListener;
    private TextView swipeResultView;

    public TransactionDoneFragment(NeedReswipeListener needReswipeListener) {
        this.reswipeListener = needReswipeListener;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.nfc_swipe_fragment_trade_done, viewGroup, false);
        ((AnimationDrawable) ((ImageView) inflate.findViewById(R.id.done_circle)).getDrawable()).start();
        this.swipeResultView = (TextView) inflate.findViewById(R.id.swipe_result);
        this.swipeResultView.setVisibility(0);
        return inflate;
    }

    public void onStart() {
        super.onStart();
        LogX.i("TransactionDoneFragment onStart.");
        VibratorUtil.vibrate(getActivity().getApplicationContext(), 80);
        this.reswipeForbiddenTimer = new TimeoutTimer(RESWIPE_FOBIDDEN_TIMEOUT, this);
        this.reswipeForbiddenTimer.startTimer();
    }

    public void onPause() {
        super.onPause();
        LogX.i("TransactionDoneFragment onPause.");
    }

    public void onStop() {
        super.onStop();
        LogX.i("TransactionDoneFragment onStop.");
    }

    public void onResume() {
        super.onResume();
        LogX.i("TransactionDoneFragment onResume.");
    }

    public void timeout() {
        LogX.d("TransactionDoneFragment, allowReswipe");
        if (this.reswipeListener != null) {
            this.reswipeListener.needReswipe();
        }
    }
}
