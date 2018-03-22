package com.huawei.nfc.carrera.logic.spi.fm.impl;

import android.content.Context;
import cn.com.fmsh.script.ApduHandler;
import cn.com.fmsh.script.ApduHandler.ApduHandlerType;
import cn.com.fmsh.script.constants.ScriptToolsConst.TagName;
import cn.com.fmsh.script.exception.FMScriptHandleException;
import cn.com.fmsh.tsm.business.constants.Constants;
import cn.com.fmsh.util.FM_Bytes;
import com.huawei.nfc.PluginPay;
import com.huawei.nfc.PluginPayAdapter;
import com.huawei.nfc.carrera.constant.Constant;
import com.huawei.nfc.carrera.util.LogX;

public class FMApduHandlerImpl implements ApduHandler {
    private static final Object APDU_LOCK = new Object();
    private static final int DEVICE_CONNECTED = 2;
    private static final int DEVICE_CONNECTING = 1;
    private static final int DEVICE_CONNECT_FAILED = 4;
    private static final int DEVICE_DISCONNECTED = 3;
    private static final int DEVICE_UNAVAILABLE = 5;
    private static final int DEVICE_UNKNOWN = 0;
    private static final Object OPEN_LOCK = new Object();
    private static final byte[] STPC_AID_SH = new byte[]{TagName.CommandSingle, (byte) 0, (byte) 0, (byte) 0, (byte) 3, Constants.TagName.ACTIVITY_TOTAL, Constants.TagName.PRODUCT_INFO, (byte) 7, (byte) 1};
    private final byte[] STPC_AID_LNT = new byte[]{(byte) 89, Constants.TagName.TERMINAL_BACK_INFO_TYPE, Constants.TagName.TERMINAL_BACK_INFO_LIST, Constants.TagName.SIM_SEID, Constants.TagName.TERMINAL_BACK_CHILDREN_ID, Constants.TagName.TERMINAL_BACK_INFO, Constants.TagName.TERMINAL_MODEL_NUMBER, Constants.TagName.TERMINAL_BACK_QUESTION_FLAG};
    private final String TAG = "FMServiceImpl";
    private volatile byte[] currentAid = null;
    private volatile boolean isOpen = false;
    private PluginPayAdapter pluginPayAdapter;

    public FMApduHandlerImpl(Context context) {
        this.pluginPayAdapter = (PluginPayAdapter) PluginPay.getInstance(context).getAdapter();
    }

    public boolean isConnect() {
        LogX.i("FMServiceImpl", "FMApduHandlerImpl isConnect : " + this.isOpen);
        return this.isOpen;
    }

    public boolean connect() {
        close();
        LogX.i("FMServiceImpl", "FMApduHandlerImpl connect");
        return open(null);
    }

    public void close() {
        LogX.i("FMServiceImpl", "FMApduHandlerImpl close");
        this.isOpen = false;
        this.currentAid = null;
        LogX.i("FMServiceImpl", "FMApduHandlerImpl close pluginPayAdapter : " + this.pluginPayAdapter);
        if (this.pluginPayAdapter != null) {
            this.pluginPayAdapter.closeChannel();
        }
    }

    public ApduHandlerType getApduHandlerType() {
        LogX.i("FMServiceImpl", "FMApduHandlerImpl getApduHandlerType " + ApduHandlerType.BLUETOOTH.getDescription());
        return ApduHandlerType.BLUETOOTH;
    }

    public boolean open(byte[] bArr) {
        boolean z = true;
        synchronized (OPEN_LOCK) {
            LogX.i("FMServiceImpl", "FMApduHandlerImpl open");
            if (bArr == null || bArr.length < 1) {
                if (this.pluginPayAdapter.openChannelSNB(getAidByte(), 0) == null) {
                    z = false;
                }
                this.isOpen = z;
                this.currentAid = getAidByte();
            } else {
                if (this.pluginPayAdapter.openChannelSNB(bArr, 0) == null) {
                    z = false;
                }
                this.isOpen = z;
                this.currentAid = bArr;
            }
            LogX.i("FMServiceImpl", "FMApduHandlerImpl open" + this.isOpen);
            z = this.isOpen;
        }
        return z;
    }

    public byte[] transceive(byte[] bArr) throws FMScriptHandleException {
        byte[] bArr2 = null;
        boolean z = true;
        synchronized (APDU_LOCK) {
            LogX.i("FMServiceImpl", "FMApduHandlerImpl transceive apdu = " + FM_Bytes.bytesToHexString(bArr));
            if (isBTConnect()) {
                if (!this.isOpen) {
                    if (this.currentAid == null || this.currentAid.length < 1) {
                        this.currentAid = getAidByte();
                    }
                    if (this.pluginPayAdapter.openChannelSNB(this.currentAid, 0) == null) {
                        z = false;
                    }
                    this.isOpen = z;
                    if (!this.isOpen) {
                    }
                }
                bArr2 = this.pluginPayAdapter.transmitSNB(bArr);
                LogX.i("FMServiceImpl", "FMApduHandlerImpl transceive apdu response = " + FM_Bytes.bytesToHexString(bArr2));
            }
        }
        return bArr2;
    }

    public boolean isBTConnect() {
        int deviceConnectState = this.pluginPayAdapter.getDeviceConnectState();
        LogX.i("FMServiceImpl", "FMApduHandlerImpl isBTConnect connectState = " + deviceConnectState);
        if (2 == deviceConnectState) {
            return true;
        }
        this.isOpen = false;
        this.currentAid = null;
        FMAIDUtil.setAid(null);
        return false;
    }

    private byte[] getAidByte() {
        String aid = FMAIDUtil.getAid();
        if (aid == null || aid.equals("")) {
            LogX.i("getAidByte enter aid is null ");
            return null;
        }
        LogX.i("getAidByte aid : " + aid);
        if (aid.equals(Constant.SH_CARD_AID)) {
            return STPC_AID_SH;
        }
        if (aid.equals(Constant.LNT_CARD_AID)) {
            return this.STPC_AID_LNT;
        }
        return STPC_AID_SH;
    }
}
