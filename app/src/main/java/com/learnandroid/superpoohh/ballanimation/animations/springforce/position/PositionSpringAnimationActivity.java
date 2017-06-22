package com.learnandroid.superpoohh.ballanimation.animations.springforce.position;

import android.animation.ObjectAnimator;
import android.os.Handler;
import android.support.animation.DynamicAnimation;
import android.support.animation.SpringAnimation;
import android.support.animation.SpringForce;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialogFragment;
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

public class PositionSpringAnimationActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener, View.OnClickListener {

    private ImageView animateView;
    private SeekBar sbDamping, sbStiffness;
    private BottomSheetDialogFragment dialogBottomSheet;
    private TextView tvDamping, tvStiffness, tvDescription;
    private Button btnShowCode;
    private View layoutBottom;
    private CodeView codevRotation;
    private BottomSheetBehavior bottomSheetBehavior;
    private PositionSpringAnimation positionSpringAnimation;

    private SpringAnimation springAnimation, positionX, positionY;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_position_spring_animation);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initInstance();
        demoAnimation();
    }

    private void demoAnimation() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
//                positionX = createSpringAnimation(animateView,
//                        SpringAnimation.TRANSLATION_X, 150f,
//                        500, 0.2f);
                positionY = createSpringAnimation(animateView,
                        SpringAnimation.TRANSLATION_Y, 200f,
                        100, 0.3f);
//                positionX.start();
                positionY.start();
            }
        }, 1500);

    }


    private void initInstance() {

        animateView = (ImageView) findViewById(R.id.animateView);

        sbDamping = (SeekBar) findViewById(R.id.sb_damping);
        sbStiffness = (SeekBar) findViewById(R.id.sb_stiffness);
        btnShowCode = (Button) findViewById(R.id.dialogBottom);
        btnShowCode.setOnClickListener(this);

        layoutBottom = findViewById(R.id.btms_code);

        codevRotation = (CodeView) findViewById(R.id.code_view);
        codevRotation.setCode(getString(R.string.listing_position_spring));
        bottomSheetBehavior = BottomSheetBehavior.from(layoutBottom);

        tvDamping = (TextView) findViewById(R.id.tv_Dimping);
        tvStiffness = (TextView) findViewById(R.id.tv_stiffness);
        tvDescription = (TextView) findViewById(R.id.tv_description);
        tvDescription.setText("Position Animation code");

        sbDamping.setOnSeekBarChangeListener(this);
        sbStiffness.setOnSeekBarChangeListener(this);


        animateView.setImageResource(R.drawable.pokeball);
        positionSpringAnimation = new PositionSpringAnimation(animateView);

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if (seekBar == sbDamping) {
            float dampingValue;
            if (progress != 0) {
                dampingValue = (float) (progress / 10.0);
                tvDamping.setText(String.valueOf(dampingValue));
            } else {
                dampingValue = 0.05f;
                tvDamping.setText("0");
            }
            positionSpringAnimation.setDampingValue(dampingValue);
        } else if (seekBar == sbStiffness) {
            float stiffnessValue;
            stiffnessValue = progress;
            positionSpringAnimation.setStiffnessValue(stiffnessValue);
            tvStiffness.setText(String.valueOf(stiffnessValue));
        }


    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

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
    public void onClick(View v) {
        if (bottomSheetBehavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        } else {
            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        }
    }


}
