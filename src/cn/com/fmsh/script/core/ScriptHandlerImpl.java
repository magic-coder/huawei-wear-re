package cn.com.fmsh.script.core;

import cn.com.fmsh.FM_Exception;
import cn.com.fmsh.script.ApduFilterDataInit;
import cn.com.fmsh.script.ApduHandler;
import cn.com.fmsh.script.ApduHandler.ApduHandlerType;
import cn.com.fmsh.script.ScriptHandler;
import cn.com.fmsh.script.bean.ApduReponseList;
import cn.com.fmsh.script.bean.ApduRequest;
import cn.com.fmsh.script.bean.ApduRequestList;
import cn.com.fmsh.script.bean.ApduResponse;
import cn.com.fmsh.script.constants.ScriptToolsConst;
import cn.com.fmsh.script.exception.FMScriptHandleException;
import cn.com.fmsh.script.exception.FMScriptHandleException.ScriptHandleExceptionType;
import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import cn.com.fmsh.util.CRCUtil;
import cn.com.fmsh.util.FM_Bytes;
import cn.com.fmsh.util.FM_Int;
import cn.com.fmsh.util.FM_Long;
import cn.com.fmsh.util.Util4Java;
import cn.com.fmsh.util.log.FMLog;
import cn.com.fmsh.util.log.LogFactory;
import com.huawei.crowdtestsdk.common.SpecialIssueType;
import java.util.Arrays;

public class ScriptHandlerImpl implements ScriptHandler {
    private /* synthetic */ FMLog f9513a = LogFactory.getInstance().getLog();
    private /* synthetic */ String f9514b = ScriptHandlerImpl.class.getName();
    private /* synthetic */ ApduHandler f9515c;
    private /* synthetic */ ApduFilter f9516d;
    private /* synthetic */ boolean f9517e;

    public ScriptHandlerImpl(ApduHandler apduHandler) {
        this.f9515c = apduHandler;
        this.f9516d = new ApduFilter();
    }

    public void cancel() {
        setStop(true);
    }

