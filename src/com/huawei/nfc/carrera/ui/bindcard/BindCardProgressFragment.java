package com.huawei.nfc.carrera.ui.bindcard;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.huawei.nfc.carrera.constant.AutoReportErrorCode;
import com.huawei.nfc.carrera.logic.cardoperate.opencardlogupload.LogUploadOperator;
import com.huawei.nfc.carrera.ui.bus.exception.ShowBindBusResultActivity;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.logger.CloudEyeLogger;
import com.huawei.wallet.R;
import com.unionpay.tsmservice.data.Constant;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

public class BindCardProgressFragment extends Fragment {
    private static final int BIND_CARD_BINDING = 10;
    private static final int BIND_CARD_FAIL = 1;
    private static final int BIND_CARD_PROGRESS = 14;
    private static final int BIND_CARD_SUCCESS = 0;
    private static final float PERCENT_MARGIN_TOP = 0.3f;
    private TextView bindCardResult;
    private TextView bindCardResultCode;
    private final Handler handler = new C55761();
    private LinearLayout ll_ani_view;
    private LinearLayout ll_result;
    private Button nextButton;
    private ImageView nfcBindCardSuccessFg;
    private int pro = 0;
    private ProgressBar progress;
    private ShownBindSuccessEndListener successListener;

    class C55761 extends Handler {
        C55761() {
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 0:
                    BindCardProgressFragment.this.successListener.bindSuccess(0);
                    return;
                case 1:
                    LogX.i("===123===BIND_CARD_FAIL");
                    BindCardProgressFragment.this.ll_ani_view.setVisibility(4);
                    BindCardProgressFragment.this.ll_result.setVisibility(0);
                    BindCardProgressFragment.this.nfcBindCardSuccessFg.setImageResource(R.drawable.ic_failure_normal);
                    final ErrorInfo errorInfo = (ErrorInfo) message.obj;
                    BindCardProgressFragment.this.nextButton.setOnClickListener(new OnClickListener() {
                        public void onClick(View view) {
                            LogX.i("error operate type, jump to card list");
                            BindCardProgressFragment.this.successListener.bindSuccess(errorInfo.oprType);
                        }
                    });
                    LogX.i("===123===errorInfo.oprType" + errorInfo.oprType);
                    BindCardProgressFragment.this.bindCardResult.setText(getResultTxt(errorInfo.oprType));
                    BindCardProgressFragment.this.nextButton.setText(getBtnText(errorInfo.oprType));
                    BindCardProgressFragment.this.nextButton.setVisibility(0);
                    BindCardProgressFragment.this.bindCardResultCode.setText(errorInfo.strErrorMsg);
                    return;
                case 10:
                    BindCardProgressFragment.this.pro = 0;
                    BindCardProgressFragment.this.progress.setProgress(BindCardProgressFragment.this.pro);
                    BindCardProgressFragment.this.ll_ani_view.setVisibility(0);
                    BindCardProgressFragment.this.ll_result.setVisibility(4);
                    BindCardProgressFragment.this.progressStart();
                    return;
                case 14:
                    if (BindCardProgressFragment.this.pro < 1720) {
                        BindCardProgressFragment.this.pro = BindCardProgressFragment.this.pro + getRandomNum();
                        BindCardProgressFragment.this.progress.setProgress(BindCardProgressFragment.this.pro);
                        sendEmptyMessageDelayed(14, 1800);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }

        private String getResultTxt(int i) {
            String access$1000 = BindCardProgressFragment.this.getStringByID(R.string.nfc_bind_card_fail);
            switch (i) {
                case 5:
                    return BindCardProgressFragment.this.getStringByID(R.string.nfc_rebind_fail);
                default:
                    return access$1000;
            }
        }

        private int getRandomNum() {
            return (new SecureRandom().nextInt(1) * 5) + 15;
        }

        private String getBtnText(int i) {
            String access$1000 = BindCardProgressFragment.this.getStringByID(R.string.nfc_quick_pass_button_text);
            switch (i) {
                case 1:
                    return BindCardProgressFragment.this.getStringByID(R.string.nfc_quick_pass_button_text);
                case 2:
                    return BindCardProgressFragment.this.getStringByID(R.string.nfc_input_bank_card_info_again);
                case 3:
                    return BindCardProgressFragment.this.getStringByID(R.string.nfc_rebind);
                case 4:
                    return BindCardProgressFragment.this.getStringByID(R.string.nfc_contact_to_bank_client);
                case 5:
                    return BindCardProgressFragment.this.getStringByID(R.string.nfc_ok);
                case 6:
                    return BindCardProgressFragment.this.getStringByID(R.string.nfc_contact_to_huawei_client);
                default:
                    return access$1000;
            }
        }
    }

    class ErrorInfo {
        int oprType;
        String strErrorMsg;

        ErrorInfo() {
        }
    }

    public BindCardProgressFragment(ShownBindSuccessEndListener shownBindSuccessEndListener) {
        this.successListener = shownBindSuccessEndListener;
    }

    private void progressStart() {
        this.handler.sendEmptyMessage(14);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.nfc_fragment_bind_card, viewGroup, false);
        initViews(inflate);
        return inflate;
    }

