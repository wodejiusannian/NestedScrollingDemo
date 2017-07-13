package nested_scrolling_demo.i.nestedscrollingdemo;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

// ┏┓　　　┏┓
// ┏┛┻━━━┛┻┓
// ┃　　　　　　　┃ 　
// ┃　　　━　　　┃
// ┃　┳┛　┗┳　┃
// ┃　　　　　　　┃
// ┃　　　┻　　　┃
// ┃　　　　　　　┃
// ┗━┓　　　┏━┛
// ┃　　　┃ 神兽保佑　　　　　　　　
// ┃　　　┃ 代码无BUG！
// ┃　　　┗━━━┓
// ┃　　　　　　　┣┓
// ┃　　　　　　　┏┛
// ┗┓┓┏━┳┓┏┛
// ┃┫┫　┃┫┫
// ┗┻┛　┗┻┛
public class ScrollParent extends LinearLayout implements NestedScrollingParent {
    private static final String TAG = "ScrollParent";

    public ScrollParent(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    //一定要按照自己的需求返回true，该方法决定了当前控件是否能接收到其内部View
    // (非并非是直接子View)滑动时的参数；假设你只涉及到纵向滑动，
    // 这里可以根据nestedScrollAxes这个参数，进行纵向判断。
    @Override
    public boolean onStartNestedScroll(View child, View target, int nestedScrollAxes) {
        return (nestedScrollAxes & ViewCompat.SCROLL_AXIS_VERTICAL) != 0;
    }

    @Override
    public void onNestedScrollAccepted(View child, View target, int axes) {
        super.onNestedScrollAccepted(child, target, axes);
    }

    @Override
    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        Log.e(TAG, "onNestedScroll: " + dyConsumed);
        super.onNestedScroll(target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
    }


    //onNestedPreScroll该方法的会传入内部View移动的dx,dy，
    // 如果你需要消耗一定的dx,dy，就通过最后一个参数consumed进行指定，
    // 例如我要消耗一半的dy，就可以写consumed[1]=dy/2
    @Override
    public void onNestedPreScroll(View target, int dx, int dy, int[] consumed) {
        super.onNestedPreScroll(target, dx, dy, consumed);
    }

    //onNestedFling你可以捕获对内部View的fling事件，如果return true则表示拦截掉内部View的事件。
    @Override
    public boolean onNestedFling(View target, float velocityX, float velocityY, boolean consumed) {
        //return super.onNestedFling(target, velocityX, velocityY, consumed);
        return false;
    }

    @Override
    public boolean onNestedPreFling(View target, float velocityX, float velocityY) {
        return super.onNestedPreFling(target, velocityX, velocityY);
    }

    @Override
    public int getNestedScrollAxes() {
        return super.getNestedScrollAxes();
    }
}
