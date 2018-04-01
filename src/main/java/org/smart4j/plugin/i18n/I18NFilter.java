package org.smart4j.plugin.i18n;

import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import org.smart4j.framework.FrameworkConstant;
import org.smart4j.framework.core.ConfigHelper;
import org.smart4j.framework.util.ClassUtil;
import org.smart4j.framework.util.StringUtil;
import org.smart4j.framework.util.WebUtil;

@WebFilter({"/*"})
public class I18NFilter implements Filter {
    public I18NFilter() {
    }

    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        String requestPath = WebUtil.getRequestPath(req);
        if (!requestPath.startsWith(FrameworkConstant.WWW_PATH)) {
            String systemLanguage = getSystemLanguage((HttpServletRequest)request);
            request.setAttribute("system_language", systemLanguage);
            boolean reloadable = ConfigHelper.getBoolean("smart.plugin.i18n.reloadable");
            if (reloadable) {
                ResourceBundle.clearCache();
                String appBasePath = req.getServletContext().getRealPath("");
                I18NPlugin.generateJS(appBasePath);
            }
        }

        chain.doFilter(request, response);
    }

    public void destroy() {
    }

    private static String getSystemLanguage(HttpServletRequest request) {
        String language = WebUtil.getCookie(request, "cookie_language");
        if (StringUtil.isEmpty(language)) {
            language = request.getLocale().toString();
            if (StringUtil.isEmpty(language)) {
                language = Locale.getDefault().toString();
            }
        }

        String i18nPropsPath = ClassUtil.getClassPath() + "i18n/" + "i18n_" + language + ".properties";
        File i18nPropsFile = new File(i18nPropsPath);
        if (!i18nPropsFile.exists()) {
            language = "en_US";
        }

        return language;
    }
}
