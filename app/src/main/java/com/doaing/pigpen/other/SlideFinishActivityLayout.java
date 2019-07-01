package com.doaing.pigpen.other;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class SlideFinishActivityLayout extends LinearLayout {

    private float lastPointX;
    private ViewGroup mParentView;
    private int windowSize;
    private int maxSlideSize;
    private int tranX;

    public SlideFinishActivityLayout(Context context) {
        super(context);
    }

    public SlideFinishActivityLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        if (changed) {
            mParentView = (ViewGroup) this.getParent();
            windowSize = this.getWidth();
            maxSlideSize = windowSize / 3;
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            lastPointX = ev.getX();
            return true;
        } else if (ev.getAction() == MotionEvent.ACTION_MOVE) {
            float changeX = ev.getX() - lastPointX;
            if (changeX >= 0) {
                tranX += changeX;
                mParentView.scrollBy((int) -changeX, 0);
            }
            return true;
        } else if (ev.getAction() == MotionEvent.ACTION_UP) {

            if (tranX >= maxSlideSize) {
                moveEnd(ev.getX());
            } else {
                moveStart(tranX);
            }
            return true;

        }
        return super.dispatchTouchEvent(ev);
    }

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
        objectAnimator.setDuration(200).start();//1 操纵的对象 2 所需要操纵的对象属性 3 动画变化的范围
    }

    public void moveStart(float tranX) {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(this, "translationX", 0, -tranX);
        objectAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        objectAnimator.setDuration(200).start();//1 操纵的对象 2 所需要操纵的对象属性 3 动画变化的范围
    }
}
