package com.juan.enciclav20;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class recyclerDatos extends AppCompatActivity {


    RecyclerView recyclerView;
    AdaptadorStaciones adaptadorItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_datos);
        recyclerView=(RecyclerView) findViewById(R.id.recyclerDatos);
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        List<Station> station = Station.listAll(Station.class);
        adaptadorItems= new AdaptadorStaciones(station, this, new AdaptadorStaciones.OnItemClick() {
            @Override
            public void itemClick(Station items, int position) {

            }
        });
        recyclerView.setAdapter(adaptadorItems);
    }
}
