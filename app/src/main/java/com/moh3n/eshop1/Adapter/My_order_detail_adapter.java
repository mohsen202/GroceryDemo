package com.moh3n.eshop1.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import com.moh3n.eshop1.Config.BaseURL;
import com.moh3n.eshop1.Model.My_order_detail_model;
import com.moh3n.eshop1.R;

/**
 * Created by Rajesh Dabhi on 30/6/2017.
 */

public class My_order_detail_adapter extends RecyclerView.Adapter<My_order_detail_adapter.MyViewHolder> {

    private List<My_order_detail_model> modelList;
    private Context context;
    RequestOptions options;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_title, tv_price, tv_qty;
        public ImageView iv_img;

        public MyViewHolder(View view) {
            super(view);
            tv_title = (TextView) view.findViewById(R.id.tv_order_Detail_title);
            tv_price = (TextView) view.findViewById(R.id.tv_order_Detail_price);
            tv_qty = (TextView) view.findViewById(R.id.tv_order_Detail_qty);
            iv_img = (ImageView) view.findViewById(R.id.iv_order_detail_img);

        }
    }

    public My_order_detail_adapter(List<My_order_detail_model> modelList) {
        this.modelList = modelList;

        options = new RequestOptions();
        options.placeholder(R.drawable.icon);
        options.centerCrop();
        options.dontAnimate();
        options.diskCacheStrategy(DiskCacheStrategy.ALL);
    }

    @Override
    public My_order_detail_adapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_my_order_detail_rv, parent, false);

        context = parent.getContext();

        return new My_order_detail_adapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(My_order_detail_adapter.MyViewHolder holder, int position) {
        My_order_detail_model mList = modelList.get(position);

        Glide.with(context)
                .load(BaseURL.IMG_PRODUCT_URL + mList.getProduct_image())
                .apply(options)
                .into(holder.iv_img);

        holder.tv_title.setText(mList.getProduct_name());
        holder.tv_price.setText(mList.getPrice());
        holder.tv_qty.setText(mList.getQty());

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

}