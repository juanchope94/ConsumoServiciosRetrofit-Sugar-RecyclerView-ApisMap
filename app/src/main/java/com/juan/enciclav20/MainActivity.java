package com.juan.enciclav20;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnDatos= findViewById(R.id.btnDatos);
        btnDatos.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {

        if(v.getId()== R.id.btnDatos)
        {
            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_DASHES).create();
            Retrofit retrofit = new Retrofit.Builder().baseUrl("http://www.encicla.gov.co/")
                    .addConverterFactory(GsonConverterFactory.create(gson)).build();
            Peticiones resClient = retrofit.create(Peticiones.class);
            Call<Example> call= resClient.getEncicla();
            call.enqueue(new Callback<Example>() {
                @Override
                public void onResponse(Call<Example> call, Response<Example> response) {
                    switch (response.code())
                    {
                        case 200:
                            Example data= response.body();
                            data.save();

                            for (int i=0; i<data.getStations().size();i++)
                            {
                                Station objStacion= data.getStations().get(i);
                                objStacion.save();

                            }

                            for (int i=0;i<data.getStations().size();i++)
                            {
                                for (int j=0;j<data.getStations().get(i).getItems().size();j++)
                                {
                                    Item objetoItems= new Item();
                                    objetoItems.setAddress( data.getStations().get(i).getItems().get(j).getAddress());
                                    objetoItems.setBikes( data.getStations().get(i).getItems().get(j).getBikes());
                                    objetoItems.setBikesState( data.getStations().get(i).getItems().get(j).getBikesState());
                                    objetoItems.setCapacity( data.getStations().get(i).getItems().get(j).getCapacity());
                                    objetoItems.setCdo( data.getStations().get(i).getItems().get(j).getCdo());
                                    objetoItems.setClosed( data.getStations().get(i).getItems().get(j).getClosed());
                                    objetoItems.setDescription( data.getStations().get(i).getItems().get(j).getDescription());
                                    objetoItems.setId( data.getStations().get(i).getItems().get(j).getId());
                                    objetoItems.setName( data.getStations().get(i).getItems().get(j).getName());
                                    objetoItems.setLat( data.getStations().get(i).getItems().get(j).getLat());
                                    objetoItems.setLon( data.getStations().get(i).getItems().get(j).getLon());
                                    objetoItems.setOrder( data.getStations().get(i).getItems().get(j).getOrder());
                                    objetoItems.setType( data.getStations().get(i).getItems().get(j).getType());
                                    objetoItems.setPicture( data.getStations().get(i).getItems().get(j).getPicture());
                                    objetoItems.setPlaces( data.getStations().get(i).getItems().get(j).getPlaces());
                                    objetoItems.setPlacesState( data.getStations().get(i).getItems().get(j).getPlacesState());
                                    objetoItems.setSerial(data.getStations().get(i).getId());
                                    objetoItems.save();
                                }
                            }


                            Intent pasarMenu= new Intent(MainActivity.this,recyclerDatos.class);
                            startActivity(pasarMenu);


                            break;

                        case 401:
                            break;

                        default:
                            break;

                    }
                }

                @Override
                public void onFailure(Call<Example> call, Throwable t) {

                }
            });


        }
    }
}
