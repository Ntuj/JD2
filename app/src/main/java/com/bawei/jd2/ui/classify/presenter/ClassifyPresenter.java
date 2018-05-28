package com.bawei.jd2.ui.classify.presenter;

import com.bawei.jd2.base.BasePresenter;
import com.bawei.jd2.bean.CatagoryBean;
import com.bawei.jd2.bean.ProductCatagoryBean;
import com.bawei.jd2.net.CatagoryApi;
import com.bawei.jd2.net.ProductCatagoryApi;
import com.bawei.jd2.ui.classify.contract.ClassifyContract;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ClassifyPresenter extends BasePresenter<ClassifyContract.View> implements ClassifyContract.Presenter{
    private ProductCatagoryApi productCatagoryApi;
    private CatagoryApi catagoryApi;

    @Inject
    public ClassifyPresenter(ProductCatagoryApi productCatagoryApi, CatagoryApi catagoryApi) {
        this.productCatagoryApi = productCatagoryApi;
        this.catagoryApi = catagoryApi;
    }

    @Override
    public void getProductCatagory(String cid) {
        productCatagoryApi.getProductCatagory(cid)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<ProductCatagoryBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ProductCatagoryBean productCatagoryBean) {
                        if (mView != null) {
                            mView.getProductCatagorySuccess(productCatagoryBean);
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

    @Override
    public void getCatagory() {
        catagoryApi.getCatagory()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<CatagoryBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CatagoryBean catagoryBean) {
                        if (mView != null) {
                            mView.getCatagorySuccess(catagoryBean);
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
