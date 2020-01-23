package com.vaenow.appupdate.android;

import android.content.res.Resources;
import org.json.JSONObject;
import org.json.JSONException;
/**
 * Created by LuoWen on 16/9/16.
 */
public class MsgHelper {
    private String packageName;
    private Resources resources;
    private JSONObject translations;
    public static String UPDATE_TITLE = "update_title";
    public static String UPDATE_MESSAGE = "update_message";
    public static String UPDATE_UPDATE_BTN = "update_update_btn";
    public static String APPUPDATE_PROGRESS = "appupdate_progress";
    public static String UPDATE_PROGRESS = "update_progress";
    public static String UPDATING = "updating";
    public static String UPDATE_BG = "update_bg";
    public static String DOWNLOAD_COMPLETE_TITLE = "download_complete_title";
    public static String DOWNLOAD_COMPLETE_POS_BTN = "download_complete_pos_btn";
    public static String DOWNLOAD_COMPLETE_NEU_BTN = "download_complete_neu_btn";
    public static String UPDATE_ERROR_TITLE = "update_error_title";
    public static String UPDATE_ERROR_MESSAGE = "update_error_message";
    public static String UPDATE_ERROR_YES_BTN = "update_error_yes_btn";


    MsgHelper(String packageName, Resources resources) {
        this.packageName = packageName;
        this.resources = resources;
    }

    MsgHelper(String packageName, Resources resources, JSONObject translations) {
        this.packageName = packageName;
        this.resources = resources;
        this.translations = translations;
    }

    public int getId(String name) {
        return resources.getIdentifier(name, "id", packageName);
    }

    public int getString(String name) {
        return resources.getIdentifier(name, "string", packageName);
    }

    public String getTranslateFromJson(String name) {
        try{
            return translations.getString(name);
        }catch (JSONException e) {
            return name.replace('_', ' ');
        }
    }
    public int getLayout(String name) {
        return resources.getIdentifier(name, "layout", packageName);
    }

    public boolean hasTranslation() {
        return this.translations != null;
    }

    public String translation() {
        return this.translations.toString();
    }
}
