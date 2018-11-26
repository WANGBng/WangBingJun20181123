package com.bwie.base;

/**
 * Created by wangbingjun on 2018/11/23.
 */

public class BasePresenter<V extends BaseView> {
    private V iv;
    public void attachView(V iv){
        this.iv = iv;
    }

    public void detachView(){
        this.iv = null;
    }
    public V getView(){
        return iv;
    }


}
