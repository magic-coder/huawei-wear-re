package com.huawei.crowdtestsdk.feedback;

import android.app.AlertDialog.Builder;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ScrollView;
import com.huawei.androidcommon.utils.DateTimeUtils;
import com.huawei.androidcommon.utils.FileUtils;
import com.huawei.androidcommon.utils.IOUtils;
import com.huawei.androidcommon.utils.NetworkUtils;
import com.huawei.androidcommon.utils.StringUtils;
import com.huawei.androidcommon.utils.ToastUtil;
import com.huawei.crowdtestsdk.api.CrowdTestApi;
import com.huawei.crowdtestsdk.bases.BugInfo;
import com.huawei.crowdtestsdk.bases.CreateType.CREATE_TYPE;
import com.huawei.crowdtestsdk.bases.DBItemSet;
import com.huawei.crowdtestsdk.bases.FeedbackParams;
import com.huawei.crowdtestsdk.bases.LogCollectedResult;
import com.huawei.crowdtestsdk.bases.SendType.SEND_TYPE;
import com.huawei.crowdtestsdk.bases.TbdtsCreationUnit;
import com.huawei.crowdtestsdk.bases.TbdtsStatus;
import com.huawei.crowdtestsdk.common.FeedbackUtils;
import com.huawei.crowdtestsdk.common.IssueMaker;
import com.huawei.crowdtestsdk.common.IssueType;
import com.huawei.crowdtestsdk.common.IssueTypeParser;
import com.huawei.crowdtestsdk.constants.IntegrationConstants;
import com.huawei.crowdtestsdk.constants.SdkConstants;
import com.huawei.crowdtestsdk.db.FeedbackHistoryConstants;
import com.huawei.crowdtestsdk.devices.CommonDevice;
import com.huawei.crowdtestsdk.devices.DeviceHelper;
import com.huawei.crowdtestsdk.devices.IssueMakerFactory;
import com.huawei.crowdtestsdk.feedback.description.component.DescriptionAttachmentComponent;
import com.huawei.crowdtestsdk.feedback.description.component.DescriptionAttachmentComponent.OnAddCameraAttachmentCallback;
import com.huawei.crowdtestsdk.feedback.description.component.DescriptionAttachmentComponent.OnAddOtherAttachmentCallback;
import com.huawei.crowdtestsdk.feedback.description.component.DescriptionCommonComponent;
import com.huawei.crowdtestsdk.feedback.description.component.DescriptionDetailEditComponent;
import com.huawei.crowdtestsdk.feedback.description.component.DescriptionLastVersionExistsComponent;
import com.huawei.crowdtestsdk.feedback.task.CreateIssueTask;
import com.huawei.crowdtestsdk.feedback.task.CreateIssueTask.OnCreationCallback;
import com.huawei.crowdtestsdk.feedback.ui.TitleBarLayout;
import com.huawei.crowdtestsdk.history.HistoryActivity;
import com.huawei.crowdtestsdk.report.GroupMemberItem;
import com.huawei.crowdtestsdk.report.ImeiItem;
import com.huawei.crowdtestsdk.report.ProductVersionItem;
import com.huawei.crowdtestsdk.report.ReportInfoUtils;
import com.huawei.crowdtestsdk.service.FeedbackService;
import com.huawei.crowdtestsdk.service.RemoteFeedbackService;
import com.huawei.crowdtestsdk.service.RemoteFeedbackService.RemoteFeedbackBinder;
import com.huawei.crowdtestsdk.utils.PhoneInfo;
import com.huawei.crowdtestsdk.utils.ResUtil;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.uploadlog.p188c.C2511g;
import com.huawei.uploadlog.p188c.C2513i;
import com.huawei.uploadlog.p188c.C2514j;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class FeedbackDescriptionActivity extends FeedbackBaseActivity {
    protected static final int ON_ATTACH = 123;
    private String appVersionName = "";
    protected int bugTypeId = 100;
    protected ServiceConnection connection = new C06886();
    protected CreateIssueTask createIssueTask;
    private DescriptionAttachmentComponent descriptionAttachmentComponent;
    private DescriptionCommonComponent descriptionCommonComponent;
    private DescriptionDetailEditComponent descriptionDetailEditComponent;
    private DescriptionLastVersionExistsComponent descriptionLastVersionExistsComponent;
    private CommonDevice device;
    private String deviceId;
    protected FeedbackService feedbackService;
    private String hardwareVersion;
    protected boolean isNewFeedback = true;
    protected IssueMaker issueMaker;
    protected long issueMakerId = -1;
    protected IssueType issueType;
    protected String mCompressedLogPath = "";
    private ViewGroup mFeedbackRecordLayout;
    protected Handler mHandler = new C06831();
    private ScrollView mScrollView;
    protected Uri mUri = FeedbackHistoryConstants.CONTENT_URI_LOG;
    protected OnAddCameraAttachmentCallback onAddCameraAttachmentCallback = new OnAddCameraAttachmentCallback() {
        public void onAddCameraAttachment() {
            FeedbackDescriptionActivity.this.descriptionAttachmentComponent.showCameraAlertDialog(FeedbackDescriptionActivity.this);
        }
    };
    protected OnAddOtherAttachmentCallback onAddOtherAttachmentCallback = new OnAddOtherAttachmentCallback() {
        public void onAddOtherAttachment() {
            FeedbackDescriptionActivity.this.descriptionAttachmentComponent.showAddOtherAttachAlertDialog(FeedbackDescriptionActivity.this);
        }
    };
    private Button onCancelBtn;
    private Button onOkBtn;
    private String productName;
    private int productType;
    private String productVersion;
    private String routerBrand;
    protected String tbdtsNo;

    class C06831 extends Handler {
        C06831() {
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 123:
                    C2511g.m12481b("BETACLUB_SDK", "[BaseDescriptionActivity.handleMessage]ON_ATTACH");
                    FeedbackDescriptionActivity.this.onAddAttachment(String.valueOf(message.obj), 1);
                    return;
                default:
                    return;
            }
        }
    }

    class C06842 implements OnClickListener {
        C06842() {
        }

        public void onClick(View view) {
            FeedbackDescriptionActivity.this.gotoFeedbackRecordActivity();
        }
    }

    class C06853 implements OnClickListener {
        C06853() {
        }

        public void onClick(View view) {
            FeedbackDescriptionActivity.this.onOk();
        }
    }

    class C06864 implements OnClickListener {
        C06864() {
        }

        public void onClick(View view) {
            FeedbackDescriptionActivity.this.onCancel();
        }
    }

    class C06875 implements OnTouchListener {
        C06875() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 2:
                    int i = FeedbackDescriptionActivity.this.getWindow().getAttributes().softInputMode;
                    FeedbackDescriptionActivity.this.descriptionCommonComponent.getMeasuredHeight();
                    if (FeedbackDescriptionActivity.this.descriptionCommonComponent.etSummaryIsFocused() && i == 16) {
                        FeedbackDescriptionActivity.this.hideInputMethod();
                        break;
                    }
            }
            return false;
        }
    }

    class C06886 implements ServiceConnection {
        C06886() {
        }

        public void onServiceDisconnected(ComponentName componentName) {
            C2511g.m12477a("BETACLUB_SDK", "[FeedbackDescriptionActivity.connection]onServiceDisconnected");
            FeedbackDescriptionActivity.this.feedbackService = null;
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            C2511g.m12477a("BETACLUB_SDK", "[FeedbackDescriptionActivity.connection]onServiceConnected");
            RemoteFeedbackBinder remoteFeedbackBinder = (RemoteFeedbackBinder) iBinder;
            FeedbackDescriptionActivity.this.feedbackService = remoteFeedbackBinder.getService();
        }
    }

    class C06897 implements DialogInterface.OnClickListener {
        C06897() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            FeedbackDescriptionActivity.this.leaveAndClearContent();
        }
    }

    class C06908 implements DialogInterface.OnClickListener {
        C06908() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            FeedbackDescriptionActivity.this.createTbdtsIssue();
        }
    }

    class C06919 implements DialogInterface.OnClickListener {
        C06919() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            FeedbackDescriptionActivity.this.leaveAndClearContent();
        }
    }

    public interface FeedbackCallback {
        LogCollectedResult collectLogs();

        void onFailed(String str);
    }

    class StartCollectLogsTask extends AsyncTask<String, Void, LogCollectedResult> {
        private Context mContext;

        StartCollectLogsTask(Context context) {
            this.mContext = context;
        }

        protected LogCollectedResult doInBackground(String... strArr) {
            C2511g.m12481b("BETACLUB_SDK", "[FeedbackDescriptionActivity.StartCollectLogsTask] doInBackground");
            LogCollectedResult logCollectedResult = null;
            if (CrowdTestApi.getInstance().getFeedbackCallback() != null) {
                logCollectedResult = CrowdTestApi.getInstance().getFeedbackCallback().collectLogs();
                if (logCollectedResult == null) {
                    C2511g.m12481b("BETACLUB_SDK", "[FeedbackDescriptionActivity.StartCollectLogsTask.doInBackground]result == null");
                }
            } else {
                C2511g.m12481b("BETACLUB_SDK", "[FeedbackDescriptionActivity.StartCollectLogsTask.doInBackground]CrowdTestApi.getFeedbackCallback() == null");
            }
            return logCollectedResult;
        }

        protected void onPostExecute(LogCollectedResult logCollectedResult) {
            C2511g.m12481b("BETACLUB_SDK", "[FeedbackDescriptionActivity.StartCollectLogsTask] onPostExecute");
            super.onPostExecute(logCollectedResult);
            Intent intent = new Intent(SdkConstants.ACTION_LOG_COLLECT_COMPLETED);
            Bundle bundle = new Bundle();
            if (logCollectedResult == null) {
                C2511g.m12481b("BETACLUB_SDK", "[FeedbackDescriptionActivity.StartCollectLogsTask.onPostExecute]logCollectedResult == null");
                bundle.putInt(SdkConstants.LOG_COLLECT_STATUS, 201);
            } else {
                bundle.putInt(SdkConstants.LOG_COLLECT_STATUS, logCollectedResult.getStatus());
                String compressWearableLog = FeedbackUtils.compressWearableLog(this.mContext, logCollectedResult.getLogPath());
                if (!StringUtils.isNullOrEmpty(compressWearableLog)) {
                    C2511g.m12481b("BETACLUB_SDK", "[LogCollectResultBroadcastReceiver.onReceive] wearableLogPath " + compressWearableLog);
                    bundle.putString(SdkConstants.LOG_COLLECT_PATH, compressWearableLog);
                }
            }
            intent.putExtras(bundle);
            this.mContext.sendBroadcast(intent, SdkConstants.USE_CROWDTESTSDK_PERMISSION);
            C2511g.m12481b("BETACLUB_SDK", "[FeedbackDescriptionActivity.StartCollectLogsTask.onPostExecute] send broadcast RemoteFeedbackService");
        }
    }

    protected void initLayout() {
        setContentView(ResUtil.getResId(this, "sdk_crowdtest_activity_feedback_description", ResUtil.TYPE_LAYOUT));
    }

    protected void initView() {
        this.mTitleBarLayout = (TitleBarLayout) findViewById(ResUtil.getResId(this, "sdk_crowdtest_title_bar_layout", "id"));
        this.mScrollView = (ScrollView) findViewById(ResUtil.getResId(this, "sdk_crowdtest_feedback_record_scroll_view", "id"));
        this.mFeedbackRecordLayout = (ViewGroup) findViewById(ResUtil.getResId(this, "sdk_crowdtest_feedback_record_group", "id"));
        this.mFeedbackRecordLayout.setOnClickListener(new C06842());
        this.onOkBtn = (Button) findViewById(ResUtil.getResId(this, "sdk_crowdtest_description_ok_button", "id"));
        this.onCancelBtn = (Button) findViewById(ResUtil.getResId(this, "sdk_crowdtest_description_cancel_button", "id"));
        this.onOkBtn.setOnClickListener(new C06853());
        this.onCancelBtn.setOnClickListener(new C06864());
        this.descriptionCommonComponent = (DescriptionCommonComponent) findViewById(ResUtil.getResId(this, "sdk_crowdtest_description_common_component", "id"));
        this.descriptionLastVersionExistsComponent = (DescriptionLastVersionExistsComponent) findViewById(ResUtil.getResId(this, "sdk_crowdtest_description_last_version_component", "id"));
        this.descriptionDetailEditComponent = (DescriptionDetailEditComponent) findViewById(ResUtil.getResId(this, "sdk_crowdtest_description_detail_edit_component", "id"));
        this.descriptionAttachmentComponent = (DescriptionAttachmentComponent) findViewById(ResUtil.getResId(this, "sdk_crowdtest_description_attachment_component", "id"));
        this.descriptionAttachmentComponent.setOnAddOtherAttachmentCallback(this.onAddOtherAttachmentCallback);
        this.descriptionAttachmentComponent.setOnAddCameraAttachmentCallback(this.onAddCameraAttachmentCallback);
        this.mScrollView.setOnTouchListener(new C06875());
    }

    public void hideInputMethod() {
        ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(getWindow().getDecorView().getApplicationWindowToken(), 0);
    }

    protected void setTitle() {
        initTitleBar(ResUtil.getResId(this, "sdk_crowdtest_icon_feedback_title", ResUtil.TYPE_DRAWABLE), ResUtil.getResId(this, "sdk_crowdtest_text_feedback_title", ResUtil.TYPE_STRING));
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initDate();
    }

    private void initDate() {
        getData(getIntent());
        this.productType = C2514j.m12526d();
        C2511g.m12481b("BETACLUB_SDK", "[FeedbackDescriptionActivity.onCreate]productType:" + this.productType);
        if (this.productType != -1) {
            initIssueMaker();
        }
    }

    private void getData(Intent intent) {
        C2511g.m12481b("BETACLUB_SDK", "[FeedbackDescriptionActivity.getData] is called!");
        if (intent != null) {
            Bundle extras = intent.getExtras();
            if (extras != null) {
                parseFeedbackParam(extras);
                this.appVersionName = extras.getString(SdkConstants.APP_VERSION_NAME, "");
                this.bugTypeId = extras.getInt(IntegrationConstants.BUG_TYPE, 105);
                this.issueType = IssueTypeParser.getIssueTypeByBugTypeId(this.bugTypeId);
                C2511g.m12481b("BETACLUB_SDK", "[FeedbackDescriptionActivity.getData]BugTypeId:" + this.bugTypeId);
                return;
            }
            C2511g.m12481b("BETACLUB_SDK", "[FeedbackDescriptionActivity.initDate] bundle is null!");
        }
    }

    private void parseFeedbackParam(Bundle bundle) {
        FeedbackParams feedbackParams = (FeedbackParams) bundle.getParcelable(SdkConstants.FEEDBACK_PARAMS);
        if (feedbackParams == null) {
            C2511g.m12481b("BETACLUB_SDK", "[FeedbackDescriptionActivity.parseFeedbackParam] feedbackParam is null!");
            return;
        }
        this.deviceId = feedbackParams.getDeviceId() != null ? feedbackParams.getDeviceId() : "";
        this.productName = feedbackParams.getProductName() != null ? feedbackParams.getProductName() : "crowdtest";
        this.productVersion = feedbackParams.getProductVersion() != null ? feedbackParams.getProductVersion() : "unknown";
        this.routerBrand = feedbackParams.getRouterBrand() != null ? feedbackParams.getRouterBrand() : "";
        this.hardwareVersion = feedbackParams.getHardwareVersion() != null ? feedbackParams.getHardwareVersion() : "";
        C2514j.m12521b(this, this.deviceId);
    }

    private void initIssueMaker() {
        this.issueMaker = IssueMakerFactory.newIssueMaker(getApplicationContext(), this.device, this.bugTypeId);
        this.issueMakerId = this.issueMaker.getId();
        this.device = new CommonDevice(new DeviceHelper(this.productType));
        this.device.setDeviceId(this.deviceId);
        this.device.setVersionName(this.productVersion);
        this.device.setProductName(this.productName);
        this.issueMaker.setDevice(this.device);
        C2511g.m12481b("BETACLUB_SDK", "[FeedbackDescriptionActivity.onCreate]issueMaker Id:" + this.issueMaker.getId());
    }

    protected void bindFeedbackService() {
        C2511g.m12481b("BETACLUB_SDK", "[RemoteBaseDescriptionActivity.bindFeedbackService]start...");
        Intent intent = new Intent(this, RemoteFeedbackService.class);
        intent.putExtra("ShowNotification", true);
        intent.setAction(SdkConstants.ACTION_BIND_FEEDBACK_SERVICE);
        startService(intent);
        bindService(intent, this.connection, 1);
    }

    protected void unBindFeedbackService() {
        C2511g.m12481b("BETACLUB_SDK", "[RemoteBaseDescriptionActivity.unBindFeedbackService]start...");
        try {
            unbindService(getServiceConnection());
        } catch (Exception e) {
            C2511g.m12481b("BETACLUB_SDK", "[FeedbackDescriptionActivity.unBindFeedbackService]unbindService Exception");
        }
    }

    private void gotoFeedbackRecordActivity() {
        C2511g.m12481b("BETACLUB_SDK", "[FeedbackDescriptionActivity.gotoFeedbackRecordActivity] is called!");
        startActivity(new Intent(this, HistoryActivity.class));
    }

    public void onOk() {
        hideInputMethod();
        if (!checkSendAvailable()) {
            return;
        }
        if (NetworkUtils.checkNetworkStatus(this)) {
            showStartCreateTbdtsIssue();
        } else {
            showSaveAlertDialogOnNetError();
        }
    }

    public void onCancel() {
        hideInputMethod();
        showDropAlertDialog();
    }

    protected boolean checkSendAvailable() {
        return this.descriptionCommonComponent.checkSendAvailable() && this.descriptionDetailEditComponent.checkSendAvailable() && this.descriptionLastVersionExistsComponent.checkSendAvailable() && this.descriptionAttachmentComponent.checkSendAvailable();
    }

    public void showDropAlertDialog() {
        Builder builder = new Builder(this);
        builder.setTitle(ResUtil.getResId(this, "sdk_crowdtest_login_activity_text_login_hint", ResUtil.TYPE_STRING));
        builder.setMessage(ResUtil.getResId(this, "sdk_crowdtest_description_fragment_hint_back", ResUtil.TYPE_STRING));
        builder.setPositiveButton(ResUtil.getResId(this, "sdk_crowdtest_description_fragment_ok", ResUtil.TYPE_STRING), new C06897());
        builder.setNegativeButton(ResUtil.getResId(this, "sdk_crowdtest_description_fragment_issue_button_text_cancel", ResUtil.TYPE_STRING), null);
        builder.show();
    }

    private void showStartCreateTbdtsIssue() {
        C2511g.m12481b("BETACLUB_SDK", "[FeedbackDescriptionActivity.showStartCreateTbdtsIssue]start...");
        C2513i.m12495a((Context) this, ResUtil.getResId(this, "sdk_crowdtest_description_confirmation_hint", ResUtil.TYPE_STRING), new C06908());
    }

    private void leaveAndClearContent() {
        toHome();
    }

    public void showSaveAlertDialogOnNetError() {
        Builder builder = new Builder(this);
        builder.setMessage(ResUtil.getResId(this, "sdk_crowdtest_disconnection_save_draft_notes", ResUtil.TYPE_STRING));
        builder.setTitle(ResUtil.getResId(this, "sdk_crowdtest_login_activity_text_login_hint", ResUtil.TYPE_STRING));
        builder.setPositiveButton(ResUtil.getResId(this, "sdk_crowdtest_text_ok", ResUtil.TYPE_STRING), new C06919());
        builder.setNegativeButton(ResUtil.getResId(this, "sdk_crowdtest_text_cancel", ResUtil.TYPE_STRING), null);
        builder.show();
    }

    public void createTbdtsIssue() {
        TbdtsCreationUnit tbdtsCreationUnit = new TbdtsCreationUnit();
        tbdtsCreationUnit.setPROJECT_ID(this.descriptionCommonComponent.getActivityId());
        tbdtsCreationUnit.setNEW_QUES_TYPE(this.issueType.getBetaTypeId());
        tbdtsCreationUnit.setRECURE(this.descriptionCommonComponent.getProbabilityText());
        tbdtsCreationUnit.setDESCRIPTION(makeTbdtsIssueDescription());
        tbdtsCreationUnit.setUSER_ACCOUNT(C2514j.m12523c());
        tbdtsCreationUnit.setAPPEAR_DATE(this.descriptionCommonComponent.getOccurrenceTimeTextFormat());
        tbdtsCreationUnit.setAPPEAR_TIME_ZONE(this.descriptionCommonComponent.getOccurrenceTimeZone());
        fillUnitSpecial(tbdtsCreationUnit);
        C2511g.m12477a("BETACLUB_SDK", "[FeedbackDescriptionActivity.createTbdtsIssue]create unit : " + tbdtsCreationUnit.toJsonString());
        try {
            if (tbdtsCreationUnit.toJsonString().getBytes("utf-8").length >= 4000) {
                C2511g.m12477a("BETACLUB_SDK", "[FeedbackDescriptionActivity.createTbdtsIssue]create unit content too long! ");
                ToastUtil.showLongToast((Context) this, ResUtil.getResId(this, "sdk_crowdtest_description_detail_too_long", ResUtil.TYPE_STRING));
                return;
            }
        } catch (UnsupportedEncodingException e) {
            C2511g.m12477a("BETACLUB_SDK", "[FeedbackDescriptionActivity.createTbdtsIssue]" + e);
        }
        this.createIssueTask = new CreateIssueTask(this);
        this.createIssueTask.onCreation(tbdtsCreationUnit, new OnCreationCallback() {
            public void callback(TbdtsStatus tbdtsStatus) {
                if (tbdtsStatus == null) {
                    FeedbackDescriptionActivity.this.onCreateTbdtsFailed(0);
                    return;
                }
                C2511g.m12481b("BETACLUB_SDK", "[FeedbackDescriptionActivity.createTbdtsIssue.onCreation]callback issueStatus :" + tbdtsStatus.toString());
                if (CreateIssueTask.parseTbdtsStatus(tbdtsStatus)) {
                    String tbdtsQuesNo = tbdtsStatus.getTbdtsQuesNo();
                    if (StringUtils.isNullOrEmpty(tbdtsQuesNo)) {
                        FeedbackDescriptionActivity.this.onCreateTbdtsFailed(0);
                        return;
                    } else {
                        FeedbackDescriptionActivity.this.onCreateTbdtsSucceed(tbdtsQuesNo);
                        return;
                    }
                }
                FeedbackDescriptionActivity.this.onCreateTbdtsFailed(tbdtsStatus.getStatus());
            }
        });
    }

    public List<String> getAttachmentList() {
        if (this.descriptionAttachmentComponent != null) {
            return this.descriptionAttachmentComponent.getAttachmentList();
        }
        return null;
    }

    protected void onCreateTbdtsSucceed(final String str) {
        C2511g.m12481b("BETACLUB_SDK", "[FeedbackDescriptionActivity.onCreateTbdtsSucceed]is called");
        this.tbdtsNo = str;
        ToastUtil.showLongToast((Context) this, String.format(getString(ResUtil.getResId(this, "sdk_crowdtest_description_fragment_create_tbdts_success", ResUtil.TYPE_STRING)), new Object[]{this.tbdtsNo}));
        uploadVersionInfo();
        final BugInfo makeBugInfo = makeBugInfo();
        String str2 = SdkConstants.getTempTargetLogPath(this) + DateTimeUtils.getCurrentDateTimeStr().replace(HwAccountConstants.BLANK, "-").replace(":", "-") + ".jpg";
        if (C2513i.m12498a(this.mScrollView, str2) && new File(str2).exists()) {
            onAddAttachment(str2, 1);
        }
        if (NetworkUtils.getNetworkType(this) == 1) {
            C2511g.m12481b("BETACLUB_SDK", "[FeedbackDescriptionActivity.onCreateTbdtsSucceed] netType is WIFI");
            startCollectLogsAfterSubmitSuccess(str);
            DBItemSet makeDbItemSet = makeDbItemSet(SEND_TYPE.SEND_ON_WIFI);
            if (this.feedbackService != null) {
                C2511g.m12481b("BETACLUB_SDK", "[FeedbackDescriptionActivity.onCreateTbdtsSucceed]——> null != feedbackService");
                setLogPath(makeDbItemSet);
                this.feedbackService.startPackageBug(this.issueMaker, this.mUri, makeDbItemSet, makeBugInfo, getAttachmentList(), SEND_TYPE.SEND_ON_WIFI, this.isNewFeedback);
                C2511g.m12481b("BETACLUB_SDK", "[FeedbackDescriptionActivity.onCreateTbdtsSucceed] insert db");
            } else {
                C2511g.m12481b("BETACLUB_SDK", "[FeedbackDescriptionActivity.onCreateTbdtsSucceed]——> null != feedbackService");
            }
            leaveAndClearContent();
            return;
        }
        Builder builder = new Builder(this);
        builder.setTitle(ResUtil.getResId(this, "sdk_crowdtest_login_activity_text_login_hint", ResUtil.TYPE_STRING));
        builder.setMessage(ResUtil.getResId(this, "sdk_crowdtest_description_fragment_msg_not_wifi_network", ResUtil.TYPE_STRING));
        builder.setCancelable(false);
        builder.setPositiveButton(ResUtil.getResId(this, "sdk_crowdtest_description_fragment_send_now", ResUtil.TYPE_STRING), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                FeedbackDescriptionActivity.this.startCollectLogsAfterSubmitSuccess(str);
                C2511g.m12481b("BETACLUB_SDK", "[FeedbackDescriptionActivity.onCreateTbdtsSucceed]SendType.SEND_TYPE.SEND_NOW——>collectLogs");
                DBItemSet access$500 = FeedbackDescriptionActivity.this.makeDbItemSet(SEND_TYPE.SEND_NOW);
                if (FeedbackDescriptionActivity.this.feedbackService != null) {
                    C2511g.m12481b("BETACLUB_SDK", "[FeedbackDescriptionActivity.onCreateTbdtsSucceed]SendType.SEND_TYPE.SEND_NOW——> null != feedbackService");
                    FeedbackDescriptionActivity.this.setLogPath(access$500);
                    FeedbackDescriptionActivity.this.feedbackService.startPackageBug(FeedbackDescriptionActivity.this.issueMaker, FeedbackDescriptionActivity.this.mUri, access$500, makeBugInfo, FeedbackDescriptionActivity.this.getAttachmentList(), SEND_TYPE.SEND_NOW, FeedbackDescriptionActivity.this.isNewFeedback);
                    C2511g.m12481b("BETACLUB_SDK", "[FeedbackDescriptionActivity.onCreateTbdtsSucceed] insert db");
                } else {
                    C2511g.m12481b("BETACLUB_SDK", "[FeedbackDescriptionActivity.onCreateTbdtsSucceed]SendType.SEND_TYPE.SEND_NOW——> null == feedbackService");
                }
                FeedbackDescriptionActivity.this.leaveAndClearContent();
            }
        });
        builder.setNegativeButton(ResUtil.getResId(this, "sdk_crowdtest_description_fragment_send_on_wifi", ResUtil.TYPE_STRING), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                FeedbackDescriptionActivity.this.startCollectLogsAfterSubmitSuccess(str);
                C2511g.m12481b("BETACLUB_SDK", "[FeedbackDescriptionActivity.onCreateTbdtsSucceed]SendType.SEND_TYPE.SEND_ON_WIFI——> collectLogs");
                DBItemSet access$500 = FeedbackDescriptionActivity.this.makeDbItemSet(SEND_TYPE.SEND_ON_WIFI);
                if (FeedbackDescriptionActivity.this.feedbackService != null) {
                    C2511g.m12481b("BETACLUB_SDK", "[FeedbackDescriptionActivity.onCreateTbdtsSucceed]SendType.SEND_TYPE.SEND_ON_WIFI——> null != feedbackService");
                    FeedbackDescriptionActivity.this.setLogPath(access$500);
                    FeedbackDescriptionActivity.this.feedbackService.startPackageBug(FeedbackDescriptionActivity.this.issueMaker, FeedbackDescriptionActivity.this.mUri, access$500, makeBugInfo, FeedbackDescriptionActivity.this.getAttachmentList(), SEND_TYPE.SEND_ON_WIFI, FeedbackDescriptionActivity.this.isNewFeedback);
                    C2511g.m12481b("BETACLUB_SDK", "[FeedbackDescriptionActivity.onCreateTbdtsSucceed] insert db");
                }
                FeedbackDescriptionActivity.this.leaveAndClearContent();
            }
        });
        builder.show();
    }

    private void uploadVersionInfo() {
        C2511g.m12481b("BETACLUB_SDK", "[FeedbackDescriptionActivity.uploadVersionInfo]is called!");
        GroupMemberItem groupMemberItem = new GroupMemberItem();
        String b = C2514j.m12519b();
        String str = Build.MODEL;
        String deviceVersion = PhoneInfo.getDeviceVersion();
        String str2 = VERSION.RELEASE;
        groupMemberItem.setUserId(b);
        groupMemberItem.setPhoneModel(str);
        groupMemberItem.setPhoneVer(deviceVersion);
        groupMemberItem.setPhoneAndroidVer(str2);
        ImeiItem imeiItem = new ImeiItem();
        imeiItem.setUserId(b);
        ProductVersionItem productVersionItem = new ProductVersionItem();
        productVersionItem.setUserId(b);
        String activityId = this.descriptionCommonComponent.getActivityId();
        if (!StringUtils.isNullOrEmpty(this.deviceId)) {
            ReportInfoUtils.reportFeedbackInfo(this, this.mHandler, imeiItem, productVersionItem, groupMemberItem, activityId, this.deviceId, this.productVersion, this.routerBrand, this.appVersionName, this.hardwareVersion);
        }
    }

    private void setLogPath(DBItemSet dBItemSet) {
        dBItemSet.logPath = ((RemoteFeedbackService) this.feedbackService).getLogPath();
        C2511g.m12481b("BETACLUB_SDK", "[FeedbackDescriptionActivity.onCreateTbdtsSucceed]dbItemSet.logPath——>" + dBItemSet.logPath);
    }

    private void startCollectLogsAfterSubmitSuccess(String str) {
        new StartCollectLogsTask(this).execute(new String[0]);
        C2511g.m12481b("BETACLUB_SDK", "[FeedbackDescriptionActivity.startCollectLogsAfterSubmitSuccess]StartCollectLogsTask is running!");
    }

    protected void onCreateTbdtsFailed(int i) {
        CreateIssueTask.parseTbdtsStatusRetCode(this, i);
    }

    private String makeTbdtsIssueDescription() {
        StringBuffer stringBuffer = new StringBuffer(getDescription());
        if (!StringUtils.isNullOrEmpty(this.descriptionDetailEditComponent.getDetailString())) {
            stringBuffer.append(SdkConstants.DESCRIPTION_SEPARATOR);
        }
        stringBuffer.append(getDeviceMoreInfo(this));
        C2511g.m12481b("BETACLUB_SDK", "[FeedbackDescriptionActivity.makeTbdtsIssueDescription]getDescription getPhoneInfo");
        return stringBuffer.toString();
    }

    public String getDeviceMoreInfo(Context context) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(System.getProperty("line.separator")).append("手机厂商：").append(Build.MANUFACTURER).append(System.getProperty("line.separator")).append("手机型号：").append(Build.MODEL).append(System.getProperty("line.separator")).append("手机版本：").append(VERSION.INCREMENTAL).append(System.getProperty("line.separator")).append("手机IMEI/MEID：").append(PhoneInfo.getDeviceId(context)).append(System.getProperty("line.separator")).append("手机EMUI版本：").append(SdkConstants.getEmuiVersion()).append(System.getProperty("line.separator")).append("安卓版本：").append(VERSION.RELEASE).append(System.getProperty("line.separator"));
        return stringBuffer.toString();
    }

    protected String getDescription() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.descriptionCommonComponent.getDescription()).append(this.descriptionLastVersionExistsComponent.getLastVersionExistsString()).append(this.descriptionDetailEditComponent.getDetailString());
        String stringBuffer2 = stringBuffer.toString();
        C2511g.m12481b("BETACLUB_SDK", "[FeedbackDescriptionActivity.getDescription]Description:" + stringBuffer2);
        return stringBuffer2;
    }

    protected String getInsertDBDescription() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.descriptionCommonComponent.getDescription());
        String stringBuffer2 = stringBuffer.toString();
        C2511g.m12481b("BETACLUB_SDK", "[FeedbackDescriptionActivity.getInsertDBDescription]Description:" + stringBuffer2);
        return stringBuffer2;
    }

    private BugInfo makeBugInfo() {
        String description = getDescription();
        BugInfo bugInfo = new BugInfo();
        bugInfo.setContext(getApplicationContext());
        bugInfo.setmBugType(this.issueType.getBetaTypeId());
        bugInfo.setmProbability(this.descriptionCommonComponent.getProbabilityText());
        bugInfo.setmDescription(description);
        bugInfo.setQuesNo(this.tbdtsNo);
        return bugInfo;
    }

    protected void fillUnitSpecial(TbdtsCreationUnit tbdtsCreationUnit) {
        tbdtsCreationUnit.setPRODB_NO(getVersionNo());
        tbdtsCreationUnit.setIMEI_NO(getDeviceId());
        tbdtsCreationUnit.setPHONE_MODEL(PhoneInfo.getDeviceModel());
        tbdtsCreationUnit.setPHONE_VER(PhoneInfo.getDeviceFullVersion());
    }

    protected String getDeviceId() {
        return this.deviceId;
    }

    protected String getVersionNo() {
        return this.productVersion;
    }

    public CommonDevice getDevice() {
        return this.device;
    }

    private DBItemSet makeDbItemSet(SEND_TYPE send_type) {
        String insertDBDescription = getInsertDBDescription();
        String activityId = this.descriptionCommonComponent.getActivityId();
        String str = "";
        CommonDevice device = getDevice();
        int probabilityIndex = this.descriptionCommonComponent.getProbabilityIndex();
        long occurrenceTime = this.descriptionCommonComponent.getOccurrenceTime();
        List cameraAttachList = this.descriptionAttachmentComponent.getCameraAttachList();
        List otherAttachList = this.descriptionAttachmentComponent.getOtherAttachList();
        if (send_type == SEND_TYPE.DRAFT) {
            int hashCode = UUID.randomUUID().hashCode();
            while (hashCode == Integer.MIN_VALUE) {
                hashCode = UUID.randomUUID().hashCode();
            }
            this.tbdtsNo = String.valueOf((long) (0 - Math.abs(hashCode)));
        }
        return new DBItemSet(0, 100, insertDBDescription, probabilityIndex, occurrenceTime, this.mCompressedLogPath, null, null, cameraAttachList, otherAttachList, activityId, str, device.getDeviceHelper(), this.tbdtsNo, CREATE_TYPE.NEW.ordinal(), send_type.ordinal(), this.issueMakerId);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        C2511g.m12481b("BETACLUB_SDK", "[FeedbackDescriptionActivity.onRequestPermissionsResult] request permission callback");
        switch (i) {
            case 1:
                C2511g.m12481b("BETACLUB_SDK", "[FeedbackDescriptionActivity.onRequestPermissionsResult] take photo");
                if (iArr[0] == 0 && this.descriptionAttachmentComponent != null) {
                    this.descriptionAttachmentComponent.takePhoto(this);
                    return;
                }
                return;
            case 2:
                C2511g.m12481b("BETACLUB_SDK", "[FeedbackDescriptionActivity.onRequestPermissionsResult] take video");
                if (iArr[0] == 0 && this.descriptionAttachmentComponent != null) {
                    this.descriptionAttachmentComponent.takeVideo(this);
                    return;
                }
                return;
            case 3:
                if (iArr[0] == 0) {
                    C2511g.m12481b("BETACLUB_SDK", "[FeedbackDescriptionActivity.onRequestPermissionsResult] go to photo selector");
                    if (this.descriptionAttachmentComponent != null) {
                        this.descriptionAttachmentComponent.goToPhotoSelector(this);
                        return;
                    }
                    return;
                }
                return;
            case 4:
                if (iArr[0] == 0) {
                    C2511g.m12481b("BETACLUB_SDK", "[FeedbackDescriptionActivity.onRequestPermissionsResult] take video");
                    if (this.descriptionAttachmentComponent != null) {
                        this.descriptionAttachmentComponent.goToFileChooser(this);
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        ArrayList arrayList = null;
        String string;
        switch (i) {
            case SdkConstants.REQUEST_GALLERY /*321*/:
                switch (i2) {
                    case -1:
                        if (intent != null) {
                            try {
                                arrayList = intent.getExtras().getStringArrayList("pathList");
                            } catch (Throwable e) {
                                C2511g.m12482b("BETACLUB_SDK", "[FeedbackDescriptionActivity.onActivityResult]REQUEST_GALLERY error", e);
                            }
                            if (arrayList != null) {
                                Iterator it = arrayList.iterator();
                                while (it.hasNext()) {
                                    String str = (String) it.next();
                                    C2511g.m12481b("BETACLUB_SDK", "[FeedbackDescriptionActivity.onActivityResult]Add each Path:" + str);
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
                                string = query.getString(1);
                                query.close();
                                onAddAttachment(string, 0);
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
                            string = FileUtils.getFilePathFromUri(this, data);
                            C2511g.m12477a("BETACLUB_SDK", "[FeedbackDescriptionActivity.onActivityResult]Camera video, add URI:" + data);
                            C2511g.m12477a("BETACLUB_SDK", "[FeedbackDescriptionActivity.onActivityResult]Camera video, add Path:" + string);
                            onAddAttachment(string, 0);
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

    public void onBackPressed() {
        super.onBackPressed();
        leaveAndClearContent();
    }

    protected void toHome() {
        finish();
    }

    protected ServiceConnection getServiceConnection() {
        return this.connection;
    }
}
