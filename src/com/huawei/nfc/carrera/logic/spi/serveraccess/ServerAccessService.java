package com.huawei.nfc.carrera.logic.spi.serveraccess;

import com.huawei.nfc.carrera.logic.spi.serveraccess.request.ApplyOrderRequest;
import com.huawei.nfc.carrera.logic.spi.serveraccess.request.DeleteAppletRequest;
import com.huawei.nfc.carrera.logic.spi.serveraccess.request.DownloadAndInstallAppletRequest;
import com.huawei.nfc.carrera.logic.spi.serveraccess.request.PersonalizeAppletRequest;
import com.huawei.nfc.carrera.logic.spi.serveraccess.request.QueryAmountRequest;
import com.huawei.nfc.carrera.logic.spi.serveraccess.request.QueryOrderRequest;
import com.huawei.nfc.carrera.logic.spi.serveraccess.request.RechargeRequest;
import com.huawei.nfc.carrera.logic.spi.serveraccess.response.ApplyOrderResponse;
import com.huawei.nfc.carrera.logic.spi.serveraccess.response.DeleteAppletResponse;
import com.huawei.nfc.carrera.logic.spi.serveraccess.response.DownloadAndInstallAppletResponse;
import com.huawei.nfc.carrera.logic.spi.serveraccess.response.PersonalizeAppletResponse;
import com.huawei.nfc.carrera.logic.spi.serveraccess.response.QueryAmountResponse;
import com.huawei.nfc.carrera.logic.spi.serveraccess.response.QueryOrderResponse;
import com.huawei.nfc.carrera.logic.spi.serveraccess.response.RechargeResponse;

public interface ServerAccessService {
    ApplyOrderResponse applyOrder(ApplyOrderRequest applyOrderRequest);

    DeleteAppletResponse deleteApplet(DeleteAppletRequest deleteAppletRequest);

    DownloadAndInstallAppletResponse downloadAndInstallApplet(DownloadAndInstallAppletRequest downloadAndInstallAppletRequest);

    PersonalizeAppletResponse personalizeApplet(PersonalizeAppletRequest personalizeAppletRequest);

    QueryAmountResponse queryAmount(QueryAmountRequest queryAmountRequest);

    QueryOrderResponse queryOrder(QueryOrderRequest queryOrderRequest);

    RechargeResponse recharge(RechargeRequest rechargeRequest);
}
