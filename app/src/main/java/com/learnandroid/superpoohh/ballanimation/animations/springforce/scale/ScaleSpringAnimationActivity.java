package com.learnandroid.superpoohh.ballanimation.animations.springforce.scale;

import android.os.Handler;
import android.support.animation.SpringAnimation;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.learnandroid.superpoohh.ballanimation.R;

import io.github.kbiakov.codeview.CodeView;

import static com.learnandroid.superpoohh.ballanimation.animations.SpringAnimationUtil.createSpringAnimation;

public class ScaleSpringAnimationActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener, View.OnClickListener {

    private ImageView animateView;
    private SeekBar sbDamping, sbStiffness;
    private TextView tvDimping, tvStiffness, infor, tvDescription;
    SpringAnimation scaleXAnimation;
    SpringAnimation scaleYAnimation;
    ScaleSpringAnimation scaleSpringAnimation;
    private View layoutBottom;
    private CodeView codevRotation;
    private Button btnShowCode;
    private BottomSheetBehavior bottomSheetBehavior;
    private float dampingRadio = 0.1f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scale_spring_animation);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        innitInstances();
        demoAnimation();
        animateView.setImageResource(R.drawable.pokeball);
        scaleSpringAnimation =
                new ScaleSpringAnimation(animateView, infor);

    }

    private void demoAnimation() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // create scaleX and scaleY animations
                scaleXAnimation = createSpringAnimation(animateView, SpringAnimation.SCALE_X,
                        2f, 200f, 0.1f);
                scaleYAnimation = createSpringAnimation(animateView, SpringAnimation.SCALE_Y,
                        2f, 1000f, 0.1f);
                scaleXAnimation.start();
                scaleYAnimation.start();
            }
        }, 1500);
    }

    private void innitInstances() {

        animateView = (ImageView) findViewById(R.id.animateView);
        infor = (TextView) findViewById(R.id.information);

        sbDamping = (SeekBar) findViewById(R.id.sb_damping);
        sbStiffness = (SeekBar) findViewById(R.id.sb_stiffness);

        btnShowCode = (Button) findViewById(R.id.dialogBottom);
        btnShowCode.setOnClickListener(this);


        tvDimping = (TextView) findViewById(R.id.tv_Dimping);
        tvStiffness = (TextView) findViewById(R.id.tv_stiffness);
        tvDescription = (TextView) findViewById(R.id.tv_description);
        tvDescription.setText("Scale Animation code");

        sbDamping.setOnSeekBarChangeListener(this);
        sbStiffness.setOnSeekBarChangeListener(this);
        layoutBottom = findViewById(R.id.btms_code);

        codevRotation = (CodeView) findViewById(R.id.code_view);
        codevRotation.setCode(getString(R.string.listing_scale_spring));
        bottomSheetBehavior = BottomSheetBehavior.from(layoutBottom);

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if (seekBar == sbDamping) {
            float dampingValue;
            if (progress != 0) {
                dampingValue = (float) (progress / 10.0);
                tvDimping.setText(String.valueOf(dampingValue));
            } else {
                dampingValue = 0.05f;
                tvDimping.setText("0");
            }
            scaleSpringAnimation.setDampingValue(dampingValue);
        } else if (seekBar == sbStiffness) {
            float stiffnessValue;
            stiffnessValue = progress;
            scaleSpringAnimation.setStiffnessValue(stiffnessValue);
            tvStiffness.setText(String.valueOf(stiffnessValue));
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onClick(View v) {
        if (v == btnShowCode) {
            if (bottomSheetBehavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            } else {
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            }
        }

    }
}
