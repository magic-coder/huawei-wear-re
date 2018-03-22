package com.snowballtech.apdu.smartdevice_oma.fundation;

import com.snowballtech.apdu.bean.Content;
import com.snowballtech.apdu.internal.INfcChannel;
import com.snowballtech.apdu.service.SnowballNfcException;
import com.snowballtech.common.log.LogUtil;
import com.snowballtech.smartdevice.SnowBallAPDU;

public class McuService {
    private String TAG = "McuService";
    private NfcObject nfcObject;

    public NfcObject pullChannel(SnowBallAPDU snowBallAPDU, String str, int i, int i2) throws SnowballNfcException {
        LogUtil.log(this.TAG, " pullNFCChannel start ");
        this.nfcObject = McuObjectContainer.getInstance().pull(str, i, i2);
        if (this.nfcObject == null && McuObjectContainer.getInstance().isFull()) {
            throw new SnowballNfcException(" channel limit ");
        }
        if (this.nfcObject == null) {
            LogUtil.log(this.TAG, "need to new a nfcObject");
            INfcChannel mcuChannel = new McuChannel(snowBallAPDU, str, i);
            McuObjectContainer.getInstance().push(mcuChannel, mcuChannel.openChannel(), str, i, i2);
            this.nfcObject = McuObjectContainer.getInstance().pull(str, i, i2);
        }
        return this.nfcObject;
    }

    public void closeChannel(Content content) {
        McuObjectContainer.getInstance().remove(content.getInstance_id(), content.getChannelType(), content.getMediaType());
    }

    public void closeChannelAll() {
        McuObjectContainer.getInstance().removeAll();
    }
}
