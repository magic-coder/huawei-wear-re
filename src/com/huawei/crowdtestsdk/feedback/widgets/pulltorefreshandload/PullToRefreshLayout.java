package com.huawei.crowdtestsdk.feedback.widgets.pulltorefreshandload;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.volley.DefaultRetryPolicy;
import com.huawei.crowdtestsdk.utils.ResUtil;
import com.huawei.uploadlog.p188c.C2511g;
import java.util.Timer;
import java.util.TimerTask;

public class PullToRefreshLayout extends RelativeLayout {
    public static final int DONE = 5;
    public static final int FAIL = 1;
    public static final int INIT = 0;
    public static final int LOADING = 4;
    public static final int REFRESHING = 2;
    public static final int RELEASE_TO_LOAD = 3;
    public static final int RELEASE_TO_REFRESH = 1;
    public static final int SUCCEED = 0;
    public static final String TAG = "PullToRefreshLayout";
    public float MOVE_SPEED = 8.0f;
    private boolean canPullDown = true;
    private boolean canPullUp = true;
    private float downY;
    private boolean isLayout = false;
    private boolean isTouch = false;
    private float lastY;
    private View loadStateImageView;
    private TextView loadStateTextView;
    private View loadingView;
    private float loadmoreDist = 200.0f;
    private View loadmoreView;
    private Context mContext;
    private int mEvents;
    private OnRefreshListener mListener;
    public float pullDownY = 0.0f;
    private View pullUpView;
    private float pullUpY = 0.0f;
    private View pullView;
    private View pullableView;
    private float radio = 2.0f;
    private float refreshDist = 200.0f;
    private View refreshStateImageView;
    private TextView refreshStateTextView;
    private View refreshView;
    private RotateAnimation refreshingAnimation;
    private View refreshingView;
    private RotateAnimation rotateAnimation;
    private RotateAnimation rotateAnimationBack;
    private int state = 0;
    private MyTimer timer;
    private Handler updateHandler = new C07531();

    public interface OnRefreshListener {
        void onLoadMore(PullToRefreshLayout pullToRefreshLayout);

        void onRefresh(PullToRefreshLayout pullToRefreshLayout);
    }

    class C07531 extends Handler {
        C07531() {
        }

        public void handleMessage(Message message) {
            PullToRefreshLayout.this.MOVE_SPEED = (float) (8.0d + (5.0d * Math.tan((1.5707963267948966d / ((double) PullToRefreshLayout.this.getMeasuredHeight())) * ((double) (PullToRefreshLayout.this.pullDownY + Math.abs(PullToRefreshLayout.this.pullUpY))))));
            if (!PullToRefreshLayout.this.isTouch) {
                if (PullToRefreshLayout.this.state == 2 && PullToRefreshLayout.this.pullDownY <= PullToRefreshLayout.this.refreshDist) {
                    PullToRefreshLayout.this.pullDownY = PullToRefreshLayout.this.refreshDist;
                    PullToRefreshLayout.this.timer.cancel();
                } else if (PullToRefreshLayout.this.state == 4 && (-PullToRefreshLayout.this.pullUpY) <= PullToRefreshLayout.this.loadmoreDist) {
                    PullToRefreshLayout.this.pullUpY = -PullToRefreshLayout.this.loadmoreDist;
                    PullToRefreshLayout.this.timer.cancel();
                }
            }
            if (PullToRefreshLayout.this.pullDownY > 0.0f) {
                PullToRefreshLayout pullToRefreshLayout = PullToRefreshLayout.this;
                pullToRefreshLayout.pullDownY -= PullToRefreshLayout.this.MOVE_SPEED;
            } else if (PullToRefreshLayout.this.pullUpY < 0.0f) {
                PullToRefreshLayout.this.pullUpY = PullToRefreshLayout.this.pullUpY + PullToRefreshLayout.this.MOVE_SPEED;
            }
            if (PullToRefreshLayout.this.pullDownY < 0.0f) {
                PullToRefreshLayout.this.pullDownY = 0.0f;
                PullToRefreshLayout.this.pullView.clearAnimation();
                if (!(PullToRefreshLayout.this.state == 2 || PullToRefreshLayout.this.state == 4)) {
                    PullToRefreshLayout.this.changeState(0);
                }
                PullToRefreshLayout.this.timer.cancel();
                PullToRefreshLayout.this.requestLayout();
            }
            if (PullToRefreshLayout.this.pullUpY > 0.0f) {
                PullToRefreshLayout.this.pullUpY = 0.0f;
                PullToRefreshLayout.this.pullUpView.clearAnimation();
                if (!(PullToRefreshLayout.this.state == 2 || PullToRefreshLayout.this.state == 4)) {
                    PullToRefreshLayout.this.changeState(0);
                }
                PullToRefreshLayout.this.timer.cancel();
                PullToRefreshLayout.this.requestLayout();
            }
            C2511g.m12481b("BETACLUB_SDK", "[PullToRefreshLayout.updateHandler]handle message!");
            PullToRefreshLayout.this.requestLayout();
            if (PullToRefreshLayout.this.pullDownY + Math.abs(PullToRefreshLayout.this.pullUpY) == 0.0f) {
                PullToRefreshLayout.this.timer.cancel();
            }
        }
    }

