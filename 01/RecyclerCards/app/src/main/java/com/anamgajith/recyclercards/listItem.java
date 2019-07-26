package com.anamgajith.recyclercards;

public class listItem {
    private int mImageId;
    private String mText;

    public listItem(int mImageId, String mText) {
        this.mImageId = mImageId;
        this.mText = mText;
    }

    public int getmImageId() {
        return mImageId;
    }

    public String getmText() {
        return mText;
    }
}
