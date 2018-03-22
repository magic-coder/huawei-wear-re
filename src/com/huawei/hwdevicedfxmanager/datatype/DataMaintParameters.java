package com.huawei.hwdevicedfxmanager.datatype;

import com.huawei.hwcommonmodel.p064d.C0978h;

public class DataMaintParameters {
    private String file_protocal_version;
    private int max_apply_data_size;
    private int timeout;
    private boolean transfer_bitmap_enable;
    private int transfer_unit_size;

    public int getTransfer_unit_size() {
        return ((Integer) C0978h.a(Integer.valueOf(this.transfer_unit_size))).intValue();
    }

    public void setTransfer_unit_size(int i) {
        this.transfer_unit_size = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public boolean getTransfer_bitmap_enable() {
        return ((Boolean) C0978h.a(Boolean.valueOf(this.transfer_bitmap_enable))).booleanValue();
    }

    public void setTransfer_bitmap_enable(boolean z) {
        this.transfer_bitmap_enable = ((Boolean) C0978h.a(Boolean.valueOf(z))).booleanValue();
    }

    public int getMax_apply_data_size() {
        return ((Integer) C0978h.a(Integer.valueOf(this.max_apply_data_size))).intValue();
    }

    public void setMax_apply_data_size(int i) {
        this.max_apply_data_size = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getTimeout() {
        return ((Integer) C0978h.a(Integer.valueOf(this.timeout))).intValue();
    }

    public void setTimeout(int i) {
        this.timeout = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public String getFile_protocal_version() {
        return (String) C0978h.a(this.file_protocal_version);
    }

    public void setFile_protocal_version(String str) {
        this.file_protocal_version = (String) C0978h.a(str);
    }
}
