package co.edu.quindio.poo.bancouq.model;

import java.util.Date;
import java.util.List;

public class Retiro extends Transaccion {

    public Retiro(String id, Date fecha, double monto) {
        super(id, fecha, monto);
    }

    @Override
    public List<Transaccion> obtenerHistorialTransacciones() {
        return historial;
    }

    public String getTipo() {
        return "Retiro";
    }
}
