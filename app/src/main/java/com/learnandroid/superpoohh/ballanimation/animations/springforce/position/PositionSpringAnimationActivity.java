package com.learnandroid.superpoohh.ballanimation.animations.springforce.position;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.learnandroid.superpoohh.ballanimation.R;

import hugo.weaving.DebugLog;

@DebugLog
public class PositionSpringAnimationActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {
    private ImageView animateView;
    private SeekBar sbDamping, sbStiffness;
    private Button dialogDescription;
    private TextView tvDamping, tvStiffness, tvDescription;

    private float damping, stiffness;

    private PositionSpringAnimation positionSpringAnimation;
//    BottomSheetDialogFragment BottomSheet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_position_spring_animation);

        innitInstance();
    }

    private void innitInstance() {

        animateView = (ImageView) findViewById(R.id.animateView);

        sbDamping = (SeekBar) findViewById(R.id.sb_damping);
        sbStiffness = (SeekBar) findViewById(R.id.sb_stiffness);

        tvDamping = (TextView) findViewById(R.id.tv_Dimping);
        tvStiffness = (TextView) findViewById(R.id.tv_stiffness);
        tvDescription = (TextView) findViewById(R.id.tv_description);
        tvDescription.setText(R.string.description_position_spring);


        sbDamping.setOnSeekBarChangeListener(this);
        sbStiffness.setOnSeekBarChangeListener(this);


//        CodeView codeView = (CodeView) findViewById(R.id.code_view);
//        codeView.setCode(getString(R.string.listing_position_spring));


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


}
