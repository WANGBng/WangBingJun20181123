package com.bwie.mvp.view;

import com.bwie.base.BaseView;
import com.bwie.my.bean.HomeBean;

/**
 * Created by wangbingjun on 2018/11/23.
 */

public interface HomeView extends BaseView {
    void OnHomeSuccess(HomeBean homeBean);
    void OnHomeFailed(Exception e);
}
