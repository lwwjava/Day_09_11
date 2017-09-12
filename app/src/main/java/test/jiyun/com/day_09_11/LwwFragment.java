package test.jiyun.com.day_09_11;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 看的太透反而不快乐 on 2017/9/11.
 */

public class LwwFragment extends Fragment {

    private RecyclerView recyclerView;
    private MyReAdapter adapter;
    private String path="http://m.yunifang.com/yunifang/mobile/goods/detail?random=42187&encode=168d21c6d627072293fbbb0a44cc72e9&id=85";
    private ArrayList<Bean.DataBean.GoodsRelDetailsBean> list=new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.lwwfragment,null);

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

        OkHttpClient client=new OkHttpClient();
        Request request=new Request.Builder().url(path).build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                String string = response.body().string();
                Gson gson=new Gson();
                Bean bean = gson.fromJson(string, Bean.class);
                List<Bean.DataBean.GoodsRelDetailsBean> data = bean.getData().getGoodsRelDetails();
                list.addAll(data);

                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        adapter = new MyReAdapter(getActivity(),list);
                        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
                        recyclerView.setAdapter(adapter);

                        adapter.notify(list);

                        adapter.setOnItemLongClickListener(new MyReAdapter.OnItemLongClickListener() {
                            @Override
                            public void onItemLongClick(View view, int position) {


                            }
                        });
                        adapter.setOnItemLongClickListener(new MyReAdapter.OnItemLongClickListener() {
                            @Override
                            public void onItemLongClick(View view, int position) {
                                
                                Intent intent=new Intent(getActivity(),Main3Activity.class);
                                startActivity(intent);

                            }
                        });

                    }
                });
            }
        });
    }

    private void initView(View view) {

        recyclerView= (RecyclerView) view.findViewById(R.id.recycler1);



    }
}
