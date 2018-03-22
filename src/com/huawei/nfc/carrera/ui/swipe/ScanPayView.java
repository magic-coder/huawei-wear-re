package com.huawei.nfc.carrera.ui.swipe;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.alipay.p238a.p239a.p240a.C3139a;
import com.alipay.p238a.p239a.p240a.p241a.p242a.C3135b;
import com.huawei.nfc.carrera.constant.AutoReportErrorCode;
import com.huawei.nfc.carrera.logic.swipe.SwipeLogicManager;
import com.huawei.nfc.carrera.ui.bus.exception.ShowBindBusResultActivity;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.wallet.R;
import com.huawei.wallet.utils.StringUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

@SuppressLint({"NewApi"})
public class ScanPayView extends LinearLayout implements OnClickListener {
    public static final String ALI_PACKAGENAME = "com.eg.android.AlipayGphone";
    public static final String WEIXIN_PACKAGENAME = "com.tencent.mm";
    private ImageButton btn_alipay;
    private Context mContext;
    private RelativeLayout scanPayRelativeLayout;
    private View scanView;
    private List<String> supportPay;

    class C56651 extends Thread {
        C56651() {
        }

        public void run() {
            LogX.i("jump To alipay with thread");
            JSONObject jSONObject = new JSONObject();
            try {
                C3139a.m13972a().m13974a(100);
                jSONObject.put(QuickPayUtil.STR_SOURCE_PKG_PARAM, "com.huawei.wallet");
                LogX.i("jsonObject is :" + jSONObject);
                ScanPayView.this.dealErrorCode(C3139a.m13972a().m13973a(ScanPayView.this.mContext, jSONObject.toString()));
            } catch (Throwable e) {
                LogX.e("jumpToAlipay()", e);
            }
        }
    }

    public ScanPayView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.supportPay = new ArrayList();
        this.mContext = context;
        this.scanView = LayoutInflater.from(context).inflate(R.layout.scanpayview, null);
        addView(this.scanView);
    }

    public ScanPayView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public ScanPayView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0);
    }

    public ScanPayView(Context context) {
        this(context, null, 0, 0);
    }

    public void setData(List<String> list) {
        initView(this.scanView, list);
    }

    private void initView(View view, List<String> list) {
        this.supportPay.clear();
        this.supportPay.addAll(list);
        this.scanPayRelativeLayout = (RelativeLayout) view.findViewById(R.id.swipe_scanpay);
        this.btn_alipay = (ImageButton) view.findViewById(R.id.swipe_taobao);
        this.btn_alipay.setOnClickListener(this);
        this.btn_alipay.setTag("com.eg.android.AlipayGphone");
        if (list.isEmpty()) {
            this.scanPayRelativeLayout.setVisibility(8);
        } else if (list.contains("com.eg.android.AlipayGphone")) {
            this.btn_alipay.setVisibility(0);
        } else {
            this.btn_alipay.setVisibility(8);
        }
    }

    public void onClick(View view) {
        String str = (String) view.getTag();
        if ("com.eg.android.AlipayGphone".equals(str)) {
            jumpToAlipay();
        } else if (!"com.tencent.mm".equals(str)) {
            LogX.e("No this payment");
        }
    }

    private void jumpToAlipay() {
        Thread c56651 = new C56651();
        if (!c56651.isAlive()) {
            c56651.start();
            SwipeLogicManager.getInstance(this.mContext).reportBIOnScanPayment("com.eg.android.AlipayGphone");
        }
    }

    private void dealErrorCode(C3135b c3135b) {
        String b = c3135b.m13963b();
        c3135b.m13962a();
        LogX.i("alipay retInfo = " + c3135b.m13962a());
        LogX.i("jump to alipay thread is finished");
        if (!StringUtil.m28479a(b, false)) {
            Map hashMap = new HashMap();
            hashMap.put(ShowBindBusResultActivity.FAIL_REASON_KEY, b);
            hashMap.put("faild_code", c3135b.toString());
            LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_SCANPAY_JUMP_ALIPAY_FAIL, hashMap, b, false, false);
        }
    }
}
