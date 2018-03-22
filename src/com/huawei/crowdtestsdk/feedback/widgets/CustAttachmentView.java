package com.huawei.crowdtestsdk.feedback.widgets;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.huawei.androidcommon.utils.FileUtils;
import com.huawei.androidcommon.utils.StringUtils;
import com.huawei.androidcommon.utils.ToastUtil;
import com.huawei.crowdtestsdk.constants.IntegrationConstants;
import com.huawei.crowdtestsdk.constants.SdkConstants;
import com.huawei.crowdtestsdk.feedback.ShowAttachActivity;
import com.huawei.crowdtestsdk.utils.ResUtil;
import com.huawei.uploadlog.p188c.C2511g;
import com.huawei.uploadlog.p188c.C2513i;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CustAttachmentView extends LinearLayout {
    private List<String> attachmentList;
    private LinearLayout mAttachLayout;
    private Context mContext;
    private int mImagePix;
    private OnAttachmentChangeListener onAttachmentChangeListener;

    class C07192 implements OnClickListener {
        C07192() {
        }

        public void onClick(final View view) {
            new Builder(CustAttachmentView.this.mContext).setTitle(ResUtil.getResId(CustAttachmentView.this.mContext, "sdk_crowdtest_login_activity_text_login_hint", ResUtil.TYPE_STRING)).setMessage(ResUtil.getResId(CustAttachmentView.this.mContext, "sdk_crowdtest_description_fragment_delete_message", ResUtil.TYPE_STRING)).setNegativeButton(ResUtil.getResId(CustAttachmentView.this.mContext, "sdk_crowdtest_description_fragment_issue_button_text_cancel", ResUtil.TYPE_STRING), null).setPositiveButton(ResUtil.getResId(CustAttachmentView.this.mContext, "sdk_crowdtest_description_fragment_delete", ResUtil.TYPE_STRING), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    int childCount = CustAttachmentView.this.mAttachLayout.getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        if (CustAttachmentView.this.mAttachLayout.getChildAt(i2).equals(view.getParent())) {
                            CustAttachmentView.this.attachmentList.remove(i2);
                        }
                    }
                    CustAttachmentView.this.mAttachLayout.removeView((View) view.getParent());
                    if (CustAttachmentView.this.onAttachmentChangeListener != null) {
                        CustAttachmentView.this.onAttachmentChangeListener.onAttachmentChange(CustAttachmentView.this.mAttachLayout.getChildCount());
                    }
                }
            }).show();
        }
    }

    public interface OnAttachmentChangeListener {
        void onAttachmentChange(int i);
    }

    public CustAttachmentView(Context context) {
        super(context, null);
        this.mAttachLayout = null;
        this.mImagePix = 0;
        this.attachmentList = new ArrayList();
        this.onAttachmentChangeListener = null;
    }

    public CustAttachmentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CustAttachmentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mAttachLayout = null;
        this.mImagePix = 0;
        this.attachmentList = new ArrayList();
        this.onAttachmentChangeListener = null;
        this.mContext = context;
        this.mImagePix = getResources().getDimensionPixelSize(ResUtil.getResId(context, "sdk_crowdtest_layout_attach_dimens", ResUtil.TYPE_DIMEN));
        creatAttachLayout();
    }

    public void setOnAttachmentChangeListener(OnAttachmentChangeListener onAttachmentChangeListener) {
        this.onAttachmentChangeListener = onAttachmentChangeListener;
    }

    private void creatAttachLayout() {
        this.mAttachLayout = new LinearLayout(this.mContext);
        this.mAttachLayout.setOrientation(1);
        this.mAttachLayout.setLayoutParams(new LayoutParams(-1, -2));
        this.mAttachLayout.setPadding(2, 2, 2, 2);
        addView(this.mAttachLayout);
    }

    public void onAddAttach(String str) {
        C2511g.m12481b("BETACLUB_SDK", "[CustAttachmentView.onAddAttach]Add attachment:" + str);
        if (StringUtils.isNullOrEmpty(str)) {
            ToastUtil.showLongToast(this.mContext, ResUtil.getResId(this.mContext, "sdk_crowdtest_description_fragment_type_unsupport", ResUtil.TYPE_STRING));
        } else if (addAttach(str)) {
            this.attachmentList.add(str);
        }
    }

    public List<String> getAttachmentList() {
        return this.attachmentList;
    }

    private boolean addAttach(String str) {
        if (str == null || !new File(str).exists()) {
            return false;
        }
        if (this.attachmentList.contains(str)) {
            ToastUtil.showShortToast(this.mContext, ResUtil.getResId(this.mContext, "sdk_crowdtest_description_fragment_repeat_add", ResUtil.TYPE_STRING));
            return false;
        }
        Bitmap a = C2513i.m12490a(this.mContext, str, this.mImagePix);
        if (a == null) {
            ToastUtil.showShortToast(this.mContext, ResUtil.getResId(this.mContext, "sdk_crowdtest_description_fragment_type_unsupport", ResUtil.TYPE_STRING));
            return false;
        }
        showAttachImage(a, str);
        return true;
    }

    private void showAttachImage(Bitmap bitmap, final String str) {
        View createContainerLayout = createContainerLayout();
        createContainerLayout.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Intent intent;
                Uri fromFile;
                if (C2513i.m12499a(str)) {
                    fromFile = Uri.fromFile(new File(str));
                    intent = new Intent("android.intent.action.VIEW");
                    intent.setDataAndType(fromFile, "video/mp4");
                } else if (C2513i.m12502b(str)) {
                    fromFile = Uri.fromFile(new File(str));
                    intent = new Intent("android.intent.action.VIEW");
                    intent.setDataAndType(fromFile, "audio/*");
                } else if (C2513i.m12503c(str)) {
                    fromFile = Uri.fromFile(new File(str));
                    intent = new Intent("android.intent.action.VIEW");
                    intent.setDataAndType(fromFile, "application/x-zip-compressed");
                } else {
                    intent = new Intent(CustAttachmentView.this.mContext, ShowAttachActivity.class);
                    intent.setAction(SdkConstants.ACTION_SHOW_ATTACH);
                    intent.putExtra(IntegrationConstants.FILE_PATH, str);
                }
                if (C2513i.m12497a(CustAttachmentView.this.mContext, intent)) {
                    CustAttachmentView.this.mContext.startActivity(intent);
                } else {
                    ToastUtil.showShortToast(CustAttachmentView.this.mContext, ResUtil.getResId(CustAttachmentView.this.mContext, "sdk_crowdtest_description_fragment_no_application_available", ResUtil.TYPE_STRING));
                }
            }
        });
        ((ImageView) createContainerLayout.findViewById(ResUtil.getResId(this.mContext, "sdk_crowdtest_attach_item_imageview_overview", "id"))).setImageBitmap(bitmap);
        ((TextView) createContainerLayout.findViewById(ResUtil.getResId(this.mContext, "sdk_crowdtest_attach_item_textview_name", "id"))).setText(FileUtils.getFileNameByPath(str) + String.format(" (%s)", new Object[]{FileUtils.getFileSizeStr(str)}));
        ((LinearLayout) createContainerLayout.findViewById(ResUtil.getResId(this.mContext, "sdk_crowdtest_attach_item_imageview_delete", "id"))).setOnClickListener(new C07192());
        this.mAttachLayout.addView(createContainerLayout);
        if (this.onAttachmentChangeListener != null) {
            this.onAttachmentChangeListener.onAttachmentChange(this.mAttachLayout.getChildCount());
        }
    }

    private LinearLayout createContainerLayout() {
        return (LinearLayout) ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(ResUtil.getResId(this.mContext, "sdk_crowdtest_layout_attach_list_item", ResUtil.TYPE_LAYOUT), null);
    }
}
