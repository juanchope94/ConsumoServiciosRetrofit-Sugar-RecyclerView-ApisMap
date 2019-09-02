package com.juan.enciclav20;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class recyclerItems extends AppCompatActivity {

    RecyclerView recyclerView;
    AdaptadorItems adaptadorItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_items);
        recyclerView=(RecyclerView) findViewById(R.id.recyclerDatosItems);
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        Bundle datos=  getIntent().getExtras();
        Long serial= datos.getLong("serial");
        List<Item> items= Item.find(Item.class, "serial = ? ", String.valueOf(serial));
        adaptadorItems= new AdaptadorItems(items, this, new AdaptadorItems.OnItemClick(){
            @Override
            public void itemClick(Item items, int position) {

            }
        });
        recyclerView.setAdapter(adaptadorItems);
      }

}
