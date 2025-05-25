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
}
