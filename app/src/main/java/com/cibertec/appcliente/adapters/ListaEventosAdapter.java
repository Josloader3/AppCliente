package com.cibertec.appcliente.adapters;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cibertec.appcliente.R;
import com.cibertec.appcliente.activities.EventoDetalleActivity;
import com.cibertec.appcliente.modelo.EventosModelo;
import com.squareup.picasso.Picasso;

public class ListaEventosAdapter extends RecyclerView.Adapter<ListaEventosAdapter.ViewHolder> {

    private List<EventosModelo> dataset;
    private Activity activity;

    public ListaEventosAdapter(Activity activity){
        dataset = new ArrayList<>();
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_evento, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final EventosModelo ev = dataset.get(position);
        holder.txvTitulo.setText(ev.getNombre());
        holder.txvfecha.setText(ev.getFecha() + " " +ev.getHora_ini());
        holder.txv_descripcion.setText(ev.getDetalles());
        Picasso.get().load("https://www.codigowebsite.app/cibertecapp/imagenes/"+ev.getUrl_foto()).into(holder.imv_evento);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity.getApplicationContext(), EventoDetalleActivity.class);
                intent.putExtra("idEvento", ev.getId());
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataset.size(); // return 0; jamas en 0 porque sino no va actualizar nada porque creera que la lista esta vacia
    }

    public void adicionarListaEventos(List<EventosModelo> listaeventos) {
        dataset.clear(); //Se limpia la lista
        dataset.addAll(listaeventos);
        notifyDataSetChanged(); // actualizar el recycler en pantalla
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txv_descripcion;
        private ImageView imv_evento;
        private TextView txvTitulo;
        private TextView txvfecha;

        public ViewHolder(View itemView){
            super(itemView);
            txv_descripcion = itemView.findViewById(R.id.txv_descripcion);
            imv_evento = itemView.findViewById(R.id.imv_evento);
            txvTitulo = itemView.findViewById(R.id.txv_titulo);
            txvfecha = itemView.findViewById(R.id.txv_fecha);
        }

    }

}
