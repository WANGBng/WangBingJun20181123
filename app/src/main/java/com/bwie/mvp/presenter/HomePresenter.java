package com.bwie.mvp.presenter;


import com.bwie.base.BasePresenter;
import com.bwie.mvp.model.HomeModel;
import com.bwie.mvp.view.HomeView;
import com.bwie.my.bean.HomeBean;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by wangbingjun on 2018/11/23.
 */
//这页面的P层
public class HomePresenter extends BasePresenter<HomeView> {
    private  final HomeModel homeModel;
    public HomePresenter(){
        homeModel = new HomeModel();
    }
    public void homedata(){
        homeModel.getHome()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HomeBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }
                    @Override//成功时才能进入这里
                    public void onNext(HomeBean homeBean) {
                        if (homeBean!=null){
                            getView().OnHomeSuccess(homeBean);
                        }
                    }
                    @Override
                    public void onError(Throwable e) {
                    }
                    @Override
                    public void onComplete() {
                    }
                });
    }
}