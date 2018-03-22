package cn.com.fmsh.tsm.business.bean;

import android.support.v4.media.TransportMediator;
import cn.com.fmsh.communication.message.ITag;
import cn.com.fmsh.communication.message.exception.FMCommunicationMessageException;
import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import cn.com.fmsh.util.BCCUtil;
import cn.com.fmsh.util.FM_CN;
import cn.com.fmsh.util.log.FMLog;
import cn.com.fmsh.util.log.LogFactory;
import com.huawei.crowdtestsdk.common.SpecialIssueType;
import com.huawei.crowdtestsdk.report.ReportInfoUtils;

public class ElectronicTakeUp {
    private /* synthetic */ byte[] f9581a;
    private /* synthetic */ byte[] f9582b;
    private /* synthetic */ String f9583c;
    private /* synthetic */ int f9584d;
    private /* synthetic */ int f9585e;
    private /* synthetic */ int f9586f;
    private /* synthetic */ int f9587g;
    private /* synthetic */ int f9588h;
    private /* synthetic */ int f9589i;
    private /* synthetic */ int f9590j;
    private /* synthetic */ int f9591k;
    private /* synthetic */ String f9592l;
    private /* synthetic */ int f9593m;
    private /* synthetic */ int f9594n;
    private /* synthetic */ byte[] f9595o;
    private /* synthetic */ String f9596p;
    private /* synthetic */ String f9597q;
    private /* synthetic */ String f9598r;
    private /* synthetic */ String f9599s;
    private /* synthetic */ int f9600t;
    private /* synthetic */ byte[] f9601u;
    private /* synthetic */ String f9602v;

    public static ElectronicTakeUp fromTag(ITag iTag) throws FMCommunicationMessageException {
        ElectronicTakeUp electronicTakeUp = null;
        FMLog log = LogFactory.getInstance().getLog();
        if (iTag != null) {
            ITag[] itemTags = iTag.getItemTags();
            if (itemTags != null && itemTags.length >= 1) {
                electronicTakeUp = new ElectronicTakeUp();
                for (ITag iTag2 : itemTags) {
                    switch (iTag2.getId()) {
                        case (byte) 17:
                            electronicTakeUp.setOrder(iTag2.getBytesVal());
                            break;
                        case (byte) 18:
                            electronicTakeUp.setOrderElseThing(iTag2.getStringVal());
                            break;
                        case (byte) 21:
                            electronicTakeUp.setTradeState((byte) iTag2.getIntVal());
                            break;
                        case (byte) 109:
                            electronicTakeUp.setPublishEndTime(iTag2.getStringVal());
                            break;
                        case (byte) 110:
                            electronicTakeUp.setStartTime(iTag2.getStringVal());
                            break;
                        case (byte) 111:
                            electronicTakeUp.setEndTime(iTag2.getStringVal());
                            break;
                        case (byte) 112:
                            electronicTakeUp.setId(iTag2.getBytesVal());
                            break;
                        case (byte) 113:
                            electronicTakeUp.setTypeId(iTag2.getBytesVal());
                            break;
                        case (byte) 114:
                            electronicTakeUp.setNumber(iTag2.getStringVal());
                            break;
                        case (byte) 115:
                            electronicTakeUp.setType(iTag2.getIntVal());
                            break;
                        case SpecialIssueType.BUG_TYPE_ID_CHARGE /*116*/:
                            electronicTakeUp.setUseType(iTag2.getIntVal());
                            break;
                        case (byte) 117:
                            electronicTakeUp.setTransferFlag(iTag2.getIntVal());
                            break;
                        case (byte) 118:
                            electronicTakeUp.setFrozenFlag(iTag2.getIntVal());
                            break;
                        case TagName.ELECTRONIC_USE_COUNT /*119*/:
                            electronicTakeUp.setUseCount(iTag2.getIntVal());
                            break;
                        case (byte) 120:
                            electronicTakeUp.setAppType(iTag2.getIntVal());
                            break;
                        case (byte) 121:
                            electronicTakeUp.setState(iTag2.getIntVal());
                            break;
                        case (byte) 122:
                            electronicTakeUp.setOutState(iTag2.getIntVal());
                            break;
                        case ReportInfoUtils.FEEDBACK_SUCCESS /*123*/:
                            electronicTakeUp.setUseTime(iTag2.getStringVal());
                            break;
                        case ReportInfoUtils.FEEDBACK_FAILED /*124*/:
                            electronicTakeUp.setPrice(iTag2.getIntVal());
                            break;
                        case (byte) 125:
                            electronicTakeUp.setPrice4favourable(iTag2.getIntVal());
                            break;
                        case TransportMediator.KEYCODE_MEDIA_PLAY /*126*/:
                            electronicTakeUp.setOutSerial(iTag2.getBytesVal());
                            break;
                        case Byte.MAX_VALUE:
                            electronicTakeUp.setPublishStartTime(iTag2.getStringVal());
                            break;
                        default:
                            break;
                    }
                }
            } else if (log != null) {
                log.warn(BusinessOrder.class.getName(), BCCUtil.getChars("x轩捰\u000bm~宿豲剰厀馒侦总旷ｂ\u000fi2寻豮书穳", 232, 45));
            }
        } else if (log != null) {
            log.warn(BusinessOrder.class.getName(), FM_CN.equals("輺挥\f(}寲豽刽畫嬟匷侰怭日（Ag0宱谸买穡", 3));
        }
        return electronicTakeUp;
    }

