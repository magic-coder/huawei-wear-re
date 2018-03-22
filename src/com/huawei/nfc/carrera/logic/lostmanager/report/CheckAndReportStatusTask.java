package com.huawei.nfc.carrera.logic.lostmanager.report;

import android.content.Context;
import com.huawei.nfc.carrera.logic.lostmanager.report.dbmanager.ReportStatusItem;
import com.huawei.nfc.carrera.storage.sp.NFCPreferences;
import com.huawei.nfc.carrera.util.LogX;
import java.util.List;

public class CheckAndReportStatusTask extends ReportStatusBaseTask implements Runnable {
    public CheckAndReportStatusTask(Context context) {
        super(context);
    }

    public void run() {
        String deviceStatus = getDeviceStatus();
        if (deviceStatus != null && reportStatusToServer(deviceStatus)) {
            removeDeviceStatus();
        }
        List<ReportStatusItem> queryWaitingReportStatus = queryWaitingReportStatus();
        if (queryWaitingReportStatus == null || queryWaitingReportStatus.isEmpty()) {
            LogX.d("no status items waiting to report.");
            return;
        }
        for (ReportStatusItem reportStatusItem : queryWaitingReportStatus) {
            if (reportStatusToServer(reportStatusItem.getAid(), reportStatusItem.getCardStatus(), reportStatusItem.getUserId(), reportStatusItem.getDpanId(), reportStatusItem.getCardName(), reportStatusItem.getCardNumber(), reportStatusItem.getIssuerID(), reportStatusItem.getCardType(), reportStatusItem.isIfNotify())) {
                removeDBStatusItem(reportStatusItem.getAid());
            }
        }
    }

    private List<ReportStatusItem> queryWaitingReportStatus() {
        return this.reportStatusDBManager.queryReportStatusList();
    }

    private String getDeviceStatus() {
        return NFCPreferences.getInstance(this.mContext).getString("device_status", null);
    }
}
