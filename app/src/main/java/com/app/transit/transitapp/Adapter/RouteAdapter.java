package com.app.transit.transitapp.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.transit.transitapp.Holders.ItemEntity;
import com.app.transit.transitapp.R;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

/**
 * Created by asus on 13/11/2017.
 */

public class RouteAdapter extends RecyclerView.Adapter<RouteAdapter. RouteViewHolder> {

private List<ItemEntity> typeList;

public class  RouteViewHolder extends RecyclerView.ViewHolder {
    public TextView title;
    public RoundedImageView image;

    public  RouteViewHolder(View view) {
        super(view);
        title = (TextView)  view.findViewById(R.id.title);
         image = (RoundedImageView) view.findViewById(R.id.imageView1);
    }
}


    public RouteAdapter(List<ItemEntity> typeList) {
        this.typeList = typeList;
    }

    @Override
    public  RouteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.type_item, parent, false);

        return new  RouteViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder( RouteViewHolder holder, int position) {
        ItemEntity itemEntity = typeList.get(position);
        holder.title.setText(itemEntity.getTitle());
        holder.image.setImageBitmap(itemEntity.getImage());


    }


    @Override
    public int getItemCount() {
        return typeList.size();
    }
}