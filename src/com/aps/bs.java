package com.aps;

import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

/* compiled from: StrictLineReader */
class bs extends ByteArrayOutputStream {
    final /* synthetic */ br f13068a;

    bs(br brVar, int i) {
        this.f13068a = brVar;
        super(i);
    }

    public String toString() {
        int i = (this.count <= 0 || this.buf[this.count - 1] != TagName.PAY_CHANNEL) ? this.count : this.count - 1;
        try {
            return new String(this.buf, 0, i, this.f13068a.f13064b.name());
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }
}
