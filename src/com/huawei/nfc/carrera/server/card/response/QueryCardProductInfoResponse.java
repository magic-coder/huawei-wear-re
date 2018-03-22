package com.huawei.nfc.carrera.server.card.response;

import java.util.ArrayList;
import java.util.List;

public class QueryCardProductInfoResponse extends CardServerBaseResponse {
    public List<CardProductInfoServerItem> items = new ArrayList();
}
