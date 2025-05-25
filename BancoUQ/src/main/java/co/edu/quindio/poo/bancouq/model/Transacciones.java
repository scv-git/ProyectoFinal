package main.java.co.edu.quindio.poo.bancouq.model;

public interface Transacciones {
    void realizarDeposito(CuentaBancaria cuenta, double monto);
    void realizarRetiro(CuentaBancaria cuenta, double monto);
    void realizarTransferencia(CuentaBancaria origen, CuentaBancaria destino, double monto);
    List<Transaccion> obtenerHistorialTransacciones();
}
