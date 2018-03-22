package com.huawei.nfc.carrera.ui.cardlist.explanddetail;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.TextView;
import com.huawei.nfc.NFCEntranceActivity;
import com.huawei.nfc.PluginPay;
import com.huawei.nfc.PluginPayAdapter;
import com.huawei.nfc.carrera.logic.CardOperateLogicApi;
import com.huawei.nfc.carrera.logic.LogicApiFactory;
import com.huawei.nfc.carrera.logic.cardinfo.callback.QueryBankCardInfoCallback;
import com.huawei.nfc.carrera.logic.cardinfo.model.BankCardInfo;
import com.huawei.nfc.carrera.logic.cardoperate.bus.callback.IssueTrafficCardCallback;
import com.huawei.nfc.carrera.logic.cardoperate.bus.callback.QueryAndHandleUnfinishedOrderCallback;
import com.huawei.nfc.carrera.logic.cardoperate.bus.model.OrderHandleResultInfo;
import com.huawei.nfc.carrera.logic.cardoperate.opencardlogupload.LogUploadOperator;
import com.huawei.nfc.carrera.ui.bindcard.ActiveCardActivity;
import com.huawei.nfc.carrera.ui.bindcard.VerifySmsCodeActivity;
import com.huawei.nfc.carrera.ui.bus.exception.ShowBindBusResultActivity;
import com.huawei.nfc.carrera.ui.bus.util.TimeUtil;
import com.huawei.nfc.carrera.ui.carddetail.CardInfoDetailActivity;
import com.huawei.nfc.carrera.ui.nullifycard.NullifyVerifyPasswordActivity;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.pay.ui.util.ToastManager;
import com.huawei.ui.commonui.dialog.C6002a;
import com.huawei.p190v.C2538c;
import com.huawei.wallet.R;
import com.huawei.wallet.model.unicard.UniCardInfo;

public class ExplandCardInstructionToActive implements OnClickListener, QueryBankCardInfoCallback, IssueTrafficCardCallback, QueryAndHandleUnfinishedOrderCallback {
    private static final String TAG = "ExplandCardInstructionToActive";
    private UniCardInfo cardListItem = null;
    protected CardOperateLogicApi cardOperateLogicManager = null;
    private Button confirmButton = null;
    private TextView descTextView = null;
    private TextView detailTextView = null;
    private BankCardInfo mBankCardInfo;
    private Context mContext;
    protected C6002a mLoadingDialog21 = null;
    private TextView titleTextView = null;

    public ExplandCardInstructionToActive(Context context) {
        this.mContext = context;
    }

