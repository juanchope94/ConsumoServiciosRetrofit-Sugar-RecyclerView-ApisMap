package com.juan.enciclav20;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdaptadorItems extends RecyclerView.Adapter<AdaptadorItems.ContactosViewHolder> {

    List<Item> lista;
    Context context;
    public interface OnItemClick
    {
        void itemClick(Item items, int position);
    }
    private OnItemClick listener;

    public AdaptadorItems(List<Item> lista, Context context, OnItemClick listener) {
        this.lista = lista;
        this.context = context;
        this.listener=listener;
    }

    public class ContactosViewHolder extends RecyclerView.ViewHolder {
     TextView nombre,direccion, descripcion, capacidad;
     Button btnUbicacion;
    // ImageView foto;

        public ContactosViewHolder(@NonNull View itemView) {
            super(itemView);

            nombre = (TextView) itemView.findViewById(R.id.txtNombre);
            direccion= (TextView) itemView.findViewById(R.id.txtDireccion);
            descripcion= (TextView) itemView.findViewById(R.id.txtDescripcion);
            capacidad= (TextView) itemView.findViewById(R.id.txtCapacidad);
            btnUbicacion= (Button) itemView.findViewById(R.id.btnUbicacion);
      //      foto= (ImageView) itemView.findViewById(R.id.imgLugar);
        }

        public void  bind(final  Item item, final  int position)
        {


            nombre.setText(item.getName().toString());
            descripcion.setText(item.getDescription().toString());
            direccion.setText(item.getAddress().toString());
            capacidad.setText(item.getCapacity().toString());
            btnUbicacion.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   Intent pasarMenu= new Intent(context,ubicacion.class);
                    pasarMenu.putExtra("nombre",item.getName());
                    pasarMenu.putExtra("lat",Double.parseDouble(item.getLat()));
                    pasarMenu.putExtra("lon",Double.parseDouble(item.getLon()));
                    context.startActivity(pasarMenu);
                }
            });
         //   Glide.with(context).load(item.getPicture().toString()).into(foto);


        }
    }

    @NonNull
    @Override
    public ContactosViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item,viewGroup,false);
        ContactosViewHolder contactosViewHolder=  new ContactosViewHolder(view);
        return contactosViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactosViewHolder contactosViewHolder, int i) {
        contactosViewHolder.bind(lista.get(i),i);
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }


}
