package com.app.transit.transitapp.Controller;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.app.transit.transitapp.Adapter.RouteAdapter;
import com.app.transit.transitapp.GlobaleManager.DividerItemDecoration;
import com.app.transit.transitapp.Holders.ItemEntity;
import com.app.transit.transitapp.R;

import java.util.ArrayList;

public class RoutesController extends AppCompatActivity {
    private ArrayList<ItemEntity> items = new ArrayList<ItemEntity>();
    private RecyclerView recyclerView;
    private RouteAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routes_controller);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.routes_type_recycler_view);

        mAdapter = new RouteAdapter(items);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);
        setItems();
    }
    void setItems(){

        ItemEntity sharingBike = new ItemEntity("sharing bike", BitmapFactory.decodeResource(getResources(), R.drawable.sharing_bike));
        ItemEntity privateBike = new ItemEntity("private bike",BitmapFactory.decodeResource(getResources(), R.drawable.private_bike));
        ItemEntity carSharing = new ItemEntity("sharing car",BitmapFactory.decodeResource(getResources(), R.drawable.sharing_car));
        ItemEntity publicTansport = new ItemEntity("public transport",BitmapFactory.decodeResource(getResources(), R.drawable.public_transport));
        ItemEntity taxi = new ItemEntity("public transport",BitmapFactory.decodeResource(getResources(), R.drawable.taxi));

        items.add(sharingBike);
        items.add(privateBike);
        items.add(carSharing);
        items.add(publicTansport);
        items.add(taxi);
        mAdapter.notifyDataSetChanged();
    }
}
