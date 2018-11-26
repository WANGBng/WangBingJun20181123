package com.bwie.my.util;

import com.bwie.my.bean.GoodsBean;
import com.bwie.my.bean.HomeBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by wangbingjun on 2018/11/23.
 */

public interface Api {
    //   首页餐馆接口第一页
    @GET("restaurants_offset_0_limit_4")
    Observable<HomeBean> home();

//  餐馆食物列表接口
    @GET("restaurant-list")
    Observable<GoodsBean> goods();
}
