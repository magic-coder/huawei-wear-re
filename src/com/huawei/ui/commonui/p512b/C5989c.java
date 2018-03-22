package com.huawei.ui.commonui.p512b;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.provider.MediaStore.Images.Media;
import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: PhotoCorp */
class C5989c implements OnClickListener {
    final /* synthetic */ C5987a f20601a;

    C5989c(C5987a c5987a) {
        this.f20601a = c5987a;
    }

    public void onClick(View view) {
        try {
            C2538c.b("PhotoCorp", new Object[]{"openChoosePhotoDialog : ACTION_PICK"});
            Intent intent = new Intent("android.intent.action.PICK", null);
            intent.setDataAndType(Media.EXTERNAL_CONTENT_URI, "image/*");
            this.f20601a.f20595d.startActivityForResult(intent, 0);
            this.f20601a.f20599h.dismiss();
        } catch (ActivityNotFoundException e) {
            C2538c.c("PhotoCorp", new Object[]{"ActivityNotFoundException e=" + e.getMessage()});
        }
    }
}
