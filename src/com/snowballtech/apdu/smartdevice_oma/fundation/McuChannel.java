package com.snowballtech.apdu.smartdevice_oma.fundation;

import com.snowballtech.apdu.bean.SeConstants;
import com.snowballtech.apdu.internal.INfcChannel;
import com.snowballtech.apdu.service.SnowballNfcException;
import com.snowballtech.common.log.LogUtil;
import com.snowballtech.common.util.ByteHelperUtil;
import com.snowballtech.common.util.ValueUtil;
import com.snowballtech.smartdevice.SnowBallAPDU;

public class McuChannel implements INfcChannel {
    private String TAG = "McuChannel";
    private SnowBallAPDU apdu;
    private int channelType;
    private byte[] instanceId;
    private String instance_id;
    private boolean isNullForInstanceId;

    public McuChannel(SnowBallAPDU snowBallAPDU, String str, int i) {
        this.apdu = snowBallAPDU;
        this.instance_id = str;
        this.channelType = i;
        prepareProcessAid();
    }

    private void prepareProcessAid() {
        LogUtil.log(this.TAG, "prepareProcessAid start ");
        if (ValueUtil.isEmpty(this.instance_id) || !this.instance_id.equals("cplc")) {
            this.instanceId = ByteHelperUtil.hexStringToByteArray(this.instance_id);
        } else {
            this.isNullForInstanceId = true;
            this.instanceId = SeConstants.AID_BYTE_65T;
        }
        LogUtil.log(this.TAG, "prepareProcessAid end ,instance_id=" + this.instance_id + ",access instance_id:" + ByteHelperUtil.toHexString(this.instanceId));
    }

    public byte[] openChannel() throws SnowballNfcException {
        try {
            LogUtil.log(this.TAG + "openChannel instanceId is +" + this.instance_id + "'channelType is " + this.channelType);
            byte[] openChannel = this.apdu.openChannel(this.instanceId, this.channelType);
            LogUtil.log(this.TAG + "openChannel result is +" + ByteHelperUtil.toHexString(openChannel));
            return openChannel;
        } catch (Throwable e) {
            e.printStackTrace();
            throw new SnowballNfcException(e);
        }
    }

    public byte[] transmit(byte[] bArr) throws SnowballNfcException {
        LogUtil.log(this.TAG, ByteHelperUtil.toHexString(bArr));
        try {
            byte[] transmit = this.apdu.transmit(bArr);
            LogUtil.log("transmit result is =" + ByteHelperUtil.toHexString(transmit));
            return transmit;
        } catch (Throwable e) {
            e.printStackTrace();
            throw new SnowballNfcException(e);
        }
    }

    public void closeChannel() throws SnowballNfcException {
        try {
            this.apdu.close();
        } catch (Throwable e) {
            e.printStackTrace();
            throw new SnowballNfcException(e);
        }
    }
}
