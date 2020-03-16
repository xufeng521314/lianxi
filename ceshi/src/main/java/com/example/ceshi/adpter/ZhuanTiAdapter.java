package com.example.ceshi.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ceshi.R;
import com.example.ceshi.api.BaseApp;
import com.example.ceshi.bean.Bean;
import com.example.ceshi.bean.ZhuanTiBean;
import com.example.ceshi.db.BeanDao;


import java.util.ArrayList;
import java.util.List;

public class ZhuanTiAdapter extends RecyclerView.Adapter<ZhuanTiAdapter.ViewHolder> {

    private List<ZhuanTiBean.DataBeanX.DataBean> list=new ArrayList<>();
    private Context context;
    private ZhuanTiBean.DataBeanX.DataBean dataBean;

    public ZhuanTiAdapter(Context context) {
        this.context = context;
    }

    public void initData(List<ZhuanTiBean.DataBeanX.DataBean> list){
        this.list.addAll(list);
        notifyDataSetChanged();
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.zhuanti_adapter,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        dataBean = list.get(position);
        holder.title.setText(dataBean.getTitle());
        holder.name.setText(dataBean.getSubtitle());
        Glide.with(context).load(dataBean.getScene_pic_url()).into(holder.zhuantiImg);
        holder.bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BeanDao beanDao = BaseApp.getInstance().getDaoSession().getBeanDao();
                beanDao.insert(new Bean(null,dataBean.getScene_pic_url(),dataBean.getTitle(),dataBean.getSubtitle()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView zhuantiImg;
        TextView title;
        TextView name;
        Button bt;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            zhuantiImg=itemView.findViewById(R.id.zhuantiImg);
            title=itemView.findViewById(R.id.aptitle);
            name=itemView.findViewById(R.id.apname);
            bt=itemView.findViewById(R.id.bt);
        }
    }
}
