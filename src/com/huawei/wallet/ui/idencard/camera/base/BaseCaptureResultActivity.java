package com.huawei.wallet.ui.idencard.camera.base;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huawei.b.b;
import com.huawei.b.c;
import com.huawei.b.f;
import com.huawei.b.g;
import com.huawei.crowdtestsdk.httpaccess.HttpStatus;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.ui.commonui.base.BaseActivity;
import com.huawei.wallet.utils.UIUtil;
import com.huawei.wallet.utils.log.LogC;
import java.util.regex.Pattern;

public class BaseCaptureResultActivity extends BaseActivity {
    String f21518a = "";
    int f21519b;
    int f21520c;
    float f21521d;
    LinearLayout f21522e;
    protected Bitmap f21523f;

    class C61641 implements OnClickListener {
        final /* synthetic */ BaseCaptureResultActivity f21564a;

        C61641(BaseCaptureResultActivity baseCaptureResultActivity) {
            this.f21564a = baseCaptureResultActivity;
        }

        public void onClick(View view) {
            this.f21564a.m28368e();
        }
    }

    protected void onCreate(Bundle bundle) {
        Object stringExtra;
        String stringExtra2;
        super.onCreate(bundle);
        if (mo5176a()) {
            UIUtil.m28490b(this);
        }
        setContentView(g.ocr_result);
        ImageView imageView = (ImageView) findViewById(f.card_num_image);
        Intent intent = getIntent();
        if (intent != null) {
            try {
                stringExtra = intent.getStringExtra("from");
                stringExtra2 = intent.getStringExtra("number");
            } catch (RuntimeException e) {
                stringExtra = "";
                stringExtra2 = "";
            }
        } else {
            stringExtra = "";
            stringExtra2 = "";
        }
        if ("intent_card_num".equals(stringExtra)) {
            this.f21518a = stringExtra2;
            imageView.setImageBitmap(this.f21523f);
        } else {
            if (stringExtra2 != null) {
                this.f21518a = m28363b(stringExtra2);
            }
            int[] iArr = null;
            if (intent != null) {
                iArr = intent.getIntArrayExtra("PicR");
            }
            if (iArr != null) {
                imageView.setImageBitmap(Bitmap.createBitmap(iArr, HttpStatus.SC_BAD_REQUEST, 80, Config.ARGB_8888));
            }
        }
        this.f21522e = (LinearLayout) findViewById(f.edit_text_group);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.f21520c = displayMetrics.widthPixels;
        this.f21521d = displayMetrics.density;
        m28365c();
        LogC.m28530b("editGroup width " + this.f21522e.getWidth(), false);
        m28367d();
    }

    protected void onResume() {
        super.onResume();
        LogC.m28530b("ResultActivity : onResume", false);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (16908332 == menuItem.getItemId()) {
            m28374b();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    protected void m28374b() {
        finish();
    }

    protected final void m28371a(int i) {
        m28372a(getString(i));
    }

    protected final void m28372a(String str) {
    }

    private String m28363b(String str) {
        int length = str.length() - 1;
        while (length >= 0) {
            if (m28361a(str.charAt(length))) {
                break;
            }
            length--;
        }
        length = 0;
        return str.substring(0, length + 1);
    }

    private static boolean m28361a(char c) {
        return Pattern.compile("[0-9]{1}").matcher(c + "").matches();
    }

    protected void onDestroy() {
        super.onDestroy();
        LogC.m28530b("ResultActivity : onDestroy", false);
    }

    private void m28365c() {
        String[] split = this.f21518a.split("\\s");
        this.f21519b = split.length;
        if (1 == this.f21519b) {
            this.f21518a = m28364c(this.f21518a);
            split = this.f21518a.split("\\s");
            this.f21519b = split.length;
        }
        if (this.f21522e != null) {
            for (int i = 0; i < this.f21519b; i++) {
                this.f21522e.addView(m28359a(i, split[i]));
                if (i != this.f21519b - 1) {
                    this.f21522e.addView(m28369f());
                }
            }
        }
        ((Button) findViewById(f.next_button)).setOnClickListener(new C61641(this));
    }

    private void m28367d() {
        if (getResources().getBoolean(b.IsSupportOrientation)) {
            UIUtil.m28488a(this, (ViewGroup) findViewById(f.orc_result_layout), true);
            UIUtil.m28487a(this, findViewById(f.ocr_bottom_layout));
        }
    }

    private void m28368e() {
        Intent intent = new Intent();
        intent.putExtra("exocr.bankcard.scanResult", m28370g());
        setResult(13274385, intent);
        finish();
    }

    private View m28369f() {
        View textView = new TextView(this);
        textView.setBackgroundColor(getResources().getColor(c.line_bottom_color));
        textView.setWidth(1);
        textView.setHeight((int) (12.0f * this.f21521d));
        return textView;
    }

    private View m28359a(int i, String str) {
        View editText = new EditText(this);
        editText.setGravity(17);
        editText.setBackgroundDrawable(null);
        editText.setId(m28362b(i));
        editText.setText(str);
        editText.setInputType(2);
        editText.setTextSize(15.0f);
        editText.setPadding(14, 0, 14, 0);
        editText.setTextColor(getResources().getColor(c.white_color));
        editText.setLayoutParams(new LayoutParams(m28366d(str), -1));
        return editText;
    }

    private String m28364c(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        while (str.length() >= 4) {
            stringBuilder.append(str.substring(0, 4) + HwAccountConstants.BLANK);
            str = str.substring(4);
        }
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    private String m28370g() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < this.f21519b; i++) {
            stringBuilder.append(((EditText) findViewById(m28362b(i))).getText());
            if (i != this.f21519b - 1) {
                stringBuilder.append("");
            }
        }
        return stringBuilder.toString();
    }

    private int m28366d(String str) {
        int length = str.length();
        int i = (this.f21520c - ((int) (36.0f * this.f21521d))) - ((this.f21519b - 1) * 1);
        if ((this.f21518a.length() - this.f21519b) + 1 != 0) {
            length *= i / ((this.f21518a.length() - this.f21519b) + 1);
        } else {
            length = 0;
        }
        LogC.m28530b("sectionWidth==== " + length, false);
        return length;
    }

    private int m28362b(int i) {
        switch (i + 1) {
            case 1:
                return f.edit_id_1;
            case 2:
                return f.edit_id_2;
            case 3:
                return f.edit_id_3;
            case 4:
                return f.edit_id_4;
            case 5:
                return f.edit_id_5;
            case 6:
                return f.edit_id_6;
            case 7:
                return f.edit_id_7;
            default:
                return f.edit_id_8;
        }
    }

    protected boolean mo5176a() {
        return true;
    }
}
