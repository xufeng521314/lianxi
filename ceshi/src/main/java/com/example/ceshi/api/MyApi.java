package com.example.ceshi.api;

import com.example.ceshi.bean.ZhuanTiBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface MyApi {
    String url="https://cdwan.cn/api/";
    @GET("topic/list")
    Observable<ZhuanTiBean> getData();
}
