package com.example.ceshi.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ceshi.R;
import com.example.ceshi.adpter.ZhuanTiAdapter;
import com.example.ceshi.bean.ZhuanTiBean;
import com.example.ceshi.presenter.NetPresenter;
import com.example.ceshi.view.NetView;

import java.util.ArrayList;
import java.util.List;

public class ZhuanTiFragment extends Fragment implements NetView {
    private RecyclerView mMyRec;
    private List<ZhuanTiBean.DataBeanX.DataBean> list;
    private ZhuanTiAdapter zhuanTiAdapter;
    private NetPresenter netPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.zhuanti_fragment, null);
        netPresenter = new NetPresenter(this);
        netPresenter.getData();
        initView(view);
        return view;
    }

    private void initView(@NonNull final View itemView) {
        mMyRec = (RecyclerView) itemView.findViewById(R.id.MyRec);
        mMyRec.setLayoutManager(new LinearLayoutManager(getActivity()));
        list = new ArrayList<>();
        zhuanTiAdapter = new ZhuanTiAdapter(list,getActivity());
        mMyRec.setAdapter(zhuanTiAdapter);
    }

    @Override
    public void setData(ZhuanTiBean zhuanTiBean) {
        List<ZhuanTiBean.DataBeanX.DataBean> data = zhuanTiBean.getData().getData();
        zhuanTiAdapter.initData(data);
    }

    @Override
    public void showToast(String str) {
        Toast.makeText(getActivity(), str, Toast.LENGTH_SHORT).show();
    }
}
