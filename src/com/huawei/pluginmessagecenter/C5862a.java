package com.huawei.pluginmessagecenter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.huawei.hms.support.api.entity.pay.HwPayConstant;
import com.huawei.hwbasemgr.a;
import com.huawei.hwcloudmodel.b.i;
import com.huawei.hwdataaccessmodel.db.C4763a;
import com.huawei.hwdataaccessmodel.db.C4764b;
import com.huawei.pluginmessagecenter.p499a.C5856b;
import com.huawei.pluginmessagecenter.p499a.C5861g;
import com.huawei.pluginmessagecenter.provider.C5877a;
import com.huawei.pluginmessagecenter.provider.data.MessageChangeEvent;
import com.huawei.pluginmessagecenter.provider.data.MessageDBObject;
import com.huawei.pluginmessagecenter.provider.data.MessageObject;
import com.huawei.ui.main.stories.lightcloud.constants.JoinConstants;
import com.sina.weibo.sdk.constant.WBConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import net.sqlcipher.database.SQLiteDatabase;

/* compiled from: MessageDBProvider */
public class C5862a extends a {
    private static String f20125a = "MessageDBProvider";
    private static volatile C5862a f20126b;
    private Context f20127c;

    private C5862a(Context context) {
        super(context);
        C5861g.m27024c(f20125a, "Enter MessageDBProvider");
        this.f20127c = context;
        if (m27032c()) {
            C5861g.m27024c(f20125a, "MessageDB data is null!");
        }
        C4764b.m22772a(this.f20127c, String.valueOf(getModuleId()));
        int a = C4764b.m22771a();
        C5861g.m27024c(f20125a, "newDBVersion =" + 103 + ", oldDBVersion=" + a);
        if (103 <= a || 100 != a) {
            m27033d();
        } else {
            m27034e();
        }
        C5861g.m27024c(f20125a, "Leave MessageDBProvider");
    }

    private boolean m27032c() {
        C5861g.m27024c(f20125a, "Enter checkMessageDBisNull");
        if (queryStorageData(WBConstants.ACTION_LOG_TYPE_MESSAGE, 1, null) != null) {
            return false;
        }
        return true;
    }

    public String m27036a(String str, String str2) {
        C5861g.m27024c(f20125a, "Enter requestMessageId module = " + str + "  type = " + str2);
        List b = m27042b(str, str2);
        if (!b.isEmpty()) {
            return ((MessageObject) b.get(0)).getMsgId();
        }
        String c = com.huawei.login.ui.login.a.a(this.f20127c).c();
        MessageDBObject messageDBObject = new MessageDBObject();
        ContentValues contentValues = new ContentValues();
        contentValues.put("huid", c);
        contentValues.put(JoinConstants.MODULE, str);
        contentValues.put("type", str2);
        contentValues.put("msgId", messageDBObject.getMsgId());
        contentValues.put("msgType", Integer.valueOf(messageDBObject.getMsgType()));
        contentValues.put("flag", Integer.valueOf(messageDBObject.getFlag()));
        contentValues.put("weight", Integer.valueOf(messageDBObject.getWeight()));
        contentValues.put("readFlag", Integer.valueOf(messageDBObject.getReadFlag()));
        contentValues.put("msgTitle", messageDBObject.getMsgTitle());
        contentValues.put("createTime", Long.valueOf(messageDBObject.getCreateTime()));
        contentValues.put("receiveTime", Long.valueOf(messageDBObject.getReceiveTime()));
        contentValues.put(HwPayConstant.KEY_EXPIRETIME, Long.valueOf(messageDBObject.getExpireTime()));
        contentValues.put("detailUri", messageDBObject.getDetailUri());
        contentValues.put("position", Integer.valueOf(messageDBObject.getPosition()));
        contentValues.put("msgPosition", Integer.valueOf(messageDBObject.getMsgPosition()));
        contentValues.put("notified", Integer.valueOf(0));
        c = "";
        try {
            SQLiteDatabase b2 = C4764b.m22772a(this.f20127c, String.valueOf(getModuleId())).m22774b();
            b2.beginTransaction();
            long insertStorageData = insertStorageData(WBConstants.ACTION_LOG_TYPE_MESSAGE, 1, contentValues);
            if (insertStorageData == -1) {
                return null;
            }
            c = "l" + insertStorageData;
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("msgId", c);
            String str3 = "id = " + insertStorageData;
            C5861g.m27024c(f20125a, "requestMessageId | whereSql = " + str3);
            updateStorageData(WBConstants.ACTION_LOG_TYPE_MESSAGE, 1, contentValues2, str3);
            b2.setTransactionSuccessful();
            b2.endTransaction();
            C5861g.m27024c(f20125a, "Leave requestMessageId module = " + str + "  type = " + str2);
            return c;
        } catch (Exception e) {
            C5861g.m27024c(f20125a, "Leave requestMessageId Exception e!!!");
            return c;
        }
    }

