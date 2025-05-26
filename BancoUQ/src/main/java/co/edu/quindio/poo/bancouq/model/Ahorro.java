package co.edu.quindio.poo.bancouq.model;

public class Ahorro extends CuentaBancaria{

    private double tasaInteres;

    public Ahorro(String numeroCuenta, double saldo, double tasaInteres) {

        super(numeroCuenta, saldo);
        this.tasaInteres = tasaInteres;

    }

    public double getTasaInteres() {
        return tasaInteres;
    }

    public void setTasaInteres(double tasaInteres) {
        this.tasaInteres = tasaInteres;
    }

    @Override
    public String toString() {
        return "Ahorro{" +
                "tasaInteres=" + tasaInteres +
                '}';
    }

    @Override
    public double depositar(double valorIngresado) {
        return super.depositar(valorIngresado);
    }

    public double calculaSaldoInteres(double tasaInteresactual) {

        saldo = saldo + (saldo * tasaInteresactual);
        return saldo;

    }

    @Override
    public double retirar(double valorRetirado) {
        return super.retirar(valorRetirado);
    }

    @Override
    public String verSaldo() {
        return super.verSaldo();
    }
}