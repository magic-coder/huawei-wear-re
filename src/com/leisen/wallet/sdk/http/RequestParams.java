package com.leisen.wallet.sdk.http;

import com.huawei.wallet.utils.log.LogC;
import com.sina.weibo.sdk.component.GameManager;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

public class RequestParams {
    public static final String APPLICATION_OCTET_STREAM = "application/octet-stream";
    protected String contentEncoding;
    protected final ConcurrentHashMap<String, FileWrapper> fileParams;
    private boolean isRepeatable;
    protected final ConcurrentHashMap<String, String> urlParams;
    protected final ConcurrentHashMap<String, Object> urlParamsWithObjects;

    public class FileWrapper {
        public final String contentType;
        public final File file;

        public FileWrapper(File file, String str) {
            this.file = file;
            this.contentType = str;
        }
    }

    public RequestParams() {
        this(null);
    }

    public RequestParams(Map<String, String> map) {
        this.urlParams = new ConcurrentHashMap();
        this.urlParamsWithObjects = new ConcurrentHashMap();
        this.fileParams = new ConcurrentHashMap();
        this.contentEncoding = GameManager.DEFAULT_CHARSET;
        this.isRepeatable = false;
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                put((String) entry.getKey(), (String) entry.getValue());
            }
        }
    }

    private void put(String str, String str2) {
        if (str != null && str2 != null) {
            this.urlParams.put(str, str2);
        }
    }

    public void put(String str, Object obj) {
        if (str != null && obj != null) {
            this.urlParamsWithObjects.put(str, obj);
        }
    }

    public void put(String str, File file, String str2) throws FileNotFoundException {
        if (file == null || !file.exists()) {
            throw new FileNotFoundException();
        } else if (str != null) {
            this.fileParams.put(str, new FileWrapper(file, str2));
        }
    }

    public void put(String str, int i) {
        if (str != null) {
            this.urlParams.put(str, String.valueOf(i));
        }
    }

    public void put(String str, long j) {
        if (str != null) {
            this.urlParams.put(str, String.valueOf(j));
        }
    }

    protected List<BasicNameValuePair> getParamsList() {
        List<BasicNameValuePair> linkedList = new LinkedList();
        for (Entry entry : this.urlParams.entrySet()) {
            linkedList.add(new BasicNameValuePair((String) entry.getKey(), (String) entry.getValue()));
        }
        linkedList.addAll(getParamsList(null, this.urlParamsWithObjects));
        return linkedList;
    }

    private List<BasicNameValuePair> getParamsList(String str, Object obj) {
        List<BasicNameValuePair> linkedList = new LinkedList();
        if (obj instanceof Map) {
            Map map = (Map) obj;
            List arrayList = new ArrayList(map.keySet());
            Collections.sort(arrayList);
            for (Object next : arrayList) {
                if (next instanceof String) {
                    Object obj2 = map.get(next);
                    if (obj2 != null) {
                        String str2;
                        if (str == null) {
                            str2 = (String) next;
                        } else {
                            str2 = String.format("%s[%s]", new Object[]{str, next});
                        }
                        linkedList.addAll(getParamsList(str2, obj2));
                    }
                }
            }
        } else if (obj instanceof List) {
            List list = (List) obj;
            r3 = list.size();
            for (r0 = 0; r0 < r3; r0++) {
                linkedList.addAll(getParamsList(String.format("%s[%d]", new Object[]{str, Integer.valueOf(r0)}), list.get(r0)));
            }
        } else if (obj instanceof Object[]) {
            for (Object paramsList : (Object[]) obj) {
                linkedList.addAll(getParamsList(String.format("%s[%d]", new Object[]{str, Integer.valueOf(r0)}), paramsList));
            }
        } else if (obj instanceof Set) {
            for (Object paramsList2 : (Set) obj) {
                linkedList.addAll(getParamsList(str, paramsList2));
            }
        } else {
            linkedList.add(new BasicNameValuePair(str, obj.toString()));
        }
        return linkedList;
    }

    protected String getParamString() {
        return URLEncodedUtils.format(getParamsList(), this.contentEncoding);
    }

    public HttpEntity getEntity(ResponseHandlerInterface responseHandlerInterface) throws IOException {
        return createFormEntity();
    }

    private HttpEntity createFormEntity() {
        try {
            return new UrlEncodedFormEntity(getParamsList(), this.contentEncoding);
        } catch (UnsupportedEncodingException e) {
            LogC.m28534d("Exception e " + e.getMessage(), false);
            return null;
        }
    }

    public void setHttpEntityIsRepeatable(boolean z) {
        this.isRepeatable = z;
    }
}
