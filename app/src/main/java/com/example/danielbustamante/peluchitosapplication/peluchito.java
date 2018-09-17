package com.example.danielbustamante.peluchitosapplication;

public class peluchito {
    private String id, nombre;
    private String cantidad;
    private String  precio;
    public peluchito(String id, String nombre, String cantidad, String precio){

        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;



    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCantidad() {
        return cantidad;
    }

    public String getPrecio() {
        return precio;
    }


}


