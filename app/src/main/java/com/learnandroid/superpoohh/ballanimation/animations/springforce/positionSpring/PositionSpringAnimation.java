package com.learnandroid.superpoohh.ballanimation.animations.springforce.positionSpring;

import android.support.animation.SpringAnimation;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;

import com.learnandroid.superpoohh.ballanimation.animations.SpringAnimationUtil;

/**
 * Created by superpoohh on 6/13/2017.
 */

public class PositionSpringAnimation {
    private View animatedView;

    private float dampingValue = 0.1f, stiffnessValue = 100f;
    private SpringAnimation xAnimation;
    private SpringAnimation yAnimation;

    private float dX;
    private float dY;

    public PositionSpringAnimation(final View animatedView) {
        if (animatedView != null) {
            this.animatedView = animatedView;
            animatedView.getViewTreeObserver().addOnGlobalLayoutListener(globalLayoutListener);
            this.animatedView.setOnTouchListener(touchListener);
        }
    }

    public void setDampingValue(float dampingValue) {
        this.dampingValue = dampingValue;
    }

    public void setStiffnessValue(float stiffnessValue) {
        this.stiffnessValue = stiffnessValue;
    }

    // create X and Y animations for view's initial position once it's known
    private ViewTreeObserver.OnGlobalLayoutListener globalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() {
        @Override
        public void onGlobalLayout() {
            xAnimation = SpringAnimationUtil.createSpringAnimation(animatedView, SpringAnimation.X, animatedView.getX(),
                    stiffnessValue, dampingValue);
            yAnimation = SpringAnimationUtil.createSpringAnimation(animatedView, SpringAnimation.Y, animatedView.getY(),
                    stiffnessValue, dampingValue);
        }
    };


    private View.OnTouchListener touchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getActionMasked()) {
                case MotionEvent.ACTION_DOWN:
                    // capture the difference between view's top left corner and touch point
                    dX = v.getX() - event.getRawX();
                    dY = v.getY() - event.getRawY();
                    // cancel animations
                    xAnimation.cancel();
                    yAnimation.cancel();
                    break;
                case MotionEvent.ACTION_MOVE:
                    //  a different approach would be to change the view's LayoutParams.
                    animatedView.animate()
                            .x(event.getRawX() + dX)
                            .y(event.getRawY() + dY)
                            .setDuration(0)
                            .start();
                    break;
                case MotionEvent.ACTION_UP:
                    xAnimation.start();
                    yAnimation.start();
                    break;
            }
            return true;
        }
    };
}
