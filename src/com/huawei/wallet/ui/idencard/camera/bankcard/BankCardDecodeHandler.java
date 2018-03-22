package com.huawei.wallet.ui.idencard.camera.bankcard;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.huawei.wallet.ui.idencard.camera.base.BaseCaptureActivity;
import com.huawei.wallet.ui.idencard.camera.base.BaseOverlayView;
import com.huawei.wallet.ui.idencard.camera.base.CameraManager;
import com.huawei.wallet.ui.idencard.camera.base.DecodeHandler;
import com.huawei.wallet.utils.log.LogC;
import exocr.bankcard.EXBankCardInfo;
import exocr.bankcard.EXBankCardReco;
import exocr.exocrengine.EXOCREngine;

public class BankCardDecodeHandler extends DecodeHandler {
    private EXBankCardInfo f21532f;
    private BaseCaptureActivity f21533g;

    protected BankCardDecodeHandler(BaseCaptureActivity baseCaptureActivity) {
        super(baseCaptureActivity);
        this.f21533g = baseCaptureActivity;
        EXBankCardReco.m29917a(baseCaptureActivity.getApplicationContext());
        this.e = new EXBankCardInfo();
        if (this.e instanceof EXBankCardInfo) {
            this.f21532f = (EXBankCardInfo) this.e;
        }
    }

    private Rect m28378a(Rect rect, int i) {
        switch (i) {
            case 3:
                return new Rect(rect.top, rect.left, rect.bottom, rect.right);
            default:
                return rect;
        }
    }

    protected boolean mo5178a(byte[] bArr) {
        this.b = System.currentTimeMillis();
        if (bArr == null) {
            LogC.m28532c("onPreviewFrame frame is null! skipping", false);
            return false;
        } else if (this.c) {
            int i = CameraManager.m28405a().m28415b().m28399a().x;
            int i2 = CameraManager.m28405a().m28415b().m28399a().y;
            int b = CameraManager.m28405a().m28415b().m28402b();
            Rect a = BaseOverlayView.m28384a(true);
            if (a == null) {
                LogC.m28530b("guideRect is null.", false);
                return false;
            }
            int a2 = EXOCREngine.m29925a(this.f21533g);
            Rect a3 = m28378a(a, a2);
            this.f21532f.setCharCount(0);
            Object obj = EXBankCardReco.m29916a(bArr, i, i2, b, a3.left, a3.top, a3.right, a3.bottom) >= 3.5f ? 1 : null;
            LogC.m28530b("onPreviewFrame nativeFocusScore time==" + (System.currentTimeMillis() - this.b), false);
            if (obj == null) {
                LogC.m28530b("onPreviewFrame sufficientFocus is false! , auto focus", false);
                m28376a();
                this.c = false;
                this.d = 0;
                return false;
            }
            boolean z;
            this.d++;
            this.f21532f.setTimestart(System.currentTimeMillis());
            int[] iArr = new int[8];
            Bitmap a4 = EXBankCardReco.m29918a(bArr, i, i2, b, a3.left, a3.top, a3.right, a3.bottom, a2, this.a, this.a.length, iArr);
            this.f21532f.setTimeend(System.currentTimeMillis());
            int i3 = iArr[0];
            if (i3 <= 0 || a4 == null) {
                z = false;
            } else {
                z = EXBankCardReco.m29920a(this.a, i3, this.f21532f);
                if (z) {
                    this.f21532f.replaceBitmap(a4);
                    LogC.m28528b("dataclass", "data class replaceBitmap()", false);
                }
                LogC.m28530b("onPreviewFrame DecodeResult==" + (System.currentTimeMillis() - this.f21532f.getTimeend()), false);
            }
            if (z || this.d <= 6) {
                return z;
            }
            LogC.m28530b("onPreviewFrame frameSucceedReco >6 auto focus!", false);
            m28376a();
            this.d = 0;
            return z;
        } else {
            LogC.m28530b("onPreviewFrame flagFocused is " + this.c + "! skipping , auto focus", false);
            m28376a();
            this.d = 0;
            return false;
        }
    }
}
