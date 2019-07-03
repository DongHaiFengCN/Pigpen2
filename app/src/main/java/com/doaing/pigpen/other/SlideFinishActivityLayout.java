package com.doaing.pigpen.other;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class SlideFinishActivityLayout extends LinearLayout {


    private int windowSize;
    private int maxSlideSize;
    private int lastX;

    private int totalDistance;

    public SlideFinishActivityLayout(Context context) {
        super(context);
    }

    public SlideFinishActivityLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        windowSize = this.getWidth();
        maxSlideSize = windowSize / 3;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastX = (int) event.getRawX();
                break;
            case MotionEvent.ACTION_MOVE:
                int offX = (int) (event.getRawX() - lastX);
                if (offX >= 0) {
                    ((View) getParent()).scrollTo(-offX, 0);
                } else {
                    ((View) getParent()).scrollTo(0, 0);
                }
                break;
            case MotionEvent.ACTION_UP:

                int move = (int) (event.getRawX() - lastX);
                if (move <= maxSlideSize) {

                    ((View) getParent()).scrollTo(0, 0);

                } else {
                    ((View) getParent()).scrollTo(-windowSize, 0);
                    Activity activity = (Activity) getContext();
                    activity.finish();
                }


                break;

        }

        return true;
    }
/*
    public void moveEnd(float tranX) {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(this, "translationX", tranX, windowSize);
        objectAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Log.e("DOAING", "结束");
                Activity activity = (Activity) getContext();
                activity.finish();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        objectAnimator.setDuration(500).start();//1 操纵的对象 2 所需要操纵的对象属性 3 动画变化的范围
    }*/
}
