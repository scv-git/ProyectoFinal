package main.java.co.edu.quindio.poo.bancouq.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Transaccion implements Transacciones {
    protected String id;
    protected Date fecha;
    protected double monto;
    protected List<Transaccion> historial = new ArrayList<>();
    private int contadorIds = 1;

    public Transaccion(String id, Date fecha, double monto) {
        this.id = id;
        this.fecha = fecha;
        this.monto = monto;
    }

    public String getId() {
        return id;
    }

    public Date getFecha() {
        return fecha;
    }

    public double getMonto() {
        return monto;
    }

    protected String generarId() {
        String nuevoId = "T" + contadorIds;
        contadorIds++;
        return nuevoId;
    }


    public void realizarDeposito(CuentaBancaria cuenta, double monto) {
        cuenta.setSaldo(cuenta.getSaldo() + monto);
        historial.add(new Deposito(generarId(), new Date(), monto));
        System.out.println("Depósito realizado. Nuevo saldo: $" + cuenta.getSaldo());
    }


    public void realizarRetiro(CuentaBancaria cuenta, double monto) {
        if (cuenta.getSaldo() >= monto) {
            cuenta.setSaldo(cuenta.getSaldo() - monto);
            historial.add(new Retiro(generarId(), new Date(), monto));
            System.out.println("Retiro realizado. Nuevo saldo: $" + cuenta.getSaldo());
        } else {
            System.out.println("Fondos insuficientes para el retiro.");
        }
    }


    public void realizarTransferencia(CuentaBancaria origen, CuentaBancaria destino, double monto) {
        if (origen.getSaldo() >= monto) {
            origen.setSaldo(origen.getSaldo() - monto);
            destino.setSaldo(destino.getSaldo() + monto);
            historial.add(new Transferencia(generarId(), new Date(), monto));
            System.out.println("Transferencia realizada. Saldo actual: $" + origen.getSaldo());
        } else {
            System.out.println("Fondos insuficientes para la transferencia.");
        }
    }


    public List<Transaccion> obtenerHistorialTransacciones() {
        return historial;
    }


    public abstract String getTipo();
}

