package com.huawei.pluginkidwatch.common.ui.view;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.provider.MediaStore.Images.Media;
import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: SlectPictureDialog */
class aj implements OnClickListener {
    final /* synthetic */ Activity f3854a;
    final /* synthetic */ ah f3855b;

    aj(ah ahVar, Activity activity) {
        this.f3855b = ahVar;
        this.f3854a = activity;
    }

    public void onClick(View view) {
        try {
            C2538c.m12674b("com.huawei.bone.sns.ui.base.CommonDialog", "==============you click 1：chose from photos");
            C2538c.m12674b("com.huawei.bone.sns.ui.base.CommonDialog", "openChoosePhotoDialog : ACTION_PICK");
            Intent intent = new Intent("android.intent.action.PICK", null);
            intent.setDataAndType(Media.EXTERNAL_CONTENT_URI, "image/*");
            this.f3854a.startActivityForResult(intent, 0);
        } catch (ActivityNotFoundException e) {
            C2538c.m12680e("com.huawei.bone.sns.ui.base.CommonDialog", "Exception e = " + e.getMessage());
        }
        this.f3855b.m7245a(this.f3855b.f3844a);
    }
}
