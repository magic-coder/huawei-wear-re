package com.huawei.nfc.carrera.ui.swipe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.wallet.R;
import com.huawei.wallet.utils.DisplayUtils;
import java.lang.ref.WeakReference;

public class ScanPayMiddleActivity extends Activity {
    private static final int DELAY_TIME = 750;
    private static final int FIRST_MSG_JUMP = 11;
    private static final int ON_NEW_INENT_MSG_JUMP = 12;
    private ImageView iconIv;
    private volatile boolean isJumped = false;
    private QuickPayHanlder payHandler;

    final class QuickPayHanlder extends Handler {
        private WeakReference<ScanPayMiddleActivity> weakAct;

        public QuickPayHanlder(ScanPayMiddleActivity scanPayMiddleActivity) {
            this.weakAct = new WeakReference(scanPayMiddleActivity);
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            ScanPayMiddleActivity scanPayMiddleActivity = (ScanPayMiddleActivity) this.weakAct.get();
            if (scanPayMiddleActivity == null) {
                message.getTarget().removeCallbacksAndMessages(null);
                return;
            }
            LogX.i("ScanPayMiddleActivity get the msg");
            if (message.what == 11) {
                message.getTarget().removeCallbacksAndMessages(null);
                LogX.i("ScanPayMiddleActivity get the msg :FIRST_MSG_JUMP");
                LogX.i("ScanPayMiddleActivity isJumped :" + String.valueOf(scanPayMiddleActivity.isJumped));
                if (scanPayMiddleActivity.isJumped) {
                    QuickPayUtil.getInstance().pop();
                    scanPayMiddleActivity.finish();
                    return;
                }
                LogX.i("ScanPayMiddleActivity execute FIRST_MSG_JUMP");
                scanPayMiddleActivity.jumpToSwipe(11);
                scanPayMiddleActivity.isJumped = true;
                LogX.i("ScanPayMiddleActivity isJumped :" + String.valueOf(scanPayMiddleActivity.isJumped));
            } else if (message.what == 12) {
                LogX.i("ScanPayMiddleActivity execute ON_NEW_INENT_MSG_JUMP start");
                scanPayMiddleActivity.jumpToSwipe(12);
                LogX.i("ScanPayMiddleActivity execute ON_NEW_INENT_MSG_JUMP end");
            }
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LogX.i("ScanPayMiddleActivity onCreate taskid=" + String.valueOf(getTaskId()));
        QuickPayUtil.getInstance().push(this);
        initData();
        setContentView(R.layout.scanpay_middle);
        initView();
    }

    private void initView() {
        this.iconIv = (ImageView) findViewById(R.id.icon);
        this.iconIv.setY(((float) (-DisplayUtils.m28450a(this))) / 2.0f);
        this.iconIv.setVisibility(0);
    }

    private void initData() {
        this.payHandler = new QuickPayHanlder(this);
        this.payHandler.sendEmptyMessageDelayed(11, 750);
    }

    private void jumpToSwipe(int i) {
        Intent intent = new Intent(QuickPayUtil.SCAN_ACTION);
        intent.setClass(this, SwipeActivity.class);
        intent.setFlags(65536);
        if (i == 12) {
            intent.addFlags(4194304);
        }
        startActivity(intent);
    }

    protected void onResume() {
        super.onResume();
        LogX.i("ScanPayMiddleActivity onResume taskID=" + String.valueOf(getTaskId()));
    }

    protected void onPause() {
        super.onPause();
        LogX.i("ScanPayMiddleActivity onPause taskID=" + String.valueOf(getTaskId()));
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.payHandler.sendEmptyMessageDelayed(12, 750);
        LogX.i("ScanPayMiddleActivity onNewIntent taskID=" + String.valueOf(getTaskId()));
    }

    protected void onDestroy() {
        super.onDestroy();
        LogX.i("ScanPayMiddleActivity onDestroy taskID=" + String.valueOf(getTaskId()));
        QuickPayUtil.getInstance().pop();
    }
}