    class C07542 extends Handler {
        C07542() {
        }

        public void handleMessage(Message message) {
            PullToRefreshLayout.this.changeState(5);
            PullToRefreshLayout.this.hide();
        }
    }

    class C07553 extends Handler {
        C07553() {
        }

        public void handleMessage(Message message) {
            PullToRefreshLayout.this.changeState(5);
            PullToRefreshLayout.this.hide();
        }
    }

    class AutoRefreshAndLoadTask extends AsyncTask<Integer, Float, String> {
        private AutoRefreshAndLoadTask() {
        }

        protected String doInBackground(Integer... numArr) {
            while (PullToRefreshLayout.this.pullDownY < DefaultRetryPolicy.DEFAULT_BACKOFF_MULT * PullToRefreshLayout.this.refreshDist) {
                PullToRefreshLayout pullToRefreshLayout = PullToRefreshLayout.this;
                pullToRefreshLayout.pullDownY += PullToRefreshLayout.this.MOVE_SPEED;
                publishProgress(new Float[]{Float.valueOf(PullToRefreshLayout.this.pullDownY)});
                try {
                    Thread.sleep((long) numArr[0].intValue());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        protected void onPostExecute(String str) {
            PullToRefreshLayout.this.changeState(2);
            if (PullToRefreshLayout.this.mListener != null) {
                PullToRefreshLayout.this.mListener.onRefresh(PullToRefreshLayout.this);
            }
            PullToRefreshLayout.this.hide();
        }

        protected void onProgressUpdate(Float... fArr) {
            if (PullToRefreshLayout.this.pullDownY > PullToRefreshLayout.this.refreshDist) {
                PullToRefreshLayout.this.changeState(1);
            }
            PullToRefreshLayout.this.requestLayout();
        }
    }

    class MyTimer {
        private Handler handler;
        private MyTask mTask;
        private Timer timer = new Timer();

        class MyTask extends TimerTask {
            private Handler handler;

            public MyTask(Handler handler) {
                this.handler = handler;
            }

            public void run() {
                this.handler.obtainMessage().sendToTarget();
            }
        }

        public MyTimer(Handler handler) {
            this.handler = handler;
        }

        public void schedule(long j) {
            if (this.mTask != null) {
                this.mTask.cancel();
                this.mTask = null;
            }
            this.mTask = new MyTask(this.handler);
            this.timer.schedule(this.mTask, 0, j);
        }

        public void cancel() {
            if (this.mTask != null) {
                this.mTask.cancel();
                this.mTask = null;
            }
        }
    }

    public PullToRefreshLayout(Context context) {
        super(context);
        initView(context);
    }

    public PullToRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView(context);
    }

    public PullToRefreshLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView(context);
    }