    private void initViews(View view) {
        this.ll_ani_view = (LinearLayout) view.findViewById(R.id.ll_ani_view);
        this.progress = (ProgressBar) view.findViewById(R.id.progress);
        this.ll_result = (LinearLayout) view.findViewById(R.id.ll_result);
        this.nfcBindCardSuccessFg = (ImageView) view.findViewById(R.id.nfc_bind_card_success_fg);
        this.bindCardResult = (TextView) view.findViewById(R.id.bind_card_result);
        this.bindCardResultCode = (TextView) view.findViewById(R.id.bind_card_result_code);
        this.nextButton = (Button) view.findViewById(R.id.nfc_next_step_button);
    }

    public void binding() {
        this.handler.sendEmptyMessage(10);
    }

    public void showBindSuccessView(String str, int i) {
        openCardLogUpload(str, "0", "", i);
        this.handler.sendEmptyMessage(0);
    }

    public void bindFailed(int i, String str, int i2) {
        ErrorInfo dealBindCardErrorCode = dealBindCardErrorCode(i);
        if (!(-3 == i || -4 == i)) {
            String str2 = dealBindCardErrorCode.strErrorMsg;
            Map hashMap = new HashMap();
            hashMap.put(ShowBindBusResultActivity.FAIL_REASON_KEY, str2);
            hashMap.put(CloudEyeLogger.FAIL_CODE, String.valueOf(i));
            hashMap.put("issuerId", str);
            hashMap.put(Constant.KEY_CARD_TYPE, String.valueOf(i2));
            LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_CUP_CARD_INFO_CHECK_ERR, hashMap, str2, false, false);
        }
        if (i == -1 || i == -2 || i == -14 || i == -18 || i == -19 || i == -99) {
            openCardLogUpload(str, String.valueOf(i), dealBindCardErrorCode.strErrorMsg, i2);
        }
        this.handler.sendMessage(this.handler.obtainMessage(1, dealBindCardErrorCode));
    }

    private ErrorInfo dealBindCardErrorCode(int i) {
        ErrorInfo errorInfoOnce = getErrorInfoOnce(i);
        if (errorInfoOnce == null) {
            return getErrorInfoSecondTime(i);
        }
        return errorInfoOnce;
    }

    private ErrorInfo getErrorInfoOnce(int i) {
        LogX.i("===123===getErrorInfoOnce resultCode = " + i);
        ErrorInfo errorInfo = new ErrorInfo();
        switch (i) {
            case -16:
            case -6:
                errorInfo.oprType = 1;
                errorInfo.strErrorMsg = getStringByID(R.string.nfc_bind_card_fail_open_overcount);
                return errorInfo;
            case -9:
                errorInfo.oprType = 2;
                errorInfo.strErrorMsg = getStringByID(R.string.nfc_bind_card_fail_card_information_check);
                return errorInfo;
            case -7:
                errorInfo.oprType = 1;
                errorInfo.strErrorMsg = getStringByID(R.string.nfc_bind_card_fail_apply_overcount);
                return errorInfo;
            case -4:
                errorInfo.oprType = 3;
                errorInfo.strErrorMsg = getStringByID(R.string.nfc_card_instruction_delete_desc_new);
                return errorInfo;
            case -3:
                errorInfo.oprType = 3;
                errorInfo.strErrorMsg = getStringByID(R.string.nfc_bindcard_error_no_network_failed);
                return errorInfo;
            default:
                return null;
        }
    }

    private ErrorInfo getErrorInfoSecondTime(int i) {
        ErrorInfo errorInfo = new ErrorInfo();
        switch (i) {
            case -20:
                errorInfo.oprType = 6;
                errorInfo.strErrorMsg = getStringByID(R.string.nfc_bind_fail_contact_unionpay);
                break;
            case -19:
                errorInfo.oprType = 5;
                errorInfo.strErrorMsg = getStringByID(R.string.nfc_rebind_fail_add_again);
                break;
            case -17:
                errorInfo.oprType = 4;
                errorInfo.strErrorMsg = getStringByID(R.string.nfc_bind_card_fail_customer_no_permission);
                break;
            case -15:
                errorInfo.oprType = 1;
                errorInfo.strErrorMsg = getStringByID(R.string.nfc_bind_card_fail_open_reach_bank_limit);
                break;
            case -13:
                errorInfo.oprType = 4;
                errorInfo.strErrorMsg = getStringByID(R.string.nfc_bind_card_fail_account_no_cellphone);
                break;
            case -12:
                errorInfo.oprType = 4;
                errorInfo.strErrorMsg = getStringByID(R.string.nfc_bind_card_fail_account_info_invalid);
                break;
            case -11:
                errorInfo.oprType = 4;
                errorInfo.strErrorMsg = getStringByID(R.string.nfc_bind_card_fail_account_no_permission);
                break;
            case -10:
                errorInfo.oprType = 4;
                errorInfo.strErrorMsg = getStringByID(R.string.nfc_bind_card_fail_card_no_permission);
                break;
            case -8:
                errorInfo.oprType = 1;
                errorInfo.strErrorMsg = getStringByID(R.string.nfc_bind_card_fail_card_installed);
                break;
            default:
                errorInfo.oprType = 4;
                errorInfo.strErrorMsg = getStringByID(R.string.nfc_bindcard_error_others_error);
                break;
        }
        return errorInfo;
    }

    public void reBind() {
        this.nextButton.setVisibility(4);
        this.ll_ani_view.setVisibility(0);
        this.ll_result.setVisibility(4);
    }

    public void onDestroyView() {
        super.onDestroyView();
    }

    private String getStringByID(int i) {
        return getActivity().getString(i);
    }

    private void openCardLogUpload(String str, String str2, String str3, int i) {
        LogUploadOperator.getInstance(getActivity()).init(str, str2, str3, i);
    }
}
