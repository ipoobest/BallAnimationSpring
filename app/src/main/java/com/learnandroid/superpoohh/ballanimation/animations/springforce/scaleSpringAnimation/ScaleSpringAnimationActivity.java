package com.learnandroid.superpoohh.ballanimation.animations.springforce.scaleSpringAnimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.learnandroid.superpoohh.ballanimation.R;
import com.learnandroid.superpoohh.ballanimation.animations.springforce.rotationSpringAnimation.RotationSpringAnimation;

import io.github.kbiakov.codeview.CodeView;

public class ScaleSpringAnimationActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    private ImageView animateView;
    private SeekBar sbDamping, sbStiffness;
    private float damping, stiffness;
    private TextView tvDimping, tvStiffness, infor, tvDescription;

    public static float dampingValue, stiffnessValue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scale_spring_animation);

        innitInstances();

        animateView.setImageResource(R.drawable.pokeball);
        ScaleSpringAnimation scaleSpringAnimation =
                new ScaleSpringAnimation(animateView, infor);

    }

    private void innitInstances() {

        animateView = (ImageView) findViewById(R.id.animateView);
        infor = (TextView) findViewById(R.id.information);

        sbDamping = (SeekBar) findViewById(R.id.sb_damping);
        sbStiffness = (SeekBar) findViewById(R.id.sb_stiffness);

        CodeView codeView = (CodeView) findViewById(R.id.code_view);
        codeView.setCode(getString(R.string.listing_scale_spring));

        tvDimping = (TextView) findViewById(R.id.tv_Dimping);
        tvStiffness = (TextView) findViewById(R.id.tv_stiffness);
        tvDescription = (TextView) findViewById(R.id.tv_description);
        tvDescription.setText(R.string.description_scales_spring);

        sbDamping.setOnSeekBarChangeListener(this);
        sbStiffness.setOnSeekBarChangeListener(this);

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if (seekBar == sbDamping) {
            int progressValue = progress;
            if(progressValue != 0){
                dampingValue = (float) (progress / 10.0);
                tvDimping.setText(String.valueOf(dampingValue));
            }else {
                dampingValue = 0.05f;
                tvDimping.setText("0");
            }
        } else if (seekBar == sbStiffness) {
            stiffnessValue = progress;
            tvStiffness.setText(String.valueOf(stiffnessValue));
        }

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
