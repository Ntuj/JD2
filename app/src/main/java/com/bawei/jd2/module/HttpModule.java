package com.bawei.jd2.module;


import com.bawei.jd2.net.AdApi;
import com.bawei.jd2.net.AdApiService;
import com.bawei.jd2.net.AddCartApi;
import com.bawei.jd2.net.AddCartApiService;
import com.bawei.jd2.net.AddrsApi;
import com.bawei.jd2.net.AddrsApiService;
import com.bawei.jd2.net.Api;
import com.bawei.jd2.net.CatagoryApi;
import com.bawei.jd2.net.CatagoryApiService;
import com.bawei.jd2.net.CreateOrderApi;
import com.bawei.jd2.net.CreateOrderApiService;
import com.bawei.jd2.net.DeleteCartApi;
import com.bawei.jd2.net.DeleteCartApiService;
import com.bawei.jd2.net.GetCartApi;
import com.bawei.jd2.net.GetCartApiService;
import com.bawei.jd2.net.ListApi;
import com.bawei.jd2.net.ListApiService;
import com.bawei.jd2.net.LoginApi;
import com.bawei.jd2.net.LoginApiService;
import com.bawei.jd2.net.MyInterceptor;
import com.bawei.jd2.net.ProductCatagoryApi;
import com.bawei.jd2.net.ProductCatagoryApiService;
import com.bawei.jd2.net.UpdateCartApi;
import com.bawei.jd2.net.UpdateCartApiService;
import com.bawei.jd2.net.UpdateHeaderApi;
import com.bawei.jd2.net.UpdateHeaderApiService;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class HttpModule {
    @Provides
    OkHttpClient.Builder provideOkHttpClientBuilder() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder()
                .writeTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor);
    }

    @Provides
    LoginApi provideLoginApi(OkHttpClient.Builder builder) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
        LoginApiService loginApiService = retrofit.create(LoginApiService.class);
        return LoginApi.getLoginApi(loginApiService);
    }

    @Provides
    AdApi provideAdApi(OkHttpClient.Builder builder) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
        AdApiService adApiService = retrofit.create(AdApiService.class);
        return AdApi.getAdApi(adApiService);
    }

    @Provides
    CatagoryApi provideCatagoryApi(OkHttpClient.Builder builder) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
        CatagoryApiService catagoryApiService = retrofit.create(CatagoryApiService.class);
        return CatagoryApi.getCatagoryApi(catagoryApiService);
    }

    @Provides
    ProductCatagoryApi provideProductCatagoryApi(OkHttpClient.Builder builder) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
        ProductCatagoryApiService productCatagoryApiService = retrofit.create(ProductCatagoryApiService.class);
        return ProductCatagoryApi.getProductCatagoryApi(productCatagoryApiService);
    }

    @Provides
    ListApi provideListApi(OkHttpClient.Builder builder) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
        ListApiService listApiService = retrofit.create(ListApiService.class);
        return ListApi.getListApi(listApiService);
    }

    @Provides
    AddCartApi provideAddCartApi(OkHttpClient.Builder builder) {
        builder.addInterceptor(new MyInterceptor());
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
        AddCartApiService addCartApiService = retrofit.create(AddCartApiService.class);
        return AddCartApi.getAddCartApi(addCartApiService);
    }

    @Provides
    GetCartApi provideGetCartApi(OkHttpClient.Builder builder) {
        builder.addInterceptor(new MyInterceptor());
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
        GetCartApiService getCartApiService = retrofit.create(GetCartApiService.class);
        return GetCartApi.getGetCartApi(getCartApiService);
    }

    @Provides
    UpdateCartApi provideUpdateCartApi(OkHttpClient.Builder builder) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
        UpdateCartApiService updateCartApiService = retrofit.create(UpdateCartApiService.class);
        return UpdateCartApi.getUpdateCartApi(updateCartApiService);
    }

    @Provides
    DeleteCartApi provideDeleteCartApi(OkHttpClient.Builder builder) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
        DeleteCartApiService deleteCartApiService = retrofit.create(DeleteCartApiService.class);
        return DeleteCartApi.getDeleteCartApi(deleteCartApiService);
    }

    @Provides
    AddrsApi provideAddrsApi(OkHttpClient.Builder builder) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
        AddrsApiService addrsApiService = retrofit.create(AddrsApiService.class);
        return AddrsApi.getAddrsApi(addrsApiService);
    }

    @Provides
    CreateOrderApi provideCreateOrderApi(OkHttpClient.Builder builder) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
        CreateOrderApiService createOrderApiService = retrofit.create(CreateOrderApiService.class);
        return CreateOrderApi.getCreateOrderApi(createOrderApiService);
    }

    @Provides
    UpdateHeaderApi provideUpdateHeaderApi(OkHttpClient.Builder builder) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
        UpdateHeaderApiService updateHeaderApiService = retrofit.create(UpdateHeaderApiService.class);
        return UpdateHeaderApi.getUpdateHeaderApi(updateHeaderApiService);
    }
}
