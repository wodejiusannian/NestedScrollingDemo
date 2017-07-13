package nested_scrolling_demo.i.nestedscrollingdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import nested_scrolling_demo.i.nestedscrollingdemo.recycle.BaseRecycleAdapter;
import nested_scrolling_demo.i.nestedscrollingdemo.recycle.BaseViewHolder;

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
public class ScrollFragment extends Fragment {
    private RecyclerView recycle;
    private List<String> mData = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_scroll, null);
        initChild(view);
        initData();
        return view;
    }

    private void initData() {
        for (int i = 0; i < 50; i++) {
            mData.add("我是来自星星的你" + i + "号");
        }
        BaseRecycleAdapter adapter = new BaseRecycleAdapter(getContext(), mData, R.layout.frgament_item_recycle_scroll) {
            @Override
            public void bindData(BaseViewHolder holder, Object o, int position) {
                TextView tip = holder.getView(R.id.fragment_item_recycle_scroll_tip);
                tip.setText(mData.get(position));
            }
        };
        GridLayoutManager manager = new GridLayoutManager(getContext(), 1);
        recycle.setLayoutManager(manager);
        recycle.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void initChild(View view) {
        recycle = (RecyclerView) view.findViewById(R.id.recycle_fragment);
    }
}