    private void initView(Context context) {
        this.mContext = context;
        this.timer = new MyTimer(this.updateHandler);
        this.rotateAnimation = (RotateAnimation) AnimationUtils.loadAnimation(context, ResUtil.getResId(context, "sdk_crowdtest_reverse_anim", ResUtil.TYPE_ANIM));
        this.rotateAnimationBack = (RotateAnimation) AnimationUtils.loadAnimation(context, ResUtil.getResId(context, "sdk_crowdtest_reverse_anim_back", ResUtil.TYPE_ANIM));
        this.refreshingAnimation = (RotateAnimation) AnimationUtils.loadAnimation(context, ResUtil.getResId(context, "sdk_crowdtest_rotating", ResUtil.TYPE_ANIM));
        Interpolator linearInterpolator = new LinearInterpolator();
        this.rotateAnimation.setInterpolator(linearInterpolator);
        this.rotateAnimationBack.setInterpolator(linearInterpolator);
        this.refreshingAnimation.setInterpolator(linearInterpolator);
    }

    private void initView() {
        this.pullView = this.refreshView.findViewById(ResUtil.getResId(this.mContext, "sdk_crowdtest_pull_icon", "id"));
        this.refreshStateTextView = (TextView) this.refreshView.findViewById(ResUtil.getResId(this.mContext, "sdk_crowdtest_state_tv", "id"));
        this.refreshingView = this.refreshView.findViewById(ResUtil.getResId(this.mContext, "sdk_crowdtest_refreshing_icon", "id"));
        this.refreshStateImageView = this.refreshView.findViewById(ResUtil.getResId(this.mContext, "sdk_crowdtest_state_iv", "id"));
        this.pullUpView = this.loadmoreView.findViewById(ResUtil.getResId(this.mContext, "sdk_crowdtest_pullup_icon", "id"));
        this.loadStateTextView = (TextView) this.loadmoreView.findViewById(ResUtil.getResId(this.mContext, "sdk_crowdtest_loadstate_tv", "id"));
        this.loadingView = this.loadmoreView.findViewById(ResUtil.getResId(this.mContext, "sdk_crowdtest_loading_icon", "id"));
        this.loadStateImageView = this.loadmoreView.findViewById(ResUtil.getResId(this.mContext, "sdk_crowdtest_loadstate_iv", "id"));
    }

    private void hide() {
        this.timer.schedule(5);
    }

    public void refreshFinish(int i) {
        this.refreshingView.clearAnimation();
        this.refreshingView.setVisibility(8);
        switch (i) {
            case 0:
                this.refreshStateImageView.setVisibility(0);
                this.refreshStateTextView.setText(ResUtil.getResId(this.mContext, "sdk_crowdtest_refresh_succeed", ResUtil.TYPE_STRING));
                this.refreshStateImageView.setBackgroundResource(ResUtil.getResId(this.mContext, "sdk_crowdtest_refresh_succeed", ResUtil.TYPE_DRAWABLE));
                break;
            default:
                this.refreshStateImageView.setVisibility(0);
                this.refreshStateTextView.setText(ResUtil.getResId(this.mContext, "sdk_crowdtest_refresh_fail", ResUtil.TYPE_STRING));
                this.refreshStateImageView.setBackgroundResource(ResUtil.getResId(this.mContext, "sdk_crowdtest_refresh_failed", ResUtil.TYPE_DRAWABLE));
                break;
        }
        if (this.pullDownY > 0.0f) {
            new C07542().sendEmptyMessageDelayed(0, 1000);
            return;
        }
        changeState(5);
        hide();
    }

