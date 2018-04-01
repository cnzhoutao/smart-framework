package org.smart4j.plugin.i18n;

import java.io.File;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.smart4j.framework.FrameworkConstant;
import org.smart4j.framework.plugin.Plugin;
import org.smart4j.framework.util.ArrayUtil;
import org.smart4j.framework.util.ClassUtil;
import org.smart4j.framework.util.FileUtil;
import org.smart4j.framework.util.JsonUtil;
import org.smart4j.framework.util.PropsUtil;

public class I18NPlugin implements Plugin {
    public I18NPlugin() {
    }

    public void init() {
        String appBasePath = ClassUtil.getClassPath();
        generateJS(appBasePath);
    }

    public void destroy() {
    }

    public static void generateJS(String appBasePath) {
        String propsBasePath = appBasePath + "/i18n/";
        String jsBasePath = System.getProperty("user.dir") + "/src/main/webapp/" + FrameworkConstant.WWW_PATH + "i18n/";
        File propsBaseDir = new File(propsBasePath);
        if (propsBaseDir.exists()) {
            String[] propsFileNames = propsBaseDir.list();
            if (ArrayUtil.isNotEmpty(propsFileNames)) {
                String[] arr$ = propsFileNames;
                int len$ = propsFileNames.length;

                for(int i$ = 0; i$ < len$; ++i$) {
                    String propsFileName = arr$[i$];
                    String jsFilePath = jsBasePath + propsFileName.substring(0, propsFileName.lastIndexOf(".")) + ".js";
                    Map<String, String> map = new HashMap();
                    Properties props = PropsUtil.loadProps("i18n/" + propsFileName);
                    Enumeration names = props.propertyNames();

                    String jsFileContent;
                    while(names.hasMoreElements()) {
                        jsFileContent = (String)names.nextElement();
                        String value = props.getProperty(jsFileContent);
                        map.put(jsFileContent, value);
                    }

                    jsFileContent = "window.I18N = " + JsonUtil.toJSON(map) + ";";
                    FileUtil.writeFile(jsFilePath, jsFileContent);
                }
            }
        }

    }
}
