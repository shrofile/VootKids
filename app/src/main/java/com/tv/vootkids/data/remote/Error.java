package com.tv.vootkids.data.remote;

public class Error {

    private int mCode;
    private String mApiMessage;

    private String mUiMessage;
    private String mTitle;


    public Error(int code) {
        mCode = code;
    }



    public Error(int code, String apiMessage) {
        this.mCode = code;
        this.mApiMessage = apiMessage;
    }


    public Error() {

    }

    public int getmCode() {
        return mCode;
    }

    public void setmCode(int mCode) {
        this.mCode = mCode;
    }

    public String getmApiMessage() {
        return mApiMessage;
    }

    public void setmApiMessage(String mApiMessage) {
        this.mApiMessage = mApiMessage;
    }


    public String getmUiMessage() {
        return mUiMessage;
    }

    public void setmUiMessage(String mUiMessage) {
        this.mUiMessage = mUiMessage;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public int getCode() {
        return mCode;
    }

    public void setCode(int code) {
        this.mCode = code;
    }

    public void setApiMessage(String apiMessage) {
        this.mApiMessage = apiMessage;
    }



}
