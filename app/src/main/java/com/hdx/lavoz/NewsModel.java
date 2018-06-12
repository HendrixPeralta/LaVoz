package com.hdx.lavoz;

class NewsModel {

    private String mUserName, mPostTitle, mPostDate, mPostCategory, mPostdescription;
    private int mPostImage;

    public NewsModel(String mUserName, String mPostTitle, String mPostDate, String mPostCategory, String mPostdescription, int mPostImage) {
        this.mUserName = mUserName;
        this.mPostTitle = mPostTitle;
        this.mPostDate = mPostDate;
        this.mPostCategory = mPostCategory;
        this.mPostdescription = mPostdescription;
        this.mPostImage = mPostImage;
    }

    public String getmUserName() {
        return mUserName;
    }

    public void setmUserName(String mUserName) {
        this.mUserName = mUserName;
    }

    public String getmPostTitle() {
        return mPostTitle;
    }

    public void setmPostTitle(String mPostTitle) {
        this.mPostTitle = mPostTitle;
    }

    public String getmPostDate() {
        return mPostDate;
    }

    public void setmPostDate(String mPostDate) {
        this.mPostDate = mPostDate;
    }

    public String getmPostCategory() {
        return mPostCategory;
    }

    public void setmPostCategory(String mPostCategory) {
        this.mPostCategory = mPostCategory;
    }

    public String getmPostdescription() {
        return mPostdescription;
    }

    public void setmPostdescription(String mPostdescription) {
        this.mPostdescription = mPostdescription;
    }

    public int getmPostImage() {
        return mPostImage;
    }

    public void setmPostImage(int mPostImage) {
        this.mPostImage = mPostImage;
    }
}
