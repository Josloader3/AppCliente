package com.cibertec.appcliente.activities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cibertec.appcliente.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapterCurso extends RecyclerView.Adapter<RecyclerViewAdapterCurso.MyViewHolder> {

    Context mcontext;
    List<Cursos> mData;

    public RecyclerViewAdapterCurso(Context mcontext, List<Cursos> mData) {
        this.mcontext = mcontext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v;
        v = LayoutInflater.from(mcontext).inflate(R.layout.item_cursos, parent, false);
        MyViewHolder vHolder = new MyViewHolder(v);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv_title.setText(mData.get(position).getCurso_Name());
        holder.tv_description.setText(mData.get(position).getDescription_Name());
        holder.img_banner.setImageResource(mData.get(position).getBanner_Curso());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_title;
        private TextView tv_description;
        private ImageView img_banner;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_title = itemView.findViewById(R.id.title_cursos);
            tv_description = itemView.findViewById(R.id.description_cursos);
            img_banner = itemView.findViewById(R.id.img_cursos);

        }
    }


}
