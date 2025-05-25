package co.edu.quindio.poo.bancouq.model;

public class Corriente extends CuentaBancaria{

    private double limiteSobregiro;

    public Corriente(String numeroCuenta, double limiteSobregiro, double saldo) {

        super(numeroCuenta, saldo);
        this.limiteSobregiro = limiteSobregiro;


    }

    public double getLimiteSobregiro() {
        return limiteSobregiro;
    }

    public void setLimiteSobregiro(double limiteSobregiro) {
        this.limiteSobregiro = limiteSobregiro;
    }

    @Override
    public String toString() {
        return "Corriente{" +
                "limiteSobregiro=" + limiteSobregiro +
                '}';
    }
}