    @SuppressLint({"InflateParams"})
    public View initView(int i) {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.nfc_homefragment_card_instruction_to_active, null);
        this.confirmButton = (Button) inflate.findViewById(R.id.delete_card_confirm_btn);
        this.confirmButton.setEnabled(true);
        this.confirmButton.setOnClickListener(this);
        LayoutParams layoutParams = new LayoutParams(-1, -2);
        layoutParams.height = i;
        inflate.setLayoutParams(layoutParams);
        this.titleTextView = (TextView) inflate.findViewById(R.id.cardinstru_title_delete);
        this.detailTextView = (TextView) inflate.findViewById(R.id.cardinstru_detail);
        this.detailTextView.setOnClickListener(this);
        this.descTextView = (TextView) inflate.findViewById(R.id.cardinstru_desc);
        return inflate;
    }

    public void setData(UniCardInfo uniCardInfo) {
        if (uniCardInfo != null) {
            this.cardListItem = uniCardInfo;
            switch (uniCardInfo.m28113d()) {
                case 1:
                    LogicApiFactory.createCardManager(this.mContext).queryBankCardInfo(this.cardListItem.m28110c(), this);
                    return;
                case 2:
                    this.titleTextView.setText(R.string.nfc_card_not_available_to_use);
                    this.confirmButton.setText(R.string.nfc_bind_bus_card_status_continue);
                    this.descTextView.setText(R.string.nfc_card_instruction_buscard_reopen);
                    this.cardOperateLogicManager = LogicApiFactory.createCardOperateApi(this.mContext.getApplicationContext());
                    this.cardOperateLogicManager.initEseInfo();
                    return;
                default:
                    return;
            }
        }
    }

    public void onClick(View view) {
        if (this.cardListItem != null) {
            int id = view.getId();
            if (id == R.id.cardinstru_detail) {
                clickDetailAction();
            } else if (id != R.id.delete_card_confirm_btn) {
            } else {
                if (TimeUtil.isFastDoubleClick()) {
                    LogX.e("onClick, isFastDoubleClick");
                    return;
                }
                switch (this.cardListItem.m28113d()) {
                    case 1:
                        if (this.mBankCardInfo != null) {
                            Intent intent = new Intent(this.mContext, ActiveCardActivity.class);
                            Bundle bundle = new Bundle();
                            bundle.putString("refId", this.cardListItem.m28110c());
                            bundle.putInt(VerifySmsCodeActivity.ISSUER_MODE, this.mBankCardInfo.getMode());
                            intent.putExtras(bundle);
                            this.mContext.startActivity(intent);
                            return;
                        }
                        return;
                    case 2:
                        C2538c.c(TAG, new Object[]{"onClick(),CARD_GROUP_TYPE_BUS!,cardListItem.getCardStatus()=" + this.cardListItem.m28102a()});
                        if (this.cardListItem.m28102a() == 11 || this.cardListItem.m28102a() == 12) {
                            showOpenCardProgressDialog();
                            this.cardOperateLogicManager.queryAndHandleUnfinfishedOrders(this.cardListItem.m28123j(), 0, this);
                            return;
                        } else if (this.cardListItem.m28102a() == 13) {
                            showOpenCardProgressDialog();
                            this.cardOperateLogicManager.issueTrafficCard(this.cardListItem.m28123j(), null, this);
                            return;
                        } else {
                            return;
                        }
                    default:
                        return;
                }
            }
        }
    }

    private void showOpenCardProgressDialog() {
        PluginPayAdapter pluginPayAdapter = (PluginPayAdapter) PluginPay.getInstance(this.mContext).getAdapter();
        if (pluginPayAdapter == null) {
            return;
        }
        if (pluginPayAdapter.getDeviceProtocol() == 13) {
            showLoadingDialog(this.mContext.getString(R.string.nfc_bind_bus_opening_card_new1), false, null);
        } else {
            showLoadingDialog(this.mContext.getString(R.string.nfc_bind_bus_opening_card_new), false, null);
        }
    }

    private void clickDetailAction() {
        if (this.cardListItem == null || StringUtil.isEmpty(this.cardListItem.m28107b(), true)) {
            LogX.e("the clicked card info is illegal.");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt(NullifyVerifyPasswordActivity.CARD_GROUP_TYPE, this.cardListItem.m28113d());
        bundle.putString("issuerId", this.cardListItem.m28123j());
        bundle.putString("productId", this.cardListItem.m28117f());
        bundle.putString(CardInfoDetailActivity.REFERENCE_ID, this.cardListItem.m28110c());
        Intent intent = new Intent();
        intent.setClass(this.mContext, NFCEntranceActivity.class);
        intent.setAction(NFCEntranceActivity.CARD_PACKAGE_JUMP_TO_CARD__DETAIL_ACTION);
        intent.putExtra("CARD_INFO", bundle);
        intent.setPackage(this.mContext.getPackageName());
        this.mContext.startActivity(intent);
    }

    public void queryBankCardInfoCallback(int i, BankCardInfo bankCardInfo) {
        LogX.i("queryBankCardInfo result is: " + i);
        if (i == 0 && bankCardInfo != null) {
            this.mBankCardInfo = bankCardInfo;
        } else if (i == -2) {
            ToastManager.show(this.mContext, R.string.nfc_bindcard_error_no_network_failed);
        } else if (i == -1) {
            ToastManager.show(this.mContext, R.string.nfc_bindcard_error_connection_failed);
        }
    }

    public void issueTrafficCardCallback(int i) {
        destroyLoadingDialog();
        if (i == 0) {
            openCardLogUpload(this.cardListItem.m28123j(), "0", "");
            jump2ResultActivity(this.mContext.getString(R.string.nfc_bind_bus_card_success), this.mContext.getString(R.string.nfc_bind_bus_success_decribe_text), 0, this.cardListItem.m28123j(), this.cardListItem.m28107b(), false, true);
            return;
        }
        if (1 == i || 10 == i || 23 == i || 24 == i || 25 == i || 99 == i) {
            openCardLogUpload(this.cardListItem.m28123j(), String.valueOf(i), "issueTrafficCardCallback, issue Traffic Card fail");
        }
        jump2ResultActivity(this.mContext.getString(R.string.nfc_bind_bus_card_fail), getErrorMessage(i), 1, this.cardListItem.m28123j(), this.cardListItem.m28107b(), true, true);
    }

    public void queryAndHandleUnfinishedOrderCallback(int i, int i2, OrderHandleResultInfo orderHandleResultInfo) {
        upLoadLog(i, i2, orderHandleResultInfo);
        if (i != 0) {
            destroyLoadingDialog();
            jump2ResultActivity(this.mContext.getString(R.string.nfc_bind_bus_card_fail), getErrorMessage(i), 1, this.cardListItem.m28123j(), this.cardListItem.m28107b(), true, true);
            return;
        }
        switch (i2) {
            case 10000:
                destroyLoadingDialog();
                jump2ResultActivity(this.mContext.getString(R.string.nfc_bind_bus_card_fail), getErrorMessage(i), 1, this.cardListItem.m28123j(), this.cardListItem.m28107b(), false, true);
                return;
            case 10001:
                return;
            case 10002:
                destroyLoadingDialog();
                if (orderHandleResultInfo == null || orderHandleResultInfo.getIssueCardOrderCnt() <= 0) {
                    jump2ResultActivity(this.mContext.getString(R.string.nfc_bind_bus_card_fail), getErrorMessage(i), 1, this.cardListItem.m28123j(), this.cardListItem.m28107b(), true, true);
                    return;
                }
                jump2ResultActivity(this.mContext.getString(R.string.nfc_bind_bus_card_success), this.mContext.getString(R.string.nfc_bind_bus_success_decribe_text), 0, this.cardListItem.m28123j(), this.cardListItem.m28107b(), false, true);
                LogicApiFactory.createCardManager(this.mContext).refreshCardList();
                return;
            default:
                return;
        }
    }

    private void jump2ResultActivity(String str, String str2, int i, String str3, String str4, boolean z, boolean z2) {
        Intent intent = new Intent(this.mContext, ShowBindBusResultActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("fail_desc", str);
        bundle.putString(ShowBindBusResultActivity.FAIL_REASON_KEY, str2);
        bundle.putInt(ShowBindBusResultActivity.FAIL_OPR_TYPE_KEY, i);
        bundle.putString("issuerId", str3);
        bundle.putString(ShowBindBusResultActivity.CARD_AID, str4);
        bundle.putBoolean(ShowBindBusResultActivity.RETRY_KEY, z);
        bundle.putBoolean(ShowBindBusResultActivity.OPENCARD_KEY, z2);
        intent.putExtras(bundle);
        this.mContext.startActivity(intent);
    }

    protected void showLoadingDialog(String str, boolean z, OnCancelListener onCancelListener) {
        if (this.mLoadingDialog21 == null) {
            C6002a c6002a = new C6002a(this.mContext, R.style.app_update_dialogActivity);
            this.mLoadingDialog21 = C6002a.m27468a(this.mContext);
            this.mLoadingDialog21.m27476a(str);
            this.mLoadingDialog21.setOnCancelListener(onCancelListener);
            this.mLoadingDialog21.setCancelable(z);
            this.mLoadingDialog21.m27474a();
        }
        if (this.mLoadingDialog21 != null) {
            this.mLoadingDialog21.show();
            C2538c.c(TAG, new Object[]{"mLoadingDialog.show()"});
        }
    }

    protected void destroyLoadingDialog() {
        if (this.mLoadingDialog21 != null && this.mLoadingDialog21.isShowing()) {
            this.mLoadingDialog21.cancel();
            this.mLoadingDialog21 = null;
            C2538c.c(TAG, new Object[]{"destroy mLoadingDialog21"});
        }
    }

    private void upLoadLog(int i, int i2, OrderHandleResultInfo orderHandleResultInfo) {
        if (i != 0) {
            if (1 == i || 10 == i || 23 == i || 24 == i || 25 == i || 99 == i) {
                openCardLogUpload(this.cardListItem.m28123j(), String.valueOf(i), "queryAndHandleUnfinishedOrderCallback, query Unfinished Order fail");
            }
        } else if (i2 != 10002 || orderHandleResultInfo == null || orderHandleResultInfo.getIssueCardOrderCnt() <= 0) {
            openCardLogUpload(this.cardListItem.m28123j(), "1", "queryAndHandleUnfinishedOrderCallback, resultType : " + i2);
        } else {
            openCardLogUpload(this.cardListItem.m28123j(), "0", "");
        }
    }

    private void openCardLogUpload(String str, String str2, String str3) {
        LogUploadOperator.getInstance(this.mContext).init(str, str2, str3, 11);
    }

    private String getErrorMessage(int i) {
        switch (i) {
            case -2:
            case 11:
                return this.mContext.getString(R.string.nfc_no_network_connection);
            case 10:
            case 99:
                return this.mContext.getString(R.string.nfc_create_order_failed);
            case 12:
                return this.mContext.getString(R.string.nfc_nfc_not_open);
            case 1008:
            case IssueTrafficCardCallback.RETURN_FAILED_CITYCODE_ILLEGAL /*1103*/:
                return this.mContext.getString(R.string.nfc_get_city_failed);
            case 1010:
                return this.mContext.getString(R.string.nfc_sp_out_of_service);
            case IssueTrafficCardCallback.RETURN_FAILED_CARD_CNT_REACH_LIMIT /*1101*/:
                return this.mContext.getString(R.string.nfc_bind_card_fail_open_overcount);
            case IssueTrafficCardCallback.RETURN_FAILED_REPEAT_ISSUERCARD /*1102*/:
                return this.mContext.getString(R.string.nfc_sp_return_failed);
            case IssueTrafficCardCallback.RETURN_FAILED_SSD_INSTALL_FAILED /*1104*/:
                return this.mContext.getString(R.string.nfc_ssd_install_failed);
            default:
                return this.mContext.getString(R.string.nfc_sp_return_failed);
        }
    }
}
