package com.app.transit.transitapp.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.transit.transitapp.Model.Route;
import com.app.transit.transitapp.R;

import java.util.List;

/**
 * Created by asus on 13/11/2017.
 */

public class StopAdapter extends RecyclerView.Adapter<StopAdapter.StopViewHolder> {

private List<Route> stopList;

public class  StopViewHolder extends RecyclerView.ViewHolder {
    public TextView provider,time,price;


    public  StopViewHolder(View view) {
        super(view);
        provider = (TextView)  view.findViewById(R.id.route_provider);
        time = (TextView) view.findViewById(R.id.stop_time);
        price = (TextView) view.findViewById(R.id.stop_price);

    }
}


    public StopAdapter(List<Route> stopList) {
        this.stopList = stopList;
    }

    @Override
    public StopAdapter.StopViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.route_item, parent, false);

        return new StopAdapter.StopViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(StopViewHolder holder, int position) {
        Route route = stopList.get(position);
        holder.provider.setText(route.getProvider());
        holder.time.setText(route.getProvider());
        holder.price.setText(route.getProvider());
    }


    @Override
    public int getItemCount() {
        return stopList.size();
    }
}