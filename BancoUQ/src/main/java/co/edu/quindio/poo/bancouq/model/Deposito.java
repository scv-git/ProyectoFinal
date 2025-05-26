package co.edu.quindio.poo.bancouq.model;

import java.util.Date;

public class Deposito extends main.java.co.edu.quindio.poo.bancouq.model.Transaccion {
    public Deposito(String id, Date fecha, double monto) {
        super(id, fecha, monto);
    }

    @Override
    public String getTipo() {
        return "Deposito";
    }
}
