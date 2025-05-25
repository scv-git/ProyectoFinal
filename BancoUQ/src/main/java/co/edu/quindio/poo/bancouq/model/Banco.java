package co.edu.quindio.poo.bancouq.model;

import java.util.ArrayList;

public class Banco {
    ArrayList<CuentaBancaria> listacuentas;
    ArrayList<Usuario> listausuarios;
    private String nombre;
    private String codigo;

    public Banco(String nombre, String codigo) {

        this.nombre = nombre;
        this.codigo = codigo;
        this.listacuentas = new ArrayList<>();
        this.listausuarios = new ArrayList<>();

    }

    public ArrayList<CuentaBancaria> getListacuentas() {
        return listacuentas;
    }

    public void setListacuentas(ArrayList<CuentaBancaria> listacuentas) {
        this.listacuentas = listacuentas;
    }

    public ArrayList<Usuario> getListausuarios() {
        return listausuarios;
    }

    public void setListausuarios(ArrayList<Usuario> listausuarios) {
        this.listausuarios = listausuarios;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Banco{" +
                "listacuentas=" + listacuentas +
                ", listausuarios=" + listausuarios +
                ", nombre='" + nombre + '\'' +
                ", codigo='" + codigo + '\'' +
                '}';
    }


}
