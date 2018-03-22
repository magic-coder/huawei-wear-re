package com.huawei.crowdtestsdk.feedback.description.component;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.provider.MediaStore.Images.Media;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.huawei.androidcommon.utils.StringUtils;
import com.huawei.crowdtestsdk.R;
import com.huawei.crowdtestsdk.constants.SdkConstants;
import com.huawei.crowdtestsdk.feedback.widgets.CustAttachmentView;
import com.huawei.crowdtestsdk.feedback.widgets.fileChooser.FileChooserActivity;
import com.huawei.crowdtestsdk.feedback.widgets.photoSelector.PhotoFolderActivity;
import com.huawei.crowdtestsdk.utils.DialogManager;
import com.huawei.crowdtestsdk.utils.ResUtil;
import com.huawei.uploadlog.p188c.C2511g;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class DescriptionAttachmentComponent extends LinearLayout implements IComponent {
    public static final int CAMERA_ATTACH = 0;
    public static final int OTHER_ATTACH = 1;
    private static Button cameraAttachExpandBtn;
    private static LinearLayout cameraAttachLayout;
    private static CustAttachmentView cameraAttachView;
    private static Button otherAttachExpandBtn;
    private static LinearLayout otherAttachLayout;
    private static CustAttachmentView otherAttachView;
    private AtomicBoolean alertDialog;
    private Button cameraAttachBtn;
    private String[] cameraOptionList;
    private OnAddCameraAttachmentCallback onAddCameraAttachmentCallback;
    private OnAddOtherAttachmentCallback onAddOtherAttachmentCallback;
    private OnDismissListener onDismissListener;
    private Button otherAttachBtn;
    private Uri photoUri;

    public interface OnAddOtherAttachmentCallback {
        void onAddOtherAttachment();
    }

    public interface OnAddCameraAttachmentCallback {
        void onAddCameraAttachment();
    }

    class C06931 implements OnDismissListener {
        C06931() {
        }

        public void onDismiss(DialogInterface dialogInterface) {
            C2511g.m12477a("BETACLUB_SDK", "[DescriptionAttachmentComponent.onDismissListener]Dismiss");
            DescriptionAttachmentComponent.this.alertDialog.set(false);
        }
    }

    class C06942 implements OnClickListener {
        C06942() {
        }

        public void onClick(View view) {
            DescriptionAttachmentComponent.this.showAttachmentView(DescriptionAttachmentComponent.cameraAttachView, DescriptionAttachmentComponent.cameraAttachExpandBtn);
        }
    }

    class C06953 implements OnClickListener {
        C06953() {
        }

        public void onClick(View view) {
            DescriptionAttachmentComponent.this.onAddAttachment(0);
        }
    }

    class C06964 implements OnClickListener {
        C06964() {
        }

        public void onClick(View view) {
            DescriptionAttachmentComponent.this.showAttachmentView(DescriptionAttachmentComponent.otherAttachView, DescriptionAttachmentComponent.otherAttachExpandBtn);
        }
    }

    class C06975 implements OnClickListener {
        C06975() {
        }

        public void onClick(View view) {
            DescriptionAttachmentComponent.this.onAddAttachment(1);
        }
    }

    public DescriptionAttachmentComponent(Context context) {
        this(context, null);
    }

    public DescriptionAttachmentComponent(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DescriptionAttachmentComponent(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cameraOptionList = null;
        this.alertDialog = new AtomicBoolean(false);
        this.onDismissListener = new C06931();
        init();
    }

    private void init() {
        View.inflate(this.mContext, R.layout.sdk_crowdtest_layout_description_attachment_component, this);
        this.cameraOptionList = getResources().getStringArray(ResUtil.getResId(this.mContext, "sdk_crowdtest_description_camera_option", ResUtil.TYPE_ARRAY));
        initView();
    }

    private void initView() {
        cameraAttachLayout = (LinearLayout) findViewById(ResUtil.getResId(this.mContext, "sdk_crowdtest_description_camera_attachment_layout", "id"));
        this.cameraAttachBtn = (Button) findViewById(ResUtil.getResId(this.mContext, "sdk_crowdtest_description_camera_attachment_button", "id"));
        cameraAttachView = (CustAttachmentView) findViewById(ResUtil.getResId(this.mContext, "sdk_crowdtest_description_camera_attachment_view", "id"));
        cameraAttachExpandBtn = (Button) findViewById(ResUtil.getResId(this.mContext, "sdk_crowdtest_description_camera_attachment_expand_button", "id"));
        otherAttachLayout = (LinearLayout) findViewById(ResUtil.getResId(this.mContext, "sdk_crowdtest_description_other_attachment_layout", "id"));
        this.otherAttachBtn = (Button) findViewById(ResUtil.getResId(this.mContext, "sdk_crowdtest_description_other_attachment_button", "id"));
        otherAttachView = (CustAttachmentView) findViewById(ResUtil.getResId(this.mContext, "sdk_crowdtest_description_other_attachment_view", "id"));
        otherAttachExpandBtn = (Button) findViewById(ResUtil.getResId(this.mContext, "sdk_crowdtest_description_other_attachment_expand_button", "id"));
        cameraAttachExpandBtn.setOnClickListener(new C06942());
        this.cameraAttachBtn.setOnClickListener(new C06953());
        otherAttachExpandBtn.setOnClickListener(new C06964());
        this.otherAttachBtn.setOnClickListener(new C06975());
    }

    private void showAttachmentView(CustAttachmentView custAttachmentView, Button button) {
        if (custAttachmentView != null) {
            if (custAttachmentView.getVisibility() == 0) {
                custAttachmentView.setVisibility(8);
                button.setCompoundDrawablesWithIntrinsicBounds(ResUtil.getResId(this.mContext, "sdk_crowdtest_arrow_enter", ResUtil.TYPE_DRAWABLE), 0, 0, 0);
                return;
            }
            custAttachmentView.setVisibility(0);
            button.setCompoundDrawablesWithIntrinsicBounds(ResUtil.getResId(this.mContext, "sdk_crowdtest_arrow_draw_back", ResUtil.TYPE_DRAWABLE), 0, 0, 0);
        }
    }

    private void onAddAttachment(int i) {
        switch (i) {
            case 0:
                if (this.onAddCameraAttachmentCallback != null) {
                    this.onAddCameraAttachmentCallback.onAddCameraAttachment();
                    return;
                }
                return;
            case 1:
                if (this.onAddOtherAttachmentCallback != null) {
                    this.onAddOtherAttachmentCallback.onAddOtherAttachment();
                    return;
                }
                return;
            default:
                if (this.onAddOtherAttachmentCallback != null) {
                    this.onAddOtherAttachmentCallback.onAddOtherAttachment();
                    return;
                }
                return;
        }
    }

    public void setOnAddOtherAttachmentCallback(OnAddOtherAttachmentCallback onAddOtherAttachmentCallback) {
        this.onAddOtherAttachmentCallback = onAddOtherAttachmentCallback;
    }

    public void setOnAddCameraAttachmentCallback(OnAddCameraAttachmentCallback onAddCameraAttachmentCallback) {
        this.onAddCameraAttachmentCallback = onAddCameraAttachmentCallback;
    }

    public void addAttachment(String str, int i) {
        switch (i) {
            case 0:
                if (cameraAttachView != null && !StringUtils.isNullOrEmpty(str)) {
                    cameraAttachView.onAddAttach(str);
                    C2511g.m12481b("BETACLUB_SDK", "cameraAttachView attachPath : " + str);
                    return;
                }
                return;
            case 1:
                if (otherAttachView != null && !StringUtils.isNullOrEmpty(str)) {
                    otherAttachView.onAddAttach(str);
                    C2511g.m12481b("BETACLUB_SDK", "otherAttachView attachPath : " + str);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public List<String> getAttachmentList() {
        List<String> arrayList = new ArrayList();
        arrayList.addAll(cameraAttachView.getAttachmentList());
        arrayList.addAll(otherAttachView.getAttachmentList());
        return arrayList;
    }

    public List<String> getCameraAttachList() {
        return cameraAttachView.getAttachmentList();
    }

    public List<String> getOtherAttachList() {
        return otherAttachView.getAttachmentList();
    }

    public void showCameraAlertDialog(Activity activity) {
        showTakePhotoView(activity);
    }

    private void checkPermissionWithCamera(Activity activity, int i) {
        C2511g.m12481b("BETACLUB_SDK", "[DescriptionAttachmentComponent.checkPermissionWithCamera] check camera permission");
        if (VERSION.SDK_INT >= 23) {
            C2511g.m12481b("BETACLUB_SDK", "[DescriptionAttachmentComponent.checkPermissionWithCamera] sdk int >= 23");
            if (ContextCompat.checkSelfPermission(activity, "android.permission.CAMERA") == 0) {
                C2511g.m12481b("BETACLUB_SDK", "[DescriptionAttachmentComponent.checkPermissionWithCamera] have permission");
                takePhotoOrVideo(activity, i);
                return;
            }
            C2511g.m12481b("BETACLUB_SDK", "[DescriptionAttachmentComponent.checkPermissionWithCamera] request permission");
            ActivityCompat.requestPermissions(activity, new String[]{"android.permission.CAMERA"}, 1);
            return;
        }
        C2511g.m12481b("BETACLUB_SDK", "[DescriptionAttachmentComponent.checkPermission] sdk int < 23");
        takePhotoOrVideo(activity, i);
    }

    private void takePhotoOrVideo(Activity activity, int i) {
        switch (i) {
            case 1:
                takePhoto(activity);
                return;
            case 2:
                takeVideo(activity);
                return;
            default:
                return;
        }
    }

    public void showTakePhotoView(Activity activity) {
        checkPermissionWithCamera(activity, 1);
    }

    public void takePhoto(Activity activity) {
        C2511g.m12481b("BETACLUB_SDK", "[DescriptionAttachmentComponent.TakePhoto] is call");
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        this.photoUri = activity.getContentResolver().insert(Media.EXTERNAL_CONTENT_URI, new ContentValues());
        intent.putExtra("output", this.photoUri);
        activity.startActivityForResult(intent, SdkConstants.REQUEST_CAMERA_PHOTO);
    }

    public void showTakeVideoView(Activity activity) {
        checkPermissionWithCamera(activity, SdkConstants.REQUEST_CAMERA_VIDEO);
    }

    public void takeVideo(Activity activity) {
        activity.startActivityForResult(new Intent("android.media.action.VIDEO_CAPTURE"), SdkConstants.REQUEST_CAMERA_VIDEO);
    }

    public Uri getPhotoUri() {
        return this.photoUri;
    }

    public void showAddOtherAttachAlertDialog(final Activity activity) {
        if (!this.alertDialog.get()) {
            this.alertDialog.set(true);
            ListAdapter arrayAdapter = new ArrayAdapter(activity, ResUtil.getResId(this.mContext, "sdk_crowdtest_cust_spinner_item", ResUtil.TYPE_LAYOUT), activity.getResources().getStringArray(ResUtil.getResId(this.mContext, "sdk_crowdtest_add_attachment", ResUtil.TYPE_ARRAY)));
            View inflate = LayoutInflater.from(activity).inflate(ResUtil.getResId(this.mContext, "sdk_crowdtest_dialog_cust_spinner_probability", ResUtil.TYPE_LAYOUT), null);
            ListView listView = (ListView) inflate.findViewById(ResUtil.getResId(this.mContext, "sdk_crowdtest_dialog_cust_spinner_list_view", "id"));
            listView.setAdapter(arrayAdapter);
            final AlertDialog create = new Builder(activity).create();
            create.show();
            create.getWindow().setContentView(inflate);
            create.setOnDismissListener(this.onDismissListener);
            listView.setOnItemClickListener(new OnItemClickListener() {
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    if (view instanceof TextView) {
                        switch (i) {
                            case 0:
                                DescriptionAttachmentComponent.this.goToFileChooserActivity(activity);
                                break;
                            case 1:
                                DescriptionAttachmentComponent.this.goToPhotoSelectorActivity(activity);
                                break;
                        }
                        DialogManager.dismissDialog(create);
                    }
                }
            });
        }
    }

    private void goToFileChooserActivity(Activity activity) {
        checkPermissionWithExternalStorage(activity, 4);
        goToFileChooser(activity);
    }

    public void goToFileChooser(Activity activity) {
        Intent intent = new Intent();
        intent.setClass(activity, FileChooserActivity.class);
        intent.setPackage(activity.getPackageName());
        activity.startActivityForResult(intent, SdkConstants.REQUEST_GALLERY);
    }

    private void checkPermissionWithExternalStorage(Activity activity, int i) {
        C2511g.m12481b("BETACLUB_SDK", "[DescriptionAttachmentComponent.checkPermissionWithExternalStorage] check External Storage permission");
        if (VERSION.SDK_INT >= 23) {
            C2511g.m12481b("BETACLUB_SDK", "[DescriptionAttachmentComponent.checkPermissionWithExternalStorage] sdk int >= 23");
            if (ContextCompat.checkSelfPermission(activity, "android.permission.READ_EXTERNAL_STORAGE") == 0 && ContextCompat.checkSelfPermission(activity, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
                C2511g.m12481b("BETACLUB_SDK", "[DescriptionAttachmentComponent.checkPermissionWithExternalStorage] have permission");
                goToFileChooserOrPhotoSelector(activity, i);
                return;
            }
            C2511g.m12481b("BETACLUB_SDK", "[DescriptionAttachmentComponent.checkPermissionWithExternalStorage] request permission");
            ActivityCompat.requestPermissions(activity, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, i);
            return;
        }
        C2511g.m12481b("BETACLUB_SDK", "[DescriptionAttachmentComponent.checkPermissionWithExternalStorage] sdk int < 23");
        goToFileChooserOrPhotoSelector(activity, i);
    }

    private void goToFileChooserOrPhotoSelector(Activity activity, int i) {
        switch (i) {
            case 3:
                goToPhotoSelector(activity);
                return;
            case 4:
                goToFileChooser(activity);
                return;
            default:
                return;
        }
    }

    private void goToPhotoSelectorActivity(Activity activity) {
        checkPermissionWithExternalStorage(activity, 3);
    }

    public void goToPhotoSelector(Activity activity) {
        Intent intent = new Intent();
        intent.setClass(activity, PhotoFolderActivity.class);
        intent.setPackage(activity.getPackageName());
        intent.putExtra("needRefresh", false);
        activity.startActivityForResult(intent, SdkConstants.REQUEST_GALLERY);
    }

    public boolean checkInput() {
        return getAttachmentList().size() > 0;
    }

    public boolean checkSendAvailable() {
        return true;
    }

    public void onDestroy() {
    }
}
