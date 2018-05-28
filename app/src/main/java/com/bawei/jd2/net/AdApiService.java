package com.bawei.jd2.net;


import com.bawei.jd2.bean.AdBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface AdApiService {
   
    @GET("ad/getAd")
    Observable<AdBean> getAd();
}
