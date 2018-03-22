package com.cmb.pboc.scard;

import android.content.Context;
import android.os.Bundle;
import com.cmb.pboc.scard.callback.ScardCallback;
import java.util.Map;

public interface Scard {
    public static final int INITIAL = 0;
    public static final int OPENED = 4;
    public static final int OPENING = 1;
    public static final int OPEN_FAIL = 5;

    byte[] ExchangeApdu(byte[] bArr);

    byte[] GetResponse(int i);

    void closeCard();

    Map getDeviceInfo();

    int getOpenCardState();

    void init(Context context, ScardCallback scardCallback, Bundle bundle);

    boolean isClose();

    void openScard();
}
