package com.huawei.ui.main.stories.settings.activity;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.TextAppearanceSpan;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.base.BaseActivity;
import com.huawei.ui.main.d;
import com.huawei.ui.main.f;
import com.huawei.ui.main.g;
import com.huawei.ui.main.j;

public class ClearUpStorageActivity extends BaseActivity {
    private ProgressBar f8889a;
    private View f8890b;
    private TextView f8891c;
    private View f8892d;
    private TextView f8893e;
    private TextView f8894f;
    private ImageView f8895g;
    private View f8896h;
    private Button f8897i;
    private View f8898j;
    private TextView f8899k;
    private String f8900l = "";

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(g.activity_clearup_storage);
        C2538c.m12674b("ClearUpStorageActivity", "onCreate()");
        m12338a();
        m12340b();
    }

    protected void onDestroy() {
        super.onDestroy();
        C2538c.m12674b("ClearUpStorageActivity", "onDestroy()");
    }

    private void m12338a() {
        C2538c.m12674b("ClearUpStorageActivity", "Enter initView!");
        this.f8890b = findViewById(f.center_layout);
        this.f8889a = (ProgressBar) findViewById(f.check_progress_bar);
        this.f8891c = (TextView) findViewById(f.tv_app_circle_text);
        this.f8892d = findViewById(f.panel_mutile_content);
        this.f8893e = (TextView) findViewById(f.tv_tip_one_textview);
        this.f8894f = (TextView) findViewById(f.tv_tip_two_textview);
        this.f8895g = (ImageView) findViewById(f.iv_clear_over_icon);
        this.f8896h = findViewById(f.pannel_clear_view);
        this.f8897i = (Button) findViewById(f.clear_button);
        this.f8898j = findViewById(f.panel_not_litter);
        this.f8899k = (TextView) findViewById(f.tv_not_litter_text);
    }

    private void m12340b() {
        C2538c.m12674b("ClearUpStorageActivity", "findRubbishSpaceSize()");
        m12339a(100);
    }

    private void m12339a(int i) {
        C2538c.m12674b("ClearUpStorageActivity", "updateClearUpUI state = " + i);
        ColorStateList valueOf;
        CharSequence spannableStringBuilder;
        switch (i) {
            case 100:
                this.f8890b.setVisibility(0);
                this.f8889a.setVisibility(0);
                this.f8891c.setText(j.IDS_social_clearup_storage_scaning);
                this.f8892d.setVisibility(8);
                this.f8896h.setVisibility(4);
                this.f8898j.setVisibility(8);
                return;
            case 101:
                if (this.f8900l.isEmpty()) {
                    this.f8890b.setVisibility(8);
                    this.f8889a.setVisibility(8);
                    this.f8891c.setText(j.IDS_social_clearup_storage_scaning);
                    this.f8892d.setVisibility(8);
                    this.f8896h.setVisibility(4);
                    this.f8898j.setVisibility(0);
                    this.f8899k.setText(j.IDS_social_clearup_storage_no_temporary_file);
                    return;
                }
                this.f8890b.setVisibility(0);
                this.f8889a.setVisibility(8);
                this.f8891c.setVisibility(8);
                this.f8892d.setVisibility(0);
                this.f8895g.setVisibility(8);
                valueOf = ColorStateList.valueOf(-671088640);
                String replace = this.f8900l.replace(HwAccountConstants.BLANK, "");
                spannableStringBuilder = new SpannableStringBuilder(replace);
                C2538c.m12674b("ClearUpStorageActivity", "updateClearUpUI SCAN_STORAGE_FINISH tepSizeStr = " + replace + " tepTextSize = " + ((int) getResources().getDimension(d.clear_up_circle_big_text_size)));
                spannableStringBuilder.setSpan(new TextAppearanceSpan(null, 0, r3, valueOf, null), 0, replace.length() - 2, 34);
                this.f8893e.setText(spannableStringBuilder);
                this.f8894f.setText(j.IDS_social_clearup_storage_clear_temporary_file);
                this.f8896h.setVisibility(0);
                this.f8897i.setText(j.IDS_social_clearup_storage_button_text);
                this.f8898j.setVisibility(8);
                return;
            case 110:
                this.f8890b.setVisibility(0);
                this.f8889a.setVisibility(0);
                this.f8891c.setVisibility(8);
                this.f8892d.setVisibility(0);
                this.f8895g.setVisibility(8);
                valueOf = ColorStateList.valueOf(-671088640);
                Object replace2 = this.f8900l.replace(HwAccountConstants.BLANK, "");
                spannableStringBuilder = new SpannableStringBuilder(replace2);
                spannableStringBuilder.setSpan(new TextAppearanceSpan(null, 0, (int) getResources().getDimension(d.clear_up_circle_big_text_size), valueOf, null), 0, replace2.length() - 2, 34);
                this.f8893e.setText(spannableStringBuilder);
                C2538c.m12674b("ClearUpStorageActivity", "updateClearUpUI 2222 spanBuilder = " + spannableStringBuilder + "  tepTextSize = " + r3);
                this.f8894f.setText(j.IDS_social_clearup_storage_clear_doing);
                this.f8896h.setVisibility(4);
                this.f8898j.setVisibility(8);
                return;
            case 111:
                this.f8890b.setVisibility(0);
                this.f8889a.setVisibility(8);
                this.f8891c.setVisibility(8);
                this.f8892d.setVisibility(0);
                this.f8893e.setVisibility(8);
                this.f8895g.setVisibility(0);
                this.f8894f.setText(j.IDS_social_clearup_storage_clear_finish);
                this.f8896h.setVisibility(0);
                this.f8897i.setText(j.IDS_social_clearup_storage_button_finish);
                this.f8898j.setVisibility(8);
                return;
            default:
                return;
        }
    }
}
