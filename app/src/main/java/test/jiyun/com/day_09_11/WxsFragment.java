package test.jiyun.com.day_09_11;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 看的太透反而不快乐 on 2017/9/11.
 */

public class WxsFragment extends Fragment {

    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.wxsfragment,null);

        initView(view);
        initData();

        return view;
    }

    private void initData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                getRequest();
            }
        }).start();
    }

    private void getRequest() {

    }

    private void initView(View view) {
        recyclerView= (RecyclerView) view.findViewById(R.id.recycler2);

    }
}
