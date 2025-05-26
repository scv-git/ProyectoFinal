package co.edu.quindio.poo.bancouq.model;

import main.java.co.edu.quindio.poo.bancouq.model.Transaccion;

import java.util.Date;

public class Retiro extends Transaccion {
    public Retiro(String id, Date fecha, double monto) {
        super(id, fecha, monto);
    }
    @Override
    public String getTipo() {
        return "Retiro";
    }
}
