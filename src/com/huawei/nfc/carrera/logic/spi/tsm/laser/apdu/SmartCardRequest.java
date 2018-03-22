package com.huawei.nfc.carrera.logic.spi.tsm.laser.apdu;

import com.huawei.p190v.C2538c;
import com.leisen.wallet.sdk.oma.SmartCardBean;
import com.leisen.wallet.sdk.util.DataConvertUtil;
import java.io.IOException;
import org.simalliance.openmobileapi.C6649a;
import org.simalliance.openmobileapi.C6650b;
import org.simalliance.openmobileapi.C6651c;
import org.simalliance.openmobileapi.C6656g;

class SmartCardRequest implements Runnable {
    private static final String BOUNDARY = "==>";
    private static final String TAG = "SmartCardRequest";
    private final Object lock = new Object();
    private SmartCardCallback mCallback;
    private C6649a mChannel;
    private int mFlag = -1;
    private C6651c mSEService;
    private C6656g mSession;
    private SmartCardBean mSmartCardBean;

    protected SmartCardRequest(C6651c c6651c, SmartCardBean smartCardBean) {
        this.mSEService = c6651c;
        if (smartCardBean != null) {
            this.mSmartCardBean = smartCardBean;
        }
    }

    public void setSmartCartBean(SmartCardBean smartCardBean) {
        this.mSmartCardBean = smartCardBean;
    }

    public void setSmartCardCallback(SmartCardCallback smartCardCallback) {
        this.mCallback = smartCardCallback;
    }

    public void setFlag(int i) {
        this.mFlag = i;
    }

    public void run() {
        synchronized (this.lock) {
            if (openCurrentAvailableChannel()) {
                try {
                    executeApduCmd();
                } catch (IOException e) {
                    closeChannelAndSession();
                    operFailure(this.mFlag, "execute apdu error：" + e.getMessage());
                }
                return;
            }
        }
    }

    private void executeApduCmd() throws IOException {
        String command = this.mSmartCardBean.getCommand();
        if (command == null || "".equals(command)) {
            String bytesToHexString = DataConvertUtil.bytesToHexString(this.mChannel.m29942c());
            C2538c.c(TAG, new Object[]{"==>chose AID  result is：" + bytesToHexString});
            operSuccess(this.mFlag, bytesToHexString);
        }
        byte[] hexStringToBytes = DataConvertUtil.hexStringToBytes(command);
        if (this.mChannel != null) {
            bytesToHexString = DataConvertUtil.bytesToHexString(this.mChannel.m29940a(hexStringToBytes));
            C2538c.c(TAG, new Object[]{"==> execute APDU:" + command + "，return RAPDU is：" + bytesToHexString});
            operSuccess(this.mFlag, bytesToHexString);
        }
    }

    private boolean openCurrentAvailableChannel() {
        if (this.mChannel == null) {
            C6650b currentAvailableReader = getCurrentAvailableReader();
            if (currentAvailableReader == null) {
                operFailure(this.mFlag, "choose reader not exist");
                return false;
            } else if (currentAvailableReader.m29945c()) {
                try {
                    this.mSession = currentAvailableReader.m29944b();
                    byte[] hexStringToBytes = DataConvertUtil.hexStringToBytes(this.mSmartCardBean.getAid());
                    C2538c.c(TAG, new Object[]{"==>open channel Aid：" + this.mSmartCardBean.getAid()});
                    try {
                        if (this.mSession != null) {
                            this.mChannel = this.mSession.m29961a(hexStringToBytes);
                        }
                    } catch (IOException e) {
                        closeChannelAndSession();
                        operFailure(this.mFlag, "open channel error：" + e.getMessage());
                        return false;
                    } catch (SecurityException e2) {
                        closeChannelAndSession();
                        operFailure(this.mFlag, "open channel error：" + e2.getMessage());
                        return false;
                    } catch (Exception e3) {
                        closeChannelAndSession();
                        operFailure(this.mFlag, "open channel error：" + e3.getMessage());
                        return false;
                    }
                } catch (IOException e4) {
                    closeChannelAndSession();
                    operFailure(this.mFlag, "open session error：" + e4.getMessage());
                    return false;
                }
            } else {
                operFailure(this.mFlag, "choose reader can not use");
                return false;
            }
        }
        return true;
    }

    private C6650b getCurrentAvailableReader() {
        C6650b[] b = this.mSEService.m29953b();
        if (b == null || b.length < 1) {
            operFailure(this.mFlag, "your devices not support any reader");
            return null;
        }
        String readerName = this.mSmartCardBean.getReaderName();
        if (readerName == null) {
            return null;
        }
        for (C6650b c6650b : b) {
            C2538c.e(TAG, new Object[]{"==>reader name:" + c6650b.m29943a()});
            if (c6650b.m29943a().startsWith(readerName)) {
                return c6650b;
            }
        }
        return null;
    }

    public void closeChannelAndSession() {
        try {
            if (!(this.mChannel == null || this.mChannel.m29941b())) {
                this.mChannel.m29939a();
                this.mChannel = null;
                C2538c.c(TAG, new Object[]{"==>Channel close success"});
            }
        } catch (Exception e) {
            C2538c.e(TAG, new Object[]{"==>Channel close fail" + e.getMessage()});
        }
        try {
            if (this.mSession != null && !this.mSession.m29965c()) {
                this.mSession.m29964b();
                this.mSession = null;
                C2538c.c(TAG, new Object[]{"==>Session close success"});
            }
        } catch (Exception e2) {
            C2538c.e(TAG, new Object[]{"==>Session close fail" + e2.getMessage()});
        }
    }

    private void operSuccess(int i, String str) {
        if (this.mCallback != null) {
            this.mCallback.onOperSuccess(i, str);
        }
    }

    private void operFailure(int i, String str) {
        C2538c.e(TAG, new Object[]{BOUNDARY + str});
        if (this.mCallback != null) {
            this.mCallback.onOperFailure(i, str);
        }
    }
}
