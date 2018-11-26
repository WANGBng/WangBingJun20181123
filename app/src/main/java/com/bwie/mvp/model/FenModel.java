package com.bwie.mvp.model;

import com.bwie.my.bean.GoodsBean;
import com.bwie.my.util.HttpUtils;

import io.reactivex.Observable;

/**
 * Created by wangbingjun on 2018/11/23.
 */

public class FenModel {
    public Observable<GoodsBean> getdata(){
        Observable<GoodsBean> dataa = HttpUtils.getdatanet().api.goods();
        return dataa;
    }
}
