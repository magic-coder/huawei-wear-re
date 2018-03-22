package com.huawei.crowdtestsdk.httpaccess;

import android.content.Context;
import com.huawei.crowdtestsdk.common.AppContext;
import com.huawei.uploadlog.p188c.C2511g;
import java.io.File;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class HttpInMemoryCookieStore implements CookieStore {
    private HashMap<String, ConcurrentHashMap<String, HttpCookie>> cookies = new HashMap();

    public HttpInMemoryCookieStore() {
        clearPersistentCookies();
    }

    public void add(URI uri, HttpCookie httpCookie) {
        if (httpCookie != null) {
            String domain = httpCookie.getDomain();
            if (domain == null) {
                return;
            }
            if (!httpCookie.hasExpired()) {
                if (!this.cookies.containsKey(domain)) {
                    this.cookies.put(domain, new ConcurrentHashMap());
                }
                ((ConcurrentHashMap) this.cookies.get(domain)).put(httpCookie.getName(), httpCookie);
            } else if (this.cookies.containsKey(domain)) {
                ((ConcurrentHashMap) this.cookies.get(domain)).remove(domain);
            }
        }
    }

    public List<HttpCookie> get(URI uri) {
        List arrayList = new ArrayList();
        for (Entry entry : this.cookies.entrySet()) {
            if (uri.getHost().contains((String) entry.getKey())) {
                arrayList.addAll(((ConcurrentHashMap) entry.getValue()).values());
            }
        }
        return arrayList;
    }

    public List<HttpCookie> getCookies() {
        List arrayList = new ArrayList();
        for (ConcurrentHashMap values : this.cookies.values()) {
            arrayList.addAll(values.values());
        }
        return arrayList;
    }

    public List<URI> getURIs() {
        List arrayList = new ArrayList();
        for (String uri : this.cookies.keySet()) {
            try {
                arrayList.add(new URI(uri));
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    public boolean remove(URI uri, HttpCookie httpCookie) {
        String cookieToken = getCookieToken(uri, httpCookie);
        if (!this.cookies.containsKey(uri.getHost()) || !((ConcurrentHashMap) this.cookies.get(uri.getHost())).containsKey(cookieToken)) {
            return false;
        }
        ((ConcurrentHashMap) this.cookies.get(uri.getHost())).remove(cookieToken);
        return true;
    }

    protected String getCookieToken(URI uri, HttpCookie httpCookie) {
        return httpCookie.getName() + httpCookie.getDomain();
    }

    public boolean removeAll() {
        C2511g.m12481b("BETACLUB_SDK", "[HttpInMemoryCookieStore.removeAll]");
        this.cookies.clear();
        return true;
    }

    private void clearPersistentCookies() {
        File xmlFile = getXmlFile(getDir(AppContext.getInstance().getApplicationContext(), "shared_prefs"), "CookiePrefsFile");
        if (xmlFile.exists() && xmlFile.delete()) {
            C2511g.m12481b("BETACLUB_SDK", "HttpInMemoryCookieStore delete success!");
        }
    }

    private static File getDir(Context context, String str) {
        try {
            return new File(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.dataDir + "/" + str);
        } catch (Throwable e) {
            C2511g.m12482b("BETACLUB_SDK", "[HttpInMemoryCookieStore.getDir]Error:", e);
            return null;
        }
    }

    private static File getXmlFile(File file, String str) {
        return new File(file.getAbsolutePath() + "/" + str + ".xml");
    }
}
