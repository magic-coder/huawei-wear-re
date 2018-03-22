package com.huawei.crowdtestsdk.feedback.widgets.photoSelector;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.huawei.crowdtestsdk.feedback.widgets.BaseChooserActivity;
import com.huawei.crowdtestsdk.utils.ResUtil;
import com.huawei.uploadlog.p188c.C2511g;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

public class PhotoShowActivity extends BaseChooserActivity {
    private static final int ALL_TYPE = 0;
    private static final int IMAGE_TYPE = 1;
    private static final int VIDEO_TYPE = 2;
    private String folderInfo = "0";
    private PhotoAdapter mAdapter;
    private LinearLayout mBottomLy;
    private File mCurrentImgDir;
    private GridView mGirdView;
    private TextView mImageCount;
    private ArrayList<String> mImgs = new ArrayList();
    private Button mOk;
    private int mScreenHeight;
    private ImageView titleBarImage;
    private TextView titleBarText;

    class C07501 implements FileFilter {
        C07501() {
        }

        public boolean accept(File file) {
            if (!file.isHidden() && file.isFile() && PhotoShowActivity.this.isNeededType(file, 0)) {
                return true;
            }
            return false;
        }
    }

    class C07512 implements Comparator<File> {
        C07512() {
        }

        public int compare(File file, File file2) {
            if (file2 == null && file == null) {
                return 0;
            }
            if (file2 == null) {
                return -1;
            }
            if (file == null) {
                return 1;
            }
            if (file2.lastModified() > file.lastModified()) {
                return 1;
            }
            if (file2.lastModified() < file.lastModified()) {
                return -1;
            }
            return 0;
        }
    }

    class C07523 implements OnClickListener {
        C07523() {
        }

        public void onClick(View view) {
            if (PhotoAdapter.getSelectedImagePaths().isEmpty()) {
                PhotoShowActivity.this.finish();
                return;
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("pathList", PhotoAdapter.getSelectedImagePaths());
            intent.putExtras(bundle);
            PhotoShowActivity.this.setResult(-1, intent);
            PhotoShowActivity.this.finish();
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(ResUtil.getResId(this, "sdk_crowdtest_activity_photo_show", ResUtil.TYPE_LAYOUT));
        if (getIntent() != null) {
            try {
                String stringExtra = getIntent().getStringExtra("dir");
                if (stringExtra != null) {
                    this.mCurrentImgDir = new File(stringExtra);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        initView();
        sortFile(this.mCurrentImgDir);
        initData();
    }

    private void initData() {
        if (this.mImgs == null || this.mImgs.isEmpty()) {
            toastAndFinish();
            return;
        }
        this.mAdapter = new PhotoAdapter(getApplicationContext(), this.mImgs, ResUtil.getResId(this, "sdk_crowdtest_photoselector_grid_item", ResUtil.TYPE_LAYOUT), this.mCurrentImgDir.getAbsolutePath());
        this.mGirdView.setAdapter(this.mAdapter);
    }

    private void sortFile(File file) {
        if (file == null || !file.exists()) {
            toastAndFinish();
            return;
        }
        this.mImgs.clear();
        File[] listFiles = file.listFiles(new C07501());
        if (listFiles == null || listFiles.length <= 0) {
            toastAndFinish();
            return;
        }
        System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
        Arrays.sort(listFiles, new C07512());
        Collection arrayList = new ArrayList();
        Collection arrayList2 = new ArrayList();
        for (int i = 0; i < listFiles.length; i++) {
            String name = listFiles[i].getName();
            if (isNeededType(listFiles[i], 1)) {
                arrayList.add(name);
            } else if (isNeededType(listFiles[i], 2)) {
                arrayList2.add(name);
            }
        }
        this.folderInfo = String.format(getString(ResUtil.getResId(this, "sdk_crowdtest_description_attachment_photo_count", ResUtil.TYPE_STRING)), new Object[]{Integer.valueOf(arrayList.size()), Integer.valueOf(arrayList2.size())});
        this.mImgs.addAll(arrayList);
        this.mImgs.addAll(arrayList2);
        this.mImageCount.setText(this.folderInfo);
    }

    private void toastAndFinish() {
        Toast.makeText(this, getString(ResUtil.getResId(this, "sdk_crowdtest_description_attachment_no_photo", ResUtil.TYPE_STRING)), 0).show();
        finish();
    }

    private boolean isNeededType(File file, int i) {
        String name = file.getName();
        switch (i) {
            case 0:
                if (name.endsWith(".jpg") || name.endsWith(".png") || name.endsWith(".jpeg") || name.endsWith(".bmp")) {
                    return true;
                }
                if (name.endsWith(".mp4")) {
                    return true;
                }
                break;
            case 1:
                if (name.endsWith(".jpg") || name.endsWith(".png") || name.endsWith(".jpeg")) {
                    return true;
                }
                if (name.endsWith(".bmp")) {
                    return true;
                }
                break;
            case 2:
                if (name.endsWith(".mp4")) {
                    return true;
                }
                break;
        }
        return false;
    }

    private void initView() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.mScreenHeight = displayMetrics.heightPixels;
        this.titleBarImage = (ImageView) findViewById(ResUtil.getResId(this, "sdk_crowdtest_title_bar_image", "id"));
        this.titleBarText = (TextView) findViewById(ResUtil.getResId(this, "sdk_crowdtest_title_bar_text", "id"));
        this.titleBarImage.setImageResource(0);
        this.titleBarImage.setVisibility(8);
        if (this.mCurrentImgDir != null && this.mCurrentImgDir.exists()) {
            this.titleBarText.setText(this.mCurrentImgDir.getName());
        }
        this.mGirdView = (GridView) findViewById(ResUtil.getResId(this, "sdk_crowdtest_id_gridView", "id"));
        this.mImageCount = (TextView) findViewById(ResUtil.getResId(this, "sdk_crowdtest_id_total_count", "id"));
        this.mBottomLy = (LinearLayout) findViewById(ResUtil.getResId(this, "sdk_crowdtest_id_bottom_ly", "id"));
        this.mOk = (Button) findViewById(ResUtil.getResId(this, "sdk_crowdtest_id_ok", "id"));
        this.mOk.setOnClickListener(new C07523());
    }

    protected void onResume() {
        C2511g.m12481b("BETACLUB_SDK", "[PhotoShowActivity.onResume]");
        sortFile(this.mCurrentImgDir);
        if (this.mAdapter != null) {
            this.mAdapter.notifyDataSetChanged();
        }
        super.onResume();
    }
}
