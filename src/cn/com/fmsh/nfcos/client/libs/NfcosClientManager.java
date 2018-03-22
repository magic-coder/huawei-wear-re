package cn.com.fmsh.nfcos.client.libs;

import cn.com.fmsh.script.ApduHandler;
import cn.com.fmsh.tsm.business.bean.Activity;
import cn.com.fmsh.tsm.business.bean.BusinessOrder;
import cn.com.fmsh.tsm.business.bean.CardAppInfo;
import cn.com.fmsh.tsm.business.bean.InvoiceToken;
import cn.com.fmsh.tsm.business.bean.LoginInfo;
import cn.com.fmsh.tsm.business.bean.MainOrder;
import cn.com.fmsh.tsm.business.bean.PayOrder;
import cn.com.fmsh.tsm.business.bean.PreDepositInfo;
import cn.com.fmsh.tsm.business.bean.Product;
import cn.com.fmsh.tsm.business.bean.PromotionMessage;
import cn.com.fmsh.tsm.business.bean.TerminalBackInfo;
import cn.com.fmsh.tsm.business.enums.EnumBusinessOrderType;
import cn.com.fmsh.tsm.business.enums.EnumCardAppStatus;
import cn.com.fmsh.tsm.business.enums.EnumCardAppType;
import cn.com.fmsh.tsm.business.enums.EnumOrderStatus;
import cn.com.fmsh.tsm.business.enums.EnumUserPlatformType;
import cn.com.fmsh.tsm.business.exception.BusinessException;
import cn.com.fmsh.util.log.FMLog;
import java.util.List;

public interface NfcosClientManager {
    int appletDownload(EnumCardAppType enumCardAppType, byte[] bArr, String str) throws BusinessException;

    MainOrder apply4Pay(EnumCardAppType enumCardAppType, int i, int i2, byte[] bArr) throws BusinessException;

    MainOrder apply4PayEx(EnumCardAppType enumCardAppType, int i, int i2, byte[] bArr, byte[] bArr2) throws BusinessException;

    MainOrder applyIssue(EnumCardAppType enumCardAppType, int i, int i2, byte[] bArr, String str, byte[] bArr2) throws BusinessException;

    MainOrder applyIssueByProduct(EnumCardAppType enumCardAppType, String str, int i, byte[] bArr, String str2, byte[] bArr2) throws BusinessException;

    MainOrder applyPromotion(byte[] bArr) throws BusinessException;

    int cancelIssue(int i) throws BusinessException;

    int closeApp(byte[] bArr, EnumCardAppType enumCardAppType, byte[] bArr2, String str) throws BusinessException;

    CardAppInfo deleteApp(byte[] bArr, EnumCardAppType enumCardAppType, byte[] bArr2, String str) throws BusinessException;

    int doIssue(byte[] bArr, int i, byte[] bArr2, byte[] bArr3) throws BusinessException;

    int doRefund(byte[] bArr) throws BusinessException;

    int doUnsolvedOrder(byte[] bArr, byte[] bArr2) throws BusinessException;

    EnumCardAppStatus getAppStatus4Platform(EnumCardAppType enumCardAppType, byte[] bArr, String str) throws BusinessException;

    CardAppInfo getCardAppInfo(int i, EnumCardAppType enumCardAppType) throws BusinessException;

    EnumCardAppStatus getCardAppStatus(EnumCardAppType enumCardAppType) throws BusinessException;

    String getInvoiceToken(byte[] bArr) throws BusinessException;

    List<InvoiceToken> getInvoiceTokens() throws BusinessException;

    LoginInfo login(String str, String str2) throws BusinessException;

    LoginInfo login4third(String str, String str2, EnumUserPlatformType enumUserPlatformType, String str3) throws BusinessException;

    int logout() throws BusinessException;

    int modifyPassword(String str, String str2) throws BusinessException;

    byte[] moveApp(byte[] bArr, EnumCardAppType enumCardAppType, byte[] bArr2, String str) throws BusinessException;

    int openApp(byte[] bArr, EnumCardAppType enumCardAppType, byte[] bArr2, String str) throws BusinessException;

    int orderExec(byte[] bArr, byte[] bArr2) throws BusinessException;

    List<Activity> queryActivities(EnumCardAppType enumCardAppType) throws BusinessException;

    List<Activity> queryActivities(EnumCardAppType enumCardAppType, String str) throws BusinessException;

    List<PreDepositInfo> queryBlance4PreDeposit(EnumCardAppType enumCardAppType) throws BusinessException;

    BusinessOrder queryBusinessOrder(byte[] bArr) throws BusinessException;

    List<BusinessOrder> queryBusinessOrders(int i, int i2, EnumCardAppType enumCardAppType, EnumBusinessOrderType enumBusinessOrderType, List<EnumOrderStatus> list, byte[] bArr) throws BusinessException;

    MainOrder queryMainOrder(byte[] bArr) throws BusinessException;

    List<MainOrder> queryMainOrders(int i, int i2, EnumCardAppType enumCardAppType) throws BusinessException;

    PayOrder queryPayOrder(byte[] bArr) throws BusinessException;

    List<Product> queryProducts(String str, EnumCardAppType enumCardAppType, String str2, String str3) throws BusinessException;

    List<PromotionMessage> queryPromotionMessage() throws BusinessException;

    int recharge(byte[] bArr, byte[] bArr2) throws BusinessException;

    int register(String str, String str2) throws BusinessException;

    void registerApduHandler(ApduHandler apduHandler);

    void registerLogHandle(FMLog fMLog);

    byte[] rentBusinessHandle(int i, byte[] bArr) throws BusinessException;

    int terminalFeedback(TerminalBackInfo terminalBackInfo) throws BusinessException;
}
