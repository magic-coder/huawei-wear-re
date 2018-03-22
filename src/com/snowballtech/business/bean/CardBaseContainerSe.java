package com.snowballtech.business.bean;

import java.util.List;

public class CardBaseContainerSe {
    private static final long serialVersionUID = 1;
    private List<CardBaseSe> card_list;

    public List<CardBaseSe> getCard_list() {
        return this.card_list;
    }

    public void setCard_list(List<CardBaseSe> list) {
        this.card_list = list;
    }
}
