package com.huawei.nfc.carrera.ui.bindcard;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.nfc.carrera.ui.NFCBaseActivity;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.wallet.R;
import com.huawei.wallet.ui.cardholder.CardHolderActivity;

public class BindCardSuccessActvity extends NFCBaseActivity {
    private static final float PERCENT_MARGIN_TOP = 0.3f;
    private boolean isSetDefaultTag = true;
    private TextView mSuccessDesText;
    private Button nextButton;
    private ImageView setDefaultView;
    private ImageView successView;

    class C55771 implements ImageGetter {
        C55771() {
        }

        public Drawable getDrawable(String str) {
            Drawable drawable = BindCardSuccessActvity.this.mContext.getResources().getDrawable(Integer.parseInt(str));
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            return drawable;
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRequestedOrientation(1);
        setTitle(R.string.nfc_add_bank_card);
        setContentView(R.layout.nfc_activity_bind_success_layout);
        initViews();
    }

    private void initViews() {
        this.successView = (ImageView) findViewById(R.id.bind_success_imageview);
        this.setDefaultView = (ImageView) findViewById(R.id.nfc_set_default);
        this.nextButton = (Button) findViewById(R.id.nfc_next_step_button);
        this.mSuccessDesText = (TextView) findViewById(R.id.nfc_bind_success_textview);
        ImageGetter c55771 = new C55771();
        String string = this.mContext.getResources().getString(R.string.nfc_bind_bank_success_decribe_text);
        int indexOf = string.indexOf("%1$s");
        this.mSuccessDesText.setText(string.substring(0, indexOf));
        this.mSuccessDesText.append(Html.fromHtml("<img src='" + R.drawable.ic_huawei_watch_guide + "'/>", c55771, null));
        this.mSuccessDesText.append(string.substring(indexOf + 4));
    }

    public void onClickEvent(View view) {
        int id = view.getId();
        if (R.id.nfc_set_default == id) {
            if (this.isSetDefaultTag) {
                showToast("开通的第一张卡片，默认卡不可取消");
                return;
            }
            this.isSetDefaultTag = !this.isSetDefaultTag;
            if (this.isSetDefaultTag) {
                this.setDefaultView.setBackgroundResource(R.drawable.nfc_button_check_on);
            } else {
                this.setDefaultView.setBackgroundResource(R.drawable.nfc_button_check_off);
            }
        } else if (R.id.nfc_next_step_button == id) {
            toHomeFragment();
        }
    }

    private void toHomeFragment() {
        LogX.i("toHomeFragment");
        Intent intent = new Intent();
        intent.setClass(this, CardHolderActivity.class);
        intent.addFlags(HwAccountConstants.FLAG_TRANSLUCENT_STATUS);
        intent.setPackage(getPackageName());
        startActivity(intent);
        finish();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            toHomeFragment();
        }
        return super.onKeyDown(i, keyEvent);
    }
}
