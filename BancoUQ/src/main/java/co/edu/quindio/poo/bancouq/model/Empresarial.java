package co.edu.quindio.poo.bancouq.model;

public class Empresarial extends CuentaBancaria {

    private double montoMaximoMensual;

    public Empresarial(String numeroCuenta, double saldo, double montoMaximoMensual) {

        super(numeroCuenta, saldo);
        this.montoMaximoMensual = montoMaximoMensual;

    }

    public double getMontoMaximoMensual() {
        return montoMaximoMensual;
    }

    public void setMontoMaximoMensual(double montoMaximoMensual) {
        this.montoMaximoMensual = montoMaximoMensual;
    }

    @Override
    public String toString() {
        return "Empresarial{" +
                "montoMaximoMensual=" + montoMaximoMensual +
                '}';
    }
}
