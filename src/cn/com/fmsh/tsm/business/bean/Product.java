package cn.com.fmsh.tsm.business.bean;

import cn.com.fmsh.communication.message.ITag;
import cn.com.fmsh.communication.message.exception.FMCommunicationMessageException;
import com.huawei.crowdtestsdk.constants.SdkConstants;
import com.huawei.crowdtestsdk.report.ReportInfoUtils;

public class Product {
    private /* synthetic */ String f9652a;
    private /* synthetic */ int f9653b;
    private /* synthetic */ String f9654c;
    private /* synthetic */ String f9655d;
    private /* synthetic */ String f9656e;

    public static Product fromTag(ITag iTag) throws FMCommunicationMessageException {
        Product product = null;
        if (iTag != null) {
            ITag[] itemTags = iTag.getItemTags();
            if (itemTags != null && itemTags.length >= 1) {
                product = new Product();
                for (ITag iTag2 : itemTags) {
                    switch (iTag2.getId()) {
                        case SdkConstants.STAT_LOGIN_FAIL_OTHER_REASON /*-103*/:
                            product.f9654c = iTag2.getStringVal();
                            break;
                        case SdkConstants.STAT_LOGIN_FAIL_PASSWD_EXPIRED /*-102*/:
                            product.f9655d = iTag2.getStringVal();
                            break;
                        case (byte) -101:
                            product.f9656e = iTag2.getStringVal();
                            break;
                        case (byte) 103:
                            product.f9652a = iTag2.getStringVal();
                            break;
                        case ReportInfoUtils.FEEDBACK_FAILED /*124*/:
                            product.f9653b = iTag2.getIntVal();
                            break;
                        default:
                            break;
                    }
                }
            }
        }
        return product;
    }

    public String getCity() {
        return this.f9656e;
    }

    public String getCode() {
        return this.f9654c;
    }

    public String getId() {
        return this.f9652a;
    }

    public String getName() {
        return this.f9655d;
    }

    public int getPrice() {
        return this.f9653b;
    }

    public void setCity(String str) {
        this.f9656e = str;
    }

    public void setCode(String str) {
        this.f9654c = str;
    }

    public void setId(String str) {
        this.f9652a = str;
    }

    public void setName(String str) {
        this.f9655d = str;
    }

    public void setPrice(int i) {
        this.f9653b = i;
    }
}
