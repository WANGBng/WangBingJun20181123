package com.bwie.mvp.view;

import com.bwie.base.BaseView;
import com.bwie.my.bean.GoodsBean;

/**
 * Created by wangbingjun on 2018/11/23.
 */

public interface FenView extends BaseView {
    void onFenSuccess(GoodsBean goodsBean);
    void onError(Throwable e);
}
