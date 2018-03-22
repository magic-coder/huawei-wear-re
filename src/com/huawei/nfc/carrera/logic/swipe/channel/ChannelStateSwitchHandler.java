package com.huawei.nfc.carrera.logic.swipe.channel;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.huawei.nfc.carrera.constant.AutoReportErrorCode;
import com.huawei.nfc.carrera.logic.ese.ESEApiFactory;
import com.huawei.nfc.carrera.logic.ta.TACardInfo;
import com.huawei.nfc.carrera.logic.ta.WalletTaException.WalletTaCardNotExistException;
import com.huawei.nfc.carrera.logic.ta.WalletTaException.WalletTaDefaultCardNotExistException;
import com.huawei.nfc.carrera.logic.ta.WalletTaException.WalletTaFingerIdMismatchException;
import com.huawei.nfc.carrera.logic.ta.WalletTaException.WalletTaSystemErrorException;
import com.huawei.nfc.carrera.logic.ta.WalletTaManager;
import com.huawei.nfc.carrera.ui.bus.exception.ShowBindBusResultActivity;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.NfcUtil;
import com.huawei.nfc.carrera.util.logger.CloudEyeLogger;
import com.huawei.nfc.util.NFCFragmentUtil;
import java.util.HashMap;
import java.util.Map;

public class ChannelStateSwitchHandler extends Handler {
    static final int CHANNEL_STATE_SWITCH_CLOSE = 3;
    static final int CHANNEL_STATE_SWITCH_OPEN_BY_VERIFY_FINGER = 1;
    static final int CHANNEL_STATE_SWITCH_OPEN_BY_VERIFY_PASSWORD = 2;
    static final int DEFAULT_CARD = 8;
    static final int DISABLE_EMULATION = 7;
    static final int ENABLE_EMULATION = 6;
    static final int GET_DEFAULT_CARD = 5;
    static final int SET_DEFAULT_CARD = 81;
    static final int SET_DEFAULT_CARD_RFCONF = 83;
    private final Context mContext;

