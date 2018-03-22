package com.huawei.hwcommonmodel.datatypes;

import com.huawei.hwcommonmodel.p064d.C0978h;

import java.util.List;

public class HWOTAParameter {
    private String OTA_protocol_version;
    private boolean breakPoint_enable;
    private List<C4745l> moduleStructList;
    private int module_number;
    private int packet_send_size;
    private int packets_send_num;
    private int timeout;
    private int transport_type;
    private int update_type;

    public String getOTA_protocol_version() {
        return (String) C0978h.a(this.OTA_protocol_version);
    }

    public void setOTA_protocol_version(String str) {
        this.OTA_protocol_version = (String) C0978h.a(str);
    }

    public int getUpdate_type() {
        return ((Integer) C0978h.a(Integer.valueOf(this.update_type))).intValue();
    }

    public void setUpdate_type(int i) {
        this.update_type = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getTransport_type() {
        return ((Integer) C0978h.a(Integer.valueOf(this.transport_type))).intValue();
    }

    public void setTransport_type(int i) {
        this.transport_type = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public boolean isBreakPoint_enable() {
        return ((Boolean) C0978h.a(Boolean.valueOf(this.breakPoint_enable))).booleanValue();
    }

    public void setBreakPoint_enable(boolean z) {
        this.breakPoint_enable = ((Boolean) C0978h.a(Boolean.valueOf(z))).booleanValue();
    }

    public int getPackets_send_num() {
        return ((Integer) C0978h.a(Integer.valueOf(this.packets_send_num))).intValue();
    }

    public void setPackets_send_num(int i) {
        this.packets_send_num = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getPacket_send_size() {
        return ((Integer) C0978h.a(Integer.valueOf(this.packet_send_size))).intValue();
    }

    public void setPacket_send_size(int i) {
        this.packet_send_size = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getTimeout() {
        return ((Integer) C0978h.a(Integer.valueOf(this.timeout))).intValue();
    }

    public void setTimeout(int i) {
        this.timeout = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getModule_number() {
        return ((Integer) C0978h.a(Integer.valueOf(this.module_number))).intValue();
    }

    public void setModule_number(int i) {
        this.module_number = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public List<C4745l> getModuleStructs() {
        return (List) C0978h.a(this.moduleStructList);
    }

    public void setModuleStructs(List<C4745l> list) {
        this.moduleStructList = (List) C0978h.a(list);
    }

    public void initHWOTAParameter1() {
    }

    public void initHWOTAParameter2() {
    }

    public void initHWOTAParameter3() {
    }

    public void initHWOTAParameter4() {
    }

    public void initHWOTAParameter5() {
    }

    public void initHWOTAParameter6() {
    }

    public void initHWOTAParameter7() {
    }

    public void initHWOTAParameter8() {
    }

    public void initHWOTAParameter9() {
    }

    public void initHWOTAParameter10() {
    }
}
