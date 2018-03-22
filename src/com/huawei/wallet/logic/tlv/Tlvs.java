package com.huawei.wallet.logic.tlv;

import java.util.List;

public class Tlvs {
    private final List<Tlv> f21302a;

    protected Tlvs(List<Tlv> list) {
        this.f21302a = list;
    }

    public Tlv m28101a(TlvTag tlvTag) {
        for (Tlv a : this.f21302a) {
            Tlv a2 = a2.m28074a(tlvTag);
            if (a2 != null) {
                return a2;
            }
        }
        return null;
    }
}
