package com.example.ceshi.presenter;

import com.example.ceshi.bean.ZhuanTiBean;
import com.example.ceshi.model.NetModel;
import com.example.ceshi.view.NetView;

public class NetPresenter implements NetModel.CallBack {
    private NetView netView;
    private NetModel netModel;

    public NetPresenter(NetView netView) {
        this.netView = netView;
        this.netModel=new NetModel();
    }

    public void getData(){
        if (netModel!=null){
            netModel.getData(this);
        }
    }

    @Override
    public void setOnSuccres(ZhuanTiBean zhuanTiBean) {
        if (netView!=null){
            netView.setData(zhuanTiBean);
        }
    }

    @Override
    public void setOnFail(String str) {
        if (netView!=null){
            netView.showToast(str);
        }
    }
}
