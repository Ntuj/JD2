package com.bawei.jd2.ui.login.contract;

import com.bawei.jd2.base.BaseContract;
import com.bawei.jd2.bean.UserBean;

public interface LoginContract {
    interface View extends BaseContract.BaseView {
        void loginSuccess(UserBean userBean);
    }

    interface Presenter extends BaseContract.BasePresenter<View> {
        void login(String mobile, String password);
    }
}
