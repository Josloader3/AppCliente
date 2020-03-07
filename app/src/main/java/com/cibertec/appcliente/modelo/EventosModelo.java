package com.cibertec.appcliente.modelo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class EventosModelo {
    @SerializedName("id")
    @Expose
     int id;

    @SerializedName("nombre")
    @Expose
    String nombre;

    @SerializedName("detalles")
    @Expose
    String detalles;

    @SerializedName("url_foto")
    @Expose
    String url_foto;

    @SerializedName("id_lugar")
    @Expose
    int id_lugar;

    @SerializedName("id_tipo_evento")
    @Expose
    int id_tipo_evento;

    @SerializedName("fecha")
    @Expose
    String fecha;

    @SerializedName("hora_ini")
    @Expose
    String hora_ini;

    @SerializedName("hora_fin")
    @Expose
    String hora_fin;

    @SerializedName("estado")
    @Expose
    int estado;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

   /* public ImageView getUrl_foto() {
        return url_foto;
    }

    public void setUrl_foto(ImageView url_foto) {
        this.url_foto = url_foto;
    }
*/
    public int getId_lugar() {
        return id_lugar;
    }

    public void setId_lugar(int id_lugar) {
        this.id_lugar = id_lugar;
    }

    public int getId_tipo_evento() {
        return id_tipo_evento;
    }

    public void setId_tipo_evento(int id_tipo_evento) {
        this.id_tipo_evento = id_tipo_evento;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora_ini() {
        return hora_ini;
    }

    public void setHora_ini(String hora_ini) {
        this.hora_ini = hora_ini;
    }

    public String getHora_fin() {
        return hora_fin;
    }

    public void setHora_fin(String hora_fin) {
        this.hora_fin = hora_fin;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }


    public String getUrl_foto() {
        return url_foto;
    }

    public void setUrl_foto(String url_foto) {
        this.url_foto = url_foto;
    }

    @Override
    public String toString() {
        return "EventosModelo{" +
                "id:" + id +
                ", nombre:" + '\"'+ nombre + '\"' +
                ", detalles:" + '\"' + detalles + '\"' +
                ", url_foto:" + '\"' + url_foto + '\"' +
                ", id_lugar:" + id_lugar +
                ", id_tipo_evento:" + id_tipo_evento +
                ", fecha:" + '\"' + fecha + '\"' +
                ", hora_ini:" + '\"' + hora_ini + '\"' +
                ", hora_fin:" + '\"' + hora_fin + '\"' +
                ", estado:" + estado + '\'' +
                '}';
    }
}
