package com.bwie.mvp.presenter;

import com.bwie.base.BasePresenter;
import com.bwie.mvp.model.FenModel;
import com.bwie.mvp.view.FenView;
import com.bwie.my.bean.GoodsBean;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by wangbingjun on 2018/11/23.
 */

public class FenZPresenter extends BasePresenter<FenView> {

    private final FenModel fenModel;

    public FenZPresenter(){
        fenModel = new FenModel();
    }
    public void twodata(){
        fenModel.getdata()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GoodsBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }
                    @Override
                    public void onNext(GoodsBean goodsBean) {
                        if (goodsBean!=null){
                            getView().onFenSuccess(goodsBean);
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
