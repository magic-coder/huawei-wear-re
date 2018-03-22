package com.huawei.nfc.carrera.server.card.response;

import java.util.ArrayList;
import java.util.List;

public class QueryIssuerInfoResponse extends CardServerBaseResponse {
    public List<IssuerInfoServerItem> issueInfos = new ArrayList();
}
