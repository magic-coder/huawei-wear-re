package com.huawei.pluginkidwatch.common.entity.model;

import com.huawei.pluginkidwatch.common.lib.utils.C1489i;
import java.io.Serializable;

public class Contact implements Serializable {
    private static final long serialVersionUID = -8429246251287724528L;
    public String bigHeadIcon = "";
    public String bitmapStr;
    public int contactId;
    public String headIcon = "";
    public String iconType;
    public int mType = 0;
    public String name;
    public String phoneNum;
    private String sortLetters;
    public int sosType = 0;
    public String type = "0";

    public String getIconType() {
        return this.iconType;
    }

    public void setIconType(String str) {
        this.iconType = str;
    }

    public String getName() {
        return (String) C1489i.m6887a(this.name);
    }

    public void setName(String str) {
        this.name = (String) C1489i.m6887a(str);
    }

    public String getPhoneNum() {
        return (String) C1489i.m6887a(this.phoneNum);
    }

    public void setPhoneNum(String str) {
        this.phoneNum = (String) C1489i.m6887a(str);
    }

    public String getHeadIcon() {
        return (String) C1489i.m6887a(this.headIcon);
    }

    public void setHeadIcon(String str) {
        this.headIcon = (String) C1489i.m6887a(str);
    }

    public String getBigHeadIcon() {
        return (String) C1489i.m6887a(this.bigHeadIcon);
    }

    public void setBigHeadIcon(String str) {
        this.bigHeadIcon = (String) C1489i.m6887a(str);
    }

    public int getmType() {
        return ((Integer) C1489i.m6887a(Integer.valueOf(this.mType))).intValue();
    }

    public void setmType(int i) {
        this.mType = i;
    }

    public String getType() {
        return (String) C1489i.m6887a(this.type);
    }

    public void setType(String str) {
        this.type = (String) C1489i.m6887a(str);
    }

    public int getContactId() {
        return ((Integer) C1489i.m6887a(Integer.valueOf(this.contactId))).intValue();
    }

    public void setContactId(int i) {
        this.contactId = ((Integer) C1489i.m6887a(Integer.valueOf(i))).intValue();
    }

    public int getSosType() {
        return ((Integer) C1489i.m6887a(Integer.valueOf(this.sosType))).intValue();
    }

    public void setSosType(int i) {
        this.sosType = i;
    }

    public String getSortLetters() {
        return (String) C1489i.m6887a(this.sortLetters);
    }

    public void setSortLetters(String str) {
        this.sortLetters = (String) C1489i.m6887a(str);
    }

    public String getBitmapStr() {
        return this.bitmapStr;
    }

    public void setBitmapStr(String str) {
        this.bitmapStr = str;
    }

    public String toString() {
        return "Contact{contactId=" + this.contactId + ", name='" + this.name + '\'' + ", phoneNum='" + this.phoneNum + '\'' + ", headIcon='" + this.headIcon + '\'' + ", bigHeadIcon='" + this.bigHeadIcon + '\'' + ", iconType='" + this.iconType + '\'' + ", mType=" + this.mType + ", type='" + this.type + '\'' + ", sosType=" + this.sosType + ", sortLetters='" + this.sortLetters + '\'' + ", bitmapStr='" + this.bitmapStr + '\'' + '}';
    }

    public void getContactRetName() {
    }

    public void requestContactRetHeadUrl() {
    }

    public void downloadContactRetNameUrl() {
    }

    public void judgeContactRetWeightBySomeInfo() {
    }

    public void setContactRetSwitchUpload() {
    }

    public void managerContactRetLocalTable() {
    }

    public void dealWithContactRetResetFactory() {
    }

    public void refreshContactRetInitData() {
    }

    public void queryContactRetProcessData() {
    }

    public void contrustContactRetHeadImage() {
    }

    public void changeContactRetDeviceInfo() {
    }

    public void uadpSaiContactData() {
    }

    public void otaPersonInfo() {
    }

    public void mearsueContactCount() {
    }

    public void deleteContactTable() {
    }

    public void setContactManager() {
    }

    public void addContactAccount() {
    }

    public void operationContactReceive() {
    }

    public void multiSimContants() {
    }

    public void adapterContactsList() {
    }

    public void configContactsActivity() {
    }

    public void openContactsListView() {
    }

    public void closeContactsListView() {
    }
}
