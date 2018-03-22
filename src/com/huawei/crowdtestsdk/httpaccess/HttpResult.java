package com.huawei.crowdtestsdk.httpaccess;

public class HttpResult {
    public String content = "";
    public int statusCode;

    public boolean isRedirect() {
        return this.statusCode == HttpStatus.SC_MOVED_TEMPORARILY || this.statusCode == 301 || this.statusCode == HttpStatus.SC_SEE_OTHER || this.statusCode == 307;
    }

    public String toString() {
        return this.statusCode + "\t" + this.content;
    }

    public boolean isForbit() {
        return this.statusCode == HttpStatus.SC_FORBIDDEN;
    }

    public boolean isResponseOK() {
        return this.statusCode == 200;
    }

    public boolean isInternalError() {
        return this.statusCode >= 500;
    }
}
