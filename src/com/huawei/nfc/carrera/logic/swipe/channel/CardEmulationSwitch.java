package com.huawei.nfc.carrera.logic.swipe.channel;

import android.content.Context;
import android.nfc.NfcAdapter;
import android.nfc.NfcManager;
import com.huawei.nfc.carrera.constant.AutoReportErrorCode;
import com.huawei.nfc.carrera.logic.swipe.SwipeLogicManager;
import com.huawei.nfc.carrera.ui.bus.exception.ShowBindBusResultActivity;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.logger.CloudEyeLogger;
import com.huawei.ui.main.stories.lightcloud.constants.JoinConstants;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class CardEmulationSwitch {
    private static final int ENABLE_OVERRIDE_RECONFIGURED = 1;
    private static final int FLAGS_LISTEN_MASK_DISAB_A_DISAB_B = 0;
    private static final int FLAGS_LISTEN_MASK_ENAB_A_ENAB_B = 3;
    private static final String TAG = CardEmulationSwitch.class.getSimpleName();

    public static void enable(Context context) {
        LogX.i(JoinConstants.ENABLE);
        switchCardEmu(context, 1, 3);
    }

    public static void disable(Context context) {
        LogX.i("disable");
        switchCardEmu(context, 1, 0);
    }

    private static boolean switchCardEmu(Context context, int i, int i2) {
        Map hashMap;
        try {
            LogX.d(TAG, "enableCardEmulation. enableOverride==" + i);
            if (getNfcAdapter(context) == null) {
                hashMap = new HashMap();
                hashMap.put(ShowBindBusResultActivity.FAIL_REASON_KEY, "enableCardEmulation. adapter is null");
                hashMap.put(CloudEyeLogger.FAIL_CODE, "switchCardEmu");
                LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_CHANNEL_STATE_SWITCH_FAIL, hashMap, "enableCardEmulation. adapter is null.", false, false);
                return false;
            }
            Class cls = Class.forName("com.nxp.nfc.NxpNfcAdapter");
            Object invoke = cls.getDeclaredMethod("getNxpNfcAdapter", new Class[]{NfcAdapter.class}).invoke(null, new Object[]{r2});
            cls.getMethod("SetListenTechMask", new Class[]{Integer.TYPE, Integer.TYPE}).invoke(invoke, new Object[]{Integer.valueOf(i2), Integer.valueOf(i)});
            return true;
        } catch (NoSuchMethodException e) {
            hashMap = new HashMap();
            hashMap.put(ShowBindBusResultActivity.FAIL_REASON_KEY, "NoSuchMethodException");
            hashMap.put(CloudEyeLogger.FAIL_CODE, "switchCardEmu");
            LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_CHANNEL_STATE_SWITCH_FAIL, hashMap, "switchCardEmu NoSuchMethodException", false, false);
            return false;
        } catch (ClassNotFoundException e2) {
            hashMap = new HashMap();
            hashMap.put(ShowBindBusResultActivity.FAIL_REASON_KEY, "ClassNotFoundException");
            hashMap.put(CloudEyeLogger.FAIL_CODE, "switchCardEmu");
            LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_CHANNEL_STATE_SWITCH_FAIL, hashMap, "switchCardEmu ClassNotFoundException", false, false);
            return false;
        } catch (IllegalArgumentException e3) {
            hashMap = new HashMap();
            hashMap.put(ShowBindBusResultActivity.FAIL_REASON_KEY, "IllegalArgumentException");
            hashMap.put(CloudEyeLogger.FAIL_CODE, "switchCardEmu");
            LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_CHANNEL_STATE_SWITCH_FAIL, hashMap, "switchCardEmu IllegalArgumentException", false, false);
            return false;
        } catch (IllegalAccessException e4) {
            hashMap = new HashMap();
            hashMap.put(ShowBindBusResultActivity.FAIL_REASON_KEY, "IllegalAccessException");
            hashMap.put(CloudEyeLogger.FAIL_CODE, "switchCardEmu");
            LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_CHANNEL_STATE_SWITCH_FAIL, hashMap, "switchCardEmu IllegalAccessException", false, false);
            return false;
        } catch (InvocationTargetException e5) {
            hashMap = new HashMap();
            hashMap.put(ShowBindBusResultActivity.FAIL_REASON_KEY, "InvocationTargetException");
            hashMap.put(CloudEyeLogger.FAIL_CODE, "switchCardEmu");
            LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_CHANNEL_STATE_SWITCH_FAIL, hashMap, "switchCardEmu InvocationTargetException", false, false);
            return false;
        }
    }

    private static NfcAdapter getNfcAdapter(Context context) {
        if (context == null) {
            return null;
        }
        NfcManager nfcManager = (NfcManager) context.getSystemService(SwipeLogicManager.NFC_PAYFORM);
        if (nfcManager == null) {
            return null;
        }
        NfcAdapter defaultAdapter = nfcManager.getDefaultAdapter();
        if (defaultAdapter == null) {
            return null;
        }
        return defaultAdapter;
    }
}
