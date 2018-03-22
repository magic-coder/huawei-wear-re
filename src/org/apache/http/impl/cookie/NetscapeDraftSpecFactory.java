package org.apache.http.impl.cookie;

import java.util.Collection;
import org.apache.http.annotation.Immutable;
import org.apache.http.cookie.CookieSpec;
import org.apache.http.cookie.CookieSpecFactory;
import org.apache.http.cookie.params.CookieSpecPNames;
import org.apache.http.params.HttpParams;

@Immutable
public class NetscapeDraftSpecFactory implements CookieSpecFactory {
    public CookieSpec newInstance(HttpParams httpParams) {
        if (httpParams == null) {
            return new NetscapeDraftSpec();
        }
        String[] strArr;
        Collection collection = (Collection) httpParams.getParameter(CookieSpecPNames.DATE_PATTERNS);
        if (collection != null) {
            strArr = (String[]) collection.toArray(new String[collection.size()]);
        } else {
            strArr = null;
        }
        return new NetscapeDraftSpec(strArr);
    }
}
