package com.huawei.nfc.carrera.ui.verifypassword.fragment;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.huawei.nfc.carrera.ui.verifypassword.listener.UserPayPasswordListener;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.pay.p130e.C5730c;
import com.huawei.pay.ui.widget.HwPayKeyBoardView;
import com.huawei.pay.ui.widget.HwPayKeyBoardView.KeyBoardOnClickListener;
import com.huawei.wallet.R;
import com.huawei.wallet.logic.bi.AppStartHianalytics;

public class UsePayPasswordFragment extends Fragment implements OnClickListener {
    private static final String FRAGMENT_TAG_VERIFY_PASSWORD = "verify_password";
    public static final String INTENT_EXTRA_CONTENT = "content";
    public static final String INTENT_EXTRA_TITLE = "title";
    private String content = "";
    private LinearLayout dialogLayout;
    private RelativeLayout inputEditAllScreenRelayout;
    private RelativeLayout keyBoardFrameLayout;
    private UserPayPasswordListener listener;
    private HwPayKeyBoardView payKeyBoardView;
    private TextView[] pwdAllScreenTxtViews;
    private StringBuilder pwdBuilder = new StringBuilder();
    private TextView[] pwdTxtViews;
    private String title = "";

    class KeyboardLisener implements KeyBoardOnClickListener {
        private KeyboardLisener() {
        }

        public void onNumKeyClick(int i) {
            if (UsePayPasswordFragment.this.pwdBuilder.length() < 6) {
                UsePayPasswordFragment.this.pwdBuilder.append(String.valueOf(i));
                UsePayPasswordFragment.this.pwdTxtViews[UsePayPasswordFragment.this.pwdBuilder.length() - 1].setBackgroundResource(R.drawable.password_normal);
                UsePayPasswordFragment.this.pwdAllScreenTxtViews[UsePayPasswordFragment.this.pwdBuilder.length() - 1].setBackgroundResource(R.drawable.password_normal);
            }
            if (UsePayPasswordFragment.this.pwdBuilder.length() == 6) {
                UsePayPasswordFragment.this.callBackPasswd(UsePayPasswordFragment.this.pwdBuilder.toString());
            }
        }

        public void onHideKeyClick() {
            UsePayPasswordFragment.this.processedKeyboradVisibilty(false);
        }

        public void onDelKeyClick() {
            if (UsePayPasswordFragment.this.pwdBuilder.length() > 0) {
                UsePayPasswordFragment.this.pwdTxtViews[UsePayPasswordFragment.this.pwdBuilder.length() - 1].setBackgroundDrawable(null);
                UsePayPasswordFragment.this.pwdAllScreenTxtViews[UsePayPasswordFragment.this.pwdBuilder.length() - 1].setBackgroundDrawable(null);
                UsePayPasswordFragment.this.pwdBuilder.deleteCharAt(UsePayPasswordFragment.this.pwdBuilder.length() - 1);
            }
        }

        public void onDelKeyLongClick() {
        }
    }

    public UsePayPasswordFragment(UserPayPasswordListener userPayPasswordListener) {
        this.listener = userPayPasswordListener;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        LogX.i("UsePayPasswordFragment, onCreateView.");
        if (getArguments() != null) {
            this.title = getArguments().getString("title");
            this.content = getArguments().getString("content");
        }
        View inflate = layoutInflater.inflate(R.layout.nfc_fragment_paypwd_dialog, viewGroup, false);
        initActivityView(inflate);
        return inflate;
    }