    private void m27033d() {
        C5861g.m27024c(f20125a, "createTable | create new table: " + getTableFullName(WBConstants.ACTION_LOG_TYPE_MESSAGE));
        String str = "id integer primary key autoincrement,msgId text not null,module text,type text,metadata text,msgType integer not null check(msgType > 0),flag integer not null check(flag > -1),weight integer not null check(weight > -1),readFlag integer not null,msgTitle text not null,msgContext text,createTime integer not null,receiveTime integer not null,expireTime integer not null,imgURI text,detailUri text not null,detailUriExt text,msgFrom text,position integer not null check(position > 0),msgPosition integer not null,huid text,imei text,notified integer not null";
        C5861g.m27024c(f20125a, "createTable | create new table sql = " + str);
        createStorageDataTable(WBConstants.ACTION_LOG_TYPE_MESSAGE, 1, str);
        C5861g.m27024c(f20125a, "createTable | create table end");
    }

    private void m27034e() {
        List arrayList = new ArrayList();
        arrayList.clear();
        C5861g.m27024c(f20125a, "Enter upgradeMessageCenterDB");
        Cursor queryStorageData = queryStorageData(WBConstants.ACTION_LOG_TYPE_MESSAGE, 1, null);
        if (queryStorageData == null || !queryStorageData.moveToFirst()) {
            if (queryStorageData != null) {
                queryStorageData.close();
            }
            m27039a();
            C4763a.m22756a(this.f20127c, String.valueOf(getModuleId()), WBConstants.ACTION_LOG_TYPE_MESSAGE, 1);
            m27033d();
            if (arrayList.size() > 0) {
                m27040a(arrayList);
            }
            C5861g.m27024c(f20125a, "Leave upgradeMessageCenterDB");
        }
        do {
            MessageObject messageObject = new MessageObject();
            m27027a(queryStorageData, messageObject);
            messageObject.setMsgPosition(0);
            arrayList.add(messageObject);
        } while (queryStorageData.moveToNext());
        if (queryStorageData != null) {
            queryStorageData.close();
        }
        m27039a();
        C4763a.m22756a(this.f20127c, String.valueOf(getModuleId()), WBConstants.ACTION_LOG_TYPE_MESSAGE, 1);
        m27033d();
        if (arrayList.size() > 0) {
            m27040a(arrayList);
        }
        C5861g.m27024c(f20125a, "Leave upgradeMessageCenterDB");
    }

    private void m27027a(Cursor cursor, MessageObject messageObject) {
        messageObject.setMsgId(cursor.getString(cursor.getColumnIndex("msgId")));
        messageObject.setMsgType(cursor.getInt(cursor.getColumnIndex("msgType")));
        messageObject.setModule(cursor.getString(cursor.getColumnIndex(JoinConstants.MODULE)));
        messageObject.setType(cursor.getString(cursor.getColumnIndex("type")));
        messageObject.setMetadata(cursor.getString(cursor.getColumnIndex("metadata")));
        messageObject.setFlag(cursor.getInt(cursor.getColumnIndex("flag")));
        messageObject.setWeight(cursor.getInt(cursor.getColumnIndex("weight")));
        messageObject.setReadFlag(cursor.getInt(cursor.getColumnIndex("readFlag")));
        messageObject.setMsgTitle(cursor.getString(cursor.getColumnIndex("msgTitle")));
        messageObject.setMsgContent(cursor.getString(cursor.getColumnIndex("msgContext")));
        messageObject.setCreateTime(cursor.getLong(cursor.getColumnIndex("createTime")));
        messageObject.setReceiveTime(cursor.getLong(cursor.getColumnIndex("receiveTime")));
        messageObject.setExpireTime(cursor.getLong(cursor.getColumnIndex(HwPayConstant.KEY_EXPIRETIME)));
        messageObject.setImgUri(cursor.getString(cursor.getColumnIndex("imgURI")));
        messageObject.setDetailUri(cursor.getString(cursor.getColumnIndex("detailUri")));
        messageObject.setDetailUriExt(cursor.getString(cursor.getColumnIndex("detailUriExt")));
        messageObject.setMsgFrom(cursor.getString(cursor.getColumnIndex("msgFrom")));
        messageObject.setPosition(cursor.getInt(cursor.getColumnIndex("position")));
        messageObject.setHuid(cursor.getString(cursor.getColumnIndex("huid")));
        messageObject.setImei(cursor.getString(cursor.getColumnIndex("imei")));
        messageObject.setNotified(cursor.getInt(cursor.getColumnIndex("notified")));
    }

