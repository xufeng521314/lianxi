package com.example.ceshi.model;

import com.example.ceshi.api.MyApi;
import com.example.ceshi.bean.ZhuanTiBean;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
public class NetModel {

    public void getData(final CallBack callBack){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(MyApi.url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        Observable<ZhuanTiBean> zhuanTi = retrofit.create(MyApi.class).getZhuanTi();
        zhuanTi.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ZhuanTiBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ZhuanTiBean zhuanTiBean) {
                        callBack.setOnSuccres(zhuanTiBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.setOnFail("数据请求不到");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public interface CallBack{
        void setOnSuccres(ZhuanTiBean zhuanTiBean);
        void setOnFail(String str);
    }
}
