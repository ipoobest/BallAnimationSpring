package com.learnandroid.superpoohh.ballanimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import io.github.kbiakov.codeview.CodeView;

/**
 * ถ้าไม่ได้ใช้ก็ลบออก
 */
@Deprecated
public class CodeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code);

        CodeView codeView = (CodeView) findViewById(R.id.code_view);
        codeView.setCode(getString(R.string.listing_position_spring));
    }
}