    private boolean m27028a(MessageObject messageObject) {
        C5861g.m27024c(f20125a, "Enter insert | Message: ");
        if (m27030c(messageObject) != 0) {
            return false;
        }
        String msgId = messageObject.getMsgId();
        ContentValues contentValues = new ContentValues();
        contentValues.put("metadata", messageObject.getMetadata());
        contentValues.put("msgType", Integer.valueOf(messageObject.getMsgType()));
        contentValues.put("flag", Integer.valueOf(messageObject.getFlag()));
        contentValues.put("weight", Integer.valueOf(messageObject.getWeight()));
        contentValues.put("readFlag", Integer.valueOf(messageObject.getReadFlag()));
        contentValues.put("msgTitle", messageObject.getMsgTitle());
        contentValues.put("msgContext", messageObject.getMsgContent());
        contentValues.put("createTime", Long.valueOf(messageObject.getCreateTime()));
        contentValues.put("receiveTime", Long.valueOf(System.currentTimeMillis()));
        contentValues.put(HwPayConstant.KEY_EXPIRETIME, Long.valueOf(messageObject.getExpireTime()));
        contentValues.put("imgURI", messageObject.getImgUri());
        contentValues.put("detailUri", messageObject.getDetailUri());
        contentValues.put("detailUriExt", messageObject.getDetailUriExt());
        contentValues.put("msgFrom", messageObject.getMsgFrom());
        contentValues.put("position", Integer.valueOf(messageObject.getPosition()));
        contentValues.put("msgPosition", Integer.valueOf(messageObject.getMsgPosition()));
        contentValues.put("huid", messageObject.getHuid());
        contentValues.put("imei", messageObject.getImei());
        contentValues.put("notified", Integer.valueOf(0));
        if (m27046e(msgId) == null) {
            contentValues.put("msgId", messageObject.getMsgId());
            contentValues.put(JoinConstants.MODULE, messageObject.getModule());
            contentValues.put("type", messageObject.getType());
            long insertStorageData = insertStorageData(WBConstants.ACTION_LOG_TYPE_MESSAGE, 1, contentValues);
            if (insertStorageData <= 0 || insertStorageData == 201000) {
                C5861g.m27024c(f20125a, "insert | insert a new message failed");
                return false;
            }
            C5861g.m27024c(f20125a, "insert | insert a new message success");
            return true;
        }
        msgId = " msgId = '" + msgId + "' and module = '" + messageObject.getModule() + "' and type = '" + messageObject.getType() + "'";
        C5861g.m27024c(f20125a, "insert | update content of message; whereSql = " + msgId);
        if (((long) updateStorageData(WBConstants.ACTION_LOG_TYPE_MESSAGE, 1, contentValues, msgId)) == 0) {
            C5861g.m27024c(f20125a, "insert | update content of message success");
            return true;
        }
        C5861g.m27024c(f20125a, "insert | update content of message failed");
        return false;
    }

