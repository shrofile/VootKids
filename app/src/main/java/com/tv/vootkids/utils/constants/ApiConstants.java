package com.tv.vootkids.utils.constants;

import android.support.annotation.IntDef;

public class ApiConstants {

    /**
     * Error Codes
     */
    public static final int CODE_DEFAULT = 999;
    public static final int CODE_SUCCESS = 200;
    public static final int CODE_NO_CACHE = 201;
    public static final int CODE_NO_NETWORK = 202;
    public static final int CODE_NO_DATA = 203;
    public static final int CODE_INTERNAL_SERVER_ERROR = 500;
    public static final int CODE_EMPTY_VIEW = 205;
    public static final int CODE_ANAUTHORIZATION = 401;
    public static final int CODE_FORBIDDEN = 403;


    public static final int CODE_INVALID_INPUT = 1001;
    public static final int CODE_EMAIL_CREATED = 1006;
    public static final int CODE_EMAIL_EXISIT = 1301;
    public static final int CODE_INVALID_CREDENTIAL = 1302;
    public static final int CODE_EMAIL_NOT_VERIFIED = 1303;
    public static final int CODE_INVALID_SOCIAL = 1304;
    public static final int CODE_USER_DONT_EXISIT = 1500;
    public static final int CODE_PASSSWORD_MISMATCH = 1501;
    public static final int CODE_FIREBASE = 1502;
    public static final int CODE_INVALID_MIME = 1503;
    public static final int CODE_FILE_LARGE = 1504;
    public static final int CODE_INVALID_DEVICEID = 1506;


    //Network Error Messages
    public static String UNKNOWN_ERROR_MESSAGE = "Unknown error";

    @IntDef({API_LANDING_STRUCTURE, API_MENU, API_DETAIL,
            API_TRAY, API_CONFIG, API_PREDICTIVE_SEARCH, API_UI_MODEL, API_TRAY_DETAIL, API_TRAY_SEASON, API_VIDEO_URL,
            API_DOWNLOAD_COMPLETE, API_APP_LANGUAGE, API_GET_ACCESS_TOKEN})
    public @interface API {
    }

    public static final int API_LANDING_STRUCTURE = 100;
    public static final int API_MENU = 101;
    public static final int API_DETAIL = 102;
    public static final int API_TRAY = 103;
    public static final int API_CONFIG = 104;
    public static final int API_UI_MODEL = 105;
    public static final int API_FIRST_HIT = 106;
    public static final int API_TRAY_DETAIL = 107;
    public static final int API_TRAY_SEASON = 108;
    public static final int API_VIDEO_URL = 109;
    public static final int API_CONTENT_LANG_GET = 110;
    public static final int API_DEVICE_SIGNUP = 111;
    public static final int API_DEVICE_SIGNIN = 112;
    public static final int API_GET_USER_INFO = 113;
    public static final int API_PREDICTIVE_SEARCH = 114;
    public static final int API_DOWNLOAD_COMPLETE = 115;
    public static final int API_GENRE_GET = 116;
    public static final int API_GENRE_POST = 117;
    public static final int API_LANG_POST = 118;
    public static final int API_BOARD_CONTENT = 119;
    public static final int API_BOARD_CONTENT_POST = 120;
    public static final int API_USER_ANALYTICS = 121;
    public static final int API_USER_ACTION = 122;
    public static final int API_CONTENT_LIKE = 123;
    public static final int API_USER_REGISTER = 124;
    public static final int API_USER_LOGIN = 125;
    public static final int API_PASSWORD_RESET = 126;
    public static final int API_FB_LOGIN = 127;
    public static final int API_GP_LOGIN = 128;
    public static final int API_STATIC_PAGE = 129;
    public static final int API_WATCHLIST_COUNT = 130;
    public static final int API_SUBSCRIBE_PUSHNOTIFICATION = 131;
    public static final int API_UPLOAD_IMAGE = 132;
    public static final int API_UPDATE_USER_INFO = 133;
    public static final int API_CHANGE_PASSWORD = 134;
    public static final int API_SIGNOUT = 135;
    public static final int API_APP_LANGUAGE = 136;
    public static final int API_PLAYBACK_QUALITIES = 137;
    public static final int API_SHARE = 138;
    public static final int API_GET_ACCESS_TOKEN = 139;

}
