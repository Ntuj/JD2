package com.bawei.jd2.ui.classify.presenter;

import com.bawei.jd2.base.BasePresenter;
import com.bawei.jd2.bean.ProductsBean;
import com.bawei.jd2.net.ListApi;
import com.bawei.jd2.ui.classify.contract.ListContract;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class ListPresenter extends BasePresenter<ListContract.View> implements ListContract.Presenter {
    private ListApi listApi;

    @Inject
    public ListPresenter(ListApi listApi) {
        this.listApi = listApi;
    }

    @Override
    public void getProducts(String pscid) {
        listApi.getProduct(pscid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<ProductsBean, List<ProductsBean.DataBean>>() {
                    @Override
                    public List<ProductsBean.DataBean> apply(ProductsBean productsBean) throws Exception {
                        return productsBean.getData();
                    }
                }).subscribe(new Consumer<List<ProductsBean.DataBean>>() {
            @Override
            public void accept(List<ProductsBean.DataBean> dataBeans) throws Exception {
                if (mView != null) {
                    mView.onSuccess(dataBeans);
                }
            }
        });
    }
}