    public ApduReponseList execute(ApduRequestList apduRequestList) throws FMScriptHandleException {
        if (this.f9513a == null) {
            this.f9513a = LogFactory.getInstance().getLog();
        }
        this.f9517e = false;
        if (apduRequestList == null) {
            return null;
        }
        ApduReponseList apduReponseList = new ApduReponseList();
        ApduRequest firstApduRequest = apduRequestList.getFirstApduRequest();
        if (firstApduRequest == null) {
            if (this.f9513a != null) {
                this.f9513a.error(this.f9514b, FM_Exception.insert(1, 74, "够朮挞产扪蠛斷＇菢叉筥专朼捀仵奪贠"));
            }
            new FMScriptHandleException(FM_Long.copyValueOf("外杨持仧执蠑斬｛菣厇筢之朩捂亦奮赹", 4)).setType(ScriptHandleExceptionType.INVALID_FIRST_ID);
            return null;
        }
        FMScriptHandleException fMScriptHandleException;
        ApduRequest apduRequest = null;
        while (!isStop()) {
            byte[] apdu = firstApduRequest.getApdu();
            if (this.f9515c.getApduHandlerType() == ApduHandlerType.OPEN_MOBILE) {
                byte[] filter = this.f9516d.filter(apdu);
                if (filter == null) {
                    apdu = this.f9515c.transceive(apdu);
                } else if (this.f9515c.open(filter)) {
                    apdu = new byte[2];
                    apdu[0] = TagName.SYSTEM_VERSION;
                } else {
                    apdu = new byte[]{TagName.MAIN_ORDER_ID, TagName.ACTIVITY_END};
                }
            } else {
                apdu = this.f9515c.transceive(apdu);
            }
            ApduResponse apduResponse = new ApduResponse();
            apduResponse.setId(firstApduRequest.getId());
            apduResponse.setApdu(firstApduRequest.getApdu());
            if (apdu == null || apdu.length < 2) {
                apduResponse.setResult(new byte[]{(byte) 1});
                apduReponseList.add(apduResponse);
                if (this.f9513a != null) {
                    this.f9513a.warn(this.f9514b, new StringBuilder(CRCUtil.substring(5, "夈杼挏价批蠅斢ｓ\u0011")).append(firstApduRequest.getId()).append(FM_Bytes.concat("\u0001挆仢扬衜夤贿", 5, 5)).toString());
                }
            } else {
                apduResponse.setResult(apdu);
                apduReponseList.add(apduResponse);
                apdu = Arrays.copyOfRange(apdu, apdu.length - 2, apdu.length);
                if (firstApduRequest.getTag() == ScriptToolsConst.TagName.CommandSingle) {
                    if (firstApduRequest.getNext4Expectation(new byte[]{(byte) -1, (byte) -1}) != -1) {
                        apduRequest = apduRequestList.getApduRequest(firstApduRequest.getId() + 1);
                    } else if (firstApduRequest.getNext4Expectation(apdu) != -1) {
                        apduRequest = apduRequestList.getApduRequest(firstApduRequest.getId() + 1);
                    } else if (this.f9513a != null) {
                        this.f9513a.error(this.f9514b, new StringBuilder(FM_Long.copyValueOf("外杨持仧执蠑斬｛\u000f", 4)).append(firstApduRequest.getId()).append(Util4Java.endsWith("]挓京哑廄砅C", 3, 52)).append(FM_Bytes.bytesToHexString(apdu)).append(FM_Bytes.concat("\u0004乏杖朊倥丌筯", 2, 104)).toString());
                    }
                } else if (firstApduRequest.getTag() == ScriptToolsConst.TagName.CommandMultiple) {
                    int next4Expectation;
                    if (firstApduRequest.isHaveExpectation()) {
                        next4Expectation = firstApduRequest.getNext4Expectation(apdu);
                        if (next4Expectation == -1) {
                            next4Expectation = firstApduRequest.getNext4Expectation(new byte[]{(byte) -1, (byte) -1});
                        }
                        if (next4Expectation == 0) {
                            next4Expectation = firstApduRequest.getId() + 1;
                        } else if (next4Expectation == 255) {
                        }
                    } else {
                        next4Expectation = firstApduRequest.getId() + 1;
                    }
                    apduRequest = apduRequestList.getApduRequest(next4Expectation);
                }
                if (apduRequest != null) {
                    if (apduRequest.getId() <= firstApduRequest.getId()) {
                        fMScriptHandleException = new FMScriptHandleException(Util4Java.endsWith("奋末挄亸戲衂旱ｌ徜挕亯盀世朷捈们皅罌古丁奢亐朻朱捎仦盟桓诋＊戸衔夠赯", SpecialIssueType.BUG_TYPE_ID_CHARGE, 89));
                        fMScriptHandleException.setType(ScriptHandleExceptionType.INVALID_NEXT);
                        throw fMScriptHandleException;
                    }
                    firstApduRequest = apduRequest;
                }
            }
            return apduReponseList;
        }
        fMScriptHandleException = new FMScriptHandleException(FM_Int.replace(68, "夃杽挘亦戢蠄施b异则撚伆裶倜次"));
        fMScriptHandleException.setType(ScriptHandleExceptionType.STOPED);
        throw fMScriptHandleException;
    }

    public byte[] execute(byte[] bArr) throws FMScriptHandleException {
        return this.f9515c.transceive(bArr);
    }

    public synchronized boolean isStop() {
        return this.f9517e;
    }

    public void setApduFilterDataInit(ApduFilterDataInit apduFilterDataInit) {
        if (apduFilterDataInit != null) {
            for (FilterPolicy addFilterPolicy : apduFilterDataInit.getFilterPolicies()) {
                this.f9516d.addFilterPolicy(addFilterPolicy);
            }
        }
    }

    public void setApduHandler(ApduHandler apduHandler) {
        this.f9515c = apduHandler;
    }

    public synchronized void setStop(boolean z) {
        this.f9517e = z;
    }
}
