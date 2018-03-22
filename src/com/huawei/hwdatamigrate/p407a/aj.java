package com.huawei.hwdatamigrate.p407a;

/* compiled from: SleepDatasTable */
public class aj extends ah {
    public int f17410h;
    public String f17411i;
    public boolean f17412j;
    public String f17413k;
    public String f17414l;
    public int f17415m;
    StringBuilder f17416n = new StringBuilder();

    public String toString() {
        this.f17416n.append("SleepDatasTable [id=");
        this.f17416n.append(this.f17410h);
        this.f17416n.append(", curDate=");
        this.f17416n.append(this.f17413k);
        this.f17416n.append(", mac=");
        this.f17416n.append(this.f17414l);
        this.f17416n.append(", isUpload=");
        this.f17416n.append(this.f17412j);
        this.f17416n.append(", totalMinutes=");
        this.f17416n.append(this.b);
        this.f17416n.append(", deepMinutes=");
        this.f17416n.append(this.c);
        this.f17416n.append(", lightMinutes=");
        this.f17416n.append(this.d);
        this.f17416n.append(", awakeMinutes=");
        this.f17416n.append(this.e);
        this.f17416n.append(", sleepsDataDetail=");
        this.f17416n.append(this.f);
        this.f17416n.append(", sleeps=");
        this.f17416n.append(this.a);
        this.f17416n.append(", sleepsDataDetailInMin=");
        this.f17416n.append(this.g);
        this.f17416n.append("]");
        String stringBuilder = this.f17416n.toString();
        this.f17416n.delete(0, this.f17416n.length());
        return stringBuilder;
    }

    public String m22803a() {
        this.f17416n.append("SleepDatasTable [ID=");
        this.f17416n.append(this.f17410h);
        this.f17416n.append(", curDate=");
        this.f17416n.append(this.f17413k);
        this.f17416n.append(", mac=");
        this.f17416n.append(this.f17414l);
        this.f17416n.append(", isUpload=");
        this.f17416n.append(this.f17412j);
        this.f17416n.append(", sleepsDataDetail=");
        this.f17416n.append(this.f);
        this.f17416n.append(", sleepsDataDetailInMin=");
        this.f17416n.append(this.g);
        this.f17416n.append("]");
        String stringBuilder = this.f17416n.toString();
        this.f17416n.delete(0, this.f17416n.length());
        return stringBuilder;
    }
}