    public void loadMoreFinish(int i) {
        this.loadingView.clearAnimation();
        this.loadingView.setVisibility(8);
        switch (i) {
            case 0:
                this.loadStateImageView.setVisibility(0);
                this.loadStateTextView.setText(ResUtil.getResId(this.mContext, "sdk_crowdtest_load_succeed", ResUtil.TYPE_STRING));
                this.loadStateImageView.setBackgroundResource(ResUtil.getResId(this.mContext, "sdk_crowdtest_load_succeed", ResUtil.TYPE_DRAWABLE));
                break;
            default:
                this.loadStateImageView.setVisibility(0);
                this.loadStateTextView.setText(ResUtil.getResId(this.mContext, "sdk_crowdtest_load_fail", ResUtil.TYPE_STRING));
                this.loadStateImageView.setBackgroundResource(ResUtil.getResId(this.mContext, "sdk_crowdtest_load_failed", ResUtil.TYPE_DRAWABLE));
                break;
        }
        if (this.pullUpY < 0.0f) {
            new C07553().sendEmptyMessageDelayed(0, 1000);
            return;
        }
        changeState(5);
        hide();
    }

    private void changeState(int i) {
        this.state = i;
        switch (this.state) {
            case 0:
                this.refreshStateImageView.setVisibility(8);
                this.refreshStateTextView.setText(ResUtil.getResId(this.mContext, "sdk_crowdtest_pull_to_refresh", ResUtil.TYPE_STRING));
                this.pullView.clearAnimation();
                this.pullView.setVisibility(0);
                this.pullView.startAnimation(this.rotateAnimationBack);
                this.loadStateImageView.setVisibility(8);
                this.loadStateTextView.setText(ResUtil.getResId(this.mContext, "sdk_crowdtest_pullup_to_load", ResUtil.TYPE_STRING));
                this.pullUpView.clearAnimation();
                this.pullUpView.setVisibility(0);
                this.pullUpView.startAnimation(this.rotateAnimationBack);
                return;
            case 1:
                this.refreshStateTextView.setText(ResUtil.getResId(this.mContext, "sdk_crowdtest_release_to_refresh", ResUtil.TYPE_STRING));
                this.pullView.startAnimation(this.rotateAnimation);
                return;
            case 2:
                this.pullView.clearAnimation();
                this.refreshingView.setVisibility(0);
                this.pullView.setVisibility(4);
                this.refreshingView.startAnimation(this.refreshingAnimation);
                this.refreshStateTextView.setText(ResUtil.getResId(this.mContext, "sdk_crowdtest_refreshing", ResUtil.TYPE_STRING));
                return;
            case 3:
                this.loadStateTextView.setText(ResUtil.getResId(this.mContext, "sdk_crowdtest_release_to_load", ResUtil.TYPE_STRING));
                this.pullUpView.startAnimation(this.rotateAnimation);
                return;
            case 4:
                this.pullUpView.clearAnimation();
                this.loadingView.setVisibility(0);
                this.pullUpView.setVisibility(4);
                this.loadingView.startAnimation(this.refreshingAnimation);
                this.loadStateTextView.setText(ResUtil.getResId(this.mContext, "sdk_crowdtest_loading", ResUtil.TYPE_STRING));
                return;
            default:
                return;
        }
    }

