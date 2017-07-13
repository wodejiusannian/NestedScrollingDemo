package nested_scrolling_demo.i.nestedscrollingdemo;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager pager;
    private TabLayout tabs;
    private List<Fragment> fragments = new ArrayList<>();
    private List<String> titles = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initFragment();
    }

    private void initFragment() {
        for (int i = 0; i < 3; i++) {
            titles.add("title" + i);
            fragments.add(new ScrollFragment());
        }
        pager.setAdapter(new TAbFrAdapter(getSupportFragmentManager(), fragments, titles));
        tabs.setupWithViewPager(pager);
    }

    private void initView() {
        pager = (ViewPager) this.findViewById(R.id.pager_main_content);
        tabs = (TabLayout) this.findViewById(R.id.tab_main_title);
    }

}
