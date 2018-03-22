package cn.com.fmsh.tsm.business.bean;

import cn.com.fmsh.communication.message.ITag;
import cn.com.fmsh.communication.message.exception.FMCommunicationMessageException;
import cn.com.fmsh.tsm.business.enums.EnumBackInfoType;
import cn.com.fmsh.util.FM_CN;
import cn.com.fmsh.util.FM_Long;
import cn.com.fmsh.util.log.FMLog;
import cn.com.fmsh.util.log.LogFactory;

public class TerminalBackInfo {
    private /* synthetic */ byte[] f9663a;
    private /* synthetic */ byte[] f9664b;
    private /* synthetic */ int f9665c;
    private /* synthetic */ String f9666d;
    private /* synthetic */ String f9667e;
    private /* synthetic */ String f9668f = null;
    private /* synthetic */ EnumBackInfoType f9669g = null;
    private /* synthetic */ String f9670h;
    private /* synthetic */ String f9671i;
    private /* synthetic */ String f9672j;
    private /* synthetic */ String f9673k = null;

    public static TerminalBackInfo fromTag(ITag iTag) throws FMCommunicationMessageException {
        TerminalBackInfo terminalBackInfo = null;
        FMLog log = LogFactory.getInstance().getLog();
        if (iTag != null) {
            ITag[] itemTags = iTag.getItemTags();
            if (itemTags != null && itemTags.length >= 1) {
                terminalBackInfo = new TerminalBackInfo();
                for (ITag iTag2 : itemTags) {
                    switch (iTag2.getId()) {
                        case (byte) 19:
                            terminalBackInfo.setDate(iTag2.getStringVal());
                            break;
                        case (byte) 20:
                            terminalBackInfo.setTime(iTag2.getStringVal());
                            break;
                        case (byte) 65:
                            terminalBackInfo.setTitle(iTag2.getStringVal());
                            break;
                        case (byte) 67:
                            terminalBackInfo.setInfoType(EnumBackInfoType.instance(iTag2.getIntVal()));
                            break;
                        case (byte) 81:
                            terminalBackInfo.setId(iTag2.getBytesVal());
                            break;
                        case (byte) 82:
                            terminalBackInfo.setQuestionFlag(iTag2.getIntVal());
                            break;
                        case (byte) 85:
                            terminalBackInfo.setChildren(iTag2.getBytesVal());
                            break;
                        default:
                            break;
                    }
                }
            } else if (log != null) {
                log.warn(BusinessOrder.class.getName(), FM_Long.copyValueOf(",轥捤Wa:宣谶剤厜駆侪性斳ｎ\u000b=>宯谲乪稷", 4));
            }
        } else if (log != null) {
            log.warn(BusinessOrder.class.getName(), FM_CN.equals("w輤挻\u001ezk寤豯副厝駉侳怬既）Bf?宰谻乱穦", 4));
        }
        return terminalBackInfo;
    }

    public String getAppVersion() {
        return this.f9673k;
    }

    public String getBasebandVersion() {
        return this.f9672j;
    }

    public byte[] getChildren() {
        return this.f9664b;
    }

    public String getDate() {
        return this.f9666d;
    }

    public byte[] getId() {
        return this.f9663a;
    }

    public EnumBackInfoType getInfoType() {
        return this.f9669g;
    }

    public String getModelNumber() {
        return this.f9671i;
    }

    public String getOsVersion() {
        return this.f9670h;
    }

    public int getQuestionFlag() {
        return this.f9665c;
    }

    public String getTime() {
        return this.f9667e;
    }

    public String getTitle() {
        return this.f9668f;
    }

    public void setAppVersion(String str) {
        this.f9673k = str;
    }

    public void setBasebandVersion(String str) {
        this.f9672j = str;
    }

    public void setChildren(byte[] bArr) {
        this.f9664b = bArr;
    }

    public void setDate(String str) {
        this.f9666d = str;
    }

    public void setId(byte[] bArr) {
        this.f9663a = bArr;
    }

    public void setInfoType(EnumBackInfoType enumBackInfoType) {
        this.f9669g = enumBackInfoType;
    }

    public void setModelNumber(String str) {
        this.f9671i = str;
    }

    public void setOsVersion(String str) {
        this.f9670h = str;
    }

    public void setQuestionFlag(int i) {
        this.f9665c = i;
    }

    public void setTime(String str) {
        this.f9667e = str;
    }

    public void setTitle(String str) {
        this.f9668f = str;
    }
}
