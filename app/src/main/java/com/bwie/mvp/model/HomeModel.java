package com.bwie.mvp.model;

import com.bwie.my.bean.HomeBean;
import com.bwie.my.util.HttpUtils;

import io.reactivex.Observable;

/**
 * Created by wangbingjun on 2018/11/23.
 */

public class HomeModel {

    public Observable<HomeBean> getHome(){
        Observable<HomeBean> home = HttpUtils.getdatanet().api.home();
        return home;
    }
}
