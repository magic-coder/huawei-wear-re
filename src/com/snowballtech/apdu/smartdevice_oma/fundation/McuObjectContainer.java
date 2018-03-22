package com.snowballtech.apdu.smartdevice_oma.fundation;

import com.snowballtech.apdu.internal.INfcChannel;
import com.snowballtech.common.log.LogUtil;
import com.snowballtech.common.util.ValueUtil;
import java.util.ArrayList;
import java.util.List;

public class McuObjectContainer {
    private static volatile McuObjectContainer singleton;
    private String TAG = "McuObjectContainer";
    private List<NfcObject> container = new ArrayList();

    public static McuObjectContainer getInstance() {
        if (singleton == null) {
            synchronized (McuObjectContainer.class) {
                if (singleton == null) {
                    singleton = new McuObjectContainer();
                }
            }
        }
        return singleton;
    }

    private McuObjectContainer() {
    }

    public void setContainer(List<NfcObject> list) {
        this.container = list;
    }

    public boolean isFull() {
        return this.container.size() >= 4;
    }

    public boolean isEmpty() {
        return this.container.size() == 0;
    }

    public int getContainerSize() {
        return this.container.size();
    }

    private boolean isExist(String str, String str2) {
        if (ValueUtil.isEmpty(str) || ValueUtil.isEmpty(str2) || !str2.equals(str)) {
            return false;
        }
        return true;
    }

    public void push(INfcChannel iNfcChannel, byte[] bArr, String str, int i, int i2) {
        String str2 = " push ";
        LogUtil.log(this.TAG, str2 + " start,instance_id=" + str + "channelType=" + i + ",mediaType=" + i2 + ",container.size=" + this.container.size());
        if (this.container.size() < 4) {
            NfcObject nfcObject = new NfcObject();
            nfcObject.setInstance_id(str);
            nfcObject.setChannelType(i);
            nfcObject.setResponse(bArr);
            nfcObject.setMediaType(i2);
            nfcObject.setNfcChannel(iNfcChannel);
            this.container.add(nfcObject);
            LogUtil.log(this.TAG, str2 + " successfully current container size:" + this.container.size());
        } else {
            LogUtil.loge(this.TAG, str2 + " overflow, current container size:" + this.container.size());
        }
        LogUtil.log(this.TAG, str2 + "  end ");
    }

    public NfcObject pull(String str, int i, int i2) {
        NfcObject nfcObject;
        String str2 = " pull ";
        LogUtil.log(this.TAG, str2 + str + ",container.size()=" + this.container.size());
        if (this.container == null || this.container.size() <= 0) {
            LogUtil.log(this.TAG, str2 + " container is null or size is 0");
            nfcObject = null;
        } else {
            for (NfcObject nfcObject2 : this.container) {
                if (isExist(str, nfcObject2.getInstance_id()) && i == nfcObject2.getChannelType() && i2 == nfcObject2.getMediaType()) {
                    LogUtil.log(this.TAG, str2 + " successfully,instance_id= " + str);
                    break;
                }
            }
            nfcObject2 = null;
        }
        LogUtil.log(this.TAG, str2 + " end ");
        return nfcObject2;
    }

    public void remove(String str, int i, int i2) {
        String str2 = " remove ";
        LogUtil.log(this.TAG, str2 + str);
        NfcObject nfcObject = null;
        if (this.container != null && this.container.size() > 0) {
            for (NfcObject nfcObject2 : this.container) {
                if (isExist(str, nfcObject2.getInstance_id()) && i == nfcObject2.getChannelType() && i2 == nfcObject2.getMediaType()) {
                    LogUtil.log(this.TAG, " find " + str2 + str);
                    nfcObject = nfcObject2;
                    break;
                }
            }
            if (nfcObject != null) {
                try {
                    nfcObject.getNfcChannel().closeChannel();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.container.remove(nfcObject);
            } else {
                LogUtil.loge(this.TAG, " don't find " + str2 + str);
            }
        }
        LogUtil.log(this.TAG, str2 + " end ");
    }

    public void removeAll() {
        if (this.container != null && this.container.size() > 0) {
            for (NfcObject nfcChannel : this.container) {
                try {
                    nfcChannel.getNfcChannel().closeChannel();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        this.container.clear();
        LogUtil.log(this.TAG, " removeAll ");
    }

    public List<NfcObject> list() {
        return this.container;
    }
}