    private void initActivityView(View view) {
        this.dialogLayout = (LinearLayout) view.findViewById(R.id.dialog_layout);
        this.payKeyBoardView = (HwPayKeyBoardView) view.findViewById(R.id.hwpay_keyboard);
        this.keyBoardFrameLayout = (RelativeLayout) view.findViewById(R.id.key_board_framelayout);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.password_layout);
        linearLayout.setOnClickListener(this);
        this.pwdTxtViews = initPwdTextView(linearLayout);
        ((TextView) view.findViewById(R.id.forget_pwd_tx)).setVisibility(4);
        if (!TextUtils.isEmpty(this.title)) {
            ((TextView) view.findViewById(R.id.input_pwd_title_text)).setText(this.title);
        }
        if (TextUtils.isEmpty(this.content)) {
            view.findViewById(R.id.input_pwd_msg_text).setVisibility(8);
        } else {
            linearLayout = (LinearLayout) view.findViewById(R.id.input_pwd_title);
            LayoutParams layoutParams = (LayoutParams) linearLayout.getLayoutParams();
            layoutParams.height = getResources().getDimensionPixelSize(R.dimen.payPasswordInput_height_input_pwd_title_adjust);
            linearLayout.setLayoutParams(layoutParams);
            TextView textView = (TextView) view.findViewById(R.id.input_pwd_title_text);
            layoutParams = (LayoutParams) textView.getLayoutParams();
            layoutParams.topMargin = getResources().getDimensionPixelSize(R.dimen.payPasswordInput_spacing_input_pwd_title_text_to_top);
            textView.setLayoutParams(layoutParams);
            textView = (TextView) view.findViewById(R.id.input_pwd_msg_text);
            layoutParams = (LayoutParams) textView.getLayoutParams();
            layoutParams.topMargin = getResources().getDimensionPixelSize(R.dimen.payPasswordInput_spacing_input_pwd_msg_text_to_top);
            textView.setLayoutParams(layoutParams);
            textView.setVisibility(0);
            textView.setText(this.content);
        }
        ((Button) view.findViewById(R.id.button_next)).setVisibility(8);
        ((Button) view.findViewById(R.id.button_up)).setVisibility(8);
        this.pwdAllScreenTxtViews = initPwdTextView((LinearLayout) view.findViewById(R.id.all_screen_input_layout));
        this.inputEditAllScreenRelayout = (RelativeLayout) view.findViewById(R.id.input_edit_layout);
        this.payKeyBoardView.setKeyBoardListener(new KeyboardLisener());
        if (getResources().getConfiguration().orientation == 2) {
            processedKeyboradVisibilty(false);
        } else {
            processedKeyboradVisibilty(true);
        }
    }

    private TextView[] initPwdTextView(LinearLayout linearLayout) {
        if (linearLayout == null) {
            return new TextView[0];
        }
        return new TextView[]{(TextView) linearLayout.findViewById(R.id.password_n1), (TextView) linearLayout.findViewById(R.id.password_n2), (TextView) linearLayout.findViewById(R.id.password_n3), (TextView) linearLayout.findViewById(R.id.password_n4), (TextView) linearLayout.findViewById(R.id.password_n5), (TextView) linearLayout.findViewById(R.id.password_n6)};
    }

    public void onClick(View view) {
        if (view.getId() == R.id.password_layout) {
            processedKeyboradVisibilty(true);
        }
    }

    public void onResume() {
        super.onResume();
        AppStartHianalytics.m27959a(getActivity());
    }

    public void onPause() {
        super.onPause();
        AppStartHianalytics.m27958a();
    }

    private void processedKeyboradVisibilty(boolean z) {
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(getPwdDialogWidthPixel(), -2);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.payKeyBoardView.getLayoutParams();
        if (getResources().getConfiguration().orientation != 2) {
            layoutParams2.addRule(12, 0);
            layoutParams2.topMargin = 0;
            this.payKeyBoardView.setLayoutParams(layoutParams2);
            if (z) {
                setKeyBoardVisiblity(true);
                layoutParams.addRule(2, this.keyBoardFrameLayout.getId());
                layoutParams.addRule(14);
                layoutParams.bottomMargin = getResources().getDimensionPixelSize(R.dimen.payPasswordInput_spacing_dialog_layout_to_bottom);
            } else {
                setKeyBoardVisiblity(false);
                layoutParams.addRule(13);
            }
            this.dialogLayout.setVisibility(0);
            this.dialogLayout.setLayoutParams(layoutParams);
        } else if (z) {
            layoutParams2.height = C5730c.m26406a(getActivity(), (float) BitmapDescriptorFactory.HUE_BLUE);
            layoutParams2.addRule(12);
            setKeyBoardVisiblity(true);
            this.payKeyBoardView.setLayoutParams(layoutParams2);
            this.dialogLayout.setVisibility(8);
        } else {
            setKeyBoardVisiblity(false);
            layoutParams.addRule(13);
            this.dialogLayout.setLayoutParams(layoutParams);
            this.dialogLayout.setVisibility(0);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (getResources().getConfiguration().orientation == 2) {
            processedKeyboradVisibilty(false);
        } else {
            processedKeyboradVisibilty(true);
        }
    }

    private int getPwdDialogWidthPixel() {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        if (i >= i2) {
            i = i2;
        }
        return (int) (((double) i) * 0.9d);
    }

    private void setKeyBoardVisiblity(boolean z) {
        int i;
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        this.keyBoardFrameLayout.setVisibility(i);
        this.payKeyBoardView.setVisibility(i);
        this.inputEditAllScreenRelayout.setVisibility(i);
        if (getResources().getConfiguration().orientation == 1) {
            this.inputEditAllScreenRelayout.setVisibility(8);
        }
    }

    private void callBackPasswd(String str) {
        getActivity().getSupportFragmentManager().beginTransaction().remove(getActivity().getSupportFragmentManager().findFragmentByTag(FRAGMENT_TAG_VERIFY_PASSWORD)).commit();
        this.listener.getPayPassword(str);
    }

    public void onDestroy() {
        LogX.d("UsePayPasswordFragment onDestroy");
        super.onDestroy();
    }
}
