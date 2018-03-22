package com.huawei.nfc.carrera.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huawei.hwcommonmodel.d.d;
import com.huawei.ui.commonui.webview.WebViewActivity;
import com.huawei.p190v.C2538c;
import com.huawei.wallet.R;
import java.util.Locale;

public class PayManagerSettingSwitchDialog extends Dialog {
    public static final String COUNTRY_CODE_CN = "CN";
    public static final String LANGUAGE_CODE_ZH = "zh";
    public static final String LOCALE_ABROAD = "en-US";
    public static final String LOCALE_CHINA = "zh-CN";
    public static final String TAG = PayManagerSettingSwitchDialog.class.getSimpleName();
    private static PayManagerSettingSwitchDialog customDialog21;
    private String URL = "<a href=\"https://health.vmall.com/help/mobilephone/zh-CN/index.html\">$</a>";
    private LinearLayout addView;
    Context mContext;
    private OnClickListener negativeButtonClickListener;
    private String negativeButtonText;
    private OnClickListener positiveButtonClickListener;
    private String positiveButtonText;

    final class C56611 extends ClickableSpan {
        final /* synthetic */ Context val$context;
        final /* synthetic */ Dialog val$dialog;
        final /* synthetic */ String val$url;

        C56611(Dialog dialog, Context context, String str) {
            this.val$dialog = dialog;
            this.val$context = context;
            this.val$url = str;
        }

        public void onClick(View view) {
            this.val$dialog.dismiss();
            if (this.val$context != null) {
                PayManagerSettingSwitchDialog.startWebViewActivity(this.val$context, this.val$url, 0);
            }
        }

        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(Color.parseColor("#0D9FFB"));
            textPaint.setUnderlineText(false);
        }
    }

    public PayManagerSettingSwitchDialog(Context context, int i) {
        super(context, i);
        this.mContext = context;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public static PayManagerSettingSwitchDialog createNotice(Context context) {
        customDialog21 = new PayManagerSettingSwitchDialog(context, R.style.common_dialog21);
        customDialog21.setContentView(R.layout.commonui_notice21_message);
        return customDialog21;
    }

    public void setNoticeTitle(String str) {
        ((TextView) customDialog21.findViewById(R.id.notice_title)).setText(str);
    }

    public void setNoticeMessage(int i, int i2, String str) {
        TextView textView = (TextView) customDialog21.findViewById(R.id.notice_message);
        TextView textView2 = (TextView) customDialog21.findViewById(R.id.notice_message1);
        this.URL = this.URL.replace("$", str);
        Locale locale = Locale.getDefault();
        String language = locale.getLanguage();
        String country = locale.getCountry();
        C2538c.c(TAG, new Object[]{"the language code is " + language});
        C2538c.c(TAG, new Object[]{"the country code is " + country});
        if (LANGUAGE_CODE_ZH.equals(language) && COUNTRY_CODE_CN.equals(country)) {
            this.URL = this.URL.replace("zh-CN", LOCALE_ABROAD);
        }
        country = this.mContext.getString(i2, new Object[]{this.URL});
        textView2.setText(i);
        textView.setText(setTextLinkOpenByWebView(this.mContext, country, customDialog21));
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public static SpannableStringBuilder setTextLinkOpenByWebView(Context context, String str, Dialog dialog) {
        if (!TextUtils.isEmpty(str)) {
            Spanned fromHtml = Html.fromHtml(str);
            if (fromHtml instanceof SpannableStringBuilder) {
                SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) fromHtml;
                Object[] spans = spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), URLSpan.class);
                if (spans == null || spans.length == 0) {
                    return spannableStringBuilder;
                }
                for (Object obj : spans) {
                    int spanStart = spannableStringBuilder.getSpanStart(obj);
                    int spanEnd = spannableStringBuilder.getSpanEnd(obj);
                    if (obj instanceof URLSpan) {
                        C2538c.c("PayManagerSettingSwitchDialog", new Object[]{((URLSpan) obj).getURL()});
                        spannableStringBuilder.removeSpan(obj);
                        spannableStringBuilder.setSpan(new C56611(dialog, context, r1), spanStart, spanEnd, 17);
                    }
                }
                return spannableStringBuilder;
            }
        }
        return new SpannableStringBuilder(str);
    }

    private static void startWebViewActivity(Context context, String str, int i) {
        Intent intent = new Intent(context, WebViewActivity.class);
        intent.putExtra("WebViewActivity.REQUEST_URL_KEY", str);
        intent.putExtra("WebViewActivity.JUMP_MODE_KEY", i);
        context.startActivity(intent);
    }

    public void setPositiveButton(String str, OnClickListener onClickListener) {
        this.positiveButtonText = str;
        this.positiveButtonClickListener = onClickListener;
    }

    public void setNegativeButton(String str, OnClickListener onClickListener) {
        this.negativeButtonText = str;
        this.negativeButtonClickListener = onClickListener;
    }

    public void startNotice() {
        Button button = (Button) customDialog21.findViewById(R.id.notice_button_left);
        Button button2 = (Button) customDialog21.findViewById(R.id.notice_button_right);
        if (button != null) {
            button.setText(this.negativeButtonText);
        }
        if (button2 != null) {
            button2.setText(this.positiveButtonText);
        }
        if (!(this.positiveButtonClickListener == null || button2 == null)) {
            button2.setOnClickListener(this.positiveButtonClickListener);
        }
        if (!(this.negativeButtonClickListener == null || button == null)) {
            button.setOnClickListener(this.negativeButtonClickListener);
        }
        customDialog21.onWindowAttributesChanged(showBottom(customDialog21));
        super.show();
    }

    public static PayManagerSettingSwitchDialog createSetting(Context context) {
        customDialog21 = new PayManagerSettingSwitchDialog(context, R.style.common_dialog21);
        customDialog21.setContentView(R.layout.commonui_info21);
        return customDialog21;
    }

    public void setView(View view) {
        this.addView = (LinearLayout) customDialog21.findViewById(R.id.person_info_add_view);
        this.addView.removeAllViews();
        this.addView.addView(view);
    }

    private LayoutParams showBottom(PayManagerSettingSwitchDialog payManagerSettingSwitchDialog) {
        Window window = payManagerSettingSwitchDialog.getWindow();
        window.setGravity(80);
        window.getDecorView().setPadding(0, 0, 0, 0);
        LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        return attributes;
    }

    public void cancel() {
        super.cancel();
        d.n(this.mContext);
        this.mContext = null;
        closeCustomDialog21();
    }

    public void dismiss() {
        super.dismiss();
        d.n(this.mContext);
        this.mContext = null;
        closeCustomDialog21();
    }

    private static void closeCustomDialog21() {
        customDialog21 = null;
    }
}
