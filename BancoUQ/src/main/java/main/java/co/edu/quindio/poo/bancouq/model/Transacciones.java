package main.java.co.edu.quindio.poo.bancouq.model;

import co.edu.quindio.poo.bancouq.model.CuentaBancaria;

import java.util.List;

public interface Transacciones {
    void realizarDeposito(CuentaBancaria cuenta, double monto);
    void realizarRetiro(CuentaBancaria cuenta, double monto);
    void realizarTransferencia(CuentaBancaria origen, CuentaBancaria destino, double monto);
    List<main.java.co.edu.quindio.poo.bancouq.model.Transaccion> obtenerHistorialTransacciones();
}
