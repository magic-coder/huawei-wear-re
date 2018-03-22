package com.huawei.nfc.carrera.ui.identifycard;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.nfc.NfcAdapter;
import android.nfc.tech.IsoDep;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import com.android.volley.DefaultRetryPolicy;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.pay.p130e.p489b.C5728a;
import com.huawei.pay.ui.baseactivity.BaseActivity;
import com.huawei.wallet.R;
import com.huawei.wallet.logic.tlv.TlvParserUtil;

public class TagReadCardNumActivity extends BaseActivity {
    public static final String EXTRA_READ_RESULT_CARD_NUMBER = "nfc_tag_read_card_result_card_number";
    public static final String EXTRA_READ_RESULT_VALIDITY = "nfc_tag_read_card_result_validity";
    private final String TAG = "CardReaderActivity";
    IntentFilter[] intentFilter = null;
    private NfcAdapter nfcAdapter;
    private ImageView nfcReadCardNumberImageCard;
    private ImageView nfcReadCardNumberImagePhone;
    PendingIntent pendingIntent = null;
    String[][] techList = ((String[][]) null);

    class C56621 implements AnimationListener {
        C56621() {
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
            TagReadCardNumActivity.this.showReadCardAnimationBack();
        }
    }

    class C56632 implements AnimationListener {
        C56632() {
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
            TagReadCardNumActivity.this.showReadCardAnimation();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRequestedOrientation(1);
        setContentView(R.layout.nfc_activity_tag_read_card_num);
        showHead(R.string.nfc_read_card_title);
        this.nfcReadCardNumberImageCard = (ImageView) findViewById(R.id.nfc_read_card_number_image_card);
        this.nfcReadCardNumberImagePhone = (ImageView) findViewById(R.id.nfc_read_card_number_image_phone);
        LogX.d("CardReaderActivity", "onCreate");
        this.pendingIntent = PendingIntent.getActivity(this, 0, new Intent(this, getClass()).addFlags(536870912), 0);
        try {
            new IntentFilter("android.nfc.action.TECH_DISCOVERED").addDataType("*/*");
        } catch (Throwable e) {
            LogX.e("fail : " + Log.getStackTraceString(e));
        }
        this.intentFilter = new IntentFilter[]{r1};
        String[][] strArr = new String[1][];
        strArr[0] = new String[]{IsoDep.class.getName()};
        this.techList = strArr;
        this.nfcAdapter = NfcAdapter.getDefaultAdapter(this);
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        LogX.d("CardReaderActivity", "onNewIntent");
        if ("android.nfc.action.TECH_DISCOVERED".equals(intent.getAction())) {
            readCardNumber(intent);
        }
    }

    private void readCardNumber(Intent intent) {
        String a = TlvParserUtil.m28089a(intent);
        if (a == null) {
            LogX.d("CardReaderActivity", "onNewIntent.number is null");
        } else {
            completed(a);
        }
    }

    public void onPause() {
        super.onPause();
        LogX.d("CardReaderActivity", "onPause");
        if (this.nfcAdapter != null) {
            this.nfcAdapter.disableForegroundDispatch(this);
        }
    }

    protected void onResume() {
        super.onResume();
        showReadCardAnimation();
        LogX.d("CardReaderActivity", "onResume");
        if (this.nfcAdapter != null) {
            this.nfcAdapter.enableForegroundDispatch(this, this.pendingIntent, this.intentFilter, this.techList);
        }
    }

    private void completed(String str) {
        Intent intent = new Intent();
        intent.putExtra(EXTRA_READ_RESULT_CARD_NUMBER, C5728a.m26402a(str, getApplicationContext()));
        setResult(-1, intent);
        finish();
    }

    private void showReadCardAnimation() {
        Animation animationSet = new AnimationSet(true);
        Animation translateAnimation = new TranslateAnimation(0.0f, 52.0f, 0.0f, -20.0f);
        Animation scaleAnimation = new ScaleAnimation(DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, 1.05f, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, 1.05f, 1, 0.5f, 1, 0.5f);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(scaleAnimation);
        animationSet.setDuration(500);
        animationSet.setFillAfter(true);
        translateAnimation.setAnimationListener(new C56621());
        translateAnimation = new AnimationSet(true);
        Animation translateAnimation2 = new TranslateAnimation(0.0f, -32.0f, 0.0f, 8.0f);
        scaleAnimation = new ScaleAnimation(DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, 0.95f, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, 0.95f, 1, 0.5f, 1, 0.5f);
        translateAnimation.addAnimation(translateAnimation2);
        translateAnimation.addAnimation(scaleAnimation);
        translateAnimation.setDuration(500);
        translateAnimation.setFillAfter(true);
        this.nfcReadCardNumberImageCard.startAnimation(animationSet);
        this.nfcReadCardNumberImagePhone.startAnimation(translateAnimation);
    }

    private void showReadCardAnimationBack() {
        Animation animationSet = new AnimationSet(true);
        Animation translateAnimation = new TranslateAnimation(52.0f, 0.0f, -20.0f, 0.0f);
        Animation scaleAnimation = new ScaleAnimation(1.05f, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, 1.05f, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, 1, 0.5f, 1, 0.5f);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(scaleAnimation);
        animationSet.setStartOffset(500);
        animationSet.setDuration(500);
        animationSet.setFillAfter(true);
        translateAnimation.setAnimationListener(new C56632());
        translateAnimation = new AnimationSet(true);
        Animation translateAnimation2 = new TranslateAnimation(-32.0f, 0.0f, 8.0f, 0.0f);
        scaleAnimation = new ScaleAnimation(0.95f, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, 0.95f, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, 1, 0.5f, 1, 0.5f);
        translateAnimation.addAnimation(translateAnimation2);
        translateAnimation.addAnimation(scaleAnimation);
        translateAnimation.setStartOffset(500);
        translateAnimation.setDuration(500);
        translateAnimation.setFillAfter(true);
        this.nfcReadCardNumberImageCard.startAnimation(animationSet);
        this.nfcReadCardNumberImagePhone.startAnimation(translateAnimation);
    }
}
