package com.huawei.crowdtestsdk.history;

import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.huawei.androidcommon.utils.FileUtils;
import com.huawei.androidcommon.utils.IOUtils;
import com.huawei.androidcommon.utils.Md5Utils;
import com.huawei.androidcommon.utils.NetworkUtils;
import com.huawei.androidcommon.utils.StringUtils;
import com.huawei.androidcommon.utils.ToastUtil;
import com.huawei.crowdtestsdk.R;
import com.huawei.crowdtestsdk.bases.CreateType.CREATE_TYPE;
import com.huawei.crowdtestsdk.bases.DBItemSet;
import com.huawei.crowdtestsdk.bases.IQuestionItem;
import com.huawei.crowdtestsdk.bases.SendType.SEND_TYPE;
import com.huawei.crowdtestsdk.common.FeedbackUtils;
import com.huawei.crowdtestsdk.common.IssueTypeParser;
import com.huawei.crowdtestsdk.constants.FeedbackProjectConstants;
import com.huawei.crowdtestsdk.constants.SdkConstants;
import com.huawei.crowdtestsdk.db.FeedbackHistoryConstants;
import com.huawei.crowdtestsdk.devices.CommonDevice;
import com.huawei.crowdtestsdk.devices.DeviceFactory;
import com.huawei.crowdtestsdk.feedback.BaseActivity;
import com.huawei.crowdtestsdk.feedback.description.component.DescriptionAttachmentComponent;
import com.huawei.crowdtestsdk.feedback.description.component.DescriptionAttachmentComponent.OnAddCameraAttachmentCallback;
import com.huawei.crowdtestsdk.feedback.description.component.DescriptionAttachmentComponent.OnAddOtherAttachmentCallback;
import com.huawei.crowdtestsdk.feedback.description.component.DescriptionDetailEditComponent;
import com.huawei.crowdtestsdk.feedback.description.component.DescriptionModifyCommonComponent;
import com.huawei.crowdtestsdk.history.net.HistoryTbdtsAccess;
import com.huawei.crowdtestsdk.utils.DialogManager;
import com.huawei.crowdtestsdk.utils.ResUtil;
import com.huawei.uploadlog.p188c.C2511g;
import com.huawei.uploadlog.p188c.C2513i;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ModifyIssueActivity extends BaseActivity {
    private final int GET_ISSUE_FAIL = 2;
    private final int GET_ISSUE_SUCCESS = 1;
    private final int RESUBMIT_ISSUE_FAIL = 6;
    private final int RESUBMIT_ISSUE_SUCCESS = 5;
    private final int UPDATE_ISSUE_FAIL = 4;
    private final int UPDATE_ISSUE_SUCCESS = 3;
    private final int UPDATE_TYPE_CLOSE = 1;
    private final int UPDATE_TYPE_TO_ORGANZIER = 2;
    private String activityID;
    private Button btnCancel;
    private Button btnClose;
    private Button btnOk;
    private DescriptionAttachmentComponent descriptionAttachmentComponent;
    private DescriptionDetailEditComponent descriptionDetailEditComponent;
    private DescriptionModifyCommonComponent descriptionModifyCommonComponent;
    private CommonDevice device;
    private boolean isResubmit = false;
    private IQuestionItem issueItem;
    private String issueNo;
    private Handler mHandler = new C07671();
    protected OnAddCameraAttachmentCallback onAddCameraAttachmentCallback = new C07682();
    protected OnAddOtherAttachmentCallback onAddOtherAttachmentCallback = new C07693();
    private OnClickListener onClickListener = new C07704();
    private ProgressDialog progressDialog;
    private ImageView titleBarImage;
    private TextView titleBarText;
    private Thread updateQuesInfoThread;

    class C07671 extends Handler {
        C07671() {
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    ModifyIssueActivity.this.getIssueSuccess();
                    return;
                case 2:
                    ModifyIssueActivity.this.getIssueFail();
                    return;
                case 3:
                    ModifyIssueActivity.this.updateIssueSuccess();
                    return;
                case 4:
                    ModifyIssueActivity.this.updateIssueFail();
                    return;
                case 5:
                    ModifyIssueActivity.this.resubmitIssueSuccess();
                    return;
                case 6:
                    ModifyIssueActivity.this.resubmitIssueFail();
                    return;
                default:
                    return;
            }
        }
    }

    class C07682 implements OnAddCameraAttachmentCallback {
        C07682() {
        }

        public void onAddCameraAttachment() {
            ModifyIssueActivity.this.descriptionAttachmentComponent.showCameraAlertDialog(ModifyIssueActivity.this);
        }
    }

    class C07693 implements OnAddOtherAttachmentCallback {
        C07693() {
        }

        public void onAddOtherAttachment() {
            ModifyIssueActivity.this.descriptionAttachmentComponent.showAddOtherAttachAlertDialog(ModifyIssueActivity.this);
        }
    }

    class C07704 implements OnClickListener {
        C07704() {
        }

        public void onClick(View view) {
            int id = view.getId();
            if (id == ResUtil.getResId(ModifyIssueActivity.this, "sdk_crowdtest_description_cancel_button", "id")) {
                ModifyIssueActivity.this.finish();
            } else if (id == ResUtil.getResId(ModifyIssueActivity.this, "sdk_crowdtest_description_ok_button", "id")) {
                ModifyIssueActivity.this.onOk();
            } else if (id == ResUtil.getResId(ModifyIssueActivity.this, "sdk_crowdtest_description_close_button", "id")) {
                ModifyIssueActivity.this.onClose();
            }
        }
    }

    class C07715 implements DialogInterface.OnClickListener {
        C07715() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            ModifyIssueActivity.this.sendByType(null, 1);
        }
    }

    class C07726 implements DialogInterface.OnClickListener {
        C07726() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            ModifyIssueActivity.this.sendByType(SEND_TYPE.SEND_NOW, 2);
        }
    }

    class C07737 implements DialogInterface.OnClickListener {
        C07737() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            ModifyIssueActivity.this.sendByType(SEND_TYPE.SEND_ON_WIFI, 2);
        }
    }

    class C07748 implements DialogInterface.OnClickListener {
        C07748() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            ModifyIssueActivity.this.sendByType(SEND_TYPE.SEND_NOW);
        }
    }

    class C07759 implements DialogInterface.OnClickListener {
        C07759() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            ModifyIssueActivity.this.sendByType(SEND_TYPE.SEND_ON_WIFI);
        }
    }

    class GetQuesInfoRunnable implements Runnable {
        private boolean isResubmit;
        private String issueNo;

        GetQuesInfoRunnable(String str, boolean z) {
            this.issueNo = str;
            this.isResubmit = z;
        }

        public void run() {
            if (this.isResubmit) {
                ModifyIssueActivity.this.issueItem = HistoryTbdtsAccess.getInstance().getBetaQuestionByIssueNoForResubmit(this.issueNo);
            } else {
                ModifyIssueActivity.this.issueItem = HistoryTbdtsAccess.getInstance().getBetaQuestionByIssueNo(this.issueNo);
            }
            if (ModifyIssueActivity.this.issueItem == null) {
                ModifyIssueActivity.this.mHandler.sendEmptyMessage(2);
            } else {
                ModifyIssueActivity.this.mHandler.sendEmptyMessage(1);
            }
        }
    }

    class SubmitQuesInfoRunnable implements Runnable {
        private int flowId;
        private IQuestionItem issueItem;
        private SEND_TYPE sendType;

        SubmitQuesInfoRunnable(IQuestionItem iQuestionItem, SEND_TYPE send_type, int i) {
            this.issueItem = iQuestionItem;
            this.sendType = send_type;
            if (i == 1) {
                iQuestionItem.setQuesStatus("6");
                iQuestionItem.setFlowStatus("6");
                this.flowId = 1;
            } else {
                iQuestionItem.setQuesStatus("2");
                iQuestionItem.setFlowStatus("2");
                this.flowId = 0;
            }
            iQuestionItem.setImeiNo(iQuestionItem.getQuesImeiNo());
        }

        public void run() {
            String resubmitBetaQuestion = HistoryTbdtsAccess.getInstance().resubmitBetaQuestion(this.issueItem, this.flowId);
            C2511g.m12481b("BETACLUB_SDK", "[ModifyIssueActivity.SubmitQuesInfoRunnable.run]Update issue result:" + resubmitBetaQuestion);
            if (resubmitBetaQuestion == null || !resubmitBetaQuestion.equalsIgnoreCase("1")) {
                ModifyIssueActivity.this.mHandler.sendEmptyMessage(6);
            } else {
                if (this.sendType != null) {
                    ModifyIssueActivity.this.sendAll(this.sendType);
                }
                ModifyIssueActivity.this.mHandler.sendEmptyMessage(5);
            }
            ModifyIssueActivity.this.getApplicationContext().sendBroadcast(new Intent(SdkConstants.UPDATE_ISSUE_LIST), SdkConstants.USE_CROWDTESTSDK_PERMISSION);
        }
    }

    class UpdateQuesInfoRunnable implements Runnable {
        private IQuestionItem issueItem;
        private SEND_TYPE sendType;

        UpdateQuesInfoRunnable(IQuestionItem iQuestionItem, SEND_TYPE send_type) {
            this.issueItem = iQuestionItem;
            this.sendType = send_type;
        }

        public void run() {
            if (this.issueItem == null) {
                C2511g.m12481b("BETACLUB_SDK", "[ModifyIssueActivity]UpdateQuesInfo issueItem is null!");
                return;
            }
            String updateBetaQuestion = HistoryTbdtsAccess.getInstance().updateBetaQuestion(this.issueItem);
            C2511g.m12481b("BETACLUB_SDK", "[ModifyIssueActivity.UpdateQuesInfoRunnable]Update issue result:" + updateBetaQuestion);
            if (updateBetaQuestion == null || !updateBetaQuestion.equalsIgnoreCase("1")) {
                ModifyIssueActivity.this.mHandler.sendEmptyMessage(4);
                return;
            }
            if (this.sendType != null) {
                ModifyIssueActivity.this.sendAll(this.sendType);
            }
            ModifyIssueActivity.this.mHandler.sendEmptyMessage(3);
        }
    }

    protected void initLayout() {
        setContentView(R.layout.sdk_crowdtest_activity_modify_issue);
        getData();
    }

    private void getData() {
        if (getIntent() != null) {
            this.issueNo = getIntent().getStringExtra("QuesID");
            this.isResubmit = getIntent().getBooleanExtra("Resubmit", false);
        }
    }

    protected void initView() {
        this.descriptionModifyCommonComponent = (DescriptionModifyCommonComponent) findViewById(ResUtil.getResId(this, "sdk_crowdtest_mofify_description_modify_component", "id"));
        this.descriptionDetailEditComponent = (DescriptionDetailEditComponent) findViewById(ResUtil.getResId(this, "sdk_crowdtest_mofify_description_detail_edit_component", "id"));
        this.descriptionAttachmentComponent = (DescriptionAttachmentComponent) findViewById(ResUtil.getResId(this, "sdk_crowdtest_mofify_description_attachment_component", "id"));
        this.btnCancel = (Button) findViewById(ResUtil.getResId(this, "sdk_crowdtest_description_cancel_button", "id"));
        this.btnOk = (Button) findViewById(ResUtil.getResId(this, "sdk_crowdtest_description_ok_button", "id"));
        this.btnClose = (Button) findViewById(ResUtil.getResId(this, "sdk_crowdtest_description_close_button", "id"));
        this.titleBarImage = (ImageView) findViewById(ResUtil.getResId(this, "sdk_crowdtest_title_bar_image", "id"));
        this.titleBarText = (TextView) findViewById(ResUtil.getResId(this, "sdk_crowdtest_title_bar_text", "id"));
        this.btnCancel.setOnClickListener(this.onClickListener);
        this.btnOk.setOnClickListener(this.onClickListener);
        this.btnClose.setOnClickListener(this.onClickListener);
        this.btnClose.setVisibility(this.isResubmit ? 0 : 8);
        this.descriptionAttachmentComponent.setOnAddOtherAttachmentCallback(this.onAddOtherAttachmentCallback);
        this.descriptionAttachmentComponent.setOnAddCameraAttachmentCallback(this.onAddCameraAttachmentCallback);
        this.descriptionModifyCommonComponent.setResubmitState(this.isResubmit);
    }

    protected void setTitle() {
        this.titleBarImage.setImageResource(ResUtil.getResId(this, "sdk_crowdtest_icon_modify_issue", ResUtil.TYPE_DRAWABLE));
        this.titleBarText.setText(ResUtil.getResId(this, "sdk_crowdtest_modify_issue", ResUtil.TYPE_STRING));
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        startWork();
    }

    private void startWork() {
        C2511g.m12481b("BETACLUB_SDK", "[ModifyIssueListActivity.startWork] issueNo:" + (this.issueNo == null ? null : this.issueNo));
        if (!TextUtils.isEmpty(this.issueNo)) {
            showProgressDialog(getString(ResUtil.getResId(this, "sdk_crowdtest_trying_to_get_issue_info", ResUtil.TYPE_STRING)));
            new Thread(new GetQuesInfoRunnable(this.issueNo, this.descriptionModifyCommonComponent.getResubmitState())).start();
        }
    }

    private void showProgressDialog(String str) {
        if (this.progressDialog == null) {
            this.progressDialog = new ProgressDialog(this);
            this.progressDialog.setProgressStyle(0);
            this.progressDialog.setIndeterminate(false);
            this.progressDialog.setCanceledOnTouchOutside(false);
            this.progressDialog.setCancelable(false);
        }
        this.progressDialog.setMessage(str);
        DialogManager.showDialog(this.progressDialog);
    }

    private void getIssueSuccess() {
        DialogManager.dismissDialog(this.progressDialog);
        this.descriptionModifyCommonComponent.setQuesInfo(this.issueItem);
        this.descriptionDetailEditComponent.setDetailString(this.issueItem.getDetail());
    }

    private void getIssueFail() {
        DialogManager.dismissDialog(this.progressDialog);
        ToastUtil.showLongToast((Context) this, ResUtil.getResId(this, "sdk_crowdtest_get_issue_fail", ResUtil.TYPE_STRING));
    }

    private void updateIssueSuccess() {
        DialogManager.dismissDialog(this.progressDialog);
        ToastUtil.showLongToast((Context) this, ResUtil.getResId(this, "sdk_crowdtest_issue_update_successful", ResUtil.TYPE_STRING));
        finish();
    }

    private void updateIssueFail() {
        DialogManager.dismissDialog(this.progressDialog);
        ToastUtil.showLongToast((Context) this, ResUtil.getResId(this, "sdk_crowdtest_issue_update_failed", ResUtil.TYPE_STRING));
    }

    private void resubmitIssueSuccess() {
        ToastUtil.showLongToast((Context) this, ResUtil.getResId(this, "sdk_crowdtest_issue_update_successful", ResUtil.TYPE_STRING));
        this.activityID = this.issueItem.getProjectId();
        C2511g.m12481b("BETACLUB_SDK", "ModifyIssueActivity activityID is " + this.activityID);
        ContentResolver contentResolver = getContentResolver();
        Uri uri = FeedbackProjectConstants.CONTENT_URI_PROJECT;
        String str = "project_id = ?";
        Cursor query = contentResolver.query(uri, new String[]{"project_id", FeedbackProjectConstants.COLUMN_NAME_PROJECT_UNHANDLE_COUNT}, str, new String[]{this.activityID}, null);
        while (query.moveToNext()) {
            ContentValues contentValues = new ContentValues();
            String string = query.getString(query.getColumnIndex(FeedbackProjectConstants.COLUMN_NAME_PROJECT_UNHANDLE_COUNT));
            if (StringUtils.isNullOrEmpty(string)) {
                string = "0";
            }
            C2511g.m12481b("BETACLUB_SDK", "ModifyIssueActivity unhandleCount is " + string);
            int parseInt = Integer.parseInt(string);
            if (parseInt > 0) {
                parseInt--;
            }
            C2511g.m12481b("BETACLUB_SDK", "Modify_Issue_COUNT:" + parseInt);
            contentValues.put(FeedbackProjectConstants.COLUMN_NAME_PROJECT_UNHANDLE_COUNT, String.valueOf(parseInt));
            contentResolver.update(uri, contentValues, str, new String[]{this.activityID});
        }
        query.close();
        Intent intent = new Intent();
        intent.setAction("com.huawei.crowdtest.UnHandleReceive");
        sendBroadcast(intent, SdkConstants.USE_CROWDTESTSDK_PERMISSION);
        C2511g.m12481b("BETACLUB_SDK", "ModifyIssueActivity.sendBroadcast");
        finish();
    }

    private void resubmitIssueFail() {
        DialogManager.dismissDialog(this.progressDialog);
        ToastUtil.showLongToast((Context) this, ResUtil.getResId(this, "sdk_crowdtest_issue_update_failed", ResUtil.TYPE_STRING));
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        ArrayList arrayList = null;
        switch (i) {
            case SdkConstants.REQUEST_GALLERY /*321*/:
                switch (i2) {
                    case -1:
                        if (intent != null) {
                            try {
                                arrayList = intent.getExtras().getStringArrayList("pathList");
                            } catch (Throwable e) {
                                C2511g.m12482b("BETACLUB_SDK", "[ModifyIssueActivity.onActivityResult]REQUEST_GALLERY error", e);
                            }
                            if (arrayList != null) {
                                Iterator it = arrayList.iterator();
                                while (it.hasNext()) {
                                    String str = (String) it.next();
                                    C2511g.m12481b("BETACLUB_SDK", "[ModifyIssueActivity.onActivityResult]Add each Path:" + str);
                                    onAddAttachment(str, 1);
                                }
                                break;
                            }
                        }
                        break;
                    default:
                        break;
                }
            case SdkConstants.REQUEST_CAMERA_PHOTO /*323*/:
                switch (i2) {
                    case -1:
                        ContentResolver contentResolver = getContentResolver();
                        Uri photoUri = this.descriptionAttachmentComponent.getPhotoUri();
                        if (photoUri != null) {
                            Cursor query = contentResolver.query(photoUri, arrayList, arrayList, arrayList, arrayList);
                            if (query != null) {
                                query.moveToFirst();
                                onAddAttachment(query.getString(1), 0);
                            }
                            IOUtils.close(query);
                            break;
                        }
                        break;
                    default:
                        break;
                }
            case SdkConstants.REQUEST_CAMERA_VIDEO /*324*/:
                switch (i2) {
                    case -1:
                        if (intent != null) {
                            Uri data = intent.getData();
                            String filePathFromUri = FileUtils.getFilePathFromUri(this, data);
                            C2511g.m12477a("BETACLUB_SDK", "[ModifyIssueActivity.onActivityResult]Camera video, add URI:" + data);
                            C2511g.m12477a("BETACLUB_SDK", "[ModifyIssueActivity.onActivityResult]Camera video, add Path:" + filePathFromUri);
                            onAddAttachment(filePathFromUri, 0);
                            break;
                        }
                        break;
                    default:
                        break;
                }
        }
        super.onActivityResult(i, i2, intent);
    }

    protected void onAddAttachment(String str, int i) {
        if (this.descriptionAttachmentComponent != null) {
            this.descriptionAttachmentComponent.addAttachment(str, i);
        }
    }

    private void onClose() {
        Builder builder = new Builder(this);
        builder.setMessage(ResUtil.getResId(this, "sdk_crowdtest_msg_close_question_hint", ResUtil.TYPE_STRING)).setPositiveButton(17039379, new C07715()).setNegativeButton(17039369, null);
        builder.show();
    }

    private void sendByType(SEND_TYPE send_type) {
        showProgressDialog(getString(ResUtil.getResId(this, "sdk_crowdtest_trying_to_update_issue_info", ResUtil.TYPE_STRING)));
        if (this.issueItem == null) {
            C2511g.m12481b("BETACLUB_SDK", "[ModifyActivity.sendByType]issueItem is null!");
            return;
        }
        this.issueItem.setBrief(this.descriptionModifyCommonComponent.getBrief());
        this.issueItem.setDetail(this.descriptionDetailEditComponent.getDetailContentString());
        this.updateQuesInfoThread = new Thread(new UpdateQuesInfoRunnable(this.issueItem, send_type));
        this.updateQuesInfoThread.start();
    }

    private void sendByType(SEND_TYPE send_type, int i) {
        showProgressDialog(getString(ResUtil.getResId(this, "sdk_crowdtest_trying_to_update_issue_info", ResUtil.TYPE_STRING)));
        this.issueItem.setBrief(this.descriptionModifyCommonComponent.getBrief());
        this.issueItem.setDetail(this.descriptionDetailEditComponent.getDetailString());
        this.updateQuesInfoThread = new Thread(new SubmitQuesInfoRunnable(this.issueItem, send_type, i));
        this.updateQuesInfoThread.start();
    }

    private void onOk() {
        if (this.isResubmit) {
            resubmitQues();
        } else {
            updateQuesInfo();
        }
    }

    private void sendAll(SEND_TYPE send_type) {
        int i;
        String compressAll = compressAll();
        DBItemSet makeDbItemSet = makeDbItemSet(compressAll, send_type);
        FeedbackUtils.insertRecord(this, FeedbackHistoryConstants.CONTENT_URI_LOG, makeDbItemSet, FeedbackUtils.formatSendingStatus(this, compressAll), 1, "2");
        long length = new File(compressAll).length();
        if (send_type == SEND_TYPE.SEND_ON_WIFI) {
            i = 1;
        } else {
            i = 7;
        }
        C2513i.m12496a(this, compressAll, makeDbItemSet.logId, length, i, SdkConstants.getCommercialVersion(), 5);
    }

    private String compressAll() {
        this.activityID = this.issueItem.getProjectId();
        C2511g.m12481b("BETACLUB_SDK", "[ModifyIssueActivity.compressAll]activityID : " + this.activityID);
        this.device = DeviceFactory.getDeviceByProjectIdFromLocal(this, this.activityID);
        this.device.setDeviceId(this.issueItem.getImeiNo());
        this.device.setVersionName(this.issueItem.getVersionName());
        return FeedbackUtils.compressLog(this, null, this.descriptionAttachmentComponent.getAttachmentList(), this.issueItem.getTbdtsQuesNo(), this.device);
    }

    private DBItemSet makeDbItemSet(String str, SEND_TYPE send_type) {
        String description = getDescription();
        long md5 = Md5Utils.getMD5(str);
        int probabilityIndex = this.descriptionModifyCommonComponent.getProbabilityIndex();
        long occurrenceTime = this.descriptionModifyCommonComponent.getOccurrenceTime();
        List cameraAttachList = this.descriptionAttachmentComponent.getCameraAttachList();
        List otherAttachList = this.descriptionAttachmentComponent.getOtherAttachList();
        return new DBItemSet(md5, IssueTypeParser.getIssueTypeByBetaId(this, this.issueItem.getNewQuesType()).getBugTypeId(), description, probabilityIndex, occurrenceTime, str, null, null, cameraAttachList, otherAttachList, this.activityID, this.issueItem.getProjectName(), this.device.getDeviceHelper(), this.issueItem.getTbdtsQuesNo(), CREATE_TYPE.ADD_ATTACH.ordinal(), send_type.ordinal(), System.currentTimeMillis());
    }

    private String getDescription() {
        return this.descriptionModifyCommonComponent.getDescription() + this.descriptionDetailEditComponent.getDetailContentString();
    }

    private void resubmitQues() {
        if (this.issueItem != null) {
            int networkType = NetworkUtils.getNetworkType(this);
            if (networkType < 0) {
                Toast.makeText(this, ResUtil.getResId(this, "sdk_crowdtest_check_net_connection", ResUtil.TYPE_STRING), 1).show();
            } else if (this.descriptionAttachmentComponent.getAttachmentList().size() == 0) {
                sendByType(null, 2);
            } else if (networkType == 1) {
                sendByType(SEND_TYPE.SEND_ON_WIFI, 2);
            } else {
                Builder builder = new Builder(this);
                builder.setTitle(ResUtil.getResId(this, "sdk_crowdtest_login_activity_text_login_hint", ResUtil.TYPE_STRING));
                builder.setMessage(ResUtil.getResId(this, "sdk_crowdtest_choose_send_type_for_attachments", ResUtil.TYPE_STRING));
                builder.setCancelable(false);
                builder.setPositiveButton(ResUtil.getResId(this, "sdk_crowdtest_description_fragment_send_now", ResUtil.TYPE_STRING), new C07726());
                builder.setNegativeButton(ResUtil.getResId(this, "sdk_crowdtest_description_fragment_send_on_wifi", ResUtil.TYPE_STRING), new C07737());
                builder.show();
            }
        }
    }

    private void updateQuesInfo() {
        if (this.issueItem != null) {
            int networkType = NetworkUtils.getNetworkType(this);
            C2511g.m12481b("BETACLUB_SDK", "[ModifyIssueActivity.updateQuesInfo]netType:" + networkType);
            if (networkType < 0) {
                Toast.makeText(this, ResUtil.getResId(this, "sdk_crowdtest_check_net_connection", ResUtil.TYPE_STRING), 1).show();
            }
            if (this.descriptionAttachmentComponent.getAttachmentList().size() == 0) {
                sendByType(null);
            } else if (networkType == 1) {
                sendByType(SEND_TYPE.SEND_ON_WIFI);
            } else {
                Builder builder = new Builder(this);
                builder.setTitle(ResUtil.getResId(this, "sdk_crowdtest_login_activity_text_login_hint", ResUtil.TYPE_STRING));
                builder.setMessage(ResUtil.getResId(this, "sdk_crowdtest_choose_send_type_for_attachments", ResUtil.TYPE_STRING));
                builder.setCancelable(false);
                builder.setPositiveButton(ResUtil.getResId(this, "sdk_crowdtest_description_fragment_send_now", ResUtil.TYPE_STRING), new C07748());
                builder.setNegativeButton(ResUtil.getResId(this, "sdk_crowdtest_description_fragment_send_on_wifi", ResUtil.TYPE_STRING), new C07759());
                builder.show();
            }
        }
    }
}
