package com.doaing.pigpen.other;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.doaing.pigpen.R;

import org.jetbrains.annotations.NotNull;

public class SlideFinishActivityLayout extends LinearLayout {


    private ViewDragHelper mViewDragHelper;

    private int endX;
    private Context context;

    public SlideFinishActivityLayout(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public SlideFinishActivityLayout(Context context, AttributeSet attrs) {

        super(context, attrs);
        this.context = context;
    }

    private void init() {

        mViewDragHelper = ViewDragHelper.create(this, 1f, new ViewDragHelper.Callback() {
            @Override
            public boolean tryCaptureView(@NonNull View view, int i) {
                return true;
            }

            /**
             * 水平 拖动
             * @param child 拖动的元素
             * @param left 将要去往的位置
             * @param dx 拖动了的距离
             * @return 新位置
             */
            @Override
            public int clampViewPositionHorizontal(@NotNull View child, int left, int dx) {

                Log.e("DOAING", "水平：" + left);
                //限制在容器内
                int leftBound = getPaddingLeft();

                endX = Math.max(left, leftBound);
                return endX;
            }

            //纵向的注释就不写了 自己体会
            @Override
            public int clampViewPositionVertical(View child, int top, int dy) {
                Log.e("DOAING", "垂直：" + top);
                return 0;
            }

            /**
             * 当 view 的 position发生改变时触发
             * @param changedView 拖动的view
             * @param left 新位置 X轴
             * @param top 新位置 Y轴
             * @param dx 从上次位置 到这次位置移动的距离 X轴
             * @param dy 从上次位置 到这次位置移动的距离 Y轴
             */
            @Override
            public void onViewPositionChanged(View changedView, int left, int top, int dx, int dy) {

                Log.e("DOAING", "left " + left + " top " + top + " dx " + dx + " dy " + dy);
            }

            /**
             *
             * @param releasedChild
             * @param xvel x 轴速度  每秒移动的像素值
             * @param yvel Y 轴速度 每秒移动的像素值
             */
            @Override
            public void onViewReleased(@NotNull View releasedChild, float xvel, float yvel) {


                if (endX > getWidth()/3) {

                    ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(releasedChild, "translationX", 0, getWidth() - endX);
                    objectAnimator.addListener(new Animator.AnimatorListener() {
                        @Override
                        public void onAnimationStart(Animator animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animator animation) {

                            Activity activity = (Activity) context;
                            activity.finish();

                        }

                        @Override
                        public void onAnimationCancel(Animator animation) {

                        }

                        @Override
                        public void onAnimationRepeat(Animator animation) {

                        }
                    });
                    objectAnimator.setDuration(100).start();//1 操纵的对象 2 所需要操纵的对象属性 3 动画变化的范围

                } else {

                    mViewDragHelper.settleCapturedViewAt(0, 0);
                    ViewCompat.postInvalidateOnAnimation(SlideFinishActivityLayout.this);
                }


            }
        });
    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return mViewDragHelper.shouldInterceptTouchEvent(ev);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mViewDragHelper.processTouchEvent(event);
        return true;
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        init();
    }

    /**
     * 因为要在 DragHelper的中使用动画
     */
    @Override
    public void computeScroll() {
        super.computeScroll();
        if (mViewDragHelper.continueSettling(true)) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

}
