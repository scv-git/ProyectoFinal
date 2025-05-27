package co.edu.quindio.poo.bancouq.model;
import java.util.Date;
import java.util.List;

public class Deposito extends Transaccion {

    public Deposito(String id, Date fecha, double monto) {
        super(id, fecha, monto);
    }

    @Override
    public List<Transaccion> obtenerHistorialTransacciones() {
        return historial;
    }


    public String getTipo() {
        return "Depósito";
    }
}


