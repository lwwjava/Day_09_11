package test.jiyun.com.day_09_11;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    private ViewPager viewPager;
    private Button btn_lww;
    private Button btn_wxs;
    private ArrayList<Fragment> list;
    private MyPeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        initView();
        initData();
    }

    private void initData() {

        list=new ArrayList<>();
        list.add(new LwwFragment());
        list.add(new WxsFragment());

        FragmentManager manager = getSupportFragmentManager();
        adapter=new MyPeAdapter(manager,list,Main2Activity.this);
        viewPager.setCurrentItem(0);
        viewPager.setAdapter(adapter);

    }

    private void initView() {

        viewPager = (ViewPager) findViewById(R.id.viewpager);

        btn_lww = (Button) findViewById(R.id.btn_lww);
        btn_wxs = (Button) findViewById(R.id.btn_wxs);

        btn_lww.setOnClickListener(this);
        btn_wxs.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_lww:
                viewPager.setCurrentItem(0);
                break;
            case R.id.btn_wxs:
                viewPager.setCurrentItem(1);
                break;
        }
    }
}
