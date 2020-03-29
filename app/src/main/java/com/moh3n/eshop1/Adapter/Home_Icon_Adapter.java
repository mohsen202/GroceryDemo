package com.moh3n.eshop1.Adapter;

import android.content.Context;
import android.content.SharedPreferences;
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
import com.moh3n.eshop1.Model.Home_Icon_model;
import com.moh3n.eshop1.R;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Rajesh Dabhi on 22/6/2017.
 */

public class Home_Icon_Adapter extends RecyclerView.Adapter<Home_Icon_Adapter.MyViewHolder> {

    private List<Home_Icon_model> modelList;
    private Context context;
    String language;
    SharedPreferences preferences;
    RequestOptions options;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public ImageView image;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.service_text);
            image = (ImageView) view.findViewById(R.id.service_image);


        }
    }

    public Home_Icon_Adapter(List<Home_Icon_model> modelList)
    {
        options = new RequestOptions();
        options.placeholder(R.drawable.icon);
        options.centerCrop();
        options.dontAnimate();
        options.diskCacheStrategy(DiskCacheStrategy.ALL);
        this.modelList = modelList;
    }

    @Override
    public Home_Icon_Adapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_headre_catogaries, parent, false);

        context = parent.getContext();

        return new Home_Icon_Adapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(Home_Icon_Adapter.MyViewHolder holder, int position) {
        Home_Icon_model mList = modelList.get(position);
        Glide.with(context)
                .load(BaseURL.IMG_CATEGORY_URL + mList.getImage())
                .apply(options)
                .into(holder.image);
        preferences = context.getSharedPreferences("lan", MODE_PRIVATE);
        language=preferences.getString("language","");
        if (language.contains("english")) {
            holder.title.setText(mList.getTitle());
        }
        else {
            holder.title.setText(mList.getArb_title());

        }
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

}

