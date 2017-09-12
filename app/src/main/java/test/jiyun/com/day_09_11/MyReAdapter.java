package test.jiyun.com.day_09_11;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by 看的太透反而不快乐 on 2017/9/5.
 */

public class MyReAdapter extends RecyclerView.Adapter<MyReAdapter.MyViewHolder>  {

    private  OnItemClickListener onItemClickListener;
    private  OnItemLongClickListener onItemLongClickListener;
    private Context context;
    private ArrayList<Bean.DataBean.GoodsRelDetailsBean> list;


    public MyReAdapter(Context context, ArrayList<Bean.DataBean.GoodsRelDetailsBean> list) {
        this.context=context;
        this.list=list;
    }

    public  void setOnItemClickListener(MyReAdapter.OnItemClickListener onItemClickListener){

        this.onItemClickListener=onItemClickListener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener listener){

        this.onItemLongClickListener =  listener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = View.inflate(context, R.layout.item, null);
        RecyclerView.LayoutParams layout=new RecyclerView.LayoutParams(RecyclerView.LayoutParams.WRAP_CONTENT,RecyclerView.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(layout);
        MyViewHolder holder=new MyViewHolder(view,onItemClickListener,onItemLongClickListener);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Glide.with(context).load(list.get(position).getGoods_img()).into(holder.imageView);
        holder.name.setText(list.get(position).getGoods_name());
        holder.price.setText(list.get(position).getShop_price()+"元");
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {

        return list.size();
    }

    public void notify(ArrayList<Bean.DataBean.GoodsRelDetailsBean> list) {
        this.list=list;
        notifyDataSetChanged();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        private ImageView imageView;
        private TextView name;
        private TextView price;


        public MyViewHolder(View itemView, OnItemClickListener onItemClickListener, OnItemLongClickListener onItemLongClickListener) {
            super(itemView);

            imageView= (ImageView) itemView.findViewById(R.id.image);
            name= (TextView) itemView.findViewById(R.id.tv_name);
            price= (TextView) itemView.findViewById(R.id.tv_price);

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View v) {

            if (null!=onItemClickListener){
                Integer position= (Integer) v.getTag();
                onItemClickListener.OnItemClick(position);
            }
        }

        @Override
        public boolean onLongClick(View v) {

            if(onItemLongClickListener != null){
                onItemLongClickListener.onItemLongClick(v,getPosition());
            }
            return true;
        }
    }

    public interface  OnItemClickListener{

        public  void OnItemClick(int position);

    }


    public interface OnItemLongClickListener{

        public void onItemLongClick(View view,int position);

    }
}

