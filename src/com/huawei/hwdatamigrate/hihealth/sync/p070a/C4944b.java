package com.huawei.hwdatamigrate.hihealth.sync.p070a;

import com.huawei.hwcloudmodel.model.CloudCommonReponse;
import com.huawei.hwdatamigrate.hihealth.sync.a.h;

/* compiled from: DefaultErrorHandling */
public class C4944b implements C4942d {
    public void mo4575a(CloudCommonReponse cloudCommonReponse) throws h {
        throw new h(C4946e.m23813a(cloudCommonReponse.getResultCode()) + cloudCommonReponse.getResultDesc());
    }
}
