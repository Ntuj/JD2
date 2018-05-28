package com.bawei.jd2.ui.classify.contract;

import com.bawei.jd2.base.BaseContract;
import com.bawei.jd2.bean.CatagoryBean;
import com.bawei.jd2.bean.ProductCatagoryBean;

public interface ClassifyContract {
    interface View extends BaseContract.BaseView {
        void getProductCatagorySuccess(ProductCatagoryBean productCatagoryBean);

        void getCatagorySuccess(CatagoryBean catagoryBean);
    }

    interface Presenter extends BaseContract.BasePresenter<View> {
        void getProductCatagory(String cid);

        void getCatagory();
    }
}
