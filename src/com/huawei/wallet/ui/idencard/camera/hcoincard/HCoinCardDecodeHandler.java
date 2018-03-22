package com.huawei.wallet.ui.idencard.camera.hcoincard;

import android.graphics.Rect;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.wallet.ui.idencard.camera.base.BaseCaptureActivity;
import com.huawei.wallet.ui.idencard.camera.base.BaseOverlayView;
import com.huawei.wallet.ui.idencard.camera.base.CameraManager;
import com.huawei.wallet.ui.idencard.camera.base.DecodeHandler;
import com.huawei.wallet.utils.log.LogC;
import exocr.base.ExBaseCardInfo;
import exocr.exocrengine.EXOCREngine;
import exocr.exocrengine.EXOCardInfo;

public class HCoinCardDecodeHandler extends DecodeHandler {
    private ExBaseCardInfo f21591f = new EXOCardInfo();
    private ExBaseCardInfo f21592g = null;
    private int f21593h = 0;
    private BaseCaptureActivity f21594i;

    HCoinCardDecodeHandler(BaseCaptureActivity baseCaptureActivity) {
        super(baseCaptureActivity);
        this.f21594i = baseCaptureActivity;
    }

    private Rect m28444a(Rect rect, int i) {
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
            int a2 = EXOCREngine.m29925a(this.f21594i);
            Rect a3 = m28444a(a, a2);
            if (EXOCREngine.m29932a(bArr, i, i2, a3)) {
                this.f21591f.setTimestart(System.currentTimeMillis());
                int a4 = EXOCREngine.m29927a(bArr, i, i2, b, a3.left, a3.top, a3.right, a3.bottom, 1, a2, this.a, this.a.length);
                this.f21591f.setTimeend(System.currentTimeMillis());
                LogC.m28530b("result: " + a4, false);
                if (a4 > 0) {
                    this.f21591f = EXOCREngine.m29930a(this.a, a4, this.f21591f);
                    if (!m28445a(this.f21591f)) {
                        return false;
                    }
                    if (this.f21591f != null) {
                        this.f21591f.setBitmap(EXOCREngine.m29929a(bArr, i, i2, b, a2, a3));
                        this.e = this.f21591f;
                        return true;
                    }
                } else if (a4 == -101010) {
                    return false;
                } else {
                    this.d++;
                }
                if (this.d > 6) {
                    LogC.m28530b("onPreviewFrame frameSucceedReco >6 auto focus!", false);
                    m28376a();
                    this.d = 0;
                }
                return false;
            }
            LogC.m28530b("onPreviewFrame IsValidFrame is false! , auto focus", false);
            m28376a();
            this.c = false;
            this.d = 0;
            return false;
        } else {
            LogC.m28530b("onPreviewFrame flagFocused is " + this.c + "! skipping , auto focus", false);
            m28376a();
            this.d = 0;
            return false;
        }
    }

    boolean m28445a(ExBaseCardInfo exBaseCardInfo) {
        if (exBaseCardInfo == null) {
            this.f21591f = new EXOCardInfo();
            return false;
        } else if (exBaseCardInfo.getStrNumbers().replace(HwAccountConstants.BLANK, "").length() != 18) {
            return false;
        } else {
            if (this.f21592g == null) {
                this.f21592g = exBaseCardInfo;
                this.f21593h = 0;
                return false;
            } else if (this.f21592g.getStrNumbers().equals(exBaseCardInfo.getStrNumbers())) {
                this.f21593h = 0;
                return true;
            } else {
                this.f21592g = exBaseCardInfo;
                this.f21593h++;
                if (this.f21593h <= 5) {
                    return false;
                }
                this.f21593h = 0;
                return true;
            }
        }
    }
}
