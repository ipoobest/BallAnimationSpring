package com.learnandroid.superpoohh.ballanimation.model;

import android.content.Intent;

/**
 * Created by superpoohh on 6/6/2017.
 */

public class AnimationItem {
    private  String mTitle;
    private  Intent mIntent;

    public AnimationItem(String title, android.content.Intent intent) {
        mTitle = title;
        mIntent = intent;
    }

    public android.content.Intent getIntent() {
        return mIntent;
    }

    public String getTitle() {
        return mTitle;
    }
}
