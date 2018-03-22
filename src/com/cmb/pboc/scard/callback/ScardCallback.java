package com.cmb.pboc.scard.callback;

import android.os.Bundle;

public interface ScardCallback {
    void onError(StringBuilder stringBuilder);

    void onResponse(Bundle bundle);
}
