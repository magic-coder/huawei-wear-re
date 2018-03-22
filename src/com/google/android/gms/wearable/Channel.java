package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Parcelable;
import com.google.android.gms.common.api.C0378p;
import com.google.android.gms.common.api.C0382t;
import com.google.android.gms.common.api.Status;

public interface Channel extends Parcelable {
    C0382t<Status> addListener(C0378p c0378p, C0521h c0521h);

    C0382t<Status> close(C0378p c0378p);

    C0382t<Status> close(C0378p c0378p, int i);

    C0382t<C0527e> getInputStream(C0378p c0378p);

    String getNodeId();

    C0382t<C0528f> getOutputStream(C0378p c0378p);

    String getPath();

    C0382t<Status> receiveFile(C0378p c0378p, Uri uri, boolean z);

    C0382t<Status> removeListener(C0378p c0378p, C0521h c0521h);

    C0382t<Status> sendFile(C0378p c0378p, Uri uri);

    C0382t<Status> sendFile(C0378p c0378p, Uri uri, long j, long j2);
}
