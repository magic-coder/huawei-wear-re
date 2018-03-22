package com.huawei.hwdevicedfxmanager.datatype;

public class HWDeviceDFXStruct {
    private String file_protocal_version;
    private int max_apply_data_size;
    private int timeout;
    private boolean transfer_bitmap_enable;
    private int transfer_unit_size;

    public boolean getTransfer_bitmap_enable() {
        return this.transfer_bitmap_enable;
    }

    public void setTransfer_bitmap_enable(boolean z) {
        this.transfer_bitmap_enable = z;
    }

    public int getTransfer_unit_size() {
        return this.transfer_unit_size;
    }

    public void setTransfer_unit_size(int i) {
        this.transfer_unit_size = i;
    }

    public int getMax_apply_data_size() {
        return this.max_apply_data_size;
    }

    public void setMax_apply_data_size(int i) {
        this.max_apply_data_size = i;
    }

    public int getTimeout() {
        return this.timeout;
    }

    public void setTimeout(int i) {
        this.timeout = i;
    }

    public String getFile_protocal_version() {
        return this.file_protocal_version;
    }

    public void setFile_protocal_version(String str) {
        this.file_protocal_version = str;
    }
}
