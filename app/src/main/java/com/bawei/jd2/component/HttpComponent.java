package com.bawei.jd2.component;


import com.bawei.jd2.module.HttpModule;
import com.bawei.jd2.ui.classify.ClassifyFragment;
import com.bawei.jd2.ui.classify.ListActivity;
import com.bawei.jd2.ui.classify.ListDetailsActivity;
import com.bawei.jd2.ui.homepage.HomePageFragment;
import com.bawei.jd2.ui.login.LoginActivity;
import com.bawei.jd2.ui.mine.MakeSureOrderActivity;
import com.bawei.jd2.ui.mine.UserInfoActivity;
import com.bawei.jd2.ui.mine.fragment.FragmentAllOrder;
import com.bawei.jd2.ui.mine.fragment.FragmentWaitOrder;
import com.bawei.jd2.ui.shopcart.ShopCartActivity;

import dagger.Component;

@Component(modules = HttpModule.class)
public interface HttpComponent {
    void inject(LoginActivity loginActivity);

    void inject(HomePageFragment homePageFragment);

    void inject(ClassifyFragment classifyFragment);

    void inject(ListActivity listActivity);

    void inject(ListDetailsActivity listDetailsActivity);

    void inject(ShopCartActivity shopCartActivity);

//    void inject(ShopCartActivity2 shopCartActivity2);

    void inject(MakeSureOrderActivity makeSureOrderActivity);

    void inject(UserInfoActivity userInfoActivity);

    void inject(FragmentAllOrder fragmentAllOrder);

    void inject(FragmentWaitOrder fragmentWaitOrder);
}
