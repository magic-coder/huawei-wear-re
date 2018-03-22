package cn.com.fmsh.nfcos.client.libs.core;

import cn.com.fmsh.nfcos.client.libs.NfcosClientManager;
import cn.com.fmsh.script.ApduHandler;
import cn.com.fmsh.tsm.business.BusinessManager;
import cn.com.fmsh.tsm.business.BusinessManagerFactory;
import cn.com.fmsh.tsm.business.bean.Activity;
import cn.com.fmsh.tsm.business.bean.BusinessOrder;
import cn.com.fmsh.tsm.business.bean.CardAppInfo;
import cn.com.fmsh.tsm.business.bean.CardAppRecord;
import cn.com.fmsh.tsm.business.bean.InvoiceToken;
import cn.com.fmsh.tsm.business.bean.LoginInfo;
import cn.com.fmsh.tsm.business.bean.MainOrder;
import cn.com.fmsh.tsm.business.bean.PayOrder;
import cn.com.fmsh.tsm.business.bean.PreDepositInfo;
import cn.com.fmsh.tsm.business.bean.Product;
import cn.com.fmsh.tsm.business.bean.PromotionMessage;
import cn.com.fmsh.tsm.business.bean.TerminalBackInfo;
import cn.com.fmsh.tsm.business.bean.UserInfo;
import cn.com.fmsh.tsm.business.bean.VersionInfo;
import cn.com.fmsh.tsm.business.card.CardTools;
import cn.com.fmsh.tsm.business.enums.EnumAppManageOperateType;
import cn.com.fmsh.tsm.business.enums.EnumBusinessOrderType;
import cn.com.fmsh.tsm.business.enums.EnumCardAppStatus;
import cn.com.fmsh.tsm.business.enums.EnumCardAppType;
import cn.com.fmsh.tsm.business.enums.EnumOrderStatus;
import cn.com.fmsh.tsm.business.enums.EnumTerminalOpType;
import cn.com.fmsh.tsm.business.enums.EnumUserPlatformType;
import cn.com.fmsh.tsm.business.exception.BusinessException;
import cn.com.fmsh.tsm.business.exception.BusinessException.ErrorMessage;
import cn.com.fmsh.util.FM_Bytes;
import cn.com.fmsh.util.log.FMLog;
import cn.com.fmsh.util.log.LogFactory;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class NfcosClientManagerImpl implements NfcosClientManager {
    private FMLog fmLog = null;
    private final String logTag = "NfcosClientManagerHodo";
    private BusinessManager manager = null;
    private volatile Map<String, byte[]> unsolvedOrderAndCardNo;

    public void init() {
        this.manager = BusinessManagerFactory.getBusinessManager();
        byte[] bArr = new byte[32];
        new Random().nextBytes(bArr);
        this.manager.setTerminalNumber(bArr);
        this.manager.setMobileInfo(new byte[]{(byte) 2, (byte) 1, (byte) EnumTerminalOpType.ANDROID.getId()});
        this.unsolvedOrderAndCardNo = new HashMap();
        this.fmLog = LogFactory.getInstance().getLog();
    }

    public void registerApduHandler(ApduHandler apduHandler) {
        this.manager.setApduHandler(apduHandler);
    }

    public int doIssue(byte[] bArr, int i, byte[] bArr2, byte[] bArr3) throws BusinessException {
        if (bArr == null || bArr.length < 1) {
            if (this.fmLog != null) {
                this.fmLog.warn("NfcosClientManagerHodo", "卡上应用发行时，请传入发卡订单号");
            }
            throw new BusinessException("卡上应用发行时，请传入发卡订单号", ErrorMessage.local_business_para_error);
        } else if (bArr2 == null || bArr2.length < 1) {
            if (this.fmLog != null) {
                this.fmLog.warn("NfcosClientManagerHodo", "卡上应用发行时，传入的eSE标志为空");
            }
            throw new BusinessException("卡上应用发行时，传入的eSE标志为空", ErrorMessage.local_business_para_error);
        } else if (this.manager.getCardAppInstall().issuerVer2(bArr, i, bArr2, bArr3)) {
            return 0;
        } else {
            return 99;
        }
    }

    public int cancelIssue(int i) throws BusinessException {
        this.manager.getCardAppInstall().cancel();
        return 0;
    }

    public EnumCardAppStatus getCardAppStatus(EnumCardAppType enumCardAppType) throws BusinessException {
        if (enumCardAppType != null) {
            return this.manager.getCardAppInstall().getAppIssuerStatus(enumCardAppType);
        }
        if (this.fmLog != null) {
            this.fmLog.warn("NfcosClientManagerHodo", "获取卡上应用状态时，传入卡上应用类型无效");
        }
        throw new BusinessException("获取卡上应用状态时，传入卡上应用类型无效", ErrorMessage.local_business_para_error);
    }

    public EnumCardAppStatus getAppStatus4Platform(EnumCardAppType enumCardAppType, byte[] bArr, String str) throws BusinessException {
        if (enumCardAppType == null) {
            if (this.fmLog != null) {
                this.fmLog.warn("NfcosClientManagerHodo", "获取卡上应用状态时，传入卡上应用类型无效");
            }
            throw new BusinessException("获取卡上应用状态时，传入卡上应用类型无效", ErrorMessage.local_business_para_error);
        } else if (bArr == null || bArr.length < 1) {
            if (this.fmLog != null) {
                this.fmLog.warn("NfcosClientManagerHodo", "获取卡上应用发行状态时，传入的eSE的标识无效");
            }
            throw new BusinessException("获取卡上应用发行状态时，传入的eSE的标识无效", ErrorMessage.local_business_para_error);
        } else if (str != null && str.length() >= 1) {
            return this.manager.getCardAppInstall().getAppIssuerStatus4Platform(enumCardAppType, str, bArr);
        } else {
            if (this.fmLog != null) {
                this.fmLog.warn("NfcosClientManagerHodo", "获取卡上应用发行状态时，传入的终端型号规格的表示无效");
            }
            throw new BusinessException("获取卡上应用发行状态时，传入的终端型号规格的表示无效", ErrorMessage.local_business_para_error);
        }
    }

    public LoginInfo login(String str, String str2) throws BusinessException {
        if (str == null || str.length() < 1) {
            if (this.fmLog != null) {
                this.fmLog.warn("NfcosClientManagerHodo", "用户登录时，用户名为空");
            }
            throw new BusinessException("用户登录时，用户名为空", ErrorMessage.local_business_para_error);
        } else if (str2 != null && str2.length() >= 1) {
            return this.manager.getCardAppTrade().loginVer2(str, str2);
        } else {
            if (this.fmLog != null) {
                this.fmLog.warn("NfcosClientManagerHodo", "用户登录时，用户密码为空");
            }
            throw new BusinessException("用户登录时，用户密码为空", ErrorMessage.local_business_para_error);
        }
    }

    public LoginInfo login4third(String str, String str2, EnumUserPlatformType enumUserPlatformType, String str3) throws BusinessException {
        if (str == null || str.length() < 1) {
            if (this.fmLog != null) {
                this.fmLog.warn("NfcosClientManagerHodo", "用户登录时，用户名为空");
            }
            throw new BusinessException("用户登录时，用户名为空", ErrorMessage.local_business_para_error);
        } else if (str2 == null || str2.length() < 1) {
            if (this.fmLog != null) {
                this.fmLog.warn("NfcosClientManagerHodo", "用户登录时，用户密码为空");
            }
            throw new BusinessException("用户登录时，用户密码为空", ErrorMessage.local_business_para_error);
        } else if (enumUserPlatformType != null) {
            return this.manager.getCardAppTrade().loginVer3(str, str2, enumUserPlatformType, str3);
        } else {
            if (this.fmLog != null) {
                this.fmLog.warn("NfcosClientManagerHodo", "用户登录时，用户所属平台类型不合法");
            }
            throw new BusinessException("用户登录时，用户所属平台类型不合法", ErrorMessage.local_business_para_error);
        }
    }

    public VersionInfo queryVersion() throws BusinessException {
        return this.manager.getCardAppTrade().queryVersion();
    }

    public CardAppInfo getCardAppInfo(int i, EnumCardAppType enumCardAppType) throws BusinessException {
        if (enumCardAppType == null) {
            if (this.fmLog != null) {
                this.fmLog.warn("NfcosClientManagerHodo", "获取卡上应用信息，传入的卡上应用类型无效");
            }
            throw new BusinessException("获取卡上应用信息，传入的卡上应用类型无效", ErrorMessage.local_business_para_error);
        }
        CardAppInfo cardAppInfo = new CardAppInfo();
        if ((i & 1) != 0) {
            byte[] appNo = this.manager.getCardAppTrade().getAppNo(enumCardAppType);
            if (enumCardAppType != EnumCardAppType.CARD_APP_TYPE_SH && enumCardAppType != EnumCardAppType.CARD_APP_TYPE_SH_TOUR && enumCardAppType != EnumCardAppType.CARD_APP_TYPE_SH_RENT) {
                cardAppInfo.setFaceId(CardTools.getFaceNo4uidByLnt(appNo));
            } else if (appNo == null || appNo.length < 8) {
                cardAppInfo.setFaceId("");
            } else {
                cardAppInfo.setFaceId(CardTools.getFaceID4UID(Arrays.copyOfRange(appNo, 4, appNo.length)));
            }
            cardAppInfo.setCardAppNo(appNo);
        }
        if ((i & 2) != 0) {
            cardAppInfo.setBalance(this.manager.getCardAppTrade().getBalance(enumCardAppType));
        }
        if ((i & 4) != 0) {
            List<CardAppRecord> cardAppRecords = this.manager.getCardAppTrade().getCardAppRecords(enumCardAppType);
            if (cardAppRecords != null) {
                for (CardAppRecord addRecord : cardAppRecords) {
                    cardAppInfo.addRecord(addRecord);
                }
            }
        }
        if ((i & 8) != 0) {
            if (this.manager.getCardAppTrade().isLock4Consume(enumCardAppType)) {
                cardAppInfo.setAppClose(true);
            } else {
                cardAppInfo.setAppClose(false);
            }
        }
        if ((i & 16) != 0) {
            cardAppInfo.setMoc(this.manager.getCardAppTrade().getMOC(enumCardAppType));
        }
        if ((i & 32) != 0) {
            cardAppInfo.setTime4Validity(this.manager.getCardAppTrade().getTime4Validity(enumCardAppType));
        }
        return cardAppInfo;
    }

    public String getInvoiceToken(byte[] bArr) throws BusinessException {
        if (bArr != null && bArr.length >= 1) {
            return this.manager.getCardAppTrade().getInvoiceToken(bArr);
        }
        if (this.fmLog != null) {
            this.fmLog.warn("NfcosClientManagerHodo", "获取订单发票申领凭证时，传入订单编号无效");
        }
        throw new BusinessException("获取订单发票申领凭证时，传入订单编号无效", ErrorMessage.local_business_para_error);
    }

    public List<InvoiceToken> getInvoiceTokens() throws BusinessException {
        return this.manager.getCardAppTrade().getInvoiceTokenVer3();
    }

    public int logout() throws BusinessException {
        return this.manager.getCardAppTrade().logout();
    }

    public int modifyPassword(String str, String str2) throws BusinessException {
        if (str == null || str.length() < 1) {
            if (this.fmLog != null) {
                this.fmLog.warn("NfcosClientManagerHodo", "用户修改密码时，旧密码为空");
            }
            throw new BusinessException("用户修改密码时，旧密码为空", ErrorMessage.local_business_para_error);
        } else if (str2 != null && str2.length() >= 1) {
            return this.manager.getCardAppTrade().modifyPassword(str, str2);
        } else {
            if (this.fmLog != null) {
                this.fmLog.warn("NfcosClientManagerHodo", "用户修改密码时，新密码为空");
            }
            throw new BusinessException("用户修改密码时，新密码为空", ErrorMessage.local_business_para_error);
        }
    }

    public int recharge(byte[] bArr, byte[] bArr2) throws BusinessException {
        if (bArr == null || bArr.length < 1) {
            if (this.fmLog != null) {
                this.fmLog.warn("NfcosClientManagerHodo", "卡上应用充值时，订单编号为空");
            }
            throw new BusinessException("卡上应用充值时，订单编号为空", ErrorMessage.local_business_para_error);
        } else if (bArr2 == null || bArr2.length < 1) {
            if (this.fmLog != null) {
                this.fmLog.warn("NfcosClientManagerHodo", "卡上应用充值时，卡上应用序列号为空");
            }
            throw new BusinessException("卡上应用充值时，卡上应用序列号为空", ErrorMessage.local_business_para_error);
        } else if (this.manager.getCardAppTrade().remoteRecharge(bArr, bArr2)) {
            return 0;
        } else {
            return 99;
        }
    }

    public int doUnsolvedOrder(byte[] bArr, byte[] bArr2) throws BusinessException {
        if (bArr == null || bArr.length < 1) {
            if (this.fmLog != null) {
                this.fmLog.warn("NfcosClientManagerHodo", "处理未决订单时，订单编号为空");
            }
            throw new BusinessException("处理未决订单时，订单编号为空", ErrorMessage.local_business_para_error);
        } else if (bArr2 != null && bArr2.length >= 1) {
            return this.manager.getCardAppTrade().doUnsolvedOrder(bArr, bArr2);
        } else {
            if (this.fmLog != null) {
                this.fmLog.warn("NfcosClientManagerHodo", "处理未决订单时，卡号为空");
            }
            throw new BusinessException("处理未决订单时，卡号为空", ErrorMessage.local_business_para_error);
        }
    }

    public int doRefund(byte[] bArr) throws BusinessException {
        if (bArr != null && bArr.length >= 1) {
            return this.manager.getCardAppTrade().doRefund(bArr);
        }
        if (this.fmLog != null) {
            this.fmLog.warn("NfcosClientManagerHodo", "处理退款时，订单编号为空");
        }
        throw new BusinessException("处理退款时，订单编号为空", ErrorMessage.local_business_para_error);
    }

    public int register(String str, String str2) throws BusinessException {
        if (str == null || str.length() < 1) {
            if (this.fmLog != null) {
                this.fmLog.warn("NfcosClientManagerHodo", "用户注册时，用户名无效");
            }
            throw new BusinessException("用户注册时，用户名无效", ErrorMessage.local_business_para_error);
        } else if (str2 == null || str2.length() < 1) {
            if (this.fmLog != null) {
                this.fmLog.warn("NfcosClientManagerHodo", "用户注册时，用户密码无效");
            }
            throw new BusinessException("用户注册时，用户密码无效", ErrorMessage.local_business_para_error);
        } else {
            UserInfo userInfo = new UserInfo();
            userInfo.setUserName(str);
            userInfo.setPassword(str2);
            userInfo.setUserType(2);
            return this.manager.getCardAppTrade().registerVer2(userInfo);
        }
    }

    public CardAppInfo deleteApp(byte[] bArr, EnumCardAppType enumCardAppType, byte[] bArr2, String str) throws BusinessException {
        if (enumCardAppType == null) {
            if (this.fmLog != null) {
                this.fmLog.warn("NfcosClientManagerHodo", "卡上应用卸载时，传入卡的类型无效");
            }
            throw new BusinessException("卡上应用卸载时，传入卡的类型无效", ErrorMessage.local_business_para_error);
        } else if (bArr2 == null || bArr2.length < 1) {
            if (this.fmLog != null) {
                this.fmLog.warn("NfcosClientManagerHodo", "卡上应用卸载时，传入eSE标识无效");
            }
            throw new BusinessException("卡上应用卸载时，传入eSE标识无效", ErrorMessage.local_business_para_error);
        } else if (str != null && str.length() >= 1) {
            return this.manager.getCardAppInstall().deleteApp(bArr, enumCardAppType, bArr2, str);
        } else {
            if (this.fmLog != null) {
                this.fmLog.warn("NfcosClientManagerHodo", "卡上应用卸载时，传入终端型号无效");
            }
            throw new BusinessException("卡上应用卸载时，传入终端型号无效", ErrorMessage.local_business_para_error);
        }
    }

    public int openApp(byte[] bArr, EnumCardAppType enumCardAppType, byte[] bArr2, String str) throws BusinessException {
        if (enumCardAppType == null) {
            if (this.fmLog != null) {
                this.fmLog.warn("NfcosClientManagerHodo", "卡上应用状态设置时，传入卡的类型无效");
            }
            throw new BusinessException("卡上应用状态设置时，传入卡的类型无效", ErrorMessage.local_business_para_error);
        } else if (bArr2 == null || bArr2.length < 1) {
            if (this.fmLog != null) {
                this.fmLog.warn("NfcosClientManagerHodo", "卡上应用状态设置时，传入eSE标识无效");
            }
            throw new BusinessException("卡上应用状态设置时，传入eSE标识无效", ErrorMessage.local_business_para_error);
        } else if (str == null || str.length() < 1) {
            if (this.fmLog != null) {
                this.fmLog.warn("NfcosClientManagerHodo", "卡上应用状态设置时，传入终端型号无效");
            }
            throw new BusinessException("卡上应用状态设置时，传入终端型号无效", ErrorMessage.local_business_para_error);
        } else {
            if (this.manager.getCardAppInstall().setApp(bArr, enumCardAppType, bArr2, str, EnumAppManageOperateType.APP_UNLOCK)) {
                return 0;
            }
            return 99;
        }
    }

    public int closeApp(byte[] bArr, EnumCardAppType enumCardAppType, byte[] bArr2, String str) throws BusinessException {
        if (enumCardAppType == null) {
            if (this.fmLog != null) {
                this.fmLog.warn("NfcosClientManagerHodo", "卡上应用状态设置时，传入卡的类型无效");
            }
            throw new BusinessException("卡上应用状态设置时，传入卡的类型无效", ErrorMessage.local_business_para_error);
        } else if (bArr2 == null || bArr2.length < 1) {
            if (this.fmLog != null) {
                this.fmLog.warn("NfcosClientManagerHodo", "卡上应用状态设置时，传入eSE标识无效");
            }
            throw new BusinessException("卡上应用状态设置时，传入eSE标识无效", ErrorMessage.local_business_para_error);
        } else if (str == null || str.length() < 1) {
            if (this.fmLog != null) {
                this.fmLog.warn("NfcosClientManagerHodo", "卡上应用状态设置时，传入终端型号无效");
            }
            throw new BusinessException("卡上应用状态设置时，传入终端型号无效", ErrorMessage.local_business_para_error);
        } else {
            if (this.manager.getCardAppInstall().setApp(bArr, enumCardAppType, bArr2, str, EnumAppManageOperateType.APP_LOCK)) {
                return 0;
            }
            return 99;
        }
    }

    public byte[] moveApp(byte[] bArr, EnumCardAppType enumCardAppType, byte[] bArr2, String str) throws BusinessException {
        if (bArr == null) {
            if (this.fmLog != null) {
                this.fmLog.warn("NfcosClientManagerHodo", "卡上应用迁出时，传入卡的无效");
            }
            throw new BusinessException("卡上应用迁出时，传入卡的类型无效", ErrorMessage.local_business_para_error);
        } else if (enumCardAppType == null) {
            if (this.fmLog != null) {
                this.fmLog.warn("NfcosClientManagerHodo", "卡上应用迁出时，传入卡的类型无效");
            }
            throw new BusinessException("卡上应用迁出时时，传入卡的类型无效", ErrorMessage.local_business_para_error);
        } else if (bArr2 == null || bArr2.length < 1) {
            if (this.fmLog != null) {
                this.fmLog.warn("NfcosClientManagerHodo", "卡上应用迁出时，传入eSE标识无效");
            }
            throw new BusinessException("卡上应用迁出时，传入eSE标识无效", ErrorMessage.local_business_para_error);
        } else if (str != null && str.length() >= 1) {
            return this.manager.getCardAppInstall().moveApp(bArr, enumCardAppType, bArr2, str);
        } else {
            if (this.fmLog != null) {
                this.fmLog.warn("NfcosClientManagerHodo", "卡上应用迁出时，传入终端型号无效");
            }
            throw new BusinessException("卡上应用迁出时，传入终端型号无效", ErrorMessage.local_business_para_error);
        }
    }

    public List<Activity> queryActivities(EnumCardAppType enumCardAppType, String str) throws BusinessException {
        if (enumCardAppType == null) {
            if (this.fmLog != null) {
                this.fmLog.warn("NfcosClientManagerHodo", "活动信息查询时，传入卡的类型无效");
            }
            throw new BusinessException("卡上应用状态设置时，传入终端型号无效", ErrorMessage.local_business_para_error);
        } else if (str != null && str.length() >= 1) {
            return this.manager.getCardAppTrade().queryActivities(enumCardAppType);
        } else {
            if (this.fmLog != null) {
                this.fmLog.warn("NfcosClientManagerHodo", "活动信息查询时，传入厂商编码无效");
            }
            throw new BusinessException("活动信息查询时，传入厂商编码无效", ErrorMessage.local_business_para_error);
        }
    }

    public MainOrder apply4Pay(EnumCardAppType enumCardAppType, int i, int i2, byte[] bArr) throws BusinessException {
        if (enumCardAppType == null) {
            if (this.fmLog != null) {
                this.fmLog.warn("NfcosClientManagerHodo", "订单申请付款时，传入卡的类型无效");
            }
            throw new BusinessException("订单申请付款时，传入卡的类型无效", ErrorMessage.local_business_para_error);
        } else if (i > 0) {
            return this.manager.getCardAppTrade().apply4Pay(i, i2, bArr, enumCardAppType);
        } else {
            if (this.fmLog != null) {
                this.fmLog.warn("NfcosClientManagerHodo", "订单申请付款时，传入的充值金额无效");
            }
            throw new BusinessException("订单申请付款时，传入的充值金额无效", ErrorMessage.local_business_para_error);
        }
    }

    public MainOrder apply4PayEx(EnumCardAppType enumCardAppType, int i, int i2, byte[] bArr, byte[] bArr2) throws BusinessException {
        if (enumCardAppType == null) {
            if (this.fmLog != null) {
                this.fmLog.warn("NfcosClientManagerHodo", "充值-活动订单申请付款时，传入卡上应用类型无效");
            }
            throw new BusinessException("充值-活动订单申请付款时，传入的支付类型无效", ErrorMessage.local_business_para_error);
        } else if (i <= 0) {
            if (this.fmLog != null) {
                this.fmLog.warn("NfcosClientManagerHodo", "充值-活动订单申请付款时，传入的充值金额无效");
            }
            throw new BusinessException("充值-活动订单申请付款时，传入的充值金额无效", ErrorMessage.local_business_para_error);
        } else {
            return this.manager.getCardAppTrade().applyAct4Pay(bArr2, enumCardAppType, FM_Bytes.join(FM_Bytes.join(FM_Bytes.join(FM_Bytes.join(new byte[]{(byte) 2, (byte) 1, (byte) i2}, new byte[]{(byte) 1, (byte) FM_Bytes.intToBytes(i, 4).length}), r1), new byte[]{(byte) 3, (byte) bArr.length}), bArr));
        }
    }

    public List<MainOrder> queryMainOrders(int i, int i2, EnumCardAppType enumCardAppType) throws BusinessException {
        if (enumCardAppType == null) {
            if (this.fmLog != null) {
                this.fmLog.warn("NfcosClientManagerHodo", "主订单查询时，传入卡上应用类型无效");
            }
            throw new BusinessException("主订单查询时，传入卡上应用类型无效", ErrorMessage.local_business_para_error);
        } else if (i >= 0 && i2 >= 0) {
            return this.manager.getCardAppTrade().queryMainOrders(i, i2, EnumOrderStatus.unknown, enumCardAppType);
        } else {
            if (this.fmLog != null) {
                this.fmLog.warn("NfcosClientManagerHodo", "主订单查询时，传入查询范围无效");
            }
            throw new BusinessException("主订单查询时，传入查询范围无效", ErrorMessage.local_business_para_error);
        }
    }

    public MainOrder queryMainOrder(byte[] bArr) throws BusinessException {
        if (bArr != null && bArr.length >= 1) {
            return this.manager.getCardAppTrade().queryMainOrder(bArr);
        }
        if (this.fmLog != null) {
            this.fmLog.warn("NfcosClientManagerHodo", "主订单详细信息查询时，传入订单编号无效");
        }
        throw new BusinessException("主订单详细信息查询时，传入订单编号无效", ErrorMessage.local_business_para_error);
    }

    public PayOrder queryPayOrder(byte[] bArr) throws BusinessException {
        if (bArr != null && bArr.length >= 1) {
            return this.manager.getCardAppTrade().queryPayOrder(bArr);
        }
        if (this.fmLog != null) {
            this.fmLog.warn("NfcosClientManagerHodo", "支付订单详细信息查询时，传入订单编号无效");
        }
        throw new BusinessException("支付订单详细信息查询时，传入订单编号无效", ErrorMessage.local_business_para_error);
    }

    public List<BusinessOrder> queryBusinessOrders(int i, int i2, EnumCardAppType enumCardAppType, EnumBusinessOrderType enumBusinessOrderType, List<EnumOrderStatus> list, byte[] bArr) throws BusinessException {
        if (enumCardAppType == null) {
            if (this.fmLog != null) {
                this.fmLog.warn("NfcosClientManagerHodo", "业务订单查询时，传入卡的类型无效");
            }
            throw new BusinessException("业务订单查询时，传入卡的类型无效", ErrorMessage.local_business_para_error);
        } else if (list == null) {
            if (this.fmLog != null) {
                this.fmLog.warn("NfcosClientManagerHodo", "业务订单查询时，传入的订单状态无效");
            }
            throw new BusinessException("业务订单查询时，传入的订单状态无效", ErrorMessage.local_business_para_error);
        } else if (enumBusinessOrderType == null) {
            if (this.fmLog != null) {
                this.fmLog.warn("NfcosClientManagerHodo", "业务订单查询时，传入业务订单类型无效");
            }
            throw new BusinessException("业务订单查询时，传入业务订单类型无效", ErrorMessage.local_business_para_error);
        } else if (i >= 0 && i2 >= 0) {
            return this.manager.getCardAppTrade().queryBusinessOrdersVer4(i, i2, enumCardAppType, enumBusinessOrderType, list, bArr);
        } else {
            if (this.fmLog != null) {
                this.fmLog.warn("NfcosClientManagerHodo", "业务订单信息查询时，传入查询范围无效");
            }
            throw new BusinessException("业务订单查询时，传入查询范围无效", ErrorMessage.local_business_para_error);
        }
    }

    public BusinessOrder queryBusinessOrder(byte[] bArr) throws BusinessException {
        if (bArr != null && bArr.length >= 1) {
            return this.manager.getCardAppTrade().queryBusinessOrder(bArr);
        }
        if (this.fmLog != null) {
            this.fmLog.warn("NfcosClientManagerHodo", "业务订单详细信息查询时，传入订单编号无效");
        }
        throw new BusinessException("业务订单详细信息查询时，传入订单编号无效", ErrorMessage.local_business_para_error);
    }

    public MainOrder applyIssueByProduct(EnumCardAppType enumCardAppType, String str, int i, byte[] bArr, String str2, byte[] bArr2) throws BusinessException {
        if (enumCardAppType == null) {
            if (this.fmLog != null) {
                this.fmLog.warn("NfcosClientManagerHodo", "发卡订单申请付款时，传入的卡上应用类型无效");
            }
            throw new BusinessException("发卡订单申请付款时，传入的卡上应用类型无效", ErrorMessage.local_business_para_error);
        } else if (str == null || str.length() < 1) {
            if (this.fmLog != null) {
                this.fmLog.warn("NfcosClientManagerHodo", "发卡订单申请付款时，传入产品编码无效");
            }
            throw new BusinessException("发卡订单申请付款时，传入产品编码无效", ErrorMessage.local_business_para_error);
        } else if (bArr == null || bArr.length < 1) {
            if (this.fmLog != null) {
                this.fmLog.warn("NfcosClientManagerHodo", "发卡订单申请付款时，传入SE标识无效");
            }
            throw new BusinessException("发卡订单申请付款时，传入SE标识无效", ErrorMessage.local_business_para_error);
        } else if (str2 == null || str2.length() < 1) {
            if (this.fmLog != null) {
                this.fmLog.warn("NfcosClientManagerHodo", "发卡订单申请付款时，传入终端型号无效");
            }
            throw new BusinessException("发卡订单申请付款时，传入终端型号无效", ErrorMessage.local_business_para_error);
        } else if (bArr2 == null || bArr2.length < 1) {
            if (this.fmLog != null) {
                this.fmLog.warn("NfcosClientManagerHodo", "发卡订单申请付款时，传入活动编码无效");
            }
            throw new BusinessException("发卡订单申请付款时，传入活动编码无效", ErrorMessage.local_business_para_error);
        } else {
            return this.manager.getCardAppTrade().applyAct4Pay(bArr2, enumCardAppType, FM_Bytes.join(FM_Bytes.join(FM_Bytes.join(FM_Bytes.join(FM_Bytes.join(FM_Bytes.join(new byte[]{(byte) 2, (byte) 1, (byte) i}, new byte[]{(byte) 1, (byte) str.getBytes().length}), r1), new byte[]{(byte) 3, (byte) bArr.length}), bArr), new byte[]{(byte) 5, (byte) str2.getBytes().length}), r1));
        }
    }

    public MainOrder applyIssue(EnumCardAppType enumCardAppType, int i, int i2, byte[] bArr, String str, byte[] bArr2) throws BusinessException {
        if (enumCardAppType == null) {
            if (this.fmLog != null) {
                this.fmLog.warn("NfcosClientManagerHodo", "发卡订单申请付款时，传入的卡上应用类型无效");
            }
            throw new BusinessException("发卡订单申请付款时，传入的卡上应用类型无效", ErrorMessage.local_business_para_error);
        } else if (bArr == null || bArr.length < 1) {
            if (this.fmLog != null) {
                this.fmLog.warn("NfcosClientManagerHodo", "发卡订单申请付款时，传入SE标识无效");
            }
            throw new BusinessException("发卡订单申请付款时，传入SE标识无效", ErrorMessage.local_business_para_error);
        } else if (str == null || str.length() < 1) {
            if (this.fmLog != null) {
                this.fmLog.warn("NfcosClientManagerHodo", "发卡订单申请付款时，传入终端型号无效");
            }
            throw new BusinessException("发卡订单申请付款时，传入终端型号无效", ErrorMessage.local_business_para_error);
        } else if (bArr2 == null || bArr2.length < 1) {
            if (this.fmLog != null) {
                this.fmLog.warn("NfcosClientManagerHodo", "发卡订单申请付款时，传入活动编码无效");
            }
            throw new BusinessException("发卡订单申请付款时，传入活动编码无效", ErrorMessage.local_business_para_error);
        } else if (i <= 0) {
            if (this.fmLog != null) {
                this.fmLog.warn("NfcosClientManagerHodo", "发卡订单申请付款时，传入的支付金额无效");
            }
            throw new BusinessException("发卡订单申请付款时，传入的支付金额无效", ErrorMessage.local_business_para_error);
        } else {
            return this.manager.getCardAppTrade().applyAct4Pay(bArr2, enumCardAppType, FM_Bytes.join(FM_Bytes.join(FM_Bytes.join(FM_Bytes.join(FM_Bytes.join(FM_Bytes.join(new byte[]{(byte) 2, (byte) 1, (byte) i2}, new byte[]{(byte) 1, (byte) FM_Bytes.intToBytes(i, 4).length}), r1), new byte[]{(byte) 3, (byte) bArr.length}), bArr), new byte[]{(byte) 5, (byte) str.getBytes().length}), r1));
        }
    }

    public List<PreDepositInfo> queryBlance4PreDeposit(EnumCardAppType enumCardAppType) throws BusinessException {
        if (enumCardAppType != null) {
            return this.manager.getCardAppTrade().queryPreDepositVer2(enumCardAppType);
        }
        if (this.fmLog != null) {
            this.fmLog.warn("NfcosClientManagerHodo", "充值额度信息查询时，传入的卡类型为空");
        }
        throw new BusinessException("充值额度信息查询时，传入的卡类型为空", ErrorMessage.local_business_para_error);
    }

    public int terminalFeedback(TerminalBackInfo terminalBackInfo) throws BusinessException {
        if (terminalBackInfo != null) {
            return this.manager.getCardAppTrade().terminalInfoBack(terminalBackInfo);
        }
        if (this.fmLog != null) {
            this.fmLog.warn("NfcosClientManagerHodo", "终端信息反馈时，传入的反馈信息对象为空");
        }
        throw new BusinessException("终端信息反馈时，传入的反馈信息对象为空", ErrorMessage.local_business_para_error);
    }

    public List<Activity> queryActivities(EnumCardAppType enumCardAppType) throws BusinessException {
        if (enumCardAppType != null) {
            return this.manager.getCardAppTrade().queryActivities(enumCardAppType);
        }
        if (this.fmLog != null) {
            this.fmLog.warn("NfcosClientManagerHodo", "活动信息列表查询时，传入的卡类型为空");
        }
        throw new BusinessException("活动信息列表查询时，传入的卡类型为空", ErrorMessage.local_business_para_error);
    }

    public int orderExec(byte[] bArr, byte[] bArr2) throws BusinessException {
        return this.manager.getCardAppInstall().orderExce(bArr, bArr2);
    }

    public byte[] rentBusinessHandle(int i, byte[] bArr) throws BusinessException {
        return this.manager.getCardAppTrade().rentBusinessHandle(i, bArr);
    }

    public int appletDownload(EnumCardAppType enumCardAppType, byte[] bArr, String str) throws BusinessException {
        if (enumCardAppType == null) {
            if (this.fmLog != null) {
                this.fmLog.warn("NfcosClientManagerHodo", "applet预下载时，传入的卡类型为空");
            }
            throw new BusinessException("applet预下载时，传入的卡类型为空", ErrorMessage.local_business_para_error);
        } else if (bArr == null || bArr.length < 1) {
            if (this.fmLog != null) {
                this.fmLog.warn("NfcosClientManagerHodo", "applet预下载时，传入的eSE标识为空");
            }
            throw new BusinessException("applet预下载时，传入的eSE标识为空", ErrorMessage.local_business_para_error);
        } else if (str == null || str.length() < 1) {
            if (this.fmLog != null) {
                this.fmLog.warn("NfcosClientManagerHodo", "applet预下载时，传入的终端信号规格为空");
            }
            throw new BusinessException("applet预下载时，传入的传入的终端信号规格为空", ErrorMessage.local_business_para_error);
        } else if (this.manager.getCardAppInstall().appletDownload(enumCardAppType, bArr, str)) {
            return 0;
        } else {
            return 99;
        }
    }

    public List<Product> queryProducts(String str, EnumCardAppType enumCardAppType, String str2, String str3) throws BusinessException {
        if (enumCardAppType == null) {
            if (this.fmLog != null) {
                this.fmLog.warn("NfcosClientManagerHodo", "产品信息检索时，传入的卡类型为空");
            }
            throw new BusinessException("applet预下载时，传入的卡类型为空", ErrorMessage.local_business_para_error);
        } else if (str2 == null || str2.length() < 1) {
            if (this.fmLog != null) {
                this.fmLog.warn("NfcosClientManagerHodo", "产品信息检索时，传入的SIM所属城市为空");
            }
            throw new BusinessException("产品信息检索时，传入的SIM所属城市为空", ErrorMessage.local_business_para_error);
        } else if (str3 == null || str3.length() < 1) {
            if (this.fmLog != null) {
                this.fmLog.warn("NfcosClientManagerHodo", "产品信息检索时，用户当前所属城市为空");
            }
            throw new BusinessException("产品信息检索时，用户当前所属城市为空", ErrorMessage.local_business_para_error);
        } else {
            byte[] bytes = str2.getBytes();
            return this.manager.getCardAppTrade().queryProducts(str, enumCardAppType, FM_Bytes.join(FM_Bytes.join(FM_Bytes.join(new byte[]{(byte) 1, (byte) bytes.length}, bytes), new byte[]{(byte) 2, (byte) r1.length}), str3.getBytes()));
        }
    }

    public void registerLogHandle(FMLog fMLog) {
        LogFactory.getInstance().setLog(fMLog);
    }

    public List<PromotionMessage> queryPromotionMessage() throws BusinessException {
        return this.manager.getBusinessExtend().queryPromotionMessage();
    }

    public MainOrder applyPromotion(byte[] bArr) throws BusinessException {
        return this.manager.getBusinessExtend().applyPromotion(bArr);
    }
}
