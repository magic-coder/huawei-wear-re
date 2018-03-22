package com.huawei.wallet.ui.idencard.camera.hcoincard;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.view.SurfaceHolder.Callback;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.huawei.b.f;
import com.huawei.b.g;
import com.huawei.b.h;
import com.huawei.wallet.ui.idencard.camera.base.BaseCaptureActivity;
import com.huawei.wallet.ui.idencard.camera.base.BaseCaptureActivityHandler;
import com.huawei.wallet.ui.idencard.camera.base.CardResultInfoManager;
import com.huawei.wallet.utils.log.LogC;
import exocr.base.ExBaseCardInfo;
import exocr.exocrengine.EXOCREngine;

public class HCoinCardCaptureActivity extends BaseCaptureActivity implements Callback {
    static final long[] f21589a = new long[]{0, 70, 10, 40};
    private TextView f21590f;

    class C61661 implements OnClickListener {
        final /* synthetic */ HCoinCardCaptureActivity f21587a;

        C61661(HCoinCardCaptureActivity hCoinCardCaptureActivity) {
            this.f21587a = hCoinCardCaptureActivity;
        }

        public void onClick(View view) {
            this.f21587a.m28337i();
        }
    }

    class C61672 implements Runnable {
        final /* synthetic */ HCoinCardCaptureActivity f21588a;

        C61672(HCoinCardCaptureActivity hCoinCardCaptureActivity) {
            this.f21588a = hCoinCardCaptureActivity;
        }

        public void run() {
            LogC.m28530b("CardIOActivity.nextActivity().post(Runnable)", false);
            Intent intent = new Intent(this.f21588a, HCoinCardCaptureResultActivity.class);
            intent.putExtras(this.f21588a.getIntent());
            intent.putExtra("from", "intent_card_num");
            LogC.m28528b("dataclass", "data class getNumbers()2", false);
            System.arraycopy(this.f21588a.d.getNumbers(), 0, new char[this.f21588a.d.getCharCount()], 0, this.f21588a.d.getCharCount());
            intent.putExtra("number", this.f21588a.d.getStrNumbers());
            intent.putExtra("exocr.bankcard.scanResult", this.f21588a.d);
            this.f21588a.d = null;
            this.f21588a.startActivityForResult(intent, 11);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        EXOCREngine.m29931a(getApplicationContext());
        this.e = getIntent().getStringExtra("event_callback_id");
    }

    protected void mo5167a() {
        super.mo5167a();
        m28328a(h.wallet_camera_add_hcoincard);
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onDestroy() {
        super.onDestroy();
        EXOCREngine.m29924a();
    }

    protected void mo5169b() {
        setContentView(g.hcoincard_reco_activity);
        this.f21590f = (TextView) findViewById(f.input_by_user);
        this.f21590f.setOnClickListener(new C61661(this));
    }

    protected void mo5170c() {
        super.mo5170c();
    }

    public void mo5168a(Object obj, long j) {
        LogC.m28530b("processDetections", false);
        if (obj != null && (obj instanceof ExBaseCardInfo)) {
            ExBaseCardInfo exBaseCardInfo = (ExBaseCardInfo) obj;
            try {
                ((Vibrator) getSystemService("vibrator")).vibrate(f21589a, -1);
                LogC.m28530b("onPreviewFrame Time : 10==" + (System.currentTimeMillis() - j), false);
            } catch (Throwable e) {
                LogC.m28526a("System services not available to Activities before onCreate() ", e, false);
            } catch (Throwable e2) {
                LogC.m28526a("Exception while cast to vibrate: ", e2, false);
            } catch (SecurityException e3) {
                LogC.m28534d("Could not activate vibration feedback. Please add <uses-permission android:name=\"android.permission.VIBRATE\" /> to your application's manifest.", false);
            }
            if (exBaseCardInfo.getCharCount() > 0) {
                this.d = exBaseCardInfo;
                Bitmap b = CardResultInfoManager.m28422d().m28425b();
                if (!(b == null || b.isRecycled())) {
                    b.recycle();
                }
                CardResultInfoManager.m28422d().m28426b(this.d.getBitmap());
                m28430a(j);
            }
        }
    }

    private void m28430a(long j) {
        LogC.m28530b("CardIOActivity.nextActivity()", false);
        new Handler().post(new C61672(this));
    }

    public Handler mo5171d() {
        return this.b;
    }

    public BaseCaptureActivityHandler mo5166a(BaseCaptureActivity baseCaptureActivity) {
        return new HCoinCardCaptureActivityHandler(baseCaptureActivity);
    }
}
