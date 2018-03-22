package com.huawei.crowdtestsdk.feedback;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import com.huawei.androidcommon.utils.BitmapUtils;
import com.huawei.crowdtestsdk.constants.IntegrationConstants;
import com.huawei.crowdtestsdk.constants.SdkConstants;
import com.huawei.crowdtestsdk.utils.ResUtil;
import com.sina.weibo.sdk.constant.WBConstants;

public class ShowAttachActivity extends Activity {
    Bitmap bitmap;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(ResUtil.getResId(this, "sdk_crowdtest_activity_image_show", ResUtil.TYPE_LAYOUT));
        Intent intent = getIntent();
        if (SdkConstants.ACTION_SHOW_ATTACH.equals(intent.getAction())) {
            String stringExtra = intent.getStringExtra(IntegrationConstants.FILE_PATH);
            if (stringExtra != null) {
                this.bitmap = BitmapUtils.getScaleBitmap(stringExtra, 1080, WBConstants.SDK_NEW_PAY_VERSION);
                ((ImageView) findViewById(ResUtil.getResId(this, "sdk_crowdtest_attach_image_view", "id"))).setImageBitmap(this.bitmap);
            }
        }
    }

    protected void onDestroy() {
        if (!(this.bitmap == null || this.bitmap.isRecycled())) {
            this.bitmap.recycle();
            this.bitmap = null;
        }
        super.onDestroy();
    }
}
