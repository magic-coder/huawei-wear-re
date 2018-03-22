package com.huawei.crowdtestsdk.feedback.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huawei.crowdtestsdk.utils.ResUtil;

public class TitleBarLayout extends LinearLayout {
    private ImageView titleImage;
    private ImageView titleRightImage;
    private TextView titleText;

    public TitleBarLayout(Context context) {
        this(context, null);
    }

    public TitleBarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TitleBarLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(ResUtil.getResId(this.mContext, "sdk_crowdtest_layout_title_bar", ResUtil.TYPE_LAYOUT), this);
        initView();
    }

    private void initView() {
        this.titleImage = (ImageView) findViewById(ResUtil.getResId(this.mContext, "sdk_crowdtest_title_bar_image", "id"));
        this.titleRightImage = (ImageView) findViewById(ResUtil.getResId(this.mContext, "sdk_crowdtest_title_bar_right_image", "id"));
        this.titleText = (TextView) findViewById(ResUtil.getResId(this.mContext, "sdk_crowdtest_title_bar_text", "id"));
    }

    public void setTitleImage(int i) {
        this.titleImage.setImageResource(i);
    }

    public void setTitleImageVisibility(boolean z) {
        if (z) {
            this.titleImage.setVisibility(0);
        } else {
            this.titleImage.setVisibility(8);
        }
    }

    public void setTitleText(int i) {
        this.titleText.setText(i);
    }

    public void setRightImage(int i) {
        this.titleRightImage.setImageResource(i);
    }

    public void setRightImageClickListener(OnClickListener onClickListener) {
        this.titleRightImage.setOnClickListener(onClickListener);
    }

    public void setRightImageVisibility(boolean z) {
        if (z) {
            this.titleRightImage.setVisibility(0);
        } else {
            this.titleRightImage.setVisibility(8);
        }
    }

    public ImageView getTitleImage() {
        return this.titleImage;
    }

    public TextView getTitleText() {
        return this.titleText;
    }
}
