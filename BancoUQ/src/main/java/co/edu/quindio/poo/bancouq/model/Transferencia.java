package co.edu.quindio.poo.bancouq.model;

import java.util.Date;

public class Transferencia extends main.java.co.edu.quindio.poo.bancouq.model.Transaccion {
    public Transferencia(String id, Date fecha, double monto) {
        super(id, fecha, monto);
    }

    public String getTipo() {
        return "Transferencia";
    }
}