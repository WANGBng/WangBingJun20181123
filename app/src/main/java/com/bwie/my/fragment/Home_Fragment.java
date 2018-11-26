package com.bwie.my.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwie.mvp.presenter.HomePresenter;
import com.bwie.mvp.view.HomeView;
import com.bwie.my.activity.GaoDeActivity;
import com.bwie.my.activity.R;
import com.bwie.my.adapter.HomeAdapter;
import com.bwie.my.bean.HomeBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by wangbingjun on 2018/11/23.
 */

public class Home_Fragment extends Fragment implements HomeView{
    View view;
    @BindView(R.id.woZai)
    TextView woZai;
    @BindView(R.id.home_rec)
    RecyclerView home_rec;
    private HomePresenter homePresenter;
    private HomeAdapter homeAdapter;
    Unbinder unbinder;//这是绑定

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if(view == null){
            view = inflater.inflate(R.layout.layout_home,container,false);
        }
        ViewGroup parent = (ViewGroup)view.getParent();
        if(parent != null){
            parent.removeView(view);
        }
        unbinder = ButterKnife.bind(this,view);
        /*woZai = (TextView) view.findViewById(R.id.woZai);
         woZai.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(getActivity(), GaoDeActivity.class);
                 startActivity(intent);
             }
         });*/
        homePresenter = new HomePresenter();
        homePresenter.attachView(this);
        homePresenter.homedata();
        return view;
    }

    @OnClick({R.id.woZai})
    public void onViewClicked(View v){
        switch (v.getId()){
            case R.id.woZai:
                Intent intent = new Intent(getActivity(), GaoDeActivity.class);
                startActivity(intent);
                break;
        }
    }


    @Override
    public void OnHomeSuccess(HomeBean homeBean) {

        List<HomeBean.DataBean> data = homeBean.getData();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        home_rec.setLayoutManager(linearLayoutManager);
        homeAdapter = new HomeAdapter(getActivity(),data);
        home_rec.setAdapter(homeAdapter);



    }

    @Override
    public void OnHomeFailed(Exception e) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
       homePresenter.detachView();
//       unbinder.unbind();
    }
}
