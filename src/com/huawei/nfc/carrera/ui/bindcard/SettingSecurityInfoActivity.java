package com.huawei.nfc.carrera.ui.bindcard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import com.huawei.nfc.carrera.ui.NFCBaseActivity;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.wallet.R;

public class SettingSecurityInfoActivity extends NFCBaseActivity {
    private Button btnNext;
    private ImageView imgSecurityIcon;
    private Bundle saveBundle;

    class C56051 implements OnClickListener {
        C56051() {
        }

        public void onClick(View view) {
            SettingSecurityInfoActivity.this.jumpToBind();
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.nfc_activity_setting_security);
        showHead(R.string.nfc_setting_security_title);
        if (!initParams()) {
            LogX.d("init security params error !");
            finish();
        }
        initUI();
    }

    private boolean initParams() {
        Intent intent = getIntent();
        if (intent == null || intent.getExtras() == null) {
            return false;
        }
        this.saveBundle = intent.getExtras();
        return true;
    }

    private void initUI() {
        this.imgSecurityIcon = (ImageView) findViewById(R.id.security_activity_image);
        this.btnNext = (Button) findViewById(R.id.setting_security_btn_next);
        this.btnNext.setOnClickListener(new C56051());
    }

    private void jumpToBind() {
        Intent intent = new Intent();
        intent.setClass(this, BindCardActivity.class);
        intent.putExtras(this.saveBundle);
        startActivity(intent);
        finish();
    }
}
