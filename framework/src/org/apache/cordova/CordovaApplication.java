package org.apache.cordova;

import android.app.Application;

import java.util.ArrayList;

/**
 * <pre>
 *     author : sunqiao
 *     e-mail : sunqiao@kayak.com.cn
 *     time   : 2019/07/29
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public abstract class CordovaApplication extends Application {

    public static CordovaPreferences preferences;
    public static String launchUrl;
    public static ArrayList<PluginEntry> pluginEntries;

    @Override
    public void onCreate() {
        super.onCreate();
        loadConfig();
    }




    //进入初始化Config配置
    protected void loadConfig() {
        ConfigXmlParser parser = new ConfigXmlParser();
        parser.parse(this);
        preferences = parser.getPreferences();
        //preferences.setPreferencesBundle(getIntent().getExtras());
        launchUrl = parser.getLaunchUrl();
        pluginEntries = parser.getPluginEntries();
    }

    public static ArrayList<PluginEntry> getPluginEntries() {
        return pluginEntries;
    }

    public static String getLaunchUrl() {
        return launchUrl;
    }

    public static CordovaPreferences getPreferences() {
        return preferences;
    }
}
