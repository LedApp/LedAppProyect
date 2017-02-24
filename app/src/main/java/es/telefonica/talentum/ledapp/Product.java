package es.telefonica.talentum.ledapp;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by gemabeltran on 23/2/17.
 */

public class Product implements Serializable{

    @SerializedName("url") private String url;
    @SerializedName("descripcion_nombre") private String nombre;
    @SerializedName("ref") private String ref;
    @SerializedName("descripcion") private String descripcion;
    @SerializedName("tresd") private String tresd;
    @SerializedName("bluetooth") private String bluetooth;
    @SerializedName("fecha") private String fecha;
    @SerializedName("cruz") private String cruz;
    @SerializedName("horario") private String horario;
    @SerializedName("brillo") private String brillo;
    @SerializedName("disponibilidad") private String disponibilidad;
    @SerializedName("voltaje") private String voltaje;
    @SerializedName("consumo") private String consumo;
    @SerializedName("almacenamiento") private String almacenamiento;
    @SerializedName("trabajo") private String trabajo;
    @SerializedName("pixeles") private String pixeles;
    @SerializedName("fuente") private String fuente;
    @SerializedName("control") private String contol;
    @SerializedName("tipofrafia") private String tipografia;
    @SerializedName("cpu") private String cpu;
    @SerializedName("animacion") private String animacion;
    @SerializedName("cantidad") private String cantidad;
    @SerializedName("ancho") private String ancho;
    @SerializedName("alto") private String alto;
    @SerializedName("fondo") private String fondo;
    @SerializedName("categoria") private String categoria;


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTresd() {
        return tresd;
    }

    public void setTresd(String tresd) {
        this.tresd = tresd;
    }

    public String getBluetooth() {
        return bluetooth;
    }

    public void setBluetooth(String bluetooth) {
        this.bluetooth = bluetooth;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCruz() {
        return cruz;
    }

    public void setCruz(String cruz) {
        this.cruz = cruz;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getBrillo() {
        return brillo;
    }

    public void setBrillo(String brillo) {
        this.brillo = brillo;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public String getVoltaje() {
        return voltaje;
    }

    public void setVoltaje(String voltaje) {
        this.voltaje = voltaje;
    }

    public String getConsumo() {
        return consumo;
    }

    public void setConsumo(String consumo) {
        this.consumo = consumo;
    }

    public String getAlmacenamiento() {
        return almacenamiento;
    }

    public void setAlmacenamiento(String almacenamiento) {
        this.almacenamiento = almacenamiento;
    }

    public String getTrabajo() {
        return trabajo;
    }

    public void setTrabajo(String trabajo) {
        this.trabajo = trabajo;
    }

    public String getPixeles() {
        return pixeles;
    }

    public void setPixeles(String pixeles) {
        this.pixeles = pixeles;
    }

    public String getFuente() {
        return fuente;
    }

    public void setFuente(String fuente) {
        this.fuente = fuente;
    }

    public String getContol() {
        return contol;
    }

    public void setContol(String contol) {
        this.contol = contol;
    }

    public String getTipografia() {
        return tipografia;
    }

    public void setTipografia(String tipografia) {
        this.tipografia = tipografia;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getAnimacion() {
        return animacion;
    }

    public void setAnimacion(String animacion) {
        this.animacion = animacion;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getAncho() {
        return ancho;
    }

    public void setAncho(String ancho) {
        this.ancho = ancho;
    }

    public String getAlto() {
        return alto;
    }

    public void setAlto(String alto) {
        this.alto = alto;
    }

    public String getFondo() {
        return fondo;
    }

    public void setFondo(String fondo) {
        this.fondo = fondo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

}
