package com.learnandroid.superpoohh.ballanimation.animations.springforce.rotation;

import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.learnandroid.superpoohh.ballanimation.R;

import io.github.kbiakov.codeview.CodeView;

public class RotationSpringAnimationActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener, View.OnClickListener {

    private ImageView ivAnimateRotation;
    private SeekBar sbDamping, sbStiffness;
    private TextView tvDimping, tvStiffness, tvInformation, tvDescription;
    private BottomSheetDialogFragment dialogBottomSheet;
    private Button btnShowCode;
    private View layoutBottom;
    private CodeView codevRotation;

    private BottomSheetBehavior bottomSheetBehavior;
    RotationSpringAnimation rotationSpringAnimation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotation_spring_animation);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initInstances();
        ivAnimateRotation.setImageResource(R.drawable.pokeball);
        rotationSpringAnimation = new RotationSpringAnimation(ivAnimateRotation, tvInformation);
    }


    private void initInstances() {
        ivAnimateRotation = (ImageView) findViewById(R.id.animateView);
        tvInformation = (TextView) findViewById(R.id.information);

        sbDamping = (SeekBar) findViewById(R.id.sb_damping);
        sbStiffness = (SeekBar) findViewById(R.id.sb_stiffness);

        btnShowCode = (Button) findViewById(R.id.dialogBottom);
        btnShowCode.setOnClickListener(this);

        tvDimping = (TextView) findViewById(R.id.tv_Dimping);
        tvStiffness = (TextView) findViewById(R.id.tv_stiffness);

        sbDamping.setOnSeekBarChangeListener(this);
        sbStiffness.setOnSeekBarChangeListener(this);
        layoutBottom = findViewById(R.id.btms_code);

        codevRotation = (CodeView) findViewById(R.id.code_view);
        codevRotation.setCode(getString(R.string.listing_rotation_spring));
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
            rotationSpringAnimation.setDampingValue(dampingValue);
        } else if (seekBar == sbStiffness) {
            float stiffnessValue;
            stiffnessValue = progress;
            rotationSpringAnimation.setStiffnessValue(stiffnessValue);
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