package com.huawei.crowdtestsdk.feedback.widgets.photoSelector;

import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.huawei.crowdtestsdk.constants.SdkConstants;
import com.huawei.crowdtestsdk.feedback.widgets.BaseChooserActivity;
import com.huawei.crowdtestsdk.utils.ResUtil;
import com.huawei.uploadlog.p188c.C2511g;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class PhotoFolderActivity extends BaseChooserActivity {
    private final int INIT_DATA = 0;
    private final int REFRESH_DATA = 1;
    LinearLayout emptyView;
    private FolderListAdapter mAdapter;
    private HashSet<String> mDirPaths;
    private Handler mHandler = new C07431();
    private List<FolderItem> mImageFloders = new ArrayList();
    private ListView mListView;
    private ProgressDialog mProgressDialog;
    private int mScreenHeight;
    private boolean needRefresh = true;
    private ImageView titleBarImage;
    private TextView titleBarText;

    class C07431 extends Handler {
        C07431() {
        }

        public void handleMessage(Message message) {
            if (PhotoFolderActivity.this.mProgressDialog != null) {
                PhotoFolderActivity.this.mProgressDialog.dismiss();
            }
            switch (message.what) {
                case 0:
                    PhotoFolderActivity.this.initData();
                    return;
                case 1:
                    if (PhotoFolderActivity.this.mAdapter != null) {
                        PhotoFolderActivity.this.mAdapter.notifyDataSetChanged();
                    }
                    PhotoFolderActivity.this.isShowNoPhotoView();
                    return;
                default:
                    return;
            }
        }
    }

    class C07453 implements OnItemClickListener {
        C07453() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            Intent intent = new Intent(PhotoFolderActivity.this, PhotoShowActivity.class);
            intent.setPackage(PhotoFolderActivity.this.getPackageName());
            intent.putExtra("dir", ((FolderItem) PhotoFolderActivity.this.mImageFloders.get(i)).getDir());
            PhotoFolderActivity.this.startActivityForResult(intent, SdkConstants.REQUEST_PHOTOS);
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(ResUtil.getResId(this, "sdk_crowdtest_activity_photo_selector", ResUtil.TYPE_LAYOUT));
        Intent intent = getIntent();
        if (intent != null) {
            try {
                this.needRefresh = intent.getBooleanExtra("needRefresh", true);
            } catch (Exception e) {
                this.needRefresh = true;
                e.printStackTrace();
            }
        }
        initView();
        getImages(0);
    }

    public void isShowNoPhotoView() {
        if (this.mAdapter == null || this.mAdapter.getCount() == 0) {
            this.emptyView.setVisibility(0);
            this.mListView.setVisibility(8);
            return;
        }
        this.emptyView.setVisibility(8);
        this.mListView.setVisibility(0);
    }

    private void initData() {
        if (!(this.mImageFloders == null || this.mImageFloders.isEmpty())) {
            this.mAdapter = new FolderListAdapter<FolderItem>(this, this.mImageFloders, ResUtil.getResId(this, "sdk_crowdtest_photoselector_item_list_dir", ResUtil.TYPE_LAYOUT)) {
                public void convert(ViewHolder viewHolder, FolderItem folderItem) {
                    viewHolder.setText(ResUtil.getResId(PhotoFolderActivity.this, "sdk_crowdtest_id_dir_item_name", "id"), folderItem.getName());
                    if (folderItem.getFirstImagePath().endsWith("mp4")) {
                        viewHolder.setImageResource(ResUtil.getResId(PhotoFolderActivity.this, "sdk_crowdtest_id_dir_item_image", "id"), ResUtil.getResId(PhotoFolderActivity.this, "sdk_crowdtest_media_icon", ResUtil.TYPE_DRAWABLE));
                    } else {
                        viewHolder.setImageByUrl(ResUtil.getResId(PhotoFolderActivity.this, "sdk_crowdtest_id_dir_item_image", "id"), folderItem.getFirstImagePath());
                    }
                    viewHolder.setText(ResUtil.getResId(PhotoFolderActivity.this, "sdk_crowdtest_id_dir_item_count", "id"), folderItem.getCountString());
                }
            };
            this.mListView.setAdapter(this.mAdapter);
            this.mListView.setOnItemClickListener(new C07453());
        }
        isShowNoPhotoView();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == SdkConstants.REQUEST_PHOTOS && i2 == -1 && intent != null) {
            setResult(-1, intent);
            finish();
        }
        super.onActivityResult(i, i2, intent);
    }

    private void getImages(final int i) {
        if (Environment.getExternalStorageState().equals("mounted")) {
            this.mProgressDialog = ProgressDialog.show(this, null, getResources().getString(ResUtil.getResId(this, "sdk_crowdtest_text_is_loading", ResUtil.TYPE_STRING)));
            new Thread(new Runnable() {

                class C07461 implements FilenameFilter {
                    C07461() {
                    }

                    public boolean accept(File file, String str) {
                        if (file.isHidden()) {
                            return false;
                        }
                        if (str.endsWith(".jpg") || str.endsWith(".png") || str.endsWith(".jpeg") || str.endsWith(".bmp")) {
                            return true;
                        }
                        return false;
                    }
                }

                class C07472 implements FilenameFilter {
                    C07472() {
                    }

                    public boolean accept(File file, String str) {
                        if (!file.isHidden() && str.endsWith(".mp4")) {
                            return true;
                        }
                        return false;
                    }
                }

                class C07483 implements Comparator<FolderItem> {
                    C07483() {
                    }

                    public int compare(FolderItem folderItem, FolderItem folderItem2) {
                        return folderItem.getName().toLowerCase().compareTo(folderItem2.getName().toLowerCase());
                    }
                }

                public void run() {
                    PhotoFolderActivity.this.mImageFloders.clear();
                    Uri uri = Media.EXTERNAL_CONTENT_URI;
                    Uri uri2 = Video.Media.EXTERNAL_CONTENT_URI;
                    query(uri);
                    query(uri2);
                    PhotoFolderActivity.this.mDirPaths = null;
                    PhotoFolderActivity.this.mHandler.sendEmptyMessage(i);
                }

                private void query(Uri uri) {
                    Uri uri2 = uri;
                    Cursor query = PhotoFolderActivity.this.getContentResolver().query(uri2, null, "mime_type=? or mime_type=? or mime_type=? or mime_type=? or mime_type=?", new String[]{"image/jpeg", "image/png", "image/jpg", "image/bmp", "video/mp4"}, "date_modified");
                    C2511g.m12481b("BETACLUB_SDK", query.getCount() + "");
                    String[] strArr = null;
                    while (query.moveToNext()) {
                        String string = query.getString(query.getColumnIndex("_data"));
                        C2511g.m12481b("BETACLUB_SDK", "[PhotoSelectorActivity.getImages]path" + string);
                        if (strArr == null) {
                            strArr = string;
                        }
                        File parentFile = new File(string).getParentFile();
                        if (parentFile != null && parentFile.exists()) {
                            String absolutePath = parentFile.getAbsolutePath();
                            if (PhotoFolderActivity.this.mDirPaths == null) {
                                PhotoFolderActivity.this.mDirPaths = new HashSet();
                            }
                            if (!PhotoFolderActivity.this.mDirPaths.contains(absolutePath)) {
                                int length;
                                int length2;
                                PhotoFolderActivity.this.mDirPaths.add(absolutePath);
                                FolderItem folderItem = new FolderItem();
                                folderItem.setDir(absolutePath);
                                folderItem.setFirstImagePath(string);
                                String[] list = parentFile.list(new C07461());
                                String[] list2 = parentFile.list(new C07472());
                                if (list != null) {
                                    length = list.length;
                                } else {
                                    length = 0;
                                }
                                if (list2 != null) {
                                    length2 = list2.length;
                                } else {
                                    length2 = 0;
                                }
                                folderItem.setCountString(String.format(PhotoFolderActivity.this.getString(ResUtil.getResId(PhotoFolderActivity.this, "sdk_crowdtest_description_attachment_photo_count", ResUtil.TYPE_STRING)), new Object[]{Integer.valueOf(length), Integer.valueOf(length2)}));
                                PhotoFolderActivity.this.mImageFloders.add(folderItem);
                                Collections.sort(PhotoFolderActivity.this.mImageFloders, new C07483());
                            }
                        }
                    }
                    query.close();
                }
            }).start();
            return;
        }
        Toast.makeText(this, getResources().getString(ResUtil.getResId(this, "sdk_crowdtest_description_attachment_no_external_storage", ResUtil.TYPE_STRING)), 0).show();
    }

    private void initView() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.mScreenHeight = displayMetrics.heightPixels;
        this.emptyView = (LinearLayout) findViewById(ResUtil.getResId(this, "photo_list_empty_layout", "id"));
        this.titleBarImage = (ImageView) findViewById(ResUtil.getResId(this, "sdk_crowdtest_title_bar_image", "id"));
        this.titleBarText = (TextView) findViewById(ResUtil.getResId(this, "sdk_crowdtest_title_bar_text", "id"));
        this.titleBarImage.setImageResource(0);
        this.titleBarImage.setVisibility(8);
        this.titleBarText.setText(ResUtil.getResId(this, "sdk_crowdtest_description_attachment_photo_selector", ResUtil.TYPE_STRING));
        this.mListView = (ListView) findViewById(ResUtil.getResId(this, "photo_folder_list", "id"));
    }

    protected void onResume() {
        if (this.needRefresh) {
            getImages(1);
        } else {
            this.needRefresh = true;
        }
        super.onResume();
    }

    protected void onPause() {
        this.needRefresh = true;
        super.onPause();
    }

    protected void onStop() {
        this.needRefresh = true;
        super.onStop();
    }
}
