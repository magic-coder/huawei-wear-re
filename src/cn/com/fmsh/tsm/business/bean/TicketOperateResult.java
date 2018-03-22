package cn.com.fmsh.tsm.business.bean;

public class TicketOperateResult {
    private /* synthetic */ byte[] f9674a;
    private /* synthetic */ int f9675b;

    public int getOperateResult() {
        return this.f9675b;
    }

    public byte[] getTicketStub() {
        return this.f9674a;
    }

    public void setOperateResult(int i) {
        this.f9675b = i;
    }

    public void setTicketStub(byte[] bArr) {
        this.f9674a = bArr;
    }
}
