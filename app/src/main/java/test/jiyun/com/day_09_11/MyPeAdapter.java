package test.jiyun.com.day_09_11;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by 看的太透反而不快乐 on 2017/9/11.
 */

public class MyPeAdapter extends FragmentPagerAdapter {


    private ArrayList<Fragment> list;
    private Context context;

    public MyPeAdapter(FragmentManager fm, ArrayList<Fragment> list, Context context) {
        super(fm);

        this.list = list;
        this.context = context;
    }



    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
