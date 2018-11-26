package com.bwie.my.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwie.my.activity.FenActivity;
import com.bwie.my.activity.R;
import com.bwie.my.bean.HomeBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by wangbingjun on 2018/11/23.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {
    private static final String TAG ="HomeAdapter" ;
    private Context context;
    private List<HomeBean.DataBean> homeList;

    public HomeAdapter(Context context, List<HomeBean.DataBean> homeList) {
        this.context = context;
        this.homeList = homeList;
    }
 /*   private void
    private onHomeClickListener onHomeClickListener;
*/


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(context, R.layout.layout_home_item,null));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        Uri uri = Uri.parse(homeList.get(position).getPic_url());
        holder.home_simple.setImageURI(uri);
        holder.mai_name.setText(homeList.get(position).getName());
        holder.month_sales.setText("月销售"+homeList.get(position).getMonth_sales()+"笔");
        holder.manjian_price.setText(homeList.get(position).getDiscounts2().get(0).getInfo());
        holder.dazhe_price.setText(homeList.get(position).getDiscounts2().get(1).getInfo());

      //  Log.e(TAG, "onBindViewHolder: "+homeList.get(position).getName() );
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,FenActivity.class);
                int id = homeList.get(position).getId();
                intent.putExtra("id",id);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return homeList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView home_simple;
        TextView mai_name;
        TextView month_sales;
        TextView manjian_price;
        TextView dazhe_price;

        public ViewHolder(View itemView) {
            super(itemView);
            home_simple = (SimpleDraweeView) itemView.findViewById(R.id.home_simple);
            mai_name = (TextView) itemView.findViewById(R.id.mai_name);
            month_sales = (TextView) itemView.findViewById(R.id.month_sales);
            manjian_price = (TextView) itemView.findViewById(R.id.manjian_price);
            dazhe_price = (TextView) itemView.findViewById(R.id.dazhe_price);
        }
    }
}
