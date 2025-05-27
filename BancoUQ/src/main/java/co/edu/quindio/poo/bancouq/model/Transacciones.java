package co.edu.quindio.poo.bancouq.model;

import java.util.List;

public interface Transacciones {


    void realizarDeposito(CuentaBancaria cuenta, double monto);
    void realizarRetiro(CuentaBancaria cuenta, double monto);
    void realizarTransferencia(CuentaBancaria origen, CuentaBancaria destino, double monto);
    List<Transaccion> obtenerHistorialTransacciones();


}