    ChannelStateSwitchHandler(Context context, Looper looper) {
        super(looper);
        this.mContext = context.getApplicationContext();
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 1:
                ChannelManager.getInstance(this.mContext).channelOpenCallback((ChannelOpenCallback) message.obj, enableByFinger(message.arg1), message.arg1);
                return;
            case 2:
                ChannelManager.getInstance(this.mContext).channelOpenCallback((ChannelOpenCallback) message.obj, enableByPassword(message.arg1), message.arg1);
                return;
            case 3:
                ChannelManager.getInstance(this.mContext).channelCloseCallback((ChannelCloseCallback) message.obj, disable(message.arg1), message.arg1);
                return;
            case 5:
                ChannelManager.getInstance(this.mContext).getDefaultCardCallback((GetDefaultCardCallback) message.obj, WalletTaManager.getInstance(this.mContext).getDefaultCard());
                return;
            case 6:
                enableCardEmulation();
                ChannelManager.getInstance(this.mContext).channelOpenCallback((ChannelOpenCallback) message.obj, true, message.arg1);
                return;
            case 7:
                disableCardEmulation();
                ChannelManager.getInstance(this.mContext).channelCloseCallback((ChannelCloseCallback) message.obj, true, message.arg1);
                return;
            case 8:
                handleDefaultCardMessage(message);
                return;
            default:
                return;
        }
    }

    private boolean enableByFinger(int i) {
        boolean isDevicesNeedPowerOn = NfcUtil.isDevicesNeedPowerOn();
        LogX.i("enableByFinger is DevicesNeedPowerOn: " + isDevicesNeedPowerOn);
        if (isDevicesNeedPowerOn) {
            LogX.i("enableByFinger esePowerOn begin");
            ESEApiFactory.createESEInfoManagerApi(this.mContext).esePowerOn();
            LogX.i("enableByFinger esePowerOn end");
        }
        LogX.i("enableByFinger activateCardByFpPwd begin");
        isDevicesNeedPowerOn = activateCardByFpPwd(i);
        LogX.i("enableByFinger activateCardByFpPwd end, isSuccess: " + isDevicesNeedPowerOn);
        if (isDevicesNeedPowerOn) {
            LogX.i("enableByFinger enable Card Emulation begin");
            CardEmulationSwitch.enable(this.mContext);
            LogX.i("enableByFinger enable Card Emulation end");
        }
        return isDevicesNeedPowerOn;
    }

    private boolean enableByPassword(int i) {
        boolean isDevicesNeedPowerOn = NfcUtil.isDevicesNeedPowerOn();
        LogX.i("enableByFinger is DevicesNeedPowerOn: " + isDevicesNeedPowerOn);
        if (isDevicesNeedPowerOn) {
            LogX.i("enableByPassword esePowerOn begin");
            ESEApiFactory.createESEInfoManagerApi(this.mContext).esePowerOn();
            LogX.i("enableByPassword esePowerOn end");
        }
        LogX.i("enableByPassword activateCardByPayPwd begin");
        boolean activateCardByPayPwd = activateCardByPayPwd(i);
        LogX.i("enableByPassword activateCardByPayPwd end, isSuccess: " + activateCardByPayPwd);
        if (2 == i && isDevicesNeedPowerOn) {
            LogX.i("enableByPassword esePoweroff cardType: " + i);
            ESEApiFactory.createESEInfoManagerApi(this.mContext).esePowerOff();
        }
        if (activateCardByPayPwd) {
            LogX.i("enableByPassword enable Card Emulation begin");
            CardEmulationSwitch.enable(this.mContext);
            LogX.i("enableByPassword enable Card Emulation end");
        }
        return activateCardByPayPwd;
    }

    private boolean disable(int i) {
        LogX.i("disable Card Emulation begin");
        NfcUtil.isSelectSE(this.mContext);
        boolean isDevicesNeedPowerOn = NfcUtil.isDevicesNeedPowerOn();
        LogX.i("disable is DevicesNeedPowerOn: " + isDevicesNeedPowerOn);
        if (isDevicesNeedPowerOn) {
            LogX.d("disableTransactionChannel esePowerOn begin");
            ESEApiFactory.createESEInfoManagerApi(this.mContext).esePowerOff();
            ESEApiFactory.createESEInfoManagerApi(this.mContext).esePowerOn();
            LogX.d("disableTransactionChannel esePowerOn end");
            LogX.i("disable deActivateCard begin");
            isDevicesNeedPowerOn = deActivateCard(i);
            LogX.i("disable deActivateCard end, isSuccess: " + isDevicesNeedPowerOn);
            LogX.i("disableTransactionChannel esePowerOff begin");
            ESEApiFactory.createESEInfoManagerApi(this.mContext).esePowerOff();
            LogX.i("disableTransactionChannel esePowerOff end");
            return isDevicesNeedPowerOn;
        }
        LogX.i("disable deActivateCard begin");
        isDevicesNeedPowerOn = deActivateCard(i);
        LogX.i("disable deActivateCard end, isSuccess: " + isDevicesNeedPowerOn);
        return isDevicesNeedPowerOn;
    }

    private void enableCardEmulation() {
        LogX.i("enableCardEmulation enable Card Emulation begin");
        CardEmulationSwitch.enable(this.mContext);
        LogX.i("enableCardEmulation enable Card Emulation end");
    }

    private void disableCardEmulation() {
        LogX.i("disableCardEmulation disable Card Emulation begin");
        CardEmulationSwitch.disable(this.mContext);
        LogX.i("disableCardEmulation disable Card Emulation end");
    }

    private boolean activateCard(int i) {
        boolean isDevicesNeedPowerOn = NfcUtil.isDevicesNeedPowerOn();
        LogX.i("activateCard is DevicesNeedPowerOn: " + isDevicesNeedPowerOn);
        if (isDevicesNeedPowerOn) {
            LogX.i("activateCard esePowerOn begin");
            ESEApiFactory.createESEInfoManagerApi(this.mContext).esePowerOn();
            LogX.i("activateCard esePowerOn end");
            LogX.i("activateCard activateCardByPayPwd begin");
            isDevicesNeedPowerOn = activateCardByPayPwd(i);
            LogX.i("activateCard activateCardByPayPwd end, isSuccess: " + isDevicesNeedPowerOn);
            LogX.i("activateCard esePowerOff begin");
            ESEApiFactory.createESEInfoManagerApi(this.mContext).esePowerOff();
            LogX.i("activateCard esePowerOff end");
            return isDevicesNeedPowerOn;
        }
        LogX.i("activateCard activateCardByPayPwd begin");
        isDevicesNeedPowerOn = activateCardByPayPwd(i);
        LogX.i("activateCard activateCardByPayPwd end, isSuccess: " + isDevicesNeedPowerOn);
        return isDevicesNeedPowerOn;
    }

    private boolean deactivateCard(int i) {
        boolean isDevicesNeedPowerOn = NfcUtil.isDevicesNeedPowerOn();
        LogX.i("deactivateCard is DevicesNeedPowerOn: " + isDevicesNeedPowerOn);
        if (isDevicesNeedPowerOn) {
            LogX.d("deactivateCard esePowerOn begin");
            ESEApiFactory.createESEInfoManagerApi(this.mContext).esePowerOn();
            LogX.d("deactivateCard esePowerOn end");
            LogX.i("deactivateCard deActivateCard begin");
            isDevicesNeedPowerOn = deActivateCard(i);
            LogX.i("deactivateCard deActivateCard end, isSuccess: " + isDevicesNeedPowerOn);
            LogX.i("deactivateCard esePowerOff begin");
            ESEApiFactory.createESEInfoManagerApi(this.mContext).esePowerOff();
            LogX.i("deactivateCard esePowerOff end");
            return isDevicesNeedPowerOn;
        }
        LogX.i("deactivateCard deActivateCard begin");
        isDevicesNeedPowerOn = deActivateCard(i);
        LogX.i("deactivateCard deActivateCard end, isSuccess: " + isDevicesNeedPowerOn);
        return isDevicesNeedPowerOn;
    }

    private boolean activateCardByFpPwd(int i) {
        Map hashMap;
        try {
            WalletTaManager.getInstance(this.mContext).activateCardByFpPwd(i);
            return true;
        } catch (WalletTaFingerIdMismatchException e) {
            hashMap = new HashMap();
            hashMap.put(ShowBindBusResultActivity.FAIL_REASON_KEY, "fingerId is mismatch");
            hashMap.put(CloudEyeLogger.FAIL_CODE, "activateCardByFpPwd failed");
            LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_CHANNEL_STATE_SWITCH_FAIL, hashMap, "activateCardByFpPwd failed, fingerId is mismatch", false, false);
            return false;
        } catch (WalletTaSystemErrorException e2) {
            Map hashMap2 = new HashMap();
            hashMap2.put(ShowBindBusResultActivity.FAIL_REASON_KEY, "system errorCode:" + e2.getCode());
            hashMap2.put(CloudEyeLogger.FAIL_CODE, "activateCardByFpPwd failed");
            LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_CHANNEL_STATE_SWITCH_FAIL, hashMap2, "activateCardByFpPwd failed, system error, errorCode: " + e2.getCode(), false, false);
            return false;
        } catch (WalletTaDefaultCardNotExistException e3) {
            hashMap = new HashMap();
            hashMap.put(ShowBindBusResultActivity.FAIL_REASON_KEY, "default card not exist");
            hashMap.put(CloudEyeLogger.FAIL_CODE, "activateCardByFpPwd failed");
            LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_CHANNEL_STATE_SWITCH_FAIL, hashMap, "activateCardByFpPwd failed, default card is not exist", false, false);
            return false;
        } catch (WalletTaCardNotExistException e4) {
            hashMap = new HashMap();
            hashMap.put(ShowBindBusResultActivity.FAIL_REASON_KEY, "card is not exist");
            hashMap.put(CloudEyeLogger.FAIL_CODE, "activateCardByFpPwd failed");
            LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_CHANNEL_STATE_SWITCH_FAIL, hashMap, "activateCardByFpPwd failed, card is not exist", false, false);
            return false;
        }
    }

    private boolean activateCardByPayPwd(int i) {
        Map hashMap;
        try {
            WalletTaManager.getInstance(this.mContext).activateCardByPayPwd(i);
            return true;
        } catch (WalletTaSystemErrorException e) {
            Map hashMap2 = new HashMap();
            hashMap2.put(ShowBindBusResultActivity.FAIL_REASON_KEY, "system errorCode:" + e.getCode());
            hashMap2.put(CloudEyeLogger.FAIL_CODE, "activateCardByFpPwd failed");
            LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_CHANNEL_STATE_SWITCH_FAIL, hashMap2, "activateCardByPayPwd system errorCode: " + e.getCode(), false, false);
            return false;
        } catch (WalletTaDefaultCardNotExistException e2) {
            hashMap = new HashMap();
            hashMap.put(ShowBindBusResultActivity.FAIL_REASON_KEY, "default card not exist");
            hashMap.put(CloudEyeLogger.FAIL_CODE, "activateCardByFpPwd failed");
            LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_CHANNEL_STATE_SWITCH_FAIL, hashMap, "activateCardByPayPwd failed, default card is not exist", false, false);
            return false;
        } catch (WalletTaCardNotExistException e3) {
            hashMap = new HashMap();
            hashMap.put(ShowBindBusResultActivity.FAIL_REASON_KEY, "card is not exist");
            hashMap.put(CloudEyeLogger.FAIL_CODE, "activateCardByFpPwd failed");
            LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_CHANNEL_STATE_SWITCH_FAIL, hashMap, "activateCardByPayPwd failed, card is not exist", false, false);
            return false;
        }
    }

    private boolean deActivateCard(int i) {
        try {
            WalletTaManager.getInstance(this.mContext).deactivateCard(i);
            return true;
        } catch (WalletTaSystemErrorException e) {
            Map hashMap = new HashMap();
            hashMap.put(ShowBindBusResultActivity.FAIL_REASON_KEY, "system errorCode:" + e.getCode());
            hashMap.put(CloudEyeLogger.FAIL_CODE, "deActivateCard failed");
            LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_CHANNEL_STATE_SWITCH_FAIL, hashMap, "activateCard failed code = " + e.getCode(), false, false);
            return false;
        }
    }

    private boolean setDefaultCard(String str) {
        Map hashMap;
        TACardInfo defaultCard = WalletTaManager.getInstance(this.mContext).getDefaultCard();
        if (defaultCard != null && defaultCard.cardGroupType == 2) {
            if (NFCFragmentUtil.isPhoneSupportShutdownSwipe()) {
                LogX.i("phone support shutdown swipe card.");
            } else {
                LogX.i("phone not support shutdown swipe card.");
                deactivateCard(2);
            }
        }
        boolean z = true;
        try {
            WalletTaManager.getInstance(this.mContext).setDefaultCard(str);
        } catch (WalletTaCardNotExistException e) {
            hashMap = new HashMap();
            hashMap.put(CloudEyeLogger.FAIL_CODE, "setDefaultCard WalletTaCardNotExistException");
            LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_SET_DEFAULT_CARD_FAIL, hashMap, "setCardDefaultInTA WalletTaCardNotExistException", false, false);
            z = false;
        } catch (WalletTaSystemErrorException e2) {
            hashMap = new HashMap();
            hashMap.put(CloudEyeLogger.FAIL_CODE, "setDefaultCard WalletTaSystemErrorException");
            LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_SET_DEFAULT_CARD_FAIL, hashMap, "setCardDefaultInTA WalletTaSystemErrorException", false, false);
            z = false;
        }
        if (z) {
            TACardInfo defaultCard2 = WalletTaManager.getInstance(this.mContext).getDefaultCard();
            if (defaultCard2 != null && defaultCard2.cardGroupType == 2) {
                if (NFCFragmentUtil.isPhoneSupportShutdownSwipe()) {
                    LogX.i("phone support shutdown swipe card.");
                } else {
                    LogX.i("phone not support shutdown swipe card.");
                    activateCard(2);
                }
            }
        }
        return z;
    }

    private void handleDefaultCardMessage(Message message) {
        Object[] objArr;
        switch (message.arg1) {
            case 81:
                objArr = (Object[]) message.obj;
                String str = (String) objArr[0];
                ChannelManager.getInstance(this.mContext).setDefaultCardCallback((SetDefaultCardCallback) objArr[1], setDefaultCard(str));
                return;
            case 83:
                objArr = (Object[]) message.obj;
                int parseInt = Integer.parseInt(objArr[0].toString());
                boolean parseBoolean = Boolean.parseBoolean(objArr[1].toString());
                if (parseInt == 1 || parseInt == 2) {
                    RFConfChangeManager.getInstance(this.mContext).setDefaultCardRFConf(parseInt, parseBoolean);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
