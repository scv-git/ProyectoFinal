package co.edu.quindio.poo.bancouq.model;

public class Deposito extends Transaccion {
    public Deposito(String id, Date fecha, double monto) {
        super(id, fecha, monto);
    }

    public String getTipo() {
            return "Depósito";
    }
}

