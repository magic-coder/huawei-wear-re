package com.huawei.pluginkidwatch.common.ui.view;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback;
import android.widget.TextView;
import com.huawei.crowdtestsdk.constants.SdkConstants;
import com.huawei.hwcommonmodel.d.a.b;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.ui.p150a.C1507h;
import com.huawei.pluginkidwatch.g;
import com.huawei.pluginkidwatch.h;
import com.huawei.pluginkidwatch.m;
import java.util.HashMap;
import java.util.Map;

/* compiled from: SlectPictureDialog */
public class ah implements OnRequestPermissionsResultCallback {
    private C1507h f3844a = null;
    private TextView f3845b;
    private TextView f3846c;
    private TextView f3847d;
    private Context f3848e;
    private boolean f3849f = true;
    private Uri f3850g;
    private Activity f3851h;

    public ah(Context context) {
        this.f3848e = context;
    }

    public void m7249a(Activity activity, Uri uri, ae aeVar) {
        C2538c.m12674b("com.huawei.bone.sns.ui.base.CommonDialog", "openChoosePhotoDialog");
        this.f3851h = activity;
        this.f3850g = uri;
        if (this.f3844a == null) {
            this.f3844a = new C1507h(this.f3848e, SdkConstants.REQUEST_CAMERA_VIDEO, 200, h.dialog_choose_head_image_list, m.servicedialog, false);
        }
        this.f3844a.show();
        this.f3844a.setCanceledOnTouchOutside(true);
        this.f3845b = (TextView) this.f3844a.findViewById(g.profile_setting_take_photo);
        this.f3846c = (TextView) this.f3844a.findViewById(g.profile_setting_choose_from_default);
        this.f3847d = (TextView) this.f3844a.findViewById(g.profile_setting_choose_from_phone);
        m7244a(activity, uri);
        this.f3846c.setOnClickListener(new ai(this, aeVar));
        this.f3847d.setOnClickListener(new aj(this, activity));
    }

    private void m7244a(Activity activity, Uri uri) {
        this.f3845b.setOnClickListener(new ak(this, activity, uri));
    }

    public void m7250b(Activity activity, Uri uri, ae aeVar) {
        C2538c.m12674b("com.huawei.bone.sns.ui.base.CommonDialog", "openChooseContactPhotoDialog");
        this.f3851h = activity;
        this.f3850g = uri;
        if (this.f3844a == null) {
            this.f3844a = new C1507h(this.f3848e, SdkConstants.REQUEST_CAMERA_VIDEO, 200, h.dialog_contact_head_common, m.servicedialog, false);
        }
        this.f3844a.show();
        this.f3844a.setCanceledOnTouchOutside(true);
        this.f3845b = (TextView) this.f3844a.findViewById(g.camera_tv_c);
        this.f3846c = (TextView) this.f3844a.findViewById(g.pic_preset_tv_c);
        this.f3847d = (TextView) this.f3844a.findViewById(g.pic_tv_c);
        m7244a(activity, uri);
        this.f3846c.setOnClickListener(new al(this, activity));
        this.f3847d.setOnClickListener(new am(this, activity));
    }

    private void m7248b(Activity activity, Uri uri) {
        try {
            C2538c.m12674b("com.huawei.bone.sns.ui.base.CommonDialog", "==============you click 0 :take photo by camera");
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            intent.putExtra("output", uri);
            activity.startActivityForResult(intent, 1);
        } catch (ActivityNotFoundException e) {
            C2538c.m12680e("com.huawei.bone.sns.ui.base.CommonDialog", "Exception e = " + e.getMessage());
        }
    }

    private void m7245a(C1507h c1507h) {
        if (c1507h != null) {
            c1507h.cancel();
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        int i2 = 0;
        C2538c.m12674b("com.huawei.bone.sns.ui.base.CommonDialog", "Activity-onRequestPermissionsResult() PermissionsManager.notifyPermissionsChange()");
        b.a().a(strArr, iArr);
        switch (i) {
            case 1:
                Map hashMap = new HashMap();
                while (i2 < strArr.length) {
                    hashMap.put(strArr[i2], Integer.valueOf(iArr[i2]));
                    i2++;
                }
                if (hashMap.containsKey("android.permission.CAMERA") && ((Integer) hashMap.get("android.permission.CAMERA")).intValue() != 0) {
                    m7248b(this.f3851h, this.f3850g);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