    public int getAppType() {
        return this.f9589i;
    }

    public String getEndTime() {
        return this.f9599s;
    }

    public int getFrozenFlag() {
        return this.f9587g;
    }

    public byte[] getId() {
        return this.f9581a;
    }

    public String getNumber() {
        return this.f9583c;
    }

    public byte[] getOrder() {
        return this.f9601u;
    }

    public String getOrderElseThing() {
        return this.f9602v;
    }

    public byte[] getOutSerial() {
        return this.f9595o;
    }

    public int getOutState() {
        return this.f9591k;
    }

    public int getPrice() {
        return this.f9593m;
    }

    public int getPrice4favourable() {
        return this.f9594n;
    }

    public String getPublishEndTime() {
        return this.f9597q;
    }

    public String getPublishStartTime() {
        return this.f9596p;
    }

    public String getStartTime() {
        return this.f9598r;
    }

    public int getState() {
        return this.f9590j;
    }

    public int getTradeState() {
        return this.f9600t;
    }

    public int getTransferFlag() {
        return this.f9586f;
    }

    public int getType() {
        return this.f9584d;
    }

    public byte[] getTypeId() {
        return this.f9582b;
    }

    public int getUseCount() {
        return this.f9588h;
    }

    public String getUseTime() {
        return this.f9592l;
    }

    public int getUseType() {
        return this.f9585e;
    }

    public void setAppType(int i) {
        this.f9589i = i;
    }

    public void setEndTime(String str) {
        this.f9599s = str;
    }

    public void setFrozenFlag(int i) {
        this.f9587g = i;
    }

    public void setId(byte[] bArr) {
        this.f9581a = bArr;
    }

    public void setNumber(String str) {
        this.f9583c = str;
    }

    public void setOrder(byte[] bArr) {
        this.f9601u = bArr;
    }

    public void setOrderElseThing(String str) {
        this.f9602v = str;
    }

    public void setOutSerial(byte[] bArr) {
        this.f9595o = bArr;
    }

    public void setOutState(int i) {
        this.f9591k = i;
    }

    public void setPrice(int i) {
        this.f9593m = i;
    }

    public void setPrice4favourable(int i) {
        this.f9594n = i;
    }

    public void setPublishEndTime(String str) {
        this.f9597q = str;
    }

    public void setPublishStartTime(String str) {
        this.f9596p = str;
    }

    public void setStartTime(String str) {
        this.f9598r = str;
    }

    public void setState(int i) {
        this.f9590j = i;
    }

    public void setTradeState(int i) {
        this.f9600t = i;
    }

    public void setTransferFlag(int i) {
        this.f9586f = i;
    }

    public void setType(int i) {
        this.f9584d = i;
    }

    public void setTypeId(byte[] bArr) {
        this.f9582b = bArr;
    }

    public void setUseCount(int i) {
        this.f9588h = i;
    }

    public void setUseTime(String str) {
        this.f9592l = str;
    }

    public void setUseType(int i) {
        this.f9585e = i;
    }
}
