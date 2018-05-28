package com.bawei.jd2.ui.classify.contract;

import com.bawei.jd2.base.BaseContract;
import com.bawei.jd2.bean.ProductsBean;

import java.util.List;

public interface ListContract {
    interface View extends BaseContract.BaseView {
        void onSuccess(List<ProductsBean.DataBean> list);
    }

    interface Presenter extends BaseContract.BasePresenter<View> {
        void getProducts(String pscid);
    }
}
