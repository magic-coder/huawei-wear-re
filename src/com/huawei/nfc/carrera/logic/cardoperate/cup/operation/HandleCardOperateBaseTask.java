package com.huawei.nfc.carrera.logic.cardoperate.cup.operation;

import android.os.Handler;
import com.huawei.nfc.carrera.logic.spi.unionpay.CUPService;
import com.huawei.nfc.carrera.util.LogX;
import java.util.ArrayList;
import java.util.List;

public abstract class HandleCardOperateBaseTask implements Runnable {
    private final CardOperateListener mListener;
    private List<String> mRefIds;
    private final HandleOperationResutTask mResultTask;
    private final CUPService mServiceApi;
    protected String mSign;
    protected String mSsid;

    protected abstract String getOperateEventTag();

    protected abstract void handleFailResult(List<String> list, int i);

    protected abstract boolean handleSuccessResult(List<String> list);

    protected abstract boolean isOperationSatisfied(List<String> list);

    protected abstract boolean prepareLocalInfo(List<String> list);

    public HandleCardOperateBaseTask(CUPService cUPService, HandleOperationResutTask handleOperationResutTask, CardOperateListener cardOperateListener) {
        this.mServiceApi = cUPService;
        this.mResultTask = handleOperationResutTask;
        this.mListener = cardOperateListener;
    }

    public void doTask(String str, String str2, ArrayList<String> arrayList, Handler handler) {
        this.mSsid = str;
        this.mSign = str2;
        this.mRefIds = arrayList;
        handler.post(this);
    }

    public void run() {
        int i = -99;
        boolean isOperationSatisfied = isOperationSatisfied(this.mRefIds);
        LogX.d("the operation task isSatisFied: " + isOperationSatisfied);
        if (isOperationSatisfied) {
            isOperationSatisfied = prepareLocalInfo(this.mRefIds);
            LogX.d("the operation task isPrepareSuccess: " + isOperationSatisfied);
            if (isOperationSatisfied) {
                notifyListenerStart();
                LogX.i("excute cup cmd now.");
                int excuteCMD = this.mServiceApi.excuteCMD(this.mSsid, this.mSign);
                LogX.i("excute cup cmd result: " + excuteCMD);
                if (excuteCMD == 0) {
                    LogX.d("the operation task isUpdateSuccess: " + handleSuccessResult(this.mRefIds));
                    notifyListenerResult(0);
                    this.mResultTask.notifyOperateResult(0);
                    return;
                }
                if (-7 == excuteCMD) {
                    LogX.d("===123===RESPONSE_CODE_FAILED_OPERATION_FATAL_ERR");
                    i = -1;
                } else if (-3 == excuteCMD || -6 == excuteCMD) {
                    LogX.d("===123===OPERATE_RESULT_DEAL");
                    i = -98;
                }
                LogX.d("notifyListenerResult  failResutl: " + i);
                handleFailResult(this.mRefIds, excuteCMD);
                notifyListenerResult(i);
                this.mResultTask.notifyOperateResult(i);
                return;
            }
            notifyListenerResult(-99);
            this.mResultTask.notifyOperateResult(-99);
            return;
        }
        notifyListenerResult(-99);
        this.mResultTask.notifyOperateResult(-99);
    }

    private void notifyListenerResult(int i) {
        LogX.d("notifyListenerResult notifyListenerResult  resultCode: " + i);
        if (this.mListener != null && this.mRefIds != null) {
            String operateEventTag = getOperateEventTag();
            for (String str : this.mRefIds) {
                LogX.d("notifyListenerResult operateFinished 2 ");
                this.mListener.operateFinished(operateEventTag, str, i);
            }
        }
    }

    private void notifyListenerStart() {
        LogX.d("notifyListenerResult notifyListenerStart ");
        if (this.mListener != null && this.mRefIds != null) {
            String operateEventTag = getOperateEventTag();
            LogX.d("notifyListenerResult operateStart 1 ");
            this.mListener.operateStart(operateEventTag, (String) this.mRefIds.get(0));
        }
    }
}
