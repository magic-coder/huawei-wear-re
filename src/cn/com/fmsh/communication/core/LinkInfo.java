package cn.com.fmsh.communication.core;

public class LinkInfo {
    private /* synthetic */ String f9334a;
    private /* synthetic */ int f9335b;
    private /* synthetic */ int f9336c = -1;

    public enum LinkType {
        TCP,
        UDP,
        HTTP
    }

    public String getAddress() {
        return this.f9334a;
    }

    public int getPort() {
        return this.f9335b;
    }

    public int getTimeout() {
        return this.f9336c;
    }

    public void setAddress(String str) {
        this.f9334a = str;
    }

    public void setPort(int i) {
        this.f9335b = i;
    }

    public void setTimeout(int i) {
        this.f9336c = i;
    }
}
