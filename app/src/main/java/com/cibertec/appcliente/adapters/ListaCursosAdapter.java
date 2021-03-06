package com.cibertec.appcliente.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cibertec.appcliente.R;
import com.cibertec.appcliente.activities.CursoDetalleActivity;
import com.cibertec.appcliente.modelo.Curso;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ListaCursosAdapter extends RecyclerView.Adapter<ListaCursosAdapter.MyViewHolder>{

    Context mcontext;
    private ArrayList<Curso> lstCursos =new ArrayList<>();


    public ListaCursosAdapter(Context mcontext, ArrayList<Curso> lstCursos) {
        this.mcontext = mcontext;
        this.lstCursos = lstCursos;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v;
        v = LayoutInflater.from(mcontext).inflate(R.layout.item_cursos, parent, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.tv_title.setText(lstCursos.get(position).getName());
        holder.tv_description.setText(lstCursos.get(position).getDesc());
        Picasso.get().load("https://www.codigowebsite.app/cibertecapp/imagenes/"+lstCursos.get(position).getImage()).into(MyViewHolder.img_banner);


    }

    @Override
    public int getItemCount() {
        return lstCursos.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {

        private TextView tv_title;
        private TextView tv_description;
        private static ImageView img_banner;


        private final Context context;
        private Curso lstCursos;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();

            tv_title = itemView.findViewById(R.id.title_cursos);
            tv_description = itemView.findViewById(R.id.description_cursos);
            img_banner = itemView.findViewById(R.id.img_cursos);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            final Intent intent;
            int itemPosition = getLayoutPosition();
            //Toast.makeText(context, "itemPosition" + itemPosition, Toast.LENGTH_SHORT).show();

            switch (itemPosition){
                //case 0:
                //User user = userDao.getUser();
                //intent =  new Intent(context, MainActivity.class);
                // intent.putExtra("User", user);
                // break;


                default:
                    intent =  new Intent(context, CursoDetalleActivity.class);
                    //intent.putExtra("title",  lstCursos.get(itemPosition));
                    intent.putExtra("headerCode", tv_title.getText());
                    intent.putExtra("description", tv_description.getText());
                    //intent.putExtra("img",img_banner.getImageTintList());
                    //intent.putExtra("img",img_banner.getImage());

                    break;
            }
            context.startActivity(intent);
        }
    }




}
