package com.learnandroid.superpoohh.ballanimation.animations.springforce.rotation;

import android.support.animation.DynamicAnimation;
import android.support.animation.SpringAnimation;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

import static com.learnandroid.superpoohh.ballanimation.animations.SpringAnimationUtil.createSpringAnimation;

/**
 * Created by superpoohh on 6/14/2017.
 */

public class RotationSpringAnimation {

    private static final float INITIAL_ROTATION = 0f;

    private float dampingValue = 0.1f, stiffnessValue = 100f;
    private SpringAnimation rotationAnimation;
    private float previousRotation;
    private float currentRotation ;
    private View animateView;
    private TextView infoView;

    public void setDampingValue(float dampingValue) {
        this.dampingValue = dampingValue;
    }

    public void setStiffnessValue(float stiffnessValue) {
        this.stiffnessValue = stiffnessValue;
    }

    public RotationSpringAnimation(ImageView animateView, TextView infoView) {
        // create a rotation SpringAnimation
        rotationAnimation = createSpringAnimation(animateView,
                SpringAnimation.ROTATION, INITIAL_ROTATION,
                stiffnessValue, dampingValue);
        this.infoView = infoView;
        this.animateView = animateView;
        this.animateView.setOnTouchListener(touchListener);
        rotationAnimation.addUpdateListener(updateListener);
        updateInfoView();
    }

    public View.OnTouchListener getTouchListener() {
        return touchListener;
    }

    private View.OnTouchListener touchListener = new View.OnTouchListener() {
        double centerX;
        double centerY;
        float x;
        float y;
        // angle calculation
        private void updateRotation(View view){
            currentRotation = view.getRotation() +
                    (float) Math.toDegrees(Math.atan2(x - centerX, centerY - y));
        }
        @Override
        public boolean onTouch(View view, MotionEvent event) {
            centerX = view.getWidth() / 2.0;
            centerY = view.getHeight() / 2.0;
            x = event.getX();
            y = event.getY();
            switch (event.getActionMasked()) {
                case MotionEvent.ACTION_DOWN:
                    // cancel so we can grab the view during previous animation
                    rotationAnimation.cancel();
                    updateRotation(view);
                    break;
                case MotionEvent.ACTION_MOVE:
                    // save current rotation
                    previousRotation = currentRotation;
                    updateRotation(view);
                    // rotate view by angle difference
                    float angle = currentRotation - previousRotation;
                    view.setRotation(view.getRotation() + angle);// += angle;
                    updateInfoView();
                    break;
                case MotionEvent.ACTION_UP:
                    rotationAnimation.start();
                    break;
            }
            return true;
        }
    };

    private DynamicAnimation.OnAnimationUpdateListener updateListener = new DynamicAnimation.OnAnimationUpdateListener() {
        @Override
        public void onAnimationUpdate(DynamicAnimation animation, float value, float velocity) {
            updateInfoView();
        }
    };

    public void updateInfoView(){
        if (animateView != null && infoView != null) {
            infoView.setText(String.format(Locale.getDefault(), "%.2f", animateView.getRotation()));
        }
    }
}
