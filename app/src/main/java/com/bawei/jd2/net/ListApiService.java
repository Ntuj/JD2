package com.bawei.jd2.net;


import com.bawei.jd2.bean.ProductsBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ListApiService {
    @FormUrlEncoded
    @POST("product/getProducts")
    Observable<ProductsBean> getProduct(@Field("pscid") String pscid);
}
