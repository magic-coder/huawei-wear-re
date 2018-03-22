package com.huawei.feedback.ui;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import com.huawei.feedback.d;
import com.huawei.phoneserviceuni.common.d.f;

public class FeedbackPicShowActivity extends BaseActivity {
    private String f16524a = null;
    private Bitmap f16525b = null;

    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        m21280a(false);
        super.onCreate(bundle);
        View imageView = new ImageView(this);
        imageView.setLayoutParams(new LayoutParams(-1, -1));
        imageView.setContentDescription(getString(d.b(this, "feedback_content_description_attached_picture")));
        setContentView(imageView);
        this.f16524a = getIntent().getStringExtra("picture_path");
        Display defaultDisplay = ((WindowManager) getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        this.f16525b = f.a(this.f16524a, point.x, point.y);
        if (this.f16525b != null) {
            imageView.setImageBitmap(this.f16525b);
            imageView.setOnClickListener(new C4475x(this));
            return;
        }
        finish();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        finish();
        return true;
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.f16525b != null && !this.f16525b.isRecycled()) {
            this.f16525b.recycle();
            this.f16525b = null;
        }
    }

    protected void onPause() {
        super.onPause();
        d.i(this, "onPause");
        d.i(this, "onReport");
    }

    protected void onResume() {
        super.onResume();
        d.i(this, "onResume");
    }
}
