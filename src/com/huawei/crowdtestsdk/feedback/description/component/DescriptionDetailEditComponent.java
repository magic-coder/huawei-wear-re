package com.huawei.crowdtestsdk.feedback.description.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.huawei.androidcommon.utils.StringUtils;
import com.huawei.crowdtestsdk.constants.SdkConstants;
import com.huawei.crowdtestsdk.utils.ResUtil;
import com.huawei.uploadlog.p188c.C2511g;

public class DescriptionDetailEditComponent extends LinearLayout implements IComponent {
    private EditText etDetails;
    private boolean mHasFocus = false;

    class C07061 implements OnTouchListener {
        C07061() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            switch (motionEvent.getAction() & 255) {
                case 1:
                    view.getParent().requestDisallowInterceptTouchEvent(false);
                    break;
            }
            return false;
        }
    }

    class C07072 implements OnFocusChangeListener {
        C07072() {
        }

        public void onFocusChange(View view, boolean z) {
            DescriptionDetailEditComponent.this.mHasFocus = z;
            C2511g.m12481b("BETACLUB_SDK", "[DescriptionDetailEditComponent.setOnFocusChangeListener]onFocusChangemHasFocus = hasFocus;;" + z);
        }
    }

    public DescriptionDetailEditComponent(Context context) {
        super(context);
        init();
    }

    public DescriptionDetailEditComponent(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public DescriptionDetailEditComponent(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        init();
    }

    private void init() {
        ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(ResUtil.getResId(this.mContext, "sdk_crowdtest_layout_description_detail_edit_component", ResUtil.TYPE_LAYOUT), this);
        setFocusableInTouchMode(true);
        initView();
    }

    private void initView() {
        this.etDetails = (EditText) findViewById(ResUtil.getResId(this.mContext, "sdk_crowdtest_description_detail_edit_component_edit", "id"));
        this.etDetails.setOnTouchListener(new C07061());
        this.etDetails.setOnFocusChangeListener(new C07072());
    }

    public boolean isHasFocus() {
        return this.mHasFocus;
    }

    public void setFocus(boolean z) {
        this.mHasFocus = z;
        C2511g.m12481b("BETACLUB_SDK", "[DescriptionDetailEditComponent.setFocusable]setFocus mHasFocus = true;");
    }

    public String getDetailString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(SdkConstants.DESCRIPTION_SEPARATOR).append("\n");
        stringBuilder.append(this.mContext.getString(ResUtil.getResId(this.mContext, "sdk_crowdtest_description_edit_component_title", ResUtil.TYPE_STRING)));
        stringBuilder.append(":\n");
        String detailContentString = getDetailContentString();
        stringBuilder.append(StringUtils.isNullOrEmpty(detailContentString) ? "" : detailContentString + "\n");
        return stringBuilder.toString();
    }

    public String getDetailContentString() {
        return this.etDetails.getText().toString();
    }

    public boolean checkInput() {
        return !StringUtils.isNullOrEmpty(this.etDetails.getText().toString());
    }

    public boolean checkSendAvailable() {
        return true;
    }

    public void onDestroy() {
    }

    public void setDetailString(String str) {
        this.etDetails.setText(str);
    }
}
