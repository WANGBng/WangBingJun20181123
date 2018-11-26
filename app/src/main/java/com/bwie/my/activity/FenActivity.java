package com.bwie.my.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.bwie.mvp.presenter.FenZPresenter;
import com.bwie.mvp.view.FenView;
import com.bwie.my.adapter.YouAdapter;
import com.bwie.my.adapter.ZuoAdapter;
import com.bwie.my.bean.GoodsBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FenActivity extends AppCompatActivity implements FenView {
    @BindView(R.id.rec_left)
    RecyclerView recLeft;
    @BindView(R.id.rec_right)
    RecyclerView recRight;
    private FenZPresenter secondPresenter;
    private List<GoodsBean.DataBean> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fen);
        ButterKnife.bind(this);
        secondPresenter = new FenZPresenter();
        secondPresenter.attachView(this);
        secondPresenter.twodata();
    }

    @Override
    public void onFenSuccess(GoodsBean goodsBean) {//成功时进行请求
        data = goodsBean.getData();
        recLeft.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        ZuoAdapter zuoAdapter = new ZuoAdapter(FenActivity.this,data);
        recLeft.setAdapter(zuoAdapter);

        zuoAdapter.setOnItemClickListener(new ZuoAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                //Toast.makeText(FenActivity.this, "点击了"+position, Toast.LENGTH_SHORT).show();
                recRight.setLayoutManager(new LinearLayoutManager(FenActivity.this,LinearLayoutManager.VERTICAL,false));
                List<GoodsBean.DataBean.SpusBean> spus = data.get(position).getSpus();
                YouAdapter youAdapter = new YouAdapter(FenActivity.this,spus);
                recRight.setAdapter(youAdapter);

            }
        });
    }

    @Override
    public void onError(Throwable e) {

    }
    @Override//防止内存溢出
    protected void onDestroy() {
        super.onDestroy();
        secondPresenter.detachView();
    }
}
