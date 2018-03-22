package com.huawei.wallet.ui.idencard.camera.bankcard;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.huawei.b.f;
import com.huawei.b.g;
import com.huawei.b.h;
import com.huawei.ui.commonui.titlebar.CustomTitleBar;
import com.huawei.wallet.logic.event.EventDispatchManager;
import com.huawei.wallet.logic.event.IEventType;
import com.huawei.wallet.ui.idencard.camera.base.BaseCaptureActivity;
import com.huawei.wallet.ui.idencard.camera.base.BaseCaptureActivityHandler;
import com.huawei.wallet.ui.idencard.camera.base.CardResultInfoManager;
import com.huawei.wallet.utils.log.LogC;
import exocr.base.ExBaseCardInfo;

public class BankCardCaptureActivity extends BaseCaptureActivity {
    static final long[] f21511a = new long[]{0, 70, 10, 40};
    private TextView f21512f;
    private CustomTitleBar f21513g;

    class C61611 implements OnClickListener {
        final /* synthetic */ BankCardCaptureActivity f21502a;

        C61611(BankCardCaptureActivity bankCardCaptureActivity) {
            this.f21502a = bankCardCaptureActivity;
        }

        public void onClick(View view) {
            this.f21502a.m28337i();
        }
    }

    class C61622 implements Runnable {
        final /* synthetic */ BankCardCaptureActivity f21503a;

        C61622(BankCardCaptureActivity bankCardCaptureActivity) {
            this.f21503a = bankCardCaptureActivity;
        }

        public void run() {
            LogC.m28530b("CardIOActivity.nextActivity().post(Runnable)", false);
            Intent intent = new Intent();
            intent.putExtras(this.f21503a.getIntent());
            intent.putExtra("from", "intent_card_num");
            System.arraycopy(this.f21503a.d.getNumbers(), 0, new char[this.f21503a.d.getCharCount()], 0, this.f21503a.d.getCharCount());
            intent.putExtra("exocr.bankcard.scanResult", this.f21503a.d.getStrNumbers());
            this.f21503a.d = null;
            this.f21503a.setResult(13274385, intent);
            CardResultInfoManager.m28422d().m28427c();
            EventDispatchManager.m28051a().m28056a(this.f21503a.e, IEventType.TYPE_CAMERA_IDENTIFY_CARD, intent);
            EventDispatchManager.m28051a().m28054a(this.f21503a.e);
            this.f21503a.finish();
        }
    }

    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.e = intent.getStringExtra("event_callback_id");
        }
        super.onCreate(bundle);
    }

    protected void mo5167a() {
        super.mo5167a();
        this.f21513g = (CustomTitleBar) findViewById(f.card_reco_title_bar);
        this.f21513g.setTitleText(getString(h.wallet_camera_add_bankcard));
    }

    protected void onPause() {
        super.onPause();
    }

    protected void mo5169b() {
        setContentView(g.card_reco_activity);
        this.f21512f = (TextView) findViewById(f.input_by_user);
        this.f21512f.setOnClickListener(new C61611(this));
    }

    protected void mo5170c() {
        super.mo5170c();
    }

    public BaseCaptureActivityHandler mo5166a(BaseCaptureActivity baseCaptureActivity) {
        return new BankCardCaptureActivityHandler(baseCaptureActivity);
    }

    public Handler mo5171d() {
        return this.b;
    }

    public void mo5168a(Object obj, long j) {
        LogC.m28530b("processDetections", false);
        if (obj != null && (obj instanceof ExBaseCardInfo)) {
            ExBaseCardInfo exBaseCardInfo = (ExBaseCardInfo) obj;
            try {
                ((Vibrator) getSystemService("vibrator")).vibrate(f21511a, -1);
                LogC.m28530b("onPreviewFrame Time : 10==" + (System.currentTimeMillis() - j), false);
            } catch (Throwable e) {
                LogC.m28526a("System services not available to Activities before onCreate() ", e, false);
            } catch (Throwable e2) {
                LogC.m28526a("Exception while cast to vibrate: ", e2, false);
            } catch (SecurityException e3) {
                LogC.m28534d("Could not activate vibration feedback. Please add <uses-permission android:name=\"android.permission.VIBRATE\" /> to your application's manifest.", false);
            } catch (Throwable e22) {
                LogC.m28529b("onCardDetected() error: no class def found error", e22, false);
            }
            if (exBaseCardInfo.getCharCount() > 0) {
                this.d = exBaseCardInfo;
                Bitmap a = CardResultInfoManager.m28422d().m28423a();
                if (!(a == null || a.isRecycled())) {
                    a.recycle();
                }
                CardResultInfoManager.m28422d().m28424a(this.d.getBitmap());
                m28339a(j);
            }
        }
    }

    private void m28339a(long j) {
        LogC.m28530b("CardIOActivity.nextActivity()", false);
        new Handler().post(new C61622(this));
    }

    protected boolean mo5172e() {
        return false;
    }
}
