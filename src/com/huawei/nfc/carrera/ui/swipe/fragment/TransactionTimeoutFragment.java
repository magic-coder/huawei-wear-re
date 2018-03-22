package com.huawei.nfc.carrera.ui.swipe.fragment;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.nfc.carrera.ui.swipe.listener.NeedReswipeListener;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.VibratorUtil;
import com.huawei.wallet.R;

public class TransactionTimeoutFragment extends Fragment {
    private TextView alertTextView;
    private NeedReswipeListener restartListener;
    private TextView swipeResultView;

    public TransactionTimeoutFragment(NeedReswipeListener needReswipeListener) {
        this.restartListener = needReswipeListener;
    }

    public void onStart() {
        super.onStart();
        LogX.i("TransactionTimeoutFragment onStart.");
        VibratorUtil.vibrate(getActivity().getApplicationContext(), 80);
    }

    public void onResume() {
        super.onResume();
        LogX.i("TransactionTimeoutFragment onResume.");
        LogX.d("TransactionTimeoutFragment allowReswipe.");
        if (this.restartListener != null) {
            this.restartListener.needReswipe();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.nfc_swipe_fragment_trade_failed, viewGroup, false);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.done_ok);
        this.swipeResultView = (TextView) inflate.findViewById(R.id.swipe_result);
        this.swipeResultView.setTextColor(getActivity().getResources().getColor(R.color.finger_tips_txt_color));
        this.alertTextView = (TextView) inflate.findViewById(R.id.nfc_swipe_done_alert_text);
        this.swipeResultView.setText(R.string.nfc_swipe_done_alert_text_timeout);
        this.alertTextView.setVisibility(8);
        ((AnimationDrawable) imageView.getDrawable()).start();
        return inflate;
    }
}
