package com.huawei.ui.commonui.dialog;

import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.util.TypedValue;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.TextView;
import com.huawei.nfc.carrera.ui.dialog.PayManagerSettingSwitchDialog;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.C5996c;
import com.huawei.ui.commonui.C6030g;
import com.huawei.ui.commonui.C6031h;
import com.huawei.ui.commonui.C6034k;
import com.huawei.ui.commonui.C6035l;
import com.huawei.ui.commonui.C6036m;

import java.util.Locale;

/* compiled from: SecurityManagerSettingSwitchDialog */
public class ao {
    private Context f20655a;
    private String f20656b;
    private String f20657c;
    private OnClickListener f20658d;
    private OnClickListener f20659e;
    private String f20660f = "<a href=\"http://health.vmall.com/help/mobilephone/zh-CN/index.html\"> $</a>";

    public ao(Context context) {
        this.f20655a = context;
    }

    public an m27533a() {
        Dialog anVar = new an(this.f20655a, C6035l.CustomDialog);
        View inflate = ((LayoutInflater) this.f20655a.getSystemService("layout_inflater")).inflate(C6031h.security_manager_setting_switch_dialog, null);
        TextView textView = (TextView) inflate.findViewById(C6030g.smswd_title);
        TextView textView2 = (TextView) inflate.findViewById(C6030g.smswd_message);
        String string = this.f20655a.getResources().getString(C6034k.IDS_unusual_stopped_message);
        this.f20660f = this.f20660f.replace("$", this.f20655a.getResources().getString(C6034k.IDS_unusual_stopped_message_more));
        Locale locale = Locale.getDefault();
        String language = locale.getLanguage();
        String country = locale.getCountry();
        C2538c.c(an.f20654a, new Object[]{"the language code is " + language});
        C2538c.c(an.f20654a, new Object[]{"the country code is " + country});
        if (PayManagerSettingSwitchDialog.LANGUAGE_CODE_ZH.equals(language) && PayManagerSettingSwitchDialog.COUNTRY_CODE_CN.equals(country)) {
            this.f20660f = this.f20660f.replace("zh-CN", PayManagerSettingSwitchDialog.LOCALE_ABROAD);
        }
        string = string + this.f20660f;
        C2538c.c(an.f20654a, new Object[]{"the URL is " + string});
        textView2.setText(m27521a(this.f20655a, string, anVar));
        textView2.setMovementMethod(LinkMovementMethod.getInstance());
        Button button = (Button) inflate.findViewById(C6030g.smswd_positiveButton);
        Button button2 = (Button) inflate.findViewById(C6030g.smswd_negativeButton);
        if (this.f20656b != null) {
            textView.setText(this.f20656b);
        }
        if (this.f20657c != null) {
            textView2.setText(this.f20657c);
        }
        if (this.f20658d == null) {
            button.setOnClickListener(new ap(this, anVar));
        } else {
            button.setOnClickListener(new aq(this, anVar));
        }
        if (this.f20659e == null) {
            button2.setOnClickListener(new ar(this, anVar));
        } else {
            button2.setOnClickListener(new as(this, anVar));
        }
        TypedValue typedValue = new TypedValue();
        this.f20655a.getTheme().resolveAttribute(C5996c.customDialogStyleRefer, typedValue, true);
        TypedArray obtainStyledAttributes = this.f20655a.getTheme().obtainStyledAttributes(typedValue.resourceId, C6036m.customDialogDefinition);
        TypedValue typedValue2 = new TypedValue();
        TypedValue typedValue3 = new TypedValue();
        obtainStyledAttributes.getValue(C6036m.customDialogDefinition_titleTextSize, typedValue2);
        obtainStyledAttributes.getValue(C6036m.customDialogDefinition_contentTextSize, typedValue3);
        textView.setTextSize(1, (float) ((int) TypedValue.complexToFloat(typedValue2.data)));
        textView2.setTextSize(1, (float) ((int) TypedValue.complexToFloat(typedValue3.data)));
        Drawable drawable = obtainStyledAttributes.getDrawable(C6036m.customDialogDefinition_dialogBackground);
        obtainStyledAttributes.recycle();
        inflate.setBackground(drawable);
        anVar.setContentView(inflate);
        Window window = anVar.getWindow();
        window.setGravity(80);
        Display defaultDisplay = ((WindowManager) this.f20655a.getSystemService("window")).getDefaultDisplay();
        LayoutParams attributes = window.getAttributes();
        int a = m27532a(this.f20655a, 8.0f);
        attributes.width = defaultDisplay.getWidth() - (a * 2);
        attributes.y = a;
        window.setAttributes(attributes);
        window.setWindowAnimations(C6035l.track_dialog_anim);
        return anVar;
    }

    public int m27532a(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    private void m27523b() {
        try {
            ComponentName componentName = new ComponentName("com.miui.securitycenter", "com.miui.permcenter.autostart.AutoStartManagementActivity");
            Intent intent = new Intent();
            intent.setComponent(componentName);
            this.f20655a.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            C2538c.c(an.f20654a, new Object[]{"not XIAOMI, start meizu process"});
            m27526c();
        }
    }

    private void m27526c() {
        try {
            this.f20655a.startActivity(this.f20655a.getPackageManager().getLaunchIntentForPackage("com.meizu.safe"));
        } catch (ActivityNotFoundException e) {
            C2538c.c(an.f20654a, new Object[]{"not MEIZU, start oppo process"});
            m27528d();
        } catch (Exception e2) {
            m27528d();
        }
    }

    private void m27528d() {
        try {
            ComponentName componentName = new ComponentName("com.coloros.safecenter", "com.coloros.privacypermissionsentry.PermissionTopActivity");
            Intent intent = new Intent();
            intent.setComponent(componentName);
            this.f20655a.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            C2538c.c(an.f20654a, new Object[]{"not oppo, start system setting process"});
            m27529e();
        }
    }

    private void m27529e() {
        try {
            this.f20655a.startActivity(this.f20655a.getPackageManager().getLaunchIntentForPackage("com.iqoo.secure"));
        } catch (ActivityNotFoundException e) {
            C2538c.c(an.f20654a, new Object[]{"not vivo, start system setting process"});
            m27530f();
        } catch (Exception e2) {
            m27530f();
        }
    }

    private void m27530f() {
        try {
            ComponentName componentName = new ComponentName("com.letv.android.letvsafe", "com.letv.android.letvsafe.BackgroundAppManageActivity");
            Intent intent = new Intent();
            intent.setComponent(componentName);
            this.f20655a.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            m27531g();
        }
    }

    private void m27531g() {
        try {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.parse("package:" + this.f20655a.getPackageName()));
            this.f20655a.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            C2538c.e(an.f20654a, new Object[]{"can't open system setting page. ingnored!!"});
        }
    }

    public static SpannableStringBuilder m27521a(Context context, String str, Dialog dialog) {
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
                        String url = ((URLSpan) obj).getURL();
                        spannableStringBuilder.removeSpan(obj);
                        spannableStringBuilder.setSpan(new at(dialog, context, url), spanStart, spanEnd, 17);
                    }
                }
                return spannableStringBuilder;
            }
        }
        return new SpannableStringBuilder(str);
    }
}
