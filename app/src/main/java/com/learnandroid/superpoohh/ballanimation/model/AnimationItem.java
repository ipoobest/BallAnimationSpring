package com.learnandroid.superpoohh.ballanimation.model;

import android.content.Intent;

/**
 * Created by superpoohh on 6/6/2017.
 */

public class AnimationItem {
    private String mTitle, mDescription;
    private Intent mIntent;

    public AnimationItem(String title, String Description,Intent intent) {
        mTitle = title;
        mIntent = intent;
        mDescription = Description;
    }

    public android.content.Intent getIntent() {
        return mIntent;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getDescription() {
        return mDescription;
    }
}