    public boolean m27040a(List<MessageObject> list) {
        int i;
        boolean z;
        C5861g.m27024c(f20125a, "Enter insertBatch ");
        if (list == null) {
            C5861g.m27024c(f20125a, "insertBatch | MessageObject List is null.");
            return false;
        }
        ArrayList arrayList = new ArrayList();
        try {
            SQLiteDatabase b = C4764b.m22772a(this.f20127c, String.valueOf(getModuleId())).m22774b();
            b.beginTransaction();
            i = 0;
            for (MessageObject messageObject : list) {
                try {
                    if (m27030c(messageObject) != 0) {
                        C5861g.m27024c(f20125a, "column check failed.");
                    } else {
                        if (m27028a(messageObject)) {
                            i++;
                            arrayList.add(messageObject.getMsgId());
                        }
                        i = i;
                    }
                } catch (Exception e) {
                }
            }
            b.setTransactionSuccessful();
            b.endTransaction();
        } catch (Exception e2) {
            i = 0;
            C5861g.m27024c(f20125a, "Leave insertBatch Exception e !!!");
            if (i != list.size()) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                C5877a.m27072a().m27073a(0, new MessageChangeEvent(arrayList, null));
            }
            C5861g.m27024c(f20125a, "Leave insertBatch ");
            return z;
        }
        if (i != list.size()) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            C5877a.m27072a().m27073a(0, new MessageChangeEvent(arrayList, null));
        }
        C5861g.m27024c(f20125a, "Leave insertBatch ");
        return z;
    }

    public int m27035a(String str) {
        C5861g.m27024c(f20125a, "Enter deleteMessageById");
        String c = com.huawei.login.ui.login.a.a(this.f20127c).c();
        if (c == null || "".equals(c)) {
            C5861g.m27024c(f20125a, "deleteMessageById | delete message failed  huid is null!");
            return -1;
        }
        c = "msgId = '" + str + "' and huid = '" + c + "'";
        C5861g.m27024c(f20125a, "deleteMessage | whereSql = " + c);
        int deleteStorageData = deleteStorageData(WBConstants.ACTION_LOG_TYPE_MESSAGE, 1, c);
        if (deleteStorageData == 0) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            C5877a.m27072a().m27073a(0, new MessageChangeEvent(null, arrayList));
        }
        C5861g.m27024c(f20125a, "Leave deleteMessageById");
        return deleteStorageData;
    }

    public boolean m27039a() {
        int deleteStorageData = deleteStorageData(WBConstants.ACTION_LOG_TYPE_MESSAGE, 1, null);
        C5861g.m27023b(f20125a, "deleteAllMessages | delete messages; resultCode = " + deleteStorageData);
        if (deleteStorageData == 0) {
            return true;
        }
        return false;
    }

    public boolean m27043b(String str) {
        boolean z = false;
        C5861g.m27024c(f20125a, "Enter onRead msgId = " + str);
        if (str == null) {
            C5861g.m27024c(f20125a, "onRead(String msgId):msgId is null");
        } else {
            MessageObject e = m27046e(str);
            if (e == null) {
                C5861g.m27024c(f20125a, "onRead(String msgId):messageObject is null");
            } else {
                int msgType = e.getMsgType();
                ContentValues contentValues = new ContentValues();
                contentValues.put("readFlag", Integer.valueOf(1));
                if (msgType == 3) {
                    contentValues.put(HwPayConstant.KEY_EXPIRETIME, Long.valueOf(C5856b.m27006b("23:59:59")));
                } else if (msgType == 2) {
                    contentValues.put(HwPayConstant.KEY_EXPIRETIME, Integer.valueOf(-1));
                }
                String str2 = "msgId = '" + str + "'";
                C5861g.m27024c(f20125a, "onRead | whereSql = " + str2);
                if (updateStorageData(WBConstants.ACTION_LOG_TYPE_MESSAGE, 1, contentValues, str2) == 0) {
                    z = true;
                }
                if (z) {
                    Executors.newFixedThreadPool(1).execute(new C5863b(this, str));
                }
                C5861g.m27024c(f20125a, "Leave onRead msgId = " + str);
            }
        }
        return z;
    }

    public static C5862a m27025a(Context context) {
        if (f20126b == null) {
            synchronized (C5862a.class) {
                if (f20126b == null) {
                    f20126b = new C5862a(context);
                }
            }
        }
        return f20126b;
    }

    public long m27041b() {
        C5861g.m27024c(f20125a, "Enter getMaxTime");
        long j = 0;
        String c = com.huawei.login.ui.login.a.a(this.f20127c).c();
        if (c == null || "".equals(c)) {
            C5861g.m27023b(f20125a, "getMaxTime | huid is invalid");
            return -1;
        }
        c = "SELECT MAX(createTime) FROM " + getTableFullName(WBConstants.ACTION_LOG_TYPE_MESSAGE) + " WHERE (" + "huid" + " = '" + c + "' or " + "huid" + " = '' )  and " + "msgId" + " like 'S%' or " + "msgId" + " like 'G%'";
        C5861g.m27024c(f20125a, "getMaxTime | sql = " + c);
        Cursor rawQueryStorageData = rawQueryStorageData(1, c, null);
        if (rawQueryStorageData != null) {
            if (rawQueryStorageData.moveToFirst()) {
                j = rawQueryStorageData.getLong(0);
            }
            rawQueryStorageData.close();
        }
        C5861g.m27024c(f20125a, "Leave getMaxTime | getMaxTime = " + j);
        return j;
    }

    private List<MessageObject> m27031c(String str, String str2) {
        List<MessageObject> arrayList = new ArrayList();
        C5861g.m27024c(f20125a, "Enter queryAll");
        String str3 = "(huid = '" + str + "' OR " + "huid" + " = '') AND (" + "imei" + "= '" + str2 + "' OR " + "imei" + " is null or " + "imei" + " = '')  ORDER BY " + "weight" + " DESC, " + "receiveTime" + " DESC";
        C5861g.m27024c(f20125a, "queryAll | whereSql 0");
        Cursor queryStorageData = queryStorageData(WBConstants.ACTION_LOG_TYPE_MESSAGE, 1, str3);
        if (queryStorageData != null) {
            while (queryStorageData.moveToNext()) {
                MessageObject a = m27026a(queryStorageData);
                C5861g.m27024c(f20125a, "queryAll | messageObject 1");
                int i = !"".equals(str) ? 1 : 0;
                if (!i.a(40) && (a.getMsgId().startsWith("S") || a.getMsgId().startsWith("G"))) {
                    C5861g.m27024c(f20125a, "queryAll | messageObject 1 continue S G");
                } else if (!m27029b(a)) {
                    String type = a.getType();
                    if (i == 0 && "specialCloudServiceMessage".equals(type)) {
                        C5861g.m27024c(f20125a, "queryAll | messageObject 1 type = specialCloudServiceMessage");
                    } else {
                        arrayList.add(a);
                    }
                }
            }
            queryStorageData.close();
        }
        C5861g.m27024c(f20125a, "Leave queryAll");
        return arrayList;
    }

    public List<MessageObject> m27044c(String str) {
        List<MessageObject> arrayList = new ArrayList();
        C5861g.m27024c(f20125a, "Enter queryAll");
        String str2 = "(huid = '" + str + "' OR " + "huid" + " = '') ORDER BY " + "weight" + " DESC, " + "receiveTime" + " DESC";
        C5861g.m27024c(f20125a, "queryAllForHealth | whereSql 0：" + str2);
        Cursor queryStorageData = queryStorageData(WBConstants.ACTION_LOG_TYPE_MESSAGE, 1, str2);
        if (queryStorageData != null) {
            while (queryStorageData.moveToNext()) {
                MessageObject a = m27026a(queryStorageData);
                C5861g.m27024c(f20125a, "queryAllForHealth | messageObject 1");
                int i = !"".equals(str) ? 1 : 0;
                if (a.getMsgId() != null && a.getMsgId().length() > 0 && !i.a(40) && (a.getMsgId().startsWith("S") || a.getMsgId().startsWith("G"))) {
                    C5861g.m27024c(f20125a, "queryAllForHealth | messageObject 1 continue S G");
                } else if (!m27029b(a)) {
                    String type = a.getType();
                    if (i == 0 && "specialCloudServiceMessage".equals(type)) {
                        C5861g.m27024c(f20125a, "queryAllForHealth | messageObject 1 type = specialCloudServiceMessage");
                    } else {
                        arrayList.add(a);
                    }
                }
            }
            queryStorageData.close();
        }
        C5861g.m27024c(f20125a, "Leave queryAllForHealth");
        return arrayList;
    }

    private boolean m27029b(MessageObject messageObject) {
        if (messageObject == null) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long expireTime = messageObject.getExpireTime();
        C5861g.m27024c(f20125a, "checkoutExpireMessageAndDelete expireTime = " + expireTime + "   currentTime = " + currentTimeMillis);
        if (expireTime >= currentTimeMillis) {
            return false;
        }
        return true;
    }

    private MessageObject m27026a(Cursor cursor) {
        MessageObject messageObject = new MessageObject();
        m27027a(cursor, messageObject);
        if (-1 != cursor.getColumnIndex("msgPosition")) {
            messageObject.setMsgPosition(cursor.getInt(cursor.getColumnIndex("msgPosition")));
        }
        return messageObject;
    }

    protected Integer getModuleId() {
        return Integer.valueOf(20005);
    }

    private int m27030c(MessageObject messageObject) {
        if (messageObject == null) {
            return -1;
        }
        if (TextUtils.isEmpty(messageObject.getMsgId())) {
            C5861g.m27024c(f20125a, "Message ID can't be null");
            return -1;
        } else if (TextUtils.isEmpty(messageObject.getMsgTitle())) {
            C5861g.m27024c(f20125a, "Message title can't be null");
            return -1;
        } else if (messageObject.getCreateTime() < 0) {
            C5861g.m27024c(f20125a, "Message create time less than 0");
            return -1;
        } else if (messageObject.getExpireTime() < 0) {
            C5861g.m27024c(f20125a, "Message expire time less than 0");
            return -1;
        } else if (messageObject.getPosition() != 0) {
            return 0;
        } else {
            C5861g.m27024c(f20125a, "Message position is invalid");
            return -1;
        }
    }

    public void m27045d(String str) {
        if (TextUtils.isEmpty(str)) {
            C5861g.m27024c(f20125a, "setNotify | msgId = " + str);
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("notified", Integer.valueOf(1));
        String str2 = "msgId = '" + str + "'";
        C5861g.m27024c(f20125a, "setNotify | whereSql = " + str2);
        C5861g.m27024c(f20125a, "setNotify | updateStorageData = " + updateStorageData(WBConstants.ACTION_LOG_TYPE_MESSAGE, 1, contentValues, str2));
    }

    public void m27038a(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            C5861g.m27024c(f20125a, "setReceiveTime | msgId = " + str);
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("receiveTime", Long.valueOf(j));
        String str2 = "msgId = '" + str + "'";
        C5861g.m27024c(f20125a, "setReceiveTime | whereSql = " + str2);
        C5861g.m27024c(f20125a, "setReceiveTime | updateStorageData = " + updateStorageData(WBConstants.ACTION_LOG_TYPE_MESSAGE, 1, contentValues, str2));
    }

    public MessageObject m27046e(String str) {
        MessageObject messageObject = null;
        String str2 = "msgId = '" + str + "'";
        C5861g.m27024c(f20125a, "getMessage | whereSql = " + str2);
        Cursor queryStorageData = queryStorageData(WBConstants.ACTION_LOG_TYPE_MESSAGE, 1, str2);
        if (queryStorageData != null) {
            if (queryStorageData.moveToFirst()) {
                messageObject = m27026a(queryStorageData);
            }
            queryStorageData.close();
        }
        return messageObject;
    }

    public List<MessageObject> m27042b(String str, String str2) {
        List<MessageObject> arrayList = new ArrayList();
        String str3 = "module = '" + str + "' and " + "type" + " = '" + str2 + "'";
        C5861g.m27024c(f20125a, "getMessages | whereSql = " + str3);
        Cursor queryStorageData = queryStorageData(WBConstants.ACTION_LOG_TYPE_MESSAGE, 1, str3);
        if (queryStorageData != null) {
            while (queryStorageData.moveToNext()) {
                arrayList.add(m27026a(queryStorageData));
            }
            queryStorageData.close();
        }
        return arrayList;
    }

    public List<MessageObject> m27037a(String str, String str2, int i, int i2) {
        C5861g.m27024c(f20125a, "Enter getMessageList");
        if (TextUtils.isEmpty(str)) {
            C5861g.m27024c(f20125a, "getMessageList | huid is null");
            return new ArrayList();
        }
        if (str2 == null) {
            str2 = "";
        }
        if (i == 0 && i2 == 0) {
            return m27031c(str, str2);
        }
        List<MessageObject> arrayList = new ArrayList();
        String str3 = "(huid = '" + str + "' or " + "huid" + " = '')  and (" + "imei" + " = '" + str2 + "' or " + "imei" + " is null or " + "imei" + " = '')  order by " + "weight" + " desc, " + "createTime" + " desc limit " + ((i - 1) * i2) + "," + i2;
        C5861g.m27024c(f20125a, "getMessageList | whereSql 0");
        Cursor queryStorageData = queryStorageData(WBConstants.ACTION_LOG_TYPE_MESSAGE, 1, str3);
        if (queryStorageData != null) {
            while (queryStorageData.moveToNext()) {
                arrayList.add(m27026a(queryStorageData));
            }
            queryStorageData.close();
        }
        C5861g.m27024c(f20125a, "Leave getMessageList");
        return arrayList;
    }
}
