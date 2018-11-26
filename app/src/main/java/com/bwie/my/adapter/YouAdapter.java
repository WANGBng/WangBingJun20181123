package com.bwie.my.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwie.application.JiaJian;
import com.bwie.my.activity.R;
import com.bwie.my.bean.GoodsBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by wangbingjun on 2018/11/23.
 */

public class YouAdapter extends RecyclerView.Adapter<YouAdapter.ViewHolder> {

    private Context context;
    private List<GoodsBean.DataBean.SpusBean> data;

    public YouAdapter(Context context, List<GoodsBean.DataBean.SpusBean> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.youitem, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.miaoshu.setText(data.get(position).getName());
        holder.sale.setText(data.get(position).getMonth_saled()+"");
        holder.price.setText("￥"+data.get(position).getPraise_num());
        holder.simple_img02.setImageURI(data.get(position).getPic_url());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView miaoshu,sale,price;
        private final SimpleDraweeView simple_img02;
        private final JiaJian jiajiannn;
        public ViewHolder(View itemView) {
            super(itemView);
            miaoshu = itemView.findViewById(R.id.miaoshu);
            sale = itemView.findViewById(R.id.sale);
            price = itemView.findViewById(R.id.price);
            simple_img02 = itemView.findViewById(R.id.simple_img02);
            jiajiannn = itemView.findViewById(R.id.jiajiann);
        }
    }

}
