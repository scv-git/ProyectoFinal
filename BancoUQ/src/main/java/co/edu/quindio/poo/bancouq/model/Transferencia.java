package co.edu.quindio.poo.bancouq.model;

public class Transferencia extends Transaccion {
    public Transferencia(String id, Date fecha, double monto) {
        super(id, fecha, monto);
    }

    public String getTipo() {
        return "Transferencia";
    }
}