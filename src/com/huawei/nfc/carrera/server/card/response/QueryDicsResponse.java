package com.huawei.nfc.carrera.server.card.response;

import com.huawei.aj.p315a.p317b.C4024a;
import java.util.ArrayList;

public class QueryDicsResponse extends C4024a {
    public ArrayList<DicItem> dicItems = new ArrayList();

    public ArrayList<DicItem> getDicItems() {
        return this.dicItems;
    }

    public void setDicItems(ArrayList<DicItem> arrayList) {
        this.dicItems = arrayList;
    }
}
