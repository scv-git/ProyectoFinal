package co.edu.quindio.poo.bancouq.model;

public class Retiro extends Transaccion {
    public Retiro(String id, Date fecha, double monto) {
        super(id, fecha, monto);
    }


    public String getTipo() {
        return "Retiro";
    }
}
