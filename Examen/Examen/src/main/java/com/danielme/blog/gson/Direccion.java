package com.danielme.blog.gson;

public class Direccion {
    private String calle;
    private int numero;
    private String ciudad;
    private int codigoPostal;
    private String pais;

    public Direccion(String calle, int numero, String ciudad, int codigoPostal, String pais) {
        this.calle = calle;
        this.numero = numero;
        this.ciudad = ciudad;
        this.codigoPostal = codigoPostal;
        this.pais = pais;
    }

    public String getCalle() {
        return calle;
    }

    public int getNumero() {
        return numero;
    }

    public String getCiudad() {
        return ciudad;
    }

    public int getcodigoPostal() {
        return codigoPostal;
    }

    public String getPais() {
        return pais;
    }

    @Override
    public String toString() {
        return "Direccion{" +
                "calle='" + calle + '\'' +
                ", numero=" + numero +
                ", ciudad='" + ciudad + '\'' +
                ", codigo_postal=" + codigoPostal +
                ", pais='" + pais + '\'' +
                '}';
    }
}
