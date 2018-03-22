package com.google.android.gms.internal;

import java.io.IOException;

public class ep extends IOException {
    public ep(String str) {
        super(str);
    }

    static ep m1433a() {
        return new ep("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }

    static ep m1434b() {
        return new ep("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static ep m1435c() {
        return new ep("CodedInputStream encountered a malformed varint.");
    }

    static ep m1436d() {
        return new ep("Protocol message contained an invalid tag (zero).");
    }

    static ep m1437e() {
        return new ep("Protocol message end-group tag did not match expected tag.");
    }

    static ep m1438f() {
        return new ep("Protocol message tag had invalid wire type.");
    }

    static ep m1439g() {
        return new ep("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }
}
