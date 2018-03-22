package com.huawei.openalliance.ad.p112a.p113a.p115b;

import com.huawei.openalliance.ad.p112a.p113a.p114a.C1213c;
import java.util.List;

public class C1221g extends C1213c {
    private List<String> clickmonitorurl__;
    private String contentid__;
    private int creativetype__ = 1;
    private long endtime__;
    private int height__;
    private String html__;
    private List<String> impmonitorurl__;
    private C1225k interactionparam__;
    private int interactiontype__ = 0;
    private String md5__;
    private C1227m metaData__;
    private C1229o paramfromserver__;
    private String sha256__;
    private int showAppLogoFlag__ = 1;
    private String showid__ = "";
    private String skipText__;
    private long starttime__;
    private String taskid__;
    private int width__;

    public C1221g(C1230p c1230p) {
        this.contentid__ = c1230p.getContentid__();
        this.html__ = c1230p.getHtml__();
        this.creativetype__ = c1230p.getCreativetype__();
        this.md5__ = c1230p.getMd5__();
        this.sha256__ = c1230p.getSha256__();
    }

    public List<String> getClickmonitorurl__() {
        return this.clickmonitorurl__;
    }

    public String getContentid__() {
        return this.contentid__;
    }

    public int getCreativetype__() {
        return this.creativetype__;
    }

    public long getEndtime__() {
        return this.endtime__;
    }

    public int getHeight__() {
        return this.height__;
    }

    public String getHtml__() {
        return this.html__;
    }

    public List<String> getImpmonitorurl__() {
        return this.impmonitorurl__;
    }

    public C1225k getInteractionparam__() {
        return this.interactionparam__;
    }

    public int getInteractiontype__() {
        return this.interactiontype__;
    }

    public String getMd5__() {
        return this.md5__;
    }

    public C1227m getMetaData__() {
        return this.metaData__;
    }

    public C1229o getParamfromserver__() {
        return this.paramfromserver__;
    }

    public String getSha256__() {
        return this.sha256__;
    }

    public int getShowAppLogoFlag__() {
        return this.showAppLogoFlag__;
    }

    public String getShowid__() {
        return this.showid__;
    }

    public String getSkipText__() {
        return this.skipText__;
    }

    public long getStarttime__() {
        return this.starttime__;
    }

    public String getTaskid__() {
        return this.taskid__;
    }

    public int getWidth__() {
        return this.width__;
    }

    public void setClickmonitorurl__(List<String> list) {
        this.clickmonitorurl__ = list;
    }

    public void setContentid__(String str) {
        this.contentid__ = str;
    }

    public void setCreativetype__(int i) {
        this.creativetype__ = i;
    }

    public void setEndtime__(long j) {
        this.endtime__ = j;
    }

    public void setHeight__(int i) {
        this.height__ = i;
    }

    public void setHtml__(String str) {
        this.html__ = str;
    }

    public void setImpmonitorurl__(List<String> list) {
        this.impmonitorurl__ = list;
    }

    public void setInteractionparam__(C1225k c1225k) {
        this.interactionparam__ = c1225k;
    }

    public void setInteractiontype__(int i) {
        this.interactiontype__ = i;
    }

    public void setMd5__(String str) {
        this.md5__ = str;
    }

    public void setMetaData__(C1227m c1227m) {
        this.metaData__ = c1227m;
    }

    public void setParamfromserver__(C1229o c1229o) {
        this.paramfromserver__ = c1229o;
    }

    public void setSha256__(String str) {
        this.sha256__ = str;
    }

    public void setShowAppLogoFlag__(int i) {
        this.showAppLogoFlag__ = i;
    }

    public void setShowid__(String str) {
        this.showid__ = str;
    }

    public void setSkipText__(String str) {
        this.skipText__ = str;
    }

    public void setStarttime__(long j) {
        this.starttime__ = j;
    }

    public void setTaskid__(String str) {
        this.taskid__ = str;
    }

    public void setWidth__(int i) {
        this.width__ = i;
    }
}