    private void releasePull() {
        this.canPullDown = true;
        this.canPullUp = true;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.downY = motionEvent.getY();
                this.lastY = this.downY;
                this.timer.cancel();
                this.mEvents = 0;
                releasePull();
                break;
            case 1:
                if (this.pullDownY > this.refreshDist || (-this.pullUpY) > this.loadmoreDist) {
                    this.isTouch = false;
                }
                if (this.state == 1) {
                    changeState(2);
                    if (this.mListener != null) {
                        this.mListener.onRefresh(this);
                    }
                } else if (this.state == 3) {
                    changeState(4);
                    if (this.mListener != null) {
                        this.mListener.onLoadMore(this);
                    }
                }
                hide();
                break;
            case 2:
                if (this.mEvents != 0) {
                    this.mEvents = 0;
                } else if (this.pullDownY > 0.0f || (((Pullable) this.pullableView).canPullDown() && this.canPullDown && this.state != 4)) {
                    this.pullDownY += (motionEvent.getY() - this.lastY) / this.radio;
                    if (this.pullDownY < 0.0f) {
                        this.pullDownY = 0.0f;
                        this.canPullDown = false;
                        this.canPullUp = true;
                    }
                    if (this.pullDownY > ((float) getMeasuredHeight())) {
                        this.pullDownY = (float) getMeasuredHeight();
                    }
                    if (this.state == 2) {
                        this.isTouch = true;
                    }
                } else if (this.pullUpY < 0.0f || (((Pullable) this.pullableView).canPullUp() && this.canPullUp && this.state != 2)) {
                    this.pullUpY += (motionEvent.getY() - this.lastY) / this.radio;
                    if (this.pullUpY > 0.0f) {
                        this.pullUpY = 0.0f;
                        this.canPullDown = true;
                        this.canPullUp = false;
                    }
                    if (this.pullUpY < ((float) (-getMeasuredHeight()))) {
                        this.pullUpY = (float) (-getMeasuredHeight());
                    }
                    if (this.state == 4) {
                        this.isTouch = true;
                    }
                } else {
                    releasePull();
                }
                this.lastY = motionEvent.getY();
                this.radio = (float) (2.0d + (2.0d * Math.tan((1.5707963267948966d / ((double) getMeasuredHeight())) * ((double) (this.pullDownY + Math.abs(this.pullUpY))))));
                if (this.pullDownY > 0.0f || this.pullUpY < 0.0f) {
                    requestLayout();
                }
                if (this.pullDownY > 0.0f) {
                    if (this.pullDownY <= this.refreshDist && (this.state == 1 || this.state == 5)) {
                        changeState(0);
                    }
                    if (this.pullDownY >= this.refreshDist && this.state == 0) {
                        changeState(1);
                    }
                } else if (this.pullUpY < 0.0f) {
                    if ((-this.pullUpY) <= this.loadmoreDist && (this.state == 3 || this.state == 5)) {
                        changeState(0);
                    }
                    if ((-this.pullUpY) >= this.loadmoreDist && this.state == 0) {
                        changeState(3);
                    }
                }
                if (this.pullDownY + Math.abs(this.pullUpY) > 8.0f) {
                    motionEvent.setAction(3);
                    break;
                }
                break;
            case 6:
                this.mEvents = -1;
                break;
        }
        super.dispatchTouchEvent(motionEvent);
        return true;
    }

    public void autoRefresh() {
        new AutoRefreshAndLoadTask().execute(new Integer[]{Integer.valueOf(20)});
    }

    public void setOnRefreshListener(OnRefreshListener onRefreshListener) {
        this.mListener = onRefreshListener;
    }

    public void autoLoad() {
        this.pullUpY = -this.loadmoreDist;
        requestLayout();
        changeState(4);
        if (this.mListener != null) {
            this.mListener.onLoadMore(this);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        C2511g.m12481b("BETACLUB_SDK", "[PullToRefreshLayout.onLayout]start...");
        if (!this.isLayout) {
            this.refreshView = getChildAt(0);
            this.pullableView = getChildAt(1);
            this.loadmoreView = getChildAt(2);
            this.isLayout = true;
            initView();
            this.refreshDist = (float) ((ViewGroup) this.refreshView).getChildAt(0).getMeasuredHeight();
            this.loadmoreDist = (float) ((ViewGroup) this.loadmoreView).getChildAt(0).getMeasuredHeight();
        }
        this.refreshView.layout(0, ((int) (this.pullDownY + this.pullUpY)) - this.refreshView.getMeasuredHeight(), this.refreshView.getMeasuredWidth(), (int) (this.pullDownY + this.pullUpY));
        this.pullableView.layout(0, (int) (this.pullDownY + this.pullUpY), this.pullableView.getMeasuredWidth(), ((int) (this.pullDownY + this.pullUpY)) + this.pullableView.getMeasuredHeight());
        this.loadmoreView.layout(0, ((int) (this.pullDownY + this.pullUpY)) + this.pullableView.getMeasuredHeight(), this.loadmoreView.getMeasuredWidth(), (((int) (this.pullDownY + this.pullUpY)) + this.pullableView.getMeasuredHeight()) + this.loadmoreView.getMeasuredHeight());
    }
}
