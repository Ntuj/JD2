package com.bawei.jd2.ui.homepage.contract;

import com.bawei.jd2.base.BaseContract;
import com.bawei.jd2.bean.AdBean;
import com.bawei.jd2.bean.CatagoryBean;

public interface HomPageContract {
    interface View extends BaseContract.BaseView {
        void getAdSuccess(AdBean adBean);

        void getCatagorySuccess(CatagoryBean catagoryBean);
    }

    interface Presenter extends BaseContract.BasePresenter<View> {
        void getAd();

        void getCatagory();
    }
}
