package co.edu.quindio.poo.bancouq.model;

import java.util.ArrayList;

public class Cliente extends Usuario{
    private String idUsuario;
    private ArrayList<CuentaBancaria> cuentas;

    public Cliente(String nombres, String apellidos,String identifiacion, String correo, String pin, String telefono) {
        super(nombres,apellidos,identifiacion,correo,pin,telefono);
        this.idUsuario = idUsuario;
        this.cuentas = new ArrayList<>();
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public ArrayList<CuentaBancaria> getCuentas() {
        return cuentas;
    }

    public void setCuentas(ArrayList<CuentaBancaria> cuentas) {
        this.cuentas = cuentas;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "idUsuario='" + idUsuario + '\'' +
                ", cuentas=" + cuentas +
                '}';
    }
}
