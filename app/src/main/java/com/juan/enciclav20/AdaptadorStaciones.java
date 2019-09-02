package com.juan.enciclav20;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdaptadorStaciones extends RecyclerView.Adapter<AdaptadorStaciones.ContactosViewHolder> {

    List<Station> lista;
    Context context;
    public interface OnItemClick
    {
        void itemClick(Station items, int position);
    }
    private OnItemClick listener;

    public AdaptadorStaciones(List<Station> lista, Context context, OnItemClick listener) {
        this.lista = lista;
        this.context = context;
        this.listener=listener;
    }

    public class ContactosViewHolder extends RecyclerView.ViewHolder {
        TextView nombre,identificacion, descripcion;
        // ImageView foto;

        public ContactosViewHolder(@NonNull View itemView) {
            super(itemView);

            nombre = (TextView) itemView.findViewById(R.id.txtNombreStacion);
            identificacion= (TextView) itemView.findViewById(R.id.txtIdentificacionStacion);
            descripcion= (TextView) itemView.findViewById(R.id.txtDescripcionStacion);

        }

        public void  bind(final  Station item, final  int position)
        {


            nombre.setText(item.getName().toString());
            descripcion.setText(item.getDesc().toString());
            identificacion.setText(item.getId().toString());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent pasarMenu= new Intent(context,recyclerItems.class);
                    pasarMenu.putExtra("serial",item.getId());
                     context.startActivity(pasarMenu);
                }
            });




        }
    }

    @NonNull
    @Override
    public ContactosViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.itemstacion,viewGroup,false);
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
